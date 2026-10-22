package com.bytedance.android.livesdk.arch.plugin.biz;

import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILivePreviewBusinessBridge f103832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f103833b;

    public a(ILivePreviewBusinessBridge r100, int r101) {
        this.f103832a = r100;
        this.f103833b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        this.f103832a.sendLogger("livesdk_toolbar_icon_show", new BehaviorPlugin$Unfold$loadBehavior$$inlined$also$lambda$1$1(this));
    }
}
