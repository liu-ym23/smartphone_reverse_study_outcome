package com.android.server.am;

import android.app.SurfaceFpsInfo;
import android.os.DebugSmtEx;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ICollaborationManagerService {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void reportSurfaceFps(List<SurfaceFpsInfo> surfaceFpsInfoList) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
