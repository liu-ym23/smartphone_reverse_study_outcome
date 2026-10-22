package ch3;

import android.content.Context;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardSimpleAbilityView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23761a = 0;

    static {
    }

    public static ProductFlowCardSimpleAbilityView a(Context r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "text");
        ProductFlowCardSimpleAbilityView r103 = new ProductFlowCardSimpleAbilityView(r100, null, 6, 0);
        r103.setIcon(r101);
        r103.setText(r102);
        return r103;
    }
}
