package h;

import android.graphics.drawable.Drawable;
import p0.e;

/* renamed from: h.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0584b implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12687a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12688b;

    public C0584b(e eVar) {
        this.f12688b = eVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f12687a) {
            case 0:
                break;
            default:
                ((e) this.f12688b).invalidateSelf();
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        switch (this.f12687a) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f12688b;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j4);
                    break;
                }
                break;
            default:
                ((e) this.f12688b).scheduleSelf(runnable, j4);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f12687a) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f12688b;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                    break;
                }
                break;
            default:
                ((e) this.f12688b).unscheduleSelf(runnable);
                break;
        }
    }
}
