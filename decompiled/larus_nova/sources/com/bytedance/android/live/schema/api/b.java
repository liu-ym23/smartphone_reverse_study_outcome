package com.bytedance.android.live.schema.api;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f100493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f100494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f100495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f100496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f100497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f100498f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f100494b, r101.f100494b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f100495c, r101.f100495c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f100496d, r101.f100496d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f100497e, r101.f100497e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f100498f, r101.f100498f) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f100494b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f100495c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f100496d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f100497e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f100498f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WebcastRedirectInfo(raw=" + this.f100494b + ", key=" + this.f100495c + ", schemaQuery=" + this.f100496d + ", urlQuery=" + this.f100497e + ", defaultSchema=" + this.f100498f + ")";
    }

    public b(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f100494b = r100;
        this.f100495c = r101;
        this.f100496d = r102;
        this.f100497e = r103;
        this.f100498f = r104;
    }
}
