package com.byted.mgl.merge.service.api.share;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpShareService extends IBdpService {
    boolean isBlockChannelDefault(String r100, boolean r101);

    boolean isSupportPictureToken();

    void openShareDialog(Activity r100, BdpShareBaseInfo r101, BdpShareDialogCallback r102, boolean r103);

    void openShareDialog(Activity r100, BdpShareBaseInfo r101, String[] r102, BdpShareDialogCallback r103, boolean r104);

    void registerShareCallback(BdpShareCallback r100);

    boolean share(Activity r100, BdpShareBaseInfo r101, BdpShareCallback r102);
}
