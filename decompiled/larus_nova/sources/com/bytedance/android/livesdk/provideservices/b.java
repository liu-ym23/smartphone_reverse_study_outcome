package com.bytedance.android.livesdk.provideservices;

import android.view.KeyEvent;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.livesdk.config.h50;
import com.bytedance.android.livesdkapi.depend.live.IEventService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements IEventService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f156773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DataCenter f156774b;

    public b() {
    }

    public static b a() {
        if (f156773a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f156773a != null) goto L9;
        f156773a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f156773a;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IEventService
    public final void postChargeEvent() {
        ((IRechargeServiceExternal) jc1.k.f(IRechargeServiceExternal.class)).rechargeCenter().sync("other");
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IEventService
    public final void bindDataCenter(ViewModel r100) {
        if ((r100 instanceof DataCenter) == false) goto L6;
        f156774b = (DataCenter) r100;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IEventService
    public final boolean postKeyEvent(int r100, int r101, KeyEvent r102) {
        xs2.b.a().post(new com.bytedance.android.livesdk.event.a(r100, r101, r102));
        boolean r103 = h50.f120342a.getValue().booleanValue();
        DataCenter r104 = f156774b;
        if (r104 == null) goto L5;
        boolean r105 = ((Boolean) r104.get("data_is_portrait", Boolean.TRUE)).booleanValue();
    L6:
        if (r103 == false) goto L9;
        if (r105 == true) goto L9;
        return true;
    L9:
        return false;
    L5:
        r105 = true;
        goto L6
    }
}
