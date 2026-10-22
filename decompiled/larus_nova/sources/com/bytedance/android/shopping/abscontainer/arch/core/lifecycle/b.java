package com.bytedance.android.shopping.abscontainer.arch.core.lifecycle;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f164136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f164137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.event.common.e f164138c;

    public b(String r100, Map<String, ? extends Object> r101, com.bytedance.kmp.ec.yata.event.common.e r102) {
        Intrinsics.checkNotNullParameter(r102, "eventInput");
        this.f164136a = r100;
        this.f164137b = r101;
        this.f164138c = r102;
    }
}
