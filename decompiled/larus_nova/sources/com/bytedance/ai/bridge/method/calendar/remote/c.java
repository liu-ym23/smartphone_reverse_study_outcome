package com.bytedance.ai.bridge.method.calendar.remote;

import evc.j;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Property.NodeInfo f35411d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f35412e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f35413f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Property> f35414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f35415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Error> f35416c;

    public static final class a {
    }

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f35414a, r101.f35414a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f35415b, r101.f35415b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f35416c, r101.f35416c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f35414a.hashCode() * 31) + this.f35415b.hashCode()) * 31;
        List<Error> r101 = this.f35416c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PropStat(properties=" + this.f35414a + ", status=" + this.f35415b + ", error=" + this.f35416c + ')';
    }

    static {
        f35411d = new Property.NodeInfo("DAV:", "propstat");
        Protocol r100 = Protocol.HTTP_1_1;
        f35412e = new j(r100, 200, "Assuming OK");
        f35413f = new j(r100, 500, "Invalid status line");
    }

    public c(List r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "properties");
        Intrinsics.checkNotNullParameter(r101, "status");
        this.f35414a = r100;
        this.f35415b = r101;
        this.f35416c = null;
    }
}
