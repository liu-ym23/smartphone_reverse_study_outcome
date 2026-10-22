package com.bytedance.android.livesdk.bgService;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMediaSessionService f104329a;

    public k(LiveMediaSessionService r100) {
        this.f104329a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveMediaSessionService.b r101 = (LiveMediaSessionService.b) r100;
        if (r101.f104302a == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        LiveMediaSessionService r103 = this.f104329a;
        if (r103.f104298g == r102) goto L12;
        r103.f104298g = r102;
        r103.c();
        return;
    L12:
        return;
    L5:
        if (r101.f104303b == true) goto L7;
        r102 = true;
        goto L8
    }
}
