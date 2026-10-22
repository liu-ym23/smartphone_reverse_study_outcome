package h6;

import android.graphics.drawable.Drawable;
import e6.j;
import e6.q;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import u5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public m f5391a;

    /* renamed from: b, reason: collision with root package name */
    public j f5392b;

    /* renamed from: c, reason: collision with root package name */
    public int f5393c;

    @Override // h6.f
    public final void a() {
        this.f5391a.getClass();
        j jVar = this.f5392b;
        Drawable drawableA = jVar.a();
        f6.f fVar = jVar.b().f3569x;
        int i = this.f5393c;
        boolean z10 = jVar instanceof q;
        boolean z11 = (z10 && ((q) jVar).f3598g) ? false : true;
        x5.a aVar = new x5.a();
        aVar.f15574c = fVar;
        aVar.f15575f = i;
        aVar.f15576g = z11;
        aVar.f15577h = new ArrayList();
        aVar.i = aVar.a(null, drawableA != null ? Integer.valueOf(drawableA.getIntrinsicWidth()) : null);
        aVar.f15578j = aVar.a(null, drawableA != null ? Integer.valueOf(drawableA.getIntrinsicHeight()) : null);
        aVar.f15580l = 255;
        aVar.f15582n = null;
        Drawable drawableMutate = drawableA != null ? drawableA.mutate() : null;
        aVar.f15583o = drawableMutate;
        if (i <= 0) {
            g5.f.s("durationMillis must be > 0.");
            return;
        }
        Drawable drawable = aVar.f15582n;
        if (drawable != null) {
            drawable.setCallback(aVar);
        }
        if (drawableMutate != null) {
            drawableMutate.setCallback(aVar);
        }
        VarHandle.storeStoreFence();
        if (z10 || (jVar instanceof e6.e)) {
            return;
        }
        g5.f.a();
    }
}
