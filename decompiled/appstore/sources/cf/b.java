package cf;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes4.dex */
public class b implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f6144d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f6145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHandler f6146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HandlerThread f6147c;

    public b() {
        HandlerThread r10 = new HandlerThread("PushThreadHandler");
        this.f6147c = r10;
        r10.start();
        Looper r11 = r10.getLooper();
        this.f6145a = r11;
        this.f6146b = new WeakHandler(r11, this);
    }

    public static b b() {
        if (f6144d != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f6144d != null) goto L11;
        f6144d = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f6144d;
    }

    public WeakHandler a() {
        return this.f6146b;
    }

    public void c(Runnable r10) {
        d(r10, 0);
    }

    public void d(Runnable r10, long r11) {
        if (r11 > 0) goto L5;
        this.f6146b.post(r10);
        return;
    L5:
        this.f6146b.postDelayed(r10, r11);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
    }
}
