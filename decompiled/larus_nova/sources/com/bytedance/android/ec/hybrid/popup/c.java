package com.bytedance.android.ec.hybrid.popup;

import android.graphics.Color;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f47594a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f47595a = 0;

        static {
        }
    }

    static {
        f47594a = CollectionsKt.listOf(new Integer[]{1, 2, 3});
    }

    public static f a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        int r100 = r110.optInt("type", -1);
        String r101 = null;
        if (f47594a.contains(Integer.valueOf(r100)) == true) goto L5;
        return null;
    L5:
        Integer r102 = Integer.valueOf(r110.optInt("width_percent", 100));
        int r103 = r102.intValue();
        boolean r104 = false;
        if (r103 < 0) goto L10;
        if (100 < r103) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L16;
        int r106 = r102.intValue();
    L17:
        Integer r107 = Integer.valueOf(r110.optInt(ECFindSimilarConfig.HEIGHT_PERCENT, 100));
        int r108 = r107.intValue();
        if (r108 < 0) goto L22;
        if (100 < r108) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == true) goto L26;
        r107 = null;
    L26:
        if (r107 == null) goto L28;
        int r111 = r107.intValue();
    L29:
        boolean r112 = r110.optBoolean("gray_enable", false);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L32
        Object r114 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r110.optString("mask_color", "#00000000"))));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r114) == false) goto L37;
        r114 = null;
    L37:
        Integer r115 = (Integer) r114;
        if (r115 == null) goto L40;
        int r116 = r115.intValue();
    L41:
        boolean r117 = r110.optBoolean("mask_click_close", false);
        boolean r118 = r110.optBoolean("mask_intercept_event", false);
        boolean r119 = r110.optBoolean("use_new_event_intercept_impl", false);
        String r120 = r110.optString(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE);
        if (Intrinsics.areEqual(r120, "bottom") == false) goto L44;
    L45:
        r104 = true;
    L46:
        if (r104 == false) goto L48;
        r101 = r120;
    L48:
        if (r101 == null) goto L50;
        boolean r121 = Intrinsics.areEqual(r101, "bottom");
    L51:
        n r122 = new n(r100, r106, r111, r112, r116, r117, r118, r119, r121, r110.optBoolean(AppConstants.BUNDLE_USE_ANIM, true), r110.optString("btm"), r110.optJSONObject("bcm"));
        if (r110.has("schema") == true) goto L60;
        int r123 = 1;
        if (r100 == 1) goto L59;
        if (r100 == 2) goto L59;
    L62:
        if (r100 == r123) goto L69;
        if (r100 != 2) goto L65;
        f r124 = new com.bytedance.android.ec.hybrid.popup.a(r17, r110.optString("schema", ""));
    L71:
        return r124;
    L65:
        if (r100 == 3) goto L75;
        return r122;
    L75:
        return new b(r17);
    L69:
        r124 = new fk.f(r17, r110.optString("schema", ""), r110.optString("data", ""));
    L59:
        return r122;
    L60:
        r123 = 1;
        goto L62
    L50:
        r121 = true;
        goto L51
    L44:
        if (Intrinsics.areEqual(r120, "center") == false) goto L46;
    L40:
        r116 = 0;
    L32:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L28:
        r111 = 100;
    L22:
        r109 = false;
        goto L23
    L16:
        r106 = 100;
    L10:
        r105 = false;
        goto L11
    }

    public static o c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        JSONObject r101 = r100.optJSONObject("group");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        m r102 = new m(r101.optString("name", "default"), r101.optInt(BdpAppEventConstant.PARAMS_STRATEGY_NAME, 0));
        int r103 = r100.optInt("priority", 0);
        String r104 = r100.optString("parent", "global");
        if (Intrinsics.areEqual(r104, "global") == false) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L17;
        boolean r106 = Intrinsics.areEqual(r104, "global");
    L19:
        return new o(r102, r103, r106, r100.optInt("z_index", 0), r100.optString("limit_desc", ""), r100.optBoolean("must_show_on_visible", false));
    L17:
        r106 = true;
        goto L19
    L8:
        if (Intrinsics.areEqual(r104, "custom") == true) goto L11;
        r105 = false;
        goto L12
    }

    public static Pair b(ck.b r100, o r101, f r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "popupManager");
        Intrinsics.checkNotNullParameter(r101, "taskConfig");
        Intrinsics.checkNotNullParameter(r102, "popupConfig");
        int r104 = r102.getType();
        if (r104 == 1) goto L12;
        if (r104 == 2) goto L15;
        if (r104 == 3) goto L14;
        return TuplesKt.to(Boolean.FALSE, "");
    L14:
        return r100.a(new gk.d(r100, r101, r102));
    L15:
        return r100.a(new gk.c(r100, r101, r102));
    L12:
        return r100.e(r101, r102, r103);
    }
}
