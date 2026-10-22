package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class b1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f131467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f131468b;

    public b1(d1 r100, Ref.ObjectRef r101) {
        this.f131467a = r100;
        this.f131468b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        d1 r102 = this.f131467a;
        r102.f131508j = 2;
        GiftDataStorageService r103 = (GiftDataStorageService) this.f131468b.element;
        if (r103 == null) goto L5;
        int r104 = r103.f131276p;
    L6:
        if (r104 > 0) goto L9;
        r102.f("GiftListRoomService-Timer");
        return;
    L9:
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
