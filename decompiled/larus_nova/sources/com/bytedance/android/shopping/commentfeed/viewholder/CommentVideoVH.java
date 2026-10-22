package com.bytedance.android.shopping.commentfeed.viewholder;

import android.widget.SeekBar;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.extensions.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentVideoVH;", "Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentBaseViewHolder;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentVideoVH extends CommentBaseViewHolder implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f172388d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PromotionVideoInfo f172389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f172390c;

    public static final class a {
    }

    static {
        f172388d = b.b(78);
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void T3() {
        throw null;
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void U3() {
        throw null;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        if (this.f172390c == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        throw null;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        PromotionVideoInfo r103 = this.f172389b;
        if (r103 == null) goto L10;
        r103.getDuration();
        if (r102 == true) goto L7;
        return;
    L7:
        if (this.f172390c == true) goto L9;
        throw null;
    L9:
        throw null;
    }
}
