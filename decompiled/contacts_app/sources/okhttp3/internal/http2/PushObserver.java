package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes5.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = null;

    boolean onData(int r1, BufferedSource r2, int r3, boolean r4) throws IOException;

    boolean onHeaders(int r1, List<Header> r2, boolean r3);

    boolean onRequest(int r1, List<Header> r2);

    void onReset(int r1, ErrorCode r2);

    static {
        CANCEL = new AnonymousClass1();
    }
}
