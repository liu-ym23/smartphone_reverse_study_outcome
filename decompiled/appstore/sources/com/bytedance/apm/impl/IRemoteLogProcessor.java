package com.bytedance.apm.impl;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IRemoteLogProcessor extends IInterface {
    String getSlardarConfig() throws RemoteException;
}
