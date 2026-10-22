package com.bytedance.android.shopping.anchorv4.nav;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4NavArea f167111a;

    public a(AnchorV4NavArea r100) {
        this.f167111a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f167111a.getCloseListener();
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}
