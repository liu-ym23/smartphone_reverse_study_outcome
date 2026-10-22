package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.api.window.AwemeInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends p {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f189611q = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f189612n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f189613o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f189614p;

    public static final class a {
    }

    static {
    }

    public final AwemeInfo e() {
        return (AwemeInfo) this.f189613o.getValue();
    }

    public final int hashCode() {
        e r100 = this.f189622j;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        WindowV2ProductItemVO r104 = this.f189623k;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f189624l == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f189625m == true) goto L18;
        r107 = 1237;
    L18:
        int r110 = (r109 + r107) * 31;
        AwemeInfo r111 = e();
        if (r111 == null) goto L21;
        String r112 = r111.a();
    L22:
        if (r112 == null) goto L25;
        r101 = r112.hashCode();
    L25:
        return r110 + r101;
    L21:
        r112 = null;
        goto L22
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.f189623k;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        String r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(o.class, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L37;
        o r103 = (o) r100;
        if ((!Intrinsics.areEqual(this.f189622j, r103.f189622j)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f189623k, r103.f189623k)) == false) goto L20;
        return false;
    L20:
        if (this.f189624l == r103.f189624l) goto L23;
        return false;
    L23:
        if (this.f189625m == r103.f189625m) goto L25;
        return false;
    L25:
        AwemeInfo r104 = e();
        if (r104 == null) goto L28;
        String r105 = r104.a();
    L29:
        AwemeInfo r106 = r103.e();
        if (r106 == null) goto L33;
        r101 = r106.a();
    L33:
        if ((!Intrinsics.areEqual(r105, r101)) == false) goto L35;
        return false;
    L35:
        return true;
    L28:
        r105 = null;
        goto L29
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.WindowHangingProductVideoVO");
    L8:
        r102 = null;
        goto L10
    }

    public o(e r100, tq3.c r101, boolean r102, boolean r110, String r111) {
        super(r100, r101, r102, r110, 207);
        this.f189614p = r111;
        this.f189613o = LazyKt.lazy(new WindowHangingProductVideoVO$awemeInfo$2(this));
    }
}
