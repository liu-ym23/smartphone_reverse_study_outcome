package com.bytedance.android.btm.api.model;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<JSONObject, Unit> f42051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f42052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f42053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f42054d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L14;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f42051a, r101.f42051a) == true) goto L8;
        return false;
    L8:
        if (this.f42052b == r101.f42052b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f42053c, r101.f42053c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f42054d, r101.f42054d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Function1<JSONObject, Unit> r100 = this.f42051a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f42052b) * 31;
        String r104 = this.f42053c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f42054d;
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
        return "ErrInfo(categoryCallback=" + this.f42051a + ", errorCode=" + this.f42052b + ", msg=" + this.f42053c + ", type=" + this.f42054d + ")";
    }

    public final String getType() {
        return this.f42054d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function1<? super JSONObject, Unit> r100, int r101, String r102, String r103) {
        this.f42051a = r100;
        this.f42052b = r101;
        this.f42053c = r102;
        this.f42054d = r103;
    }
}
