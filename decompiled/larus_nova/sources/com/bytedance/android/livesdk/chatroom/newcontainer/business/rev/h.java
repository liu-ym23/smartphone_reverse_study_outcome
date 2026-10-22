package com.bytedance.android.livesdk.chatroom.newcontainer.business.rev;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f107528a;

    public h(i r100) {
        this.f107528a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        i r101 = this.f107528a;
        if (((Boolean) ((KVData) r100).getData(Boolean.FALSE)).booleanValue() == false) goto L6;
        r101.getClass();
        r101.f107531d = System.currentTimeMillis();
        return;
    L6:
        if (r101.f107531d <= 0) goto L10;
        r101.f107532e += System.currentTimeMillis() - r101.f107531d;
        r101.f107531d = 0;
        return;
    }
}
