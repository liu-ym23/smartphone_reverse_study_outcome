package acb;

import com.larus.apm.impl.protector.RunnableProtector;
import h0b.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.a f2905c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f2905c.f2907a.f2906a.f2909b).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((g) r100.next()).a(this.f2903a, this.f2904b);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public c(d.a r100, String r101, int r102) {
        this.f2905c = r100;
        this.f2903a = r101;
        this.f2904b = r102;
    }
}
