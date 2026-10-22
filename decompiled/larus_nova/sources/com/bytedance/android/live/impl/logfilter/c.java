package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.livesdk.log.filter.v;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<f> f69212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f69213b = null;

    public c() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f69213b = new c();
        f69212a = new CopyOnWriteArraySet();
    }

    public static void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        CopyOnWriteArraySet<f> r101 = f69212a;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Iterator<T> r102 = f69212a.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        f r103 = (f) r102.next();
        if (r103 == null) goto L4;
        r103.onEvent(r100, r101);
        goto L4
    }
}
