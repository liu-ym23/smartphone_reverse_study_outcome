package com.bytedance.android.livesdk.livecommerce.room.utils.json;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<JSONObject, Unit> f151944a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f151944a, ((a) r100).f151944a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Function1<JSONObject, Unit> r100 = this.f151944a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "JSONObjectEnvPair(init=" + this.f151944a + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        this.f151944a = r100;
    }
}
