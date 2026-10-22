package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class n implements rj0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkPKAudienceInteractDynamicEmojiDialog f81965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m00.g f81966b;

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
        m00.g r100 = this.f81966b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return new vc0.a(r100);
    }

    @Override // rj0.a
    public final void onCancel() {
        m00.g r100 = this.f81966b;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f81965a.z5(1, true);
    }

    @Override // rj0.a
    public final void onConfirm() {
        m00.g r100 = this.f81966b;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f81965a.z5(1, true);
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return s1.B(R.string.ttlive_ok);
    }

    public n(LinkPKAudienceInteractDynamicEmojiDialog r100, m00.g r101) {
        this.f81965a = r100;
        this.f81966b = r101;
    }
}
