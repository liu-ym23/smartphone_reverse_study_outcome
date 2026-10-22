package os.teatracker;

import android.content.Context;

/* JADX INFO: compiled from: BaseHandler.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class c {

    /* JADX INFO: compiled from: BaseHandler.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TeaHandler f40689a = null;

        static {
            f40689a = new TeaHandler();
        }
    }

    public abstract d.a a();

    public abstract void a(Context r1, e r2);

    public abstract void a(g r1);

    public abstract Boolean b();

    public abstract String c();

    abstract e e();

    abstract Context getContext();

    c() {
    }

    public static c d() {
        return a.f40689a;
    }
}
