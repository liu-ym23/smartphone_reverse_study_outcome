package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.feed.event.j1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f175463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f175464b = null;

    public static final class a implements ti.j {
        public a() {
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            String r101 = r100.optString("status");
            if (Intrinsics.areEqual(r101, "success") == true) goto L5;
        L7:
            dm.a.a("marketing_card").i("on receive js event, status = " + r101);
            return;
        L5:
            if ((System.currentTimeMillis() - r.f175463a) <= 5000) goto L7;
            s0.a(new j1());
            r.f175463a = System.currentTimeMillis();
            goto L7
        }
    }

    static {
        f175464b = new a();
    }
}
