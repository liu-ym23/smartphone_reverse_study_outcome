package com.stepos.motionkit.fx.backend.sf;

import A6.j;
import B7.a;
import D7.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.MKLog;
import com.stepos.motionkit.fx.backend.SfEffectChannel;
import com.stepos.motionkit.fx.backend.sf.SfEffectReflector;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0003R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/stepos/motionkit/fx/backend/sf/SfDrawableChannel;", "Lcom/stepos/motionkit/fx/backend/SfEffectChannel;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "startEffect", "createEffect", "stopEffect", "teardown", "syncBounds", "Landroid/view/View;", "view", "attach", "(Landroid/view/View;)V", "", "agsl", "submitShader", "(Ljava/lang/String;)V", "", "enabled", "setBackgroundSampling", "(Z)V", "", "", "uniforms", "submitUniforms", "(Ljava/util/Map;)V", "start", "stop", "detach", "targetView", "Landroid/view/View;", "shaderSrc", "Ljava/lang/String;", "Landroid/graphics/drawable/Drawable;", "effectDrawable", "Landroid/graphics/drawable/Drawable;", "", "effectId", "J", "previousBackground", "", "fadeAlpha", "F", "Landroid/animation/Animator;", "stopAnimator", "Landroid/animation/Animator;", "startTimeMs", "", "debugFrameCount", "I", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SfDrawableChannel implements SfEffectChannel {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "SF";
    private int debugFrameCount;
    private Drawable effectDrawable;
    private long effectId;
    private Drawable previousBackground;
    private long startTimeMs;
    private Animator stopAnimator;
    private View targetView;
    private String shaderSrc = "";
    private float fadeAlpha = 1.0f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/motionkit/fx/backend/sf/SfDrawableChannel$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createEffect() {
        View view = this.targetView;
        if (view == null) {
            return;
        }
        SfEffectReflector.CreateResult createResultCreateFromView = SfEffectReflector.INSTANCE.createFromView(view, this.shaderSrc);
        this.effectId = createResultCreateFromView.getEffectId();
        this.effectDrawable = createResultCreateFromView.getDrawable();
        if (createResultCreateFromView.getError() != null || this.effectDrawable == null || this.effectId == 0) {
            MKLog.e$default(MKLog.INSTANCE, TAG, "createEffect failed: " + createResultCreateFromView.getError() + " effectId=" + this.effectId, null, 4, null);
            teardown();
            return;
        }
        this.previousBackground = view.getBackground();
        view.setBackground(this.effectDrawable);
        Drawable drawable = this.effectDrawable;
        if (drawable != null) {
            drawable.setVisible(true, true);
        }
        syncBounds();
        MKLog.INSTANCE.i(TAG, "createEffect OK effectId=" + this.effectId + " bounds=" + view.getWidth() + "x" + view.getHeight());
    }

    private final void startEffect() {
        View view = this.targetView;
        if (view == null) {
            return;
        }
        if (!SfDrawableUniformSetter.INSTANCE.isAvailable()) {
            MKLog.e$default(MKLog.INSTANCE, TAG, "SF effect drawable class not found on classpath", null, 4, null);
            return;
        }
        if (this.shaderSrc.length() == 0) {
            MKLog.e$default(MKLog.INSTANCE, TAG, "no shader source submitted", null, 4, null);
            return;
        }
        Animator animator = this.stopAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (this.effectDrawable != null) {
            teardown();
        }
        this.fadeAlpha = 1.0f;
        this.startTimeMs = System.currentTimeMillis();
        this.debugFrameCount = 0;
        if (view.isAttachedToWindow()) {
            createEffect();
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.stepos.motionkit.fx.backend.sf.SfDrawableChannel.startEffect.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v10) {
                    k.f(v10, "v");
                    v10.removeOnAttachStateChangeListener(this);
                    SfDrawableChannel.this.createEffect();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v10) {
                    k.f(v10, "v");
                }
            });
        }
    }

    private final void stopEffect() {
        Animator animator = this.stopAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (this.effectDrawable == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.fadeAlpha, 0.0f);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.48f, 0.0f, 0.3f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new j(this, 5));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.motionkit.fx.backend.sf.SfDrawableChannel$stopEffect$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                k.f(animation, "animation");
                this.this$0.teardown();
            }
        });
        valueAnimatorOfFloat.start();
        this.stopAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopEffect$lambda$1$lambda$0(SfDrawableChannel sfDrawableChannel, ValueAnimator it) {
        k.f(it, "it");
        Object animatedValue = it.getAnimatedValue();
        k.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        sfDrawableChannel.fadeAlpha = ((Float) animatedValue).floatValue();
    }

    private final void syncBounds() {
        Drawable drawable;
        View view = this.targetView;
        if (view != null && (drawable = this.effectDrawable) != null && view.getWidth() > 0 && view.getHeight() > 0) {
            drawable.setBounds(0, 0, view.getWidth(), view.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void teardown() {
        Drawable drawable = this.effectDrawable;
        if (drawable != null) {
            drawable.setVisible(false, true);
            drawable.setCallback(null);
        }
        View view = this.targetView;
        if (view != null && view.getBackground() == this.effectDrawable) {
            view.setBackground(this.previousBackground);
        }
        this.effectDrawable = null;
        this.previousBackground = null;
        this.effectId = 0L;
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void attach(View view) {
        k.f(view, "view");
        this.targetView = view;
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void detach() {
        Animator animator = this.stopAnimator;
        if (animator != null) {
            animator.cancel();
        }
        teardown();
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void setBackgroundSampling(boolean enabled) {
        MKLog.INSTANCE.d(TAG, "setBackgroundSampling=" + enabled);
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void start() {
        startEffect();
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void stop() {
        stopEffect();
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void submitShader(String agsl) {
        k.f(agsl, "agsl");
        if (agsl.length() > 0) {
            this.shaderSrc = agsl;
        }
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void submitUniforms(Map<String, float[]> uniforms) {
        k.f(uniforms, "uniforms");
        Drawable drawable = this.effectDrawable;
        if (drawable == null) {
            return;
        }
        View view = this.targetView;
        if (view != null && view.getWidth() > 0 && view.getHeight() > 0) {
            float width = view.getWidth();
            float height = view.getHeight();
            SfDrawableUniformSetter sfDrawableUniformSetter = SfDrawableUniformSetter.INSTANCE;
            sfDrawableUniformSetter.setFloat2(drawable, "resolution", width, height);
            sfDrawableUniformSetter.setFloat2(drawable, "iResolution", width, height);
            sfDrawableUniformSetter.setFloat2(drawable, "textureSize", width, height);
            sfDrawableUniformSetter.setFloat(drawable, "aspect", width / height);
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - this.startTimeMs) / 1000.0f;
        SfDrawableUniformSetter sfDrawableUniformSetter2 = SfDrawableUniformSetter.INSTANCE;
        sfDrawableUniformSetter2.setFloat(drawable, "iTime", fCurrentTimeMillis);
        sfDrawableUniformSetter2.setInt(drawable, "enable", 1);
        for (Map.Entry<String, float[]> entry : uniforms.entrySet()) {
            String key = entry.getKey();
            float[] value = entry.getValue();
            int length = value.length;
            if (length == 1) {
                SfDrawableUniformSetter.INSTANCE.setFloatAndInt(drawable, key, value[0]);
            } else if (length == 2) {
                SfDrawableUniformSetter.INSTANCE.setFloat2(drawable, key, value[0], value[1]);
            } else if (length == 3) {
                SfDrawableUniformSetter.INSTANCE.setFloat3(drawable, key, value[0], value[1], value[2]);
            } else if (length == 4) {
                SfDrawableUniformSetter.INSTANCE.setFloat4(drawable, key, value[0], value[1], value[2], value[3]);
            }
        }
        SfDrawableUniformSetter.INSTANCE.setFloat(drawable, "fadeAlpha", this.fadeAlpha);
        drawable.invalidateSelf();
        int i = this.debugFrameCount + 1;
        this.debugFrameCount = i;
        if (i <= 3 || i % 60 == 0) {
            MKLog.INSTANCE.d(TAG, String.format(a.q(androidx.constraintlayout.core.dsl.a.k(this.debugFrameCount, "submitUniforms frame=", " res=", (view != null ? Integer.valueOf(view.getWidth()) : null) + "x" + (view != null ? Integer.valueOf(view.getHeight()) : null), " t=%.2f keys=["), v.I0(uniforms.keySet(), null, null, null, null, 63), "]"), Arrays.copyOf(new Object[]{Float.valueOf(fCurrentTimeMillis)}, 1)));
        }
    }
}
