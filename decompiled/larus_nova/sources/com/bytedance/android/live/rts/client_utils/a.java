package com.bytedance.android.live.rts.client_utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f100461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f100462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f100463c;

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f100461a, r101.f100461a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f100462b, r101.f100462b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f100463c, r101.f100463c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f100461a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f100462b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f100463c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetClientSettingParams(key=" + this.f100461a + ", type=" + this.f100462b + ", path=" + this.f100463c + ")";
    }

    public final String getType() {
        return this.f100462b;
    }

    public a(String r100, String r101, String r102) {
        this.f100461a = r100;
        this.f100462b = r101;
        this.f100463c = r102;
    }
}
