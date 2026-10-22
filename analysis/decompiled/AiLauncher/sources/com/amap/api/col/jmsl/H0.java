package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* loaded from: classes.dex */
public class H0 extends Q1<String, Integer> {

    /* renamed from: E, reason: collision with root package name */
    public Context f16095E;

    /* renamed from: F, reason: collision with root package name */
    public String f16096F;

    public H0(Context context, String str) {
        super(context, str);
        this.f16095E = context;
        this.f16096F = str;
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.g(this.f16095E) + "/nearby/data/delete";
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16095E));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f16096F);
        return stringBuffer.toString();
    }
}
