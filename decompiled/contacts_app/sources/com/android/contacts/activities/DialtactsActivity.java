package com.android.contacts.activities;

import android.app.assist.AssistContent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.GlobalProxyLancet;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.ReflectUtils;
import com.android.contacts.WarnNotDefaultDialerAppActivity;
import com.android.contacts.calllog.NewCallLogFragment;
import com.android.contacts.calllog.v2.CallLogV2Fragment;
import com.android.contacts.common.list.ContactListFilterController;
import com.android.contacts.dialpad.NewDialpadFragment;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.NewContactListFragment;
import com.android.contacts.list.NewPhoneFavoriteFragment;
import com.android.contacts.list.PhoneFavoriteFragment;
import com.android.contacts.list.ProviderStatusLoader;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.AsyncImageLoader;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.DialogManager;
import com.android.contacts.util.ImportantResource;
import com.android.contacts.util.NumberLocationUpdaterService;
import com.android.contacts.util.ThemeUtils;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.ProgressDialog;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.contactsdk.loader.CallHistoryEntityUtilKt;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.matrix.platform.sdk.ones.appupdate.MatrixAppUpdateManager;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactsAppLaunchEvent;
import com.obric.utils.ClipboardReader;
import com.obric.utils.views.ObricBottomDeleteBarView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.api.ContactsContractSmt;
import obric.app.tracker.Agent;
import obric.widget.calendar.MonthWeekEventsView;
import org.json.JSONArray;

/* JADX INFO: compiled from: DialtactsActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b1\u0018\u0000 ä\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0010ä\u0001å\u0001æ\u0001ç\u0001è\u0001é\u0001ê\u0001ë\u0001B\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020P2\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0002J\u0011\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\tJ\n\u0010\u0089\u0001\u001a\u00030\u0087\u0001H\u0002J\u001e\u0010\u008a\u0001\u001a\u00020u2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010\u0088\u0001\u001a\u00020\tH\u0002J\u0013\u0010\u008d\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u008e\u0001\u001a\u00020BH\u0004J\u0014\u0010\u008f\u0001\u001a\u00030\u0087\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\u001d\u0010\u0092\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0M2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0002J\u001d\u0010\u0095\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120M2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0002J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u0014\u0010\u0098\u0001\u001a\u0004\u0018\u00010P2\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0002J\n\u0010\u0099\u0001\u001a\u00030\u0087\u0001H\u0002J\b\u0010\u009a\u0001\u001a\u00030\u0087\u0001J\b\u0010\u009b\u0001\u001a\u00030\u0087\u0001J\n\u0010\u009c\u0001\u001a\u00030\u0087\u0001H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020\u001e2\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0004J\u001c\u0010\u009e\u0001\u001a\u00020\u001e2\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001eH\u0004J\n\u0010 \u0001\u001a\u00030\u0087\u0001H\u0002J\t\u0010¡\u0001\u001a\u00020\u001eH\u0002J\b\u0010¢\u0001\u001a\u00030\u0087\u0001J(\u0010£\u0001\u001a\u00030\u0087\u00012\u0007\u0010¤\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\t2\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0014J\u0013\u0010§\u0001\u001a\u00030\u0087\u00012\u0007\u0010¨\u0001\u001a\u00020PH\u0016J\n\u0010©\u0001\u001a\u00030\u0087\u0001H\u0016J)\u0010ª\u0001\u001a\u00030\u0087\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010¬\u0001\u001a\u00020\u001e2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010®\u0001\u001a\u00030\u0087\u0001H\u0016J\u0016\u0010¯\u0001\u001a\u00030\u0087\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0014J\n\u0010²\u0001\u001a\u00030\u0087\u0001H\u0016J\u0013\u0010³\u0001\u001a\u00030\u0087\u00012\u0007\u0010´\u0001\u001a\u00020\tH\u0016J\u0014\u0010µ\u0001\u001a\u00030\u0087\u00012\b\u0010¶\u0001\u001a\u00030\u0091\u0001H\u0016J\u0016\u0010·\u0001\u001a\u00030\u0087\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J\n\u0010¸\u0001\u001a\u00030\u0087\u0001H\u0014J\u0014\u0010¹\u0001\u001a\u00030\u0087\u00012\b\u0010º\u0001\u001a\u00030»\u0001H\u0016J\n\u0010¼\u0001\u001a\u00030\u0087\u0001H\u0016J\n\u0010½\u0001\u001a\u00030\u0087\u0001H\u0014J\u0014\u0010¾\u0001\u001a\u00030\u0087\u00012\b\u0010¿\u0001\u001a\u00030\u0091\u0001H\u0016J\n\u0010À\u0001\u001a\u00030\u0087\u0001H\u0014J\u0013\u0010Á\u0001\u001a\u00030\u0087\u00012\u0007\u0010´\u0001\u001a\u00020\tH\u0016J\n\u0010Â\u0001\u001a\u00030\u0087\u0001H\u0014J\u0013\u0010Ã\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ä\u0001\u001a\u00020\u001eH\u0016J\n\u0010Å\u0001\u001a\u00030\u0087\u0001H\u0002J\u0012\u0010Æ\u0001\u001a\u00030\u0087\u00012\b\u0010º\u0001\u001a\u00030»\u0001J\n\u0010Ç\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010È\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010É\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0087\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ì\u0001\u001a\u00020\tH\u0002J\u001a\u0010Í\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010Î\u0001\u001a\u00020\u001eJ\u001c\u0010Ï\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ì\u0001\u001a\u00020\t2\u0007\u0010Ð\u0001\u001a\u00020\u001eH\u0004J\u0012\u0010Ñ\u0001\u001a\u00030\u0087\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001J\u0013\u0010Ò\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\tH\u0002J\u0011\u0010Ó\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ô\u0001\u001a\u00020\u001eJ\u0014\u0010Õ\u0001\u001a\u00030\u0087\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\u001c\u0010Ö\u0001\u001a\u00030\u0087\u00012\u0007\u0010×\u0001\u001a\u00020\t2\u0007\u0010Ø\u0001\u001a\u00020\u001eH\u0002J\n\u0010Ù\u0001\u001a\u00030\u0087\u0001H\u0002J\u0011\u0010Ú\u0001\u001a\u00030\u0087\u00012\u0007\u0010Û\u0001\u001a\u00020\u0012J)\u0010Ü\u0001\u001a\u00030\u0087\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010¤\u0001\u001a\u00020\t2\n\u0010Ý\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\u0011\u0010Þ\u0001\u001a\u00030\u0087\u00012\u0007\u0010Û\u0001\u001a\u00020\u0012J\n\u0010ß\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010à\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010á\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010â\u0001\u001a\u00030\u0087\u0001H\u0002J\u0013\u0010ã\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0096\u0001\u0010\u0017\u001a>\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u0011j$\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0016`\u00152B\u0010\u0010\u001a>\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u0011j$\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0016`\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000fR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020\r0MX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010P0OX\u0084\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010f\u001a\u0004\u0018\u00010gX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010x\u001a\u00020yX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0014\u0010~\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010\u001c¨\u0006ì\u0001"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity;", "Lcom/android/contacts/ContactsActivity;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/android/contacts/util/DialogManager$DialogShowingViewActivity;", "Lcom/android/contacts/common/list/ContactListFilterController$ContactListFilterListener;", "Lcom/android/contacts/list/ProviderStatusLoader$ProviderStatusListener;", "Lcom/obric/utils/ClipboardReader$ClipboardObserver;", "()V", "MESSAGE_DELAY_SEND", "", "MESSAGE_QUERY_CONTACT_BRIEF", "MESSAGE_SHOW_DIALOG_BY_DB_STATUS", "andClearFilterText", "", "getAndClearFilterText", "()Ljava/lang/String;", "<set-?>", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/android/contacts/activities/DialtactsActivity$DataItem;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "briefContactList", "getBriefContactList", "()Ljava/util/HashMap;", "currentItem", "getCurrentItem", "()I", "isShowGroup", "", "()Z", "setShowGroup", "(Z)V", "lastNetworkCountryIso", "getLastNetworkCountryIso", "mAllFragment", "Lcom/android/contacts/list/NewContactListFragment;", "mBottomDeleteBar", "Lcom/obric/utils/views/ObricBottomDeleteBarView;", "getMBottomDeleteBar", "()Lcom/obric/utils/views/ObricBottomDeleteBarView;", "setMBottomDeleteBar", "(Lcom/obric/utils/views/ObricBottomDeleteBarView;)V", "mBottomDeleteBarBtn", "Lcom/obric/oui/button/OButtonFloating;", "getMBottomDeleteBarBtn", "()Lcom/obric/oui/button/OButtonFloating;", "setMBottomDeleteBarBtn", "(Lcom/obric/oui/button/OButtonFloating;)V", "mBottomDeleteLayoutListener", "Lcom/android/contacts/list/BottomDeleteLayoutListener;", "mBottomNavigationBar", "Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "getMBottomNavigationBar", "()Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "setMBottomNavigationBar", "(Lcom/obric/oui/segmentedtab/OBottomNavigationBar;)V", "mBriefContactListObserver", "Landroid/database/ContentObserver;", "mCallLogObserver", "mCallLogV2Fragment", "Lcom/android/contacts/calllog/v2/CallLogV2Fragment;", "mClipboardReader", "Lcom/obric/utils/ClipboardReader;", "mCurrentPhotoFile", "Ljava/io/File;", "mDialpadFragment", "Lcom/android/contacts/dialpad/NewDialpadFragment;", "getMDialpadFragment", "()Lcom/android/contacts/dialpad/NewDialpadFragment;", "setMDialpadFragment", "(Lcom/android/contacts/dialpad/NewDialpadFragment;)V", "mDialpadListener", "Lcom/android/contacts/dialpad/NewDialpadFragment$Listener;", "mFilterText", "mForbiddenDescriptionTypes", "", "mFragments", "", "Landroidx/fragment/app/Fragment;", "getMFragments", "()[Landroidx/fragment/app/Fragment;", "setMFragments", "([Landroidx/fragment/app/Fragment;)V", "[Landroidx/fragment/app/Fragment;", "mFragmentsCallback", "Lcom/android/contacts/ContactFragmentsCallback;", "mHandler", "Landroid/os/Handler;", "mIsLaunchedByInCall", "mIsLaunchedByMagicFlow", "mIsTabEnabled", "mLinearLayout", "Landroid/widget/LinearLayout;", "[Landroid/widget/LinearLayout;", "mNewCallLogFragment", "Lcom/android/contacts/calllog/NewCallLogFragment;", "mPhoneFavoriteFragment", "Lcom/android/contacts/list/NewPhoneFavoriteFragment;", "mPhoneFavoriteListener", "Lcom/android/contacts/list/NewPhoneFavoriteFragment$Listener;", "mPrefs", "Landroid/content/SharedPreferences;", "getMPrefs", "()Landroid/content/SharedPreferences;", "setMPrefs", "(Landroid/content/SharedPreferences;)V", "mPrefsCallback", "Lcom/android/contacts/PreferencesCallback;", "mProgress", "Lcom/android/contacts/widget/ProgressDialog;", "mProviderStatus", "mProviderStatusLoader", "Lcom/android/contacts/list/ProviderStatusLoader;", "mRawContactIdForUpdatePhoto", "mStatusView", "Landroid/view/View;", "mTabIndexInPreference", "mVeilView", "mViewId", "", "getMViewId", "()[I", "setMViewId", "([I)V", "tabIndex", "getTabIndex", "bitmap2Bytes", "", "bm", "Landroid/graphics/Bitmap;", "buildFragmentByPosition", "position", "changeStatusBarColor", "", "color", "clickBottomDeleteBar", "createStatusView", "activity", "Landroidx/fragment/app/FragmentActivity;", "doCropPhoto", "f", "fixIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "getCallList", "listArray", "Lorg/json/JSONArray;", "getContactsList", "getDialogManager", "Lcom/android/contacts/util/DialogManager;", "getFragmentAt", "handleNumberLocationUpdater", "hideDialpad", "hideProgressDialog", "initStatusBar", "isDialIntent", "isSendKeyWhileInCall", "recentCallsRequest", "loadBriefContactList", "needMoveTaskToBack", "notifyDBDataChanged", "onActivityResult", "requestCode", "resultCode", "data", "onAttachFragment", "fragment", "onBackPressed", "onClipboardResult", Params.CONTENT, "isSuccess", "errMessage", "onContactListFilterChanged", "onCreate", "icicle", "Landroid/os/Bundle;", "onDestroy", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "onNewIntent", "newIntent", "onNewIntentWhenPrivacyNotOk", "onPause", "onProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "onProviderStatusChange", "onResume", "onServiceCompleted", ContactSaveService.EXTRA_CALLBACK_INTENT, "onStart", "onStatusBarHeightChanged", "onStop", "onWindowFocusChanged", "hasFocus", "pressedBack", "provideData", "queryBriefContactList", "queryProviderStatus", "registerObservers", "releaseUselessResource", "saveLastTabIndex", "index", "sendFragmentVisibilityChange", "visibility", "setCurrentItem", "isClick", "setCurrentTab", "setLeveralStatusBar", "setTabOnclickEnabled", "isTabEnabled", "setupFilterText", "showOrhideDialog", "status", "triggerLoad", "showProgressDialog", "startActivityForPickPhoto", ContactSaveService.EXTRA_RAW_CONTACT_ID, "startActivityForResult", "options", "startActivityForTakePhoto", "unregisterObservers", "updateClipboardReader", "updateFromIntentExtra", "updateNavigationBarTab", "updateTabClickEvent", "Companion", "DataItem", "OnDBDataChangeListener", "PageEnableListener", "ReleaseResourceListener", "UpdatePhotoTask", "ViewPagerVisibilityListener", "onBackPressListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialtactsActivity extends ContactsActivity implements View.OnCreateContextMenuListener, DialogManager.DialogShowingViewActivity, ContactListFilterController.ContactListFilterListener, ProviderStatusLoader.ProviderStatusListener, ClipboardReader.ClipboardObserver {
    private static final String ACTION_TOUCH_DIALER = "com.android.phone.action.TOUCH_DIALER";
    public static final String ADD_CONTACTS = "com.android.contacts.activities.action.ADD_CONTACTS";
    public static final String CALL_ORIGIN_DIALTACTS = "com.android.contacts.activities.DialtactsActivity";
    private static final String CALL_SETTINGS_CLASS_NAME = "com.android.phone.CallFeaturesSetting";
    public static final int CHANGEPHOTO = 99;
    public static final Companion Companion = null;
    private static final boolean DEBUG = false;
    private static final int DISPLAY_NAME_INDEX = 1;
    public static final String EXTRA_CALL_ORIGIN = "com.android.phone.CALL_ORIGIN";
    public static final String FREQUENT_CONTACTS = "com.android.contacts.activities.action.FREQUENT_CONTACTS";
    public static final String LAST_TAB_INDEX = "LAST_TAB_INDEX_V1";
    private static final int NUMBER_INDEX = 2;
    private static final String PHONE_PACKAGE = "com.android.phone";
    private static final int ROW_CONTACT_ID_INDEX = 0;
    public static final String SEARCH_CONTACTS = "com.android.contacts.activities.action.SEARCH_CONTACTS";
    private static final int SUBACTIVITY_EDIT_GROUP = 2;
    public static final int TAB_INDEX_ALL = 1;
    public static final int TAB_INDEX_CALL_LOG = 0;
    public static final int TAB_INDEX_COUNT = 3;
    public static final int TAB_INDEX_FAVORITES = 2;
    private static final String TAG = "DialtactsActivity";
    public static ContactsAppLaunchEvent sLaunchEvent;
    public static final Rect sSysGestureInsets = null;
    private final int MESSAGE_DELAY_SEND;
    private final int MESSAGE_QUERY_CONTACT_BRIEF;
    private final int MESSAGE_SHOW_DIALOG_BY_DB_STATUS;
    private HashMap<Long, ArrayList<DataItem>> briefContactList;
    private boolean isShowGroup;
    private NewContactListFragment mAllFragment;
    private ObricBottomDeleteBarView mBottomDeleteBar;
    private OButtonFloating mBottomDeleteBarBtn;
    private final BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private OBottomNavigationBar mBottomNavigationBar;
    private final ContentObserver mBriefContactListObserver;
    private ContentObserver mCallLogObserver;
    private CallLogV2Fragment mCallLogV2Fragment;
    private ClipboardReader mClipboardReader;
    private File mCurrentPhotoFile;
    private NewDialpadFragment mDialpadFragment;
    private final NewDialpadFragment.Listener mDialpadListener;
    private String mFilterText;
    private final List<String> mForbiddenDescriptionTypes;
    private Fragment[] mFragments;
    private final ContactFragmentsCallback mFragmentsCallback;
    private final Handler mHandler;
    private boolean mIsLaunchedByInCall;
    private boolean mIsLaunchedByMagicFlow;
    private boolean mIsTabEnabled;
    private final LinearLayout[] mLinearLayout;
    private NewCallLogFragment mNewCallLogFragment;
    private NewPhoneFavoriteFragment mPhoneFavoriteFragment;
    private final NewPhoneFavoriteFragment.Listener mPhoneFavoriteListener;
    private SharedPreferences mPrefs;
    private final PreferencesCallback mPrefsCallback;
    private ProgressDialog mProgress;
    private int mProviderStatus;
    private ProviderStatusLoader mProviderStatusLoader;
    private long mRawContactIdForUpdatePhoto;
    private View mStatusView;
    private int mTabIndexInPreference;
    private View mVeilView;
    private int[] mViewId;

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&J*\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$Companion;", "", "()V", "ACTION_TOUCH_DIALER", "", "ADD_CONTACTS", "CALL_ORIGIN_DIALTACTS", "CALL_SETTINGS_CLASS_NAME", "CHANGEPHOTO", "", "DEBUG", "", "getDEBUG", "()Z", "DISPLAY_NAME_INDEX", "EXTRA_CALL_ORIGIN", "FREQUENT_CONTACTS", "LAST_TAB_INDEX", "NUMBER_INDEX", "PHONE_PACKAGE", "ROW_CONTACT_ID_INDEX", "SEARCH_CONTACTS", "SUBACTIVITY_EDIT_GROUP", "TAB_INDEX_ALL", "TAB_INDEX_CALL_LOG", "TAB_INDEX_COUNT", "TAB_INDEX_FAVORITES", "TAG", "callSettingsIntent", "Landroid/content/Intent;", "getCallSettingsIntent", "()Landroid/content/Intent;", "sLaunchEvent", "Lcom/obric/tracker/event/ContactsAppLaunchEvent;", "sSysGestureInsets", "Landroid/graphics/Rect;", "isDefaultDialer", "context", "Landroid/content/Context;", "updateContactPhoto", "", "c", "Landroid/content/ContentResolver;", "bytes", "", ContactSaveService.EXTRA_RAW_CONTACT_ID, "", "Sync", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ void access$updateContactPhoto(Companion r0, ContentResolver r1, byte[] r2, long r3, boolean r5) {
            r0.updateContactPhoto(r1, r2, r3, r5);
        }

        protected final boolean getDEBUG() {
            return DialtactsActivity.access$getDEBUG$cp();
        }

        public final Intent getCallSettingsIntent() {
            Intent r2 = new Intent("android.intent.action.MAIN");
            r2.setClassName("com.android.phone", DialtactsActivity.CALL_SETTINGS_CLASS_NAME);
            r2.setFlags(67108864);
            return r2;
        }

        private final void updateContactPhoto(ContentResolver r9, byte[] r10, long r11, boolean r13) {
            if (ContactsContract.isProfileId(r11) == false) goto L5;
            Uri r8 = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
            Intrinsics.checkNotNullExpressionValue(r8, "withAppendedPath(Contact…file.CONTENT_URI, \"data\")");
        L6:
            Cursor r0 = null;
            Cursor r1 = r9.query(r8, null, "raw_contact_id = " + r11 + " AND mimetype = 'vnd.android.cursor.item/photo'", null, null);     // Catch: Throwable -> L25
            if (r1 != null) goto L29;
        L15:
            long r2 = -1;
        L16:
            if (r1 == null) goto L18;
            r1.close();
        L18:
            ContentValues r3 = new ContentValues();
            if (r2 < 0) goto L21;
            r3.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, r10);
            r3.put("is_super_primary", 1);
            r9.update(r8, r3, "_id = " + r2, null);
        L22:
            if (r13 == true) goto L33;
            Uri r12 = Uri.withAppendedPath(Uri.parse("content://com.android.contacts/raw_contacts"), String.valueOf(r11));
            Intrinsics.checkNotNullExpressionValue(r12, "withAppendedPath(\n      …tring()\n                )");
            ContentValues r14 = new ContentValues();
            r14.put("dirty", 0);
            r9.update(r12, r14, null, null);
            return;
        L33:
            return;
        L21:
            r3.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r11));
            r3.put("is_super_primary", 1);
            r3.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, r10);
            r3.put("mimetype", "vnd.android.cursor.item/photo");
            r9.insert(r8, r3);
            goto L22
        L29:
        L13:
            th = th;
            r0 = r1;
        L26:
            if (r0 == null) goto L28;
            r0.close();
        L28:
            throw th;
        L10:
            if (r1.moveToFirst() == false) goto L15;
            r2 = r1.getLong(r1.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L13
        L25:
            th = th;
            goto L26
        L5:
            r8 = ContactsContract.Data.CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(r8, "CONTENT_URI");
            goto L6
        }

        public final boolean isDefaultDialer(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Object r1 = r2.getSystemService("telecom");
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.telecom.TelecomManager");
            boolean r3 = !TextUtils.equals("com.obric.dialer.app", ((TelecomManager) r1).getDefaultDialerPackage());
            if (r3 == true) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(DialtactsActivity.TAG, "System Dialer is not currently set to be default dialer");
        L5:
            return r3;
        }
    }

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$DataItem;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "number", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DataItem {
        private String name;
        public String number;

        public DataItem() {
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String r1) {
            this.name = r1;
        }
    }

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$OnDBDataChangeListener;", "", "onDBDataChanged", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnDBDataChangeListener {
        void onDBDataChanged();
    }

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$PageEnableListener;", "", "setEnable", "", "visible", "", "shouldTrigger", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PageEnableListener {
        void setEnable(boolean r1, boolean r2);
    }

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$ReleaseResourceListener;", "", "release", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ReleaseResourceListener {
        void release();
    }

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ'\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0014\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0014R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$UpdatePhotoTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "context", "Landroid/content/Context;", ContactSaveService.EXTRA_RAW_CONTACT_ID, "", "bitmap", "Landroid/graphics/Bitmap;", "sync", "", "(Lcom/android/contacts/activities/DialtactsActivity;Landroid/content/Context;JLandroid/graphics/Bitmap;Z)V", "mBitmap", "mContext", "mRawContactId", "mResolver", "Landroid/content/ContentResolver;", "mSync", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "onPostExecute", "", "aVoid", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class UpdatePhotoTask extends AsyncTask<Void, Void, Void> {
        private final Bitmap mBitmap;
        private final Context mContext;
        private final long mRawContactId;
        private final ContentResolver mResolver;
        private final boolean mSync;
        final /* synthetic */ DialtactsActivity this$0;

        public UpdatePhotoTask(DialtactsActivity r2, Context r3, long r4, Bitmap r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r6, "bitmap");
            this.this$0 = r2;
            this.mContext = r3;
            ContentResolver r5 = r3.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(r5, "context.getContentResolver()");
            this.mResolver = r5;
            this.mRawContactId = r4;
            this.mBitmap = r6;
            this.mSync = r7;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r8) {
            Intrinsics.checkNotNullParameter(r8, "params");
            byte[] r3 = DialtactsActivity.access$bitmap2Bytes(this.this$0, this.mBitmap);
            Companion.access$updateContactPhoto(DialtactsActivity.Companion, this.mResolver, r3, this.mRawContactId, this.mSync);
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            ContactPhotoManager.getInstance(this.mContext).refreshCache();
        }
    }

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$ViewPagerVisibilityListener;", "", "onVisibilityChanged", "", "visible", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ViewPagerVisibilityListener {
        void onVisibilityChanged(boolean r1);
    }

    /* JADX INFO: compiled from: DialtactsActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/contacts/activities/DialtactsActivity$onBackPressListener;", "", "backToTopState", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface onBackPressListener {
        boolean backToTopState();
    }

    public static /* synthetic */ void $r8$lambda$4utUeJRn0iboybtu40tNBqYWEoY(DialtactsActivity r0) {
        queryProviderStatus$lambda$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$RvhMDTz_4R85cBQ45GlTdZiybXg(Context r0, Intent r1) {
        onNewIntentWhenPrivacyNotOk$lambda$8(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZB6TlC9vQejS6l0Gt74cgYq7-ec, reason: not valid java name */
    public static /* synthetic */ void m121$r8$lambda$ZB6TlC9vQejS6l0Gt74cgYq7ec(DialtactsActivity r0) {
        handleNumberLocationUpdater$lambda$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$oAGCwF0dQZoqm_A6WeCKGa9ZBMU(DialtactsActivity r0, View r1) {
        onCreate$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$zrHhpW_i6xX6oPFn06exkN_fuX8(DialtactsActivity r0) {
        queryBriefContactList$lambda$0(r0);
    }

    @Override // com.android.contacts.util.DialogManager.DialogShowingViewActivity
    public DialogManager getDialogManager() {
        return null;
    }

    @Override // com.android.contacts.common.list.ContactListFilterController.ContactListFilterListener
    public void onContactListFilterChanged() {
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent r1) {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent r1) {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onProvideAssistContent(this, r1);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onStart(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_activities_DialtactsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public DialtactsActivity() {
        this.briefContactList = new HashMap();
        this.mIsTabEnabled = true;
        this.mFragments = new Fragment[3];
        this.mLinearLayout = new LinearLayout[3];
        this.mViewId = new int[]{R.id.calllog_frame, R.id.all_contacts_frame, R.id.stared_contacts_frame};
        this.mFragmentsCallback = new ContactFragmentsCallback(this);
        this.mForbiddenDescriptionTypes = CollectionsKt.mutableListOf(new String[]{ClipboardReader.FORBIDDEN_CLIPBOARD_TYPE_CALL_LOG});
        this.mBottomDeleteLayoutListener = new DialtactsActivity$mBottomDeleteLayoutListener$1(this);
        this.MESSAGE_SHOW_DIALOG_BY_DB_STATUS = 3;
        this.MESSAGE_QUERY_CONTACT_BRIEF = 4;
        this.MESSAGE_DELAY_SEND = PathInterpolatorCompat.MAX_NUM_POINTS;
        final Handler r0 = new DialtactsActivity$mHandler$1(this);
        this.mHandler = r0;
        this.mBriefContactListObserver = new DialtactsActivity$mBriefContactListObserver$1(this, r0);
        this.mDialpadListener = new DialtactsActivity$mDialpadListener$1();
        this.mPhoneFavoriteListener = new DialtactsActivity$mPhoneFavoriteListener$1(this);
        this.mRawContactIdForUpdatePhoto = -1;
        this.mTabIndexInPreference = -1;
        this.mProviderStatus = -1;
        this.mPrefsCallback = new DialtactsActivity$mPrefsCallback$1(this);
    }

    public static final /* synthetic */ byte[] access$bitmap2Bytes(DialtactsActivity r0, Bitmap r1) {
        return r0.bitmap2Bytes(r1);
    }

    public static final /* synthetic */ boolean access$getDEBUG$cp() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: access$getMDisplayOrder$p$s-957186764, reason: not valid java name */
    public static final /* synthetic */ int m122access$getMDisplayOrder$p$s957186764(DialtactsActivity r0) {
        return r0.mDisplayOrder;
    }

    public static final /* synthetic */ int access$getMESSAGE_QUERY_CONTACT_BRIEF$p(DialtactsActivity r0) {
        return r0.MESSAGE_QUERY_CONTACT_BRIEF;
    }

    public static final /* synthetic */ int access$getMESSAGE_SHOW_DIALOG_BY_DB_STATUS$p(DialtactsActivity r0) {
        return r0.MESSAGE_SHOW_DIALOG_BY_DB_STATUS;
    }

    public static final /* synthetic */ Handler access$getMHandler$p(DialtactsActivity r0) {
        return r0.mHandler;
    }

    public static final /* synthetic */ int access$getMProviderStatus$p(DialtactsActivity r0) {
        return r0.mProviderStatus;
    }

    public static final /* synthetic */ ProviderStatusLoader access$getMProviderStatusLoader$p(DialtactsActivity r0) {
        return r0.mProviderStatusLoader;
    }

    /* JADX INFO: renamed from: access$getMSortOrder$p$s-957186764, reason: not valid java name */
    public static final /* synthetic */ int m123access$getMSortOrder$p$s957186764(DialtactsActivity r0) {
        return r0.mSortOrder;
    }

    public static final /* synthetic */ void access$queryBriefContactList(DialtactsActivity r0) {
        r0.queryBriefContactList();
    }

    public static final /* synthetic */ void access$setMProviderStatus$p(DialtactsActivity r0, int r1) {
        r0.mProviderStatus = r1;
    }

    public static final /* synthetic */ void access$setMTabIndexInPreference$p(DialtactsActivity r0, int r1) {
        r0.mTabIndexInPreference = r1;
    }

    public static final /* synthetic */ void access$showOrhideDialog(DialtactsActivity r0, int r1, boolean r2) {
        r0.showOrhideDialog(r1, r2);
    }

    public static final /* synthetic */ void access$updateClipboardReader(DialtactsActivity r0) {
        r0.updateClipboardReader();
    }

    public static final /* synthetic */ void access$updateTabClickEvent(DialtactsActivity r0, int r1) {
        r0.updateTabClickEvent(r1);
    }

    public final HashMap<Long, ArrayList<DataItem>> getBriefContactList() {
        return this.briefContactList;
    }

    protected final SharedPreferences getMPrefs() {
        return this.mPrefs;
    }

    protected final void setMPrefs(SharedPreferences r1) {
        this.mPrefs = r1;
    }

    protected final Fragment[] getMFragments() {
        return this.mFragments;
    }

    protected final void setMFragments(Fragment[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFragments = r2;
    }

    protected final int[] getMViewId() {
        return this.mViewId;
    }

    protected final void setMViewId(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mViewId = r2;
    }

    public final boolean isShowGroup() {
        return this.isShowGroup;
    }

    public final void setShowGroup(boolean r1) {
        this.isShowGroup = r1;
    }

    @Override // com.obric.utils.ClipboardReader.ClipboardObserver
    public void onClipboardResult(String r2, boolean r3, String r4) {
        if (getCurrentItem() == 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onClipboardResult: not in call log tab");
        return;
    L6:
        String r5 = r2;
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onClipboardResult: content is empty");
        return;
    L16:
        if (r3 == false) goto L21;
        NewDialpadFragment r1 = this.mDialpadFragment;
        if (r1 == null) goto L26;
        if (r1 == null) goto L27;
        r1.showDialpadWithTextDialog(r2);
        return;
    L27:
        return;
    L26:
        return;
    L21:
        NewDialpadFragment r7 = this.mDialpadFragment;
        if (r7 == null) goto L29;
        if (r7 == null) goto L30;
        r7.dismissClipPopupWindow();
        return;
    L30:
        return;
    L29:
        return;
    L9:
        if (r5.length() == 0) goto L12;
        r6 = false;
        goto L13
    }

    private final void queryBriefContactList() {
        new Thread(new DialtactsActivity$$ExternalSyntheticLambda0(this)).start();
    }

    private static final void queryBriefContactList$lambda$0(DialtactsActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.loadBriefContactList();
    }

    private final void loadBriefContactList() {
        Cursor r0 = ContactsApplication.getInstance().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"contact_id", "display_name", "data1"}, null, null, null);
        if (r0 != null) goto L19;
        return;
    L19:
        HashMap<Long, ArrayList<DataItem>> r1 = new HashMap(this.briefContactList.size());     // Catch: Throwable -> L15
    L6:
        if (r0.moveToNext() == false) goto L13;
        long r2 = r0.getLong(0);     // Catch: Throwable -> L15
        DataItem r4 = new DataItem();     // Catch: Throwable -> L15
        r4.setName(r0.getString(1));     // Catch: Throwable -> L15
        r4.number = r0.getString(2);     // Catch: Throwable -> L15
        if (r1.containsKey(Long.valueOf(r2)) == true) goto L9;
        ArrayList<DataItem> r5 = new ArrayList();     // Catch: Throwable -> L15
        r5.add(r4);     // Catch: Throwable -> L15
        r1.put(Long.valueOf(r2), r5);     // Catch: Throwable -> L15
        goto L6
    L9:
        ArrayList<DataItem> r3 = r1.get(Long.valueOf(r2));     // Catch: Throwable -> L15
        if (r3 == null) goto L6;
        r3.add(r4);     // Catch: Throwable -> L15
        goto L6
    L13:
        this.briefContactList = r1;     // Catch: Throwable -> L15
        r0.close();
        return;
    L15:
        th = move-exception;
        r0.close();
        throw th;
    }

    private final void registerObservers() {
        if (this.mCallLogObserver != null) goto L6;
        final Handler r0 = this.mHandler;
        ContentObserver r1 = new DialtactsActivity$registerObservers$callLogObserver$1(this, r0);
        this.mCallLogObserver = r1;
        getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, false, r1);
        return;
    }

    private final void unregisterObservers() {
        ContentObserver r0 = this.mCallLogObserver;
        if (r0 == null) goto L6;
        getContentResolver().unregisterContentObserver(r0);
        this.mCallLogObserver = null;
        return;
    }

    private final Fragment buildFragmentByPosition(int r5) {
        if (r5 != 0) goto L4;
        CallLogV2Fragment r0 = new CallLogV2Fragment();
    L14:
        int r1 = this.mViewId[r5];
        FragmentTransaction r2 = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r2, "supportFragmentManager.beginTransaction()");
        if (r5 != 0) goto L20;
        NewDialpadFragment r6 = NewDialpadFragment.Companion.getPreload();
        if (r6 != null) goto L19;
        r6 = new NewDialpadFragment();
    L19:
        this.mDialpadFragment = r6;
        r2.replace(R.id.dialpad_frame, r6);
    L20:
        r2.replace(r1, r0);
        r2.commit();
        return r0;
    L4:
        if (r5 != 1) goto L6;
        r0 = NewContactListFragment.Companion.getPreload();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Preload ContactListFragment = " + r0);
        if (r0 != null) goto L14;
        r0 = new NewContactListFragment();
        goto L14
    L6:
        if (r5 != 2) goto L9;
        ContactsUtils.setCpuBoost(800);
        r0 = new NewPhoneFavoriteFragment();
        goto L14
    L9:
        throw new IllegalStateException("Unknown fragment index: " + r5);
    }

    protected final NewDialpadFragment getMDialpadFragment() {
        return this.mDialpadFragment;
    }

    protected final void setMDialpadFragment(NewDialpadFragment r1) {
        this.mDialpadFragment = r1;
    }

    public final OBottomNavigationBar getMBottomNavigationBar() {
        return this.mBottomNavigationBar;
    }

    public final void setMBottomNavigationBar(OBottomNavigationBar r1) {
        this.mBottomNavigationBar = r1;
    }

    public final ObricBottomDeleteBarView getMBottomDeleteBar() {
        return this.mBottomDeleteBar;
    }

    public final void setMBottomDeleteBar(ObricBottomDeleteBarView r1) {
        this.mBottomDeleteBar = r1;
    }

    public final OButtonFloating getMBottomDeleteBarBtn() {
        return this.mBottomDeleteBarBtn;
    }

    public final void setMBottomDeleteBarBtn(OButtonFloating r1) {
        this.mBottomDeleteBarBtn = r1;
    }

    public void com_android_contacts_activities_DialtactsActivity__onCreate$___twin___(Bundle r7) {
        sLaunchEvent = new ContactsAppLaunchEvent("", "");
        EventTrackerManager r0 = EventTrackerManager.INSTANCE;
        ContactsAppLaunchEvent r1 = sLaunchEvent;
        Intrinsics.checkNotNull(r1);
        r0.startTrack(r1, false);
        super.onCreate(r7);
        OButtonFloating r3 = null;
        Agent.getInstance().onClick("EVENT_ON_CREATE", null);
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onCreate");
    L5:
        Intent r2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r2, MemorySourceLinkType.INTENT);
        fixIntent(r2);
        setContentView(R.layout.dialtacts_activity);
        DialtactsActivity r4 = this;
        UiUtils.setWindowColorStatusBar(r4);
        getWindow().setBackgroundDrawable(null);
        View r5 = findViewById(R.id.veil);
        this.mVeilView = r5;
        this.mFragmentsCallback.setVeilView(r5);
        this.mBottomNavigationBar = (OBottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        View r6 = findViewById(R.id.bottom_delete_bar);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.utils.views.ObricBottomDeleteBarView");
        ObricBottomDeleteBarView r8 = (ObricBottomDeleteBarView) r6;
        this.mBottomDeleteBar = r8;
        if (r8 == null) goto L8;
        r3 = r8.getDeleteBtn();
    L8:
        this.mBottomDeleteBarBtn = r3;
        if (r3 == null) goto L11;
        r3.setEnabled(false);
    L11:
        OButtonFloating r9 = this.mBottomDeleteBarBtn;
        if (r9 == null) goto L14;
        r9.setOnClickListener(new DialtactsActivity$$ExternalSyntheticLambda4(this));
    L14:
        updateNavigationBarTab();
        OBottomNavigationBar r10 = this.mBottomNavigationBar;
        if (r10 == null) goto L19;
        OBottomNavActionBar r11 = r10.getNavigationBar();
        if (r11 == null) goto L19;
        r11.setOnTabSelectListener(new AnonymousClass2(this));
    L19:
        DialtactsActivity r12 = this;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(r12);
        setCurrentTab(r2);
        if (Intrinsics.areEqual(ContactsContractSmt.get_UI_FILTER_CONTACTS_ACTION(), r2.getAction()) == false) goto L23;
        if (r7 != null) goto L23;
        setupFilterText(r2);
    L23:
        this.mProviderStatusLoader = new ProviderStatusLoader(r12);
        this.mHandler.sendEmptyMessageDelayed(this.MESSAGE_QUERY_CONTACT_BRIEF, 600);
        ContactsApplication.getInstance().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.mBriefContactListObserver);
        this.mClipboardReader = new ClipboardReader(r12, new ClipboardReader.Builder().addPhoneNumberPattern().build(), this.mForbiddenDescriptionTypes);
        MatrixAppUpdateManager.INSTANCE.checkUpdate(r4);
    }

    private static final void onCreate$lambda$2(DialtactsActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.clickBottomDeleteBar();
    }

    private final void clickBottomDeleteBar() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "clickBottomDeleteBar#click id = " + getCurrentItem());
        boolean r1 = false;
        if (getCurrentItem() != 0) goto L16;
        NewCallLogFragment r0 = this.mNewCallLogFragment;
        if (r0 == null) goto L16;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L16;
        NewCallLogFragment r3 = this.mNewCallLogFragment;
        if (r3 == null) goto L16;
        r3.showDeleteCallLogDialog();
        goto L16
    L8:
        if (r0.isVisible() != true) goto L10;
        r2 = true;
    L16:
        if (getCurrentItem() != 0) goto L29;
        CallLogV2Fragment r4 = this.mCallLogV2Fragment;
        if (r4 == null) goto L29;
        if (r4 != null) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L29;
        CallLogV2Fragment r6 = this.mCallLogV2Fragment;
        if (r6 == null) goto L29;
        r6.showDeleteCallLogDialog();
        goto L29
    L21:
        if (r4.isVisible() != true) goto L23;
        r5 = true;
    L29:
        if (getCurrentItem() != 1) goto L42;
        NewContactListFragment r7 = this.mAllFragment;
        if (r7 == null) goto L42;
        if (r7 != null) goto L34;
    L36:
        boolean r8 = false;
    L37:
        if (r8 == false) goto L42;
        NewContactListFragment r9 = this.mAllFragment;
        if (r9 == null) goto L42;
        r9.onClickDelete();
        goto L42
    L34:
        if (r7.isVisible() != true) goto L36;
        r8 = true;
    L42:
        if (getCurrentItem() != 2) goto L54;
        NewPhoneFavoriteFragment r10 = this.mPhoneFavoriteFragment;
        if (r10 == null) goto L55;
        if (r10 != null) goto L47;
    L49:
        if (r1 == false) goto L56;
        NewPhoneFavoriteFragment r11 = this.mPhoneFavoriteFragment;
        if (r11 == null) goto L57;
        r11.showDeleteFavoriteDialog();
        return;
    L57:
        return;
    L56:
        return;
    L47:
        if (r10.isVisible() != true) goto L49;
        r1 = true;
        goto L49
    L55:
        return;
    }

    private final void updateNavigationBarTab() {
        String[] r1 = {getString(R.string.dialtacts_tab_call), getString(R.string.common_contacts), getString(R.string.common_favorites)};
        Drawable r2 = ResourcesCompat.getDrawable(getResources(), R.drawable.bottom_call_icon, null);
        Intrinsics.checkNotNull(r2);
        Drawable r3 = ResourcesCompat.getDrawable(getResources(), R.drawable.bottom_contact_icon, null);
        Intrinsics.checkNotNull(r3);
        Drawable r4 = ResourcesCompat.getDrawable(getResources(), R.drawable.bottom_favorite_icon, null);
        Intrinsics.checkNotNull(r4);
        Drawable[] r0 = {r2, r3, r4};
        OBottomNavigationBar r8 = this.mBottomNavigationBar;
        if (r8 == null) goto L8;
        OBottomNavActionBar r9 = r8.getNavigationBar();
        if (r9 == null) goto L9;
        r9.setTabTitleAndDrawable(r1, r0);
        return;
    L9:
        return;
    }

    private final void updateTabClickEvent(int r4) {
        if (r4 == 0) goto L10;
        if (r4 != 1) goto L6;
        Agent.getInstance().onAttach("ContactListFragment");
    L12:
        if (this.mIsTabEnabled == false) goto L15;
        setCurrentItem(r4, true);
        return;
    L15:
        if (DEBUG == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "tab is disabled!");
        return;
    L19:
        return;
    L6:
        if (r4 != 2) goto L12;
        Agent.getInstance().onAttach(PhoneFavoriteFragment.TAG);
        goto L12
    L10:
        Agent.getInstance().onAttach("CallLogFragment");
        goto L12
    }

    private final void initStatusBar() {
        Window r0 = getWindow();
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.flags = 67108864 | r1.flags;
        r0.setAttributes(r1);
        setLeveralStatusBar(ResourcesCompat.getColor(getResources(), R.color.dialtacts_status_bar_color_common, null));
    }

    private final void setLeveralStatusBar(int r2) {
        View r0 = this.mStatusView;
        if (r0 != null) goto L5;
        this.mStatusView = createStatusView(this, r2);
        View r3 = getWindow().getDecorView();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r3).addView(this.mStatusView);
        return;
    L5:
        if (r0 == null) goto L9;
        r0.setBackgroundColor(r2);
        return;
    }

    private final View createStatusView(FragmentActivity r3, int r4) {
        View r0 = new View(r3);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, ThemeUtils.getStatusBarHeight(this)));
        r0.setBackgroundColor(r4);
        return r0;
    }

    public final void changeStatusBarColor(int r1) {
        setLeveralStatusBar(r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.ContactSaveService.Listener
    public void onServiceCompleted(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, ContactSaveService.EXTRA_CALLBACK_INTENT);
        if (Intrinsics.areEqual(ContactSaveService.ACTION_SET_PHONE_STARRED, r3.getAction()) == false) goto L6;
        notifyDBDataChanged();
        return;
    L6:
        super.onServiceCompleted(r3);
    }

    public void com_android_contacts_activities_DialtactsActivity__onStart$___twin___() {
        super.onStart();
        Agent.getInstance().onClick("EVENT_ON_START", null);
        if (isPreferencesChanged() == false) goto L12;
        NewContactListFragment r0 = this.mAllFragment;
        if (r0 == null) goto L8;
        if (r0 == null) goto L8;
        r0.onPreferencesChanged();
    L8:
        NewPhoneFavoriteFragment r1 = this.mPhoneFavoriteFragment;
        if (r1 == null) goto L12;
        if (r1 == null) goto L12;
        r1.onPreferencesChanged();
    L12:
        ProviderStatusLoader r2 = this.mProviderStatusLoader;
        if (r2 == null) goto L16;
        if (r2 == null) goto L16;
        r2.setProviderStatusListener(this);
    L16:
        registerObservers();
        this.mHandler.postDelayed(new AnonymousClass1(this), 5000);
    }

    public void com_android_contacts_activities_DialtactsActivity__onResume$___twin___() {
        super.onResume();
        DialtactsActivity r1 = this;
        if (Companion.isDefaultDialer(r1) == true) goto L6;
        startActivity(new Intent(r1, WarnNotDefaultDialerAppActivity.class));
        finish();
        return;
    L6:
        updateFromIntentExtra();
        Constants.HANDMODE = Settings.Global.getInt(getContentResolver(), "quick_access_contacts", 1);
        queryProviderStatus();
        ContactPhotoManager.getInstance(r1).refreshCache();
        handleNumberLocationUpdater();
    }

    private final void updateClipboardReader() {
        int r0 = getCurrentItem();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "updateClipboardReader currentItem = " + r0);
        if (this.mClipboardReader != null) goto L5;
        this.mClipboardReader = new ClipboardReader(this, new ClipboardReader.Builder().addPhoneNumberPattern().build(), this.mForbiddenDescriptionTypes);
    L5:
        if (r0 == 0) goto L10;
        ClipboardReader r5 = this.mClipboardReader;
        if (r5 == null) goto L17;
        r5.disable();
        return;
    L17:
        return;
    L10:
        ClipboardReader r1 = this.mClipboardReader;
        if (r1 == null) goto L13;
        r1.addObserver(this);
    L13:
        ClipboardReader r6 = this.mClipboardReader;
        if (r6 == null) goto L18;
        r6.enable();
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L5;
        updateClipboardReader();
        return;
    L5:
        ClipboardReader r0 = this.mClipboardReader;
        if (r0 == null) goto L11;
        if (r0 == null) goto L12;
        r0.disable();
        return;
    L12:
        return;
    }

    public void com_android_contacts_activities_DialtactsActivity__onPause$___twin___() {
        super.onPause();
        ClipboardReader r0 = this.mClipboardReader;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.disable();
        return;
    L8:
        return;
    }

    private final void updateFromIntentExtra() {
        boolean r0 = Intrinsics.areEqual(Constants.SOURCE_LAUNCH_BY_MINUS_SCREEN, getIntent().getStringExtra(Constants.EXTRA_SOURCE_LAUNCH));
        this.mIsLaunchedByMagicFlow = r0;
        if (r0 == false) goto L6;
        getIntent().removeExtra(Constants.EXTRA_SOURCE_LAUNCH);
        return;
    }

    private final void queryProviderStatus() {
        new Thread(new DialtactsActivity$$ExternalSyntheticLambda3(this)).start();
    }

    private static final void queryProviderStatus$lambda$3(DialtactsActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        ProviderStatusLoader r0 = r3.mProviderStatusLoader;
        if (r0 == null) goto L5;
        int r1 = r0.getProviderStatus();
    L6:
        r3.mProviderStatus = r1;
        Handler r2 = r3.mHandler;
        r2.sendMessage(Message.obtain(r2, r3.MESSAGE_SHOW_DIALOG_BY_DB_STATUS, r1, 0));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private final void handleNumberLocationUpdater() {
        new Thread(new DialtactsActivity$$ExternalSyntheticLambda1(this)).start();
    }

    private static final void handleNumberLocationUpdater$lambda$4(DialtactsActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Object r0 = r4.getApplicationContext().getSystemService("phone");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String r1 = ((TelephonyManager) r0).getNetworkCountryIso();
        String r2 = r4.getLastNetworkCountryIso();
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "networkCountryIso = " + r1 + ", lastNetworkCountryIso = " + r2);
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return;
    L8:
        if (StringsKt.equals(r1, r2, true) == true) goto L12;
        Intent r3 = new Intent(r4, NumberLocationUpdaterService.class);
        r3.putExtra(ContactsUtils.PREF_LAST_NETWORK_COUNTRY_ISO, r1);
        r4.startService(r3);
        return;
    }

    private final String getLastNetworkCountryIso() {
        SharedPreferences r2 = PreferenceManager.getDefaultSharedPreferences(this);
        if (r2 == null) goto L5;
        String r3 = r2.getString(ContactsUtils.PREF_LAST_NETWORK_COUNTRY_ISO, "");
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public void com_android_contacts_activities_DialtactsActivity__onDestroy$___twin___() {
        super.onDestroy();
        ContactDetailCacheManager.getInstance().destroy();
        ContactDetailCacheManager.getInstance().destroyProfileLoader(this);
        ContactsApplication.getInstance().getContentResolver().unregisterContentObserver(this.mBriefContactListObserver);
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onDestroy");
    L5:
        ClipboardReader r0 = this.mClipboardReader;
        if (r0 == null) goto L10;
        if (r0 == null) goto L9;
        r0.disable();
    L9:
        this.mClipboardReader = null;
    L10:
        MatrixAppUpdateManager.INSTANCE.abortUpdate();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        super.onAttachFragment(r4);
        if (this.mLinearLayout[0] == null) goto L5;
        int r0 = getCurrentItem();
    L7:
        if ((r4 instanceof NewDialpadFragment) == false) goto L16;
        NewDialpadFragment r5 = (NewDialpadFragment) r4;
        this.mDialpadFragment = r5;
        if (r5 == null) goto L11;
        r5.setPrefsCallback(this.mPrefsCallback);
    L11:
        if (r0 != 0) goto L59;
        NewDialpadFragment r3 = this.mDialpadFragment;
        if (r3 == null) goto L60;
        r3.onVisibilityChanged(true);
        return;
    L60:
        return;
    L59:
        return;
    L16:
        if ((r4 instanceof NewCallLogFragment) == false) goto L28;
        NewCallLogFragment r6 = (NewCallLogFragment) r4;
        this.mNewCallLogFragment = r6;
        if (r6 == null) goto L20;
        r6.setFragmentsCallback(this.mFragmentsCallback);
    L20:
        if (r0 != 0) goto L24;
        NewCallLogFragment r7 = this.mNewCallLogFragment;
        if (r7 == null) goto L24;
        r7.onVisibilityChanged(true);
    L24:
        NewCallLogFragment r8 = this.mNewCallLogFragment;
        if (r8 == null) goto L62;
        r8.setBottomDeleteLayoutListener(this.mBottomDeleteLayoutListener);
        return;
    L62:
        return;
    L28:
        if ((r4 instanceof CallLogV2Fragment) == false) goto L31;
        CallLogV2Fragment r9 = (CallLogV2Fragment) r4;
        this.mCallLogV2Fragment = r9;
        r9.setFragmentsCallback(this.mFragmentsCallback);
        r9.setBottomDeleteLayoutListener(this.mBottomDeleteLayoutListener);
        return;
    L31:
        if ((r4 instanceof NewPhoneFavoriteFragment) == false) goto L48;
        NewPhoneFavoriteFragment r10 = (NewPhoneFavoriteFragment) r4;
        this.mPhoneFavoriteFragment = r10;
        if (r10 == null) goto L35;
        r10.setFragmentsCallback(this.mFragmentsCallback);
    L35:
        NewPhoneFavoriteFragment r11 = this.mPhoneFavoriteFragment;
        if (r11 == null) goto L38;
        r11.setListener(this.mPhoneFavoriteListener);
    L38:
        NewPhoneFavoriteFragment r12 = this.mPhoneFavoriteFragment;
        if (r12 == null) goto L41;
        r12.setDialtactsActivity(this);
    L41:
        NewPhoneFavoriteFragment r13 = this.mPhoneFavoriteFragment;
        if (r13 == null) goto L44;
        r13.setPrefsCallback(this.mPrefsCallback);
    L44:
        NewPhoneFavoriteFragment r14 = this.mPhoneFavoriteFragment;
        if (r14 == null) goto L65;
        r14.setBottomDeleteLayoutListener(this.mBottomDeleteLayoutListener);
        return;
    L65:
        return;
    L48:
        if ((r4 instanceof NewContactListFragment) == false) goto L67;
        NewContactListFragment r15 = (NewContactListFragment) r4;
        this.mAllFragment = r15;
        if (r15 == null) goto L52;
        r15.setFragmentsCallback(this.mFragmentsCallback);
    L52:
        NewContactListFragment r16 = this.mAllFragment;
        if (r16 == null) goto L55;
        r16.setPrefsCallback(this.mPrefsCallback);
    L55:
        NewContactListFragment r17 = this.mAllFragment;
        if (r17 == null) goto L68;
        r17.setBottomDeleteLayoutListener(this.mBottomDeleteLayoutListener);
        return;
    L68:
        return;
    L67:
        return;
    L5:
        r0 = -1;
        goto L7
    }

    public void com_android_contacts_activities_DialtactsActivity__onStop$___twin___() {
        super.onStop();
        ProviderStatusLoader r0 = this.mProviderStatusLoader;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.setProviderStatusListener(null);
    L6:
        unregisterObservers();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onStop");
    }

    private final void fixIntent(Intent r3) {
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Fix intent error for action: " + r3.getAction() + ", ex: " + Log.getStackTraceString(e));
        return;
    L3:
        if (Intrinsics.areEqual("android.intent.action.CALL_BUTTON", r3.getAction()) == false) goto L6;
        r3.setDataAndType(CallLog.Calls.CONTENT_URI, "vnd.android.cursor.dir/calls");     // Catch: RuntimeException -> L11
        r3.putExtra("call_key", true);     // Catch: RuntimeException -> L11
        setIntent(r3);     // Catch: RuntimeException -> L11
    L14:
        return;
    L6:
        if (Intrinsics.areEqual("android.intent.action.VIEW", r3.getAction()) == false) goto L8;
    L9:
        this.mIsLaunchedByInCall = r3.getBooleanExtra("launched_by_incall", false);     // Catch: RuntimeException -> L11
        goto L14
    L8:
        if (Intrinsics.areEqual("android.intent.action.DIAL", r3.getAction()) == false) goto L14;
        goto L9
    }

    protected final boolean isSendKeyWhileInCall(Intent r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        if (r3 == true) goto L5;
    L10:
        return false;
    L5:
        if (r2.getBooleanExtra("call_key", false) == false) goto L10;
        if (ReflectUtils.showCallScreen(this) == false) goto L10;
        return true;
    }

    public final void setCurrentTab(Intent r6) {
        Intrinsics.checkNotNullParameter(r6, MemorySourceLinkType.INTENT);
        boolean r0 = Intrinsics.areEqual("vnd.android.cursor.dir/calls", r6.getType());
        if (isSendKeyWhileInCall(r6, r0) == false) goto L52;
        finish();
        return;
    L52:
        int r2 = r6.getIntExtra("show_tab_at", -1);     // Catch: RuntimeException -> L9
    L10:
        int r4 = 1;
        if (r2 < 0) goto L16;
        if (r2 >= 3) goto L16;
    L14:
        boolean r1 = false;
    L26:
        if (r2 < 0) goto L28;
        if (r2 >= 3) goto L28;
    L29:
        String r7 = r6.getAction();
        if (Intrinsics.areEqual(ADD_CONTACTS, r7) == false) goto L32;
    L37:
        setCurrentItem(1, false);
    L38:
        OBottomNavigationBar r8 = this.mBottomNavigationBar;
        if (r8 == null) goto L41;
        OBottomNavActionBar r9 = r8.getNavigationBar();
    L42:
        if (r9 == null) goto L45;
        r9.setCurrentTab(r4);
    L45:
        if (r4 != 0) goto L54;
        if (r1 == false) goto L55;
        NewDialpadFragment r5 = this.mDialpadFragment;
        if (r5 == null) goto L56;
        if (r5 == null) goto L57;
        r5.showDialpad();
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L41:
        r9 = null;
        goto L42
    L32:
        if (Intrinsics.areEqual(SEARCH_CONTACTS, r7) == true) goto L37;
        if (Intrinsics.areEqual(FREQUENT_CONTACTS, r7) == true) goto L37;
        setCurrentItem(r2, false);
        r4 = r2;
    L28:
        r2 = 0;
    L16:
        if (isDialIntent(r6) == false) goto L18;
        r2 = 0;
        r1 = true;
        goto L26
    L18:
        if (r0 == false) goto L21;
        r1 = false;
        r2 = 0;
        goto L26
    L21:
        if (Intrinsics.areEqual("android.intent.action.VIEW", r6.getAction()) == true) goto L23;
    L25:
        r2 = getTabIndex();
        goto L14
    L23:
        if (Intrinsics.areEqual(ContactsContract.Contacts.CONTENT_URI, r6.getData()) == false) goto L25;
        r1 = false;
        r2 = 1;
    L9:
        r2 = 0;
        goto L10
    }

    protected final void setCurrentItem(int r7, boolean r8) {
        int r0 = getCurrentItem();
        if (r0 < 0) goto L12;
        if (r0 == r7) goto L6;
        sendFragmentVisibilityChange(r0, false);
        goto L12
    L6:
        if (r7 != 1) goto L12;
        if (r8 == false) goto L12;
        NewContactListFragment r3 = this.mAllFragment;
        if (r3 == null) goto L12;
        if (r3 == null) goto L12;
        r3.onBackPressed();
    L12:
        if (r8 == true) goto L15;
        if (r7 != r0) goto L15;
        return;
    L15:
        int r9 = this.mViewId.length;
        int r1 = 0;
    L16:
        if (r1 >= r9) goto L39;
        if (r1 == r7) goto L28;
        View r4 = findViewById(this.mViewId[r1]);
        if (r4 == null) goto L23;
        r4.setVisibility(4);
    L23:
        if (r1 != 0) goto L38;
        View r5 = findViewById(R.id.dialpad_frame);
        if (r5 == null) goto L38;
        r5.setVisibility(4);
    L38:
        r1 = r1 + 1;
        goto L16
    L28:
        View r6 = findViewById(this.mViewId[r1]);
        if (r6 == null) goto L32;
        r6.setVisibility(0);
    L32:
        if (r1 != 0) goto L37;
        View r10 = findViewById(R.id.dialpad_frame);
        if (r10 == null) goto L37;
        r10.setVisibility(0);
    L37:
        sendFragmentVisibilityChange(r1, true);
        goto L38
    L39:
        saveLastTabIndex(r7);
    }

    public final int getCurrentItem() {
        int r0 = this.mFragments.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = findViewById(this.mViewId[r1]);
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 0) goto L9;
        return r1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return -1;
    }

    @Override // com.android.contacts.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        NewContactListFragment r0 = this.mAllFragment;
        if (r0 == null) goto L13;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L13;
        NewContactListFragment r2 = this.mAllFragment;
        if (r2 == null) goto L13;
        r2.setKeepSearchState(true);
        goto L13
    L7:
        if (r0.isSearch() != true) goto L9;
        r1 = true;
    L13:
        super.startActivityForResult(r4, r5, r6);
    }

    public final void notifyDBDataChanged() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == false) goto L7;
        return;
    L7:
        if (this.mCallLogObserver == null) goto L19;
        NewContactListFragment r0 = this.mAllFragment;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity.OnDBDataChangeListener");
        r0.onDBDataChanged();
    L12:
        NewDialpadFragment r2 = this.mDialpadFragment;
        if (r2 == null) goto L18;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity.OnDBDataChangeListener");
        r2.onDBDataChanged();
        return;
    L18:
        return;
    }

    public void com_android_contacts_activities_DialtactsActivity__onNewIntent$___twin___(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "newIntent");
        super.onNewIntent(r3);
        String r0 = r3.getAction();
        if (Intrinsics.areEqual(GroupEditorActivity.ACTION_SAVE_COMPLETED, r0) == false) goto L8;
        NewContactListFragment r2 = this.mAllFragment;
        if (r2 == null) goto L12;
        r2.groupSaveCompleted();
        return;
    L12:
        return;
    L8:
        setIntent(r3);
        fixIntent(r3);
        setCurrentTab(r3);
        if (Intrinsics.areEqual(ContactsContractSmt.get_UI_FILTER_CONTACTS_ACTION(), r0) == false) goto L13;
        setupFilterText(r3);
        return;
    }

    private final List<String> getCallList(JSONArray r4) {
        ArrayList r3 = new ArrayList();
        if (r4 != null) goto L12;
        return r3;
    L12:
        int r0 = r4.length();     // Catch: Throwable -> L9
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        r3.add(r4.getString(r1));     // Catch: Throwable -> L9
        r1 = r1 + 1;
    L11:
        return r3;
    L9:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "DialtactsActivity#getCallList err = " + th);
        goto L11
    }

    private final List<Long> getContactsList(JSONArray r5) {
        ArrayList r4 = new ArrayList();
        if (r5 != null) goto L12;
        return r4;
    L12:
        int r0 = r5.length();     // Catch: Throwable -> L9
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        r4.add(Long.valueOf(r5.getLong(r1)));     // Catch: Throwable -> L9
        r1 = r1 + 1;
    L11:
        return r4;
    L9:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "DialtactsActivity#getContactsList err = " + th);
        goto L11
    }

    protected final boolean isDialIntent(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        String r2 = r3.getAction();
        if (Intrinsics.areEqual("android.intent.action.DIAL", r2) == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(ACTION_TOUCH_DIALER, r2) == true) goto L16;
        if (Intrinsics.areEqual("android.intent.action.VIEW", r2) == false) goto L14;
        Uri r4 = r3.getData();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Constants.SCHEME_TEL, r4.getScheme()) == false) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public final String getAndClearFilterText() {
        String r0 = this.mFilterText;
        this.mFilterText = null;
        return r0;
    }

    private final void setupFilterText(Intent r3) {
        if ((r3.getFlags() & 1048576) == 0) goto L5;
        return;
    L5:
        String r4 = r3.getStringExtra(ContactsContractSmt.get_UI_FILTER_TEXT_EXTRA_KEY());
        String r0 = r4;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L15;
        this.mFilterText = r4;
        return;
    L15:
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ActivityResultCaller r0 = getFragmentAt(getCurrentItem());
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity.onBackPressListener");
        if (((onBackPressListener) r0).backToTopState() == true) goto L5;
        return;
    L5:
        pressedBack();
    }

    private final void pressedBack() {
        releaseUselessResource();
        if (this.mIsLaunchedByInCall == false) goto L7;
        super.onBackPressed();
        overridePendingTransition(0, R.anim.slide_down_out);
        return;
    L7:
        if (this.mIsLaunchedByMagicFlow == false) goto L11;
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        return;
    L11:
        if (needMoveTaskToBack() == true) goto L14;
        super.onBackPressed();
        return;
    }

    private final void releaseUselessResource() {
        int r0 = getCurrentItem();
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "releaseUselessResource curItemIndex:" + r0);
    L5:
        if (r0 != 0) goto L12;
        DialtactsActivity r1 = this;
        AsyncImageLoader.getInstances(r1).clearImageCache();
        if (this.mDialpadFragment == null) goto L12;
        ImportantResource.getInstance(r1).clear();
        NewDialpadFragment r2 = this.mDialpadFragment;
        if (r2 == null) goto L12;
        r2.release();
    L12:
        if (r0 == 1) goto L18;
        NewContactListFragment r3 = this.mAllFragment;
        if (r3 == null) goto L18;
        if (r3 == null) goto L18;
        r3.release();
    L18:
        if (r0 == 2) goto L24;
        NewPhoneFavoriteFragment r4 = this.mPhoneFavoriteFragment;
        if (r4 == null) goto L25;
        if (r4 == null) goto L26;
        r4.release();
        return;
    L26:
        return;
    L25:
        return;
    }

    private final boolean needMoveTaskToBack() {
        if (isTaskRoot() == false) goto L6;
        moveTaskToBack(false);
        return true;
    L6:
        return false;
    }

    private final Fragment getFragmentAt(int r3) {
        if (r3 != 0) goto L4;
    L10:
        Fragment[] r0 = this.mFragments;
        if (r0[r3] != null) goto L14;
        r0[r3] = buildFragmentByPosition(r3);
    L14:
        return this.mFragments[r3];
    L4:
        if (r3 == 1) goto L10;
        if (r3 == 2) goto L10;
        throw new IllegalStateException("Unknown fragment index: " + r3);
    }

    public final void sendFragmentVisibilityChange(int r3, boolean r4) {
        ActivityResultCaller r0 = getFragmentAt(r3);
        if ((r0 instanceof ViewPagerVisibilityListener) == false) goto L5;
        ((ViewPagerVisibilityListener) r0).onVisibilityChanged(r4);
    L5:
        if (r3 != 0) goto L10;
        NewDialpadFragment r1 = this.mDialpadFragment;
        if (r1 == null) goto L10;
        if (r1 == null) goto L10;
        r1.onVisibilityChanged(r4);
    L10:
        float r2 = 8.0f;
        if (r4 == false) goto L23;
        if (r3 != 0) goto L20;
        NewDialpadFragment r5 = this.mDialpadFragment;
        boolean r6 = false;
        if (r5 != null) goto L16;
    L18:
        if (r6 == false) goto L20;
        r2 = 0.0f;
        goto L20
    L16:
        if (r5.isDialpadShown() != true) goto L18;
        r6 = true;
    L20:
        OBottomNavigationBar r7 = this.mBottomNavigationBar;
        if (r7 == null) goto L28;
        r7.setMaskBlurRadius(r2);
        return;
    L28:
        return;
    L23:
        if (r3 != 0) goto L30;
        OBottomNavigationBar r8 = this.mBottomNavigationBar;
        if (r8 == null) goto L31;
        r8.setMaskBlurRadius(8.0f);
        return;
    L31:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r8, int r9, Intent r10) {
        super.onActivityResult(r8, r9, r10);
        if (r9 == (-1)) goto L6;
        return;
    L6:
        if (r8 != 1) goto L8;
        File r11 = this.mCurrentPhotoFile;
        if (r11 == null) goto L21;
        doCropPhoto(r11);
        return;
    L21:
        return;
    L8:
        if (r8 != 2) goto L22;
        if (r10 == null) goto L18;
        Bitmap r5 = (Bitmap) r10.getParcelableExtra("data", Bitmap.class);
        if (r5 == null) goto L19;
        new UpdatePhotoTask(this, this, this.mRawContactIdForUpdatePhoto, r5, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void startActivityForTakePhoto(long r2) {
        this.mRawContactIdForUpdatePhoto = r2;     // Catch: ActivityNotFoundException -> L5
        File r3 = new File(ContactEditorFragment.getPhotoFileName(this));     // Catch: ActivityNotFoundException -> L5
        this.mCurrentPhotoFile = r3;     // Catch: ActivityNotFoundException -> L5
        startActivityForResult(ContactsIntentUtils.getTakePickIntent(r3), 1);     // Catch: ActivityNotFoundException -> L5
        AnimationUtil.switchActivityAnimation(this, 1);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        Toast.makeText(this, R.string.photoPickerNotFoundText, 1).show();
    }

    public final void startActivityForPickPhoto(long r2) {
        this.mRawContactIdForUpdatePhoto = r2;     // Catch: ActivityNotFoundException -> L5
        startActivityForResult(ContactsIntentUtils.getPhotoPickIntent(), 2);     // Catch: ActivityNotFoundException -> L5
        AnimationUtil.switchActivityAnimation(this, 1);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        Toast.makeText(this, R.string.photoPickerNotFoundText, 1).show();
    }

    protected final void doCropPhoto(File r6) {
        Intrinsics.checkNotNullParameter(r6, "f");
        String r3 = r6.getAbsolutePath();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r3, "f.getAbsolutePath()");     // Catch: Exception -> L5
        MediaScannerConnection.scanFile(this, new String[]{r3}, new String[]{null}, null);     // Catch: Exception -> L5
        startActivityForResult(ContactsIntentUtils.getCropImageIntent(Uri.fromFile(r6)), 2);     // Catch: Exception -> L5
        AnimationUtil.switchActivityAnimation(this, 1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot crop image", e);
        Toast.makeText(this, R.string.photoPickerNotFoundText, 1).show();
    }

    private final byte[] bitmap2Bytes(Bitmap r4) {
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        r4.compress(Bitmap.CompressFormat.PNG, 100, r3);
        byte[] r5 = r3.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r5, "bos.toByteArray()");
        return r5;
    }

    public final void setTabOnclickEnabled(boolean r1) {
        this.mIsTabEnabled = r1;
    }

    private final int getTabIndex() {
        int r0 = PreferenceManager.getDefaultSharedPreferences(this).getInt(LAST_TAB_INDEX, 0);
        this.mTabIndexInPreference = r0;
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.contacts.activities.DialtactsActivity$saveLastTabIndex$1] */
    private final void saveLastTabIndex(final int r2) {
        if (this.mTabIndexInPreference != r2) goto L5;
        return;
    L5:
        new C01391(this, r2).start();
    }

    @Override // com.android.contacts.list.ProviderStatusLoader.ProviderStatusListener
    public void onProviderStatusChange() {
        new Thread(new DialtactsActivity$onProviderStatusChange$loadThread$1(this)).start();
    }

    private final void showOrhideDialog(int r4, boolean r5) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "showOrhideDialog status:" + r4 + " triggerLoad:" + r5);
    L6:
        if (Constants.ANDROID60 == false) goto L8;
        int r0 = 2;
    L9:
        int r1 = getCurrentItem();
        if (r4 == 0) goto L16;
        if (r4 == r0) goto L16;
        showProgressDialog();
        if (r1 < 0) goto L20;
        Object r3 = this.mFragments[r1];
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity.PageEnableListener");
        ((PageEnableListener) r3).setEnable(false, r5);
        return;
    L20:
        return;
    L16:
        hideProgressDialog();
        if (r1 < 0) goto L22;
        Object r6 = this.mFragments[r1];
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity.PageEnableListener");
        ((PageEnableListener) r6).setEnable(true, r5);
        return;
    L22:
        return;
    L8:
        r0 = ContactsContractSmt.get_STATUS_NO_ACCOUNTS_NO_CONTACTS();
        goto L9
    }

    private final void showProgressDialog() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L25;
        boolean r1 = false;
        if (this.mProgress != null) goto L12;
        ProgressDialog r0 = new ProgressDialog(this);
        this.mProgress = r0;
        r0.setMessage(getString(R.string.dialog_content_wait_message));
        ProgressDialog r2 = this.mProgress;
        if (r2 == null) goto L12;
        r2.setCancelable(false);
    L12:
        ProgressDialog r3 = this.mProgress;
        if (r3 != null) goto L15;
    L17:
        if (r1 == false) goto L23;
        ProgressDialog r4 = this.mProgress;
        if (r4 == null) goto L24;
        r4.show();
        return;
    L24:
        return;
    L23:
        return;
    L15:
        if (r3.isShowing() == true) goto L17;
        r1 = true;
        goto L17
    }

    public final void hideProgressDialog() {
        ProgressDialog r0 = this.mProgress;
        if (r0 == null) goto L14;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L15;
        ProgressDialog r3 = this.mProgress;
        if (r3 == null) goto L16;
        r3.dismiss();
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r0.isShowing() != true) goto L9;
        r1 = true;
        goto L9
    }

    @Override // com.android.contacts.BaseActivity, com.obric.privacyhook.LifeHookActivity
    public void onNewIntentWhenPrivacyNotOk(Intent r4) {
        super.onNewIntentWhenPrivacyNotOk(r4);
        UiUtils.setWindowColorStatusBar(this);
        final Intent r5 = new Intent(getIntent());
        r5.addFlags(268435456);
        final Context r0 = getApplicationContext();
        PrivacyUtils.startBasePermissionApplyIfNeeded(this, new DialtactsActivity$$ExternalSyntheticLambda2(r0, r5));
        finish();
    }

    private static final void onNewIntentWhenPrivacyNotOk$lambda$8(Context r1, Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "$nowIntent");
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");
        PrivacyUtils.startPrivacyFlowHomeWithoutAnimation(r1, r2);
    }

    public void com_android_contacts_activities_DialtactsActivity__onProvideAssistContent$___twin___(AssistContent r2) {
        Intrinsics.checkNotNullParameter(r2, "outContent");
        super.onProvideAssistContent(r2);
        provideData(r2);
    }

    public final void provideData(AssistContent r9) {
        Intrinsics.checkNotNullParameter(r9, "outContent");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onProvideAssistContent: DialtactsActivity call ");
        List<Long> r2 = null;
        if (getCurrentItem() != 0) goto L20;
        NewCallLogFragment r0 = this.mNewCallLogFragment;
        if (r0 == null) goto L20;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L20;
        NewCallLogFragment r3 = this.mNewCallLogFragment;
        if (r3 == null) goto L15;
        List<Long> r4 = r3.getCurrentVisibleContact();
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onProvideAssistContent: call log" + r4);
        if (r4 == null) goto L20;
        ContentResolver r6 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r6, "contentResolver");
        EntityProvider.INSTANCE.donateOnScreenData(r9, new ArrayList(CallHistoryEntityUtilKt.queryCallLogsByIds(r6, r4, this)));
        goto L20
    L15:
        r4 = null;
        goto L16
    L8:
        if (r0.isVisible() != true) goto L10;
        r1 = true;
    L20:
        if (getCurrentItem() != 0) goto L37;
        CallLogV2Fragment r5 = this.mCallLogV2Fragment;
        if (r5 == null) goto L37;
        if (r5 != null) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L37;
        CallLogV2Fragment r8 = this.mCallLogV2Fragment;
        if (r8 == null) goto L32;
        List<Long> r10 = r8.getCurrentVisibleContact();
    L33:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onProvideAssistContent: call log v2 " + r10);
        if (r10 == null) goto L37;
        ContentResolver r11 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r11, "contentResolver");
        EntityProvider.INSTANCE.donateOnScreenData(r9, new ArrayList(CallHistoryEntityUtilKt.queryCallLogsByIds(r11, r10, this)));
        goto L37
    L32:
        r10 = null;
        goto L33
    L25:
        if (r5.isVisible() != true) goto L27;
        r7 = true;
    L37:
        if (getCurrentItem() != 1) goto L58;
        NewContactListFragment r12 = this.mAllFragment;
        if (r12 == null) goto L59;
        if (r12 != null) goto L42;
    L44:
        boolean r13 = false;
    L45:
        if (r13 == false) goto L60;
        NewContactListFragment r14 = this.mAllFragment;
        if (r14 == null) goto L49;
        r2 = r14.getCurrentVisibleContact();
    L49:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onProvideAssistContent: contacts all " + r2);
        if (r2 != null) goto L52;
        return;
    L52:
        if (r2.isEmpty() == true) goto L62;
        ContentResolver r15 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r15, "contentResolver");
        List r16 = CollectionsKt.toMutableList(ContactEntityUtilKt.queryContactsByIds(r15, r2, false, false));
        ContentResolver r17 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r17, "contentResolver");
        List<ContactEntity> r18 = ContactEntityUtilKt.queryContactsByIds(r17, r2, true, false);
        if (r18.isEmpty() == true) goto L56;
        r16.addAll(r18);
    L56:
        EntityProvider.INSTANCE.donateOnScreenData(r9, new ArrayList(r16));
        return;
    L62:
        return;
    L60:
        return;
    L42:
        if (r12.isVisible() != true) goto L44;
        r13 = true;
        goto L45
    L59:
        return;
    }

    public final void hideDialpad() {
        if (getCurrentItem() != 0) goto L9;
        NewDialpadFragment r1 = this.mDialpadFragment;
        if (r1 == null) goto L10;
        if (r1 == null) goto L11;
        r1.disappearDialpad();
        return;
    L11:
        return;
    L10:
        return;
    }

    static {
        Companion = new Companion(null);
        DEBUG = ContactsUtils.DEBUG;
        sSysGestureInsets = new Rect();
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r2) {
        OBottomNavigationBar r1 = this.mBottomNavigationBar;
        if (r1 == null) goto L6;
        r1.setPadding(0, 0, 0, r2);
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onCreate(DialtactsActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_DialtactsActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_DialtactsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DialtactsActivity r1) {
        com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStart")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onStart(DialtactsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r2.com_android_contacts_activities_DialtactsActivity__onStart$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onResume(DialtactsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_activities_DialtactsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onPause(DialtactsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_android_contacts_activities_DialtactsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onStop(DialtactsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_DialtactsActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(DialtactsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_activities_DialtactsActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onNewIntent")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(DialtactsActivity r2, Intent r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r3);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_DialtactsActivity__onNewIntent$___twin___(r3);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onProvideAssistContent")
    public static void com_android_contacts_activities_DialtactsActivity_com_obric_privacyhook_PrivacyHook_onProvideAssistContent(DialtactsActivity r2, AssistContent r3) {
        Intrinsics.checkNotNullParameter(r3, "outContent");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        DialtactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superOnProvideAssistContent(r3);
        return;
    L6:
        r2.com_android_contacts_activities_DialtactsActivity__onProvideAssistContent$___twin___(r3);
    }
}
