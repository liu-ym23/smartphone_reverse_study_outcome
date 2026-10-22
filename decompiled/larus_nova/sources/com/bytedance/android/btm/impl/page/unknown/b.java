package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Object, UnknownPageInfo> f42399a = null;

    static {
        f42399a = Collections.synchronizedMap(new WeakHashMap());
    }

    public static UnknownPageInfo a(Object r100) {
        UnknownPageInfo r101 = c(r100);
        if (UnionBufferQueue.a(r101) == false) goto L5;
        String r102 = r100.getClass().getName();
        Lazy r103 = BtmFormatUtils.f42489a;
        r101.setPageBtm("aUnknown.b" + StringsKt.replace$default(r102, '.', '_', false, 4, null) + ".c0.d0");
    L5:
        return r101;
    }

    public static UnknownPageInfo b(String r100) {
        Object r101 = null;
        if (r100 == null) goto L18;
        Map<Object, UnknownPageInfo> r102 = f42399a;
        monitor-enter(r102);
        Iterator<T> r103 = r102.values().iterator();     // Catch: Throwable -> L15
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();     // Catch: Throwable -> L15
        if (((UnknownPageInfo) r104).getMountBtmIds().contains(r100) == false) goto L8;
        r101 = r104;
    L12:
        UnknownPageInfo r105 = (UnknownPageInfo) r101;     // Catch: Throwable -> L15
        monitor-exit(r102);
        return r105;
    L15:
        th = move-exception;
        throw th;
    L18:
        return null;
    }

    public static UnknownPageInfo c(Object r100) {
        Map<Object, UnknownPageInfo> r101 = f42399a;
        UnknownPageInfo r102 = r101.get(r100);
        if (r102 != null) goto L6;
        UnknownPageInfo r103 = new UnknownPageInfo();
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }
}
