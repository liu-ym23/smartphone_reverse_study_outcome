package d5;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import k0.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Drawable.Callback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3198c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3199f;

    public /* synthetic */ c(int i) {
        this.f3198c = i;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f3198c) {
            case 0:
                ((f) this.f3199f).invalidateSelf();
                break;
            default:
                drawable.getClass();
                o6.a aVar = (o6.a) this.f3199f;
                k1 k1Var = aVar.f9232j;
                k1Var.setValue(Integer.valueOf(((Number) k1Var.getValue()).intValue() + 1));
                Drawable drawable2 = aVar.i;
                Object obj = o6.c.f9236a;
                aVar.f9233k.setValue(c1.e.a((drawable2.getIntrinsicWidth() < 0 || drawable2.getIntrinsicHeight() < 0) ? 9205357640488583168L : a.a.e(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight())));
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, jb.d] */
    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        switch (this.f3198c) {
            case 0:
                ((f) this.f3199f).scheduleSelf(runnable, j10);
                break;
            default:
                drawable.getClass();
                runnable.getClass();
                ((Handler) o6.c.f9236a.getValue()).postAtTime(runnable, j10);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, jb.d] */
    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f3198c) {
            case 0:
                ((f) this.f3199f).unscheduleSelf(runnable);
                break;
            default:
                drawable.getClass();
                runnable.getClass();
                ((Handler) o6.c.f9236a.getValue()).removeCallbacks(runnable);
                break;
        }
    }
}
