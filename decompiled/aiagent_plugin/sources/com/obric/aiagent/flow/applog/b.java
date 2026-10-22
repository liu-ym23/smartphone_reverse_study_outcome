package com.obric.aiagent.flow.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IRegisterIPCListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: compiled from: IRegisterIPCListener.kt */
    public static final class a {
        public static void a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        }
    }

    void a();

    void b();
}
