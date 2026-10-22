package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.O2;
import com.amap.api.col.jmsl.s7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public abstract class I1<T, V> extends C1 {

    /* renamed from: B, reason: collision with root package name */
    public Context f16099B;

    /* renamed from: z, reason: collision with root package name */
    public T f16103z;

    /* renamed from: y, reason: collision with root package name */
    public boolean f16102y = true;

    /* renamed from: A, reason: collision with root package name */
    public int f16098A = 1;

    /* renamed from: C, reason: collision with root package name */
    public int f16100C = 1;

    /* renamed from: D, reason: collision with root package name */
    public String f16101D = "";

    public I1(Context context, T t10) {
        d(context, t10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private V h() throws com.amap.api.services.core.AMapException {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.I1.h():java.lang.Object");
    }

    public V c(byte[] bArr) throws JSONException, AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e10) {
            C1631z1.o(e10, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        C1631z1.v(str);
        return f(str);
    }

    public final void d(Context context, T t10) {
        this.f16099B = context;
        this.f16103z = t10;
        this.f16098A = 1;
        setSoTimeout(ServiceSettings.getInstance().getSoTimeOut());
        setConnectionTimeout(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    public byte[] e(int i10, U1 u12, C1 c12) throws g5 {
        setHttpProtocol(i10 == 1 ? s7.c.HTTP : s7.c.HTTPS);
        C1577l2 c1577l2D = this.f16102y ? u12.d(c12) : u12.q(c12);
        byte[] bArr = c1577l2D.f16719a;
        this.f16101D = c1577l2D.f16722d;
        return bArr;
    }

    public abstract V f(String str) throws AMapException;

    public V g() throws AMapException {
        String str;
        if (this.f16103z == null) {
            return null;
        }
        try {
            return h();
        } catch (AMapException e10) {
            String strI = this.i();
            String str2 = this.f16101D;
            if (strI != null) {
                String errorType = e10.getErrorType();
                if (e10.getErrorLevel() == 0) {
                    int errorCode = e10.getErrorCode();
                    if (errorCode == 0) {
                        str = UxipConstants.f30661Y;
                    } else {
                        int iPow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
                        str = ((errorCode % iPow) + (iPow * 4)) + "";
                    }
                } else {
                    str = e10.getErrorCode() + "";
                }
                String str3 = str;
                if (str3 != null && str3.length() >= 1) {
                    C1541c2.g(T2.a(true), strI, errorType, str2, "", str3);
                }
            }
            throw e10;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getSDKName() {
        return "sea";
    }

    public String i() {
        String ipv6url = getIPV6URL();
        if (ipv6url == null) {
            return null;
        }
        try {
            int iIndexOf = ipv6url.indexOf(".com/");
            int iIndexOf2 = ipv6url.indexOf("?");
            return iIndexOf2 == -1 ? ipv6url.substring(iIndexOf + 5) : ipv6url.substring(iIndexOf + 5, iIndexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public O2.b j() {
        return null;
    }

    public V k() {
        return null;
    }
}
