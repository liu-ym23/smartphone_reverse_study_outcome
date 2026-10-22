package G1;

import F1.b;
import F1.c;
import com.apm.insight.CrashType;
import com.apm.insight.IOOMCallback;

/* loaded from: classes2.dex */
public final class a implements IOOMCallback {
    @Override // com.apm.insight.IOOMCallback
    public final void onCrash(CrashType crashType, Throwable th, Thread thread, long j5) {
        try {
            if (b.b().d()) {
                return;
            }
            c.e().a(j5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
