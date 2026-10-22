package com.bytedance.android.shopping.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.android.shopping.anchorv3.kolbuyershow.KolBuyerShowActivity;
import com.bytedance.android.shopping.anchorv3.kolbuyershow.KolBuyerShowParams;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements bf.c {
    public e() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "ecom_kol_buyer_show_merge";
    }

    @Override // bf.c
    public final boolean c(Context r100, Uri r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        int r102 = m63.c.f512281a;
        Intrinsics.checkNotNullParameter(r101, "uri");
        String r111 = UriProtector.getQueryParameter(r101, "title_list");
        if (r111 != null) goto L5;
        String r103 = "";
    L6:
        String r112 = UriProtector.getQueryParameter(r101, "enter_from");
        if (r112 != null) goto L9;
        String r104 = "";
    L10:
        String r113 = UriProtector.getQueryParameter(r101, "product_id");
        if (r113 != null) goto L13;
        String r105 = "";
    L14:
        String r114 = UriProtector.getQueryParameter(r101, "track_params");
        if (r114 != null) goto L17;
        String r106 = "";
    L18:
        String r107 = UriProtector.getQueryParameter(r101, SendClosePdpEventParam.KEY_LYNX_URL);
        if (r107 != null) goto L21;
        String r108 = "";
    L22:
        int r109 = KolBuyerShowActivity.f165119q;
        KolBuyerShowParams r115 = new KolBuyerShowParams(r103, r105, r104, r106, r108);
        Intrinsics.checkNotNullParameter(r115, "param");
        if (r100 == null) goto L27;
        Intent r116 = new Intent(r100, KolBuyerShowActivity.class);
        r116.putExtra("param_key", r115);
        Unit r117 = Unit.INSTANCE;
        r100.startActivity(r116);
        return true;
    L27:
        return true;
    L21:
        r108 = r107;
        goto L22
    L17:
        r106 = r114;
        goto L18
    L13:
        r105 = r113;
        goto L14
    L9:
        r104 = r112;
        goto L10
    L5:
        r103 = r111;
        goto L6
    }
}
