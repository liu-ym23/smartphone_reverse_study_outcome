package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/m1;", "Lcom/bytedance/android/sdk/bdticketguard/f;", "", "local_error", "Ljava/lang/String;", "getLocal_error", "()Ljava/lang/String;", "remote_error", "getRemote_error", "ticket_name", "getTicket_name", "ticket", "getTicket", "request_client_data", "getRequest_client_data", "request_client_data_req_content", "getRequest_client_data_req_content", "request_client_data_req_sign", "getRequest_client_data_req_sign", "request_client_data_req_sign_ree", "getRequest_client_data_req_sign_ree", "request_client_data_timestamp", "getRequest_client_data_timestamp", "request_client_data_ts_sign", "getRequest_client_data_ts_sign", "request_client_data_ts_sign_ree", "getRequest_client_data_ts_sign_ree", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class m1 extends f {

    @SerializedName("local_error")
    private final String local_error;

    @SerializedName("remote_error")
    private final String remote_error;

    @SerializedName("request_client_data")
    private final String request_client_data;

    @SerializedName("request_client_data_req_content")
    private final String request_client_data_req_content;

    @SerializedName("request_client_data_req_sign")
    private final String request_client_data_req_sign;

    @SerializedName("request_client_data_req_sign_ree")
    private final String request_client_data_req_sign_ree;

    @SerializedName("request_client_data_timestamp")
    private final String request_client_data_timestamp;

    @SerializedName("request_client_data_ts_sign")
    private final String request_client_data_ts_sign;

    @SerializedName("request_client_data_ts_sign_ree")
    private final String request_client_data_ts_sign_ree;

    @SerializedName("ticket")
    private final String ticket;

    @SerializedName("ticket_name")
    private final String ticket_name;

    public m1(k r100) {
        super(r100);
        this.remote_error = r100.f163800c;
        o r101 = (o) r100.f163748a;
        Long r102 = null;
        if (r101 == null) goto L5;
        g r103 = (g) r101.f163797a;
    L6:
        String r104 = "";
        if (r103 == null) goto L11;
        String r105 = r103.f163710e;
        if (r105 == null) goto L11;
    L12:
        this.local_error = r105;
        if (r103 == null) goto L15;
        i r106 = (i) r103.f163576a;
    L16:
        if (r106 == null) goto L22;
        String r107 = r106.f163739e;
        if (r107 == null) goto L22;
        String r108 = p0.a(r107);
        if (r108 == null) goto L22;
    L23:
        this.ticket = r108;
        if (r106 == null) goto L28;
        String r109 = r106.f163740f;
        if (r109 == null) goto L28;
    L29:
        this.ticket_name = r109;
        if (r103 == null) goto L36;
        String r110 = r103.f163713h;
        if (r110 == null) goto L36;
        String r111 = p0.a(r110);
        if (r111 == null) goto L36;
    L37:
        this.request_client_data = r111;
        if (r103 == null) goto L40;
        e r112 = r103.f163712g;
    L41:
        if (r112 == null) goto L45;
        String r113 = r112.f163644a;
        if (r113 == null) goto L45;
    L46:
        this.request_client_data_req_content = r113;
        if (r112 == null) goto L53;
        String r114 = r112.a();
        if (r114 == null) goto L53;
        String r115 = p0.a(r114);
        if (r115 == null) goto L53;
    L54:
        this.request_client_data_req_sign = r115;
        if (r112 == null) goto L61;
        String r116 = r112.b();
        if (r116 == null) goto L61;
        String r117 = p0.a(r116);
        if (r117 == null) goto L61;
    L62:
        this.request_client_data_req_sign_ree = r117;
        if (r112 == null) goto L65;
        r102 = Long.valueOf(r112.c());
    L65:
        String r118 = String.valueOf(r102.longValue());
        if (r118 != null) goto L69;
        r118 = "";
    L69:
        this.request_client_data_timestamp = r118;
        if (r112 == null) goto L76;
        String r119 = r112.d();
        if (r119 == null) goto L76;
        String r120 = p0.a(r119);
        if (r120 == null) goto L76;
    L77:
        this.request_client_data_ts_sign = r120;
        if (r112 == null) goto L84;
        String r121 = r112.e();
        if (r121 == null) goto L84;
        String r122 = p0.a(r121);
        if (r122 == null) goto L84;
        r104 = r122;
    L84:
        this.request_client_data_ts_sign_ree = r104;
        return;
    L76:
        r120 = "";
    L61:
        r117 = "";
    L53:
        r115 = "";
    L45:
        r113 = "";
        goto L46
    L40:
        r112 = null;
    L36:
        r111 = "";
    L28:
        r109 = "";
    L22:
        r108 = "";
        goto L23
    L15:
        r106 = null;
    L11:
        r105 = "";
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
