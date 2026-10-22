package T;

import android.util.Size;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.z;

/* loaded from: classes.dex */
public final class d {
    public static void a(z.b<?, ?, ?> bVar, int i10) {
        Size sizeS;
        s sVar = (s) bVar.d();
        int I10 = sVar.I(-1);
        if (I10 == -1 || I10 != i10) {
            ((s.a) bVar).b(i10);
        }
        if (I10 == -1 || i10 == -1 || I10 == i10) {
            return;
        }
        if (Math.abs(M.c.b(i10) - M.c.b(I10)) % 180 != 90 || (sizeS = sVar.S(null)) == null) {
            return;
        }
        ((s.a) bVar).c(new Size(sizeS.getHeight(), sizeS.getWidth()));
    }
}
