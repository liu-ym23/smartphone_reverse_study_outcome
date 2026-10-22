package com.bytedance.bdturing.verify.a;

import com.bytedance.bdturing.BdTuringConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: QaRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6656a;

    /* JADX WARN: Multi-variable type inference failed */
    public j() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        return "qa";
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        return 3;
    }

    public /* synthetic */ j(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    L5:
        this(r1);
    }

    public j(String r1) {
        this.f6656a = r1;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r3) {
        d.h.b.o.d(r3, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r3, "isPop", !a() ? 1 : 0);
        com.bytedance.bdturing.utils.d.a(r3, "uid", this.f6656a);
        com.bytedance.bdturing.utils.d.a(r3, "use_dialog_size_v2", com.bytedance.bdturing.setting.h.f6610a.c());
    }
}
