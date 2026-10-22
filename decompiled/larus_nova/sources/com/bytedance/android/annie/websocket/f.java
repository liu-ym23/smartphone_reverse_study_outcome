package com.bytedance.android.annie.websocket;

import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f40117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f40118c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f40116a, r101.f40116a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f40117b, r101.f40117b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f40118c, r101.f40118c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f40116a.hashCode() * 31;
        JsonObject r101 = this.f40117b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<String> r105 = this.f40118c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RequestTask(url=" + this.f40116a + ", header=" + this.f40117b + ", protocols=" + this.f40118c + ')';
    }

    public f(String r100, JsonObject r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f40116a = r100;
        this.f40117b = r101;
        this.f40118c = r102;
    }
}
