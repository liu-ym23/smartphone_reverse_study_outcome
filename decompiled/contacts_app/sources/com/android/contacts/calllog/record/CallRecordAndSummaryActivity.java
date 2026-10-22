package com.android.contacts.calllog.record;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.callsummary.CallSummaryGenerateManager;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.model.aikernel.AISummary;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.contactprovider.ObricCallRecordSummaryDeleteObserver;
import com.obric.contactprovider.tableinfo.CallFeature;
import com.obric.contactprovider.tableinfo.CallSummaryASRMessage;
import com.obric.database.entity.RecordASRMessageEntity;
import com.obric.database.entity.RecordInfoEntity;
import com.obric.feedback.sdk.FeedbackSdkResultContract;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.notification.NotificationHelper;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.forms.OEditText;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.slider.OSlider;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.obric.privacy.PrivacyUtils;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.CallLogFeedbackEvent;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.ContactNames;
import com.obric.utils.GlobalUtils;
import com.obric.utils.ObriceRecordSummaryUtils;
import com.ss.android.common.util.NetworkUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: CallRecordAndSummaryActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b*\u0004\u000f/gj\u0018\u0000 \u008c\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u008c\u0002\u008d\u0002B\u0005¢\u0006\u0002\u0010\u0004JM\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010a2\u0007\u0010\u008f\u0001\u001a\u0002092\u0007\u0010\u0090\u0001\u001a\u0002092\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0003\u0010\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020\u0019H\u0002J_\u0010\u0095\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0097\u00010\u0096\u0001j\n\u0012\u0005\u0012\u00030\u0097\u0001`\u0098\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010a2\u0007\u0010\u008f\u0001\u001a\u0002092\u0007\u0010\u0090\u0001\u001a\u0002092\u0007\u0010\u0099\u0001\u001a\u00020\u00192\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0003\u0010\u009a\u0001J\u0012\u0010\u009b\u0001\u001a\u0002092\u0007\u0010\u009c\u0001\u001a\u00020eH\u0002J\t\u0010\u009d\u0001\u001a\u000209H\u0002J\u0013\u0010\u009e\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0016H\u0002J,\u0010 \u0001\u001a\u00030\u008b\u00012\u000f\u0010¡\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010¢\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u00030¥\u00010¢\u0001H\u0002J\t\u0010¦\u0001\u001a\u00020\u0019H\u0002J\u0015\u0010§\u0001\u001a\u00030\u008b\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010aH\u0002J\u0015\u0010¨\u0001\u001a\u00030\u008b\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010aH\u0002J\n\u0010©\u0001\u001a\u00030\u008b\u0001H\u0002J!\u0010ª\u0001\u001a\u00030\u008b\u00012\u0015\u0010«\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030\u008b\u00010¬\u0001H\u0002J\f\u0010\u00ad\u0001\u001a\u0005\u0018\u00010£\u0001H\u0002J\n\u0010®\u0001\u001a\u00030\u008b\u0001H\u0016J.\u0010¯\u0001\u001a\u00030\u008b\u00012\b\u0010°\u0001\u001a\u00030£\u00012\u0018\u0010±\u0001\u001a\u0013\u0012\u0007\u0012\u0005\u0018\u00010¥\u0001\u0012\u0005\u0012\u00030\u008b\u00010¬\u0001H\u0002J\t\u0010²\u0001\u001a\u00020\u0006H\u0002J\t\u0010³\u0001\u001a\u00020\u0019H\u0002J\n\u0010´\u0001\u001a\u00030£\u0001H\u0002J\t\u0010µ\u0001\u001a\u00020\u0006H\u0002J\t\u0010¶\u0001\u001a\u00020\u0006H\u0002J\u0010\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190¢\u0001H\u0002J\u0016\u0010¸\u0001\u001a\u0005\u0018\u00010¥\u00012\b\u0010°\u0001\u001a\u00030£\u0001H\u0002J\u0012\u0010¹\u0001\u001a\u00020\u00062\u0007\u0010\u009c\u0001\u001a\u00020eH\u0002J\u0016\u0010º\u0001\u001a\u00030\u008b\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0002J8\u0010¼\u0001\u001a\u00030\u008b\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\u000f\u0010¿\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010¢\u00012\u000f\u0010À\u0001\u001a\n\u0012\u0005\u0012\u00030¥\u00010¢\u0001H\u0002J\t\u0010Á\u0001\u001a\u000209H\u0002J\n\u0010Â\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030\u008b\u0001H\u0002J\b\u0010Å\u0001\u001a\u00030\u008b\u0001J\n\u0010Æ\u0001\u001a\u00030\u008b\u0001H\u0007J\n\u0010Ç\u0001\u001a\u00030\u008b\u0001H\u0003J\t\u0010È\u0001\u001a\u000209H\u0002J\t\u0010É\u0001\u001a\u000209H\u0002J\u0014\u0010Ê\u0001\u001a\u0002092\t\u0010Ë\u0001\u001a\u0004\u0018\u00010MH\u0002J\t\u0010Ì\u0001\u001a\u000209H\u0002J\u001c\u0010Í\u0001\u001a\u00030\u008b\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010[\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010Î\u0001\u001a\u00030\u008b\u00012\n\u0010Ï\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0014J\n\u0010Ð\u0001\u001a\u00030\u008b\u0001H\u0014J\u0013\u0010Ñ\u0001\u001a\u00030\u008b\u00012\u0007\u0010Ò\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010Ó\u0001\u001a\u00030\u008b\u00012\u0007\u0010Ô\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010Õ\u0001\u001a\u00030\u008b\u00012\u0007\u0010Ö\u0001\u001a\u00020\u0006H\u0016J\n\u0010×\u0001\u001a\u00030\u008b\u0001H\u0014J\n\u0010Ø\u0001\u001a\u00030\u008b\u0001H\u0014J\u0013\u0010Ù\u0001\u001a\u00030\u008b\u00012\u0007\u0010Ö\u0001\u001a\u00020\u0006H\u0016J\n\u0010Ú\u0001\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010Û\u0001\u001a\u00030\u008b\u00012\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010Ý\u0001\u001a\u000209H\u0002J\n\u0010Þ\u0001\u001a\u00030\u008b\u0001H\u0002J\f\u0010ß\u0001\u001a\u0005\u0018\u00010£\u0001H\u0002J\u0015\u0010à\u0001\u001a\u00030\u008b\u00012\t\b\u0002\u0010á\u0001\u001a\u000209H\u0002J%\u0010â\u0001\u001a\u00030\u008b\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\u00192\t\b\u0002\u0010ã\u0001\u001a\u000209H\u0002J\n\u0010ä\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010å\u0001\u001a\u00020\u00192\u0007\u0010æ\u0001\u001a\u00020\u000bH\u0002J\u0014\u0010ç\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\n\u0010è\u0001\u001a\u00030\u008b\u0001H\u0002J\u001d\u0010é\u0001\u001a\u00030\u008b\u00012\u0006\u0010_\u001a\u00020\u00062\t\b\u0002\u0010ê\u0001\u001a\u00020\u0006H\u0002J\n\u0010ë\u0001\u001a\u00030\u008b\u0001H\u0002J\u001a\u0010ì\u0001\u001a\u00030\u008b\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\u0019H\u0002J\u0012\u0010í\u0001\u001a\u0002092\u0007\u0010î\u0001\u001a\u000209H\u0002J\t\u0010ï\u0001\u001a\u000209H\u0002J\u001f\u0010ð\u0001\u001a\u00030\u008b\u00012\u0007\u0010ñ\u0001\u001a\u00020\u00062\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H\u0002J'\u0010ô\u0001\u001a\u00030\u008b\u00012\u0007\u0010õ\u0001\u001a\u00020\u00062\u0007\u0010ö\u0001\u001a\u00020\u00062\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010aH\u0002J\u0013\u0010÷\u0001\u001a\u00030\u008b\u00012\u0007\u0010ø\u0001\u001a\u00020\u0006H\u0002J\n\u0010ù\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010ú\u0001\u001a\u00030\u008b\u0001H\u0002J\u0013\u0010û\u0001\u001a\u00030\u008b\u00012\u0007\u0010Ö\u0001\u001a\u00020\u0006H\u0016J\n\u0010ü\u0001\u001a\u00030\u008b\u0001H\u0003J\n\u0010ý\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010þ\u0001\u001a\u00030\u008b\u0001H\u0002J\u0011\u0010ÿ\u0001\u001a\u00030\u008b\u00012\u0007\u0010Ô\u0001\u001a\u00020\u0006J\u0013\u0010\u0080\u0002\u001a\u00030\u008b\u00012\u0007\u0010Ö\u0001\u001a\u00020\u0006H\u0016J\n\u0010\u0081\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u0082\u0002\u001a\u00030\u008b\u0001H\u0002J\u001c\u0010\u0082\u0002\u001a\u00030\u008b\u00012\u0007\u0010\u0083\u0002\u001a\u00020\u00062\u0007\u0010\u0084\u0002\u001a\u00020\u0006H\u0003J#\u0010\u0085\u0002\u001a\u00030\u008b\u0001*\u00030\u0086\u00022\u0007\u0010\u0087\u0002\u001a\u00020\u00192\t\b\u0002\u0010\u0088\u0002\u001a\u00020\u0019H\u0002J!\u0010\u0089\u0002\u001a\u00020\u0019*\u00030\u0086\u00022\u0007\u0010\u008a\u0002\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010\u0019H\u0002J\r\u0010\u008b\u0002\u001a\u00020\u0006*\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0010\u0010V\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020Z0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u00020gX\u0082\u0004¢\u0006\u0004\n\u0002\u0010hR\u0010\u0010i\u001a\u00020jX\u0082\u0004¢\u0006\u0004\n\u0002\u0010kR\u0011\u0010l\u001a\u00020m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u001b\u0010s\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\bu\u0010vR\u000e\u0010y\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u0004\u0018\u00010~X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u007f\u001a\u00030\u0080\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008e\u0002"}, d2 = {"Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity;", "Lcom/android/contacts/ContactsActivity;", "Lcom/android/contacts/calllog/record/RecordSentenceAdapter$RecordSentenceClickListener;", "Lcom/obric/callsummary/model/aikernel/AISummary$DownloadStatusListener;", "()V", "MAX_FEEDBACK_CHAR_COUNT", "", "adapter", "Lcom/android/contacts/calllog/record/RecordSentenceAdapter;", "asrList", "", "Lcom/obric/database/entity/RecordASRMessageEntity;", "asrListIsEmpty", "Ljava/util/concurrent/atomic/AtomicBoolean;", "audioFocusChangeListener", "com/android/contacts/calllog/record/CallRecordAndSummaryActivity$audioFocusChangeListener$1", "Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity$audioFocusChangeListener$1;", "audioFocusManager", "Lcom/android/contacts/calllog/record/AudioFocusManager;", "backwardButton", "Lcom/obric/oui/button/OIconButtonFloating;", "callCreateTime", "", "callSummaryWorking", "callUserName", "", "charCountAlertTextView", "Landroid/widget/TextView;", "charCountTextView", "chipInaccurateASR", "Lcom/obric/oui/text/OTextView;", "chipInaccurateSummary", "chipOther", "chipPoorEffect", "chipSlowResponse", "consentCheckbox", "Lcom/obric/oui/checkbox/OCheckBox;", "contactNames", "Lcom/obric/utils/ContactNames;", "deleteDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "emptyView", "Landroid/view/ViewGroup;", "endTimeTextView", "enter_from", "errorTpsTextView", "feedbackCopyFinishedReceiver", "com/android/contacts/calllog/record/CallRecordAndSummaryActivity$feedbackCopyFinishedReceiver$1", "Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity$feedbackCopyFinishedReceiver$1;", "feedbackEditText", "Lcom/obric/oui/forms/OEditText;", "feedbackOverlay", "Landroid/widget/LinearLayout;", "feedbackSheet", "Lcom/obric/oui/sheet/v2/OSheet;", "forwardButton", "isActivityResumed", "", "isEmpty", "isFeedbackDislikeSelected", "isFeedbackLikeSelected", "isScroll", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isUserScrolling", "()Z", "setUserScrolling", "(Z)V", "linearLayoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "listAndErrView", "listener", "Landroid/view/View$OnLayoutChangeListener;", "mHandler", "Landroid/os/Handler;", "mediaPlayer", "Landroid/media/MediaPlayer;", "mediaPlayerReleased", "mergeTopOffsetDp", "oPopover", "Lcom/obric/oui/popover/v2/OPopover;", "getOPopover", "()Lcom/obric/oui/popover/v2/OPopover;", "setOPopover", "(Lcom/obric/oui/popover/v2/OPopover;)V", "oldMediaPlayer", "onlyShowCallSummaryView", "pendingFeedbackCleanupMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity$PendingFeedbackCleanup;", "phoneNumber", "playAndPauseButton", "playTimeTextView", "playerContainerView", "position", "preCallFeatureBean", "Lcom/obric/model/bean/CallFeatureBean;", "recordAsrWorking", "recordFilePath", "recordListView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "recordSummaryChangeListener", "com/android/contacts/calllog/record/CallRecordAndSummaryActivity$recordSummaryChangeListener$1", "Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity$recordSummaryChangeListener$1;", "scrollListener", "com/android/contacts/calllog/record/CallRecordAndSummaryActivity$scrollListener$1", "Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity$scrollListener$1;", "scrollRunnable", "Ljava/lang/Runnable;", "getScrollRunnable", "()Ljava/lang/Runnable;", "scrollerDefaultDurationMs", "getScrollerDefaultDurationMs", "()J", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "showSummaryView", "slider", "Lcom/obric/oui/slider/OSlider;", "statusBarHeight", "submitButton", "Lcom/obric/oui/button/OButton;", "summaryListener", "Lcom/obric/model/CallFeatureModel$CallFeatureModelListener;", "titleBarHolder", "Lcom/obric/ui/OFloatingTitleBarHolder;", "touchListener", "Landroid/view/View$OnTouchListener;", "touchRunnable", "tracking", "updatePositionRunnable", "updateRecordDataRunnable", "updateSeekRunnable", "buildAndShowPopoverMenu", "", "view", "Landroid/view/View;", "callFeatureBean", "playerShow", "showSummery", "deleteActionTitle", "deleteDialogTitle", "(Landroid/view/View;Lcom/obric/model/bean/CallFeatureBean;ZZLjava/lang/Integer;Ljava/lang/Integer;)V", "buildFeedbackTranscriptContent", "buildPopoverMenuItems", "Ljava/util/ArrayList;", "Lcom/obric/ui/popover/MenuItemData;", "Lkotlin/collections/ArrayList;", "firstTitle", "(Lcom/obric/model/bean/CallFeatureBean;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/util/ArrayList;", "canScrollVisible", "recyclerView", "checkoutSubmit", "cleanupPendingFeedbackFiles", "taskId", "cleanupSharedFeedbackSources", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Ljava/io/File;", "uris", "Landroid/net/Uri;", "collectFeedbackDesc", "deleteRecord", "deleteSummary", "dialogDismiss", "executeSafely", "block", "Lkotlin/Function1;", "exportFeedbackTranscriptFile", "finish", "generateFileUri", "file", "callback", "getAdapterCounts", "getDisplayTitle", "getFeedbackCacheDir", "getMediaPlayerCurrentPosition", "getMediaPlayerDuration", "getSelectedFeedbackTypes", "getUriForFile", "getVisibleItemCount", "handleChipClick", "clickedChip", "handleFeedbackTriggerResult", "result", "Landroid/os/Bundle;", "pendingFiles", "pendingUris", "hasFeedback", "initFeedbackButtons", "initFeedbackPanel", "initIntent", "initRightTitleBtn", "initView", "initializeMediaPlayer", "isAsrFail", "isAsrWorking", "isMediaPlayerPlayingSafely", "player", "isPlaying", "notifyStartCallSummaryTask", "onCreate", "savedInstanceState", "onDestroy", "onDownloadStatus", "downloadStatus", "onItemClicked", "currentPosition", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "onPause", "onResume", "onStatusBarHeightChanged", "pauseRecord", "playMediaPlayer", Params.FILE_PATH, "needReset", "playRecord", "prepareFeedbackRecordFile", "queryASREntity", "forceUpdate", "refreshCallSummary", "showNoNetworkToast", "registerFeedbackCopyFinishedReceiver", "resolveFeedbackSpeakerName", "entity", "rightBtnClick", "saveFeedback", "scrollToPosition", "offsetDp", "setupChips", "shareRecordFile", "shouldBlockSummaryRefreshForNoNetwork", "showToast", "shouldShowFeedbackBar", "showAlertDialog", "title", "click", "Landroid/content/DialogInterface$OnClickListener;", "showDeleteDialog", "titleRes", "dialogTitleRes", "showFeedbackSubmitFailedToast", "resId", "startLocalSummaryDownload", "unregisterFeedbackCopyFinishedReceiver", "updateAsrErrorViewHeight", "updateErrTpsTextViewHeight", "updateFeedbackVisibility", "updateFeedbackVoteState", "updateListPosition", "updateListViewHeight", "updateRecordSummaryWorkingStatus", "updateSeekBar", "duration", "playTime", "copyToClipboard", "Landroid/content/Context;", "text", GroupDeletionDialogFragment.ARG_LABEL, "getSpeakerName", "owner", "toSafeDurationInt", "Companion", "PendingFeedbackCleanup", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallRecordAndSummaryActivity extends ContactsActivity implements RecordSentenceAdapter.RecordSentenceClickListener, AISummary.DownloadStatusListener {
    private static final String ACTION_FEEDBACK_COPY_FINISHED = "com.obric.feedback.sdk.action.CUSTOM_FILE_COPY_FINISHED";
    public static final String CALL_CREATE_TIME = "call_create_time";
    public static final String CALL_USER_NAME = "call_user_name";
    public static final Companion Companion = null;
    public static final String ENTER_FROM = "enter_from";
    private static final String EXTRA_RESULT_SUCCESS = "success";
    private static final String EXTRA_RESULT_TASK_ID = "task_id";
    private static final String FEEDBACK_PACKAGE_NAME = "com.obric.feedback";
    public static final int HANDLE_MESSAGE_UPDATE_STATUS_BY_DELETE = 1;
    public static final long MAX_FEEDBACK_RECORD_FILE_SIZE = 536870912;
    public static final String PHONE_NUMBER = "phone_number";
    public static final String SHOW_CALLLOG_SUMMARY = "show_calllog_summary";
    public static final String TAG = "CallRecordAndSummaryActivity";
    private final int MAX_FEEDBACK_CHAR_COUNT;
    private RecordSentenceAdapter adapter;
    private final List<RecordASRMessageEntity> asrList;
    private final AtomicBoolean asrListIsEmpty;
    private final CallRecordAndSummaryActivity$audioFocusChangeListener$1 audioFocusChangeListener;
    private final AudioFocusManager audioFocusManager;
    private OIconButtonFloating backwardButton;
    private long callCreateTime;
    private final AtomicBoolean callSummaryWorking;
    private String callUserName;
    private TextView charCountAlertTextView;
    private TextView charCountTextView;
    private OTextView chipInaccurateASR;
    private OTextView chipInaccurateSummary;
    private OTextView chipOther;
    private OTextView chipPoorEffect;
    private OTextView chipSlowResponse;
    private OCheckBox consentCheckbox;
    private final ContactNames contactNames;
    private OAlertDialog deleteDialog;
    private ViewGroup emptyView;
    private TextView endTimeTextView;
    private String enter_from;
    private TextView errorTpsTextView;
    private final CallRecordAndSummaryActivity$feedbackCopyFinishedReceiver$1 feedbackCopyFinishedReceiver;
    private OEditText feedbackEditText;
    private LinearLayout feedbackOverlay;
    private OSheet feedbackSheet;
    private OIconButtonFloating forwardButton;
    private volatile boolean isActivityResumed;
    private final AtomicBoolean isEmpty;
    private boolean isFeedbackDislikeSelected;
    private boolean isFeedbackLikeSelected;
    private final AtomicBoolean isScroll;
    private boolean isUserScrolling;
    private final LinearLayoutManager linearLayoutManager;
    private ViewGroup listAndErrView;
    private View.OnLayoutChangeListener listener;
    private final Handler mHandler;
    private MediaPlayer mediaPlayer;
    private final AtomicBoolean mediaPlayerReleased;
    private int mergeTopOffsetDp;
    private OPopover oPopover;
    private MediaPlayer oldMediaPlayer;
    private boolean onlyShowCallSummaryView;
    private final ConcurrentHashMap<Long, PendingFeedbackCleanup> pendingFeedbackCleanupMap;
    private String phoneNumber;
    private OIconButtonFloating playAndPauseButton;
    private TextView playTimeTextView;
    private ViewGroup playerContainerView;
    private int position;
    private CallFeatureBean preCallFeatureBean;
    private final AtomicBoolean recordAsrWorking;
    private String recordFilePath;
    private RecyclerView recordListView;
    private final CallRecordAndSummaryActivity$recordSummaryChangeListener$1 recordSummaryChangeListener;
    private final CallRecordAndSummaryActivity$scrollListener$1 scrollListener;
    private final Runnable scrollRunnable;
    private final long scrollerDefaultDurationMs;
    private final Lazy sharedPreferences$delegate;
    private boolean showSummaryView;
    private OSlider slider;
    private int statusBarHeight;
    private OButton submitButton;
    private final CallFeatureModel.CallFeatureModelListener summaryListener;
    private OFloatingTitleBarHolder titleBarHolder;
    private final View.OnTouchListener touchListener;
    private final Runnable touchRunnable;
    private boolean tracking;
    private final Runnable updatePositionRunnable;
    private final Runnable updateRecordDataRunnable;
    private final Runnable updateSeekRunnable;

    /* JADX INFO: compiled from: CallRecordAndSummaryActivity.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity$Companion;", "", "()V", "ACTION_FEEDBACK_COPY_FINISHED", "", "CALL_CREATE_TIME", "CALL_USER_NAME", "ENTER_FROM", "EXTRA_RESULT_SUCCESS", "EXTRA_RESULT_TASK_ID", "FEEDBACK_PACKAGE_NAME", "HANDLE_MESSAGE_UPDATE_STATUS_BY_DELETE", "", "MAX_FEEDBACK_RECORD_FILE_SIZE", "", "PHONE_NUMBER", "SHOW_CALLLOG_SUMMARY", "TAG", "startSelf", "", "context", "Landroid/content/Context;", "callCreateTime", "phoneNumber", "name", "enter_from", "showSummaryView", "", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void startSelf$default(Companion r7, Context r8, Long r9, String r10, String r11, String r12, boolean r13, int r14, Object r15) {
            if ((r14 & 32) == 0) goto L5;
            r13 = true;
        L5:
            r7.startSelf(r8, r9, r10, r11, r12, r13);
        }

        public final void startSelf(Context r2, Long r3, String r4, String r5, String r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r1 = new Intent(r2, CallRecordAndSummaryActivity.class);
            r1.putExtra("call_create_time", r3);
            r1.putExtra("phone_number", r4);
            r1.putExtra(CallRecordAndSummaryActivity.CALL_USER_NAME, r5);
            r1.putExtra("enter_from", r6);
            r1.putExtra(CallRecordAndSummaryActivity.SHOW_CALLLOG_SUMMARY, r7);
            r1.addFlags(268435456);
            r1.addFlags(67108864);
            r2.startActivity(r1);
        }
    }

    /* JADX INFO: compiled from: CallRecordAndSummaryActivity.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/android/contacts/calllog/record/CallRecordAndSummaryActivity$PendingFeedbackCleanup;", "", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Ljava/io/File;", "uris", "Landroid/net/Uri;", "(Ljava/util/List;Ljava/util/List;)V", "getFiles", "()Ljava/util/List;", "getUris", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PendingFeedbackCleanup {
        private final List<File> files;
        private final List<Uri> uris;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingFeedbackCleanup copy$default(PendingFeedbackCleanup r0, List r1, List r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.files;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.uris;
        L9:
            return r0.copy(r1, r2);
        }

        public final List<File> component1() {
            return this.files;
        }

        public final List<Uri> component2() {
            return this.uris;
        }

        public final PendingFeedbackCleanup copy(List<? extends File> r1, List<? extends Uri> r2) {
            Intrinsics.checkNotNullParameter(r1, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            Intrinsics.checkNotNullParameter(r2, "uris");
            return new PendingFeedbackCleanup(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PendingFeedbackCleanup) == true) goto L8;
            return false;
        L8:
            PendingFeedbackCleanup r6 = (PendingFeedbackCleanup) r5;
            if (Intrinsics.areEqual(this.files, r6.files) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.uris, r6.uris) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.files.hashCode() * 31) + this.uris.hashCode();
        }

        public String toString() {
            return "PendingFeedbackCleanup(files=" + this.files + ", uris=" + this.uris + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PendingFeedbackCleanup(List<? extends File> r2, List<? extends Uri> r3) {
            Intrinsics.checkNotNullParameter(r2, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            Intrinsics.checkNotNullParameter(r3, "uris");
            this.files = r2;
            this.uris = r3;
        }

        public final List<File> getFiles() {
            return this.files;
        }

        public final List<Uri> getUris() {
            return this.uris;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.record.CallRecordAndSummaryActivity$deleteRecord$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallRecordAndSummaryActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.record.CallRecordAndSummaryActivity$deleteRecord$1", f = "CallRecordAndSummaryActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CallFeatureBean $callFeatureBean;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CallRecordAndSummaryActivity this$0;

        AnonymousClass1(CallFeatureBean r1, CallRecordAndSummaryActivity r2, Continuation<? super AnonymousClass1> r3) {
            this.$callFeatureBean = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$callFeatureBean, this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L47;
            ResultKt.throwOnFailure(r9);
            CoroutineScope r10 = (CoroutineScope) this.L$0;
            CallRecordAndSummaryActivity r11 = this.this$0;
            String r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
            String r2 = CallRecordAndSummaryActivity.access$getRecordFilePath$p(r11);     // Catch: Throwable -> L11
            if (r2 == null) goto L8;
            r11.getContentResolver().delete(Uri.parse(r2), null);     // Catch: Throwable -> L11
            CallRecordAndSummaryActivity.access$setRecordFilePath$p(r11, "");     // Catch: Throwable -> L11
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Object r13 = Result.m803constructorimpl(r12);     // Catch: Throwable -> L11
        L14:
            if (Result.m810isSuccessimpl(r13) == false) goto L17;
            Unit r3 = (Unit) r13;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallRecordAndSummaryActivity.TAG, "deleteRecord success");
        L17:
            if (Result.m806exceptionOrNullimpl(r13) == null) goto L19;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallRecordAndSummaryActivity.TAG, "deleteRecord fail");
        L19:
            CallFeatureBean r14 = this.$callFeatureBean;
            if (r14 == null) goto L29;
            String r15 = r14.getPhoneNumber();
            if (r15 == null) goto L29;
            if (r15.length() != 0) goto L26;
            boolean r16 = true;
        L27:
            if (r16 != true) goto L29;
            boolean r17 = true;
        L31:
            if (r17 == false) goto L33;
            Pair r18 = new Pair(CallSummaryASRMessage.CALL_CREATE_TIME + "=?", new String[]{String.valueOf(CallRecordAndSummaryActivity.access$getCallCreateTime$p(this.this$0))});
        L37:
            String r4 = (String) r18.component1();
            String[] r19 = (String[]) r18.component2();
            this.this$0.getContentResolver().delete(ObricCallLogProviderHelper.INSTANCE.getCallSummaryASRMessageUri(), r4, r19);
            this.this$0.getContentResolver().delete(ObricCallLogProviderHelper.INSTANCE.getRecordASRMessageUri(), r4, r19);
            this.this$0.getContentResolver().delete(ObricCallLogProviderHelper.INSTANCE.getRecordInfoUri(), r4, r19);
            String r20 = String.valueOf(CallRecordAndSummaryActivity.access$getCallCreateTime$p(this.this$0));
            String r5 = CallRecordAndSummaryActivity.access$getPhoneNumber$p(this.this$0);
            if (r5 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
            r5 = null;
        L40:
            ObricCallRecordSummaryDeleteObserver.deleteRecordInfo(r20, r5);
            NotificationHelper r21 = NotificationHelper.INSTANCE;
            CallRecordAndSummaryActivity r6 = this.this$0;
            CallRecordAndSummaryActivity r7 = r6;
            long r8 = CallRecordAndSummaryActivity.access$getCallCreateTime$p(r6);
            String r22 = CallRecordAndSummaryActivity.access$getPhoneNumber$p(this.this$0);
            if (r22 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        L44:
            r21.cancelRecordNotification(r7, r8, r0);
            return Unit.INSTANCE;
        L43:
            r0 = r22;
            goto L44
        L33:
            String r23 = CallSummaryASRMessage.CALL_CREATE_TIME + "=? AND " + CallSummaryASRMessage.PHONE_NUMBER + "=?";
            String[] r24 = new String[2];
            r24[0] = String.valueOf(CallRecordAndSummaryActivity.access$getCallCreateTime$p(this.this$0));
            String r25 = CallRecordAndSummaryActivity.access$getPhoneNumber$p(this.this$0);
            if (r25 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
            r25 = null;
        L36:
            r24[1] = r25;
            r18 = new Pair(r23, r24);
            goto L37
        L26:
            r16 = false;
        L29:
            r17 = false;
            goto L31
        L8:
            r12 = null;
        L11:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r13 = Result.m803constructorimpl(ResultKt.createFailure(th));
            goto L14
        L47:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.record.CallRecordAndSummaryActivity$deleteSummary$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallRecordAndSummaryActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.record.CallRecordAndSummaryActivity$deleteSummary$1", f = "CallRecordAndSummaryActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CallFeatureBean $callFeatureBean;
        int label;
        final /* synthetic */ CallRecordAndSummaryActivity this$0;

        C01651(CallFeatureBean r1, CallRecordAndSummaryActivity r2, Continuation<? super C01651> r3) {
            this.$callFeatureBean = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01651(this.$callFeatureBean, this.this$0, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01651) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L29;
            ResultKt.throwOnFailure(r9);
            CallFeatureBean r10 = this.$callFeatureBean;
            if (r10 == null) goto L14;
            String r11 = r10.getPhoneNumber();
            if (r11 == null) goto L14;
            if (r11.length() != 0) goto L11;
            boolean r12 = true;
        L12:
            if (r12 != true) goto L14;
            boolean r13 = true;
        L15:
            String r2 = null;
            if (r13 == false) goto L18;
            Pair r14 = new Pair(CallFeature.CALL_CREATE_TIME + "=?", new String[]{String.valueOf(CallRecordAndSummaryActivity.access$getCallCreateTime$p(this.this$0))});
        L22:
            this.this$0.getContentResolver().delete(ObricCallLogProviderHelper.INSTANCE.getCallFeatureUri(), (String) r14.component1(), (String[]) r14.component2());
            String r15 = String.valueOf(CallRecordAndSummaryActivity.access$getCallCreateTime$p(this.this$0));
            String r8 = CallRecordAndSummaryActivity.access$getPhoneNumber$p(this.this$0);
            if (r8 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        L26:
            ObricCallRecordSummaryDeleteObserver.deleteSummary(r15, r2);
            return Unit.INSTANCE;
        L25:
            r2 = r8;
            goto L26
        L18:
            String r4 = CallFeature.CALL_CREATE_TIME + "=? AND " + CallFeature.PHONE_NUMBER + "=?";
            String[] r5 = new String[2];
            r5[0] = String.valueOf(CallRecordAndSummaryActivity.access$getCallCreateTime$p(this.this$0));
            String r1 = CallRecordAndSummaryActivity.access$getPhoneNumber$p(this.this$0);
            if (r1 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
            r1 = null;
        L21:
            r5[1] = r1;
            r14 = new Pair(r4, r5);
            goto L22
        L11:
            r12 = false;
        L14:
            r13 = false;
            goto L15
        L29:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$2dgrCAo-8at-BpCypH1fBCXzWNw, reason: not valid java name */
    public static /* synthetic */ void m135$r8$lambda$2dgrCAo8atBpCypH1fBCXzWNw(CallRecordAndSummaryActivity r0, View r1) {
        initView$lambda$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$4IDBc6eG4ZkBPH8ZxnH9WP2EQ5M(CallRecordAndSummaryActivity r0, OTextView r1, View r2) {
        setupChips$lambda$34$lambda$33(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$8z9LkzUi98uGR4FAfNPExBUvZWU(WeakReference r0, Function1 r1) {
        executeSafely$lambda$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$GUK_1yKh3eTfUgSkJggEbSmpP9w(CallRecordAndSummaryActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        updateErrTpsTextViewHeight$lambda$74$lambda$73$lambda$72(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: $r8$lambda$GwqN0FhGvTdYdH-eW_ZBBj71B30, reason: not valid java name */
    public static /* synthetic */ void m136$r8$lambda$GwqN0FhGvTdYdHeW_ZBBj71B30(CallRecordAndSummaryActivity r0, int r1, int r2) {
        scrollToPosition$lambda$68(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$H9NPQktEXoHPidBe6Zg7IAavKf0(CallRecordAndSummaryActivity r0, OCheckBox r1, boolean r2) {
        initFeedbackPanel$lambda$28$lambda$27$lambda$24(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$IkDF6NAd93Gisyq1SzZq-d8bS_U, reason: not valid java name */
    public static /* synthetic */ void m137$r8$lambda$IkDF6NAd93Gisyq1SzZqd8bS_U(CallRecordAndSummaryActivity r0, View r1) {
        initFeedbackPanel$lambda$28$lambda$27$lambda$20$lambda$19(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$NXomKmMPqilnR6ay1RenPlntx1M(CallRecordAndSummaryActivity r0, View r1) {
        initView$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$P6-fOWYHuvypcaewgzH40F6Jb6M, reason: not valid java name */
    public static /* synthetic */ void m138$r8$lambda$P6fOWYHuvypcaewgzH40F6Jb6M(CallRecordAndSummaryActivity r0, View r1) {
        initView$lambda$14(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Q4zfmXYnmBrUDpfWRRbo-3vZ7qA, reason: not valid java name */
    public static /* synthetic */ void m139$r8$lambda$Q4zfmXYnmBrUDpfWRRbo3vZ7qA(CallRecordAndSummaryActivity r0, DialogInterface r1, int r2) {
        showAlertDialog$lambda$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$QYly1V1OEd-QBcUujyKCGLG5IHA, reason: not valid java name */
    public static /* synthetic */ boolean m140$r8$lambda$QYly1V1OEdQBcUujyKCGLG5IHA(CallRecordAndSummaryActivity r0, View r1, MotionEvent r2) {
        return touchListener$lambda$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qa0WjwoToyOubSQ-Rs8pH3b3l6w, reason: not valid java name */
    public static /* synthetic */ void m141$r8$lambda$Qa0WjwoToyOubSQRs8pH3b3l6w(int r0, CallRecordAndSummaryActivity r1, CallFeatureBean r2, DialogInterface r3, int r4) {
        showDeleteDialog$lambda$7(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$QpNsVfzyOiOORpjXPAXtSoKnUQY(CallRecordAndSummaryActivity r0, long r1, String r3) {
        refreshCallSummary$lambda$76(r0, r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$R-n5eB0DDamGRmN2YHhe0mtwaTY, reason: not valid java name */
    public static /* synthetic */ void m142$r8$lambda$Rn5eB0DDamGRmN2YHhe0mtwaTY(CallRecordAndSummaryActivity r0, View r1, View r2) {
        initFeedbackPanel$lambda$28$lambda$27$lambda$22(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$V8jpqiQ_RPY9YeV4TQxeQcN-z84, reason: not valid java name */
    public static /* synthetic */ void m143$r8$lambda$V8jpqiQ_RPY9YeV4TQxeQcNz84(CallRecordAndSummaryActivity r0) {
        initView$lambda$11(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$VOOvYdKlAU1Xl3BC6aHqk2-qyWk, reason: not valid java name */
    public static /* synthetic */ void m144$r8$lambda$VOOvYdKlAU1Xl3BC6aHqk2qyWk(CallRecordAndSummaryActivity r0) {
        shareRecordFile$lambda$80$lambda$79(r0);
    }

    public static /* synthetic */ void $r8$lambda$Xw4TVwCb5yvM8HK5xnNBPC3Z4uE(CallRecordAndSummaryActivity r0) {
        scrollRunnable$lambda$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$YxlxAORhxp6lpWpQ4udnOByzoPM(CallRecordAndSummaryActivity r0, MediaPlayer r1) {
        initializeMediaPlayer$lambda$64(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Z70GNN22-5o-Mw1srNbqJZMpcl4, reason: not valid java name */
    public static /* synthetic */ void m145$r8$lambda$Z70GNN225oMw1srNbqJZMpcl4(CallRecordAndSummaryActivity r0, int r1) {
        showFeedbackSubmitFailedToast$lambda$56(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZFvyn1GRe5y9eGT64UsFPcuVS3w(CallRecordAndSummaryActivity r0) {
        updateErrTpsTextViewHeight$lambda$74$lambda$73(r0);
    }

    public static /* synthetic */ void $r8$lambda$ap2sS2Xqx37SBux18G_8f9RChjM(CallRecordAndSummaryActivity r0, long r1, String r3) {
        shareRecordFile$lambda$80(r0, r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$bjRrURpvRCbSY-UtkM8UvZyTJZ0, reason: not valid java name */
    public static /* synthetic */ boolean m146$r8$lambda$bjRrURpvRCbSYUtkM8UvZyTJZ0(CallRecordAndSummaryActivity r0, Message r1) {
        return mHandler$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$e9pGJwbcido7jGgClMG0iMmKpwU(CallRecordAndSummaryActivity r0, View r1) {
        initView$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$fcqRoBYjlf59sX_jw-3ZgEcxk5c, reason: not valid java name */
    public static /* synthetic */ void m147$r8$lambda$fcqRoBYjlf59sX_jw3ZgEcxk5c(CallRecordAndSummaryActivity r0, View r1, View r2) {
        initFeedbackPanel$lambda$28$lambda$27$lambda$26(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$fye1mXhpAF-xElyvHcv3m1BdOeI, reason: not valid java name */
    public static /* synthetic */ void m148$r8$lambda$fye1mXhpAFxElyvHcv3m1BdOeI(CallRecordAndSummaryActivity r0, MediaPlayer r1) {
        initializeMediaPlayer$lambda$66(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jBvlhB72b-t9vem_5knc-FvLRAE, reason: not valid java name */
    public static /* synthetic */ void m149$r8$lambda$jBvlhB72bt9vem_5kncFvLRAE(CallRecordAndSummaryActivity r0) {
        updateErrTpsTextViewHeight$lambda$74(r0);
    }

    public static /* synthetic */ void $r8$lambda$jOxab05jAwTBjm9uN_6AG3q9u_o(CallRecordAndSummaryActivity r0) {
        updateRecordDataRunnable$lambda$70(r0);
    }

    public static /* synthetic */ void $r8$lambda$jUPietlPfiRVWvfwVboM5Aq_aLU(String r0, CallRecordAndSummaryActivity r1) {
        shareRecordFile$lambda$80$lambda$78(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oW0vWVxqeUC_fFwop12Y8HNTLI8(CallRecordAndSummaryActivity r0, CallFeatureBean r1) {
        queryASREntity$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pcxTzgqy9tnXuYGHTmHNL09zyC0(CallRecordAndSummaryActivity r0) {
        updateSeekRunnable$lambda$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$rl458MUYvtLSw6bZ4sx2P_wzAMQ(CallRecordAndSummaryActivity r0) {
        touchRunnable$lambda$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$tXL5JN3VARFkFsS1tQnJNuLiUlY(CallRecordAndSummaryActivity r0, View r1) {
        initView$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$yNZiQtFCShDP9O4ohKP-op_6GdI, reason: not valid java name */
    public static /* synthetic */ void m150$r8$lambda$yNZiQtFCShDP9O4ohKPop_6GdI(MediaPlayer r0) {
        initializeMediaPlayer$lambda$65(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ySzjFAYtq8RJR1gnBAp1iX-vXXE, reason: not valid java name */
    public static /* synthetic */ void m151$r8$lambda$ySzjFAYtq8RJR1gnBAp1iXvXXE(CallRecordAndSummaryActivity r0) {
        updatePositionRunnable$lambda$69(r0);
    }

    static {
        Companion = new Companion(null);
    }

    private static final void initializeMediaPlayer$lambda$65(MediaPlayer r0) {
    }

    public void com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.android.contacts.calllog.record.CallRecordAndSummaryActivity$audioFocusChangeListener$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.android.contacts.calllog.record.CallRecordAndSummaryActivity$recordSummaryChangeListener$1] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.android.contacts.calllog.record.CallRecordAndSummaryActivity$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.android.contacts.calllog.record.CallRecordAndSummaryActivity$feedbackCopyFinishedReceiver$1] */
    public CallRecordAndSummaryActivity() {
        this.callCreateTime = -1;
        this.showSummaryView = true;
        this.MAX_FEEDBACK_CHAR_COUNT = 100;
        this.pendingFeedbackCleanupMap = new ConcurrentHashMap();
        this.feedbackCopyFinishedReceiver = new CallRecordAndSummaryActivity$feedbackCopyFinishedReceiver$1(this);
        this.mHandler = new Handler(Looper.getMainLooper(), new CallRecordAndSummaryActivity$$ExternalSyntheticLambda27(this));
        this.mergeTopOffsetDp = MathKt.roundToInt(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics()));
        this.isScroll = new AtomicBoolean(false);
        this.scrollerDefaultDurationMs = WsConstants.EXIT_DELAY_TIME;
        this.scrollRunnable = new CallRecordAndSummaryActivity$$ExternalSyntheticLambda28(this);
        CallRecordAndSummaryActivity r3 = this;
        this.contactNames = new ContactNames(r3);
        this.scrollListener = new CallRecordAndSummaryActivity$scrollListener$1(this);
        this.touchRunnable = new CallRecordAndSummaryActivity$$ExternalSyntheticLambda29(this);
        this.touchListener = new CallRecordAndSummaryActivity$$ExternalSyntheticLambda30(this);
        this.callSummaryWorking = new AtomicBoolean(false);
        this.recordAsrWorking = new AtomicBoolean(false);
        this.isEmpty = new AtomicBoolean(true);
        this.asrListIsEmpty = new AtomicBoolean(true);
        this.asrList = new ArrayList();
        this.sharedPreferences$delegate = LazyKt.lazy(new CallRecordAndSummaryActivity$sharedPreferences$2(this));
        this.updateSeekRunnable = new CallRecordAndSummaryActivity$$ExternalSyntheticLambda31(this);
        this.mediaPlayerReleased = new AtomicBoolean(false);
        this.recordSummaryChangeListener = new CallRecordAndSummaryActivity$recordSummaryChangeListener$1(this);
        this.linearLayoutManager = new LinearLayoutManager(r3);
        ?? r0 = new CallRecordAndSummaryActivity$audioFocusChangeListener$1(this);
        this.audioFocusChangeListener = r0;
        this.audioFocusManager = new AudioFocusManager(r3, (AudioFocusChangeListener) r0);
        this.updatePositionRunnable = new CallRecordAndSummaryActivity$$ExternalSyntheticLambda32(this);
        this.updateRecordDataRunnable = new CallRecordAndSummaryActivity$$ExternalSyntheticLambda33(this);
        this.summaryListener = new CallRecordAndSummaryActivity$summaryListener$1(this);
    }

    public static final /* synthetic */ boolean access$checkoutSubmit(CallRecordAndSummaryActivity r0) {
        return r0.checkoutSubmit();
    }

    public static final /* synthetic */ void access$cleanupPendingFeedbackFiles(CallRecordAndSummaryActivity r0, long r1) {
        r0.cleanupPendingFeedbackFiles(r1);
    }

    public static final /* synthetic */ String access$collectFeedbackDesc(CallRecordAndSummaryActivity r0) {
        return r0.collectFeedbackDesc();
    }

    public static final /* synthetic */ File access$exportFeedbackTranscriptFile(CallRecordAndSummaryActivity r0) {
        return r0.exportFeedbackTranscriptFile();
    }

    public static final /* synthetic */ void access$generateFileUri(CallRecordAndSummaryActivity r0, File r1, Function1 r2) {
        r0.generateFileUri(r1, r2);
    }

    public static final /* synthetic */ List access$getAsrList$p(CallRecordAndSummaryActivity r0) {
        return r0.asrList;
    }

    public static final /* synthetic */ long access$getCallCreateTime$p(CallRecordAndSummaryActivity r2) {
        return r2.callCreateTime;
    }

    public static final /* synthetic */ TextView access$getCharCountAlertTextView$p(CallRecordAndSummaryActivity r0) {
        return r0.charCountAlertTextView;
    }

    public static final /* synthetic */ String access$getDisplayTitle(CallRecordAndSummaryActivity r0) {
        return r0.getDisplayTitle();
    }

    public static final /* synthetic */ OEditText access$getFeedbackEditText$p(CallRecordAndSummaryActivity r0) {
        return r0.feedbackEditText;
    }

    public static final /* synthetic */ OSheet access$getFeedbackSheet$p(CallRecordAndSummaryActivity r0) {
        return r0.feedbackSheet;
    }

    public static final /* synthetic */ int access$getMAX_FEEDBACK_CHAR_COUNT$p(CallRecordAndSummaryActivity r0) {
        return r0.MAX_FEEDBACK_CHAR_COUNT;
    }

    public static final /* synthetic */ Handler access$getMHandler$p(CallRecordAndSummaryActivity r0) {
        return r0.mHandler;
    }

    public static final /* synthetic */ MediaPlayer access$getMediaPlayer$p(CallRecordAndSummaryActivity r0) {
        return r0.mediaPlayer;
    }

    public static final /* synthetic */ int access$getMediaPlayerDuration(CallRecordAndSummaryActivity r0) {
        return r0.getMediaPlayerDuration();
    }

    public static final /* synthetic */ String access$getPhoneNumber$p(CallRecordAndSummaryActivity r0) {
        return r0.phoneNumber;
    }

    public static final /* synthetic */ String access$getRecordFilePath$p(CallRecordAndSummaryActivity r0) {
        return r0.recordFilePath;
    }

    public static final /* synthetic */ String access$getSpeakerName(CallRecordAndSummaryActivity r0, Context r1, int r2, String r3) {
        return r0.getSpeakerName(r1, r2, r3);
    }

    public static final /* synthetic */ OFloatingTitleBarHolder access$getTitleBarHolder$p(CallRecordAndSummaryActivity r0) {
        return r0.titleBarHolder;
    }

    public static final /* synthetic */ Runnable access$getUpdateRecordDataRunnable$p(CallRecordAndSummaryActivity r0) {
        return r0.updateRecordDataRunnable;
    }

    public static final /* synthetic */ void access$handleFeedbackTriggerResult(CallRecordAndSummaryActivity r0, Bundle r1, List r2, List r3) {
        r0.handleFeedbackTriggerResult(r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$isActivityResumed$p(CallRecordAndSummaryActivity r0) {
        return r0.isActivityResumed;
    }

    public static final /* synthetic */ boolean access$isFeedbackDislikeSelected$p(CallRecordAndSummaryActivity r0) {
        return r0.isFeedbackDislikeSelected;
    }

    public static final /* synthetic */ boolean access$isFeedbackLikeSelected$p(CallRecordAndSummaryActivity r0) {
        return r0.isFeedbackLikeSelected;
    }

    public static final /* synthetic */ boolean access$isPlaying(CallRecordAndSummaryActivity r0) {
        return r0.isPlaying();
    }

    public static final /* synthetic */ void access$pauseRecord(CallRecordAndSummaryActivity r0) {
        r0.pauseRecord();
    }

    public static final /* synthetic */ void access$playRecord(CallRecordAndSummaryActivity r0) {
        r0.playRecord();
    }

    public static final /* synthetic */ File access$prepareFeedbackRecordFile(CallRecordAndSummaryActivity r0) {
        return r0.prepareFeedbackRecordFile();
    }

    public static final /* synthetic */ void access$setCallUserName$p(CallRecordAndSummaryActivity r0, String r1) {
        r0.callUserName = r1;
    }

    public static final /* synthetic */ void access$setFeedbackDislikeSelected$p(CallRecordAndSummaryActivity r0, boolean r1) {
        r0.isFeedbackDislikeSelected = r1;
    }

    public static final /* synthetic */ void access$setFeedbackLikeSelected$p(CallRecordAndSummaryActivity r0, boolean r1) {
        r0.isFeedbackLikeSelected = r1;
    }

    public static final /* synthetic */ void access$setRecordFilePath$p(CallRecordAndSummaryActivity r0, String r1) {
        r0.recordFilePath = r1;
    }

    public static final /* synthetic */ void access$setTracking$p(CallRecordAndSummaryActivity r0, boolean r1) {
        r0.tracking = r1;
    }

    public static final /* synthetic */ void access$shareRecordFile(CallRecordAndSummaryActivity r0, long r1, String r3) {
        r0.shareRecordFile(r1, r3);
    }

    public static final /* synthetic */ void access$showDeleteDialog(CallRecordAndSummaryActivity r0, int r1, int r2, CallFeatureBean r3) {
        r0.showDeleteDialog(r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateFeedbackVoteState(CallRecordAndSummaryActivity r0) {
        r0.updateFeedbackVoteState();
    }

    public static final /* synthetic */ void access$updateSeekBar(CallRecordAndSummaryActivity r0, int r1, int r2) {
        r0.updateSeekBar(r1, r2);
    }

    private static final boolean mHandler$lambda$0(CallRecordAndSummaryActivity r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (r4.what != 1) goto L12;
        r3.queryASREntity(true);
        r3.updateRecordSummaryWorkingStatus();
        r3.initializeMediaPlayer();
        RecyclerView r5 = r3.recordListView;
        RecordSentenceAdapter r1 = null;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r5 = null;
    L7:
        RecordSentenceAdapter r2 = r3.adapter;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L11:
        r5.setAdapter(r1);
        r3.updateFeedbackVisibility();
        r3.updateErrTpsTextViewHeight();
        r3.initRightTitleBtn();
        goto L12
    L10:
        r1 = r2;
    L12:
        return true;
    }

    public final AtomicBoolean isScroll() {
        return this.isScroll;
    }

    public final long getScrollerDefaultDurationMs() {
        return this.scrollerDefaultDurationMs;
    }

    public final Runnable getScrollRunnable() {
        return this.scrollRunnable;
    }

    private static final void scrollRunnable$lambda$1(CallRecordAndSummaryActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        boolean r0 = r4.isPlaying();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "scrollRunnable: isScroll = " + r4.isScroll.get() + ", isPlaying = " + r0);
        r4.isScroll.set(false);
        if (r0 == false) goto L6;
        scrollToPosition$default(r4, r4.position, 0, 2, null);
        return;
    }

    public final boolean isUserScrolling() {
        return this.isUserScrolling;
    }

    public final void setUserScrolling(boolean r1) {
        this.isUserScrolling = r1;
    }

    private static final void touchRunnable$lambda$2(CallRecordAndSummaryActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.isUserScrolling = false;
    }

    private static final boolean touchListener$lambda$3(CallRecordAndSummaryActivity r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        int r5 = r4.getAction();
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L6;
    L10:
        r2.mHandler.postDelayed(r2.touchRunnable, 100);
        return false;
    L6:
        if (r5 == 2) goto L11;
        if (r5 == 3) goto L10;
        return false;
    L11:
        r2.isUserScrolling = true;
        r2.mHandler.removeCallbacks(r2.touchRunnable);
        return false;
    }

    public final OPopover getOPopover() {
        return this.oPopover;
    }

    public final void setOPopover(OPopover r1) {
        this.oPopover = r1;
    }

    private final SharedPreferences getSharedPreferences() {
        Object r1 = this.sharedPreferences$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-sharedPreferences>(...)");
        return (SharedPreferences) r1;
    }

    private static final void updateSeekRunnable$lambda$4(CallRecordAndSummaryActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.updateSeekBar();
    }

    private final void initIntent() {
        this.callCreateTime = getIntent().getLongExtra("call_create_time", -1);
        String r0 = getIntent().getStringExtra(CALL_USER_NAME);
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.callUserName = r0;
        String r2 = getIntent().getStringExtra("phone_number");
        if (r2 != null) goto L8;
        String r4 = "";
    L9:
        this.phoneNumber = StringsKt.replace$default(r4, "-", "", false, 4, null);
        boolean r5 = true;
        this.showSummaryView = getIntent().getBooleanExtra(SHOW_CALLLOG_SUMMARY, true);
        String r3 = getIntent().getStringExtra("enter_from");
        if (r3 != null) goto L12;
        r3 = "outside";
    L12:
        this.enter_from = r3;
        String r6 = getIntent().getStringExtra(CallSummaryWidget.INTENT_PARAMS_CALL_SUMMARY_ID);
        StringBuilder r7 = new StringBuilder("CallRecordAndSummaryActivity callCreateTime:").append(this.callCreateTime).append(", summaryId is null:");
        String r8 = r6;
        if (r8 != null) goto L15;
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallSummaryWidget.TAG, r7.append(r5).toString());
        if (TextUtils.isEmpty(r8) == true) goto L37;
        Pair<String, String> r9 = CallSummaryWidget.getCallCreateTimeAndPhoneNumber(r6);
        if (r9 == null) goto L25;
        String r10 = r9.getFirst();
        if (r10 == null) goto L25;
        long r11 = Long.parseLong(r10);
    L26:
        this.callCreateTime = r11;
        if (r9 == null) goto L32;
        String r12 = r9.getSecond();
        if (r12 == null) goto L32;
        r1 = r12;
    L32:
        this.phoneNumber = r1;
        ContactNames r13 = this.contactNames;
        if (r1 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r1 = null;
    L35:
        r13.getName(r1, new C01671(this));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallSummaryWidget.TAG, "CallRecordAndSummaryActivity callCreateTime:" + this.callCreateTime);
    L25:
        r11 = -1;
    L37:
        if (this.callCreateTime == (-1)) goto L39;
        return;
    L39:
        if (ContactsUtils.DEBUG == true) goto L42;
        return;
    L42:
        throw new Exception("callCreateTime must not be -1!");
    L15:
        if (r8.length() == 0) goto L18;
        r5 = false;
        goto L18
    L8:
        r4 = r2;
        goto L9
    }

    private final String getDisplayTitle() {
        String r0 = this.callUserName;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("callUserName");
        r0 = null;
    L6:
        if ((!StringsKt.isBlank(r0)) == false) goto L12;
        String r3 = this.callUserName;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("callUserName");
        return null;
    L11:
        return r3;
    L12:
        String r4 = this.phoneNumber;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        return null;
    L16:
        return r4;
    }

    static /* synthetic */ void queryASREntity$default(CallRecordAndSummaryActivity r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.queryASREntity(r1);
    }

    private final void queryASREntity(boolean r20) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "queryASREntity start!");
        CallFeatureModel r1 = CallFeatureModel.INSTANCE;
        long r3 = this.callCreateTime;
        String r5 = this.phoneNumber;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r5 = null;
    L5:
        final CallFeatureBean r2 = r1.getCallFeature(r3, r5);
        if (r20 == true) goto L15;
        if (r2 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "queryASREntity callFeatureBean.equals(preCallFeatureBean), return");
        return;
    L9:
        if (r2.equals(this.preCallFeatureBean) != true) goto L11;
        r6 = true;
    L15:
        this.asrList.clear();
        this.preCallFeatureBean = r2;
        if (r2 == null) goto L18;
        this.onlyShowCallSummaryView = !r2.isFeatureCallRecordEnabled();
    L18:
        ObricCallLogProviderHelper r7 = ObricCallLogProviderHelper.INSTANCE;
        CallRecordAndSummaryActivity r9 = this;
        long r10 = this.callCreateTime;
        String r8 = this.phoneNumber;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r8 = null;
    L21:
        List<RecordInfoEntity> r11 = r7.getRecordInfoEntity(r9, r10, r8);
        if ((!r11.isEmpty()) == false) goto L24;
        this.recordFilePath = r11.get(0).getPath();
    L24:
        if (r2 != null) goto L26;
    L28:
        boolean r12 = false;
    L30:
        if (r12 == true) goto L32;
    L37:
        List<RecordASRMessageEntity> r13 = CollectionsKt.emptyList();
    L38:
        List<RecordASRMessageEntity> r14 = r13;
        this.asrListIsEmpty.set(r14.isEmpty());
        List<RecordASRMessageEntity> r15 = r14;
        this.asrList.addAll(r15);
        long r16 = this.callCreateTime;
        if (r2 == null) goto L42;
        String r17 = r2.getPhoneNumber();
        if (r17 == null) goto L42;
    L43:
        boolean r18 = this.showSummaryView;
        int r19 = this.statusBarHeight;
        CallRecordAndSummaryActivity r110 = this;
        if (r2 != null) goto L46;
    L48:
        boolean r111 = false;
    L49:
        this.adapter = new RecordSentenceAdapter(r9, r16, r17, r14, r18, r19, r110, r111);
        initFeedbackButtons();
        if (r2 != null) goto L52;
    L54:
        boolean r21 = false;
    L55:
        if (r21 == true) goto L57;
    L62:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "queryASREntity done! Change a new adapter.");
        return;
    L57:
        if ((true ^ r15.isEmpty()) == false) goto L62;
        long r4 = this.callCreateTime;
        String r22 = this.phoneNumber;
        if (r22 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r22 = null;
    L61:
        refreshCallSummary(r4, r22, false);
        GlobalUtils.INSTANCE.execute(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda18(this, r2));
        goto L62
    L52:
        if (r2.isAsrFailCanNotUseMobileNetwork() != true) goto L54;
        r21 = true;
        goto L55
    L46:
        if (r2.isAsrFailCanNotUseMobileNetwork() != true) goto L48;
        r111 = true;
    L42:
        r17 = "";
        goto L43
    L32:
        if (r2.isRecordASRAvailable() == false) goto L37;
        ObricCallLogProviderHelper r23 = ObricCallLogProviderHelper.INSTANCE;
        long r112 = this.callCreateTime;
        String r113 = r2.getPhoneNumber();
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        r13 = r23.getRecordASRMessageEntity(r9, r112, r113);
        goto L38
    L26:
        if (r2.isFeatureCallRecordEnabled() != true) goto L28;
        r12 = true;
        goto L30
    }

    private static final void queryASREntity$lambda$5(CallRecordAndSummaryActivity r7, CallFeatureBean r8) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        ObricCallLogProviderHelper.INSTANCE.updateCallFeatureStatusToObricCallLog(r7, r8.getId(), 0, 16);
    }

    public void com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.calllog_record_and_summary);
        UiUtils.setWindowColorStatusBar(this);
        registerFeedbackCopyFinishedReceiver();
        initIntent();
        int r4 = 0;
        ViewGroup r1 = null;
        queryASREntity$default(this, false, 1, null);
        updateRecordSummaryWorkingStatus();
        initView();
        initializeMediaPlayer();
        initRightTitleBtn();
        ObricCallRecordSummaryDeleteObserver.addRecordChangeListener(this.recordSummaryChangeListener);
        ViewGroup r0 = this.emptyView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    L6:
        ViewGroup r2 = r1;
        if (this.isEmpty.get() == true) goto L10;
        r4 = 8;
    L10:
        r2.setVisibility(r4);
        return;
    L5:
        r1 = r0;
        goto L6
    }

    public final void initRightTitleBtn() {
        dialogDismiss();
        OFloatingTitleBarHolder r0 = this.titleBarHolder;
        OFloatingTitleBarHolder r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarHolder");
        r0 = null;
    L5:
        r0.endButtonToState("STATE_NONE");
        ViewGroup r1 = this.playerContainerView;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("playerContainerView");
        r1 = null;
    L8:
        boolean r3 = true;
        if (ViewExtensionsKt.isVisibile(r1) == false) goto L11;
    L16:
        boolean r4 = true;
    L17:
        CallFeatureModel r5 = CallFeatureModel.INSTANCE;
        long r6 = this.callCreateTime;
        String r8 = this.phoneNumber;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r8 = null;
    L20:
        CallFeatureBean r7 = r5.getCallFeature(r6, r8);
        if (this.showSummaryView == false) goto L33;
        if (r7 == null) goto L28;
        CallSummary r9 = r7.getSummary();
        if (r9 == null) goto L28;
        if (r9.isEmpty() == true) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
    L34:
        if (r4 == true) goto L37;
        if (r3 == true) goto L37;
        return;
    L37:
        OFloatingTitleBarHolder r11 = this.titleBarHolder;
        if (r11 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarHolder");
    L41:
        r2.endButtonToState(OFloatingTitleBarHolder.STATE_NORMAL);
        return;
    L40:
        r2 = r11;
        goto L41
    L31:
        if (this.callSummaryWorking.get() == false) goto L33;
    L28:
        r10 = false;
    L33:
        r3 = false;
        goto L34
    L11:
        if (this.asrListIsEmpty.get() == false) goto L16;
        if (isAsrWorking() == true) goto L16;
        r4 = false;
        goto L17
    }

    private final void rightBtnClick(View r13) {
        CallFeatureModel r0 = CallFeatureModel.INSTANCE;
        long r1 = this.callCreateTime;
        String r3 = this.phoneNumber;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r3 = null;
    L5:
        CallFeatureBean r7 = r0.getCallFeature(r1, r3);
        ViewGroup r2 = this.playerContainerView;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("playerContainerView");
        r2 = null;
    L9:
        if (ViewExtensionsKt.isVisibile(r2) == false) goto L11;
    L16:
        boolean r8 = true;
    L18:
        if (this.showSummaryView == false) goto L30;
        if (r7 == null) goto L25;
        CallSummary r4 = r7.getSummary();
        if (r4 == null) goto L25;
        if (r4.isEmpty() == true) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L28;
    L29:
        boolean r9 = true;
    L31:
        if (r8 == false) goto L34;
        if (r9 == false) goto L34;
        Pair r6 = new Pair(Integer.valueOf(R.string.delete_call_record_and_summary), Integer.valueOf(R.string.dialog_delete_call_record_and_summary));
    L40:
        buildAndShowPopoverMenu(r13, r7, r8, r9, (Integer) r6.component1(), (Integer) r6.component2());
        return;
    L34:
        if (r8 == true) goto L37;
        if (r9 == false) goto L37;
        r6 = new Pair(Integer.valueOf(R.string.delete_call_summary), Integer.valueOf(R.string.dialog_delete_call_summary));
    L37:
        if (r8 == false) goto L39;
        r6 = new Pair(Integer.valueOf(R.string.delete_call_record), Integer.valueOf(R.string.dialog_delete_call_record));
        goto L40
    L39:
        r6 = TuplesKt.to(null, null);
        goto L40
    L28:
        if (this.callSummaryWorking.get() == false) goto L30;
    L25:
        r5 = false;
    L30:
        r9 = false;
        goto L31
    L11:
        if (this.asrListIsEmpty.get() == false) goto L16;
        if (isAsrWorking() == true) goto L16;
        r8 = false;
        goto L18
    }

    private final void buildAndShowPopoverMenu(View r9, CallFeatureBean r10, boolean r11, boolean r12, Integer r13, Integer r14) {
        boolean r1 = true;
        if ((!this.asrList.isEmpty()) == false) goto L15;
        if (r10 == null) goto L10;
        CallSummary r0 = r10.getSummary();
        if (r0 == null) goto L10;
        if (r0.isEmpty() != true) goto L10;
    L11:
        if (r1 == false) goto L15;
        if (isAsrWorking() == true) goto L15;
        String r2 = getString(R.string.generate_summary);
    L16:
        String r4 = r2;
        Intrinsics.checkNotNullExpressionValue(r4, "if(asrList.isNotEmpty()\n…efresh_summary)\n        }");
        CallRecordAndSummaryActivity r3 = this;
        OPopover r5 = OUIPopoverHelper.genPopover$default(r3, buildPopoverMenuItems(r10, r11, r12, r4, r13, r14), false, 4, null);
        this.oPopover = r5;
        if (r5 == null) goto L20;
        OUIPopoverHelper.showPopupAtAnchorView(r3, r5, Direct.BOTTOM_LEFT, r9, null);
        return;
    L20:
        return;
    L10:
        r1 = false;
    L15:
        r2 = getString(R.string.refresh_summary);
        goto L16
    }

    private final void showDeleteDialog(final int r2, int r3, final CallFeatureBean r4) {
        showAlertDialog(r3, new CallRecordAndSummaryActivity$$ExternalSyntheticLambda2(r2, this, r4));
    }

    private static final void showDeleteDialog$lambda$7(int r0, CallRecordAndSummaryActivity r1, CallFeatureBean r2, DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r3 == null) goto L5;
        r3.dismiss();
    L5:
        switch(r0) {
            case 2131886751: goto L9;
            case 2131886752: goto L8;
            case 2131886753: goto L7;
            default: goto L10;
        };
    L7:
        r1.deleteSummary(r2);
        goto L10
    L8:
        r1.deleteRecord(r2);
        r1.deleteSummary(r2);
        goto L10
    L9:
        r1.deleteRecord(r2);
    L10:
        r1.finish();
    }

    private final void showAlertDialog(int r14, DialogInterface.OnClickListener r15) {
        OAlertDialogUtils r0 = OAlertDialogUtils.INSTANCE;
        String r16 = getString(r14);
        String r1 = getString(R.string.common_delete);
        String r2 = getString(R.string.common_cancel);
        CallRecordAndSummaryActivity r3 = this;
        String r4 = r16;
        String r5 = r1;
        String r8 = r2;
        OAlertDialog r17 = OAlertDialogUtils.showConfirmationDialog$default(r3, r4, null, r5, r15, ButtonStyleController.TextColorType.Negative, r8, new CallRecordAndSummaryActivity$$ExternalSyntheticLambda1(this), null, 256, null);
        this.deleteDialog = r17;
        if (r17 == null) goto L5;
        r17.setCanceledOnTouchOutside(true);
    L5:
        OAlertDialog r13 = this.deleteDialog;
        if (r13 == null) goto L9;
        r13.show();
        return;
    }

    private static final void showAlertDialog$lambda$8(CallRecordAndSummaryActivity r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OAlertDialog r3 = r0.deleteDialog;
        if (r3 == null) goto L6;
        r3.dismiss();
        return;
    }

    private final void deleteRecord(CallFeatureBean r8) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r8, this, null), 3, null);
    }

    private final void deleteSummary(CallFeatureBean r8) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C01651(r8, this, null), 3, null);
    }

    public final LinearLayoutManager getLinearLayoutManager() {
        return this.linearLayoutManager;
    }

    public final void initView() {
        View r0 = findViewById(R.id.ic_backward);
        Intrinsics.checkNotNull(r0);
        this.backwardButton = (OIconButtonFloating) r0;
        View r1 = findViewById(R.id.ic_forward);
        Intrinsics.checkNotNull(r1);
        this.forwardButton = (OIconButtonFloating) r1;
        View r2 = findViewById(R.id.ic_play);
        Intrinsics.checkNotNull(r2);
        this.playAndPauseButton = (OIconButtonFloating) r2;
        View r3 = findViewById(R.id.seek_bar);
        Intrinsics.checkNotNull(r3);
        this.slider = (OSlider) r3;
        View r4 = findViewById(R.id.tv_end_time);
        Intrinsics.checkNotNull(r4);
        this.endTimeTextView = (TextView) r4;
        View r5 = findViewById(R.id.tv_play_time);
        Intrinsics.checkNotNull(r5);
        this.playTimeTextView = (TextView) r5;
        View r6 = findViewById(R.id.record_list);
        Intrinsics.checkNotNull(r6);
        this.recordListView = (RecyclerView) r6;
        View r7 = findViewById(R.id.title_bar);
        Intrinsics.checkNotNull(r7);
        OFloatingTitleBarHolder r8 = new OFloatingTitleBarHolder((OFloatingTitleBar) r7);
        this.titleBarHolder = r8;
        r8.addStartAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_back_22_22, new CallRecordAndSummaryActivity$$ExternalSyntheticLambda9(this));
        OFloatingTitleBarHolder r9 = this.titleBarHolder;
        OSlider r10 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarHolder");
        r9 = null;
    L5:
        r9.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_menu_more, new CallRecordAndSummaryActivity$$ExternalSyntheticLambda10(this));
        View r11 = findViewById(R.id.record_list_err_layout);
        Intrinsics.checkNotNull(r11);
        this.listAndErrView = (ViewGroup) r11;
        View r12 = findViewById(R.id.error_tips);
        Intrinsics.checkNotNull(r12);
        this.errorTpsTextView = (TextView) r12;
        View r13 = findViewById(R.id.cl_player_container);
        Intrinsics.checkNotNull(r13);
        this.playerContainerView = (ViewGroup) r13;
        View r14 = findViewById(R.id.asr_empty_view);
        Intrinsics.checkNotNull(r14);
        this.emptyView = (ViewGroup) r14;
        OFloatingTitleBarHolder r15 = this.titleBarHolder;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarHolder");
        r15 = null;
    L8:
        OFloatingTitleBar r16 = r15.getTitleBar();
        long r17 = this.callCreateTime;
        String r18 = getResources().getString(R.string.ymdhm_date_time_format);
        Intrinsics.checkNotNullExpressionValue(r18, "resources.getString(R.st…g.ymdhm_date_time_format)");
        r16.setCenterSubtitle(TimeUtilKt.formatTimestamp(r17, r18));
        OFloatingTitleBarHolder r19 = this.titleBarHolder;
        if (r19 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarHolder");
        r19 = null;
    L11:
        OTextView r20 = (OTextView) r19.getTitleBar().findViewById(R.id.center_sub_title);
        OFloatingTitleBarHolder r21 = this.titleBarHolder;
        if (r21 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarHolder");
        r21 = null;
    L14:
        OTextView r22 = (OTextView) r21.getTitleBar().findViewById(R.id.center_title);
        if (r22 == null) goto L21;
        if (r20 == null) goto L19;
        int r23 = r20.getMeasuredWidth();
    L20:
        r22.setMaxWidth(r23);
        goto L21
    L19:
        r23 = MathKt.roundToInt(TypedValue.applyDimension(1, 220, Resources.getSystem().getDisplayMetrics()));
    L21:
        if (r22 == null) goto L23;
        r22.setSingleLine();
    L23:
        if (r22 == null) goto L26;
        r22.setEllipsize(TextUtils.TruncateAt.END);
    L26:
        if (r22 == null) goto L29;
        r22.setGravity(17);
    L29:
        OFloatingTitleBarHolder r24 = this.titleBarHolder;
        if (r24 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarHolder");
        r24 = null;
    L32:
        r24.getTitleBar().setCenterTitle(getDisplayTitle());
        OSlider r25 = this.slider;
        if (r25 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("slider");
        r25 = null;
    L35:
        r25.setProcessProgressColor(R.color.oui_text_1);
        RecyclerView r26 = this.recordListView;
        if (r26 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r26 = null;
    L38:
        r26.setLayoutManager(this.linearLayoutManager);
        RecyclerView r27 = this.recordListView;
        if (r27 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r27 = null;
    L41:
        RecordSentenceAdapter r28 = this.adapter;
        if (r28 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r28 = null;
    L44:
        r27.setAdapter(r28);
        RecyclerView r29 = this.recordListView;
        if (r29 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r29 = null;
    L47:
        r29.setVerticalScrollBarEnabled(true);
        RecyclerView r30 = this.recordListView;
        if (r30 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r30 = null;
    L50:
        r30.post(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda12(this));
        RecyclerView r31 = this.recordListView;
        if (r31 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r31 = null;
    L53:
        r31.setOnScrollListener(this.scrollListener);
        RecyclerView r32 = this.recordListView;
        if (r32 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r32 = null;
    L56:
        r32.setOnTouchListener(this.touchListener);
        OIconButtonFloating r33 = this.playAndPauseButton;
        if (r33 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("playAndPauseButton");
        r33 = null;
    L59:
        r33.setOnClickListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda13(this));
        OIconButtonFloating r34 = this.forwardButton;
        if (r34 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("forwardButton");
        r34 = null;
    L62:
        r34.setOnClickListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda14(this));
        OIconButtonFloating r35 = this.backwardButton;
        if (r35 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("backwardButton");
        r35 = null;
    L65:
        r35.setOnClickListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda15(this));
        OSlider r36 = this.slider;
        if (r36 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("slider");
    L69:
        r10.setOnSeekBarChangeListenerExt(new AnonymousClass7(this));
        return;
    L68:
        r10 = r36;
        goto L69
    }

    private static final void initView$lambda$9(CallRecordAndSummaryActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void initView$lambda$10(CallRecordAndSummaryActivity r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "view");
        r1.rightBtnClick(r2);
    }

    private static final void initView$lambda$11(CallRecordAndSummaryActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.updateErrTpsTextViewHeight();
    }

    private static final void initView$lambda$12(CallRecordAndSummaryActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.isPlaying() == false) goto L5;
        r0.pauseRecord();
        r0.audioFocusManager.releaseAudioFocus();
        return;
    L5:
        if (r0.audioFocusManager.requestAudioFocus() == false) goto L9;
        r0.playRecord();
        return;
    }

    private static final void initView$lambda$13(CallRecordAndSummaryActivity r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        MediaPlayer r3 = r1.mediaPlayer;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r3 = null;
    L5:
        r3.seekTo(r1.getMediaPlayerCurrentPosition() + KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r1.updateSeekBar();
        r1.updateListPosition(r1.getMediaPlayerCurrentPosition());
    }

    private static final void initView$lambda$14(CallRecordAndSummaryActivity r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        MediaPlayer r3 = r1.mediaPlayer;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r3 = null;
    L5:
        r3.seekTo(r1.getMediaPlayerCurrentPosition() - 10000);
        r1.updateSeekBar();
        r1.updateListPosition(r1.getMediaPlayerCurrentPosition());
    }

    private final boolean hasFeedback() {
        StringBuilder r0 = new StringBuilder("feedback_").append(this.callCreateTime).append('_');
        String r1 = this.phoneNumber;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r1 = null;
    L5:
        String r2 = r0.append(r1).toString();
        return getSharedPreferences().getBoolean(r2, false);
    }

    private final void saveFeedback() {
        StringBuilder r0 = new StringBuilder("feedback_").append(this.callCreateTime).append('_');
        String r1 = this.phoneNumber;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r1 = null;
    L5:
        String r2 = r0.append(r1).toString();
        SharedPreferences.Editor r3 = getSharedPreferences().edit();
        Intrinsics.checkNotNullExpressionValue(r3, "editor");
        r3.putBoolean(r2, true);
        r3.apply();
    }

    private final void executeSafely(final Function1<? super CallRecordAndSummaryActivity, Unit> r3) {
        final WeakReference r0 = new WeakReference(this);
        GlobalUtils.INSTANCE.execute(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda17(r0, r3));
    }

    private static final void executeSafely$lambda$17(WeakReference r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$weakActivity");
        Intrinsics.checkNotNullParameter(r2, "$block");
        CallRecordAndSummaryActivity r3 = (CallRecordAndSummaryActivity) r1.get();
        if (r3 == null) goto L6;
        r2.invoke(r3);
        return;
    }

    private final void updateFeedbackVisibility() {
        boolean r0 = shouldShowFeedbackBar();
        if (r0 == false) goto L5;
        initFeedbackPanel();
    L5:
        RecordSentenceAdapter r1 = this.adapter;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L8:
        r1.updateFeedbackVisibility(r0);
    }

    private final void initFeedbackButtons() {
        RecordSentenceAdapter r0 = this.adapter;
        RecordSentenceAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        r0.notifyFeedbackVoteState(this.isFeedbackLikeSelected, this.isFeedbackDislikeSelected);
        RecordSentenceAdapter r2 = this.adapter;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r1.bindFeedbackActions(new C01661(this), new AnonymousClass2(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void updateFeedbackVoteState() {
        RecordSentenceAdapter r0 = this.adapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        r0.notifyFeedbackVoteState(this.isFeedbackLikeSelected, this.isFeedbackDislikeSelected);
    }

    private final void initFeedbackPanel() {
        if (this.feedbackSheet == null) goto L5;
        return;
    L5:
        OSheet r0 = new OSheet(this, 0, 0, false, false, 28, null);
        r0.setCanceledOnTouchOutside(false);
        this.feedbackSheet = r0;
        final View r2 = r0.getLayoutInflater().inflate(R.layout.activity_calllog_feedback, null);
        if (r2 == null) goto L27;
        Intrinsics.checkNotNullExpressionValue(r2, "inflate(R.layout.activity_calllog_feedback, null)");
        r0.setBodyView(r2);
        OEditText r3 = (OEditText) r2.findViewById(R.id.feedback_edit_text);
        this.feedbackEditText = r3;
        if (r3 == null) goto L11;
        r3.setMovementMethod(new ScrollingMovementMethod());
    L11:
        OFloatingTitleBar r4 = (OFloatingTitleBar) r2.findViewById(R.id.feedback_title_bar);
        if (r4 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById<OFloatingTi…(R.id.feedback_title_bar)");
        OFloatingTitleBar.addEndAction$default(r4, R.drawable.o_floating_title_bar_icon_close, 0, new CallRecordAndSummaryActivity$$ExternalSyntheticLambda3(this), 2, null);
        r4.setCenterTitle(R.string.feedback_title);
    L14:
        LinearLayout r5 = (LinearLayout) r2.findViewById(R.id.feedback_overlay);
        this.feedbackOverlay = r5;
        if (r5 == null) goto L17;
        r5.setOnClickListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda4(this, r2));
    L17:
        this.charCountAlertTextView = (TextView) r2.findViewById(R.id.tv_char_count_alert);
        final TextView r6 = (TextView) r2.findViewById(R.id.tv_char_count);
        r6.setText(r6.getResources().getString(R.string.feedback_char_count, new Object[]{0}));
        OEditText r7 = this.feedbackEditText;
        if (r7 == null) goto L20;
        r7.addTextChangedListener(new CallRecordAndSummaryActivity$initFeedbackPanel$2$1$3$1(r6, this));
    L20:
        this.charCountTextView = r6;
        this.chipSlowResponse = (OTextView) r2.findViewById(R.id.chip_slow_response);
        this.chipPoorEffect = (OTextView) r2.findViewById(R.id.chip_poor_effect);
        this.chipInaccurateASR = (OTextView) r2.findViewById(R.id.chip_inaccurate_asr);
        this.chipInaccurateSummary = (OTextView) r2.findViewById(R.id.chip_inaccurate_summary);
        this.chipOther = (OTextView) r2.findViewById(R.id.chip_other);
        setupChips();
        OCheckBox r8 = (OCheckBox) r2.findViewById(R.id.consent_checkbox);
        this.consentCheckbox = r8;
        if (r8 == null) goto L23;
        r8.setOnCheckedChangeListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda5(this));
    L23:
        OButton r9 = (OButton) r2.findViewById(R.id.submit_button);
        this.submitButton = r9;
        if (r9 == null) goto L26;
        r9.setOnClickListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda6(this, r2));
    L26:
        checkoutSubmit();
    L27:
        ViewExtensionsKt.setEnable(r0.getBodyContainer(), false);
        ViewExtensionsKt.setEnable(r0.getRootContainer(), false);
    }

    private static final void initFeedbackPanel$lambda$28$lambda$27$lambda$20$lambda$19(CallRecordAndSummaryActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OSheet r2 = r0.feedbackSheet;
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }

    private static final void initFeedbackPanel$lambda$28$lambda$27$lambda$22(CallRecordAndSummaryActivity r0, View r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$this_apply");
        OEditText r3 = r0.feedbackEditText;
        if (r3 == null) goto L6;
        Object r4 = r1.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r4).hideSoftInputFromWindow(r3.getWindowToken(), 2);
        return;
    }

    private static final void initFeedbackPanel$lambda$28$lambda$27$lambda$24(CallRecordAndSummaryActivity r0, OCheckBox r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "<anonymous parameter 0>");
        r0.checkoutSubmit();
    }

    private static final void initFeedbackPanel$lambda$28$lambda$27$lambda$26(CallRecordAndSummaryActivity r12, View r13, View r14) {
        Intrinsics.checkNotNullParameter(r12, "this$0");
        Intrinsics.checkNotNullParameter(r13, "$this_apply");
        if (r12.checkoutSubmit() == true) goto L6;
        return;
    L6:
        if (NetworkUtils.isWifi(r13.getContext()) == true) goto L9;
        String r2 = r13.getResources().getString(R.string.feedback_network_error);
        Intrinsics.checkNotNullExpressionValue(r2, "resources.getString(R.st…g.feedback_network_error)");
        OToast.Companion.show$default(OToast.Companion, r12, r2, 0, 4, null);
        return;
    L9:
        OCheckBox r15 = r12.consentCheckbox;
        if (r15 != null) goto L12;
    L14:
        final boolean r16 = false;
    L15:
        OSheet r3 = r12.feedbackSheet;
        if (r3 == null) goto L19;
        r3.dismiss();
    L19:
        if (r12.isFeedbackLikeSelected == false) goto L21;
        EventTrackerManager.INSTANCE.track(new CallLogFeedbackEvent.CallLogFeedbackEventCancel());
    L21:
        r12.isFeedbackDislikeSelected = true;
        r12.isFeedbackLikeSelected = false;
        r12.updateFeedbackVoteState();
        String r6 = r13.getResources().getString(R.string.feedback_has_been_commited);
        Intrinsics.checkNotNullExpressionValue(r6, "resources.getString(R.st…edback_has_been_commited)");
        OToast.Companion.show$default(OToast.Companion, r12, r6, 0, 4, null);
        EventTrackerManager r17 = EventTrackerManager.INSTANCE;
        StringBuilder r0 = new StringBuilder();
        List<String> r4 = r12.getSelectedFeedbackTypes();
        if ((true ^ r4.isEmpty()) == false) goto L24;
        r0.append(CollectionsKt.joinToString$default(r4, ", ", null, null, 0, null, null, 62, null));
    L24:
        String r1 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        r17.track(new CallLogFeedbackEvent.CallLogFeedbackEventBad(r1));
        r12.executeSafely(new CallRecordAndSummaryActivity$initFeedbackPanel$2$1$5$2(r16));
        return;
    L12:
        if (r15.isChecked() != true) goto L14;
        r16 = true;
        goto L15
    }

    private final boolean shouldShowFeedbackBar() {
        CallFeatureModel r0 = CallFeatureModel.INSTANCE;
        long r1 = this.callCreateTime;
        String r3 = this.phoneNumber;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r3 = null;
    L5:
        CallFeatureBean r2 = r0.getCallFeature(r1, r3);
        if (r2 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L19;
        if (r2 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == true) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == true) goto L24;
        return false;
    L24:
        if (hasFeedback() == false) goto L26;
        return false;
    L26:
        return true;
    L14:
        if (r2.isOnlyUseIntelligentCall() != true) goto L16;
        r5 = true;
    L19:
        if ((!this.asrList.isEmpty()) == false) goto L21;
        r6 = true;
        goto L22
    L8:
        if (r2.isIntelligentCallEnabled() != true) goto L10;
        r4 = true;
        goto L11
    }

    private final void generateFileUri(File r4, Function1<? super Uri, Unit> r5) {
        Uri r6 = getUriForFile(r4);
        if (r6 != null) goto L13;
        Unit r7 = null;
    L10:
        if (r7 != null) goto L15;
        r5.invoke(null);
        return;
    L15:
        return;
    L13:
        grantUriPermission(FEEDBACK_PACKAGE_NAME, r6, 3);     // Catch: Exception -> L6
        r5.invoke(r6);     // Catch: Exception -> L6
    L8:
        r7 = Unit.INSTANCE;
    L6:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "grantUriPermission error: " + e);
        r5.invoke(null);
        goto L8
    }

    private final String collectFeedbackDesc() {
        StringBuilder r0 = new StringBuilder();
        List<String> r1 = getSelectedFeedbackTypes();
        OEditText r14 = this.feedbackEditText;
        if (r14 == null) goto L9;
        Editable r15 = r14.getText();
        if (r15 == null) goto L9;
        String r16 = r15.toString();
        if (r16 == null) goto L9;
        String r17 = StringsKt.trim(r16).toString();
    L10:
        List<String> r2 = r1;
        boolean r4 = true;
        if ((!r2.isEmpty()) == false) goto L14;
        r0.append(CollectionsKt.joinToString$default(r1, ", ", null, null, 0, null, null, 62, null));
    L14:
        if ((!r2.isEmpty()) == false) goto L24;
        String r3 = r17;
        if (r3 != null) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L24;
        r0.append("\n");
        goto L24
    L18:
        if (StringsKt.isBlank(r3) == true) goto L21;
        r5 = false;
    L24:
        String r6 = r17;
        if (r6 != null) goto L27;
    L30:
        if (r4 == true) goto L32;
        r0.append(r17);
    L32:
        String r18 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "toString(...)");
        return r18;
    L27:
        if (StringsKt.isBlank(r6) == true) goto L30;
        r4 = false;
    L9:
        r17 = null;
        goto L10
    }

    private final boolean checkoutSubmit() {
        OEditText r0 = this.feedbackEditText;
        if (r0 == null) goto L7;
        Editable r1 = r0.getText();
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        String r3 = r2;
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        boolean r5 = !r4;
        OEditText r6 = this.feedbackEditText;
        if (r6 == null) goto L20;
        Editable r7 = r6.getText();
        if (r7 == null) goto L20;
        int r8 = r7.length();
    L22:
        if (r8 > this.MAX_FEEDBACK_CHAR_COUNT) goto L24;
        boolean r9 = true;
    L25:
        List r10 = CollectionsKt.listOf(new OTextView[]{this.chipSlowResponse, this.chipPoorEffect, this.chipInaccurateASR, this.chipInaccurateSummary, this.chipOther});
        if ((r10 instanceof Collection) == true) goto L28;
    L30:
        Iterator r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L29;
        OTextView r12 = (OTextView) r11.next();
        if (r12 != null) goto L36;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == false) goto L32;
        boolean r14 = true;
    L41:
        OButton r15 = this.submitButton;
        if (r15 == null) goto L50;
        if (r5 == true) goto L46;
        if (r14 == true) goto L46;
    L48:
        boolean r16 = false;
    L49:
        r15.setEnabled(r16);
    L46:
        if (r9 == false) goto L48;
        r16 = true;
    L50:
        OButton r17 = this.submitButton;
        if (r17 == null) goto L56;
        if (r17.isEnabled() != true) goto L56;
        return true;
    L56:
        return false;
    L36:
        if (r12.isSelected() != true) goto L38;
        r13 = true;
    L29:
        r14 = false;
        goto L41
    L28:
        if (r10.isEmpty() == false) goto L30;
    L24:
        r9 = false;
    L20:
        r8 = 0;
        goto L22
    L11:
        if (StringsKt.isBlank(r3) == true) goto L14;
        r4 = false;
    L7:
        r2 = null;
        goto L8
    }

    private final void setupChips() {
        Iterator r0 = CollectionsKt.listOf(new OTextView[]{this.chipSlowResponse, this.chipPoorEffect, this.chipInaccurateASR, this.chipInaccurateSummary, this.chipOther}).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        final OTextView r1 = (OTextView) r0.next();
        if (r1 == null) goto L4;
        r1.setOnClickListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda20(this, r1));
        goto L4
    }

    private static final void setupChips$lambda$34$lambda$33(CallRecordAndSummaryActivity r0, OTextView r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.handleChipClick(r1);
    }

    private final void handleChipClick(View r3) {
        if (r3 != null) goto L5;
    L9:
        checkoutSubmit();
        return;
    L5:
        if (r3.isSelected() != true) goto L7;
        boolean r0 = true;
    L8:
        r3.setSelected(!r0);
        goto L9
    L7:
        r0 = false;
        goto L8
    }

    private final List<String> getSelectedFeedbackTypes() {
        List r4 = CollectionsKt.listOf(new OTextView[]{this.chipSlowResponse, this.chipPoorEffect, this.chipInaccurateASR, this.chipInaccurateSummary, this.chipOther});
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L17;
        OTextView r1 = (OTextView) r5.next();
        String r2 = null;
        if (r1 == null) goto L14;
        CharSequence r3 = r1.getText();
        if (r3 == null) goto L14;
        String r6 = r3.toString();
        if (r6 == null) goto L14;
        if (r1.isSelected() == false) goto L14;
        r2 = r6;
    L14:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L17:
        return r0;
    }

    private final File getFeedbackCacheDir() {
        File r0 = new File(getCacheDir(), "feedback");
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    private final Uri getUriForFile(File r2) {
        return FileProvider.getUriForFile(this, ContactPhotoUtils.FILE_PROVIDER_AUTHORITY, r2);
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to get uri for file", e);
        return null;
    }

    private final void registerFeedbackCopyFinishedReceiver() {
        IntentFilter r2 = new IntentFilter("com.obric.feedback.sdk.action.CUSTOM_FILE_COPY_FINISHED");
        ContextCompat.registerReceiver(this, this.feedbackCopyFinishedReceiver, r2, FeedbackSdkResultContract.ACTION_PERMISSION, null, 4);
    }

    private final void unregisterFeedbackCopyFinishedReceiver() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        CallRecordAndSummaryActivity r1 = this;     // Catch: Throwable -> L4
        unregisterReceiver(this.feedbackCopyFinishedReceiver);     // Catch: Throwable -> L4
        Object r2 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.m806exceptionOrNullimpl(r2);
        if (r3 == null) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "unregister feedbackCopyFinishedReceiver failed", r3);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void handleFeedbackTriggerResult(Bundle r7, List<? extends File> r8, List<? extends Uri> r9) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L7:
        long r1 = -1;
        if (r7 == null) goto L10;
        r1 = r7.getLong(EXTRA_RESULT_TASK_ID, -1);
    L10:
        if (r0 == true) goto L12;
    L21:
        cleanupSharedFeedbackSources(r8, r9);
        return;
    L12:
        if (r1 <= 0) goto L21;
        ConcurrentHashMap<Long, PendingFeedbackCleanup> r6 = this.pendingFeedbackCleanupMap;
        Long r10 = Long.valueOf(r1);
        HashSet r2 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r4 = r11.next();
        if (r2.add(((File) r4).getAbsolutePath()) == false) goto L15;
        r3.add(r4);
        goto L15
    L19:
        r6.put(r10, new PendingFeedbackCleanup(r3, CollectionsKt.distinct(r9)));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "cache pending feedback cleanup for taskId=" + r1);
        return;
    L5:
        if (r7.getBoolean("success") != true) goto L7;
        r0 = true;
        goto L7
    }

    private final void cleanupPendingFeedbackFiles(long r3) {
        PendingFeedbackCleanup r0 = this.pendingFeedbackCleanupMap.remove(Long.valueOf(r3));
        if (r0 != null) goto L5;
        return;
    L5:
        cleanupSharedFeedbackSources(r0.getFiles(), r0.getUris());
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "cleanup pending feedback files finished for taskId=" + r3);
    }

    private final void cleanupSharedFeedbackSources(List<? extends File> r5, List<? extends Uri> r6) {
        Iterator r7 = CollectionsKt.distinct(r6).iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        Uri r0 = (Uri) r7.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        CallRecordAndSummaryActivity r3 = this;     // Catch: Throwable -> L8
        revokeUriPermission(FEEDBACK_PACKAGE_NAME, r0, 3);     // Catch: Throwable -> L8
        Object r1 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.m810isSuccessimpl(r1) == false) goto L13;
        Unit r4 = (Unit) r1;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "revoke feedback uri permission success ");
    L13:
        Throwable r8 = Result.m806exceptionOrNullimpl(r1);
        if (r8 == null) goto L4;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "revoke feedback uri permission failed", r8);
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L11
    L16:
        HashSet r10 = new HashSet();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r5.iterator();
    L18:
        if (r12.hasNext() == false) goto L22;
        Object r13 = r12.next();
        if (r10.add(((File) r13).getAbsolutePath()) == false) goto L18;
        r11.add(r13);
        goto L18
    L22:
        Iterator r14 = r11.iterator();
    L24:
        if (r14.hasNext() == false) goto L39;
        File r15 = (File) r14.next();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L31
        CallRecordAndSummaryActivity r17 = this;     // Catch: Throwable -> L31
        if (r15.exists() == false) goto L29;
        r15.delete();     // Catch: Throwable -> L31
    L29:
        Object r18 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L34:
        if (Result.m810isSuccessimpl(r18) == false) goto L36;
        Unit r19 = (Unit) r18;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "delete feedback temp file success");
    L36:
        Throwable r20 = Result.m806exceptionOrNullimpl(r18);
        if (r20 == null) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "delete feedback temp file failed", r20);
    L31:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.os.ParcelFileDescriptor] */
    private final File prepareFeedbackRecordFile() {
        String r1 = this.recordFilePath;
        ?? r2 = 1;
        r2 = 1;
        ?? r3 = 0;
        if (r1 != null) goto L5;
    L7:
        r1 = null;
    L8:
        String r4 = r1;
        if (r4 == null) goto L70;
        if (StringsKt.isBlank(r4) == true) goto L70;
        r2 = 0;
    L70:
        if (r2 == 0) goto L74;
        showFeedbackSubmitFailedToast(R.string.feedback_record_file_invalid);
        return null;
    L74:
        Uri r5 = Uri.parse(r1);     // Catch: Throwable -> L52 Exception -> L54
        ParcelFileDescriptor r6 = getContentResolver().openFileDescriptor(r5, "r");     // Catch: Throwable -> L52 Exception -> L54
        String r7 = r5.getLastPathSegment();     // Catch: Exception -> L50 Throwable -> L60
        if (r7 == null) goto L22;
        String r8 = StringsKt.substringAfterLast(r7, LibrarianImpl.Constants.DOT, "");     // Catch: Exception -> L50 Throwable -> L60
    L23:
        if (r6 != null) goto L26;
        showFeedbackSubmitFailedToast(R.string.feedback_record_file_invalid);     // Catch: Exception -> L50 Throwable -> L60
        return null;
    L26:
        long r9 = r6.getStatSize();     // Catch: Exception -> L50 Throwable -> L60
        if (r9 > 0) goto L29;
    L47:
        showFeedbackSubmitFailedToast(R.string.feedback_record_file_invalid);     // Catch: Exception -> L50 Throwable -> L60
        r6.close();
        return null;
    L29:
        if (r9 > MAX_FEEDBACK_RECORD_FILE_SIZE) goto L47;
        File r10 = new File(getFeedbackCacheDir(), "feedback_record_" + this.callCreateTime + '.' + r8);     // Catch: Exception -> L50 Throwable -> L60
        FileInputStream r0 = new FileInputStream(r6.getFileDescriptor());     // Catch: Exception -> L50 Throwable -> L60
        FileInputStream r11 = r0;     // Catch: Throwable -> L42
        FileOutputStream r12 = new FileOutputStream(r10);     // Catch: Throwable -> L42
        ByteStreamsKt.copyTo$default(r11, r12, 0, 2, null);     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r0, null);     // Catch: Exception -> L50 Throwable -> L60
        r6.close();
        return r10;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Exception -> L50 Throwable -> L60
        throw th;     // Catch: Exception -> L50 Throwable -> L60
    L22:
        r8 = null;
    L50:
        e = e;
    L56:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to prepare feedback record file", e);     // Catch: Throwable -> L60
        showFeedbackSubmitFailedToast(R.string.feedback_record_file_invalid);     // Catch: Throwable -> L60
        if (r6 == null) goto L77;
        r6.close();
        return null;
    L77:
        return null;
    L54:
        e = e;
        r6 = null;
    L52:
        th = th;
    L62:
        if (r3 == 0) goto L64;
        r3.close();
    L64:
        throw th;
    L60:
        th = th;
        r3 = r2;
        goto L62
    L5:
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
        goto L7
    }

    private final File exportFeedbackTranscriptFile() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        CallRecordAndSummaryActivity r3 = this;     // Catch: Throwable -> L5
        File r4 = new File(getFeedbackCacheDir(), "feedback_transcript_" + this.callCreateTime + ".txt");     // Catch: Throwable -> L5
        FilesKt.writeText$default(r4, buildFeedbackTranscriptContent(), null, 2, null);     // Catch: Throwable -> L5
        Object r7 = Result.m803constructorimpl(r4);     // Catch: Throwable -> L5
    L8:
        if (Result.m806exceptionOrNullimpl(r7) != null) goto L11;
        r1 = r7;
    L11:
        return (File) r1;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final String buildFeedbackTranscriptContent() {
        StringBuilder r0 = new StringBuilder("Call Time: ");
        long r1 = this.callCreateTime;
        String r3 = getString(R.string.ymdhm_date_time_format);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.ymdhm_date_time_format)");
        r0.append(TimeUtilKt.formatTimestamp(r1, r3));
        r0.append("\nPhone Number: ");
        String r2 = this.phoneNumber;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r2 = null;
    L5:
        r0.append(r2);
        r0.append("\n\n");
        if (this.asrList.isEmpty() == false) goto L9;
        r0.append("No transcript available.\n");
        String r9 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "builder.toString()");
        return r9;
    L9:
        Iterator<T> r4 = this.asrList.iterator();
        int r5 = 0;
    L11:
        if (r4.hasNext() == false) goto L16;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        RecordASRMessageEntity r8 = (RecordASRMessageEntity) r6;
        r0.append(r7);
        r0.append(". ");
        r0.append(resolveFeedbackSpeakerName(r8));
        r0.append(" [");
        r0.append(TimeUtilKt.formatMillisecondsUsingDuration(toSafeDurationInt(r8.getStartTime())));
        r0.append(" / ");
        r0.append(TimeUtilKt.formatMillisecondsUsingDuration(toSafeDurationInt(r8.getDuration())));
        r0.append("]\n");
        r0.append(StringsKt.trim(r8.getAsrText()).toString());
        r0.append("\n\n");
        r5 = r7;
        goto L11
    L16:
        String r10 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "builder.toString()");
        return r10;
    }

    private final String resolveFeedbackSpeakerName(RecordASRMessageEntity r3) {
        if (r3.getOwner() != 2) goto L13;
        if (r3.isConference() == null) goto L13;
        Integer r0 = r3.isConference();
        if (r0 != null) goto L10;
    L11:
        String r2 = getString(R.string.common_conference_call);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.common_conference_call)");
        return r2;
    L10:
        if (r0.intValue() != 0) goto L11;
    L13:
        return getSpeakerName(this, r3.getOwner(), r3.getPhoneNumber());
    }

    private final int toSafeDurationInt(long r7) {
        return (int) RangesKt.coerceIn(r7, 0, 2147483647L);
    }

    private final void showFeedbackSubmitFailedToast(final int r8) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        String r3 = getString(r8);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(resId)");
        OToast.Companion.show$default(OToast.Companion, this, r3, 0, 4, null);
        return;
    L5:
        this.mHandler.post(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda23(this, r8));
    }

    private static final void showFeedbackSubmitFailedToast$lambda$56(CallRecordAndSummaryActivity r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        String r3 = r7.getString(r8);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(resId)");
        OToast.Companion.show$default(OToast.Companion, r7, r3, 0, 4, null);
    }

    private final void playRecord() {
        if (TimeUtilKt.formatDurationAndGetSeconds(getMediaPlayerCurrentPosition()) == TimeUtilKt.formatDurationAndGetSeconds(getMediaPlayerDuration())) goto L17;
    L8:
        MediaPlayer r0 = this.mediaPlayer;
        OIconButtonFloating r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r0 = null;
    L11:
        r0.start();
        updateSeekBar();
        updateListPosition(getMediaPlayerCurrentPosition());
        OIconButtonFloating r4 = this.playAndPauseButton;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("playAndPauseButton");
    L15:
        r1.setIcon(R.drawable.icon_pause);
        return;
    L14:
        r1 = r4;
        goto L15
    L17:
        playMediaPlayer(this.recordFilePath, true);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private final void pauseRecord() {
        MediaPlayer r0 = this.mediaPlayer;
        OIconButtonFloating r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r0 = null;
    L5:
        r0.pause();
        OIconButtonFloating r2 = this.playAndPauseButton;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("playAndPauseButton");
    L9:
        r1.setIcon(R.drawable.icon_play);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final int getMediaPlayerCurrentPosition() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        CallRecordAndSummaryActivity r2 = this;     // Catch: Throwable -> L14
        if (this.mediaPlayer != null) goto L6;
    L11:
        int r3 = 0;
    L12:
        Object r4 = Result.m803constructorimpl(Integer.valueOf(r3));     // Catch: Throwable -> L14
    L17:
        if (Result.m806exceptionOrNullimpl(r4) == null) goto L21;
        r4 = 0;
    L21:
        return ((Number) r4).intValue();
    L6:
        if (this.mediaPlayerReleased.get() == true) goto L11;
        MediaPlayer r5 = this.mediaPlayer;     // Catch: Throwable -> L14
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");     // Catch: Throwable -> L14
        r5 = null;
    L10:
        r3 = r5.getCurrentPosition();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final int getMediaPlayerDuration() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        CallRecordAndSummaryActivity r2 = this;     // Catch: Throwable -> L14
        if (this.mediaPlayer != null) goto L6;
    L11:
        int r3 = 0;
    L12:
        Object r4 = Result.m803constructorimpl(Integer.valueOf(r3));     // Catch: Throwable -> L14
    L17:
        if (Result.m806exceptionOrNullimpl(r4) == null) goto L21;
        r4 = 0;
    L21:
        return ((Number) r4).intValue();
    L6:
        if (this.mediaPlayerReleased.get() == true) goto L11;
        MediaPlayer r5 = this.mediaPlayer;     // Catch: Throwable -> L14
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");     // Catch: Throwable -> L14
        r5 = null;
    L10:
        r3 = r5.getDuration();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final void initializeMediaPlayer() {
        String r0 = this.recordFilePath;
        CallFeatureModel r1 = CallFeatureModel.INSTANCE;
        long r2 = this.callCreateTime;
        String r4 = this.phoneNumber;
        TextView r6 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r4 = null;
    L5:
        CallFeatureBean r3 = r1.getCallFeature(r2, r4);
        MediaPlayer r5 = this.mediaPlayer;
        if (r5 == null) goto L9;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L11:
        if (isMediaPlayerPlayingSafely(r5) == false) goto L18;
        MediaPlayer r7 = this.mediaPlayer;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r7 = null;
    L15:
        this.oldMediaPlayer = r7;
        if (r7 == null) goto L18;
        r7.seekTo(getMediaPlayerCurrentPosition());
    L18:
        this.mediaPlayer = new MediaPlayer();
        boolean r8 = true;
        if (this.showSummaryView == false) goto L29;
        if (r3 == null) goto L26;
        CallSummary r9 = r3.getSummary();
        if (r9 == null) goto L26;
        if (r9.isEmpty() == true) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L29;
        boolean r11 = true;
    L30:
        CallRecordAndSummaryActivity r12 = this;
        Long r13 = Long.valueOf(this.callCreateTime);
        String r14 = this.phoneNumber;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r14 = null;
    L34:
        if (ObriceRecordSummaryUtils.recordFileNotExists(r12, r13, r14) == false) goto L85;
        ViewGroup r15 = this.playerContainerView;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("playerContainerView");
        r15 = null;
    L38:
        r15.setVisibility(8);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L47
        if (isMediaPlayerPlayingSafely(r5) == false) goto L45;
        if (r5 == null) goto L43;
        r5.stop();     // Catch: Throwable -> L47
    L43:
        if (r5 == null) goto L45;
        r5.release();     // Catch: Throwable -> L47
    L45:
        Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L50:
        if (this.onlyShowCallSummaryView == true) goto L59;
        if (r11 == true) goto L59;
        if (this.asrListIsEmpty.get() == false) goto L59;
        RecyclerView r17 = this.recordListView;
        if (r17 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r17 = null;
    L58:
        r17.setVisibility(8);
    L63:
        CallFeatureModel r18 = CallFeatureModel.INSTANCE;
        long r19 = this.callCreateTime;
        String r20 = this.phoneNumber;
        if (r20 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r20 = null;
    L66:
        CallFeatureBean r21 = r18.getCallFeature(r19, r20);
        if (r21 != null) goto L69;
    L71:
        r8 = false;
    L73:
        if (r8 == false) goto L79;
        TextView r110 = this.errorTpsTextView;
        if (r110 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
    L78:
        r6.setVisibility(0);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "isFeatureCallRecordEnabled:true , but filePath does not exist " + r0);
        return;
    L77:
        r6 = r110;
        goto L78
    L79:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "isFeatureCallRecordEnabled:false, hide playerView");
        TextView r111 = this.errorTpsTextView;
        if (r111 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
    L83:
        r6.setVisibility(8);
        return;
    L82:
        r6 = r111;
        goto L83
    L69:
        if (r21.isFeatureCallRecordEnabled() != true) goto L71;
    L59:
        RecyclerView r22 = this.recordListView;
        if (r22 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r22 = null;
    L62:
        r22.setVisibility(0);
    L47:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L50
    L85:
        TextView r24 = this.errorTpsTextView;
        if (r24 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
        r24 = null;
    L88:
        r24.setVisibility(8);
        playMediaPlayer(r0, false);     // Catch: IOException -> L91
    L94:
        if (this.mediaPlayer != null) goto L122;
    L107:
        MediaPlayer r25 = this.mediaPlayer;
        if (r25 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r25 = null;
    L110:
        r25.setOnPreparedListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda0(this));
        MediaPlayer r26 = this.mediaPlayer;
        if (r26 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r26 = null;
    L113:
        r26.setOnSeekCompleteListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda11());
        MediaPlayer r27 = this.mediaPlayer;
        if (r27 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r27 = null;
    L116:
        r27.setOnCompletionListener(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda22(this));
        TextView r28 = this.endTimeTextView;
        if (r28 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("endTimeTextView");
    L120:
        r6.setText(TimeUtilKt.formatMillisecondsUsingDuration(getMediaPlayerDuration()));
        return;
    L119:
        r6 = r28;
        goto L120
    L122:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L105
        MediaPlayer r30 = this.oldMediaPlayer;     // Catch: Throwable -> L105
        if (r30 == null) goto L102;
        this.mediaPlayer = r30;     // Catch: Throwable -> L105
        if (r30 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");     // Catch: Throwable -> L105
        MediaPlayer r31 = null;
    L101:
        r31.seekTo(r30.getCurrentPosition());     // Catch: Throwable -> L105
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L105
    L103:
        Result.m803constructorimpl(r32);     // Catch: Throwable -> L105
        goto L107
    L100:
        r31 = r30;
        goto L101
    L102:
        r32 = null;
    L105:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.m803constructorimpl(ResultKt.createFailure(th));
    L91:
        e = move-exception;
        e.printStackTrace();
    L26:
        r10 = false;
    L29:
        r11 = false;
    L9:
        r5 = null;
        goto L11
    }

    private static final void initializeMediaPlayer$lambda$64(CallRecordAndSummaryActivity r2, MediaPlayer r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        OSlider r4 = r2.slider;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slider");
        r4 = null;
    L5:
        r4.setMaxValue(TimeUtilKt.formatDurationAndGetSeconds(r2.getMediaPlayerDuration()));
    }

    private static final void initializeMediaPlayer$lambda$66(CallRecordAndSummaryActivity r0, MediaPlayer r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OIconButtonFloating r2 = r0.playAndPauseButton;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("playAndPauseButton");
        r2 = null;
    L5:
        r2.setIcon(R.drawable.icon_play);
    }

    private final void updateSeekBar() {
        OSlider r0 = this.slider;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slider");
        r0 = null;
    L5:
        r0.removeCallbacks(this.updateSeekRunnable);
        updateSeekBar(getMediaPlayerDuration(), getMediaPlayerCurrentPosition());
    }

    private final void updateSeekBar(int r6, int r7) {
    L23:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        OSlider r2 = null;
        if (this.tracking == true) goto L9;
        OSlider r0 = this.slider;     // Catch: Exception -> L23
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("slider");     // Catch: Exception -> L23
        r0 = null;
    L8:
        r0.setProgress(TimeUtilKt.formatDurationAndGetSeconds(r7));     // Catch: Exception -> L23
    L9:
        TextView r1 = this.playTimeTextView;     // Catch: Exception -> L23
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("playTimeTextView");     // Catch: Exception -> L23
        r1 = null;
    L12:
        r1.setText(TimeUtilKt.formatMillisecondsUsingDuration(r7));     // Catch: Exception -> L23
        TextView r3 = this.endTimeTextView;     // Catch: Exception -> L23
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("endTimeTextView");     // Catch: Exception -> L23
        r3 = null;
    L15:
        r3.setText(TimeUtilKt.formatMillisecondsUsingDuration(r6 - r7));     // Catch: Exception -> L23
        if (isPlaying() == false) goto L28;
        OSlider r8 = this.slider;     // Catch: Exception -> L23
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("slider");     // Catch: Exception -> L23
    L21:
        r2.postDelayed(this.updateSeekRunnable, 200);     // Catch: Exception -> L23
        return;
    L20:
        r2 = r8;
        goto L21
    }

    private final boolean isMediaPlayerPlayingSafely(MediaPlayer r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        CallRecordAndSummaryActivity r2 = this;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        boolean r4 = r3.isPlaying();     // Catch: Throwable -> L11
        boolean r5 = true;
        if (r4 != true) goto L8;
    L9:
        Object r6 = Result.m803constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L11
    L14:
        if (Result.m809isFailureimpl(r6) == false) goto L17;
        r6 = false;
    L17:
        return ((Boolean) r6).booleanValue();
    L8:
        r5 = false;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final boolean isPlaying() {
        if (this.mediaPlayerReleased.get() == true) goto L11;
        MediaPlayer r0 = this.mediaPlayer;
        if (r0 == null) goto L11;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r0 = null;
    L9:
        if (isMediaPlayerPlayingSafely(r0) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public void com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onDestroy$___twin___() {
        super.onDestroy();
        unregisterFeedbackCopyFinishedReceiver();
        this.mHandler.removeCallbacks(this.updatePositionRunnable);
        this.audioFocusManager.releaseAudioFocus();
        if (this.mediaPlayer == null) goto L8;
        this.mediaPlayerReleased.set(true);
        MediaPlayer r0 = this.mediaPlayer;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r0 = null;
    L7:
        r0.release();
    L8:
        MediaPlayer r1 = this.oldMediaPlayer;
        if (r1 == null) goto L11;
        r1.release();
    L11:
        ObricCallRecordSummaryDeleteObserver.removeRecordChangeListener(this.recordSummaryChangeListener);
        AISummary.INSTANCE.unregisterDownloadStatusListener(this);
    }

    @Override // com.android.contacts.calllog.record.RecordSentenceAdapter.RecordSentenceClickListener
    public void onItemClicked(int r3) {
        this.isScroll.set(false);
        this.isUserScrolling = false;
        MediaPlayer r0 = this.mediaPlayer;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        r0 = null;
    L5:
        r0.seekTo(r3);
        updateSeekBar(getMediaPlayerDuration(), r3);
        updateListPosition(r3);
    }

    public final void updateListPosition(int r10) {
        RecordSentenceAdapter r0 = this.adapter;
        RecyclerView r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L6:
        if (r0.getAsrItems().isEmpty() == false) goto L8;
        return;
    L8:
        RecordSentenceAdapter r1 = this.adapter;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L11:
        int r3 = r1.getAsrItems().size() - 1;
        int r4 = 0;
    L13:
        if (r4 > r3) goto L21;
        int r6 = (r4 + r3) / 2;
        RecordSentenceAdapter r5 = this.adapter;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r5 = null;
    L18:
        if (((int) r5.getAsrItems().get(r6).getStartTime()) <= r10) goto L19;
        r3 = r6 - 1;
        goto L13
    L19:
        r4 = r6 + 1;
    L21:
        int r11 = r3 - 1;
        if (r11 < 0) goto L43;
        RecordSentenceAdapter r7 = this.adapter;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r7 = null;
    L27:
        if (r3 >= r7.getAsrItems().size()) goto L43;
        RecordSentenceAdapter r8 = this.adapter;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r8 = null;
    L31:
        int r9 = (int) r8.getAsrItems().get(r3).getStartTime();
        RecordSentenceAdapter r12 = this.adapter;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r12 = null;
    L35:
        if (r9 != ((int) r12.getAsrItems().get(r11).getStartTime())) goto L43;
        StringBuilder r13 = new StringBuilder("updateListPosition: same start time, move to left index: ").append(r3).append(", ");
        RecordSentenceAdapter r14 = this.adapter;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r14 = null;
    L39:
        StringBuilder r15 = r13.append(r14.getAsrItems().get(r3).getStartTime()).append(' ');
        RecordSentenceAdapter r16 = this.adapter;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r16 = null;
    L42:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, r15.append(r16.getAsrItems().get(r3).getAsrText()).toString());
        r3 = r3 - 1;
    L43:
        RecordSentenceAdapter r17 = this.adapter;
        if (r17 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r17 = null;
    L46:
        Integer r18 = r17.getHighlightPosition();
        if (r18 != null) goto L50;
    L51:
        RecordSentenceAdapter r19 = this.adapter;
        if (r19 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r19 = null;
    L54:
        scrollToPosition$default(this, r19.getContentStartOffset() + r3, 0, 2, null);
        RecordSentenceAdapter r110 = this.adapter;
        if (r110 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r110 = null;
    L57:
        r110.setHighlightPosition(Integer.valueOf(r3));
        RecordSentenceAdapter r111 = this.adapter;
        if (r111 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r111 = null;
    L60:
        this.position = r3 + r111.getContentStartOffset();
    L62:
        if (isPlaying() == false) goto L83;
        RecyclerView r112 = this.recordListView;
        if (r112 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r112 = null;
    L66:
        r112.removeCallbacks(this.updatePositionRunnable);
        RecyclerView r113 = this.recordListView;
        if (r113 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L70:
        r2.postDelayed(this.updatePositionRunnable, 100);
        return;
    L69:
        r2 = r113;
        goto L70
    L83:
        return;
    L50:
        if (r18.intValue() == r3) goto L62;
        goto L51
    }

    static /* synthetic */ void scrollToPosition$default(CallRecordAndSummaryActivity r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r0.mergeTopOffsetDp;
    L5:
        r0.scrollToPosition(r1, r2);
    }

    private final void scrollToPosition(final int r3, final int r4) {
        RecyclerView r0 = this.recordListView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r0 = null;
    L5:
        r0.post(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda21(this, r3, r4));
    }

    private static final void scrollToPosition$lambda$68(CallRecordAndSummaryActivity r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        RecyclerView r1 = null;
        if (r3.isScroll.get() == false) goto L9;
        RecyclerView r6 = r3.recordListView;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L8:
        r1.smoothScrollToPosition(r4);
        r3.mHandler.removeCallbacks(r3.scrollRunnable);
        r3.mHandler.postDelayed(r3.scrollRunnable, r3.scrollerDefaultDurationMs);
        return;
    L7:
        r1 = r6;
        goto L8
    L9:
        RecyclerView r7 = r3.recordListView;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L13:
        RecyclerView.LayoutManager r8 = r1.getLayoutManager();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) r8).scrollToPositionWithOffset(r4, r5);
        return;
    L12:
        r1 = r7;
        goto L13
    }

    private static final void updatePositionRunnable$lambda$69(CallRecordAndSummaryActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isPlaying() == false) goto L6;
        r1.updateListPosition(r1.getMediaPlayerCurrentPosition());
        return;
    }

    private static final void updateRecordDataRunnable$lambda$70(CallRecordAndSummaryActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        RecordSentenceAdapter r2 = null;
        queryASREntity$default(r3, false, 1, null);
        r3.updateRecordSummaryWorkingStatus();
        r3.initializeMediaPlayer();
        RecyclerView r0 = r3.recordListView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r0 = null;
    L5:
        RecordSentenceAdapter r1 = r3.adapter;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r0.setAdapter(r2);
        r3.updateErrTpsTextViewHeight();
        r3.initRightTitleBtn();
        r3.updateFeedbackVisibility();
        return;
    L8:
        r2 = r1;
        goto L9
    }

    public void com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onResume$___twin___() {
        super.onResume();
        this.isActivityResumed = true;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "CallRecordAndSummaryActivity#onResume");
        CallFeatureModel.INSTANCE.addCallFeatureModelListener(this.summaryListener);
        this.mHandler.removeCallbacks(this.updateRecordDataRunnable);
        this.mHandler.post(this.updateRecordDataRunnable);
        NotificationHelper r0 = NotificationHelper.INSTANCE;
        CallRecordAndSummaryActivity r1 = this;
        long r2 = this.callCreateTime;
        String r4 = this.phoneNumber;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r4 = null;
    L5:
        r0.cancelRecordNotification(r1, r2, r4);
        EventTrackerManager r3 = EventTrackerManager.INSTANCE;
        String r13 = this.enter_from;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("enter_from");
        String r7 = null;
    L9:
        r3.track(new ContactPageShowEvent(r7, TAG, null, null, 12, null));
        return;
    L8:
        r7 = r13;
        goto L9
    }

    public void com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onPause$___twin___() {
        super.onPause();
        this.isActivityResumed = false;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "CallRecordAndSummaryActivity#onPause");
        CallFeatureModel.INSTANCE.removeCallFeatureModelListener(this.summaryListener);
        RecyclerView r0 = this.recordListView;
        OIconButtonFloating r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r0 = null;
    L5:
        r0.removeCallbacks(this.updatePositionRunnable);
        OSlider r2 = this.slider;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("slider");
        r2 = null;
    L8:
        r2.removeCallbacks(this.updateSeekRunnable);
        if (isPlaying() == true) goto L31;
    L29:
        dialogDismiss();
        return;
    L31:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L26
        MediaPlayer r4 = this.mediaPlayer;     // Catch: Throwable -> L26
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");     // Catch: Throwable -> L26
        r4 = null;
    L14:
        r4.pause();     // Catch: Throwable -> L26
        MediaPlayer r5 = this.mediaPlayer;     // Catch: Throwable -> L26
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");     // Catch: Throwable -> L26
        r5 = null;
    L17:
        this.oldMediaPlayer = r5;     // Catch: Throwable -> L26
        if (r5 == null) goto L20;
        r5.seekTo(getMediaPlayerCurrentPosition());     // Catch: Throwable -> L26
    L20:
        OIconButtonFloating r6 = this.playAndPauseButton;     // Catch: Throwable -> L26
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("playAndPauseButton");     // Catch: Throwable -> L26
    L24:
        r1.setIcon(R.drawable.icon_play);     // Catch: Throwable -> L26
        Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        this.audioFocusManager.releaseAudioFocus();
        goto L29
    L23:
        r1 = r6;
    L26:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    private final void updateErrTpsTextViewHeight() {
        TextView r0 = this.errorTpsTextView;
        RecyclerView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
        r0 = null;
    L6:
        if (r0.getVisibility() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        RecyclerView r3 = this.recordListView;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L15:
        r1.post(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda25(this));
        return;
    L14:
        r1 = r3;
        goto L15
    L8:
        r2 = false;
        goto L9
    }

    private static final void updateErrTpsTextViewHeight$lambda$74(final CallRecordAndSummaryActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        ViewGroup r0 = r3.listAndErrView;
        RecyclerView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listAndErrView");
        r0 = null;
    L5:
        r0.post(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda24(r3));
        RecyclerView r2 = r3.recordListView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r2 = null;
    L8:
        r2.requestLayout();
        RecyclerView r4 = r3.recordListView;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L12:
        r1.setVisibility(0);
        return;
    L11:
        r1 = r4;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void updateErrTpsTextViewHeight$lambda$74$lambda$73(final CallRecordAndSummaryActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        CallFeatureModel r0 = CallFeatureModel.INSTANCE;
        long r1 = r7.callCreateTime;
        String r3 = r7.phoneNumber;
        RecyclerView r4 = null;
        RecyclerView r5 = null;
        ViewGroup r6 = null;
        ViewGroup r8 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r3 = null;
    L5:
        CallFeatureBean r2 = r0.getCallFeature(r1, r3);
        boolean r9 = false;
        if (r7.showSummaryView == false) goto L16;
        if (r2 != null) goto L10;
    L12:
        Object[] r10 = false;
    L13:
        if (r10 == false) goto L16;
        r9 = true;
        goto L16
    L10:
        if (r2.isFeatureCallSummaryEnabled() != true) goto L12;
        r10 = true;
    L16:
        if (r9 == false) goto L24;
        if (r7.listener != null) goto L24;
        r7.listener = new CallRecordAndSummaryActivity$$ExternalSyntheticLambda26(r7);
        RecyclerView r11 = r7.recordListView;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r11 = null;
    L22:
        r11.addOnLayoutChangeListener(r7.listener);
    L24:
        if (r7.asrListIsEmpty.get() == true) goto L26;
    L70:
        TextView r12 = r7.errorTpsTextView;
        if (r12 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
        r12 = null;
    L73:
        r12.setHeight((int) r7.getResources().getDimension(R.dimen.o_record_summary_error_tips));
        RecyclerView r13 = r7.recordListView;
        if (r13 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r13 = null;
    L76:
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        r14.height = -1;
        RecyclerView r15 = r7.recordListView;
        if (r15 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L80:
        r4.setLayoutParams(r14);
        return;
    L79:
        r4 = r15;
        goto L80
    L26:
        if (r7.isAsrWorking() == true) goto L28;
    L29:
        RecyclerView r16 = r7.recordListView;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r16 = null;
    L32:
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        r17.height = -2;
        RecyclerView r18 = r7.recordListView;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r18 = null;
    L35:
        r18.setLayoutParams(r17);
        if (r9 == true) goto L38;
    L50:
        if (r9 == false) goto L62;
        RecordSentenceAdapter r19 = r7.adapter;
        if (r19 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r19 = null;
    L54:
        int r20 = r19.getVisibleTopSectionHeight() + ContactsUtils.dipTopx(r7, 10.0d);
        TextView r21 = r7.errorTpsTextView;
        if (r21 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
        r21 = null;
    L57:
        ViewGroup r22 = r7.listAndErrView;
        if (r22 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("listAndErrView");
    L61:
        r21.setHeight(r6.getMeasuredHeight() - r20);
        return;
    L60:
        r6 = r22;
        goto L61
    L62:
        TextView r23 = r7.errorTpsTextView;
        if (r23 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
        r23 = null;
    L65:
        ViewGroup r24 = r7.listAndErrView;
        if (r24 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("listAndErrView");
    L69:
        r23.setHeight(r8.getMeasuredHeight());
        return;
    L68:
        r8 = r24;
        goto L69
    L38:
        if (r7.isAsrFail() == true) goto L50;
        TextView r25 = r7.errorTpsTextView;
        if (r25 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
        r25 = null;
    L42:
        ViewGroup r26 = r7.listAndErrView;
        if (r26 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("listAndErrView");
        r26 = null;
    L45:
        int r27 = r26.getMeasuredHeight();
        RecyclerView r28 = r7.recordListView;
        if (r28 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L49:
        r25.setHeight(r27 - r5.getMeasuredHeight());
        return;
    L48:
        r5 = r28;
        goto L49
    L28:
        if (r7.isAsrFail() == false) goto L70;
        goto L29
    }

    private static final void updateErrTpsTextViewHeight$lambda$74$lambda$73$lambda$72(CallRecordAndSummaryActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if ((r5 - r3) == (r9 - r7)) goto L6;
        r0.updateErrTpsTextViewHeight();
        return;
    }

    @Override // com.android.contacts.calllog.record.RecordSentenceAdapter.RecordSentenceClickListener
    public void updateListViewHeight(int r8) {
        StringBuilder r0 = new StringBuilder("updateListViewHeight listview height = ");
        RecyclerView r1 = this.recordListView;
        RecyclerView r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r1 = null;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r0.append(r1.getHeight()).append(" , item height = ").append(r8).toString());
        RecyclerView r2 = this.recordListView;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r2 = null;
    L9:
        if (r2.getHeight() >= r8) goto L25;
        TextView r4 = this.errorTpsTextView;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("errorTpsTextView");
        r4 = null;
    L13:
        ViewGroup r5 = this.listAndErrView;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("listAndErrView");
        r5 = null;
    L16:
        r4.setHeight(r5.getMeasuredHeight() - (r8 + ContactsUtils.dipTopx(this, 10.0d)));
        RecyclerView r9 = this.recordListView;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
        r9 = null;
    L19:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        r10.height = -2;
        RecyclerView r7 = this.recordListView;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recordListView");
    L23:
        r3.setLayoutParams(r10);
        return;
    L22:
        r3 = r7;
        goto L23
    }

    @Override // com.android.contacts.calllog.record.RecordSentenceAdapter.RecordSentenceClickListener
    public void updateAsrErrorViewHeight(int r1) {
        this.statusBarHeight = r1;
    }

    @Override // com.android.contacts.calllog.record.RecordSentenceAdapter.RecordSentenceClickListener
    public void startLocalSummaryDownload() {
        AISummary.INSTANCE.registerDownloadStatusListener(this);
        AISummary.INSTANCE.startModelDownloadCheck();
    }

    private final void updateRecordSummaryWorkingStatus() {
        CallFeatureModel r0 = CallFeatureModel.INSTANCE;
        long r1 = this.callCreateTime;
        String r3 = this.phoneNumber;
        String r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r3 = null;
    L5:
        CallFeatureBean r2 = r0.getCallFeature(r1, r3);
        if (r2 != null) goto L8;
        return;
    L8:
        AtomicBoolean r5 = this.callSummaryWorking;
        boolean r6 = true;
        if (r2.isCallSummaryAvailable() == true) goto L17;
        Set<Pair<Long, String>> r7 = CallFeatureModel.INSTANCE.getSummarizingDataSet();
        Long r8 = Long.valueOf(this.callCreateTime);
        String r9 = this.phoneNumber;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
    L15:
        if (r7.contains(new Pair(r8, r4)) == false) goto L17;
        boolean r10 = true;
    L18:
        r5.set(r10);
        AtomicBoolean r11 = this.recordAsrWorking;
        if (r2.isFeatureCallRecordEnabled() == true) goto L21;
    L25:
        boolean r12 = false;
    L26:
        r11.set(r12);
        AtomicBoolean r13 = this.isEmpty;
        if (r2.isFeatureCallRecordEnabled() == false) goto L29;
    L31:
        r6 = false;
    L32:
        r13.set(r6);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updateRecordSummaryWorkingStatus callSummaryWorking = [" + this.callSummaryWorking.get() + "] , recordAsrWorking = [" + this.recordAsrWorking.get() + DefaultContactListAdapter.SNIPPET_END_MATCH);
        return;
    L29:
        if (r2.isCallSummaryAvailable() == true) goto L31;
    L21:
        if (r2.isRecordASRAvailable() == true) goto L25;
        if (r2.isRecordASRWorking() == false) goto L25;
        r12 = true;
        goto L26
    L13:
        r4 = r9;
    L17:
        r10 = false;
        goto L18
    }

    private final boolean isAsrWorking() {
        CallFeatureModel r0 = CallFeatureModel.INSTANCE;
        long r1 = this.callCreateTime;
        String r4 = this.phoneNumber;
        Boolean r3 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r4 = null;
    L5:
        CallFeatureBean r5 = r0.getCallFeature(r1, r4);
        if (r5 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r5.isRecordASRAvailable());
    L9:
        if (r5 == null) goto L11;
        Boolean r6 = Boolean.valueOf(r5.isRecordASRWorking());
    L12:
        if (r5 == null) goto L15;
        r3 = Boolean.valueOf(r5.isFeatureCallRecordEnabled());
    L15:
        if (Intrinsics.areEqual(r3, true) == false) goto L22;
        if (Intrinsics.areEqual(r2, false) == false) goto L22;
        if (Intrinsics.areEqual(r6, true) == false) goto L22;
        return true;
    L22:
        return false;
    L11:
        r6 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    private final boolean isAsrFail() {
        CallFeatureModel r0 = CallFeatureModel.INSTANCE;
        long r1 = this.callCreateTime;
        String r4 = this.phoneNumber;
        Boolean r3 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r4 = null;
    L5:
        CallFeatureBean r5 = r0.getCallFeature(r1, r4);
        if (r5 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r5.isRecordASRAvailable());
    L9:
        if (r5 == null) goto L11;
        Boolean r6 = Boolean.valueOf(r5.isRecordASRWorking());
    L12:
        if (r5 == null) goto L15;
        r3 = Boolean.valueOf(r5.isFeatureCallRecordEnabled());
    L15:
        if (Intrinsics.areEqual(r3, true) == false) goto L22;
        if (Intrinsics.areEqual(r2, false) == false) goto L22;
        if (Intrinsics.areEqual(r6, false) == false) goto L22;
        return true;
    L22:
        return false;
    L11:
        r6 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    private final void dialogDismiss() {
        OPopover r0 = this.oPopover;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L12;
        OPopover r3 = this.oPopover;
        if (r3 == null) goto L12;
        r3.dismiss();
    L12:
        OAlertDialog r4 = this.deleteDialog;
        if (r4 != null) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == false) goto L23;
        OAlertDialog r5 = this.deleteDialog;
        if (r5 == null) goto L24;
        r5.dismiss();
        return;
    L24:
        return;
    L23:
        return;
    L15:
        if (r4.isShowing() != true) goto L17;
    L5:
        if (r0.isShowing() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.obric.callsummary.model.aikernel.AISummary.DownloadStatusListener
    public void onDownloadStatus(int r2) {
        if (r2 != AISummary.INSTANCE.getDOWNLOAD_STATUS_DOWNLOADED()) goto L6;
        this.mHandler.removeCallbacks(this.updateRecordDataRunnable);
        this.mHandler.post(this.updateRecordDataRunnable);
        return;
    }

    private final boolean canScrollVisible(RecyclerView r3) {
        int r4 = getVisibleItemCount(r3);
        int r2 = getAdapterCounts();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "canScrollVisible visibleItemCount = " + r4 + ", adapterCount = " + r2);
        if (r4 >= r2) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getVisibleItemCount(RecyclerView r1) {
        RecyclerView.LayoutManager r0 = r1.getLayoutManager();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
        LinearLayoutManager r2 = (LinearLayoutManager) r0;
        int r3 = r2.findFirstVisibleItemPosition();
        return (r2.findLastVisibleItemPosition() - r3) + 1;
    }

    private final int getAdapterCounts() {
        RecordSentenceAdapter r0 = this.adapter;
        RecordSentenceAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        int r2 = r0.getItemCount();
        RecordSentenceAdapter r3 = this.adapter;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r3 = null;
    L9:
        if (r3.isFeedbackVisible() == true) goto L11;
        r2 = r2 - 1;
    L11:
        RecordSentenceAdapter r4 = this.adapter;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L14:
        RecordSentenceAdapter.HeaderHolder r5 = r4.getHeaderHolder();
        boolean r6 = true;
        if (r5 == null) goto L21;
        ViewGroup r7 = r5.getCallSummaryContainer();
        if (r7 == null) goto L21;
        if (ViewExtensionsKt.isVisibile(r7) == true) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
        r2 = r2 - 1;
    L24:
        RecordSentenceAdapter r9 = this.adapter;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L28:
        RecordSentenceAdapter.StatusHolder r10 = r1.getStatuesHolder();
        if (r10 == null) goto L35;
        View r11 = r10.itemView;
        if (r11 == null) goto L35;
        if (ViewExtensionsKt.isVisibile(r11) == true) goto L35;
    L36:
        if (r6 == false) goto L38;
        r2 = r2 - 1;
    L38:
        if (r2 >= 0) goto L41;
        return 0;
    L41:
        return r2;
    L35:
        r6 = false;
        goto L36
    L27:
        r1 = r9;
    L21:
        r8 = false;
        goto L22
    }

    private final ArrayList<MenuItemData> buildPopoverMenuItems(final CallFeatureBean r46, boolean r47, boolean r48, String r49, final Integer r50, final Integer r51) {
        CallRecordAndSummaryActivity r0 = this;
        Long r1 = Long.valueOf(this.callCreateTime);
        String r3 = this.phoneNumber;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
        r3 = null;
    L5:
        boolean r2 = !ObriceRecordSummaryUtils.recordFileNotExists(r0, r1, r3);
        if (r47 == true) goto L9;
        if (r48 == true) goto L9;
    L19:
        final boolean r4 = false;
    L21:
        if (this.callSummaryWorking.get() == true) goto L26;
        if (r48 == false) goto L26;
        if (this.asrList.isEmpty() == true) goto L26;
        boolean r15 = true;
    L28:
        if (this.recordAsrWorking.get() == true) goto L33;
        if (r47 == false) goto L33;
        if (this.asrList.isEmpty() == true) goto L33;
        boolean r14 = true;
    L35:
        if (this.callSummaryWorking.get() == false) goto L37;
    L39:
        boolean r30 = false;
    L40:
        ArrayList<MenuItemData> r5 = new ArrayList();
        final boolean r31 = r14;
        final boolean r32 = r15;
        r5.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_refresh_summary), null, null, r49, null, null, null, null, new CallRecordAndSummaryActivity$buildPopoverMenuItems$1$1(r4, this), r4, 492, null));
        r5.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_copy_summary), null, null, getString(R.string.copy_summary), null, null, null, null, new CallRecordAndSummaryActivity$buildPopoverMenuItems$1$2(r32, this, r46), r32, 492, null));
        r5.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_copy_number), null, null, getString(R.string.copy_transcript), null, null, null, null, new CallRecordAndSummaryActivity$buildPopoverMenuItems$1$3(r31, this), r31, 492, null));
        r5.add(new MenuItemData(ItemType.DIVIDER, null, null, null, null, null, null, null, null, null, false, 2046, null));
        if (r2 == false) goto L43;
        r5.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_share), null, null, getString(R.string.menu_share), null, null, null, null, new CallRecordAndSummaryActivity$buildPopoverMenuItems$1$4(this), false, 1516, null));
    L43:
        if (r50 == null) goto L47;
        if (r51 == null) goto L47;
        final boolean r6 = r30;
        r5.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_delete), null, null, getString(r50.intValue()), null, null, true, null, new CallRecordAndSummaryActivity$buildPopoverMenuItems$1$5(r6, this, r50, r51, r46), r30, 364, null));
        return r5;
    L47:
        return r5;
    L37:
        if (this.recordAsrWorking.get() == true) goto L39;
        r30 = true;
    L33:
        r14 = false;
    L26:
        r15 = false;
    L9:
        if (this.callSummaryWorking.get() == true) goto L19;
        if (r46 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L19;
        if (this.asrList.isEmpty() == true) goto L19;
        r4 = true;
        goto L21
    L12:
        if (r46.isFeatureCallRecordEnabled() != true) goto L14;
        r7 = true;
        goto L15
    }

    private final String getSpeakerName(Context r2, int r3, String r4) {
        if (r3 != 1) goto L5;
        String r5 = r2.getString(R.string.common_i);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.common_i)");
        return r5;
    L5:
        if (r3 != 2) goto L7;
        if (r4 != null) goto L18;
        String r6 = this.callUserName;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("callUserName");
        return null;
    L19:
        return r6;
    L18:
        return r4;
    L7:
        if (r3 == 3) goto L9;
        return "";
    L9:
        String r7 = r2.getString(R.string.call_speaker_self_ai);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.call_speaker_self_ai)");
        return r7;
    }

    static /* synthetic */ void copyToClipboard$default(CallRecordAndSummaryActivity r0, Context r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = "call_content";
    L5:
        r0.copyToClipboard(r1, r2, r3);
    }

    private final void copyToClipboard(Context r2, String r3, String r4) {
        Object r1 = r2.getSystemService("clipboard");
        if ((r1 instanceof ClipboardManager) == false) goto L5;
        ClipboardManager r5 = (ClipboardManager) r1;
    L6:
        if (r5 == null) goto L8;
        r5.setPrimaryClip(ClipData.newPlainText(r4, r3));
    L8:
        Toast.makeText(r2, R.string.copy_success, 0).show();
        return;
    L5:
        r5 = null;
        goto L6
    }

    static /* synthetic */ void refreshCallSummary$default(CallRecordAndSummaryActivity r0, long r1, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r0.refreshCallSummary(r1, r3, r4);
    }

    private final void refreshCallSummary(final long r2, final String r4, boolean r5) {
        if (shouldBlockSummaryRefreshForNoNetwork(r5) == false) goto L5;
        return;
    L5:
        GlobalUtils.INSTANCE.execute(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda16(this, r2, r4));
        RecordSentenceAdapter r1 = this.adapter;
        if (r1 == null) goto L11;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L9:
        r1.notifySummaryStatusChanged();
        return;
    }

    private static final void refreshCallSummary$lambda$76(CallRecordAndSummaryActivity r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$phoneNumber");
        r1.notifyStartCallSummaryTask(r2, r4);
    }

    private final boolean shouldBlockSummaryRefreshForNoNetwork(boolean r10) {
        CallRecordAndSummaryActivity r1 = this;
        if (AISummary.INSTANCE.isOnlineModel(r1) == true) goto L6;
        return false;
    L6:
        if (ContactsUtils.isNetworkConnected(r1) == false) goto L8;
        return false;
    L8:
        if (r10 == false) goto L12;
        String r5 = getString(R.string.intelligent_sound_network_err);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.intelligent_sound_network_err)");
        OToast.Companion.show$default(OToast.Companion, this, r5, 0, 4, null);
        return true;
    L12:
        return true;
    }

    private final void notifyStartCallSummaryTask(long r4, String r6) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "notifyStartCallSummaryTask start callCreateTime:" + r4);
        if (r6 != null) goto L5;
        return;
    L5:
        CallFeatureModel.INSTANCE.callSummaryStarted(new Pair(Long.valueOf(r4), r6));
        CallFeatureModel.INSTANCE.callSummaryFinished(new Pair(Long.valueOf(r4), r6), CallSummaryGenerateManager.INSTANCE.retryCallSummary(this, r4, r6));
    }

    private final void playMediaPlayer(String r4, final boolean r5) {
        ObriceRecordSummaryUtils.INSTANCE.getRecordFile(this, r4, new C01681(this, r5));
    }

    private final void shareRecordFile(final long r3, final String r5) {
        GlobalUtils.INSTANCE.execute(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda19(this, r3, r5));
    }

    private static final void shareRecordFile$lambda$80(final CallRecordAndSummaryActivity r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$phoneNumber");
        RecordInfoEntity r4 = (RecordInfoEntity) CollectionsKt.firstOrNull(ObricCallLogProviderHelper.INSTANCE.getRecordInfoEntity(r2, r3, r5));     // Catch: Exception -> L11
        if (r4 == null) goto L10;
        final String r6 = r4.getPath();     // Catch: Exception -> L11
        if (r6 == null) goto L16;
        r2.runOnUiThread(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda7(r6, r2));     // Catch: Exception -> L11
        return;
    L16:
        return;
    L10:
        return;
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "File transfer failed", e);
        r2.runOnUiThread(new CallRecordAndSummaryActivity$$ExternalSyntheticLambda8(r2));
    }

    private static final void shareRecordFile$lambda$80$lambda$78(String r2, CallRecordAndSummaryActivity r3) {
        Intrinsics.checkNotNullParameter(r2, "$originalPathUri");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Uri r4 = Uri.parse(r2);
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.SEND");
        r0.setType("audio/*");
        r0.putExtra("android.intent.extra.STREAM", r4);
        r0.addFlags(1);
        r3.startActivity(Intent.createChooser(r0, r3.getString(R.string.share_record)));
    }

    private static final void shareRecordFile$lambda$80$lambda$79(CallRecordAndSummaryActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Toast.makeText(r2, R.string.share_record_fail, 0).show();
    }

    public void com_android_contacts_calllog_record_CallRecordAndSummaryActivity__finish$___twin___() {
        if (this.isFeedbackDislikeSelected == false) goto L5;
    L6:
        saveFeedback();
    L7:
        super.finish();
        return;
    L5:
        if (this.isFeedbackLikeSelected == false) goto L7;
        goto L6
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onCreate(CallRecordAndSummaryActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallRecordAndSummaryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CallRecordAndSummaryActivity r1) {
        com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onResume(CallRecordAndSummaryActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallRecordAndSummaryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onPause(CallRecordAndSummaryActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallRecordAndSummaryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onStop(CallRecordAndSummaryActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallRecordAndSummaryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_onDestroy(CallRecordAndSummaryActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallRecordAndSummaryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_calllog_record_CallRecordAndSummaryActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_calllog_record_CallRecordAndSummaryActivity_com_obric_privacyhook_PrivacyHook_finish(CallRecordAndSummaryActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallRecordAndSummaryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_calllog_record_CallRecordAndSummaryActivity__finish$___twin___();
    }
}
