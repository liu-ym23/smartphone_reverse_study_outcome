package v7;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.drawable.Drawable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0017¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lv7/u;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/RuntimeShader;", "shader", "LB7/a;", "binder", "<init>", "(Landroid/graphics/RuntimeShader;LB7/a;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "draw", "(Landroid/graphics/Canvas;)V", "", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", Const.INTENT_KEY_APIKEY, "Landroid/graphics/RuntimeShader;", Const.INTENT_KEY_PKGNAME, "LB7/a;", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "paint", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class u extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RuntimeShader shader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B7.a binder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Paint paint;

    public u(RuntimeShader shader, B7.a binder) {
        kotlin.jvm.internal.p.i(shader, "shader");
        kotlin.jvm.internal.p.i(binder, "binder");
        this.shader = shader;
        this.binder = binder;
        Paint paint = new Paint();
        paint.setShader(shader);
        this.paint = paint;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        canvas.drawRect(getBounds(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
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
