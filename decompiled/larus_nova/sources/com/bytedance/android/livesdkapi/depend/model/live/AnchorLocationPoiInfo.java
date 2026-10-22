package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorLocationPoiInfo;", "", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "isLocalSet", "setLocalSet", "poiId", "", "getPoiId", "()J", "setPoiId", "(J)V", "poiIdStr", "", "getPoiIdStr", "()Ljava/lang/String;", "setPoiIdStr", "(Ljava/lang/String;)V", "text", "getText", "setText", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLocationPoiInfo implements h {

    @SerializedName("enabled")
    protected boolean enabled;

    @IgnoreProtoFieldCheck
    private boolean isLocalSet;

    @SerializedName("poi_id")
    protected long poiId;

    @SerializedName("poi_id_str")
    protected String poiIdStr;

    @SerializedName("text")
    protected String text;

    public AnchorLocationPoiInfo() {
    }

    public String toString() {
        return "AnchorLocationPoiInfo(enabled=" + this.enabled + ", poiId=" + this.poiId + ", poiIdStr=" + this.poiIdStr + ", text=" + this.text + ", isLocalSet=" + this.isLocalSet + ')';
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final long getPoiId() {
        return this.poiId;
    }

    public final String getPoiIdStr() {
        return this.poiIdStr;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isLocalSet() {
        return this.isLocalSet;
    }

    public AnchorLocationPoiInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.enabled = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.poiId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.poiIdStr = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.text = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    public final void setLocalSet(boolean r100) {
        this.isLocalSet = r100;
    }

    public final void setPoiId(long r100) {
        this.poiId = r100;
    }

    public final void setPoiIdStr(String r100) {
        this.poiIdStr = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
