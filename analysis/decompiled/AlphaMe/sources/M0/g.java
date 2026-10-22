package M0;

import L0.m;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.v;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class g extends b {

    /* renamed from: v, reason: collision with root package name */
    public final G0.d f1414v;

    public g(v vVar, e eVar) {
        super(vVar, eVar);
        G0.d dVar = new G0.d(vVar, this, new m("__container", eVar.f1393a));
        this.f1414v = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // M0.b, G0.e
    public final void h(RectF rectF, Matrix matrix) {
        super.h(rectF, matrix);
        this.f1414v.h(rectF, this.f1373l);
    }

    @Override // M0.b
    public final void k(Canvas canvas, Matrix matrix, int i4) {
        this.f1414v.d(canvas, matrix, i4);
    }

    @Override // M0.b
    public final void n(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        this.f1414v.g(eVar, i4, arrayList, eVar2);
    }
}
