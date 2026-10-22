package com.amap.api.col.jmsl;

import android.webkit.WebResourceResponse;
import java.io.InputStream;

/* renamed from: com.amap.api.col.jmsl.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1591p0 extends WebResourceResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f16793a;

    /* renamed from: b, reason: collision with root package name */
    public String f16794b;

    public C1591p0(String str, String str2, InputStream inputStream) {
        super(str, str2, inputStream);
    }

    public void a(int i10) {
        this.f16793a = i10;
    }

    public void b(String str) {
        this.f16794b = str;
    }

    @Override // android.webkit.WebResourceResponse
    public String getReasonPhrase() {
        return this.f16794b;
    }

    @Override // android.webkit.WebResourceResponse
    public int getStatusCode() {
        return this.f16793a;
    }
}
