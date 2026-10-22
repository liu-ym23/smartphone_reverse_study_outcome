package com.bytedance.crash.l;

import android.util.Pair;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IMultipartService.java */
/* JADX INFO: loaded from: classes.dex */
public interface d {
    Pair<Integer, String> a();

    void a(File r1, Map<String, String> r2);

    void a(String r1, File r2);

    void a(String r1, String r2);

    void a(String r1, List<File> r2);

    void a(String r1, byte[] r2);
}
