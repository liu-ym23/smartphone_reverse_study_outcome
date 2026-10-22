package com.bytedance.android.livesdk.chatroom.progressbar.service;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements rk1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, IPlayerProgressService> f107821a;

    public a() {
        this.f107821a = new LinkedHashMap();
    }

    @Override // rk1.a
    public final void E5(DataCenter r100) {
        if (r100 == null) goto L4;
        int r101 = r100.hashCode();
    L5:
        this.f107821a.remove(Integer.valueOf(r101));
        return;
    L4:
        r101 = 0;
        goto L5
    }

    @Override // rk1.a
    public final IPlayerProgressService M4(DataCenter r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Map<Integer, IPlayerProgressService> r101 = this.f107821a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        IPlayerProgressService r103 = (IPlayerProgressService) r102.get(Integer.valueOf(r100.hashCode()));
        if (r103 != null) goto L9;
        PlayerProgressService r104 = new PlayerProgressService();
        this.f107821a.put(Integer.valueOf(r100.hashCode()), r104);
        return r104;
    L9:
        return r103;
    }
}
