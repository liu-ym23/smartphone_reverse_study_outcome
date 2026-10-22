package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = null;

    static {
        CANCEL = new AnonymousClass1();
    }

    boolean onData(int r10, BufferedSource r11, int r12, boolean r13) throws IOException;

    boolean onHeaders(int r10, List<Header> r11, boolean r12);

    boolean onRequest(int r10, List<Header> r11);

    void onReset(int r10, ErrorCode r11);
}
