package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f62162a;

    public h(Function1 r100) {
        this.f62162a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f62162a.invoke(r100);
    }
}
