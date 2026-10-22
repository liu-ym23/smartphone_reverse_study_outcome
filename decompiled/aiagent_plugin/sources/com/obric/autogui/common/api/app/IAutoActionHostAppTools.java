package com.obric.autogui.common.api.app;

import android.app.Application;
import android.content.Context;
import android.os.UserHandle;
import java.util.Date;

/* JADX INFO: compiled from: IAutoActionHostAppTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionHostAppTools {
    Context getAppContext();

    Context getAppContextOrNull();

    long getAppVersionCode();

    Date getBuildTime();

    String getFunctionName();

    Application getHostAppContext();

    HostAppInfo getHostAppInfo();

    String getHostAppPackage();

    UserHandle getUserHandle();

    boolean isSelf(String r1, String r2);
}
