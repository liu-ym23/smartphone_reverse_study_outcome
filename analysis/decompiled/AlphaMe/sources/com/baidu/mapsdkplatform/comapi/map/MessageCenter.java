package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import com.baidu.platform.comjni.engine.MessageProxy;

/* loaded from: classes.dex */
public class MessageCenter {
    public static void registMessage(int i4, Handler handler) {
        MessageProxy.registerMessageHandler(i4, handler);
    }

    public static void unregistMessage(int i4, Handler handler) {
        MessageProxy.unRegisterMessageHandler(i4, handler);
    }
}
