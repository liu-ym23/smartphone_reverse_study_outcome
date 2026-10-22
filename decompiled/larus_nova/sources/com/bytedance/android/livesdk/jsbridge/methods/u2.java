package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class u2 implements NotificationSettingBottomDialog.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f142209a;

    @Override // com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog.b
    public final void onFailure() {
    }

    public u2(CallContext r100) {
        this.f142209a = r100;
    }

    @Override // com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog.b
    public final void onSuccess(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        JSONObject r102 = new JSONObject();
        r102.put("status", r101);     // Catch: Throwable -> L5
        this.f142209a.b("H5_setLiveNotificationStatus", r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e(th.getMessage());
    }
}
