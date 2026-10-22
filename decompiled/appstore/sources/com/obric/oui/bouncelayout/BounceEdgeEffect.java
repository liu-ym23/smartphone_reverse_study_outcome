package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.orecyclerview.base.d;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lsposed.hiddenapibypass.HiddenApiBypass;
import yf.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u008a\u0001\u008b\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010\"\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010\u0016J\u0017\u0010)\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010\u0016J'\u0010+\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b-\u0010\u001eJ\u0017\u0010/\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u00109J'\u0010;\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010:\u001a\u00020\u001bH\u0002¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u000fH\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u00100J(\u0010E\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u001b2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001b0CH\u0082\b¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\bH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\bH\u0002¢\u0006\u0004\bI\u0010HJ\u000f\u0010J\u001a\u00020\u0018H\u0002¢\u0006\u0004\bJ\u0010KJ\u0013\u0010L\u001a\u00020\b*\u00020\bH\u0002¢\u0006\u0004\bL\u00104J\u0013\u0010M\u001a\u00020\b*\u00020\bH\u0002¢\u0006\u0004\bM\u00104J\u0015\u0010O\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\b¢\u0006\u0004\bO\u00100J\r\u0010P\u001a\u00020\u0018¢\u0006\u0004\bP\u0010KJ\u0015\u0010R\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u000f¢\u0006\u0004\bR\u0010SJ\u001f\u0010V\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0006H\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\bX\u00100J\u001f\u0010X\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\bH\u0016¢\u0006\u0004\bX\u0010ZJ\u000f\u0010[\u001a\u00020\bH\u0016¢\u0006\u0004\b[\u0010HJ\u001f\u0010\\\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\bH\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0018H\u0016¢\u0006\u0004\b^\u0010KJ\u0017\u0010`\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u0006H\u0016¢\u0006\u0004\b`\u0010aJ\u0017\u0010d\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020bH\u0016¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u000fH\u0016¢\u0006\u0004\bf\u00106J\u000f\u0010g\u001a\u00020\u0018H\u0016¢\u0006\u0004\bg\u0010KR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010hR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010iR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010j\u001a\u0004\bk\u0010H\"\u0004\bl\u00100R\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0016\u0010n\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR*\u0010p\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010j\u001a\u0004\bq\u0010H\"\u0004\b>\u00100R0\u0010s\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0016\u0010y\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010jR\u0016\u0010z\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010jR\u0016\u0010{\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010oR\u0016\u0010|\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010jR\u0016\u0010}\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010oR\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0081\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\"\u0010\u0085\u0001\u001a\r \u0084\u0001*\u0005\u0018\u00010\u0083\u00010\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010jR\u0017\u0010&\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b&\u0010\u0082\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010jR\u0019\u0010\u0089\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0082\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "Landroid/widget/EdgeEffect;", "Landroid/content/Context;", "context", "Landroid/view/View;", "target", "", "orientation", "", "maxOverscrollPx", "<init>", "(Landroid/content/Context;Landroid/view/View;IF)V", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "targetState", "()Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "", "isVerticalOrientation", "(I)Z", "otherOrientation", "isSameAxis", WsConstants.KEY_CONNECTION_STATE, "getActiveOrientation", "(Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;)I", CommonKey.KEY_VALUE, "", "setActiveOrientation", "(Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;I)V", "", "reason", "markActiveOrientation", "(Ljava/lang/String;)V", "clearActiveOrientationIfCurrent", "", "now", "recordReleaseFrame", "(Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;J)V", "wasOppositeReleasedInSameFrame", "(Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;J)Z", "lastPullTime", "(Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;)J", "lastPullOrientation", "lastPullSign", "deltaPx", "recordPullFrame", "(Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;JF)V", "resetInactiveReleaseState", "deltaDistance", "ensurePullMultiplier", "(F)V", "isPulling", "(F)Z", "getDeltaPx", "(F)F", "isUnscrollableOnCurrentAxis", "()Z", "targetAccumulated", "shouldIgnoreAbruptOppositeDelta", "(FF)Z", "reasonPrefix", "shouldSkipPullInCurrentFrame", "(FJLjava/lang/String;)Z", "trackReleaseVelocity", "setTranslation", "(FZ)V", "newTranslation", "updateReleaseVelocity", "operation", "Lkotlin/Function0;", "messageProvider", "logFrame", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getCurrentFrameIntervalMs", "()F", "getReleaseVelocityPxPerMs", "resetReleaseVelocityTracker", "()V", "px", "dp", "deltaX", "updateTouchDeltaX", "stopAnimationForTouch", "enable", "setUseHeightForHorizontalSize", "(Z)V", Style.KEY_WIDTH, Style.KEY_HEIGHT, "setSize", "(II)V", "onPull", "displacement", "(FF)V", "getDistance", "onPullDistance", "(FF)F", "onRelease", "velocity", "onAbsorb", "(I)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)Z", "isFinished", "finish", "Landroid/view/View;", "I", "F", "getMaxOverscrollPx", "setMaxOverscrollPx", "sizePx", "useHeightForHorizontalSize", "Z", "translation", "getTranslation", "Lkotlin/Function1;", "onTranslationChanged", "Lkotlin/jvm/functions/Function1;", "getOnTranslationChanged", "()Lkotlin/jvm/functions/Function1;", "setOnTranslationChanged", "(Lkotlin/jvm/functions/Function1;)V", "accumulatedDragDistance", "pullMultiplier", "pullMultiplierInitialized", "lastTouchDeltaX", "abruptOppositeDeltaGuardArmed", "Lcom/obric/oui/orecyclerview/base/d;", "springBack", "Lcom/obric/oui/orecyclerview/base/d;", "animationStartTime", "J", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "displayMetrics", "Landroid/util/DisplayMetrics;", "lastPullTranslation", "releaseVelocityPxPerMs", "releaseVelocityTime", "Companion", "Orientation", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceEdgeEffect extends EdgeEffect {

    @NotNull
    public static final Companion Companion = null;
    private static final float MAX_RELEASE_VELOCITY_PX_PER_MS = 20.0f;
    public static final int ORIENTATION_BOTTOM = 1;
    public static final int ORIENTATION_LEFT = 2;
    private static final int ORIENTATION_NONE = -1;
    public static final int ORIENTATION_RIGHT = 3;
    public static final int ORIENTATION_TOP = 0;
    private static final long RELEASE_VELOCITY_VALID_MS = 120;

    @NotNull
    public static final String TAG = "BounceEdgeEffect";

    @NotNull
    private static final WeakHashMap<View, Companion.TargetBounceState> targetStates = null;
    private boolean abruptOppositeDeltaGuardArmed;
    private float accumulatedDragDistance;
    private long animationStartTime;
    private final DisplayMetrics displayMetrics;
    private long lastPullTime;
    private float lastPullTranslation;
    private float lastTouchDeltaX;
    private float maxOverscrollPx;

    @Nullable
    private Function1<? super Float, Unit> onTranslationChanged;
    private final int orientation;
    private float pullMultiplier;
    private boolean pullMultiplierInitialized;
    private float releaseVelocityPxPerMs;
    private long releaseVelocityTime;
    private int sizePx;

    @Nullable
    private d springBack;

    @NotNull
    private final View target;
    private float translation;
    private boolean useHeightForHorizontalSize;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion;", "", "()V", "MAX_RELEASE_VELOCITY_PX_PER_MS", "", "ORIENTATION_BOTTOM", "", "ORIENTATION_LEFT", "ORIENTATION_NONE", "ORIENTATION_RIGHT", "ORIENTATION_TOP", "RELEASE_VELOCITY_VALID_MS", "", "TAG", "", "targetStates", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "bypassHiddenApi", "", "signature", "TargetBounceState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001a\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017¨\u0006-"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "", "()V", "activeHorizontalOrientation", "", "getActiveHorizontalOrientation", "()I", "setActiveHorizontalOrientation", "(I)V", "activeVerticalOrientation", "getActiveVerticalOrientation", "setActiveVerticalOrientation", "lastHorizontalPullOrientation", "getLastHorizontalPullOrientation", "setLastHorizontalPullOrientation", "lastHorizontalPullSign", "getLastHorizontalPullSign", "setLastHorizontalPullSign", "lastHorizontalPullTime", "", "getLastHorizontalPullTime", "()J", "setLastHorizontalPullTime", "(J)V", "lastHorizontalReleaseOrientation", "getLastHorizontalReleaseOrientation", "setLastHorizontalReleaseOrientation", "lastHorizontalReleaseTime", "getLastHorizontalReleaseTime", "setLastHorizontalReleaseTime", "lastVerticalPullOrientation", "getLastVerticalPullOrientation", "setLastVerticalPullOrientation", "lastVerticalPullSign", "getLastVerticalPullSign", "setLastVerticalPullSign", "lastVerticalPullTime", "getLastVerticalPullTime", "setLastVerticalPullTime", "lastVerticalReleaseOrientation", "getLastVerticalReleaseOrientation", "setLastVerticalReleaseOrientation", "lastVerticalReleaseTime", "getLastVerticalReleaseTime", "setLastVerticalReleaseTime", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class TargetBounceState {
            private int activeHorizontalOrientation;
            private int activeVerticalOrientation;
            private int lastHorizontalPullOrientation;
            private int lastHorizontalPullSign;
            private long lastHorizontalPullTime;
            private int lastHorizontalReleaseOrientation;
            private long lastHorizontalReleaseTime;
            private int lastVerticalPullOrientation;
            private int lastVerticalPullSign;
            private long lastVerticalPullTime;
            private int lastVerticalReleaseOrientation;
            private long lastVerticalReleaseTime;

            public TargetBounceState() {
                this.activeVerticalOrientation = -1;
                this.activeHorizontalOrientation = -1;
                this.lastVerticalReleaseTime = -1;
                this.lastVerticalReleaseOrientation = -1;
                this.lastHorizontalReleaseTime = -1;
                this.lastHorizontalReleaseOrientation = -1;
                this.lastVerticalPullTime = -1;
                this.lastVerticalPullOrientation = -1;
                this.lastHorizontalPullTime = -1;
                this.lastHorizontalPullOrientation = -1;
            }

            public final int getActiveHorizontalOrientation() {
                return this.activeHorizontalOrientation;
            }

            public final int getActiveVerticalOrientation() {
                return this.activeVerticalOrientation;
            }

            public final int getLastHorizontalPullOrientation() {
                return this.lastHorizontalPullOrientation;
            }

            public final int getLastHorizontalPullSign() {
                return this.lastHorizontalPullSign;
            }

            public final long getLastHorizontalPullTime() {
                return this.lastHorizontalPullTime;
            }

            public final int getLastHorizontalReleaseOrientation() {
                return this.lastHorizontalReleaseOrientation;
            }

            public final long getLastHorizontalReleaseTime() {
                return this.lastHorizontalReleaseTime;
            }

            public final int getLastVerticalPullOrientation() {
                return this.lastVerticalPullOrientation;
            }

            public final int getLastVerticalPullSign() {
                return this.lastVerticalPullSign;
            }

            public final long getLastVerticalPullTime() {
                return this.lastVerticalPullTime;
            }

            public final int getLastVerticalReleaseOrientation() {
                return this.lastVerticalReleaseOrientation;
            }

            public final long getLastVerticalReleaseTime() {
                return this.lastVerticalReleaseTime;
            }

            public final void setActiveHorizontalOrientation(int r10) {
                this.activeHorizontalOrientation = r10;
            }

            public final void setActiveVerticalOrientation(int r10) {
                this.activeVerticalOrientation = r10;
            }

            public final void setLastHorizontalPullOrientation(int r10) {
                this.lastHorizontalPullOrientation = r10;
            }

            public final void setLastHorizontalPullSign(int r10) {
                this.lastHorizontalPullSign = r10;
            }

            public final void setLastHorizontalPullTime(long r10) {
                this.lastHorizontalPullTime = r10;
            }

            public final void setLastHorizontalReleaseOrientation(int r10) {
                this.lastHorizontalReleaseOrientation = r10;
            }

            public final void setLastHorizontalReleaseTime(long r10) {
                this.lastHorizontalReleaseTime = r10;
            }

            public final void setLastVerticalPullOrientation(int r10) {
                this.lastVerticalPullOrientation = r10;
            }

            public final void setLastVerticalPullSign(int r10) {
                this.lastVerticalPullSign = r10;
            }

            public final void setLastVerticalPullTime(long r10) {
                this.lastVerticalPullTime = r10;
            }

            public final void setLastVerticalReleaseOrientation(int r10) {
                this.lastVerticalReleaseOrientation = r10;
            }

            public final void setLastVerticalReleaseTime(long r10) {
                this.lastVerticalReleaseTime = r10;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final void bypassHiddenApi(@NotNull String r10) {
            q.g(r10, "signature");
            HiddenApiBypass.addHiddenApiExemptions(new String[]{r10});     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Log.w(BounceEdgeEffect.TAG, q.p("Failed to bypass hidden API restrictions for ", r10), th);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Orientation;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Orientation {
    }

    static {
        Companion = new Companion(null);
        targetStates = new WeakHashMap();
    }

    public BounceEdgeEffect(@NotNull Context r10, @NotNull View r11, int r12, float r13) {
        q.g(r10, "context");
        q.g(r11, "target");
        super(r10);
        this.target = r11;
        this.orientation = r12;
        this.maxOverscrollPx = r13;
        this.pullMultiplier = 1.0f;
        this.abruptOppositeDeltaGuardArmed = true;
        this.animationStartTime = -1;
        this.displayMetrics = r10.getResources().getDisplayMetrics();
        this.lastPullTime = -1;
        this.releaseVelocityTime = -1;
    }

    public static final /* synthetic */ int access$getOrientation$p(BounceEdgeEffect r10) {
        return r10.orientation;
    }

    public static final /* synthetic */ View access$getTarget$p(BounceEdgeEffect r10) {
        return r10.target;
    }

    private final void clearActiveOrientationIfCurrent(String r10) {
        Companion.TargetBounceState r11 = targetState();
        if (getActiveOrientation(r11) != this.orientation) goto L8;
        setActiveOrientation(r11, -1);
        if (BounceDebugLogger.getEnabled() == false) goto L9;
        BounceDebugLogger.log(this.target, "activeEdgeCleared", "orientation=" + this.orientation + " reason=" + r10);
        return;
    L9:
        return;
    }

    private final float dp(float r10) {
        return r10 / this.displayMetrics.density;
    }

    private final void ensurePullMultiplier(float r10) {
        if (this.pullMultiplierInitialized == false) goto L6;
        return;
    L6:
        if (r10 != 0.0f) goto L8;
        return;
    L8:
        View r11 = this.target;
        float r12 = -1.0f;
        if ((r11 instanceof NestedScrollView) == false) goto L16;
        if (this.orientation != 0) goto L16;
        if (r10 < 0.0f) goto L24;
    L14:
        r12 = 1.0f;
    L24:
        this.pullMultiplier = r12;
        this.pullMultiplierInitialized = true;
        return;
    L16:
        if ((r11 instanceof HorizontalScrollView) == false) goto L22;
        if (this.orientation != 2) goto L22;
        if (r10 >= 0.0f) goto L14;
    L22:
        if ((r11 instanceof HorizontalScrollView) == false) goto L14;
        int r13 = this.orientation;
        goto L14
    }

    private final int getActiveOrientation(Companion.TargetBounceState r10) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r10.getActiveVerticalOrientation();
    L6:
        return r10.getActiveHorizontalOrientation();
    }

    private final float getCurrentFrameIntervalMs() {
        Display r10 = this.target.getDisplay();
        WindowManager r11 = null;
        if (r10 != null) goto L5;
        Float r12 = null;
    L7:
        if (r12 != null) goto L17;
        Object r13 = this.target.getContext().getSystemService("window");
        if ((r13 instanceof WindowManager) == false) goto L11;
        r11 = (WindowManager) r13;
    L11:
        if (r11 != null) goto L13;
    L12:
        float r14 = 0.0f;
    L19:
        if (r14 > 0.0f) goto L23;
        return 16.67f;
    L23:
        return 1000.0f / r14;
    L13:
        Display r15 = r11.getDefaultDisplay();
        if (r15 == null) goto L12;
        r14 = r15.getRefreshRate();
        goto L19
    L17:
        r14 = r12.floatValue();
        goto L19
    L5:
        r12 = Float.valueOf(r10.getRefreshRate());
        goto L7
    }

    private final float getDeltaPx(float r10) {
        if ((this.target instanceof HorizontalScrollView) == false) goto L20;
        int r11 = this.orientation;
        if (r11 == 2) goto L7;
        if (r11 != 3) goto L20;
    L7:
        float r12 = Math.abs(r10) * this.sizePx;
        int r13 = this.orientation;
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L12;
        return r12;
    L12:
        if (this.lastTouchDeltaX <= 0.0f) goto L18;
        return r12;
    L18:
        return -r12;
    L15:
        if (this.lastTouchDeltaX >= 0.0f) goto L18;
        return r12;
    L20:
        return (r10 * this.pullMultiplier) * this.sizePx;
    }

    private final float getReleaseVelocityPxPerMs() {
        long r10 = AnimationUtils.currentAnimationTimeMillis();
        long r11 = this.releaseVelocityTime;
        if (r11 != (-1)) goto L5;
    L7:
        return 0.0f;
    L5:
        if ((r10 - r11) > 120) goto L7;
        return this.releaseVelocityPxPerMs;
    }

    private final boolean isPulling(float r10) {
        if (r10 != 0.0f) goto L6;
        return false;
    L6:
        if (this.accumulatedDragDistance <= 0.0f) goto L8;
        return true;
    L8:
        ensurePullMultiplier(r10);
        if (getDeltaPx(r10) > 0.0f) goto L11;
        return false;
    L11:
        int r11 = this.orientation;
        if (r11 == 0) goto L29;
        if (r11 == 1) goto L26;
        if (r11 == 2) goto L23;
        if (r11 == 3) goto L20;
        return false;
    L20:
        if (this.target.canScrollHorizontally(1) == false) goto L32;
        return false;
    L32:
        return true;
    L23:
        if (this.target.canScrollHorizontally(-1) == false) goto L32;
        return false;
    L26:
        if (this.target.canScrollVertically(1) == false) goto L32;
        return false;
    L29:
        if (this.target.canScrollVertically(-1) == false) goto L32;
        return false;
    }

    private final boolean isSameAxis(int r10) {
        if (isVerticalOrientation(this.orientation) == false) goto L8;
        if (r10 == 0) goto L13;
        if (r10 == 1) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L13;
        return false;
    }

    private final boolean isUnscrollableOnCurrentAxis() {
        int r10 = this.orientation;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L12;
        if (this.target.canScrollHorizontally(-1) == false) goto L9;
        return false;
    L9:
        if (this.target.canScrollHorizontally(1) == false) goto L18;
        return false;
    L18:
        return true;
    L12:
        if (this.target.canScrollVertically(-1) == false) goto L14;
        return false;
    L14:
        if (this.target.canScrollVertically(1) == false) goto L18;
        return false;
    }

    private final boolean isVerticalOrientation(int r10) {
        if (r10 == 0) goto L8;
        if (r10 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private final int lastPullOrientation(Companion.TargetBounceState r10) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r10.getLastVerticalPullOrientation();
    L6:
        return r10.getLastHorizontalPullOrientation();
    }

    private final int lastPullSign(Companion.TargetBounceState r10) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r10.getLastVerticalPullSign();
    L6:
        return r10.getLastHorizontalPullSign();
    }

    private final long lastPullTime(Companion.TargetBounceState r10) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r10.getLastVerticalPullTime();
    L6:
        return r10.getLastHorizontalPullTime();
    }

    private final void logFrame(String r10, Function0<String> r11) {
        if (BounceDebugLogger.getEnabled() == false) goto L18;
        float r12 = 0.0f;
        if (access$getOrientation$p(this) != 2) goto L7;
    L10:
        float r13 = getTranslation();
    L12:
        if (access$getOrientation$p(this) != 0) goto L14;
    L15:
        r12 = getTranslation();
    L16:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), r10, r13, r12, r11.invoke());
        return;
    L14:
        if (access$getOrientation$p(this) != 1) goto L16;
    L7:
        if (access$getOrientation$p(this) == 3) goto L10;
        r13 = 0.0f;
        goto L12
    }

    public static /* synthetic */ void logFrame$default(BounceEdgeEffect r10, String r11, Function0 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = AnonymousClass1.INSTANCE;
    L6:
        if (BounceDebugLogger.getEnabled() == false) goto L21;
        float r15 = 0.0f;
        if (access$getOrientation$p(r10) != 2) goto L10;
    L13:
        float r16 = r10.getTranslation();
    L15:
        if (access$getOrientation$p(r10) != 0) goto L17;
    L18:
        r15 = r10.getTranslation();
    L19:
        BounceDebugLogger.logContentFrame(access$getTarget$p(r10), r11, r16, r15, (String) r12.invoke());
        return;
    L17:
        if (access$getOrientation$p(r10) != 1) goto L19;
    L10:
        if (access$getOrientation$p(r10) == 3) goto L13;
        r16 = 0.0f;
        goto L15
    }

    private final void markActiveOrientation(String r10) {
        Companion.TargetBounceState r11 = targetState();
        int r12 = getActiveOrientation(r11);
        int r13 = this.orientation;
        if (r12 == r13) goto L8;
        setActiveOrientation(r11, r13);
        if (BounceDebugLogger.getEnabled() == false) goto L9;
        BounceDebugLogger.log(this.target, "activeEdgeChanged", "from=" + r12 + " to=" + this.orientation + " reason=" + r10);
        return;
    L9:
        return;
    }

    private final float px(float r10) {
        return TypedValue.applyDimension(1, r10, this.displayMetrics);
    }

    private final void recordPullFrame(Companion.TargetBounceState r10, long r11, float r12) {
        int r13 = (int) Math.signum(r12);
        if (r13 != 0) goto L6;
        return;
    L6:
        if (isVerticalOrientation(this.orientation) == false) goto L8;
        r10.setLastVerticalPullTime(r11);
        r10.setLastVerticalPullOrientation(this.orientation);
        r10.setLastVerticalPullSign(r13);
        return;
    L8:
        r10.setLastHorizontalPullTime(r11);
        r10.setLastHorizontalPullOrientation(this.orientation);
        r10.setLastHorizontalPullSign(r13);
    }

    private final void recordReleaseFrame(Companion.TargetBounceState r10, long r11) {
        if (isVerticalOrientation(this.orientation) == false) goto L5;
        r10.setLastVerticalReleaseTime(r11);
        r10.setLastVerticalReleaseOrientation(this.orientation);
        return;
    L5:
        r10.setLastHorizontalReleaseTime(r11);
        r10.setLastHorizontalReleaseOrientation(this.orientation);
    }

    private final void resetInactiveReleaseState(String r10) {
        if (BounceDebugLogger.getEnabled() == false) goto L5;
        BounceDebugLogger.log(this.target, "onReleaseSkipped", "orientation=" + this.orientation + " reason=" + r10 + " translation=" + getTranslation());
    L5:
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        setTranslation(0.0f, false);
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.target.invalidate();
    }

    private final void resetReleaseVelocityTracker() {
        this.lastPullTranslation = this.translation;
        this.lastPullTime = -1;
        this.releaseVelocityPxPerMs = 0.0f;
        this.releaseVelocityTime = -1;
    }

    private final void setActiveOrientation(Companion.TargetBounceState r10, int r11) {
        if (isVerticalOrientation(this.orientation) == false) goto L5;
        r10.setActiveVerticalOrientation(r11);
        return;
    L5:
        r10.setActiveHorizontalOrientation(r11);
    }

    private final void setTranslation(float r10) {
        if (this.translation == r10) goto L10;
        this.translation = r10;
        Function1<? super Float, Unit> r11 = this.onTranslationChanged;
        if (r11 == null) goto L11;
        r11.invoke(Float.valueOf(r10));
        return;
    L11:
        return;
    }

    private final boolean shouldIgnoreAbruptOppositeDelta(float r10, float r11) {
        if (this.accumulatedDragDistance > 0.0f) goto L5;
    L19:
        return false;
    L5:
        if (r10 >= 0.0f) goto L19;
        if (r11 > 0.0f) goto L19;
        if (this.abruptOppositeDeltaGuardArmed == false) goto L19;
        if (isUnscrollableOnCurrentAxis() == false) goto L19;
        this.abruptOppositeDeltaGuardArmed = false;
        if (BounceDebugLogger.getEnabled() == false) goto L20;
        BounceDebugLogger.log(this.target, "oppositeDeltaSkipped", "orientation=" + this.orientation + " deltaPx=" + r10 + " accumulated=" + this.accumulatedDragDistance + " target=" + r11);
        return true;
    L20:
        return true;
    }

    private final boolean shouldSkipPullInCurrentFrame(float r11, long r12, String r14) {
        if (r11 != 0.0f) goto L5;
        return false;
    L5:
        Companion.TargetBounceState r10 = targetState();
        int r13 = getActiveOrientation(r10);
        if (r13 == (-1)) goto L14;
        if (r13 == this.orientation) goto L14;
        if (BounceDebugLogger.getEnabled() == false) goto L12;
        BounceDebugLogger.log(this.target, "onPullSkipped", "orientation=" + this.orientation + " activeOrientation=" + r13 + " reason=" + r14 + "ActiveEdge deltaPx=" + r11 + " translation=" + getTranslation());
    L12:
        return true;
    L14:
        if (isUnscrollableOnCurrentAxis() == false) goto L24;
        if (r11 >= 0.0f) goto L24;
        if (lastPullTime(r10) != r12) goto L24;
        if (lastPullSign(r10) <= 0) goto L24;
        if (BounceDebugLogger.getEnabled() == false) goto L23;
        BounceDebugLogger.log(this.target, "onPullSkipped", "orientation=" + this.orientation + " lastOrientation=" + lastPullOrientation(r10) + " reason=" + r14 + "OppositeInSameFrame deltaPx=" + r11 + " translation=" + getTranslation());
    L23:
        return true;
    L24:
        return false;
    }

    private final Companion.TargetBounceState targetState() {
        WeakHashMap<View, Companion.TargetBounceState> r10 = targetStates;
        monitor-enter(r10);
        View r11 = this.target;     // Catch: Throwable -> L7
        Companion.TargetBounceState r12 = r10.get(r11);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = new Companion.TargetBounceState();     // Catch: Throwable -> L7
        r10.put(r11, r12);     // Catch: Throwable -> L7
    L9:
        Companion.TargetBounceState r13 = r12;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    private final void updateReleaseVelocity(float r10) {
        long r11 = AnimationUtils.currentAnimationTimeMillis();
        long r12 = this.lastPullTime;
        if (r12 != (-1)) goto L5;
    L7:
        this.lastPullTranslation = r10;
        this.lastPullTime = r11;
        if (BounceDebugLogger.getEnabled() == false) goto L11;
        BounceDebugLogger.log(this.target, "velocitySample", "orientation=" + this.orientation + " velocityPxPerMs=" + this.releaseVelocityPxPerMs + " translation=" + r10);
        return;
    L11:
        return;
    L5:
        if (r11 <= r12) goto L7;
        this.releaseVelocityPxPerMs = h.j((r10 - this.lastPullTranslation) / (r11 - r12), -20.0f, MAX_RELEASE_VELOCITY_PX_PER_MS);
        this.releaseVelocityTime = r11;
        goto L7
    }

    private final boolean wasOppositeReleasedInSameFrame(Companion.TargetBounceState r10, long r11) {
        if (isVerticalOrientation(this.orientation) == false) goto L10;
        if (r10.getLastVerticalReleaseTime() == r11) goto L7;
        return false;
    L7:
        if (r10.getLastVerticalReleaseOrientation() != this.orientation) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r10.getLastHorizontalReleaseTime() == r11) goto L12;
        return false;
    L12:
        if (r10.getLastHorizontalReleaseOrientation() != this.orientation) goto L16;
        return false;
    }

    @Override // android.widget.EdgeEffect
    public boolean draw(@NotNull Canvas r13) {
        q.g(r13, "canvas");
        d r14 = this.springBack;
        if (this.animationStartTime == (-1)) goto L27;
        if (r14 == null) goto L27;
        long r10 = AnimationUtils.currentAnimationTimeMillis() - this.animationStartTime;
        d.a r15 = r14.b(r10);
        setTranslation(px(r15.a()), false);
        if (BounceDebugLogger.getEnabled() == false) goto L23;
        if (access$getOrientation$p(this) != 2) goto L10;
    L13:
        float r11 = getTranslation();
    L15:
        if (access$getOrientation$p(this) != 0) goto L17;
    L20:
        float r12 = getTranslation();
    L21:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), "draw", r11, r12, "orientation=" + this.orientation + " elapsed=" + r10 + " finished=" + r15.b());
        goto L23
    L17:
        if (access$getOrientation$p(this) == 1) goto L20;
        r12 = 0.0f;
        goto L21
    L10:
        if (access$getOrientation$p(this) == 3) goto L13;
        r11 = 0.0f;
    L23:
        if (r15.b() == true) goto L26;
        this.target.invalidate();
        return true;
    L26:
        setTranslation(0.0f, false);
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent("drawFinished");
    L27:
        return false;
    }

    @Override // android.widget.EdgeEffect
    public void finish() {
        super.finish();
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        setTranslation(0.0f, false);
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent("finish");
        this.target.invalidate();
    }

    @Override // android.widget.EdgeEffect
    public float getDistance() {
        int r10 = this.sizePx;
        if (r10 > 0) goto L7;
        return 0.0f;
    L7:
        return this.accumulatedDragDistance / r10;
    }

    public final float getMaxOverscrollPx() {
        return this.maxOverscrollPx;
    }

    @Nullable
    public final Function1<Float, Unit> getOnTranslationChanged() {
        return this.onTranslationChanged;
    }

    public final float getTranslation() {
        return this.translation;
    }

    @Override // android.widget.EdgeEffect
    public boolean isFinished() {
        if (this.animationStartTime == (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.translation != 0.0f) goto L7;
        return true;
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int r14) {
        if (this.maxOverscrollPx > 0.0f) goto L6;
        return;
    L6:
        if (this.animationStartTime == (-1)) goto L12;
        if (BounceDebugLogger.getEnabled() == false) goto L52;
        BounceDebugLogger.log(this.target, "onAbsorbSkipped", "orientation=" + this.orientation + " velocity=" + r14 + " reason=animationRunning");
        return;
    L52:
        return;
    L12:
        if (BounceDebugLogger.getEnabled() == false) goto L14;
        BounceDebugLogger.log(this.target, "onAbsorb", "orientation=" + this.orientation + " velocity=" + r14);
    L14:
        resetReleaseVelocityTracker();
        markActiveOrientation("onAbsorb");
        int r10 = this.orientation;
        if (r10 == 1) goto L19;
        if (r10 == 3) goto L19;
        int r15 = Math.abs(r14);
    L20:
        float r16 = dp(r15 / 1000.0f);
        long r11 = AnimationUtils.currentAnimationTimeMillis();
        this.animationStartTime = r11;
        if (this.springBack != null) goto L23;
        this.springBack = new d();
    L23:
        float r12 = dp(this.translation);
        d r13 = this.springBack;
        if (r13 == null) goto L27;
        r13.a(r16, r12);
    L27:
        if (r13 == null) goto L50;
        float r17 = getCurrentFrameIntervalMs();
        if (r17 <= 0.0f) goto L50;
        this.animationStartTime = r11 - b.d(r17);
        d.a r18 = r13.b(r17);
        setTranslation(px(r18.a()), false);
        if (BounceDebugLogger.getEnabled() == false) goto L48;
        if (access$getOrientation$p(this) != 2) goto L35;
    L38:
        float r19 = getTranslation();
    L40:
        if (access$getOrientation$p(this) != 0) goto L42;
    L45:
        float r20 = getTranslation();
    L46:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), "onAbsorbImmediateFrame", r19, r20, "orientation=" + this.orientation + " elapsed=" + r17 + " refreshRate=" + (1000.0f / r17) + " finished=" + r18.b());
        goto L48
    L42:
        if (access$getOrientation$p(this) == 1) goto L45;
        r20 = 0.0f;
        goto L46
    L35:
        if (access$getOrientation$p(this) == 3) goto L38;
        r19 = 0.0f;
    L48:
        if (r18.b() == false) goto L50;
        setTranslation(0.0f, false);
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        clearActiveOrientationIfCurrent("absorbImmediateFinished");
    L50:
        this.target.invalidate();
        return;
    L19:
        r15 = -Math.abs(r14);
        goto L20
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r10) {
        onPull(r10, 0.5f);
    }

    @Override // android.widget.EdgeEffect
    public float onPullDistance(float r10, float r11) {
        if (this.sizePx > 0) goto L5;
    L60:
        return 0.0f;
    L5:
        if (this.maxOverscrollPx <= 0.0f) goto L60;
        if (BounceDebugLogger.getEnabled() == false) goto L10;
        BounceDebugLogger.log(this.target, "onPullDistance", "orientation=" + this.orientation + " deltaDistance=" + r10);
    L10:
        ensurePullMultiplier(r10);
        if (this.animationStartTime == (-1)) goto L13;
        this.accumulatedDragDistance = com.obric.oui.orecyclerview.base.b.f15353a.a(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
    L13:
        ViewParent r12 = this.target.getParent();
        if (r12 == null) goto L18;
        r12.requestDisallowInterceptTouchEvent(true);
    L18:
        if (this.accumulatedDragDistance == 0.0f) goto L20;
    L23:
        float r13 = getDeltaPx(r10);
        if (r10 != 0.0f) goto L26;
        return 0.0f;
    L26:
        long r14 = AnimationUtils.currentAnimationTimeMillis();
        if (shouldSkipPullInCurrentFrame(r13, r14, "onPullDistance") == false) goto L30;
        this.target.invalidate();
        return r10;
    L30:
        float r15 = this.accumulatedDragDistance + r13;
        if (shouldIgnoreAbruptOppositeDelta(r13, r15) == false) goto L35;
        markActiveOrientation("skipAbruptOppositeOnPullDistance");
        this.target.invalidate();
        return r10;
    L35:
        if (r15 <= 0.0f) goto L39;
        this.accumulatedDragDistance = r15;
        if (r13 <= 0.0f) goto L40;
        this.abruptOppositeDeltaGuardArmed = true;
    L40:
        recordPullFrame(targetState(), r14, r13);
        int r16 = this.orientation;
        float r17 = 1.0f;
        if (r16 == 0) goto L52;
        if (r16 != 1) goto L44;
    L51:
        r17 = -1.0f;
        goto L52
    L44:
        if (r16 == 2) goto L52;
        if (r16 == 3) goto L51;
        float r18 = this.translation;
        if (r18 == 0.0f) goto L52;
        r17 = Math.signum(r18);
    L52:
        float r19 = r17 * Math.abs(com.obric.oui.orecyclerview.base.b.f15353a.b(this.accumulatedDragDistance, this.maxOverscrollPx));
        setTranslation(r19, true);
        if (this.accumulatedDragDistance <= 0.0f) goto L55;
    L57:
        markActiveOrientation("onPullDistance");
    L58:
        this.target.invalidate();
        return r10;
    L55:
        if (r19 != 0.0f) goto L57;
        clearActiveOrientationIfCurrent("onPullDistanceZero");
        goto L58
    L39:
        r10 = ((-this.accumulatedDragDistance) / this.sizePx) * this.pullMultiplier;
        this.accumulatedDragDistance = 0.0f;
        goto L40
    L20:
        if (isPulling(r10) == true) goto L23;
        setTranslation(0.0f, false);
        resetReleaseVelocityTracker();
        return 0.0f;
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        long r10 = AnimationUtils.currentAnimationTimeMillis();
        Companion.TargetBounceState r11 = targetState();
        int r12 = getActiveOrientation(r11);
        if (r12 == (-1)) goto L9;
        if (r12 == this.orientation) goto L9;
        resetInactiveReleaseState(q.p("inactiveEdge activeOrientation=", Integer.valueOf(r12)));
        return;
    L9:
        if (wasOppositeReleasedInSameFrame(r11, r10) == false) goto L12;
        resetInactiveReleaseState("oppositeReleasedInSameFrame");
        return;
    L12:
        float r13 = this.translation;
        if (r13 != 0.0f) goto L16;
        this.accumulatedDragDistance = 0.0f;
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent("releaseZeroTranslation");
        return;
    L16:
        float r14 = dp(r13);
        float r15 = dp(getReleaseVelocityPxPerMs());
        if (BounceDebugLogger.getEnabled() == false) goto L19;
        BounceDebugLogger.log(this.target, "onRelease", "orientation=" + this.orientation + " initialValueDp=" + r14 + " initialVelocityDpPerMs=" + r15);
    L19:
        recordReleaseFrame(r11, r10);
        markActiveOrientation("onRelease");
        this.animationStartTime = r10;
        if (this.springBack != null) goto L22;
        this.springBack = new d();
    L22:
        d r16 = this.springBack;
        if (r16 == null) goto L26;
        r16.a(r15, r14);
    L26:
        resetReleaseVelocityTracker();
        this.target.invalidate();
    }

    public final void setMaxOverscrollPx(float r10) {
        this.maxOverscrollPx = r10;
    }

    public final void setOnTranslationChanged(@Nullable Function1<? super Float, Unit> r10) {
        this.onTranslationChanged = r10;
    }

    @Override // android.widget.EdgeEffect
    public void setSize(int r10, int r11) {
        super.setSize(r10, r11);
        int r12 = this.orientation;
        if (r12 == 2) goto L7;
        if (r12 == 3) goto L7;
    L8:
        r10 = r11;
    L9:
        this.sizePx = r10;
        return;
    L7:
        if (this.useHeightForHorizontalSize == false) goto L9;
        goto L8
    }

    public final void setUseHeightForHorizontalSize(boolean r10) {
        this.useHeightForHorizontalSize = r10;
    }

    public final void stopAnimationForTouch() {
        if (this.animationStartTime == (-1)) goto L6;
        this.accumulatedDragDistance = com.obric.oui.orecyclerview.base.b.f15353a.a(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.target.invalidate();
        return;
    }

    public final void updateTouchDeltaX(float r10) {
        this.lastTouchDeltaX = r10;
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r10, float r11) {
        if (this.sizePx > 0) goto L5;
        return;
    L5:
        if (this.maxOverscrollPx > 0.0f) goto L8;
        return;
    L8:
        if (BounceDebugLogger.getEnabled() == false) goto L10;
        BounceDebugLogger.log(this.target, "onPull", "orientation=" + this.orientation + " deltaDistance=" + r10);
    L10:
        ensurePullMultiplier(r10);
        if (this.animationStartTime == (-1)) goto L13;
        this.accumulatedDragDistance = com.obric.oui.orecyclerview.base.b.f15353a.a(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
    L13:
        ViewParent r12 = this.target.getParent();
        if (r12 == null) goto L18;
        r12.requestDisallowInterceptTouchEvent(true);
    L18:
        if (this.accumulatedDragDistance == 0.0f) goto L20;
    L23:
        float r13 = getDeltaPx(r10);
        long r14 = AnimationUtils.currentAnimationTimeMillis();
        if (shouldSkipPullInCurrentFrame(r13, r14, "onPull") == false) goto L27;
        this.target.invalidate();
        return;
    L27:
        float r15 = this.accumulatedDragDistance + r13;
        if (shouldIgnoreAbruptOppositeDelta(r13, r15) == false) goto L31;
        markActiveOrientation("skipAbruptOppositeOnPull");
        this.target.invalidate();
        return;
    L31:
        float r16 = h.c(r15, 0.0f);
        this.accumulatedDragDistance = r16;
        if (r13 > 0.0f) goto L34;
    L36:
        recordPullFrame(targetState(), r14, r13);
        float r17 = com.obric.oui.orecyclerview.base.b.f15353a.b(this.accumulatedDragDistance, this.maxOverscrollPx);
        int r18 = this.orientation;
        if (r18 == 0) goto L45;
        if (r18 != 1) goto L40;
    L44:
        r17 = -Math.abs(r17);
    L46:
        setTranslation(r17, true);
        if (this.accumulatedDragDistance <= 0.0f) goto L49;
    L51:
        markActiveOrientation("onPull");
    L52:
        this.target.invalidate();
        return;
    L49:
        if (r17 != 0.0f) goto L51;
        clearActiveOrientationIfCurrent("onPullZero");
        goto L52
    L40:
        if (r18 == 2) goto L45;
        if (r18 == 3) goto L44;
    L45:
        r17 = Math.abs(r17);
        goto L46
    L34:
        if (r16 <= 0.0f) goto L36;
        this.abruptOppositeDeltaGuardArmed = true;
        goto L36
    L20:
        if (isPulling(r10) == true) goto L23;
        setTranslation(0.0f, false);
        resetReleaseVelocityTracker();
    }

    private final void setTranslation(float r10, boolean r11) {
        if (r11 == false) goto L4;
        updateReleaseVelocity(r10);
    L4:
        setTranslation(r10);
        if (BounceDebugLogger.getEnabled() == false) goto L20;
        float r12 = 0.0f;
        if (access$getOrientation$p(this) != 2) goto L9;
    L12:
        float r13 = getTranslation();
    L14:
        if (access$getOrientation$p(this) != 0) goto L16;
    L17:
        r12 = getTranslation();
    L18:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), "setTranslation", r13, r12, "trackVelocity=" + r11 + " orientation=" + this.orientation);
        return;
    L16:
        if (access$getOrientation$p(this) != 1) goto L18;
    L9:
        if (access$getOrientation$p(this) == 3) goto L12;
        r13 = 0.0f;
        goto L14
    }
}
