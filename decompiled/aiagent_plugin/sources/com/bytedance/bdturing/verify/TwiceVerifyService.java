package com.bytedance.bdturing.verify;

import com.bytedance.bdturing.c;
import com.bytedance.bdturing.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TwiceVerifyService implements a {
    private boolean isOnVerify;

    @Override // com.bytedance.bdturing.verify.a
    public boolean isProcess(int r1) {
        switch(r1) {
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L3;
            case 13: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public TwiceVerifyService() {
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean execute(com.bytedance.bdturing.verify.a.a r5, c r6) {
        final c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
        if (com.bytedance.bdturing.twiceverify.c.a().b() == true) goto L6;
        return false;
    L6:
        setOnVerify(true);
        e.a();
        com.bytedance.bdturing.twiceverify.c.a().a(r5, null, new AnonymousClass1(this, r7));
        return true;
    }

    public synchronized boolean isOnVerify() {
        monitor-enter(this);
        boolean r0 = this.isOnVerify;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setOnVerify(boolean r1) {
        monitor-enter(this);
        this.isOnVerify = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
