package com.bytedance.android.livesdk.strategy;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Object> f158434a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f158434a, ((a) r100).f158434a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        HashMap<String, Object> r100 = this.f158434a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "AdStrategyFeatures(data=" + this.f158434a + ")";
    }

    public a() {
        this(new HashMap());
    }

    public final boolean a() {
        Object r100 = this.f158434a.get("live_is_ad");
        if ((r100 instanceof Boolean) == true) goto L5;
        r100 = null;
    L5:
        Boolean r101 = (Boolean) r100;
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    }

    public a(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f158434a = r100;
    }
}
