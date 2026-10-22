package com.bytedance.android.shopping.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.l;
import com.bytedance.android.shopping.commentfeed.model.CommentDetailParams;
import com.bytedance.android.shopping.commentfeed.view.CommentDetailActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements bf.c {
    public b() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "ec_comment_detail";
    }

    @Override // bf.c
    public final boolean c(Context r110, Uri r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "uri");
        int r100 = ac3.a.f2668a;
        String r113 = r111.toString();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "url");
        Uri r114 = UriProtector.parse(r113);
        String r101 = UriProtector.getQueryParameter(r114, "product_id");
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = UriProtector.getQueryParameter(r114, "comment_id");
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        String r105 = UriProtector.getQueryParameter(r114, "comment_cursor");
        if (r105 == null) goto L13;
        long r106 = CastLongProtector.parseLong(r105);
    L14:
        String r107 = UriProtector.getQueryParameter(r114, com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE);
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        List r108 = CollectionsKt.mutableListOf(new l.a[]{new l.a("product_id", "presence"), new l.a("comment_id", "presence")});
        JSONObject r109 = new JSONObject();
        r109.put("product_id", r102);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, r107);
        int r115 = l.f45163a;
        l.b(r114.toString(), "show_comment_detail_page", r109, r108);
        if (TextUtils.isEmpty(r102) == false) goto L20;
    L25:
        return true;
    L20:
        if (TextUtils.isEmpty(r104) == true) goto L25;
        if (r106 < 0) goto L25;
        CommentDetailParams r116 = new CommentDetailParams(r102, r104, r106, r107);
        int r117 = CommentDetailActivity.f172336k;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "param");
        Intent r118 = new Intent(r110, CommentDetailActivity.class);
        r118.putExtra(com.bytedance.android.ec.core.event.a.KEY_COMMENT_DETAIL, r116);
        Unit r119 = Unit.INSTANCE;
        r110.startActivity(r118);
        goto L25
    L13:
        r106 = -1;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }
}
