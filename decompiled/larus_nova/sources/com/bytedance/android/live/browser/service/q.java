package com.bytedance.android.live.browser.service;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements y9.n {
    public q() {
    }

    @Override // y9.n
    public final boolean L0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        v60.a r101 = v60.a.f553369a;
        return v60.a.c().containsKey(r100);
    }

    @Override // y9.n
    public final boolean u(String r100, String r101, Type r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        v60.a r103 = v60.a.f553369a;
        return v60.a.l(r100, r101, r102);
    }

    @Override // y9.n
    public final Object u1(String r100, Type r110, Object r111) {
        Intrinsics.checkNotNullParameter("annie_setting_from_server_key", "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r110, "type");
        return v60.a.f553369a.k(r100, r111, r110, false, com.bytedance.android.live.core.utils.v.a(), false);
    }
}
