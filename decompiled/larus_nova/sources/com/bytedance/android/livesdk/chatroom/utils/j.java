package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.z5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements z5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f114518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f114519b;

    @Override // com.bytedance.android.livesdk.utils.z5.a
    public final void onQuit() {
        ALogger.i("CarnivalBinarySeiHandler", "handler thread quit");
    }

    @Override // com.bytedance.android.livesdk.utils.z5.a
    public final void a(z5 r100) {
        Intrinsics.checkNotNullParameter(r100, "thread");
        if (this.f114518a.f114494a.compareAndSet(1, 2) == false) goto L5;
        ALogger.i("CarnivalBinarySeiHandler", "handler start success. cost=" + (System.currentTimeMillis() - this.f114519b));
        this.f114518a.f114496c = new Handler(r100.getLooper());
        return;
    L5:
        ALogger.i("CarnivalBinarySeiHandler", "handler start failed. cur state is " + this.f114518a.f114494a.get());
    }

    public j(i r100, long r101) {
        this.f114518a = r100;
        this.f114519b = r101;
    }
}
