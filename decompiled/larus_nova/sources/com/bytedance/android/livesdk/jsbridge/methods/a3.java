package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import w20.nc;

/* JADX INFO: loaded from: classes9.dex */
public final class a3 implements w2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w2 f142051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nc f142052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f142053c;

    @Override // com.bytedance.android.livesdk.jsbridge.methods.w2.a
    public final void a() {
        this.f142051a.finishWithFailure(new Throwable("System permissionDenied."));
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.w2.a
    public final void b() {
        Integer r100 = this.f142052b.b();
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        w2 r102 = this.f142051a;
        Integer r103 = this.f142052b.a();
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        r102.f142234a = r104;
        ((IHostAction) jc1.k.n(IHostAction.class)).openMultiSelectPhotoLibraryForMultiLink(this.f142053c, LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, r101, this.f142051a.f142234a, "live_choose_photo", "live_album");
        return;
    L9:
        r104 = BmLocated.HALF_LEFT_BOTTOM;
        goto L10
    L5:
        r101 = 9;
        goto L6
    }

    public a3(w2 r100, nc r101, Activity r102) {
        this.f142051a = r100;
        this.f142052b = r101;
        this.f142053c = r102;
    }
}
