package com.amap.api.mapcore.util;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes28.dex */
class b1 implements u1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f27054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f27055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ c1 f27056c;

    @Override // com.amap.api.mapcore.util.u1.a
    public void a(String r100, String r101) {
    L7:
        c1 r102 = this.f27056c;
        r102.f27099v.a(r102.f27098u.e());
        return;
    L3:
        if (new PolarisFileWrapper(this.f27054a).delete() == true) goto L5;
        return;
    L5:
        a2.a(this.f27055b);     // Catch: Exception -> L7
        this.f27056c.setCompleteCode(100);     // Catch: Exception -> L7
        this.f27056c.f27099v.a();     // Catch: Exception -> L7
    }

    public b1(c1 r100, String r101, File r102) {
        this.f27056c = r100;
        this.f27054a = r101;
        this.f27055b = r102;
    }

    @Override // com.amap.api.mapcore.util.u1.a
    public void a(String r100, String r101, float r102) {
        int r103 = (int) ((((double) r102) * 0.39d) + 60.0d);
        if ((r103 - this.f27056c.getcompleteCode()) > 0) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - c1.a(this.f27056c)) <= 1000) goto L9;
        this.f27056c.setCompleteCode(r103);
        c1.a(this.f27056c, System.currentTimeMillis());
        return;
    }

    @Override // com.amap.api.mapcore.util.u1.a
    public void a(String r100, String r101, int r102) {
        c1 r103 = this.f27056c;
        r103.f27099v.a(r103.f27098u.e());
    }
}
