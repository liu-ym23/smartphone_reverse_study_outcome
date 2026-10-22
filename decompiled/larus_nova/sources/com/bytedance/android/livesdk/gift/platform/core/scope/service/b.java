package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.CleanDataSource;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssetsDeleteGlobalService f131465a;

    public b(AssetsDeleteGlobalService r100) {
        this.f131465a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((Map) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        Map.Entry r103 = (Map.Entry) r102.next();
        long r104 = ((Number) r103.getKey()).longValue();
        com.bytedance.android.live.core.resources.e r105 = (com.bytedance.android.live.core.resources.e) r103.getValue();
        Long r106 = Long.valueOf(r104);
        String r107 = r105.getMD5();
        com.bytedance.android.live.core.resources.j r108 = r105.getH265ResourceModel();
        String r109 = null;
        if (r108 == null) goto L8;
        String r110 = r108.getMd5();
    L9:
        com.bytedance.android.live.core.resources.k r111 = r105.getH265SuperResourceModel();
        if (r111 == null) goto L12;
        r109 = r111.getMd5();
    L12:
        r101.put(r106, new com.bytedance.android.livesdk.gift.platform.business.effect.assets.a(r107, r110, r109));
        goto L4
    L8:
        r110 = null;
        goto L9
    L13:
        this.f131465a.a(r101, CleanDataSource.NET);
    }
}
