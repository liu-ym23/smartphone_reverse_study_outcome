package com.bytedance.android.livesdk.chatroom.tetris.vr;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceControlDialogLandscape f111930a;

    public j(VrAudienceControlDialogLandscape r100) {
        this.f111930a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        VrAudienceControlDialogLandscape r101 = this.f111930a;
        boolean r102 = ((Boolean) r100).booleanValue();
        int r103 = VrAudienceControlDialogLandscape.f111853o;
        r101.V90(r102);
    }
}
