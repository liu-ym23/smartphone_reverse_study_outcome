package x2;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Looper f43473a;

    public c(Looper looper) {
        super(looper);
        this.f43473a = Looper.getMainLooper();
    }

    public c(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f43473a = Looper.getMainLooper();
    }
}
