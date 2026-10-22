package com.bytedance.android.live.room.api.messagewindow.monitor;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f99005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f99006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f99007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f99008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f99009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f99010g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f99010g, ((e) r100).f99010g) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        f r100 = this.f99010g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CardNode(builder=" + this.f99010g + ")";
    }

    public e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f99010g = r100;
        this.f99004a = r100.f99016f;
        this.f99005b = r100.f99011a;
        this.f99006c = r100.f99012b;
        this.f99007d = r100.f99013c;
        this.f99008e = r100.f99014d;
        this.f99009f = r100.f99015e;
    }
}
