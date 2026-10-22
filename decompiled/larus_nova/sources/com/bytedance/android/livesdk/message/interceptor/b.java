package com.bytedance.android.livesdk.message.interceptor;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements CommonFilterInterceptor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f153529a;

    public b(Map<String, String> r100) {
        this.f153529a = r100;
    }

    @Override // com.bytedance.android.livesdk.message.interceptor.CommonFilterInterceptor.a
    public final String get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (String) this.f153529a.get(r100);
    }
}
