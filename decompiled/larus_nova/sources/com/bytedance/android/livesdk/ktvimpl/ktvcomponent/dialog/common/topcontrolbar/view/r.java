package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoChorusTopBarControlContainer f144207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c f144208b;

    public r(VideoChorusTopBarControlContainer r100, com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r101) {
        this.f144207a = r100;
        this.f144208b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r102 = this.f144208b;
        if (r102 == null) goto L10;
        jd2.c r103 = r102.f();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.f498226a != 2) goto L12;
        VideoChorusTopBarControlContainer r104 = this.f144207a;
        r104.l(VideoChorusTopBarControlContainer.h(r104), VideoChorusTopBarControlContainer.i(this.f144207a));
        return;
    L12:
        return;
    }
}
