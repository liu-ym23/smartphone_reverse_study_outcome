package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.VisibleCheckResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/d;", "", "", "", "", "checkResult", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setCheckResult", "(Ljava/util/Map;)V", "resultMsg", "b", "setResultMsg", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements vh7.h {

    @SerializedName(LocationMonitorConst.CHECK_RESULT)
    protected Map<String, Integer> checkResult;

    @SerializedName("result_msg")
    protected Map<String, String> resultMsg;

    public d() {
        this.checkResult = new HashMap();
        this.resultMsg = new HashMap();
    }

    public final Map<String, Integer> a() {
        return this.checkResult;
    }

    public final Map<String, String> b() {
        return this.resultMsg;
    }

    public d(am3.g r110) {
        this.checkResult = new HashMap();
        this.resultMsg = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L41;
        String r102 = null;
        if (r101 == 1) goto L25;
        if (r101 != 2) goto L8;
        long r103 = r110.c();
        Object r104 = null;
    L10:
        int r111 = r110.f();
        if (r111 == (-1)) goto L17;
        if (r111 != 1) goto L13;
        r102 = am3.h.c(r110);
        goto L10
    L13:
        if (r111 != 2) goto L14;
        r104 = am3.h.c(r110);
        goto L10
    L14:
        am3.h.e(r110);
        goto L10
    L17:
        r110.d(r103);
        Map r105 = this.resultMsg;
        if (r102 == null) goto L24;
        if (r104 == null) goto L22;
    L36:
        r105.put(r102, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L8:
        am3.h.e(r110);
        goto L3
    L25:
        long r106 = r110.c();
        r104 = null;
    L26:
        int r112 = r110.f();
        if (r112 == (-1)) goto L33;
        if (r112 != 1) goto L29;
        r102 = am3.h.c(r110);
        goto L26
    L29:
        if (r112 != 2) goto L30;
        r104 = Integer.valueOf(r110.i());
        goto L26
    L30:
        am3.h.e(r110);
        goto L26
    L33:
        r110.d(r106);
        r105 = this.checkResult;
        if (r102 == null) goto L40;
        if (r104 != null) goto L36;
        throw new IllegalStateException("Value must not be null");
    L40:
        throw new IllegalStateException("Key must not be null");
    L41:
        r110.d(r100);
        if (this.checkResult != null) goto L45;
        this.checkResult = new HashMap();
    L45:
        if (this.resultMsg != null) goto L77;
        this.resultMsg = new HashMap();
        return;
    }
}
