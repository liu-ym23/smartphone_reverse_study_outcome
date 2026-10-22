package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CronetEngine.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    private static final String TAG = "d";

    /* JADX INFO: compiled from: CronetEngine.java */
    public static class a {
        private static final String TAG = "CronetEngine.Builder";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final k f37897a;

        /* JADX INFO: renamed from: com.ttnet.org.chromium.net.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CronetEngine.java */
        public static abstract class AbstractC1027a {
            public abstract void loadLibrary(String r1);

            public AbstractC1027a() {
            }
        }

        public a(Context r3, boolean r4) {
            this(a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4));
        }

        public a(k r1) {
            this.f37897a = r1;
        }

        public a a(String r2) {
            this.f37897a.h(r2);
            return this;
        }

        public a b(String r2) {
            this.f37897a.g(r2);
            return this;
        }

        public a a(AbstractC1027a r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a a(boolean r2) {
            this.f37897a.b(r2);
            return this;
        }

        public a b(boolean r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a c(String r2) {
            this.f37897a.f(r2);
            return this;
        }

        public a c(boolean r2) {
            this.f37897a.c(r2);
            return this;
        }

        public a d(boolean r2) {
            this.f37897a.d(r2);
            return this;
        }

        public a a() {
            this.f37897a.a();
            return this;
        }

        public a a(TTAppInfoProvider r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a a(aa r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a a(z r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a a(int r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a d(String r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a a(ArrayList<byte[]> r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a a(Map<String[], Pair<byte[], byte[]>> r3) {
            Map<String[], Pair<byte[], byte[]>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            this.f37897a.a(r4);
            return this;
        }

        public a e(String r2) {
            this.f37897a.b(r2);
            return this;
        }

        public a f(String r2) {
            this.f37897a.c(r2);
            return this;
        }

        public a g(String r2) {
            this.f37897a.d(r2);
            return this;
        }

        public a e(boolean r2) {
            this.f37897a.e(r2);
            return this;
        }

        public a f(boolean r2) {
            this.f37897a.f(r2);
            return this;
        }

        public a a(long r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a g(boolean r2) {
            this.f37897a.g(r2);
            return this;
        }

        public a h(boolean r2) {
            this.f37897a.h(r2);
            return this;
        }

        public a h(String r2) {
            this.f37897a.e(r2);
            return this;
        }

        public a a(TTAppInfoProvider.AppInfo r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a i(boolean r2) {
            this.f37897a.i(r2);
            return this;
        }

        public a a(boolean r2, boolean r3) {
            this.f37897a.a(r2, r3);
            return this;
        }

        public a b(long r2) {
            this.f37897a.b(r2);
            return this;
        }

        public a b(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r2) {
            this.f37897a.b(r2);
            return this;
        }

        public a a(TTThreadConfigInfoProvider.b r3) {
            TTThreadConfigInfoProvider.b r4 = (TTThreadConfigInfoProvider.b) ZeusTransformUtils.wrapperContextForParams(r3, TTThreadConfigInfoProvider.b.class, "com.obric.aiagent.plugin");
            this.f37897a.a(r4);
            return this;
        }

        public a a(TTSamplingSettingProvider.TTSlaSamplingSetting r2) {
            this.f37897a.a(r2);
            return this;
        }

        public a a(boolean r2, String r3) {
            this.f37897a.a(r2, r3);
            return this;
        }

        public a j(boolean r2) {
            this.f37897a.j(r2);
            return this;
        }

        public a a(int r2, long r3) {
            this.f37897a.a(r2, r3);
            return this;
        }

        public a a(String r2, int r3, int r4) {
            this.f37897a.a(r2, r3, r4);
            return this;
        }

        private static k a(Context r3, boolean r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            f r6 = (f) ZeusTransformUtils.preCheckCast(a(r5, new ArrayList(f.a(r5))).get(0), f.class, "com.obric.aiagent.plugin");
            if (a(TAG, 3) == false) goto L6;
            a(TAG, String.format("Using '%s' provider for creating CronetEngine.Builder.", new Object[]{r6}));
        L6:
            return r6.a(r4).f37897a;
        }

        static List<f> a(Context r3, List<f> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            List<f> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if (r6.size() == 0) goto L17;
            Iterator<f> r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L11;
            if (((f) ZeusTransformUtils.preCheckCast(r7.next(), f.class, "com.obric.aiagent.plugin")).c() == true) goto L6;
            r7.remove();
            goto L6
        L11:
            if (r6.size() == 0) goto L15;
            Collections.sort(r6, new AnonymousClass1());
            return r6;
        L15:
            throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
        L17:
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        static int b(String r5, String r6) {
            if (r5 == null) goto L20;
            if (r6 == null) goto L20;
            String[] r7 = r5.split("\\.");
            String[] r8 = r6.split("\\.");
            int r0 = 0;
        L6:
            if (r0 >= r7.length) goto L18;
            if (r0 >= r8.length) goto L18;
            int r1 = Integer.parseInt(r7[r0]);     // Catch: NumberFormatException -> L14
            int r2 = Integer.parseInt(r8[r0]);     // Catch: NumberFormatException -> L14
            if (r1 != r2) goto L11;
            r0 = r0 + 1;
            goto L6
        L11:
            return Integer.signum(r1 - r2);
        L14:
            e = move-exception;
            throw new IllegalArgumentException("Unable to convert version segments into integers: " + r7[r0] + " & " + r8[r0], e);
        L18:
            return Integer.signum(r7.length - r8.length);
        L20:
            throw new IllegalArgumentException("The input values cannot be null");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static boolean a(String r1, int r2) {
            if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
            return Log.isLoggable(r1, r2);
        L7:
            if (r2 == 6) goto L9;
        L11:
            return false;
        L9:
            if (Log.isLoggable(r1, r2) == false) goto L11;
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    static {
    }

    public abstract ab a();

    public abstract ac.a a(ac.b r1, Executor r2);

    public abstract ae.a a(ae.b r1, Executor r2);

    public abstract ai.a a(String r1, ai.b r2, Executor r3);

    public abstract URLConnection a(URL r1, Proxy r2, boolean r3);

    public d() {
    }
}
