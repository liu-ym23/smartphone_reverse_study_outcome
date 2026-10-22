package com.bytedance.android.livesdk.chatroom.roommanage.binder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends RefineSettingItemBinder {
    public c() {
    }

    @Override // com.bytedance.android.live.adapter.binding.SwitchSettingItemBinder
    public final SwitchSettingViewHolder i(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        SwitchSettingViewHolder r102 = new SwitchSettingViewHolder(r100.inflate(R.layout.ttlive_viewholder_chat_room_manage_switch_setting_item, r101, false));
        r102.f58552d.setEnableEffect(false);
        return r102;
    }
}
