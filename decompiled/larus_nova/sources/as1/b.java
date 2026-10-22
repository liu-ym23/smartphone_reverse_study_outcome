package as1;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16089a;

    public b(int r100) {
        this.f16089a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f16089a;     // Catch: Throwable -> L7
        Context r101 = s1.getContext();     // Catch: Throwable -> L7
        if (r101 == null) goto L10;
        f2.d(r101.getString(r100), 1);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
