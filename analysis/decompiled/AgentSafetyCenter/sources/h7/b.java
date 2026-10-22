package h7;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f5398b;

    /* renamed from: a, reason: collision with root package name */
    public Object f5399a;

    public b(Object obj) {
        this.f5399a = obj;
    }

    public static b a() {
        if (f5398b == null) {
            b bVar = new b();
            bVar.f5399a = new Object();
            Looper mainLooper = Looper.getMainLooper();
            a aVar = new a();
            aVar.f5397a = bVar;
            VarHandle.storeStoreFence();
            new Handler(mainLooper, aVar);
            VarHandle.storeStoreFence();
            f5398b = bVar;
        }
        return f5398b;
    }
}
