package au3;

import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends cv3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f16303d;

    public a() {
        this.f16303d = b.f16304g;
        super(1200000);
    }

    @Override // java.lang.Runnable
    public final void run() {
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f16303d.f16309e);     // Catch: Throwable -> L4
        b r100 = this.f16303d;     // Catch: Throwable -> L4
        r100.f16309e = null;     // Catch: Throwable -> L4
        r100.f16308d = true;     // Catch: Throwable -> L4
        this.f16303d.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
