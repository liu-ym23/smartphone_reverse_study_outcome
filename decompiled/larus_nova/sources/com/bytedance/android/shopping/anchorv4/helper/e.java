package com.bytedance.android.shopping.anchorv4.helper;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f166955a = 0;

    static {
    }

    public static boolean c(j73.b r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        if (r100.e() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.r() <= 73) goto L7;
        return true;
    }

    public static boolean d(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        Object r102 = ECSettingKeys.p0().get(r100);
        Object r103 = null;
        if ((r102 instanceof Map) == true) goto L14;
        r102 = null;
    L14:
        Map r104 = (Map) r102;
        if (r104 == null) goto L18;
        r103 = r104.get("forbid_close_full_pdp_by_one_step");
    L18:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static String a(String r100, AnchorV4VM r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        if (e(r100, r101) == false) goto L6;
        int r102 = p0.f45664a;
        return p0.d(p0.d(r100, ECFindSimilarConfig.HEIGHT_PERCENT, String.valueOf(r101.getPanelHeightPercent())), "use_real_screen_height", "1");
    L6:
        return r100;
    }

    public static String b(String r100, j73.b r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        boolean r102 = false;
        if (c(r101) == true) goto L6;
    L14:
        if (r102 == false) goto L20;
        int r103 = p0.f45664a;
        return p0.d(p0.d(r100, ECFindSimilarConfig.HEIGHT_PERCENT, String.valueOf(r101.r())), "use_real_screen_height", "1");
    L20:
        return r100;
    L6:
        if (StringsKt.contains$default(r100, ECFindSimilarConfig.HEIGHT_PERCENT, false, 2, null) == false) goto L14;
        Iterator<T> r104 = ECSettingKeys.v0().iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        if (StringsKt.contains$default(r100, (String) r104.next(), false, 2, null) == false) goto L10;
        r102 = true;
        goto L14
    }

    public static boolean e(String r100, AnchorV4VM r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        if (r101.pathParams().f167761a == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        return false;
    L11:
        if (StringsKt.contains$default(r100, ECFindSimilarConfig.HEIGHT_PERCENT, false, 2, null) == true) goto L13;
        return false;
    L13:
        Iterator<T> r103 = ECSettingKeys.v0().iterator();
    L15:
        if (r103.hasNext() == false) goto L19;
        if (StringsKt.contains$default(r100, (String) r103.next(), false, 2, null) == false) goto L15;
        return true;
    L19:
        return false;
    L5:
        if (r101.getPanelHeightPercent() <= 73) goto L7;
        r102 = true;
        goto L8
    }

    public static boolean f(String r100, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        if (r101.e() == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        return false;
    L11:
        if (StringsKt.contains$default(r100, ECFindSimilarConfig.HEIGHT_PERCENT, false, 2, null) == true) goto L13;
        return false;
    L13:
        Iterator<T> r103 = ECSettingKeys.v0().iterator();
    L15:
        if (r103.hasNext() == false) goto L19;
        if (StringsKt.contains$default(r100, (String) r103.next(), false, 2, null) == false) goto L15;
        return true;
    L19:
        return false;
    L5:
        if (r101.r() <= 73) goto L7;
        r102 = true;
        goto L8
    }
}
