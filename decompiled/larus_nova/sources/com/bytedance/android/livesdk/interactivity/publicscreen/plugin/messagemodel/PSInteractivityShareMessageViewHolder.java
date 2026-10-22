package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSTextMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.interactivityshare.ItemShareLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/messagemodel/PSInteractivityShareMessageViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSTextMessageViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSInteractivityShareMessageViewHolder extends PSTextMessageViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ItemShareLayout f139209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HSImageView f139210l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f139211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f139212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function2<m1, Context, Unit> f139213o;

    /* JADX WARN: Multi-variable type inference failed */
    public PSInteractivityShareMessageViewHolder(View r100, Function2<? super m1, ? super Context, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "onShareItemClick");
        super(r100, null);
        this.f139213o = r101;
        this.f139209k = (ItemShareLayout) r100.findViewById(R.id.layout);
        this.f139210l = (HSImageView) r100.findViewById(R.id.iv_cover);
        this.f139211m = (TextView) r100.findViewById(R.id.tv_name);
        this.f139212n = r100.findViewById(R.id.share_content_layout);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.PSTextMessageViewHolder
    public final void X3(e52.a r100, s r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r103 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(r102, null, r100);
        this.f139209k.setTouchBackgroundColor(r103);
    }
}
