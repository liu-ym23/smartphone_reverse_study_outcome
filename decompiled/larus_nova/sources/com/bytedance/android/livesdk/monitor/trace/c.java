package com.bytedance.android.livesdk.monitor.trace;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.o5;
import com.bytedance.android.livesdk.jsbridge.methods.draft.m;
import com.bytedance.android.livesdk.utils.s6;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f153983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f153984b;

    public c(b r100, JSONObject r101) {
        this.f153983a = r100;
        this.f153984b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        LinkedTreeMap r111 = (LinkedTreeMap) r110;
        int r100 = 0;
        if (r111.containsKey("limit_keys") == false) goto L14;
        String r101 = (String) r111.get("limit_keys");
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        b r103 = this.f153983a;
        Intrinsics.checkNotNull(r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "rawStr");
        s6 r104 = s6.f159161a;
        s6.a(StringsKt.split$default(r101, new char[]{','}, false, 0, 6, null));
        goto L14
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
    L14:
        if (o5.f65376a.getValue().booleanValue() == true) goto L22;
        String r105 = m.a(this.f153984b);
        if (r105 != null) goto L18;
        return;
    L18:
        if (StringsKt.contains$default(r105, "ttlive_room_apm_enter", false, 2, null) != true) goto L25;
        ALogger.e("trace_yzw", "respond:" + r111);
        JSONArray r112 = JSONObjectProtectorUtils.getJSONArray(this.f153984b, "data");
        int r106 = r112.length();
    L20:
        if (r100 >= r106) goto L26;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r112, r100);
        ALogger.e("trace_yzw", "eventName:" + r107.optString("event_type") + ", roomId:" + r107.optString("room_id"));
        r100 = r100 + 1;
        goto L20
    L26:
        return;
    L25:
        return;
    }
}
