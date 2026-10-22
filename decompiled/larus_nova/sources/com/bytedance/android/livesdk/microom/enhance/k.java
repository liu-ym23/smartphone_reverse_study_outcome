package com.bytedance.android.livesdk.microom.enhance;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MicRoomCenterCountDownWidget f153869a;

    public k(MicRoomCenterCountDownWidget r100) {
        this.f153869a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        TextView r102 = this.f153869a.f153819a;
        if (r102 == null) goto L9;
        if (r101 == null) goto L6;
        String r103 = String.valueOf(r101.longValue());
    L7:
        r102.setText(r103);
        return;
    L6:
        r103 = null;
        goto L7
    }
}
