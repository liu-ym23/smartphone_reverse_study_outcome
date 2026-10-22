package c0b;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.cameraview.cameraViewV2.CaptureLayoutV2;
import com.ss.android.lark.cameraview.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayoutV2 f21969a;

    public a(CaptureLayoutV2 r100) {
        this.f21969a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w r100 = this.f21969a.f410881d;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");     // Catch: Throwable -> L7
        r100 = null;
    L5:
        r100.setEnabled(true);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
