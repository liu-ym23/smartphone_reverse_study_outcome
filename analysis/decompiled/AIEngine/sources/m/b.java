package m;

import androidx.datastore.preferences.protobuf.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f10431c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f10432d = new a();

    /* renamed from: b, reason: collision with root package name */
    public final c f10433b = new c();

    public static b k() {
        if (f10431c != null) {
            return f10431c;
        }
        synchronized (b.class) {
            try {
                if (f10431c == null) {
                    f10431c = new b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10431c;
    }
}
