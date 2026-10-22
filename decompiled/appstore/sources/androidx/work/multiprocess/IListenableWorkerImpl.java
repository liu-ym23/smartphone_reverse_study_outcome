package androidx.work.multiprocess;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IListenableWorkerImpl extends IInterface {
    public static final String DESCRIPTOR = "androidx.work.multiprocess.IListenableWorkerImpl";

    void interrupt(byte[] r10, IWorkManagerImplCallback r11) throws RemoteException;

    void startWork(byte[] r10, IWorkManagerImplCallback r11) throws RemoteException;
}
