package com.bytedance.android.live.base.model.liteinteraction;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.ClickMob")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/liteinteraction/c;", "", "", "clickMobLogName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setClickMobLogName", "(Ljava/lang/String;)V", "", "clickMobLogParams", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setClickMobLogParams", "(Ljava/util/Map;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c implements h {

    @SerializedName("click_mob_log_name")
    protected String clickMobLogName;

    @SerializedName("click_mob_log_params")
    protected Map<String, String> clickMobLogParams;

    public c() {
    }

    public c(g r110) {
        this.clickMobLogParams = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.clickMobLogName = am3.h.c(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = am3.h.c(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<String, String> r106 = this.clickMobLogParams;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
    }

    public final String a() {
        return this.clickMobLogName;
    }

    public final Map<String, String> b() {
        return this.clickMobLogParams;
    }
}
