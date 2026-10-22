package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.liveinteract.jsbridge.method.DynamicRegisterMessageMethod;

/* JADX INFO: loaded from: classes10.dex */
public final class q implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f143750a;

    public q(m r100) {
        this.f143750a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new DynamicRegisterMessageMethod(this.f143750a.f143746b);
    }
}
