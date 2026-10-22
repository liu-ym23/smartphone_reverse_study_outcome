package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import com.bytedance.android.livesdk.log.ContentDurationLogger;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y4 extends dq1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.log.j f114674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentDurationLogger f114675b;

    public y4(com.bytedance.android.livesdk.log.j r100, ContentDurationLogger r101) {
        this.f114674a = r100;
        this.f114675b = r101;
    }

    @Override // dq1.e
    public final void b(VSCameraInfo r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "targetCamera");
        com.bytedance.android.livesdk.log.j r102 = this.f114674a;
        if (r102 == null) goto L5;
        r102.f();
    L5:
        ContentDurationLogger r103 = this.f114675b;
        if (r103 == null) goto L9;
        r103.a();
        return;
    }
}
