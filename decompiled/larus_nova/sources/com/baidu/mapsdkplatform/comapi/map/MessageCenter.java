package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import com.baidu.platform.comjni.engine.MessageProxy;

/* JADX INFO: loaded from: classes39.dex */
public class MessageCenter {
    public MessageCenter() {
    }

    public static void registMessage(int r100, Handler r101) {
        MessageProxy.registerMessageHandler(r100, r101);
    }

    public static void unregistMessage(int r100, Handler r101) {
        MessageProxy.unRegisterMessageHandler(r100, r101);
    }
}
