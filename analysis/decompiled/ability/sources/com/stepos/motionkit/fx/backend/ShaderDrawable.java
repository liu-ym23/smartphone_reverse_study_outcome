package com.stepos.motionkit.fx.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.drawable.Drawable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0017¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/motionkit/fx/backend/ShaderDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/RuntimeShader;", "shader", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", AppAgent.CONSTRUCT, "(Landroid/graphics/RuntimeShader;Lcom/stepos/motionkit/fx/uniform/UniformBinder;)V", "Landroid/graphics/Canvas;", "canvas", "LC7/r;", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", "Landroid/graphics/RuntimeShader;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShaderDrawable extends Drawable {
    private final UniformBinder binder;
    private final Paint paint;
    private final RuntimeShader shader;

    public ShaderDrawable(RuntimeShader shader, UniformBinder binder) {
        kotlin.jvm.internal.k.f(shader, "shader");
        kotlin.jvm.internal.k.f(binder, "binder");
        this.shader = shader;
        this.binder = binder;
        Paint paint = new Paint();
        paint.setShader(shader);
        this.paint = paint;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        kotlin.jvm.internal.k.f(canvas, "canvas");
        canvas.drawRect(getBounds(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    @C7.c
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
