package com.bytedance.android.livesdk.widget;

import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.utils.h4;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class k1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveThumbProcessViewHolder f161780a;

    public k1(LiveThumbProcessViewHolder r100) {
        this.f161780a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (LiveThumbProcessViewHolder.c(this.f161780a) == true) goto L7;
        TextView r102 = (TextView) this.f161780a.f161102e.getValue();
        int r103 = h4.f114490a;
        r102.setText(h4.a(r101.longValue()));
        return;
    }
}
