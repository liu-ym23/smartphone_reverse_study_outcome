package com.bumptech.glide.load.engine.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PreFillQueue.java */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<d, Integer> f3624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f3625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3627d;

    public c(Map<d, Integer> r4) {
        Map<d, Integer> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.f3624a = r5;
        this.f3625b = new ArrayList(r5.keySet());
        Iterator<Integer> r6 = r5.values().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        this.f3626c += ((Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        goto L4
    }

    public d a() {
        d r0 = (d) ZeusTransformUtils.preCheckCast(this.f3625b.get(this.f3627d), d.class, "com.obric.aiagent.plugin");
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.f3624a.get(r0), Integer.class, "com.obric.aiagent.plugin");
        if (r1.intValue() != 1) goto L5;
        this.f3624a.remove(r0);
        this.f3625b.remove(this.f3627d);
    L6:
        this.f3626c--;
        if (this.f3625b.isEmpty() == false) goto L9;
        int r2 = 0;
    L10:
        this.f3627d = r2;
        return r0;
    L9:
        r2 = (this.f3627d + 1) % this.f3625b.size();
        goto L10
    L5:
        this.f3624a.put(r0, Integer.valueOf(r1.intValue() - 1));
        goto L6
    }

    public boolean b() {
        if (this.f3626c != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
