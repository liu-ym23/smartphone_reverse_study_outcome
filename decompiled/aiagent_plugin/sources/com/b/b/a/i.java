package com.b.b.a;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PinyinMapDict.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements h {
    public abstract Map<String, String[]> b();

    public i() {
    }

    @Override // com.b.b.a.h
    public Set<String> a() {
        if (b() != null) goto L7;
        return null;
    L7:
        return b().keySet();
    }
}
