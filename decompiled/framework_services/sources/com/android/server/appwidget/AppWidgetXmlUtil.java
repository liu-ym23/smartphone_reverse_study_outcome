package com.android.server.appwidget;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import android.util.SizeF;
import android.util.Slog;
import android.util.SparseArray;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AppWidgetXmlUtil {
    private static final String ATTR_AUTO_ADVANCED_VIEW_ID = "auto_advance_view_id";
    private static final String ATTR_CONFIGURE = "configure";
    private static final String ATTR_DESCRIPTION_RES = "description_res";
    private static final String ATTR_ICON = "icon";
    private static final String ATTR_INITIAL_KEYGUARD_LAYOUT = "initial_keyguard_layout";
    private static final String ATTR_INITIAL_LAYOUT = "initial_layout";
    private static final String ATTR_LABEL = "label";
    private static final String ATTR_MAX_RESIZE_HEIGHT = "max_resize_height";
    private static final String ATTR_MAX_RESIZE_WIDTH = "max_resize_width";
    private static final String ATTR_MIN_HEIGHT = "min_height";
    private static final String ATTR_MIN_RESIZE_HEIGHT = "min_resize_height";
    private static final String ATTR_MIN_RESIZE_WIDTH = "min_resize_width";
    private static final String ATTR_MIN_WIDTH = "min_width";
    private static final String ATTR_NEW_ID = "new_id";
    private static final String ATTR_NOTIFIED = "notified";
    private static final String ATTR_OLD_ID = "old_id";
    private static final String ATTR_OS_FINGERPRINT = "os_fingerprint";
    private static final String ATTR_PACKAGE_NAMES = "pkgs";
    private static final String ATTR_PREVIEW_IMAGE = "preview_image";
    private static final String ATTR_PREVIEW_LAYOUT = "preview_layout";
    private static final String ATTR_PROVIDER_INHERITANCE = "provider_inheritance";
    private static final String ATTR_RESIZE_MODE = "resize_mode";
    private static final String ATTR_TAG = "tag";
    private static final String ATTR_TARGET_CELL_HEIGHT = "target_cell_height";
    private static final String ATTR_TARGET_CELL_WIDTH = "target_cell_width";
    private static final String ATTR_UPDATE_PERIOD_MILLIS = "update_period_millis";
    private static final String ATTR_WIDGET_CATEGORY = "widget_category";
    private static final String ATTR_WIDGET_FEATURES = "widget_features";
    private static final String SIZE_SEPARATOR = ",";
    private static final String TAG = "AppWidgetXmlUtil";
    static final String TAG_BACKUP_RESTORE_CONTROLLER_STATE = "br";
    private static final String TAG_HOST_UPDATES = "host_updates";
    private static final String TAG_PROVIDER_UPDATES = "provider_updates";
    private static final String TAG_PRUNED_APPS = "pruned_apps";
    private static final String TAG_RECORD = "record";

    public AppWidgetXmlUtil() {
    }

    public static void writeAppWidgetProviderInfoLocked(TypedXmlSerializer out, AppWidgetProviderInfo info) throws IOException {
        out.getClass();
        info.getClass();
        out.attributeInt(null, ATTR_MIN_WIDTH, info.minWidth);
        out.attributeInt(null, ATTR_MIN_HEIGHT, info.minHeight);
        out.attributeInt(null, ATTR_MIN_RESIZE_WIDTH, info.minResizeWidth);
        out.attributeInt(null, ATTR_MIN_RESIZE_HEIGHT, info.minResizeHeight);
        out.attributeInt(null, ATTR_MAX_RESIZE_WIDTH, info.maxResizeWidth);
        out.attributeInt(null, ATTR_MAX_RESIZE_HEIGHT, info.maxResizeHeight);
        out.attributeInt(null, ATTR_TARGET_CELL_WIDTH, info.targetCellWidth);
        out.attributeInt(null, ATTR_TARGET_CELL_HEIGHT, info.targetCellHeight);
        out.attributeInt(null, ATTR_UPDATE_PERIOD_MILLIS, info.updatePeriodMillis);
        out.attributeInt(null, ATTR_INITIAL_LAYOUT, info.initialLayout);
        out.attributeInt(null, ATTR_INITIAL_KEYGUARD_LAYOUT, info.initialKeyguardLayout);
        if (info.configure == null) goto L6;
        out.attribute(null, ATTR_CONFIGURE, info.configure.flattenToShortString());
    L6:
        if (info.label == null) goto L8;
        out.attribute(null, ATTR_LABEL, info.label);
    L8:
        out.attributeInt(null, ATTR_ICON, info.icon);
        out.attributeInt(null, ATTR_PREVIEW_IMAGE, info.previewImage);
        out.attributeInt(null, ATTR_PREVIEW_LAYOUT, info.previewLayout);
        out.attributeInt(null, ATTR_AUTO_ADVANCED_VIEW_ID, info.autoAdvanceViewId);
        out.attributeInt(null, ATTR_RESIZE_MODE, info.resizeMode);
        out.attributeInt(null, ATTR_WIDGET_CATEGORY, info.widgetCategory);
        out.attributeInt(null, ATTR_WIDGET_FEATURES, info.widgetFeatures);
        out.attributeInt(null, ATTR_DESCRIPTION_RES, info.descriptionRes);
        out.attributeBoolean(null, ATTR_PROVIDER_INHERITANCE, info.isExtendedFromAppWidgetProvider);
        out.attribute(null, ATTR_OS_FINGERPRINT, Build.FINGERPRINT);
    }

    public static AppWidgetProviderInfo readAppWidgetProviderInfoLocked(TypedXmlPullParser parser) {
        parser.getClass();
        String fingerprint = parser.getAttributeValue(null, ATTR_OS_FINGERPRINT);
        if (Build.FINGERPRINT.equals(fingerprint) == true) goto L5;
        return null;
    L5:
        AppWidgetProviderInfo info = new AppWidgetProviderInfo();
        info.minWidth = parser.getAttributeInt(null, ATTR_MIN_WIDTH, 0);
        info.minHeight = parser.getAttributeInt(null, ATTR_MIN_HEIGHT, 0);
        info.minResizeWidth = parser.getAttributeInt(null, ATTR_MIN_RESIZE_WIDTH, 0);
        info.minResizeHeight = parser.getAttributeInt(null, ATTR_MIN_RESIZE_HEIGHT, 0);
        info.maxResizeWidth = parser.getAttributeInt(null, ATTR_MAX_RESIZE_WIDTH, 0);
        info.maxResizeHeight = parser.getAttributeInt(null, ATTR_MAX_RESIZE_HEIGHT, 0);
        info.targetCellWidth = parser.getAttributeInt(null, ATTR_TARGET_CELL_WIDTH, 0);
        info.targetCellHeight = parser.getAttributeInt(null, ATTR_TARGET_CELL_HEIGHT, 0);
        info.updatePeriodMillis = parser.getAttributeInt(null, ATTR_UPDATE_PERIOD_MILLIS, 0);
        info.initialLayout = parser.getAttributeInt(null, ATTR_INITIAL_LAYOUT, 0);
        info.initialKeyguardLayout = parser.getAttributeInt(null, ATTR_INITIAL_KEYGUARD_LAYOUT, 0);
        String configure = parser.getAttributeValue(null, ATTR_CONFIGURE);
        if (TextUtils.isEmpty(configure) == true) goto L8;
        info.configure = ComponentName.unflattenFromString(configure);
    L8:
        info.label = parser.getAttributeValue(null, ATTR_LABEL);
        info.icon = parser.getAttributeInt(null, ATTR_ICON, 0);
        info.previewImage = parser.getAttributeInt(null, ATTR_PREVIEW_IMAGE, 0);
        info.previewLayout = parser.getAttributeInt(null, ATTR_PREVIEW_LAYOUT, 0);
        info.autoAdvanceViewId = parser.getAttributeInt(null, ATTR_AUTO_ADVANCED_VIEW_ID, 0);
        info.resizeMode = parser.getAttributeInt(null, ATTR_RESIZE_MODE, 0);
        info.widgetCategory = parser.getAttributeInt(null, ATTR_WIDGET_CATEGORY, 0);
        info.widgetFeatures = parser.getAttributeInt(null, ATTR_WIDGET_FEATURES, 0);
        info.descriptionRes = parser.getAttributeInt(null, ATTR_DESCRIPTION_RES, 0);
        info.isExtendedFromAppWidgetProvider = parser.getAttributeBoolean(null, ATTR_PROVIDER_INHERITANCE, false);
        return info;
    }

    static String serializeWidgetSizes(List<SizeF> sizes) {
        return (String) sizes.stream().map(new AppWidgetXmlUtil$$ExternalSyntheticLambda2()).collect(Collectors.joining(SIZE_SEPARATOR));
    }

    static ArrayList<SizeF> deserializeWidgetSizesStr(String sizesStr) {
        if (sizesStr != null) goto L5;
    L12:
        return null;
    L5:
        if (sizesStr.isEmpty() == true) goto L12;
        return (ArrayList) Arrays.stream(sizesStr.split(SIZE_SEPARATOR)).map(new AppWidgetXmlUtil$$ExternalSyntheticLambda0()).collect(Collectors.toCollection(new AppWidgetXmlUtil$$ExternalSyntheticLambda1()));
    L9:
        e = move-exception;
        Slog.e(TAG, "Error parsing widget sizes", e);
        return null;
    }

    static void writeBackupRestoreControllerState(TypedXmlSerializer out, AppWidgetServiceImpl.BackupRestoreController.State state) throws IOException {
        out.getClass();
        state.getClass();
        out.startTag(null, "br");
        Set<String> prunedApps = state.getPrunedApps();
        if (prunedApps != null) goto L5;
    L7:
        SparseArray<List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord>> updatesByProvider = state.getUpdatesByProvider();
        if (updatesByProvider == null) goto L10;
        writeUpdateRecords(out, TAG_PROVIDER_UPDATES, updatesByProvider);
    L10:
        SparseArray<List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord>> updatesByHost = state.getUpdatesByHost();
        if (updatesByHost == null) goto L13;
        writeUpdateRecords(out, TAG_HOST_UPDATES, updatesByHost);
    L13:
        out.endTag(null, "br");
        return;
    L5:
        if (prunedApps.isEmpty() == true) goto L7;
        out.startTag(null, TAG_PRUNED_APPS);
        out.attribute(null, ATTR_PACKAGE_NAMES, String.join(SIZE_SEPARATOR, prunedApps));
        out.endTag(null, TAG_PRUNED_APPS);
        goto L7
    }

    private static void writeUpdateRecords(TypedXmlSerializer out, String outerTag, SparseArray<List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord>> records) throws IOException {
        int i = 0;
    L4:
        if (i >= records.size()) goto L11;
        int tag = records.keyAt(i);
        out.startTag(null, outerTag);
        out.attributeInt(null, ATTR_TAG, tag);
        List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord> entries = records.get(tag);
        Iterator<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord> r4 = entries.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord entry = r4.next();
        out.startTag(null, TAG_RECORD);
        out.attributeInt(null, ATTR_OLD_ID, entry.oldId);
        out.attributeInt(null, ATTR_NEW_ID, entry.newId);
        out.attributeBoolean(null, ATTR_NOTIFIED, entry.notified);
        out.endTag(null, TAG_RECORD);
        goto L7
    L9:
        out.endTag(null, outerTag);
        i = i + 1;
        goto L4
    }

    static AppWidgetServiceImpl.BackupRestoreController.State readBackupRestoreControllerState(TypedXmlPullParser parser) {
        parser.getClass();
        String tag = null;
        Set<String> prunedApps = new ArraySet(1);
        SparseArray<List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord>> updatesByProviders = new SparseArray();
        SparseArray<List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord>> updatesByHosts = new SparseArray();
    L38:
        int type = parser.next();     // Catch: Throwable -> L13
        byte r7 = 2;
        if (type != 2) goto L28;
        tag = parser.getName();     // Catch: Throwable -> L13
        switch(tag.hashCode()) {
            case -900592516: goto L19;
            case -508749417: goto L16;
            case 434853171: goto L11;
            default: goto L21;
        };     // Catch: Throwable -> L13
    L21:
        r7 = -1;
    L23:
        switch(r7) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            default: goto L28;
        };
    L25:
        updatesByHosts.put(parser.getAttributeInt(null, ATTR_TAG), parseRestoreUpdateRecords(parser));     // Catch: Throwable -> L13 Throwable -> L13
        goto L28
    L26:
        updatesByProviders.put(parser.getAttributeInt(null, ATTR_TAG), parseRestoreUpdateRecords(parser));     // Catch: Throwable -> L13 Throwable -> L13
        goto L28
    L27:
        String packages = parser.getAttributeValue(null, ATTR_PACKAGE_NAMES);     // Catch: Throwable -> L13 Throwable -> L13
        prunedApps.addAll(Arrays.asList(packages.split(SIZE_SEPARATOR)));     // Catch: Throwable -> L13 Throwable -> L13
        goto L28
    L11:
        if (tag.equals(TAG_HOST_UPDATES) == false) goto L21;
    L16:
        if (tag.equals(TAG_PRUNED_APPS) == false) goto L21;
        r7 = 0;
        goto L23
    L19:
        if (tag.equals(TAG_PROVIDER_UPDATES) == false) goto L21;
        r7 = 1;
    L28:
        if (type == 1) goto L35;
        if ("br".equals(tag) == false) goto L38;
        if (type != 3) goto L38;
    L35:
        return new AppWidgetServiceImpl.BackupRestoreController.State(prunedApps, updatesByProviders, updatesByHosts);
    L13:
        e = move-exception;
        Log.e(TAG, "error parsing state", e);
        return null;
    }

    private static List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord> parseRestoreUpdateRecords(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        List<AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord> ret = new ArrayList();
    L3:
        int type = parser.next();
        String tag = parser.getName();
        if (tag.equals(TAG_RECORD) == false) goto L9;
        if (type != 2) goto L9;
        int oldId = parser.getAttributeInt(null, ATTR_OLD_ID);
        int newId = parser.getAttributeInt(null, ATTR_NEW_ID);
        boolean notified = parser.getAttributeBoolean(null, ATTR_NOTIFIED);
        AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord record = new AppWidgetServiceImpl.BackupRestoreController.RestoreUpdateRecord(oldId, newId);
        record.notified = notified;
        ret.add(record);
    L9:
        if (tag.equals(TAG_RECORD) == true) goto L3;
        return ret;
    }
}
