package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public class j1 extends a9 implements w1.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w1 f27449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z1 f27450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b2 f27451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f27452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bundle f27453f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27454h;

    public void d() {
        this.f27454h = true;
        w1 r100 = this.f27449b;
        if (r100 == null) goto L5;
        r100.e();
    L6:
        z1 r101 = this.f27450c;
        if (r101 == null) goto L10;
        r101.b();
        return;
    L10:
        return;
    L5:
        cancelTask();
        goto L6
    }

    private void b() throws IOException {
        String r100 = this.f27451d.a();
        w1 r101 = new w1(new x1(this.f27451d.getUrl(), w3.a(this.f27452e), this.f27451d.e(), 1, r100), this.f27451d.getUrl(), this.f27452e, this.f27451d);
        this.f27449b = r101;
        r101.a(this);
        b2 r102 = this.f27451d;
        this.f27450c = new z1(r102, r102);
        if (this.f27454h == true) goto L6;
        this.f27449b.f();
        return;
    }

    public void a() {
        Bundle r100 = this.f27453f;
        if (r100 == null) goto L6;
        r100.clear();
        this.f27453f = null;
        return;
    }

    public void c() {
        z1 r100 = this.f27450c;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.amap.api.mapcore.util.a9
    public void runTask() {
        if (this.f27451d.g() == false) goto L11;
        this.f27451d.a(c2.a.f27106c);
        return;
    L11:
        b();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public j1(b2 r100, Context r101) {
        this.f27453f = new Bundle();
        this.f27454h = false;
        this.f27451d = r100;
        this.f27452e = r101;
    }
}
