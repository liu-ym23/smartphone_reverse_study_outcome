package com.bytedance.android.live.profit.dress;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f87137a = null;

    static {
        f87137a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        List<? extends p> r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "list");
        if ((!r101.isEmpty()) == false) goto L8;
        j.f87120c.a(r101);
        j.f87121d.getClass();
        String r102 = i.f87117c;
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        j.f87125h = r102;
    L8:
        jy0.b.d("DressRepository", "loaded " + r101.size() + " models from storage, version=" + j.f87125h);
        return j.f87125h;
    }
}
