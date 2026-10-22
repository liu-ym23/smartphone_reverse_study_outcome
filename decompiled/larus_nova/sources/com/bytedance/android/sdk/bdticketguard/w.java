package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/w;", "", "", "local_client_cert", "Ljava/lang/String;", "getLocal_client_cert", "()Ljava/lang/String;", "local_public_key_ree", "getLocal_public_key_ree", "local_public_key_tee", "getLocal_public_key_tee", "", "timestamp", "J", "getTimestamp", "()J", "create_at", "getCreate_at", "<init>", "()V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public class w {

    @SerializedName("create_at")
    private final String create_at;

    @SerializedName("local_client_cert")
    private final String local_client_cert;

    @SerializedName("local_public_key_ree")
    private final String local_public_key_ree;

    @SerializedName("local_public_key_tee")
    private final String local_public_key_tee;

    @SerializedName("timestamp")
    private final long timestamp;

    public w() {
        TicketGuardManager r100 = c1.f163567a;
        TicketGuardManager r101 = c1.f163567a;
        String r102 = "";
        if (r101 == null) goto L9;
        String r103 = r101.m();
        if (r103 == null) goto L9;
        String r104 = p0.a(r103);
        if (r104 == null) goto L9;
    L10:
        this.local_client_cert = r104;
        TicketGuardManager r105 = c1.f163567a;
        if (r105 == null) goto L17;
        String r106 = r105.v();
        if (r106 == null) goto L17;
        String r107 = p0.a(r106);
        if (r107 == null) goto L17;
    L18:
        this.local_public_key_ree = r107;
        TicketGuardManager r108 = c1.f163567a;
        if (r108 == null) goto L25;
        String r109 = r108.D();
        if (r109 == null) goto L25;
        String r110 = p0.a(r109);
        if (r110 == null) goto L25;
        r102 = r110;
    L25:
        this.local_public_key_tee = r102;
        long r111 = System.currentTimeMillis();
        this.timestamp = r111;
        this.create_at = p0.f163973a.format(new Date(r111));
        return;
    L17:
        r107 = "";
    L9:
        r104 = "";
        goto L10
    }
}
