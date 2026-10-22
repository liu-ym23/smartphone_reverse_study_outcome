package y0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class g {

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f43786a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43787b;

        /* renamed from: c, reason: collision with root package name */
        public final int f43788c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f43789d;

        /* renamed from: e, reason: collision with root package name */
        public final String f43790e;

        /* renamed from: f, reason: collision with root package name */
        public final int f43791f;

        @Deprecated
        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this(uri, i10, i11, z10, null, i12);
        }

        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f43791f;
        }

        public String c() {
            if (i()) {
                return this.f43786a.getAuthority();
            }
            return null;
        }

        public int d() {
            return this.f43787b;
        }

        public Uri e() {
            return this.f43786a;
        }

        public String f() {
            return this.f43790e;
        }

        public int g() {
            return this.f43788c;
        }

        public boolean h() {
            return this.f43789d;
        }

        public boolean i() {
            return Objects.equals(this.f43786a.getScheme(), "systemfont");
        }

        public b(Uri uri, int i10, int i11, boolean z10, String str, int i12) {
            this.f43786a = (Uri) B0.h.f(uri);
            this.f43787b = i10;
            this.f43788c = i11;
            this.f43789d = z10;
            this.f43790e = str;
            this.f43791f = i12;
        }

        public b(String str, String str2) {
            this.f43786a = new Uri.Builder().scheme("systemfont").authority(str).build();
            this.f43787b = 0;
            this.f43788c = Const.I_TILE_TINY;
            this.f43789d = false;
            this.f43790e = str2;
            this.f43791f = 0;
        }
    }

    public static class c {
        public void a(int i10) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return t0.h.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) throws PackageManager.NameNotFoundException {
        return d.e(context, List.of(eVar), cancellationSignal);
    }

    public static Typeface c(Context context, List<e> list, int i10, boolean z10, int i11, Handler handler, c cVar) {
        C5915a c5915a = new C5915a(cVar, h.b(handler));
        if (!z10) {
            return f.d(context, list, i10, null, c5915a);
        }
        if (list.size() <= 1) {
            return f.e(context, list.get(0), c5915a, i10, i11);
        }
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f43784a;

        /* renamed from: b, reason: collision with root package name */
        public final List<b[]> f43785b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f43784a = i10;
            this.f43785b = Collections.singletonList(bVarArr);
        }

        public static a a(int i10, List<b[]> list) {
            return new a(i10, list);
        }

        public static a b(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] c() {
            return this.f43785b.get(0);
        }

        public List<b[]> d() {
            return this.f43785b;
        }

        public int e() {
            return this.f43784a;
        }

        public boolean f() {
            return this.f43785b.size() > 1;
        }

        public a(int i10, List<b[]> list) {
            this.f43784a = i10;
            this.f43785b = list;
        }
    }
}
