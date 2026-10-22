package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECItemCardTag;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f177000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f177001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f177002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f177003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f177004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f177005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f177006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f177007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f177008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f177009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f177010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f177011l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f177012m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f177013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f177014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f177015p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f177016q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<ECHybridListItemVO> f177017r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f177018s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f177019t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f177020u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f177021v;

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        this.f177021v = r100;
        this.f177002c = new LinkedHashMap();
        this.f177003d = new LinkedHashMap();
        this.f177004e = new LinkedHashMap();
        this.f177005f = new LinkedHashMap();
        this.f177006g = new LinkedHashMap();
        this.f177007h = new LinkedHashMap();
        this.f177008i = new LinkedHashMap();
        this.f177009j = 2;
        this.f177010k = 3;
        this.f177011l = 3;
        this.f177012m = 3;
        this.f177013n = 2;
        this.f177014o = 2;
        this.f177017r = new ArrayList();
        this.f177018s = new LinkedHashMap();
        this.f177019t = 2;
    }

    public static boolean b(ECHybridListItemVO r100) {
        ECNAMallCardExtra r101 = r100.c();
        if (r101 == null) goto L7;
        ECItemCardTag r102 = r101.getCardTag();
        if (r102 == null) goto L7;
        String[] r103 = r102.getRid();
    L9:
        if (r103 == null) goto L15;
        boolean r104 = false;
        if (r103.length != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L15;
    L17:
        return !r104;
    L13:
        r105 = false;
    L15:
        r104 = true;
    L7:
        r103 = null;
        goto L9
    }

    public static boolean c(ECHybridListItemVO r100) {
        ECNAMallCardExtra r101 = r100.c();
        if (r101 == null) goto L7;
        ECItemCardTag r102 = r101.getCardTag();
        if (r102 == null) goto L7;
        String[] r103 = r102.getPid();
    L9:
        if (r103 == null) goto L15;
        boolean r104 = false;
        if (r103.length != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L15;
    L17:
        return !r104;
    L13:
        r105 = false;
    L15:
        r104 = true;
    L7:
        r103 = null;
        goto L9
    }

    public static String[] f(ECHybridListItemVO r100) {
        ECNAMallCardExtra r101 = r100.c();
        if (r101 == null) goto L7;
        ECItemCardTag r102 = r101.getCardTag();
        if (r102 == null) goto L7;
        return r102.getRid();
    L7:
        return null;
    }

    public final void e(int r100) {
        if (r100 <= this.f177015p) goto L5;
        this.f177015p = r100;
    L5:
        ((LinkedHashMap) this.f177003d).clear();
        ((LinkedHashMap) this.f177004e).clear();
        ((LinkedHashMap) this.f177005f).clear();
        ((LinkedHashMap) this.f177006g).clear();
        ((LinkedHashMap) this.f177007h).clear();
        ((LinkedHashMap) this.f177008i).clear();
    }

    public static void d(Map r100, String r101) {
        LinkedHashMap r102 = (LinkedHashMap) r100;
        Pair r103 = (Pair) r102.get(r101);
        if (r103 == null) goto L9;
        int r104 = ((Number) r103.component1()).intValue();
        ECHybridListItemVO r105 = (ECHybridListItemVO) r103.component2();
        if (r104 != 1) goto L7;
        r102.remove(r101);
        return;
    L7:
        r102.put(r101, TuplesKt.to(Integer.valueOf(r104 - 1), r105));
        return;
    }

    public final boolean a(ECHybridListItemVO r100, Map<String, Pair<Integer, ECHybridListItemVO>> r101, String[] r110, int r111, String r112) {
        int r102 = r110.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        String r104 = r110[r103];
        if (r101.containsKey(r104) == false) goto L15;
        Pair r105 = (Pair) ((LinkedHashMap) r101).get(r104);
        if (r105 == null) goto L16;
        int r106 = ((Number) r105.component1()).intValue();
        ECHybridListItemVO r107 = (ECHybridListItemVO) r105.component2();
        int r108 = r106 + 1;
        if (r108 == r111) goto L10;
        r101.put(r104, TuplesKt.to(Integer.valueOf(r108), r107));
        goto L16
    L10:
        Map<String, Map<String, Object>> r109 = this.f177002c;
        LinkedHashMap r113 = (LinkedHashMap) r109;
        Map r114 = (Map) r113.get(r107.Q);
        if (r114 == null) goto L13;
        ThreadPoolHelper.c().submit(new m(r114, r112));
    L13:
        return true;
    L16:
        r103 = r103 + 1;
        goto L3
    L15:
        r101.put(r104, TuplesKt.to(1, r100));
        goto L16
    L17:
        return false;
    }
}
