package com.bytedance.android.annie.websocket;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements IMessageReceiveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f40122b;

    public h(g r100) {
        this.f40122b = r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
    public final void onFeedBackLog(String r100) {
        if (this.f40122b != null) goto L5;
        return;
    L5:
        int r101 = i.f40123a;
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L8
    L9:
        int r103 = r102.optInt("ws_state", -1);
        if (r103 != (-1)) goto L12;
        return;
    L12:
        if (r103 != 0) goto L30;
        if (r102.optBoolean("using_quic") == false) goto L16;
        String r104 = "quic";
    L40:
        JSONObject r105 = new JSONObject(this.f40121a);     // Catch: Exception -> L20
    L21:
        String r106 = r102.optString(MonitorConstants.RESPONSE_HEADER);
        Intrinsics.checkNotNullParameter(r105, "jsonOb");
        r105.put("__MP_RESP_HEADER", r106);     // Catch: Exception -> L33
    L23:
        int r107 = i.f40123a;
        Intrinsics.checkNotNullParameter(r105, "jsonOb");
        r105.put("__MP_TRANSPORT_PROTOCOL", r104);     // Catch: Exception -> L34
    L25:
        int r108 = i.f40123a;
        Intrinsics.checkNotNullParameter(r105, "jsonOb");
        r105.put("__MP_LOG", r102);     // Catch: JSONException -> L35
    L27:
        this.f40122b.c(4, r105.toString());
        return;
    L20:
        r105 = new JSONObject();
        goto L21
    L16:
        r104 = "tcp";
        goto L40
    L30:
        if (r103 != 1) goto L46;
        String r109 = r102.optString("ws_error");
        this.f40122b.c(3, r109);
        return;
    L46:
        return;
    L8:
        r102 = new JSONObject();
        goto L9
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
    public final void onMessage(byte[] r100, int r101) {
        c r102 = this.f40122b;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.onMessage(r100, r101);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener
    public final void onConnection(int r100, String r101, JSONObject r102) {
        if (this.f40122b != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L8;
        String r103 = r102.toString();
        if (r103 == null) goto L8;
    L10:
        if (r100 != 4) goto L12;
    L18:
        this.f40121a = r103;
        return;
    L12:
        if (r100 == 3) goto L18;
        if (r100 == 2) goto L18;
        this.f40122b.c(r100, r103);
        return;
    L8:
        r103 = SliceInitService.DEFAULT_SWITCH;
        goto L10
    }
}
