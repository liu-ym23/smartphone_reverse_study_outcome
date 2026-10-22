package ic;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f20562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List f20563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile com.bytedance.retrofit2.f f20564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile com.bytedance.retrofit2.f f20565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap f20566f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap f20567g = null;

    static {
        f20561a = new f();
        f20562b = "";
        f20563c = new ArrayList();
        f20566f = new ConcurrentHashMap();
        f20567g = new ConcurrentHashMap();
    }

    public f() {
    }

    public final void a() {
        monitor-enter(f.class);
        f20565e = null;     // Catch: Throwable -> L8
        f20567g.clear();     // Catch: Throwable -> L8
        Unit r10 = Unit.f21064a;     // Catch: Throwable -> L8
        monitor-exit(f.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void b() {
        monitor-enter(f.class);
        f20564d = null;     // Catch: Throwable -> L8
        f20566f.clear();     // Catch: Throwable -> L8
        Unit r10 = Unit.f21064a;     // Catch: Throwable -> L8
        monitor-exit(f.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void c(String r10, List r11) {
        q.g(r10, "host");
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        f20562b = r10;
        if (r11 == null) goto L9;
        List r12 = b0.z0(r11);
        if (r12 == null) goto L9;
    L10:
        f20563c = r12;
        if (f20564d == null) goto L14;
        b();
    L14:
        if (f20565e == null) goto L17;
        a();
        return;
    L17:
        return;
    L9:
        r12 = new ArrayList();
        goto L10
    }
}
