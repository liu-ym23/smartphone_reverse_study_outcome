package com.bytedance.android.livesdk.dslservice.util.jsb;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends le7.a<ReadableMap> {
    public final ReadableMap M;
    public final PlatformType N;
    public final String O;
    public final ReadableMap P;

    @Override // le7.a
    public final ReadableMap b() {
        return this.M;
    }

    @Override // le7.a
    public final PlatformType c() {
        return this.N;
    }

    @Override // le7.a
    public final String d() {
        return this.O;
    }

    public e(String r100, JavaOnlyMap r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter("", "pageUrl");
        super(r100);
        this.P = r101;
        if (r101 != null) goto L5;
        r101 = new JavaOnlyMap();
    L5:
        this.M = r101;
        this.N = PlatformType.LYNX;
        this.O = "";
    }
}
