package com.bytedance.bdtracker;

import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class f1 extends e1 {
    public f1(HashSet<String> hashSet, HashMap<String, HashSet<String>> map) {
        super(hashSet, map);
    }

    @Override // com.bytedance.bdtracker.e1
    public boolean a(String str) {
        return !this.a.contains(str);
    }

    @Override // com.bytedance.bdtracker.e1
    public boolean a(HashSet<String> hashSet, String str) {
        return !hashSet.contains(str);
    }
}
