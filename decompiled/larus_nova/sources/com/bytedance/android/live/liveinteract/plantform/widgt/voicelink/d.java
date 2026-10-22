package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkVoiceAnchorContainerWidget f77823a;

    public d(MultiLinkVoiceAnchorContainerWidget r100) {
        this.f77823a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        pe0.a r101 = (pe0.a) r100;
        MultiLinkVoiceAnchorContainerWidget r102 = this.f77823a;
        com.bytedance.android.livesdk.message.linker.h r103 = r102.f77765i;
        if (r103 == null) goto L6;
        r102.continueAnchorLinkMic(r102.f77759c, r103);
        return;
    }
}
