package com.ss.android.message;

import android.content.Context;
import com.ss.android.pushmanager.IMessageContext;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface IPushLifeAdapter extends IPushLifeCycleListener {

    public interface IPushDepend {
        void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15, JSONObject r16);

        void onEventV3(String r10, JSONObject r11);
    }

    void handleAppLogUpdate(Context r10, Map<String, String> r11);

    void initOnApplication(Context r10, IMessageContext r11);

    void onSetSettingsData(Context r10, JSONObject r11);

    void setPushDepend(IPushDepend r10);
}
