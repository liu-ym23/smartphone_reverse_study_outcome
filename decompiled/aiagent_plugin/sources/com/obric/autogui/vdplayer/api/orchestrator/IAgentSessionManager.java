package com.obric.autogui.vdplayer.api.orchestrator;

import com.obric.autogui.vdplayer.api.a.b;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.h;

/* JADX INFO: compiled from: IAgentSessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAgentSessionManager {

    /* JADX INFO: compiled from: IAgentSessionManager.kt */
    public interface a {
        h<com.obric.autogui.vdplayer.api.a.a> a();

        ak<b> b();
    }

    h<a> getActiveSession();

    a getSession(String r1);
}
