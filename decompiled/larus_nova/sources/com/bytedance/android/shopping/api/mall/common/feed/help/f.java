package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.bytedance.android.ec.hybrid.list.entity.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f170266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f170267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f170268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f170269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f170270f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f170265a, r101.f170265a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170266b, r101.f170266b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170267c, r101.f170267c) == true) goto L12;
        return false;
    L12:
        if (this.f170268d == r101.f170268d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170269e, r101.f170269e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170270f, r101.f170270f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170265a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<m> r104 = this.f170266b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f170267c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f170268d) * 31;
        Map<String, Object> r110 = this.f170269e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.f170270f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallTransBffEventDataParams(eventName=" + this.f170265a + ", paramsFromClient=" + this.f170266b + ", fillMap=" + this.f170267c + ", itemIndexInSection=" + this.f170268d + ", paramsFromGlobal=" + this.f170269e + ", specialData=" + this.f170270f + ")";
    }

    public f(String r100, List<m> r101, Map<String, Object> r102, int r103, Map<String, ? extends Object> r104, Map<String, ? extends Object> r105) {
        this.f170265a = r100;
        this.f170266b = r101;
        this.f170267c = r102;
        this.f170268d = r103;
        this.f170269e = r104;
        this.f170270f = r105;
    }
}
