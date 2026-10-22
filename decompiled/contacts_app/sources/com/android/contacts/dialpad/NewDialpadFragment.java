package com.android.contacts.dialpad;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.common.speech.LoggingEvents;
import com.android.contacts.AbstractFragment;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.ReflectUtils;
import com.android.contacts.SpecialCharSequenceMgr;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.calllog.CallLogAdapter;
import com.android.contacts.calllog.CallLogListItemViews;
import com.android.contacts.calllog.CallLogNotificationsService;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.recommend.BaseFlowAdapter;
import com.android.contacts.recommend.FlowAdapter;
import com.android.contacts.recommend.RecommendDataLoader;
import com.android.contacts.recommend.RecommendUtil;
import com.android.contacts.speeddial.SpeedDialSettingActivity;
import com.android.contacts.speeddial.SpeedDialUtils;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.AvatarImageHelper;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactBadgeUtil;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.ImportantResource;
import com.android.contacts.util.NumberMarkResource;
import com.android.contacts.util.OreoApiUtils;
import com.android.contacts.util.PhoneNumberFormatter;
import com.android.contacts.util.ProductUtils;
import com.android.contacts.util.TelecomUtil;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.CopyTextViewKt;
import com.android.contacts.widget.DialButton;
import com.android.contacts.widget.DialpadContainer;
import com.android.contacts.widget.PopMenu;
import com.android.contacts.widget.PopMenuItem;
import com.android.contacts.widget.SimSwitchView;
import com.android.contacts.widget.ViewUtilsKt;
import com.android.internal.telephony.ITelephony;
import com.android.phone.common.CallLogAsync;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Lists;
import com.obric.Intelligentcall.activity.IntelligentAutoPickUpActivity;
import com.obric.anim.ContactsTransitionKt;
import com.obric.anim.OEAAnimKt;
import com.obric.anim.OEAAnimKt$animTransit$1$1;
import com.obric.anim.OEAAnimKt$animTransit$1$2;
import com.obric.anim.TransitionCallback;
import com.obric.anim.TransitionEx;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import com.obric.oui.button.OButton;
import com.obric.oui.coachmark.OCoachmarkView;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.settings.SettingsProviderHelper;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.utils.VibratorHelper;
import com.obric.utils.views.DismissibleClickableView;
import com.obricOld.contacts.menus.LongMenuHelper;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import obric.api.TelephonySmt;
import obric.app.tracker.Agent;
import obric.util.Utils;

/* JADX INFO: compiled from: NewDialpadFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000«\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b_\n\u0002\u0018\u0002\n\u0002\b\b*\u0001q\b\u0007\u0018\u0000 \u009b\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u0012:\b\u009b\u0003\u009c\u0003\u009d\u0003\u009e\u0003B\u0005¢\u0006\u0002\u0010\u0013J\u0013\u0010Õ\u0001\u001a\u00030®\u00012\u0007\u0010Ö\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010×\u0001\u001a\u00030®\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0016J\u0013\u0010Ú\u0001\u001a\u00030®\u00012\u0007\u0010Û\u0001\u001a\u000206H\u0002J\u0013\u0010Ü\u0001\u001a\u00030®\u00012\u0007\u0010Ý\u0001\u001a\u000206H\u0002J\t\u0010Þ\u0001\u001a\u00020 H\u0016J1\u0010ß\u0001\u001a\u00030®\u00012\n\u0010à\u0001\u001a\u0005\u0018\u00010á\u00012\u0007\u0010â\u0001\u001a\u00020\u00192\u0007\u0010ã\u0001\u001a\u00020\u00192\u0007\u0010ä\u0001\u001a\u00020\u0019H\u0016J\n\u0010å\u0001\u001a\u00030®\u0001H\u0002J\u0013\u0010æ\u0001\u001a\u00030®\u00012\u0007\u0010ç\u0001\u001a\u00020\u0019H\u0002J\b\u0010è\u0001\u001a\u00030®\u0001J\b\u0010é\u0001\u001a\u00030®\u0001J\u0011\u0010é\u0001\u001a\u00030®\u00012\u0007\u0010ê\u0001\u001a\u00020\u0019J\u001e\u0010ë\u0001\u001a\u00030®\u00012\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010ì\u0001\u001a\u00020 H\u0002J\t\u0010í\u0001\u001a\u00020 H\u0002J\b\u0010î\u0001\u001a\u00030®\u0001J\n\u0010ï\u0001\u001a\u00030®\u0001H\u0002J\b\u0010ð\u0001\u001a\u00030®\u0001J\b\u0010ñ\u0001\u001a\u00030®\u0001J\n\u0010ò\u0001\u001a\u00030®\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030®\u0001H\u0016J\t\u0010ô\u0001\u001a\u00020 H\u0002J\u0013\u0010õ\u0001\u001a\u00020\u00192\b\u0010ö\u0001\u001a\u00030Ò\u0001H\u0002J\u0014\u0010÷\u0001\u001a\u00030Ò\u00012\b\u0010ö\u0001\u001a\u00030Ò\u0001H\u0002J\u0015\u0010ø\u0001\u001a\u0005\u0018\u00010ù\u00012\u0007\u0010Û\u0001\u001a\u000206H\u0002J\u0012\u0010ú\u0001\u001a\u00020\u00152\u0007\u0010ê\u0001\u001a\u00020\u0019H\u0002J\n\u0010û\u0001\u001a\u00030®\u0001H\u0002J\t\u0010ü\u0001\u001a\u00020 H\u0002J\n\u0010ý\u0001\u001a\u00030®\u0001H\u0002J\n\u0010þ\u0001\u001a\u00030®\u0001H\u0002J\n\u0010ÿ\u0001\u001a\u00030®\u0001H\u0002J\u0007\u0010\u0080\u0002\u001a\u00020 J\u0013\u0010\u0081\u0002\u001a\u00030®\u00012\u0007\u0010\u0082\u0002\u001a\u00020\u0019H\u0002J\n\u0010\u0083\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u0084\u0002\u001a\u00030®\u0001H\u0016J\u0013\u0010\u0085\u0002\u001a\u00030®\u00012\u0007\u0010\u0086\u0002\u001a\u000206H\u0016J\u0016\u0010\u0087\u0002\u001a\u00030®\u00012\n\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0089\u0002H\u0016J,\u0010\u008a\u0002\u001a\u0004\u0018\u0001062\b\u0010\u008b\u0002\u001a\u00030\u008c\u00022\t\u0010\u008d\u0002\u001a\u0004\u0018\u00010W2\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u0089\u0002H\u0016J\n\u0010\u008f\u0002\u001a\u00030®\u0001H\u0016J\n\u0010\u0090\u0002\u001a\u00030®\u0001H\u0016J\n\u0010\u0091\u0002\u001a\u00030®\u0001H\u0016J\n\u0010\u0092\u0002\u001a\u00030®\u0001H\u0016J\n\u0010\u0093\u0002\u001a\u00030®\u0001H\u0002J6\u0010\u0094\u0002\u001a\u00030®\u00012\u000e\u0010\u0095\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0096\u00022\u0007\u0010Ý\u0001\u001a\u0002062\u0007\u0010\u0097\u0002\u001a\u00020\u00192\b\u0010\u0098\u0002\u001a\u00030\u0099\u0002H\u0016J'\u0010\u009a\u0002\u001a\u00020 2\u0007\u0010\u0086\u0002\u001a\u0002062\u0007\u0010\u0082\u0002\u001a\u00020\u00192\n\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009c\u0002H\u0016J\u0012\u0010\u009d\u0002\u001a\u00020 2\u0007\u0010\u0086\u0002\u001a\u000206H\u0016J\u0013\u0010\u009e\u0002\u001a\u00020 2\b\u0010\u009f\u0002\u001a\u00030 \u0002H\u0016J*\u0010¡\u0002\u001a\u00020 2\b\u0010¢\u0002\u001a\u00030£\u00022\t\u0010¤\u0002\u001a\u0004\u0018\u0001062\n\u0010¥\u0002\u001a\u0005\u0018\u00010Ç\u0001H\u0016J\n\u0010¦\u0002\u001a\u00030®\u0001H\u0016J\u001f\u0010§\u0002\u001a\u00030®\u00012\u0013\u0010¨\u0002\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010Ã\u0001\u0018\u00010Â\u0001H\u0016J\n\u0010©\u0002\u001a\u00030®\u0001H\u0016J1\u0010ª\u0002\u001a\u00030®\u00012\n\u0010«\u0002\u001a\u0005\u0018\u00010¬\u00022\u0007\u0010\u00ad\u0002\u001a\u00020\u00192\u0007\u0010®\u0002\u001a\u00020\u00192\u0007\u0010¯\u0002\u001a\u00020\u0019H\u0016J\u001d\u0010°\u0002\u001a\u00030®\u00012\b\u0010«\u0002\u001a\u00030¬\u00022\u0007\u0010\u00ad\u0002\u001a\u00020\u0019H\u0016J\n\u0010±\u0002\u001a\u00030®\u0001H\u0016J\n\u0010²\u0002\u001a\u00030®\u0001H\u0016J1\u0010³\u0002\u001a\u00030®\u00012\n\u0010Ø\u0001\u001a\u0005\u0018\u00010á\u00012\u0007\u0010â\u0001\u001a\u00020\u00192\u0007\u0010´\u0002\u001a\u00020\u00192\u0007\u0010µ\u0002\u001a\u00020\u0019H\u0016J\u001c\u0010¶\u0002\u001a\u00020 2\u0007\u0010«\u0002\u001a\u0002062\b\u0010\u009b\u0002\u001a\u00030·\u0002H\u0016J\u001f\u0010¸\u0002\u001a\u00030®\u00012\u0007\u0010\u0086\u0002\u001a\u0002062\n\u0010¹\u0002\u001a\u0005\u0018\u00010\u0089\u0002H\u0016J\u0013\u0010º\u0002\u001a\u00030®\u00012\u0007\u0010»\u0002\u001a\u00020 H\u0016J\t\u0010¼\u0002\u001a\u00020 H\u0002J\u0011\u0010½\u0002\u001a\u00030®\u00012\u0007\u0010¾\u0002\u001a\u00020\u0019J\n\u0010¿\u0002\u001a\u00030®\u0001H\u0002J\u0013\u0010À\u0002\u001a\u00030®\u00012\u0007\u0010ê\u0001\u001a\u00020\u0019H\u0002J\n\u0010Á\u0002\u001a\u00030®\u0001H\u0002J\u0013\u0010Â\u0002\u001a\u00030®\u00012\u0007\u0010ç\u0001\u001a\u00020\u0015H\u0002J\u001e\u0010Ã\u0002\u001a\u00030®\u00012\t\u0010Ä\u0002\u001a\u0004\u0018\u00010\u00152\u0007\u0010Å\u0002\u001a\u00020\u0019H\u0002J\n\u0010Æ\u0002\u001a\u00030®\u0001H\u0002J\u0015\u0010Ç\u0002\u001a\u00030®\u00012\t\u0010È\u0002\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010É\u0002\u001a\u00030®\u00012\n\u0010Ê\u0002\u001a\u0005\u0018\u00010Ç\u0001H\u0002J\n\u0010Ë\u0002\u001a\u00030®\u0001H\u0002J\n\u0010Ì\u0002\u001a\u00030®\u0001H\u0016J\n\u0010Í\u0002\u001a\u00030®\u0001H\u0002J\n\u0010Î\u0002\u001a\u00030®\u0001H\u0002J\u0014\u0010Ï\u0002\u001a\u0004\u0018\u0001062\u0007\u0010Ð\u0002\u001a\u00020\u0019H\u0002J\b\u0010Ñ\u0002\u001a\u00030®\u0001J\u0015\u0010Ñ\u0002\u001a\u00030®\u00012\t\u0010Ò\u0002\u001a\u0004\u0018\u000106H\u0002J\n\u0010Ó\u0002\u001a\u00030®\u0001H\u0007J\n\u0010Ô\u0002\u001a\u00030®\u0001H\u0002J\u0013\u0010Õ\u0002\u001a\u00030®\u00012\u0007\u0010Ö\u0002\u001a\u00020\u0019H\u0002J\u0013\u0010×\u0002\u001a\u00030®\u00012\u0007\u0010Ø\u0002\u001a\u00020 H\u0002J\u001e\u0010Ù\u0002\u001a\u00030®\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010Ú\u0002\u001a\u00030\u0099\u0002H\u0002J\u0013\u0010Û\u0002\u001a\u00030®\u00012\u0007\u0010Ü\u0002\u001a\u00020 H\u0002J\n\u0010Ý\u0002\u001a\u00030®\u0001H\u0002J\u001c\u0010Þ\u0002\u001a\u00030®\u00012\u0007\u0010»\u0002\u001a\u00020 2\u0007\u0010ß\u0002\u001a\u00020 H\u0016J \u0010à\u0002\u001a\u00030®\u00012\t\u0010¥\u0002\u001a\u0004\u0018\u00010\u00152\t\u0010á\u0002\u001a\u0004\u0018\u00010\u0015H\u0002J\u0011\u0010â\u0002\u001a\u00030®\u00012\u0007\u0010ã\u0002\u001a\u00020\u0015J\u0013\u0010ä\u0002\u001a\u00030®\u00012\u0007\u0010å\u0002\u001a\u00020 H\u0002J\u0014\u0010æ\u0002\u001a\u00030®\u00012\n\u0010ç\u0002\u001a\u0005\u0018\u00010\u009e\u0001J\u0013\u0010è\u0002\u001a\u00030®\u00012\u0007\u0010é\u0002\u001a\u000206H\u0002J\u0013\u0010ê\u0002\u001a\u00030®\u00012\u0007\u0010È\u0002\u001a\u00020\u0015H\u0002J\b\u0010ë\u0002\u001a\u00030®\u0001J\n\u0010ì\u0002\u001a\u00030®\u0001H\u0002J\u0011\u0010í\u0002\u001a\u00030®\u00012\u0007\u0010È\u0002\u001a\u00020\u0015J\n\u0010î\u0002\u001a\u00030®\u0001H\u0002J\n\u0010ï\u0002\u001a\u00030®\u0001H\u0002J\u0013\u0010ð\u0002\u001a\u00030®\u00012\u0007\u0010Ö\u0001\u001a\u00020\u0019H\u0002J\u0013\u0010ñ\u0002\u001a\u00030®\u00012\u0007\u0010ç\u0001\u001a\u00020\u0019H\u0002J\b\u0010ò\u0002\u001a\u00030®\u0001J\b\u0010ó\u0002\u001a\u00030®\u0001J\u0013\u0010ô\u0002\u001a\u00020\u00192\b\u0010ö\u0001\u001a\u00030Ò\u0001H\u0002J\u0015\u0010õ\u0002\u001a\u00030®\u00012\t\u0010\u0095\u0002\u001a\u0004\u0018\u000106H\u0002J\n\u0010ö\u0002\u001a\u00030®\u0001H\u0002J\n\u0010÷\u0002\u001a\u00030®\u0001H\u0002J*\u0010ø\u0002\u001a\u00030®\u00012\u0007\u0010\u0080\u0002\u001a\u00020 2\t\b\u0002\u0010ù\u0002\u001a\u00020 2\n\b\u0002\u0010ú\u0002\u001a\u00030\u0099\u0002H\u0002J\u0013\u0010û\u0002\u001a\u00030®\u00012\u0007\u0010ê\u0001\u001a\u00020\u0019H\u0002J\u001f\u0010ü\u0002\u001a\u00030®\u00012\u0013\u0010¨\u0002\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010Ã\u0001\u0018\u00010Â\u0001H\u0002J'\u0010ý\u0002\u001a\u00030®\u00012\t\u0010\u008d\u0002\u001a\u0004\u0018\u0001062\u0007\u0010þ\u0002\u001a\u00020 2\u0007\u0010â\u0001\u001a\u00020 H\u0002J\n\u0010ÿ\u0002\u001a\u00030®\u0001H\u0002J\u0015\u0010\u0080\u0003\u001a\u00030®\u00012\t\u0010\u0081\u0003\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u0082\u0003\u001a\u00030®\u0001H\u0002J\u0013\u0010\u0083\u0003\u001a\u00030®\u00012\u0007\u0010\u0084\u0003\u001a\u00020 H\u0002J\u0013\u0010\u0085\u0003\u001a\u00030®\u00012\u0007\u0010\u0084\u0003\u001a\u00020 H\u0002J\u0013\u0010\u0086\u0003\u001a\u00030®\u00012\u0007\u0010\u0087\u0003\u001a\u00020 H\u0002J\n\u0010\u0088\u0003\u001a\u00030®\u0001H\u0002J\u0013\u0010\u0089\u0003\u001a\u00030®\u00012\u0007\u0010\u008a\u0003\u001a\u00020 H\u0002J\u0013\u0010\u008b\u0003\u001a\u00030®\u00012\u0007\u0010\u008c\u0003\u001a\u00020 H\u0002J\u0013\u0010\u008d\u0003\u001a\u00030®\u00012\u0007\u0010\u008e\u0003\u001a\u00020 H\u0002J\u0013\u0010\u008f\u0003\u001a\u00030®\u00012\u0007\u0010\u008e\u0003\u001a\u00020 H\u0002J\n\u0010\u0090\u0003\u001a\u00030®\u0001H\u0002J\n\u0010\u0091\u0003\u001a\u00030®\u0001H\u0002J \u0010\u0092\u0003\u001a\u00030®\u0001*\u0002062\u0007\u0010\u0093\u0003\u001a\u00020\u00192\u0007\u0010\u0094\u0003\u001a\u00020\u0019H\u0002J\u000e\u0010\u0095\u0003\u001a\u00030®\u0001*\u000206H\u0002J#\u0010\u0096\u0003\u001a\u00030®\u0001*\u00030\u0097\u00032\b\u0010\u0098\u0003\u001a\u00030Ò\u00012\b\u0010\u0099\u0003\u001a\u00030Ò\u0001H\u0002J\u000e\u0010\u009a\u0003\u001a\u00030®\u0001*\u000206H\u0002R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0014\u0010\"\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u000e\u0010$\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010!R\u000e\u0010&\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b'\u0010!R\u000e\u0010(\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020 2\u0006\u0010,\u001a\u00020 8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b.\u0010!\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u000106X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010^\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u0001060*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u000106X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u000106X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u000106X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u00020qX\u0082\u0004¢\u0006\u0004\n\u0002\u0010rR\u000e\u0010s\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u000e\u0010z\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0092\u0001\u001a\u001e\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u0001\u0018\u00010\u0093\u0001j\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u0001\u0018\u0001`\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0098\u0001\u001a\u00030\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010¤\u0001\u001a\u001a\u0012\u0007\u0012\u0005\u0018\u00010¥\u00010\u0093\u0001j\f\u0012\u0007\u0012\u0005\u0018\u00010¥\u0001`\u0095\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u0016\u0010ª\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010«\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010¬\u0001\u001a\f\u0012\u0005\u0012\u00030®\u0001\u0018\u00010\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010±\u0001\u001a\n\u0018\u00010²\u0001R\u00030³\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010´\u0001\u001a\u00030µ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010¶\u0001\u001a\n\u0018\u00010·\u0001R\u00030³\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R\u000f\u0010¼\u0001\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010½\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¾\u0001\u0010\u001e\"\u0006\b¿\u0001\u0010À\u0001R\u001b\u0010Á\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010Ã\u0001\u0018\u00010Â\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Æ\u0001\u001a\u00030Ç\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010È\u0001\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010É\u0001\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u0012\u0010Ð\u0001\u001a\u0005\u0018\u00010³\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Ñ\u0001\u001a\u00030Ò\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001¨\u0006\u009f\u0003"}, d2 = {"Lcom/android/contacts/dialpad/NewDialpadFragment;", "Lcom/android/contacts/AbstractFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnKeyListener;", "Lcom/android/contacts/activities/DialtactsActivity$ViewPagerVisibilityListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/text/TextWatcher;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "Landroid/widget/AbsListView$OnScrollListener;", "Landroid/view/View$OnTouchListener;", "Lcom/android/contacts/recommend/RecommendDataLoader$OnRecommendDataLoadListener;", "Lcom/android/contacts/util/AvatarImageHelper$OnAvatarTextFontChangeListener;", "Lcom/android/contacts/calllog/CallLogAdapter$CallFetcher;", "Lcom/android/contacts/activities/DialtactsActivity$PageEnableListener;", "Lcom/android/contacts/activities/DialtactsActivity$ReleaseResourceListener;", "Lcom/android/contacts/activities/DialtactsActivity$onBackPressListener;", "Lcom/android/contacts/DSUtils$DSFatureStatusListener;", "Lcom/android/contacts/activities/DialtactsActivity$OnDBDataChangeListener;", "()V", "DIALPAD_LEFT_MODE", "", "DIALPAD_NUMBER", "DIALPAD_NUMBER_UPDATE_TIME", "defaultSimSlotId", "", "getDefaultSimSlotId", "()I", "dialpadNumber", "getDialpadNumber", "()Ljava/lang/String;", "isDialpadLeftMode", "", "()Z", "isDialpadNumberTimeOut", "isDigitsEmpty", "isFillDigits", "isPhoneInUse", "isShowLeft", "isSyncActive", "isT9on", "keyStates", "", "Lcom/android/contacts/dialpad/NewDialpadFragment$KeyState;", "left", "lastOneHandModeLeft", "getLastOneHandModeLeft", "setLastOneHandModeLeft", "(Z)V", "mAdapter", "Lcom/android/contacts/recommend/FlowAdapter;", "mAudioManager", "Landroid/media/AudioManager;", "mBGView", "Landroid/view/View;", "mBottomNavBlurAnimator", "Landroid/animation/ValueAnimator;", "mBtnAddClassic", "Lcom/obric/oui/button/OButton;", "mBtnAddClassicContainer", "Landroid/widget/FrameLayout;", "mBtnAddLeft", "mBtnAddRight", "mBtnAddToContact", "Landroid/widget/LinearLayout;", "mBtnChangeModeLeft", "mBtnChangeModeRight", "mBtnSendMessage", "mCallLog", "Lcom/android/phone/common/CallLogAsync;", "getMCallLog", "()Lcom/android/phone/common/CallLogAsync;", "setMCallLog", "(Lcom/android/phone/common/CallLogAsync;)V", "mClassicDialpad", "mClassicDialpadContainer", "Lcom/obric/oui/layout/OUIFrameLayout;", "mContactsObserver", "Landroid/database/ContentObserver;", "mContext", "Landroidx/fragment/app/FragmentActivity;", "mCurrentDialpadLayoutID", "mCurrentDialpadPanel", "mDTMFToneEnabled", "mDelete", "mDeleteClassic", "mDialPadSheet", "Landroid/view/ViewGroup;", "mDialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "mDialpad", "mDialpadDarkLeft", "Landroid/widget/TextView;", "mDialpadDarkRight", "mDialpadLayoutCache", "mDialpadOptionAdapter", "Lcom/android/contacts/dialpad/DialpadOptionAdapter;", "mDialpadUnusualLeft", "mDialpadUnusualRight", "mDialpadUsual", "mDigitFrame", "mDigits", "Lcom/android/contacts/dialpad/DigitsEditText;", "mDigitsAttribution", "mDismissibleClickableView", "Lcom/obric/utils/views/DismissibleClickableView;", "mEmptyView", "mFirstLoad", "mFirstUseAfterColdLaunch", "mForceTouchController", "Lcom/android/contacts/forcetouch/ForceTouchController;", "mFragmentView", "mHandler", "com/android/contacts/dialpad/NewDialpadFragment$mHandler$1", "Lcom/android/contacts/dialpad/NewDialpadFragment$mHandler$1;", "mIgnoreChange", "mImportantResource", "Lcom/android/contacts/util/ImportantResource;", "getMImportantResource", "()Lcom/android/contacts/util/ImportantResource;", "setMImportantResource", "(Lcom/android/contacts/util/ImportantResource;)V", "mInMissCallsPage", "mInputBackgroundCover", "mIsDialpadLeftMode", "mIsLoadingCalls", "mIsResetLayout", "mIsShowDialpad", "mItemLongClickedListener", "Lcom/android/contacts/list/HorizontalScrollListView$ItemLongClickedListener;", "mKeyguardManager", "Landroid/app/KeyguardManager;", "mLastNumberDialed", "mLastShownAttrNumber", "mListView", "Lcom/android/contacts/bytedanceosquickcontact/QuickContactListView;", "mListViewAlphaAnimator", "Landroid/animation/ObjectAnimator;", "mLongClickHandler", "Landroid/os/Handler;", "mNeedReloadData", "mOldIntent", "Landroid/content/Intent;", "mOpenCallSummaryView", "mOpenCallSummaryViewStub", "Landroid/view/ViewStub;", "mOptionItems", "Ljava/util/ArrayList;", "Lcom/android/contacts/dialpad/DialpadOptionItem;", "Lkotlin/collections/ArrayList;", "mPhoneStateListener1", "Landroid/telephony/PhoneStateListener;", "mPhoneStateListener2", "mPhotoLoader", "Lcom/android/contacts/ContactPhotoManager;", "mPrefs", "Landroid/content/SharedPreferences;", "mPrefsCallback", "Lcom/android/contacts/PreferencesCallback;", "mProhibitedPhoneNumberRegexp", "mProviderIsNormal", "mRecommendDataLoader", "Lcom/android/contacts/recommend/RecommendDataLoader;", "mRegisIndex", "mResults", "Lcom/android/contacts/dialpad/ContactItem;", "getMResults", "()Ljava/util/ArrayList;", "setMResults", "(Ljava/util/ArrayList;)V", "mSearchFuture", "Ljava/util/concurrent/Future;", "mShowClipPopupWindowRunnable", "Lkotlin/Function0;", "", "mSimSelectPopMenu", "Lcom/android/contacts/widget/PopMenu;", "mT9Adapter", "Lcom/android/contacts/dialpad/T9Search$T9Adapter;", "Lcom/android/contacts/dialpad/T9Search;", "mT9Listener", "Lcom/android/contacts/dialpad/T9Search$Listener;", "mT9Result", "Lcom/android/contacts/dialpad/T9Search$T9SearchResult;", "getMT9Result", "()Lcom/android/contacts/dialpad/T9Search$T9SearchResult;", "setMT9Result", "(Lcom/android/contacts/dialpad/T9Search$T9SearchResult;)V", "mT9SearchThreadName", "mTempStr", "getMTempStr", "setMTempStr", "(Ljava/lang/String;)V", "mTmpDataList", "", "Lcom/android/contacts/recommend/BaseFlowAdapter$FlowEntry;", "mToneGenerator", "Landroid/media/ToneGenerator;", "mToneGeneratorLock", "", "mTouchpad", "mVisibilityChanged", "pool", "Ljava/util/concurrent/ExecutorService;", "getPool", "()Ljava/util/concurrent/ExecutorService;", "setPool", "(Ljava/util/concurrent/ExecutorService;)V", "sT9Search", "stableDensity", "", "getStableDensity", "()F", "addVoiceMailNumberPanel", "slotId", "afterTextChanged", "input", "Landroid/text/Editable;", "applyFixedScaleDualSimCallButtonStyle", "root", "assertAccessInfoDelegateSet", BaseSwitches.V, "backToTopState", "beforeTextChanged", "s", "", "start", "count", LoggingEvents.VoiceIme.EXTRA_AFTER_N_BEST_CHOOSE, "beginRefreshOptionFrame", "callSpeedNumber", "number", "callVoicemail", "dialButtonPressed", "simId", "dialClickedNumber", "isStranger", "dialOnTap", "disappearDialpad", "dismissCallSummaryView", "dismissClipPopupWindow", "dismissPendingDialogs", "ensureOpenCallSummaryView", "fetchCalls", "fillDigitsIfNecessary", "fixedScaleDp", "value", "fixedScaleDpFloat", "getCallLogListItemView", "Lcom/android/contacts/calllog/CallLogListItemViews;", "getDialButtonLabel", "goToAddContact", "hasT9ListAdapter", "hideListView", "initDialpadMode", "initFrequentRes", "isDialpadShown", "keyPressed", "keyCode", "newFlashIntent", "onAvatarTextFontChanged", "onClick", "view", "onCreate", "state", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedState", "onDBDataChanged", "onDSFeatureStatusChanged", "onDestroy", "onDestroyView", "onDialogDismissed", "onItemClick", "parent", "Landroid/widget/AdapterView;", "position", "id", "", "onKey", "event", "Landroid/view/KeyEvent;", "onLongClick", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "onMenuItemClicked", "menuType", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "anchor", "data", "onPause", "onRecommendDataLoaded", "list", "onResume", "onScroll", "arg0", "Landroid/widget/AbsListView;", "arg1", "arg2", "arg3", "onScrollStateChanged", "onStart", "onStop", "onTextChanged", LoggingEvents.VoiceIme.EXTRA_BEFORE_N_BEST_CHOOSE, "changeCount", "onTouch", "Landroid/view/MotionEvent;", "onViewCreated", "savedInstanceState", "onVisibilityChanged", "visible", "phoneIsCdma", "playTone", "tone", "preloadRecommendData", "processDialButtonPressed", "queryLastOutgoingCall", "queryNumberAttribution", "queryPublicNumbers", NewDialpadFragment.KEY_DIGITS, "delay", "refreshData", "refreshInputTextTimeout", "text", "refreshOptionFrame", "obj", "registerObserver", "release", "removeInputTextTimeout", "removeMissedCallNotifications", "replaceCurrentDialpadPanel", "layoutRes", "resetDialpad", "dialpad", "searchContacts", "sendMessageToSearch", "sendSpeedDialMessage", "btnId", "setDailpadLeftMode", "isLeftMode", "setDialpadNumber", DBHelper.COL_TIME, "setDigitHint", "setHint", "setEmptyView", "setEnable", "triggerload", "setFormattedDigits", "normalizedNumber", "setLastNumberDialed", "lastNumberDialed", "setObserverToWork", "needWork", "setPrefsCallback", "callback", "setupClassicKeypad", "dialpadRoot", "showClipPopupWindow", "showDialpad", "showDialpadWithOutAnimation", "showDialpadWithTextDialog", "showListViewWithAnimIfNeed", "showListViewWithoutAnimIfNeed", "showMissingVoicemailErrorDialog", "showNoSpeedNumberDialog", "showVibrator", "startCallsQuery", "systemScaleDp", "traversalChildAndSetDelegateIfNecessary", "tryToShowOpenCallSummaryView", "unregisterObserver", "updateBottomNavigationBarMaskBlurRadius", "animateWhenOff", "delayMs", "updateCallButtonState", "updateCallLogList", "updateDialActionContainerLayout", "compact", "updateDialAndDeleteButtonEnabledState", "updateDialString", "newDigits", "updateDialpadMode", "updateDigitView", "hasInput", "updateInputBackgroundCoverVisibility", "updateListViewConfig", "isCallLogMode", "updateOnEntry", "updateSideActionContainerLayout", "showDualButtons", "updateSimSwitchViewState", "toEmpty", "updateUsualDialPadBackground", "isMoveToRight", "updateUsualDialPadPadding", "updateVoicemailNotifications", "updateYellowPageState", "applyDialActionButtonSize", "buttonSize", "buttonPadding", "applyFixedScaleDialActionButton", "applyFixedScaleSimCallButton", "Lcom/android/contacts/widget/DialButton;", "marginStartDp", "marginEndDp", "applySystemScaleDialActionButton", "Companion", "ErrorDialogFragment", "KeyState", "Listener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewDialpadFragment extends AbstractFragment implements View.OnClickListener, View.OnLongClickListener, View.OnKeyListener, DialtactsActivity.ViewPagerVisibilityListener, AdapterView.OnItemClickListener, TextWatcher, PopupMenu.OnMenuItemClickListener, AbsListView.OnScrollListener, View.OnTouchListener, RecommendDataLoader.OnRecommendDataLoadListener, AvatarImageHelper.OnAvatarTextFontChangeListener, CallLogAdapter.CallFetcher, DialtactsActivity.PageEnableListener, DialtactsActivity.ReleaseResourceListener, DialtactsActivity.onBackPressListener, DSUtils.DSFatureStatusListener, DialtactsActivity.OnDBDataChangeListener {
    public static final String ADD_CALL_MODE_KEY = "add_call_mode";
    public static final Companion Companion = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_DENSITY_DPI = 160;
    private static final int DELAY_UPDATE_TRANSITION = 900;
    private static final float DIAL_ACTION_BUTTON_PADDING_DP = 2.0f;
    private static final float DIAL_ACTION_BUTTON_SIZE_DP = 64.0f;
    private static final int DIAL_TONE_STREAM_TYPE = 0;
    private static final float DUAL_SIM_CALL_BUTTON_DRAWABLE_PADDING_DP = 6.0f;
    private static final float DUAL_SIM_CALL_BUTTON_HEIGHT_DP = 40.0f;
    private static final float DUAL_SIM_CALL_BUTTON_HORIZONTAL_PADDING_DP = 16.0f;
    private static final float DUAL_SIM_CALL_BUTTON_ICON_SIZE_DP = 18.0f;
    private static final float DUAL_SIM_CALL_BUTTON_MARGIN_DP = 4.0f;
    private static final float DUAL_SIM_CALL_BUTTON_TEXT_SIZE_DP = 14.0f;
    private static final String EMPTY_NUMBER = "";
    public static final String EXTRA_SEND_EMPTY_FLASH = "com.android.phone.extra.SEND_EMPTY_FLASH";
    private static final int INPUT_TEXT_TIME_OUT = 11;
    private static final String KEY_CLASSIFY = "classify";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DIGITS = "digits";
    private static final int LONG_CLICK_DELAY = 500;
    private static final int MESSAGE_CLICK_ONE = 3;
    private static final int MESSAGE_CLICK_POUND = 2;
    private static final int MESSAGE_CLICK_STAR = 1;
    private static final int MESSAGE_CLICK_ZERO = 0;
    private static final int MESSAGE_SPEED_DIAL = 4;
    private static final int MESSAGE_UPDATE_TRANSITION = 10;
    private static final int MSG_QUERY_ATTRIBUTION = 202;
    private static final int MSG_QUERY_PUBLIC_NUMBER = 200;
    private static final int MSG_REFRESH_OPTION_FRAME = 201;
    private static final int MSG_UPDATE_FLOW_ADAPTER = 1000;
    private static final int SET_T9_ADAPTER_UNLIMITIED = 13;
    private static final int SHOW_MIRAGE_HIDE_ANIMATION = 12;
    public static final String SP_KEY_SHOULD_SHOW_TUTORIAL_POPUP = "should_show_tutorial_popup";
    private static final boolean SUPPORT_SAVE_DIGITS = false;
    private static final boolean SUPPORT_TEN_MINUTES_CLEAR_DIGITS = false;
    private static final String TAG = "DialpadFragment";
    private static final long TEN_MINUTES = 0;
    private static final long TIME_DELAED_AFTER_NUMBER_FORMAT = 400;
    private static final int TONE_LENGTH_MS = 150;
    private static final int TONE_RELATIVE_VOLUME = 56;
    private static int sDigitEmptyTextSize;
    private static int sDigitFrameMaxHeight;
    private static int sDigitFrameMinHeight;
    private static int sDigitTextSizeHint;
    private static boolean sIsTooLate;
    private static NewDialpadFragment sPreloadMe;
    private static final LongMenuHelper.MenuType[] sT9CalllogMenuItems = null;
    private static final LongMenuHelper.MenuType[] sT9ContactMenuItems = null;
    private final String DIALPAD_LEFT_MODE;
    private final String DIALPAD_NUMBER;
    private final String DIALPAD_NUMBER_UPDATE_TIME;
    private boolean isFillDigits;
    private final boolean isShowLeft;
    private boolean isT9on;
    private final Map<Integer, KeyState> keyStates;
    private FlowAdapter mAdapter;
    private AudioManager mAudioManager;
    private View mBGView;
    private ValueAnimator mBottomNavBlurAnimator;
    private OButton mBtnAddClassic;
    private FrameLayout mBtnAddClassicContainer;
    private final OButton mBtnAddLeft;
    private final OButton mBtnAddRight;
    private final LinearLayout mBtnAddToContact;
    private final OButton mBtnChangeModeLeft;
    private final OButton mBtnChangeModeRight;
    private final LinearLayout mBtnSendMessage;
    private CallLogAsync mCallLog;
    private View mClassicDialpad;
    private OUIFrameLayout mClassicDialpadContainer;
    private ContentObserver mContactsObserver;
    private FragmentActivity mContext;
    private int mCurrentDialpadLayoutID;
    private View mCurrentDialpadPanel;
    private boolean mDTMFToneEnabled;
    private OButton mDelete;
    private View mDeleteClassic;
    private ViewGroup mDialPadSheet;
    private OAlertDialog mDialog;
    private final View mDialpad;
    private final TextView mDialpadDarkLeft;
    private final TextView mDialpadDarkRight;
    private final Map<Integer, View> mDialpadLayoutCache;
    private DialpadOptionAdapter mDialpadOptionAdapter;
    private final View mDialpadUnusualLeft;
    private final View mDialpadUnusualRight;
    private final View mDialpadUsual;
    private FrameLayout mDigitFrame;
    private DigitsEditText mDigits;
    private TextView mDigitsAttribution;
    private DismissibleClickableView mDismissibleClickableView;
    private View mEmptyView;
    private boolean mFirstLoad;
    private boolean mFirstUseAfterColdLaunch;
    private ForceTouchController mForceTouchController;
    private View mFragmentView;
    private final NewDialpadFragment$mHandler$1 mHandler;
    private boolean mIgnoreChange;
    private ImportantResource mImportantResource;
    private final boolean mInMissCallsPage;
    private View mInputBackgroundCover;
    private final boolean mIsDialpadLeftMode;
    private volatile boolean mIsLoadingCalls;
    private boolean mIsResetLayout;
    private boolean mIsShowDialpad;
    private final HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private KeyguardManager mKeyguardManager;
    private String mLastNumberDialed;
    private String mLastShownAttrNumber;
    private QuickContactListView mListView;
    private ObjectAnimator mListViewAlphaAnimator;
    private final Handler mLongClickHandler;
    private boolean mNeedReloadData;
    private Intent mOldIntent;
    private View mOpenCallSummaryView;
    private ViewStub mOpenCallSummaryViewStub;
    private ArrayList<DialpadOptionItem> mOptionItems;
    private final PhoneStateListener mPhoneStateListener1;
    private final PhoneStateListener mPhoneStateListener2;
    private ContactPhotoManager mPhotoLoader;
    private SharedPreferences mPrefs;
    private PreferencesCallback mPrefsCallback;
    private String mProhibitedPhoneNumberRegexp;
    private boolean mProviderIsNormal;
    private RecommendDataLoader mRecommendDataLoader;
    private int mRegisIndex;
    private ArrayList<ContactItem> mResults;
    private Future<?> mSearchFuture;
    private Function0<Unit> mShowClipPopupWindowRunnable;
    private final PopMenu mSimSelectPopMenu;
    private T9Search.T9Adapter mT9Adapter;
    private final T9Search.Listener mT9Listener;
    private T9Search.T9SearchResult mT9Result;
    private final String mT9SearchThreadName;
    private String mTempStr;
    private List<BaseFlowAdapter.FlowEntry> mTmpDataList;
    private ToneGenerator mToneGenerator;
    private final Object mToneGeneratorLock;
    private View mTouchpad;
    private boolean mVisibilityChanged;
    private ExecutorService pool;
    private T9Search sT9Search;

    /* JADX INFO: compiled from: NewDialpadFragment.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0004H\u0002J\u0006\u00100\u001a\u00020ER\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=R\u0018\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=¨\u0006G"}, d2 = {"Lcom/android/contacts/dialpad/NewDialpadFragment$Companion;", "", "()V", "ADD_CALL_MODE_KEY", "", "DEBUG", "", "DEFAULT_DENSITY_DPI", "", "DELAY_UPDATE_TRANSITION", "DIAL_ACTION_BUTTON_PADDING_DP", "", "DIAL_ACTION_BUTTON_SIZE_DP", "DIAL_TONE_STREAM_TYPE", "DUAL_SIM_CALL_BUTTON_DRAWABLE_PADDING_DP", "DUAL_SIM_CALL_BUTTON_HEIGHT_DP", "DUAL_SIM_CALL_BUTTON_HORIZONTAL_PADDING_DP", "DUAL_SIM_CALL_BUTTON_ICON_SIZE_DP", "DUAL_SIM_CALL_BUTTON_MARGIN_DP", "DUAL_SIM_CALL_BUTTON_TEXT_SIZE_DP", "EMPTY_NUMBER", "EXTRA_SEND_EMPTY_FLASH", "INPUT_TEXT_TIME_OUT", "KEY_CLASSIFY", "KEY_DESCRIPTION", "KEY_DIGITS", "LONG_CLICK_DELAY", "MESSAGE_CLICK_ONE", "MESSAGE_CLICK_POUND", "MESSAGE_CLICK_STAR", "MESSAGE_CLICK_ZERO", "MESSAGE_SPEED_DIAL", "MESSAGE_UPDATE_TRANSITION", "MSG_QUERY_ATTRIBUTION", "MSG_QUERY_PUBLIC_NUMBER", "MSG_REFRESH_OPTION_FRAME", "MSG_UPDATE_FLOW_ADAPTER", "SET_T9_ADAPTER_UNLIMITIED", "SHOW_MIRAGE_HIDE_ANIMATION", "SP_KEY_SHOULD_SHOW_TUTORIAL_POPUP", "SUPPORT_SAVE_DIGITS", "SUPPORT_TEN_MINUTES_CLEAR_DIGITS", "TAG", "TEN_MINUTES", "", "TIME_DELAED_AFTER_NUMBER_FORMAT", "TONE_LENGTH_MS", "TONE_RELATIVE_VOLUME", "preload", "Lcom/android/contacts/dialpad/NewDialpadFragment;", "getPreload", "()Lcom/android/contacts/dialpad/NewDialpadFragment;", "sDigitEmptyTextSize", "sDigitFrameMaxHeight", "sDigitFrameMinHeight", "sDigitTextSizeHint", "sIsTooLate", "sPreloadMe", "sT9CalllogMenuItems", "", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "[Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "sT9ContactMenuItems", "assertPointInView", "px", "py", "view", "Landroid/view/View;", "log", "", NotificationCompat.CATEGORY_MESSAGE, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ boolean access$assertPointInView(Companion r0, float r1, float r2, View r3) {
            return r0.assertPointInView(r1, r2, r3);
        }

        public static final /* synthetic */ void access$log(Companion r0, String r1) {
            r0.log(r1);
        }

        public final void preload() {
            if (NewDialpadFragment.access$getSIsTooLate$cp() == false) goto L6;
            return;
        L6:
            if (NewDialpadFragment.access$getSPreloadMe$cp() != null) goto L9;
            NewDialpadFragment.access$setSPreloadMe$cp(new NewDialpadFragment());
            return;
        }

        public final NewDialpadFragment getPreload() {
            NewDialpadFragment r1 = NewDialpadFragment.access$getSPreloadMe$cp();
            NewDialpadFragment.access$setSPreloadMe$cp(null);
            NewDialpadFragment.access$setSIsTooLate$cp(true);
            return r1;
        }

        private final boolean assertPointInView(float r4, float r5, View r6) {
            if (r6 != null) goto L5;
            return false;
        L5:
            int r0 = r6.getHeight();
            int r7 = r6.getWidth();
            if (r4 >= 0.0f) goto L8;
            return false;
        L8:
            if (r4 <= r7) goto L10;
            return false;
        L10:
            if (r5 >= 0.0f) goto L12;
            return false;
        L12:
            if (r5 > r0) goto L18;
            return true;
        L18:
            return false;
        }

        private final void log(String r1) {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewDialpadFragment.TAG, r1);
            return;
        }
    }

    /* JADX INFO: compiled from: NewDialpadFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/contacts/dialpad/NewDialpadFragment$ErrorDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "mMessageResId", "", "Ljava/lang/Integer;", "mTitleResId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ErrorDialogFragment extends DialogFragment {
        private static final String ARG_MESSAGE_RES_ID = "argMessageResId";
        private static final String ARG_TITLE_RES_ID = "argTitleResId";
        public static final Companion Companion = null;
        private Integer mMessageResId;
        private int mTitleResId;

        /* JADX INFO: compiled from: NewDialpadFragment.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/contacts/dialpad/NewDialpadFragment$ErrorDialogFragment$Companion;", "", "()V", "ARG_MESSAGE_RES_ID", "", "ARG_TITLE_RES_ID", "newInstance", "Lcom/android/contacts/dialpad/NewDialpadFragment$ErrorDialogFragment;", "titleResId", "", "messageResId", "newInstanceInter", "(ILjava/lang/Integer;)Lcom/android/contacts/dialpad/NewDialpadFragment$ErrorDialogFragment;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final ErrorDialogFragment newInstance(int r2) {
                return newInstanceInter(r2, null);
            }

            public final ErrorDialogFragment newInstance(int r1, int r2) {
                return newInstanceInter(r1, Integer.valueOf(r2));
            }

            private final ErrorDialogFragment newInstanceInter(int r3, Integer r4) {
                ErrorDialogFragment r2 = new ErrorDialogFragment();
                Bundle r0 = new Bundle();
                r0.putInt(ErrorDialogFragment.ARG_TITLE_RES_ID, r3);
                if (r4 == null) goto L5;
                r0.putInt(ErrorDialogFragment.ARG_MESSAGE_RES_ID, r4.intValue());
            L5:
                r2.setArguments(r0);
                return r2;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$DANbgnvgl2qRkAQe-xfW5l3pDnQ, reason: not valid java name */
        public static /* synthetic */ void m184$r8$lambda$DANbgnvgl2qRkAQexfW5l3pDnQ(ErrorDialogFragment r0, DialogInterface r1, int r2) {
            onCreateDialog$lambda$0(r0, r1, r2);
        }

        static {
            Companion = new Companion(null);
        }

        public ErrorDialogFragment() {
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r4) {
            super.onCreate(r4);
            Bundle r5 = getArguments();
            boolean r0 = false;
            if (r5 == null) goto L5;
            int r6 = r5.getInt(ARG_TITLE_RES_ID);
        L6:
            this.mTitleResId = r6;
            Bundle r7 = getArguments();
            if (r7 != null) goto L9;
        L11:
            if (r0 == false) goto L18;
            Bundle r8 = getArguments();
            if (r8 == null) goto L15;
            Integer r9 = Integer.valueOf(r8.getInt(ARG_MESSAGE_RES_ID));
        L16:
            this.mMessageResId = r9;
            return;
        L15:
            r9 = null;
            goto L16
        L18:
            return;
        L9:
            if (r7.containsKey(ARG_MESSAGE_RES_ID) != true) goto L11;
            r0 = true;
            goto L11
        L5:
            r6 = 0;
            goto L6
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r4) {
            FragmentActivity r0 = getActivity();
            Intrinsics.checkNotNull(r0);
            AlertDialog.Builder r5 = new AlertDialog.Builder(r0);
            r5.setTitle(this.mTitleResId).setPositiveButton(R.string.ok, new NewDialpadFragment$ErrorDialogFragment$$ExternalSyntheticLambda0(this));
            Integer r3 = this.mMessageResId;
            if (r3 == null) goto L5;
            r5.setMessage(r3.intValue());
        L5:
            AlertDialog r6 = r5.create();
            Intrinsics.checkNotNullExpressionValue(r6, "builder.create()");
            return r6;
        }

        private static final void onCreateDialog$lambda$0(ErrorDialogFragment r0, DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            r0.dismiss();
        }
    }

    /* JADX INFO: compiled from: NewDialpadFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/dialpad/NewDialpadFragment$KeyState;", "", "keyCode", "", "playTone", "cancelled", "", "(IIZ)V", "getCancelled", "()Z", "setCancelled", "(Z)V", "getKeyCode", "()I", "getPlayTone", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class KeyState {
        private boolean cancelled;
        private final int keyCode;
        private final int playTone;

        public static /* synthetic */ KeyState copy$default(KeyState r0, int r1, int r2, boolean r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.keyCode;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.playTone;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.cancelled;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.keyCode;
        }

        public final int component2() {
            return this.playTone;
        }

        public final boolean component3() {
            return this.cancelled;
        }

        public final KeyState copy(int r1, int r2, boolean r3) {
            return new KeyState(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof KeyState) == true) goto L8;
            return false;
        L8:
            KeyState r6 = (KeyState) r5;
            if (this.keyCode == r6.keyCode) goto L12;
            return false;
        L12:
            if (this.playTone == r6.playTone) goto L15;
            return false;
        L15:
            if (this.cancelled == r6.cancelled) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = ((Integer.hashCode(this.keyCode) * 31) + Integer.hashCode(this.playTone)) * 31;
            boolean r2 = this.cancelled;
            ?? r3 = r2;
            if (r2 == false) goto L6;
            r3 = 1;
        L6:
            return r0 + r3;
        }

        public String toString() {
            return "KeyState(keyCode=" + this.keyCode + ", playTone=" + this.playTone + ", cancelled=" + this.cancelled + ')';
        }

        public KeyState(int r1, int r2, boolean r3) {
            this.keyCode = r1;
            this.playTone = r2;
            this.cancelled = r3;
        }

        public /* synthetic */ KeyState(int r1, int r2, boolean r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = false;
        L5:
            this(r1, r2, r3);
        }

        public final int getKeyCode() {
            return this.keyCode;
        }

        public final int getPlayTone() {
            return this.playTone;
        }

        public final boolean getCancelled() {
            return this.cancelled;
        }

        public final void setCancelled(boolean r1) {
            this.cancelled = r1;
        }
    }

    /* JADX INFO: compiled from: NewDialpadFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/contacts/dialpad/NewDialpadFragment$Listener;", "", "onSearchButtonPressed", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Listener {
        void onSearchButtonPressed();
    }

    /* JADX INFO: compiled from: NewDialpadFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LongMenuHelper.MenuType.values().length];
            r0[LongMenuHelper.MenuType.MENU_DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LongMenuHelper.MenuType.MENU_BLACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$0IY8N08kvhJsJm4II9ghAkL3RNw(View r0) {
        ensureOpenCallSummaryView$lambda$7(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$7ORzGa88K8y2srCTh9tU4-hgU5Y, reason: not valid java name */
    public static /* synthetic */ void m178$r8$lambda$7ORzGa88K8y2srCTh9tU4hgU5Y(NewDialpadFragment r0) {
        onResume$lambda$25(r0);
    }

    public static /* synthetic */ void $r8$lambda$9HtPdrKqAVvWbeyWBQ_Ti42o2Hs(DialtactsActivity r0, ValueAnimator r1) {
        updateBottomNavigationBarMaskBlurRadius$lambda$46$lambda$45(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FnAkw6VxLh3gx2RIetek1bRBc3I(NewDialpadFragment r0, String r1) {
        queryLastOutgoingCall$lambda$42(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$L1PbYH4eBglmMl3JUP60pSKrhIc(NewDialpadFragment r0, DialogInterface r1) {
        showMissingVoicemailErrorDialog$lambda$31(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$QS78v4WTsV3w7rmqoGmz7NxZxyY() {
        onResume$lambda$23();
    }

    /* JADX INFO: renamed from: $r8$lambda$Sex-zdZXzSNDW8APf8PMr684tv0, reason: not valid java name */
    public static /* synthetic */ void m179$r8$lambda$SexzdZXzSNDW8APf8PMr684tv0(NewDialpadFragment r0) {
        onResume$lambda$24(r0);
    }

    public static /* synthetic */ void $r8$lambda$U_y0Qc8KWq7hOtYoXH2wXp9xIOc(NewDialpadFragment r0, View r1) {
        ensureOpenCallSummaryView$lambda$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Woy6Xt2n0h4fCnHwOaP544VokAU(NewDialpadFragment r0) {
        removeMissedCallNotifications$lambda$27(r0);
    }

    public static /* synthetic */ void $r8$lambda$agacgEHd6cIulQhIZptnJUiwcNY(NewDialpadFragment r0, DialogInterface r1, int r2) {
        showMissingVoicemailErrorDialog$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$cPWVc7lsSj6Q2qutXhvjd1Nk9lo(NewDialpadFragment r0, int r1) {
        playTone$lambda$34$lambda$33(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$d72B2HOPOF7fdPgkgbIpt0yVnyg(NewDialpadFragment r0) {
        afterTextChanged$lambda$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$hWSjPzATAwVKmJdSWbUb1fjc6xk(NewDialpadFragment r0, int r1) {
        onCreateView$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$i-OALm2HM7qGMtrNI-OpNw-U6c0, reason: not valid java name */
    public static /* synthetic */ void m180$r8$lambda$iOALm2HM7qGMtrNIOpNwU6c0(NewDialpadFragment r0, int r1, DialogInterface r2, int r3) {
        showMissingVoicemailErrorDialog$lambda$29(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$kxk6Cw-s8ZuwYiVL59Ma2em49sQ, reason: not valid java name */
    public static /* synthetic */ void m181$r8$lambda$kxk6Cws8ZuwYiVL59Ma2em49sQ(SimSwitchView r0, View r1) {
        updateSimSwitchViewState$lambda$41(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oyeXyO7i_622Q1QfAvLYFqkZIFA(NewDialpadFragment r0, FragmentActivity r1, ViewGroup r2, String r3) {
        showClipPopupWindow$lambda$47(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$s7DVtk2rMsrb1zS-LXvytvXSByU, reason: not valid java name */
    public static /* synthetic */ void m182$r8$lambda$s7DVtk2rMsrb1zSLXvytvXSByU(NewDialpadFragment r0, View r1) {
        ensureOpenCallSummaryView$lambda$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$vkTHI5KcCARdwuVQwPObKkruPHA(View r0) {
        onCreateView$lambda$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$wraahRZVqQL2d_03H7k7LhctXhY(NewDialpadFragment r0) {
        startCallsQuery$lambda$26(r0);
    }

    private static final void ensureOpenCallSummaryView$lambda$7(View r0) {
    }

    private final String getDialpadNumber() {
        return "";
    }

    private final boolean isDialpadNumberTimeOut() {
        return false;
    }

    private static final void onCreateView$lambda$4(View r0) {
    }

    private final void updateOnEntry() {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    public static final /* synthetic */ void access$beginRefreshOptionFrame(NewDialpadFragment r0) {
        r0.beginRefreshOptionFrame();
    }

    public static final /* synthetic */ void access$callSpeedNumber(NewDialpadFragment r0, int r1) {
        r0.callSpeedNumber(r1);
    }

    public static final /* synthetic */ boolean access$getDEBUG$cp() {
        return DEBUG;
    }

    public static final /* synthetic */ int access$getDIAL_TONE_STREAM_TYPE$cp() {
        return DIAL_TONE_STREAM_TYPE;
    }

    public static final /* synthetic */ Map access$getKeyStates$p(NewDialpadFragment r0) {
        return r0.keyStates;
    }

    public static final /* synthetic */ FragmentActivity access$getMContext$p(NewDialpadFragment r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ DigitsEditText access$getMDigits$p(NewDialpadFragment r0) {
        return r0.mDigits;
    }

    public static final /* synthetic */ TextView access$getMDigitsAttribution$p(NewDialpadFragment r0) {
        return r0.mDigitsAttribution;
    }

    public static final /* synthetic */ ForceTouchController access$getMForceTouchController$p(NewDialpadFragment r0) {
        return r0.mForceTouchController;
    }

    public static final /* synthetic */ NewDialpadFragment$mHandler$1 access$getMHandler$p(NewDialpadFragment r0) {
        return r0.mHandler;
    }

    public static final /* synthetic */ boolean access$getMIsLoadingCalls$p(NewDialpadFragment r0) {
        return r0.mIsLoadingCalls;
    }

    public static final /* synthetic */ String access$getMLastShownAttrNumber$p(NewDialpadFragment r0) {
        return r0.mLastShownAttrNumber;
    }

    public static final /* synthetic */ QuickContactListView access$getMListView$p(NewDialpadFragment r0) {
        return r0.mListView;
    }

    public static final /* synthetic */ ObjectAnimator access$getMListViewAlphaAnimator$p(NewDialpadFragment r0) {
        return r0.mListViewAlphaAnimator;
    }

    /* JADX INFO: renamed from: access$getMLongMenuHelper$p$s-214468365, reason: not valid java name */
    public static final /* synthetic */ LongMenuHelper m183access$getMLongMenuHelper$p$s214468365(NewDialpadFragment r0) {
        return r0.mLongMenuHelper;
    }

    public static final /* synthetic */ Future access$getMSearchFuture$p(NewDialpadFragment r0) {
        return r0.mSearchFuture;
    }

    public static final /* synthetic */ T9Search.T9Adapter access$getMT9Adapter$p(NewDialpadFragment r0) {
        return r0.mT9Adapter;
    }

    public static final /* synthetic */ List access$getMTmpDataList$p(NewDialpadFragment r0) {
        return r0.mTmpDataList;
    }

    public static final /* synthetic */ ToneGenerator access$getMToneGenerator$p(NewDialpadFragment r0) {
        return r0.mToneGenerator;
    }

    public static final /* synthetic */ Object access$getMToneGeneratorLock$p(NewDialpadFragment r0) {
        return r0.mToneGeneratorLock;
    }

    public static final /* synthetic */ boolean access$getMVisibilityChanged$p(NewDialpadFragment r0) {
        return r0.mVisibilityChanged;
    }

    public static final /* synthetic */ boolean access$getSIsTooLate$cp() {
        return sIsTooLate;
    }

    public static final /* synthetic */ NewDialpadFragment access$getSPreloadMe$cp() {
        return sPreloadMe;
    }

    public static final /* synthetic */ LongMenuHelper.MenuType[] access$getST9CalllogMenuItems$cp() {
        return sT9CalllogMenuItems;
    }

    public static final /* synthetic */ LongMenuHelper.MenuType[] access$getST9ContactMenuItems$cp() {
        return sT9ContactMenuItems;
    }

    public static final /* synthetic */ boolean access$hasT9ListAdapter(NewDialpadFragment r0) {
        return r0.hasT9ListAdapter();
    }

    public static final /* synthetic */ boolean access$isDialpadNumberTimeOut(NewDialpadFragment r0) {
        return r0.isDialpadNumberTimeOut();
    }

    public static final /* synthetic */ boolean access$isDigitsEmpty(NewDialpadFragment r0) {
        return r0.isDigitsEmpty();
    }

    public static final /* synthetic */ boolean access$isFillDigits$p(NewDialpadFragment r0) {
        return r0.isFillDigits;
    }

    public static final /* synthetic */ void access$keyPressed(NewDialpadFragment r0, int r1) {
        r0.keyPressed(r1);
    }

    public static final /* synthetic */ void access$processDialButtonPressed(NewDialpadFragment r0, int r1) {
        r0.processDialButtonPressed(r1);
    }

    public static final /* synthetic */ void access$queryNumberAttribution(NewDialpadFragment r0, String r1) {
        r0.queryNumberAttribution(r1);
    }

    public static final /* synthetic */ void access$refreshOptionFrame(NewDialpadFragment r0, Object r1) {
        r0.refreshOptionFrame(r1);
    }

    public static final /* synthetic */ void access$sendMessageToSearch(NewDialpadFragment r0) {
        r0.sendMessageToSearch();
    }

    public static final /* synthetic */ void access$setMIgnoreChange$p(NewDialpadFragment r0, boolean r1) {
        r0.mIgnoreChange = r1;
    }

    public static final /* synthetic */ void access$setMLastShownAttrNumber$p(NewDialpadFragment r0, String r1) {
        r0.mLastShownAttrNumber = r1;
    }

    public static final /* synthetic */ void access$setMSearchFuture$p(NewDialpadFragment r0, Future r1) {
        r0.mSearchFuture = r1;
    }

    public static final /* synthetic */ void access$setMToneGenerator$p(NewDialpadFragment r0, ToneGenerator r1) {
        r0.mToneGenerator = r1;
    }

    public static final /* synthetic */ void access$setSIsTooLate$cp(boolean r0) {
        sIsTooLate = r0;
    }

    public static final /* synthetic */ void access$setSPreloadMe$cp(NewDialpadFragment r0) {
        sPreloadMe = r0;
    }

    public static final /* synthetic */ void access$showClipPopupWindow(NewDialpadFragment r0, String r1) {
        r0.showClipPopupWindow(r1);
    }

    public static final /* synthetic */ void access$showListViewWithAnimIfNeed(NewDialpadFragment r0) {
        r0.showListViewWithAnimIfNeed();
    }

    public static final /* synthetic */ void access$showListViewWithoutAnimIfNeed(NewDialpadFragment r0) {
        r0.showListViewWithoutAnimIfNeed();
    }

    public static final /* synthetic */ void access$updateCallLogList(NewDialpadFragment r0, List r1) {
        r0.updateCallLogList(r1);
    }

    public static final /* synthetic */ void access$updateListViewConfig(NewDialpadFragment r0, boolean r1) {
        r0.updateListViewConfig(r1);
    }

    public static final /* synthetic */ void access$updateOnEntry(NewDialpadFragment r0) {
        r0.updateOnEntry();
    }

    public NewDialpadFragment() {
        this.mT9Listener = new NewDialpadFragment$mT9Listener$1(this);
        this.mLastShownAttrNumber = "";
        this.mToneGeneratorLock = new Object();
        this.mDialpadLayoutCache = new HashMap();
        this.isShowLeft = true;
        this.mT9SearchThreadName = "SearchContactsThread";
        this.DIALPAD_LEFT_MODE = "pref_last_dialpad_left_mode";
        this.DIALPAD_NUMBER = "dialpad_number";
        this.DIALPAD_NUMBER_UPDATE_TIME = "dialpad_number_update_time";
        this.keyStates = new LinkedHashMap();
        this.mSimSelectPopMenu = new PopMenu();
        this.mHandler = new NewDialpadFragment$mHandler$1(this, Looper.getMainLooper());
        this.mCallLog = new CallLogAsync();
        this.mLastNumberDialed = "";
        this.mTempStr = "";
        this.mFirstLoad = true;
        this.mFirstUseAfterColdLaunch = true;
        this.mPhoneStateListener1 = new NewDialpadFragment$mPhoneStateListener1$1(this);
        this.mPhoneStateListener2 = new NewDialpadFragment$mPhoneStateListener2$1(this);
        this.mResults = new ArrayList();
        final Looper r0 = Looper.getMainLooper();
        this.mLongClickHandler = new NewDialpadFragment$mLongClickHandler$1(this, r0);
        this.mIsShowDialpad = true;
        this.mItemLongClickedListener = new NewDialpadFragment$mItemLongClickedListener$1(this);
        this.mProviderIsNormal = true;
    }

    private final void preloadRecommendData() {
        new NewDialpadFragment$preloadRecommendData$t$1(this).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setObserverToWork(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NewDialpadFragment$mHandler$1 r0 = this.mHandler;
        if (r0 == null) goto L5;
        r0.removeMessages(10);
    L5:
        setDailpadLeftMode(this.mIsDialpadLeftMode);
        DigitsEditText r1 = this.mDigits;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L15;
        DigitsEditText r3 = this.mDigits;
        if (r3 == null) goto L15;
        r3.setCursorVisible(false);
    L15:
        setObserverToWork(false);
        this.mIsLoadingCalls = false;
        this.mNeedReloadData = true;
        RecommendDataLoader r4 = this.mRecommendDataLoader;
        if (r4 == null) goto L18;
        r4.stopLoadRecommendData("Dialpad");
    L18:
        dismissLongMenu();
        DialpadMatchTracker.reportAndClear("leave_page");
        return;
    L8:
        if (r1.isCursorVisible() != true) goto L10;
        r2 = true;
        goto L11
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        DSUtils.unregisterDSFeatureStatusListener(this);
    L5:
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L12;
        if (r0 == null) goto L9;
        r0.removeTextChangedListener(this);
    L9:
        DigitsEditText r1 = this.mDigits;
        if (r1 == null) goto L12;
        r1.destroy();
    L12:
        T9Search r2 = this.sT9Search;
        if (r2 == null) goto L19;
        if (r2 == null) goto L16;
        r2.setPrefsCallback(null);
    L16:
        T9Search r3 = this.sT9Search;
        if (r3 == null) goto L19;
        r3.setRegisterLocaleChange(false);
    L19:
        AvatarImageHelper.getIntance().removeAvatarTextFontChangeListener(this);
        RecommendDataLoader r4 = this.mRecommendDataLoader;
        if (r4 == null) goto L22;
        r4.destroy();
    L22:
        this.mRecommendDataLoader = null;
        ExecutorService r5 = this.pool;
        if (r5 == null) goto L25;
        r5.shutdownNow();
    L25:
        this.pool = null;
    }

    public final ImportantResource getMImportantResource() {
        return this.mImportantResource;
    }

    public final void setMImportantResource(ImportantResource r1) {
        this.mImportantResource = r1;
    }

    private final void showListViewWithAnimIfNeed() {
        QuickContactListView r0 = this.mListView;
        if (r0 == null) goto L5;
        float r1 = r0.getAlpha();
    L7:
        if (r1 > 0.0f) goto L12;
        ObjectAnimator r2 = this.mListViewAlphaAnimator;
        if (r2 == null) goto L13;
        r2.start();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = 0.0f;
        goto L7
    }

    private final void showListViewWithoutAnimIfNeed() {
        QuickContactListView r0 = this.mListView;
        if (r0 == null) goto L5;
        float r1 = r0.getAlpha();
    L7:
        if (r1 > 0.0f) goto L12;
        QuickContactListView r2 = this.mListView;
        if (r2 == null) goto L13;
        r2.setAlpha(1.0f);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = 0.0f;
        goto L7
    }

    private final void hideListView() {
        QuickContactListView r1 = this.mListView;
        if (r1 == null) goto L6;
        r1.setAlpha(0.0f);
        return;
    }

    private final void sendMessageToSearch() {
        NewDialpadFragment$mHandler$1 r0 = this.mHandler;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        NewDialpadFragment$mHandler$1 r2 = this.mHandler;
        if (r2 == null) goto L11;
        r2.removeMessages(com.android.contacts.R.id.msg_search);
    L11:
        NewDialpadFragment$mHandler$1 r4 = this.mHandler;
        if (r4 == null) goto L15;
        r4.sendEmptyMessageDelayed(com.android.contacts.R.id.msg_search, 250);
        return;
    L15:
        return;
    L5:
        if (r0.hasMessages(com.android.contacts.R.id.msg_search) != true) goto L7;
        r1 = true;
        goto L7
    }

    private final boolean hasT9ListAdapter() {
        QuickContactListView r2 = this.mListView;
        ListAdapter r0 = null;
        if (r2 == null) goto L5;
        ListAdapter r3 = r2.getAdapter();
    L7:
        if ((r3 instanceof HeaderViewListAdapter) == false) goto L9;
        HeaderViewListAdapter r1 = (HeaderViewListAdapter) r3;
    L10:
        if (r1 == null) goto L16;
        ListAdapter r4 = r1.getWrappedAdapter();
        if (r4 == null) goto L16;
        r3 = r4;
    L25:
        return r3 instanceof T9Search.T9Adapter;
    L16:
        if ((r3 instanceof WrapperListAdapter) == false) goto L18;
        WrapperListAdapter r5 = (WrapperListAdapter) r3;
    L19:
        if (r5 == null) goto L21;
        r0 = r5.getWrappedAdapter();
    L21:
        if (r0 == null) goto L25;
        r3 = r0;
        goto L25
    L18:
        r5 = null;
        goto L19
    L9:
        r1 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    private final void beginRefreshOptionFrame() {
        if (this.mOptionItems != null) goto L39;
        this.mOptionItems = new ArrayList();
        DialpadOptionItem r0 = new DialpadOptionItem();
        FragmentActivity r3 = this.mContext;
        if (r3 == null) goto L7;
        Drawable r4 = r3.getDrawable(com.android.contacts.R.drawable.icon_item_add_contact);
    L8:
        r0.icon = r4;
        FragmentActivity r5 = this.mContext;
        if (r5 == null) goto L11;
        String r6 = r5.getString(com.android.contacts.R.string.t9_add_to_contacts);
    L12:
        r0.describe = r6;
        ArrayList<DialpadOptionItem> r7 = this.mOptionItems;
        if (r7 == null) goto L15;
        r7.add(r0);
    L15:
        DialpadOptionItem r1 = new DialpadOptionItem();
        FragmentActivity r8 = this.mContext;
        if (r8 == null) goto L18;
        Drawable r9 = r8.getDrawable(com.android.contacts.R.drawable.icon_item_send_message);
    L19:
        r1.icon = r9;
        FragmentActivity r10 = this.mContext;
        if (r10 == null) goto L22;
        String r11 = r10.getString(com.android.contacts.R.string.common_send_sms);
    L23:
        r1.describe = r11;
        ArrayList<DialpadOptionItem> r12 = this.mOptionItems;
        if (r12 == null) goto L27;
        r12.add(r1);
    L27:
        if (ContactsUtils.FEATURE_CMCC == false) goto L39;
        DialpadOptionItem r2 = new DialpadOptionItem();
        r2.type = 3;
        FragmentActivity r13 = this.mContext;
        if (r13 == null) goto L31;
        Drawable r14 = r13.getDrawable(com.android.contacts.R.drawable.icon_item_volte_call);
    L32:
        r2.icon = r14;
        FragmentActivity r15 = this.mContext;
        if (r15 == null) goto L35;
        String r16 = r15.getString(com.android.contacts.R.string.detail_action_volte);
    L36:
        r2.describe = r16;
        ArrayList<DialpadOptionItem> r17 = this.mOptionItems;
        if (r17 == null) goto L39;
        r17.add(r2);
        goto L39
    L35:
        r16 = null;
        goto L36
    L31:
        r14 = null;
        goto L32
    L22:
        r11 = null;
        goto L23
    L18:
        r9 = null;
        goto L19
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
    L39:
        DigitsEditText r18 = this.mDigits;
        if (r18 == null) goto L42;
        Editable r19 = r18.getText();
    L43:
        String r20 = String.valueOf(r19);
        QuickContactListView r21 = this.mListView;
        if (r21 == null) goto L46;
        ListAdapter r22 = r21.getAdapter();
    L48:
        if ((r22 instanceof DialpadOptionAdapter) == true) goto L56;
        Message r23 = Message.obtain(this.mHandler, 201, r20);
        NewDialpadFragment$mHandler$1 r24 = this.mHandler;
        if (r24 == null) goto L52;
        r24.removeMessages(201);
    L52:
        NewDialpadFragment$mHandler$1 r25 = this.mHandler;
        if (r25 == null) goto L55;
        r25.sendMessageDelayed(r23, 100);
    L55:
        int r26 = 300;
    L58:
        if (StringsKt.startsWith$default(r20, ContactsUtils.CHAR_POUND, false, 2, null) == false) goto L60;
        return;
    L60:
        if (StringsKt.startsWith$default(r20, ContactsUtils.CHAR_STAR, false, 2, null) == false) goto L62;
        return;
    L62:
        if (r20.length() >= 3) goto L64;
        return;
    L64:
        if (ContactsUtils.isFeatureDomestic() == false) goto L70;
        queryPublicNumbers(r20, r26);
        return;
    L70:
        return;
    L56:
        showListViewWithoutAnimIfNeed();
        r26 = 0;
        goto L58
    L46:
        r22 = null;
        goto L48
    L42:
        r19 = null;
        goto L43
    }

    private final void queryPublicNumbers(String r2, final int r3) {
        NumberInfosManager.NumberInfosListenerAdatper r0 = new NewDialpadFragment$queryPublicNumbers$listener$1(this, r3);
        NumberInfosManager.getInstance().getBaseAndMarkOfflineAsync(r2, r0.toDestroyObservable(getDestroyObservable()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void refreshOptionFrame(Object r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L7;
        return;
    L7:
        if ((r11 instanceof String) == false) goto L10;
        String r12 = (String) r11;
        String r0 = null;
        int r3 = 0;
    L15:
        ArrayList<DialpadOptionItem> r4 = this.mOptionItems;
        boolean r5 = true;
        if (r4 != null) goto L18;
    L20:
        Object[] r6 = false;
    L21:
        if (r6 == false) goto L26;
        ArrayList<DialpadOptionItem> r7 = this.mOptionItems;
        if (r7 == null) goto L26;
        DialpadOptionItem r8 = r7.remove(0);
    L26:
        if (TextUtils.isEmpty(r0) == true) goto L44;
        DialpadOptionItem r9 = new DialpadOptionItem();
        r9.type = 1;
        if (r3 <= 0) goto L36;
        FragmentActivity r10 = this.mContext;
        FragmentActivity r13 = r10;
        if (r10 == null) goto L34;
        Resources r14 = r10.getResources();
        if (r14 == null) goto L34;
        double r15 = r14.getDimensionPixelSize(com.android.contacts.R.dimen.listview_photo_width);
    L35:
        Bitmap r16 = NameAvatarController.getCircleBitmap(AvatarImageHelper.getAvatarBitmap(NumberMarkResource.getInstance(this.mContext).getResource(r3), ContactsUtils.dipTopx(r13, r15)), false);
        r9.drawbleRes = r3;
    L37:
        FragmentActivity r17 = this.mContext;
        if (r17 == null) goto L40;
        Resources r18 = r17.getResources();
    L41:
        r9.icon = new BitmapDrawable(r18, r16);
        r9.describe = r0;
        r9.detail = r12;
        ArrayList<DialpadOptionItem> r19 = this.mOptionItems;
        if (r19 == null) goto L44;
        r19.add(0, r9);
        goto L44
    L40:
        r18 = null;
    L34:
        r15 = 0.0d;
        goto L35
    L36:
        r16 = ContactBadgeUtil.loadDefaultAvatarPhoto(this.mContext, true, false);
    L44:
        T9Search.T9SearchResult r110 = this.mT9Result;
        if (r110 == null) goto L60;
        if (r110 == null) goto L48;
        ArrayList<ContactItem> r111 = r110.getResults();
    L49:
        if (r111 == null) goto L60;
        T9Search.T9SearchResult r112 = this.mT9Result;
        if (r112 == null) goto L57;
        ArrayList<ContactItem> r113 = r112.getResults();
        if (r113 == null) goto L57;
        if ((!r113.isEmpty()) != true) goto L57;
    L58:
        if (r5 == false) goto L60;
        return;
    L57:
        r5 = false;
        goto L58
    L48:
        r111 = null;
    L60:
        ArrayList r114 = new ArrayList(this.mOptionItems);
        DialpadOptionAdapter r1 = this.mDialpadOptionAdapter;
        if (r1 != null) goto L63;
        this.mDialpadOptionAdapter = new DialpadOptionAdapter(this.mContext, r114);
    L65:
        QuickContactListView r115 = this.mListView;
        if (r115 == null) goto L68;
        ListAdapter r116 = r115.getAdapter();
    L69:
        updateListViewConfig(false);
        if ((r116 instanceof DialpadOptionAdapter) == false) goto L75;
        DialpadOptionAdapter r2 = this.mDialpadOptionAdapter;
        if (r116 != r2) goto L75;
        if (r2 == null) goto L89;
        r2.notifyDataSetChanged();
        return;
    L89:
        return;
    L75:
        QuickContactListView r117 = this.mListView;
        if (r117 == null) goto L78;
        r117.setAdapter(this.mDialpadOptionAdapter);
    L78:
        QuickContactListView r118 = this.mListView;
        if (r118 == null) goto L82;
        r118.setScrollEnabled(false);
    L82:
        ForceTouchController r119 = this.mForceTouchController;
        if (r119 == null) goto L85;
        r119.setAdapter(null);
    L85:
        showListViewWithAnimIfNeed();
        return;
    L68:
        r116 = null;
        goto L69
    L63:
        if (r1 == null) goto L65;
        r1.setList(r114);
        goto L65
    L18:
        if (r4.size() != ((ContactsUtils.FEATURE_CMCC ? 1 : 0) + 3)) goto L20;
        r6 = true;
        goto L21
    L10:
        if ((r11 instanceof NumberInfosManager.NumberInfos) == false) goto L88;
        NumberInfosManager.NumberInfos r120 = (NumberInfosManager.NumberInfos) r11;
        r0 = r120.getMark();
        if (TextUtils.isEmpty(r0) == false) goto L14;
        r0 = r120.getName();
    L14:
        r120.getClassifyString();
        r3 = r120.getClassifyDrawableRes();
        r12 = r120.getNumber();
        goto L15
    }

    private final void setEmptyView() {
        ViewGroup.LayoutParams r1 = null;
        if (this.mEmptyView != null) goto L9;
        View r0 = this.mFragmentView;
        if (r0 == null) goto L7;
        View r2 = r0.findViewById(R.id.empty);
    L8:
        this.mEmptyView = r2;
        goto L9
    L7:
        r2 = null;
    L9:
        QuickContactListView r3 = this.mListView;
        if (r3 == null) goto L12;
        View r4 = r3.getEmptyView();
    L13:
        if (r4 != null) goto L18;
        QuickContactListView r5 = this.mListView;
        if (r5 == null) goto L18;
        r5.setEmptyView(this.mEmptyView);
    L18:
        if (this.mIsPcMode == false) goto L33;
        View r6 = this.mFragmentView;
        if (r6 == null) goto L22;
        View r7 = r6.findViewById(com.android.contacts.R.id.black_view);
    L23:
        if (r7 == null) goto L25;
        r1 = r7.getLayoutParams();
    L25:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r8 = (RelativeLayout.LayoutParams) r1;
        FragmentActivity r9 = this.mContext;
        if (r9 == null) goto L30;
        Resources r10 = r9.getResources();
        if (r10 == null) goto L30;
        int r11 = r10.getDimensionPixelSize(com.android.contacts.R.dimen.dialpad_empty_margin_top_tnt);
    L31:
        r8.topMargin = r11;
        r7.setLayoutParams(r8);
        return;
    L30:
        r11 = 0;
        goto L31
    L22:
        r7 = null;
        goto L23
    L33:
        return;
    L12:
        r4 = null;
        goto L13
    }

    public final CallLogAsync getMCallLog() {
        return this.mCallLog;
    }

    public final void setMCallLog(CallLogAsync r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCallLog = r2;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        updateDigitView(!TextUtils.isEmpty(r1));
    }

    public final String getMTempStr() {
        return this.mTempStr;
    }

    public final void setMTempStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTempStr = r2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r12) {
        Intrinsics.checkNotNullParameter(r12, "input");
        Editable r0 = r12;
        boolean r2 = false;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        dismissCallSummaryView();
    L9:
        if (this.mIgnoreChange == false) goto L12;
        return;
    L12:
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L15;
        return;
    L15:
        if (SpecialCharSequenceMgr.handleChars(getActivity(), r12.toString(), this.mDigits) == false) goto L21;
        DigitsEditText r3 = this.mDigits;
        if (r3 == null) goto L21;
        Editable r4 = r3.getText();
        if (r4 == null) goto L21;
        r4.clear();
    L21:
        DigitsEditText r5 = this.mDigits;
        Editable r6 = null;
        if (r5 == null) goto L24;
        Integer r7 = Integer.valueOf(r5.length());
    L25:
        DigitsEditText r8 = this.mDigits;
        if (r8 == null) goto L28;
        Integer r9 = Integer.valueOf(r8.getSelectionStart());
    L30:
        if (Intrinsics.areEqual(r7, r9) == false) goto L41;
        DigitsEditText r10 = this.mDigits;
        if (r10 == null) goto L34;
        Integer r11 = Integer.valueOf(r10.getSelectionEnd());
    L36:
        if (Intrinsics.areEqual(r7, r11) == false) goto L41;
        DigitsEditText r13 = this.mDigits;
        if (r13 == null) goto L41;
        r13.setCursorVisible(false);
        goto L41
    L34:
        r11 = null;
    L41:
        if (isDigitsEmpty() == false) goto L43;
        new Handler().post(new NewDialpadFragment$$ExternalSyntheticLambda13(this));
        this.mTempStr = "";
        DialpadMatchTracker.onMatchCancelled();
    L86:
        DigitsEditText r14 = this.mDigits;
        if (r14 == null) goto L89;
        r14.adjustPaddingAndTextSize(r12.toString());
    L89:
        updateDialAndDeleteButtonEnabledState();
        updateYellowPageState();
        if (r0.length() != 0) goto L92;
        r2 = true;
    L92:
        updateSimSwitchViewState(r2);
        NewDialpadFragment$mHandler$1 r15 = this.mHandler;
        if (r15 == null) goto L116;
        r15.removeMessages(202);
        r15.sendMessageDelayed(r15.obtainMessage(202, r12.toString()), 300);
        return;
    L116:
        return;
    L43:
        String r16 = this.mTempStr;
        DigitsEditText r17 = this.mDigits;
        if (r17 == null) goto L46;
        Editable r18 = r17.getText();
    L47:
        String r19 = String.valueOf(r18);
        int r20 = r19.length() - 1;
        int r21 = 0;
        boolean r22 = false;
    L49:
        if (r21 > r20) goto L65;
        if (r22 == true) goto L52;
        int r110 = r21;
    L54:
        if (Intrinsics.compare(r19.charAt(r110), 32) > 0) goto L56;
        boolean r111 = true;
    L57:
        if (r22 == false) goto L58;
        if (r111 == false) goto L65;
        r20 = r20 - 1;
        goto L49
    L58:
        if (r111 == false) goto L59;
        r21 = r21 + 1;
        goto L49
    L59:
        r22 = true;
        goto L49
    L56:
        r111 = false;
        goto L57
    L52:
        r110 = r20;
    L65:
        if (Intrinsics.areEqual(r16, r19.subSequence(r21, r20 + 1).toString()) == true) goto L86;
        DigitsEditText r23 = this.mDigits;
        if (r23 == null) goto L69;
        r6 = r23.getText();
    L69:
        String r24 = String.valueOf(r6);
        int r25 = r24.length() - 1;
        int r26 = 0;
        boolean r27 = false;
    L70:
        if (r26 > r25) goto L85;
        if (r27 == true) goto L73;
        int r28 = r26;
    L75:
        if (Intrinsics.compare(r24.charAt(r28), 32) > 0) goto L77;
        boolean r29 = true;
    L78:
        if (r27 == false) goto L79;
        if (r29 == false) goto L85;
        r25 = r25 - 1;
        goto L70
    L79:
        if (r29 == false) goto L80;
        r26 = r26 + 1;
        goto L70
    L80:
        r27 = true;
        goto L70
    L77:
        r29 = false;
        goto L78
    L73:
        r28 = r25;
    L85:
        this.mTempStr = r24.subSequence(r26, r25 + 1).toString();
        DialpadMatchTracker.onMatchStart();
        sendMessageToSearch();
        goto L86
    L46:
        r18 = null;
        goto L47
    L28:
        r9 = null;
        goto L30
    L24:
        r7 = null;
        goto L25
    L5:
        r1 = false;
        goto L6
    }

    private static final void afterTextChanged$lambda$0(NewDialpadFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        ObjectAnimator r0 = r2.mListViewAlphaAnimator;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        r2.resetDialpad();
        return;
    L10:
        return;
    L5:
        if (r0.isRunning() == true) goto L7;
        r1 = true;
        goto L7
    }

    private final void refreshInputTextTimeout(String r3) {
        NewDialpadFragment$mHandler$1 r0 = this.mHandler;
        if (r0 == null) goto L6;
        r0.removeMessages(11);
        NewDialpadFragment$mHandler$1 r2 = this.mHandler;
        r2.sendMessageDelayed(r2.obtainMessage(11, r3), TEN_MINUTES);
        return;
    }

    private final void removeInputTextTimeout() {
        NewDialpadFragment$mHandler$1 r1 = this.mHandler;
        if (r1 == null) goto L6;
        r1.removeMessages(11);
        return;
    }

    public final ExecutorService getPool() {
        return this.pool;
    }

    public final void setPool(ExecutorService r1) {
        this.pool = r1;
    }

    public final void setPrefsCallback(PreferencesCallback r1) {
        this.mPrefsCallback = r1;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.mContext = getActivity();
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.pool = Executors.newSingleThreadExecutor();
        ContactPhotoManager r5 = ContactPhotoManager.getInstance(getActivity());
        this.mPhotoLoader = r5;
        if (r5 == null) goto L5;
        r5.preloadPhotosInBackground();
    L5:
        T9Search r6 = T9Search.getInstance(getActivity());
        this.sT9Search = r6;
        if (r6 == null) goto L8;
        r6.setPrefsCallback(this.mPrefsCallback);
    L8:
        T9Search r7 = this.sT9Search;
        if (r7 == null) goto L11;
        r7.setRegisterLocaleChange(true);
    L11:
        this.mRecommendDataLoader = new RecommendDataLoader(this.mContext, this);
        AvatarImageHelper.getIntance().addAvatarTextFontChangeListener(this);
        startCallsQuery();
        this.mIsLoadingCalls = true;
        preloadRecommendData();
        FragmentActivity r8 = this.mContext;
        String r1 = null;
        if (r8 == null) goto L14;
        Object r9 = r8.getSystemService("keyguard");
    L15:
        this.mKeyguardManager = (KeyguardManager) r9;
        FragmentActivity r10 = this.mContext;
        if (r10 == null) goto L18;
        Object r11 = r10.getSystemService("audio");
    L19:
        this.mAudioManager = (AudioManager) r11;
        setHasOptionsMenu(true);
        FragmentActivity r12 = this.mContext;
        if (r12 == null) goto L22;
        r1 = r12.getString(com.android.contacts.R.string.config_prohibited_phone_number_regexp);
    L22:
        this.mProhibitedPhoneNumberRegexp = r1;
        queryLastOutgoingCall();
        if (DSUtils.isMultiSimEnabled() == false) goto L25;
        DSUtils.registerDSFeatureStatusListener(this);
    L25:
        setupLongMenu();
        initFrequentRes();
        return;
    L18:
        r11 = null;
        goto L19
    L14:
        r9 = null;
        goto L15
    }

    private final void initFrequentRes() {
        FragmentActivity r1 = this.mContext;
        if (r1 == null) goto L5;
        Resources r2 = r1.getResources();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        int r0 = r2.getDimensionPixelSize(com.android.contacts.R.dimen.digit_frame_max_height);
        sDigitFrameMaxHeight = r0;
        sDigitFrameMinHeight = r0;
        sDigitTextSizeHint = r2.getDimensionPixelSize(com.android.contacts.R.dimen.digit_edittext_hint);
        sDigitEmptyTextSize = r2.getDimensionPixelSize(com.android.contacts.R.dimen.digit_empty_text_size);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        this.mImportantResource = ImportantResource.getInstance(this.mContext);
        int r0 = 0;
        this.mFragmentView = r4.inflate(com.android.contacts.R.layout.dialpad_fragment, r5, false);
        if (r5 == null) goto L5;
        r5.setClipChildren(false);
    L5:
        if (r5 == null) goto L8;
        r5.setClipToPadding(false);
    L8:
        View r7 = this.mFragmentView;
        ViewStub r8 = null;
        if (r7 == null) goto L11;
        View r9 = r7.findViewById(com.android.contacts.R.id.list);
    L12:
        QuickContactListView r10 = (QuickContactListView) r9;
        this.mListView = r10;
        if (r10 == null) goto L15;
        r10.setOnScrollListener(this);
    L15:
        QuickContactListView r11 = this.mListView;
        if (r11 == null) goto L19;
        r11.setOnItemClickListener(this);
    L19:
        QuickContactListView r12 = this.mListView;
        if (r12 == null) goto L22;
        r12.setItemLongClickedListener(this.mItemLongClickedListener);
    L22:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.mListView, "alpha", new float[]{0.0f, 1.0f});
        this.mListViewAlphaAnimator = r13;
        if (r13 == null) goto L25;
        r13.setDuration(200);
    L25:
        ObjectAnimator r14 = this.mListViewAlphaAnimator;
        if (r14 == null) goto L28;
        r14.addListener(new C01861(this));
    L28:
        ForceTouchController r15 = new ForceTouchController(this.mListView, this.mContext);
        this.mForceTouchController = r15;
        QuickContactListView r16 = this.mListView;
        if (r16 == null) goto L31;
        r16.setOnTouchListener(r15);
    L31:
        View r17 = this.mFragmentView;
        if (r17 == null) goto L34;
        View r18 = r17.findViewById(com.android.contacts.R.id.bg_container);
    L35:
        this.mBGView = r18;
        View r19 = this.mFragmentView;
        if (r19 == null) goto L38;
        View r20 = r19.findViewById(com.android.contacts.R.id.input_background_cover);
    L39:
        this.mInputBackgroundCover = r20;
        View r21 = this.mBGView;
        if (r21 == null) goto L42;
        r21.setOnClickListener(new NewDialpadFragment$$ExternalSyntheticLambda7());
    L42:
        View r22 = this.mFragmentView;
        if (r22 == null) goto L45;
        View r23 = r22.findViewById(com.android.contacts.R.id.digits_frame);
    L46:
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mDigitFrame = (FrameLayout) r23;
        View r24 = this.mFragmentView;
        if (r24 == null) goto L49;
        View r25 = r24.findViewById(com.android.contacts.R.id.digits);
    L50:
        DigitsEditText r26 = (DigitsEditText) r25;
        this.mDigits = r26;
        if (r26 == null) goto L53;
        CopyTextViewKt.copyPasteActionMode(r26);
    L53:
        View r27 = this.mFragmentView;
        if (r27 == null) goto L56;
        View r28 = r27.findViewById(com.android.contacts.R.id.digits_attribution);
    L57:
        this.mDigitsAttribution = (TextView) r28;
        DigitsEditText r29 = this.mDigits;
        if (r29 == null) goto L60;
        r29.setFilters(new InputFilter[]{new AnonymousClass3(this)});
    L60:
        DigitsEditText r30 = this.mDigits;
        if (r30 == null) goto L63;
        r30.setKeyListener(DialerKeyListener.getInstance());
    L63:
        DigitsEditText r31 = this.mDigits;
        if (r31 == null) goto L66;
        r31.setOnClickListener(this);
    L66:
        DigitsEditText r32 = this.mDigits;
        if (r32 == null) goto L69;
        r32.setOnKeyListener(this);
    L69:
        DigitsEditText r33 = this.mDigits;
        if (r33 == null) goto L72;
        r33.setOnLongClickListener(this);
    L72:
        DigitsEditText r34 = this.mDigits;
        if (r34 == null) goto L75;
        r34.addTextChangedListener(this);
    L75:
        updateDigitView(false);
        DigitsEditText r35 = this.mDigits;
        if (r35 == null) goto L78;
        r35.setAccessibilityDelegate(new AnonymousClass4(this));
    L78:
        PhoneNumberFormatter.setPhoneNumberFormattingTextWatcher(getActivity(), this.mDigits);
        DigitsEditText r36 = this.mDigits;
        if (r36 == null) goto L81;
        r36.setCursorVisible(false);
    L81:
        View r37 = this.mFragmentView;
        if (r37 == null) goto L84;
        View r38 = r37.findViewById(com.android.contacts.R.id.touchpad);
    L85:
        this.mTouchpad = r38;
        if (r38 == null) goto L89;
        r38.setOnTouchListener(this);
    L89:
        if (DEBUG == false) goto L108;
        FragmentActivity r39 = this.mContext;
        if (r39 == null) goto L95;
        Resources r40 = r39.getResources();
        if (r40 == null) goto L95;
        DisplayMetrics r41 = r40.getDisplayMetrics();
    L96:
        float r42 = 56;
        if (r41 == null) goto L99;
        float r1 = r41.density;
    L100:
        int r43 = (int) (r42 * r1);
        if (r41 == null) goto L103;
        int r2 = r41.widthPixels;
    L104:
        int r3 = r2 / r43;
        if (r41 == null) goto L107;
        r0 = r41.widthPixels;
    L107:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "The size of fake menu buttons (in pixel): " + (r0 / r3));
        goto L108
    L103:
        r2 = 0;
        goto L104
    L99:
        r1 = 0.0f;
    L95:
        r41 = null;
    L108:
        initDialpadMode();
        View r44 = this.mFragmentView;
        if (r44 == null) goto L111;
        View r45 = r44.findViewById(com.android.contacts.R.id.switch_sim);
    L113:
        if ((r45 instanceof SimSwitchView) == false) goto L115;
        SimSwitchView r46 = (SimSwitchView) r45;
    L116:
        if (r46 == null) goto L118;
        r46.setOnCurrentSimChangedListener(new NewDialpadFragment$$ExternalSyntheticLambda8(this));
    L118:
        T9Search r47 = this.sT9Search;
        if (r47 == null) goto L121;
        r47.setCallback(this.mT9Listener);
    L121:
        View r48 = this.mFragmentView;
        if (r48 == null) goto L124;
        View r49 = r48.findViewById(com.android.contacts.R.id.open_call_summary_view);
    L126:
        if ((r49 instanceof ViewStub) == false) goto L128;
        r8 = (ViewStub) r49;
    L128:
        this.mOpenCallSummaryViewStub = r8;
        return this.mFragmentView;
    L124:
        r49 = null;
        goto L126
    L115:
        r46 = null;
        goto L116
    L111:
        r45 = null;
        goto L113
    L84:
        r38 = null;
        goto L85
    L56:
        r28 = null;
        goto L57
    L49:
        r25 = null;
        goto L50
    L45:
        r23 = null;
        goto L46
    L38:
        r20 = null;
        goto L39
    L34:
        r18 = null;
        goto L35
    L11:
        r9 = null;
        goto L12
    }

    private static final void onCreateView$lambda$5(NewDialpadFragment r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.updateCallButtonState(r2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View r0 = this.mFragmentView;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(com.android.contacts.R.id.switch_sim);
    L7:
        if ((r1 instanceof SimSwitchView) == false) goto L9;
        SimSwitchView r2 = (SimSwitchView) r1;
    L10:
        if (r2 == null) goto L12;
        r2.setOnCurrentSimChangedListener(null);
    L12:
        T9Search r3 = this.sT9Search;
        if (r3 == null) goto L15;
        r3.setCallback(null);
    L15:
        this.mOpenCallSummaryView = null;
        this.mOpenCallSummaryViewStub = null;
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    private final void dismissCallSummaryView() {
        SharedPreferences r0 = this.mPrefs;
        if (r0 == null) goto L5;
        boolean r1 = r0.getBoolean("should_show_tutorial_popup", true);
    L6:
        if (r1 == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Change SP_KEY_SHOULD_SHOW_TUTORIAL_POPUP to false");
        SharedPreferences r2 = this.mPrefs;
        if (r2 == null) goto L10;
        SharedPreferences.Editor r3 = r2.edit();
        Intrinsics.checkNotNullExpressionValue(r3, "editor");
        r3.putBoolean("should_show_tutorial_popup", false);
        r3.apply();
    L10:
        View r4 = this.mOpenCallSummaryView;
        if (r4 == null) goto L16;
        if (r4 == null) goto L17;
        r4.setVisibility(8);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void ensureOpenCallSummaryView() {
        if (this.mOpenCallSummaryView == null) goto L5;
        return;
    L5:
        ViewStub r0 = this.mOpenCallSummaryViewStub;
        if (r0 != null) goto L8;
        return;
    L8:
        View r1 = r0.inflate();
        this.mOpenCallSummaryView = r1;
        OCoachmarkView r2 = null;
        this.mOpenCallSummaryViewStub = null;
        if (r1 == null) goto L12;
        r1.setVisibility(8);
    L12:
        View r3 = this.mOpenCallSummaryView;
        if (r3 == null) goto L15;
        View r4 = r3.findViewById(com.android.contacts.R.id.call_summary_coach);
    L17:
        if ((r4 instanceof OCoachmarkView) == false) goto L19;
        r2 = (OCoachmarkView) r4;
    L19:
        if (r2 == null) goto L23;
        OUIFrameLayout r5 = (OUIFrameLayout) r2.findViewById(com.android.contacts.R.id.coachmark_icon_container);
        if (r5 == null) goto L23;
        r5.setBorderWidth(0);
    L23:
        if (r2 == null) goto L25;
        r2.setOnClickListener(new NewDialpadFragment$$ExternalSyntheticLambda14());
    L25:
        if (r2 == null) goto L27;
        r2.setOnPrimaryActionClickListener(new NewDialpadFragment$$ExternalSyntheticLambda15(this));
    L27:
        if (r2 == null) goto L30;
        r2.setOnSecondaryActionClickListener(new NewDialpadFragment$$ExternalSyntheticLambda16(this));
        return;
    L30:
        return;
    L15:
        r4 = null;
        goto L17
    }

    private static final void ensureOpenCallSummaryView$lambda$9(NewDialpadFragment r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        FragmentActivity r5 = r3.getActivity();
        if (r5 == null) goto L5;
        Intent r0 = new Intent();
        r0.setClass(r5, IntelligentAutoPickUpActivity.class);
        r5.startActivity(r0);
    L5:
        r3.dismissCallSummaryView();
    }

    private static final void ensureOpenCallSummaryView$lambda$10(NewDialpadFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.dismissCallSummaryView();
    }

    @Override // com.android.contacts.util.AvatarImageHelper.OnAvatarTextFontChangeListener
    public void onAvatarTextFontChanged() {
        NewDialpadFragment$mHandler$1 r1 = this.mHandler;
        if (r1 == null) goto L6;
        r1.sendEmptyMessage(1000);
        return;
    }

    private final void registerObserver() {
        if (this.mContactsObserver != null) goto L10;
        final Handler r0 = new Handler();
        ContentObserver r1 = new NewDialpadFragment$registerObserver$contactsObserver$1(this, r0);
        this.mContactsObserver = r1;
        FragmentActivity r3 = this.mContext;
        if (r3 == null) goto L11;
        ContentResolver r4 = r3.getContentResolver();
        if (r4 == null) goto L12;
        r4.registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void unregisterObserver() {
        ContentObserver r0 = this.mContactsObserver;
        if (r0 == null) goto L11;
        FragmentActivity r1 = this.mContext;
        if (r1 == null) goto L9;
        ContentResolver r2 = r1.getContentResolver();
        if (r2 == null) goto L9;
        r2.unregisterContentObserver(r0);
    L9:
        this.mContactsObserver = null;
        return;
    }

    private final void setObserverToWork(boolean r2) {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        registerObserver();
        return;
    L7:
        unregisterObserver();
    }

    @Override // com.android.contacts.activities.DialtactsActivity.OnDBDataChangeListener
    public void onDBDataChanged() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "call log db changed.");
        this.mTmpDataList = null;
        refreshData();
    }

    @Override // com.android.contacts.recommend.RecommendDataLoader.OnRecommendDataLoadListener
    public void onRecommendDataLoaded(List<BaseFlowAdapter.FlowEntry> r3) {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        this.mIsLoadingCalls = false;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "On recommend data loaded.");
        updateCallLogList(r3);
    }

    private final void updateCallLogList(List<BaseFlowAdapter.FlowEntry> r3) {
        this.mTmpDataList = r3;
        if (this.mAdapter != null) goto L5;
        return;
    L5:
        ContactsUtils.updateDateAndTimeFormat();
        FlowAdapter r0 = this.mAdapter;
        if (r0 == null) goto L8;
        r0.setLoading(false);
    L8:
        FlowAdapter r1 = this.mAdapter;
        if (r1 == null) goto L11;
        r1.setData(r3);
    L11:
        if (r3 != null) goto L13;
    L14:
        setEmptyView();
    L16:
        if (this.mIsLoadingCalls == true) goto L18;
        RecommendUtil.saveRecommendDataToFile(this.mContext, r3);
    L18:
        StringBuilder r2 = new StringBuilder("show recommend data: ");
        Float r4 = null;
        if (r3 == null) goto L21;
        Integer r5 = Integer.valueOf(r3.size());
    L22:
        StringBuilder r6 = r2.append(r5).append(", ");
        QuickContactListView r7 = this.mListView;
        if (r7 == null) goto L25;
        r4 = Float.valueOf(r7.getAlpha());
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r6.append(r4).toString());
        return;
    L21:
        r5 = null;
        goto L22
    L13:
        if (r3.isEmpty() == false) goto L16;
        goto L14
    }

    private final void refreshData() {
        if (this.mProviderIsNormal == true) goto L5;
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "cant refresh data: " + this.mProviderIsNormal);
        return;
    L5:
        if (this.mAdapter == null) goto L22;
        startCallsQuery();
        NewDialpadFragment$mHandler$1 r0 = this.mHandler;
        if (r0 == null) goto L11;
        r0.sendEmptyMessageDelayed(10, 900);
    L11:
        if (this.mIsLoadingCalls == false) goto L24;
        List<BaseFlowAdapter.FlowEntry> r1 = this.mTmpDataList;
        if (r1 == null) goto L25;
        boolean r2 = false;
        if (r1 != null) goto L17;
    L19:
        if (r2 == false) goto L26;
        updateCallLogList(this.mTmpDataList);
        return;
    L26:
        return;
    L17:
        if (r1.isEmpty() == true) goto L19;
        r2 = true;
        goto L19
    L25:
        return;
    }

    public final boolean isSyncActive() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return false;
    L7:
        return AccountTypeManager.getInstance(r0).isSyncActive();
    }

    private final boolean fillDigitsIfNecessary() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        Intent r1 = r0.getIntent();
    L6:
        boolean r3 = false;
        if (r1 == this.mOldIntent) goto L27;
        if (r1 == null) goto L10;
        String r2 = r1.getAction();
    L12:
        if (Intrinsics.areEqual("android.intent.action.DIAL", r2) == false) goto L14;
    L17:
        if (r1 == null) goto L19;
        Uri r4 = r1.getData();
    L20:
        if (r4 != null) goto L22;
    L26:
        this.mOldIntent = r1;
        goto L27
    L22:
        if (Intrinsics.areEqual(Constants.SCHEME_TEL, r4.getScheme()) == false) goto L26;
        String r5 = r4.getSchemeSpecificPart();
        if (TextUtils.isEmpty(r5) == true) goto L26;
        r3 = true;
        updateDigitView(true);
        hideListView();
        setFormattedDigits(r5, null);
        sendMessageToSearch();
        goto L26
    L19:
        r4 = null;
        goto L20
    L14:
        if (Intrinsics.areEqual("com.android.phone.action.TOUCH_DIALER", r2) == true) goto L17;
        if (Intrinsics.areEqual("android.intent.action.VIEW", r2) == false) goto L26;
    L10:
        r2 = null;
    L27:
        return r3;
    L5:
        r1 = null;
        goto L6
    }

    private final void setFormattedDigits(String r6, String r7) {
        String r8 = ContactsUtils.formatNumber(r6);
        String r9 = r8;
        if (TextUtils.isEmpty(r9) == true) goto L25;
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L7;
        r0.dropLastNumber();
    L7:
        DigitsEditText r1 = this.mDigits;
        if (r1 == null) goto L10;
        Editable r2 = r1.getText();
    L12:
        if (r2 == null) goto L20;
        int r3 = r2.length();
        if (this.mFirstUseAfterColdLaunch == true) goto L19;
        if (r8 == null) goto L18;
        r8 = new Regex(HanziToPinyin.Token.SEPARATOR).replace(r9, "");
        goto L19
    L18:
        r8 = null;
    L19:
        r2.replace(0, r3, r8);
    L20:
        this.mIsResetLayout = false;
        if (r2 != null) goto L23;
        return;
    L23:
        afterTextChanged(r2);
        return;
    L10:
        r2 = null;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ContactsUtils.getCurrentCountryIso(getActivity());
        FlowAdapter r4 = new FlowAdapter(getActivity(), this);
        this.mAdapter = r4;
        QuickContactListView r5 = this.mListView;
        if (r5 == null) goto L5;
        r5.setAdapter(r4);
    L5:
        QuickContactListView r6 = this.mListView;
        if (r6 == null) goto L9;
        r6.setScrollEnabled(true);
    L9:
        QuickContactListView r7 = this.mListView;
        if (r7 == null) goto L12;
        r7.setAutoClose(false);
    L12:
        updateListViewConfig(true);
        QuickContactListView r8 = this.mListView;
        if (r8 == null) goto L15;
        r8.setItemsCanFocus(false);
    L15:
        ForceTouchController r9 = this.mForceTouchController;
        if (r9 == null) goto L19;
        r9.setAdapter(this.mAdapter);
        return;
    }

    private final void updateListViewConfig(boolean r5) {
        QuickContactListView r0 = this.mListView;
        if (r0 == null) goto L11;
        int r2 = 0;
        if (r5 == true) goto L10;
        FragmentActivity r3 = this.mContext;
        if (r3 == null) goto L10;
        r2 = r3.getColor(com.android.contacts.R.color.divider_color);
    L10:
        r0.setDivider(new ColorDrawable(r2));
    L11:
        FragmentActivity r1 = this.mContext;
        if (r1 == null) goto L18;
        Resources r4 = r1.getResources();
        if (r4 == null) goto L18;
        int r6 = r4.getDimensionPixelSize(com.android.contacts.R.dimen.divider_height);
        QuickContactListView r7 = this.mListView;
        if (r7 == null) goto L18;
        r7.setDividerHeight(r6);
    L18:
        QuickContactListView r8 = this.mListView;
        if (r8 == null) goto L28;
        Drawable r9 = null;
        if (r5 == true) goto L26;
        FragmentActivity r10 = this.mContext;
        if (r10 == null) goto L26;
        r9 = r10.getDrawable(com.android.contacts.R.drawable.header_line);
    L26:
        r8.setOverscrollHeader(r9);
        return;
    }

    private final CallLogListItemViews getCallLogListItemView(View r1) {
        if ((r1 instanceof CallLogListItemViews) == false) goto L7;
        return (CallLogListItemViews) r1;
    L7:
        return (CallLogListItemViews) r1.findViewById(com.android.contacts.R.id.primary_action_view);
    }

    private final void setupClassicKeypad(View r7) {
        ImageView r0 = (ImageView) r7.findViewById(com.android.contacts.R.id.one_classic);
        String r1 = null;
        if (r0 == null) goto L9;
        FragmentActivity r2 = this.mContext;
        if (r2 == null) goto L7;
        Drawable r3 = r2.getDrawable(com.android.contacts.R.drawable.o_dial_btn_1);
    L8:
        r0.setBackground(r3);
        goto L9
    L7:
        r3 = null;
    L9:
        View r4 = r7.findViewById(com.android.contacts.R.id.one_frame_container);
        if (r4 == null) goto L12;
        r4.setOnTouchListener(this);
    L12:
        View r5 = r7.findViewById(com.android.contacts.R.id.one_frame_container);
        if (r5 == null) goto L15;
        r5.setOnClickListener(this);
    L15:
        ImageView r6 = (ImageView) r7.findViewById(com.android.contacts.R.id.four_classic);
        if (r6 == null) goto L22;
        FragmentActivity r8 = this.mContext;
        if (r8 == null) goto L20;
        Drawable r9 = r8.getDrawable(com.android.contacts.R.drawable.o_dial_btn_4);
    L21:
        r6.setBackground(r9);
        goto L22
    L20:
        r9 = null;
    L22:
        View r10 = r7.findViewById(com.android.contacts.R.id.four_frame_container);
        if (r10 == null) goto L25;
        r10.setOnTouchListener(this);
    L25:
        View r11 = r7.findViewById(com.android.contacts.R.id.four_frame_container);
        if (r11 == null) goto L28;
        r11.setOnClickListener(this);
    L28:
        ImageView r12 = (ImageView) r7.findViewById(com.android.contacts.R.id.seven_classic);
        if (r12 == null) goto L35;
        FragmentActivity r13 = this.mContext;
        if (r13 == null) goto L33;
        Drawable r14 = r13.getDrawable(com.android.contacts.R.drawable.o_dial_btn_7);
    L34:
        r12.setBackground(r14);
        goto L35
    L33:
        r14 = null;
    L35:
        View r15 = r7.findViewById(com.android.contacts.R.id.seven_frame_container);
        if (r15 == null) goto L38;
        r15.setOnTouchListener(this);
    L38:
        View r16 = r7.findViewById(com.android.contacts.R.id.seven_frame_container);
        if (r16 == null) goto L41;
        r16.setOnClickListener(this);
    L41:
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L44;
        String r18 = r17.getString(com.android.contacts.R.string.accessibility_dial_button);
    L45:
        OButton r19 = (OButton) r7.findViewById(com.android.contacts.R.id.call_classic);
        View r20 = r7.findViewById(com.android.contacts.R.id.call_classic_container);
        if (r19 == null) goto L58;
        FragmentActivity r21 = this.mContext;
        if (r21 == null) goto L50;
        Drawable r22 = r21.getDrawable(com.android.contacts.R.drawable.o_dial_btn_call);
    L51:
        r19.setMIcon(r22);
        if (r20 == null) goto L54;
        r20.setOnClickListener(this);
    L54:
        if (r20 == null) goto L56;
        r20.setContentDescription(r18);
    L56:
        if (r20 == null) goto L58;
        r20.setOnTouchListener(this);
        goto L58
    L50:
        r22 = null;
    L58:
        View r23 = r7.findViewById(com.android.contacts.R.id.call_sim1_button);
        if (r23 == null) goto L65;
        r23.setOnClickListener(this);
        FragmentActivity r24 = getActivity();
        if (r24 == null) goto L63;
        String r25 = r24.getString(com.android.contacts.R.string.accessibility_sim1_dial_button);
    L64:
        r23.setContentDescription(r25);
        goto L65
    L63:
        r25 = null;
    L65:
        View r26 = r7.findViewById(com.android.contacts.R.id.call_sim2_button);
        if (r26 == null) goto L72;
        r26.setOnClickListener(this);
        FragmentActivity r27 = getActivity();
        if (r27 == null) goto L70;
        String r28 = r27.getString(com.android.contacts.R.string.accessibility_sim2_dial_button);
    L71:
        r26.setContentDescription(r28);
        goto L72
    L70:
        r28 = null;
    L72:
        applyFixedScaleDualSimCallButtonStyle(r7);
        ImageView r29 = (ImageView) r7.findViewById(com.android.contacts.R.id.two_classic);
        if (r29 == null) goto L79;
        FragmentActivity r30 = this.mContext;
        if (r30 == null) goto L77;
        Drawable r31 = r30.getDrawable(com.android.contacts.R.drawable.o_dial_btn_2);
    L78:
        r29.setBackground(r31);
        goto L79
    L77:
        r31 = null;
    L79:
        View r32 = r7.findViewById(com.android.contacts.R.id.two_frame_container);
        if (r32 == null) goto L82;
        r32.setOnTouchListener(this);
    L82:
        View r33 = r7.findViewById(com.android.contacts.R.id.two_frame_container);
        if (r33 == null) goto L85;
        r33.setOnClickListener(this);
    L85:
        ImageView r34 = (ImageView) r7.findViewById(com.android.contacts.R.id.five_classic);
        if (r34 == null) goto L92;
        FragmentActivity r35 = this.mContext;
        if (r35 == null) goto L90;
        Drawable r36 = r35.getDrawable(com.android.contacts.R.drawable.o_dial_btn_5);
    L91:
        r34.setBackground(r36);
        goto L92
    L90:
        r36 = null;
    L92:
        View r37 = r7.findViewById(com.android.contacts.R.id.five_frame_container);
        if (r37 == null) goto L95;
        r37.setOnTouchListener(this);
    L95:
        View r38 = r7.findViewById(com.android.contacts.R.id.five_frame_container);
        if (r38 == null) goto L98;
        r38.setOnClickListener(this);
    L98:
        ImageView r39 = (ImageView) r7.findViewById(com.android.contacts.R.id.eight_classic);
        if (r39 == null) goto L105;
        FragmentActivity r40 = this.mContext;
        if (r40 == null) goto L103;
        Drawable r41 = r40.getDrawable(com.android.contacts.R.drawable.o_dial_btn_8);
    L104:
        r39.setBackground(r41);
        goto L105
    L103:
        r41 = null;
    L105:
        View r42 = r7.findViewById(com.android.contacts.R.id.eight_frame_container);
        if (r42 == null) goto L108;
        r42.setOnTouchListener(this);
    L108:
        View r43 = r7.findViewById(com.android.contacts.R.id.eight_frame_container);
        if (r43 == null) goto L111;
        r43.setOnClickListener(this);
    L111:
        ImageView r44 = (ImageView) r7.findViewById(com.android.contacts.R.id.zero_classic);
        if (r44 == null) goto L126;
        FragmentActivity r45 = this.mContext;
        if (r45 == null) goto L116;
        Drawable r46 = r45.getDrawable(com.android.contacts.R.drawable.o_dial_btn_0);
    L117:
        r44.setBackground(r46);
        View r47 = r7.findViewById(com.android.contacts.R.id.zero_frame_container);
        if (r47 == null) goto L120;
        r47.setOnTouchListener(this);
    L120:
        View r48 = r7.findViewById(com.android.contacts.R.id.zero_frame_container);
        if (r48 == null) goto L123;
        r48.setOnClickListener(this);
    L123:
        View r49 = r7.findViewById(com.android.contacts.R.id.zero_frame_container);
        if (r49 == null) goto L126;
        r49.setHapticFeedbackEnabled(false);
        goto L126
    L116:
        r46 = null;
    L126:
        ImageView r50 = (ImageView) r7.findViewById(com.android.contacts.R.id.three_classic);
        if (r50 == null) goto L133;
        FragmentActivity r51 = this.mContext;
        if (r51 == null) goto L131;
        Drawable r52 = r51.getDrawable(com.android.contacts.R.drawable.o_dial_btn_3);
    L132:
        r50.setBackground(r52);
        goto L133
    L131:
        r52 = null;
    L133:
        View r53 = r7.findViewById(com.android.contacts.R.id.three_frame_container);
        if (r53 == null) goto L136;
        r53.setOnTouchListener(this);
    L136:
        View r54 = r7.findViewById(com.android.contacts.R.id.three_frame_container);
        if (r54 == null) goto L139;
        r54.setOnClickListener(this);
    L139:
        ImageView r55 = (ImageView) r7.findViewById(com.android.contacts.R.id.six_classic);
        if (r55 == null) goto L146;
        FragmentActivity r56 = this.mContext;
        if (r56 == null) goto L144;
        Drawable r57 = r56.getDrawable(com.android.contacts.R.drawable.o_dial_btn_6);
    L145:
        r55.setBackground(r57);
        goto L146
    L144:
        r57 = null;
    L146:
        View r58 = r7.findViewById(com.android.contacts.R.id.six_frame_container);
        if (r58 == null) goto L149;
        r58.setOnTouchListener(this);
    L149:
        View r59 = r7.findViewById(com.android.contacts.R.id.six_frame_container);
        if (r59 == null) goto L152;
        r59.setOnClickListener(this);
    L152:
        ImageView r60 = (ImageView) r7.findViewById(com.android.contacts.R.id.nine_classic);
        if (r60 == null) goto L159;
        FragmentActivity r61 = this.mContext;
        if (r61 == null) goto L157;
        Drawable r62 = r61.getDrawable(com.android.contacts.R.drawable.o_dial_btn_9);
    L158:
        r60.setBackground(r62);
        goto L159
    L157:
        r62 = null;
    L159:
        View r63 = r7.findViewById(com.android.contacts.R.id.nine_frame_container);
        if (r63 == null) goto L162;
        r63.setOnTouchListener(this);
    L162:
        View r64 = r7.findViewById(com.android.contacts.R.id.nine_frame_container);
        if (r64 == null) goto L165;
        r64.setOnClickListener(this);
    L165:
        OButton r65 = (OButton) r7.findViewById(com.android.contacts.R.id.star_classic);
        View r66 = r7.findViewById(com.android.contacts.R.id.star_classic_container);
        if (r65 == null) goto L179;
        FragmentActivity r67 = this.mContext;
        if (r67 == null) goto L170;
        Drawable r68 = r67.getDrawable(com.android.contacts.R.drawable.o_dial_btn_asterisk);
    L171:
        r65.setMIcon(r68);
        FrameLayout r69 = (FrameLayout) r66;
        if (r69 == null) goto L174;
        r69.setOnTouchListener(this);
    L174:
        if (r69 == null) goto L176;
        r69.setOnClickListener(this);
    L176:
        if (r69 == null) goto L179;
        r69.setHapticFeedbackEnabled(false);
        goto L179
    L170:
        r68 = null;
    L179:
        OButton r70 = (OButton) r7.findViewById(com.android.contacts.R.id.pound_classic);
        View r71 = r7.findViewById(com.android.contacts.R.id.pound_classic_container);
        if (r70 == null) goto L193;
        FragmentActivity r72 = this.mContext;
        if (r72 == null) goto L184;
        Drawable r73 = r72.getDrawable(com.android.contacts.R.drawable.o_dial_btn_poundsign);
    L185:
        r70.setMIcon(r73);
        FrameLayout r74 = (FrameLayout) r71;
        if (r74 == null) goto L188;
        r74.setOnTouchListener(this);
    L188:
        if (r74 == null) goto L190;
        r74.setOnClickListener(this);
    L190:
        if (r74 == null) goto L193;
        r74.setHapticFeedbackEnabled(false);
        goto L193
    L184:
        r73 = null;
    L193:
        OButton r75 = (OButton) r7.findViewById(com.android.contacts.R.id.add_classic);
        View r76 = r7.findViewById(com.android.contacts.R.id.add_classic_container);
        if (r75 == null) goto L200;
        this.mBtnAddClassic = r75;
        FrameLayout r77 = (FrameLayout) r76;
        this.mBtnAddClassicContainer = r77;
        if (r77 == null) goto L198;
        r77.setOnClickListener(this);
    L198:
        if (r77 == null) goto L200;
        r77.setOnTouchListener(this);
    L200:
        this.mDelete = (OButton) r7.findViewById(com.android.contacts.R.id.delete_classic);
        View r78 = this.mFragmentView;
        if (r78 == null) goto L203;
        View r79 = r78.findViewById(com.android.contacts.R.id.delete_classic_container);
    L204:
        this.mDeleteClassic = r79;
        OButton r80 = this.mDelete;
        if (r80 == null) goto L230;
        FragmentActivity r81 = this.mContext;
        if (r81 == null) goto L209;
        Drawable r82 = r81.getDrawable(com.android.contacts.R.drawable.o_dial_btn_delete_left);
    L210:
        r80.setMIcon(r82);
        View r83 = this.mDeleteClassic;
        if (r83 == null) goto L213;
        r83.setOnClickListener(this);
    L213:
        View r84 = this.mDeleteClassic;
        if (r84 == null) goto L216;
        r84.setOnLongClickListener(this);
    L216:
        View r85 = this.mDeleteClassic;
        if (r85 == null) goto L220;
        r85.setHapticFeedbackEnabled(false);
    L220:
        View r86 = this.mDeleteClassic;
        if (r86 == null) goto L227;
        FragmentActivity r87 = getActivity();
        if (r87 == null) goto L226;
        r1 = r87.getString(com.android.contacts.R.string.common_delete_button);
    L226:
        r86.setContentDescription(r1);
    L227:
        View r88 = this.mDeleteClassic;
        if (r88 == null) goto L230;
        r88.setOnTouchListener(this);
        goto L230
    L209:
        r82 = null;
    L230:
        traversalChildAndSetDelegateIfNecessary(r7);
        View r89 = r7.findViewById(com.android.contacts.R.id.dialpad_classic_layout);
        if ((r89 instanceof DialpadContainer) == false) goto L234;
        ((DialpadContainer) r89).setOnHide(new AnonymousClass6(this));
        return;
    L234:
        return;
    L203:
        r79 = null;
        goto L204
    L44:
        r18 = null;
        goto L45
    }

    private final void initDialpadMode() {
        View r0 = this.mFragmentView;
        ViewGroup r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(com.android.contacts.R.id.dialpad_panel_stub);
    L6:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewStub");
        ViewStub r3 = (ViewStub) r2;
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "init isSimManualSelectMode = " + DSUtils.isSimManualSelectMode());
    L9:
        r3.setLayoutResource(com.android.contacts.R.layout.dialpad_classic_panel);
        View r4 = r3.inflate();
        this.mClassicDialpad = r4;
        if (r4 == null) goto L12;
        OUIFrameLayout r5 = (OUIFrameLayout) r4.findViewById(com.android.contacts.R.id.dialpad_classic_container);
    L13:
        this.mClassicDialpadContainer = r5;
        View r6 = this.mClassicDialpad;
        if (r6 == null) goto L16;
        r1 = (ViewGroup) r6.findViewById(com.android.contacts.R.id.dialpad_sheet_panel);
    L16:
        this.mDialPadSheet = r1;
        Context r7 = getContext();
        if (r7 != null) goto L19;
    L23:
        View r8 = this.mClassicDialpad;
        if (r8 == null) goto L26;
        setupClassicKeypad(r8);
    L26:
        this.mCurrentDialpadPanel = this.mClassicDialpad;
        this.mCurrentDialpadLayoutID = com.android.contacts.R.layout.dialpad_classic_panel;
        return;
    L19:
        if (OMaterialHelper.isMaterialEffectEnabled(r7) == false) goto L23;
        ViewGroup r9 = this.mDialPadSheet;
        if (r9 == null) goto L23;
        r9.setBackgroundResource(com.android.contacts.R.drawable.new_dialpad_bg_for_material);
        ViewGroup r10 = r9;
        OMaterialExtBaseKt.materials$default(r10, MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!ViewUtilKt.isDarkMode(r10))), false, 0, null, 14, null);
        OMaterialExtBaseKt.setMaterialBackdropTarget(r10, this.mClassicDialpad);
        goto L23
    L12:
        r5 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    private final void updateDialpadMode() {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "update isSimManualSelectMode = " + DSUtils.isSimManualSelectMode());
        int r0 = this.mCurrentDialpadLayoutID;
        int r2 = com.android.contacts.R.layout.dialpad_classic_panel;
        boolean r3 = false;
        if (r0 != com.android.contacts.R.layout.dialpad_classic_panel) goto L9;
        r2 = 0;
    L9:
        if (r2 == 0) goto L13;
        View r1 = replaceCurrentDialpadPanel(r2);
        this.mCurrentDialpadPanel = r1;
        this.mClassicDialpad = r1;
        this.mCurrentDialpadLayoutID = r2;
        if (r1 == null) goto L26;
        setupClassicKeypad(r1);
        return;
    L26:
        return;
    L13:
        ImportantResource r4 = this.mImportantResource;
        if (r4 != null) goto L16;
    L18:
        if (r3 == true) goto L20;
        return;
    L20:
        if (ContactsUtils.DEBUG == false) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "biu biu --->> reload class pad data" + this.mClassicDialpad);
    L22:
        View r5 = this.mCurrentDialpadPanel;
        if (r5 == null) goto L29;
        setupClassicKeypad(r5);
        return;
    L29:
        return;
    L16:
        if (r4.getDrawableCount() != 0) goto L18;
        r3 = true;
        goto L18
    }

    private final View replaceCurrentDialpadPanel(int r6) {
        View r0 = this.mCurrentDialpadPanel;
        View r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L6:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r3 = (ViewGroup) r2;
        int r4 = r3.indexOfChild(this.mCurrentDialpadPanel);
        r3.removeView(this.mCurrentDialpadPanel);
        View r5 = this.mDialpadLayoutCache.get(Integer.valueOf(r6));
        if (r5 != null) goto L14;
        FragmentActivity r7 = this.mContext;
        if (r7 == null) goto L13;
        LayoutInflater r8 = r7.getLayoutInflater();
        if (r8 == null) goto L13;
        r1 = r8.inflate(r6, r3, false);
    L13:
        this.mDialpadLayoutCache.put(Integer.valueOf(r6), r1);
        r5 = r1;
    L14:
        resetDialpad(r5);
        r3.addView(r5, r4);
        return r5;
    L5:
        r2 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsPcMode == false) goto L12;
        if (this.mVisibilityChanged == false) goto L12;
        if (ProductUtils.isSupportDialInExtDisplay() == true) goto L12;
        NewDialpadFragment$mHandler$1 r0 = this.mHandler;
        if (r0 == null) goto L12;
        r0.postDelayed(new NewDialpadFragment$$ExternalSyntheticLambda3(), 300);
    L12:
        if (DSUtils.isMultiSimEnabled() == false) goto L15;
        DSUtils.registerCallStateChangeListener(this.mPhoneStateListener1);
        DSUtils.registerCallStateChangeListener(this.mPhoneStateListener2);
        onDSFeatureStatusChanged();
    L15:
        if (this.sT9Search == null) goto L19;
        NewDialpadFragment$mHandler$1 r1 = this.mHandler;
        if (r1 == null) goto L19;
        r1.postDelayed(new NewDialpadFragment$$ExternalSyntheticLambda4(this), 500);
    L19:
        boolean r2 = fillDigitsIfNecessary();
        this.isFillDigits = r2;
        boolean r5 = true;
        if (this.mIsResetLayout == false) goto L22;
        new Handler().postDelayed(new NewDialpadFragment$$ExternalSyntheticLambda5(this), 300);
    L43:
        boolean r3 = true;
    L44:
        StringBuilder r4 = new StringBuilder("registToneGeneratorLock-");
        int r6 = this.mRegisIndex;
        this.mRegisIndex = r6 + 1;
        final String r7 = r4.append(r6).toString();
        new NewDialpadFragment$onResume$registToneGeneratorLock$1(this, r7).start();
        DigitsEditText r8 = this.mDigits;
        if (r8 != null) goto L47;
    L49:
        boolean r9 = false;
    L50:
        if (r9 == false) goto L52;
    L56:
        updateDialpadMode();
        updateDialAndDeleteButtonEnabledState();
        updateYellowPageState();
        updateSimSwitchViewState(false);
        this.mFirstUseAfterColdLaunch = false;
        DigitsEditText r10 = this.mDigits;
        if (r10 != null) goto L59;
    L61:
        r5 = false;
    L62:
        if (r5 == false) goto L65;
        if (r3 == false) goto L65;
        tryToShowOpenCallSummaryView();
    L65:
        Function0<Unit> r11 = this.mShowClipPopupWindowRunnable;
        if (r11 == null) goto L71;
        if (r11 == null) goto L69;
        r11.invoke();
    L69:
        this.mShowClipPopupWindowRunnable = null;
        return;
    L71:
        return;
    L59:
        if (r10.length() != 0) goto L61;
    L52:
        if (this.mT9Adapter != null) goto L54;
    L55:
        sendMessageToSearch();
        goto L56
    L54:
        if (hasT9ListAdapter() == true) goto L56;
    L47:
        if (r8.length() != 0) goto L49;
        r9 = true;
        goto L50
    L22:
        if (r2 == true) goto L43;
        final String r12 = getDialpadNumber();
        DigitsEditText r13 = this.mDigits;
        if (r13 != null) goto L26;
    L28:
        boolean r14 = false;
    L29:
        if (r14 == false) goto L43;
        if (TextUtils.isEmpty(r12) == true) goto L43;
        updateDigitView(true);
        QuickContactListView r15 = this.mListView;
        if (r15 == null) goto L35;
        ListAdapter r16 = r15.getAdapter();
    L37:
        if ((r16 instanceof FlowAdapter) == false) goto L39;
        hideListView();
    L39:
        NewDialpadFragment$mHandler$1 r17 = this.mHandler;
        if (r17 == null) goto L42;
        r17.postDelayed(new RunnableC01874(this, r12), TIME_DELAED_AFTER_NUMBER_FORMAT);
    L42:
        r3 = false;
        goto L44
    L35:
        r16 = null;
        goto L37
    L26:
        if (r13.isStateNumber() != true) goto L28;
        r14 = true;
        goto L29
    }

    private static final void onResume$lambda$23() {
        ContactsApplication.showToast(com.android.contacts.R.string.revone_dial_function, 0);
    }

    private static final void onResume$lambda$24(NewDialpadFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        T9Search r0 = r2.sT9Search;     // Catch: InterruptedException -> L7
        if (r0 == null) goto L9;
        r0.refresh();     // Catch: InterruptedException -> L7
    L9:
        T9Search r1 = r2.sT9Search;
        if (r1 == null) goto L13;
        r1.setRegisterContentObserverChange(true);
    L13:
        if (r2.mVisibilityChanged == false) goto L18;
        r2.refreshData();
        return;
    L18:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private static final void onResume$lambda$25(NewDialpadFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        DigitsEditText r0 = r1.mDigits;
        if (r0 == null) goto L7;
        Editable r2 = r0.getText();
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        DigitsEditText r3 = r1.mDigits;
        if (r3 == null) goto L10;
        r3.dropLastNumber();
    L10:
        r1.mIsResetLayout = false;
    }

    public final void setLastNumberDialed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "lastNumberDialed");
        this.mLastNumberDialed = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        T9Search r0 = this.sT9Search;
        boolean r1 = false;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.setRegisterContentObserverChange(false);
    L6:
        final String r2 = "unregistToneGeneratorLock-" + this.mRegisIndex;
        new NewDialpadFragment$onPause$unregistToneGeneratorLock$1(this, r2).start();
        View r3 = null;
        if (this.mIsResetLayout == false) goto L9;
        setDialpadNumber(null, 0);
    L20:
        QuickContactListView r4 = this.mListView;
        if (r4 == null) goto L24;
        if (r4 == null) goto L24;
        r4.hideQuickContact();
    L24:
        setDailpadLeftMode(this.mIsDialpadLeftMode);
        if (DSUtils.isMultiSimEnabled() == false) goto L27;
        DSUtils.unregisterCallStateChangeListener(this.mPhoneStateListener1);
        DSUtils.unregisterCallStateChangeListener(this.mPhoneStateListener2);
    L27:
        View r5 = this.mFragmentView;
        if (r5 == null) goto L30;
        r3 = r5.findViewById(com.android.contacts.R.id.switch_sim);
    L30:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.android.contacts.widget.SimSwitchView");
        ((SimSwitchView) r3).dismissPopupWindow();
        return;
    L9:
        DigitsEditText r6 = this.mDigits;
        if (r6 != null) goto L12;
    L14:
        if (r1 == false) goto L20;
        DigitsEditText r7 = this.mDigits;
        if (r7 == null) goto L18;
        Editable r8 = r7.getText();
    L19:
        setDialpadNumber(String.valueOf(r8), System.currentTimeMillis());
        goto L20
    L18:
        r8 = null;
        goto L19
    L12:
        if (r6.isStateNumber() != true) goto L14;
        r1 = true;
        goto L14
    }

    public final void startCallsQuery() {
        StringBuilder r0 = new StringBuilder("start call query: isloading=").append(this.mIsLoadingCalls).append(", mFirstLoad=").append(this.mFirstLoad).append(", mNeedReloadData=").append(this.mNeedReloadData).append(", ");
        List<BaseFlowAdapter.FlowEntry> r1 = this.mTmpDataList;
        Integer r2 = null;
        if (r1 == null) goto L7;
        if (r1 == null) goto L7;
        r2 = Integer.valueOf(r1.size());
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r2).toString());
        if (this.mIsLoadingCalls == false) goto L10;
        return;
    L10:
        FragmentActivity r3 = this.mContext;
        if (r3 != null) goto L13;
    L39:
        Companion.access$log(Companion, "Activity destroyed, stop calls query here.");
        return;
    L13:
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == true) goto L39;
        if (this.mTmpDataList != null) goto L23;
    L31:
        this.mFirstLoad = false;
        FlowAdapter r5 = this.mAdapter;
        if (r5 == null) goto L35;
        if (r5 == null) goto L35;
        r5.setLoading(true);
    L35:
        RecommendDataLoader r6 = this.mRecommendDataLoader;
        if (r6 == null) goto L41;
        r6.loadRecommendData(true);
        return;
    L41:
        return;
    L23:
        if (this.mFirstLoad == true) goto L31;
        NewDialpadFragment$mHandler$1 r7 = this.mHandler;
        if (r7 == null) goto L28;
        r7.post(new NewDialpadFragment$$ExternalSyntheticLambda2(this));
    L28:
        if (this.mNeedReloadData == true) goto L30;
        return;
    L30:
        this.mNeedReloadData = false;
        goto L31
    L15:
        if (r3.isDestroyed() != true) goto L17;
        r4 = true;
        goto L18
    }

    private static final void startCallsQuery$lambda$26(NewDialpadFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.updateCallLogList(r1.mTmpDataList);
    }

    private final void removeMissedCallNotifications() {
        new Thread(new NewDialpadFragment$$ExternalSyntheticLambda6(this)).start();
    }

    private static final void removeMissedCallNotifications$lambda$27(NewDialpadFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        ReflectUtils.cancelMissedCallsNotification(r1.getActivity());
    }

    private final void updateVoicemailNotifications() {
        if (getActivity() == null) goto L8;
        Intent r0 = new Intent(getActivity(), CallLogNotificationsService.class);
        r0.setAction(CallLogNotificationsService.ACTION_UPDATE_NOTIFICATIONS);
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L9;
        r3.startService(r0);
        return;
    L9:
        return;
    }

    public final ArrayList<ContactItem> getMResults() {
        return this.mResults;
    }

    public final void setMResults(ArrayList<ContactItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mResults = r2;
    }

    public final T9Search.T9SearchResult getMT9Result() {
        return this.mT9Result;
    }

    public final void setMT9Result(T9Search.T9SearchResult r1) {
        this.mT9Result = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void searchContacts() {
        if (Thread.currentThread().isInterrupted() == false) goto L5;
        return;
    L5:
        DigitsEditText r0 = this.mDigits;
        T9Search.T9Adapter r1 = null;
        ArrayList<ContactItem> r2 = null;
        if (r0 == null) goto L8;
        Editable r3 = r0.getText();
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.length() < 0) goto L84;
        DigitsEditText r4 = this.mDigits;     // Catch: Exception -> L19
        if (r4 == null) goto L16;
        Editable r5 = r4.getText();     // Catch: Exception -> L19
    L17:
        String r6 = String.valueOf(r5);     // Catch: Exception -> L19
    L21:
        int r7 = 0;
        if (TextUtils.isEmpty(r6) == true) goto L26;
        if (r6 == null) goto L26;
        r7 = r6.length();
    L26:
        if (r7 <= 0) goto L64;
        T9Search r8 = this.sT9Search;
        if (r8 == null) goto L74;
        if (r8 == null) goto L31;
        T9Search.T9SearchResult r9 = r8.search(r6);
    L32:
        this.mT9Result = r9;
        if (r9 != null) goto L35;
        NewDialpadFragment$mHandler$1 r10 = this.mHandler;
        if (r10 == null) goto L79;
        r10.sendEmptyMessage(com.android.contacts.R.id.msg_setoptionframe_visible);
        return;
    L79:
        return;
    L35:
        if (this.mT9Adapter != null) goto L57;
        T9Search r11 = this.sT9Search;
        if (r11 == null) goto L42;
        FragmentActivity r12 = this.mContext;
        if (r9 == null) goto L41;
        r2 = r9.getResults();
    L41:
        r1 = r11.getT9Adapter(r12, r2);
    L42:
        this.mT9Adapter = r1;
        if (r1 == null) goto L45;
        r1.setQuickContactListener(this.mListView);
    L45:
        T9Search.T9Adapter r13 = this.mT9Adapter;
        if (r13 == null) goto L48;
        r13.setListView(this.mListView);
    L48:
        T9Search.T9Adapter r14 = this.mT9Adapter;
        if (r14 == null) goto L51;
        r14.setLongClick(this.mItemLongClickedListener);
    L51:
        T9Search.T9Adapter r15 = this.mT9Adapter;
        if (r15 == null) goto L54;
        r15.setItemClick(this);
    L54:
        NewDialpadFragment$mHandler$1 r16 = this.mHandler;
        if (r16 == null) goto L75;
        r16.sendEmptyMessage(com.android.contacts.R.id.msg_set_t9adapter);
        return;
    L75:
        return;
    L57:
        NewDialpadFragment$mHandler$1 r17 = this.mHandler;
        if (r17 == null) goto L77;
        r17.sendEmptyMessage(com.android.contacts.R.id.msg_addresult_to_t9adapter);
        return;
    L77:
        return;
    L31:
        r9 = null;
        goto L32
    L74:
        return;
    L64:
        if (this.mT9Adapter != null) goto L66;
        return;
    L66:
        if (this.isT9on == false) goto L82;
        NewDialpadFragment$mHandler$1 r18 = this.mHandler;
        if (r18 == null) goto L83;
        r18.sendEmptyMessage(com.android.contacts.R.id.msg_reset_dialpad);
        return;
    L83:
        return;
    L82:
        return;
    L16:
        r5 = null;
    L19:
        e = move-exception;
        e.printStackTrace();
        r6 = null;
        goto L21
    L84:
        return;
    L8:
        r3 = null;
        goto L9
    }

    private final boolean dialOnTap() {
        return PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("t9_dial_onclick", false);
    }

    private final boolean isDialpadLeftMode() {
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L5;
        ContentResolver r3 = r2.getContentResolver();
    L7:
        if (Settings.Global.getInt(r3, "contacts_dialpad_left_mode", 0) == 1) goto L9;
        return false;
    L9:
        return true;
    L5:
        r3 = null;
        goto L7
    }

    private final void setDailpadLeftMode(boolean r2) {
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L5;
        ContentResolver r3 = r1.getContentResolver();
    L6:
        Settings.Global.putInt(r3, "contacts_dialpad_left_mode", r2 ? 1 : 0);
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void setDialpadNumber(String r1, long r2) {
        SharedPreferences r3 = this.mPrefs;
        if (r3 == null) goto L5;
        SharedPreferences.Editor r4 = r3.edit();
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = "";
    L9:
        if (r4 == null) goto L11;
        r4.putString(this.DIALPAD_NUMBER, r1);
    L11:
        if (r4 == null) goto L14;
        r4.apply();
        return;
    L14:
        return;
    L5:
        r4 = null;
        goto L7
    }

    private final boolean getLastOneHandModeLeft() {
        SharedPreferences r0 = this.mPrefs;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean(this.DIALPAD_LEFT_MODE, false);
    }

    private final void setLastOneHandModeLeft(boolean r2) {
        SharedPreferences r0 = this.mPrefs;
        if (r0 == null) goto L5;
        SharedPreferences.Editor r1 = r0.edit();
    L6:
        if (r1 == null) goto L8;
        r1.putBoolean(this.DIALPAD_LEFT_MODE, r2);
    L8:
        if (r1 == null) goto L11;
        r1.apply();
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void keyPressed(int r5) {
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L5;
        r0.dropLastNumber();
    L5:
        StringBuilder r1 = new StringBuilder("keyPressed: ").append(r5).append(',');
        DigitsEditText r2 = this.mDigits;
        if (r2 == null) goto L8;
        Editable r3 = r2.getText();
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r1.append(r3).toString());
        boolean r4 = true;
        if (r5 != 67) goto L12;
    L14:
        if (r5 == 67) goto L16;
    L27:
        KeyEvent r6 = new KeyEvent(0, r5);
        DigitsEditText r7 = this.mDigits;
        if (r7 == null) goto L31;
        r7.onKeyDown(r5, r6);
        return;
    L31:
        return;
    L16:
        if (isDigitsEmpty() == true) goto L27;
        DigitsEditText r8 = this.mDigits;
        if (r8 == null) goto L24;
        Editable r9 = r8.getText();
        if (r9 == null) goto L24;
        if (r9.length() != 1) goto L24;
    L25:
        if (r4 == false) goto L27;
        setDigitHint(false);
        hideListView();
    L24:
        r4 = false;
        goto L25
    L12:
        if (isDigitsEmpty() == false) goto L14;
        updateDigitView(true);
        hideListView();
        goto L27
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r1, int r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r1.getId() == com.android.contacts.R.id.digits) goto L5;
        return false;
    L5:
        if (r2 != 66) goto L8;
        dialButtonPressed();
        return true;
    L8:
        sendMessageToSearch();
        return false;
    }

    private final void updateUsualDialPadPadding(boolean r5) {
        int r0 = ContactsUtils.dipTopx(getContext(), 20.0d);
        int r1 = ContactsUtils.dipTopx(getContext(), 8.0d);
        if (r5 == false) goto L10;
        View r6 = this.mDialpadUsual;
        if (r6 == null) goto L7;
        r6.setPadding(r0, r6.getPaddingTop(), r1, this.mDialpadUsual.getPaddingBottom());
    L7:
        View r7 = this.mDialpadUnusualRight;
        if (r7 == null) goto L17;
        r7.setPadding(r7.getPaddingLeft(), this.mDialpadUnusualRight.getPaddingTop(), r0, this.mDialpadUnusualRight.getPaddingBottom());
        return;
    L17:
        return;
    L10:
        View r8 = this.mDialpadUsual;
        if (r8 == null) goto L13;
        r8.setPadding(r1, r8.getPaddingTop(), r0, this.mDialpadUsual.getPaddingBottom());
    L13:
        View r9 = this.mDialpadUnusualLeft;
        if (r9 == null) goto L19;
        r9.setPadding(r0, r9.getPaddingTop(), this.mDialpadUnusualLeft.getPaddingRight(), this.mDialpadUnusualLeft.getPaddingBottom());
        return;
    }

    private final void updateUsualDialPadBackground(boolean r2) {
        Drawable r0 = null;
        if (r2 == false) goto L11;
        View r3 = this.mDialpadUsual;
        if (r3 == null) goto L20;
        FragmentActivity r1 = this.mContext;
        if (r1 == null) goto L10;
        r0 = r1.getDrawable(com.android.contacts.R.drawable.o_dial_table_bg_left);
    L10:
        r3.setBackground(r0);
        return;
    L20:
        return;
    L11:
        View r4 = this.mDialpadUsual;
        if (r4 == null) goto L21;
        FragmentActivity r5 = this.mContext;
        if (r5 == null) goto L17;
        r0 = r5.getDrawable(com.android.contacts.R.drawable.o_dial_table_bg_right);
    L17:
        r4.setBackground(r0);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        boolean r0 = true;
        switch(r4.getId()) {
            case 2131361949: goto L31;
            case 2131361950: goto L31;
            case 2131361952: goto L28;
            case 2131362194: goto L26;
            case 2131362216: goto L24;
            case 2131362217: goto L22;
            case 2131362469: goto L20;
            case 2131362472: goto L20;
            case 2131362473: goto L20;
            case 2131362526: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        DigitsEditText r5 = this.mDigits;
        if (r5 == null) goto L8;
        Integer r6 = Integer.valueOf(r5.length());
    L9:
        DigitsEditText r2 = this.mDigits;
        if (r2 == null) goto L18;
        if (r6 != null) goto L14;
    L17:
        r2.setCursorVisible(r0);
        goto L18
    L14:
        if (r6.intValue() != 0) goto L17;
        r0 = false;
    L18:
        showDialpad();
        return;
    L8:
        r6 = null;
        goto L9
    L20:
        keyPressed(67);
        return;
    L22:
        dialButtonPressed(1);
        return;
    L24:
        dialButtonPressed(0);
        return;
    L26:
        dialButtonPressed();
        return;
    L28:
        goToAddContact();
        return;
    L31:
        if (isDigitsEmpty() == true) goto L33;
        goToAddContact();
        return;
    L33:
        disappearDialpad();
    }

    private final void goToAddContact() {
        if (isDigitsEmpty() == false) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L13;
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L9;
        Editable r1 = r0.getText();
    L10:
        Intent r2 = ContactsIntentUtils.getAddToContactIntent(r1, "call_log_digists");
        r2.putExtra(ContactsUtils.EXTRA_HIDE_STRANGER_CALL_LOG, true);
        AnimationUtil.startActivityWithAnimExtra(getActivity(), r2, 1, 2);
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        DigitsEditText r0 = this.mDigits;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Editable r2 = r0.getText();
    L6:
        boolean r3 = true;
        switch(r6.getId()) {
            case 2131362469: goto L23;
            case 2131362472: goto L23;
            case 2131362473: goto L23;
            case 2131362526: goto L9;
            default: goto L8;
        };
    L8:
        return false;
    L9:
        DigitsEditText r7 = this.mDigits;
        if (r7 == null) goto L12;
        r1 = Integer.valueOf(r7.length());
    L12:
        DigitsEditText r5 = this.mDigits;
        if (r5 == null) goto L21;
        if (r1 != null) goto L17;
    L20:
        r5.setCursorVisible(r3);
        goto L21
    L17:
        if (r1.intValue() != 0) goto L20;
        r3 = false;
    L21:
        return false;
    L23:
        if (DEBUG == false) goto L29;
        if (r2 == null) goto L27;
        String r8 = r2.toString();
        if (r8 == null) goto L27;
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onLongClick with delete key , with digits:" + r8);
    L27:
        r8 = "";
    L29:
        DigitsEditText r9 = this.mDigits;
        if (r9 == null) goto L33;
        r9.setCursorVisible(false);
    L33:
        if (isDigitsEmpty() == true) goto L35;
        setDigitHint(false);
        hideListView();
    L35:
        if (r2 == null) goto L37;
        r2.clear();
    L37:
        return true;
    L5:
        r2 = null;
        goto L6
    }

    private final void updateDigitView(boolean r8) {
        FrameLayout r0 = this.mDigitFrame;
        String r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r2;
    L10:
        boolean r4 = true;
        boolean r5 = false;
        if (r8 == true) goto L19;
        DigitsEditText r9 = this.mDigits;
        if (r9 == null) goto L15;
        boolean r10 = r9.isTailNumber();
    L16:
        if (r10 == true) goto L19;
        boolean r11 = false;
    L20:
        updateInputBackgroundCoverVisibility(r11);
        if (r11 == false) goto L23;
        int r6 = sDigitFrameMaxHeight;
    L24:
        if (r3 != null) goto L26;
    L28:
        boolean r7 = false;
    L29:
        if (r7 == true) goto L36;
        if (r3 == null) goto L33;
        r3.height = r6;
    L33:
        FrameLayout r12 = this.mDigitFrame;
        if (r12 == null) goto L36;
        r12.setLayoutParams(r3);
    L36:
        setDigitHint(false);
        if (r11 == false) goto L39;
        int r13 = 0;
    L40:
        View r14 = this.mBGView;
        if (r14 != null) goto L43;
        return;
    L43:
        if (r14.getVisibility() == r13) goto L69;
        if (r11 == false) goto L46;
        String r15 = "show";
    L48:
        if ((r14 instanceof ViewGroup) == false) goto L50;
        ViewGroup r16 = (ViewGroup) r14;
    L51:
        if (r16 != null) goto L53;
    L65:
        if (r5 == false) goto L70;
        r14.setVisibility(r13);
        return;
    L70:
        return;
    L53:
        if (r15.length() <= 0) goto L55;
        boolean r17 = true;
    L56:
        if (r17 == false) goto L63;
        TransitionEx r18 = OEAAnimKt.getRunningTransition(r16);
        if (r18 == null) goto L61;
        r1 = r18.getTag();
    L61:
        if (Intrinsics.areEqual(r15, r1) == false) goto L63;
        r4 = false;
    L64:
        r5 = r4;
    L63:
        TransitionManager.endTransitions(r16);
        TransitionSet r19 = new TransitionSet();
        r19.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        Fade r20 = new Fade();
        r20.addTarget(r14);
        r19.addTransition(r20);
        r19.setDuration(200);
        TransitionSet r21 = r19;
        OEAAnimKt.access$setRunningTransition(r16, new TransitionEx(r15, r21));
        r19.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r16)));
        TransitionManager.beginDelayedTransition(r16, r21);
        goto L64
    L55:
        r17 = false;
        goto L56
    L50:
        r16 = null;
        goto L51
    L46:
        r15 = "hide";
        goto L48
    L69:
        return;
    L39:
        r13 = 8;
        goto L40
    L26:
        if (r3.height != r6) goto L28;
        r7 = true;
        goto L29
    L23:
        r6 = sDigitFrameMinHeight;
        goto L24
    L15:
        r10 = false;
    L19:
        r11 = true;
        goto L20
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    private final void updateInputBackgroundCoverVisibility(boolean r2) {
        View r1 = this.mInputBackgroundCover;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L9:
        if (r1.getVisibility() == r3) goto L12;
        r1.setVisibility(r3);
        return;
    L12:
        return;
    L7:
        r3 = 8;
        goto L9
    }

    private final void setDigitHint(boolean r8) {
        if (r8 == false) goto L6;
        SpannableString r9 = new SpannableString(getText(com.android.contacts.R.string.digit_input_hint));
        r9.setSpan(new TextAppearanceSpan(null, 0, sDigitTextSizeHint, null, null), 0, r9.length(), 18);
        DigitsEditText r7 = this.mDigits;
        if (r7 == null) goto L10;
        r7.setHint(r9);
        return;
    L10:
        return;
    L6:
        DigitsEditText r10 = this.mDigits;
        if (r10 == null) goto L12;
        r10.setHint(null);
        return;
    }

    public final void resetDialpad() {
        updateDigitView(false);
        OButton r1 = this.mDelete;
        if (r1 == null) goto L5;
        r1.setPressed(false);
    L5:
        View r2 = this.mDeleteClassic;
        if (r2 == null) goto L9;
        if (r2 == null) goto L9;
        r2.setPressed(false);
    L9:
        boolean r3 = true;
        updateListViewConfig(true);
        QuickContactListView r4 = this.mListView;
        if (r4 == null) goto L12;
        ListAdapter r5 = r4.getAdapter();
    L14:
        if ((r5 instanceof FlowAdapter) == false) goto L18;
        FlowAdapter r6 = this.mAdapter;
        if (r6 == null) goto L27;
        r6.notifyDataSetChanged();
    L27:
        QuickContactListView r7 = this.mListView;
        if (r7 == null) goto L30;
        r7.setAutoClose(false);
    L30:
        QuickContactListView r8 = this.mListView;
        if (r8 == null) goto L33;
        r8.restoreScrollState(false);
    L33:
        showListViewWithoutAnimIfNeed();
        QuickContactListView r9 = this.mListView;
        if (r9 != null) goto L36;
    L38:
        r3 = false;
    L39:
        if (r3 == false) goto L43;
        QuickContactListView r10 = this.mListView;
        if (r10 == null) goto L43;
        r10.setVisibility(0);
    L43:
        dismissLongMenu();
        return;
    L36:
        if (r9.getVisibility() != 8) goto L38;
    L18:
        QuickContactListView r11 = this.mListView;
        if (r11 == null) goto L21;
        r11.setAdapter(this.mAdapter);
    L21:
        QuickContactListView r12 = this.mListView;
        if (r12 == null) goto L24;
        r12.setScrollEnabled(true);
    L24:
        ForceTouchController r13 = this.mForceTouchController;
        if (r13 == null) goto L27;
        r13.setAdapter(this.mAdapter);
        goto L27
    L12:
        r5 = null;
        goto L14
    }

    public final void callVoicemail() {
        if (ContactsUtils.isNoSim(this.mContext) == false) goto L7;
        ContactsApplication.showToast(com.android.contacts.R.string.no_sim_voice_mail_toast, 1);
        return;
    L7:
        if (DSUtils.useDSFeature() == false) goto L14;
        FragmentActivity r0 = this.mContext;
        FragmentActivity r1 = r0;
        if (r0 == null) goto L11;
        String r2 = r0.getString(com.android.contacts.R.string.common_voice_mail);
    L12:
        ContactsUtils.showSelectSimDialog(r1, r2, null, 3);
    L18:
        DigitsEditText r4 = this.mDigits;
        if (r4 == null) goto L24;
        Editable r5 = r4.getText();
        if (r5 == null) goto L25;
        r5.clear();
        return;
    L25:
        return;
    L24:
        return;
    L11:
        r2 = null;
        goto L12
    L14:
        if (TextUtils.isEmpty(ContactsUtils.getVoiceNumber()) == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "callVoicemail but voicemail number is empty");
        showMissingVoicemailErrorDialog(DSUtils.getDefaultCallSim());
        return;
    L17:
        DSUtils.callVoicemail(this.mContext, -1);
        goto L18
    }

    private final void showMissingVoicemailErrorDialog(final int r15) {
        dismissPendingDialogs();
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        OAlertDialog r16 = (OAlertDialog) OAlertDialogBuilder.positiveButton$default(OAlertDialogBuilder.negativeButton$default(new OAlertDialogBuilder(r0).title(com.android.contacts.R.string.no_vm_number).message(com.android.contacts.R.string.no_vm_number_msg), com.android.contacts.R.string.no_vm_negative_btn, new NewDialpadFragment$$ExternalSyntheticLambda0(this, r15), null, 4, null), com.android.contacts.R.string.no_vm_positive_btn, new NewDialpadFragment$$ExternalSyntheticLambda10(this), null, 4, null).onCancel(new NewDialpadFragment$$ExternalSyntheticLambda11(this)).build();
        this.mDialog = r16;
        if (r16 == null) goto L9;
        r16.show();
        return;
    }

    private static final void showMissingVoicemailErrorDialog$lambda$29(NewDialpadFragment r0, int r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.addVoiceMailNumberPanel(r1);
    }

    private static final void showMissingVoicemailErrorDialog$lambda$30(NewDialpadFragment r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onDialogDismissed();
    }

    private static final void showMissingVoicemailErrorDialog$lambda$31(NewDialpadFragment r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onDialogDismissed();
    }

    private final void onDialogDismissed() {
        this.mDialog = null;
    }

    public final void dismissPendingDialogs() {
        OAlertDialog r0 = this.mDialog;
        if (r0 == null) goto L8;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        this.mDialog = null;
        return;
    }

    private final void addVoiceMailNumberPanel(int r4) {
        Companion.access$log(Companion, "show vm setting");
        Intent r0 = new Intent("com.android.phone.CallFeaturesSetting.ADD_VOICEMAIL");
        r0.setClassName(TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME, "com.bytedanceos.phone.settings.settings.VoiceMailSetting");
        r0.putExtra("slot", r4);
        startActivity(r0);
    }

    private final void processDialButtonPressed(int r10) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("Contacts", "dialpad pressed. " + isDigitsEmpty());
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_CALL_BUTTON);
        DialpadMatchTracker.reportAndClear("make_call");
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L5;
        r0.dropLastNumber();
    L5:
        String r2 = "";
        int r4 = 0;
        if (isDigitsEmpty() == true) goto L8;
        DigitsEditText r1 = this.mDigits;
        if (r1 == null) goto L34;
        Editable r3 = r1.getText();
        if (r3 == null) goto L34;
        String r5 = r3.toString();
        if (r5 == null) goto L34;
        r2 = r5;
    L34:
        this.mLastNumberDialed = r2;
        if (ContactsUtils.isJustClicked() == true) goto L64;
        String r6 = this.mProhibitedPhoneNumberRegexp;
        String r7 = r6;
        if (r7 != null) goto L39;
    L42:
        boolean r8 = true;
    L43:
        if (r8 == true) goto L57;
        if (new Regex(r6).matches(r2) == false) goto L57;
        if (SystemProperties.getInt("persist.radio.otaspdial", 0) == 1) goto L57;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "The phone number is prohibited explicitly by a rule.");
        if (getActivity() == null) goto L51;
        ErrorDialogFragment.Companion.newInstance(com.android.contacts.R.string.dialog_phone_call_prohibited_title).show(getParentFragmentManager(), "phone_prohibited_dialog");
    L51:
        DigitsEditText r11 = this.mDigits;
        if (r11 == null) goto L64;
        Editable r12 = r11.getText();
        if (r12 == null) goto L64;
        r12.clear();
    L57:
        if (r10 == (-1)) goto L59;
        Intent r13 = DSUtils.getCallIntent(this.mContext, r2, r10, true);
        Intrinsics.checkNotNullExpressionValue(r13, "getCallIntent(mContext, number, simId, true)");
    L61:
        if ((getActivity() instanceof DialtactsActivity) == false) goto L63;
        r13.putExtra("com.android.phone.CALL_ORIGIN", "com.android.contacts.activities.DialtactsActivity");
    L63:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("Contacts", "start call!");
        startActivity(r13);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
        this.mIsResetLayout = true;
        goto L64
    L59:
        r13 = ContactsIntentUtils.newDialNumberIntent(r2, true);
        Intrinsics.checkNotNullExpressionValue(r13, "newDialNumberIntent(number, true)");
        goto L61
    L39:
        if (r7.length() == 0) goto L42;
        r8 = false;
    L64:
        AnimationUtil.switchActivityAnimation(getActivity(), 0);
        return;
    L8:
        if (phoneIsCdma() == false) goto L13;
        if (isPhoneInUse() == false) goto L13;
        startActivity(newFlashIntent());
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
        return;
    L13:
        if (TextUtils.isEmpty(this.mLastNumberDialed) == true) goto L25;
        DigitsEditText r14 = this.mDigits;
        if (r14 == null) goto L17;
        r14.setText(new Regex("[- ()]").replace(this.mLastNumberDialed, ""));
    L17:
        DigitsEditText r15 = this.mDigits;
        if (r15 == null) goto L24;
        if (r15 == null) goto L23;
        Editable r9 = r15.getText();
        if (r9 == null) goto L23;
        r4 = r9.length();
    L23:
        r15.setSelection(r4);
    L24:
        sendMessageToSearch();
        return;
    L25:
        playTone(26);
    }

    public final void dialButtonPressed() {
        int r1 = -1;
        if (DSUtils.isSimManualSelectMode() == false) goto L20;
        if (isDigitsEmpty() == false) goto L8;
        processDialButtonPressed(-1);
        return;
    L8:
        View r0 = this.mCurrentDialpadPanel;
        if (r0 != null) goto L12;
        r0 = this.mClassicDialpad;
    L12:
        if (r0 != null) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "dialButtonPressed manual select mode, anchor is null");
        return;
    L15:
        View r2 = ViewUtilsKt.findView(r0, new int[]{com.android.contacts.R.id.dialpad_classic_layout, com.android.contacts.R.id.call_classic});
        if (r2 == null) goto L18;
        r0 = r2;
    L18:
        String r4 = DSUtils.getOperatorNameBySimSlotId(0);
        Intrinsics.checkNotNullExpressionValue(r4, "getOperatorNameBySimSlotId(DSUtils.SIM_1)");
        String r5 = DSUtils.getSimNumber(r0.getContext(), 0);
        Intrinsics.checkNotNullExpressionValue(r5, "getSimNumber(anchor.context, DSUtils.SIM_1)");
        String r6 = DSUtils.getOperatorNameBySimSlotId(1);
        Intrinsics.checkNotNullExpressionValue(r6, "getOperatorNameBySimSlotId(DSUtils.SIM_2)");
        String r7 = DSUtils.getSimNumber(r0.getContext(), 1);
        Intrinsics.checkNotNullExpressionValue(r7, "getSimNumber(anchor.context, DSUtils.SIM_2)");
        ArrayList r3 = Lists.newArrayList(new PopMenuItem[]{new PopMenuItem(0, com.android.contacts.R.drawable.sim_1_icon, r4, r5), new PopMenuItem(1, com.android.contacts.R.drawable.sim_2_icon, r6, r7)});
        Intrinsics.checkNotNullExpressionValue(r3, "newArrayList<PopMenuItem…          )\n            )");
        final ArrayList r8 = r3;
        this.mSimSelectPopMenu.setWidth(OUnitExtensionKt.dp2px(BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND));
        this.mSimSelectPopMenu.show(r0, r8, new AnonymousClass1(r8, this));
        return;
    L20:
        if (DSUtils.useDSFeature() == false) goto L26;
        View r9 = this.mFragmentView;
        if (r9 == null) goto L24;
        View r10 = r9.findViewById(com.android.contacts.R.id.switch_sim);
    L25:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.android.contacts.widget.SimSwitchView");
        r1 = ((SimSwitchView) r10).getCurrentSim();
        goto L26
    L24:
        r10 = null;
    L26:
        processDialButtonPressed(r1);
    }

    public final void dialButtonPressed(int r1) {
        processDialButtonPressed(r1);
    }

    public final void playTone(final int r6) {
        if (ContactsUtils.USER_LOG_ON == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Dialpad playTone: tone=" + r6 + ", mDTMFToneEnabled=" + this.mDTMFToneEnabled);
    L5:
        FragmentActivity r2 = this.mContext;
        if (r2 == null) goto L8;
        ContentResolver r3 = r2.getContentResolver();
    L9:
        boolean r4 = true;
        if (Settings.System.getInt(r3, "dtmf_tone", 1) == 1) goto L13;
        r4 = false;
    L13:
        this.mDTMFToneEnabled = r4;
        if (r4 == true) goto L17;
        return;
    L17:
        if (ContactsUtils.USER_LOG_ON == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "playTone got ringer mode 2");
    L19:
        Object r5 = this.mToneGeneratorLock;
        monitor-enter(r5);
    L41:
        th = move-exception;
        throw th;
    L22:
        if (this.mToneGenerator != null) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "playTone: mToneGenerator == null, tone: " + r6);     // Catch: Throwable -> L41
        monitor-exit(r5);
        return;
    L27:
        if (ContactsUtils.USER_LOG_ON == false) goto L45;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "playTone start...");     // Catch: Throwable -> L41
    L45:
        ExecutorService r1 = this.pool;     // Catch: RejectedExecutionException -> L33 Throwable -> L41
        if (r1 == null) goto L36;
        r1.execute(new NewDialpadFragment$$ExternalSyntheticLambda1(this, r6));     // Catch: RejectedExecutionException -> L33 Throwable -> L41
    L36:
        if (ContactsUtils.USER_LOG_ON == false) goto L38;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "playTone done...");     // Catch: Throwable -> L41
    L38:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r5);
        return;
    L33:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "playTone rejected because executor is shutdown, tone: " + r6, e);     // Catch: Throwable -> L41
        goto L36
    L8:
        r3 = null;
        goto L9
    }

    private static final void playTone$lambda$34$lambda$33(NewDialpadFragment r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Object r0 = r2.mToneGeneratorLock;
        monitor-enter(r0);
        ToneGenerator r4 = r2.mToneGenerator;     // Catch: Throwable -> L15
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        if (r4 != null) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "playTone#execute: mToneGenerator == null, tone: " + r3);
        return;
    L20:
        r4.startTone(r3, 150);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "playTone#catch startTone err: " + th);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private final void dialClickedNumber(String r4, boolean r5) {
        Intent r0 = DSUtils.getSelectSimDialogIntentIfNeeded(this.mContext, null, r4, r5, false);
        if (r0 == null) goto L6;
        startActivity(r0);
        return;
    L6:
        if (DSUtils.useDSFeature() == false) goto L12;
        View r6 = this.mFragmentView;
        if (r6 == null) goto L10;
        View r7 = r6.findViewById(com.android.contacts.R.id.switch_sim);
    L11:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.android.contacts.widget.SimSwitchView");
        Intent r8 = DSUtils.getCallIntent(this.mContext, r4, ((SimSwitchView) r7).getCurrentSim());
        Intrinsics.checkNotNullExpressionValue(r8, "{\n                val ss…currentSim)\n            }");
    L13:
        startActivity(r8);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
        AnimationUtil.switchActivityAnimation(getActivity(), 0);
        return;
    L10:
        r7 = null;
        goto L11
    L12:
        r8 = ContactsIntentUtils.newDialNumberIntent(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r8, "{\n                Contac…isStranger)\n            }");
        goto L13
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r7, View r8, int r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, BaseSwitches.V);
        String r11 = null;
        if (r7 == null) goto L6;
        ListAdapter r12 = r7.getAdapter();
        if (r12 == null) goto L6;
    L12:
        boolean r13 = r12 instanceof HeaderViewListAdapter;
        if (r13 == false) goto L15;
        HeaderViewListAdapter r0 = (HeaderViewListAdapter) r12;
    L16:
        boolean r1 = false;
        if (r0 == null) goto L19;
        int r2 = r0.getHeadersCount();
    L20:
        if (r13 == false) goto L22;
        HeaderViewListAdapter r14 = (HeaderViewListAdapter) r12;
    L23:
        if (r14 == null) goto L28;
        ListAdapter r15 = r14.getWrappedAdapter();
        if (r15 == null) goto L28;
    L26:
        r12 = r15;
    L36:
        int r16 = r9 - r2;
        if (r16 >= 0) goto L40;
        return;
    L40:
        if ((r12 instanceof ListAdapter) == true) goto L42;
    L44:
        String r3 = "";
        if ((r12 instanceof T9Search.T9Adapter) == false) goto L72;
        T9Search.T9Adapter r17 = this.mT9Adapter;
        if (r17 == null) goto L50;
        ContactItem r18 = r17.getItem(r16);
        if (r18 == null) goto L50;
    L51:
        if (r18 == null) goto L53;
        r11 = r18.number;
    L53:
        if (r11 == null) goto L56;
        r3 = r11;
    L56:
        this.mLastNumberDialed = r3;
        if (r18 == null) goto L59;
        long r4 = r18.id;
    L61:
        if (r4 <= 0) goto L63;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_CALL_SEARCH_RESULT_CONTACT);
    L64:
        DialpadMatchTracker.reportAndClear("click_result");
        String r19 = this.mLastNumberDialed;
        if (r18 != null) goto L67;
    L69:
        dialClickedNumber(r19, r1);
        this.mIsResetLayout = true;
        return;
    L67:
        if (r18.hasname == true) goto L69;
        r1 = true;
        goto L69
    L63:
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_CALL_SEARCH_RESULT_CALL_LOG);
        goto L64
    L59:
        r4 = 0;
    L50:
        r18 = ((T9Search.T9Adapter) r12).getItem(r16);
        goto L51
    L72:
        if ((r12 instanceof DialpadOptionAdapter) == false) goto L96;
        DigitsEditText r20 = this.mDigits;
        if (r20 == null) goto L76;
        Editable r21 = r20.getText();
    L77:
        Editable r110 = r21;
        if (TextUtils.isEmpty(r110) == false) goto L80;
        return;
    L80:
        int r22 = ((DialpadOptionAdapter) r12).getCount() - r16;
        if (ContactsUtils.FEATURE_CMCC == false) goto L83;
        r22 = r22 - 1;
    L83:
        if (r22 == 0) goto L93;
        if (r22 != 1) goto L86;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SEND_MMS);
        startActivity(ContactsIntentUtils.getSendMessageIntent(r110));
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
        return;
    L86:
        if (r22 != 2) goto L88;
        Intent r23 = ContactsIntentUtils.getAddToContactIntent(r110, "call_log_list_add");
        r23.putExtra(ContactsUtils.EXTRA_HIDE_STRANGER_CALL_LOG, true);
        AnimationUtil.startActivityWithAnimExtra(getActivity(), r23, 1, 2);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
        return;
    L88:
        if (r22 != 3) goto L107;
        dialClickedNumber(String.valueOf(r21), true);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
        this.mIsResetLayout = true;
        return;
    L107:
        return;
    L93:
        startActivity(ContactsIntentUtils.newDialVoltePhoneIntent("" + r21));
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
        return;
    L76:
        r21 = null;
        goto L77
    L96:
        if ((r12 instanceof CallLogAdapter) == false) goto L109;
        Object r24 = r8.getTag();
        if ((r24 instanceof View.OnClickListener) == false) goto L102;
        CallLogListItemViews r25 = getCallLogListItemView(r8);
        if (r25 == null) goto L102;
        ((View.OnClickListener) r24).onClick(r25.primaryActionView);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
    L102:
        this.mIsResetLayout = true;
        return;
    L109:
        return;
    L42:
        if (r16 < ((ListAdapter) r12).getCount()) goto L44;
        return;
    L28:
        if ((r12 instanceof WrapperListAdapter) == false) goto L30;
        WrapperListAdapter r111 = (WrapperListAdapter) r12;
    L31:
        if (r111 == null) goto L33;
        r15 = r111.getWrappedAdapter();
    L34:
        if (r15 == null) goto L36;
    L33:
        r15 = null;
        goto L34
    L30:
        r111 = null;
        goto L31
    L22:
        r14 = null;
        goto L23
    L19:
        r2 = 0;
        goto L20
    L15:
        r0 = null;
    L6:
        QuickContactListView r26 = this.mListView;
        if (r26 == null) goto L9;
        ListAdapter r27 = r26.getAdapter();
    L10:
        if (r27 == null) goto L108;
        r12 = r27;
        goto L12
    L108:
        return;
    L9:
        r27 = null;
        goto L10
    }

    private final boolean phoneIsCdma() {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));     // Catch: RemoteException -> L9
        if (r0 == null) goto L14;
        if (r0.getActivePhoneType() != 2) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "phone.getActivePhoneType() failed", e);
        return false;
    }

    private final boolean isPhoneInUse() {
        if (getContext() != null) goto L5;
    L7:
        return false;
    L5:
        if (TelecomUtil.isInManagedCall(getContext()) == false) goto L7;
        return true;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return onOptionsItemSelected(r2);
    }

    private final void updateDialString(String r5) {
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L26;
        int r1 = r0.getSelectionStart();
        DigitsEditText r2 = this.mDigits;
        if (r2 == null) goto L27;
        int r3 = r2.getSelectionEnd();
        int r4 = Math.min(r1, r3);
        int r6 = Math.max(r1, r3);
        DigitsEditText r7 = this.mDigits;
        if (r7 == null) goto L9;
        Editable r8 = r7.getText();
    L11:
        if (r4 == (-1)) goto L20;
        if (r4 != r6) goto L15;
        if (r8 == null) goto L28;
        r8.replace(r4, r4, r5);
        return;
    L28:
        return;
    L15:
        if (r8 == null) goto L17;
        r8.replace(r4, r6, r5);
    L17:
        DigitsEditText r9 = this.mDigits;
        if (r9 == null) goto L30;
        r9.setSelection(r4 + 1);
        return;
    L30:
        return;
    L20:
        DigitsEditText r10 = this.mDigits;
        if (r10 == null) goto L32;
        int r11 = r10.length();
        if (r8 == null) goto L33;
        r8.replace(r11, r11, r5);
        return;
    L33:
        return;
    L32:
        return;
    L9:
        r8 = null;
        goto L11
    L27:
        return;
    }

    private final void updateDialAndDeleteButtonEnabledState() {
        boolean r0 = !isDigitsEmpty();
        OButton r1 = this.mDelete;
        if (r1 == null) goto L5;
        r1.setEnabled(r0);
    L5:
        View r2 = this.mDeleteClassic;
        if (r2 == null) goto L10;
        if (r2 == null) goto L11;
        r2.setEnabled(r0);
        return;
    L11:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void updateYellowPageState() {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        boolean r0 = isDigitsEmpty();
        OButton r1 = this.mBtnAddClassic;
        if (r1 == null) goto L36;
        Drawable r2 = null;
        String r3 = null;
        if (r0 == true) goto L26;
        if (r1 == null) goto L16;
        FragmentActivity r4 = this.mContext;
        if (r4 == null) goto L14;
        Drawable r5 = r4.getDrawable(com.android.contacts.R.drawable.o_dial_btn_add);
    L15:
        r1.setMIcon(r5);
        goto L16
    L14:
        r5 = null;
    L16:
        OButton r6 = this.mBtnAddClassic;
        if (r6 == null) goto L20;
        r6.setMImageTintColorId(0);
    L20:
        FrameLayout r7 = this.mBtnAddClassicContainer;
        if (r7 == null) goto L37;
        FragmentActivity r8 = this.mContext;
        if (r8 == null) goto L25;
        r3 = r8.getString(com.android.contacts.R.string.accessibility_dialpad_add);
    L25:
        r7.setContentDescription(r3);
        return;
    L37:
        return;
    L26:
        if (r1 == null) goto L32;
        FragmentActivity r9 = this.mContext;
        if (r9 == null) goto L31;
        r2 = r9.getDrawable(com.android.contacts.R.drawable.ic_dialpad_icon);
    L31:
        r1.setMIcon(r2);
    L32:
        FrameLayout r10 = this.mBtnAddClassicContainer;
        if (r10 == null) goto L39;
        r10.setContentDescription("");
        return;
    L39:
        return;
    }

    private final String getDialButtonLabel(int r5) {
        String r0 = DSUtils.getOperatorNameBySimSlotId(r5);
        String r1 = r0;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        Intrinsics.checkNotNullExpressionValue(r0, Utils.BUNDLE_TAG_OPERATOR);
        return r0;
    L12:
        FragmentActivity r4 = this.mContext;
        if (r4 == null) goto L15;
        String r6 = DSUtils.getSimName(r4, r5);
    L16:
        String r7 = r6;
        if (r7 != null) goto L19;
    L20:
        r2 = true;
    L21:
        if (r2 == true) goto L24;
        return r6;
    L24:
        return "SIM " + (r5 + 1);
    L19:
        if (r7.length() != 0) goto L21;
    L15:
        r6 = null;
        goto L16
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final void updateCallButtonState(int r10) {
        View r0 = this.mFragmentView;
        Drawable r1 = null;
        if (r0 == null) goto L5;
        OButton r2 = (OButton) r0.findViewById(com.android.contacts.R.id.call_classic);
    L6:
        View r3 = this.mFragmentView;
        if (r3 == null) goto L9;
        View r4 = r3.findViewById(com.android.contacts.R.id.dual_sim_call_buttons);
    L10:
        View r5 = this.mFragmentView;
        if (r5 == null) goto L13;
        DialButton r6 = (DialButton) r5.findViewById(com.android.contacts.R.id.call_sim1_button);
    L14:
        View r7 = this.mFragmentView;
        if (r7 == null) goto L17;
        DialButton r8 = (DialButton) r7.findViewById(com.android.contacts.R.id.call_sim2_button);
    L18:
        if (r2 == null) goto L50;
        if (r4 != null) goto L22;
        return;
    L22:
        if (r10 == (-1)) goto L24;
    L26:
        boolean r9 = false;
    L27:
        updateSideActionContainerLayout(r9);
        if (r9 == false) goto L34;
        r2.setVisibility(8);
        r4.setVisibility(0);
        if (r6 == null) goto L32;
        r6.setText(getDialButtonLabel(0));
    L32:
        if (r8 == null) goto L51;
        r8.setText(getDialButtonLabel(1));
        return;
    L51:
        return;
    L34:
        r2.setVisibility(0);
        r4.setVisibility(8);
        if (DSUtils.useDSFeature() == false) goto L45;
        if (r10 == 0) goto L38;
        if (r10 != 1) goto L45;
    L38:
        FragmentActivity r11 = this.mContext;
        if (r11 == null) goto L44;
        if (r10 != 0) goto L42;
        int r12 = com.android.contacts.R.drawable.o_dial_btn_call_sim_1;
    L43:
        r1 = r11.getDrawable(r12);
        goto L44
    L42:
        r12 = com.android.contacts.R.drawable.o_dial_btn_call_sim_2;
    L44:
        r2.setMIcon(r1);
        return;
    L45:
        FragmentActivity r13 = this.mContext;
        if (r13 == null) goto L48;
        r1 = r13.getDrawable(com.android.contacts.R.drawable.o_dial_btn_call);
    L48:
        r2.setMIcon(r1);
        return;
    L24:
        if (DSUtils.useDSFeature() == false) goto L26;
        r9 = true;
        goto L27
    L50:
        return;
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final void applyFixedScaleDualSimCallButtonStyle(View r4) {
        View r1 = r4.findViewById(com.android.contacts.R.id.dual_sim_call_buttons);
        if (r1 == null) goto L10;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L10;
        r2.height = fixedScaleDp(40.0f);
        View r0 = r4.findViewById(com.android.contacts.R.id.dual_sim_call_buttons);
        if (r0 == null) goto L10;
        r0.setLayoutParams(r2);
    L10:
        DialButton r3 = (DialButton) r4.findViewById(com.android.contacts.R.id.call_sim1_button);
        if (r3 == null) goto L13;
        applyFixedScaleSimCallButton(r3, 0.0f, DUAL_SIM_CALL_BUTTON_MARGIN_DP);
    L13:
        DialButton r5 = (DialButton) r4.findViewById(com.android.contacts.R.id.call_sim2_button);
        if (r5 == null) goto L17;
        applyFixedScaleSimCallButton(r5, DUAL_SIM_CALL_BUTTON_MARGIN_DP, 0.0f);
        return;
    }

    private final void applyFixedScaleSimCallButton(DialButton r4, float r5, float r6) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if ((r0 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setMarginStart(fixedScaleDp(r5));
        r1.setMarginEnd(fixedScaleDp(r6));
        r4.setLayoutParams(r1);
        int r7 = fixedScaleDp(16.0f);
        r4.setPadding(r7, 0, r7, 0);
        r4.setCompoundDrawablePadding(fixedScaleDp(6.0f));
        r4.setTextSize(0, fixedScaleDpFloat(14.0f));
        int r3 = fixedScaleDp(DUAL_SIM_CALL_BUTTON_ICON_SIZE_DP);
        Drawable[] r8 = r4.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(r8, "compoundDrawablesRelative");
        Drawable[] r9 = r8;
        int r2 = r9.length;
        int r10 = 0;
    L9:
        if (r10 >= r2) goto L14;
        Drawable r11 = r9[r10];
        if (r11 == null) goto L13;
        r11.setBounds(0, 0, r3, r3);
    L13:
        r10 = r10 + 1;
        goto L9
    L14:
        r4.setCompoundDrawablesRelative(r4.getCompoundDrawablesRelative()[0], r4.getCompoundDrawablesRelative()[1], r4.getCompoundDrawablesRelative()[2], r4.getCompoundDrawablesRelative()[3]);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final int fixedScaleDp(float r1) {
        return MathKt.roundToInt(fixedScaleDpFloat(r1));
    }

    private final float fixedScaleDpFloat(float r1) {
        return r1 * getStableDensity();
    }

    private final float getStableDensity() {
        return SystemProperties.getInt("ro.sf.lcd_density", getResources().getDisplayMetrics().densityDpi) / 160.0f;
    }

    private final void updateSideActionContainerLayout(boolean r4) {
        View r0 = this.mFragmentView;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(com.android.contacts.R.id.add_classic_container);
    L6:
        updateDialActionContainerLayout(r2, r4, true);
        View r3 = this.mFragmentView;
        if (r3 == null) goto L9;
        r1 = r3.findViewById(com.android.contacts.R.id.delete_classic_container);
    L9:
        updateDialActionContainerLayout(r1, r4, false);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void updateDialActionContainerLayout(View r6, boolean r7, boolean r8) {
        TableRow.LayoutParams r0 = null;
        if (r6 == null) goto L5;
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
    L7:
        if ((r1 instanceof TableRow.LayoutParams) == false) goto L9;
        r0 = (TableRow.LayoutParams) r1;
    L9:
        if (r0 != null) goto L12;
        return;
    L12:
        if (r7 == false) goto L14;
        r0.width = -2;
        r0.weight = 0.0f;
        r0.setMarginStart(0);
        r0.setMarginEnd(0);
        applyFixedScaleDialActionButton(r6);
    L23:
        r6.setLayoutParams(r0);
        return;
    L14:
        r0.width = 0;
        r0.weight = 1.0f;
        if (r8 == false) goto L17;
        int r9 = ContactsUtils.dipTopx(getContext(), 24.0d);
    L18:
        r0.setMarginStart(r9);
        if (r8 == false) goto L21;
        int r10 = ContactsUtils.dipTopx(getContext(), 4.0d);
    L22:
        r0.setMarginEnd(r10);
        applySystemScaleDialActionButton(r6);
        goto L23
    L21:
        r10 = ContactsUtils.dipTopx(getContext(), 24.0d);
        goto L22
    L17:
        r9 = ContactsUtils.dipTopx(getContext(), 4.0d);
        goto L18
    L5:
        r1 = null;
        goto L7
    }

    private final void applyFixedScaleDialActionButton(View r3) {
        applyDialActionButtonSize(r3, fixedScaleDp(64.0f), fixedScaleDp(2.0f));
    }

    private final void applySystemScaleDialActionButton(View r3) {
        applyDialActionButtonSize(r3, systemScaleDp(64.0f), systemScaleDp(2.0f));
    }

    private final void applyDialActionButtonSize(View r2, int r3, int r4) {
        View r0 = null;
        if ((r2 instanceof ViewGroup) == false) goto L5;
        ViewGroup r5 = (ViewGroup) r2;
    L6:
        if (r5 == null) goto L8;
        r0 = r5.getChildAt(0);
    L8:
        if (r0 != null) goto L10;
        return;
    L10:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = r3;
        r1.height = r3;
        r0.setLayoutParams(r1);
        r0.setPadding(r4, r4, r4, r4);
        return;
    L5:
        r5 = null;
        goto L6
    }

    private final int systemScaleDp(float r1) {
        return MathKt.roundToInt(r1 * getResources().getDisplayMetrics().density);
    }

    private final void queryNumberAttribution(String r4) {
        Regex r0 = new Regex("[^0-9]");
        String r5 = r0.replace(r4, "");
        if (r5.length() >= 7) goto L10;
        TextView r6 = this.mDigitsAttribution;
        if (r6 == null) goto L8;
        r6.setText("");
    L8:
        this.mLastShownAttrNumber = "";
        return;
    L10:
        NewDialpadFragment$queryNumberAttribution$listener$1 r1 = new NewDialpadFragment$queryNumberAttribution$listener$1(this, r5);
        NumberInfosManager.getInstance().getBaseAndMarkInfosAsync(r5, r1);
    }

    private final void updateSimSwitchViewState(boolean r6) {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        View r0 = this.mFragmentView;
        View r1 = null;
        if (r0 == null) goto L8;
        View r2 = r0.findViewById(com.android.contacts.R.id.sim_switch_container);
    L9:
        View r3 = this.mFragmentView;
        if (r3 == null) goto L12;
        View r4 = r3.findViewById(com.android.contacts.R.id.switch_sim);
    L13:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.android.contacts.widget.SimSwitchView");
        final SimSwitchView r5 = (SimSwitchView) r4;
        if (r2 == null) goto L16;
        r2.setOnClickListener(new NewDialpadFragment$$ExternalSyntheticLambda17(r5));
    L16:
        View r7 = this.mFragmentView;
        if (r7 == null) goto L19;
        r1 = r7.findViewById(com.android.contacts.R.id.add_or_yellow_page_btn);
    L19:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r8 = (OButton) r1;
        r8.setOnClickListener(this);
        r8.setOnTouchListener(this);
        r8.setVisibility(8);
        if (getDefaultSimSlotId() != r5.getLastSystemSim()) goto L22;
        if (r6 == true) goto L22;
    L24:
        if (DSUtils.useDSFeature() == true) goto L26;
    L32:
        if (r2 == null) goto L35;
        r2.setVisibility(8);
    L35:
        updateCallButtonState(r5.getCurrentSim());
        return;
    L26:
        if (isDigitsEmpty() == true) goto L32;
        if (r5.getCurrentSim() == (-1)) goto L32;
        if (r2 == null) goto L35;
        r2.setVisibility(0);
    L22:
        r5.setLastSystemSim(getDefaultSimSlotId());
        r5.setCurrentSim(getDefaultSimSlotId());
        goto L24
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    private static final void updateSimSwitchViewState$lambda$41(SimSwitchView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "$ssv");
        r0.performClick();
    }

    private final boolean isDigitsEmpty() {
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L5;
        Editable r1 = r0.getText();
    L6:
        Editable r2 = r1;
        if (r2 != null) goto L9;
    L12:
        return true;
    L9:
        if (r2.length() == 0) goto L12;
        return false;
    L5:
        r1 = null;
        goto L6
    }

    private final void queryLastOutgoingCall() {
        this.mLastNumberDialed = "";
        CallLogAsync.GetLastOutgoingCallArgs r0 = new CallLogAsync.GetLastOutgoingCallArgs(getActivity(), new NewDialpadFragment$$ExternalSyntheticLambda12(this));
        this.mCallLog.getLastOutgoingCall(r0);
    }

    private static final void queryLastOutgoingCall$lambda$42(NewDialpadFragment r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "number");
        r1.mLastNumberDialed = r2;
        r1.updateDialAndDeleteButtonEnabledState();
    }

    private final Intent newFlashIntent() {
        Intent r2 = ContactsIntentUtils.newDialNumberIntent("");
        r2.putExtra(EXTRA_SEND_EMPTY_FLASH, true);
        Intrinsics.checkNotNullExpressionValue(r2, MemorySourceLinkType.INTENT);
        return r2;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r4) {
        if (this.mVisibilityChanged == r4) goto L53;
        T9Search r0 = this.sT9Search;
        if (r0 == null) goto L9;
        if (r0 == null) goto L9;
        r0.setRegisterContentObserverChange(r4);
    L9:
        if (r4 == true) goto L36;
        ExecutorService r1 = this.pool;
        if (r1 == null) goto L13;
        r1.shutdown();
    L13:
        QuickContactListView r2 = this.mListView;
        boolean r3 = true;
        if (r2 == null) goto L24;
        if (r2 != null) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L24;
        QuickContactListView r6 = this.mListView;
        if (r6 == null) goto L24;
        r6.hideQuickContact();
        goto L24
    L17:
        if (r2.isShowQuickContact() != true) goto L19;
        r5 = true;
    L24:
        DigitsEditText r7 = this.mDigits;
        if (r7 == null) goto L35;
        if (r7 != null) goto L28;
    L30:
        r3 = false;
    L31:
        if (r3 == false) goto L35;
        DigitsEditText r8 = this.mDigits;
        if (r8 == null) goto L35;
        r8.setCursorVisible(false);
        goto L35
    L28:
        if (r7.isCursorVisible() != true) goto L30;
    L35:
        dismissLongMenu();
    L37:
        if (r4 == false) goto L48;
        if (isResumed() == false) goto L48;
        refreshData();
        T9Search r9 = this.sT9Search;
        if (r9 == null) goto L48;
        if (r9 == null) goto L48;
        r9.refresh();     // Catch: InterruptedException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L48:
        if (this.mIsPcMode == false) goto L53;
        if (r4 == false) goto L53;
        if (ProductUtils.isSupportDialInExtDisplay() == true) goto L53;
        ContactsApplication.showToast(com.android.contacts.R.string.revone_dial_function, 0);
        goto L53
    L36:
        this.pool = Executors.newSingleThreadExecutor();
    L53:
        this.mVisibilityChanged = r4;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "arg0");
        if (this.isT9on == false) goto L5;
    L7:
        QuickContactListView r0 = this.mListView;
        ListAdapter r1 = null;
        if (r0 == null) goto L10;
        ListAdapter r2 = r0.getAdapter();
    L12:
        if ((r2 instanceof T9Search.T9Adapter) == false) goto L17;
        QuickContactListView r5 = this.mListView;
        if (r5 == null) goto L16;
        r1 = r5.getAdapter();
    L16:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.android.contacts.dialpad.T9Search.T9Adapter");
        ((T9Search.T9Adapter) r1).setListViewScrollState(r4);
    L17:
        if (r4 != 0) goto L22;
        ContactPhotoManager r6 = this.mPhotoLoader;
        if (r6 == null) goto L21;
        r6.resume();
    L21:
        ContactDetailCacheManager.getInstance().refreshCache(r3);
        return;
    L22:
        ContactPhotoManager r7 = this.mPhotoLoader;
        if (r7 == null) goto L27;
        r7.pause();
        return;
    L27:
        return;
    L10:
        r2 = null;
        goto L12
    L5:
        if (r4 != 1) goto L7;
        disappearDialpad();
        goto L7
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r21, MotionEvent r22) {
        Intrinsics.checkNotNullParameter(r21, "arg0");
        Intrinsics.checkNotNullParameter(r22, "event");
        int r3 = r22.getActionMasked();
        int r4 = r22.getPointerId(r22.getActionIndex());
        float r5 = r22.getX(r22.getActionIndex());
        float r6 = r22.getY(r22.getActionIndex());
        if (r3 == 0) goto L62;
        if (r3 == 1) goto L35;
        if (r3 == 2) goto L25;
        if (r3 == 3) goto L10;
        if (r3 == 5) goto L62;
        if (r3 == 6) goto L35;
    L105:
        return false;
    L10:
        this.keyStates.clear();
        if (this.mLongClickHandler.hasMessages(0) == false) goto L14;
        this.mLongClickHandler.removeMessages(0);
    L14:
        if (this.mLongClickHandler.hasMessages(2) == false) goto L17;
        this.mLongClickHandler.removeMessages(2);
    L17:
        if (this.mLongClickHandler.hasMessages(1) == false) goto L20;
        this.mLongClickHandler.removeMessages(1);
    L20:
        if (this.mLongClickHandler.hasMessages(3) == false) goto L23;
        this.mLongClickHandler.removeMessages(3);
    L23:
        if (this.mLongClickHandler.hasMessages(4) == false) goto L105;
        this.mLongClickHandler.removeMessages(4);
        goto L105
    L25:
        int r7 = r22.getPointerCount();
        int r8 = 0;
    L26:
        if (r8 >= r7) goto L105;
        int r9 = r22.getPointerId(r8);
        float r10 = r22.getX(r8);
        float r11 = r22.getY(r8);
        KeyState r12 = this.keyStates.get(Integer.valueOf(r9));
        if (r12 == null) goto L34;
        if (r12.getCancelled() == true) goto L34;
        if (Companion.access$assertPointInView(Companion, r10, r11, r21) == true) goto L34;
        r12.setCancelled(true);
    L34:
        r8 = r8 + 1;
    L35:
        KeyState r1 = this.keyStates.get(Integer.valueOf(r4));
        if (r1 == null) goto L47;
        if (r1.getCancelled() == false) goto L40;
    L45:
        KeyState r2 = this.keyStates.remove(Integer.valueOf(r4));
        goto L47
    L40:
        if (r1.getPlayTone() <= (-1)) goto L43;
        playTone(r1.getPlayTone());
    L43:
        if (r1.getKeyCode() <= (-1)) goto L45;
        keyPressed(r1.getKeyCode());
    L47:
        if (this.mLongClickHandler.hasMessages(0) == false) goto L50;
        this.mLongClickHandler.removeMessages(0);
    L50:
        if (this.mLongClickHandler.hasMessages(2) == false) goto L53;
        this.mLongClickHandler.removeMessages(2);
    L53:
        if (this.mLongClickHandler.hasMessages(1) == false) goto L56;
        this.mLongClickHandler.removeMessages(1);
    L56:
        if (this.mLongClickHandler.hasMessages(3) == false) goto L59;
        this.mLongClickHandler.removeMessages(3);
    L59:
        if (this.mLongClickHandler.hasMessages(4) == false) goto L105;
        this.mLongClickHandler.removeMessages(4);
    L62:
        if (this.isT9on == false) goto L66;
        showDialpad();
        return false;
    L66:
        if (Companion.access$assertPointInView(Companion, r5, r6, r21) == true) goto L69;
        return false;
    L69:
        if (r21.getId() != com.android.contacts.R.id.delete_classic_container) goto L71;
    L106:
        showVibrator();
        return false;
    L71:
        if (r21.getId() == com.android.contacts.R.id.call_classic_container) goto L106;
        switch(r21.getId()) {
            case 2131362587: goto L87;
            case 2131362655: goto L86;
            case 2131362685: goto L85;
            case 2131363151: goto L84;
            case 2131363223: goto L83;
            case 2131363311: goto L82;
            case 2131363574: goto L81;
            case 2131363604: goto L80;
            case 2131363648: goto L79;
            case 2131363790: goto L78;
            case 2131363913: goto L77;
            case 2131364006: goto L76;
            default: goto L75;
        };
    L75:
        return false;
    L76:
        Pair r13 = new Pair(0, 7);
    L88:
        int r16 = ((Number) r13.component1()).intValue();
        int r15 = ((Number) r13.component2()).intValue();
        this.keyStates.put(Integer.valueOf(r4), new KeyState(r15, r16, false, 4, null));
        switch(r21.getId()) {
            case 2131362587: goto L103;
            case 2131362655: goto L103;
            case 2131362685: goto L103;
            case 2131363151: goto L103;
            case 2131363223: goto L95;
            case 2131363311: goto L93;
            case 2131363574: goto L103;
            case 2131363604: goto L103;
            case 2131363648: goto L92;
            case 2131363790: goto L103;
            case 2131363913: goto L103;
            case 2131364006: goto L91;
            default: goto L104;
        };
    L91:
        this.mLongClickHandler.sendEmptyMessageDelayed(0, 500);
        goto L104
    L92:
        this.mLongClickHandler.sendEmptyMessageDelayed(1, 500);
        goto L104
    L93:
        this.mLongClickHandler.sendEmptyMessageDelayed(2, 500);
        goto L104
    L103:
        sendSpeedDialMessage(r21.getId());
    L104:
        showVibrator();
        goto L105
    L95:
        if (isDigitsEmpty() == true) goto L102;
        DigitsEditText r14 = this.mDigits;
        if (r14 == null) goto L99;
        Editable r17 = r14.getText();
    L101:
        if (TextUtils.equals(r17, "1") == false) goto L104;
    L99:
        r17 = null;
    L102:
        this.mLongClickHandler.sendEmptyMessageDelayed(3, 500);
        goto L104
    L77:
        r13 = new Pair(2, 9);
        goto L88
    L78:
        r13 = new Pair(3, 10);
        goto L88
    L79:
        r13 = new Pair(10, 17);
        goto L88
    L80:
        r13 = new Pair(6, 13);
        goto L88
    L81:
        r13 = new Pair(7, 14);
        goto L88
    L82:
        r13 = new Pair(11, 18);
        goto L88
    L83:
        r13 = new Pair(1, 8);
        goto L88
    L84:
        r13 = new Pair(9, 16);
        goto L88
    L85:
        r13 = new Pair(4, 11);
        goto L88
    L86:
        r13 = new Pair(5, 12);
        goto L88
    L87:
        r13 = new Pair(8, 15);
        goto L88
    }

    private final void sendSpeedDialMessage(int r4) {
        if (ContactsUtils.FEATURE_CMCC == true) goto L6;
        return;
    L6:
        switch(r4) {
            case 2131362584: goto L15;
            case 2131362585: goto L15;
            case 2131362586: goto L15;
            case 2131362587: goto L15;
            case 2131362653: goto L14;
            case 2131362654: goto L14;
            case 2131362655: goto L14;
            case 2131362682: goto L13;
            case 2131362683: goto L13;
            case 2131362684: goto L13;
            case 2131362685: goto L13;
            case 2131363149: goto L12;
            case 2131363150: goto L12;
            case 2131363151: goto L12;
            case 2131363572: goto L11;
            case 2131363573: goto L11;
            case 2131363574: goto L11;
            case 2131363602: goto L10;
            case 2131363603: goto L10;
            case 2131363604: goto L10;
            case 2131363788: goto L9;
            case 2131363789: goto L9;
            case 2131363790: goto L9;
            case 2131363911: goto L8;
            case 2131363912: goto L8;
            case 2131363913: goto L8;
            default: goto L7;
        };
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid click for speed dial.");
        int r5 = -1;
    L17:
        if (isDigitsEmpty() == true) goto L24;
        DigitsEditText r1 = this.mDigits;
        if (r1 == null) goto L21;
        Editable r2 = r1.getText();
    L23:
        if (TextUtils.equals(r2, String.valueOf(r5)) == true) goto L24;
        return;
    L21:
        r2 = null;
    L24:
        Message r0 = this.mLongClickHandler.obtainMessage(4);
        Intrinsics.checkNotNullExpressionValue(r0, "mLongClickHandler.obtain…ssage(MESSAGE_SPEED_DIAL)");
        r0.obj = Integer.valueOf(r5);
        this.mLongClickHandler.sendMessageDelayed(r0, 500);
        return;
    L8:
        r5 = 2;
        goto L17
    L9:
        r5 = 3;
        goto L17
    L10:
        r5 = 6;
        goto L17
    L11:
        r5 = 7;
        goto L17
    L12:
        r5 = 9;
        goto L17
    L13:
        r5 = 4;
        goto L17
    L14:
        r5 = 5;
        goto L17
    L15:
        r5 = 8;
        goto L17
    }

    private final void callSpeedNumber(int r2) {
        SpeedDialUtils.checkValidity(getActivity(), r2);
        String r0 = SpeedDialUtils.getPhoneNumber(getActivity(), r2);
        if (r0 != null) goto L5;
        showNoSpeedNumberDialog(r2);
        return;
    L5:
        dialClickedNumber(r0, true);
        this.mIsResetLayout = true;
    }

    private final void showNoSpeedNumberDialog(int r4) {
        Intent r0 = new Intent(getActivity(), SpeedDialSettingActivity.class);
        r0.putExtra(SpeedDialSettingActivity.EXTRA_NUMBER, r4);
        AnimationUtil.startActivityWithAnimExtra(getActivity(), r0, 1, 2);
    }

    public final boolean isDialpadShown() {
        return this.mIsShowDialpad;
    }

    static /* synthetic */ void updateBottomNavigationBarMaskBlurRadius$default(NewDialpadFragment r0, boolean r1, boolean r2, long r3, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        r0.updateBottomNavigationBarMaskBlurRadius(r1, r2, r3);
    }

    private final void updateBottomNavigationBarMaskBlurRadius(boolean r4, boolean r5, long r6) {
        FragmentActivity r0 = getActivity();
        if ((r0 instanceof DialtactsActivity) == false) goto L5;
        final DialtactsActivity r1 = (DialtactsActivity) r0;
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getCurrentItem() != 0) goto L12;
        if (r4 == false) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        float r2 = 0.0f;
    L16:
        if (r7 == false) goto L28;
        if (r5 == false) goto L28;
        ValueAnimator r8 = this.mBottomNavBlurAnimator;
        if (r8 == null) goto L21;
        r8.cancel();
    L21:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{8.0f, 0.0f});
        r9.setDuration(320);
        r9.setInterpolator(new DecelerateInterpolator());
        r9.addUpdateListener(new NewDialpadFragment$$ExternalSyntheticLambda18(r1));
        this.mBottomNavBlurAnimator = r9;
        if (r9 == null) goto L25;
        r9.setStartDelay(r6);
    L25:
        ValueAnimator r3 = this.mBottomNavBlurAnimator;
        if (r3 == null) goto L35;
        r3.start();
        return;
    L35:
        return;
    L28:
        ValueAnimator r10 = this.mBottomNavBlurAnimator;
        if (r10 == null) goto L31;
        r10.cancel();
    L31:
        OBottomNavigationBar r11 = r1.getMBottomNavigationBar();
        if (r11 == null) goto L37;
        r11.setMaskBlurRadius(r2);
        return;
    L37:
        return;
    L15:
        r2 = 8.0f;
    L12:
        r7 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private static final void updateBottomNavigationBarMaskBlurRadius$lambda$46$lambda$45(DialtactsActivity r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$dialtactsActivity");
        Intrinsics.checkNotNullParameter(r2, "animator");
        OBottomNavigationBar r3 = r1.getMBottomNavigationBar();
        if (r3 == null) goto L6;
        Object r4 = r2.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r3.setMaskBlurRadius(((Float) r4).floatValue());
        return;
    }

    public final void showDialpad() {
        if (this.mIsShowDialpad == false) goto L5;
        return;
    L5:
        this.mIsShowDialpad = true;
        updateBottomNavigationBarMaskBlurRadius(true, true, 50);
        this.isT9on = false;
        View r2 = this.mFragmentView;
        if ((r2 instanceof ViewGroup) == false) goto L8;
        ViewGroup r3 = (ViewGroup) r2;
    L9:
        View r4 = this.mClassicDialpad;
        final View r5 = this.mTouchpad;
        if (r3 == null) goto L16;
        if (r4 == null) goto L17;
        if (r5 == null) goto L18;
        ContactsTransitionKt.toggleDialpad(r3, r4, r5, true, new C01891(r5));
        r4.setVisibility(0);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void showDialpadWithTextDialog(final String r9) {
        Intrinsics.checkNotNullParameter(r9, "text");
        if (this.mIsShowDialpad == false) goto L6;
        showClipPopupWindow(r9);
        return;
    L6:
        this.mIsShowDialpad = true;
        updateBottomNavigationBarMaskBlurRadius$default(this, true, true, 0, 4, null);
        this.isT9on = false;
        View r2 = this.mFragmentView;
        if ((r2 instanceof ViewGroup) == false) goto L9;
        ViewGroup r3 = (ViewGroup) r2;
    L10:
        View r4 = this.mClassicDialpad;
        View r5 = this.mTouchpad;
        if (r3 == null) goto L17;
        if (r4 == null) goto L18;
        if (r5 == null) goto L19;
        ContactsTransitionKt.toggleDialpad(r3, r4, r5, true, new NewDialpadFragment$showDialpadWithTextDialog$onEnd$1(this, r9));
        r5.setVisibility(8);
        r4.setVisibility(0);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r3 = null;
        goto L10
    }

    private final void showClipPopupWindow(final String r10) {
        if (this.mContext != null) goto L6;
        this.mShowClipPopupWindowRunnable = new C01881(this, r10);
        return;
    L6:
        Editable r0 = null;
        this.mShowClipPopupWindowRunnable = null;
        DigitsEditText r1 = this.mDigits;
        if (r1 == null) goto L14;
        if (r1 == null) goto L11;
        r0 = r1.getText();
    L11:
        if (TextUtils.isEmpty(String.valueOf(r0)) == true) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "showClipPopupWindow: text is not empty");
        return;
    L14:
        final FragmentActivity r2 = getActivity();
        if (r2 != null) goto L17;
        return;
    L17:
        final ViewGroup r3 = (ViewGroup) r2.findViewById(R.id.content);
        DismissibleClickableView r4 = this.mDismissibleClickableView;
        if (r4 != null) goto L20;
        this.mDismissibleClickableView = new DismissibleClickableView(r2, null, 0, 6, null);
    L29:
        DismissibleClickableView r5 = this.mDismissibleClickableView;
        if (r5 == null) goto L35;
        ViewGroup r6 = this.mClassicDialpad;
        if (r6 != null) goto L34;
        r6 = r3;
    L34:
        r5.enableMaterialEffect(r6);
    L35:
        OUIFrameLayout r7 = this.mClassicDialpadContainer;
        if (r7 == null) goto L39;
        r7.post(new NewDialpadFragment$$ExternalSyntheticLambda9(this, r2, r3, r10));
        return;
    L39:
        return;
    L20:
        boolean r8 = false;
        if (r3 != null) goto L23;
    L25:
        if (r8 == true) goto L29;
        DismissibleClickableView r9 = this.mDismissibleClickableView;
        if (r9 == null) goto L29;
        r9.dismiss();
        goto L29
    L23:
        if (r3.indexOfChild(r4) != (-1)) goto L25;
        r8 = true;
        goto L25
    }

    private static final void showClipPopupWindow$lambda$47(final NewDialpadFragment r4, FragmentActivity r5, ViewGroup r6, final String r7) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$ctx");
        Intrinsics.checkNotNullParameter(r7, "$text");
        OUIFrameLayout r0 = r4.mClassicDialpadContainer;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getLeft();
    L6:
        OUIFrameLayout r3 = r4.mClassicDialpadContainer;
        if (r3 == null) goto L9;
        int r8 = r3.getMeasuredWidth();
    L10:
        int r9 = r2 + (r8 / 2);
        int[] r10 = new int[2];
        OUIFrameLayout r11 = r4.mClassicDialpadContainer;
        if (r11 == null) goto L13;
        r11.getLocationOnScreen(r10);
    L13:
        Integer r12 = ArraysKt.getOrNull(r10, 1);
        if (r12 == null) goto L16;
        r1 = r12.intValue();
    L16:
        int r13 = r1 - ContactsUtils.dipTopx(r5, 5.0d);
        DismissibleClickableView r14 = r4.mDismissibleClickableView;
        if (r14 == null) goto L19;
        r14.setViewPosition(r9, r13);
    L19:
        if (r6 == null) goto L21;
        r6.addView(r4.mDismissibleClickableView);
    L21:
        DismissibleClickableView r15 = r4.mDismissibleClickableView;
        if (r15 == null) goto L24;
        r15.setShowText(r7);
    L24:
        DismissibleClickableView r16 = r4.mDismissibleClickableView;
        if (r16 == null) goto L28;
        r16.setViewClickAction(new NewDialpadFragment$showClipPopupWindow$2$1(r4, r7));
        return;
    L28:
        return;
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void dismissClipPopupWindow() {
        DismissibleClickableView r0 = this.mDismissibleClickableView;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.dismiss();
        return;
    L8:
        return;
    }

    @Override // com.android.contacts.AbstractFragment, com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r3, View r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "menuType");
        QuickContactListView r2 = this.mListView;
        if (r2 == null) goto L5;
        ListAdapter r6 = r2.getAdapter();
    L6:
        ListAdapter r7 = r6;
        if ((r7 instanceof T9Search.T9Adapter) == true) goto L9;
    L20:
        return false;
    L9:
        if ((r5 instanceof ContactItem) == false) goto L20;
        int r8 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r8 != 1) goto L14;
        ((T9Search.T9Adapter) r7).doRemoveCallLog((ContactItem) r5);
        return true;
    L14:
        if (r8 == 2) goto L16;
        return false;
    L16:
        ((T9Search.T9Adapter) r7).numberIntoBlackList((ContactItem) r5);
        return true;
    L5:
        r6 = null;
        goto L6
    }

    private final void showDialpadWithOutAnimation() {
        if (this.mIsShowDialpad == false) goto L5;
        return;
    L5:
        resetDialpad(this.mDialpad);
        resetDialpad(this.mClassicDialpad);
    }

    private final void resetDialpad(View r9) {
        View r0 = this.mFragmentView;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        TransitionManager.endTransitions((ViewGroup) r0);
    L6:
        if (r9 == null) goto L8;
        r9.setVisibility(0);
    L8:
        this.mIsShowDialpad = true;
        updateBottomNavigationBarMaskBlurRadius$default(this, true, true, 0, 4, null);
        this.isT9on = false;
    }

    public final void disappearDialpad() {
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L5;
        r0.setCursorVisible(false);
    L5:
        this.keyStates.clear();
        if (this.mIsShowDialpad == true) goto L8;
        return;
    L8:
        this.isT9on = true;
        this.mIsShowDialpad = false;
        updateBottomNavigationBarMaskBlurRadius$default(this, false, false, 0, 6, null);
        View r1 = this.mFragmentView;
        if ((r1 instanceof ViewGroup) == false) goto L11;
        ViewGroup r2 = (ViewGroup) r1;
    L12:
        View r3 = this.mClassicDialpad;
        View r9 = this.mTouchpad;
        if (r2 == null) goto L19;
        if (r9 == null) goto L20;
        if (r3 == null) goto L21;
        ContactsTransitionKt.toggleDialpad(r2, r3, null, false, null);
        r9.setVisibility(0);
        r3.setVisibility(8);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r2 = null;
        goto L12
    }

    @Override // com.android.contacts.calllog.CallLogAdapter.CallFetcher
    public void fetchCalls() {
        RecommendDataLoader r1 = this.mRecommendDataLoader;
        if (r1 == null) goto L6;
        r1.loadRecommendData(true);
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r3, boolean r4) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r3 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r3;
        if (r3 == false) goto L10;
        if (r4 == false) goto L11;
        refreshData();
        return;
    L11:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ReleaseResourceListener
    public void release() {
        if (this.mVisibilityChanged == true) goto L17;
        DigitsEditText r0 = this.mDigits;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L18;
        T9Search.T9Adapter r2 = this.mT9Adapter;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r2 == null) goto L15;
        r2.setItems(null);
    L15:
        this.mT9Adapter = null;
        return;
    L18:
        return;
    L7:
        if (r0.length() != 0) goto L9;
        r1 = true;
        goto L9
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        QuickContactListView r0 = this.mListView;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L17;
        QuickContactListView r3 = this.mListView;
        if (r3 == null) goto L15;
        r3.hideQuickContact();
    L15:
        return false;
    L17:
        return true;
    L7:
        if (r0.isShowQuickContact() != true) goto L9;
        r1 = true;
        goto L10
    }

    private final int getDefaultSimSlotId() {
        return DSUtils.getDefaultCallSim();
    }

    @Override // com.android.contacts.DSUtils.DSFatureStatusListener
    public void onDSFeatureStatusChanged() {
        updateDialpadMode();
        updateSimSwitchViewState(false);
        updateYellowPageState();
        FlowAdapter r1 = this.mAdapter;
        if (r1 == null) goto L7;
        if (r1 == null) goto L8;
        r1.notifyDataSetChanged();
        return;
    L8:
        return;
    }

    private final void traversalChildAndSetDelegateIfNecessary(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if ((r4 instanceof ViewGroup) == false) goto L15;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L16;
        View r2 = r5.getChildAt(r1);
        if (r2 == null) goto L10;
        assertAccessInfoDelegateSet(r2);
        traversalChildAndSetDelegateIfNecessary(r2);
    L10:
        r1 = r1 + 1;
        goto L6
    L16:
        return;
    }

    private final void assertAccessInfoDelegateSet(View r1) {
        switch(r1.getId()) {
            case 2131362584: goto L5;
            case 2131362585: goto L5;
            case 2131362586: goto L5;
            case 2131362587: goto L5;
            case 2131362653: goto L5;
            case 2131362654: goto L5;
            case 2131362655: goto L5;
            case 2131362682: goto L5;
            case 2131362683: goto L5;
            case 2131362684: goto L5;
            case 2131362685: goto L5;
            case 2131363149: goto L5;
            case 2131363150: goto L5;
            case 2131363151: goto L5;
            case 2131363221: goto L5;
            case 2131363222: goto L5;
            case 2131363223: goto L5;
            case 2131363310: goto L5;
            case 2131363311: goto L5;
            case 2131363572: goto L5;
            case 2131363573: goto L5;
            case 2131363574: goto L5;
            case 2131363602: goto L5;
            case 2131363603: goto L5;
            case 2131363604: goto L5;
            case 2131363647: goto L5;
            case 2131363648: goto L5;
            case 2131363788: goto L5;
            case 2131363789: goto L5;
            case 2131363790: goto L5;
            case 2131363911: goto L5;
            case 2131363912: goto L5;
            case 2131363913: goto L5;
            case 2131364004: goto L5;
            case 2131364005: goto L5;
            case 2131364006: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        OreoApiUtils.setViewAccessbilityDelegateForTouch(r1);
    }

    public final void showVibrator() {
        if (this.mIsPcMode == true) goto L6;
        VibratorHelper.INSTANCE.dial(this.mContext);
        return;
    }

    private final void tryToShowOpenCallSummaryView() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "try to show open call summary view start");
        if (OpenCallSummaryGuideFlavorDelegate.INSTANCE.shouldHideOpenCallSummaryGuide() == false) goto L13;
        View r9 = this.mOpenCallSummaryView;
        if (r9 == null) goto L11;
        r9.setVisibility(8);
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "hide open call summary view for current region");
        return;
    L13:
        SharedPreferences r3 = this.mPrefs;
        boolean r6 = true;
        if (r3 == null) goto L16;
        boolean r4 = r3.getBoolean("should_show_tutorial_popup", true);
    L18:
        if (r4 == true) goto L20;
    L29:
        if (r4 == false) goto L31;
        ensureOpenCallSummaryView();
    L31:
        View r1 = this.mOpenCallSummaryView;
        if (r1 != null) goto L34;
    L36:
        r6 = false;
    L37:
        if (r4 == false) goto L43;
        if (r6 == true) goto L43;
        View r10 = this.mOpenCallSummaryView;
        if (r10 == null) goto L49;
        r10.setVisibility(0);
    L49:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "try to show open call summary view start");
        return;
    L43:
        if (r4 == true) goto L49;
        if (r6 == false) goto L49;
        View r11 = this.mOpenCallSummaryView;
        if (r11 == null) goto L49;
        r11.setVisibility(8);
        goto L49
    L34:
        if (r1.getVisibility() != 0) goto L36;
    L20:
        if (SettingsProviderHelper.INSTANCE.isAutoIntelligentEnabled(r0, false) == false) goto L29;
        SharedPreferences r2 = this.mPrefs;
        if (r2 == null) goto L28;
        SharedPreferences.Editor r5 = r2.edit();
        if (r5 == null) goto L28;
        SharedPreferences.Editor r7 = r5.putBoolean("should_show_tutorial_popup", false);
        if (r7 == null) goto L28;
        r7.commit();
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Change SP_KEY_SHOULD_SHOW_TUTORIAL_POPUP to false");
        r4 = false;
        goto L29
    L16:
        r4 = true;
        goto L18
    }

    static {
        Companion = new Companion(null);
        sT9ContactMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_STAR};
        sT9CalllogMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        DEBUG = ContactsUtils.DEBUG;
        DIAL_TONE_STREAM_TYPE = 1;
        TEN_MINUTES = 600000;
    }
}
