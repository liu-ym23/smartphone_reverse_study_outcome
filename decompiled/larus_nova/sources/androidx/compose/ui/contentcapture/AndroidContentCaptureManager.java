package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0083\u0001\u0084\u0001\u0085\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020#2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010B\u001a\u00020#H\u0080@¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020#H\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020#H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020#H\u0002J\u0018\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u000202H\u0002J\u0016\u0010N\u001a\u00020#2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0018\u0010P\u001a\u00020#2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020#H\u0002J\b\u0010V\u001a\u00020#H\u0002J\u0016\u0010W\u001a\u0004\u0018\u00010X*\u00020L2\u0006\u0010Y\u001a\u00020RH\u0002J&\u0010Z\u001a\u00020#*\u00020L2\u0018\u0010[\u001a\u0014\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020#0\\H\u0002JG\u0010]\u001a\u00020#\"\u0004\b\u0000\u0010^*\b\u0012\u0004\u0012\u0002H^0_2\u0018\u0010[\u001a\u0014\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u0002H^\u0012\u0004\u0012\u00020#0\\2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002H^\u0012\u0004\u0012\u00020 0aH\u0082\bJ\u001a\u0010b\u001a\u00020#2\u0006\u0010c\u001a\u00020R2\b\u0010d\u001a\u0004\u0018\u00010XH\u0002J\u0010\u0010e\u001a\u00020#2\u0006\u0010c\u001a\u00020RH\u0002J\b\u0010f\u001a\u00020#H\u0002J\u0018\u0010g\u001a\u00020#2\u0006\u0010Y\u001a\u00020R2\u0006\u0010h\u001a\u00020LH\u0002J\u0010\u0010i\u001a\u00020#2\u0006\u0010h\u001a\u00020LH\u0002J\u0010\u0010j\u001a\u00020#2\u0006\u0010h\u001a\u00020LH\u0002J\r\u0010k\u001a\u00020#H\u0000¢\u0006\u0002\blJ\r\u0010m\u001a\u00020#H\u0000¢\u0006\u0002\bnJ\r\u0010o\u001a\u00020#H\u0000¢\u0006\u0002\bpJ\b\u0010q\u001a\u00020#H\u0002J\b\u0010r\u001a\u00020#H\u0002J\b\u0010s\u001a\u00020#H\u0002J-\u0010t\u001a\u00020#2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\u000e\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010{0zH\u0001¢\u0006\u0002\b|J(\u0010}\u001a\u00020#2\u0006\u0010~\u001a\u00020\u00002\u0010\u0010\u007f\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010\u0080\u0001H\u0001¢\u0006\u0003\b\u0082\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006\u0086\u0001"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "onContentCaptureSession", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function0;)V", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "getOnContentCaptureSession", "()Lkotlin/jvm/functions/Function0;", "setOnContentCaptureSession", "(Lkotlin/jvm/functions/Function0;)V", "contentCaptureSession", "getContentCaptureSession$ui_release$annotations", "()V", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "bufferedEvents", "", "Landroidx/compose/ui/contentcapture/ContentCaptureEvent;", "SendRecurringContentCaptureEventsIntervalMillis", "", "translateStatus", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "currentSemanticsNodesInvalidated", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "handler", "Landroid/os/Handler;", "getHandler$ui_release", "()Landroid/os/Handler;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui_release", "()Landroidx/collection/IntObjectMap;", "setCurrentSemanticsNodes$ui_release", "(Landroidx/collection/IntObjectMap;)V", "currentSemanticsNodesSnapshotTimestampMillis", "previousSemanticsNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "checkingForSemanticsChanges", "contentCaptureChangeChecker", "Ljava/lang/Runnable;", "onViewAttachedToWindow", BaseSwitches.V, "Landroid/view/View;", "onViewDetachedFromWindow", "isEnabled", "isEnabled$ui_release", "()Z", WidgetCostModule.TYPE_ON_START, "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSemanticsChange", "onSemanticsChange$ui_release", "onLayoutChange", "onLayoutChange$ui_release", "sendContentCaptureDisappearEvents", "sendContentCaptureAppearEvents", "newNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "oldNode", "checkForContentCapturePropertyChanges", "newSemanticsNodes", "sendContentCaptureTextUpdateEvent", "id", "", "newText", "", "updateSemanticsCopy", "notifySubtreeStateChangeIfNeeded", "toViewStructure", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "index", "fastForEachReplacedVisibleChildren", "action", "Lkotlin/Function2;", "fastForEachIndexedWithFilter", ExifInterface.GPS_DIRECTION_TRUE, "", "predicate", "Lkotlin/Function1;", "bufferContentCaptureViewAppeared", "virtualId", "viewStructure", "bufferContentCaptureViewDisappeared", "notifyContentCaptureChanges", "updateBuffersOnAppeared", "node", "updateBuffersOnDisappeared", "updateTranslationOnAppeared", "onShowTranslation", "onShowTranslation$ui_release", "onHideTranslation", "onHideTranslation$ui_release", "onClearTranslation", "onClearTranslation$ui_release", "showTranslatedText", "hideTranslatedText", "clearTranslatedText", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onCreateVirtualViewTranslationRequests$ui_release", "onVirtualViewTranslationResponses", "contentCaptureManager", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onVirtualViewTranslationResponses$ui_release", "TranslateStatus", "ViewTranslationHelperMethods", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidContentCaptureManager implements ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX = "android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX";
    public static final String VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP = "android.view.contentcapture.EventTimestamp";
    private long SendRecurringContentCaptureEventsIntervalMillis;
    private final Channel<Unit> boundsUpdateChannel;
    private final List<ContentCaptureEvent> bufferedEvents;
    private boolean checkingForSemanticsChanges;
    private final Runnable contentCaptureChangeChecker;
    private ContentCaptureSessionCompat contentCaptureSession;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private long currentSemanticsNodesSnapshotTimestampMillis;
    private final Handler handler;
    private Function0<? extends ContentCaptureSessionCompat> onContentCaptureSession;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private TranslateStatus translateStatus;
    private final AndroidComposeView view;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$Companion;", "", "<init>", "()V", "VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP", "", "VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum TranslateStatus extends Enum<TranslateStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TranslateStatus[] $VALUES = null;
        public static final TranslateStatus SHOW_ORIGINAL = null;
        public static final TranslateStatus SHOW_TRANSLATED = null;

        private static final /* synthetic */ TranslateStatus[] $values() {
            return new TranslateStatus[]{SHOW_ORIGINAL, SHOW_TRANSLATED};
        }

        public static EnumEntries<TranslateStatus> getEntries() {
            return $ENTRIES;
        }

        static {
            SHOW_ORIGINAL = new TranslateStatus("SHOW_ORIGINAL", 0);
            SHOW_TRANSLATED = new TranslateStatus("SHOW_TRANSLATED", 1);
            TranslateStatus[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static TranslateStatus[] values() {
            return (TranslateStatus[]) $VALUES.clone();
        }

        public static TranslateStatus valueOf(String r100) {
            return (TranslateStatus) r27.a.a(TranslateStatus.class, r100);
        }

        private TranslateStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0007J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0007J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods;", "", "<init>", "()V", "onCreateVirtualViewTranslationRequests", "", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "doTranslation", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ViewTranslationHelperMethods {
        public static final ViewTranslationHelperMethods INSTANCE = null;

        static {
            INSTANCE = new ViewTranslationHelperMethods();
        }

        private ViewTranslationHelperMethods() {
        }

        public static /* synthetic */ void a(AndroidContentCaptureManager r100, LongSparseArray r101) {
            onVirtualViewTranslationResponses$lambda$1(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void doTranslation(AndroidContentCaptureManager r100, LongSparseArray<ViewTranslationResponse> r101) {
            int r102 = r101.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L20;
            long r104 = r101.keyAt(r103);
            ViewTranslationResponse r105 = r101.get(r104);
            if (r105 == null) goto L19;
            TranslationResponseValue r106 = r105.getValue("android:text");
            if (r106 == null) goto L19;
            CharSequence r107 = r106.getText();
            if (r107 == null) goto L19;
            SemanticsNodeWithAdjustedBounds r108 = r100.getCurrentSemanticsNodes$ui_release().get((int) r104);
            if (r108 == null) goto L19;
            SemanticsNode r109 = r108.getSemanticsNode();
            if (r109 == null) goto L19;
            AccessibilityAction r110 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(r109.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetTextSubstitution());
            if (r110 == null) goto L19;
            Function1 r111 = (Function1) r110.getAction();
            if (r111 == null) goto L19;
            List r112 = null;
            Boolean r113 = (Boolean) r111.invoke(new AnnotatedString(r107.toString(), r112, 2, 0 == true ? 1 : 0));
        L19:
            r103 = r103 + 1;
            goto L3
        }

        private static final void onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager r100, LongSparseArray r101) {
            INSTANCE.doTranslation(r100, r101);
        }

        public final void onVirtualViewTranslationResponses(final AndroidContentCaptureManager r100, final LongSparseArray<ViewTranslationResponse> r101) {
            if (Build.VERSION.SDK_INT >= 31) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L8;
            doTranslation(r100, r101);
            return;
        L8:
            r100.getView().post(new b(r100, r101));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onCreateVirtualViewTranslationRequests(AndroidContentCaptureManager r110, long[] r111, int[] r112, Consumer<ViewTranslationRequest> r113) {
            int r100 = r111.length;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L16;
            SemanticsNodeWithAdjustedBounds r102 = r110.getCurrentSemanticsNodes$ui_release().get((int) r111[r101]);
            if (r102 == null) goto L15;
            SemanticsNode r103 = r102.getSemanticsNode();
            if (r103 == null) goto L15;
            ViewTranslationRequest.Builder r104 = new ViewTranslationRequest.Builder(r110.getView().getAutofillId(), r103.getId());
            List r105 = (List) SemanticsConfigurationKt.getOrNull(r103.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
            if (r105 == null) goto L15;
            String r106 = ListUtilsKt.fastJoinToString$default(r105, "\n", null, null, 0, null, null, 62, null);
            if (r106 == null) goto L15;
            r104.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(r106, null, 2, 0 == true ? 1 : 0)));
            r113.accept(r104.build());
        L15:
            r101 = r101 + 1;
            goto L3
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ContentCaptureEventType.values().length];
            r100[ContentCaptureEventType.VIEW_APPEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ContentCaptureEventType.VIEW_DISAPPEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public static /* synthetic */ void a(AndroidContentCaptureManager r100) {
        contentCaptureChangeChecker$lambda$2(r100);
    }

    public static /* synthetic */ void getContentCaptureSession$ui_release$annotations() {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
    }

    public final void onLayoutChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() == false) goto L6;
        notifySubtreeStateChangeIfNeeded();
        return;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() == true) goto L5;
        return;
    L5:
        if (this.checkingForSemanticsChanges == true) goto L9;
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.contentCaptureChangeChecker);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
    }

    private final void notifyContentCaptureChanges() {
        ContentCaptureSessionCompat r100 = this.contentCaptureSession;
        if (r100 != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L9;
        return;
    L9:
        if ((!this.bufferedEvents.isEmpty()) == false) goto L33;
        List<ContentCaptureEvent> r101 = this.bufferedEvents;
        int r102 = r101.size();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L25;
        ContentCaptureEvent r104 = (ContentCaptureEvent) ListProtector.get(r101, r103);
        int r105 = WhenMappings.$EnumSwitchMapping$0[r104.getType().ordinal()];
        if (r105 != 1) goto L15;
        ViewStructureCompat r106 = r104.getStructureCompat();
        if (r106 == null) goto L24;
        r100.notifyViewAppeared(r106.toViewStructure());
    L24:
        r103 = r103 + 1;
        goto L11
    L15:
        if (r105 != 2) goto L20;
        AutofillId r107 = r100.newAutofillId(r104.getId());
        if (r107 == null) goto L24;
        r100.notifyViewDisappeared(r107);
        goto L24
    L20:
        throw new NoWhenBranchMatchedException();
    L25:
        r100.flush();
        this.bufferedEvents.clear();
        return;
    }

    private final void notifySubtreeStateChangeIfNeeded() {
        this.boundsUpdateChannel.mo10962trySendJP2dKIU(Unit.INSTANCE);
    }

    private final void sendContentCaptureDisappearEvents() {
        MutableIntObjectMap<SemanticsNodeCopy> r100 = this.previousSemanticsNodes;
        int[] r101 = r100.keys;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L21;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == false) goto L17;
        int r111 = r101[(r104 << 3) + r107];
        if (getCurrentSemanticsNodes$ui_release().containsKey(r111) == true) goto L17;
        bufferContentCaptureViewDisappeared(r111);
        notifySubtreeStateChangeIfNeeded();
    L17:
        r105 = r105 >> 8;
        r107 = r107 + 1;
        goto L8
    L12:
        r110 = false;
        goto L13
    L18:
        if (r106 == 8) goto L19;
        return;
    L19:
        if (r104 == r103) goto L29;
        r104 = r104 + 1;
        goto L5
    L29:
        return;
    }

    private final void updateSemanticsCopy() {
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> r100 = getCurrentSemanticsNodes$ui_release();
        int[] r101 = r100.keys;
        Object[] r102 = r100.values;
        long[] r103 = r100.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L19;
        int r105 = 0;
    L5:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r107 = 8 - ((~(r105 - r104)) >>> 31);
        int r110 = 0;
    L8:
        if (r110 >= r107) goto L16;
        if ((255 & r106) >= 128) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L15;
        int r112 = (r105 << 3) + r110;
        this.previousSemanticsNodes.set(r101[r112], new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) r102[r112]).getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
    L15:
        r106 = r106 >> 8;
        r110 = r110 + 1;
        goto L8
    L12:
        r111 = false;
        goto L13
    L16:
        if (r107 != 8) goto L19;
    L17:
        if (r105 == r104) goto L19;
        r105 = r105 + 1;
    L19:
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated == false) goto L6;
        this.currentSemanticsNodesInvalidated = false;
        this.currentSemanticsNodes = SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner(), -1);
        this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
    L6:
        return this.currentSemanticsNodes;
    }

    public final boolean isEnabled$ui_release() {
        if (ContentCaptureManager.Companion.isEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.contentCaptureSession == null) goto L7;
        return true;
    }

    public final void onClearTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    public final void onHideTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    public final void onShowTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    private final void clearTranslatedText() {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> r100 = getCurrentSemanticsNodes$ui_release();
        Object[] r101 = r100.values;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L25;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L22;
        if ((255 & r105) >= 128) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == false) goto L21;
        SemanticsConfiguration r111 = ((SemanticsNodeWithAdjustedBounds) r101[(r104 << 3) + r107]).getSemanticsNode().getUnmergedConfig$ui_release();
        if (SemanticsConfigurationKt.getOrNull(r111, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) == null) goto L21;
        AccessibilityAction r112 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(r111, SemanticsActions.INSTANCE.getClearTextSubstitution());
        if (r112 == null) goto L21;
        Function0 r113 = (Function0) r112.getAction();
        if (r113 == null) goto L21;
        Boolean r114 = (Boolean) r113.invoke();
    L21:
        r105 = r105 >> 8;
        r107 = r107 + 1;
        goto L8
    L12:
        r110 = false;
        goto L13
    L22:
        if (r106 == 8) goto L23;
        return;
    L23:
        if (r104 == r103) goto L35;
        r104 = r104 + 1;
        goto L5
    L35:
        return;
    }

    private final void hideTranslatedText() {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> r100 = getCurrentSemanticsNodes$ui_release();
        Object[] r101 = r100.values;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L25;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L22;
        if ((255 & r105) >= 128) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == false) goto L21;
        SemanticsConfiguration r111 = ((SemanticsNodeWithAdjustedBounds) r101[(r104 << 3) + r107]).getSemanticsNode().getUnmergedConfig$ui_release();
        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(r111, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.TRUE) == false) goto L21;
        AccessibilityAction r112 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(r111, SemanticsActions.INSTANCE.getShowTextSubstitution());
        if (r112 == null) goto L21;
        Function1 r113 = (Function1) r112.getAction();
        if (r113 == null) goto L21;
        Boolean r114 = (Boolean) r113.invoke(Boolean.FALSE);
    L21:
        r105 = r105 >> 8;
        r107 = r107 + 1;
        goto L8
    L12:
        r110 = false;
        goto L13
    L22:
        if (r106 == 8) goto L23;
        return;
    L23:
        if (r104 == r103) goto L35;
        r104 = r104 + 1;
        goto L5
    L35:
        return;
    }

    private final void showTranslatedText() {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> r100 = getCurrentSemanticsNodes$ui_release();
        Object[] r101 = r100.values;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L25;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L22;
        if ((255 & r105) >= 128) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == false) goto L21;
        SemanticsConfiguration r111 = ((SemanticsNodeWithAdjustedBounds) r101[(r104 << 3) + r107]).getSemanticsNode().getUnmergedConfig$ui_release();
        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(r111, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.FALSE) == false) goto L21;
        AccessibilityAction r112 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(r111, SemanticsActions.INSTANCE.getShowTextSubstitution());
        if (r112 == null) goto L21;
        Function1 r113 = (Function1) r112.getAction();
        if (r113 == null) goto L21;
        Boolean r114 = (Boolean) r113.invoke(Boolean.TRUE);
    L21:
        r105 = r105 >> 8;
        r107 = r107 + 1;
        goto L8
    L12:
        r110 = false;
        goto L13
    L22:
        if (r106 == 8) goto L23;
        return;
    L23:
        if (r104 == r103) goto L35;
        r104 = r104 + 1;
        goto L5
    L35:
        return;
    }

    public final ContentCaptureSessionCompat getContentCaptureSession$ui_release() {
        return this.contentCaptureSession;
    }

    public final Handler getHandler$ui_release() {
        return this.handler;
    }

    public final Function0<ContentCaptureSessionCompat> getOnContentCaptureSession() {
        return this.onContentCaptureSession;
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public static final /* synthetic */ void access$notifySubtreeStateChangeIfNeeded(AndroidContentCaptureManager r100) {
        r100.notifySubtreeStateChangeIfNeeded();
    }

    private final void bufferContentCaptureViewDisappeared(int r100) {
        this.bufferedEvents.add(new ContentCaptureEvent(r100, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_DISAPPEAR, null));
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap<SemanticsNodeWithAdjustedBounds> r310) {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> r100 = r310;
        int[] r101 = r100.keys;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L94;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        char r110 = 7;
        long r111 = -9187201950435737472L;
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L91;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L8:
        if (r112 >= r106) goto L88;
        if ((r105 & 255) >= 128) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L85;
        int r107 = r101[(r104 << 3) + r112];
        SemanticsNodeCopy r114 = this.previousSemanticsNodes.get(r107);
        SemanticsNodeWithAdjustedBounds r108 = r100.get(r107);
        if (r108 == null) goto L17;
        SemanticsNode r109 = r108.getSemanticsNode();
    L18:
        if (r109 == null) goto L83;
        if (r114 != null) goto L49;
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r115 = r109.getUnmergedConfig$ui_release().getProps$ui_release();
        Object[] r116 = r115.keys;
        long[] r117 = r115.metadata;
        int r118 = r117.length - 2;
        int[] r210 = r101;
        if (r118 < 0) goto L47;
        int r119 = 0;
    L23:
        long r120 = r117[r119];
        long[] r211 = r102;
        int r212 = r103;
        if (((((~r120) << r110) & r120) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L44;
        int r121 = 8 - ((~(r119 - r118)) >>> 31);
        int r122 = 0;
    L26:
        if (r122 >= r121) goto L41;
        if ((r120 & 255) >= 128) goto L30;
        boolean r213 = true;
    L31:
        if (r213 == false) goto L39;
        SemanticsPropertyKey r123 = (SemanticsPropertyKey) r116[(r119 << 3) + r122];
        SemanticsProperties r214 = SemanticsProperties.INSTANCE;
        Object[] r311 = r116;
        if (Intrinsics.areEqual(r123, r214.getText()) == false) goto L40;
        List r124 = (List) SemanticsConfigurationKt.getOrNull(r109.getUnmergedConfig$ui_release(), r214.getText());
        if (r124 == null) goto L37;
        AnnotatedString r125 = (AnnotatedString) CollectionsKt.firstOrNull(r124);
    L38:
        sendContentCaptureTextUpdateEvent(r109.getId(), String.valueOf(r125));
        goto L40
    L37:
        r125 = null;
    L40:
        r120 = r120 >> 8;
        r122 = r122 + 1;
        r116 = r311;
        goto L26
    L39:
        r311 = r116;
        goto L40
    L30:
        r213 = false;
        goto L31
    L41:
        Object[] r312 = r116;
        if (r121 != 8) goto L48;
    L45:
        if (r119 == r118) goto L48;
        r119 = r119 + 1;
        r102 = r211;
        r103 = r212;
        r116 = r312;
        r110 = 7;
    L48:
        long r215 = -9187201950435737472L;
    L87:
        r105 = r105 >> 8;
        r112 = r112 + 1;
        r100 = r310;
        r111 = r215;
        r101 = r210;
        r102 = r211;
        r103 = r212;
        r110 = 7;
        goto L8
    L44:
        r312 = r116;
        goto L45
    L47:
        r211 = r102;
        r212 = r103;
        goto L48
    L49:
        r210 = r101;
        r211 = r102;
        r212 = r103;
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r126 = r109.getUnmergedConfig$ui_release().getProps$ui_release();
        Object[] r127 = r126.keys;
        long[] r128 = r126.metadata;
        int r129 = r128.length - 2;
        if (r129 < 0) goto L48;
        int r130 = 0;
    L52:
        long r131 = r128[r130];
        r215 = -9187201950435737472L;
        if (((((~r131) << 7) & r131) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L80;
        int r132 = 8 - ((~(r130 - r129)) >>> 31);
        int r133 = 0;
    L55:
        if (r133 >= r132) goto L77;
        if ((r131 & 255) >= 128) goto L59;
        boolean r313 = true;
    L60:
        if (r313 == false) goto L74;
        long[] r314 = r128;
        SemanticsPropertyKey r134 = (SemanticsPropertyKey) r127[(r130 << 3) + r133];
        SemanticsProperties r315 = SemanticsProperties.INSTANCE;
        Object[] r316 = r127;
        if (Intrinsics.areEqual(r134, r315.getText()) == false) goto L75;
        List r135 = (List) SemanticsConfigurationKt.getOrNull(r114.getUnmergedConfig(), r315.getText());
        if (r135 == null) goto L66;
        AnnotatedString r136 = (AnnotatedString) CollectionsKt.firstOrNull(r135);
    L67:
        SemanticsNodeCopy r317 = r114;
        List r137 = (List) SemanticsConfigurationKt.getOrNull(r109.getUnmergedConfig$ui_release(), r315.getText());
        if (r137 == null) goto L70;
        AnnotatedString r138 = (AnnotatedString) CollectionsKt.firstOrNull(r137);
    L72:
        if (Intrinsics.areEqual(r136, r138) == true) goto L76;
        sendContentCaptureTextUpdateEvent(r109.getId(), String.valueOf(r138));
    L76:
        r131 = r131 >> 8;
        r133 = r133 + 1;
        r128 = r314;
        r127 = r316;
        r114 = r317;
        goto L55
    L70:
        r138 = null;
        goto L72
    L66:
        r136 = null;
    L75:
        r317 = r114;
        goto L76
    L74:
        r314 = r128;
        r316 = r127;
        goto L75
    L59:
        r313 = false;
        goto L60
    L77:
        long[] r318 = r128;
        Object[] r319 = r127;
        SemanticsNodeCopy r320 = r114;
        if (r132 != 8) goto L87;
    L81:
        if (r130 == r129) goto L87;
        r130 = r130 + 1;
        r128 = r318;
        r127 = r319;
        r114 = r320;
        goto L52
    L80:
        r318 = r128;
        r319 = r127;
        r320 = r114;
        goto L81
    L83:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
        throw new KotlinNothingValueException();
    L17:
        r109 = null;
        goto L18
    L85:
        r210 = r101;
        r211 = r102;
        r212 = r103;
        r215 = r111;
        goto L87
    L12:
        r113 = false;
        goto L13
    L88:
        int[] r216 = r101;
        long[] r217 = r102;
        int r218 = r103;
        if (r106 != 8) goto L112;
        r103 = r218;
    L92:
        if (r104 == r103) goto L113;
        r104 = r104 + 1;
        r100 = r310;
        r101 = r216;
        r102 = r217;
        goto L5
    L113:
        return;
    L112:
        return;
    L91:
        r216 = r101;
        r217 = r102;
        goto L92
    }

    private static final void contentCaptureChangeChecker$lambda$2(AndroidContentCaptureManager r100) {
        if (r100.isEnabled$ui_release() == true) goto L5;
        return;
    L5:
        Trace.beginSection("ContentCapture:changeChecker");
        Owner.CC.measureAndLayout$default(r100.view, false, 1, null);     // Catch: Throwable -> L14
        r100.sendContentCaptureDisappearEvents();     // Catch: Throwable -> L14
        Trace.beginSection("ContentCapture:sendAppearEvents");     // Catch: Throwable -> L14
        r100.sendContentCaptureAppearEvents(r100.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), r100.previousSemanticsRoot);     // Catch: Throwable -> L11
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        Trace.endSection();     // Catch: Throwable -> L14
        r100.checkForContentCapturePropertyChanges(r100.getCurrentSemanticsNodes$ui_release());     // Catch: Throwable -> L14
        r100.updateSemanticsCopy();     // Catch: Throwable -> L14
        r100.checkingForSemanticsChanges = false;     // Catch: Throwable -> L14
        Trace.endSection();
        return;
    L11:
        th = move-exception;
        Trace.endSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    private final void updateBuffersOnDisappeared(SemanticsNode r100) {
        if (isEnabled$ui_release() == true) goto L5;
        return;
    L5:
        bufferContentCaptureViewDisappeared(r100.getId());
        List<SemanticsNode> r101 = r100.getReplacedChildren$ui_release();
        int r102 = r101.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        updateBuffersOnDisappeared((SemanticsNode) ListProtector.get(r101, r103));
        r103 = r103 + 1;
        goto L6
    }

    private final void updateTranslationOnAppeared(SemanticsNode r100) {
        SemanticsConfiguration r101 = r100.getUnmergedConfig$ui_release();
        Boolean r102 = (Boolean) SemanticsConfigurationKt.getOrNull(r101, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        if (this.translateStatus != TranslateStatus.SHOW_ORIGINAL) goto L12;
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L12;
        AccessibilityAction r103 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(r101, SemanticsActions.INSTANCE.getShowTextSubstitution());
        if (r103 == null) goto L21;
        Function1 r104 = (Function1) r103.getAction();
        if (r104 == null) goto L22;
        Boolean r105 = (Boolean) r104.invoke(Boolean.FALSE);
        return;
    L22:
        return;
    L21:
        return;
    L12:
        if (this.translateStatus == TranslateStatus.SHOW_TRANSLATED) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L25;
        AccessibilityAction r106 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(r101, SemanticsActions.INSTANCE.getShowTextSubstitution());
        if (r106 == null) goto L26;
        Function1 r107 = (Function1) r106.getAction();
        if (r107 == null) goto L27;
        Boolean r108 = (Boolean) r107.invoke(Boolean.TRUE);
        return;
    L27:
        return;
    L26:
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0089 -> B:18:0x004c). Please report as a decompilation issue!!! */
    public final Object boundsUpdatesEventLoop$ui_release(Continuation<? super Unit> r110) {
        if ((r110 instanceof AndroidContentCaptureManager$boundsUpdatesEventLoop$1) == false) goto L7;
        AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r100 = (AndroidContentCaptureManager$boundsUpdatesEventLoop$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ChannelIterator<Unit> r104 = (ChannelIterator) r100.L$0;
        ResultKt.throwOnFailure(r111);
        ChannelIterator<Unit> r112 = r104;
    L17:
        AndroidContentCaptureManager r105 = this;
    L18:
        r100.L$0 = r112;
        r100.label = 1;
        Object r106 = r112.hasNext(r100);
        if (r106 != r102) goto L21;
        return r102;
    L21:
        AndroidContentCaptureManager r107 = r105;
        ChannelIterator<Unit> r108 = r112;
        r111 = r106;
        AndroidContentCaptureManager r109 = r107;
    L23:
        if (((Boolean) r111).booleanValue() == false) goto L35;
        r108.next();
        if (r109.isEnabled$ui_release() == false) goto L28;
        r109.notifyContentCaptureChanges();
    L28:
        if (r109.checkingForSemanticsChanges == true) goto L30;
        r109.checkingForSemanticsChanges = true;
        r109.handler.post(r109.contentCaptureChangeChecker);
    L30:
        long r113 = r109.SendRecurringContentCaptureEventsIntervalMillis;
        r100.L$0 = r108;
        r100.label = 2;
        if (DelayKt.delay(r113, r100) != r102) goto L33;
        return r102;
    L33:
        r112 = r108;
        r105 = r109;
        goto L18
    L35:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r108 = (ChannelIterator) r100.L$0;
        ResultKt.throwOnFailure(r111);
        r109 = this;
        goto L23
    L16:
        ResultKt.throwOnFailure(r111);
        r112 = this.boundsUpdateChannel.iterator();
    L7:
        r100 = new AndroidContentCaptureManager$boundsUpdatesEventLoop$1(this, r110);
        goto L8
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner r100) {
        this.contentCaptureSession = this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(-1, this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner r100) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = null;
    }

    public final void setContentCaptureSession$ui_release(ContentCaptureSessionCompat r100) {
        this.contentCaptureSession = r100;
    }

    public final void setCurrentSemanticsNodes$ui_release(IntObjectMap<SemanticsNodeWithAdjustedBounds> r100) {
        this.currentSemanticsNodes = r100;
    }

    public final void setOnContentCaptureSession(Function0<? extends ContentCaptureSessionCompat> r100) {
        this.onContentCaptureSession = r100;
    }

    public AndroidContentCaptureManager(AndroidComposeView r100, Function0<? extends ContentCaptureSessionCompat> r101) {
        this.view = r100;
        this.onContentCaptureSession = r101;
        this.bufferedEvents = new ArrayList();
        this.SendRecurringContentCaptureEventsIntervalMillis = 100;
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        this.currentSemanticsNodesInvalidated = true;
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.handler = new Handler(Looper.getMainLooper());
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(r100.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.contentCaptureChangeChecker = new a(this);
    }

    private final void bufferContentCaptureViewAppeared(int r100, ViewStructureCompat r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        this.bufferedEvents.add(new ContentCaptureEvent(r100, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_APPEAR, r110));
    }

    private final void fastForEachReplacedVisibleChildren(SemanticsNode r100, Function2<? super Integer, ? super SemanticsNode, Unit> r101) {
        List<SemanticsNode> r102 = r100.getReplacedChildren$ui_release();
        int r103 = r102.size();
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Object r106 = ListProtector.get(r102, r104);
        if (getCurrentSemanticsNodes$ui_release().containsKey(((SemanticsNode) r106).getId()) == false) goto L7;
        r101.invoke(Integer.valueOf(r105), r106);
        r105 = r105 + 1;
    L7:
        r104 = r104 + 1;
        goto L3
    }

    private final void sendContentCaptureAppearEvents(SemanticsNode r100, final SemanticsNodeCopy r101) {
        fastForEachReplacedVisibleChildren(r100, new AnonymousClass1(r101, this));
        List<SemanticsNode> r102 = r100.getReplacedChildren$ui_release();
        int r103 = r102.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        SemanticsNode r105 = (SemanticsNode) ListProtector.get(r102, r104);
        if (getCurrentSemanticsNodes$ui_release().containsKey(r105.getId()) == false) goto L13;
        if (this.previousSemanticsNodes.containsKey(r105.getId()) == false) goto L13;
        SemanticsNodeCopy r106 = this.previousSemanticsNodes.get(r105.getId());
        if (r106 == null) goto L11;
        sendContentCaptureAppearEvents(r105, r106);
        goto L13
    L11:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
        throw new KotlinNothingValueException();
    L13:
        r104 = r104 + 1;
        goto L3
    }

    private final void sendContentCaptureTextUpdateEvent(int r100, String r101) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return;
    L5:
        ContentCaptureSessionCompat r102 = this.contentCaptureSession;
        if (r102 != null) goto L8;
        return;
    L8:
        AutofillId r103 = r102.newAutofillId(r100);
        if (r103 == null) goto L12;
        r102.notifyViewTextChanged(r103, r101);
        return;
    L12:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid content capture ID");
        throw new KotlinNothingValueException();
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode r110, int r111) {
        ContentCaptureSessionCompat r100 = this.contentCaptureSession;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L8;
        return null;
    L8:
        AutofillIdCompat r101 = ViewCompatShims.getAutofillId(this.view);
        if (r101 != null) goto L11;
        return null;
    L11:
        SemanticsNode r102 = r110.getParent();
        if (r102 == null) goto L16;
        AutofillId r103 = r100.newAutofillId(r102.getId());
        if (r103 != null) goto L17;
        return null;
    L17:
        ViewStructureCompat r104 = r100.newVirtualViewStructure(r103, r110.getId());
        if (r104 != null) goto L20;
        return null;
    L20:
        SemanticsConfiguration r105 = r110.getUnmergedConfig$ui_release();
        SemanticsProperties r106 = SemanticsProperties.INSTANCE;
        if (r105.contains(r106.getPassword()) == false) goto L23;
        return null;
    L23:
        Bundle r107 = r104.getExtras();
        if (r107 == null) goto L26;
        r107.putLong(VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP, this.currentSemanticsNodesSnapshotTimestampMillis);
        r107.putInt(VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX, r111);
    L26:
        String r112 = (String) SemanticsConfigurationKt.getOrNull(r105, r106.getTestTag());
        if (r112 == null) goto L29;
        r104.setId(r110.getId(), null, null, r112);
    L29:
        Boolean r113 = (Boolean) SemanticsConfigurationKt.getOrNull(r105, r106.getIsTraversalGroup());
        if (r113 == null) goto L32;
        r113.booleanValue();
        r104.setClassName("android.widget.ViewGroup");
    L32:
        List r108 = (List) SemanticsConfigurationKt.getOrNull(r105, r106.getText());
        if (r108 == null) goto L35;
        r104.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextClassName);
        r104.setText(ListUtilsKt.fastJoinToString$default(r108, "\n", null, null, 0, null, null, 62, null));
    L35:
        AnnotatedString r114 = (AnnotatedString) SemanticsConfigurationKt.getOrNull(r105, r106.getEditableText());
        if (r114 == null) goto L38;
        r104.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
        r104.setText(r114);
    L38:
        List r109 = (List) SemanticsConfigurationKt.getOrNull(r105, r106.getContentDescription());
        if (r109 == null) goto L41;
        r104.setContentDescription(ListUtilsKt.fastJoinToString$default(r109, "\n", null, null, 0, null, null, 62, null));
    L41:
        Role r115 = (Role) SemanticsConfigurationKt.getOrNull(r105, r106.getRole());
        if (r115 == null) goto L46;
        String r116 = SemanticsUtils_androidKt.m6743toLegacyClassNameV4PA4sw(r115.m6768unboximpl());
        if (r116 == null) goto L46;
        r104.setClassName(r116);
    L46:
        TextLayoutResult r117 = SemanticsUtils_androidKt.getTextLayoutResult(r105);
        if (r117 == null) goto L49;
        TextLayoutInput r118 = r117.getLayoutInput();
        r104.setTextStyle((TextUnit.m7742getValueimpl(r118.getStyle().m7029getFontSizeXSAIIZE()) * r118.getDensity().getDensity()) * r118.getDensity().getFontScale(), 0, 0, 0);
    L49:
        Rect r119 = r110.getBoundsInParent$ui_release();
        r104.setDimens((int) r119.getLeft(), (int) r119.getTop(), 0, 0, (int) (r119.getRight() - r119.getLeft()), (int) (r119.getBottom() - r119.getTop()));
        return r104;
    L16:
        r103 = r101.toAutofillId();
        goto L17
    }

    private final void updateBuffersOnAppeared(int r100, SemanticsNode r101) {
        if (isEnabled$ui_release() == true) goto L5;
        return;
    L5:
        updateTranslationOnAppeared(r101);
        bufferContentCaptureViewAppeared(r101.getId(), toViewStructure(r101, r100));
        fastForEachReplacedVisibleChildren(r101, new C87331(this));
    }

    public final void onVirtualViewTranslationResponses$ui_release(AndroidContentCaptureManager r100, LongSparseArray<ViewTranslationResponse> r101) {
        ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(r100, r101);
    }

    public static final /* synthetic */ void access$updateBuffersOnAppeared(AndroidContentCaptureManager r100, int r101, SemanticsNode r102) {
        r100.updateBuffersOnAppeared(r101, r102);
    }

    private final <T> void fastForEachIndexedWithFilter(List<? extends T> r100, Function2<? super Integer, ? super T, Unit> r101, Function1<? super T, Boolean> r102) {
        int r103 = r100.size();
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r106 = (Object) ListProtector.get(r100, r104);
        if (r102.invoke(r106).booleanValue() == false) goto L7;
        r101.invoke(Integer.valueOf(r105), r106);
        r105 = r105 + 1;
    L7:
        r104 = r104 + 1;
        goto L3
    }

    public final void onCreateVirtualViewTranslationRequests$ui_release(long[] r100, int[] r101, Consumer<ViewTranslationRequest> r102) {
        ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, r100, r101, r102);
    }
}
