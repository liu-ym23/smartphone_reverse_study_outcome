package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class n2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o2 f131652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f131653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f131654c;

    public n2(o2 r100, Ref.LongRef r101, Ref.LongRef r102) {
        this.f131652a = r100;
        this.f131653b = r101;
        this.f131654c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Ref.LongRef r102 = this.f131653b;
        long r103 = r102.element;
        Ref.LongRef r104 = this.f131654c;
        long r105 = r103 - r104.element;
        r102.element = r105;
        long r106 = r104.element;
        if (r105 >= r106) goto L5;
        o2.a(this.f131652a, r106, true);
        return;
    L5:
        o2.a(this.f131652a, r106, false);
    }
}
