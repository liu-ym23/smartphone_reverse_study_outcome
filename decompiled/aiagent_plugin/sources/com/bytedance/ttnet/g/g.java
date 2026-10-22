package com.bytedance.ttnet.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestPriorityController.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f11470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f11471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f11472c;

    public g() {
        this.f11470a = new CopyOnWriteArraySet();
        this.f11471b = new CopyOnWriteArraySet();
        this.f11472c = new CopyOnWriteArraySet();
    }

    public void a(JSONObject r2) {
        this.f11470a = i.a(r2, "high");
        this.f11471b = i.a(r2, "normal");
        this.f11472c = i.a(r2, "low");
    }

    public com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r10) {
        com.bytedance.retrofit2.b.c.a r6 = r10.m();
        if (a(this.f11470a, r10.o(), r6, 3, 4) == false) goto L7;
        return r6.b();
    L7:
        if (a(this.f11472c, r10.o(), r6, -1, 1) == true) goto L9;
        int r0 = r10.f();
        if (r0 < 3) goto L14;
        r0 = 1;
    L14:
        if (r0 > (-1)) goto L16;
        r0 = 0;
    L16:
        int r4 = r0;
        int r1 = r10.g();
        if (r1 < 4) goto L19;
        r1 = 3;
    L19:
        if (r1 < 1) goto L22;
        r1 = 2;
    L22:
        if (a(this.f11471b, r10.o(), r6, r4, r1) == false) goto L26;
        return r6.b();
    L26:
        return r6.a(1).b(3).b();
    L9:
        return r6.b();
    }

    private boolean a(Set<String> r2, String r3, com.bytedance.retrofit2.b.c.a r4, int r5, int r6) {
        if (i.a((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin"), r3) == false) goto L6;
        r4.a(r5);
        r4.b(r6);
        return true;
    L6:
        return false;
    }
}
