package com.stepos.launcher.assistant.widgetdrag;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public class WidgetRestoreUtils {
    private static final String STEPOS_WIDGET_ID_CHANGED = "steposWidgetIdChanged";
    private static final String STEPOS_WIDGET_ID_CHANGED_COMPLETE = "steposWidgetIdChangedComplete";
    private static final String STEPOS_WIDGET_NEW_ID = "steposWidgetNewId";
    private static final String STEPOS_WIDGET_OLD_ID = "steposWidgetOldId";

    public static void changeWidgetId(Context context, int i10, int i11) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i11);
        appWidgetOptions.putBoolean(STEPOS_WIDGET_ID_CHANGED, true);
        appWidgetOptions.putInt(STEPOS_WIDGET_OLD_ID, i10);
        appWidgetOptions.putInt(STEPOS_WIDGET_NEW_ID, i11);
        appWidgetManager.updateAppWidgetOptions(i11, appWidgetOptions);
    }

    public static boolean changeWidgetIdComplete(Context context, int i10) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i10);
        if (appWidgetOptions == null || !appWidgetOptions.getBoolean(STEPOS_WIDGET_ID_CHANGED_COMPLETE)) {
            return false;
        }
        appWidgetOptions.remove(STEPOS_WIDGET_ID_CHANGED_COMPLETE);
        appWidgetOptions.remove(STEPOS_WIDGET_ID_CHANGED);
        appWidgetOptions.remove(STEPOS_WIDGET_OLD_ID);
        appWidgetOptions.remove(STEPOS_WIDGET_NEW_ID);
        appWidgetManager.updateAppWidgetOptions(i10, appWidgetOptions);
        return true;
    }

    public static Bundle setChangeWidgetId(Bundle bundle, int i10, int i11) {
        bundle.putBoolean(STEPOS_WIDGET_ID_CHANGED, true);
        bundle.putInt(STEPOS_WIDGET_OLD_ID, i10);
        bundle.putInt(STEPOS_WIDGET_NEW_ID, i11);
        return bundle;
    }
}
