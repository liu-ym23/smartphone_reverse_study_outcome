package com.bytedance.android.livesdk.player;

import com.bytedance.android.live.player.utils.PlayerRequestHelper;
import com.bytedance.android.livesdkapi.model.PlayerNameValuePair;
import com.bytedance.android.livesdkapi.roomplayer.PlayerHttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class s0 implements com.ss.videoarch.liveplayer.h {
    public s0() {
    }

    @Override // com.ss.videoarch.liveplayer.h
    public final com.ss.videoarch.liveplayer.h.b doPost(String r100, String r101) {
        return null;
    }

    public static String a(List r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L10;
        PlayerNameValuePair r103 = (PlayerNameValuePair) r102.next();
        r101.append(r103.getName());
        r101.append(": ");
        r101.append(r103.getValue());
        r101.append("\n");
        goto L7
    L10:
        return r101.toString();
    }

    @Override // com.ss.videoarch.liveplayer.h
    public final com.ss.videoarch.liveplayer.h.b doRequest(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("host", r101);
        String r103 = null;
        JSONObject r104 = null;
        PlayerHttpResponse r105 = (PlayerHttpResponse) PlayerRequestHelper.a(r100, r102).execute();     // Catch: Exception -> L19 JSONException -> L22 IOException -> L26
        if (r105 != null) goto L6;
    L16:
        String r106 = null;
    L18:
        return com.ss.videoarch.liveplayer.h.b.newBuilder().setResponse(r104).setBody(r106).build();
    L6:
        if (r105.getBody() == null) goto L16;
        r106 = new String(r105.getBody());     // Catch: Exception -> L19 JSONException -> L22 IOException -> L26
        String r107 = a(r105.getHeaders());     // Catch: JSONException -> L13 Exception -> L19 IOException -> L26
        r104 = new JSONObject(r106);     // Catch: JSONException -> L11 Exception -> L19 IOException -> L26
    L11:
        JSONException e100 = e;
    L15:
        JSONException r108 = e100;
        r103 = r106;
    L25:
        return com.ss.videoarch.liveplayer.h.b.newBuilder().setBody(r103).setHeader(r107).setException(r108).build();
    L13:
        e = move-exception;
        e100 = e;
        r107 = null;
    L22:
        e = move-exception;
        r108 = e;
        r107 = null;
    L26:
        e = move-exception;
        return com.ss.videoarch.liveplayer.h.b.newBuilder().setException(e).build();
    L19:
        e = move-exception;
        return com.ss.videoarch.liveplayer.h.b.newBuilder().setException(e).build();
    }
}
