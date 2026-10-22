package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes46.dex */
public final class t implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f72346a;

    public t(HSImageView r100) {
        this.f72346a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f72346a.setVisibility(8);
        UtilityKotlinExtentionsKt.q(this.f72346a);
    }
}
