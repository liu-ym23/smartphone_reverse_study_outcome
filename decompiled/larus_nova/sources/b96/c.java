package b96;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.update.UpdateException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f18299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UpdateException f18300b;

    public c(e r100, UpdateException r101) {
        this.f18299a = r100;
        this.f18300b = r101;
    }

    public final void a() {
        e r100 = this.f18299a;     // Catch: Throwable -> L10
        GeckoUpdateListener r101 = r100.f18306e;     // Catch: Throwable -> L10
        if (r101 == null) goto L5;
        r101.onDownloadFail(r100.f18307f.getPack(), this.f18300b);     // Catch: Throwable -> L10
    L5:
        Set<GeckoUpdateListener> r102 = ty5.a.f547967a;     // Catch: Throwable -> L10
        Iterator r103 = ((CopyOnWriteArraySet) ty5.a.f547967a).iterator();     // Catch: Throwable -> L10
    L6:
        if (r103.hasNext() == false) goto L16;
        ((GeckoUpdateListener) r103.next()).onDownloadFail(this.f18299a.f18307f.getPack(), this.f18300b);     // Catch: Throwable -> L10
        goto L6
    L16:
        return;
    L10:
        th = move-exception;
        GeckoLogger.w("download onFailed exception: " + th.getMessage());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
