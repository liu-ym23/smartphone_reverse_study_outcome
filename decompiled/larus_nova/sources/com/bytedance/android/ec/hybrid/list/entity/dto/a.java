package com.bytedance.android.ec.hybrid.list.entity.dto;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f47089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, ? extends Object> f47090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, ? extends Object> f47091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f47092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f47093h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        if (this.f47086a == r101.f47086a) goto L8;
        return false;
    L8:
        if (this.f47087b == r101.f47087b) goto L10;
        return false;
    L10:
        if (this.f47088c == r101.f47088c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f47089d, r101.f47089d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f47090e, r101.f47090e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f47091f, r101.f47091f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f47092g, r101.f47092g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f47093h, r101.f47093h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((this.f47086a * 31) + this.f47087b) * 31) + this.f47088c) * 31;
        String r101 = this.f47089d;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, ? extends Object> r105 = this.f47090e;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, ? extends Object> r108 = this.f47091f;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f47092g;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f47093h;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ECHybridCommonData(pageNum=" + this.f47086a + ", indexInPage=" + this.f47087b + ", curPageCardNum=" + this.f47088c + ", sessionId=" + this.f47089d + ", abValues=" + this.f47090e + ", logCommonData=" + this.f47091f + ", ecomSceneId=" + this.f47092g + ", nextPageCursor=" + this.f47093h + ")";
    }

    public final a a() {
        Object r100 = super.clone();
        if (r100 == null) goto L7;
        return (a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridCommonData");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public /* synthetic */ a(int r110, String r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r112 & 4) == 0) goto L9;
        int r101 = -1;
    L11:
        if ((r112 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r112 & 64) == 0) goto L17;
        String r113 = null;
    L18:
        this(r110, r100, r101, r102, null, null, r113, null);
        return;
    L17:
        r113 = r111;
        goto L18
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }

    public a(int r100, int r101, int r102, String r103, Map<String, ? extends Object> r104, Map<String, ? extends Object> r105, String r106, Integer r107) {
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        this.f47086a = r100;
        this.f47087b = r101;
        this.f47088c = r102;
        this.f47089d = r103;
        this.f47090e = r104;
        this.f47091f = r105;
        this.f47092g = r106;
        this.f47093h = r107;
    }
}
