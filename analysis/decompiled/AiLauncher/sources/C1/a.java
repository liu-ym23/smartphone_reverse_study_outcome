package C1;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.InterfaceC1387e;
import android.view.LifecycleOwner;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0004¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\nH\u0004¢\u0006\u0004\b\u0018\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\f¨\u0006\u001f"}, d2 = {"LC1/a;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "LC1/d;", "LE1/c;", "Landroidx/lifecycle/e;", "<init>", "()V", "Landroid/graphics/drawable/Drawable;", "placeholder", "LY8/t;", "c", "(Landroid/graphics/drawable/Drawable;)V", "error", Const.INTENT_KEY_UMID, "result", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/LifecycleOwner;", "owner", UxipConstants.f30640D, "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "drawable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "", "Z", "isStarted", "e", "()Landroid/graphics/drawable/Drawable;", "f", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class a<T extends View> implements d<T>, E1.c, InterfaceC1387e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean isStarted;

    @Override // C1.c
    public void a(Drawable result) {
        h(result);
    }

    @Override // C1.c
    public void c(Drawable placeholder) {
        h(placeholder);
    }

    @Override // C1.c
    public void d(Drawable error) {
        h(error);
    }

    public abstract Drawable e();

    public abstract void f(Drawable drawable);

    public final void g() {
        Object objE = e();
        Animatable animatable = objE instanceof Animatable ? (Animatable) objE : null;
        if (animatable == null) {
            return;
        }
        if (this.isStarted) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    public final void h(Drawable drawable) {
        Object objE = e();
        Animatable animatable = objE instanceof Animatable ? (Animatable) objE : null;
        if (animatable != null) {
            animatable.stop();
        }
        f(drawable);
        g();
    }

    @Override // android.view.InterfaceC1387e
    public void onStart(LifecycleOwner owner) {
        this.isStarted = true;
        g();
    }

    @Override // android.view.InterfaceC1387e
    public void onStop(LifecycleOwner owner) {
        this.isStarted = false;
        g();
    }
}
