package z4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f14258b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f14259a = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b bVar = b.this;
            C0181b c0181b = (C0181b) message.obj;
            synchronized (bVar.f14259a) {
                try {
                    if (c0181b == null || c0181b == null) {
                        c0181b.getClass();
                        throw null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: z4.b$b, reason: collision with other inner class name */
    public static class C0181b {
    }

    public b() {
        new Handler(Looper.getMainLooper(), new a());
    }

    public static b a() {
        if (f14258b == null) {
            f14258b = new b();
        }
        return f14258b;
    }
}
