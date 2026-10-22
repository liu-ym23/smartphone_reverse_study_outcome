package com.ss.bduploader.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.bduploader.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class BDUploadDNSParser$1 extends Handler {
    final /* synthetic */ c this$0;

    BDUploadDNSParser$1(c r1, Looper r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r8) {
        if (r8.obj == null) goto L5;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8.obj, b.class, "com.obric.aiagent.plugin");
    L6:
        s.c("BDUploadDNSParser", String.format("----receive msg what:%d info:%s", new Object[]{Integer.valueOf(r8.what), r0}));
        int r2 = r8.what;
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L10;
        c.b(this.this$0, r8.what, r0);
    L15:
        s.c("BDUploadDNSParser", String.format("****end proc msg what:%d info:%s", new Object[]{Integer.valueOf(r8.what), r0}));
        return;
    L10:
        if (r2 != 3) goto L15;
        c.c(this.this$0, r8.what, r0);
        goto L15
    L14:
        c.a(this.this$0, r8.what, r0);
        goto L15
    L5:
        r0 = null;
        goto L6
    }
}
