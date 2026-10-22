package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements IPreLoaderItemCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f108613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f108614b;

    public k(j r100, long r101) {
        this.f108613a = r100;
        this.f108614b = r101;
    }

    @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
    public final void preloadItemInfo(PreLoaderItemCallBackInfo r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getKey());
    L5:
        if (r101 != null) goto L8;
    L10:
        if (r101 != null) goto L13;
    L15:
        if (r101 != null) goto L18;
        return;
    L18:
        if (r101.intValue() != 5) goto L23;
        this.f108613a.f108611c.a(this.f108614b);
        return;
    L23:
        return;
    L13:
        if (r101.intValue() != 3) goto L15;
        this.f108613a.f108611c.c(this.f108614b);
        return;
    L8:
        if (r101.intValue() != 2) goto L10;
        this.f108613a.f108611c.b(this.f108614b);
        return;
    L4:
        r101 = null;
        goto L5
    }
}
