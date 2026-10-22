package com.bytedance.android.livesdk.dislike;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemType f122166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OptionAction f122167b;

    public boolean a(n r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (r100.f122166a == this.f122166a) goto L6;
        return false;
    L6:
        return true;
    }

    public n(ItemType r100, OptionAction r101) {
        Intrinsics.checkNotNullParameter(r100, DownloadHelper.IDENTITY);
        Intrinsics.checkNotNullParameter(r101, "optionAction");
        this.f122166a = r100;
        this.f122167b = r101;
    }
}
