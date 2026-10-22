package com.stepos.common.alphame;

import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAlphaMeClient extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.common.alphame.IAlphaMeClient";
    public static final int ON_RECEIVER_TRANSACTION = 2;
    public static final int ON_RESULT_TRANSACTION = 1;

    void onReceiver(Args args) throws RemoteException;

    void onResult(Args args) throws RemoteException;
}
