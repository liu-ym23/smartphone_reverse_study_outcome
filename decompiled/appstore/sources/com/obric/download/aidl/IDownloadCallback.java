package com.obric.download.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.download.base.DownloadInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadCallback extends IInterface {

    public static abstract class a extends Binder implements IDownloadCallback {
        public a() {
            attachInterface(this, "com.obric.download.aidl.IDownloadCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L68;
            DownloadInfo r14 = null;
            switch(r10) {
                case 1: goto L63;
                case 2: goto L58;
                case 3: goto L53;
                case 4: goto L48;
                case 5: goto L43;
                case 6: goto L38;
                case 7: goto L33;
                case 8: goto L28;
                case 9: goto L23;
                case 10: goto L18;
                case 11: goto L13;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L11;
            r14 = DownloadInfo.CREATOR.a(r11);
        L11:
            onExtraInfoUpdate(r14);
            r12.writeNoException();
            return true;
        L13:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L16;
            r14 = DownloadInfo.CREATOR.a(r11);
        L16:
            onRetryDelay(r14, r11.readInt(), r11.readString());
            r12.writeNoException();
            return true;
        L18:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L21;
            r14 = DownloadInfo.CREATOR.a(r11);
        L21:
            onRetry(r14, r11.readInt(), r11.readString());
            r12.writeNoException();
            return true;
        L23:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L26;
            r14 = DownloadInfo.CREATOR.a(r11);
        L26:
            onFirstSuccess(r14);
            r12.writeNoException();
            return true;
        L28:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L31;
            r14 = DownloadInfo.CREATOR.a(r11);
        L31:
            onFirstStart(r14);
            r12.writeNoException();
            return true;
        L33:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L36;
            r14 = DownloadInfo.CREATOR.a(r11);
        L36:
            onDownloadCancel(r14);
            r12.writeNoException();
            return true;
        L38:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L41;
            r14 = DownloadInfo.CREATOR.a(r11);
        L41:
            onDownloadFailed(r14, r11.readInt(), r11.readString());
            r12.writeNoException();
            return true;
        L43:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L46;
            r14 = DownloadInfo.CREATOR.a(r11);
        L46:
            onDownloadFinish(r14);
            r12.writeNoException();
            return true;
        L48:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L51;
            r14 = DownloadInfo.CREATOR.a(r11);
        L51:
            onDownloadPause(r14);
            r12.writeNoException();
            return true;
        L53:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L56;
            r14 = DownloadInfo.CREATOR.a(r11);
        L56:
            onDownloading(r14);
            r12.writeNoException();
            return true;
        L58:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L61;
            r14 = DownloadInfo.CREATOR.a(r11);
        L61:
            onDownloadStart(r14);
            r12.writeNoException();
            return true;
        L63:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L66;
            r14 = DownloadInfo.CREATOR.a(r11);
        L66:
            onDownloadPending(r14);
            r12.writeNoException();
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L68:
            r12.writeString("com.obric.download.aidl.IDownloadCallback");
            return true;
        }
    }

    void onDownloadCancel(DownloadInfo r10) throws RemoteException;

    void onDownloadFailed(DownloadInfo r10, int r11, String r12) throws RemoteException;

    void onDownloadFinish(DownloadInfo r10) throws RemoteException;

    void onDownloadPause(DownloadInfo r10) throws RemoteException;

    void onDownloadPending(DownloadInfo r10) throws RemoteException;

    void onDownloadStart(DownloadInfo r10) throws RemoteException;

    void onDownloading(DownloadInfo r10) throws RemoteException;

    void onExtraInfoUpdate(DownloadInfo r10) throws RemoteException;

    void onFirstStart(DownloadInfo r10) throws RemoteException;

    void onFirstSuccess(DownloadInfo r10) throws RemoteException;

    void onRetry(DownloadInfo r10, int r11, String r12) throws RemoteException;

    void onRetryDelay(DownloadInfo r10, int r11, String r12) throws RemoteException;
}
