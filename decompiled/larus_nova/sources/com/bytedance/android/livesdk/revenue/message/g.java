package com.bytedance.android.livesdk.revenue.message;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<vlc.l>> f157182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f157183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.platform.bytelink.d f157184c;

    public g(com.ss.ugc.live.sdk.platform.bytelink.f r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f157184c = r100;
        this.f157182a = new LinkedHashMap();
        this.f157183b = new f(this);
    }

    @Override // com.bytedance.android.livesdk.revenue.message.a
    public final void a(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        List r102 = (List) ((LinkedHashMap) this.f157182a).get(r100);
        if (r102 == null) goto L8;
        r102.remove(r101);
        if (r102.size() != 0) goto L9;
        this.f157184c.m(r100, this.f157183b);
        this.f157182a.remove(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.message.a
    public final void b(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        List<vlc.l> r102 = (List) ((LinkedHashMap) this.f157182a).get(r100);
        if (r102 != null) goto L5;
        r102 = new ArrayList();
    L5:
        r102.add(r101);
        this.f157182a.put(r100, r102);
        if (r102.size() != 1) goto L9;
        this.f157184c.d(r100, this.f157183b);
        return;
    }
}
