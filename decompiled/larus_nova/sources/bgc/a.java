package bgc;

import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PushMultiProcessSharedProvider f18986c;

    @Override // java.lang.Runnable
    public final void run() {
        PushMultiProcessSharedProvider r100 = this.f18986c;     // Catch: Throwable -> L4
        Uri r101 = PushMultiProcessSharedProvider.c(r100.getContext(), this.f18984a, this.f18985b);     // Catch: Throwable -> L4
        r100.getContext().getContentResolver().notifyChange(r101, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(PushMultiProcessSharedProvider r100, String r101, String r102) {
        this.f18986c = r100;
        this.f18984a = r101;
        this.f18985b = r102;
    }
}
