package com.bytedance.android.livesdk.ktvapi.model.mv;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/mv/IMvPreviewViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class IMvPreviewViewHolder<T> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i<T> f142327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f142328b;

    public abstract void T3(int r100, T r101);

    public IMvPreviewViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public void U3(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f142328b = r100;
    }
}
