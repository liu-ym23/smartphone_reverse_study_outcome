package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.utils.a0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vz1.e f128818a;

    public c(vz1.e r100) {
        this.f128818a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        vz1.e r102 = this.f128818a;
        if (r102 == null) goto L17;
        h1 r103 = r102.f557650a;
        if (r103 == null) goto L18;
        boolean r104 = true;
        if (r103.getBizType() != 1) goto L19;
        int r105 = a0.f132019a;
        Integer r106 = Integer.valueOf(this.f128818a.f557650a.getAfterSendAction());
        if (r106 == null) goto L13;
        r106.intValue();
        if ((r106.intValue() & 2) != 2) goto L13;
    L14:
        if (r104 == false) goto L20;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 6));
        return;
    L20:
        return;
    L13:
        r104 = false;
        goto L14
    L19:
        return;
    L18:
        return;
    }
}
