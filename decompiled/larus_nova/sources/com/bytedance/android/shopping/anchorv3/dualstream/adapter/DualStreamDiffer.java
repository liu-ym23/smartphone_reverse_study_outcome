package com.bytedance.android.shopping.anchorv3.dualstream.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/dualstream/adapter/DualStreamDiffer;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DualStreamDiffer extends DiffUtil.ItemCallback<Object> {

    public static final class a {
    }

    static {
    }

    public DualStreamDiffer() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r101, UGCMonitor.TYPE_POST);
        if ((r100 instanceof PromotionProductCommentDTO) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r101 instanceof PromotionProductCommentDTO) == false) goto L7;
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r101, UGCMonitor.TYPE_POST);
        if ((r100 instanceof PromotionProductCommentDTO) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r101 instanceof PromotionProductCommentDTO) == false) goto L7;
        return Intrinsics.areEqual(((PromotionProductCommentDTO) r100).getId(), ((PromotionProductCommentDTO) r101).getId());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final Object getChangePayload(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r101, UGCMonitor.TYPE_POST);
        ArrayList r102 = new ArrayList();
        Boolean r103 = null;
        if ((r100 instanceof PromotionProductCommentDTO) == true) goto L5;
        r100 = null;
    L5:
        PromotionProductCommentDTO r104 = (PromotionProductCommentDTO) r100;
        if (r104 == null) goto L8;
        Boolean r105 = r104.getLiked();
    L10:
        if ((r101 instanceof PromotionProductCommentDTO) == true) goto L12;
        r101 = null;
    L12:
        PromotionProductCommentDTO r106 = (PromotionProductCommentDTO) r101;
        if (r106 == null) goto L16;
        r103 = r106.getLiked();
    L16:
        if ((!Intrinsics.areEqual(r105, r103)) == false) goto L18;
        r102.add("dig_changed");
    L18:
        return r102;
    L8:
        r105 = null;
        goto L10
    }
}
