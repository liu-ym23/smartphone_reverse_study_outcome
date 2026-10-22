package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f72187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f72188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ne0.c f72189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ne0.c f72190d;

    public i(String r100, String r101, ne0.c r102, ne0.c r103) {
        this.f72187a = r100;
        this.f72188b = r101;
        this.f72189c = r102;
        this.f72190d = r103;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        ALogger.i("PlayModeService", "childStore state changed sync to parent childKey=" + this.f72187a + ", parentkey=" + this.f72188b);
        ne0.c r102 = this.f72190d;
        String r103 = this.f72188b;
        if (r101 == null) goto L5;
        Object r104 = r101.getData();
    L6:
        r102.b(r103, r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
