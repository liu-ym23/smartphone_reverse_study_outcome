package com.obric.android.agilelogger.b;

import android.content.Intent;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: FormatUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<a, com.obric.android.agilelogger.a.b> f22389a;

    /* JADX INFO: compiled from: FormatUtils.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22390a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f22391b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f22392c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f22393d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f22394e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        private static final /* synthetic */ a[] j = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(j.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("MSG", 0);
            f22390a = r0;
            a r1 = new a("JSON", 1);
            f22391b = r1;
            a r3 = new a("BUNDLE", 2);
            f22392c = r3;
            a r5 = new a("INTENT", 3);
            f22393d = r5;
            a r7 = new a("THROWABLE", 4);
            f22394e = r7;
            a r9 = new a("BORDER", 5);
            f = r9;
            a r11 = new a("STACKTRACE", 6);
            g = r11;
            a r13 = new a("THREAD", 7);
            h = r13;
            a r15 = new a("STACKTRACE_STR", 8);
            i = r15;
            j = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }
    }

    static {
        ConcurrentHashMap<a, com.obric.android.agilelogger.a.b> r0 = new ConcurrentHashMap();
        f22389a = r0;
        r0.put(a.f22390a, new com.obric.android.agilelogger.a.b.a());
        f22389a.put(a.f22391b, new com.obric.android.agilelogger.a.b.a.a());
        f22389a.put(a.f22392c, new com.obric.android.agilelogger.a.b.b.a());
        f22389a.put(a.f22393d, new com.obric.android.agilelogger.a.b.b.b());
        f22389a.put(a.f, new com.obric.android.agilelogger.a.a.b());
        f22389a.put(a.g, new com.obric.android.agilelogger.a.c.a());
        f22389a.put(a.h, new com.obric.android.agilelogger.a.d.a());
        f22389a.put(a.f22394e, new com.obric.android.agilelogger.a.b.c.a());
    }

    public static String a(a r3, String r4) {
        com.obric.android.agilelogger.a.b r0 = (com.obric.android.agilelogger.a.b) ZeusTransformUtils.preCheckCast(f22389a.get(r3), com.obric.android.agilelogger.a.b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return r4;
    L5:
        if (r3 != a.f) goto L9;
        return r0.a(new String[]{r4});
    L9:
        return r0.a(r4);
    }

    public static String a(a r2, StackTraceElement[] r3) {
        return ((com.obric.android.agilelogger.a.b) ZeusTransformUtils.preCheckCast(f22389a.get(r2), com.obric.android.agilelogger.a.b.class, "com.obric.aiagent.plugin")).a(r3);
    }

    public static String a(a r2, Bundle r3) {
        return ((com.obric.android.agilelogger.a.b.b.a) ZeusTransformUtils.preCheckCast((com.obric.android.agilelogger.a.b) ZeusTransformUtils.preCheckCast(f22389a.get(r2), com.obric.android.agilelogger.a.b.class, "com.obric.aiagent.plugin"), com.obric.android.agilelogger.a.b.b.a.class, "com.obric.aiagent.plugin")).a(r3);
    }

    public static String a(a r2, Intent r3) {
        return ((com.obric.android.agilelogger.a.b.b.b) ZeusTransformUtils.preCheckCast((com.obric.android.agilelogger.a.b) ZeusTransformUtils.preCheckCast(f22389a.get(r2), com.obric.android.agilelogger.a.b.class, "com.obric.aiagent.plugin"), com.obric.android.agilelogger.a.b.b.b.class, "com.obric.aiagent.plugin")).a(r3);
    }

    public static String a(a r2, Throwable r3) {
        return ((com.obric.android.agilelogger.a.b) ZeusTransformUtils.preCheckCast(f22389a.get(r2), com.obric.android.agilelogger.a.b.class, "com.obric.aiagent.plugin")).a(r3);
    }

    public static String a(a r2, Thread r3) {
        return ((com.obric.android.agilelogger.a.b) ZeusTransformUtils.preCheckCast(f22389a.get(r2), com.obric.android.agilelogger.a.b.class, "com.obric.aiagent.plugin")).a(r3);
    }
}
