package com.bytedance.android.annie.service.latch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.ies.web.jsbridge2.d0;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface ILatchService extends com.bytedance.android.annie.service.a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/service/latch/ILatchService$PrefetchStrategy;", "", "Prefetch", "Latch", "Nothing", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum PrefetchStrategy extends Enum<PrefetchStrategy> {
        public static final PrefetchStrategy Latch = null;
        public static final PrefetchStrategy Nothing = null;
        public static final PrefetchStrategy Prefetch = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrefetchStrategy[] f39875a = null;

        public static PrefetchStrategy valueOf(String r100) {
            return (PrefetchStrategy) r27.a.a(PrefetchStrategy.class, r100);
        }

        public static PrefetchStrategy[] values() {
            return (PrefetchStrategy[]) f39875a.clone();
        }

        static {
            PrefetchStrategy r100 = new PrefetchStrategy("Prefetch", 0);
            Prefetch = r100;
            PrefetchStrategy r101 = new PrefetchStrategy("Latch", 1);
            Latch = r101;
            PrefetchStrategy r102 = new PrefetchStrategy("Nothing", 2);
            Nothing = r102;
            f39875a = new PrefetchStrategy[]{r100, r101, r102};
        }

        public PrefetchStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(c r100);

        void b(b r100);

        void c(int r100, int r101, String r102, String r103, int r104, String r105, Map<String, ? extends Object> r106);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f39876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f39877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f39878c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f39876a, r101.f39876a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f39877b, r101.f39877b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f39878c, r101.f39878c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f39876a.hashCode() * 31) + this.f39877b.hashCode()) * 31) + this.f39878c.hashCode();
        }

        public final String toString() {
            return "LatchJsbPromiseMetric(category=" + this.f39876a + ", metrics=" + this.f39877b + ", extra=" + this.f39878c + ')';
        }

        public b(JSONObject r100, JSONObject r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "category");
            Intrinsics.checkNotNullParameter(r101, "metrics");
            Intrinsics.checkNotNullParameter(r102, "extra");
            this.f39876a = r100;
            this.f39877b = r101;
            this.f39878c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f39879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f39880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f39881c;

        public final String toString() {
            return "LatchPerfMetric(metrics=" + this.f39879a + ", category=" + this.f39880b + ", extra=" + this.f39881c + ')';
        }

        public c(JSONObject r100, JSONObject r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "metrics");
            Intrinsics.checkNotNullParameter(r101, "category");
            Intrinsics.checkNotNullParameter(r102, "extra");
            this.f39879a = r100;
            this.f39880b = r101;
            this.f39881c = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f39882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f39883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f39884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f39885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f39886e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f39887f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, String> f39888g;

        public d() {
            this.f39882a = "";
            this.f39884c = "fullscreen";
            this.f39888g = new LinkedHashMap();
        }
    }

    public interface e extends Disposable {
        void f(d0 r100);
    }

    boolean O0(View r100);

    void Q0(String r100);

    String R0(View r100);

    void S0(String r100);

    boolean c(View r100);

    void d(String r100, boolean r101);

    int d1(Context r100, String r101, Uri r102, d r103);

    d e(long r100, String r101, String r102, String r103);

    String i(Uri r100);

    void initPrefetch();

    Pair<PrefetchStrategy, String> k(Uri r100, String r101);

    void s(Uri r100);

    e u0(Context r100, String r101, Uri r102, long r103, d r104, boolean r105);
}
