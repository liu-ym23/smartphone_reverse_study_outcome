package bdb;

import android.view.View;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnLongClickListener f18702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f18703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vcb.b f18704c;

    /* JADX INFO: renamed from: bdb.a$a, reason: collision with other inner class name */
    public static final class C0293a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnLongClickListener f18705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f18706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vcb.b f18707c;

        public C0293a() {
        }
    }

    public interface b {
        Object a(Class<? extends Object> r100);
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<Class<? extends Object>, Object> f18708a;

        public c() {
            this.f18708a = new ConcurrentHashMap();
        }

        @Override // bdb.a.b
        public final Object a(Class<? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "actionHandlerApiClass");
            return this.f18708a.get(r100);
        }
    }

    public a(C0293a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f18702a = r100.f18705a;
        this.f18703b = r100.f18706b;
        this.f18704c = r100.f18707c;
    }
}
