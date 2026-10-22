package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.bytedance.android.live.user.IUserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f142110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f142111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IUserService f142112c;

    public l() {
        h r100 = new h();
        k r101 = new k();
        IUserService r102 = (IUserService) jc1.k.n(IUserService.class);
        Intrinsics.checkNotNullParameter(r100, "rxDownloadApi");
        Intrinsics.checkNotNullParameter(r101, "rxSaveDraftApi");
        Intrinsics.checkNotNullParameter(r102, "userService");
        this.f142110a = r100;
        this.f142111b = r101;
        this.f142112c = r102;
    }
}
