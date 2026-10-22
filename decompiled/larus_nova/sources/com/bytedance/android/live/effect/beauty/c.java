package com.bytedance.android.live.effect.beauty;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements com.bytedance.android.live.effect.api.k.f {
    public c() {
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r100, Sticker r101) {
        StringBuilder r102 = new StringBuilder("onDownloadFail,id:");
        String r103 = null;
        if (r101 == null) goto L5;
        Long r104 = Long.valueOf(r101.getId());
    L6:
        r102.append(r104);
        r102.append(",name:");
        if (r101 == null) goto L9;
        r103 = r101.getName();
    L9:
        r102.append(r103);
        ALogger.i("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment", r102.toString());
        if (r101 == null) goto L13;
        r101.setDownloaded(true);
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r100, Sticker r101) {
        StringBuilder r102 = new StringBuilder("onDownloadStart,id:");
        String r103 = null;
        if (r101 == null) goto L5;
        Long r104 = Long.valueOf(r101.getId());
    L6:
        r102.append(r104);
        r102.append(",name:");
        if (r101 == null) goto L9;
        r103 = r101.getName();
    L9:
        r102.append(r103);
        ALogger.i("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment", r102.toString());
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r100, Sticker r101, ExceptionResult r102) {
        StringBuilder r103 = new StringBuilder("onDownloadFail,id:");
        String r104 = null;
        if (r101 == null) goto L5;
        Long r105 = Long.valueOf(r101.getId());
    L6:
        r103.append(r105);
        r103.append(",name:");
        if (r101 == null) goto L9;
        r104 = r101.getName();
    L9:
        r103.append(r104);
        ALogger.i("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment", r103.toString());
        return;
    L5:
        r105 = null;
        goto L6
    }
}
