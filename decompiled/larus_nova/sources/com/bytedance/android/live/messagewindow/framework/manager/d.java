package com.bytedance.android.live.messagewindow.framework.manager;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f83125a;

    public d(a.e r100) {
        this.f83125a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        a r102 = this.f83125a.f83120c;
        String r103 = "getTargetViewLayoutEvent " + this.f83125a.hashCode();
        int r104 = a.f83112d;
        r102.getClass();
        a.a(r103);
    }
}
