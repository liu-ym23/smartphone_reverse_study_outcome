package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.browser.IBrowserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 implements v9.c {

    public static final class a implements com.bytedance.android.live.schema.api.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.b f64274a;

        public a(v9.b r100) {
            this.f64274a = r100;
        }

        @Override // com.bytedance.android.live.schema.api.d.a
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "finalSchema");
            v9.b r101 = this.f64274a;
            if (r101 == null) goto L6;
            r101.onSuccess(r100);
            return;
        }

        @Override // com.bytedance.android.live.schema.api.d.a
        public final void onFail(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            v9.b r102 = this.f64274a;
            if (r102 == null) goto L6;
            r102.onFail(r100, r101);
            return;
        }
    }

    public c0() {
    }

    @Override // v9.c
    public final void X0(String r100, v9.b r101) {
        com.bytedance.android.live.schema.api.b r102 = com.bytedance.android.live.schema.api.utils.b.b(r100);
        if (r102 == null) goto L5;
        ((IBrowserService) jc1.k.n(IBrowserService.class)).createRedirectProcessor().a(r102, new a(r101));
        return;
    L5:
        if (r101 == null) goto L9;
        r101.onFail(1002, "illegal redirect schema");
        return;
    }
}
