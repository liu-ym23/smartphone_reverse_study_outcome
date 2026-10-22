package com.android.server.am;

import com.android.server.resmng.IAppStatus;

/* JADX INFO: loaded from: classes.dex */
public interface IProcessStatusChecker {

    public static class WidgetInfo {
        int h;
        String packageName;
        int userId;
        int w;

        public WidgetInfo(int userId, String packageName) {
            this.userId = userId;
            this.packageName = packageName;
        }

        public WidgetInfo setSize(int w, int h) {
            this.w = w;
            this.h = h;
            return this;
        }

        public String toString() {
            return "WidgetInfo{userId=" + this.userId + ", packageName=" + this.packageName + ", w=" + this.w + ", h=" + this.h + "}";
        }
    }

    default void init(ActivityManagerService service) {
    }

    default boolean check(ProcessRecord r, IAppStatus status) {
        return false;
    }

    default void onWidgetAdded(WidgetInfo widgetInfo) {
    }

    default void onWidgetRemoved(WidgetInfo widgetInfo) {
    }

    default void onWidgetClear() {
    }

    default void updateWallpaperPackage(String packageName) {
    }

    default void addRecordingUid(int uid) {
    }

    default void removeRecordingUid(int uid) {
    }
}
