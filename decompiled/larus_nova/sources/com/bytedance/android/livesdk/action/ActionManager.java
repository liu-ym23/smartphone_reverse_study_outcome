package com.bytedance.android.livesdk.action;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ActionManager {
    private static ActionManager sInstance;
    private ActionHandler mActionHandler;

    public static ActionManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ActionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ActionManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ActionManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void clear() {
        this.mActionHandler.clear();
    }

    private ActionManager() {
        this.mActionHandler = new ActionHandler();
    }

    public void action(String r100) {
        actionCallback(r100, null);
    }

    public boolean canHandle(String r100) {
        return this.mActionHandler.canHandle(r100);
    }

    public void register(BaseActionMethod r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mActionHandler.registerActionMethod(r100);
    }

    public void unregister(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mActionHandler.unregisterAction(r100);
    }

    public void actionCallback(String r100, BaseActionMethod.Callback r101) {
        this.mActionHandler.handleAction(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
