package aa4;

import com.bytedance.bdp.bdpbase.ipc.d;
import com.bytedance.bdp.bdpbase.ipc.r;
import g94.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, r> f2341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f2342b;

    /* JADX INFO: renamed from: aa4.a$a, reason: collision with other inner class name */
    public static class C0037a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2343a = null;

        static {
            f2343a = new a();
        }
    }

    public a() {
        this.f2341a = new ConcurrentHashMap();
        this.f2342b = d.a.a();
        b.d("IPC_BdpIPCCenter", new Object[]{"<init>"});
    }
}
