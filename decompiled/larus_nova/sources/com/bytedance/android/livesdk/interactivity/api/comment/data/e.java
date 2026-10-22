package com.bytedance.android.livesdk.interactivity.api.comment.data;

import kotlin.jvm.internal.Intrinsics;
import u22.m;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f133036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m.a f133037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputDraftType f133038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f133039d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f133036a, r101.f133036a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f133037b, r101.f133037b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f133038c, r101.f133038c) == true) goto L12;
        return false;
    L12:
        if (this.f133039d == r101.f133039d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        CharSequence r100 = this.f133036a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        m.a r104 = this.f133037b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        InputDraftType r107 = this.f133038c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f133039d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InputDraftItem(content=" + this.f133036a + ", atParams=" + this.f133037b + ", type=" + this.f133038c + ", sceneId=" + this.f133039d + ")";
    }

    public final InputDraftType getType() {
        return this.f133038c;
    }

    public e(CharSequence r100, InputDraftType r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f133036a = r100;
        this.f133037b = null;
        this.f133038c = r101;
        this.f133039d = r102;
    }
}
