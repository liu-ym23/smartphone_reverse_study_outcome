package com.bytedance.android.ec.core.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function1<? super String, Unit> f45582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f45583b = null;

    public static final class a implements ti.j {
        public a() {
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Function1<? super String, Unit> r101 = f2.f45582a;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(r100.optString("product_id"));
            return;
        }
    }

    static {
        f45583b = new a();
    }
}
