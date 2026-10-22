package D2;

import com.google.android.gms.common.internal.C1669j;

/* loaded from: classes2.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f2232a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f2233b;

    public v(w wVar, i iVar) {
        this.f2233b = wVar;
        this.f2232a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f2233b.f2235b) {
            try {
                w wVar = this.f2233b;
                if (wVar.f2236c != null) {
                    wVar.f2236c.onFailure((Exception) C1669j.k(this.f2232a.h()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
