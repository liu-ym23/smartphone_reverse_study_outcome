package com.bytedance.ai.applet.grantingV2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowResult f34665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u2.a f34668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u2.f f34669e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f34665a == r101.f34665a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34666b, r101.f34666b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34667c, r101.f34667c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34668d, r101.f34668d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34669e, r101.f34669e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f34665a.hashCode() * 31;
        String r101 = this.f34666b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f34667c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        u2.a r108 = this.f34668d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        u2.f r111 = this.f34669e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionHandleResult(flowResult=" + this.f34665a + ", toastType=" + this.f34666b + ", toastMessage=" + this.f34667c + ", cardData=" + this.f34668d + ", item=" + this.f34669e + ')';
    }

    public /* synthetic */ a(FlowResult r100, u2.a r101, u2.f r102) {
        this(r100, null, null, r101, r102);
    }

    public a(FlowResult r100, String r101, String r102, u2.a r103, u2.f r104) {
        Intrinsics.checkNotNullParameter(r100, "flowResult");
        this.f34665a = r100;
        this.f34666b = r101;
        this.f34667c = r102;
        this.f34668d = r103;
        this.f34669e = r104;
    }
}
