package w2;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class i extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Looper f43052a;

    public i(Looper looper) {
        super(looper);
        this.f43052a = Looper.getMainLooper();
    }

    public i(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f43052a = Looper.getMainLooper();
    }
}
