package com.google.protobuf;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class K2 {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a, reason: collision with root package name */
    public List f2849a;
    public List b;
    public List c;
    public List d;
    public List e;

    static {
        new J2().a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K2)) {
            return false;
        }
        K2 k22 = (K2) obj;
        return Arrays.equals(new Object[]{this.f2849a, this.b, this.c, this.d, this.e}, new Object[]{k22.f2849a, k22.b, k22.c, k22.d, k22.e});
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2849a, this.b, this.c, this.d, this.e});
    }
}
