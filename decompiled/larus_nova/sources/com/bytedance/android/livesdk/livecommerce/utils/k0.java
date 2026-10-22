package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.process.ProcessDomain;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashPermissionInfoResponse;
import com.bytedance.android.livesdk.livecommerce.network.response.FlashPermissionStatus;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class k0 implements vi2.v0<ECFlashPermissionInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f153093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f153094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f153095c;

    @Override // vi2.v0
    public final void onError(Throwable r100) {
        this.f153095c.invoke();
    }

    @Override // vi2.v0
    public final void onSuccess(ECFlashPermissionInfoResponse r100) {
        ECFlashPermissionInfoResponse r101 = r100;
        Object r102 = null;
        if (r101 == null) goto L5;
        ECV2PopupInfo r103 = r101.getPopupInfo();
    L6:
        if (r103 == null) goto L34;
        Integer r104 = r101.getStatus();
        int r105 = FlashPermissionStatus.NOT_OPEN_YET.getStatus();
        if (r104 != null) goto L11;
    L12:
        Integer r106 = r101.getStatus();
        int r107 = FlashPermissionStatus.OFF.getStatus();
        if (r106 != null) goto L16;
    L17:
        Integer r108 = r101.getStatus();
        int r109 = FlashPermissionStatus.PAUSED.getStatus();
        if (r108 == null) goto L34;
        if (r108.intValue() != r109) goto L34;
    L22:
        Context r110 = this.f153093a;
        if (r110 == null) goto L36;
        int r111 = com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.f152783a;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.a(r110, r101.getPopupInfo());
    L36:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L27
        Object r113 = Result.m9449constructorimpl(new JSONObject().put("log_id", r101.getRequestId()));     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r113) == true) goto L33;
        r102 = r113;
    L33:
        int r114 = lh.b.f509219a;
        lh.b.d(ProcessDomain.LIVE, "闪购点击被拦截", SystemClock.elapsedRealtime() - this.f153094b, (JSONObject) r102, 16);
        return;
    L27:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L16:
        if (r106.intValue() == r107) goto L22;
    L11:
        if (r104.intValue() == r105) goto L22;
    L34:
        this.f153095c.invoke();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public k0(Context r100, long r101, Function0 r102) {
        this.f153093a = r100;
        this.f153094b = r101;
        this.f153095c = r102;
    }
}
