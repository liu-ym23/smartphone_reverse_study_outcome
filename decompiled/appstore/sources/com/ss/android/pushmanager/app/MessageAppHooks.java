package com.ss.android.pushmanager.app;

import android.content.Context;
import com.ss.android.pushmanager.IMessageContext;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MessageAppHooks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InitHook f18190a;

    public interface InitHook {
        void tryInit(Context r10);
    }

    public interface PushHook {
        Map<String, String> getHttpCommonParams();

        String getMessageAction();

        IMessageContext getMessageContext();

        String getMessageKeyData();

        Class getNotifyServiceClass();

        String getRomInfo();

        String getSessionKey();

        boolean isSswoActivityisFinish();

        void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15, JSONObject r16);
    }

    static {
    }

    public static InitHook a() {
        return f18190a;
    }
}
