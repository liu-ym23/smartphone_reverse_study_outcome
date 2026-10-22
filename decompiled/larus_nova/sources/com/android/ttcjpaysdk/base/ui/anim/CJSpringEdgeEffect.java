package com.android.ttcjpaysdk.base.ui.anim;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJSpringEdgeEffect;", "Landroidx/recyclerview/widget/RecyclerView$EdgeEffectFactory;", "()V", "canPullVerticalDirection", "", "getCanPullVerticalDirection", "()I", "setCanPullVerticalDirection", "(I)V", "enableAbsorbImpact", "", "getEnableAbsorbImpact", "()Z", "setEnableAbsorbImpact", "(Z)V", "maxPullVerticalDistance", "", "getMaxPullVerticalDistance", "()F", "setMaxPullVerticalDistance", "(F)V", "onPullCallback", "Lcom/android/ttcjpaysdk/base/ui/anim/CJSpringEdgeEffect$OnPullCallback;", "getOnPullCallback", "()Lcom/android/ttcjpaysdk/base/ui/anim/CJSpringEdgeEffect$OnPullCallback;", "setOnPullCallback", "(Lcom/android/ttcjpaysdk/base/ui/anim/CJSpringEdgeEffect$OnPullCallback;)V", "createEdgeEffect", "Landroid/widget/EdgeEffect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "direction", "Companion", "OnPullCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSpringEdgeEffect extends RecyclerView.EdgeEffectFactory {
    public static final Companion Companion = null;
    private static final float FLING_TRANSLATION_MAGNITUDE = 0.1f;
    private static final float OVERSCROLL_TRANSLATION_MAGNITUDE = 0.2f;
    public static final int PULL_DIRECTION_DOWN = 16;
    public static final int PULL_DIRECTION_UP = 1;
    private int canPullVerticalDirection;
    private boolean enableAbsorbImpact;
    private float maxPullVerticalDistance;
    private OnPullCallback onPullCallback;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJSpringEdgeEffect$Companion;", "", "()V", "FLING_TRANSLATION_MAGNITUDE", "", "OVERSCROLL_TRANSLATION_MAGNITUDE", "PULL_DIRECTION_DOWN", "", "PULL_DIRECTION_UP", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJSpringEdgeEffect$OnPullCallback;", "", "onPull", "", "deltaDistance", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnPullCallback {
        boolean onPull(float r100);
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.ui.anim.CJSpringEdgeEffect$createEdgeEffect$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"com/android/ttcjpaysdk/base/ui/anim/CJSpringEdgeEffect$createEdgeEffect$1", "Landroid/widget/EdgeEffect;", "reboundAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "getReboundAnimation", "()Landroidx/dynamicanimation/animation/SpringAnimation;", "reboundAnimation$delegate", "Lkotlin/Lazy;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "getView", "()Landroidx/recyclerview/widget/RecyclerView;", "viewOrientation", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "handlePull", "", "deltaDistance", "", "isFinished", "onAbsorb", "velocity", "onPull", "displacement", "onRelease", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 extends EdgeEffect {
        final /* synthetic */ int $direction;
        private final Lazy reboundAnimation$delegate;
        final /* synthetic */ CJSpringEdgeEffect this$0;
        private final RecyclerView view;
        private final int viewOrientation;

        private final SpringAnimation getReboundAnimation() {
            return (SpringAnimation) this.reboundAnimation$delegate.getValue();
        }

        @Override // android.widget.EdgeEffect
        public boolean isFinished() {
            return !getReboundAnimation().isRunning();
        }

        @Override // android.widget.EdgeEffect
        public void onRelease() {
            super.onRelease();
            int r100 = this.viewOrientation;
            if (r100 != (-1)) goto L5;
            return;
        L5:
            boolean r101 = false;
            if (r100 != 1) goto L13;
            if (this.view.getTranslationY() != 0.0f) goto L10;
            r101 = true;
        L10:
            if (r101 == true) goto L18;
            getReboundAnimation().start();
            return;
        L18:
            return;
        L13:
            if (this.view.getTranslationX() != 0.0f) goto L15;
            r101 = true;
        L15:
            if (r101 == true) goto L20;
            getReboundAnimation().start();
            return;
        }

        public final RecyclerView getView() {
            return this.view;
        }

        public static final /* synthetic */ int access$getViewOrientation$p(AnonymousClass1 r100) {
            return r100.viewOrientation;
        }

        private final void handlePull(float r100) {
            int r101 = this.viewOrientation;
            int r102 = -1;
            if (r101 != (-1)) goto L5;
            return;
        L5:
            boolean r103 = true;
            if (r101 != 1) goto L30;
            boolean r104 = false;
            if (this.$direction != 3) goto L14;
            if ((this.this$0.getCanPullVerticalDirection() & 1) == 1) goto L17;
            r103 = false;
        L17:
            if (r103 == true) goto L19;
            return;
        L19:
            OnPullCallback r105 = this.this$0.getOnPullCallback();
            if (r105 != null) goto L22;
        L24:
            float r106 = this.view.getTranslationY() + (((r102 * this.view.getHeight()) * r100) * 0.2f);
            if (r106 >= 0.0f) goto L27;
            float r107 = RangesKt.coerceAtLeast(r106, -this.this$0.getMaxPullVerticalDistance());
        L28:
            this.view.setTranslationY(r107);
        L34:
            getReboundAnimation().cancel();
            return;
        L27:
            r107 = RangesKt.coerceAtMost(r106, this.this$0.getMaxPullVerticalDistance());
            goto L28
        L22:
            if (r105.onPull(r100) == false) goto L24;
            return;
        L14:
            if ((this.this$0.getCanPullVerticalDirection() & 16) != 16) goto L16;
            r104 = true;
        L16:
            r103 = r104;
            r102 = 1;
            goto L17
        L30:
            if (this.$direction == 2) goto L33;
            r102 = 1;
        L33:
            float r108 = ((r102 * this.view.getWidth()) * r100) * 0.2f;
            RecyclerView r109 = this.view;
            r109.setTranslationX(r109.getTranslationX() + r108);
            goto L34
        }

        @Override // android.widget.EdgeEffect
        public boolean draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            setSize(0, 0);
            return super.draw(r100);
        }

        @Override // android.widget.EdgeEffect
        public void onAbsorb(int r100) {
            if (this.this$0.getEnableAbsorbImpact() == true) goto L5;
            return;
        L5:
            super.onAbsorb(r100);
            int r101 = this.viewOrientation;
            int r102 = -1;
            if (r101 != (-1)) goto L9;
            return;
        L9:
            if (r101 != 1) goto L16;
            if (this.$direction == 3) goto L14;
            r102 = 1;
        L14:
            getReboundAnimation().cancel();
            getReboundAnimation().start();
            getReboundAnimation().setStartVelocity((r102 * r100) * 0.1f).start();
            return;
        L16:
            if (this.$direction == 2) goto L19;
            r102 = 1;
        L19:
            getReboundAnimation().cancel();
            getReboundAnimation().start();
            getReboundAnimation().setStartVelocity((r102 * r100) * 0.1f).start();
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float r100) {
            super.onPull(r100);
            handlePull(r100);
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float r100, float r101) {
            super.onPull(r100, r101);
            handlePull(r100);
        }

        public AnonymousClass1(RecyclerView r100, int r101, CJSpringEdgeEffect r102, Context r103) {
            this.$direction = r101;
            this.this$0 = r102;
            super(r103);
            this.view = r100;
            r100.addOnScrollListener(new C05371());
            RecyclerView.LayoutManager r104 = r100.getLayoutManager();
            if ((r104 instanceof LinearLayoutManager) == false) goto L6;
            int r105 = ((LinearLayoutManager) r104).getOrientation();
        L9:
            this.viewOrientation = r105;
            this.reboundAnimation$delegate = LazyKt.lazy(new CJSpringEdgeEffect$createEdgeEffect$1$reboundAnimation$2(this));
            return;
        L6:
            if ((r104 instanceof StaggeredGridLayoutManager) == false) goto L8;
            r105 = ((StaggeredGridLayoutManager) r104).getOrientation();
            goto L9
        L8:
            r105 = -1;
            goto L9
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJSpringEdgeEffect() {
        this.maxPullVerticalDistance = Float.MAX_VALUE;
        this.canPullVerticalDirection = 17;
        this.enableAbsorbImpact = true;
    }

    public final int getCanPullVerticalDirection() {
        return this.canPullVerticalDirection;
    }

    public final boolean getEnableAbsorbImpact() {
        return this.enableAbsorbImpact;
    }

    public final float getMaxPullVerticalDistance() {
        return this.maxPullVerticalDistance;
    }

    public final OnPullCallback getOnPullCallback() {
        return this.onPullCallback;
    }

    public final void setCanPullVerticalDirection(int r100) {
        this.canPullVerticalDirection = r100;
    }

    public final void setEnableAbsorbImpact(boolean r100) {
        this.enableAbsorbImpact = r100;
    }

    public final void setMaxPullVerticalDistance(float r100) {
        this.maxPullVerticalDistance = r100;
    }

    public final void setOnPullCallback(OnPullCallback r100) {
        this.onPullCallback = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
    public EdgeEffect createEdgeEffect(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        return new AnonymousClass1(r100, r101, this, r100.getContext());
    }
}
