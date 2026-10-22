package C;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* loaded from: classes.dex */
public class g {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f276a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f277b;

        @Deprecated
        public a(int i5, b[] bVarArr) {
            this.f276a = i5;
            this.f277b = bVarArr;
        }

        static a a(int i5, b[] bVarArr) {
            return new a(i5, bVarArr);
        }

        public b[] b() {
            return this.f277b;
        }

        public int c() {
            return this.f276a;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f278a;

        /* renamed from: b, reason: collision with root package name */
        private final int f279b;

        /* renamed from: c, reason: collision with root package name */
        private final int f280c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f281d;

        /* renamed from: e, reason: collision with root package name */
        private final int f282e;

        @Deprecated
        public b(Uri uri, int i5, int i6, boolean z5, int i7) {
            this.f278a = (Uri) D.h.e(uri);
            this.f279b = i5;
            this.f280c = i6;
            this.f281d = z5;
            this.f282e = i7;
        }

        static b a(Uri uri, int i5, int i6, boolean z5, int i7) {
            return new b(uri, i5, i6, z5, i7);
        }

        public int b() {
            return this.f282e;
        }

        public int c() {
            return this.f279b;
        }

        public Uri d() {
            return this.f278a;
        }

        public int e() {
            return this.f280c;
        }

        public boolean f() {
            return this.f281d;
        }
    }

    public static class c {
        public void a(int i5) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return androidx.core.graphics.e.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, eVar, cancellationSignal);
    }

    public static Typeface c(Context context, e eVar, int i5, boolean z5, int i6, Handler handler, c cVar) {
        C.a aVar = new C.a(cVar, handler);
        return z5 ? f.e(context, eVar, aVar, i5, i6) : f.d(context, eVar, i5, null, aVar);
    }
}
