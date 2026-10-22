package com.obric.aiagent.applog.impl;

import com.bytedance.bdinstall.ah;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import d.h.b.o;

/* JADX INFO: compiled from: AppLogLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16133a;

    public b(String r2) {
        o.e(r2, "tag");
        this.f16133a = r2;
    }

    @Override // com.bytedance.bdinstall.ah
    public void a(String r2, Throwable r3) {
        if (r3 == null) goto L4;
        ISecureLogDepend.Companion.w(this.f16133a, r2, r3);
        return;
    L4:
        ISecureLogDepend.Companion.v(this.f16133a, r2);
    }

    @Override // com.bytedance.bdinstall.ah
    public void b(String r2, Throwable r3) {
        if (r3 == null) goto L4;
        ISecureLogDepend.Companion.w(this.f16133a, r2, r3);
        return;
    L4:
        ISecureLogDepend.Companion.i(this.f16133a, r2);
    }

    @Override // com.bytedance.bdinstall.ah
    public void c(String r2, Throwable r3) {
        ISecureLogDepend.Companion.w(this.f16133a, r2, r3);
    }

    @Override // com.bytedance.bdinstall.ah
    public void d(String r2, Throwable r3) {
        if (r3 == null) goto L4;
        ISecureLogDepend.Companion.w(this.f16133a, r2, r3);
        return;
    L4:
        ISecureLogDepend.Companion.i(this.f16133a, r2);
    }

    @Override // com.bytedance.bdinstall.ah
    public void e(String r2, Throwable r3) {
        ISecureLogDepend.Companion.e(this.f16133a, r2, r3);
    }
}
