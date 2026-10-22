package com.bytedance.crash.mira;

import org.json.JSONArray;

/* JADX INFO: compiled from: NpthMiraApi.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static a f7562a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f7563b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7564c = false;

    /* JADX INFO: compiled from: NpthMiraApi.java */
    interface a {
        void a(C0169b r1);
    }

    /* JADX INFO: renamed from: com.bytedance.crash.mira.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NpthMiraApi.java */
    public static class C0169b {
        public C0169b() {
        }
    }

    /* JADX INFO: compiled from: NpthMiraApi.java */
    public interface c {
        JSONArray a();
    }

    static {
    }

    public static JSONArray a() {
        c r0 = f7563b;
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.a();
    L11:
        return null;
    }

    public static boolean b() {
        return f7564c;
    }

    public static void c() {
        f7564c = true;
    }

    public static void a(C0169b r1) {
        a r0 = f7562a;
        if (r0 == null) goto L9;
        r0.a(r1);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
