package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/f;", "Lcom/bytedance/android/sdk/bdticketguard/w;", "", "host", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "path", "getPath", CronetDataStorageAccess.LOGID, "getLogid", "request_csr", "getRequest_csr", "request_client_cert", "getRequest_client_cert", "request_ree_public_key", "getRequest_ree_public_key", "request_iteration_version", "getRequest_iteration_version", "request_version", "getRequest_version", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public class f extends w {

    @SerializedName("host")
    private final String host;

    @SerializedName(CronetDataStorageAccess.LOGID)
    private final String logid;

    @SerializedName("path")
    private final String path;

    @SerializedName("request_client_cert")
    private final String request_client_cert;

    @SerializedName("request_csr")
    private final String request_csr;

    @SerializedName("request_iteration_version")
    private final String request_iteration_version;

    @SerializedName("request_ree_public_key")
    private final String request_ree_public_key;

    @SerializedName("request_version")
    private final String request_version;

    public f(i0<?> r100) {
        P r101 = r100.f163748a;
        g0 r102 = null;
        if (r101 == 0) goto L5;
        d0 r103 = r101.f163797a;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.f163576a;
    L8:
        this.logid = r100.f163749b;
        String r104 = "";
        if (r102 == null) goto L13;
        String r105 = r102.f163716a;
        if (r105 == null) goto L13;
    L14:
        this.host = r105;
        if (r102 == null) goto L19;
        String r106 = r102.f163717b;
        if (r106 == null) goto L19;
    L20:
        this.path = r106;
        LinkedHashMap r107 = new LinkedHashMap();
        if (r103 == null) goto L28;
        List<Pair<String, String>> r108 = r103.f163577b;
        if (r108 == null) goto L28;
        Iterator<T> r109 = r108.iterator();
    L26:
        if (r109.hasNext() == false) goto L28;
        Pair r110 = (Pair) r109.next();
        r107.put(r110.first, r110.second);
    L28:
        String r111 = (String) r107.get("bd-ticket-guard-client-csr");
        if (r111 == null) goto L33;
        String r112 = p0.a(r111);
        if (r112 == null) goto L33;
    L34:
        this.request_csr = r112;
        String r113 = (String) r107.get("bd-ticket-guard-client-cert");
        if (r113 == null) goto L39;
        String r114 = p0.a(r113);
        if (r114 == null) goto L39;
    L40:
        this.request_client_cert = r114;
        String r115 = (String) r107.get("bd-ticket-guard-ree-public-key");
        if (r115 == null) goto L45;
        String r116 = p0.a(r115);
        if (r116 == null) goto L45;
    L46:
        this.request_ree_public_key = r116;
        String r117 = (String) r107.get("bd-ticket-guard-iteration-version");
        if (r117 != null) goto L50;
        r117 = "";
    L50:
        this.request_iteration_version = r117;
        String r118 = (String) r107.get("bd-ticket-guard-version");
        if (r118 == null) goto L53;
        r104 = r118;
    L53:
        this.request_version = r104;
        return;
    L45:
        r116 = "";
    L39:
        r114 = "";
    L33:
        r112 = "";
    L19:
        r106 = "";
    L13:
        r105 = "";
        goto L14
    L5:
        r103 = null;
        goto L6
    }
}
