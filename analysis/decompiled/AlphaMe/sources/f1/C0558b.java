package f1;

import android.content.Context;
import j.C0622a;

/* renamed from: f1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0558b {

    /* renamed from: b, reason: collision with root package name */
    public static final C0558b f12525b;

    /* renamed from: a, reason: collision with root package name */
    public C0622a f12526a;

    static {
        C0558b c0558b = new C0558b();
        c0558b.f12526a = null;
        f12525b = c0558b;
    }

    public static C0622a a(Context context) {
        C0622a c0622a;
        C0558b c0558b = f12525b;
        synchronized (c0558b) {
            try {
                if (c0558b.f12526a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    c0558b.f12526a = new C0622a(context, 2);
                }
                c0622a = c0558b.f12526a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0622a;
    }
}
