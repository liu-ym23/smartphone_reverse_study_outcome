package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.banner;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xp0.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/banner/AnchorShelfDisplayBannerItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayBannerItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f84538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f84539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f84540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f84541d;

    public AnchorShelfDisplayBannerItemViewHolder(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f84541d = r101;
        FrameLayout r102 = (FrameLayout) r100.findViewById(R.id.banner_content);
        this.f84538a = r102;
        this.f84539b = (HSImageView) r100.findViewById(R.id.banner_cover);
        this.f84540c = (ImageView) r100.findViewById(R.id.banner_close);
        float r103 = s1.y() - UtilityKotlinExtentionsKt.h(16);
        r102.setLayoutParams(new FrameLayout.LayoutParams((int) r103, (int) (0.44568247f * r103)));
    }
}
