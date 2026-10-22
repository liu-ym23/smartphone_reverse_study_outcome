package i;

import f3.d;
import w7.e0;

/* loaded from: classes.dex */
public final class a extends e0 {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f4387d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f4388e = new d(1);

    /* renamed from: c, reason: collision with root package name */
    public final c f4389c;

    public a() {
        super(21);
        this.f4389c = new c();
    }

    public static a S() {
        if (f4387d != null) {
            return f4387d;
        }
        synchronized (a.class) {
            try {
                if (f4387d == null) {
                    f4387d = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4387d;
    }
}
