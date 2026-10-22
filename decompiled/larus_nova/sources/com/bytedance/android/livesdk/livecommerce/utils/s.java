package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.utils.z1;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class s {
    public static final void c(final String r100, final EnumEntranceInfoScene r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$reportAPTDiff");
        Intrinsics.checkNotNullParameter(r101, "tag");
        com.bytedance.android.ec.sdk.helper.l.a(new ECLiveEntranceInfoHelperKt$reportAPTDiff$1(r100, r101));
    }

    public static final void a(gl.a r100, JSONObject r101, Function2<? super String, ? super String, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r102, "condition");
        if (r101 != null) goto L5;
        return;
    L5:
        Map<String, String> r103 = z1.j(r101);
        Intrinsics.checkNotNullParameter(r100, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r102, "condition");
        r100.f(MapsKt.toMap(r103), new ECLiveEntranceInfoHelperKt$putStringIf$1(r102));
    }

    public static final void b(gl.a r100, Pair<String, String>[] r101, Function2<? super String, ? super String, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r101, "entranceInfo");
        Intrinsics.checkNotNullParameter(r102, "condition");
        Map r103 = MapsKt.toMap(r101);
        Intrinsics.checkNotNullParameter(r100, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r102, "condition");
        if (r103 == null) goto L7;
        r100.f(MapsKt.toMap(r103), new ECLiveEntranceInfoHelperKt$putStringIf$1(r102));
        return;
    }

    public static final void d(String r100, EnumEntranceInfoScene r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$reportEntranceInfoDiff");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "inSchema");
        oh.a.c("entrance_info_diff", new r(r100, r101, r102));
    }
}
