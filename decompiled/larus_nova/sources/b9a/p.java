package b9a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes4.dex */
public final class p extends a9a.a {
    @Override // a9a.a
    public final String f() {
        return CloudControlInf.SP;
    }

    public p() {
    }

    @Override // a9a.a
    public final synchronized boolean g(z8a.a r100) throws Exception {
        monitor-enter(this);
        PolarisFileWrapper r101 = d9a.e.a(x8a.c.b().getContext());     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
        a9a.a.h("sp文件拷贝失败", r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L8:
        f9a.b.C5874b.f475989a.b(r100, r101.getParentFile(), "default_sp_file_type");     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L11:
        th = move-exception;
        throw th;
    }
}
