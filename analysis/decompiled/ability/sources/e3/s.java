package e3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import d3.C1376a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class s extends y {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Matrix d;

    public s(ArrayList arrayList, Matrix matrix) {
        this.c = arrayList;
        this.d = matrix;
    }

    @Override // e3.y
    public final void a(Matrix matrix, C1376a c1376a, int i, Canvas canvas) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((y) it.next()).a(this.d, c1376a, i, canvas);
        }
    }
}
