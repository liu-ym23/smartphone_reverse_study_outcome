package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session;

import com.bytedance.android.livesdk.live.LiveInnerCommonController;
import com.bytedance.android.livesdk.slideuptip.LiveSlideUpTipsGuideStrategy;
import com.bytedance.android.livesdk.slideuptip.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ik1.b f107459a;

    public d(ik1.b r100) {
        this.f107459a = r100;
    }

    @Override // com.bytedance.android.livesdk.slideuptip.k.b
    public final boolean a() {
        ik1.b r100 = this.f107459a;
        if (r100 == null) goto L9;
        LiveInnerCommonController r101 = r100.A;
        if (r101 == null) goto L9;
        LiveSlideUpTipsGuideStrategy r102 = r101.a();
        if (r102 == null) goto L9;
        Boolean r103 = Boolean.valueOf(r102.f158380n);
    L11:
        return r103.booleanValue();
    L9:
        r103 = null;
        goto L11
    }
}
