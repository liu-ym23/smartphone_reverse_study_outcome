package com.bytedance.android.livesdk.event;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f123364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f123365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f123366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f123367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBaseUser f123368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f123369f;

    public final String toString() {
        return "MentionSendInfo(type=" + getType() + ", value=" + this.f123365b + ", start=" + this.f123366c + ", length=" + this.f123367d + ", user=" + this.f123368e + ", isFromMentionList=" + this.f123369f + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r100 = getType() * 31;
        String r101 = this.f123365b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f123366c) * 31) + this.f123367d) * 31;
        IBaseUser r105 = this.f123368e;
        if (r105 == null) goto L9;
        r102 = r105.hashCode();
    L9:
        int r106 = (r104 + r102) * 31;
        boolean r107 = this.f123369f;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        return r106 + r108;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getLength() {
        return this.f123367d;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getStart() {
        return this.f123366c;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public int getType() {
        return this.f123364a;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final String getValue() {
        return this.f123365b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L18;
        r r101 = (r) r100;
        if (getType() == r101.getType()) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f123365b, r101.f123365b) == true) goto L10;
        return false;
    L10:
        if (this.f123366c == r101.f123366c) goto L12;
        return false;
    L12:
        if (this.f123367d == r101.f123367d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f123368e, r101.f123368e) == true) goto L16;
        return false;
    L16:
        if (this.f123369f == r101.f123369f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public r(int r100, String r101, int r102, int r103, IBaseUser r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f123364a = r100;
        this.f123365b = r101;
        this.f123366c = r102;
        this.f123367d = r103;
        this.f123368e = r104;
        this.f123369f = r105;
    }
}
