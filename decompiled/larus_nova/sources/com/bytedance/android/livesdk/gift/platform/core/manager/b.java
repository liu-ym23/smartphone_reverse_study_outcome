package com.bytedance.android.livesdk.gift.platform.core.manager;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.gift.configmodel.z1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f130792a = null;

    static {
        f130792a = new b();
    }

    public b() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (((z1) com.bytedance.android.livesdk.gift.platform.core.g.f130523c.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.f130521a[1])).a() == true) goto L5;
        ay1.d.f16730d.setValue(null, ay1.d.f16727a[5], Boolean.TRUE);
    L5:
        WeakReference<DataCenter> r102 = GiftEffectManager.f130730b;
        if (r102 == null) goto L11;
        DataCenter r103 = r102.get();
        if (r103 == null) goto L12;
        r103.put("cmd_toggle_gift_video_view", Boolean.valueOf(ay1.d.b()));
        return;
    L12:
        return;
    }
}
