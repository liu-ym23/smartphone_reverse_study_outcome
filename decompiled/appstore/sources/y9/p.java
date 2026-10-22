package y9;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class p extends x9.a {
    public p() {
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.SP;
    }

    @Override // x9.a
    public synchronized boolean e(w9.a r10) {
        monitor-enter(this);
        File r11 = aa.g.a(v9.a.k().i());     // Catch: Throwable -> L8
        if (r11 != null) goto L10;
        i("sp文件拷贝失败", r10);     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L10:
        ba.b.b().e(r10, r11.getParentFile(), "default_sp_file_type");     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L8:
        th = move-exception;
        throw th;
    }
}
