package ai3;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.ErrorMonitorType;
import com.tencent.open.SocialConstants;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final void a(j33.d r100, ErrorMonitorType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$reportError");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        r100.a("buynow_error_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", r101.getValue()), TuplesKt.to(SocialConstants.PARAM_APP_DESC, r102)}));
    }
}
