package com.android.server.broadcastradio.hal2;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
class Utils {
    private static final String TAG = "BcRadio2Srv.utils";

    interface FuncThrowingRemoteException<T> {
        T exec() throws RemoteException;
    }

    interface VoidFuncThrowingRemoteException {
        void exec() throws RemoteException;
    }

    private Utils() {
        throw new UnsupportedOperationException("Utils class is noninstantiable");
    }

    static FrequencyBand getBand(int freq) {
        if (freq >= 30) goto L7;
        return FrequencyBand.UNKNOWN;
    L7:
        if (freq >= 500) goto L11;
        return FrequencyBand.AM_LW;
    L11:
        if (freq >= 1705) goto L15;
        return FrequencyBand.AM_MW;
    L15:
        if (freq >= 30000) goto L19;
        return FrequencyBand.AM_SW;
    L19:
        if (freq >= 60000) goto L23;
        return FrequencyBand.UNKNOWN;
    L23:
        if (freq >= 110000) goto L27;
        return FrequencyBand.FM;
    L27:
        return FrequencyBand.UNKNOWN;
    }

    static <T> T maybeRethrow(FuncThrowingRemoteException<T> r) {
        return r.exec();
    L4:
        ex = move-exception;
        ex.rethrowFromSystemServer();
        return null;
    }

    static void maybeRethrow(VoidFuncThrowingRemoteException r) {
        r.exec();     // Catch: RemoteException -> L4
        return;
    L4:
        ex = move-exception;
        ex.rethrowFromSystemServer();
    }
}
