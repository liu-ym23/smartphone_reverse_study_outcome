package com.bytedance.android.ec.store.utils;

import android.content.res.Resources;
import android.net.Uri;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48668a = 0;

    public h() {
    }

    static {
    }

    public static String a(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getNotNullQuery");
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = UriProtector.getQueryParameter(r100, r101);
        if (r102 != null) goto L6;
        return "";
    L6:
        return r102;
    }

    public static LayoutTypes b(Integer r100, Integer r101) {
        int r102 = q.f48131a.getInt("product_card_local_layout_type", -1);
        LayoutTypes r103 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        int r104 = r103.getType();
        if (r101 != null) goto L6;
    L7:
        LayoutTypes r105 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        int r106 = r105.getType();
        if (r101 == null) goto L14;
        if (r101.intValue() != r106) goto L14;
    L18:
        r100 = r101;
    L19:
        int r107 = r103.getType();
        if (r100 != null) goto L23;
    L25:
        r103 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r103.getType();
        if (r100 == null) goto L29;
        r100.intValue();
    L29:
        return r103;
    L23:
        if (r100.intValue() != r107) goto L25;
    L14:
        if (r102 != r103.getType()) goto L16;
    L17:
        r100 = Integer.valueOf(r102);
        goto L19
    L16:
        if (r102 != r105.getType()) goto L19;
    L6:
        if (r101.intValue() == r104) goto L18;
        goto L7
    }

    public static int e(Number r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "number");
        if (r101 == false) goto L6;
        Intrinsics.checkNotNullParameter(r100, "$this$nrpx");
        float r102 = r100.floatValue();
        float r103 = k1.l();
        Resources r104 = Resources.getSystem();
        return com.bytedance.android.shopping.extensions.b.b(Float.valueOf((r102 * (r103 / WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density)) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
    L6:
        return com.bytedance.android.shopping.extensions.b.b(r100);
    }

    public static void c(JSONObject r110, String r111, String r112, Map r113) {
        Intrinsics.checkNotNullParameter(r111, "label");
        if (r110 == null) goto L5;
        Integer r100 = Integer.valueOf(r110.optInt("enable_common_ad_track"));
    L6:
        if (r100 != null) goto L9;
    L10:
        if (r110 == null) goto L15;
        boolean r101 = ECServiceManager.f42805a;
        ((s83.g) ECServiceManager.c(s83.g.class)).d(r110.optString("tag"), r111, r112, r110.optString("creative_id"), r110.optString("log_extra"), r113, null, null);
        return;
    L15:
        return;
    L9:
        if (r100.intValue() != 0) goto L10;
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static void d(JSONObject r110, String r111, String r112, Map r113, String r114) {
        Intrinsics.checkNotNullParameter(r111, "label");
        Intrinsics.checkNotNullParameter(r114, "tag");
        if (r110 == null) goto L5;
        Integer r100 = Integer.valueOf(r110.optInt("is_from_ad"));
    L6:
        if (r100 != null) goto L9;
    L10:
        if (r110 == null) goto L15;
        boolean r101 = ECServiceManager.f42805a;
        ((s83.g) ECServiceManager.c(s83.g.class)).d(r114, r111, r112, r110.optString("creative_id"), r110.optString("log_extra"), r113, null, null);
        return;
    L15:
        return;
    L9:
        if (r100.intValue() != 0) goto L10;
        return;
    L5:
        r100 = null;
        goto L6
    }
}
