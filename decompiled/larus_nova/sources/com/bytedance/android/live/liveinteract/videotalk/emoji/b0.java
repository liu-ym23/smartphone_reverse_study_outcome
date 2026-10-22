package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class b0 implements rj0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoShowMode f79340a;

    @Override // rj0.a
    public final boolean a() {
        return false;
    }

    @Override // rj0.a
    public final boolean b() {
        return false;
    }

    @Override // rj0.a
    public final void c() {
    }

    @Override // rj0.a
    public final String getCancelText() {
        return "";
    }

    @Override // rj0.a
    public final void onConfirm() {
    }

    @Override // rj0.a
    public final vc0.a getSurfaceView() {
        rj0.l.f537955n2.getClass();
        rj0.l r100 = rj0.l.a.a();
        if (r100 == null) goto L7;
        m00.g r101 = r100.hh();
        if (r101 == null) goto L7;
        return new vc0.a(r101);
    L7:
        return null;
    }

    @Override // rj0.a
    public final void onCancel() {
        DigitAvatarContext r100 = DigitAvatarContext.Companion.getContext();
        if (r100 == null) goto L6;
        DigitAvatarContext.setVideoShowMode$default(r100, this.f79340a, null, 2, null);
        return;
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return s1.B(R.string.ttlive_ok);
    }

    public b0(VideoShowMode r100) {
        this.f79340a = r100;
    }
}
