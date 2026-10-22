package com.bytedance.android.livesdk.provider.outer;

import com.bytedance.android.live.base.exception.ApiServerException;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f156701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f156702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f156703c;

    public final String toString() {
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L4
        r100.put("code", this.f156701a);     // Catch: JSONException -> L4
        r100.put("message", this.f156702b);     // Catch: JSONException -> L4
        r100.put("extra", this.f156703c);     // Catch: JSONException -> L4
        return r100.toString();
    L4:
        e = move-exception;
        e.printStackTrace();
        return super.toString();
    }

    public static a a(Object r100) {
        int r101 = -1;
        String r102 = "unknown";
        if (r100 != null) goto L7;
        return new a(-1, "unknown");
    L7:
        if ((r100 instanceof ApiServerException) == false) goto L10;
        ApiServerException r103 = (ApiServerException) r100;
        int r104 = r103.getErrorCode();
        r102 = r103.getErrorMsg();
        r101 = r104;
    L10:
        if ((r100 instanceof IOException) == false) goto L13;
        r102 = ((IOException) r100).getMessage();
        r101 = -2;
    L13:
        if ((r100 instanceof String) == false) goto L16;
        r102 = r100.toString();
    L16:
        return new a(r101, r102);
    }

    public a(int r100, String r101) {
        this.f156701a = -1;
        this.f156702b = "";
        this.f156703c = "";
        this.f156701a = r100;
        this.f156702b = r101;
        this.f156703c = "IStandalonePreviewView:fetchRoomData";
    }
}
