package T3;

import C5.f;
import C7.r;
import android.util.Log;
import kotlin.Result;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1204a;
    public final /* synthetic */ b b;

    public /* synthetic */ a(b bVar, int i) {
        this.f1204a = i;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objA;
        int i = this.f1204a;
        b bVar = this.b;
        switch (i) {
            case 0:
                try {
                    B5.a aVar = new B5.a(bVar, 6);
                    f fVarC = f.c();
                    synchronized (fVarC) {
                        fVarC.h = aVar;
                    }
                    objA = r.f317a;
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    Log.w("DeviceIdManager", "setOAIDChangeListener failed", thA);
                }
                bVar.b("bootstrap");
                return;
            case 1:
                bVar.b("oaidChanged");
                return;
            case 2:
                bVar.b("retry");
                return;
            default:
                bVar.b("kick");
                return;
        }
    }
}
