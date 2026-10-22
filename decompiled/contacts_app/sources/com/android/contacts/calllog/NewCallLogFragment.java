package com.android.contacts.calllog;

import android.app.KeyguardManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.security.bytedance.guard.BDSettingsEvent;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.ReflectUtils;
import com.android.contacts.activities.ContactCalllogsActivity;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.activities.NumberMarkActivity;
import com.android.contacts.calllog.blocked.repo.BlockedDataRequester;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.list.SlideListView;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.voicemail.VoicemailStatusHelper;
import com.android.contacts.voicemail.VoicemailStatusHelperImpl;
import com.android.contacts.widget.SelectAllState;
import com.obric.anim.ListAnimator;
import com.obric.immersive.Immersive;
import com.obric.model.CallFeatureModel;
import com.obric.notification.NotificationHelper;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.ui.ListTouchHelper;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.OUIHelper;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.ClipboardReader;
import com.obric.utils.NewContactsTraceLog;
import com.obric.utils.OAutoSecurityGuardUtils;
import com.obric.utils.ObriceRecordSummaryUtils;
import com.obric.utils.commonitemview.CallLogItemCardView;
import com.obricOld.contacts.menus.LongMenuHelper;
import com.ss.android.http.legacy.protocol.HTTP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import obric.app.tracker.Agent;
import obric.widget.ButtonTabGroup;

/* JADX INFO: compiled from: NewCallLogFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¡\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006*\u0001\u001d\u0018\u0000 ä\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b:\u0004ä\u0001å\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\fB3\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J\b\u0010g\u001a\u00020\u0012H\u0016J\u001e\u0010h\u001a\u00020i2\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010l0kH\u0003J\u000e\u0010m\u001a\u00020i2\u0006\u0010n\u001a\u000203J\u001c\u0010o\u001a\u00020\u00122\b\u0010p\u001a\u0004\u0018\u00010\u000e2\b\u0010q\u001a\u0004\u0018\u00010\u000eH\u0002J\u0006\u0010r\u001a\u00020iJ\b\u0010s\u001a\u00020iH\u0002J\u0006\u0010t\u001a\u00020iJ\u0010\u0010u\u001a\u00020i2\u0006\u0010v\u001a\u00020\u0012H\u0002J\b\u0010w\u001a\u00020iH\u0002J\u001c\u0010x\u001a\u00020\u00122\b\u0010p\u001a\u0004\u0018\u00010\u000e2\b\u0010q\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010y\u001a\u00020iH\u0016J\u0010\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020\u0012H\u0002J\u0012\u0010}\u001a\u0004\u0018\u00010~2\u0006\u0010\u007f\u001a\u00020)H\u0002J\u001f\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u000203H\u0002J\u001c\u0010\u0085\u0001\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u0002032\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0002J,\u0010\u0089\u0001\u001a\u00020\u00122!\u0010\u008a\u0001\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u008b\u0001j\r\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u0001`\u008c\u0001H\u0002J\u001d\u0010\u008d\u0001\u001a\u00020\u00122\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0002J\u0017\u0010\u0091\u0001\u001a\u00020i2\f\u0010\u0092\u0001\u001a\u00070\u0093\u0001R\u00020\u0018H\u0002J'\u0010\u0094\u0001\u001a\u00020i2\u0007\u0010\u0095\u0001\u001a\u0002032\u0007\u0010\u0096\u0001\u001a\u0002032\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\u001c\u0010\u0099\u0001\u001a\u00020i2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010)2\u0006\u0010n\u001a\u000203H\u0016J\u0013\u0010\u009b\u0001\u001a\u00020i2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u0012\u0010\u009c\u0001\u001a\u00020i2\u0007\u0010\u009d\u0001\u001a\u00020)H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020i2\u0007\u0010\u009f\u0001\u001a\u00020)H\u0002J\u0015\u0010 \u0001\u001a\u00020i2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J+\u0010£\u0001\u001a\u00020)2\b\u0010¤\u0001\u001a\u00030¥\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00012\n\u0010¨\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\t\u0010©\u0001\u001a\u00020iH\u0016J\t\u0010ª\u0001\u001a\u00020iH\u0016J\t\u0010«\u0001\u001a\u00020iH\u0016J*\u0010¬\u0001\u001a\u00020\u00122\b\u0010\u00ad\u0001\u001a\u00030®\u00012\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010)2\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\t\u0010¯\u0001\u001a\u00020iH\u0016J\t\u0010°\u0001\u001a\u00020iH\u0016J0\u0010±\u0001\u001a\u00020i2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010²\u00012\u0007\u0010³\u0001\u001a\u0002032\u0007\u0010´\u0001\u001a\u0002032\u0007\u0010µ\u0001\u001a\u000203H\u0016J\u001e\u0010¶\u0001\u001a\u00020i2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010²\u00012\u0007\u0010·\u0001\u001a\u000203H\u0016J\t\u0010¸\u0001\u001a\u00020iH\u0002J\t\u0010¹\u0001\u001a\u00020iH\u0016J\u001e\u0010º\u0001\u001a\u00020i2\u0007\u0010\u009d\u0001\u001a\u00020)2\n\u0010»\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\u0012\u0010¼\u0001\u001a\u00020i2\u0007\u0010½\u0001\u001a\u00020\u0012H\u0016J\u0015\u0010¾\u0001\u001a\u00020i2\n\u0010¿\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u0014\u0010À\u0001\u001a\u00020i2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u0007\u0010Â\u0001\u001a\u00020iJ\t\u0010Ã\u0001\u001a\u00020iH\u0002J\u0012\u0010Ä\u0001\u001a\u00020i2\t\u0010Å\u0001\u001a\u0004\u0018\u00010'J\u0012\u0010Æ\u0001\u001a\u00020i2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0002J\u001b\u0010È\u0001\u001a\u00020i2\u0007\u0010½\u0001\u001a\u00020\u00122\u0007\u0010É\u0001\u001a\u00020\u0012H\u0016J\u000f\u0010Ê\u0001\u001a\u00020i2\u0006\u0010j\u001a\u00020<J\u0012\u0010Ë\u0001\u001a\u00020i2\u0007\u0010Ì\u0001\u001a\u00020\u0012H\u0002J\u0007\u0010Í\u0001\u001a\u00020iJ\u0010\u0010Î\u0001\u001a\u00020i2\u0007\u0010\u0089\u0001\u001a\u00020\u0012J\u0012\u0010Ï\u0001\u001a\u00020i2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u000eJ\t\u0010Ð\u0001\u001a\u00020iH\u0002J\u0007\u0010Ñ\u0001\u001a\u00020iJ\t\u0010Ò\u0001\u001a\u00020iH\u0002J\u0007\u0010Ó\u0001\u001a\u00020iJ\u0014\u0010Ô\u0001\u001a\u00020i2\t\u0010Õ\u0001\u001a\u0004\u0018\u00010RH\u0002J\u0014\u0010Ö\u0001\u001a\u00020i2\t\u0010×\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u0015\u0010Ø\u0001\u001a\u00020i2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001H\u0002J\t\u0010Û\u0001\u001a\u00020iH\u0002J\t\u0010Ü\u0001\u001a\u00020iH\u0002J\u0012\u0010Ý\u0001\u001a\u00020i2\u0007\u0010Þ\u0001\u001a\u00020\u0012H\u0002J\"\u0010ß\u0001\u001a\u000f\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002030à\u00012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0002J\"\u0010á\u0001\u001a\u000f\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002030à\u00012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0002J\t\u0010â\u0001\u001a\u00020iH\u0002J\u0015\u0010ã\u0001\u001a\u00020i2\n\u0010¿\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0002R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010?\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010A\u0012\u0006\u0012\u0004\u0018\u00010A\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u0002030MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010T\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006æ\u0001"}, d2 = {"Lcom/android/contacts/calllog/NewCallLogFragment;", "Landroidx/fragment/app/ListFragment;", "Lcom/android/contacts/activities/DialtactsActivity$ViewPagerVisibilityListener;", "Lcom/android/contacts/calllog/CallLogQueryHandler$Listener;", "Lcom/android/contacts/calllog/CallLogAdapter$CallFetcher;", "Landroid/view/View$OnClickListener;", "Lcom/obricOld/contacts/menus/LongMenuHelper$OnMenuItemClickedListener;", "Lcom/android/contacts/activities/DialtactsActivity$PageEnableListener;", "Landroid/widget/AbsListView$OnScrollListener;", "Lcom/android/contacts/activities/DialtactsActivity$onBackPressListener;", "Lcom/android/contacts/DSUtils$DSFatureStatusListener;", "Lobric/widget/ButtonTabGroup$OnButtonGroupItemClickListener;", "()V", CallLogListAdapter.PAYLOAD_SELECTION, "", "result", "", "initHasCallLog", "", ContactCalllogsActivity.EXTRA_CONTACT_HAS_MORE_NUMBERS, "(Ljava/lang/String;Ljava/util/List;ZZ)V", "blankView", "Lcom/obric/oui/status/OPageStatus;", "<set-?>", "Lcom/android/contacts/calllog/CallLogAdapter;", "callLogAdapter", "getCallLogAdapter", "()Lcom/android/contacts/calllog/CallLogAdapter;", "callSummaryFinishedListener", "com/android/contacts/calllog/NewCallLogFragment$callSummaryFinishedListener$1", "Lcom/android/contacts/calllog/NewCallLogFragment$callSummaryFinishedListener$1;", "currentVisibleContact", "", "getCurrentVisibleContact", "()Ljava/util/List;", "isEditMode", "isInMissCallsPage", "()Z", "mBottomDeleteLayoutListener", "Lcom/android/contacts/list/BottomDeleteLayoutListener;", "mBtnEdit", "Landroid/view/View;", "mCallLogQueryHandler", "Lcom/android/contacts/calllog/CallLogQueryHandler;", "mCallLogTitleView", "Lcom/obric/oui/text/OTextView;", "mCalllogAnimator", "Lcom/obric/anim/ListAnimator;", "mContactHasMoreNumbers", "mContactTitleBarCenterView", "mCurTabIndex", "", "mDeleteConfirmDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "mEmptyView", "mEmptyViewStub", "Landroid/view/ViewStub;", "mForceTouchController", "Lcom/android/contacts/forcetouch/ForceTouchController;", "mFragmentsCallback", "Lcom/android/contacts/ContactFragmentsCallback;", "mHandler", "Landroid/os/Handler;", "mHasRecordTask", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "mHeaderHeight", "mInitHasCallLog", "mIsDeletingCallLogs", "mIsShowSingleContactCalls", "mItemLongClickedListener", "Lcom/android/contacts/list/HorizontalScrollListView$ItemLongClickedListener;", "mKeyguardManager", "Landroid/app/KeyguardManager;", "mLongMenuHelper", "Lcom/obricOld/contacts/menus/LongMenuHelper;", "mNavigationBarObserver", "Landroidx/lifecycle/Observer;", "mOALLTabSegmentedLayout", "Lcom/obric/oui/tab/OTabLayout;", "mPendingClearMissedCall", "mPopover", "Lcom/obric/oui/popover/v2/OPopover;", "mProviderIsNormal", "mResult", "mSelectedAll", "Lcom/android/contacts/widget/SelectAllState;", "mSelection", "mSimId", "mSlideListView", "Lcom/android/contacts/list/SlideListView;", "mSlideListener", "Lcom/android/contacts/list/SlideListView$Listener;", "mTitleBarHolder", "Lcom/obric/ui/OFloatingTitleBarHolder;", "mVisibilityChanged", "mVoicemailSourcesAvailable", "mVoicemailStatusHelper", "Lcom/android/contacts/voicemail/VoicemailStatusHelper;", "secondaryHintTextView", "Landroid/widget/TextView;", "summaryListener", "Lcom/obric/model/CallFeatureModel$CallFeatureModelListener;", "backToTopState", "checkHasRecord", "", "callback", "Lkotlin/Function1;", "", "clickTitleBar", "pos", "compareSipAddresses", "number1", "number2", "dismissLongMenu", "doRemoveAction", "endEditAnimation", "endEditMode", "withAnimation", "endEditWithoutAnimation", "equalNumbers", "fetchCalls", "getBlockedCallMenu", "Lcom/obric/ui/popover/MenuItemData;", "isBlockedCallAddStatus", "getCallLogListItemView", "Lcom/obric/utils/commonitemview/CallLogItemCardView;", "root", "getCursorValue", "", "cursor", "Landroid/database/Cursor;", "columnIndex", "hasItemVisible", "position", "proportionLevel", "", "hasRecord", "selectedIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSameDay", "cal1", "Ljava/util/Calendar;", "cal2", "markNumber", "pal", "Lcom/android/contacts/calllog/CallLogAdapter$PrimaryActionListener;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onButtonGroupItemClick", "child", "onCallsFetched", "onClick", "view", "onClickMenu", "clickView", "onCreate", "state", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedState", "onDSFeatureStatusChanged", "onDestroy", "onDestroyView", "onMenuItemClicked", "menuType", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "onPause", "onResume", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "onSelectAllClick", "onStop", "onViewCreated", "savedInstanceState", "onVisibilityChanged", "visible", "onVoicemailStatusFetched", "statusCursor", "refreshData", "scene", "refreshUI", "removeMissedCallNotifications", "setBottomDeleteLayoutListener", "listener", "setEmptyViews", "forSingle", "setEnable", "triggerload", "setFragmentsCallback", "setVoicemailSourcesAvailable", "voicemailSourcesAvailable", "showDeleteCallLogDialog", "showDeleteConfirmDialog", "startCallsQuery", "startEditAnimation", "startEditMode", "startVoicemailStatusQuery", "stopRequestProcessing", "tryShowBlockedCallRedBadge", "popover", "unMarkNumber", "number", "updateCallLogFilter", "context", "Landroid/content/Context;", "updateOnEntry", "updateOnExit", "updateOnTransition", "onEntry", "updatePositionIdMap", "", "updatePositionIdMapMin", "updateVoicemailNotifications", "updateVoicemailStatusMessage", "Companion", "DeleteCallLogTask", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewCallLogFragment extends ListFragment implements DialtactsActivity.ViewPagerVisibilityListener, CallLogQueryHandler.Listener, CallLogAdapter.CallFetcher, View.OnClickListener, LongMenuHelper.OnMenuItemClickedListener, DialtactsActivity.PageEnableListener, AbsListView.OnScrollListener, DialtactsActivity.onBackPressListener, DSUtils.DSFatureStatusListener, ButtonTabGroup.OnButtonGroupItemClickListener {
    public static final Companion Companion = null;
    private static final int DELAY_UPDATE_TRANSITION = 900;
    private static final boolean FEATURE_CMCC_CU = false;
    private static final int MESSAGE_UPDATE_TRANSITION = 10;
    private static final int REQUEST_CODE_GET_NUMBER_MARK = 1009;
    private static final int START_QUERY_CALLLOG = 1000;
    private static final String SUB_TAG_ALL = "CALL_LOG_ALL";
    private static final String SUB_TAG_SINGLE = "CALL_LOG_SINGLE";
    private static final int TAB_INDEX_ALL = 0;
    private static final int TAB_INDEX_SIM1_OR_MISSED = 1;
    private static final int TAB_INDEX_SIM2 = 2;
    private static final String TAG = "NewCallLogFragment";
    private static final LongMenuHelper.MenuType[] sLongMenuItemsContacts = null;
    private static final LongMenuHelper.MenuType[] sLongMenuItemsSingle = null;
    private static final LongMenuHelper.MenuType[] sLongMenuItemsStranger = null;
    private OPageStatus blankView;
    private CallLogAdapter callLogAdapter;
    private final NewCallLogFragment$callSummaryFinishedListener$1 callSummaryFinishedListener;
    private boolean isEditMode;
    private boolean isInMissCallsPage;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private View mBtnEdit;
    private CallLogQueryHandler mCallLogQueryHandler;
    private OTextView mCallLogTitleView;
    private final ListAnimator mCalllogAnimator;
    private boolean mContactHasMoreNumbers;
    private View mContactTitleBarCenterView;
    private int mCurTabIndex;
    private OAlertDialog mDeleteConfirmDialog;
    private View mEmptyView;
    private ViewStub mEmptyViewStub;
    private ForceTouchController mForceTouchController;
    private ContactFragmentsCallback mFragmentsCallback;
    private final Handler mHandler;
    private AsyncTask<Void, Void, Boolean> mHasRecordTask;
    private int mHeaderHeight;
    private boolean mInitHasCallLog;
    private boolean mIsDeletingCallLogs;
    private boolean mIsShowSingleContactCalls;
    private final HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private KeyguardManager mKeyguardManager;
    private LongMenuHelper mLongMenuHelper;
    private final Observer<Integer> mNavigationBarObserver;
    private OTabLayout mOALLTabSegmentedLayout;
    private boolean mPendingClearMissedCall;
    private OPopover mPopover;
    private boolean mProviderIsNormal;
    private List<String> mResult;
    private SelectAllState mSelectedAll;
    private String mSelection;
    private int mSimId;
    private SlideListView mSlideListView;
    private final SlideListView.Listener mSlideListener;
    private OFloatingTitleBarHolder mTitleBarHolder;
    private boolean mVisibilityChanged;
    private boolean mVoicemailSourcesAvailable;
    private VoicemailStatusHelper mVoicemailStatusHelper;
    private TextView secondaryHintTextView;
    private final CallFeatureModel.CallFeatureModelListener summaryListener;

    /* JADX INFO: compiled from: NewCallLogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/calllog/NewCallLogFragment$Companion;", "", "()V", "DELAY_UPDATE_TRANSITION", "", "FEATURE_CMCC_CU", "", "MESSAGE_UPDATE_TRANSITION", "REQUEST_CODE_GET_NUMBER_MARK", "START_QUERY_CALLLOG", "SUB_TAG_ALL", "", "SUB_TAG_SINGLE", "TAB_INDEX_ALL", "TAB_INDEX_SIM1_OR_MISSED", "TAB_INDEX_SIM2", "TAG", "sLongMenuItemsContacts", "", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "[Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "sLongMenuItemsSingle", "sLongMenuItemsStranger", "hasMultiSimInDevice", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean hasMultiSimInDevice() {
            if (MultiSimAdapter.isMultiSimEnabled() == true) goto L5;
            return false;
        L5:
            if (MultiSimAdapter.hasIccCard(0) == true) goto L7;
            return false;
        L7:
            if (MultiSimAdapter.hasIccCard(1) == true) goto L9;
            return false;
        L9:
            return true;
        }
    }

    /* JADX INFO: compiled from: NewCallLogFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u000020\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJS\u0010\t\u001a\u0004\u0018\u00010\u00052B\u0010\n\u001a\"\u0012\u001e\b\u0001\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00040\u000b\"\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0004H\u0014¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/contacts/calllog/NewCallLogFragment$DeleteCallLogTask;", "Landroid/os/AsyncTask;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/lang/Void;", "mResolver", "Landroid/content/ContentResolver;", "(Lcom/android/contacts/calllog/NewCallLogFragment;Landroid/content/ContentResolver;)V", "doInBackground", "params", "", "([Ljava/util/ArrayList;)Ljava/lang/Void;", "onPostExecute", "", "aVoid", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DeleteCallLogTask extends AsyncTask<ArrayList<Long>, Void, Void> {
        private final ContentResolver mResolver;
        final /* synthetic */ NewCallLogFragment this$0;

        public DeleteCallLogTask(NewCallLogFragment r2, ContentResolver r3) {
            Intrinsics.checkNotNullParameter(r3, "mResolver");
            this.this$0 = r2;
            this.mResolver = r3;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(ArrayList<Long>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(ArrayList<Long>... r7) {
            Intrinsics.checkNotNullParameter(r7, "params");
            ArrayList<Long> r8 = r7[0];
            if (r8 != null) goto L5;
        L16:
            return null;
        L5:
            if (r8.isEmpty() == true) goto L16;
            StringBuilder r2 = new StringBuilder("_id IN (");
            Iterator<Long> r9 = r8.iterator();
            boolean r3 = true;
        L9:
            if (r9.hasNext() == false) goto L15;
            Long r4 = r9.next();
            if (r3 == false) goto L13;
            r3 = false;
        L14:
            r2.append(r4);
            goto L9
        L13:
            r2.append(", ");
            goto L14
        L15:
            r2.append(")");
            this.mResolver.delete(CallLog.Calls.CONTENT_URI, r2.toString(), null);
            goto L16
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r2) {
            CallLogAdapter r3 = this.this$0.getCallLogAdapter();
            if (r3 == null) goto L5;
            r3.clearHashSet();
        L5:
            NewCallLogFragment.access$setMIsDeletingCallLogs$p(this.this$0, false);
            NewCallLogFragment.access$endEditMode(this.this$0, true);
            NewCallLogFragment.access$refreshData(this.this$0, "CallLogFragment onPostExecute");
        }
    }

    /* JADX INFO: compiled from: NewCallLogFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LongMenuHelper.MenuType.values().length];
            r0[LongMenuHelper.MenuType.MENU_DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[LongMenuHelper.MenuType.MENU_BLACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[LongMenuHelper.MenuType.MENU_COPY_NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[LongMenuHelper.MenuType.MENU_FLAG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[LongMenuHelper.MenuType.MENU_CREATE_CONTACTS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.NewCallLogFragment$onClickMenu$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NewCallLogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.NewCallLogFragment$onClickMenu$1", f = "NewCallLogFragment.kt", i = {0}, l = {862}, m = "invokeSuspend", n = {"items"}, s = {"L$0"})
    static final class C01431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $act;
        final /* synthetic */ View $clickView;
        Object L$0;
        int label;
        final /* synthetic */ NewCallLogFragment this$0;

        C01431(FragmentActivity r1, NewCallLogFragment r2, View r3, Continuation<? super C01431> r4) {
            this.$act = r1;
            this.this$0 = r2;
            this.$clickView = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01431(this.$act, this.this$0, this.$clickView, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01431) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ArrayList r3 = (ArrayList) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r4 = r18;
        L12:
            boolean r5 = ((Boolean) r4).booleanValue();
            r3.add(NewCallLogFragment.access$getBlockedCallMenu(this.this$0, r5));
            ItemType r6 = ItemType.TEXT;
            Integer r7 = Boxing.boxInt(R.drawable.menu_item_settings_icon);
            String r8 = this.this$0.getString(R.string.common_settings);
            final NewCallLogFragment r13 = this.this$0;
            r3.add(new MenuItemData(r6, r7, null, null, r8, null, null, null, null, new C00171(r13), false, 1024, null));
            NewCallLogFragment.access$setMPopover$p(this.this$0, OUIPopoverHelper.genPopover$default(this.$act, r3, false, 4, null));
            FragmentActivity r9 = this.$act;
            OPopover r10 = NewCallLogFragment.access$getMPopover$p(this.this$0);
            Intrinsics.checkNotNull(r10);
            OUIPopoverHelper.showPopupAtAnchorView(r9, r10, Direct.BOTTOM_LEFT, this.$clickView, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            ArrayList r11 = new ArrayList();
            BlockedDataRequester r12 = BlockedDataRequester.INSTANCE;
            ContentResolver r14 = this.$act.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(r14, "act.contentResolver");
            this.L$0 = r11;
            this.label = 1;
            r4 = r12.queryBlockedCallAddStatusAsync(r14, this);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r3 = r11;
            goto L12
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1uFcn-Tg1f0KhXyaFSj6h9F4-xs, reason: not valid java name */
    public static /* synthetic */ void m127$r8$lambda$1uFcnTg1f0KhXyaFSj6h9F4xs(NewCallLogFragment r0, int r1, DialogInterface r2, int r3) {
        showDeleteConfirmDialog$lambda$21$lambda$19(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$4XvCl8o31PLkI8Kbk9MCtE7ELnc(NewCallLogFragment r0, View r1) {
        onCreateView$lambda$13$lambda$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$KYAVB6XkR89G7eCbnWYy_45_lcw(NewCallLogFragment r0, View r1) {
        onCreateView$lambda$13$lambda$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$LwK31Ky5Bt4nlQGwNES2DJacrSM(NewCallLogFragment r0, View r1) {
        onCreateView$lambda$1$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$SEYrulZ5e-rEFyLh5egm6h0f6EU, reason: not valid java name */
    public static /* synthetic */ boolean m128$r8$lambda$SEYrulZ5erEFyLh5egm6h0f6EU(NewCallLogFragment r0, View r1, MotionEvent r2) {
        return onViewCreated$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$UTN7kc_J224sjRegbcMe8atVD94(NewCallLogFragment r0, View r1) {
        onCreateView$lambda$13$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$UpHUJ8atP6zJUn8eoH7tGOa8F1w(NewCallLogFragment r0, int r1, DialogInterface r2, int r3) {
        showDeleteConfirmDialog$lambda$21$lambda$20(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ebyqkvbQcjyyg-KlLJwJx_DUuaQ, reason: not valid java name */
    public static /* synthetic */ void m129$r8$lambda$ebyqkvbQcjyygKlLJwJx_DUuaQ(NewCallLogFragment r0) {
        removeMissedCallNotifications$lambda$28(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$rcfG5W4FJgaNoASgk6tJRh-kdsI, reason: not valid java name */
    public static /* synthetic */ void m130$r8$lambda$rcfG5W4FJgaNoASgk6tJRhkdsI(NewCallLogFragment r0, View r1) {
        onCreateView$lambda$13$lambda$12$lambda$10(r0, r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    public static final /* synthetic */ void access$endEditMode(NewCallLogFragment r0, boolean r1) {
        r0.endEditMode(r1);
    }

    public static final /* synthetic */ MenuItemData access$getBlockedCallMenu(NewCallLogFragment r0, boolean r1) {
        return r0.getBlockedCallMenu(r1);
    }

    public static final /* synthetic */ CallLogItemCardView access$getCallLogListItemView(NewCallLogFragment r0, View r1) {
        return r0.getCallLogListItemView(r1);
    }

    public static final /* synthetic */ ContactFragmentsCallback access$getMFragmentsCallback$p(NewCallLogFragment r0) {
        return r0.mFragmentsCallback;
    }

    public static final /* synthetic */ Handler access$getMHandler$p(NewCallLogFragment r0) {
        return r0.mHandler;
    }

    public static final /* synthetic */ boolean access$getMIsShowSingleContactCalls$p(NewCallLogFragment r0) {
        return r0.mIsShowSingleContactCalls;
    }

    public static final /* synthetic */ LongMenuHelper access$getMLongMenuHelper$p(NewCallLogFragment r0) {
        return r0.mLongMenuHelper;
    }

    public static final /* synthetic */ OPopover access$getMPopover$p(NewCallLogFragment r0) {
        return r0.mPopover;
    }

    public static final /* synthetic */ SlideListView access$getMSlideListView$p(NewCallLogFragment r0) {
        return r0.mSlideListView;
    }

    public static final /* synthetic */ LongMenuHelper.MenuType[] access$getSLongMenuItemsContacts$cp() {
        return sLongMenuItemsContacts;
    }

    public static final /* synthetic */ LongMenuHelper.MenuType[] access$getSLongMenuItemsSingle$cp() {
        return sLongMenuItemsSingle;
    }

    public static final /* synthetic */ LongMenuHelper.MenuType[] access$getSLongMenuItemsStranger$cp() {
        return sLongMenuItemsStranger;
    }

    public static final /* synthetic */ boolean access$hasRecord(NewCallLogFragment r0, ArrayList r1) {
        return r0.hasRecord(r1);
    }

    public static final /* synthetic */ void access$refreshData(NewCallLogFragment r0, String r1) {
        r0.refreshData(r1);
    }

    public static final /* synthetic */ void access$setEmptyViews(NewCallLogFragment r0, boolean r1) {
        r0.setEmptyViews(r1);
    }

    public static final /* synthetic */ void access$setMIsDeletingCallLogs$p(NewCallLogFragment r0, boolean r1) {
        r0.mIsDeletingCallLogs = r1;
    }

    public static final /* synthetic */ void access$setMPopover$p(NewCallLogFragment r0, OPopover r1) {
        r0.mPopover = r1;
    }

    public static final /* synthetic */ void access$updateOnEntry(NewCallLogFragment r0) {
        r0.updateOnEntry();
    }

    public final CallLogAdapter getCallLogAdapter() {
        return this.callLogAdapter;
    }

    public final boolean isInMissCallsPage() {
        return this.isInMissCallsPage;
    }

    public final void setFragmentsCallback(ContactFragmentsCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mFragmentsCallback = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        Agent r5 = Agent.getInstance();
        if (this.mIsShowSingleContactCalls == false) goto L5;
        String r0 = SUB_TAG_SINGLE;
    L6:
        r5.onAttach(TAG, r0);
        FragmentActivity r1 = getActivity();
        Object r2 = null;
        if (r1 == null) goto L9;
        ContentResolver r3 = r1.getContentResolver();
    L10:
        this.mCallLogQueryHandler = new CallLogQueryHandler(r3, this);
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L13;
        r2 = r6.getSystemService("keyguard");
    L13:
        this.mKeyguardManager = (KeyguardManager) r2;
        if (DSUtils.isMultiSimEnabled() == false) goto L23;
        DSUtils.registerDSFeatureStatusListener(this);
        if (DSUtils.sShouldUpdateShowSimIcon == false) goto L23;
        if (DSUtils.useDSFeature() == false) goto L23;
        CallLogQueryHandler r7 = this.mCallLogQueryHandler;
        if (r7 == null) goto L22;
        r7.updateShowSimId();
    L22:
        DSUtils.sShouldUpdateShowSimIcon = false;
    L23:
        this.mLongMenuHelper = new LongMenuHelper(getActivity(), this);
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r0 = SUB_TAG_ALL;
        goto L6
    }

    public NewCallLogFragment() {
        this.mInitHasCallLog = true;
        this.mSimId = -1;
        this.mNavigationBarObserver = new NewCallLogFragment$mNavigationBarObserver$1(this);
        this.mSlideListener = new NewCallLogFragment$mSlideListener$1(this);
        this.mItemLongClickedListener = new NewCallLogFragment$mItemLongClickedListener$1(this);
        this.mCalllogAnimator = new ListAnimator(new int[]{R.id.top_container, R.id.call_log_summary_card_view, R.id.item_divider}, new int[]{R.id.end_icon}, new int[]{R.id.icon_container, R.id.end_icon});
        this.summaryListener = new NewCallLogFragment$summaryListener$1(this);
        this.callSummaryFinishedListener = new NewCallLogFragment$callSummaryFinishedListener$1(this);
        this.mHandler = new NewCallLogFragment$mHandler$1(this);
        this.mProviderIsNormal = true;
        this.mIsShowSingleContactCalls = false;
    }

    public NewCallLogFragment(String r7, List<String> r8, boolean r9, boolean r10) {
        this.mInitHasCallLog = true;
        this.mSimId = -1;
        this.mNavigationBarObserver = new NewCallLogFragment$mNavigationBarObserver$1(this);
        this.mSlideListener = new NewCallLogFragment$mSlideListener$1(this);
        this.mItemLongClickedListener = new NewCallLogFragment$mItemLongClickedListener$1(this);
        this.mCalllogAnimator = new ListAnimator(new int[]{R.id.top_container, R.id.call_log_summary_card_view, R.id.item_divider}, new int[]{R.id.end_icon}, new int[]{R.id.icon_container, R.id.end_icon});
        this.summaryListener = new NewCallLogFragment$summaryListener$1(this);
        this.callSummaryFinishedListener = new NewCallLogFragment$callSummaryFinishedListener$1(this);
        this.mHandler = new NewCallLogFragment$mHandler$1(this);
        this.mProviderIsNormal = true;
        this.mContactHasMoreNumbers = r10;
        this.mSelection = r7;
        this.mResult = r8;
        this.mIsShowSingleContactCalls = true;
        this.mInitHasCallLog = r9;
    }

    @Override // com.android.contacts.calllog.CallLogQueryHandler.Listener
    public void onCallsFetched(Cursor r12) {
        Intrinsics.checkNotNullParameter(r12, "cursor");
        if (getActivity() == null) goto L61;
        FragmentActivity r0 = getActivity();
        boolean r2 = false;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L61;
        if (isAdded() == false) goto L61;
        if (getContext() == null) goto L61;
        if (ContactsUtils.DEBUG == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onCallsFetched cursor count:" + r12.getCount());
    L20:
        if (this.callLogAdapter != null) goto L22;
        CallLogAdapter r10 = new CallLogAdapter(getActivity(), this, new ContactInfoHelper(getActivity(), ContactsUtils.getCurrentCountryIso(getActivity())), this, this.mIsShowSingleContactCalls, this.mContactHasMoreNumbers);
        this.callLogAdapter = r10;
        r10.setItemLongClickedListener(this.mItemLongClickedListener);
    L22:
        ContactsUtils.updateDateAndTimeFormat();
        SlideListView r3 = this.mSlideListView;
        if (r3 == null) goto L25;
        ListAdapter r4 = r3.getAdapter();
    L26:
        if (r4 != null) goto L43;
        SlideListView r5 = this.mSlideListView;
        if (r5 == null) goto L30;
        r5.setAdapter(this.callLogAdapter);
    L30:
        ForceTouchController r6 = this.mForceTouchController;
        if (r6 == null) goto L33;
        r6.setAdapter(this.callLogAdapter);
    L33:
        SlideListView r7 = this.mSlideListView;
        if (r7 == null) goto L36;
        r7.setAutoClose(false);
    L36:
        CallLogAdapter r8 = this.callLogAdapter;
        if (r8 == null) goto L40;
        r8.mHSListView = this.mSlideListView;
    L40:
        SlideListView r9 = this.mSlideListView;
        if (r9 == null) goto L43;
        r9.setOnScrollStateChangeListener(this.callLogAdapter);
    L43:
        CallLogAdapter r11 = this.callLogAdapter;
        if (r11 == null) goto L46;
        r11.setLoading(false);
    L46:
        CallLogAdapter r13 = this.callLogAdapter;
        if (r13 == null) goto L50;
        r13.changeCursor(r12);
    L50:
        if (r12.getCount() != 0) goto L52;
        setEmptyViews(this.mIsShowSingleContactCalls);
    L52:
        CallLogAdapter r14 = this.callLogAdapter;
        if (r14 != null) goto L55;
    L57:
        if (r2 == false) goto L59;
        endEditMode(true);
    L59:
        refreshUI();
        return;
    L55:
        if (r14.isEmpty() != true) goto L57;
        r2 = true;
        goto L57
    L25:
        r4 = null;
        goto L26
    L7:
        if (r0.isFinishing() != true) goto L9;
        r1 = true;
    L61:
        MoreCloseables.closeQuietly(r12);
    }

    private final CallLogItemCardView getCallLogListItemView(View r1) {
        return (CallLogItemCardView) r1;
    }

    @Override // com.android.contacts.calllog.CallLogQueryHandler.Listener
    public void onVoicemailStatusFetched(Cursor r4) {
        FragmentActivity r0 = getActivity();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        MoreCloseables.closeQuietly(r4);
        return;
    L11:
        updateVoicemailStatusMessage(r4);
        VoicemailStatusHelper r3 = this.mVoicemailStatusHelper;
        if (r3 == null) goto L14;
        Integer r5 = Integer.valueOf(r3.getNumberActivityVoicemailSources(r4));
    L15:
        if (r5 != null) goto L18;
    L21:
        setVoicemailSourcesAvailable(r1);
        MoreCloseables.closeQuietly(r4);
        return;
    L18:
        if (r5.intValue() != 0) goto L21;
        r1 = false;
        goto L21
    L14:
        r5 = null;
        goto L15
    L5:
        if (r0.isFinishing() != true) goto L7;
        r2 = true;
        goto L8
    }

    private final void setVoicemailSourcesAvailable(boolean r2) {
        if (this.mVoicemailSourcesAvailable != r2) goto L5;
        return;
    L5:
        this.mVoicemailSourcesAvailable = r2;
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r19, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r19, "inflater");
        if (this.mIsShowSingleContactCalls == false) goto L5;
        View r2 = r19.inflate(R.layout.contact_detail_calllog_fragment, r20, false);
        Intrinsics.checkNotNullExpressionValue(r2, "inflater.inflate(R.layou…agment, container, false)");
    L6:
        View r6 = r2;
        this.mVoicemailStatusHelper = new VoicemailStatusHelperImpl();
        OFloatingTitleBar r3 = (OFloatingTitleBar) r6.findViewById(R.id.otitlebar);
        Intrinsics.checkNotNull(r3);
        this.mTitleBarHolder = new OFloatingTitleBarHolder(r3);
        ViewStub r4 = null;
        if (this.mIsShowSingleContactCalls == true) goto L9;
        String[] r7 = {getString(R.string.tab_all), getString(R.string.tab_missed_calls), getString(R.string.tab_missed_calls)};
        if (FEATURE_CMCC_CU == false) goto L19;
        List r5 = CollectionsKt.listOf(Arrays.copyOf(r7, 3));
    L20:
        View r8 = LayoutInflater.from(getContext()).inflate(R.layout.content_title_segmentedlayout, null, false);
        this.mContactTitleBarCenterView = r8;
        if (r8 == null) goto L23;
        OTabLayout r9 = (OTabLayout) r8.findViewById(R.id.tab_layout_title);
    L24:
        this.mOALLTabSegmentedLayout = r9;
        if (r9 == null) goto L28;
        r9.setTabMode(0);
    L28:
        Iterator r10 = r5.iterator();
        int r11 = 0;
    L30:
        if (r10.hasNext() == false) goto L42;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        String r14 = (String) r12;
        OTabLayout r15 = this.mOALLTabSegmentedLayout;
        if (r15 == null) goto L37;
        OTabLayoutBase.Tab r16 = r15.getTabAt(r11);
    L38:
        if (r16 == null) goto L41;
        r16.setText(r14);
    L41:
        r11 = r13;
        goto L30
    L37:
        r16 = null;
        goto L38
    L42:
        OTabLayout r17 = this.mOALLTabSegmentedLayout;
        if (r17 == null) goto L45;
        r17.addOnTabSelectedListener(new AnonymousClass3(this));
    L45:
        View r18 = this.mContactTitleBarCenterView;
        if (r18 == null) goto L52;
        r18.setLayoutParams(new ViewGroup.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()))));
        OFloatingTitleBarHolder r22 = this.mTitleBarHolder;
        if (r22 == null) goto L52;
        OFloatingTitleBar r23 = r22.getTitleBar();
        if (r23 == null) goto L52;
        r23.setCenterCustomView(r18);
    L52:
        this.mCurTabIndex = 0;
        OTabLayout r24 = this.mOALLTabSegmentedLayout;
        if (r24 == null) goto L55;
        r24.selectTab(0);
    L55:
        OTabLayout r25 = this.mOALLTabSegmentedLayout;
        if (r25 == null) goto L62;
        OTabLayoutBase.Tab r26 = r25.getTabAt(0);
        if (r26 == null) goto L62;
        OTabLayoutBase.TabView r27 = r26.getView();
        if (r27 == null) goto L62;
        r27.setContentDescription(getString(R.string.accessibility_tab_all_description));
    L62:
        FragmentActivity r28 = getActivity();
        if (r28 == null) goto L67;
        Resources r29 = r28.getResources();
        if (r29 == null) goto L67;
        int r30 = r29.getDimensionPixelSize(R.dimen.calllog_edit_header_height);
    L68:
        this.mHeaderHeight = r30;
        if (FEATURE_CMCC_CU == false) goto L71;
        updateCallLogFilter(getActivity());
    L71:
        FragmentActivity r31 = getActivity();
        if (r31 == null) goto L75;
        OTextView r32 = new OTextView(r31, null, 0, null, 14, null);
        r32.setGravity(17);
        r32.setSingleLine(true);
        r32.setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 22, Resources.getSystem().getDisplayMetrics())));
        r32.setMaxLines(1);
        r32.setEllipsize(TextUtils.TruncateAt.END);
        r32.setTextAppearance(R.style.Title_1_Bold);
        r32.setTextColor(ResourcesCompat.getColor(r32.getResources(), R.color.oui_basic_text_1, null));
        FrameLayout.LayoutParams r33 = new FrameLayout.LayoutParams(-2, -2);
        r33.gravity = 17;
        r32.setLayoutParams(r33);
        this.mCallLogTitleView = r32;
    L75:
        if (getActivity() != null) goto L77;
    L120:
        View r34 = r6.findViewById(R.id.listview_emptyview_stub);
        if ((r34 instanceof ViewStub) == false) goto L123;
        r4 = (ViewStub) r34;
    L123:
        this.mEmptyViewStub = r4;
        ListView r35 = (ListView) r6.findViewById(android.R.id.list);
        if (r35 != null) goto L126;
    L130:
        return r6;
    L126:
        if (this.mIsShowSingleContactCalls == false) goto L128;
        int r0 = OUIHelper.OUIList.getFooterHeight100();
    L129:
        OUIHelper.OUIList.setFooterAndHeader$default(r19, r35, null, Integer.valueOf(r0), 4, null);
        goto L130
    L128:
        r0 = OUIHelper.OUIList.getFooterHeight184();
        goto L129
    L77:
        if (this.mIsShowSingleContactCalls == false) goto L81;
        OFloatingTitleBarHolder r36 = this.mTitleBarHolder;
        if (r36 == null) goto L84;
        View r37 = OFloatingTitleBarHolder.addEndAction$default(r36, OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_multi_select_selector, null, 4, null);
    L85:
        this.mBtnEdit = r37;
        if (r37 == null) goto L89;
        r37.setContentDescription(getString(R.string.common_edit));
    L89:
        View r38 = this.mBtnEdit;
        if (r38 == null) goto L93;
        r38.setOnClickListener(new NewCallLogFragment$$ExternalSyntheticLambda2(this));
    L93:
        if (this.mIsShowSingleContactCalls == true) goto L101;
        OFloatingTitleBarHolder r39 = this.mTitleBarHolder;
        if (r39 == null) goto L97;
        View r40 = r39.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_menu_more, new NewCallLogFragment$$ExternalSyntheticLambda3(this));
    L98:
        if (r40 == null) goto L101;
        r40.setContentDescription(getString(R.string.more_btn));
        goto L101
    L97:
        r40 = null;
    L101:
        OFloatingTitleBarHolder r41 = this.mTitleBarHolder;
        if (r41 == null) goto L104;
        r41.addStartAction(OFloatingTitleBarHolder.STATE_EDIT, R.drawable.icon_cancel_22_22, new NewCallLogFragment$$ExternalSyntheticLambda4(this)).setContentDescription(getString(R.string.accessibility_btn_cancel));
        r41.removeStartAction();
    L104:
        OFloatingTitleBarHolder r42 = this.mTitleBarHolder;
        if (r42 == null) goto L120;
        String r43 = getResources().getString(R.string.select_all);
        Intrinsics.checkNotNullExpressionValue(r43, "resources.getString(R.string.select_all)");
        View r44 = r42.addEndAction(OFloatingTitleBarHolder.STATE_EDIT, r43, new NewCallLogFragment$$ExternalSyntheticLambda5(this));
        r44.setContentDescription(getString(R.string.select_all));
        if ((r44 instanceof ViewGroup) == false) goto L109;
        ViewGroup r45 = (ViewGroup) r44;
    L110:
        if (r45 == null) goto L112;
        View r46 = r45.getChildAt(0);
    L114:
        if ((r46 instanceof OTextView) == false) goto L116;
        OTextView r47 = (OTextView) r46;
    L117:
        if (r47 == null) goto L119;
        r47.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        this.mSelectedAll = new SelectAllState(r47);
    L119:
        r42.removeEndAction();
        goto L120
    L116:
        r47 = null;
        goto L117
    L112:
        r46 = null;
        goto L114
    L109:
        r45 = null;
    L84:
        r37 = null;
        goto L85
    L81:
        OFloatingTitleBarHolder r48 = this.mTitleBarHolder;
        if (r48 == null) goto L84;
        r37 = OFloatingTitleBarHolder.addStartAction$default(r48, OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_multi_select_selector, null, 4, null);
    L67:
        r30 = 0;
        goto L68
    L23:
        r9 = null;
        goto L24
    L19:
        r5 = CollectionsKt.listOf(Arrays.copyOf(r7, 3)).subList(0, 2);
        goto L20
    L9:
        if (getActivity() == null) goto L75;
        OFloatingTitleBarHolder r49 = this.mTitleBarHolder;
        if (r49 == null) goto L13;
        View r50 = r49.addStartAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_back_22_22, new NewCallLogFragment$$ExternalSyntheticLambda1(this));
    L14:
        if (r50 == null) goto L75;
        r50.setContentDescription(getString(R.string.common_back));
        goto L75
    L13:
        r50 = null;
        goto L14
    L5:
        r2 = r19.inflate(R.layout.call_log_fragment, r20, false);
        Intrinsics.checkNotNullExpressionValue(r2, "inflater.inflate(R.layou…agment, container, false)");
        goto L6
    }

    private static final void onCreateView$lambda$1$lambda$0(NewCallLogFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.finish();
        return;
    }

    private static final void onCreateView$lambda$13$lambda$6(NewCallLogFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_EDIT_CALL_LOG);
        r2.startEditMode();
    }

    private static final void onCreateView$lambda$13$lambda$7(NewCallLogFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.onClickMenu(r2);
    }

    private static final void onCreateView$lambda$13$lambda$9$lambda$8(NewCallLogFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.isEditMode == true) goto L5;
        return;
    L5:
        if (r0.mIsDeletingCallLogs == true) goto L9;
        r0.endEditMode(true);
        return;
    }

    private static final void onCreateView$lambda$13$lambda$12$lambda$10(NewCallLogFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onSelectAllClick();
    }

    private final void onSelectAllClick() {
        SelectAllState r0 = this.mSelectedAll;
        if (r0 == null) goto L5;
        r0.toggle();
    L5:
        SelectAllState r1 = this.mSelectedAll;
        int r2 = 0;
        if (r1 == null) goto L8;
        boolean r3 = r1.isSelectAll();
    L9:
        CallLogAdapter r4 = this.callLogAdapter;
        if (r4 == null) goto L26;
        if (r3 == false) goto L21;
        if (r4 == null) goto L14;
        int r5 = r4.getCount();
    L15:
        if (r2 >= r5) goto L20;
        CallLogAdapter r6 = this.callLogAdapter;
        if (r6 == null) goto L19;
        r6.setChecked(r2, true);
    L19:
        r2 = r2 + 1;
        goto L15
    L20:
        refreshUI();
    L23:
        CallLogAdapter r7 = this.callLogAdapter;
        if (r7 == null) goto L26;
        r7.notifyDataSetChanged();
        goto L26
    L14:
        r5 = 0;
        goto L15
    L21:
        if (r4 == null) goto L23;
        r4.clearHashSet();
    L26:
        BottomDeleteLayoutListener r8 = this.mBottomDeleteLayoutListener;
        if (r8 == null) goto L35;
        if (r8 == null) goto L36;
        r8.setBottomBtnEnable(r3);
        return;
    L36:
        return;
    L35:
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final void setBottomDeleteLayoutListener(BottomDeleteLayoutListener r1) {
        this.mBottomDeleteLayoutListener = r1;
    }

    public final void clickTitleBar(int r5) {
        if (r5 != this.mCurTabIndex) goto L5;
        return;
    L5:
        this.mCurTabIndex = r5;
        OTabLayout r0 = this.mOALLTabSegmentedLayout;
        if (r0 == null) goto L9;
        r0.selectTab(r5);
    L9:
        if (r5 != 0) goto L11;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_ALL_CALL_LOG);
        if (this.isInMissCallsPage == false) goto L72;
        this.isInMissCallsPage = false;
        OTabLayout r6 = this.mOALLTabSegmentedLayout;
        if (r6 == null) goto L63;
        OTabLayoutBase.Tab r7 = r6.getTabAt(0);
        if (r7 == null) goto L63;
        r7.setContentDescription(getString(R.string.accessibility_tab_all_description));
    L63:
        if (FEATURE_CMCC_CU == false) goto L65;
        this.mSimId = -1;
    L65:
        CallLogAdapter r8 = this.callLogAdapter;
        if (r8 == null) goto L69;
        if (r8 == null) goto L69;
        r8.clearHashSet();
    L69:
        SlideListView r9 = this.mSlideListView;
        if (r9 == null) goto L72;
        r9.restoreScrollState(false);
    L72:
        CallLogAdapter r4 = this.callLogAdapter;
        if (r4 == null) goto L83;
        if (r4 == null) goto L84;
        r4.onContentChangedByScene("call log click title bar in TAB_INDEX_ALL");
        return;
    L84:
        return;
    L83:
        return;
    L11:
        if (r5 != 1) goto L13;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_MISSED_CALL_LOG);
        if (this.isInMissCallsPage == true) goto L33;
    L34:
        this.isInMissCallsPage = true;
        OTabLayout r10 = this.mOALLTabSegmentedLayout;
        if (r10 == null) goto L40;
        OTabLayoutBase.Tab r11 = r10.getTabAt(1);
        if (r11 == null) goto L40;
        r11.setContentDescription(getString(R.string.accessibility_tab_all_unselected));
    L40:
        if (FEATURE_CMCC_CU == true) goto L42;
    L44:
        CallLogAdapter r12 = this.callLogAdapter;
        if (r12 == null) goto L48;
        if (r12 == null) goto L48;
        r12.clearHashSet();
    L48:
        SlideListView r13 = this.mSlideListView;
        if (r13 == null) goto L51;
        r13.restoreScrollState(false);
    L51:
        CallLogAdapter r14 = this.callLogAdapter;
        if (r14 == null) goto L80;
        if (r14 == null) goto L81;
        r14.onContentChangedByScene("call log click title bar in TAB_INDEX_SIM1_OR_MISSED");
        return;
    L81:
        return;
    L80:
        return;
    L42:
        if (DSUtils.useDSFeature() == false) goto L44;
        this.mSimId = 0;
        goto L44
    L33:
        if (this.mSimId == 0) goto L51;
    L13:
        if (r5 == 2) goto L16;
        return;
    L16:
        if (this.isInMissCallsPage == true) goto L18;
    L19:
        this.isInMissCallsPage = true;
        this.mSimId = 1;
        CallLogAdapter r15 = this.callLogAdapter;
        if (r15 == null) goto L23;
        if (r15 == null) goto L23;
        r15.clearHashSet();
    L23:
        SlideListView r16 = this.mSlideListView;
        if (r16 == null) goto L26;
        r16.restoreScrollState(false);
    L26:
        CallLogAdapter r17 = this.callLogAdapter;
        if (r17 == null) goto L77;
        if (r17 == null) goto L78;
        r17.onContentChangedByScene("call log click title bar in TAB_INDEX_SIM2");
        return;
    L78:
        return;
    L77:
        return;
    L18:
        if (this.mSimId == 1) goto L26;
        goto L19
    }

    private final void updateCallLogFilter(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        OTabLayoutBase.TabView r1 = null;
        if (DSUtils.useDSFeature() == false) goto L14;
        OTabLayout r2 = this.mOALLTabSegmentedLayout;
        if (r2 == null) goto L11;
        OTabLayoutBase.Tab r4 = r2.getTabAt(1);
        if (r4 == null) goto L11;
        r1 = r4.getView();
    L11:
        if (r1 == null) goto L24;
        r1.setVisibility(0);
        return;
    L24:
        return;
    L14:
        OTabLayout r5 = this.mOALLTabSegmentedLayout;
        if (r5 == null) goto L19;
        OTabLayoutBase.Tab r6 = r5.getTabAt(1);
        if (r6 == null) goto L19;
        r1 = r6.getView();
    L19:
        if (r1 == null) goto L25;
        r1.setVisibility(8);
        return;
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ListView r5 = getListView();
        if ((r5 instanceof SlideListView) == false) goto L5;
        SlideListView r6 = (SlideListView) r5;
    L6:
        this.mSlideListView = r6;
        if (r6 == null) goto L9;
        r6.setSlideListener(this.mSlideListener);
    L9:
        SlideListView r7 = this.mSlideListView;
        if (r7 == null) goto L12;
        r7.setOnScrollListener(this);
    L12:
        SlideListView r8 = this.mSlideListView;
        if (r8 == null) goto L16;
        r8.setScrollEnabled(!this.mIsShowSingleContactCalls);
    L16:
        this.mForceTouchController = new ForceTouchController(this.mSlideListView, getActivity());
        SlideListView r9 = this.mSlideListView;
        if (r9 == null) goto L20;
        r9.setOnTouchListener(new NewCallLogFragment$$ExternalSyntheticLambda8(this));
    L20:
        if (this.mIsShowSingleContactCalls == true) goto L22;
    L24:
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L28;
        Immersive.Companion.getImmersive(r10).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        return;
    L28:
        return;
    L22:
        if (this.mInitHasCallLog == true) goto L24;
        setEmptyViews(true);
        goto L24
    L5:
        r6 = null;
        goto L6
    }

    private static final boolean onViewCreated$lambda$15(NewCallLogFragment r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r4.getActionMasked() == 0) goto L5;
    L13:
        ForceTouchController r5 = r2.mForceTouchController;
        if (r5 != null) goto L18;
        return false;
    L18:
        return r5.onTouch(r3, r4);
    L5:
        if ((r3 instanceof ListView) == false) goto L7;
        ListView r0 = (ListView) r3;
    L8:
        Intrinsics.checkNotNullExpressionValue(r4, "event");
        if (ListTouchHelper.isTouchOnFooterOrBlank(r0, r4) == false) goto L13;
        CallLogAdapter r1 = r2.callLogAdapter;
        if (r1 == null) goto L13;
        r1.closeSwipedViews();
        goto L13
    L7:
        r0 = null;
        goto L8
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        Immersive.Companion.getImmersive(r0).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
        return;
    }

    private final void setEmptyViews(boolean r5) {
        String r0 = getString(R.string.call_log_empty_secondary);
        Intrinsics.checkNotNullExpressionValue(r0, "getString(R.string.call_log_empty_secondary)");
        if (this.mEmptyView != null) goto L22;
        ViewStub r1 = this.mEmptyViewStub;
        OTextView r2 = null;
        if (r1 == null) goto L7;
        View r3 = r1.inflate();
    L8:
        this.mEmptyView = r3;
        if (r3 == null) goto L11;
        View r4 = r3.findViewById(R.id.black_view);
    L12:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.oui.status.OPageStatus");
        OPageStatus r6 = (OPageStatus) r4;
        this.blankView = r6;
        if (r6 == null) goto L15;
        r6.setTitle(getString(R.string.call_log_empty));
    L15:
        OPageStatus r7 = this.blankView;
        if (r7 == null) goto L18;
        r7.setMessage(r0);
    L18:
        OPageStatus r8 = this.blankView;
        if (r8 == null) goto L21;
        r2 = r8.getMessageView();
    L21:
        this.secondaryHintTextView = r2;
        goto L22
    L11:
        r4 = null;
        goto L12
    L7:
        r3 = null;
    L22:
        if (r5 == false) goto L24;
        r0 = getString(R.string.single_recentCalls_empty_secondary);
        Intrinsics.checkNotNullExpressionValue(r0, "getString(R.string.singl…entCalls_empty_secondary)");
    L24:
        TextView r9 = this.secondaryHintTextView;
        if (r9 == null) goto L27;
        r9.setText(r0);
    L27:
        SlideListView r10 = this.mSlideListView;
        if (r10 == null) goto L31;
        r10.setEmptyView(this.mEmptyView);
        return;
    }

    public final void dismissLongMenu() {
        LongMenuHelper r0 = this.mLongMenuHelper;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        LongMenuHelper r3 = this.mLongMenuHelper;
        if (r3 == null) goto L13;
        r3.dismiss();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r4, View r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, "menuType");
        if (this.callLogAdapter != null) goto L5;
        return false;
    L5:
        if ((r6 instanceof CallLogAdapter.PrimaryActionListener) == false) goto L47;
        FragmentActivity r0 = getActivity();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r1 != 1) goto L9;
        CallLogAdapter r3 = this.callLogAdapter;
        if (r3 == null) goto L44;
        r3.doRemoveCallLog(r5, (CallLogAdapter.PrimaryActionListener) r6);
    L44:
        return true;
    L9:
        if (r1 == 2) goto L33;
        if (r1 != 3) goto L13;
        String[] r7 = {HTTP.PLAIN_TEXT_TYPE, ClipboardReader.FORBIDDEN_CLIPBOARD_TYPE_CALL_LOG};
        ClipData.Item r8 = new ClipData.Item(((CallLogAdapter.PrimaryActionListener) r6).getNumber());
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L27;
        Object r10 = r9.getSystemService("clipboard");
    L28:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) r10).setPrimaryClip(new ClipData("number", r7, r8));
        if (r0 == null) goto L31;
        OToast.Companion r11 = OToast.Companion;
        String r12 = r0.getString(R.string.copy_success);
        Intrinsics.checkNotNullExpressionValue(r12, "activity.getString(R.string.copy_success)");
        r11.show(r0, r12, 80);
    L31:
        return true;
    L27:
        r10 = null;
        goto L28
    L13:
        if (r1 != 4) goto L15;
        CallLogAdapter.PrimaryActionListener r13 = (CallLogAdapter.PrimaryActionListener) r6;
        if (r13.isHasMarked() == false) goto L22;
        unMarkNumber(r13.getNumber());
    L23:
        return true;
    L22:
        markNumber(r13);
        goto L23
    L15:
        if (r1 != 5) goto L48;
        ((CallLogAdapter.PrimaryActionListener) r6).clickGoToDetail();
        return true;
    L48:
        return false;
    L33:
        if (r4.isHighLight == false) goto L37;
        CallLogAdapter r14 = this.callLogAdapter;
        if (r14 == null) goto L40;
        r14.removeFromBlackList(((CallLogAdapter.PrimaryActionListener) r6).getNumber());
    L40:
        return true;
    L37:
        CallLogAdapter r15 = this.callLogAdapter;
        if (r15 == null) goto L40;
        r15.addNumberToBlackList(((CallLogAdapter.PrimaryActionListener) r6).getPhoneCallDetails());
        goto L40
    L47:
        return false;
    }

    private final void markNumber(CallLogAdapter.PrimaryActionListener r6) {
        boolean r0 = r6.isHasMarked();
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L6;
        Intent r2 = new Intent(r1, NumberMarkActivity.class);
        r2.putExtra(NumberMarkActivity.EXTRA_PARAM_MARKED, r0);
        r2.putExtra(NumberMarkActivity.EXTRA_PARAM_NUMBER, r6.getNumber());
        startActivityForResult(r2, 1009);
        AnimationUtil.switchActivityAnimation(r1, 1);
        return;
    }

    private final void unMarkNumber(String r3) {
        NumberInfosManager.getInstance().clearMarkInfoAsync(r3, new C01451(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r3 == (-1)) goto L5;
        return;
    L5:
        if (r2 != 1009) goto L17;
        if (r4 == null) goto L20;
        int r5 = r4.getIntExtra("position", -1);
        NumberInfosManager.NumberInfosListenerAdatper r6 = new NewCallLogFragment$onActivityResult$listener$1(this);
        String r1 = r4.getStringExtra(NumberMarkActivity.EXTRA_PARAM_NUMBER);
        if (NumberInfosManager.Classify.isValidIndex(r5) == false) goto L11;
        NumberInfosManager.getInstance().setMarkInfoAsync(r1, r5, r6);
        return;
    L11:
        String r7 = r4.getStringExtra("flag");
        if (TextUtils.isEmpty(r7) == true) goto L14;
        NumberInfosManager.getInstance().setCustomMarkInfoAsync(r1, r7, r6);
        return;
    L14:
        NumberInfosManager.getInstance().clearMarkInfoAsync(r1, new C01421());
        return;
    L20:
        return;
    }

    @Override // obric.widget.ButtonTabGroup.OnButtonGroupItemClickListener
    public void onButtonGroupItemClick(View r4, int r5) {
        if (r5 != this.mCurTabIndex) goto L5;
        return;
    L5:
        this.mCurTabIndex = r5;
        if (r5 != 0) goto L8;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_ALL_CALL_LOG);
        if (this.isInMissCallsPage == false) goto L59;
        this.isInMissCallsPage = false;
        if (FEATURE_CMCC_CU == false) goto L52;
        this.mSimId = -1;
    L52:
        CallLogAdapter r6 = this.callLogAdapter;
        if (r6 == null) goto L56;
        if (r6 == null) goto L56;
        r6.clearHashSet();
    L56:
        SlideListView r7 = this.mSlideListView;
        if (r7 == null) goto L59;
        r7.restoreScrollState(false);
    L59:
        CallLogAdapter r3 = this.callLogAdapter;
        if (r3 == null) goto L70;
        if (r3 == null) goto L71;
        r3.onContentChangedByScene("call log onButtonGroupItemClick in TAB_INDEX_ALL");
        return;
    L71:
        return;
    L70:
        return;
    L8:
        if (r5 != 1) goto L10;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_MISSED_CALL_LOG);
        if (this.isInMissCallsPage == true) goto L30;
    L31:
        this.isInMissCallsPage = true;
        if (FEATURE_CMCC_CU == true) goto L34;
    L36:
        CallLogAdapter r8 = this.callLogAdapter;
        if (r8 == null) goto L40;
        if (r8 == null) goto L40;
        r8.clearHashSet();
    L40:
        SlideListView r9 = this.mSlideListView;
        if (r9 == null) goto L43;
        r9.restoreScrollState(false);
    L43:
        CallLogAdapter r10 = this.callLogAdapter;
        if (r10 == null) goto L67;
        if (r10 == null) goto L68;
        r10.onContentChangedByScene("call log onButtonGroupItemClick in TAB_INDEX_SIM1_OR_MISSED");
        return;
    L68:
        return;
    L67:
        return;
    L34:
        if (DSUtils.useDSFeature() == false) goto L36;
        this.mSimId = 0;
        goto L36
    L30:
        if (this.mSimId == 0) goto L43;
    L10:
        if (r5 == 2) goto L13;
        return;
    L13:
        if (this.isInMissCallsPage == true) goto L15;
    L16:
        this.isInMissCallsPage = true;
        this.mSimId = 1;
        CallLogAdapter r11 = this.callLogAdapter;
        if (r11 == null) goto L20;
        if (r11 == null) goto L20;
        r11.clearHashSet();
    L20:
        SlideListView r12 = this.mSlideListView;
        if (r12 == null) goto L23;
        r12.restoreScrollState(false);
    L23:
        CallLogAdapter r13 = this.callLogAdapter;
        if (r13 == null) goto L64;
        if (r13 == null) goto L65;
        r13.onContentChangedByScene("call log onButtonGroupItemClick in TAB_INDEX_SIM2");
        return;
    L65:
        return;
    L64:
        return;
    L15:
        if (this.mSimId == 1) goto L23;
        goto L16
    }

    private final void onClickMenu(View r9) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C01431(r0, this, r9, null), 3, null);
    }

    private final MenuItemData getBlockedCallMenu(final boolean r18) {
        if (r18 == false) goto L5;
        ItemType r2 = ItemType.TEXT_WITH_BADGE;
    L6:
        ItemType r4 = r2;
        if (r18 == false) goto L9;
        OPopoverEntranceMenuView.Builder.BadgeInfo r3 = new OPopoverEntranceMenuView.Builder.BadgeInfo(OPopoverEntranceMenuView.Builder.BadgeInfo.Style.DOT, 0, 0, 6, null);
    L10:
        Integer r5 = Integer.valueOf(R.drawable.menu_item_blocked_call_icon);
        String r8 = getString(R.string.blocked_call_log_title);
        return new MenuItemData(r4, r5, null, null, r8, null, null, null, r3, new C01411(this, r18), false, 1024, null);
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = ItemType.TEXT;
        goto L6
    }

    private final void tryShowBlockedCallRedBadge(OPopover r2) {
        if (r2 == null) goto L6;
        View r1 = r2.getPopoverView();
        if (r1 == null) goto L6;
        ViewGroup r3 = (ViewGroup) r1.findViewById(R.id.popover_container);
    L7:
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.getChildCount() > 0) goto L12;
        return;
    L12:
        View r4 = r3.getChildAt(0);
        if (r4 != null) goto L15;
        return;
    L15:
        ImageView r5 = (ImageView) r4.findViewById(R.id.iv_popover_tail_image);
        if (r5 != null) goto L18;
        return;
    L18:
        ViewExtensionsKt.setVisibility(r5, true);
        r5.setImageResource(R.drawable.ic_red_badge_inset_4);
        return;
    L6:
        r3 = null;
        goto L7
    }

    public final void showDeleteConfirmDialog(boolean r15) {
        if (r15 == true) goto L4;
        int r16 = R.string.dialog_title_delete_call_log_no_record;
    L5:
        Intrinsics.checkNotNullExpressionValue(getString(r16), "getString(titleId)");
        final int r0 = BDSettingsEvent.EVENT_TYPE_CALL_LOGS_DELETE.getType();
        if (getActivity() == null) goto L13;
        OAlertDialogUtils r1 = OAlertDialogUtils.INSTANCE;
        Context r3 = requireContext();
        String r17 = getString(r16);
        String r2 = getString(R.string.btn_confirm_delete);
        DialogInterface.OnClickListener r7 = new NewCallLogFragment$$ExternalSyntheticLambda6(this, r0);
        String r4 = getString(R.string.common_cancel);
        ButtonStyleController.TextColorType r8 = ButtonStyleController.TextColorType.Negative;
        DialogInterface.OnClickListener r10 = new NewCallLogFragment$$ExternalSyntheticLambda7(this, r0);
        Intrinsics.checkNotNullExpressionValue(r3, "requireContext()");
        OAlertDialog r18 = OAlertDialogUtils.showConfirmationDialog$default(r3, r17, null, r2, r7, r8, r4, r10, null, 256, null);
        this.mDeleteConfirmDialog = r18;
        if (r18 == null) goto L10;
        r18.setCanceledOnTouchOutside(true);
    L10:
        OAlertDialog r19 = this.mDeleteConfirmDialog;
        if (r19 == null) goto L13;
        r19.show();
    L13:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(getActivity(), r0, true, false);
        return;
    L4:
        r16 = R.string.dialog_title_delete_call_log;
        goto L5
    }

    private static final void showDeleteConfirmDialog$lambda$21$lambda$19(NewCallLogFragment r0, int r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.doRemoveAction();
        OAlertDialog r4 = r0.mDeleteConfirmDialog;
        if (r4 == null) goto L6;
        if (r4 == null) goto L6;
        r4.dismiss();
    L6:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r0.getActivity(), r1, false, true);
    }

    private static final void showDeleteConfirmDialog$lambda$21$lambda$20(NewCallLogFragment r0, int r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OAlertDialog r4 = r0.mDeleteConfirmDialog;
        if (r4 == null) goto L6;
        if (r4 == null) goto L6;
        r4.dismiss();
    L6:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r0.getActivity(), r1, false, false);
    }

    public final void showDeleteCallLogDialog() {
        checkHasRecord(new C01441(this));
    }

    private final void checkHasRecord(final Function1 r3) {
        AsyncTask<Void, Void, Boolean> r0 = this.mHasRecordTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        CallLogAdapter r1 = this.callLogAdapter;
        if (r1 == null) goto L10;
        ArrayList<Long> r2 = r1.getSelectedIds();
        if (r2 == null) goto L10;
        int r4 = r2.size();
    L11:
        if (r4 > 0) goto L14;
        r3.invoke(false);
        return;
    L14:
        AsyncTask<Void, Void, Boolean> r5 = new AnonymousClass1(this, r3);
        this.mHasRecordTask = r5;
        r5.execute(new Void[0]);
        return;
    L10:
        r4 = 0;
        goto L11
    }

    private final boolean hasRecord(ArrayList<Long> r12) {
        ArrayList<Long> r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L14;
        ContentResolver r4 = r2.getContentResolver();
    L15:
        String[] r6 = {"number", "date"};
        String r7 = "_id IN (" + TextUtils.join(SimContactsConstants.EMAIL_SEP, r12) + ')';
        if (r4 == null) goto L18;
        Cursor r13 = r4.query(CallLog.Calls.CONTENT_URI, r6, r7, null, null);
    L19:
        Cursor r14 = r13;
        Cursor r5 = r14;     // Catch: Throwable -> L40
        if (r5 != null) goto L24;
        CloseableKt.closeFinally(r14, null);
        return false;
    L24:
        int r3 = r5.getColumnIndex("number");     // Catch: Throwable -> L40
        int r8 = r5.getColumnIndex("date");     // Catch: Throwable -> L40
        if (r3 == (-1)) goto L37;
        if (r8 == (-1)) goto L37;
    L29:
        if (r5.moveToNext() == false) goto L34;
        if (ObriceRecordSummaryUtils.recordFileNotExists(getActivity(), Long.valueOf(r5.getLong(r8)), r5.getString(r3)) == true) goto L29;
        CloseableKt.closeFinally(r14, null);
        return true;
    L34:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r14, null);
        return false;
    L37:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Calls table does not contain required columns");     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r14, null);
        return false;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L18:
        r13 = null;
        goto L19
    L14:
        r4 = null;
        goto L15
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void doRemoveAction() {
        CallLogAdapter r1 = this.callLogAdapter;
        if (r1 == null) goto L5;
        ArrayList<Long> r2 = r1.getSelectedIds();
    L6:
        HashSet r0 = new HashSet(r2);
        ArrayList<Integer> r3 = new ArrayList();
        ArrayList<Integer> r4 = new ArrayList();
        CallLogAdapter r5 = this.callLogAdapter;
        if (r5 == null) goto L9;
        Cursor r6 = r5.getCursor();
    L10:
        if (r6 != null) goto L12;
        return;
    L12:
        SlideListView r7 = this.mSlideListView;
        if (r7 == null) goto L15;
        int r8 = r7.getHeaderViewsCount();
    L16:
        int r9 = 0;
    L17:
        if (r9 >= r8) goto L19;
        r4.add(Integer.valueOf(r9));
        r9 = r9 + 1;
        goto L17
    L19:
        CallLogAdapter r10 = this.callLogAdapter;
        if (r10 == null) goto L22;
        int r11 = r10.getCount();
    L23:
        int r12 = 0;
    L24:
        if (r12 >= r11) goto L34;
        CallLogAdapter r13 = this.callLogAdapter;
        if (r13 == null) goto L28;
        Long r14 = Long.valueOf(r13.getItemId(r12));
    L30:
        if (r0.contains(r14) == false) goto L32;
        r3.add(Integer.valueOf(r12 + r8));
    L33:
        r12 = r12 + 1;
        goto L24
    L32:
        r4.add(Integer.valueOf(r12 + r8));
        goto L33
    L28:
        r14 = null;
        goto L30
    L34:
        SlideListView r15 = this.mSlideListView;
        if (r15 == null) goto L37;
        int r16 = r15.getFooterViewsCount();
    L38:
        int r17 = 0;
    L39:
        if (r17 >= r16) goto L41;
        r4.add(Integer.valueOf((r17 + r8) + r11));
        r17 = r17 + 1;
        goto L39
    L41:
        final MatrixCursor r18 = new MatrixCursor(r6.getColumnNames());
        if (r6.moveToFirst() == false) goto L55;
    L43:
        ArrayList r19 = new ArrayList();
        int r20 = r6.getColumnCount();
        int r21 = r6.getColumnIndex("_id");
        if (r21 < 0) goto L54;
        if (r0.contains(Long.valueOf(r6.getLong(r21))) == true) goto L54;
        int r22 = 0;
    L50:
        if (r22 >= r20) goto L52;
        r19.add(getCursorValue(r6, r22));
        r22 = r22 + 1;
        goto L50
    L52:
        r18.addRow(r19);
    L54:
        if (r6.moveToNext() == true) goto L43;
    L55:
        final SlideListView r23 = this.mSlideListView;
        new C01401(this, r18, r23).setResultListSize(r18.getCount()).start(r3, r4);
        return;
    L37:
        r16 = 0;
        goto L38
    L22:
        r11 = 0;
        goto L23
    L15:
        r8 = 0;
        goto L16
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final Object getCursorValue(Cursor r2, int r3) {
        int r1 = r2.getType(r3);
        if (r1 != 0) goto L5;
        return null;
    L5:
        if (r1 == 1) goto L21;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L17;
        if (r1 != 4) goto L15;
        return r2.getBlob(r3);
    L15:
        throw new IllegalStateException("Invalid or unhandled data type");
    L17:
        return r2.getString(r3);
    L19:
        return Float.valueOf(r2.getFloat(r3));
    L21:
        return Long.valueOf(r2.getLong(r3));
    }

    private final void startEditAnimation() {
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L5;
        r0.setIsEditMode(true);
    L5:
        CallLogAdapter r1 = this.callLogAdapter;
        if (r1 == null) goto L8;
        r1.notifyDataSetChanged();
    L8:
        SlideListView r2 = this.mSlideListView;
        if (r2 == null) goto L12;
        this.mCalllogAnimator.startEdit(r2);
        return;
    }

    public final void endEditAnimation() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L8;
        r0.setIsEditMode(false);
    L8:
        CallLogAdapter r1 = this.callLogAdapter;
        if (r1 == null) goto L11;
        r1.notifyDataSetChanged();
    L11:
        SlideListView r2 = this.mSlideListView;
        if (r2 == null) goto L15;
        this.mCalllogAnimator.finishEdit(r2);
        return;
    }

    private final void endEditWithoutAnimation() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L8;
        r0.setIsEditMode(false);
    L8:
        CallLogAdapter r2 = this.callLogAdapter;
        if (r2 == null) goto L12;
        r2.notifyDataSetChanged();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ContactsUtils.fatchVoiceMailNumber();
        if (this.isEditMode == false) goto L7;
        OFloatingTitleBarHolder r0 = this.mTitleBarHolder;
        if (r0 == null) goto L11;
        r0.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
    L11:
        if (this.mIsShowSingleContactCalls == false) goto L13;
        refreshData("CallLogFragment onResume");
        refreshUI();
    L14:
        CallFeatureModel.INSTANCE.addCallFeatureModelListener(this.summaryListener);
        CallFeatureModel.INSTANCE.addCallSummaryFinishedListener(this.callSummaryFinishedListener);
        Context r8 = getContext();
        if (r8 == null) goto L17;
        NotificationHelper.INSTANCE.cancelAllRecordNotification(r8);
    L17:
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent("", TAG, null, null, 12, null));
        return;
    L13:
        refreshData("CallLogFragment onResume，not refresh ui");
        goto L14
    L7:
        OFloatingTitleBarHolder r1 = this.mTitleBarHolder;
        if (r1 == null) goto L11;
        r1.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
        goto L11
    }

    private final void updateVoicemailStatusMessage(Cursor r1) {
        VoicemailStatusHelper r0 = this.mVoicemailStatusHelper;
        if (r0 == null) goto L5;
        List<VoicemailStatusHelper.StatusMessage> r2 = r0.getStatusMessages(r1);
    L6:
        if (r2 == null) goto L9;
        VoicemailStatusHelper.StatusMessage r3 = r2.get(0);
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopRequestProcessing();
        SlideListView r0 = this.mSlideListView;
        if (r0 == null) goto L7;
        if (r0 == null) goto L7;
        r0.hideQuickContact();
    L7:
        if (this.mPendingClearMissedCall == false) goto L22;
        KeyguardManager r1 = this.mKeyguardManager;
        if (r1 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L22;
        this.mPendingClearMissedCall = false;
        CallLogQueryHandler r3 = this.mCallLogQueryHandler;
        if (r3 == null) goto L18;
        r3.markNewCallsAsOld();
    L18:
        CallLogQueryHandler r4 = this.mCallLogQueryHandler;
        if (r4 == null) goto L21;
        r4.markMissedCallsAsRead();
    L21:
        removeMissedCallNotifications();
        updateVoicemailNotifications();
        goto L22
    L11:
        if (r1.isKeyguardLocked() == true) goto L13;
        r2 = true;
    L22:
        CallFeatureModel.INSTANCE.removeCallFeatureModelListener(this.summaryListener);
        CallFeatureModel.INSTANCE.removeCallSummaryFinishedListener(this.callSummaryFinishedListener);
    }

    public final void stopRequestProcessing() {
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.stopRequestProcessing();
        return;
    L8:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mVisibilityChanged == false) goto L5;
        updateOnExit();
    L5:
        this.mHandler.removeMessages(10);
        if (this.isEditMode == false) goto L16;
        boolean r0 = false;
        endEditMode(false);
        OAlertDialog r1 = this.mDeleteConfirmDialog;
        if (r1 != null) goto L10;
    L12:
        if (r0 == false) goto L16;
        OAlertDialog r2 = this.mDeleteConfirmDialog;
        if (r2 == null) goto L16;
        r2.dismiss();
        goto L16
    L10:
        if (r1.isShowing() != true) goto L12;
        r0 = true;
    L16:
        dismissLongMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Agent r0 = Agent.getInstance();
        if (this.mIsShowSingleContactCalls == false) goto L5;
        String r1 = SUB_TAG_SINGLE;
    L6:
        r0.onDetach(TAG, r1);
        Agent.getInstance().flush();
        if (DSUtils.isMultiSimEnabled() == false) goto L9;
        DSUtils.unregisterDSFeatureStatusListener(this);
    L9:
        CallLogAdapter r2 = this.callLogAdapter;
        if (r2 == null) goto L17;
        if (r2 == null) goto L13;
        r2.stopRequestProcessing();
    L13:
        CallLogAdapter r3 = this.callLogAdapter;
        if (r3 == null) goto L18;
        r3.changeCursor(null);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r1 = SUB_TAG_ALL;
        goto L6
    }

    @Override // com.android.contacts.calllog.CallLogAdapter.CallFetcher
    public void fetchCalls() {
        if (this.isInMissCallsPage == true) goto L13;
        if (this.mIsShowSingleContactCalls == false) goto L9;
        CallLogQueryHandler r0 = this.mCallLogQueryHandler;
        if (r0 == null) goto L27;
        r0.fetchContactCalls(this.mSelection, this.mResult);
        return;
    L27:
        return;
    L9:
        CallLogQueryHandler r2 = this.mCallLogQueryHandler;
        if (r2 == null) goto L29;
        r2.fetchAllCalls();
        return;
    L29:
        return;
    L13:
        if (FEATURE_CMCC_CU == true) goto L15;
    L23:
        CallLogQueryHandler r3 = this.mCallLogQueryHandler;
        if (r3 == null) goto L34;
        r3.fetchMissCalls();
        return;
    L34:
        return;
    L15:
        if (DSUtils.useDSFeature() == false) goto L23;
        int r1 = this.mSimId;
        if (r1 != 0) goto L19;
    L20:
        CallLogQueryHandler r4 = this.mCallLogQueryHandler;
        if (r4 == null) goto L32;
        r4.fetchSimCalls(r1);
        return;
    L32:
        return;
    L19:
        if (1 == r1) goto L20;
    }

    public final void startCallsQuery(String r4) {
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.setLoading(true);
    L6:
        NewContactsTraceLog.INSTANCE.onCallLogPageLog("CallLogFragment startCallsQuery scene:" + r4);
        fetchCalls();
    }

    private final void startVoicemailStatusQuery() {
        CallLogQueryHandler r0 = this.mCallLogQueryHandler;
        if (r0 == null) goto L6;
        r0.fetchVoicemailStatus();
        return;
    }

    public final void startEditMode() {
        if (this.isEditMode == true) goto L28;
        SlideListView r0 = this.mSlideListView;
        if (r0 == null) goto L8;
        r0.setSlideEnable(true);
    L8:
        if (this.mIsShowSingleContactCalls == true) goto L15;
        SlideListView r1 = this.mSlideListView;
        if (r1 == null) goto L12;
        r1.restoreScrollState(false);
    L12:
        SlideListView r2 = this.mSlideListView;
        if (r2 == null) goto L15;
        r2.setScrollEnabled(false);
    L15:
        this.isEditMode = true;
        OFloatingTitleBarHolder r3 = this.mTitleBarHolder;
        if (r3 == null) goto L18;
        r3.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
    L18:
        CallLogAdapter r4 = this.callLogAdapter;
        if (r4 == null) goto L22;
        if (r4 == null) goto L22;
        r4.setIsEditMode(true);
    L22:
        startEditAnimation();
        BottomDeleteLayoutListener r5 = this.mBottomDeleteLayoutListener;
        if (r5 == null) goto L26;
        if (r5 == null) goto L26;
        r5.startTransition(true);
    L26:
        refreshUI();
        return;
    }

    private final void endEditMode(boolean r4) {
        if (this.isEditMode == true) goto L5;
        return;
    L5:
        this.isEditMode = false;
        SlideListView r1 = this.mSlideListView;
        if (r1 == null) goto L9;
        r1.setSlideEnable(false);
    L9:
        if (this.mIsShowSingleContactCalls == true) goto L13;
        SlideListView r2 = this.mSlideListView;
        if (r2 == null) goto L13;
        r2.setScrollEnabled(true);
    L13:
        OFloatingTitleBarHolder r3 = this.mTitleBarHolder;
        if (r3 == null) goto L16;
        r3.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
    L16:
        CallLogAdapter r5 = this.callLogAdapter;
        if (r5 == null) goto L20;
        if (r5 == null) goto L20;
        r5.clearHashSet();
    L20:
        if (r4 == false) goto L25;
        endEditAnimation();
        BottomDeleteLayoutListener r6 = this.mBottomDeleteLayoutListener;
        if (r6 == null) goto L30;
        if (r6 == null) goto L30;
        r6.startTransition(false);
    L30:
        CallLogAdapter r7 = this.callLogAdapter;
        if (r7 == null) goto L34;
        if (r7 == null) goto L34;
        r7.clearHashSet();
    L34:
        refreshUI();
        return;
    L25:
        CallLogAdapter r8 = this.callLogAdapter;
        if (r8 == null) goto L29;
        if (r8 == null) goto L29;
        r8.setIsEditMode(false);
    L29:
        endEditWithoutAnimation();
        goto L30
    }

    public final void refreshUI() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (this.isEditMode == false) goto L82;
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L16;
        if (r0 == null) goto L13;
        ArrayList<Long> r2 = r0.getSelectedIds();
        if (r2 == null) goto L13;
        int r3 = r2.size();
    L14:
        if (r3 <= 0) goto L16;
        boolean r4 = true;
    L17:
        BottomDeleteLayoutListener r5 = this.mBottomDeleteLayoutListener;
        if (r5 == null) goto L27;
        if (r5 == null) goto L21;
        String r6 = getResources().getString(R.string.delete_btn);
        Intrinsics.checkNotNullExpressionValue(r6, "resources.getString(R.string.delete_btn)");
        r5.setButtonText(r6);
    L21:
        BottomDeleteLayoutListener r7 = this.mBottomDeleteLayoutListener;
        if (r7 == null) goto L24;
        r7.setLayoutVisible(true);
    L24:
        BottomDeleteLayoutListener r8 = this.mBottomDeleteLayoutListener;
        if (r8 == null) goto L27;
        r8.setBottomBtnEnable(r4);
    L27:
        CallLogAdapter r9 = this.callLogAdapter;
        Cursor r10 = null;
        if (r9 == null) goto L34;
        if (r9 == null) goto L33;
        ArrayList<Long> r11 = r9.getSelectedIds();
        if (r11 == null) goto L33;
        Integer r12 = Integer.valueOf(r11.size());
    L36:
        if (this.mIsShowSingleContactCalls == false) goto L42;
        OFloatingTitleBarHolder r13 = this.mTitleBarHolder;
        if (r13 == null) goto L61;
        OFloatingTitleBar r14 = r13.getTitleBar();
        if (r14 == null) goto L61;
        r14.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{r12}));
    L61:
        CallLogAdapter r15 = this.callLogAdapter;
        if (r15 == null) goto L71;
        if (r15 == null) goto L65;
        r10 = r15.getCursor();
    L65:
        if (r10 == null) goto L71;
        CallLogAdapter r16 = this.callLogAdapter;
        if (r16 == null) goto L71;
        Cursor r17 = r16.getCursor();
        if (r17 == null) goto L71;
        int r18 = r17.getCount();
    L72:
        if (r12 != null) goto L75;
    L77:
        r1 = false;
    L78:
        SelectAllState r19 = this.mSelectedAll;
        if (r19 == null) goto L121;
        r19.setSelectAll(r1);
        return;
    L121:
        return;
    L75:
        if (r12.intValue() != r18) goto L77;
    L71:
        r18 = 0;
        goto L72
    L42:
        OTextView r20 = this.mCallLogTitleView;
        if (r20 != null) goto L45;
    L57:
        OTextView r21 = this.mCallLogTitleView;
        if (r21 == null) goto L61;
        r21.setText(getString(R.string.delete_selected_item_numbers, new Object[]{r12}));
        goto L61
    L45:
        if (r20.getParent() != null) goto L47;
        boolean r22 = true;
    L48:
        if (r22 == true) goto L51;
        r20 = null;
    L51:
        if (r20 == null) goto L57;
        OFloatingTitleBarHolder r23 = this.mTitleBarHolder;
        if (r23 == null) goto L57;
        OFloatingTitleBar r24 = r23.getTitleBar();
        if (r24 == null) goto L57;
        r24.setCenterCustomView(r20);
        goto L57
    L47:
        r22 = false;
    L33:
        r12 = null;
        goto L36
    L34:
        r12 = 0;
    L13:
        r3 = 0;
    L16:
        r4 = false;
        goto L17
    L82:
        CallLogAdapter r25 = this.callLogAdapter;
        if (r25 == null) goto L91;
        if (r25 != null) goto L86;
    L88:
        boolean r26 = false;
    L89:
        if (r26 == false) goto L91;
    L92:
        View r27 = this.mBtnEdit;
        if (r27 == null) goto L95;
        r27.setEnabled(r1);
    L95:
        BottomDeleteLayoutListener r28 = this.mBottomDeleteLayoutListener;
        if (r28 == null) goto L100;
        if (r28 == null) goto L100;
        r28.setLayoutVisible(false);
    L100:
        if (this.mIsShowSingleContactCalls == true) goto L108;
        View r29 = this.mContactTitleBarCenterView;
        if (r29 == null) goto L115;
        OFloatingTitleBarHolder r30 = this.mTitleBarHolder;
        if (r30 == null) goto L116;
        OFloatingTitleBar r31 = r30.getTitleBar();
        if (r31 == null) goto L117;
        r31.setCenterCustomView(r29);
        return;
    L117:
        return;
    L116:
        return;
    L115:
        return;
    L108:
        OFloatingTitleBarHolder r32 = this.mTitleBarHolder;
        if (r32 == null) goto L119;
        OFloatingTitleBar r33 = r32.getTitleBar();
        if (r33 == null) goto L120;
        r33.setCenterTitle(getString(R.string.common_call_log));
        return;
    L120:
        return;
    L119:
        return;
    L86:
        if (r25.isEmpty() == true) goto L88;
        r26 = true;
    L91:
        r1 = false;
        goto L92
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r2) {
        if (this.mVisibilityChanged == r2) goto L10;
        if (r2 == false) goto L7;
        refreshData("CallLogFragment onVisibilityChanged visible");
        goto L10
    L7:
        if (this.isEditMode == false) goto L9;
        endEditMode(false);
    L9:
        updateOnExit();
        dismissLongMenu();
    L10:
        this.mVisibilityChanged = r2;
    }

    private final void refreshData(String r4) {
        if (this.mProviderIsNormal == true) goto L5;
        return;
    L5:
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L9;
        if (r0 == null) goto L9;
        r0.invalidateCache();
    L9:
        Message r1 = Message.obtain();
        r1.what = 1000;
        r1.obj = r4;
        this.mHandler.sendMessageDelayed(r1, 100);
        this.mHandler.sendEmptyMessageDelayed(10, 900);
    }

    private final void removeMissedCallNotifications() {
        new Thread(new NewCallLogFragment$$ExternalSyntheticLambda0(this)).start();
    }

    private static final void removeMissedCallNotifications$lambda$28(NewCallLogFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        ReflectUtils.cancelMissedCallsNotification(r1.getActivity());
    }

    private final void updateOnExit() {
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.stopRequestProcessing();
        return;
    L8:
        return;
    }

    private final void updateOnEntry() {
        updateOnTransition(false);
    }

    private final void updateOnTransition(boolean r4) {
        if (this.mCallLogQueryHandler != null) goto L5;
        return;
    L5:
        KeyguardManager r0 = this.mKeyguardManager;
        boolean r2 = false;
        if (r0 != null) goto L8;
    L10:
        if (r2 == false) goto L19;
        CallLogQueryHandler r1 = this.mCallLogQueryHandler;
        if (r1 == null) goto L14;
        r1.markNewCallsAsOld();
    L14:
        if (r4 == true) goto L18;
        CallLogQueryHandler r5 = this.mCallLogQueryHandler;
        if (r5 == null) goto L18;
        r5.markMissedCallsAsRead();
    L18:
        removeMissedCallNotifications();
        updateVoicemailNotifications();
        return;
    L19:
        this.mPendingClearMissedCall = true;
        return;
    L8:
        if (r0.isKeyguardLocked() == true) goto L10;
        r2 = true;
        goto L10
    }

    private final void updateVoicemailNotifications() {
        if (getActivity() == null) goto L16;
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L16;
        Intent r2 = new Intent(getActivity(), CallLogNotificationsService.class);
        r2.setAction(CallLogNotificationsService.ACTION_UPDATE_NOTIFICATIONS);
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L21;
        r3.startService(r2);
        return;
    L21:
        return;
    L7:
        if (r0.isDestroyed() != true) goto L9;
        r1 = true;
    L16:
        if (getActivity() != null) goto L18;
        String r4 = "get activity is null";
    L19:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failure to updateVoicemailNotifications, getActivity is:".concat(r4));
        return;
    L18:
        r4 = "activity is destroyed";
        goto L19
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r2, boolean r3) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r2 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r2;
        if (r2 == false) goto L9;
        refreshData("CallLogFragment setEnable visible:" + r2);
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r2, int r3) {
        if (r3 == 0) goto L4;
        ContactsUtils.setCpuBoost(4000);
    L5:
        CallLogAdapter r4 = this.callLogAdapter;
        if (r4 == null) goto L11;
        if (r4 == null) goto L11;
        r4.setScrollState(r3);
    L11:
        if (r3 == 1) goto L13;
        return;
    L13:
        if ((getActivity() instanceof DialtactsActivity) == false) goto L17;
        FragmentActivity r1 = getActivity();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity");
        ((DialtactsActivity) r1).hideDialpad();
        return;
    L17:
        return;
    L4:
        ContactsUtils.releaseCpuBoost();
        ContactDetailCacheManager.getInstance().refreshCache(this.mSlideListView);
        goto L5
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        if (this.isEditMode == false) goto L14;
        SlideListView r0 = this.mSlideListView;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
        return false;
    L12:
        endEditMode(true);
        return false;
    L7:
        if (r0.isSelecting() != true) goto L9;
        r1 = true;
        goto L10
    L14:
        return true;
    }

    @Override // com.android.contacts.DSUtils.DSFatureStatusListener
    public void onDSFeatureStatusChanged() {
        if (DSUtils.useDSFeature() == false) goto L9;
        CallLogQueryHandler r0 = this.mCallLogQueryHandler;
        if (r0 == null) goto L9;
        if (r0 == null) goto L9;
        r0.updateShowSimId();
    L9:
        if (FEATURE_CMCC_CU == true) goto L11;
    L13:
        CallLogAdapter r1 = this.callLogAdapter;
        if (r1 == null) goto L18;
        if (r1 == null) goto L19;
        r1.notifyDataSetChanged();
        return;
    L19:
        return;
    L18:
        return;
    L11:
        if (this.mIsShowSingleContactCalls == true) goto L13;
        updateCallLogFilter(getActivity());
        goto L13
    }

    public final List<Long> getCurrentVisibleContact() {
        CallLogAdapter r0 = this.callLogAdapter;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 == null) goto L7;
        Cursor r1 = r0.getCursor();
    L8:
        if (r1 != null) goto L10;
        return null;
    L10:
        Map<Integer, Integer> r2 = updatePositionIdMap(r1);
        SlideListView r3 = this.mSlideListView;
        int r4 = 0;
        if (r3 == null) goto L13;
        int r5 = r3.getFirstVisiblePosition();
    L14:
        SlideListView r6 = this.mSlideListView;
        if (r6 == null) goto L17;
        r4 = r6.getLastVisiblePosition();
    L17:
        ArrayList r7 = new ArrayList();
        if (r5 <= r4) goto L20;
    L36:
        return r7;
    L20:
        if (r5 > r1.getCount()) goto L34;
        Integer r8 = r2.get(Integer.valueOf(r5));
        if (r8 == null) goto L24;
        int r9 = r8.intValue();
    L25:
        boolean r10 = r1.moveToPosition(r9);
        if (r5 != r4) goto L28;
        double r11 = 0.6d;
    L29:
        if (r10 == false) goto L34;
        int r12 = r1.getColumnIndex("_id");
        boolean r13 = hasItemVisible(r5, r11);
        if (r12 == (-1)) goto L34;
        if (r13 == false) goto L34;
        r7.add(Long.valueOf(r1.getLong(r12)));
        goto L34
    L28:
        r11 = 0.65d;
        goto L29
    L24:
        r9 = r5;
    L34:
        if (r5 == r4) goto L36;
        r5 = r5 + 1;
        goto L20
    L13:
        r5 = 0;
        goto L14
    L7:
        r1 = null;
        goto L8
    }

    private final boolean hasItemVisible(int r10, double r11) {
        SlideListView r0 = this.mSlideListView;
        if (r0 == null) goto L5;
        View r12 = r0.getChildAt(r10);
    L7:
        if (r12 != null) goto L9;
        return false;
    L9:
        SlideListView r9 = this.mSlideListView;
        if (r9 == null) goto L12;
        int r13 = r9.getHeight();
    L13:
        int r1 = r12.getMeasuredHeight();
        int r2 = r12.getTop();
        int r14 = r12.getBottom();
        if (r2 >= 0) goto L16;
        double r5 = (((double) (r2 + r1)) * 1.0d) / (((double) r1) * 1.0d);
    L17:
        if (r14 <= r13) goto L20;
        r5 = (((double) (r1 - (r14 - r13))) * 1.0d) / (((double) r1) * 1.0d);
    L20:
        if (r5 <= r11) goto L23;
        return true;
    L23:
        return false;
    L16:
        r5 = 1.0d;
        goto L17
    L12:
        r13 = 0;
        goto L13
    L5:
        r12 = null;
        goto L7
    }

    private final Map<Integer, Integer> updatePositionIdMapMin(Cursor r17) {
        HashMap r2 = new HashMap();
        if (r17 == null) goto L5;
        int r5 = 1;
        if (r17.getCount() != 1) goto L11;
        r2.put(0, 0);
        return r2;
    L11:
        if (r17.moveToPosition(0) == false) goto L13;
        String r3 = r17.getString(1);
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        int r7 = 4;
        int r8 = r17.getInt(4);
        long r10 = r17.getLong(2);
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r10);
        Calendar r11 = Calendar.getInstance();
        int r13 = 0;
        int r14 = 0;
    L19:
        if (r17.moveToNext() == false) goto L51;
        String r15 = r17.getString(r5);
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        int r16 = r17.getInt(r7);
        long r4 = r17.getLong(2);
        r11.setTimeInMillis(r4);
        if (equalNumbers(r3, r15) == true) goto L26;
    L25:
        int r6 = 0;
        int r9 = 1;
    L43:
        if (r6 == 0) goto L45;
        r14 = r14 + 1;
    L46:
        r12.setTimeInMillis(r4);
        if (r17.isLast() == false) goto L49;
        r2.put(Integer.valueOf(r13), Integer.valueOf(r14));
    L49:
        r5 = r9;
        r3 = r15;
        r8 = r16;
        r7 = 4;
        goto L19
    L45:
        r2.put(Integer.valueOf(r13), Integer.valueOf(r14));
        r14 = r14 + 1;
        r13 = r13 + 1;
        goto L46
    L26:
        Intrinsics.checkNotNullExpressionValue(r12, "firstCalendar");
        Intrinsics.checkNotNullExpressionValue(r11, "cur");
        if (isSameDay(r12, r11) == false) goto L25;
        if (r8 == r7) goto L40;
        if (r8 == 3) goto L40;
        r9 = 1;
        if (r16 == 7) goto L39;
        if (r16 == 1) goto L39;
        if (r16 == 2) goto L39;
    L38:
        r6 = 0;
    L39:
        r6 = r9;
    L40:
        r9 = 1;
        if (r16 != 3) goto L38;
    L51:
        return r2;
    L13:
        return r2;
    L5:
        return r2;
    }

    private final Map<Integer, Integer> updatePositionIdMap(Cursor r18) {
        HashMap r2 = new HashMap();
        if (r18 == null) goto L5;
        int r5 = 1;
        if (r18.getCount() != 1) goto L11;
        r2.put(0, 0);
        return r2;
    L11:
        if (r18.moveToPosition(0) == false) goto L13;
        String r3 = r18.getString(1);
        String r6 = "";
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        int r8 = r18.getInt(4);
        long r10 = r18.getLong(2);
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r10);
        Calendar r11 = Calendar.getInstance();
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L19:
        if (r18.moveToNext() == false) goto L51;
        String r16 = r18.getString(r5);
        if (r16 != null) goto L23;
        r16 = r6;
    L23:
        int r4 = r18.getInt(4);
        String r17 = r6;
        long r7 = r18.getLong(2);
        r11.setTimeInMillis(r7);
        if (equalNumbers(r3, r16) == true) goto L26;
    L25:
        int r9 = 0;
        int r19 = 1;
    L43:
        if (r9 == 0) goto L45;
        int r20 = Math.min(r15, r14);
        r14 = r14 + 1;
        r15 = r20;
    L46:
        r12.setTimeInMillis(r7);
        if (r18.isLast() == false) goto L49;
        r2.put(Integer.valueOf(r13), Integer.valueOf(r15));
    L49:
        r5 = r19;
        r3 = r16;
        r6 = r17;
        r8 = r4;
        goto L19
    L45:
        r2.put(Integer.valueOf(r13), Integer.valueOf(r15));
        r14 = r14 + 1;
        r13 = r13 + 1;
        r15 = r14;
        goto L46
    L26:
        Intrinsics.checkNotNullExpressionValue(r12, "firstCalendar");
        Intrinsics.checkNotNullExpressionValue(r11, "cur");
        if (isSameDay(r12, r11) == false) goto L25;
        if (r8 == 4) goto L40;
        if (r8 == 3) goto L40;
        r19 = 1;
        if (r4 == 7) goto L39;
        if (r4 == 1) goto L39;
        if (r4 == 2) goto L39;
    L38:
        r9 = 0;
    L39:
        r9 = r19;
    L40:
        r19 = 1;
        if (r4 != 3) goto L38;
    L51:
        return r2;
    L13:
        return r2;
    L5:
        return r2;
    }

    private final boolean isSameDay(Calendar r3, Calendar r4) {
        if (r3.get(1) == r4.get(1)) goto L5;
        return false;
    L5:
        if (r3.get(2) == r4.get(2)) goto L7;
        return false;
    L7:
        if (r3.get(6) != r4.get(6)) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean equalNumbers(String r2, String r3) {
        if (PhoneNumberUtils.isUriNumber(r2) == true) goto L18;
        if (PhoneNumberUtils.isUriNumber(r3) == true) goto L18;
        if (TextUtils.isEmpty(r2) == true) goto L16;
        if (TextUtils.isEmpty(r3) == true) goto L16;
        boolean r1 = Intrinsics.areEqual(r2, r3);
        if (r1 == false) goto L14;
        return r1;
    L14:
        return PhoneNumberUtils.compare(r2, r3);
    L16:
        return PhoneNumberUtils.compare(r2, r3);
    L18:
        return compareSipAddresses(r2, r3);
    }

    private final boolean compareSipAddresses(String r12, String r13) {
        if (r12 == null) goto L19;
        if (r13 == null) goto L19;
        int r11 = StringsKt.indexOf$default(r12, '@', 0, false, 6, null);
        String r0 = "";
        if (r11 == (-1)) goto L8;
        String r4 = r12.substring(0, r11);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        String r14 = r12.substring(r11);
        Intrinsics.checkNotNullExpressionValue(r14, "substring(...)");
        r12 = r4;
    L9:
        int r5 = StringsKt.indexOf$default(r13, '@', 0, false, 6, null);
        if (r5 == (-1)) goto L13;
        String r1 = r13.substring(0, r5);
        Intrinsics.checkNotNullExpressionValue(r1, "substring(...)");
        String r15 = r13.substring(r5);
        Intrinsics.checkNotNullExpressionValue(r15, "substring(...)");
        r0 = r15;
        r13 = r1;
    L13:
        if (Intrinsics.areEqual(r12, r13) == true) goto L15;
        return false;
    L15:
        if (StringsKt.equals(r14, r0, true) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        r14 = "";
    L19:
        return TextUtils.equals(r12, r13);
    }

    static {
        Companion = new Companion(null);
        if (ContactsUtils.FEATURE_CMCC == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        FEATURE_CMCC_CU = r0;
        sLongMenuItemsStranger = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_COPY_NUMBER, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_LINE, LongMenuHelper.MenuType.MENU_CREATE_CONTACTS, LongMenuHelper.MenuType.MENU_FLAG, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        sLongMenuItemsContacts = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_COPY_NUMBER, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_LINE, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        sLongMenuItemsSingle = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_DELETE};
        return;
    L5:
        if (ContactsUtils.FEATURE_CU == true) goto L8;
        r0 = false;
        goto L9
    }
}
