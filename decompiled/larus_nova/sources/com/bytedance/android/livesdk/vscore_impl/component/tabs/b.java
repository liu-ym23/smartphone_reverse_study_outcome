package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseMatchNativeWidget f159942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseMatchNativeWidget$adjustPad$1 f159943b;

    public b(BaseMatchNativeWidget r100, BaseMatchNativeWidget$adjustPad$1 r101) {
        this.f159942a = r100;
        this.f159943b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((PadOrientation) sh6.c.b((sh6.b) r100)) != PadOrientation.PORTRAIT) goto L5;
        boolean r101 = true;
    L6:
        this.f159942a.xq(r101);
        this.f159943b.invoke(r101);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
