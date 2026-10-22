package com.amap.api.col.jmsl;

import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public final class J2 extends s7 {

    /* renamed from: z, reason: collision with root package name */
    public String f16144z;

    /* renamed from: y, reason: collision with root package name */
    public Map<String, String> f16143y = new HashMap();

    /* renamed from: A, reason: collision with root package name */
    public Map<String, String> f16142A = new HashMap();

    public final void c(Map<String, String> map) {
        this.f16143y.clear();
        this.f16143y.putAll(map);
    }

    public final void d(String str) {
        this.f16144z = str;
    }

    public final void e(Map<String, String> map) {
        this.f16142A.clear();
        this.f16142A.putAll(map);
    }

    @Override // com.amap.api.col.jmsl.s7
    public final Map<String, String> getParams() {
        return this.f16142A;
    }

    @Override // com.amap.api.col.jmsl.s7
    public final Map<String, String> getRequestHead() {
        return this.f16143y;
    }

    @Override // com.amap.api.col.jmsl.s7
    public final String getURL() {
        return this.f16144z;
    }
}
