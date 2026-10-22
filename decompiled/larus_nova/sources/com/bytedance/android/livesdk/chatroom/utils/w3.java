package com.bytedance.android.livesdk.chatroom.utils;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class w3 implements cc2.n<cc2.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f114661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f114662b;

    public w3(View r100, View r101) {
        this.f114661a = r100;
        this.f114662b = r101;
    }

    @Override // cc2.n
    public final void a(cc2.b r100, Boolean r101) {
        View r102 = this.f114661a;
        if (r102 == null) goto L5;
        r102.setVisibility(0);
    L5:
        View r103 = this.f114662b;
        if (r103 == null) goto L9;
        r103.setVisibility(0);
        return;
    }

    @Override // cc2.n
    public final void b(cc2.b r100, Boolean r101) {
        View r102 = this.f114661a;
        if (r102 == null) goto L5;
        r102.setVisibility(4);
    L5:
        View r103 = this.f114662b;
        if (r103 == null) goto L9;
        r103.setVisibility(4);
        return;
    }
}
