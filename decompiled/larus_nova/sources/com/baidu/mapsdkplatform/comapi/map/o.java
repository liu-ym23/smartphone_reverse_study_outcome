package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;

/* JADX INFO: loaded from: classes39.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f32183a;

    public o() {
    }

    public void a(Message r100) {
        if (r100.what == 65289) goto L5;
        return;
    L5:
        int r101 = r100.arg1;
        if (r101 != 12) goto L8;
    L13:
        n r102 = this.f32183a;
        if (r102 == null) goto L17;
        r102.a(r101, r100.arg2);
        return;
    L17:
        return;
    L8:
        if (r101 == 101) goto L13;
        if (r101 == 102) goto L13;
        switch(r101) {
            case -1: goto L13;
            case 0: goto L13;
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            default: goto L18;
        };
    }

    public void b(n r100) {
        this.f32183a = null;
    }

    public void a(n r100) {
        this.f32183a = r100;
    }
}
