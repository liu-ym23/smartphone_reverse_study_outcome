package com.bytedance.common.wschannel;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WschannelSdkInitParam.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.common.wschannel.app.a f7004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Application f7005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.common.wschannel.app.c f7006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7008e;
    private boolean f;
    private b<Boolean> g;

    /* JADX INFO: compiled from: WschannelSdkInitParam.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Application f7009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.common.wschannel.app.c f7010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f7012d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f7013e;
        private com.bytedance.common.wschannel.app.a f;

        public a() {
            this.f7011c = false;
            this.f7012d = true;
            this.f7013e = false;
        }

        public a a(Application r3) {
            this.f7009a = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(com.bytedance.common.wschannel.app.c r3) {
            this.f7010b = (com.bytedance.common.wschannel.app.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.app.c.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(boolean r1) {
            this.f7011c = r1;
            return this;
        }

        public a b(boolean r1) {
            this.f7012d = r1;
            return this;
        }

        public a c(boolean r1) {
            this.f7013e = r1;
            return this;
        }

        public a a(com.bytedance.common.wschannel.app.a r3) {
            this.f = (com.bytedance.common.wschannel.app.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.app.a.class, "com.obric.aiagent.plugin");
            return this;
        }

        public n a() {
            return new n(this.f7009a, this.f7010b, this.f7011c, this.f7012d, this.f7013e, this.f);
        }
    }

    public n(Application r3, com.bytedance.common.wschannel.app.c r4, boolean r5, boolean r6, boolean r7, com.bytedance.common.wschannel.app.a r8) {
        Application r9 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.c r10 = (com.bytedance.common.wschannel.app.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.common.wschannel.app.c.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.a r11 = (com.bytedance.common.wschannel.app.a) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.common.wschannel.app.a.class, "com.obric.aiagent.plugin");
        this.f7005b = r9;
        this.f7006c = r10;
        this.f7007d = r5;
        this.f7008e = r6;
        this.f = r7;
        this.f7004a = r11;
    }

    public Application a() {
        return this.f7005b;
    }

    public com.bytedance.common.wschannel.app.c b() {
        return this.f7006c;
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.f7007d;
    }

    public boolean e() {
        return this.f7008e;
    }

    public b<Boolean> f() {
        return this.g;
    }
}
