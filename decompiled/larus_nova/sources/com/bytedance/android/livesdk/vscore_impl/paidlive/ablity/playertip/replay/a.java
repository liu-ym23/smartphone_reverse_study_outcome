package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.playertip.replay;

import android.view.View;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.i;
import com.bytedance.android.livesdk.vscore_impl.paidlive.f;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidReplayCameraTempWatchPlayerTipView f160310a;

    public a(PaidReplayCameraTempWatchPlayerTipView r100) {
        this.f160310a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        View r102 = this.f160310a.f160292e;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getVisibility() != 0) goto L11;
        i r103 = f.h(this.f160310a.f160296i);
        if (r103 == null) goto L12;
        r103.ca();
        return;
    L12:
        return;
    }
}
