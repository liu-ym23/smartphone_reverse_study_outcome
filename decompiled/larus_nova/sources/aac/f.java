package aac;

import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2385c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f2386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<b, Object> f2387b;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public interface b {
        void a(UserSetting r100);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f2388a = null;

        static {
            f2388a = new f();
        }
    }

    static {
        f2385c = new Object();
    }

    public f() {
        this.f2386a = new CopyOnWriteArrayList();
        this.f2387b = new ConcurrentHashMap();
    }
}
