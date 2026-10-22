package com.bytedance.android.live.core.tetris.widgets.cache;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> f65979a;

    public void a() {
        Map<String, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> r100 = this.f65979a;
        if (r100 == null) goto L13;
        Collection r101 = ((LinkedHashMap) r100).values();
        if (r101 == null) goto L13;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        Iterator r103 = ((Map) r102.next()).values().iterator();
    L11:
        if (r103.hasNext() == false) goto L8;
        ((com.bytedance.android.live.core.tetris.widgets.a) r103.next()).clearAfterDestroyed();
    L13:
        ((LinkedHashMap) this.f65979a).clear();
    }

    public h() {
        this.f65979a = new LinkedHashMap();
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        int r101 = b.f65961a;
        Map<String, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> r102 = this.f65979a;
        Intrinsics.checkNotNullParameter(r102, "cache");
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        if (MultiRoomConfig.INSTANCE.enableComponentCacheFullLog() == false) goto L15;
        Iterator r103 = ((LinkedHashMap) r102).entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L18;
        Map.Entry r104 = (Map.Entry) r103.next();
        StringBuilder r105 = new StringBuilder("Cache is ");
        r105.append(r100);
        r105.append(" , ");
        r105.append((String) r104.getKey());
        r105.append(" , size = ");
        Map r106 = (Map) r104.getValue();
        if (r106 == null) goto L10;
        Integer r107 = Integer.valueOf(r106.size());
    L11:
        r105.append(r107.intValue());
        ALogger.i("ComponentCacheLog", r105.toString());
        Iterator r108 = ((Map) r104.getValue()).entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L6;
        ALogger.i("ComponentCacheLog", "Cache is " + r100 + " , " + ((com.bytedance.android.live.core.tetris.widgets.a) ((Map.Entry) r108.next()).getValue()).getClass().getName());
        goto L13
    L10:
        r107 = null;
        goto L11
    L18:
        return;
    }

    public final void c(String r100, Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, ? extends com.bytedance.android.live.core.tetris.widgets.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "uniqueID");
        Intrinsics.checkNotNullParameter(r101, "widgets");
        LinkedHashMap r102 = (LinkedHashMap) this.f65979a;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new LinkedHashMap();
        r102.put(r100, r103);
    L5:
        ((Map) r103).putAll(r101);
    }
}
