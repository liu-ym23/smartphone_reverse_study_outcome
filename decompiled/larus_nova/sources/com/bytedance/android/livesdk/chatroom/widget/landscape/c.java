package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeQuickRecordWidget f119068a;

    public c(LandscapeQuickRecordWidget r100) {
        this.f119068a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        LandscapeQuickRecordWidget r102 = this.f119068a;
        if (r101 == null) goto L5;
        PadOrientation r103 = (PadOrientation) sh6.c.b(r101);
    L7:
        if (r103 == PadOrientation.LANDSCAPE) goto L9;
        boolean r104 = true;
    L10:
        boolean r105 = LandscapeQuickRecordWidget.f118927j;
        r102.xq(r104);
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = null;
        goto L7
    }
}
