package com.android.internal.telephony;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ITelephony extends IInterface {

    public static abstract class Stub {
        public Stub() {
        }

        public static ITelephony asInterface(IBinder r7) {
            if (r7 != null) goto L8;
            return null;
        L8:
            return (ITelephony) Class.forName("com.android.internal.telephony.ITelephony$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r7});
        L7:
            return null;
        }
    }

    int getActivePhoneType() throws RemoteException;

    boolean handlePinMmi(String r1) throws RemoteException;

    boolean isImsRegisteredBySubId(int r1) throws RemoteException;

    boolean isVideoTelephonyAvailable(int r1) throws RemoteException;
}
