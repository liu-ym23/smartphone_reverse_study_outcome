package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class u0 implements Consumer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullVideoButtonWidget f117533a;

    public u0(FullVideoButtonWidget r100) {
        this.f117533a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Boolean r100) throws Exception {
        Boolean r101 = r100;
        FullVideoButtonWidget r102 = this.f117533a;
        r102.xq();
        if (r102.f114946d == false) goto L22;
        long r103 = System.currentTimeMillis();
        if ((r103 - r102.f114962t) >= 500) goto L8;
        r102.f114962t = r103;
        r102.f114952j.setVisibility(8);
        return;
    L8:
        r102.f114962t = r103;
        if (r101.booleanValue() == true) goto L11;
        r102.Bq(false);
        return;
    L11:
        if (r102.f114952j.getVisibility() == 0) goto L13;
        boolean r104 = true;
    L14:
        r102.f114952j.setVisibility(0);
        if (r104 == false) goto L17;
        ut1.h.c();
    L17:
        r102.Bq(true);
        return;
    L13:
        r104 = false;
        goto L14
    }
}
