package K;

import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class B0 {

    /* renamed from: a, reason: collision with root package name */
    public final List<SurfaceConfig> f3869a = new ArrayList();

    public static void b(List<int[]> list, int i10, int[] iArr, int i11) {
        if (i11 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = 0;
            while (true) {
                if (i13 >= i11) {
                    iArr[i11] = i12;
                    b(list, i10, iArr, i11 + 1);
                    break;
                } else if (i12 == iArr[i13]) {
                    break;
                } else {
                    i13++;
                }
            }
        }
    }

    public boolean a(SurfaceConfig surfaceConfig) {
        return this.f3869a.add(surfaceConfig);
    }

    public final List<int[]> c(int i10) {
        ArrayList arrayList = new ArrayList();
        b(arrayList, i10, new int[i10], 0);
        return arrayList;
    }

    public List<SurfaceConfig> d(List<SurfaceConfig> list) {
        int i10;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.f3869a.size()) {
            return null;
        }
        List<int[]> listC = c(this.f3869a.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        Iterator<int[]> it = listC.iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            boolean zG = true;
            while (i10 < this.f3869a.size()) {
                if (next[i10] < list.size()) {
                    zG &= this.f3869a.get(i10).g(list.get(next[i10]));
                    if (!zG) {
                        break;
                    }
                    surfaceConfigArr[next[i10]] = this.f3869a.get(i10);
                }
                i10++;
            }
            if (zG) {
                i10 = 1;
                break;
            }
        }
        if (i10 != 0) {
            return Arrays.asList(surfaceConfigArr);
        }
        return null;
    }
}
