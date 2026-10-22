package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurface;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class n {
    public static void a(List<DeferrableSurface> list) {
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public static void b(List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (list.isEmpty()) {
            return;
        }
        int i10 = 0;
        do {
            try {
                list.get(i10).l();
                i10++;
            } catch (DeferrableSurface.SurfaceClosedException e10) {
                for (int i11 = i10 - 1; i11 >= 0; i11--) {
                    list.get(i11).e();
                }
                throw e10;
            }
        } while (i10 < list.size());
    }
}
