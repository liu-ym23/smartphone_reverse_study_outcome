package com.baidu.mapsdkplatform.comapi.a.a;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes39.dex */
public class c implements Comparator {
    public c() {
    }

    @Override // java.util.Comparator
    public int compare(Object r100, Object r101) {
        File r102 = (File) r101;
        String[] r103 = ((File) r100).getName().split("_");     // Catch: Exception -> L5
        return r102.getName().split("_")[2].compareTo(r103[2]);
    L5:
        return 0;
    }
}
