package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.revlink.impl.settings.dynamic.LinkMultiDynamicSettingsKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f96490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c f96491b;

    public l(MediatorLiveData r100, com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r101) {
        this.f96490a = r100;
        this.f96491b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (LinkMultiDynamicSettingsKt.a() <= 0) goto L9;
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
    L8:
        if ((r102 % LinkMultiDynamicSettingsKt.a()) == 0) goto L9;
        return;
    L6:
        r102 = 0;
    L9:
        MediatorLiveData r103 = this.f96490a;
        JSONObject r104 = new JSONObject();
        r104.put("remain_time", r101.intValue());
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r105 = this.f96491b.f96458e.getValue();
        if (r105 == null) goto L12;
        Integer r106 = Integer.valueOf(r105.f96579b);
    L13:
        r104.put("state", r106);
        Unit r107 = Unit.INSTANCE;
        r103.setValue(r104);
        return;
    L12:
        r106 = null;
        goto L13
    }
}
