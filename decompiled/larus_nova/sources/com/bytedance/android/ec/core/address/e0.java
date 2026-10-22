package com.bytedance.android.ec.core.address;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes43.dex */
public final class e0 implements BDLocationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wi.b f43685a;

    public e0(m r100) {
        this.f43685a = r100;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(BDLocationException r100) {
        if (r100 == null) goto L5;
        this.f43685a.onFailure(r100);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r210) {
        ArrayList r100 = new ArrayList();
        Object[] r110 = {r210};
        f06.b r111 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101330);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r103;
        f06.d r107 = r106.preInvoke(101330, "com/bytedance/android/ec/core/address/DefaultLocationHostService$tryToLocate$1", "onLocationChanged", this, r110, "void", r111);     // Catch: Exception -> L23
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L23
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        if (r210 != null) goto L21;
        this.f43685a.onFailure(new Throwable("result is null"));
        return;
    L21:
        this.f43685a.a(new wi.a(r210.getLatitude(), r210.getLongitude()));
        return;
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r103 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }
}
