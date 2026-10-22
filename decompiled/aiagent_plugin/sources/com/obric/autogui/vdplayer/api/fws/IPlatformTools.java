package com.obric.autogui.vdplayer.api.fws;

import android.content.Context;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: IPlatformTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IPlatformTools {
    void putSessionInfo(JSONObject r1, IAutoActionAgentEventListener.SessionInfo r2);

    void startAppOnMainDisplay(Context r1, IAutoActionAgentEventListener.OperatingAppInfo r2);
}
