package com.bytedance.android.live.liveinteract.voicechat.match.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatMatchDialog f80384a;

    public l(ChatMatchDialog r100) {
        this.f80384a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ChatMatchDialog r101 = this.f80384a;
        boolean r102 = Intrinsics.areEqual((Boolean) r100, Boolean.TRUE);
        int r103 = ChatMatchDialog.V;
        r101.ba0(r102);
    }
}
