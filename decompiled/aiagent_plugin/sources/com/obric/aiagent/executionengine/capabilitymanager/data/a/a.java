package com.obric.aiagent.executionengine.capabilitymanager.data.a;

import com.obric.aiagent.executionengine.capabilitymanager.data.CapabilityDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.j;
import java.util.List;

/* JADX INFO: compiled from: IIntentDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "ICapabilityBeanDao";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0331a f16428a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f<a> f16429c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f16430b;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.data.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IIntentDao.kt */
    public static final class C0331a {
        public /* synthetic */ C0331a(h r1) {
            this();
        }

        private C0331a() {
        }

        private final a b() {
            return (a) ZeusTransformUtils.preCheckCast(a.b().b(), a.class, "com.obric.aiagent.plugin");
        }

        public final a a() {
            return b();
        }
    }

    public static /* synthetic */ com.obric.aiagent.executionengine.capabilitymanager.data.b.a lambda$EEcVoElU9al9MDZjGQuH9B5XTwg() {
        return d();
    }

    public static /* synthetic */ a lambda$inoLNZJrygyIHux32WtkVKB1BYk() {
        return e();
    }

    private a() {
        this.f16430b = g.a($$Lambda$a$EEcVoElU9al9MDZjGQuH9B5XTwg.INSTANCE);
    }

    public static final /* synthetic */ f b() {
        return f16429c;
    }

    static {
        f16428a = new C0331a(null);
        f16429c = g.a(j.f38505a, $$Lambda$a$inoLNZJrygyIHux32WtkVKB1BYk.INSTANCE);
    }

    private static final a e() {
        return new a();
    }

    private final com.obric.aiagent.executionengine.capabilitymanager.data.b.a c() {
        return (com.obric.aiagent.executionengine.capabilitymanager.data.b.a) ZeusTransformUtils.preCheckCast(this.f16430b.b(), com.obric.aiagent.executionengine.capabilitymanager.data.b.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.executionengine.capabilitymanager.data.b.a d() {
        return CapabilityDatabase.f16426e.a().o();
    }

    public final List<String> a() {
        return c().a();
    }

    public final com.obric.aiagent.executionengine.capabilitymanager.data.bean.a a(String r2) {
        o.e(r2, "key");
        return c().a(r2);
    }

    public final List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> b(String r2) {
        o.e(r2, "name");
        return c().b(r2);
    }

    public final List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "packages");
        return c().a(r4);
    }

    public final long a(com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r2) {
        o.e(r2, "bean");
        return c().a(r2);
    }

    public final List<Long> b(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3) {
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "beans");
        return c().b(r4);
    }

    public final int c(String r2) {
        o.e(r2, "key");
        return c().c(r2);
    }

    public final int c(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3) {
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "beans");
        return c().c(r4);
    }

    public final int a(String r2, boolean r3) {
        o.e(r2, "key");
        return c().a(r2, r3);
    }

    public final int d(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "keys");
        return c().d(r4);
    }

    public final int e(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3) {
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "beans");
        return c().e(r4);
    }
}
