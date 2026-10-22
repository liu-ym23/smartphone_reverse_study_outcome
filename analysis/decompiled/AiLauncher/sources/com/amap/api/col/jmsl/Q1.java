package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.ServiceSettings;
import com.autonavi.aps.amapapi.config.Const;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class Q1<T, V> extends I1<T, V> {
    public Q1(Context context, T t10) {
        super(context, t10);
    }

    @Override // com.amap.api.col.jmsl.s7
    public byte[] getEntityBytes() {
        try {
            String strN = n();
            StringBuffer stringBuffer = new StringBuffer();
            if (strN != null) {
                stringBuffer.append(strN);
                stringBuffer.append(Const.STR_MART_ADD);
            }
            int iJ = C1567j0.j();
            if (C1567j0.o() || iJ != 0) {
                stringBuffer.append("langCode=");
                stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            }
            String string = stringBuffer.toString();
            String strL = l(string);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(string);
            String strB = J0.b();
            stringBuffer2.append("&ts=" + strB);
            stringBuffer2.append("&scode=" + J0.d(this.f16099B, strB, strL));
            return stringBuffer2.toString().getBytes("utf-8");
        } catch (Throwable th) {
            C1631z1.o(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.jmsl.I1, com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Accept-Encoding", "gzip");
        map.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, "AMAP SDK Android Search 9.8.1");
        map.put("X-INFO", J0.c(this.f16099B));
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.8.1", "sea"));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.jmsl.I1
    public V k() {
        return null;
    }

    public String l(String str) throws UnsupportedEncodingException {
        String[] strArrSplit = str.split(Const.STR_MART_ADD);
        Arrays.sort(strArrSplit);
        StringBuffer stringBuffer = new StringBuffer();
        for (String strDecode : strArrSplit) {
            if (strDecode != null) {
                try {
                    strDecode = URLDecoder.decode(strDecode, "utf-8");
                } catch (UnsupportedEncodingException e10) {
                    C1631z1.o(e10, "ProtocalHandler", "strReEncoder");
                    strDecode = "";
                    stringBuffer.append(strDecode);
                    stringBuffer.append(Const.STR_MART_ADD);
                } catch (Exception e11) {
                    C1631z1.o(e11, "ProtocalHandler", "strReEncoderException");
                    strDecode = "";
                    stringBuffer.append(strDecode);
                    stringBuffer.append(Const.STR_MART_ADD);
                }
            }
            stringBuffer.append(strDecode);
            stringBuffer.append(Const.STR_MART_ADD);
        }
        String string = stringBuffer.toString();
        return string.length() > 1 ? (String) string.subSequence(0, string.length() - 1) : str;
    }

    public String m(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e10) {
            C1631z1.o(e10, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e11) {
            C1631z1.o(e11, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    public abstract String n();
}
