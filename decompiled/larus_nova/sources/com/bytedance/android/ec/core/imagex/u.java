package com.bytedance.android.ec.core.imagex;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.collection.LruCache;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class u extends r {
    public static final /* synthetic */ int G = 0;
    public com.bytedance.android.shopping.api.image.q A;
    public String B;
    public String C;
    public String D;
    public String E;
    public volatile boolean F;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f45045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Point f45046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ResizeOptions f45047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f45048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f45049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f45050n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f45051o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f45052p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f45053q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f45054r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f45055s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f45056t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f45057u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f45058v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f45059w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f45060x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LruCache<String, f> f45061y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bytedance.android.shopping.api.image.r f45062z;

    public final void k() {
        long r100 = this.f45054r;
        if (r100 > 0) goto L5;
        return;
    L5:
        long r101 = this.f45055s;
        if (r101 <= 0) goto L8;
        this.f45054r = r100 + r101;
        this.f45055s = -1;
    L8:
        Long r102 = Long.valueOf(System.nanoTime() - this.f45054r);
        if (r102.longValue() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        f("ec_local_duration", Double.valueOf(r102.longValue() / ((double) 1000000.0f)));
    L17:
        this.f45054r = -1;
        return;
    L11:
        r103 = false;
        goto L12
    }

    public final com.bytedance.android.shopping.api.image.q n() {
        com.bytedance.android.shopping.api.image.r r100 = this.f45062z;
        if ((r100 instanceof com.bytedance.android.shopping.api.image.q) == true) goto L6;
        r100 = null;
    L6:
        return (com.bytedance.android.shopping.api.image.q) r100;
    }

    public final String p() {
        String r100 = this.D;
        if (r100 != null) goto L9;
        com.bytedance.android.shopping.api.image.r r101 = this.f45062z;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getOriginUrl();
    L9:
        return r100;
    }

    public final long s() {
        ResizeOptions r100 = this.f45047k;
        int r101 = 0;
        if (r100 != null) goto L12;
        Point r102 = this.f45046j;
        if (r102 == null) goto L11;
        if (r102 == null) goto L8;
        int r103 = r102.x;
    L9:
        if (r102 == null) goto L18;
        r101 = r102.y;
    L18:
        return r103 * r101;
    L8:
        r103 = 0;
        goto L9
    L11:
        return 0;
    L12:
        if (r100 == null) goto L14;
        r103 = r100.width;
    L15:
        if (r100 == null) goto L18;
        r101 = r100.height;
        goto L18
    L14:
        r103 = 0;
        goto L15
    }

    public final String t() {
        Integer r100 = null;
        if (this.f45047k == null) goto L5;
        StringBuilder r101 = new StringBuilder();
        ResizeOptions r102 = this.f45047k;
        if (r102 == null) goto L18;
        Integer r103 = Integer.valueOf(r102.width);
    L19:
        r101.append(String.valueOf(r103));
        r101.append("x");
        ResizeOptions r104 = this.f45047k;
        if (r104 == null) goto L22;
        r100 = Integer.valueOf(r104.height);
    L22:
        r101.append(String.valueOf(r100));
        return r101.toString();
    L18:
        r103 = null;
        goto L19
    L5:
        if (this.f45046j == null) goto L14;
        StringBuilder r105 = new StringBuilder();
        Point r106 = this.f45046j;
        if (r106 == null) goto L9;
        Integer r107 = Integer.valueOf(r106.x);
    L10:
        r105.append(String.valueOf(r107));
        r105.append("x");
        Point r108 = this.f45046j;
        if (r108 == null) goto L13;
        r100 = Integer.valueOf(r108.y);
    L13:
        r105.append(String.valueOf(r100));
        return r105.toString();
    L9:
        r107 = null;
        goto L10
    L14:
        return "";
    }

    public final void y() {
        i("ec_local_duration");
        i("ec_local_duration_request");
        i("ec_local_duration_url_parser");
        i("ec_local_duration_url_edit");
        i("ec_local_duration_url_transform");
        i("ec_local_duration_url_build");
        i("ec_local_duration_url_query_build");
        i("ec_local_duration_url_find_cache");
        i("ec_local_duration_async_build_init");
        i("ec_local_duration_async_context_init");
        i("ec_local_duration_load_controller_before");
        i("ec_local_duration_load_controller_build");
        i("ec_local_duration_load_controller");
        i("ec_local_duration_request_core_build");
        i("ec_local_duration_request_secondary_build");
    }

    public final void B() {
        y();
        this.f45053q = SystemClock.elapsedRealtime();
        this.f45054r = System.nanoTime();
    }

    public final void z() {
        long r100 = System.nanoTime();
        long r101 = this.f45057u;
        long r102 = this.f45058v;
        if (r101 <= r102) goto L6;
    L18:
        this.f45056t = -1;
        this.f45057u = -1;
        this.f45058v = -1;
        this.f45059w = -1;
        this.f45060x = -1;
        return;
    L6:
        if (r100 < r102) goto L18;
        long r103 = this.f45056t;
        if (r101 < r103) goto L18;
        Long r104 = Long.valueOf((r100 - r102) + (r101 - r103));
        if (r104.longValue() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        r104 = null;
    L16:
        if (r104 == null) goto L18;
        f("ec_local_duration", Double.valueOf(r104.longValue() / ((double) 1000000.0f)));
        goto L18
    L12:
        r105 = false;
        goto L13
    }

    public final String l() {
        return this.E;
    }

    public final com.bytedance.android.shopping.api.image.r m() {
        return this.f45062z;
    }

    public final String o() {
        return this.f45051o;
    }

    public final Integer q() {
        return this.f45048l;
    }

    public final long r() {
        return this.f45053q;
    }

    public final Point u() {
        return this.f45046j;
    }

    public final Boolean v() {
        return this.f45052p;
    }

    public final boolean w() {
        return this.f45045i;
    }

    public final boolean x() {
        return this.f45049m;
    }

    public u(r r100) {
        Intrinsics.checkNotNullParameter(r100, "internal");
        String r101 = r100.f44943f;
        String r102 = r100.f44944g;
        WeakReference<Function0<Map<String, Object>>> r103 = r100.f44942e;
        if (r103 == null) goto L5;
        Function0<Map<String, Object>> r104 = r103.get();
    L6:
        super(r101, r102, r104);
        LinkedHashMap r105 = new LinkedHashMap();
        r105.putAll(r100.f44940c);
        Unit r106 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f44940c = r105;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.putAll(r100.f44941d);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f44941d = r107;
        this.f44938a = r100.f44938a;
        this.f44939b = r100.f44939b;
        this.f45053q = Long.MAX_VALUE;
        this.f45054r = -1;
        this.f45055s = -1;
        this.f45056t = -1;
        this.f45057u = -1;
        this.f45058v = -1;
        this.f45059w = -1;
        this.f45060x = -1;
        this.f45061y = new LruCache(3);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void A(Context r100) {
        String r101 = this.f44938a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        if (r100 == null) goto L16;
        Activity r103 = com.bytedance.android.ec.core.utils.l0.b(r100);
        if (r103 == null) goto L17;
        this.f44938a = r103.getClass().getName();
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void C(ResizeOptions r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.width > 0) goto L6;
        return;
    L6:
        if (r100.height <= 0) goto L11;
        this.f45047k = r100;
        return;
    }

    public final void D(View r100) {
        Intrinsics.checkNotNullParameter(r100, "genericDraweeView");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() <= 0) goto L9;
        this.f45046j = new Point(r100.getWidth(), r100.getHeight());
        return;
    }

    public final boolean j(Uri r100) {
        com.bytedance.android.shopping.api.image.r r101 = this.f45062z;
        String r102 = null;
        if (r101 == null) goto L8;
        if (r101 == null) goto L7;
        r102 = r101.c();
    L7:
        return Intrinsics.areEqual("ecom-shop-material", r102);
    L8:
        if (r100 == null) goto L11;
        String r103 = r100.getPath();
        if (r103 == null) goto L11;
    L13:
        if (r103 != null) goto L15;
        return false;
    L15:
        if (StringsKt.contains$default(r103, "/ecom-shop-material/", false, 2, null) != true) goto L19;
        return true;
    L19:
        return false;
    L11:
        r103 = p();
        goto L13
    }
}
