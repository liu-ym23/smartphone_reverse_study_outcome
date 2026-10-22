package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import ju1.n;

/* JADX INFO: loaded from: classes7.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShortTermStateDynamicShowFramework f106642a;

    public i(ShortTermStateDynamicShowFramework r100) {
        this.f106642a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        bu0.a r101 = (bu0.a) r100;
        ALogger.i("ShortTermStateDynamicShowFramework", "redpack count = " + r101.f20721b);
        DataCenter r102 = this.f106642a.f106615f;
        if (r102 != null) goto L5;
    L24:
        this.f106642a.f106612c = r101.f20720a;
        return;
    L5:
        if (z.e(r102, false) == true) goto L24;
        PropertyOwner<n> r103 = this.f106642a.f106610a;
        if (r103 == null) goto L11;
        n r104 = r103.f64752a;
        if (r104 == null) goto L11;
        Integer r105 = Integer.valueOf(r104.b(0));
    L12:
        if (r105 != null) goto L15;
    L17:
        DataCenter r106 = this.f106642a.f106615f;
        if (r106 == null) goto L24;
        Long r107 = r101.f20721b;
        if (r107 == null) goto L22;
        long r108 = r107.longValue();
    L23:
        r106.put("data_redpack_interest_count", Long.valueOf(r108));
        goto L24
    L22:
        r108 = 0;
        goto L23
    L15:
        if (r105.intValue() != 1) goto L17;
        ShortTermStateDynamicShowFramework.a(this.f106642a, "short_touch_tempstate_redpack_behavior", r105);
    L11:
        r105 = null;
        goto L12
    }
}
