package com.bytedance.android.livesdk.chatroom.end;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCoverStreamPlayView f106087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f106088b;

    public m(LiveCoverStreamPlayView r100, LifecycleOwner r101) {
        this.f106087a = r100;
        this.f106088b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        this.f106087a.R5();
        return;
    }
}
