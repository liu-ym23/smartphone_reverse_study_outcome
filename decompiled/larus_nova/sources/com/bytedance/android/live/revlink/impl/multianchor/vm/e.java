package com.bytedance.android.live.revlink.impl.multianchor.vm;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkingInvitePreloadUtils f95048a;

    public e(LinkingInvitePreloadUtils r100) {
        this.f95048a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LinkingInvitePreloadUtils r102 = this.f95048a;
        if (r102.f95033i == false) goto L6;
        return;
    L6:
        if (r102.h().length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L15;
        LinkingInvitePreloadUtils r104 = this.f95048a;
        Disposable r105 = r104.f95032h;
        if (r105 == null) goto L13;
        r105.dispose();
    L13:
        r104.f95033i = true;
        return;
    L15:
        return;
    L8:
        r103 = false;
        goto L9
    }
}
