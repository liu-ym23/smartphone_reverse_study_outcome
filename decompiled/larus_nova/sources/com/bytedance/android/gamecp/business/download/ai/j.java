package com.bytedance.android.gamecp.business.download.ai;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f52489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f52490b;

    public j(List r100, Map r101) {
        this.f52489a = r100;
        this.f52490b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        if (r101 == null) goto L22;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L32;
        com.bytedance.android.gamecp.host_api.model.j r103 = (com.bytedance.android.gamecp.host_api.model.j) r102.next();
        String r104 = r103.f57396a;
        int r105 = r104.hashCode();
        if (r105 != 108957) goto L10;
        if (r104.equals(com.alipay.sdk.m.k.b.f25406k) == false) goto L21;
        this.f52489a.add(r103);
    L21:
        throw new IllegalArgumentException("SimpleGameInfo 没有指定 from 参数");
    L10:
        if (r105 != 103145323) goto L21;
        if (r104.equals("local") == false) goto L21;
        Map r106 = this.f52490b;
        String r107 = r103.gameId;
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        r106.put(r107, r103);
        goto L6
    L32:
        return;
    }
}
