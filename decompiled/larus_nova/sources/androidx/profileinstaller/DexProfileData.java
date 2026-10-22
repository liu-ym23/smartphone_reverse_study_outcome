package androidx.profileinstaller;

import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
class DexProfileData {
    final String apkName;
    int classSetSize;
    int[] classes;
    final long dexChecksum;
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    public DexProfileData(String r100, String r101, long r102, long r103, int r104, int r105, int r106, int[] r110, TreeMap<Integer, Integer> r111) {
        this.apkName = r100;
        this.dexName = r101;
        this.dexChecksum = r102;
        this.mTypeIdCount = r103;
        this.classSetSize = r104;
        this.hotMethodRegionSize = r105;
        this.numMethodIds = r106;
        this.classes = r110;
        this.methods = r111;
    }
}
