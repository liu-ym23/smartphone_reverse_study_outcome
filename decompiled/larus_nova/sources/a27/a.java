package a27;

import com.bytedance.bdp.bdpbase.ipc.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, r> f1419a;

    /* JADX INFO: renamed from: a27.a$a, reason: collision with other inner class name */
    public static class C0005a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1420a = null;

        static {
            f1420a = new a();
        }
    }

    public a() {
        this.f1419a = new ConcurrentHashMap();
    }
}
