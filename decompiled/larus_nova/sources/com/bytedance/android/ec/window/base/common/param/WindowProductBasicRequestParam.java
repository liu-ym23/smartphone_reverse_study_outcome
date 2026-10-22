package com.bytedance.android.ec.window.base.common.param;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001c\u0010!\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001c\u0010$\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/param/WindowProductBasicRequestParam;", "Ljava/io/Serializable;", "()V", EffectConfiguration.KEY_CURSOR, "", "getCursor", "()J", "setCursor", "(J)V", "customIdType", "", "getCustomIdType", "()Ljava/lang/Integer;", "setCustomIdType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "customIds", "", "getCustomIds", "()Ljava/lang/String;", "setCustomIds", "(Ljava/lang/String;)V", "entrances", "getEntrances", "setEntrances", "isCustom", "", "()Z", "setCustom", "(Z)V", "materialId", "getMaterialId", "setMaterialId", "tmpId", "getTmpId", "setTmpId", "token", "getToken", "setToken", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductBasicRequestParam implements Serializable {
    private long cursor;
    private Integer customIdType;
    private String customIds;
    private String entrances;
    private boolean isCustom;
    private String materialId;
    private String tmpId;
    private String token;

    public WindowProductBasicRequestParam() {
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final String getEntrances() {
        return this.entrances;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final String getTmpId() {
        return this.tmpId;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean isCustom() {
        return this.isCustom;
    }

    public final void setCursor(long r100) {
        this.cursor = r100;
    }

    public final void setCustom(boolean r100) {
        this.isCustom = r100;
    }

    public final void setCustomIdType(Integer r100) {
        this.customIdType = r100;
    }

    public final void setCustomIds(String r100) {
        this.customIds = r100;
    }

    public final void setEntrances(String r100) {
        this.entrances = r100;
    }

    public final void setMaterialId(String r100) {
        this.materialId = r100;
    }

    public final void setTmpId(String r100) {
        this.tmpId = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }
}
