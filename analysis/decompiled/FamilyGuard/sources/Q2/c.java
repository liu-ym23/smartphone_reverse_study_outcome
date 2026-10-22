package Q2;

import Y2.f;
import android.app.Application;
import android.text.TextUtils;
import g3.C0739b;
import g3.C0742e;
import java.io.File;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f4914d;

    /* renamed from: a, reason: collision with root package name */
    private Application f4915a;

    /* renamed from: b, reason: collision with root package name */
    private String f4916b;

    /* renamed from: c, reason: collision with root package name */
    private int f4917c;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f4918a = new c();
    }

    public static c a() {
        if (f4914d) {
            return b.f4918a;
        }
        throw new IllegalStateException("UsageStatsProxy3 is not initialised - invoke at least once with parameterised init");
    }

    public static void b(Application application, Q2.b bVar, Q2.a aVar, String str, String str2) {
        if (aVar == null) {
            aVar = new Q2.a();
        }
        Q2.a aVar2 = aVar;
        if (f4914d) {
            return;
        }
        f4914d = true;
        a().c(application, bVar.d(), aVar2, str, str2);
    }

    private void c(Application application, int i5, Q2.a aVar, String str, String str2) {
        File externalFilesDir;
        if (application == null) {
            throw new IllegalArgumentException("The context is null!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("appId is null!");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("initConfig is null!");
        }
        this.f4915a = application;
        this.f4916b = str;
        this.f4917c = i5;
        if (C0742e.f17578d && (externalFilesDir = application.getExternalFilesDir(null)) != null) {
            C0742e.j(new C0739b(externalFilesDir.getAbsolutePath()));
        }
        f.m().e(this.f4915a, this.f4917c, this.f4916b, str2);
        C0742e.c("UsageStatsProxy3", "UsageStatsProxy3 init complete");
    }

    public void d(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f.m().f(str, str2, map, null);
    }

    private c() {
    }
}
