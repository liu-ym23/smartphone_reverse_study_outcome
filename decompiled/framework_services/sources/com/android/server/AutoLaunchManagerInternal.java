package com.android.server;

import android.content.ComponentName;
import com.android.internal.appwidget.IAppWidgetHost;

/* JADX INFO: loaded from: classes.dex */
public abstract class AutoLaunchManagerInternal {
    public abstract void addHighPowerApp(String r1);

    public abstract boolean isPackageAutoLaunchEnabled(String r1);

    public abstract String isSkipByAutoLaunch(String r1, String r2, String r3, int r4);

    public abstract void onWidgetProviderAddedOrChangedLocked(int r1, IAppWidgetHost r2, String r3, int r4);

    public abstract void onWidgetRemovedLocked(int r1, IAppWidgetHost r2, String r3, int r4);

    public abstract void onWidgetsClearedLocked();

    public abstract void setAutoLaunchPackageEnabled(String r1, boolean r2, boolean r3, boolean r4);

    public abstract boolean showChooseDialogForDoubleApp(ComponentName r1);

    public AutoLaunchManagerInternal() {
    }
}
