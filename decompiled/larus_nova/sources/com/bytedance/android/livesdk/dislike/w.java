package com.bytedance.android.livesdk.dislike;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class w extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nt1.b f122239c;

    @Override // com.bytedance.android.livesdk.dislike.n
    public final boolean a(n r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof w) == true) goto L5;
        return false;
    L5:
        nt1.b r101 = ((w) r100).f122239c;
        nt1.b r102 = this.f122239c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "setting");
        boolean r103 = true;
        if (r102.f520466c == r101.f520466c) goto L8;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L17;
        r102 = null;
    L17:
        if (r102 == null) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L22;
        return false;
    L22:
        return super.a(r100);
    L8:
        if (r102.f520465b != r101.f520465b) goto L13;
        if (r102.f520464a != r101.f520464a) goto L13;
        r104 = false;
        goto L14
    }

    public w(nt1.b r100, OptionAction r101, ItemType r102) {
        Intrinsics.checkNotNullParameter(r100, "notificationSettingVO");
        Intrinsics.checkNotNullParameter(r101, "optionAction");
        Intrinsics.checkNotNullParameter(r102, DownloadHelper.IDENTITY);
        super(r102, r101);
        this.f122239c = r100;
    }
}
