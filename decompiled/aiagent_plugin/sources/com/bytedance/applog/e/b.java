package com.bytedance.applog.e;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: AllowEventFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    @Override // com.bytedance.applog.e.e
    public boolean a() {
        return false;
    }

    public b(com.bytedance.applog.c r1, HashSet<String> r2, HashMap<String, HashSet<String>> r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.applog.e.a
    public boolean a(String r1) {
        return !this.f5576a.contains(r1);
    }

    @Override // com.bytedance.applog.e.a
    public boolean a(HashSet<String> r1, String r2) {
        return !r1.contains(r2);
    }
}
