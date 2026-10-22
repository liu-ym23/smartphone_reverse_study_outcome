package com.stepos.ailauncher.container;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.launcher.assistant.slidepanel.SlidingPanelLayout;
import com.stepos.launcher.assistant.slidepanel.SlidingPanelLayoutInterpolator;
import h9.InterfaceC4149a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b'\u0018\u0000 l2\u00020\u0001:\u0003mCAB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b \u0010\u001bJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b!\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002¢\u0006\u0004\b(\u0010)J'\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u0010+\u001a\u00020%H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b.\u0010/J/\u00104\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\"2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J'\u00109\u001a\u00020\f2\u0006\u00107\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\u00020%2\u0006\u00107\u001a\u0002062\u0006\u0010;\u001a\u00020%H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b>\u0010\u001fJ\u001f\u0010A\u001a\u00020\f2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\nH\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020%2\u0006\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\fH\u0002¢\u0006\u0004\bJ\u0010\u0014J\u001f\u0010M\u001a\u00020\f2\u0006\u0010K\u001a\u0002002\u0006\u0010L\u001a\u000202H\u0002¢\u0006\u0004\bM\u0010NJ\u0011\u0010O\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\bO\u0010PJA\u0010R\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u00101\u001a\u0002002\u0006\u0010*\u001a\u00020\"2\u0006\u0010;\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u0001062\u0006\u0010Q\u001a\u00020%H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\f2\u0006\u0010T\u001a\u000202H\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\f2\u0006\u0010T\u001a\u000202H\u0002¢\u0006\u0004\bW\u0010VJ\u0017\u0010X\u001a\u00020\f2\u0006\u0010T\u001a\u000202H\u0002¢\u0006\u0004\bX\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0016\u0010e\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010f\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010`R\u0016\u0010i\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010j¨\u0006n"}, d2 = {"Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "owns", "LY8/t;", "setContentOwnsHorizontalGesture", "(Z)V", "Landroidx/viewpager2/widget/ViewPager2;", "pager", "setViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "disallowIntercept", "requestDisallowInterceptTouchEvent", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "k", "(Landroid/view/MotionEvent;Landroidx/viewpager2/widget/ViewPager2;)V", "m", "(Landroid/view/MotionEvent;)V", Const.INTENT_KEY_UMID, "w", "Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$b;", "u", "(Landroid/view/MotionEvent;)Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$b;", "", "absDx", "absDy", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(FF)V", "sample", "effSlop", "f", "(Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$b;FF)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)V", "Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$State;", "fromState", "", "reason", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/MotionEvent;Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$b;Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$State;Ljava/lang/String;)V", "Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelLayout;", "spl", "pointerId", "n", "(Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelLayout;Landroid/view/MotionEvent;I)V", "vx", "s", "(Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelLayout;F)F", "l", "pagerEnabled", "parentDisallow", Const.INTENT_KEY_APIKEY, "(ZZ)V", Const.INTENT_KEY_PKGNAME, "(Landroidx/viewpager2/widget/ViewPager2;Landroid/view/MotionEvent;)V", "c", "(I)F", "Landroid/view/VelocityTracker;", "e", "()Landroid/view/VelocityTracker;", "t", "target", "cause", "v", "(Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$State;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelLayout;", "fed", "p", "(Ljava/lang/String;Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$State;Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$b;FLcom/stepos/launcher/assistant/slidepanel/SlidingPanelLayout;F)V", "msg", "o", "(Ljava/lang/String;)V", "q", "r", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "slidingPanel", "Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelLayout;", "velocityTracker", "Landroid/view/VelocityTracker;", "touchSlop", "I", "maxVelocity", "downX", "F", "downY", "lastX", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$State;", "gestureSeq", "childClaimedGesture", "Z", "contentOwnsHorizontalGesture", "Companion", "State", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPagerTouchWrapper extends FrameLayout {
    private static final boolean DEBUG = true;
    private static final float EDGE_OUT_SLOP_DIVISOR = 3.0f;
    private static final float GESTURE_DX_DOMINANT_RATIO = 0.5f;
    private static final float ONESHOT_VELOCITY_THRESHOLD = 2000.0f;
    private static final String TAG = "PagerHandoff";
    private boolean childClaimedGesture;
    private boolean contentOwnsHorizontalGesture;
    private float downX;
    private float downY;
    private int gestureSeq;
    private float lastX;
    private final int maxVelocity;
    private SlidingPanelLayout slidingPanel;
    private State state;
    private final int touchSlop;
    private VelocityTracker velocityTracker;
    private ViewPager2 viewPager;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$State;", "", "<init>", "(Ljava/lang/String;I)V", "UNDECIDED", "VERTICAL", "CHILD_HORIZONTAL", "PARENT_HORIZONTAL", "CONTENT_HORIZONTAL", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State UNDECIDED = new State("UNDECIDED", 0);
        public static final State VERTICAL = new State("VERTICAL", 1);
        public static final State CHILD_HORIZONTAL = new State("CHILD_HORIZONTAL", 2);
        public static final State PARENT_HORIZONTAL = new State("PARENT_HORIZONTAL", 3);
        public static final State CONTENT_HORIZONTAL = new State("CONTENT_HORIZONTAL", 4);

        private static final /* synthetic */ State[] $values() {
            return new State[]{UNDECIDED, VERTICAL, CHILD_HORIZONTAL, PARENT_HORIZONTAL, CONTENT_HORIZONTAL};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static InterfaceC4149a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper$b;", "", "", "totalDx", "moveDx", "gestureDx", "", "canPagerScroll", "<init>", "(FFFZ)V", "isRtl", "e", "(Z)Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "F", Const.INTENT_KEY_UMID, "()F", "c", "getGestureDx", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "direction", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.container.ViewPagerTouchWrapper$b, reason: from toString */
    public static final /* data */ class HorizontalSample {
        private final boolean canPagerScroll;
        private final float gestureDx;
        private final float moveDx;
        private final float totalDx;

        public HorizontalSample(float f10, float f11, float f12, boolean z10) {
            this.totalDx = f10;
            this.moveDx = f11;
            this.gestureDx = f12;
            this.canPagerScroll = z10;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanPagerScroll() {
            return this.canPagerScroll;
        }

        public final int b() {
            return this.gestureDx > 0.0f ? -1 : 1;
        }

        /* renamed from: c, reason: from getter */
        public final float getMoveDx() {
            return this.moveDx;
        }

        /* renamed from: d, reason: from getter */
        public final float getTotalDx() {
            return this.totalDx;
        }

        public final boolean e(boolean isRtl) {
            float f10 = this.gestureDx;
            return isRtl ? f10 > 0.0f : f10 < 0.0f;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HorizontalSample)) {
                return false;
            }
            HorizontalSample horizontalSample = (HorizontalSample) other;
            return Float.compare(this.totalDx, horizontalSample.totalDx) == 0 && Float.compare(this.moveDx, horizontalSample.moveDx) == 0 && Float.compare(this.gestureDx, horizontalSample.gestureDx) == 0 && this.canPagerScroll == horizontalSample.canPagerScroll;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.totalDx) * 31) + Float.hashCode(this.moveDx)) * 31) + Float.hashCode(this.gestureDx)) * 31) + Boolean.hashCode(this.canPagerScroll);
        }

        public String toString() {
            return "HorizontalSample(totalDx=" + this.totalDx + ", moveDx=" + this.moveDx + ", gestureDx=" + this.gestureDx + ", canPagerScroll=" + this.canPagerScroll + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.UNDECIDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.CHILD_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[State.PARENT_HORIZONTAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[State.CONTENT_HORIZONTAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerTouchWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void a(boolean pagerEnabled, boolean parentDisallow) {
        boolean z10 = pagerEnabled && !this.contentOwnsHorizontalGesture;
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.setUserInputEnabled(z10);
        }
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(parentDisallow);
        }
    }

    public final void b(ViewPager2 pager, MotionEvent ev) {
        if (pager.h()) {
            View childAt = pager.getChildAt(0);
            RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
            if (recyclerView == null) {
                return;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(ev);
            motionEventObtain.setAction(3);
            try {
                recyclerView.dispatchTouchEvent(motionEventObtain);
                o("PAGER_CANCEL x=" + ((int) ev.getX()) + " y=" + ((int) ev.getY()));
            } finally {
                motionEventObtain.recycle();
            }
        }
    }

    public final float c(int pointerId) {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maxVelocity);
        return velocityTracker.getXVelocity(pointerId);
    }

    public final boolean d(MotionEvent ev) {
        SlidingPanelLayoutInterpolator slidingPanelLayoutInterpolator;
        float fAbs = Math.abs(ev.getX() - this.downX);
        float fAbs2 = Math.abs(ev.getY() - this.downY);
        HorizontalSample horizontalSampleU = u(ev);
        SlidingPanelLayout slidingPanelLayout = this.slidingPanel;
        boolean z10 = (this.contentOwnsHorizontalGesture || horizontalSampleU.getCanPagerScroll() || !horizontalSampleU.e(slidingPanelLayout != null && slidingPanelLayout.mIsRtl)) ? false : true;
        float f10 = (!z10 || (slidingPanelLayout != null && (slidingPanelLayoutInterpolator = slidingPanelLayout.mSlidingPanelLayoutInterpolator) != null && !slidingPanelLayoutInterpolator.isFinished())) ? this.touchSlop : this.touchSlop / 3.0f;
        if (fAbs < f10 && fAbs2 < this.touchSlop) {
            return false;
        }
        if (fAbs2 > fAbs) {
            h(fAbs, fAbs2);
            return true;
        }
        if (this.contentOwnsHorizontalGesture) {
            g(fAbs);
            return true;
        }
        if (horizontalSampleU.getCanPagerScroll()) {
            f(horizontalSampleU, fAbs, f10);
            return true;
        }
        j(ev, horizontalSampleU, State.UNDECIDED, (!z10 || fAbs >= ((float) this.touchSlop)) ? "EDGE_OUT" : "EDGE_OUT_FAST");
        return true;
    }

    public final VelocityTracker e() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
        this.velocityTracker = velocityTrackerObtain;
        kotlin.jvm.internal.p.h(velocityTrackerObtain, "also(...)");
        return velocityTrackerObtain;
    }

    public final void f(HorizontalSample sample, float absDx, float effSlop) {
        v(State.CHILD_HORIZONTAL, "PAGER_CAN_SCROLL dir=" + sample.b() + " totalDx=" + ((int) sample.getTotalDx()) + " absDx=" + ((int) absDx) + " effSlop=" + ((int) effSlop));
        a(true, true);
    }

    public final void g(float absDx) {
        v(State.CONTENT_HORIZONTAL, "CONTENT_OWNS absDx=" + ((int) absDx));
        a(false, true);
    }

    public final void h(float absDx, float absDy) {
        v(State.VERTICAL, "VERTICAL_DOMINANT absDx=" + ((int) absDx) + " absDy=" + ((int) absDy));
        a(false, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.stepos.ailauncher.container.ViewPagerTouchWrapper] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final SlidingPanelLayout i() {
        while (this != 0) {
            if (this instanceof SlidingPanelLayout) {
                return (SlidingPanelLayout) this;
            }
            Object parent = this.getParent();
            this = parent instanceof View ? (View) parent : 0;
        }
        return null;
    }

    public final void j(MotionEvent ev, HorizontalSample sample, State fromState, String reason) {
        float fS;
        if (this.contentOwnsHorizontalGesture) {
            o("HANDOFF blocked reason=" + reason + " from=" + fromState + " (content owns horizontal)");
            g(Math.abs(sample.getTotalDx()));
            return;
        }
        int pointerId = ev.getPointerId(0);
        float fC = c(pointerId);
        SlidingPanelLayout slidingPanelLayout = this.slidingPanel;
        if (slidingPanelLayout != null) {
            n(slidingPanelLayout, ev, pointerId);
            fS = s(slidingPanelLayout, fC);
        } else {
            fS = Float.NaN;
        }
        p(reason, fromState, sample, fC, slidingPanelLayout, fS);
        v(State.PARENT_HORIZONTAL, reason);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            b(viewPager2, ev);
        }
        a(false, false);
        this.lastX = ev.getX();
    }

    public final void k(MotionEvent ev, ViewPager2 pager) {
        this.gestureSeq++;
        this.childClaimedGesture = false;
        c0.INSTANCE.b();
        this.downX = ev.getX();
        this.downY = ev.getY();
        this.lastX = ev.getX();
        this.state = State.UNDECIDED;
        a(true, true);
        if (this.slidingPanel == null) {
            this.slidingPanel = i();
        }
        RecyclerView.Adapter adapter = pager.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        int currentItem = pager.getCurrentItem();
        boolean z10 = itemCount > 0 && (currentItem == 0 || currentItem == itemCount + (-1));
        int scrollState = pager.getScrollState();
        String str = scrollState != 0 ? scrollState != 1 ? scrollState != 2 ? "?" : "SETTLING" : "DRAGGING" : "IDLE";
        o("DOWN x=" + ((int) ev.getX()) + " y=" + ((int) ev.getY()) + " item=" + currentItem + "/" + itemCount + " pagerState=" + str + " edgeOnDown=" + z10 + " spl=" + (this.slidingPanel != null));
    }

    public final void l(MotionEvent ev) {
        float fC = c(ev.getPointerId(0));
        String str = ev.getActionMasked() == 1 ? "UP" : "CANCEL";
        State state = this.state;
        int i10 = (int) fC;
        ViewPager2 viewPager2 = this.viewPager;
        o("END action=" + str + " state=" + state + " wrapperVx=" + i10 + " item=" + (viewPager2 != null ? Integer.valueOf(viewPager2.getCurrentItem()) : null));
        this.state = State.UNDECIDED;
        a(true, false);
        t();
    }

    public final void m(MotionEvent ev) {
        int i10 = c.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i10 == 1) {
            if (!this.childClaimedGesture && d(ev)) {
                this.lastX = ev.getX();
                return;
            }
            return;
        }
        if (i10 == 2) {
            if (this.childClaimedGesture) {
                return;
            }
            w(ev);
            this.lastX = ev.getX();
            return;
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        this.lastX = ev.getX();
    }

    public final void n(SlidingPanelLayout spl, MotionEvent ev, int pointerId) {
        if (!spl.mSlidingPanelLayoutInterpolator.isFinished()) {
            spl.mSlidingPanelLayoutInterpolator.cancelAll();
        }
        spl.mActivePointerId = pointerId;
        spl.mDownX = ev.getX();
        spl.mDownY = ev.getY();
        spl.mLastMotionX = ev.getX();
        spl.startScrollX = ev.getX();
        spl.mStartTouchPanelX = spl.mPanelX;
        spl.mTotalMotionX = 0.0f;
        spl.startDrag();
    }

    public final void o(String msg) {
        Log.d(TAG, "g#" + this.gestureSeq + " " + msg);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.slidingPanel == null) {
            this.slidingPanel = i();
        }
        o("onAttachedToWindow splFound=" + (this.slidingPanel != null));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        t();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r4, r0)
            androidx.viewpager2.widget.ViewPager2 r0 = r3.viewPager
            r1 = 0
            if (r0 != 0) goto Lb
            return r1
        Lb:
            int r2 = r4.getActionMasked()
            if (r2 != 0) goto L18
            android.view.VelocityTracker r2 = r3.velocityTracker
            if (r2 == 0) goto L18
            r2.clear()
        L18:
            android.view.VelocityTracker r2 = r3.e()
            r2.addMovement(r4)
            int r2 = r4.getActionMasked()
            if (r2 == 0) goto L37
            r0 = 1
            if (r2 == r0) goto L33
            r0 = 2
            if (r2 == r0) goto L2f
            r0 = 3
            if (r2 == r0) goto L33
            goto L3a
        L2f:
            r3.m(r4)
            goto L3a
        L33:
            r3.l(r4)
            goto L3a
        L37:
            r3.k(r4, r0)
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.container.ViewPagerTouchWrapper.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(String reason, State fromState, HorizontalSample sample, float vx, SlidingPanelLayout spl, float fed) {
        String str = "HANDOFF reason=" + reason + " from=" + fromState + " dir=" + sample.b() + " vx=" + ((int) vx) + " totalDx=" + ((int) sample.getTotalDx()) + " moveDx=" + ((int) sample.getMoveDx());
        if (spl == null) {
            r(str + " spl=null FALLBACK");
            return;
        }
        String strValueOf = Float.isNaN(fed) ? "no" : String.valueOf((int) fed);
        int i10 = spl.mPanelX;
        String str2 = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(spl.mPanelPositionRatio)}, 1));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        q(str + " feedSpl=" + strValueOf + " splPanelX=" + i10 + " splRatio=" + str2 + " splSettling=" + spl.mSettling);
    }

    public final void q(String msg) {
        Log.i(TAG, "g#" + this.gestureSeq + " " + msg);
    }

    public final void r(String msg) {
        Log.w(TAG, "g#" + this.gestureSeq + " " + msg);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        this.childClaimedGesture = disallowIntercept;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    public final float s(SlidingPanelLayout spl, float vx) {
        if (Math.abs(vx) < 2000.0f) {
            return Float.NaN;
        }
        spl.onOneshotFlingVelocity(vx);
        return vx;
    }

    public final void setContentOwnsHorizontalGesture(boolean owns) {
        ViewPager2 viewPager2;
        if (this.contentOwnsHorizontalGesture == owns) {
            return;
        }
        this.contentOwnsHorizontalGesture = owns;
        q("contentOwnsHorizontalGesture=" + owns);
        State state = this.state;
        if ((state == State.UNDECIDED || state == State.CONTENT_HORIZONTAL) && (viewPager2 = this.viewPager) != null) {
            viewPager2.setUserInputEnabled(!owns);
        }
    }

    public final void setViewPager(ViewPager2 pager) {
        kotlin.jvm.internal.p.i(pager, "pager");
        this.viewPager = pager;
    }

    public final void t() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
    }

    public final HorizontalSample u(MotionEvent ev) {
        float x10 = ev.getX() - this.downX;
        float x11 = ev.getX() - this.lastX;
        float f10 = Math.abs(x10) >= ((float) this.touchSlop) * 0.5f ? x10 : x11;
        int i10 = f10 > 0.0f ? -1 : 1;
        ViewPager2 viewPager2 = this.viewPager;
        return new HorizontalSample(x10, x11, f10, viewPager2 != null && viewPager2.canScrollHorizontally(i10));
    }

    public final void v(State target, String cause) {
        State state = this.state;
        if (state == target) {
            return;
        }
        o("STATE old=" + state + " new=" + target + " cause=" + cause);
        this.state = target;
    }

    public final void w(MotionEvent ev) {
        HorizontalSample horizontalSampleU = u(ev);
        if (horizontalSampleU.getCanPagerScroll()) {
            return;
        }
        j(ev, horizontalSampleU, State.CHILD_HORIZONTAL, "EDGE_OUT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerTouchWrapper(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.maxVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.state = State.UNDECIDED;
    }

    public /* synthetic */ ViewPagerTouchWrapper(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
