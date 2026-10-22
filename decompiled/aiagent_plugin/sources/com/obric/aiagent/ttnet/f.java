package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.o;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: RequestRestrictRuleManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f22233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Set<d> f22234b;

    private f() {
    }

    static {
        f22233a = new f();
        f22234b = ax.b();
    }

    @Override // com.obric.aiagent.ttnet.b
    public void a(d r3) {
        o.e(r3, "rule");
        f22234b = ax.a(r3);
        com.obric.aiagent.a.a.a((Collection) ZeusTransformUtils.preCheckCast(r3.a(), Collection.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.a.a.b((Collection) ZeusTransformUtils.preCheckCast(r3.b(), Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.ttnet.b
    public Set<d> a() {
        return f22234b;
    }
}
