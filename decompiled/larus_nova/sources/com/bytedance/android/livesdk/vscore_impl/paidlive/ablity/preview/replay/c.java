package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.replay;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.chatroom.view.BlurImageView;
import com.ss.android.videoshop.context.VideoContext;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements cjc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidReplayMLVideoMaskView f160444a;

    public c(PaidReplayMLVideoMaskView r100) {
        this.f160444a = r100;
    }

    @Override // cjc.d
    public final void a(Bitmap r100) {
        if (r100 == null) goto L6;
        PaidReplayMLVideoMaskView r101 = this.f160444a;
        BlurImageView r102 = r101.f160432p;
        if (r102 == null) goto L6;
        r102.post(new d(r101, r100, 1));
    L6:
        VideoContext r103 = this.f160444a.j();
        if (r103 != null) goto L9;
    L10:
        VideoContext r104 = this.f160444a.j();
        if (r104 == null) goto L15;
        r104.pause();
        return;
    L15:
        return;
    L9:
        if (r103.isPlaying() == true) goto L10;
    }
}
