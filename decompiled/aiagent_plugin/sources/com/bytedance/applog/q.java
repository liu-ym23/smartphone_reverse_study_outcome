package com.bytedance.applog;

import com.bytedance.bdinstall.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: UriConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    private static boolean g = false;
    private static boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f5954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f5955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u f5958e;
    private final Map<String, String> f;

    /* JADX INFO: renamed from: com.bytedance.applog.q$1, reason: invalid class name */
    /* JADX INFO: compiled from: UriConfig.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: UriConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f5959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f5960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f5961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f5962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private u f5963e;
        private Map<String, String> f;

        public a() {
            this.f = null;
        }

        static /* synthetic */ u a(a r0) {
            return r0.f5963e;
        }

        static /* synthetic */ String[] b(a r0) {
            return r0.f5959a;
        }

        static /* synthetic */ String[] c(a r0) {
            return r0.f5960b;
        }

        static /* synthetic */ String d(a r0) {
            return r0.f5961c;
        }

        static /* synthetic */ String e(a r0) {
            return r0.f5962d;
        }

        static /* synthetic */ Map f(a r0) {
            return r0.f;
        }

        public a a(u r1) {
            this.f5963e = r1;
            return this;
        }

        public a a(String[] r3) {
            if (q.h() == false) goto L5;
            this.f5959a = (String[]) ZeusTransformUtils.preCheckCast(new HashSet(Arrays.asList(r3)).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        L6:
            return this;
        L5:
            this.f5959a = r3;
            goto L6
        }

        public a b(String[] r3) {
            if (q.h() == false) goto L5;
            this.f5960b = (String[]) ZeusTransformUtils.preCheckCast(new HashSet(Arrays.asList(r3)).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        L6:
            return this;
        L5:
            this.f5960b = r3;
            goto L6
        }

        public a a(String r1) {
            this.f5961c = r1;
            return this;
        }

        public a b(String r1) {
            this.f5962d = r1;
            return this;
        }

        public q a() {
            return new q(this, null);
        }
    }

    static {
    }

    /* synthetic */ q(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ boolean h() {
        return g;
    }

    public static String a() {
        if (h == false) goto L5;
        return "/service/2/app_log/";
    L5:
        return "/service/2/app_log_monitor/";
    }

    private q(a r2) {
        this.f5958e = a.a(r2);
        this.f5954a = a.b(r2);
        this.f5955b = a.c(r2);
        this.f5956c = a.d(r2);
        this.f5957d = a.e(r2);
        this.f = a.f(r2);
    }

    public u b() {
        return this.f5958e;
    }

    public String[] c() {
        return this.f5954a;
    }

    public String[] d() {
        return this.f5955b;
    }

    public String e() {
        return this.f5956c;
    }

    public String f() {
        return this.f5957d;
    }

    public Map<String, String> g() {
        return this.f;
    }
}
