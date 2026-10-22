package com.bytedance.android.live.liveinteract.digitavatar;

import android.view.View;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;

/* JADX INFO: loaded from: classes46.dex */
public final class d0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TalkRoomBaseDynamicEmoji f72610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f72611b;

    public d0(TalkRoomBaseDynamicEmoji r100, e0 r101) {
        this.f72610a = r100;
        this.f72611b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.live.liveinteract.videotalk.emoji.s r101 = this.f72611b.f72614b;
        if (r101 == null) goto L6;
        r101.j0(this.f72610a);
        return;
    }
}
