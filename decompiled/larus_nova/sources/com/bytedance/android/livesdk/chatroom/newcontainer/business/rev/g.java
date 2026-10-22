package com.bytedance.android.livesdk.chatroom.newcontainer.business.rev;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f107527a;

    public g(i r100) {
        this.f107527a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) ((KVData) r100).getData(Boolean.FALSE)).booleanValue() == true) goto L6;
        this.f107527a.z("event");
        return;
    }
}
