package re;

import com.bytedance.android.alog.ILibLoader;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes4.dex */
public class c implements ILibLoader {
    public c() {
    }

    @Override // com.bytedance.android.alog.ILibLoader
    public void loadLibrary(String r10) {
        com.bytedance.librarian.a.a(CloudControlInf.ALOG, a.f23901b.c());     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary(CloudControlInf.ALOG);
    }
}
