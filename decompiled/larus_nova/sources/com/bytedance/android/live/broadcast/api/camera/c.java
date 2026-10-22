package com.bytedance.android.live.broadcast.api.camera;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements l00.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f58977a;

    public c(a r100) {
        this.f58977a = r100;
    }

    @Override // l00.d.a
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        ALogger.i("CameraDirtyCheckController", "download fail,error:" + r100);
    }

    @Override // l00.d.a
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        ALogger.i("CameraDirtyCheckController", "download success,path:" + r100);
        a r101 = this.f58977a;
        r101.f58975d = r100;
        r101.f58976e.O0(r101.f58973b, r100);
    }
}
