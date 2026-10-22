package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import io.reactivex.functions.Action;
import java.util.Iterator;

/* JADX INFO: loaded from: classes47.dex */
public final class k implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.dsl.recyclerview.c f86636a;

    public k(com.bytedance.android.livesdk.dsl.recyclerview.c r100) {
        this.f86636a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Iterator<yt1.k> r100 = this.f86636a.f122794c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().release();
        goto L4
    }
}
