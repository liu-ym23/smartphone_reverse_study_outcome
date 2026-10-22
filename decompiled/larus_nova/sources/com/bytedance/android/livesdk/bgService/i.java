package com.bytedance.android.livesdk.bgService;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f104327a;

    public i(MediatorLiveData r100) {
        this.f104327a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        LiveMediaSessionService.b r102 = (LiveMediaSessionService.b) this.f104327a.getValue();
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.f104302a);
    L7:
        if ((!Intrinsics.areEqual(r103, r101)) == false) goto L12;
        if (r102 == null) goto L10;
        r102.f104302a = r101.booleanValue();
    L10:
        this.f104327a.setValue(r102);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
