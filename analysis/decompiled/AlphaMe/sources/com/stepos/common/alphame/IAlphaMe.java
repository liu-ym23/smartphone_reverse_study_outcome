package com.stepos.common.alphame;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface IAlphaMe extends IInterface {
    public static final int ADD_CLIENT_TRANSACTION = 1;
    public static final int COLLECT_ITEM_TRANSACTION = 6;
    public static final String DESCRIPTOR = "com.stepos.common.alphame.IAlphaMe";
    public static final int EXEC_TRANSACTION = 5;
    public static final int REGISTER_RECEIVER_TRANSACTION = 3;
    public static final int REMOVE_CLIENT_TRANSACTION = 2;
    public static final int UNREGISTER_RECEIVER_TRANSACTION = 4;

    void addClient(IBinder iBinder) throws RemoteException;

    void collect(String str, Args args) throws RemoteException;

    void exec(IBinder iBinder, String str, Args args, int i4, int i5) throws RemoteException;

    void registerActionReceiver(IBinder iBinder, ArrayList<String> arrayList, int i4) throws RemoteException;

    void removeClient(IBinder iBinder) throws RemoteException;

    void unregisterActionReceiver(IBinder iBinder, int i4) throws RemoteException;
}
