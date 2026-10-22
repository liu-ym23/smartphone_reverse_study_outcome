package com.obric.oui.titlebar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ae;
import d.h.b.h;
import d.h.b.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OUnitedTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.a {
    private static final int ACTION_MARGIN_TOP = 0;
    private static final int COLLAPSE_HEIGHT = 0;
    public static final int COLLAPSE_ON_CENTER = 0;
    public static final int COLLAPSE_ON_LEFT = 1;
    public static final float COLLAPSE_TEXT_SIZE_ON_CENTER = 16.0f;
    public static final float COLLAPSE_TEXT_SIZE_ON_LEFT = 20.0f;
    public static final a Companion = null;
    private static final int EXPANDED_HEIGHT = 0;
    public static final float EXPANDED_TEXT_SIZE = 40.0f;
    public static final int PENDING_ACTION_ANIMATED = 16;
    public static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    public static final int PENDING_ACTION_COLLAPSED = 1;
    public static final int PENDING_ACTION_EXPANDED = 16;
    public static final int PENDING_ACTION_FORCE = 8;
    public static final int PENDING_ACTION_NONE = 0;
    private static final int TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER = 0;
    private static final int TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT = 0;
    private static final int TITLE_EXPANDED_MARGIN_BOTTOM = 0;
    private final int INVALID_SCROLL_RANGE;
    private View bottomAction;
    private View divider;
    private int downScrollRange;
    private final boolean haveChildWithInterpolator;
    private boolean inDebug;
    private al lastInsets;
    private ViewGroup leftAction;
    private Drawable leftActionSrc;
    private final boolean liftOnScroll;
    private WeakReference<View> liftOnScrollTargetView;
    private final int liftOnScrollTargetViewId;
    private int mCollapsePosition;
    private b mOnHeaderFlingUnConsumedListener;
    private List<c> mOnOffsetChangeListeners;
    private int mPendingAction;
    private TextView mTvSubTitle;
    private TextView mTvTitle;
    private ViewGroup rightAction;
    private Drawable rightActionSrc;
    private int textInitPos;
    private String titleText;

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ValueAnimator f36619a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f36620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WeakReference<View> f36621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f36622e;
        private boolean f;
        private int g;
        private int h;
        private int i;

        public static /* synthetic */ void lambda$ZIs0WQWKskK7CJrYtNXDHN8fftQ(Behavior r0, CoordinatorLayout r1, OUnitedTitleBar r2, ValueAnimator r3) {
            a(r0, r1, r2, r3);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int a(CoordinatorLayout r7, View r8, int r9, int r10, int r11) {
            return a(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r9, r10, r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ void a(CoordinatorLayout r9, View r10, View r11, int r12, int r13, int r14, int r15) {
            a(r9, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r10, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ void a(CoordinatorLayout r8, View r9, View r10, int r11, int r12, int[] r13) {
            a(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ boolean a(View r3) {
            return a((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.a, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r3, View r4, int r5) {
            return a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ boolean a(CoordinatorLayout r7, View r8, int r9, int r10, float r11) {
            return a(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r9, r10, r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r7, View r8, View r9, float r10, float r11) {
            return a(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r9, r10, r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r8, View r9, View r10, float r11, float r12, boolean r13) {
            return a(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r7, View r8, View r9, View r10, int r11) {
            return a(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r9, r10, r11);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int b(View r3) {
            return b((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int c(View r3) {
            return c((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ void d(CoordinatorLayout r3, View r4, View r5) {
            a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ void e(CoordinatorLayout r3, View r4) {
            a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        public Behavior() {
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        }

        public boolean a(OUnitedTitleBar r5) {
            WeakReference<View> r0 = this.f36621d;
            if (r0 == null) goto L15;
            o.a(r0);
            View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L7;
        L13:
            return false;
        L7:
            if (r1.isShown() == false) goto L13;
            if (ViewCompat.a(r1, -1) == true) goto L13;
            int r4 = d();
            o.a(r5);
            if (r4 <= (-OUnitedTitleBar.access$getScrollRange(r5))) goto L13;
            return true;
        L15:
            return true;
        }

        public int b(OUnitedTitleBar r1) {
            o.e(r1, "view");
            return -OUnitedTitleBar.access$getScrollRange(r1);
        }

        public int c(OUnitedTitleBar r1) {
            o.e(r1, "view");
            return OUnitedTitleBar.access$getScrollRange(r1);
        }

        public int a(CoordinatorLayout r8, OUnitedTitleBar r9, int r10, int r11, int r12) {
            int r0 = d();
            if (this.f == false) goto L5;
            r11 = Math.max(this.h, r11);
            r12 = Math.min(this.i, r12);
        L5:
            int r13 = super.a(r8, (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"), r10, r11, r12);
            if (r9 == null) goto L9;
            r9.dispatchOffsetChange(d());
        L9:
            int r14 = 0;
            if (this.f == false) goto L20;
            if (r9 != null) goto L13;
            b r15 = null;
        L14:
            if (r15 == null) goto L20;
            int r16 = ((r10 - r0) + r13) - this.g;
            if (r16 == 0) goto L18;
            o.a(r9);
            b r17 = r9.getMOnHeaderFlingUnConsumedListener();
            o.a(r17);
            r14 = r17.a(r9, r10, r16);
        L18:
            this.g += -r14;
            goto L20
        L13:
            r15 = r9.getMOnHeaderFlingUnConsumedListener();
        L20:
            return r13 + r14;
        }

        public boolean a(CoordinatorLayout r7, OUnitedTitleBar r8, int r9, int r10, float r11) {
            o.e(r8, "layout");
            if (r11 >= 0.0f) goto L5;
            this.f = true;
            this.g = 0;
            this.h = r9;
            this.i = r10;
            r9 = Integer.MIN_VALUE;
            r10 = Integer.MAX_VALUE;
        L5:
            View r2 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
            return super.a(r7, r2, r9, r10, r11);
        }

        public void a(CoordinatorLayout r2, OUnitedTitleBar r3) {
            this.f = false;
            b(r2, r3);
        }

        public final boolean b(CoordinatorLayout r5, OUnitedTitleBar r6) {
            int r0 = d();
            o.a(r6);
            int r1 = -OUnitedTitleBar.access$getSnapRange(r6);
            if (r0 <= r1) goto L11;
            if (r0 >= 0) goto L11;
            if (r0 < ((r1 + 0) / 2)) goto L9;
            r1 = 0;
        L9:
            a(r5, r6, r1, 0.0f);
            return true;
        L11:
            return false;
        }

        public boolean a(CoordinatorLayout r3, OUnitedTitleBar r4, int r5) {
            o.e(r3, "parent");
            o.e(r4, "child");
            boolean r6 = super.a(r3, (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), r5);
            if (OUnitedTitleBar.access$getMPendingAction$p(r4) != 0) goto L5;
        L10:
            r4.dispatchOffsetChange(d());
            return r6;
        L5:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r4) & 1) == 0) goto L8;
            b_(r3, (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), -OUnitedTitleBar.access$getScrollRange(r4));
            goto L10
        L8:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r4) & 16) == 0) goto L10;
            b_(r3, (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 0);
            goto L10
        }

        private final void a(CoordinatorLayout r3, OUnitedTitleBar r4, int r5, float r6) {
            int r0 = Math.abs(b() - r5);
            float r7 = Math.abs(r6);
            if (r7 <= 0.0f) goto L5;
            int r8 = Math.round(1000 * (r0 / r7));
        L6:
            a(r3, r4, r5, r8);
            return;
        L5:
            o.a(r4);
            r8 = (int) (((r0 / r4.getHeight()) + 1) * 150);
            goto L6
        }

        private final void a(final CoordinatorLayout r6, final OUnitedTitleBar r7, int r8, int r9) {
            int r0 = d();
            if (r0 != r8) goto L7;
            ValueAnimator r1 = this.f36619a;
            if (r1 == null) goto L7;
            o.a(r1);
            r1.cancel();
        L7:
            ValueAnimator r2 = this.f36619a;
            if (r2 != null) goto L10;
            ValueAnimator r3 = new ValueAnimator();
            this.f36619a = r3;
            o.a(r3);
            r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
            ValueAnimator r4 = this.f36619a;
            o.a(r4);
            r4.addUpdateListener(new $$Lambda$OUnitedTitleBar$Behavior$ZIs0WQWKskK7CJrYtNXDHN8fftQ(this, r6, r7));
        L11:
            ValueAnimator r10 = this.f36619a;
            o.a(r10);
            r10.setDuration(r9);
            ValueAnimator r11 = this.f36619a;
            o.a(r11);
            r11.setIntValues(new int[]{r0, r8});
            ValueAnimator r5 = this.f36619a;
            o.a(r5);
            r5.start();
            return;
        L10:
            o.a(r2);
            r2.cancel();
            goto L11
        }

        private static final void a(Behavior r2, CoordinatorLayout r3, OUnitedTitleBar r4, ValueAnimator r5) {
            o.e(r2, "this$0");
            o.e(r5, "animation");
            View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
            Object r7 = r5.getAnimatedValue();
            Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Int");
            r2.b_(r3, r6, ((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin")).intValue());
        }

        public boolean a(CoordinatorLayout r2, OUnitedTitleBar r3, View r4, View r5, int r6) {
            o.e(r2, "coordinatorLayout");
            o.e(r3, "child");
            o.e(r4, "directTargetChild");
            o.e(r5, "target");
            if ((r6 & 2) > 0) goto L5;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L14;
            ValueAnimator r8 = this.f36619a;
            if (r8 == null) goto L14;
            o.a(r8);
            r8.cancel();
        L14:
            this.f36621d = null;
            this.f36622e = false;
            this.f = false;
            c();
            return r7;
        L5:
            if (OUnitedTitleBar.access$getScrollRange(r3) <= 0) goto L9;
            if ((r2.getHeight() - r4.getHeight()) > r3.getHeight()) goto L9;
            r7 = true;
            goto L10
        }

        public void a(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int[] r12) {
            o.e(r7, "coordinatorLayout");
            o.e(r8, "child");
            o.e(r9, "target");
            o.e(r12, "consumed");
            if (r11 > 0) goto L5;
            return;
        L5:
            if (this.f36620c == true) goto L9;
            int r4 = -OUnitedTitleBar.access$getScrollRange(r8);
            r12[1] = b(r7, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), r11, r4, 0);
            return;
        }

        public void a(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int r12, int r13) {
            o.e(r7, "coordinatorLayout");
            o.e(r8, "child");
            o.e(r9, "target");
            if (r13 >= 0) goto L5;
            b(r7, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), r13, -OUnitedTitleBar.access$getScrollRange(r8), 0);
            boolean r14 = true;
        L6:
            this.f36620c = r14;
            return;
        L5:
            r14 = false;
            goto L6
        }

        public void a(CoordinatorLayout r2, OUnitedTitleBar r3, View r4) {
            o.e(r2, "coordinatorLayout");
            o.e(r3, "child");
            o.e(r4, "target");
            if (this.f36622e == true) goto L5;
            b(r2, r3);
        L5:
            this.f36620c = false;
            this.f36621d = new WeakReference(r4);
        }

        public boolean a(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, float r10, float r11) {
            o.e(r7, "coordinatorLayout");
            o.e(r8, "child");
            o.e(r9, "target");
            if (r11 > 0.0f) goto L5;
            return false;
        L5:
            if (d() <= (-OUnitedTitleBar.access$getScrollRange(r8))) goto L10;
            a(r7, r8, -OUnitedTitleBar.access$getScrollRange(r8), 0, -r11);
            this.f36622e = true;
            return true;
        L10:
            return false;
        }

        public boolean a(CoordinatorLayout r1, OUnitedTitleBar r2, View r3, float r4, float r5, boolean r6) {
            o.e(r1, "coordinatorLayout");
            o.e(r2, "child");
            o.e(r3, "target");
            this.f36622e = true;
            return false;
        }
    }

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final int a() {
            return OUnitedTitleBar.access$getACTION_MARGIN_TOP$cp();
        }

        public final int b() {
            return OUnitedTitleBar.access$getTITLE_EXPANDED_MARGIN_BOTTOM$cp();
        }

        public final int c() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER$cp();
        }

        public final int d() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT$cp();
        }
    }

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    public interface b {
        int a(OUnitedTitleBar r1, int r2, int r3);
    }

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    public interface c {
        void a(OUnitedTitleBar r1, int r2);
    }

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OUnitedTitleBar f36623a;

        d(OUnitedTitleBar r1) {
            this.f36623a = r1;
        }

        @Override // com.obric.oui.titlebar.OUnitedTitleBar.c
        public void a(OUnitedTitleBar r17, int r18) {
            ViewGroup r2 = this.f36623a.getLeftAction();
            ViewGroup.MarginLayoutParams r3 = null;
            if (r2 != null) goto L5;
            ViewGroup.LayoutParams r4 = null;
        L7:
            if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == false) goto L9;
            ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        L10:
            ViewGroup r6 = this.f36623a.getRightAction();
            if (r6 != null) goto L13;
            ViewGroup.LayoutParams r7 = null;
        L15:
            if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L17;
            ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        L18:
            TextView r9 = this.f36623a.getMTvTitle();
            if (r9 != null) goto L21;
            ViewGroup.LayoutParams r10 = null;
        L23:
            if (ZeusTransformUtils.instanceOf(r10, ViewGroup.MarginLayoutParams.class) == false) goto L25;
            r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        L25:
            int r11 = g.a((View) ZeusTransformUtils.preCheckCast(this.f36623a, View.class, "com.obric.aiagent.plugin"), OUnitedTitleBar.Companion.a());
            float r12 = 16.0f;
            int r13 = g.a((View) ZeusTransformUtils.preCheckCast(this.f36623a, View.class, "com.obric.aiagent.plugin"), OUnitedTitleBar.Companion.b());
            int r14 = g.a((View) ZeusTransformUtils.preCheckCast(this.f36623a, View.class, "com.obric.aiagent.plugin"), OUnitedTitleBar.Companion.c());
            float r15 = (-r18) / this.f36623a.getTotalScrollRange();
            if (this.f36623a.getMCollapsePosition() != 1) goto L39;
            r14 = g.a((View) ZeusTransformUtils.preCheckCast(this.f36623a, View.class, "com.obric.aiagent.plugin"), OUnitedTitleBar.Companion.d());
            int[] r16 = new int[2];
            TextView r19 = this.f36623a.getMTvTitle();
            if (r19 == null) goto L31;
            r19.getLocationOnScreen(r16);
        L31:
            if (r18 != 0) goto L33;
            int r20 = r16[0];
            int r110 = r16[1];
            this.f36623a.setTextInitPos(r20);
        L33:
            float r21 = (this.f36623a.getTextInitPos() + g.a((View) ZeusTransformUtils.preCheckCast(this.f36623a, View.class, "com.obric.aiagent.plugin"), 18)) * r15;
            if (r3 == null) goto L37;
            r3.leftMargin = -((int) r21);
        L37:
            r12 = 20.0f;
        L39:
            if (r15 != 1.0f) goto L41;
            boolean r111 = true;
        L42:
            if (r111 == false) goto L47;
            View r112 = this.f36623a.getDivider();
            if (r112 == null) goto L51;
            k.a(r112);
        L51:
            if (r5 == null) goto L54;
            r5.topMargin = (-r18) + r11;
        L54:
            if (r8 == null) goto L57;
            r8.topMargin = (-r18) + r11;
        L57:
            int r1 = (int) (r13 - ((r13 - r14) * r15));
            float r22 = ((r12 - 40.0f) * new AccelerateDecelerateInterpolator().getInterpolation(r15)) + 40.0f;
            TextView r23 = this.f36623a.getMTvTitle();
            if (r23 == null) goto L61;
            r23.setTextSize(2, r22);
        L61:
            if (r3 == null) goto L64;
            r3.bottomMargin = r1;
        L64:
            ViewGroup r24 = this.f36623a.getLeftAction();
            if (r24 == null) goto L68;
            r24.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        L68:
            ViewGroup r25 = this.f36623a.getRightAction();
            if (r25 == null) goto L72;
            r25.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        L72:
            TextView r0 = this.f36623a.getMTvTitle();
            if (r0 == null) goto L77;
            r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            return;
        L77:
            return;
        L47:
            View r113 = this.f36623a.getDivider();
            if (r113 == null) goto L51;
            k.b(r113);
            goto L51
        L41:
            r111 = false;
            goto L42
        L21:
            r10 = r9.getLayoutParams();
            goto L23
        L17:
            r8 = null;
            goto L18
        L13:
            r7 = r6.getLayoutParams();
            goto L15
        L9:
            r5 = null;
            goto L10
        L5:
            r4 = r2.getLayoutParams();
            goto L7
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OUnitedTitleBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ al lambda$yEMAtgEZgize7zTW62nLO80OFoI(OUnitedTitleBar r0, View r1, al r2) {
        return m1228init$lambda0(r0, r1, r2);
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final boolean setLiftedState(boolean r1) {
        return false;
    }

    public /* synthetic */ OUnitedTitleBar(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ int access$getACTION_MARGIN_TOP$cp() {
        return ACTION_MARGIN_TOP;
    }

    public static final /* synthetic */ int access$getCOLLAPSE_HEIGHT$cp() {
        return COLLAPSE_HEIGHT;
    }

    public static final /* synthetic */ int access$getEXPANDED_HEIGHT$cp() {
        return EXPANDED_HEIGHT;
    }

    public static final /* synthetic */ int access$getMPendingAction$p(OUnitedTitleBar r0) {
        return r0.mPendingAction;
    }

    public static final /* synthetic */ int access$getScrollRange(OUnitedTitleBar r0) {
        return r0.getScrollRange();
    }

    public static final /* synthetic */ int access$getSnapRange(OUnitedTitleBar r0) {
        return r0.getSnapRange();
    }

    public static final /* synthetic */ int access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER$cp() {
        return TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER;
    }

    public static final /* synthetic */ int access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT$cp() {
        return TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT;
    }

    public static final /* synthetic */ int access$getTITLE_EXPANDED_MARGIN_BOTTOM$cp() {
        return TITLE_EXPANDED_MARGIN_BOTTOM;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin")), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(generateLayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        return (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin")), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    }

    public OUnitedTitleBar(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        init(r5, r6);
        this.INVALID_SCROLL_RANGE = -1;
        this.downScrollRange = -1;
    }

    static {
        Companion = new a(null);
        COLLAPSE_HEIGHT = 56;
        EXPANDED_HEIGHT = 240;
        ACTION_MARGIN_TOP = 12;
        TITLE_EXPANDED_MARGIN_BOTTOM = 92;
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER = 17;
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT = 14;
    }

    public final ViewGroup getLeftAction() {
        return this.leftAction;
    }

    public final void setLeftAction(ViewGroup r1) {
        this.leftAction = r1;
    }

    public final ViewGroup getRightAction() {
        return this.rightAction;
    }

    public final void setRightAction(ViewGroup r1) {
        this.rightAction = r1;
    }

    public final TextView getMTvTitle() {
        return this.mTvTitle;
    }

    public final void setMTvTitle(TextView r1) {
        this.mTvTitle = r1;
    }

    public final TextView getMTvSubTitle() {
        return this.mTvSubTitle;
    }

    public final void setMTvSubTitle(TextView r1) {
        this.mTvSubTitle = r1;
    }

    public final View getBottomAction() {
        return this.bottomAction;
    }

    public final void setBottomAction(View r1) {
        this.bottomAction = r1;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r1) {
        this.titleText = r1;
    }

    public final Drawable getLeftActionSrc() {
        return this.leftActionSrc;
    }

    public final void setLeftActionSrc(Drawable r1) {
        this.leftActionSrc = r1;
    }

    public final Drawable getRightActionSrc() {
        return this.rightActionSrc;
    }

    public final void setRightActionSrc(Drawable r1) {
        this.rightActionSrc = r1;
    }

    public final View getDivider() {
        return this.divider;
    }

    public final void setDivider(View r1) {
        this.divider = r1;
    }

    public final b getMOnHeaderFlingUnConsumedListener() {
        return this.mOnHeaderFlingUnConsumedListener;
    }

    public final void setMOnHeaderFlingUnConsumedListener(b r3) {
        this.mOnHeaderFlingUnConsumedListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public final int getMCollapsePosition() {
        return this.mCollapsePosition;
    }

    public final void setMCollapsePosition(int r1) {
        this.mCollapsePosition = r1;
    }

    public final void addOnOffsetChangeListener(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        if (this.mOnOffsetChangeListeners != null) goto L5;
        this.mOnOffsetChangeListeners = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L5:
        if (r5 == null) goto L10;
        List<c> r0 = this.mOnOffsetChangeListeners;
        o.a(r0);
        if (r0.contains(r5) == true) goto L11;
        List<c> r3 = this.mOnOffsetChangeListeners;
        o.a(r3);
        r3.add(r5);
        return;
    L11:
        return;
    }

    public final void removeOnOffsetChangeListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        List<c> r2 = this.mOnOffsetChangeListeners;
        if (r2 == null) goto L7;
        ae.c((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).remove(r4);
        return;
    }

    public final void setExpanded(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 16;
    L5:
        this.mPendingAction = r2;
        requestLayout();
        return;
    L4:
        r2 = 1;
        goto L5
    }

    public final void dispatchOffsetChange(int r5) {
        List<c> r0 = this.mOnOffsetChangeListeners;
        if (r0 == null) goto L8;
        o.a(r0);
        Iterator<c> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.aiagent.plugin")).a(this, r5);
        goto L6
    L10:
        return;
    }

    public final void setOnHeaderFlingUnConsumedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "onHeaderFlingUnConsumedListener");
        this.mOnHeaderFlingUnConsumedListener = r4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public BaseBehavior.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new BaseBehavior.LayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public BaseBehavior.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new BaseBehavior.LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    private final void init(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        TypedArray r8 = r7.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OUnitedTitleBar);
        o.c(r8, "context.obtainStyledAttr…tyleable.OUnitedTitleBar)");
        this.titleText = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_united_title, "styleable", "OUnitedTitleBar_oui_united_title"));
        this.mCollapsePosition = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_title_collapse_position, "styleable", "OUnitedTitleBar_oui_title_collapse_position"), 0);
        this.leftActionSrc = r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_left_action_src, "styleable", "OUnitedTitleBar_oui_left_action_src"));
        this.rightActionSrc = r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_right_action_src, "styleable", "OUnitedTitleBar_oui_right_action_src"));
        r8.recycle();
        FrameLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_united_titlebar, "layout", "o_united_titlebar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        this.leftAction = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.fl_left_container, DbHelper.COL_ID, "fl_left_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        this.rightAction = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.fl_right_container, DbHelper.COL_ID, "fl_right_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        this.mTvTitle = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_title_container, DbHelper.COL_ID, "tv_title_container")), TextView.class, "com.obric.aiagent.plugin");
        this.mTvSubTitle = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_subtitle_container, DbHelper.COL_ID, "tv_subtitle_container")), TextView.class, "com.obric.aiagent.plugin");
        this.bottomAction = findViewById(ZeusTransformUtils.mapRes(R.id.fl_bottom_container, DbHelper.COL_ID, "fl_bottom_container"));
        this.divider = findViewById(ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider"));
        TextView r9 = this.mTvTitle;
        if (r9 == null) goto L6;
        r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.titleText, CharSequence.class, "com.obric.aiagent.plugin"));
    L6:
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), new $$Lambda$OUnitedTitleBar$yEMAtgEZgize7zTW62nLO80OFoI(this));
        setupView();
        registerTransform();
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final al m1228init$lambda0(OUnitedTitleBar r0, View r1, al r2) {
        o.e(r0, "this$0");
        al r3 = r0.onWindowInsetChanged(r2);
        o.a(r3);
        return r3;
    }

    public final boolean getInDebug() {
        return this.inDebug;
    }

    public final void setInDebug(boolean r1) {
        this.inDebug = r1;
    }

    public final void setupView() {
        if (this.leftActionSrc == null) goto L6;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        OIconButton r0 = new OIconButton(r4, null, 0, 0, null, 28, null);
        r0.setImageDrawable(getLeftActionSrc());
        setLeftAction((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
    L6:
        if (this.rightActionSrc == null) goto L8;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "context");
        OIconButton r1 = new OIconButton(r5, null, 0, 0, null, 28, null);
        r1.setImageDrawable(getRightActionSrc());
        setRightAction((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
    L8:
        setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent")));
        if (this.inDebug == false) goto L23;
        ViewGroup r2 = this.leftAction;
        if (r2 == null) goto L14;
        r2.setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_blue_2, "color", "oui_blue_2")));
    L14:
        ViewGroup r3 = this.rightAction;
        if (r3 == null) goto L18;
        r3.setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_blue_2, "color", "oui_blue_2")));
    L18:
        setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_red_2, "color", "oui_red_2")));
        TextView r6 = this.mTvTitle;
        if (r6 == null) goto L24;
        r6.setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_yellow_1, "color", "oui_yellow_1")));
        return;
    L24:
        return;
    }

    public final void registerTransform() {
        addOnOffsetChangeListener((c) ZeusTransformUtils.preCheckCast(new d(this), c.class, "com.obric.aiagent.plugin"));
    }

    public final int getTextInitPos() {
        return this.textInitPos;
    }

    public final void setTextInitPos(int r1) {
        this.textInitPos = r1;
    }

    public final int getINVALID_SCROLL_RANGE() {
        return this.INVALID_SCROLL_RANGE;
    }

    public final void setLeftAction(View r2) {
        o.e(r2, "view");
        ViewGroup r0 = this.leftAction;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        ViewGroup r1 = this.leftAction;
        if (r1 == null) goto L11;
        r1.addView(r2);
        return;
    }

    public final void setRightAction(View r2) {
        o.e(r2, "view");
        ViewGroup r0 = this.rightAction;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        ViewGroup r1 = this.rightAction;
        if (r1 == null) goto L11;
        r1.addView(r2);
        return;
    }

    private final int getSnapRange() {
        return g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 56);
    }

    public final boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public final boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final boolean shouldLift(View r1) {
        View r0 = findLiftOnScrollTargetView(r1);
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r1.getScrollY() <= 0) goto L12;
        goto L11
    }

    private final View findLiftOnScrollTargetView(View r5) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r0 = this.liftOnScrollTargetViewId;
        if (r0 == (-1)) goto L15;
        if (r5 == null) goto L8;
        View r6 = r5.findViewById(r0);
    L9:
        if (r6 == null) goto L11;
    L13:
        if (r6 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r6);
        goto L15
    L11:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L13;
        ViewParent r7 = getParent();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.view.ViewGroup");
        r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin")).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r6 = null;
    L15:
        WeakReference<View> r4 = this.liftOnScrollTargetView;
        if (r4 != null) goto L19;
        return null;
    L19:
        return (View) ZeusTransformUtils.preCheckCast(r4.get(), View.class, "com.obric.aiagent.plugin");
    }

    public final int getTopInset() {
        al r0 = this.lastInsets;
        if (r0 == null) goto L5;
        o.a(r0);
        return r0.b();
    L5:
        return 0;
    }

    private final void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    private final boolean shouldDrawStatusBarForeground() {
        if (getTopInset() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final al onWindowInsetChanged(al r3) {
        if (ViewCompat.v((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == false) goto L5;
        al r0 = r3;
    L7:
        if (androidx.core.util.d.a(this.lastInsets, r0) == true) goto L9;
        this.lastInsets = r0;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r3;
    L5:
        r0 = null;
        goto L7
    }

    public final int getPendingAction() {
        return this.mPendingAction;
    }

    public final void resetPendingAction() {
        this.mPendingAction = 0;
    }

    public final boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    private final int getScrollRange() {
        return g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), EXPANDED_HEIGHT - COLLAPSE_HEIGHT);
    }

    public final int getTotalScrollRange() {
        return g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), EXPANDED_HEIGHT - COLLAPSE_HEIGHT);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public CoordinatorLayout.b<?> getBehavior() {
        return (CoordinatorLayout.b) ZeusTransformUtils.preCheckCast(new BaseBehavior.Behavior(), CoordinatorLayout.b.class, "com.obric.aiagent.plugin");
    }
}
