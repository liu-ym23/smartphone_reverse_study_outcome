package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventType f38179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f38180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, d> f38181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f38182d;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f38179a, r101.f38179a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f38180b, r101.f38180b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f38181c, r101.f38181c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f38182d, r101.f38182d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        EventType r100 = this.f38179a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f38180b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, d> r107 = this.f38181c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f38182d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "EventConfigDsl(type='" + this.f38179a + "', label=" + this.f38180b + ", map=" + this.f38181c + ", extra=" + this.f38182d + ')';
    }

    public final EventType getType() {
        return this.f38179a;
    }

    public b(EventType r100, d r101, Map r102) {
        this.f38179a = r100;
        this.f38180b = r101;
        this.f38181c = r102;
        this.f38182d = null;
    }
}
