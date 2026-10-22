package com.android.server.am;

import android.annotation.SystemApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface ActivityManagerLocal {
    boolean bindSdkSandboxService(Intent r1, ServiceConnection r2, int r3, IBinder r4, String r5, String r6, int r7) throws RemoteException;

    boolean bindSdkSandboxService(Intent r1, ServiceConnection r2, int r3, IBinder r4, String r5, String r6, Context.BindServiceFlags r7) throws RemoteException;

    boolean bindSdkSandboxService(Intent r1, ServiceConnection r2, int r3, String r4, String r5, int r6) throws RemoteException;

    boolean canAllowWhileInUsePermissionInFgs(int r1, int r2, String r3);

    boolean canStartForegroundService(int r1, int r2, String r3);

    void killSdkSandboxClientAppProcess(IBinder r1);

    ComponentName startSdkSandboxService(Intent r1, int r2, String r3, String r4) throws RemoteException;

    boolean stopSdkSandboxService(Intent r1, int r2, String r3, String r4);

    void tempAllowWhileInUsePermissionInFgs(int r1, long r2);
}
