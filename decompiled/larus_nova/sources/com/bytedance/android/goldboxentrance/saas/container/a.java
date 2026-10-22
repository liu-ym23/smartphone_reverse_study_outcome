package com.bytedance.android.goldboxentrance.saas.container;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f58113a;

    public a(Function0 r100) {
        this.f58113a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        Function0 r101 = this.f58113a;
        if (r101 == null) goto L5;
        Unit r102 = (Unit) r101.invoke();
    L5:
        ALogger.d("GoldCoinEntranceWidget", "load hybrid card success.");
    }
}
