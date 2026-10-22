package com.bytedance.android.shopping.anchorv3.track;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.anchorv3.AnchorV3Starter;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardRecommendReasonStruct;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.track.TrackerProvider;
import ih3.g;
import java.util.HashMap;
import jd3.v;
import jd3.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165294a = 0;

    static {
        new HashMap();
        new HashMap();
    }

    public static HashMap a(Context r100) {
        TrackerProvider.a r101 = TrackerProvider.Companion;
        if (r100 == null) goto L10;
        Activity r102 = d0.f165305a.getActivity(r100);
        if ((r102 instanceof FragmentActivity) == true) goto L8;
        r102 = null;
    L8:
        FragmentActivity r103 = (FragmentActivity) r102;
        if (r103 == null) goto L10;
        Object r104 = ((TrackerProvider) ViewModelProviders.of(r103).get(TrackerProvider.class)).getTracker();
        if ((r104 instanceof a) == true) goto L14;
        r104 = null;
    L14:
        a r105 = (a) r104;
    L15:
        if (r105 != null) goto L17;
        return null;
    L17:
        return r105.f165293a;
    L10:
        r105 = null;
        goto L15
    }

    public static String b(String r100) {
        if (TextUtils.equals(r100, "search_result_card") == true) goto L7;
        return null;
    L7:
        return g.f489807b.S("ecommerce");
    }

    public static void e(ItemCardRecommendReasonStruct r100, j63.c r101, Integer r102) {
        int r103 = a63.a.f1951a;
        int r104 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        i63.a r105 = new i63.a();
        r105.f488427a = "product_detail_guessyoulike";
        r105.f488428b = String.valueOf(r102);
        if (r101 == null) goto L7;
        ItemCardProductStruct r106 = r101.d();
        if (r106 == null) goto L7;
        String r107 = r106.getProductId();
    L8:
        r105.f488430d = r107;
        if (r100 == null) goto L11;
        String r108 = r100.getRankId();
    L12:
        r105.f488429c = r108;
        r105.post(null, null);
        return;
    L11:
        r108 = null;
    L7:
        r107 = null;
        goto L8
    }

    public static void c(AnchorV3Starter r100, String r101, Integer r102, Context r103) {
        Intrinsics.checkNotNullParameter(r100, "anchorV3Starter");
        int r104 = a63.a.f1951a;
        int r105 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        v r106 = new v();
        r106.f498542a = r102;
        r106.f498543b = r101;
        r106.f498544c = r100;
        c.b(r106, r103);
    }

    public static void d(String r100, String r101, Context r102, String r103) {
        Intrinsics.checkNotNullParameter("live_trabecula", "enterMethod");
        int r104 = a63.a.f1951a;
        int r105 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        z r106 = new z();
        r106.f498575c = "click";
        r106.f498576d = r100;
        r106.f498574b = "live_trabecula";
        r106.f498573a = "product_detail_page";
        r106.f498577e = r103;
        if (k.c(r101) == false) goto L5;
        r106.a(r101);
    L5:
        c.b(r106, r102);
    }
}
