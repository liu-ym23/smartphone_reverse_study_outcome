package com.bytedance.android.latch.xbridge.internal;

import com.bytedance.android.latch.internal.f;
import io.reactivex.subjects.MaybeSubject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends f {
    public b() {
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "callbackId");
        com.bytedance.android.latch.internal.a r102 = this.f58299a;
        if (r102 == null) goto L5;
        r102.f(r101, r100);
    L5:
        this.f58300b.put(r101, new MaybeSubject());
    }

    public final void c(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Intrinsics.checkNotNullParameter(r102, "callbackId");
        com.bytedance.android.latch.internal.a r103 = this.f58299a;
        if (r103 == null) goto L5;
        r103.e(r102, r101);
    L5:
        a(r102).onSuccess(f.b(r100, r102));
    }
}
