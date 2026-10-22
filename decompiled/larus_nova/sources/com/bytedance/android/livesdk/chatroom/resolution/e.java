package com.bytedance.android.livesdk.chatroom.resolution;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoResolutionManager f110471a;

    public e(AutoResolutionManager r100) {
        this.f110471a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        this.f110471a.h();
        return;
    }
}
