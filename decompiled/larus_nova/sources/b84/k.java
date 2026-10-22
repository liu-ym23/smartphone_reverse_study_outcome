package b84;

import android.os.Environment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdinstall.o0;
import com.bytedance.common.utility.io.IOUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f18034a;

    public final void a() {
        ArrayList r100 = new ArrayList();
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (this.f18034a.F == false) goto L30;
    L21:
        Iterator r101 = r100.iterator();
    L23:
        if (r101.hasNext() == false) goto L29;
        String r102 = (String) r101.next();
        IOUtils.deletePath(r102);     // Catch: Throwable -> L27
        com.bytedance.bdinstall.t.d("dt " + r102);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L29:
        return;
    L30:
        r100.add(Environment.getExternalStorageDirectory().getPath() + i84.s.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L15
    L36:
        r100.add(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + i84.s.d());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L4:
        if (this.f18034a.F == false) goto L6;
        String r103 = "device_id";
    L7:
        r100.add(this.f18034a.getContext().getExternalCacheDir().getParent() + HTTP.URL_DEFAULT + r103);     // Catch: Throwable -> L9
        goto L12
    L6:
        r103 = i84.s.d();     // Catch: Throwable -> L9
        goto L7
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

    public k(o0 r100) {
        this.f18034a = r100;
    }
}
