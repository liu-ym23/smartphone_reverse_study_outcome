package com.bytedance.bdinstall.i;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ITicketGuard.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    List<Map<String, String>> a(long r1, String r3, String r4, boolean r5, List<Pair<String, String>> r6, String r7);

    List<Pair<String, String>> a(String r1, String r2, String r3, boolean r4);

    List<Pair<String, String>> a(String r1, boolean r2, boolean r3, String r4);

    Map<String, Long> a();

    void a(c r1);

    byte[] a(byte[] r1);
}
