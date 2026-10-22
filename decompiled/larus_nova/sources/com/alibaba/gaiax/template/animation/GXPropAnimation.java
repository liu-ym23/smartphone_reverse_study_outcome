package com.alibaba.gaiax.template.animation;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXNode;
import com.alibaba.gaiax.template.GXColor;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.utils.JsonExt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J4\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00066"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimation;", "Lcom/alibaba/gaiax/template/animation/GXIPropAnimation;", "name", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName;", "value", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue;", "(Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName;Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue;)V", GXPropAnimation.KEY_DELAY, "", "getDelay", "()J", "setDelay", "(J)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", GXPropAnimation.KEY_INTERPOLATOR, "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator;", "getInterpolator", "()Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator;", "setInterpolator", "(Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator;)V", GXPropAnimation.KEY_LOOP_COUNT, "getLoopCount", "setLoopCount", GXPropAnimationSet.GXPropLoopMode.KEY_LOOP_MODE, "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode;", "getLoopMode", "()Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode;", "setLoopMode", "(Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode;)V", "getName", "()Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName;", "getValue", "()Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue;", "createAnimator", "Landroid/animation/Animator;", "targetView", "Landroid/view/View;", "executeAnimation", "", "gxState", "Lcom/alibaba/gaiax/template/GXIExpression;", "gxAnimationExpression", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "gxTemplateData", "Lorg/json/JSONObject;", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXPropAnimation implements GXIPropAnimation {
    public static final Companion Companion = null;
    private static final String KEY_DELAY = "delay";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_INTERPOLATOR = "interpolator";
    private static final String KEY_LOOP = "loop";
    private static final String KEY_LOOP_COUNT = "loopCount";
    private static final String KEY_PROP_NAME = "propName";
    private static ArgbEvaluator argbEvaluator;
    private long delay;
    private int duration;
    private GXPropAnimationSet.GXPropInterpolator interpolator;
    private int loopCount;
    private GXPropAnimationSet.GXPropLoopMode loopMode;
    private final GXPropAnimationSet.GXPropName name;
    private final GXPropAnimationSet.GXPropValue value;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimation$Companion;", "", "()V", "KEY_DELAY", "", "KEY_DURATION", "KEY_INTERPOLATOR", "KEY_LOOP", "KEY_LOOP_COUNT", "KEY_PROP_NAME", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "getArgbEvaluator", "()Landroid/animation/ArgbEvaluator;", "setArgbEvaluator", "(Landroid/animation/ArgbEvaluator;)V", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimation;", "data", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ArgbEvaluator getArgbEvaluator() {
            return GXPropAnimation.access$getArgbEvaluator$cp();
        }

        public final GXPropAnimation create(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            GXPropAnimationSet.GXPropName r101 = GXPropAnimationSet.GXPropName.Companion.create(r100.optString(GXPropAnimation.KEY_PROP_NAME, null));
            GXPropAnimationSet.GXPropValue r102 = GXPropAnimationSet.GXPropValue.Companion.create(r100);
            if (r101 == null) goto L29;
            if (r102 == null) goto L29;
            GXPropAnimation r103 = new GXPropAnimation(r101, r102);
            String r104 = r100.optString("duration", null);
            if (r104 == null) goto L8;
            r103.setDuration(CastIntegerProtector.parseInt(r104));
        L8:
            String r105 = r100.optString(GXPropAnimation.KEY_INTERPOLATOR, null);
            if (r105 == null) goto L11;
            r103.setInterpolator(GXPropAnimationSet.GXPropInterpolator.Companion.create(r105));
        L11:
            String r106 = r100.optString(GXPropAnimationSet.GXPropLoopMode.KEY_LOOP_MODE, null);
            if (r106 == null) goto L15;
            r103.setLoopMode(GXPropAnimationSet.GXPropLoopMode.Companion.create(r106));
        L15:
            if (r100.has(GXPropAnimation.KEY_LOOP) == false) goto L20;
            if (JsonExt.INSTANCE.getBooleanExt(r100, GXPropAnimation.KEY_LOOP) == false) goto L20;
            r103.setLoopCount(Integer.MAX_VALUE);
        L26:
            if (r100.has(GXPropAnimation.KEY_DELAY) == false) goto L28;
            r103.setDelay(r100.optLong(GXPropAnimation.KEY_DELAY));
        L28:
            return r103;
        L20:
            if (r100.has(GXPropAnimation.KEY_LOOP_COUNT) == false) goto L26;
            if (r103.getLoopMode() != GXPropAnimationSet.GXPropLoopMode.REVERSE) goto L24;
            r103.setLoopCount(Math.max(1, (r100.optInt(GXPropAnimation.KEY_LOOP_COUNT) * 2) - 1));
            goto L26
        L24:
            r103.setLoopCount(Math.max(0, r100.optInt(GXPropAnimation.KEY_LOOP_COUNT) - 1));
        L29:
            return null;
        }

        public final void setArgbEvaluator(ArgbEvaluator r100) {
            GXPropAnimation.access$setArgbEvaluator$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(GXPropAnimation r100, View r101, ValueAnimator r102) {
        createAnimator$lambda$0(r100, r101, r102);
    }

    @Override // com.alibaba.gaiax.template.animation.GXIAnimation
    public void executeAnimation(GXIExpression r100, GXIExpression r101, GXTemplateContext r102, GXNode r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r102, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r103, "gxNode");
        Intrinsics.checkNotNullParameter(r104, "gxTemplateData");
    }

    public static final /* synthetic */ ArgbEvaluator access$getArgbEvaluator$cp() {
        return argbEvaluator;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final GXPropAnimationSet.GXPropInterpolator getInterpolator() {
        return this.interpolator;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final GXPropAnimationSet.GXPropLoopMode getLoopMode() {
        return this.loopMode;
    }

    public final GXPropAnimationSet.GXPropName getName() {
        return this.name;
    }

    public final GXPropAnimationSet.GXPropValue getValue() {
        return this.value;
    }

    public static final /* synthetic */ void access$setArgbEvaluator$cp(ArgbEvaluator r100) {
        argbEvaluator = r100;
    }

    @Override // com.alibaba.gaiax.template.animation.GXIPropAnimation
    public Animator createAnimator(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        ValueAnimator r101 = new ValueAnimator();
        r101.setRepeatCount(this.loopCount);
        if (this.loopMode != GXPropAnimationSet.GXPropLoopMode.RESET) goto L5;
        int r102 = 1;
    L6:
        r101.setRepeatMode(r102);
        r101.setDuration(this.duration);
        r101.setInterpolator(this.interpolator.value());
        GXPropAnimationSet.GXPropValue r103 = this.value;
        if ((r103 instanceof GXPropAnimationSet.GXPropValue.GXPropValueFloat) == false) goto L10;
        r101.setFloatValues(new float[]{((GXPropAnimationSet.GXPropValue.GXPropValueFloat) r103).getValueFrom(), ((GXPropAnimationSet.GXPropValue.GXPropValueFloat) this.value).getValueTo()});
    L15:
        r101.addUpdateListener(new a(this, r100));
        r101.setStartDelay(this.delay);
        return r101;
    L10:
        if ((r103 instanceof GXPropAnimationSet.GXPropValue.GXPropValueColor) == false) goto L15;
        if (argbEvaluator != null) goto L14;
        argbEvaluator = new ArgbEvaluator();
    L14:
        r101.setEvaluator(argbEvaluator);
        r101.setIntValues(new int[]{GXColor.value$default(((GXPropAnimationSet.GXPropValue.GXPropValueColor) this.value).getValueFrom(), null, 1, null), GXColor.value$default(((GXPropAnimationSet.GXPropValue.GXPropValueColor) this.value).getValueTo(), null, 1, null)});
        goto L15
    L5:
        r102 = 2;
        goto L6
    }

    public final void setDelay(long r100) {
        this.delay = r100;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setInterpolator(GXPropAnimationSet.GXPropInterpolator r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interpolator = r100;
    }

    public final void setLoopCount(int r100) {
        this.loopCount = r100;
    }

    public final void setLoopMode(GXPropAnimationSet.GXPropLoopMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loopMode = r100;
    }

    public GXPropAnimation(GXPropAnimationSet.GXPropName r100, GXPropAnimationSet.GXPropValue r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.name = r100;
        this.value = r101;
        this.duration = 300;
        this.interpolator = GXPropAnimationSet.GXPropInterpolator.STANDARD;
        this.loopMode = GXPropAnimationSet.GXPropLoopMode.RESET;
    }

    private static final void createAnimator$lambda$0(GXPropAnimation r100, View r101, ValueAnimator r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "$targetView");
        if ((r102.getAnimatedValue() instanceof Float) == false) goto L6;
        GXPropAnimationSet.GXPropName r103 = r100.name;
        Object r104 = r102.getAnimatedValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Float");
        r103.setValue(r101, ((Float) r104).floatValue());
        return;
    L6:
        if ((r102.getAnimatedValue() instanceof Integer) == false) goto L10;
        GXPropAnimationSet.GXPropName r105 = r100.name;
        Object r106 = r102.getAnimatedValue();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Int");
        r105.setColorValue(r101, ((Integer) r106).intValue());
        return;
    }
}
