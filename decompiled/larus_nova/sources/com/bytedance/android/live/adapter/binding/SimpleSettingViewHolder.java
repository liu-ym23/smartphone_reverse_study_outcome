package com.bytedance.android.live.adapter.binding;

import android.view.View;
import android.widget.ImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/adapter/binding/SimpleSettingViewHolder;", "Lcom/bytedance/android/live/adapter/binding/BaseSettingViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleSettingViewHolder extends BaseSettingViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f58545d;

    public SimpleSettingViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f58545d = (ImageView) r100.findViewById(R.id.iv_arrow);
    }
}
