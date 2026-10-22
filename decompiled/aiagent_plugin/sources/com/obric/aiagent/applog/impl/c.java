package com.obric.aiagent.applog.impl;

import com.bytedance.applog.p;
import com.bytedance.applog.q;
import com.bytedance.bdinstall.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BDTrackerConfigs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16134a = null;

    /* JADX INFO: compiled from: BDTrackerConfigs.kt */
    public static final class a extends com.bytedance.bdinstall.f.b {
        @Override // com.bytedance.bdinstall.f.b
        public String a() {
            return null;
        }

        @Override // com.bytedance.bdinstall.f.b
        public String a(int r1) {
            return null;
        }

        @Override // com.bytedance.bdinstall.f.b
        public String b(int r1) {
            return null;
        }

        @Override // com.bytedance.bdinstall.f.b
        public String e() {
            return null;
        }

        @Override // com.bytedance.bdinstall.f.b
        public String f() {
            return null;
        }

        a() {
        }
    }

    static {
        f16134a = new c();
    }

    private c() {
    }

    public final q a(boolean r1) {
        return b(r1);
    }

    private final q b(boolean r2) {
        q.a r1 = new q.a();
        if (r2 == false) goto L5;
        u r3 = u.f6447b;
    L6:
        q r4 = r1.a(r3).a(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}).b(new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}).a("https://log.zijieapi.com/service/2/log_settings/").a();
        o.c(r4, "build(...)");
        return r4;
    L5:
        r3 = u.f6446a;
        goto L6
    }

    public final void a(p r3) {
        o.e(r3, "config");
        r3.a((com.bytedance.bdinstall.f.b) ZeusTransformUtils.preCheckCast(new a(), com.bytedance.bdinstall.f.b.class, "com.obric.aiagent.plugin"));
    }
}
