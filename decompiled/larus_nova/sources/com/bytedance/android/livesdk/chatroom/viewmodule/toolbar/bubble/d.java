package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BubbleController f115845a;

    public d(BubbleController r100) {
        this.f115845a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        g.b r101 = (g.b) r100;
        Iterator<T> r102 = this.f115845a.a().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        T r103 = r102.next();
        if (((h) r103).T8().getId() != r101.b()) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L12:
        h r105 = (h) r103;
        if (r105 == null) goto L25;
        i r106 = r105.T8();
        if (r106 == null) goto L26;
        i.a r107 = r106.getCallback();
        if (r107 == null) goto L27;
        r107.b(r106);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }
}
