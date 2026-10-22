package com.bytedance.android.livesdk.interactivity.seek;

import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f140779a;

    public a(b r100) {
        this.f140779a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Object r101 = sh6.c.b((sh6.b) r100);
        if (r101 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.b r102 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.b) r101;
        long r103 = r102.f118398b - r102.f118397a;
        b r104 = this.f140779a;
        if (r103 <= r104.f140785f) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L16;
        if (r104.f140786g == true) goto L24;
        r104.f140786g = true;
        Iterator<jc1.h> r106 = r104.f140780a.iterator();
    L13:
        if (r106.hasNext() == false) goto L26;
        r106.next().g(true);
        goto L13
    L26:
        return;
    L24:
        return;
    L16:
        if (r104.f140786g == false) goto L25;
        r104.f140786g = false;
        Iterator<jc1.h> r107 = r104.f140780a.iterator();
    L19:
        if (r107.hasNext() == false) goto L27;
        r107.next().g(false);
        goto L19
    L27:
        return;
    L25:
        return;
    L7:
        r105 = false;
        goto L8
    }
}
