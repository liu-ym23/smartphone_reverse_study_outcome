package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f119469a;

    public n(o r100) {
        this.f119469a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        o r102 = this.f119469a;
        if (r102.f119477g0 == true) goto L13;
        int r103 = ClearScreenConst$InteractType.INTERACT_SHOW.getId();
        if (r101 != null) goto L8;
    L9:
        boolean r104 = true;
    L11:
        r102.f119475e0 = r104;
        return;
    L8:
        if (r101.intValue() != r103) goto L9;
        r104 = false;
        goto L11
    }
}
