package com.amap.api.mapcore.util;

import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class c3 extends y7 {
    protected boolean isPostFlag;

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        return null;
    }

    public z7 makeHttpRequestNeedHeader() throws k5 {
        if (b0.f27047f == null) goto L9;
        if (u5.a(b0.f27047f, w3.b()).f28191a == u5.e.f28083b) goto L9;
        return null;
    L9:
        if (MapsInitializer.getProtocol() != 1) goto L11;
        y7.c r100 = y7.c.f28467a;
    L12:
        setHttpProtocol(r100);
        x7 r101 = x7.b(false);
        if (this.isPostFlag == false) goto L16;
        return r101.a(this);
    L16:
        return r101.e(this);
    L11:
        r100 = y7.c.f28468b;
        goto L12
    }

    public byte[] makeHttpRequestWithInterrupted() throws k5 {
        setDegradeAbility(y7.a.f28453b);
        return makeHttpRequest();
    }

    public c3() {
        this.isPostFlag = true;
    }

    public byte[] makeHttpRequest() throws k5 {
        z7 r100 = makeHttpRequestNeedHeader();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f28591a;
    }
}
