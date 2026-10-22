package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f130795a = null;

    static {
        f130795a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        boolean r101 = GiftEffectManager.f130729a;
        boolean r102 = ((tq2.d) r100).f547125a;
        GiftEffectManager.f130732d = r102;
        if (r102 == false) goto L10;
        WeakReference<DataCenter> r103 = GiftEffectManager.f130730b;
        if (r103 == null) goto L11;
        DataCenter r104 = r103.get();
        if (r104 == null) goto L12;
        r104.put("cmd_clear_gift_message", new Object());
        return;
    L12:
        return;
    L11:
        return;
    }
}
