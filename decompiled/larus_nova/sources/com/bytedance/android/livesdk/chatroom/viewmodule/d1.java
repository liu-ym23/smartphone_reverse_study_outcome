package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class d1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f115235a;

    public d1(f1 r100) {
        this.f115235a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1<Long, Unit> r101 = this.f115235a.f115249c;
        long r102 = ((Long) r100).longValue();
        f1 r103 = this.f115235a;
        r101.invoke(Long.valueOf(r102 * r103.f115251e.toSeconds(r103.f115250d)));
    }
}
