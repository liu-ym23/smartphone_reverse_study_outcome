package com.bytedance.android.live.soloktv.karaokestation.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements bb1.a<com.bytedance.android.live.soloktv.model.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvHomeFragment f101338a;

    public j(SoloKtvHomeFragment r100) {
        this.f101338a = r100;
    }

    @Override // bb1.a
    public final SoloKtvRoomViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new SoloKtvRoomViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.solo_ktv_live_room_item, r100, false), this.f101338a.f101241d);
    }
}
