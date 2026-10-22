package com.bytedance.ttnet.diagnosis;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o6.a;

/* JADX INFO: loaded from: classes.dex */
public class TTNetDiagnosisService {
    public static final int ACCELERATE_TARGET = 2;
    public static final int DIAGNOSE_TARGET = 3;
    public static final int DIAGNOSE_V2_TARGET = 4;
    public static final int DNS_RESOLVE_TARGET = 0;
    public static final int NET_DETECT_ALL = 67;
    public static final int NET_DETECT_HTTP_GET = 1;
    public static final int NET_DETECT_ICMP_PING = 2;
    public static final int NET_DETECT_UDP_PING = 64;
    public static final int RACE_TARGETS = 1;
    private static final Map<Integer, String> sTypeStringMap = null;

    static {
        HashMap r10 = new HashMap();
        sTypeStringMap = r10;
        r10.put(0, "DNS_RESOLVE_TARGET");
        r10.put(1, "RACE_TARGETS");
        r10.put(2, "ACCELERATE_TARGET");
        r10.put(3, "DIAGNOSE_TARGET");
        r10.put(4, "DIAGNOSE_V2_TARGET");
    }

    public TTNetDiagnosisService() {
    }

    public static IDiagnosisRequest createRequest(int r10, String r11, int r12, int r13) throws Exception {
        if (isOneTargetRequestType(r10) == false) goto L20;
        if (isValidNetDetect(r10, r12) == false) goto L18;
        if (r10 != 0) goto L8;
    L15:
        ArrayList r14 = new ArrayList();
        r14.add(r11);
        return new a(r10, r14, r12, r13);
    L8:
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L15;
        if (r10 == 4) goto L15;
        return null;
    L18:
        throw new IllegalArgumentException("Illegal netDetectType: " + r12);
    L20:
        throw new IllegalArgumentException("Type " + requestTypeToString(r10) + " of request should be created with multiple targets.");
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.c() == false) goto L7;
        return SsCronetHttpClient.y(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static boolean isOneTargetRequestType(int r10) {
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L6;
        return false;
    L6:
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L16;
        if (r10 == 4) goto L16;
        throw new IllegalArgumentException("Illegal request type: " + r10);
    L16:
        return true;
    }

    private static boolean isValidNetDetect(int r10, long r11) {
        if (r10 != 0) goto L5;
        return true;
    L5:
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L17;
        if (r10 != 3) goto L11;
    L15:
        return true;
    L11:
        if (r10 == 4) goto L15;
        throw new IllegalArgumentException("Illegal request type: " + r10);
    L17:
        if (r11 != 1) goto L19;
    L24:
        return true;
    L19:
        if (r11 == 2) goto L24;
        if (r11 == 64) goto L24;
        return false;
    L26:
        if ((67 & r11) != 0) goto L28;
    L30:
        return false;
    L28:
        if ((r11 & (-68)) != 0) goto L30;
        return true;
    }

    public static void reportUserLog(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L17;
        SsCronetHttpClient r11 = getCronetHttpClient();     // Catch: Exception -> L10
        if (r11 == null) goto L16;
        r11.R(r10);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private static String requestTypeToString(int r10) {
        return sTypeStringMap.get(Integer.valueOf(r10));
    }

    public static IDiagnosisRequest createRequest(int r10, List<String> r11, int r12, int r13) throws Exception {
        if (isOneTargetRequestType(r10) == true) goto L15;
        if (isValidNetDetect(r10, r12) == false) goto L13;
        if (r10 == 1) goto L11;
        return null;
    L11:
        return new a(r10, r11, r12, r13);
    L13:
        throw new IllegalArgumentException("Illegal netDetectType: " + r12);
    L15:
        throw new IllegalArgumentException("Type " + requestTypeToString(r10) + " of request should be created with only one target.");
    }
}
