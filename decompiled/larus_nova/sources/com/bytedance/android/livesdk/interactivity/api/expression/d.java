package com.bytedance.android.livesdk.interactivity.api.expression;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f133203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f133204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f133205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f133206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBaseUser f133207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f133208f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (this.f133203a == r101.f133203a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f133204b, r101.f133204b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f133205c, r101.f133205c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f133206d, r101.f133206d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f133207e, r101.f133207e) == true) goto L16;
        return false;
    L16:
        if (this.f133208f == r101.f133208f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public final int hashCode() {
        int r100 = this.f133203a * 31;
        String r101 = this.f133204b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f133205c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f133206d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        IBaseUser r111 = this.f133207e;
        if (r111 == null) goto L17;
        r102 = r111.hashCode();
    L17:
        int r112 = (r110 + r102) * 31;
        boolean r113 = this.f133208f;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        return r112 + r114;
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
        return "MentionSpanParam(color=" + this.f133203a + ", text=" + this.f133204b + ", userId=" + this.f133205c + ", webcastUid=" + this.f133206d + ", user=" + this.f133207e + ", isFromMentionList=" + this.f133208f + ")";
    }

    public d(int r100, String r101, String r102, String r103, IBaseUser r104, boolean r105) {
        this.f133203a = r100;
        this.f133204b = r101;
        this.f133205c = r102;
        this.f133206d = r103;
        this.f133207e = r104;
        this.f133208f = r105;
    }
}
