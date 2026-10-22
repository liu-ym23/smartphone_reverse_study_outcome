package com.bytedance.android.livesdk.chatroom.end;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCoverStreamPlayView f106068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f106069b;

    public h(LiveCoverStreamPlayView r100, LifecycleOwner r101) {
        this.f106068a = r100;
        this.f106069b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        LiveCoverStreamPlayView r102 = this.f106068a;
        if (r101 == null) goto L5;
        boolean r103 = r101.booleanValue();
    L6:
        r102.f105914c = r103;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
