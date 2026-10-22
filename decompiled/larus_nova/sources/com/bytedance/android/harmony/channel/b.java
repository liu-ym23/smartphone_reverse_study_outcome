package com.bytedance.android.harmony.channel;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E f58180c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f58178a, r101.f58178a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f58179b, r101.f58179b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f58180c, r101.f58180c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f58178a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f58179b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        E r107 = this.f58180c;
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
        return "Error(category=" + this.f58178a + ", message=" + this.f58179b + ", extra=" + this.f58180c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, String r101, JsonObject r102) {
        this.f58178a = r100;
        this.f58179b = r101;
        this.f58180c = r102;
    }
}
