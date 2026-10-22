package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.live.platformplayer.model.LivePanelType;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f85768a;

    public i(o r100) {
        this.f85768a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i1 r101 = (i1) r100;
        if (r101.f571850b == true) goto L5;
    L7:
        ds0.b r102 = new ds0.b();
        r102.a(LivePanelType.INPUT);
        if (r101.f571850b == false) goto L10;
        String r103 = "open";
    L11:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f469805b = r103;
        r102.f469806c = r101.f571849a;
        this.f85768a.f85780d.c(r102);
        return;
    L10:
        r103 = "close";
        goto L11
    L5:
        if (r101.f571849a != 0) goto L7;
    }
}
