package com.android.server.am;

import android.app.ActivityTaskManager;
import android.app.AppOpsManager;
import android.app.IActivityTaskManager;
import android.app.IAssistDataReceiver;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.IWindowManager;
import com.android.internal.logging.MetricsLogger;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AssistDataRequester extends IAssistDataReceiver.Stub {
    public static final String KEY_RECEIVER_EXTRA_COUNT = "count";
    public static final String KEY_RECEIVER_EXTRA_INDEX = "index";
    public IActivityTaskManager mActivityTaskManager;
    private AppOpsManager mAppOpsManager;
    private final ArrayList<Bundle> mAssistData;
    private final ArrayList<Bitmap> mAssistScreenshot;
    private AssistDataRequesterCallbacks mCallbacks;
    private Object mCallbacksLock;
    private boolean mCanceled;
    private Context mContext;
    private int mPendingDataCount;
    private int mPendingScreenshotCount;
    private int mRequestScreenshotAppOps;
    private int mRequestStructureAppOps;
    private IWindowManager mWindowManager;

    public interface AssistDataRequesterCallbacks {
        boolean canHandleReceivedAssistDataLocked();

        default void onAssistDataReceivedLocked(Bundle data, int activityIndex, int activityCount) {
        }

        default void onAssistScreenshotReceivedLocked(Bitmap screenshot) {
        }

        default void onAssistRequestCompleted() {
        }
    }

    public AssistDataRequester(Context context, IWindowManager windowManager, AppOpsManager appOpsManager, AssistDataRequesterCallbacks callbacks, Object callbacksLock, int requestStructureAppOps, int requestScreenshotAppOps) {
        this.mAssistData = new ArrayList();
        this.mAssistScreenshot = new ArrayList();
        this.mCallbacks = callbacks;
        this.mCallbacksLock = callbacksLock;
        this.mWindowManager = windowManager;
        this.mActivityTaskManager = ActivityTaskManager.getService();
        this.mContext = context;
        this.mAppOpsManager = appOpsManager;
        this.mRequestStructureAppOps = requestStructureAppOps;
        this.mRequestScreenshotAppOps = requestScreenshotAppOps;
    }

    public void requestAssistData(List<IBinder> activityTokens, boolean fetchData, boolean fetchScreenshot, boolean allowFetchData, boolean allowFetchScreenshot, int callingUid, String callingPackage, String callingAttributionTag) {
        requestAssistData(activityTokens, fetchData, fetchScreenshot, true, allowFetchData, allowFetchScreenshot, false, callingUid, callingPackage, callingAttributionTag);
    }

    public void requestAssistData(List<IBinder> activityTokens, boolean fetchData, boolean fetchScreenshot, boolean fetchStructure, boolean allowFetchData, boolean allowFetchScreenshot, boolean ignoreTopActivityCheck, int callingUid, String callingPackage, String callingAttributionTag) {
        requestData(activityTokens, false, fetchData, fetchScreenshot, fetchStructure, allowFetchData, allowFetchScreenshot, ignoreTopActivityCheck, callingUid, callingPackage, callingAttributionTag);
    }

    private void requestData(List<IBinder> activityTokens, boolean requestAutofillData, boolean fetchData, boolean fetchScreenshot, boolean fetchStructure, boolean allowFetchData, boolean allowFetchScreenshot, boolean ignoreTopActivityCheck, int callingUid, String callingPackage, String callingAttributionTag) {
        AssistDataRequester r2 = this;
        activityTokens.getClass();
        callingPackage.getClass();
        if (activityTokens.isEmpty() == false) goto L80;
        r2.tryDispatchRequestComplete();
        return;
    L80:
        boolean isAssistDataAllowed = r2.mActivityTaskManager.isAssistDataAllowed();     // Catch: RemoteException -> L9
        boolean isAssistDataAllowed2 = isAssistDataAllowed;
    L11:
        boolean allowFetchData2 = allowFetchData & isAssistDataAllowed2;
        if (fetchData == false) goto L17;
        if (isAssistDataAllowed2 == false) goto L17;
        if (r2.mRequestScreenshotAppOps == (-1)) goto L17;
        boolean r0 = true;
    L18:
        boolean allowFetchScreenshot2 = allowFetchScreenshot & r0;
        r2.mCanceled = false;
        r2.mPendingDataCount = 0;
        r2.mPendingScreenshotCount = 0;
        r2.mAssistData.clear();
        r2.mAssistScreenshot.clear();
        if (fetchData == true) goto L21;
        AssistDataRequester r1 = r2;
    L64:
        if (fetchScreenshot == false) goto L76;
        AssistDataRequester r9 = r1;
        if (r1.mAppOpsManager.noteOpNoThrow(r1.mRequestScreenshotAppOps, callingUid, callingPackage, callingAttributionTag, null) != 0) goto L73;
        if (allowFetchScreenshot2 == false) goto L73;
        MetricsLogger.count(r9.mContext, "assist_with_screen", 1);     // Catch: RemoteException -> L70
        r9.mPendingScreenshotCount++;     // Catch: RemoteException -> L70
        r9.mWindowManager.requestAssistScreenshot(r9);     // Catch: RemoteException -> L70
    L77:
        r9.tryDispatchRequestComplete();
        return;
    L73:
        if (r9.mCallbacks.canHandleReceivedAssistDataLocked() == false) goto L75;
        r9.dispatchAssistScreenshotReceived(null);
        goto L77
    L75:
        r9.mAssistScreenshot.add(null);
        goto L77
    L76:
        r9 = r1;
        goto L77
    L21:
        if (r2.mAppOpsManager.noteOpNoThrow(r2.mRequestStructureAppOps, callingUid, callingPackage, callingAttributionTag, null) != 0) goto L58;
        if (allowFetchData2 == false) goto L58;
        int numActivities = activityTokens.size();
        int i = 0;
    L24:
        if (i >= numActivities) goto L56;
        IBinder topActivity = activityTokens.get(i);
        MetricsLogger.count(r2.mContext, "assist_with_context", 1);     // Catch: RemoteException -> L29
        Bundle receiverExtras = new Bundle();     // Catch: RemoteException -> L29
        receiverExtras.putInt(KEY_RECEIVER_EXTRA_INDEX, i);     // Catch: RemoteException -> L29
        receiverExtras.putInt(KEY_RECEIVER_EXTRA_COUNT, numActivities);     // Catch: RemoteException -> L29
        if (requestAutofillData == false) goto L31;
        boolean result = r2.mActivityTaskManager.requestAutofillData(r2, receiverExtras, topActivity, 0);     // Catch: RemoteException -> L29
        r1 = r2;
    L44:
        if (result == true) goto L79;
        if (i != 0) goto L55;
        if (r1.mCallbacks.canHandleReceivedAssistDataLocked() == false) goto L52;
        r1.dispatchAssistDataReceived(null);     // Catch: RemoteException -> L46
    L53:
        allowFetchScreenshot2 = false;
        goto L64
    L52:
        r1.mAssistData.add(null);     // Catch: RemoteException -> L46
    L55:
        i = i + 1;
        r2 = r1;
        goto L24
    L79:
        r1.mPendingDataCount++;     // Catch: RemoteException -> L46
        goto L55
    L31:
        if (fetchStructure == false) goto L33;
        int requestType = 1;
    L34:
        IActivityTaskManager r3 = r2.mActivityTaskManager;     // Catch: RemoteException -> L29
        if (i != 0) goto L38;
        if (ignoreTopActivityCheck == true) goto L38;
        boolean r5 = true;
    L39:
        if (i != 0) goto L41;
        boolean r6 = true;
    L42:
        result = r3.requestAssistContextExtras(requestType, r2, receiverExtras, topActivity, r5, r6);     // Catch: RemoteException -> L29
        r1 = r2;
        goto L44
    L41:
        r6 = false;
    L38:
        r5 = false;
        goto L39
    L33:
        requestType = 3;
    L30:
        r1 = r2;
        goto L55
    L56:
        r1 = r2;
    L58:
        r1 = r2;
        if (r1.mCallbacks.canHandleReceivedAssistDataLocked() == false) goto L61;
        r1.dispatchAssistDataReceived(null);
    L62:
        allowFetchScreenshot2 = false;
        goto L64
    L61:
        r1.mAssistData.add(null);
    L17:
        r0 = false;
    L10:
        isAssistDataAllowed2 = false;
        goto L11
    }

    public void processPendingAssistData() {
        flushPendingAssistData();
        tryDispatchRequestComplete();
    }

    private void flushPendingAssistData() {
        int dataCount = this.mAssistData.size();
        int i = 0;
    L3:
        if (i >= dataCount) goto L5;
        dispatchAssistDataReceived(this.mAssistData.get(i));
        i = i + 1;
        goto L3
    L5:
        this.mAssistData.clear();
        int screenshotsCount = this.mAssistScreenshot.size();
        int i2 = 0;
    L6:
        if (i2 >= screenshotsCount) goto L8;
        dispatchAssistScreenshotReceived(this.mAssistScreenshot.get(i2));
        i2 = i2 + 1;
        goto L6
    L8:
        this.mAssistScreenshot.clear();
    }

    public int getPendingDataCount() {
        return this.mPendingDataCount;
    }

    public int getPendingScreenshotCount() {
        return this.mPendingScreenshotCount;
    }

    public void cancel() {
        this.mCanceled = true;
        this.mPendingDataCount = 0;
        this.mPendingScreenshotCount = 0;
        this.mAssistData.clear();
        this.mAssistScreenshot.clear();
    }

    public void onHandleAssistData(Bundle data) {
        Object r0 = this.mCallbacksLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCanceled == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPendingDataCount--;     // Catch: Throwable -> L8
        if (this.mCallbacks.canHandleReceivedAssistDataLocked() == false) goto L13;
        flushPendingAssistData();     // Catch: Throwable -> L8
        dispatchAssistDataReceived(data);     // Catch: Throwable -> L8
        tryDispatchRequestComplete();     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        this.mAssistData.add(data);     // Catch: Throwable -> L8
        goto L14
    }

    public void onHandleAssistScreenshot(Bitmap screenshot) {
        Object r0 = this.mCallbacksLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCanceled == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPendingScreenshotCount--;     // Catch: Throwable -> L8
        if (this.mCallbacks.canHandleReceivedAssistDataLocked() == false) goto L13;
        flushPendingAssistData();     // Catch: Throwable -> L8
        dispatchAssistScreenshotReceived(screenshot);     // Catch: Throwable -> L8
        tryDispatchRequestComplete();     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        this.mAssistScreenshot.add(screenshot);     // Catch: Throwable -> L8
        goto L14
    }

    private void dispatchAssistDataReceived(Bundle data) {
        int activityIndex = 0;
        int activityCount = 0;
        if (data == null) goto L5;
        Bundle receiverExtras = data.getBundle(ActivityTaskManagerInternal.ASSIST_KEY_RECEIVER_EXTRAS);
    L6:
        if (receiverExtras == null) goto L8;
        activityIndex = receiverExtras.getInt(KEY_RECEIVER_EXTRA_INDEX);
        activityCount = receiverExtras.getInt(KEY_RECEIVER_EXTRA_COUNT);
    L8:
        this.mCallbacks.onAssistDataReceivedLocked(data, activityIndex, activityCount);
        return;
    L5:
        receiverExtras = null;
        goto L6
    }

    private void dispatchAssistScreenshotReceived(Bitmap screenshot) {
        this.mCallbacks.onAssistScreenshotReceivedLocked(screenshot);
    }

    private void tryDispatchRequestComplete() {
        if (this.mPendingDataCount == 0) goto L5;
        return;
    L5:
        if (this.mPendingScreenshotCount == 0) goto L7;
        return;
    L7:
        if (this.mAssistData.isEmpty() == true) goto L9;
        return;
    L9:
        if (this.mAssistScreenshot.isEmpty() == false) goto L15;
        this.mCallbacks.onAssistRequestCompleted();
        return;
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("mPendingDataCount=");
        pw.println(this.mPendingDataCount);
        pw.print(prefix);
        pw.print("mAssistData=");
        pw.println(this.mAssistData);
        pw.print(prefix);
        pw.print("mPendingScreenshotCount=");
        pw.println(this.mPendingScreenshotCount);
        pw.print(prefix);
        pw.print("mAssistScreenshot=");
        pw.println(this.mAssistScreenshot);
    }
}
