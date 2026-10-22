package com.bytedance.android.livesdk.message.interceptor;

import com.bytedance.android.live.base.model.message.f1;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements ulc.b {
    public e() {
    }

    @Override // ulc.b
    public final String getName() {
        return "HotChatInterceptor";
    }

    @Override // vlc.b
    public final boolean onMessage(tlc.d r100) {
        if ((r100 instanceof f1) == false) goto L10;
        f1 r101 = (f1) r100;
        if (r101.getChatContentType() == 2) goto L7;
        return false;
    L7:
        if (g.f153535a.getValue().booleanValue() == true) goto L13;
        ALogger.i("HotChatInterceptor", "intercept hot message due to setting, chat type: " + r101.getChatContentType());
        return true;
    L13:
        return false;
    L10:
        return false;
    }
}
