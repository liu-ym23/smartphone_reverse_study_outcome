package k2;

import android.text.TextPaint;
import d1.f0;
import d1.i0;
import d2.o;
import d2.q;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final l f7206a = new l(false);

    public static final void a(o oVar, d1.o oVar2, f0 f0Var, float f5, i0 i0Var, n2.l lVar, td.h hVar) {
        ArrayList arrayList = oVar.f3156h;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            q qVar = (q) arrayList.get(i);
            qVar.f3159a.f(oVar2, f0Var, f5, i0Var, lVar, hVar);
            oVar2.n(0.0f, qVar.f3159a.b());
        }
    }

    public static final void b(TextPaint textPaint, float f5) {
        if (Float.isNaN(f5)) {
            return;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        textPaint.setAlpha(Math.round(f5 * 255));
    }
}
