package bz0;

import android.net.Uri;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class g implements yy0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f21821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f21822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f21823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f21824d;

    public g() {
        this.f21821a = Uri.EMPTY;
        this.f21822b = new k();
        this.f21823c = new j();
        this.f21824d = new LinkedHashMap();
    }

    @Override // yy0.a
    public final void a(Function1<? super yy0.h, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        r100.invoke(this.f21822b);
    }

    @Override // yy0.a
    public final void d(Function1<? super yy0.g, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        r100.invoke(this.f21823c);
    }

    @Override // yy0.a
    public final void e(String r100, HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        int r103 = f.f21820a[r101.ordinal()];
        if (r103 != 1) goto L5;
        Uri r104 = x6.a.b(r100);
        Intrinsics.checkNotNullParameter(r104, "uri");
        this.f21821a = r104;
        return;
    L5:
        if (r103 != 2) goto L19;
        Uri r105 = x6.a.d(r100);
        if (r102 != null) goto L10;
    L15:
        Intrinsics.checkNotNullParameter(r105, "uri");
        this.f21821a = r105;
        return;
    L10:
        if (r102.length() <= 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 != true) goto L15;
        r105.buildUpon().appendQueryParameter("fallback_url", r102).build();
        goto L15
    L12:
        r106 = false;
        goto L13
    }
}
