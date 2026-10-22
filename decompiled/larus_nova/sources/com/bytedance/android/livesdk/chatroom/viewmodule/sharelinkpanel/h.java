package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import com.bytedance.android.livehostapi.business.depend.share.IVSPosterClickListener;
import com.lynx.serval.svg.SVGRenderEngine;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements IVSPosterClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLinkShareToThirdDialogFragment f115497a;

    @Override // com.bytedance.android.livehostapi.business.depend.share.IVSPosterClickListener
    public final void onDownloadButtonClick() {
        LiveLinkShareToThirdDialogFragment.T90(this.f115497a, SVGRenderEngine.SAVE);
    }

    public h(LiveLinkShareToThirdDialogFragment r100) {
        this.f115497a = r100;
    }
}
