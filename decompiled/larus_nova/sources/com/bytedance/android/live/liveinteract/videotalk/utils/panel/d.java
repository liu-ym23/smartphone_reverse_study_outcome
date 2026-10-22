package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements rj0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoShowMode f79852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoShowMode f79853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m00.g f79854c;

    @Override // rj0.a
    public final boolean a() {
        return true;
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
    public final vc0.a getSurfaceView() {
        m00.g r100 = this.f79854c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return new vc0.a(r100);
    }

    @Override // rj0.a
    public final void onCancel() {
        if (this.f79853b != VideoShowMode.DIGIT_AVATAR) goto L9;
        DigitAvatarContext r100 = DigitAvatarContext.Companion.getContext();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.getRestoreDigitAvatar();
        if (r101 == null) goto L9;
        r101.setValue(Boolean.TRUE);
    L9:
        DigitAvatarContext r102 = DigitAvatarContext.Companion.getContext();
        if (r102 == null) goto L13;
        DigitAvatarContext.setVideoShowMode$default(r102, this.f79853b, null, 2, null);
        return;
    }

    @Override // rj0.a
    public final void onConfirm() {
        DigitAvatarContext r100 = DigitAvatarContext.Companion.getContext();
        if (r100 == null) goto L6;
        DigitAvatarContext.setVideoShowMode$default(r100, this.f79852a, null, 2, null);
        return;
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return s1.B(R.string.ttlive_ok);
    }

    public d(VideoShowMode r100, VideoShowMode r101, m00.g r102) {
        this.f79852a = r100;
        this.f79853b = r101;
        this.f79854c = r102;
    }
}
