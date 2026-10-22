package com.bytedance.android.live.browser.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements com.bytedance.android.annie.bridge.o {

    public static final class a implements com.bytedance.ies.web.jsbridge2.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f64286a;

        public a(Function0 r100) {
            this.f64286a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.p
        public final void a() {
            this.f64286a.invoke();
        }
    }

    public k() {
    }

    @Override // com.bytedance.android.annie.bridge.o
    public final void h1(com.bytedance.ies.web.jsbridge2.o r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "env");
        Intrinsics.checkNotNullParameter(r101, "block");
        r100.f249413r = new a(r101);
    }
}
