package androidx.work.multiprocess;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IWorkManagerImplCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImplCallback";

    void onFailure(String r10) throws RemoteException;

    void onSuccess(byte[] r10) throws RemoteException;
}
