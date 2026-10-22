package v7;

import android.graphics.Bitmap;
import android.graphics.RuntimeShader;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/¨\u00063"}, d2 = {"Lv7/n;", "", "Landroid/graphics/RuntimeShader;", "shader", "LB7/a;", "binder", "Lv7/u;", "drawable", "Landroid/view/View;", "targetView", "Landroid/view/View$OnLayoutChangeListener;", "layoutListener", "Landroid/graphics/Bitmap;", "bgBitmap", "<init>", "(Landroid/graphics/RuntimeShader;LB7/a;Lv7/u;Landroid/view/View;Landroid/view/View$OnLayoutChangeListener;Landroid/graphics/Bitmap;)V", "", "elapsedMs", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(J)V", Const.INTENT_KEY_APIKEY, "()V", "Landroid/graphics/RuntimeShader;", "getShader", "()Landroid/graphics/RuntimeShader;", "LB7/a;", "getBinder", "()LB7/a;", "c", "Lv7/u;", "getDrawable", "()Lv7/u;", Const.INTENT_KEY_UMID, "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", "e", "Landroid/view/View$OnLayoutChangeListener;", "getLayoutListener", "()Landroid/view/View$OnLayoutChangeListener;", "f", "Landroid/graphics/Bitmap;", "getBgBitmap", "()Landroid/graphics/Bitmap;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "hasResolution", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "hasTime", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RuntimeShader shader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B7.a binder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final u drawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final View targetView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final View.OnLayoutChangeListener layoutListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Bitmap bgBitmap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean hasResolution;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean hasTime;

    public n(RuntimeShader shader, B7.a binder, u drawable, View targetView, View.OnLayoutChangeListener layoutListener, Bitmap bitmap) {
        kotlin.jvm.internal.p.i(shader, "shader");
        kotlin.jvm.internal.p.i(binder, "binder");
        kotlin.jvm.internal.p.i(drawable, "drawable");
        kotlin.jvm.internal.p.i(targetView, "targetView");
        kotlin.jvm.internal.p.i(layoutListener, "layoutListener");
        this.shader = shader;
        this.binder = binder;
        this.drawable = drawable;
        this.targetView = targetView;
        this.layoutListener = layoutListener;
        this.bgBitmap = bitmap;
        this.hasResolution = binder.d("iResolution");
        this.hasTime = binder.d("iTime");
    }

    public final void a() {
        this.targetView.removeOnLayoutChangeListener(this.layoutListener);
        this.targetView.getOverlay().remove(this.drawable);
        Bitmap bitmap = this.bgBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public final void b(long elapsedMs) {
        this.binder.e(elapsedMs);
        this.binder.a(this.shader);
        if (this.hasResolution) {
            this.shader.setFloatUniform("iResolution", this.targetView.getWidth(), this.targetView.getHeight());
        }
        if (this.hasTime) {
            this.shader.setFloatUniform("iTime", elapsedMs / 1000.0f);
        }
        this.drawable.invalidateSelf();
    }
}
