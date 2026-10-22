package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RTChorusMusicInfoView f146656a;

    public i(RTChorusMusicInfoView r100) {
        this.f146656a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f146656a.y((MidiSkinDressInfo) sh6.c.b((sh6.b) r100));
    }
}
