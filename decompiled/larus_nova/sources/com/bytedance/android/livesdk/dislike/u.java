package com.bytedance.android.livesdk.dislike;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nt1.c f122237c;

    @Override // com.bytedance.android.livesdk.dislike.n
    public final boolean a(n r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof u) == true) goto L6;
        return false;
    L6:
        if (((u) r100).f122237c.a(this.f122237c) == true) goto L9;
        return false;
    L9:
        return super.a(r100);
    }

    public u(nt1.c r100, OptionAction r101, ItemType r102) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        Intrinsics.checkNotNullParameter(r101, "optionAction");
        Intrinsics.checkNotNullParameter(r102, DownloadHelper.IDENTITY);
        super(r102, r101);
        this.f122237c = r100;
    }
}
