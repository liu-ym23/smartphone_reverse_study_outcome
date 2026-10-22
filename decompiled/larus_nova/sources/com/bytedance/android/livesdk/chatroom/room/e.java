package com.bytedance.android.livesdk.chatroom.room;

import com.bytedance.android.livesdk.config.s90;
import io.reactivex.functions.Consumer;
import zg1.t1;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f111085a;

    public e(c r100) {
        this.f111085a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        t1 r101 = (t1) r100;
        c r102 = this.f111085a;
        r102.getClass();
        if (r101 == null) goto L17;
        int r103 = r101.f571943a;
        if (r103 != 1) goto L8;
        r102.f110984h.setValue(Boolean.TRUE);
        r102.f110981e = true;
        return;
    L8:
        if (r103 == 2) goto L11;
        return;
    L11:
        if (s90.f121191a.getValue().booleanValue() == true) goto L19;
        r102.c(true, false);
        return;
    L19:
        return;
    }
}
