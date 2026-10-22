package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.jmsl.AbstractC1576l1;
import com.amap.api.col.jmsl.C1569j2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class LocationRequest extends AbstractC1576l1 {

    /* renamed from: o, reason: collision with root package name */
    Map<String, String> f18394o;

    /* renamed from: p, reason: collision with root package name */
    private String f18395p;

    /* renamed from: q, reason: collision with root package name */
    String f18396q;

    /* renamed from: r, reason: collision with root package name */
    String f18397r;

    /* renamed from: s, reason: collision with root package name */
    byte[] f18398s;

    /* renamed from: t, reason: collision with root package name */
    byte[] f18399t;

    /* renamed from: u, reason: collision with root package name */
    boolean f18400u;

    /* renamed from: v, reason: collision with root package name */
    String f18401v;

    /* renamed from: w, reason: collision with root package name */
    Map<String, String> f18402w;

    /* renamed from: x, reason: collision with root package name */
    boolean f18403x;

    public LocationRequest(Context context, C1569j2 c1569j2) {
        super(context, c1569j2);
        this.f18394o = null;
        this.f18395p = "";
        this.f18396q = "";
        this.f18397r = "";
        this.f18398s = null;
        this.f18399t = null;
        this.f18400u = false;
        this.f18401v = null;
        this.f18402w = null;
        this.f18403x = false;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getIPDNSName() {
        return this.f18395p;
    }

    @Override // com.amap.api.col.jmsl.C1, com.amap.api.col.jmsl.s7
    public String getIPV6URL() {
        return this.f18397r;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1, com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        return this.f18402w;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1
    public String getPlatInfo() {
        return this.f18401v;
    }

    public String getPlatinfo() {
        return this.f18401v;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1
    public byte[] getRawDatas() {
        return this.f18398s;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1, com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        return this.f18394o;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1
    public byte[] getRsaAesRawDatas() {
        return this.f18399t;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1, com.amap.api.col.jmsl.s7
    public String getURL() {
        return this.f18396q;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1
    public boolean getXinfoFlag() {
        return this.f18400u;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1576l1
    public boolean isLocRequest() {
        return this.f18403x;
    }

    public void setAesEntity(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                if (bArr != null) {
                    try {
                        byteArrayOutputStream.write(getDatasLength(bArr));
                        byteArrayOutputStream.write(bArr);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                }
                this.f18399t = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public void setDnsHostName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f18395p = "";
        } else {
            this.f18395p = str;
        }
    }

    public void setEntity(byte[] bArr) {
        this.f18398s = bArr;
    }

    public void setHead(Map<String, String> map) {
        this.f18394o = map;
    }

    public void setIPV6Url(String str) {
        this.f18397r = str;
    }

    public void setIsXinfo(boolean z10) {
        this.f18400u = z10;
    }

    public void setLocRequest(boolean z10) {
        this.f18403x = z10;
    }

    public void setParamsMap(Map<String, String> map) {
        this.f18402w = map;
    }

    public void setPlatinfo(String str) {
        this.f18401v = str;
    }

    public void setUrl(String str) {
        this.f18396q = str;
    }
}
