package com.bytedance.android.live.core.verify.utils;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f66520a;

    public b(a.C1099a r100) {
        this.f66520a = r100;
    }

    @Override // com.bytedance.android.live.core.verify.utils.a.d
    public final void a(String r110) {
        String r111 = a.d();
        r111.getClass();
        if (r111.equals("self") == false) goto L5;
        int r100 = 2;
    L9:
        a.C1099a r112 = (a.C1099a) this.f66520a;
        a.o(r112.f66499a, r112.f66500b, r112.f66501c, r112.f66502d, r100, r112.f66503e, true, r112.f66504f, r112.f66505g, false, r112.f66506h);
        return;
    L5:
        if (r111.equals("ali_cloud") == true) goto L7;
        r100 = 0;
        goto L9
    L7:
        r100 = 3;
        goto L9
    }
}
