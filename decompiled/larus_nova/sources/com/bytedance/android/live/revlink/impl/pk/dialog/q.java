package com.bytedance.android.live.revlink.impl.pk.dialog;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;
import x31.u;

/* JADX INFO: loaded from: classes47.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkUserBanSettingDialog f96095a;

    public q(PkUserBanSettingDialog r100) {
        this.f96095a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IFollowPair r101 = (IFollowPair) r100;
        PkUserBanSettingDialog r102 = this.f96095a;
        int r103 = 0;
        r102.f95493j = false;
        if (r101 == null) goto L5;
        Integer r104 = Integer.valueOf(r101.getFollowStatus());
    L6:
        r102.U90(r104);
        u r105 = this.f96095a.f95488e;
        if (r105 == null) goto L12;
        if (r101 == null) goto L10;
        r103 = r101.getFollowStatus();
    L10:
        r105.f562342a = r103;
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
