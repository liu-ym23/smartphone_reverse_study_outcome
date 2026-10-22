package com.android.server.autofill;

import android.app.ActivityManager;
import android.app.assist.AssistStructure;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.hardware.display.DisplayManager;
import android.metrics.LogMaker;
import android.net.Uri;
import android.os.UserHandle;
import android.os.UserManager;
import android.service.autofill.Dataset;
import android.service.autofill.FillResponse;
import android.service.autofill.InternalSanitizer;
import android.service.autofill.SaveInfo;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.widget.RemoteViews;
import com.android.internal.util.ArrayUtils;
import com.android.server.utils.Slogf;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class Helper {
    private static final String TAG = "AutofillHelper";
    public static boolean sDebug;
    public static Boolean sFullScreenMode;
    public static boolean sVerbose;

    public static class SaveInfoStats {
        public int saveDataTypeCount;
        public int saveInfoCount;

        public SaveInfoStats(int saveInfoCount, int saveDataTypeCount) {
            this.saveInfoCount = saveInfoCount;
            this.saveDataTypeCount = saveDataTypeCount;
        }
    }

    private interface ViewNodeFilter {
        boolean matches(AssistStructure.ViewNode r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$3WoTykt09vAC-xMqjnEGK9m1mEo, reason: not valid java name */
    public static /* synthetic */ void m2294$r8$lambda$3WoTykt09vACxMqjnEGK9m1mEo(int r0, AtomicBoolean r1, Uri r2) {
        lambda$checkRemoteViewUriPermissions$0(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$5IVE57lJv3GvUMORybTW6j5Ne9I(AutofillId r0, AssistStructure.ViewNode r1) {
        return lambda$findViewNodeByAutofillId$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$MKepWjPuL-yfVylaeuWHmuQrF1M, reason: not valid java name */
    public static /* synthetic */ boolean m2295$r8$lambda$MKepWjPuLyfVylaeuWHmuQrF1M(String[] r0, AssistStructure.ViewNode r1) {
        return lambda$sanitizeUrlBar$2(r0, r1);
    }

    static {
        sDebug = true;
        sVerbose = false;
        sFullScreenMode = null;
    }

    private Helper() {
        throw new UnsupportedOperationException("contains static members only");
    }

    private static boolean checkRemoteViewUriPermissions(final int userId, RemoteViews rView) {
        final AtomicBoolean permissionsOk = new AtomicBoolean(true);
        rView.visitUris(new Helper$$ExternalSyntheticLambda1(userId, permissionsOk));
        return permissionsOk.get();
    }

    private static /* synthetic */ void lambda$checkRemoteViewUriPermissions$0(int userId, AtomicBoolean permissionsOk, Uri uri) {
        int uriOwnerId = ContentProvider.getUserIdFromUri(uri, userId);
        if (uriOwnerId != userId) goto L5;
        boolean allowed = true;
    L6:
        permissionsOk.set(permissionsOk.get() & allowed);
        return;
    L5:
        allowed = false;
        goto L6
    }

    public static Context getUserContext(Context context) {
        int userId = ActivityManager.getCurrentUser();
        Context c = context.createContextAsUser(UserHandle.of(userId), 0);
        if (sDebug == false) goto L5;
        Slog.d(TAG, "Current User: " + userId + ", context created as: " + c.getContentResolver().getUserId());
    L5:
        return c;
    }

    public static RemoteViews sanitizeRemoteView(RemoteViews rView) {
        if (rView != null) goto L5;
        return null;
    L5:
        int userId = ActivityManager.getCurrentUser();
        boolean ok = checkRemoteViewUriPermissions(userId, rView);
        if (ok == true) goto L8;
        Slog.w(TAG, "sanitizeRemoteView() user: " + userId + " tried accessing resource that does not belong to them");
    L8:
        if (ok == true) goto L10;
        return null;
    L10:
        return rView;
    }

    public static Slice sanitizeSlice(Slice slice) {
        if (slice != null) goto L5;
        return null;
    L5:
        int userId = ActivityManager.getCurrentUser();
        Iterator<SliceItem> r2 = slice.getItems().iterator();
    L7:
        if (r2.hasNext() == false) goto L21;
        SliceItem sliceItem = r2.next();
        if (sliceItem.getFormat().equals("image") == false) goto L7;
        Icon icon = sliceItem.getIcon();
        if (icon.getType() == 4) goto L16;
        if (icon.getType() != 6) goto L7;
    L16:
        int iconUriId = ContentProvider.getUserIdFromUri(icon.getUri(), userId);
        if (iconUriId == userId) goto L7;
        Slog.w(TAG, "sanitizeSlice() user: " + userId + " cannot access icons in Slice");
        return null;
    L21:
        return slice;
    }

    static AutofillId[] toArray(ArraySet<AutofillId> set) {
        if (set != null) goto L5;
        return null;
    L5:
        AutofillId[] array = new AutofillId[set.size()];
        int i = 0;
    L7:
        if (i >= set.size()) goto L10;
        array[i] = set.valueAt(i);
        i = i + 1;
        goto L7
    L10:
        return array;
    }

    public static String paramsToString(WindowManager.LayoutParams params) {
        StringBuilder builder = new StringBuilder(25);
        params.dumpDimensions(builder);
        return builder.toString();
    }

    static ArrayMap<AutofillId, AutofillValue> getFields(Dataset dataset) {
        ArrayList<AutofillId> ids = dataset.getFieldIds();
        ArrayList<AutofillValue> values = dataset.getFieldValues();
        if (ids != null) goto L5;
        int size = 0;
    L6:
        ArrayMap<AutofillId, AutofillValue> fields = new ArrayMap(size);
        int i = 0;
    L7:
        if (i >= size) goto L10;
        fields.put(ids.get(i), values.get(i));
        i = i + 1;
        goto L7
    L10:
        return fields;
    L5:
        size = ids.size();
        goto L6
    }

    private static LogMaker newLogMaker(int category, String servicePackageName, int sessionId, boolean compatMode) {
        LogMaker log = new LogMaker(category).addTaggedData(908, servicePackageName).addTaggedData(1456, Integer.toString(sessionId));
        if (compatMode == false) goto L5;
        log.addTaggedData(1414, 1);
    L5:
        return log;
    }

    public static LogMaker newLogMaker(int category, String packageName, String servicePackageName, int sessionId, boolean compatMode) {
        return newLogMaker(category, servicePackageName, sessionId, compatMode).setPackageName(packageName);
    }

    public static LogMaker newLogMaker(int category, ComponentName componentName, String servicePackageName, int sessionId, boolean compatMode) {
        ComponentName sanitizedComponentName = new ComponentName(componentName.getPackageName(), "");
        return newLogMaker(category, servicePackageName, sessionId, compatMode).setComponentName(sanitizedComponentName);
    }

    public static void printlnRedactedText(PrintWriter pw, CharSequence text) {
        if (text != null) goto L4;
        pw.println("null");
        return;
    L4:
        pw.print(text.length());
        pw.println("_chars");
    }

    public static AssistStructure.ViewNode findViewNodeByAutofillId(AssistStructure structure, final AutofillId autofillId) {
        return findViewNode(structure, new Helper$$ExternalSyntheticLambda0(autofillId));
    }

    private static /* synthetic */ boolean lambda$findViewNodeByAutofillId$1(AutofillId autofillId, AssistStructure.ViewNode node) {
        return autofillId.equals(node.getAutofillId());
    }

    private static AssistStructure.ViewNode findViewNode(AssistStructure structure, ViewNodeFilter filter) {
        ArrayDeque<AssistStructure.ViewNode> nodesToProcess = new ArrayDeque();
        int numWindowNodes = structure.getWindowNodeCount();
        int i = 0;
    L3:
        if (i >= numWindowNodes) goto L6;
        nodesToProcess.add(structure.getWindowNodeAt(i).getRootViewNode());
        i = i + 1;
    L6:
        if (nodesToProcess.isEmpty() == true) goto L15;
        AssistStructure.ViewNode node = nodesToProcess.removeFirst();
        if (filter.matches(node) == true) goto L9;
        int i2 = 0;
    L12:
        if (i2 >= node.getChildCount()) goto L6;
        nodesToProcess.addLast(node.getChildAt(i2));
        i2 = i2 + 1;
        goto L12
    L9:
        return node;
    L15:
        return null;
    }

    public static AssistStructure.ViewNode sanitizeUrlBar(AssistStructure structure, final String[] urlBarIds) {
        AssistStructure.ViewNode urlBarNode = findViewNode(structure, new Helper$$ExternalSyntheticLambda2(urlBarIds));
        if (urlBarNode == null) goto L14;
        String domain = urlBarNode.getText().toString();
        if (domain.isEmpty() == true) goto L7;
        urlBarNode.setWebDomain(domain);
        if (sDebug == false) goto L14;
        Slog.d(TAG, "sanitizeUrlBar(): id=" + urlBarNode.getIdEntry() + ", domain=" + urlBarNode.getWebDomain());
        goto L14
    L7:
        if (sDebug == false) goto L15;
        Slog.d(TAG, "sanitizeUrlBar(): empty on " + urlBarNode.getIdEntry());
        return null;
    L15:
        return null;
    L14:
        return urlBarNode;
    }

    private static /* synthetic */ boolean lambda$sanitizeUrlBar$2(String[] urlBarIds, AssistStructure.ViewNode node) {
        return ArrayUtils.contains(urlBarIds, node.getIdEntry());
    }

    static int getNumericValue(LogMaker log, int tag) {
        Object value = log.getTaggedData(tag);
        if ((value instanceof Number) == true) goto L7;
        return 0;
    L7:
        return ((Number) value).intValue();
    }

    static ArrayList<AutofillId> getAutofillIds(AssistStructure structure, boolean autofillableOnly) {
        ArrayList<AutofillId> ids = new ArrayList();
        int size = structure.getWindowNodeCount();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        AssistStructure.WindowNode node = structure.getWindowNodeAt(i);
        addAutofillableIds(node.getRootViewNode(), ids, autofillableOnly);
        i = i + 1;
        goto L3
    L6:
        return ids;
    }

    private static void addAutofillableIds(AssistStructure.ViewNode node, ArrayList<AutofillId> ids, boolean autofillableOnly) {
        if (autofillableOnly == true) goto L4;
    L5:
        AutofillId id = node.getAutofillId();
        if (id == null) goto L8;
        ids.add(id);
    L8:
        int size = node.getChildCount();
        int i = 0;
    L9:
        if (i >= size) goto L12;
        AssistStructure.ViewNode child = node.getChildAt(i);
        addAutofillableIds(child, ids, autofillableOnly);
        i = i + 1;
        goto L9
    L12:
        return;
    L4:
        if (node.getAutofillType() == 0) goto L8;
        goto L5
    }

    static ArrayMap<AutofillId, InternalSanitizer> createSanitizers(SaveInfo saveInfo) {
        if (saveInfo != null) goto L5;
        return null;
    L5:
        InternalSanitizer[] sanitizerKeys = saveInfo.getSanitizerKeys();
        if (sanitizerKeys != null) goto L8;
        return null;
    L8:
        int size = sanitizerKeys.length;
        ArrayMap<AutofillId, InternalSanitizer> sanitizers = new ArrayMap(size);
        if (sDebug == false) goto L11;
        Slog.d(TAG, "Service provided " + size + " sanitizers");
    L11:
        AutofillId[][] sanitizerValues = saveInfo.getSanitizerValues();
        int i = 0;
    L12:
        if (i >= size) goto L22;
        InternalSanitizer sanitizer = sanitizerKeys[i];
        AutofillId[] ids = sanitizerValues[i];
        if (sDebug == false) goto L16;
        Slog.d(TAG, "sanitizer #" + i + " (" + sanitizer + ") for ids " + Arrays.toString(ids));
    L16:
        int r8 = ids.length;
        int r9 = 0;
    L18:
        if (r9 >= r8) goto L20;
        AutofillId id = ids[r9];
        sanitizers.put(id, sanitizer);
        r9 = r9 + 1;
        goto L18
    L20:
        i = i + 1;
        goto L12
    L22:
        return sanitizers;
    }

    static boolean containsCharsInOrder(String s1, String s2) {
        int prevIndex = -1;
        char[] r1 = s2.toCharArray();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        char ch = r1[r4];
        int index = TextUtils.indexOf(s1, ch, prevIndex + 1);
        if (index == (-1)) goto L6;
        prevIndex = index;
        r4 = r4 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    static Context getDisplayContext(Context context, int displayId) {
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L6;
        return context;
    L6:
        if (context.getDisplayId() != displayId) goto L12;
        if (sDebug == false) goto L10;
        Slogf.d(TAG, "getDisplayContext(): context %s already has displayId %d", new Object[]{context, Integer.valueOf(displayId)});
    L10:
        return context;
    L12:
        if (sDebug == false) goto L14;
        Slogf.d(TAG, "Creating context for display %d", new Object[]{Integer.valueOf(displayId)});
    L14:
        Display display = ((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(displayId);
        if (display != null) goto L19;
        Slogf.wtf(TAG, "Could not get context with displayId %d, Autofill operations will probably fail)", new Object[]{Integer.valueOf(displayId)});
        return context;
    L19:
        return context.createDisplayContext(display);
    }

    static <T> T weakDeref(WeakReference<T> weakRef, String tag, String prefix) {
        T deref = weakRef.get();
        if (deref != null) goto L5;
        Slog.wtf(tag, prefix + "fail to deref " + weakRef);
    L5:
        return deref;
    }

    public static SaveInfoStats getSaveInfoStatsFromFillResponses(SparseArray<FillResponse> fillResponses) {
        if (fillResponses == null) goto L4;
        int numSaveInfos = 0;
        int numSaveDataTypes = 0;
        ArraySet<Integer> saveDataTypeSeen = new ArraySet();
        int numResponses = fillResponses.size();
        int responseNum = 0;
    L9:
        if (responseNum >= numResponses) goto L19;
        FillResponse response = fillResponses.valueAt(responseNum);
        if (response == null) goto L17;
        if (response.getSaveInfo() == null) goto L17;
        numSaveInfos = numSaveInfos + 1;
        int saveDataType = response.getSaveInfo().getType();
        if (saveDataTypeSeen.contains(Integer.valueOf(saveDataType)) == true) goto L17;
        saveDataTypeSeen.add(Integer.valueOf(saveDataType));
        numSaveDataTypes = numSaveDataTypes + 1;
    L17:
        responseNum = responseNum + 1;
        goto L9
    L19:
        return new SaveInfoStats(numSaveInfos, numSaveDataTypes);
    L4:
        if (sVerbose == false) goto L7;
        Slog.v(TAG, "getSaveInfoStatsFromFillResponses(): fillResponse sparse array is null");
    L7:
        return new SaveInfoStats(-1, -1);
    }
}
