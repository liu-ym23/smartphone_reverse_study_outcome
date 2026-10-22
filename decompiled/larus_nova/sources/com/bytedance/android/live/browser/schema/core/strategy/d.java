package com.bytedance.android.live.browser.schema.core.strategy;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, c.b> f64221a;

    public static final class a implements c.b {
        public a() {
        }

        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            return new g();
        }
    }

    public d() {
        this.f64221a = new HashMap();
        a(0, new a());
    }

    public final void a(int r100, c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "factory");
        Map<Integer, c.b> r102 = this.f64221a;
        HashMap r103 = (HashMap) r102;
        r103.put(Integer.valueOf(r100), r101);
    }
}
