package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/setting/LiveFragmentLeakConfig;", "", "()V", "ecWidget", "", "getEcWidget", "()Z", "setEcWidget", "(Z)V", "enable", "getEnable", "setEnable", "revControlWidget", "getRevControlWidget", "setRevControlWidget", "widgetProvider", "getWidgetProvider", "setWidgetProvider", "getRevControlWidgetSwitch", "getWidgetProviderSwitch", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFragmentLeakConfig {

    @SerializedName("ec_widget")
    private boolean ecWidget;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("rev_control_widget")
    private boolean revControlWidget;

    @SerializedName("widget_provider")
    private boolean widgetProvider;

    public final boolean getRevControlWidgetSwitch() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.revControlWidget == false) goto L7;
        return true;
    }

    public final boolean getWidgetProviderSwitch() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.widgetProvider == false) goto L7;
        return true;
    }

    public LiveFragmentLeakConfig() {
        this.enable = true;
    }

    public final boolean getEcWidget() {
        return this.ecWidget;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getRevControlWidget() {
        return this.revControlWidget;
    }

    public final boolean getWidgetProvider() {
        return this.widgetProvider;
    }

    public final void setEcWidget(boolean r100) {
        this.ecWidget = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setRevControlWidget(boolean r100) {
        this.revControlWidget = r100;
    }

    public final void setWidgetProvider(boolean r100) {
        this.widgetProvider = r100;
    }
}
