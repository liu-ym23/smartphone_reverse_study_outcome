package androidx.camera.core.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList;

    public SurfaceCombination() {
        this.mSurfaceConfigList = new ArrayList();
    }

    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    private List<int[]> getElementsArrangements(int r100) {
        ArrayList r101 = new ArrayList();
        generateArrangements(r101, r100, new int[r100], 0);
        return r101;
    }

    public boolean addSurfaceConfig(SurfaceConfig r100) {
        return this.mSurfaceConfigList.add(r100);
    }

    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(List<SurfaceConfig> r110) {
        if (r110.isEmpty() == false) goto L7;
        return new ArrayList();
    L7:
        if (r110.size() == this.mSurfaceConfigList.size()) goto L9;
        return null;
    L9:
        List<int[]> r100 = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] r101 = new SurfaceConfig[r110.size()];
        Iterator<int[]> r102 = r100.iterator();
    L10:
        int r103 = 0;
        if (r102.hasNext() == false) goto L24;
        int[] r104 = r102.next();
        boolean r105 = true;
    L14:
        if (r103 >= this.mSurfaceConfigList.size()) goto L22;
        if (r104[r103] >= r110.size()) goto L21;
        r105 = r105 & ((SurfaceConfig) ListProtector.get(this.mSurfaceConfigList, r103)).isSupported((SurfaceConfig) ListProtector.get(r110, r104[r103]));
        if (r105 == false) goto L22;
        r101[r104[r103]] = (SurfaceConfig) ListProtector.get(this.mSurfaceConfigList, r103);
    L21:
        r103 = r103 + 1;
    L22:
        if (r105 == false) goto L10;
        r103 = 1;
    L24:
        if (r103 != 0) goto L26;
        return null;
    L26:
        return Arrays.asList(r101);
    }

    public boolean removeSurfaceConfig(SurfaceConfig r100) {
        return this.mSurfaceConfigList.remove(r100);
    }

    private static void generateArrangements(List<int[]> r100, int r101, int[] r102, int r103) {
        if (r103 < r102.length) goto L6;
        r100.add((int[]) r102.clone());
        return;
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L18;
        int r105 = 0;
    L9:
        if (r105 >= r103) goto L14;
        if (r104 == r102[r105]) goto L12;
        r105 = r105 + 1;
        goto L9
    L12:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        r102[r103] = r104;
        generateArrangements(r100, r101, r102, r103 + 1);
    L17:
        r104 = r104 + 1;
        goto L7
    L14:
        r106 = false;
        goto L15
    }
}
