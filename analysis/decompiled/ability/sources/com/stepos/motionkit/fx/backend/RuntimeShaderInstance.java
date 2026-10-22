package com.stepos.motionkit.fx.backend;

import android.graphics.Bitmap;
import android.graphics.RuntimeShader;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006-"}, d2 = {"Lcom/stepos/motionkit/fx/backend/RuntimeShaderInstance;", "", "Landroid/graphics/RuntimeShader;", "shader", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", "Lcom/stepos/motionkit/fx/backend/ShaderDrawable;", "drawable", "Landroid/view/View;", "targetView", "Landroid/view/View$OnLayoutChangeListener;", "layoutListener", "Landroid/graphics/Bitmap;", "bgBitmap", AppAgent.CONSTRUCT, "(Landroid/graphics/RuntimeShader;Lcom/stepos/motionkit/fx/uniform/UniformBinder;Lcom/stepos/motionkit/fx/backend/ShaderDrawable;Landroid/view/View;Landroid/view/View$OnLayoutChangeListener;Landroid/graphics/Bitmap;)V", "", "elapsedMs", "LC7/r;", "update", "(J)V", "release", "()V", "Landroid/graphics/RuntimeShader;", "getShader", "()Landroid/graphics/RuntimeShader;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "getBinder", "()Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "Lcom/stepos/motionkit/fx/backend/ShaderDrawable;", "getDrawable", "()Lcom/stepos/motionkit/fx/backend/ShaderDrawable;", "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", "Landroid/view/View$OnLayoutChangeListener;", "getLayoutListener", "()Landroid/view/View$OnLayoutChangeListener;", "Landroid/graphics/Bitmap;", "getBgBitmap", "()Landroid/graphics/Bitmap;", "", "hasResolution", "Z", "hasTime", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RuntimeShaderInstance {
    private final Bitmap bgBitmap;
    private final UniformBinder binder;
    private final ShaderDrawable drawable;
    private final boolean hasResolution;
    private final boolean hasTime;
    private final View.OnLayoutChangeListener layoutListener;
    private final RuntimeShader shader;
    private final View targetView;

    public RuntimeShaderInstance(RuntimeShader shader, UniformBinder binder, ShaderDrawable drawable, View targetView, View.OnLayoutChangeListener layoutListener, Bitmap bitmap) {
        kotlin.jvm.internal.k.f(shader, "shader");
        kotlin.jvm.internal.k.f(binder, "binder");
        kotlin.jvm.internal.k.f(drawable, "drawable");
        kotlin.jvm.internal.k.f(targetView, "targetView");
        kotlin.jvm.internal.k.f(layoutListener, "layoutListener");
        this.shader = shader;
        this.binder = binder;
        this.drawable = drawable;
        this.targetView = targetView;
        this.layoutListener = layoutListener;
        this.bgBitmap = bitmap;
        this.hasResolution = binder.declaresFloatUniform("iResolution");
        this.hasTime = binder.declaresFloatUniform("iTime");
    }

    public final Bitmap getBgBitmap() {
        return this.bgBitmap;
    }

    public final UniformBinder getBinder() {
        return this.binder;
    }

    public final ShaderDrawable getDrawable() {
        return this.drawable;
    }

    public final View.OnLayoutChangeListener getLayoutListener() {
        return this.layoutListener;
    }

    public final RuntimeShader getShader() {
        return this.shader;
    }

    public final View getTargetView() {
        return this.targetView;
    }

    public final void release() {
        this.targetView.removeOnLayoutChangeListener(this.layoutListener);
        this.targetView.getOverlay().remove(this.drawable);
        Bitmap bitmap = this.bgBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public final void update(long elapsedMs) {
        this.binder.resolve(elapsedMs);
        this.binder.applyTo(this.shader);
        if (this.hasResolution) {
            this.shader.setFloatUniform("iResolution", this.targetView.getWidth(), this.targetView.getHeight());
        }
        if (this.hasTime) {
            this.shader.setFloatUniform("iTime", elapsedMs / 1000.0f);
        }
        this.drawable.invalidateSelf();
    }

    public /* synthetic */ RuntimeShaderInstance(RuntimeShader runtimeShader, UniformBinder uniformBinder, ShaderDrawable shaderDrawable, View view, View.OnLayoutChangeListener onLayoutChangeListener, Bitmap bitmap, int i, kotlin.jvm.internal.e eVar) {
        this(runtimeShader, uniformBinder, shaderDrawable, view, onLayoutChangeListener, (i & 32) != 0 ? null : bitmap);
    }
}
