package com.bytedance.android.live.ktv.common.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/UploadImgVh;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UploadImgVh extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f70799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f70800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f70801c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f70802a;

        public a(b r100) {
            this.f70802a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f70802a.e();
        }
    }

    public UploadImgVh(View r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "adapterClickCb");
        super(r100);
        this.f70799a = (TextView) r100.findViewById(R.id.tv_upload);
        this.f70800b = (ImageView) r100.findViewById(R.id.iv_upload_img);
        View r102 = r100.findViewById(R.id.fl_upload_img);
        this.f70801c = r102;
        r102.setOnClickListener(new a(r101));
    }
}
