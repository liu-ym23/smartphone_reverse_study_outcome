package com.bytedance.android.shopping.sameproduct.adapter;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import eh3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/adapter/SameProductDiffer;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductDiffer extends DiffUtil.ItemCallback<Object> {
    public SameProductDiffer() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r101, UGCMonitor.TYPE_POST);
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r101, UGCMonitor.TYPE_POST);
        String r102 = null;
        if ((r100 instanceof rd3.a) == false) goto L23;
        if ((r101 instanceof rd3.a) == false) goto L23;
        Promotion r103 = ((rd3.a) r100).f();
        if (r103 == null) goto L13;
        PromotionProductStruct r104 = r103.getPromotionInfo();
        if (r104 == null) goto L13;
        PromotionProductBaseStruct r105 = r104.getBaseInfo();
        if (r105 == null) goto L13;
        String r106 = r105.getProductId();
    L14:
        Promotion r107 = ((rd3.a) r101).f();
        if (r107 == null) goto L58;
        PromotionProductStruct r108 = r107.getPromotionInfo();
        if (r108 == null) goto L58;
        PromotionProductBaseStruct r109 = r108.getBaseInfo();
        if (r109 == null) goto L58;
        r102 = r109.getProductId();
    L58:
        return TextUtils.equals(r106, r102);
    L13:
        r106 = null;
    L23:
        if ((r100 instanceof PromotionProductStruct) == false) goto L47;
        if ((r101 instanceof PromotionProductStruct) == false) goto L47;
        PromotionProductStruct r110 = (PromotionProductStruct) r100;
        PromotionProductBaseStruct r111 = r110.getBaseInfo();
        if (r111 == null) goto L29;
        String r112 = r111.getProductId();
    L30:
        PromotionProductStruct r113 = (PromotionProductStruct) r101;
        PromotionProductBaseStruct r114 = r113.getBaseInfo();
        if (r114 == null) goto L33;
        String r115 = r114.getProductId();
    L35:
        if (TextUtils.equals(r112, r115) == false) goto L56;
        PromotionProductBaseStruct r116 = r110.getBaseInfo();
        if (r116 == null) goto L39;
        String r117 = r116.getPromotionId();
    L40:
        PromotionProductBaseStruct r118 = r113.getBaseInfo();
        if (r118 == null) goto L44;
        r102 = r118.getPromotionId();
    L44:
        if (TextUtils.equals(r117, r102) == false) goto L56;
    L50:
        return true;
    L39:
        r117 = null;
    L56:
        return false;
    L33:
        r115 = null;
        goto L35
    L29:
        r112 = null;
    L47:
        if ((r100 instanceof b) == false) goto L52;
        if ((r101 instanceof b) == true) goto L50;
    L52:
        if ((r100 instanceof eh3.a) == false) goto L56;
        if ((r101 instanceof eh3.a) == false) goto L56;
        goto L56
    }
}
