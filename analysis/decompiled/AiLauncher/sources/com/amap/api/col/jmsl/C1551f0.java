package com.amap.api.col.jmsl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.jmsl.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1551f0 extends X1 {

    /* renamed from: com.amap.api.col.jmsl.f0$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f16623a;

        /* renamed from: b, reason: collision with root package name */
        public String f16624b;
    }

    public C1551f0(Context context, String str) {
        super(context, str);
        this.f16467C = str;
        this.f16469y = false;
    }

    @Override // com.amap.api.col.jmsl.X1
    public Object d(byte[] bArr) throws C1599r1 {
        if (bArr == null) {
            return null;
        }
        a aVar = new a();
        aVar.f16623a = bArr;
        return aVar;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getIPV6URL() {
        String str = this.f16467C;
        HashMap<String, Long> map = C1570k.f16700b;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri.getAuthority().startsWith("dualstack-")) {
                return str;
            }
            return uri.buildUpon().authority("dualstack-" + uri.getAuthority()).build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // com.amap.api.col.jmsl.X1, com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", C1567j0.n(this.f16466B));
        String strB = J0.b();
        String strD = J0.d(this.f16466B, strB, C1604s2.c(hashtable));
        hashtable.put("ts", strB);
        hashtable.put("scode", strD);
        return hashtable;
    }

    @Override // com.amap.api.col.jmsl.X1, com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        C1569j2 c1569j2C = C1570k.c();
        String strH = c1569j2C != null ? c1569j2C.h() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, C1623x1.f17031b);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", strH, "3dmap-lite"));
        hashtable.put("x-INFO", J0.h(this.f16466B));
        hashtable.put("key", C1567j0.n(this.f16466B));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return this.f16467C;
    }

    @Override // com.amap.api.col.jmsl.s7
    public boolean isSupportIPV6() {
        return true;
    }
}
