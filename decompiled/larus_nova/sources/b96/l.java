package b96;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f18330a;

    public l(j r100) {
        this.f18330a = r100;
    }

    public final void a() {
        j r100 = this.f18330a;     // Catch: Throwable -> L17
        GeckoUpdateListener r101 = r100.f18320d;     // Catch: Throwable -> L17
        if (r101 == null) goto L9;
        PrepareMeta r102 = r100.f18317a;     // Catch: Throwable -> L17
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("meta");     // Catch: Throwable -> L17
    L8:
        r101.onUpdateStart(r102.getPack());     // Catch: Throwable -> L17
    L9:
        Iterator r103 = ((CopyOnWriteArraySet) ty5.a.f547967a).iterator();     // Catch: Throwable -> L17
    L10:
        if (r103.hasNext() == false) goto L25;
        GeckoUpdateListener r104 = (GeckoUpdateListener) r103.next();     // Catch: Throwable -> L17
        PrepareMeta r105 = this.f18330a.f18317a;     // Catch: Throwable -> L17
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("meta");     // Catch: Throwable -> L17
    L15:
        r104.onUpdateStart(r105.getPack());     // Catch: Throwable -> L17
        goto L10
    L25:
        return;
    L17:
        th = move-exception;
        GeckoLogger.w("onUpdateStart exception: " + th.getMessage());
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
