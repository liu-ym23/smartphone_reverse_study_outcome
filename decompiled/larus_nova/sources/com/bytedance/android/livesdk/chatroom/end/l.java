package com.bytedance.android.livesdk.chatroom.end;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCoverStreamPlayView f106084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f106085b;

    public l(LiveCoverStreamPlayView r100, LifecycleOwner r101) {
        this.f106084a = r100;
        this.f106085b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        this.f106084a.R5();
    }
}
