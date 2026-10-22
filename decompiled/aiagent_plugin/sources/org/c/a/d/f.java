package org.c.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: DocumentStartEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f40393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.c.a.a.e f40394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f40395c;

    public f(org.c.a.c.a r3, org.c.a.c.a r4, boolean r5, org.c.a.a.e r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        super(r3, r4);
        this.f40393a = r5;
        this.f40394b = r6;
        this.f40395c = r8;
    }

    public boolean b() {
        return this.f40393a;
    }

    public org.c.a.a.e c() {
        return this.f40394b;
    }

    public Map<String, String> e() {
        return this.f40395c;
    }

    @Override // org.c.a.d.g
    public g.a a() {
        return g.a.f40401d;
    }
}
