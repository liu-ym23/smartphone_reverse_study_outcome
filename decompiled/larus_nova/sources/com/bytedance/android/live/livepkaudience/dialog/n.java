package com.bytedance.android.live.livepkaudience.dialog;

import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkGuestApplyDialog f81833a;

    public n(PkGuestApplyDialog r100) {
        this.f81833a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 == null) goto L8;
        int r102 = WaitingListType.UNKNOWN.ordinal();
        if (r101.intValue() == r102) goto L9;
        PkGuestApplyDialog r103 = this.f81833a;
        r103.f81721q = r101.intValue();
        return;
    L9:
        return;
    }
}
