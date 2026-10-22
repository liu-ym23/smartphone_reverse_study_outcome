package com.bytedance.bdtracker;

import java.util.UUID;

/* loaded from: classes.dex */
public class o5 {
    public static a5<String> a = new a();

    public static class a extends a5<String> {
        @Override // com.bytedance.bdtracker.a5
        public String a(Object[] objArr) {
            return UUID.randomUUID().toString();
        }
    }

    public static String a() {
        return a.b(new Object[0]);
    }
}
