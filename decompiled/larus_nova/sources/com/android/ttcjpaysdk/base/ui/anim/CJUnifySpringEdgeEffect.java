package com.android.ttcjpaysdk.base.ui.anim;

import android.widget.EdgeEffect;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0004\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0018\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\tH\u0014J\u0006\u0010,\u001a\u00020\u0011R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect;", "Landroidx/recyclerview/widget/RecyclerView$EdgeEffectFactory;", "()V", "attachStateChangeListener", "com/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$attachStateChangeListener$1", "Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$attachStateChangeListener$1;", "attachedView", "Landroidx/recyclerview/widget/RecyclerView;", "canPullVerticalDirection", "", "getCanPullVerticalDirection", "()I", "setCanPullVerticalDirection", "(I)V", "edgeEffectResetters", "", "Lkotlin/Function0;", "", "enableAbsorbImpact", "", "getEnableAbsorbImpact", "()Z", "setEnableAbsorbImpact", "(Z)V", "horizontalController", "Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$SpringController;", "maxPullVerticalDistance", "", "getMaxPullVerticalDistance", "()F", "setMaxPullVerticalDistance", "(F)V", "onPullCallback", "Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$OnPullCallback;", "getOnPullCallback", "()Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$OnPullCallback;", "setOnPullCallback", "(Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$OnPullCallback;)V", "verticalController", "attachTo", "recyclerView", "createEdgeEffect", "Landroid/widget/EdgeEffect;", "direction", BasicTestActionHandler.TEST_ACTION_RESET, "Companion", "OnPullCallback", "SpringController", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifySpringEdgeEffect extends RecyclerView.EdgeEffectFactory {
    public static final Companion Companion = null;
    private static final float FLING_TRANSLATION_MAGNITUDE = 0.1f;
    private static final float MAX_FLING_TRANSLATION_VELOCITY = 2000.0f;
    private static final float OVERSCROLL_TRANSLATION_MAGNITUDE = 0.2f;
    public static final int PULL_DIRECTION_DOWN = 16;
    public static final int PULL_DIRECTION_UP = 1;
    private final CJUnifySpringEdgeEffect$attachStateChangeListener$1 attachStateChangeListener;
    private RecyclerView attachedView;
    private int canPullVerticalDirection;
    private final List<Function0<Unit>> edgeEffectResetters;
    private boolean enableAbsorbImpact;
    private SpringController horizontalController;
    private float maxPullVerticalDistance;
    private OnPullCallback onPullCallback;
    private SpringController verticalController;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$Companion;", "", "()V", "FLING_TRANSLATION_MAGNITUDE", "", "MAX_FLING_TRANSLATION_VELOCITY", "OVERSCROLL_TRANSLATION_MAGNITUDE", "PULL_DIRECTION_DOWN", "", "PULL_DIRECTION_UP", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$OnPullCallback;", "", "onPull", "", "deltaDistance", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnPullCallback {
        boolean onPull(float r100);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$SpringController;", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "isVertical", "", "minValue", "", "maxValue", "(Landroidx/recyclerview/widget/RecyclerView;ZFF)V", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/dynamicanimation/animation/SpringAnimation;", "isPulling", "absorb", "", "velocity", "currentValue", "isFinished", "pull", "delta", "release", BasicTestActionHandler.TEST_ACTION_RESET, "setValue", "value", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SpringController {
        private final SpringAnimation animation;
        private boolean isPulling;
        private final boolean isVertical;
        private final float maxValue;
        private final float minValue;
        private final RecyclerView view;

        public final void release() {
            boolean r100 = false;
            this.isPulling = false;
            if (currentValue() != 0.0f) goto L5;
            r100 = true;
        L5:
            if (r100 == true) goto L8;
            this.animation.start();
            return;
        }

        public final void reset() {
            this.isPulling = false;
            this.animation.cancel();
            setValue(0.0f);
        }

        private final float currentValue() {
            if (this.isVertical == false) goto L6;
            return this.view.getTranslationY();
        L6:
            return this.view.getTranslationX();
        }

        public final boolean isFinished() {
            if (this.isPulling == false) goto L5;
            return false;
        L5:
            if (this.animation.isRunning() == false) goto L7;
            return false;
        L7:
            if (currentValue() != 0.0f) goto L9;
            boolean r100 = true;
        L10:
            if (r100 == false) goto L15;
            return true;
        L15:
            return false;
        L9:
            r100 = false;
            goto L10
        }

        private final void setValue(float r100) {
            if (this.isVertical == false) goto L5;
            this.view.setTranslationY(r100);
            return;
        L5:
            this.view.setTranslationX(r100);
        }

        public final void absorb(float r100) {
            this.isPulling = false;
            this.animation.cancel();
            this.animation.setStartVelocity(r100);
            this.animation.start();
        }

        public final void pull(float r100) {
            this.animation.cancel();
            this.isPulling = true;
            if (this.isVertical == false) goto L5;
            float r101 = this.view.getTranslationY();
        L6:
            setValue(RangesKt.coerceIn(r101 + r100, this.minValue, this.maxValue));
            return;
        L5:
            r101 = this.view.getTranslationX();
            goto L6
        }

        public SpringController(RecyclerView r100, boolean r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.view = r100;
            this.isVertical = r101;
            this.minValue = r102;
            this.maxValue = r103;
            if (r101 == false) goto L5;
            DynamicAnimation.ViewProperty r104 = DynamicAnimation.TRANSLATION_Y;
        L6:
            SpringAnimation r105 = new SpringAnimation(r100, r104);
            SpringForce r106 = new SpringForce(0.0f);
            r106.setDampingRatio(1.0f);
            r106.setStiffness(1200.0f);
            r105.setSpring(r106);
            r105.setMinValue(r102);
            r105.setMaxValue(r103);
            this.animation = r105;
            return;
        L5:
            r104 = DynamicAnimation.TRANSLATION_X;
            goto L6
        }

        public /* synthetic */ SpringController(RecyclerView r100, boolean r101, float r102, float r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 4) == 0) goto L6;
            r102 = -3.4028235E38f;
        L6:
            if ((r104 & 8) == 0) goto L8;
            r103 = Float.MAX_VALUE;
        L8:
            this(r100, r101, r102, r103);
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.ui.anim.CJUnifySpringEdgeEffect$createEdgeEffect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r100) {
            super(0, r100, CJUnifySpringEdgeEffect$createEdgeEffect$edgeEffect$1.class, "resetState", "resetState()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((CJUnifySpringEdgeEffect$createEdgeEffect$edgeEffect$1) this.receiver).resetState();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void reset() {
        Iterator<T> r100 = this.edgeEffectResetters.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    L6:
        SpringController r101 = this.verticalController;
        if (r101 == null) goto L9;
        r101.reset();
    L9:
        SpringController r102 = this.horizontalController;
        if (r102 == null) goto L14;
        r102.reset();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.android.ttcjpaysdk.base.ui.anim.CJUnifySpringEdgeEffect$attachStateChangeListener$1] */
    public CJUnifySpringEdgeEffect() {
        this.maxPullVerticalDistance = 200.0f;
        this.canPullVerticalDirection = 17;
        this.enableAbsorbImpact = true;
        this.edgeEffectResetters = new ArrayList();
        this.attachStateChangeListener = new CJUnifySpringEdgeEffect$attachStateChangeListener$1(this);
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

    private final void attachTo(RecyclerView r100) {
        if (this.attachedView != r100) goto L5;
        return;
    L5:
        reset();
        this.edgeEffectResetters.clear();
        RecyclerView r101 = this.attachedView;
        if (r101 == null) goto L8;
        r101.removeOnAttachStateChangeListener(this.attachStateChangeListener);
    L8:
        this.attachedView = r100;
        r100.addOnAttachStateChangeListener(this.attachStateChangeListener);
        this.verticalController = null;
        this.horizontalController = null;
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
    public EdgeEffect createEdgeEffect(RecyclerView r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "recyclerView");
        attachTo(r110);
        RecyclerView.LayoutManager r100 = r110.getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == false) goto L7;
        int r101 = ((LinearLayoutManager) r100).getOrientation();
    L5:
        int r102 = r101;
    L10:
        if (r102 != 0) goto L12;
        SpringController r103 = this.horizontalController;
        if (r103 != null) goto L21;
        r103 = new SpringController(r110, false, 0.0f, 0.0f, 12, null);
        this.horizontalController = r103;
    L21:
        SpringController r104 = r103;
    L22:
        CJUnifySpringEdgeEffect$createEdgeEffect$edgeEffect$1 r105 = new CJUnifySpringEdgeEffect$createEdgeEffect$edgeEffect$1(r104, r102, r111, this, r110, r110.getContext());
        this.edgeEffectResetters.add(new AnonymousClass1(r105));
        return r105;
    L12:
        if (r102 == 1) goto L14;
        r103 = null;
        goto L21
    L14:
        SpringController r106 = this.verticalController;
        if (r106 != null) goto L17;
        float r107 = this.maxPullVerticalDistance;
        r106 = new SpringController(r110, true, -r107, r107);
        this.verticalController = r106;
    L17:
        r104 = r106;
        goto L22
    L7:
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L9;
        r101 = ((StaggeredGridLayoutManager) r100).getOrientation();
        goto L5
    L9:
        r102 = -1;
        goto L10
    }
}
