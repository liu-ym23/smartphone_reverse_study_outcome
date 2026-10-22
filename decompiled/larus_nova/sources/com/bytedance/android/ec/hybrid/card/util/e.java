package com.bytedance.android.ec.hybrid.card.util;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECLynxCardErrorType f46600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46601b;

    public e(ECLynxCardErrorType r100, String r101) {
        this.f46600a = r100;
        this.f46601b = r101;
    }

    public final void a() {
        int r100 = f.f46602a;
        JSONObject r101 = new JSONObject();
        r101.put("success", "false");
        ECLynxCardErrorType r102 = this.f46600a;
        Intrinsics.checkNotNullParameter(r102, "$this$isTimeout");
        if (r102 != ECLynxCardErrorType.TIMEOUT) goto L5;
        boolean r103 = true;
    L6:
        r101.put(LocationMonitorConst.IS_TIMEOUT, String.valueOf(r103));
        String r104 = this.f46601b;
        if (r104 == null) goto L9;
        r101.put("error_msg", r104);
    L9:
        Unit r105 = Unit.INSTANCE;
        f.a("ec_lynx_card_render_result", r101, null, null);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
