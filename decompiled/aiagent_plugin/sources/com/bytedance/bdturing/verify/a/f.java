package com.bytedance.bdturing.verify.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.BdTuringConfig;

/* JADX INFO: compiled from: IdentityVerifyRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f6653e;
    private final boolean f;

    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        return "verify_identity";
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        return 14;
    }

    public final String i() {
        return this.f6649a;
    }

    public final String j() {
        return this.f6650b;
    }

    public final String k() {
        return this.f6651c;
    }

    public final String l() {
        return this.f6652d;
    }

    public final String m() {
        return this.f6653e;
    }

    public final boolean n() {
        return this.f;
    }

    public f(String r2, String r3, String r4, String r5, String r6, boolean r7) {
        d.h.b.o.d(r2, DBHelper.BATTERY_COL_SCENE);
        d.h.b.o.d(r3, "flow");
        d.h.b.o.d(r4, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.d(r5, "detail");
        d.h.b.o.d(r6, "ticket");
        this.f6649a = r2;
        this.f6650b = r3;
        this.f6651c = r4;
        this.f6652d = r5;
        this.f6653e = r6;
        this.f = r7;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r3) {
        d.h.b.o.d(r3, "queryBuilder");
        d.o.o.a(r3);
        r3.append(com.bytedance.bdturing.setting.h.f6610a.a(f(), "report_url"));
    }
}
