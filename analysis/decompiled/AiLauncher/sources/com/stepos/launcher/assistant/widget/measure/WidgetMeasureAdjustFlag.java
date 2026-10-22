package com.stepos.launcher.assistant.widget.measure;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0002J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFlag;", "", "flag", "", "<init>", "(I)V", "useHideBaiduWidgetTitle", "", "withHideBaiduWidgetTitle", "hideTitle", "hasFlag", "mask", "updateMask", "addMask", "component1", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "Companion", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WidgetMeasureAdjustFlag {
    public static final WidgetMeasureAdjustFlag DEFAULT_FLAG;
    private static final int HIDE_BAIDU_WIDGET_TITLE = 1;
    private static final WidgetMeasureAdjustFlag[] flagCache;
    private final int flag;

    static {
        WidgetMeasureAdjustFlag[] widgetMeasureAdjustFlagArr = new WidgetMeasureAdjustFlag[2];
        for (int i10 = 0; i10 < 2; i10++) {
            widgetMeasureAdjustFlagArr[i10] = new WidgetMeasureAdjustFlag(i10);
        }
        flagCache = widgetMeasureAdjustFlagArr;
        DEFAULT_FLAG = new WidgetMeasureAdjustFlag(0);
    }

    public WidgetMeasureAdjustFlag(int i10) {
        this.flag = i10;
    }

    /* renamed from: component1, reason: from getter */
    private final int getFlag() {
        return this.flag;
    }

    public static /* synthetic */ WidgetMeasureAdjustFlag copy$default(WidgetMeasureAdjustFlag widgetMeasureAdjustFlag, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = widgetMeasureAdjustFlag.flag;
        }
        return widgetMeasureAdjustFlag.copy(i10);
    }

    private final boolean hasFlag(int mask) {
        return (this.flag & mask) != 0;
    }

    private final WidgetMeasureAdjustFlag updateMask(int mask, boolean addMask) {
        return addMask ? flagCache[this.flag | mask] : flagCache[this.flag & (~mask)];
    }

    public static /* synthetic */ WidgetMeasureAdjustFlag withHideBaiduWidgetTitle$default(WidgetMeasureAdjustFlag widgetMeasureAdjustFlag, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return widgetMeasureAdjustFlag.withHideBaiduWidgetTitle(z10);
    }

    public final WidgetMeasureAdjustFlag copy(int flag) {
        return new WidgetMeasureAdjustFlag(flag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WidgetMeasureAdjustFlag) && this.flag == ((WidgetMeasureAdjustFlag) other).flag;
    }

    public int hashCode() {
        return Integer.hashCode(this.flag);
    }

    public String toString() {
        return "WidgetMeasureAdjustFlag(flag=" + this.flag + ")";
    }

    public final boolean useHideBaiduWidgetTitle() {
        return hasFlag(1);
    }

    public final WidgetMeasureAdjustFlag withHideBaiduWidgetTitle(boolean hideTitle) {
        return updateMask(1, hideTitle);
    }
}
