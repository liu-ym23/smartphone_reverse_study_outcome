package com.bytedance.android.ecom.arch.slice.render.bindinfo;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f50125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f50126c;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f50124a == r101.f50124a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f50125b, r101.f50125b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f50126c, r101.f50126c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f50124a * 31;
        Object r101 = this.f50125b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, ? extends Object> r105 = this.f50126c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ForConfigValue(index=" + this.f50124a + ", item=" + this.f50125b + ", dataCtx=" + this.f50126c + ")";
    }

    public a(int r100, Object r101) {
        this.f50124a = r100;
        this.f50125b = r101;
        this.f50126c = null;
    }
}
