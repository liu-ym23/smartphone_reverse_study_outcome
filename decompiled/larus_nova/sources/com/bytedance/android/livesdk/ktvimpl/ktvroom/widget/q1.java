package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class q1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q1 f145855a = null;

    static {
        f145855a = new q1();
    }

    public q1() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        boolean r101 = ((Boolean) r100).booleanValue();
        com.bytedance.android.live.liveinteract.plantform.base.g r102 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r102 == null) goto L6;
        r102.Lp(!r101);
        return;
    }
}
