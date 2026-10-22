package okhttp3;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f40218b = null;

    /* JADX INFO: compiled from: Interceptor.kt */
    public interface a {
        ab a();

        ad a(ab r1);

        j b();

        e call();
    }

    /* JADX INFO: compiled from: Interceptor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f40219a = null;

        static {
            f40219a = new b();
        }

        private b() {
        }
    }

    static {
        f40218b = b.f40219a;
    }

    ad intercept(a r1);
}
