package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class e9 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f9 f63362a;

    public e9(f9 r100) {
        this.f63362a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ((IOpenPlatformAnchorService) jc1.k.n(IOpenPlatformAnchorService.class)).unmount();
        r100.dismiss();
        this.f63362a.finishWithSuccess();
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_open_platform_cancel_toast, 0);
    }
}
