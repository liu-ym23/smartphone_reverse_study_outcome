package android.net;

import android.os.Looper;
import android.os.Message;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
interface NetworkFactoryShim {
    void dump(FileDescriptor r1, PrintWriter r2, String[] r3);

    Looper getLooper();

    NetworkProvider getProvider();

    int getRequestCount();

    int getSerialNumber();

    Message obtainMessage(int r1, int r2, int r3, Object r4);

    void reevaluateAllRequests();

    void register(String r1);

    void releaseRequestAsUnfulfillableByAnyFactory(NetworkRequest r1);

    void setCapabilityFilter(NetworkCapabilities r1);

    void setScoreFilter(int r1);

    void setScoreFilter(NetworkScore r1);

    void terminate();

    default void registerIgnoringScore(String logTag) {
        throw new UnsupportedOperationException();
    }
}
