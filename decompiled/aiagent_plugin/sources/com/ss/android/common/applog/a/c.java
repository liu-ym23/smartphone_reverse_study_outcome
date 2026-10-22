package com.ss.android.common.applog.a;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: WhiteEventFilter.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends a {
    public c(HashSet<String> r1, HashMap<String, HashSet<String>> r2) {
        super(r1, r2);
    }

    @Override // com.ss.android.common.applog.a.a
    public boolean a(String r1) {
        return !this.f37146a.contains(r1);
    }

    @Override // com.ss.android.common.applog.a.a
    public boolean a(HashSet<String> r1, String r2) {
        return !r1.contains(r2);
    }
}
