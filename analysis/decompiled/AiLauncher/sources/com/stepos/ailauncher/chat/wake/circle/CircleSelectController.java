package com.stepos.ailauncher.chat.wake.circle;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Z8.C1173v;
import Z8.Q;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.circle.G;
import com.stepos.ailauncher.screenshot.ScreenshotClient;
import com.stepos.picker.screenperception.ScreenPoint;
import com.stepos.picker.screenperception.ScreenRegion;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.N;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0096\u00012\u00020\u0001:\u0002\u0097\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u0017J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010$J\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010\u0013J\u000f\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020+H\u0002¢\u0006\u0004\b.\u0010-J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\"H\u0002¢\u0006\u0004\b7\u0010$J\u000f\u00108\u001a\u00020\fH\u0002¢\u0006\u0004\b8\u0010\u0013J\u000f\u00109\u001a\u00020\fH\u0002¢\u0006\u0004\b9\u0010\u0013J\u0017\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u00020\f2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060=H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bA\u0010\u0013J\u000f\u0010B\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010\u0013J\u000f\u0010C\u001a\u00020\fH\u0002¢\u0006\u0004\bC\u0010\u0013J\u000f\u0010D\u001a\u00020\fH\u0002¢\u0006\u0004\bD\u0010\u0013J\u000f\u0010E\u001a\u00020\fH\u0002¢\u0006\u0004\bE\u0010\u0013J\u000f\u0010F\u001a\u00020\fH\u0002¢\u0006\u0004\bF\u0010\u0013J\u000f\u0010G\u001a\u00020\fH\u0002¢\u0006\u0004\bG\u0010\u0013J\u0017\u0010H\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\bH\u0010\u0017J\u0017\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\fH\u0002¢\u0006\u0004\bM\u0010\u0013J\r\u0010O\u001a\u00020N¢\u0006\u0004\bO\u0010PJ\r\u0010Q\u001a\u00020N¢\u0006\u0004\bQ\u0010PJ\r\u0010R\u001a\u00020\f¢\u0006\u0004\bR\u0010\u0013J\r\u0010S\u001a\u00020\f¢\u0006\u0004\bS\u0010\u0013J\r\u0010T\u001a\u00020\f¢\u0006\u0004\bT\u0010\u0013J\u0015\u0010V\u001a\u00020\f2\u0006\u0010U\u001a\u00020I¢\u0006\u0004\bV\u0010LJ\r\u0010W\u001a\u00020N¢\u0006\u0004\bW\u0010PR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010XR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010YR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010ZR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010[R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010YR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\\R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\\R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010`\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010ZR\u0018\u0010c\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010ZR\u0016\u0010f\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010h\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010ZR\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020j0i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010lR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010q\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010|\u001a\u00020{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010rR\u0019\u0010\u008d\u0001\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0086\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0090\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0095\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010g¨\u0006\u0098\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/circle/CircleSelectController;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "wakeRoot", "Landroid/view/View;", "panelView", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "inputView", "chipHost", "Lkotlin/Function0;", "LY8/t;", "onSubmitSuccess", "onDismissRequest", "onBlankTapRequest", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/View;Lcom/stepos/ailauncher/chat/view/BaseInputView;Landroid/view/ViewGroup;Lp9/a;Lp9/a;Lp9/a;)V", "t0", "()V", "Landroid/graphics/RectF;", "rect", "y0", "(Landroid/graphics/RectF;)V", "T0", "A0", "I0", "Landroid/graphics/Rect;", "Z0", "(Landroid/graphics/RectF;)Landroid/graphics/Rect;", "k0", "Lcom/stepos/picker/screenperception/ScreenRegion;", "M0", "(Landroid/graphics/RectF;)Lcom/stepos/picker/screenperception/ScreenRegion;", "", "C0", "()I", "f0", "freehandView", "", "h0", "(Landroid/view/View;)Ljava/lang/Float;", "b1", "Landroidx/constraintlayout/widget/ConstraintLayout$b;", "j0", "()Landroidx/constraintlayout/widget/ConstraintLayout$b;", "i0", "Lcom/stepos/ailauncher/chat/wake/circle/J;", "m0", "()Lcom/stepos/ailauncher/chat/wake/circle/J;", "l0", "()Landroid/view/View;", "Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView;", "p0", "()Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView;", "z0", "U0", "W0", "container", "d1", "(Landroid/view/View;)V", "", "chipViews", "e0", "(Ljava/util/List;)V", "O0", SdCardDbCreator.FIELD_LASTLOC_ID, "F0", "R0", "P0", "X0", "Q0", "K0", "", "type", "S0", "(Ljava/lang/String;)V", "E0", "", "H0", "()Z", "V0", "Y", "B0", "N0", "question", "L0", "D0", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "Landroid/view/View;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Lp9/a;", "Lcom/stepos/ailauncher/chat/wake/circle/G;", "_mode", "Lcom/stepos/ailauncher/chat/wake/circle/G;", "freehandDrawView", "Lcom/stepos/ailauncher/chat/wake/circle/J;", "drawingScrimView", "selectionOverlayView", "Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView;", "chipsContainer", "chipRevealGeneration", "I", "closeButton", "", "Ly7/E;", "chipBlurHandles", "Ljava/util/List;", "chipGlassCacheTargets", "Lcom/stepos/ailauncher/chat/wake/circle/B;", "dragGlassCache", "Lcom/stepos/ailauncher/chat/wake/circle/B;", "currentRect", "Landroid/graphics/RectF;", "density", "F", "Lcom/stepos/ailauncher/chat/wake/circle/F;", "guideManager", "Lcom/stepos/ailauncher/chat/wake/circle/F;", "Lcom/stepos/ailauncher/screenshot/ScreenshotClient;", "screenshotClient", "Lcom/stepos/ailauncher/screenshot/ScreenshotClient;", "LUa/M;", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "captureJob", "Lkotlinx/coroutines/g;", "safetyReviewJob", "Landroid/net/Uri;", "latestCapturedUri", "Landroid/net/Uri;", "safetyBlocked", "Z", "lastCapturedRectPx", "Landroid/graphics/Rect;", "", "lastCaptureTsMs", "J", "pendingCaptureRect", "captureInflight", "Ljava/lang/Runnable;", "coalescedCaptureRunnable", "Ljava/lang/Runnable;", "updateOverlayBoundsRunnable", "Landroid/view/View$OnLayoutChangeListener;", "inputViewLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "captureRequestCount", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CircleSelectController {
    private static final long CAPTURE_THROTTLE_MS = 120;
    private static final int CHIP_BLUR_RADIUS_DP = 30;
    private static final int CHIP_CORNER_RADIUS_DP = 21;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DRAWING_SCRIM_COLOR = 855638016;
    private static final String TAG = "CircleSelect";
    private static final String TRACKER_PAGE_NAME = "circle";
    private static volatile boolean isAnyActive;
    private static volatile boolean isStrokeInProgress;
    private static volatile boolean isTouchInProgress;
    private static volatile boolean keyboardSuppressedForStroke;
    private static InterfaceC5063a<Y8.t> onDeactivatedForWake;
    private static InterfaceC5063a<Y8.t> onDismissFromGuard;
    private static InterfaceC5063a<Y8.t> onSessionCancel;
    private static volatile boolean sessionCancelled;
    private G _mode;
    private boolean captureInflight;
    private kotlinx.coroutines.g captureJob;
    private int captureRequestCount;
    private final List<y7.E> chipBlurHandles;
    private final List<View> chipGlassCacheTargets;
    private final ViewGroup chipHost;
    private int chipRevealGeneration;
    private View chipsContainer;
    private View closeButton;
    private final Runnable coalescedCaptureRunnable;
    private final Context context;
    private RectF currentRect;
    private final float density;
    private final B dragGlassCache;
    private View drawingScrimView;
    private J freehandDrawView;
    private final F guideManager;
    private final BaseInputView inputView;
    private final View.OnLayoutChangeListener inputViewLayoutListener;
    private long lastCaptureTsMs;
    private Rect lastCapturedRectPx;
    private Uri latestCapturedUri;
    private final InterfaceC5063a<Y8.t> onBlankTapRequest;
    private final InterfaceC5063a<Y8.t> onDismissRequest;
    private final InterfaceC5063a<Y8.t> onSubmitSuccess;
    private final View panelView;
    private RectF pendingCaptureRect;
    private boolean safetyBlocked;
    private kotlinx.coroutines.g safetyReviewJob;
    private final M scope;
    private final ScreenshotClient screenshotClient;
    private SelectionOverlayView selectionOverlayView;
    private final Runnable updateOverlayBoundsRunnable;
    private final ViewGroup wakeRoot;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R$\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010%R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\nR\u0014\u0010+\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/circle/CircleSelectController$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "", UxipConstants.f30680s, "isAnyActive", "Z", Const.INTENT_KEY_UMID, "()Z", "isStrokeInProgress", "f", "isTouchInProgress", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lkotlin/Function0;", "onDismissFromGuard", "Lp9/a;", Const.INTENT_KEY_PKGNAME, "()Lp9/a;", "setOnDismissFromGuard$chat_release", "(Lp9/a;)V", "onDeactivatedForWake", "getOnDeactivatedForWake$chat_release", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "onSessionCancel", "c", "setOnSessionCancel$chat_release", "e", "isSessionCancelled", "", "TAG", "Ljava/lang/String;", "", "CHIP_BLUR_RADIUS_DP", "I", "CHIP_CORNER_RADIUS_DP", "TRACKER_PAGE_NAME", "DRAWING_SCRIM_COLOR", "sessionCancelled", "", "CAPTURE_THROTTLE_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.circle.CircleSelectController$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a() {
            CircleSelectController.sessionCancelled = true;
            InterfaceC5063a<Y8.t> interfaceC5063aC = c();
            if (interfaceC5063aC != null) {
                interfaceC5063aC.invoke();
            }
        }

        public final InterfaceC5063a<Y8.t> b() {
            return CircleSelectController.onDismissFromGuard;
        }

        public final InterfaceC5063a<Y8.t> c() {
            return CircleSelectController.onSessionCancel;
        }

        public final boolean d() {
            return CircleSelectController.isAnyActive;
        }

        public final boolean e() {
            return CircleSelectController.sessionCancelled;
        }

        public final boolean f() {
            return CircleSelectController.isStrokeInProgress;
        }

        public final boolean g() {
            return CircleSelectController.isTouchInProgress;
        }

        public final void h() {
            CircleSelectController.sessionCancelled = false;
        }

        public final void i(InterfaceC5063a<Y8.t> interfaceC5063a) {
            CircleSelectController.onDeactivatedForWake = interfaceC5063a;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {
        final /* synthetic */ int $generation$inlined;

        public b(int i10) {
            this.$generation$inlined = i10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            CircleSelectController.this.inputView.post(new c(this.$generation$inlined, CircleSelectController.this));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        final /* synthetic */ int $generation;
        final /* synthetic */ CircleSelectController this$0;

        public c(int i10, CircleSelectController circleSelectController) {
            this.$generation = i10;
            this.this$0 = circleSelectController;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.$generation == this.this$0.chipRevealGeneration && kotlin.jvm.internal.p.d(this.this$0._mode, G.c.INSTANCE)) {
                this.this$0.W0();
            }
        }
    }

    public CircleSelectController(Context context, ViewGroup wakeRoot, View panelView, BaseInputView inputView, ViewGroup viewGroup, InterfaceC5063a<Y8.t> onSubmitSuccess, InterfaceC5063a<Y8.t> onDismissRequest, InterfaceC5063a<Y8.t> onBlankTapRequest) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(wakeRoot, "wakeRoot");
        kotlin.jvm.internal.p.i(panelView, "panelView");
        kotlin.jvm.internal.p.i(inputView, "inputView");
        kotlin.jvm.internal.p.i(onSubmitSuccess, "onSubmitSuccess");
        kotlin.jvm.internal.p.i(onDismissRequest, "onDismissRequest");
        kotlin.jvm.internal.p.i(onBlankTapRequest, "onBlankTapRequest");
        this.context = context;
        this.wakeRoot = wakeRoot;
        this.panelView = panelView;
        this.inputView = inputView;
        this.chipHost = viewGroup;
        this.onSubmitSuccess = onSubmitSuccess;
        this.onDismissRequest = onDismissRequest;
        this.onBlankTapRequest = onBlankTapRequest;
        this._mode = G.b.INSTANCE;
        this.chipBlurHandles = new ArrayList();
        this.chipGlassCacheTargets = new ArrayList();
        this.dragGlassCache = new B();
        this.density = context.getResources().getDisplayMetrics().density;
        this.guideManager = new F(context);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        this.screenshotClient = new ScreenshotClient(applicationContext);
        this.scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c()));
        this.coalescedCaptureRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.r
            @Override // java.lang.Runnable
            public final void run() {
                CircleSelectController.g0(this.f26728a);
            }
        };
        this.updateOverlayBoundsRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.s
            @Override // java.lang.Runnable
            public final void run() {
                CircleSelectController.c1(this.f26729a);
            }
        };
        this.inputViewLayoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.wake.circle.t
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                CircleSelectController.G0(this.f26730a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
    }

    public static final Y8.t A() {
        return Y8.t.f7040a;
    }

    public static final void G0(CircleSelectController circleSelectController, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i17 - i15;
        int i19 = i13 - i11;
        if (i18 == i19 || !circleSelectController.H0()) {
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("inputView height changed: %d -> %d, updating overlay bounds (delayed)", Arrays.copyOf(new Object[]{Integer.valueOf(i18), Integer.valueOf(i19)}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        circleSelectController.inputView.removeCallbacks(circleSelectController.updateOverlayBoundsRunnable);
        circleSelectController.inputView.postDelayed(circleSelectController.updateOverlayBoundsRunnable, 350L);
    }

    public static final void J0(CircleSelectController circleSelectController) {
        circleSelectController.A0();
    }

    public static final void Y0(CircleSelectController circleSelectController, View view) {
        C4148a.d(TAG, "closeButton clicked: dismissing circle select", false, 4, null);
        circleSelectController.S0(ChatTracker.TRIGGER_CLOSE_BUTTON);
        circleSelectController.onDismissRequest.invoke();
    }

    public static final Y8.t Z(CircleSelectController circleSelectController) {
        circleSelectController.S0("guard_triggered");
        circleSelectController.B0();
        return Y8.t.f7040a;
    }

    public static final Y8.t a0(CircleSelectController circleSelectController) {
        circleSelectController.B0();
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(CircleSelectController circleSelectController) {
        if (circleSelectController.H0()) {
            C4148a.d(TAG, "onInputActivated: user interacted with inputView, exiting circle select", false, 4, null);
            circleSelectController.S0("inputview_action");
            circleSelectController.B0();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t c0(CircleSelectController circleSelectController) {
        if (kotlin.jvm.internal.p.d(circleSelectController._mode, G.c.INSTANCE)) {
            C4148a.d(TAG, "onImagesEmpty: region image removed, hiding chips", false, 4, null);
            circleSelectController.F0();
        }
        return Y8.t.f7040a;
    }

    public static final void c1(CircleSelectController circleSelectController) {
        if (circleSelectController.H0()) {
            circleSelectController.b1();
        }
    }

    public static final Y8.t d0(CircleSelectController circleSelectController) {
        if (circleSelectController.H0()) {
            C4148a.d(TAG, "onManualFilesAdded: user added files via '+' button, exiting circle select", false, 4, null);
            circleSelectController.S0("add_button");
            circleSelectController.B0();
        }
        return Y8.t.f7040a;
    }

    public static final void e1(CircleSelectController circleSelectController, View view) {
        String string = circleSelectController.context.getString(R$string.circle_select_what_is_this);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        N.a("screen_circle_vipcase_click", TRACKER_PAGE_NAME, kotlin.collections.a.m(Y8.j.a("title", string), Y8.j.a("recommend_id", "1")));
        circleSelectController.L0(string);
    }

    public static final void f1(CircleSelectController circleSelectController, View view) {
        String string = circleSelectController.context.getString(R$string.circle_select_image_describe);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        N.a("screen_circle_vipcase_click", TRACKER_PAGE_NAME, kotlin.collections.a.m(Y8.j.a("title", string), Y8.j.a("recommend_id", "2")));
        circleSelectController.L0(string);
    }

    public static final void g0(CircleSelectController circleSelectController) {
        circleSelectController.A0();
    }

    public static final void g1(CircleSelectController circleSelectController, View view) {
        String string = circleSelectController.context.getString(R$string.circle_select_image_caption);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        N.a("screen_circle_vipcase_click", TRACKER_PAGE_NAME, kotlin.collections.a.m(Y8.j.a("title", string), Y8.j.a("recommend_id", "3")));
        circleSelectController.L0(string);
    }

    public static final void h1(View view, CircleSelectController circleSelectController, List list) {
        if (view.isAttachedToWindow()) {
            circleSelectController.e0(list);
        }
    }

    public static final Float n0(CircleSelectController circleSelectController, J j10) {
        return circleSelectController.h0(j10);
    }

    public static final Y8.t o0(CircleSelectController circleSelectController, RectF rect) {
        kotlin.jvm.internal.p.i(rect, "rect");
        circleSelectController.K0(rect);
        return Y8.t.f7040a;
    }

    public static final Y8.t q0(CircleSelectController circleSelectController, RectF newRect) {
        kotlin.jvm.internal.p.i(newRect, "newRect");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onRectChanged: new=[%.0f,%.0f,%.0f,%.0f] (%.0fx%.0f)", Arrays.copyOf(new Object[]{Float.valueOf(newRect.left), Float.valueOf(newRect.top), Float.valueOf(newRect.right), Float.valueOf(newRect.bottom), Float.valueOf(newRect.width()), Float.valueOf(newRect.height())}, 6));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        circleSelectController.currentRect = newRect;
        N.a("screen_circle_switch", TRACKER_PAGE_NAME, kotlin.collections.a.i());
        circleSelectController.T0(newRect);
        return Y8.t.f7040a;
    }

    public static final Y8.t r0(CircleSelectController circleSelectController) {
        circleSelectController.E0();
        return Y8.t.f7040a;
    }

    public static final Y8.t s0(CircleSelectController circleSelectController, boolean z10) {
        if (z10) {
            circleSelectController.dragGlassCache.b(Z8.F.S0(C1173v.q(circleSelectController.inputView.J5()), circleSelectController.chipGlassCacheTargets));
        } else {
            circleSelectController.dragGlassCache.c();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t u0(boolean z10) {
        isTouchInProgress = z10;
        return Y8.t.f7040a;
    }

    public static final Y8.t v0(CircleSelectController circleSelectController) {
        isStrokeInProgress = true;
        keyboardSuppressedForStroke = true;
        circleSelectController.inputView.N8();
        circleSelectController.guideManager.h();
        C4148a.d(TAG, "onDrawStarted: keep voice session, collapsing keyboard", false, 4, null);
        circleSelectController.inputView.n6();
        N.a(ChatTracker.SEND_SCREEN_CLICK, TRACKER_PAGE_NAME, kotlin.collections.a.i());
        return Y8.t.f7040a;
    }

    public static final Y8.t w0(CircleSelectController circleSelectController) {
        View view = circleSelectController.drawingScrimView;
        if (view != null) {
            view.setVisibility(8);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t x0(CircleSelectController circleSelectController) {
        C4148a.d(TAG, "onTapped: user tapped blank area in drawing mode, dismissing", false, 4, null);
        circleSelectController.S0("tap_blank");
        circleSelectController.onBlankTapRequest.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t z() {
        return Y8.t.f7040a;
    }

    public final void A0() {
        RectF rectF = this.pendingCaptureRect;
        if (rectF == null) {
            return;
        }
        this.pendingCaptureRect = null;
        T0(rectF);
    }

    public final void B0() {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        boolean zH0 = H0();
        this.chipRevealGeneration++;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("forceReset: mode=%s, latestUri=%s", Arrays.copyOf(new Object[]{this._mode, this.latestCapturedUri}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        this.dragGlassCache.c();
        this.inputView.removeCallbacks(this.updateOverlayBoundsRunnable);
        isAnyActive = false;
        this.inputView.setCircleSelectTouchActive$chat_release(false);
        isStrokeInProgress = false;
        isTouchInProgress = false;
        keyboardSuppressedForStroke = false;
        onDismissFromGuard = null;
        onSessionCancel = null;
        this.guideManager.o();
        kotlinx.coroutines.g gVar = this.captureJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.captureJob = null;
        kotlinx.coroutines.g gVar2 = this.safetyReviewJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.safetyReviewJob = null;
        this.safetyBlocked = false;
        this.latestCapturedUri = null;
        this.wakeRoot.removeCallbacks(this.coalescedCaptureRunnable);
        this.pendingCaptureRect = null;
        this.captureInflight = false;
        this.lastCapturedRectPx = null;
        this.lastCaptureTsMs = 0L;
        O0();
        P0();
        this._mode = G.b.INSTANCE;
        this.currentRect = null;
        this.inputView.setOnInputActivated(null);
        this.inputView.setOnImagesEmpty(null);
        this.inputView.setOnManualFilesAdded(null);
        this.inputView.removeOnLayoutChangeListener(this.inputViewLayoutListener);
        if (!zH0 || (interfaceC5063a = onDeactivatedForWake) == null) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public final int C0() {
        if (this.inputView.getHeight() == 0 || this.wakeRoot.getHeight() == 0) {
            return 0;
        }
        int[] iArr = new int[2];
        this.inputView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        this.wakeRoot.getLocationInWindow(iArr2);
        return C5685n.f(iArr[1] - iArr2[1], 0);
    }

    public final boolean D0() {
        if (!H0()) {
            return false;
        }
        S0("swipe_back");
        this.onDismissRequest.invoke();
        return true;
    }

    public final void E0() {
        if (kotlin.jvm.internal.p.d(this._mode, G.c.INSTANCE)) {
            S0("tap_blank");
            this.onBlankTapRequest.invoke();
        }
    }

    public final void F0() {
        View view = this.chipsContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup = this.chipHost;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean H0() {
        return !(this._mode instanceof G.b);
    }

    public final void I0() {
        if (this.pendingCaptureRect == null) {
            return;
        }
        this.wakeRoot.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.f
            @Override // java.lang.Runnable
            public final void run() {
                CircleSelectController.J0(this.f26717a);
            }
        });
    }

    public final void K0(RectF rect) {
        isStrokeInProgress = false;
        if (kotlin.jvm.internal.p.d(this._mode, G.a.INSTANCE)) {
            y0(rect);
        }
    }

    public final void L0(String question) {
        kotlin.jvm.internal.p.i(question, "question");
        if (kotlin.jvm.internal.p.d(this._mode, G.c.INSTANCE)) {
            if (this.safetyBlocked) {
                C4148a.u(TAG, "onQuestionSubmitted: blocked by safety review", false, 4, null);
                Toast.makeText(this.context, R$string.upload_risk_failed, 0).show();
                return;
            }
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("onQuestionSubmitted: question='%s', sending via inputView", Arrays.copyOf(new Object[]{question}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            B0();
            this.inputView.Va(question);
            this.onSubmitSuccess.invoke();
        }
    }

    public final ScreenRegion M0(RectF rect) {
        return new ScreenRegion(new ScreenPoint((int) rect.left, (int) rect.top), new ScreenPoint((int) rect.right, (int) rect.top), new ScreenPoint((int) rect.right, (int) rect.bottom), new ScreenPoint((int) rect.left, (int) rect.bottom));
    }

    public final void N0() {
        C4148a.d(TAG, "release", false, 4, null);
        B0();
        O0();
        this.screenshotClient.i();
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }

    public final void O0() {
        this.dragGlassCache.c();
        this.chipGlassCacheTargets.clear();
        Iterator<T> it = this.chipBlurHandles.iterator();
        while (it.hasNext()) {
            ((y7.E) it.next()).g();
        }
        this.chipBlurHandles.clear();
    }

    public final void P0() {
        J j10 = this.freehandDrawView;
        if (j10 != null) {
            this.wakeRoot.removeView(j10);
        }
        this.freehandDrawView = null;
        View view = this.drawingScrimView;
        if (view != null) {
            this.wakeRoot.removeView(view);
        }
        this.drawingScrimView = null;
        SelectionOverlayView selectionOverlayView = this.selectionOverlayView;
        if (selectionOverlayView != null) {
            this.wakeRoot.removeView(selectionOverlayView);
        }
        this.selectionOverlayView = null;
        View view2 = this.chipsContainer;
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
        }
        this.chipsContainer = null;
        ViewGroup viewGroup2 = this.chipHost;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        Q0();
    }

    public final void Q0() {
        View view = this.closeButton;
        if (view != null) {
            this.wakeRoot.removeView(view);
        }
        this.closeButton = null;
    }

    public final void R0() {
        SelectionOverlayView selectionOverlayView = this.selectionOverlayView;
        if (selectionOverlayView != null) {
            this.wakeRoot.removeView(selectionOverlayView);
        }
        this.selectionOverlayView = null;
        F0();
    }

    public final void S0(String type) {
        N.a("screen_circle_exit", TRACKER_PAGE_NAME, Q.f(Y8.j.a("quit_type", type)));
    }

    public final void T0(RectF rect) {
        Rect rectZ0 = Z0(rect);
        if (!this.captureInflight && kotlin.jvm.internal.p.d(rectZ0, this.lastCapturedRectPx)) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("requestCapture: skip same rect %s (already captured)", Arrays.copyOf(new Object[]{rectZ0}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            return;
        }
        if (this.captureInflight) {
            RectF rectF = new RectF(rect);
            this.pendingCaptureRect = rectF;
            kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
            String str2 = String.format("requestCapture: inflight, coalesce pending=%s", Arrays.copyOf(new Object[]{rectF}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.d(TAG, str2, false, 4, null);
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.lastCaptureTsMs;
        if (jElapsedRealtime >= 120) {
            k0(rect);
            return;
        }
        this.pendingCaptureRect = new RectF(rect);
        this.wakeRoot.removeCallbacks(this.coalescedCaptureRunnable);
        long j10 = 120 - jElapsedRealtime;
        this.wakeRoot.postDelayed(this.coalescedCaptureRunnable, j10);
        kotlin.jvm.internal.y yVar3 = kotlin.jvm.internal.y.f34840a;
        String str3 = String.format("requestCapture: throttled, fire pending in %dms", Arrays.copyOf(new Object[]{Long.valueOf(j10)}, 1));
        kotlin.jvm.internal.p.h(str3, "format(...)");
        C4148a.d(TAG, str3, false, 4, null);
    }

    public final void U0() {
        int i10 = this.chipRevealGeneration + 1;
        this.chipRevealGeneration = i10;
        BaseInputView baseInputView = this.inputView;
        if (!baseInputView.isLaidOut() || baseInputView.isLayoutRequested()) {
            baseInputView.addOnLayoutChangeListener(new b(i10));
        } else {
            this.inputView.post(new c(i10, this));
        }
    }

    public final boolean V0() {
        return H0() && keyboardSuppressedForStroke;
    }

    public final void W0() {
        if (this.chipsContainer == null) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.context);
            ViewGroup viewGroup = this.chipHost;
            if (viewGroup != null) {
                View viewInflate = layoutInflaterFrom.inflate(R$layout.layout_circle_select_chips, viewGroup, false);
                viewGroup.addView(viewInflate);
                kotlin.jvm.internal.p.f(viewInflate);
                d1(viewInflate);
                this.chipsContainer = viewInflate;
            } else {
                View viewInflate2 = layoutInflaterFrom.inflate(R$layout.layout_circle_select_chips, this.wakeRoot, false);
                ConstraintLayout.b bVar = new ConstraintLayout.b(0, -2);
                bVar.f12664t = 0;
                bVar.f12668v = 0;
                bVar.f12648l = 0;
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = f0() + ((int) (12 * this.density));
                this.wakeRoot.addView(viewInflate2, bVar);
                kotlin.jvm.internal.p.f(viewInflate2);
                d1(viewInflate2);
                this.chipsContainer = viewInflate2;
            }
        }
        ViewGroup viewGroup2 = this.chipHost;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        View view = this.chipsContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        a1();
        N.a("screen_circle_vipcase_expose", TRACKER_PAGE_NAME, kotlin.collections.a.i());
    }

    public final void X0() {
        if (this.closeButton != null) {
            return;
        }
        int i10 = (int) (32 * this.density);
        ImageView imageView = new ImageView(this.context);
        imageView.setImageResource(R$drawable.ic_circle_select_close);
        imageView.setBackgroundResource(R$drawable.bg_circle_select_close);
        int i11 = (int) (4 * this.density);
        imageView.setPadding(i11, i11, i11, i11);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.circle.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleSelectController.Y0(this.f26724a, view);
            }
        });
        ConstraintLayout.b bVar = new ConstraintLayout.b(i10, i10);
        bVar.f12642i = 0;
        bVar.f12668v = 0;
        float f10 = this.density;
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = (int) (52 * f10);
        bVar.setMarginEnd((int) (20 * f10));
        this.wakeRoot.addView(imageView, bVar);
        this.closeButton = imageView;
    }

    public final void Y() {
        if (sessionCancelled) {
            C4148a.d(TAG, "activate: session cancelled (AI key held into push-to-talk), skip", false, 4, null);
            return;
        }
        if (kotlin.jvm.internal.p.d(this._mode, G.b.INSTANCE)) {
            isAnyActive = true;
            this.inputView.setCircleSelectTouchActive$chat_release(true);
            keyboardSuppressedForStroke = false;
            onDismissFromGuard = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.u
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CircleSelectController.Z(this.f26731a);
                }
            };
            onSessionCancel = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.v
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CircleSelectController.a0(this.f26732a);
                }
            };
            this.inputView.setOnInputActivated(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.w
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CircleSelectController.b0(this.f26733a);
                }
            });
            this.inputView.setOnImagesEmpty(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.x
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CircleSelectController.c0(this.f26734a);
                }
            });
            this.inputView.setOnManualFilesAdded(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.y
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CircleSelectController.d0(this.f26735a);
                }
            });
            this.inputView.addOnLayoutChangeListener(this.inputViewLayoutListener);
            t0();
        }
    }

    public final Rect Z0(RectF rectF) {
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public final void a1() {
        View view;
        int iF0;
        if (this.chipHost == null && (view = this.chipsContainer) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar == null || ((ViewGroup.MarginLayoutParams) bVar).bottomMargin == (iF0 = f0() + ((int) (12 * this.density)))) {
                return;
            }
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = iF0;
            view.requestLayout();
        }
    }

    public final void b1() {
        a1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d1(final View container) {
        final List listP = C1173v.p(container.findViewById(R$id.chip_what_is_this), container.findViewById(R$id.chip_describe_image), container.findViewById(R$id.chip_caption));
        TextView textView = (TextView) listP.get(0);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.circle.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleSelectController.e1(this.f26711a, view);
                }
            });
        }
        TextView textView2 = (TextView) listP.get(1);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.circle.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleSelectController.f1(this.f26712a, view);
                }
            });
        }
        TextView textView3 = (TextView) listP.get(2);
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.circle.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleSelectController.g1(this.f26713a, view);
                }
            });
        }
        container.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.e
            @Override // java.lang.Runnable
            public final void run() {
                CircleSelectController.h1(container, this, listP);
            }
        });
    }

    public final void e0(List<? extends View> chipViews) {
        y7.E eU;
        O0();
        int i10 = (int) (21 * this.density);
        for (View view : chipViews) {
            if (view != null && (eU = y7.H.a(s7.p.f40121a, view).x(true).w(i10).i(y7.o.INSTANCE.h()).u()) != null && eU.c() > 0) {
                this.chipBlurHandles.add(eU);
                if (eU.d().contains("glass_refraction")) {
                    this.chipGlassCacheTargets.add(view);
                }
            }
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("applyChipBlur: %d handles active", Arrays.copyOf(new Object[]{Integer.valueOf(this.chipBlurHandles.size())}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final int f0() {
        int iC0 = C0();
        return iC0 <= 0 ? this.inputView.getHeight() : C5685n.f((this.wakeRoot.getHeight() - this.wakeRoot.getPaddingBottom()) - iC0, 0);
    }

    public final Float h0(View freehandView) {
        if (this.inputView.getHeight() == 0) {
            return null;
        }
        int[] iArr = new int[2];
        this.inputView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        freehandView.getLocationInWindow(iArr2);
        float f10 = iArr[1] - iArr2[1];
        if (f10 <= 0.0f || f10 >= freehandView.getHeight()) {
            return null;
        }
        return Float.valueOf(f10);
    }

    public final ConstraintLayout.b i0() {
        ConstraintLayout.b bVar = new ConstraintLayout.b(0, 0);
        bVar.f12664t = 0;
        bVar.f12668v = 0;
        bVar.f12642i = 0;
        bVar.f12648l = 0;
        return bVar;
    }

    public final ConstraintLayout.b j0() {
        ConstraintLayout.b bVar = new ConstraintLayout.b(0, 0);
        bVar.f12664t = 0;
        bVar.f12668v = 0;
        bVar.f12642i = 0;
        bVar.f12648l = 0;
        return bVar;
    }

    public final void k0(RectF rect) {
        this.inputView.H5();
        kotlinx.coroutines.g gVar = this.captureJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.captureInflight = true;
        this.lastCaptureTsMs = SystemClock.elapsedRealtime();
        int i10 = this.captureRequestCount + 1;
        this.captureRequestCount = i10;
        ScreenRegion screenRegionM0 = M0(rect);
        long jG = WakeService.INSTANCE.C0().g();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("requestCapture #%d: rect=[%.0f,%.0f,%.0f,%.0f] -> region topLeft=(%d,%d) bottomRight=(%d,%d)", Arrays.copyOf(new Object[]{Integer.valueOf(i10), Float.valueOf(rect.left), Float.valueOf(rect.top), Float.valueOf(rect.right), Float.valueOf(rect.bottom), Integer.valueOf(screenRegionM0.getTopLeft().getX()), Integer.valueOf(screenRegionM0.getTopLeft().getY()), Integer.valueOf(screenRegionM0.getBottomRight().getX()), Integer.valueOf(screenRegionM0.getBottomRight().getY())}, 9));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        this.captureJob = C1060i.d(this.scope, null, null, new CircleSelectController$doCapture$1(this, screenRegionM0, i10, rect, jG, null), 3, null);
    }

    public final View l0() {
        View view = this.drawingScrimView;
        if (view != null) {
            return view;
        }
        View view2 = new View(this.context);
        view2.setLayoutParams(j0());
        view2.setBackgroundColor(855638016);
        this.drawingScrimView = view2;
        this.wakeRoot.addView(view2, z0());
        return view2;
    }

    public final J m0() {
        J j10 = this.freehandDrawView;
        if (j10 != null) {
            return j10;
        }
        final J j11 = new J(this.context, null, 0, 6, null);
        j11.setLayoutParams(i0());
        C4148a.d(TAG, "ensureFreehandView: fullscreen, exclude inputView zone dynamically", false, 4, null);
        j11.setExcludeTopProvider(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CircleSelectController.n0(this.f26721a, j11);
            }
        });
        j11.setOnFreehandComplete(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.circle.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CircleSelectController.o0(this.f26723a, (RectF) obj);
            }
        });
        this.freehandDrawView = j11;
        int iZ0 = z0() + 1;
        ViewGroup viewGroup = this.wakeRoot;
        viewGroup.addView(j11, C5685n.j(iZ0, viewGroup.getChildCount()));
        return j11;
    }

    public final SelectionOverlayView p0() {
        SelectionOverlayView selectionOverlayView = this.selectionOverlayView;
        if (selectionOverlayView != null) {
            return selectionOverlayView;
        }
        SelectionOverlayView selectionOverlayView2 = new SelectionOverlayView(this.context, null, 0, 6, null);
        selectionOverlayView2.setLayoutParams(j0());
        C4148a.d(TAG, "ensureSelectionOverlay: fullscreen overlay", false, 4, null);
        selectionOverlayView2.setOnRectChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.circle.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CircleSelectController.q0(this.f26725a, (RectF) obj);
            }
        });
        selectionOverlayView2.setOnBlankTapped(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CircleSelectController.r0(this.f26726a);
            }
        });
        selectionOverlayView2.setOnDragStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.circle.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CircleSelectController.s0(this.f26727a, ((Boolean) obj).booleanValue());
            }
        });
        this.selectionOverlayView = selectionOverlayView2;
        this.wakeRoot.addView(selectionOverlayView2, z0());
        return selectionOverlayView2;
    }

    public final void t0() {
        this._mode = G.a.INSTANCE;
        C4148a.d(TAG, "enterDrawing", false, 4, null);
        R0();
        l0().setVisibility(0);
        J jM0 = m0();
        jM0.setVisibility(0);
        jM0.setOnTouchInProgressChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.circle.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CircleSelectController.u0(((Boolean) obj).booleanValue());
            }
        });
        jM0.setOnDrawStarted(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CircleSelectController.v0(this.f26718a);
            }
        });
        jM0.setOnStrokeFinished(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CircleSelectController.w0(this.f26719a);
            }
        });
        jM0.setOnTapped(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CircleSelectController.x0(this.f26720a);
            }
        });
        X0();
        this.guideManager.p(this.wakeRoot);
    }

    public final void y0(RectF rect) {
        this._mode = G.c.INSTANCE;
        this.currentRect = rect;
        C4148a.d(TAG, "enterLocked: " + rect, false, 4, null);
        J j10 = this.freehandDrawView;
        if (j10 != null) {
            j10.setVisibility(8);
        }
        SelectionOverlayView selectionOverlayViewP0 = p0();
        selectionOverlayViewP0.setSelectionRect(rect);
        selectionOverlayViewP0.setVisibility(0);
        View view = this.closeButton;
        if (view != null) {
            view.bringToFront();
        }
        T0(rect);
    }

    public final int z0() {
        int iIndexOfChild = this.wakeRoot.indexOfChild(this.panelView);
        return iIndexOfChild >= 0 ? iIndexOfChild : this.wakeRoot.getChildCount();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CircleSelectController(Context context, ViewGroup viewGroup, View view, BaseInputView baseInputView, ViewGroup viewGroup2, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5063a interfaceC5063a3, int i10, kotlin.jvm.internal.i iVar) {
        ViewGroup viewGroup3 = (i10 & 16) != 0 ? null : viewGroup2;
        InterfaceC5063a interfaceC5063a4 = (i10 & 32) != 0 ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CircleSelectController.z();
            }
        } : interfaceC5063a;
        InterfaceC5063a interfaceC5063a5 = (i10 & 64) != 0 ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.circle.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CircleSelectController.A();
            }
        } : interfaceC5063a2;
        this(context, viewGroup, view, baseInputView, viewGroup3, interfaceC5063a4, interfaceC5063a5, (i10 & 128) != 0 ? interfaceC5063a5 : interfaceC5063a3);
    }
}
