package com.slardaros.client;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class BaseHandler {
    public abstract void init(Context r1);

    public abstract void onAbResult(String r1, int r2, String r3);

    public abstract void onEvent(AgentEvent r1);

    public abstract void onEvents(List<AgentEvent> r1);

    public abstract void onExit();

    public abstract int onRequestAppProfile(String r1, String r2, String r3, String r4, String r5, boolean r6);

    public abstract boolean onRequestProfile(String r1, String r2, String r3, String r4, String r5, boolean r6);

    public abstract void onUnbind();

    BaseHandler() {
    }

    public static BaseHandler getSlardarHandler() {
        return SlardarHandler.getInstance();
    }
}
