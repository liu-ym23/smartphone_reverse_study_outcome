package com.alipay.sdk.m.f0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class b {
    public b() {
    }

    public static c a(DataReportResult r100) {
        c r101 = new c();
        if (r100 != null) goto L6;
        return null;
    L6:
        r101.f25280a = r100.success;
        r101.f25281b = r100.resultCode;
        Map<String, String> r102 = r100.resultData;
        if (r102 == null) goto L19;
        r101.f25287c = r102.get("apdid");
        r101.f25288d = r102.get("apdidToken");
        r101.f25291g = r102.get("dynamicKey");
        r101.f25292h = r102.get("timeInterval");
        r101.f25293i = r102.get("webrtcUrl");
        r101.f25294j = "";
        String r103 = r102.get("drmSwitch");
        if (com.alipay.sdk.m.z.a.b(r103) == false) goto L17;
        if (r103.length() <= 0) goto L14;
        StringBuilder r104 = new StringBuilder();
        r104.append(r103.charAt(0));
        r101.f25289e = r104.toString();
    L14:
        if (r103.length() < 3) goto L17;
        StringBuilder r105 = new StringBuilder();
        r105.append(r103.charAt(2));
        r101.f25290f = r105.toString();
    L17:
        if (r102.containsKey("apse_degrade") == false) goto L19;
        r101.f25295k = r102.get("apse_degrade");
    L19:
        return r101;
    }

    public static DataReportRequest a(d r100) {
        DataReportRequest r101 = new DataReportRequest();
        if (r100 != null) goto L6;
        return null;
    L6:
        r101.f25987os = r100.f25296a;
        r101.rpcVersion = r100.f25305j;
        r101.bizType = "1";
        HashMap r102 = new HashMap();
        r101.bizData = r102;
        r102.put("apdid", r100.f25297b);
        r101.bizData.put("apdidToken", r100.f25298c);
        r101.bizData.put("umidToken", r100.f25299d);
        r101.bizData.put("dynamicKey", r100.f25300e);
        r101.deviceData = r100.f25301f;
        return r101;
    }
}
