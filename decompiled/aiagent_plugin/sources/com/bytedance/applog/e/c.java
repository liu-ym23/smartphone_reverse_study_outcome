package com.bytedance.applog.e;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: BlockEventFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(com.bytedance.applog.c r1, HashSet<String> r2, HashMap<String, HashSet<String>> r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.applog.e.a
    public boolean a(String r2) {
        if (this.f5576a != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f5576a.contains(r2) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.applog.e.a
    public boolean a(HashSet<String> r1, String r2) {
        return r1.contains(r2);
    }

    @Override // com.bytedance.applog.e.e
    public boolean a() {
        if (this.f5576a == null) goto L7;
        if (this.f5576a.isEmpty() == true) goto L7;
    L11:
        return false;
    L7:
        if (this.f5577b != null) goto L9;
    L12:
        return true;
    L9:
        if (this.f5577b.isEmpty() == false) goto L11;
        goto L11
    }
}
