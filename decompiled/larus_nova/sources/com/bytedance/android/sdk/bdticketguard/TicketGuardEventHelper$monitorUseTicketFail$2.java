package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.android.sdk.bdticketguard.init.TicketGuardBootFinishManager;
import com.bytedance.android.sdk.bdticketguard.utils.TGThreadUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class TicketGuardEventHelper$monitorUseTicketFail$2 implements TicketGuardBootFinishManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f163519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f163520b;

    @Override // com.bytedance.android.sdk.bdticketguard.init.TicketGuardBootFinishManager.a
    public final void a() {
        TGThreadUtils r100 = TGThreadUtils.f164077f;
        Function0<Unit> r101 = new TicketGuardEventHelper$monitorUseTicketFail$2$onBootFinish$1(this);
        r100.getClass();
        TGThreadUtils.a(r101);
    }

    public TicketGuardEventHelper$monitorUseTicketFail$2(String r100, JSONObject r101) {
        this.f163519a = r100;
        this.f163520b = r101;
    }
}
