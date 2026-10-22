package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.h;
import androidx.core.util.e;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontsContractCompat {

    public static class FontRequestCallback {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface FontRequestFailReason {
        }

        public FontRequestCallback() {
        }

        public abstract void a(int r10);

        public abstract void b(Typeface r10);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f2579b;

        public a(int r10, b[] r11) {
            this.f2578a = r10;
            this.f2579b = r11;
        }

        public static a a(int r10, b[] r11) {
            return new a(r10, r11);
        }

        public b[] b() {
            return this.f2579b;
        }

        public int c() {
            return this.f2578a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f2580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f2583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2584e;

        public b(Uri r10, int r11, int r12, boolean r13, int r14) {
            this.f2580a = (Uri) e.g(r10);
            this.f2581b = r11;
            this.f2582c = r12;
            this.f2583d = r13;
            this.f2584e = r14;
        }

        public static b a(Uri r10, int r11, int r12, boolean r13, int r14) {
            return new b(r10, r11, r12, r13, r14);
        }

        public int b() {
            return this.f2584e;
        }

        public int c() {
            return this.f2581b;
        }

        public Uri d() {
            return this.f2580a;
        }

        public int e() {
            return this.f2582c;
        }

        public boolean f() {
            return this.f2583d;
        }
    }

    public static Typeface a(Context r10, CancellationSignal r11, b[] r12) {
        return h.b(r10, r11, r12, 0);
    }

    public static a b(Context r10, CancellationSignal r11, q.c r12) {
        return androidx.core.provider.b.e(r10, r12, r11);
    }

    public static Typeface c(Context r10, q.c r11, int r12, boolean r13, int r14, Handler r15, FontRequestCallback r16) {
        androidx.core.provider.a r17 = new androidx.core.provider.a(r16, r15);
        if (r13 == false) goto L7;
        return c.e(r10, r11, r17, r12, r14);
    L7:
        return c.d(r10, r11, r12, null, r17);
    }
}
