package com.bytedance.android.marketing.sdk.api;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f162670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f162671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f162672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Object> f162673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f162674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f162675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f162676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, FrameLayout> f162677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f162678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f162679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f162680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, Object> f162681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f162682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f162683n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Activity f162684o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Fragment f162685p;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3);
    }

    public final Activity getActivity() {
        return this.f162684o;
    }

    public final Map<String, Object> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_RIT);
        LinkedHashMap r101 = new LinkedHashMap();
        Map r102 = (Map) ((LinkedHashMap) this.f162676g).get(r100);
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        r101.putAll(r102);
        return r101;
    }

    public final Map<String, Object> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_RIT);
        LinkedHashMap r101 = new LinkedHashMap();
        Map r102 = (Map) ((LinkedHashMap) this.f162675f).get(r100);
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        r101.putAll(r102);
        return r101;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f162680k = r100;
        this.f162681l.put("enter_from", r100);
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f162679j = r100;
        this.f162681l.put("page_name", r100);
    }

    public c(Activity r100, Fragment r101) {
        this.f162684o = r100;
        this.f162685p = r101;
        this.f162675f = new LinkedHashMap();
        this.f162676g = new LinkedHashMap();
        this.f162677h = new LinkedHashMap();
        this.f162678i = new LinkedHashMap();
        this.f162679j = "";
        this.f162680k = "";
        this.f162681l = new LinkedHashMap();
    }

    public /* synthetic */ c(Activity r100, Fragment r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
