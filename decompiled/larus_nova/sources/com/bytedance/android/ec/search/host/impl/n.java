package com.bytedance.android.ec.search.host.impl;

import android.app.Activity;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostUserService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements ITradeSearchHostUserService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f48180a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48181b = null;

    public n() {
    }

    static {
        f48180a = new n();
        f48181b = LazyKt.lazy(new m());
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostUserService
    public final String getCurrentUserId() {
        pj.a r100 = (pj.a) f48181b.getValue();
        if (r100 == null) goto L6;
        String r101 = r100.getCurrentUserId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostUserService
    public final boolean isLogin() {
        pj.a r100 = (pj.a) f48181b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isLogin();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostUserService
    public final void showLogin(Activity r100, String r101, String r110, Function0<Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        pj.a r102 = (pj.a) f48181b.getValue();
        if (r102 == null) goto L6;
        r102.showLogin(r100, r101, r110, r111, r112);
        return;
    }
}
