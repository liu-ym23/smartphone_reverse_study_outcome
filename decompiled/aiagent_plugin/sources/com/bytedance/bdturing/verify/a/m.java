package com.bytedance.bdturing.verify.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.BdTuringConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SmsRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6664c;

    public m() {
        this(null, false, null, 7, null);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        return "sms";
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        return 1;
    }

    public /* synthetic */ m(String r3, boolean r4, String r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    L11:
        this(r3, r4, r5);
    }

    public m(String r1, boolean r2, String r3) {
        this.f6662a = r1;
        this.f6663b = r2;
        this.f6664c = r3;
        a(true);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r3) {
        d.h.b.o.d(r3, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r3, DBHelper.BATTERY_COL_SCENE, this.f6662a);
        com.bytedance.bdturing.utils.d.a(r3, "show_success_toast", this.f6663b ? 1 : 0);
        com.bytedance.bdturing.utils.d.a(r3, "uid", this.f6664c);
        com.bytedance.bdturing.utils.d.a(r3, "use_dialog_size_v2", com.bytedance.bdturing.setting.h.f6610a.c());
    }
}
