package com.bytedance.android.live.revenue.platform.log.impl.filterimpl;

import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.y;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mz0.e;

/* JADX INFO: loaded from: classes47.dex */
public class a implements e<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<Object> f91483a;

    @Override // mz0.e
    public final Map<String, String> getMap() {
        return this.f91483a.getMap();
    }

    public final void n() {
        Intrinsics.checkNotNullParameter("lottery_id", "key");
        this.f91483a.remove("lottery_id");
    }

    public a(o<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        this.f91483a = r100;
    }

    @Override // mz0.e
    public final void c(y r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f91483a.setData(r100);
    }

    public final void h(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f91483a.a(r100);
    }

    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f91483a.c(r100, r101);
    }
}
