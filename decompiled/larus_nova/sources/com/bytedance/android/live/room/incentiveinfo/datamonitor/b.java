package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorTrafficSupportDataChangeMonitor.b f99674a;

    public b(AnchorTrafficSupportDataChangeMonitor.b r100) {
        this.f99674a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        AnchorTrafficSupportDataChangeMonitor.b r102 = this.f99674a;
        AnchorTrafficSupportDataChangeMonitor r103 = r102.f99638b;
        int r104 = w81.b.f558614e;
        w81.a r105 = r103.f99631i.get(Long.valueOf(r102.f99637a));
        if (r105 != null) goto L5;
        r105 = this.f99674a.f99638b.f99630h;
    L5:
        r103.f(w81.b.a.b(r105));
        AnchorTrafficSupportDataChangeMonitor.b r106 = this.f99674a;
        r106.f99638b.f99635m.put(Long.valueOf(r106.f99637a), Boolean.FALSE);
        AnchorTrafficSupportDataChangeMonitor.b r107 = this.f99674a;
        r107.f99638b.f99631i.remove(Long.valueOf(r107.f99637a));
    }
}
