package com.stepos.launcher.assistant.widgetdrag;

import java.util.List;

/* loaded from: classes.dex */
public class GlobalDragWidgetStackInfo extends GlobalDragItemInfo {
    private List<WidgetInfo> widgetInfoList;
    private int selectedPosition = 0;
    private boolean recommend = false;

    public static class WidgetInfo {
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

        public String toString() {
            return "WidgetInfo{appWidgetId=" + this.appWidgetId + ", packageName='" + this.packageName + "', className='" + this.className + "'}";
        }
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public List<WidgetInfo> getWidgetInfoList() {
        return this.widgetInfoList;
    }

    public boolean isRecommend() {
        return this.recommend;
    }

    public void setRecommend(boolean z10) {
        this.recommend = z10;
    }

    public void setSelectedPosition(int i10) {
        this.selectedPosition = i10;
    }

    public void setWidgetInfoList(List<WidgetInfo> list) {
        this.widgetInfoList = list;
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.GlobalDragItemInfo
    public String toString() {
        return "GlobalDragWidgetStackInfo{widgetInfoList=" + this.widgetInfoList + ", selectedPosition=" + this.selectedPosition + ", recommend=" + this.recommend + ", super=" + super.toString() + '}';
    }
}
