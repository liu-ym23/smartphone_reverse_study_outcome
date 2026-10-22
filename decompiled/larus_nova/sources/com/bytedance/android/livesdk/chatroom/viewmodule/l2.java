package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class l2 implements Consumer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewFullVideoButtonWidget f115307a;

    public l2(NewFullVideoButtonWidget r100) {
        this.f115307a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Boolean r100) throws Exception {
        Boolean r101 = r100;
        NewFullVideoButtonWidget r102 = this.f115307a;
        r102.yq();
        if (r102.f114997f == false) goto L22;
        long r103 = System.currentTimeMillis();
        if ((r103 - r102.f115015x) >= 500) goto L8;
        r102.f115015x = r103;
        r102.f115006o.setVisibility(8);
        return;
    L8:
        r102.f115015x = r103;
        if (r101.booleanValue() == true) goto L11;
        r102.Fq(false);
        return;
    L11:
        if (r102.f115006o.getVisibility() == 0) goto L13;
        boolean r104 = true;
    L14:
        r102.f115006o.setVisibility(0);
        if (r104 == false) goto L17;
        ut1.h.c();
    L17:
        r102.Fq(true);
        return;
    L13:
        r104 = false;
        goto L14
    }
}
