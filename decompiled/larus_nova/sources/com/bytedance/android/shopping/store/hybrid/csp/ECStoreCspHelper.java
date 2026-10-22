package com.bytedance.android.shopping.store.hybrid.csp;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreCspHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f184828a = 0;

    static {
    }

    public static void a(l r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        Lazy r102 = ECStoreSettings.f48572a;
        int r103 = p.f45243a;
        Object r104 = Boolean.TRUE;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r106 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r107 = jj4.a.a("ec_shop_scc_interceptor_enable", Boolean.class, r104, false);     // Catch: Throwable -> L7
        if (r107 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Boolean) r107).booleanValue() == true) goto L16;
        return;
    L16:
        int r108 = com.bytedance.android.ec.core.hybrid.a.f44106a;
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Function1<JSONObject, Unit> r109 = new ECStoreCspHelper$openInterceptAbility$$inlined$let$lambda$1(r101);
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r109, "listener");
        return;
    L7:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r111) == true) goto L12;
        r104 = r111;
    L12:
        r107 = r104;
        goto L14
    }
}
