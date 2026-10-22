package com.bytedance.android.anniex.worker;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends le7.a<ReadableMap> {
    public final PlatformType M;
    public final ReadableMap N;
    public final String O;

    @Override // le7.a
    public final JSONObject a() {
        ReadableMap r100 = this.N;
        JSONObject r101 = null;
        if ((r100 instanceof JavaOnlyMap) == false) goto L5;
        JavaOnlyMap r102 = (JavaOnlyMap) r100;
    L6:
        if (r102 == null) goto L8;
        r101 = r102.toJSONObject();
    L8:
        if (r101 == null) goto L10;
        return r101;
    L10:
        return new JSONObject();
    L5:
        r102 = null;
        goto L6
    }

    @Override // le7.a
    public final ReadableMap b() {
        return this.N;
    }

    @Override // le7.a
    public final PlatformType c() {
        return this.M;
    }

    @Override // le7.a
    public final String d() {
        return this.O;
    }

    public f(String r100, ReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        super(r100);
        this.M = PlatformType.WORKER;
        boolean r102 = false;
        if (r101 != null) goto L23;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        e(r101.getString("namespace"));     // Catch: Exception -> L18
    L11:
        if (r101 != null) goto L13;
    L15:
        if (r102 == false) goto L19;
        r101 = r101.getMap("data");     // Catch: Exception -> L18
    L18:
        r101 = new JavaOnlyMap();
    L19:
        if (r101 != null) goto L21;
        r101 = new JavaOnlyMap();
    L21:
        this.N = r101;
        this.O = "";
        return;
    L13:
        if (r101.hasKey("data") != true) goto L15;
        r102 = true;
        goto L15
    L23:
        if (r101.hasKey("namespace") != true) goto L7;
        r103 = true;
        goto L8
    }
}
