package org.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: AbstractLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements Serializable, org.b.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f40276d;

    public abstract void a(org.b.a.b r1, org.b.e r2, String r3, Object[] r4, Throwable r5);

    public a() {
    }

    public String a() {
        return this.f40276d;
    }

    @Override // org.b.c
    public void a(String r3, Throwable r4) {
        if (c() == false) goto L6;
        a(org.b.a.b.f40269d, null, r3, r4);
        return;
    }

    private void a(org.b.a.b r7, org.b.e r8, String r9, Throwable r10) {
        a(r7, (org.b.e) ZeusTransformUtils.wrapperContextForParams(r8, org.b.e.class, "com.obric.aiagent.plugin"), r9, null, r10);
    }
}
