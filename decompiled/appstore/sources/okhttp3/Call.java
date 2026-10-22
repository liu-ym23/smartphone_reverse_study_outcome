package okhttp3;

import java.io.IOException;
import okhttp3.internal.connection.StreamAllocation;

/* JADX INFO: loaded from: classes4.dex */
public interface Call extends Cloneable {

    public interface Factory {
        Call newCall(Request r10);
    }

    void cancel();

    /* JADX INFO: renamed from: clone */
    Call mo57clone();

    void enqueue(Callback r10);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    StreamAllocation streamAllocation();
}
