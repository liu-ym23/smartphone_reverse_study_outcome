package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f115838a;

    public k(Function0 r100) {
        this.f115838a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        this.f115838a.invoke();
        return;
    }
}
