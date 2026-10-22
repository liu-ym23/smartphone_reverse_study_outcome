package c8;

import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f22700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f22701b;

    public c(c0 r100, b r101) {
        this.f22700a = r100;
        this.f22701b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TimeLineEvent.b r100 = new TimeLineEvent.b();     // Catch: Throwable -> L4
        r100.c();     // Catch: Throwable -> L4
        r100.f249287a = "label_pre_call_origin_url";     // Catch: Throwable -> L4
        TimeLineEvent r101 = new TimeLineEvent(r100, null);     // Catch: Throwable -> L4
        ((CopyOnWriteArrayList) this.f22700a.f249326k).add(r101);     // Catch: Throwable -> L4
        this.f22701b.i(this.f22700a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
