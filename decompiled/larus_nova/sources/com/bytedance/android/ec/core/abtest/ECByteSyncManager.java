package com.bytedance.android.ec.core.abtest;

import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ECByteSyncManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f43615a = null;

    public ECByteSyncManager() {
    }

    static {
        f43615a = LazyKt.lazy(ECByteSyncManager$handlers$2.INSTANCE);
    }

    public static final void a(JSONObject r100, String r101, long r102, long r103) {
        int r104 = 0;
        int r105 = r100.optInt(AiProactiveTaskViewModel.PARAM_TASK_TYPE, 0);
        if (((i) ((Map) f43615a.getValue()).get(Integer.valueOf(r105))) == null) goto L26;
        Intrinsics.checkNotNullParameter(r100, "jsonPayload");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L7
        i.a(r100, r102, r103);     // Catch: Throwable -> L7
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L19
        if (r108 != null) goto L13;
        r104 = 1;
    L13:
        r109.put("success", r104);     // Catch: Throwable -> L19
        if (r108 == null) goto L16;
        String r110 = r108.getMessage();     // Catch: Throwable -> L19
    L17:
        r109.put("error_msg", r110);     // Catch: Throwable -> L19
        r109.put("data", r100);     // Catch: Throwable -> L19
        r109.put("msg_id", r101);     // Catch: Throwable -> L19
        com.bytedance.android.ec.sdk.helper.g.f48122a.logV3("pdp_exp_disaster_recovery_monitor", r109);     // Catch: Throwable -> L19
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L16:
        r110 = null;
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L7:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
