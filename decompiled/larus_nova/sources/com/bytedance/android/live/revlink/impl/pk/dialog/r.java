package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkUserBanSettingDialog f96096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f96097b;

    public r(PkUserBanSettingDialog r100, Context r101) {
        this.f96096a = r100;
        this.f96097b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f96096a.f95493j = false;
        r101.printStackTrace();
        if ((r101 instanceof ApiServerException) == true) goto L5;
        r101 = null;
    L5:
        ApiServerException r102 = (ApiServerException) r101;
        if (r102 == null) goto L8;
        IESUIUtils.displayToast(this.f96097b, r102.getPrompt());
        return;
    L8:
        IESUIUtils.displayToast(this.f96097b, R.string.ttlive_live_follow_failed);
    }
}
