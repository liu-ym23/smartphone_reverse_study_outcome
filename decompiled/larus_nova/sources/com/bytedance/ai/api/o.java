package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f34054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f34058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f34059f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f34054a == r101.f34054a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34055b, r101.f34055b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34056c, r101.f34056c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34057d, r101.f34057d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34058e, r101.f34058e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f34059f, r101.f34059f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f34054a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f34055b.hashCode()) * 31) + this.f34056c.hashCode()) * 31;
        String r102 = this.f34057d;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f34058e;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        JSONObject r109 = this.f34059f;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "LiveCardClientResult(ok=" + this.f34054a + ", sessionKey=" + this.f34055b + ", sessionTag=" + this.f34056c + ", errorCode=" + this.f34057d + ", errorMessage=" + this.f34058e + ", detail=" + this.f34059f + ')';
    }

    public /* synthetic */ o(String r100, String r101, String r110, String r111) {
        this(false, r100, r101, r110, r111, null);
    }

    public o(boolean r100, String r101, String r102, String r103, String r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r101, "sessionKey");
        Intrinsics.checkNotNullParameter(r102, "sessionTag");
        this.f34054a = r100;
        this.f34055b = r101;
        this.f34056c = r102;
        this.f34057d = r103;
        this.f34058e = r104;
        this.f34059f = r105;
    }
}
