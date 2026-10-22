package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGiftMenuStickerServiceWidget f119151a;

    public o0(LiveGiftMenuStickerServiceWidget r100) {
        this.f119151a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        zg1.p r101 = (zg1.p) r100;
        if (Intrinsics.areEqual(r101.f571903a, "zongyiyouxi") == true) goto L5;
        return;
    L5:
        if (r101.f571905c == true) goto L13;
        LiveGiftMenuStickerServiceWidget r102 = this.f119151a;
        List<LiveGiftMenuStickerServiceWidget.a> r103 = r102.f118523b;
        ArrayList r104 = new ArrayList();
        Iterator r105 = ((ArrayList) r103).iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if (((LiveGiftMenuStickerServiceWidget.a) r106).f118531b == false) goto L8;
        r104.add(r106);
        goto L8
    L12:
        ((ArrayList) r102.f118523b).clear();
        ((ArrayList) r102.f118523b).addAll(r104);
    L13:
        List<LiveGiftMenuStickerServiceWidget.a> r107 = this.f119151a.f118523b;
        ArrayList r108 = (ArrayList) r107;
        r108.add(new LiveGiftMenuStickerServiceWidget.a(r101));
        this.f119151a.zq();
    }
}
