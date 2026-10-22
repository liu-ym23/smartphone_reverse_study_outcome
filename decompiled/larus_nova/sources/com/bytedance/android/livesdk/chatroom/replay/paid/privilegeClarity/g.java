package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPrivilegeClarityManager f109443a;

    public g(ReplayPrivilegeClarityManager r100) {
        this.f109443a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ReplayPrivilegeClarityManager r101 = this.f109443a;
        boolean r102 = ((Boolean) r100).booleanValue();
        r101.f109404m = r102;
        if (r102 == false) goto L6;
        r101.n();
        return;
    }
}
