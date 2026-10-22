package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.w;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WelfareProjectBottomRightCardWidget f117661a;

    public i(WelfareProjectBottomRightCardWidget r100) {
        this.f117661a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        WelfareProjectBottomRightCardWidget r102 = this.f117661a;
        int r103 = WelfareProjectBottomRightCardWidget.f117640i;
        r102.getClass();
        xs2.b.a().post(new w(false, true, new int[2], 0));
        e r104 = r102.f117648h;
        if (r104 == null) goto L6;
        r104.a();
        return;
    }
}
