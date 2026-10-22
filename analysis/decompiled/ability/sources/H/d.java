package H;

import android.app.Application;
import android.content.Context;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f708a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;

    public d(Context context, long j5, long j6, boolean z10) {
        this.f708a = context;
        this.b = j5;
        this.c = j6;
        this.d = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Context applicationContext = this.f708a;
            F0.a aVar = new F0.a();
            if (applicationContext != null) {
                if (!(applicationContext instanceof Application)) {
                    applicationContext = applicationContext.getApplicationContext();
                }
                aVar.f515a = (Application) applicationContext;
            }
            aVar.a(this.b, this.c, this.d);
        } catch (Exception unused) {
        }
    }
}
