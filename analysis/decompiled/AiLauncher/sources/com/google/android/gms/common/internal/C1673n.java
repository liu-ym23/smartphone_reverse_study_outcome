package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

/* renamed from: com.google.android.gms.common.internal.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1673n implements a.d {

    /* renamed from: b, reason: collision with root package name */
    public static final C1673n f19838b = a().a();

    /* renamed from: a, reason: collision with root package name */
    public final String f19839a;

    /* renamed from: com.google.android.gms.common.internal.n$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f19840a;

        public /* synthetic */ a(C1676q c1676q) {
        }

        public C1673n a() {
            return new C1673n(this.f19840a, null);
        }

        public a b(String str) {
            this.f19840a = str;
            return this;
        }
    }

    public /* synthetic */ C1673n(String str, r rVar) {
        this.f19839a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        String str = this.f19839a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1673n) {
            return C1668i.a(this.f19839a, ((C1673n) obj).f19839a);
        }
        return false;
    }

    public final int hashCode() {
        return C1668i.b(this.f19839a);
    }
}
