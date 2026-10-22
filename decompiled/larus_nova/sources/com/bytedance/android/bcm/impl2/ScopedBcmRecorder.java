package com.bytedance.android.bcm.impl2;

import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.util.f;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class ScopedBcmRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ScopedBcmContent> f41887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<f<PageInfo>, ScopedBcmContent> f41888b = null;

    static {
        LinkedHashMap<String, ScopedBcmContent> r100 = new ScopedBcmRecorder$btmMap$1();
        LinkedHashMap<f<PageInfo>, ScopedBcmContent> r101 = new ScopedBcmRecorder$pageInfoMap$1();
        f41887a = Collections.synchronizedMap(r100);
        f41888b = Collections.synchronizedMap(r101);
    }

    public static ScopedBcmContent a(PageInfo r100) {
        Map<f<PageInfo>, ScopedBcmContent> r101 = f41888b;
        f<PageInfo> r102 = new f(r100);
        ScopedBcmContent r103 = r101.get(r102);
        if (r103 != null) goto L6;
        r103 = new ScopedBcmContent();
        r101.put(r102, r103);
    L6:
        return r103;
    }
}
