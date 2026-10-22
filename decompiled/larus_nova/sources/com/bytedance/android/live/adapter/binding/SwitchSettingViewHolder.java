package com.bytedance.android.live.adapter.binding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/adapter/binding/SwitchSettingViewHolder;", "Lcom/bytedance/android/live/adapter/binding/BaseSettingViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchSettingViewHolder extends BaseSettingViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveSwitchButton f58552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f58553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f58554f;

    public SwitchSettingViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f58552d = (LiveSwitchButton) r100.findViewById(R.id.setting_switch);
        this.f58553e = (TextView) r100.findViewById(R.id.tv_desc_action);
        this.f58554f = (ImageView) r100.findViewById(R.id.iv_switch_title);
    }
}
