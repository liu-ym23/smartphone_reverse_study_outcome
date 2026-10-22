package com.bytedance.android.shopping.searchsimilar.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.searchsimilar.SimilarProductFragment;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SimilarProductHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f182493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f182494b;

    public SimilarProductHelper() {
        this.f182494b = "";
    }

    public final void a(Context r100, final Uri r101, final boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (r100 == null) goto L20;
        n.b(r100, r110, null, new SimilarProductHelper$startFromSchema$$inlined$let$lambda$1(this, r110, r101), SimilarProductHelper$startFromSchema$1$2.INSTANCE);
        String r102 = com.bytedance.android.shopping.monitor.d.c("ec_similar_product_page_duration");
        this.f182494b = r102;
        com.bytedance.android.shopping.monitor.d.f(r102).a("duration");
        com.bytedance.android.shopping.monitor.d.f(this.f182494b).a(com.bytedance.android.ec.core.event.a.KEY_API_DURATION);
        Activity r103 = this.f182493a;
        if (r103 == null) goto L21;
        SimilarProductParam.a r111 = SimilarProductParam.Companion;
        String r104 = this.f182494b;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r104, "mCurMonitorName");
        String r112 = j1.c(r101, SimilarProductParam.AWEME_ID);
        if (r112 != null) goto L9;
        String r105 = "";
    L10:
        String r113 = j1.c(r101, "enter_from");
        if (r113 != null) goto L13;
        String r106 = "";
    L14:
        String r114 = j1.c(r101, "author_id");
        if (r114 != null) goto L17;
        String r107 = "";
    L18:
        SimilarProductParam r115 = new SimilarProductParam(r105, r106, r107, Integer.valueOf(k.r(j1.c(r101, SimilarProductParam.TOTAL_PANEL_HEIGHT), 0)), r104);
        int r108 = SimilarProductFragment.M;
        FragmentManager r109 = ((FragmentActivity) r103).getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r115, "param");
        SimilarProductFragment r116 = new SimilarProductFragment();
        Bundle r117 = new Bundle();
        r117.putSerializable("param_key", r115);
        Unit r118 = Unit.INSTANCE;
        r116.setArguments(r117);
        r116.X90(r103, r109);
        return;
    L17:
        r107 = r114;
        goto L18
    L13:
        r106 = r113;
        goto L14
    L9:
        r105 = r112;
        goto L10
    L21:
        return;
    }
}
