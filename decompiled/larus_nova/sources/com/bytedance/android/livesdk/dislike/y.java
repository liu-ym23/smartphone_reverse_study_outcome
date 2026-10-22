package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.dislike.action.RecommendToFriendsAction;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y extends n {
    public y(RecommendToFriendsAction r100, ItemType r101) {
        Intrinsics.checkNotNullParameter(r100, "optionAction");
        Intrinsics.checkNotNullParameter(r101, DownloadHelper.IDENTITY);
        super(r101, r100);
    }
}
