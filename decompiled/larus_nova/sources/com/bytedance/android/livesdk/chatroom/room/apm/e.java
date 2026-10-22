package com.bytedance.android.livesdk.chatroom.room.apm;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f110700a;

    public e(c r100) {
        this.f110700a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        this.f110700a.f110692c = false;
        return;
    }
}
