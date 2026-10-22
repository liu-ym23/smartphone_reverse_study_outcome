package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.C1668i;

/* renamed from: com.google.android.gms.common.api.internal.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1635b<O extends a.d> {

    /* renamed from: a, reason: collision with root package name */
    public final int f19590a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.api.a f19591b;

    /* renamed from: c, reason: collision with root package name */
    public final a.d f19592c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19593d;

    public C1635b(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        this.f19591b = aVar;
        this.f19592c = dVar;
        this.f19593d = str;
        this.f19590a = C1668i.b(aVar, dVar, str);
    }

    public static <O extends a.d> C1635b<O> a(com.google.android.gms.common.api.a<O> aVar, O o10, String str) {
        return new C1635b<>(aVar, o10, str);
    }

    public final String b() {
        return this.f19591b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1635b)) {
            return false;
        }
        C1635b c1635b = (C1635b) obj;
        return C1668i.a(this.f19591b, c1635b.f19591b) && C1668i.a(this.f19592c, c1635b.f19592c) && C1668i.a(this.f19593d, c1635b.f19593d);
    }

    public final int hashCode() {
        return this.f19590a;
    }
}
