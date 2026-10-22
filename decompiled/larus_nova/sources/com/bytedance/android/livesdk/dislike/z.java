package com.bytedance.android.livesdk.dislike;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class z extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt1.a f122246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.dislike.action.y f122247d;

    public z(pt1.a r100, com.bytedance.android.livesdk.dislike.action.y r101, ItemType r102) {
        Intrinsics.checkNotNullParameter(r100, "shareFansHelper");
        Intrinsics.checkNotNullParameter(r101, "shareFansAction");
        Intrinsics.checkNotNullParameter(r102, DownloadHelper.IDENTITY);
        super(r102, r101);
        this.f122246c = r100;
        this.f122247d = r101;
    }
}
