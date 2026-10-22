package com.bytedance.android.gamecp.business.gamedetail.view.intro;

import com.bytedance.android.gamecp.business.gamedetail.base.model.VideoRotation;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VideoRotation f55932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GameImageBundler f55934e;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.view.intro.a$a, reason: collision with other inner class name */
    public static final class C0900a {
    }

    static {
    }

    public final int getType() {
        return this.f55931b;
    }

    public a(String r100, int r101, VideoRotation r102, boolean r103, GameImageBundler r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = false;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "rotation");
        this.f55930a = r100;
        this.f55931b = r101;
        this.f55932c = r102;
        this.f55933d = r103;
        this.f55934e = r104;
    }
}
