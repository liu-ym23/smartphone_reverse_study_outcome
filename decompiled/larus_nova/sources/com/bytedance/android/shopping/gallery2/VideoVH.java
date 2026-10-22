package com.bytedance.android.shopping.gallery2;

import android.view.View;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/VideoVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoVH extends TransitionViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECVideoView f176158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECVideoPlayer f176159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f176160c;

    public VideoVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        ECVideoView r101 = (ECVideoView) r100.findViewById(R.id.video_patch_layout);
        this.f176158a = r101;
        ECVideoPlayer r102 = new ECVideoPlayer(r100.getContext());
        this.f176159b = r102;
        r101.setPlayer(r102);
        r101.setScaleType(0);
        r102.n(true);
    }

    public final void T3(k r100) {
        Intrinsics.checkNotNullParameter(r100, "galleryMediaModel");
        this.f176159b.q();
        this.f176160c = r100;
        String r101 = r100.f47877f;
        if (r101 == null) goto L6;
        this.f176158a.setCoverUrl(r101);
        return;
    }
}
