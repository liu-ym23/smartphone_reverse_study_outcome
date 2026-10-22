package com.bytedance.android.livesdk.player.newstrategy;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f155938a = 0;

    static {
    }

    public static JSONObject a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "name");
        JSONObject r102 = r100.optJSONObject(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        String r103 = r100.optString(r101);
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L18;
        return null;
    L18:
        return new JSONObject(r103);
    L17:
        return null;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L13
    }
}
