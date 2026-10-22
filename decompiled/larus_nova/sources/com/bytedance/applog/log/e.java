package com.bytedance.applog.log;

import com.bytedance.bdinstall.f0;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f192460a;

    public e(f0 r100) {
        this.f192460a = r100;
    }

    @Override // com.bytedance.applog.log.j
    public final void a(k r100) {
        f0 r101 = this.f192460a;
        if (r101 == null) goto L18;
        int r102 = r100.f192471c;
        if (r102 != 1) goto L7;
        r101.d(r100.b(), r100.f192476h);
        return;
    L7:
        if (r102 != 2) goto L9;
        r101.i(r100.b(), r100.f192476h);
        return;
    L9:
        if (r102 != 3) goto L11;
        r101.w(r100.b(), r100.f192476h);
        return;
    L11:
        if (r102 == 4) goto L13;
        r101.v(r100.b(), r100.f192476h);
        return;
    L13:
        r101.e(r100.b(), r100.f192476h);
        return;
    }
}
