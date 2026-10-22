package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECPerfSessionReadMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPerfSessionReadMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ec.readPerfSession";
    }

    public ECPerfSessionReadMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("session_id");
        String r103 = r100.optString("stage");
        if (StringsKt.isBlank(r102) == false) goto L33;
        d("invalid session id", r101);
        return;
    L33:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L25
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        bm.a r106 = ECPerfSessionManager.f48098d.b(r102);     // Catch: Throwable -> L25
    L16:
        if (r106 != null) goto L31;
        d("no session info", r101);     // Catch: Throwable -> L25
    L23:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L35;
        d("read session fail: " + r108.getMessage(), r101);
        return;
    L35:
        return;
    L31:
        r101.a(r106.b());     // Catch: Throwable -> L21
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L25
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
        goto L23
    L15:
        r106 = ECPerfSessionManager.f48098d.c(r102, r103);     // Catch: Throwable -> L25
        goto L16
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r105 = false;
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    public final void d(String r100, ECBaseBridgeMethod.a r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        r101.onFailed(0, r100);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
