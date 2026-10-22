package com.byted.mgl.merge.service.impl.share;

import android.app.Activity;
import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.byted.mgl.merge.service.api.share.BdpShareCallback;
import com.byted.mgl.merge.service.api.share.BdpShareDialogCallback;
import com.byted.mgl.merge.service.api.share.BdpShareService;

/* JADX INFO: loaded from: classes3.dex */
public class BdpShareServiceImpl implements BdpShareService {
    public BdpShareServiceImpl() {
    }

    @Override // com.byted.mgl.merge.service.api.share.BdpShareService
    public boolean isBlockChannelDefault(String r100, boolean r101) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.share.BdpShareService
    public boolean isSupportPictureToken() {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.share.BdpShareService
    public void openShareDialog(Activity r100, BdpShareBaseInfo r101, BdpShareDialogCallback r102, boolean r103) {
    }

    @Override // com.byted.mgl.merge.service.api.share.BdpShareService
    public void openShareDialog(Activity r100, BdpShareBaseInfo r101, String[] r102, BdpShareDialogCallback r103, boolean r104) {
    }

    @Override // com.byted.mgl.merge.service.api.share.BdpShareService
    public void registerShareCallback(BdpShareCallback r100) {
    }

    @Override // com.byted.mgl.merge.service.api.share.BdpShareService
    public boolean share(Activity r100, BdpShareBaseInfo r101, BdpShareCallback r102) {
        return false;
    }
}
