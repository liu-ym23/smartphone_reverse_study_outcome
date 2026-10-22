package com.bytedance.android.livesdk.message.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class mj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f153666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f153668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f153669d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof mj) == false) goto L14;
        mj r101 = (mj) r100;
        if (this.f153666a == r101.f153666a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f153667b, r101.f153667b) == true) goto L10;
        return false;
    L10:
        if (this.f153668c == r101.f153668c) goto L12;
        return false;
    L12:
        if (this.f153669d == r101.f153669d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f153666a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f153667b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L9:
        int r105 = (((r102 + r104) * 31) + this.f153668c) * 31;
        long r106 = this.f153669d;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L8:
        r104 = 0;
        goto L9
    }

    public final String toString() {
        return "RemindMessageModel(show=" + this.f153666a + ", content=" + this.f153667b + ", type=" + this.f153668c + ", duration=" + this.f153669d + ")";
    }

    public final int getType() {
        return this.f153668c;
    }

    public mj(boolean r100, String r101, long r102) {
        this.f153666a = r100;
        this.f153667b = r101;
        this.f153668c = 1003;
        this.f153669d = r102;
    }
}
