package com.bytedance.android.livesdk.interactivity.api.roomintro.api;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/PoiInfo;", "", "()V", "defaultIntro", "", "getDefaultIntro", "()Ljava/lang/String;", "setDefaultIntro", "(Ljava/lang/String;)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PoiInfo implements h {

    @SerializedName("default_intro")
    protected String defaultIntro;

    @SerializedName("enabled")
    protected boolean enabled;

    public PoiInfo() {
    }

    public PoiInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.enabled = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.defaultIntro = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final String getDefaultIntro() {
        return this.defaultIntro;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setDefaultIntro(String r100) {
        this.defaultIntro = r100;
    }

    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }
}
