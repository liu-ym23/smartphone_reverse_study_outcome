package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/n;", "Lcom/bytedance/android/sdk/bdticketguard/f;", "", "server_data", "Ljava/lang/String;", "getServer_data", "()Ljava/lang/String;", "response_ticket_data", "getResponse_ticket_data", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class n extends f {

    @SerializedName("response_ticket_data")
    private final String response_ticket_data;

    @SerializedName("server_data")
    private final String server_data;

    public n(c0 r100) {
        super(r100);
        this.server_data = p0.a(r100.f163563c);
        StringBuilder r101 = new StringBuilder();
        List<u0> r102 = r100.f163565e;
        if (r102 == null) goto L15;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        u0 r104 = (u0) r103.next();
        v0.a r105 = (v0.a) GsonProtectorUtils.fromJson(TicketGuardApiKt.a(), r104.b(), v0.a.class);
        StringBuilder r106 = new StringBuilder(com.alipay.sdk.m.u.i.f25853b);
        r106.append(p0.a(r104.a()));
        r106.append(':');
        String r107 = r105.a();
        String r108 = null;
        if (r107 == null) goto L10;
        String r109 = p0.a(r107);
    L11:
        r106.append(r109);
        r106.append(':');
        String r110 = r105.b();
        if (r110 == null) goto L14;
        r108 = p0.a(r110);
    L14:
        r106.append(r108);
        r101.append(r106.toString());
        goto L6
    L10:
        r109 = null;
    L15:
        this.response_ticket_data = r101.toString();
    }
}
