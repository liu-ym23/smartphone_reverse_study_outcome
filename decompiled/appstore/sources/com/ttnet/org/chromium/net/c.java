package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18485a = "c";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f18486a;

        /* JADX INFO: renamed from: com.ttnet.org.chromium.net.c$a$a, reason: collision with other inner class name */
        public class C0224a implements Comparator {
            public C0224a() {
            }

            public int a(d r10, d r11) {
                if ("Fallback-Cronet-Provider".equals(r10.d()) == false) goto L7;
                return 1;
            L7:
                if ("Fallback-Cronet-Provider".equals(r11.d()) == false) goto L11;
                return -1;
            L11:
                return -a.b(r10.e(), r11.e());
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
                return a((d) r10, (d) r11);
            }
        }

        public static abstract class b {
            public b() {
            }

            public abstract void loadLibrary(String r10);
        }

        public a(Context r10) {
            this(c(r10));
        }

        public static int b(String r10, String r11) {
            if (r10 == null) goto L21;
            if (r11 == null) goto L21;
            String[] r12 = r10.split("\\.");
            String[] r13 = r11.split("\\.");
            int r14 = 0;
        L6:
            if (r14 >= r12.length) goto L19;
            if (r14 >= r13.length) goto L19;
            int r15 = Integer.parseInt(r12[r14]);     // Catch: NumberFormatException -> L13
            int r16 = Integer.parseInt(r13[r14]);     // Catch: NumberFormatException -> L13
            if (r15 != r16) goto L11;
            r14 = r14 + 1;
            goto L6
        L11:
            return Integer.signum(r15 - r16);
        L13:
            e = move-exception;
            throw new IllegalArgumentException("Unable to convert version segments into integers: " + r12[r14] + " & " + r13[r14], e);
        L19:
            return Integer.signum(r12.length - r13.length);
        L21:
            throw new IllegalArgumentException("The input values cannot be null");
        }

        public static i c(Context r10) {
            d r11 = (d) k(r10, new ArrayList(d.c(r10))).get(0);
            if (Log.isLoggable(c.a(), 3) == false) goto L6;
            Log.d(c.a(), String.format("Using '%s' provider for creating CronetEngine.Builder.", new Object[]{r11}));
        L6:
            return r11.b().f18486a;
        }

        public static List k(Context r10, List r11) {
            if (r11.size() == 0) goto L17;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L11;
            if (((d) r12.next()).f() == true) goto L6;
            r12.remove();
            goto L6
        L11:
            if (r11.size() == 0) goto L15;
            Collections.sort(r11, new C0224a());
            return r11;
        L15:
            throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
        L17:
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        public a a(String r10, int r11, int r12) {
            this.f18486a.a(r10, r11, r12);
            return this;
        }

        public a d(boolean r10) {
            this.f18486a.c(r10);
            return this;
        }

        public a e(boolean r10) {
            this.f18486a.d(r10);
            return this;
        }

        public a f(boolean r10) {
            this.f18486a.e(r10);
            return this;
        }

        public a g(int r10, long r11) {
            this.f18486a.f(r10, r11);
            return this;
        }

        public a h(boolean r10) {
            this.f18486a.g(r10);
            return this;
        }

        public a i(boolean r10) {
            this.f18486a.i(r10);
            return this;
        }

        public a j() {
            this.f18486a.j();
            return this;
        }

        public a l(boolean r10) {
            this.f18486a.k(r10);
            return this;
        }

        public a m(long r10) {
            this.f18486a.l(r10);
            return this;
        }

        public a n(TTAppInfoProvider r10) {
            this.f18486a.m(r10);
            return this;
        }

        public a o(v r10) {
            this.f18486a.n(r10);
            return this;
        }

        public a p(String r10) {
            this.f18486a.o(r10);
            return this;
        }

        public a q(Map r10) {
            this.f18486a.p(r10);
            return this;
        }

        public a r(String r10) {
            this.f18486a.q(r10);
            return this;
        }

        public a s(u r10) {
            this.f18486a.r(r10);
            return this;
        }

        public a t(String r10) {
            this.f18486a.s(r10);
            return this;
        }

        public a u(b r10) {
            this.f18486a.t(r10);
            return this;
        }

        public a v(ArrayList r10) {
            this.f18486a.u(r10);
            return this;
        }

        public a w(String r10) {
            this.f18486a.v(r10);
            return this;
        }

        public a x(String r10) {
            this.f18486a.w(r10);
            return this;
        }

        public a y(String r10) {
            this.f18486a.x(r10);
            return this;
        }

        public a z(String r10) {
            this.f18486a.z(r10);
            return this;
        }

        public a(i r10) {
            this.f18486a = r10;
        }
    }

    static {
    }

    public c() {
    }

    public static /* synthetic */ String a() {
        return f18485a;
    }

    public abstract TTNetDiagnosisRequest.a b(TTNetDiagnosisRequest.Callback r10, Executor r11);

    public abstract a0.a c(String r10, a0.b r11, Executor r12);

    public abstract w.a d(w.b r10, Executor r11);

    public abstract URLConnection e(URL r10);
}
