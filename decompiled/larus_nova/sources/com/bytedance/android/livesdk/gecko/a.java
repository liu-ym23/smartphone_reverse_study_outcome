package com.bytedance.android.livesdk.gecko;

import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements xo2.c {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gecko.a$a, reason: collision with other inner class name */
    public static final class C2024a implements com.bytedance.android.livesdk.service.k.b<xo2.c> {
        public C2024a() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [R, com.bytedance.android.livesdk.gecko.a] */
        @Override // com.bytedance.android.livesdk.service.k.b
        public final com.bytedance.android.livesdk.service.k.b.a<xo2.c> setup(com.bytedance.android.livesdk.service.k.b.a<xo2.c> r100) {
            r100.f158001a = new a();
            r100.f158002b = true;
            return r100;
        }
    }

    public a() {
    }

    @Override // xo2.c
    public final void a(GeckoClient r100, String r101, Map<String, Map<String, Object>> r102, Map<String, List<CheckRequestBodyModel.TargetChannel>> r103, GeckoUpdateListener r104, xo2.c.a r105) {
        if (r100 == null) goto L5;
        r100.checkUpdateMulti(r101, r103, new OptionCheckUpdateParams().setCustomParam(r102).setEnableThrottle(false).setListener(new g(r104, r105)));
        return;
    }
}
