package com.amap.api.col.jmsl;

/* renamed from: com.amap.api.col.jmsl.o2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1589o2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f16792a;

    public C1589o2(String str) {
        this.f16792a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1589o2.class != obj.getClass()) {
            return false;
        }
        return this.f16792a.equals(((C1589o2) obj).f16792a);
    }

    public int hashCode() {
        return this.f16792a.hashCode();
    }

    public String toString() {
        return this.f16792a;
    }
}
