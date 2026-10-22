package com.bytedanceos.common.networkv2.push;

import com.bytedanceos.common.networkv2.rest.AbstractRest;
import pg.a;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateAppPushRest extends AbstractRest {
    private static volatile UpdateAppPushRest sInstance;
    private UpdateAppPushService mService;

    private UpdateAppPushRest() {
        init();
    }

    public static UpdateAppPushRest instance() {
        if (sInstance != null) goto L16;
        monitor-enter(UpdateAppPushRest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new UpdateAppPushRest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(UpdateAppPushRest.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    public void getUpdateAppPush(Subscriber r10, String r11) {
        this.mService.getUpdateAppPush(r11).s(a.c()).q(r10);
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (UpdateAppPushService) this.retrofit.d(UpdateAppPushService.class);
    }
}
