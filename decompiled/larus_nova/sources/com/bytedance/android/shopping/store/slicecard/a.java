package com.bytedance.android.shopping.store.slicecard;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.slicecard.a$a, reason: collision with other inner class name */
    public static final class C2738a {
        public static void a(SliceActionType r100, StoreV2ProductItemVO r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        }

        public static void b(SliceActionType r100, ShopSlcProductItemV2 r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        }

        public static void c(StoreV2ProductItemVO r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        }
    }

    void a(ShopSlcProductItemV2 r100, View r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103);

    void b(StoreV2ProductItemVO r100, View r101, Map<String, ? extends Object> r102);

    void c(SliceActionType r100, ShopSlcProductItemV2 r101, View r102, Map<String, ? extends Object> r103);

    void d(SliceActionType r100, StoreV2ProductItemVO r101, View r102, Map<String, ? extends Object> r103);
}
