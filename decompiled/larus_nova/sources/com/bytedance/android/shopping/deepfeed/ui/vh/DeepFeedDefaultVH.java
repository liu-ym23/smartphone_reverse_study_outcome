package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedDefaultVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DeepFeedDefaultVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f173770b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.deepfeed.action.h f173771a;

    public static final class a {
    }

    static {
    }

    public DeepFeedDefaultVH(View r100, com.bytedance.android.shopping.deepfeed.action.h r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f173771a = r101;
        SimpleDraweeView r102 = (SimpleDraweeView) r100.findViewById(R.id.deep_feed_default_center_mask);
    }
}
