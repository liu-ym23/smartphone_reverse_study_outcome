package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/AICloneConvItem;", "", "()V", "convItem", "", "getConvItem", "()Ljava/lang/Long;", "setConvItem", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "errToast", "", "getErrToast", "()Ljava/lang/String;", "setErrToast", "(Ljava/lang/String;)V", "map", "", "getMap", "()Ljava/util/Map;", "setMap", "(Ljava/util/Map;)V", "schema", "getSchema", "setSchema", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AICloneConvItem implements vh7.h {

    @SerializedName("conv_component")
    protected Long convItem;

    @SerializedName("toast")
    protected String errToast;

    @SerializedName("tag")
    protected Map<String, String> map;

    @SerializedName("schema")
    protected String schema;

    public AICloneConvItem() {
    }

    public final Long getConvItem() {
        return this.convItem;
    }

    public final String getErrToast() {
        return this.errToast;
    }

    public final Map<String, String> getMap() {
        return this.map;
    }

    public final String getSchema() {
        return this.schema;
    }

    public AICloneConvItem(am3.g r110) {
        this.map = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.convItem = Long.valueOf(r110.j());
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.schema = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.errToast = am3.h.c(r110);
        goto L3
    L12:
        if (r101 != 200) goto L13;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L15:
        int r105 = r110.f();
        if (r105 == (-1)) goto L22;
        if (r105 != 1) goto L18;
        r103 = am3.h.c(r110);
        goto L15
    L18:
        if (r105 != 2) goto L19;
        r104 = am3.h.c(r110);
        goto L15
    L19:
        am3.h.e(r110);
        goto L15
    L22:
        r110.d(r102);
        Map<String, String> r106 = this.map;
        if (r103 == null) goto L29;
        if (r104 == null) goto L27;
        r106.put(r103, r104);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }

    public final void setConvItem(Long r100) {
        this.convItem = r100;
    }

    public final void setErrToast(String r100) {
        this.errToast = r100;
    }

    public final void setMap(Map<String, String> r100) {
        this.map = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }
}
