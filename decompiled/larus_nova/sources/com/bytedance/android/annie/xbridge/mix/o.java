package com.bytedance.android.annie.xbridge.mix;

import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class o extends le7.a<Object> {
    public final PlatformType M;
    public final Object N;
    public final String O;

    @Override // le7.a
    public final Object b() {
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

    public o(CallContext r100, Map<String, ? extends Object> r101, String r102) {
        super(r102);
        List<String> r103 = s.f40190a;
        if ((r100.f249269d instanceof WebView) == false) goto L5;
        PlatformType r104 = PlatformType.WEB;
    L6:
        this.M = r104;
        this.N = r101;
        String r105 = r100.f249267b;
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        this.O = r105;
        return;
    L5:
        r104 = PlatformType.LYNX;
        goto L6
    }
}
