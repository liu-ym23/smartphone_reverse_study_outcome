package com.stepos.launcher.assistant.widgetdrag;

/* loaded from: classes.dex */
public class GlobalDragWidgetInfo extends GlobalDragItemInfo {
    private int appWidgetId = -1;
    private String className;
    private String packageName;

    public int getAppWidgetId() {
        return this.appWidgetId;
    }

    public String getClassName() {
        return this.className;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setAppWidgetId(int i10) {
        this.appWidgetId = i10;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.GlobalDragItemInfo
    public String toString() {
        return "GlobalDragWidgetInfo{appWidgetId=" + this.appWidgetId + ", packageName='" + this.packageName + ", className='" + this.className + ", super='" + super.toString() + '}';
    }
}
