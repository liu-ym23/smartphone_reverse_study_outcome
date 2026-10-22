package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.view.View;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;

/* JADX INFO: loaded from: classes12.dex */
public final class o implements com.bytedance.android.shopping.anchorv4.bottom.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f166681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventContext f166682b;

    @Override // com.bytedance.android.shopping.anchorv4.bottom.c0
    public final View getIconView() {
        return yp.a.c(this.f166682b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.c0
    public final void onSuccess(boolean r100) {
        this.f166681a.f166687f.s(r100);
    }

    public o(p r100, EventContext r101) {
        this.f166681a = r100;
        this.f166682b = r101;
    }
}
