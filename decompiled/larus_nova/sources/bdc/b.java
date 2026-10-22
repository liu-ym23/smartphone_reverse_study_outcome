package bdc;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f18714a;

    public final void a() {
        Activity r100 = this.f18714a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDestroyed() == false) goto L7;
        return;
    L7:
        if (this.f18714a.isFinishing() == true) goto L17;
        this.f18714a.finish();     // Catch: Exception -> L10
        this.f18714a.overridePendingTransition(0, 0);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("ExitActivityTransition", "exit:" + e);
        return;
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

    public b(FragmentActivity r100) {
        this.f18714a = r100;
    }
}
