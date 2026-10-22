package com.bytedance.android.live.soloktv.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/SoloKtvTuningViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvTuningViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f101815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f101816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f101817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.model.bean.h f101818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<com.bytedance.android.live.ktv.common.model.bean.h, Unit> f101819e;

    /* JADX WARN: Multi-variable type inference failed */
    public SoloKtvTuningViewHolder(View r100, Function1<? super com.bytedance.android.live.ktv.common.model.bean.h, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f101819e = r101;
        View r102 = r100.findViewById(R.id.tuning_selected);
        this.f101815a = r102;
        HSImageView r103 = (HSImageView) r100.findViewById(R.id.tuning_cover);
        this.f101816b = r103;
        this.f101817c = (TextView) r100.findViewById(R.id.tuning_title);
        r103.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r102.setBackgroundResource(R.drawable.ttlive_bg_ktv_tuning_border_light);
    }
}
