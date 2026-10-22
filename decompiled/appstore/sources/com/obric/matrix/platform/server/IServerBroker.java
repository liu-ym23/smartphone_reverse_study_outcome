package com.obric.matrix.platform.server;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IServerBroker extends IInterface {
    byte[] invoke(int r10, byte[] r11) throws RemoteException;

    void invokeAsyn(int r10, byte[] r11, IServerCallback r12) throws RemoteException;

    void registerServerCallback(String r10, IServerCallback r11) throws RemoteException;
}
