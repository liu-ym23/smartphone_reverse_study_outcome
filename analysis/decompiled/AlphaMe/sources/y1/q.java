package y1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x1.C0980a;

/* loaded from: classes.dex */
public final class q extends w {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f16297c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f16298d;

    public q(ArrayList arrayList, Matrix matrix) {
        this.f16297c = arrayList;
        this.f16298d = matrix;
    }

    @Override // y1.w
    public final void a(Matrix matrix, C0980a c0980a, int i4, Canvas canvas) {
        Iterator it = this.f16297c.iterator();
        while (it.hasNext()) {
            ((w) it.next()).a(this.f16298d, c0980a, i4, canvas);
        }
    }
}
