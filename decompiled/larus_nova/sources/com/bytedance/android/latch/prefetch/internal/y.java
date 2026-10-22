package com.bytedance.android.latch.prefetch.internal;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class y implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f58495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f58496b;

    public y(ProcessManager r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "processManager");
        Intrinsics.checkNotNullParameter(r101, "configManager");
        this.f58495a = r100;
        this.f58496b = r101;
        final WeakReference r102 = null;
        r101.b(new PrefetchHandler$1(this, r102));
    }

    @Override // com.bytedance.android.latch.prefetch.internal.j
    public final t b(String r100, com.bytedance.android.latch.a.b r101) {
        Intrinsics.checkNotNullParameter(r100, "pageUrl");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        k r102 = n.f58484a;
        n.a("Start prefetch, page url: " + r100);
        t r103 = this.f58496b.a(new UriWrapper(r100), r101);
        if (r103 != null) goto L6;
        String r104 = "No config found for page " + r100 + ", skipping...";
        Intrinsics.checkNotNullParameter(r104, "message");
        n.f58484a.onLog(r104);
        return null;
    L6:
        return r103;
    }

    @Override // com.bytedance.android.latch.prefetch.internal.j
    public final void a(String r110, t r111, com.bytedance.android.latch.a.b r112, o r113) {
        Intrinsics.checkNotNullParameter(r110, "pageUrl");
        Intrinsics.checkNotNullParameter(r111, "config");
        Intrinsics.checkNotNullParameter(r112, "dataHolder");
        Intrinsics.checkNotNullParameter(r113, "bridge");
        UriWrapper r100 = new UriWrapper(r110);
        Map<String, d0> r101 = r111.f58490b;
        JSONObject r114 = r111.f58491c;
        SortedMap r102 = (SortedMap) r100.f58444d.getValue();
        this.f58495a.a();
        Iterator<Map.Entry<String, d0>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, d0> r104 = r103.next();
        l r105 = this.f58495a;
        d0 r106 = r104.getValue();
        String r107 = z.a(r114, r104.getKey());
        if (r107 != null) goto L8;
        r107 = "0";
    L8:
        r105.b(r110, r102, r112, r113, r106, r107);
        goto L4
    }
}
