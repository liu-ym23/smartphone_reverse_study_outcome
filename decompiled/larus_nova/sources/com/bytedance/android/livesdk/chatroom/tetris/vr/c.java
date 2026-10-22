package com.bytedance.android.livesdk.chatroom.tetris.vr;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceControlDialog f111918a;

    public c(VrAudienceControlDialog r100) {
        this.f111918a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        VrAudienceControlDialog r101 = this.f111918a;
        boolean r102 = ((Boolean) r100).booleanValue();
        int r103 = VrAudienceControlDialog.M;
        r101.Y0(r102);
    }
}
