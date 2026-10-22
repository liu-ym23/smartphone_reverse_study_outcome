package androidx.work.multiprocess;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IWorkManagerImpl extends IInterface {
    public static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";

    void cancelAllWork(IWorkManagerImplCallback r10) throws RemoteException;

    void cancelAllWorkByTag(String r10, IWorkManagerImplCallback r11) throws RemoteException;

    void cancelUniqueWork(String r10, IWorkManagerImplCallback r11) throws RemoteException;

    void cancelWorkById(String r10, IWorkManagerImplCallback r11) throws RemoteException;

    void enqueueContinuation(byte[] r10, IWorkManagerImplCallback r11) throws RemoteException;

    void enqueueWorkRequests(byte[] r10, IWorkManagerImplCallback r11) throws RemoteException;

    void queryWorkInfo(byte[] r10, IWorkManagerImplCallback r11) throws RemoteException;

    void setForegroundAsync(byte[] r10, IWorkManagerImplCallback r11) throws RemoteException;

    void setProgress(byte[] r10, IWorkManagerImplCallback r11) throws RemoteException;

    void updateUniquePeriodicWorkRequest(String r10, byte[] r11, IWorkManagerImplCallback r12) throws RemoteException;
}
