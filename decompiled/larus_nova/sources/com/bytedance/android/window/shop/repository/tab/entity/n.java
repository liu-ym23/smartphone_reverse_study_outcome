package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f189604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f189605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f189606l;

    public n(f r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "second");
        ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Integer>> r102 = com.bytedance.android.window.shop.holder.factory.c.f187943a;
        int r103 = r100.f189560i;
        int r104 = r101.f189560i;
        ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Integer>> r105 = com.bytedance.android.window.shop.holder.factory.c.f187943a;
        ConcurrentHashMap<Integer, Integer> r106 = r105.get(Integer.valueOf(r103));
        if (r106 != null) goto L5;
        r106 = new ConcurrentHashMap();
        r105.put(Integer.valueOf(r103), r106);
    L5:
        Integer r107 = r106.get(Integer.valueOf(r104));
        if (r107 != null) goto L8;
        r107 = Integer.valueOf(com.bytedance.android.window.shop.holder.factory.c.f187947e.getAndIncrement());
        r106.put(Integer.valueOf(r104), r107);
        com.bytedance.android.window.shop.holder.factory.c.f187944b.put(r107, TuplesKt.to(Integer.valueOf(r103), Integer.valueOf(r104)));
    L8:
        super(r107.intValue());
        this.f189605k = r100;
        this.f189606l = r101;
        int r108 = 1;
        if ((r100 instanceof n) == false) goto L11;
        int r109 = ((n) r100).f189604j;
    L13:
        if ((r101 instanceof n) == false) goto L15;
        r108 = ((n) r101).f189604j;
    L15:
        this.f189604j = r109 + r108;
        return;
    L11:
        r109 = 1;
        goto L13
    }
}
