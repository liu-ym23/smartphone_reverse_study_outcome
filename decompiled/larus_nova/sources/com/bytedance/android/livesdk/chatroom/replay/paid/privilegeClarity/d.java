package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f109428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f109429b;

    public d(e r100, o r101) {
        this.f109428a = r100;
        this.f109429b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        b r102 = this.f109429b;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        e r103 = this.f109428a;
        r103.f109435f.removeObserver(r103.f109433d);
        e r104 = this.f109428a;
        r104.f109435f.removeObserver(r104.f109434e);
    }
}
