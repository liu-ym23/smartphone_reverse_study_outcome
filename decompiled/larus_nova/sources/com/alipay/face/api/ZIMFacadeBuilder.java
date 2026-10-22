package com.alipay.face.api;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class ZIMFacadeBuilder {
    private static ZIMFacade s_instance;

    public ZIMFacadeBuilder() {
    }

    public static synchronized ZIMFacade create(Context r100) {
        monitor-enter(ZIMFacadeBuilder.class);
        if (r100 == null) goto L13;
        ZIMFacade r101 = s_instance;     // Catch: Throwable -> L14
        if (r101 != null) goto L8;
        s_instance = new ZIMFacade(r100);     // Catch: Throwable -> L14
    L9:
        ZIMFacade r102 = s_instance;     // Catch: Throwable -> L14
        monitor-exit(ZIMFacadeBuilder.class);
        return r102;
    L8:
        r101.updateContext(r100);     // Catch: Throwable -> L14
        goto L9
    L13:
        throw new RuntimeException("context Can't be null");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
