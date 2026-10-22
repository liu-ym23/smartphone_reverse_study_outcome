package com.bytedance.android.live.broadcastgame.opengame.service;

import android.view.View;
import com.bytedance.android.live.broadcastgame.opengame.view.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommercialService f60997a;

    public d(CommercialService r100) {
        this.f60997a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f60997a.f60932d;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke();
    L5:
        u r103 = this.f60997a.f60930b;
        if (r103 == null) goto L9;
        r103.poll();
        return;
    }
}
