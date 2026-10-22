package com.bytedance.bdinstall.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f6270a;

    /* JADX INFO: compiled from: Cache.java */
    interface a<L> {
        L a(L r1, L r2, d r3);

        void a(L r1);

        boolean a(L r1, L r2);

        L b();

        boolean b(L r1);
    }

    @Override // com.bytedance.bdinstall.h.i
    public abstract String a(String r1);

    @Override // com.bytedance.bdinstall.h.i
    public abstract void a(String r1, String r2);

    public abstract void a(String r1, String[] r2);

    public abstract String[] b(String r1);

    public d() {
    }

    private d a() {
        return this.f6270a;
    }

    void a(d r1) {
        this.f6270a = r1;
    }

    public String b(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(a(r2, r3, new AnonymousClass1(this)), String.class, "com.obric.aiagent.plugin");
    }

    public String c(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(a(r2, r3, new AnonymousClass2(this)), String.class, "com.obric.aiagent.plugin");
    }

    public String d(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(a(r2, r3, new AnonymousClass3(this)), String.class, "com.obric.aiagent.plugin");
    }

    public String[] a(String[] r2, String[] r3) {
        return (String[]) ZeusTransformUtils.preCheckCast(a(r2, r3, new AnonymousClass4(this)), String[].class, "com.obric.aiagent.plugin");
    }

    public String e(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(a(r2, r3, new AnonymousClass5(this)), String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.h.i
    public String f(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(a(r2, r3, new AnonymousClass6(this)), String.class, "com.obric.aiagent.plugin");
    }

    private <T> T a(T r4, T r5, a<T> r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L27;
        d r3 = a();
        Object r0 = r7.b();
        boolean r1 = r7.b(r4);
        boolean r2 = r7.b(r0);
        if (r1 == true) goto L8;
        if (r2 == false) goto L8;
        r4 = (T) r0;
    L8:
        if (r3 == null) goto L13;
        T r8 = (T) r7.a(r4, r5, r3);
        if (r7.a(r8, r0) == true) goto L12;
        r7.a(r8);
    L12:
        return r8;
    L13:
        boolean r9 = false;
        if (r1 == true) goto L17;
        if (r2 == true) goto L17;
        r9 = true;
    L18:
        if (r9 == true) goto L20;
    L21:
        if (r1 == true) goto L23;
    L25:
        return r5;
    L23:
        if (r7.a(r5, r0) == true) goto L25;
    L24:
        r7.a(r5);
        goto L25
    L20:
        if (r7.b(r5) == true) goto L24;
    L17:
        r5 = r4;
        goto L18
    L27:
        throw new IllegalArgumentException("agent == null");
    }

    public void a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d r2 = a();
        if (r2 == null) goto L6;
        r2.a(r4);
        return;
    }
}
