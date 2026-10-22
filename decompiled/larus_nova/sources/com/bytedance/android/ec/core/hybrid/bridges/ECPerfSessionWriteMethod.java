package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.android.ec.opt.session.model.StageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECPerfSessionWriteMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPerfSessionWriteMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ec.writePerfSession";
    }

    public ECPerfSessionWriteMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L26
        String r103 = r100.optString("session_id");     // Catch: Throwable -> L26
        String r104 = r100.optString("stage");     // Catch: Throwable -> L26
        if (StringsKt.isBlank(r103) == true) goto L39;
        if (StringsKt.isBlank(r104) == true) goto L39;
        String r105 = r100.optString("timestamp", "0");     // Catch: Throwable -> L26
        String r106 = r100.optString("stage_type");     // Catch: Throwable -> L26
        JSONObject r107 = r100.optJSONObject("stage_data");     // Catch: Throwable -> L26
        bm.b r108 = new bm.b(r104, r105);     // Catch: Throwable -> L26
        StageType.Companion.getClass();     // Catch: Throwable -> L26
        StageType r109 = StageType.a.a(r106);     // Catch: Throwable -> L26
        if (r109 != null) goto L11;
        r109 = StageType.NORMAL;     // Catch: Throwable -> L26
    L11:
        Intrinsics.checkNotNullParameter(r109, "<set-?>");     // Catch: Throwable -> L26
        r108.f19540a = r109;     // Catch: Throwable -> L26
        if (r107 == null) goto L14;
        r108.update(z1.k(r107));     // Catch: Throwable -> L26
    L14:
        ECPerfSessionManager.f48098d.d(r103, r104, r108);     // Catch: Throwable -> L26
        r101.a(new JSONObject());     // Catch: Throwable -> L17
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 != null) goto L36;
        return;
    L36:
        r101.onFailed(0, "write session fail: " + r111.getMessage());     // Catch: Throwable -> L33
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L17:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L26
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
    L39:
        r101.onFailed(0, "invalid id or stage");     // Catch: Throwable -> L23
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L43:
        return;
    L23:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L26
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }
}
