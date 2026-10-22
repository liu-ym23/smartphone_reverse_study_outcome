package com.bytedance.android.live.ktv.common.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.view.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.i;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/OpusPreviewAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/IMvPreviewViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewAdapter<T> extends RecyclerView.Adapter<IMvPreviewViewHolder<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends T> f70773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j<T> f70775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i<T> f70776d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends T> r100 = this.f70773a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        IMvPreviewViewHolder r102 = (IMvPreviewViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<? extends T> r103 = this.f70773a;
        if (r103 == null) goto L8;
        Object r104 = ListProtector.get(r103, r101);
        if (r104 == null) goto L9;
        r102.T3(r101, r104);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        j<T> r102 = this.f70775c;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.layout_mv_cover_item, r100, false);
        if (this.f70774b <= 0) goto L5;
        r103.setLayoutParams(new ViewGroup.LayoutParams(this.f70774b, s1.f(150.0f)));
    L5:
        Unit r104 = Unit.INSTANCE;
        if (r103 == null) goto L10;
        IMvPreviewViewHolder<T> r105 = r102.a((FrameLayout) r103);
        r105.f142327a = this.f70776d;
        r105.U3((HSImageView) r105.itemView.findViewById(R.id.cover_bg));
        return r105;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public OpusPreviewAdapter(int r100, j r101, f r102) {
        Intrinsics.checkNotNullParameter(r101, "vhProvider");
        Intrinsics.checkNotNullParameter(r102, "adapterClickCallback");
        this.f70774b = r100;
        this.f70775c = r101;
        this.f70776d = r102;
    }
}
