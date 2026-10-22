package com.bytedance.dataplatform;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.p;
import d.h.b.y;
import d.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: ClientExperimentManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ d.m.h[] f7904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f7905b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Application f7906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<r<String, com.bytedance.dataplatform.b.a<?>, String>> f7907d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f7908e = null;
    private static final HashSet<String> f = null;
    private static final d.f g = null;

    /* JADX INFO: compiled from: ClientExperimentManager.kt */
    static final class a extends p implements d.h.a.a<Map<String, Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7909a = null;

        static {
            f7909a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Map<String, Integer> invoke() {
            return a();
        }

        public final Map<String, Integer> a() {
            return com.bytedance.dataplatform.a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(b.f7905b), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "CLIENT_EXPERIMENT_CACHE_TAG");
        }
    }

    static {
        f7904a = new d.m.h[]{(d.m.h) ZeusTransformUtils.preCheckCast(aa.a(new y(aa.b(b.class), "clientExperimentLayer", "getClientExperimentLayer()Ljava/util/Map;")), d.m.h.class, "com.obric.aiagent.plugin")};
        f7905b = new b();
        f7907d = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.aiagent.plugin");
        f7908e = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        f = new HashSet();
        g = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f7909a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private b() {
    }

    public static final /* synthetic */ Application a(b r0) {
        return f7906c;
    }

    public final boolean a(String r1) {
        o.d(r1, "key");
        return !f.contains(r1);
    }
}
