package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/settings/provider/WidgetReusedSettings;", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "widgetId", "reusedMaxSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getReusedMaxSize", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetReusedSettings {

    @SerializedName(IFlowAppIntentIDL.PARAM_APPLET_ID)
    private final String appletId;

    @SerializedName("reusedMaxSize")
    private final int reusedMaxSize;

    @SerializedName("widgetId")
    private final String widgetId;

    public WidgetReusedSettings() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ WidgetReusedSettings copy$default(WidgetReusedSettings r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.appletId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.widgetId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.reusedMaxSize;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final int component3() {
        return this.reusedMaxSize;
    }

    public final WidgetReusedSettings copy(String r100, String r101, int r102) {
        return new WidgetReusedSettings(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WidgetReusedSettings) == true) goto L8;
        return false;
    L8:
        WidgetReusedSettings r101 = (WidgetReusedSettings) r100;
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L15;
        return false;
    L15:
        if (this.reusedMaxSize == r101.reusedMaxSize) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.appletId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.widgetId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.reusedMaxSize;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "WidgetReusedSettings(appletId=" + this.appletId + ", widgetId=" + this.widgetId + ", reusedMaxSize=" + this.reusedMaxSize + ')';
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final int getReusedMaxSize() {
        return this.reusedMaxSize;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public WidgetReusedSettings(String r100, String r101, int r102) {
        this.appletId = r100;
        this.widgetId = r101;
        this.reusedMaxSize = r102;
    }

    public /* synthetic */ WidgetReusedSettings(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
