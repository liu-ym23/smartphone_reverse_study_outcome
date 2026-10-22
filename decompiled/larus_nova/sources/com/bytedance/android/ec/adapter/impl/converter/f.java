package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements IExternalMessageListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ td.a f42783a;

    public f(td.a r100) {
        this.f42783a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        td.a r101 = this.f42783a;
        if ((r100 instanceof ce.a) == false) goto L6;
        ee.a r102 = new ee.b((ce.a) r100);
    L9:
        r101.f(r102, false);
        return;
    L6:
        if ((r100 instanceof com.bytedance.android.ec.adapter.impl.messagev2.a) == false) goto L8;
        r102 = (ee.a) r100;
        goto L9
    L8:
        r102 = null;
        goto L9
    }
}
