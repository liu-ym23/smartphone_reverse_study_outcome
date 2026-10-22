package com.bytedance.android.live.browser.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements com.bytedance.android.annie.bridge.r {

    public static final class a implements com.bytedance.ies.web.jsbridge2.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f64293a;

        public a(Function2 r100) {
            this.f64293a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.v
        public final void a(String r100, String r101) {
            if (Intrinsics.areEqual("host", r100) == false) goto L6;
            this.f64293a.invoke(r100, r101);
            return;
        }
    }

    public v() {
    }

    @Override // com.bytedance.android.annie.bridge.r
    public final void K0(com.bytedance.ies.web.jsbridge2.d0 r100, Function2<? super String, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "jsBridge2");
        Intrinsics.checkNotNullParameter(r101, "block");
        r100.f249341a.f249306j = new a(r101);
    }
}
