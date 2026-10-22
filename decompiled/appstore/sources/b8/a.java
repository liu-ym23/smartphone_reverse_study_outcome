package b8;

import android.content.Context;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f5938c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f5939d = "last_upload_time";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FetchDataCallBack f5941b;

    /* JADX INFO: renamed from: b8.a$a, reason: collision with other inner class name */
    public class C0064a implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f5942a;

        public C0064a(a r10) {
            this.f5942a = r10;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            String r15 = " ====== code[" + r11 + "],content[" + r12 + "]";
            if ((r11 / 100) != 2) goto L5;
            j.a("Auto upload user apps success" + r15);
            b0.n().F(a.a(), System.currentTimeMillis(), null, a.b(this.f5942a));
            return;
        L5:
            j.a("Auto upload user apps failed" + r15);
        }
    }

    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f5943a;

        public b(a r10) {
            this.f5943a = r10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.bytedanceos.appstore.network.a.j0(a.c(this.f5943a));
        }
    }

    static {
    }

    public a(Context r10) {
        this.f5941b = new C0064a(this);
        this.f5940a = r10;
    }

    public static /* synthetic */ String a() {
        return f5939d;
    }

    public static /* synthetic */ Context b(a r10) {
        return r10.f5940a;
    }

    public static /* synthetic */ FetchDataCallBack c(a r10) {
        return r10.f5941b;
    }

    public static synchronized a f(Context r10) {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f5938c != null) goto L9;
        f5938c = new a(r10);     // Catch: Throwable -> L7
    L9:
        a r11 = f5938c;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r11;
    }

    public final boolean d() {
        long r10 = b0.n().p(f5939d, null, this.f5940a);
        long r11 = System.currentTimeMillis();
        StringBuilder r12 = new StringBuilder();
        r12.append("auto upload user apps lastTime[");
        r12.append(r10);
        r12.append("],nowTime[");
        r12.append(r11);
        r12.append("],(nowTime - lastTime)[");
        long r13 = r11 - r10;
        r12.append(r13);
        r12.append("]");
        j.a(r12.toString());
        if (r13 < 86400000) goto L5;
        return true;
    L5:
        return false;
    }

    public void e() {
        if (d() == false) goto L5;
        new b(this).start();
        return;
    L5:
        j.e("Auto upload user apps failed cause by interval time is too short");
    }
}
