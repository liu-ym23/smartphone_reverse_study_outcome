package com.bytedance.android.ec.core.monitor;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45147a = 0;

    static {
    }

    public static void a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_ENTER_PRODUCT_DETAL, "scene");
        String r100 = UriProtector.getQueryParameter(r110, "source_page");
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r102 = UriProtector.getQueryParameter(r110, "promotion_id");
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        String r103 = UriProtector.getQueryParameter(r110, com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        String r104 = UriProtector.getQueryParameter(r110, com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        if (r104 == null) goto L15;
        r101 = r104;
    L15:
        List r105 = CollectionsKt.mutableListOf(new l.a[]{new l.a("promotion_id", "presence"), new l.a("source_page", "presence")});
        JSONObject r111 = new JSONObject();
        r111.put("promotion_id", r102);
        r111.put("source_page", r100);
        r111.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r103);
        r111.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r101);
        int r106 = l.f45163a;
        l.b(r110.toString(), com.bytedance.android.ec.core.event.a.KEY_ENTER_PRODUCT_DETAL, r111, r105);
    }

    public static void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("enter_rank_list", "scene");
        Intrinsics.checkNotNullParameter(r101, "packLogId");
        if (a2.b(r100) == false) goto L5;
        return;
    L5:
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r100), com.bytedance.android.ec.core.event.a.KEY_RANK_ID);
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        if (r103.length() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L18;
        int r105 = d.f45144a;
        JSONObject r106 = new JSONObject();
        r106.put("rank_schema", r100);
        r106.put("pack_log_id", r101);
        if (r102 != null) goto L16;
        r102 = "";
    L16:
        r106.put("feed_log_id", r102);
        Unit r107 = Unit.INSTANCE;
        d.d(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, "presence", null, "enter_rank_list", r106);
        return;
    L18:
        return;
    L11:
        r104 = false;
        goto L12
    }
}
