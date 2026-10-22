package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponentFunctionInfo;", "", "()V", "data", "", "", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "functionId", "getFunctionId", "()Ljava/lang/String;", "setFunctionId", "(Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ClientComponentFunctionInfo implements h {

    @SerializedName("data")
    protected Map<String, String> data;

    @SerializedName("function_id")
    protected String functionId;

    public ClientComponentFunctionInfo() {
    }

    public ClientComponentFunctionInfo(g r110) {
        this.data = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.functionId = am3.h.c(r110);
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
        Map<String, String> r106 = this.data;
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

    public final Map<String, String> getData() {
        return this.data;
    }

    public final String getFunctionId() {
        return this.functionId;
    }

    public final void setData(Map<String, String> r100) {
        this.data = r100;
    }

    public final void setFunctionId(String r100) {
        this.functionId = r100;
    }
}
