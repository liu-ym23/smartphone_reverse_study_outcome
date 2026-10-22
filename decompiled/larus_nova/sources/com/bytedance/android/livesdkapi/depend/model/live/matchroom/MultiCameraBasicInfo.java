package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MultiCameraBasicInfo;", "", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "", "iconBgColor", "Ljava/lang/String;", "getIconBgColor", "()Ljava/lang/String;", "setIconBgColor", "(Ljava/lang/String;)V", "panelBgColor", "getPanelBgColor", "setPanelBgColor", "iconPad", "getIconPad", "setIconPad", "", "supportVSCore", "Z", "getSupportVSCore", "()Z", "setSupportVSCore", "(Z)V", "name", "getName", "setName", "", "defaultDisplayDuration", "I", "getDefaultDisplayDuration", "()I", "setDefaultDisplayDuration", "(I)V", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraBasicInfo implements h {

    @SerializedName("default_display_duration")
    protected int defaultDisplayDuration;

    @SerializedName("icon")
    protected k icon;

    @SerializedName("icon_background_color")
    protected String iconBgColor;

    @SerializedName("icon_pad")
    protected k iconPad;

    @SerializedName("name")
    protected String name;

    @SerializedName("panel_background_color")
    protected String panelBgColor;

    @SerializedName("support_vs_core")
    protected boolean supportVSCore;

    public MultiCameraBasicInfo() {
    }

    public final int getDefaultDisplayDuration() {
        return this.defaultDisplayDuration;
    }

    public final k getIcon() {
        return this.icon;
    }

    public final String getIconBgColor() {
        return this.iconBgColor;
    }

    public final k getIconPad() {
        return this.iconPad;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPanelBgColor() {
        return this.panelBgColor;
    }

    public final boolean getSupportVSCore() {
        return this.supportVSCore;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public MultiCameraBasicInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.defaultDisplayDuration = r100.i();
        goto L3
    L8:
        this.name = am3.h.c(r100);
        goto L3
    L9:
        this.supportVSCore = am3.h.a(r100);
        goto L3
    L10:
        this.iconPad = f.a(r100, k.class);
        goto L3
    L11:
        this.panelBgColor = am3.h.c(r100);
        goto L3
    L12:
        this.iconBgColor = am3.h.c(r100);
        goto L3
    L13:
        this.icon = f.a(r100, k.class);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }

    public final void setDefaultDisplayDuration(int r100) {
        this.defaultDisplayDuration = r100;
    }

    public final void setIcon(k r100) {
        this.icon = r100;
    }

    public final void setIconBgColor(String r100) {
        this.iconBgColor = r100;
    }

    public final void setIconPad(k r100) {
        this.iconPad = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setPanelBgColor(String r100) {
        this.panelBgColor = r100;
    }

    public final void setSupportVSCore(boolean r100) {
        this.supportVSCore = r100;
    }
}
