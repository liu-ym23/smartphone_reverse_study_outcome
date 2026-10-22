package com.bytedance.android.monitorV2.settings;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, c<?>> f163226a;

    public h() {
        this.f163226a = new ConcurrentHashMap();
    }

    public final <T> void a(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        b r102 = new b(r101);
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        c r103 = (c) ((ConcurrentHashMap) this.f163226a).get(r100);
        if (r103 == null) goto L12;
        if (r103 != r102) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        r103.release();
        goto L12
    L6:
        r104 = false;
    L12:
        ((ConcurrentHashMap) this.f163226a).put(r100, r102);
    }
}
