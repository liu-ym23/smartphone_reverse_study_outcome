package com.bytedance.android.livesdk.chatroom.progressbar.player;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerProgressBridge f107813a;

    public a(PlayerProgressBridge r100) {
        this.f107813a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L7;
        PlayerProgressBridge r101 = this.f107813a;
        r101.f107797l = false;
        r101.g();
        return;
    }
}
