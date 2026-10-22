package com.bytedance.bdturing.verify.a;

import com.bytedance.bdturing.BdTuringConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IdentityRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6648b;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r1) {
        d.h.b.o.d(r1, "queryBuilder");
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        return "verify";
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        return 4;
    }

    public /* synthetic */ e(String r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    L8:
        this(r3, r4);
    }

    public e(String r1, String r2) {
        this.f6647a = r1;
        this.f6648b = r2;
    }
}
