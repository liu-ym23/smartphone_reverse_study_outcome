package a6a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxEngineProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f1967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeakReference f1968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f1969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f1970d;

    @Override // java.lang.Runnable
    public final void run() {
        LynxModuleWrapper r100 = (LynxModuleWrapper) this.f1967a.get();     // Catch: Throwable -> L8
        LynxEngineProxy r101 = (LynxEngineProxy) this.f1968b.get();     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        b.a(r100, r101, this.f1969c, this.f1970d);     // Catch: Throwable -> L8
    L13:
        return;
    L6:
        LLog.i("LynxLepusModule", "triggerLepusBridgeAsync failed, LynxModule or LynxEngine has been released.");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public a(WeakReference r100, WeakReference r101, ReadableMap r102, String r103) {
        this.f1967a = r100;
        this.f1968b = r101;
        this.f1969c = r102;
        this.f1970d = r103;
    }
}
