package u2;

import android.content.Context;

/* renamed from: u2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5572c {

    /* renamed from: b, reason: collision with root package name */
    public static final C5572c f42423b = new C5572c();

    /* renamed from: a, reason: collision with root package name */
    public C5571b f42424a = null;

    public static C5571b a(Context context) {
        return f42423b.b(context);
    }

    public final synchronized C5571b b(Context context) {
        try {
            if (this.f42424a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f42424a = new C5571b(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f42424a;
    }
}
