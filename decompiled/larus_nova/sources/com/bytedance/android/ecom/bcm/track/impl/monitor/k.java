package com.bytedance.android.ecom.bcm.track.impl.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o> f51118a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, k> f51119a = null;

        static {
            f51119a = new ConcurrentHashMap();
        }
    }

    public k(List r100) {
        List r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(new o((com.bytedance.android.ecom.bcm.track.impl.setting.h) r103.next()));
        goto L4
    L6:
        this.f51118a = r102;
    }
}
