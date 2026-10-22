package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/ECMallTabTouchAreaConfig;", "Ljava/io/Serializable;", "", "enableExpand", "Z", "getEnableExpand", "()Z", "setEnableExpand", "(Z)V", "enableExpandClick", "getEnableExpandClick", "setEnableExpandClick", "enableExpandScroll", "getEnableExpandScroll", "setEnableExpandScroll", "enableNestedScrollHandoff", "getEnableNestedScrollHandoff", "setEnableNestedScrollHandoff", "", "expandRange", "[I", "getExpandRange", "()[I", "setExpandRange", "([I)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallTabTouchAreaConfig implements Serializable {
    public static final a Companion = null;
    public static final String SETTING_KEY = "ec_mall_tab_touch_area_config";

    @SerializedName("enable_expand")
    private boolean enableExpand;

    @SerializedName("enable_expand_click")
    private boolean enableExpandClick;

    @SerializedName("enable_expand_scroll")
    private boolean enableExpandScroll;

    @SerializedName("enable_nested_scroll_handoff")
    private boolean enableNestedScrollHandoff;

    @SerializedName("expand_range")
    private int[] expandRange;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean getEnableExpand() {
        if (this.enableExpand == true) goto L5;
    L9:
        return false;
    L5:
        if (this.enableExpandClick == false) goto L7;
    L8:
        return true;
    L7:
        if (this.enableExpandScroll == false) goto L9;
        goto L8
    }

    public final int[] getExpandRange() {
        int[] r100 = this.expandRange;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length != 4) goto L9;
        return r100;
    L9:
        return null;
    }

    public ECMallTabTouchAreaConfig() {
        this.enableExpandClick = true;
        this.enableExpandScroll = true;
    }

    public final boolean getEnableExpandClick() {
        return this.enableExpandClick;
    }

    public final boolean getEnableExpandScroll() {
        return this.enableExpandScroll;
    }

    public final boolean getEnableNestedScrollHandoff() {
        return this.enableNestedScrollHandoff;
    }

    public final void setEnableExpand(boolean r100) {
        this.enableExpand = r100;
    }

    public final void setEnableExpandClick(boolean r100) {
        this.enableExpandClick = r100;
    }

    public final void setEnableExpandScroll(boolean r100) {
        this.enableExpandScroll = r100;
    }

    public final void setEnableNestedScrollHandoff(boolean r100) {
        this.enableNestedScrollHandoff = r100;
    }

    public final void setExpandRange(int[] r100) {
        this.expandRange = r100;
    }
}
