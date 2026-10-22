package com.bytedance.android.livesdk.chatroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerControlWidget f118833a;

    public k1(PlayerControlWidget r100) {
        this.f118833a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        PlayerControlWidget r102 = this.f118833a;
        if (r102.f118606h == false) goto L6;
        r102.f118606h = false;
        return;
    L6:
        if ((!Intrinsics.areEqual(r101, Boolean.TRUE)) == true) goto L11;
        this.f118833a.Iq();
        return;
    }
}
