package com.bytedance.mobsec.metasec.ml;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.a.e;
import com.bytedance.mobsec.metasec.a.f;
import ms.bd.c.z0;

/* JADX INFO: loaded from: classes.dex */
public final class c implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f.a f8870a;

    c(e r1) {
        this.f8870a = r1;
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public void a(int r1) {
        this.f8870a.a(r1);
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public void a(String r1) {
        this.f8870a.a(r1);
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public void a(String r3, String r4) {
        String r0 = z0.a().b();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.f8870a.c(r0);
    L5:
        this.f8870a.a(r3, r4);
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public void b(String r1) {
        this.f8870a.b(r1);
    }

    @Override // com.bytedance.mobsec.metasec.a.f.a
    public void c(String r1) {
        this.f8870a.c(r1);
    }

    public void d(String r2) {
        a(r2, "");
    }
}
