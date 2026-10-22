package com.obric.matrix.platform.server;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IServerCallback extends IInterface {
    void onResult(int r10, byte[] r11) throws RemoteException;
}
