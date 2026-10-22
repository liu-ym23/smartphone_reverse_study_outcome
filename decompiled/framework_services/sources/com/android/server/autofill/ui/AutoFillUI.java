package com.android.server.autofill.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.Drawable;
import android.metrics.LogMaker;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.pico.utils.ExtImplFactory;
import android.service.autofill.Dataset;
import android.service.autofill.FillResponse;
import android.service.autofill.SaveInfo;
import android.service.autofill.ValueFinder;
import android.text.TextUtils;
import android.util.Slog;
import android.view.KeyEvent;
import android.view.autofill.AutofillId;
import android.view.autofill.IAutofillWindowPresenter;
import android.widget.Toast;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.UiModeManagerInternal;
import com.android.server.UiThread;
import com.android.server.autofill.Helper;
import com.android.server.autofill.PresentationStatsEventLogger;
import com.android.server.autofill.SaveEventLogger;
import com.android.server.utils.Slogf;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class AutoFillUI {
    private static final String TAG = "AutofillUI";
    private AutoFillUiCallback mCallback;
    private final Context mContext;
    private Runnable mCreateFillUiRunnable;
    private IExtAutoFillUI mExt;
    private DialogFillUi mFillDialog;
    private FillUi mFillUi;
    private final Handler mHandler;
    private final MetricsLogger mMetricsLogger;
    private final OverlayControl mOverlayControl;
    private SaveUi mSaveUi;
    private AutoFillUiCallback mSaveUiCallback;
    private final UiModeManagerInternal mUiModeMgr;

    public interface AutoFillUiCallback {
        void authenticate(int r1, int r2, IntentSender r3, Bundle r4, int r5);

        void cancelSave();

        void cancelSession();

        void dispatchUnhandledKey(AutofillId r1, KeyEvent r2);

        void fill(int r1, int r2, Dataset r3, int r4);

        void onShown(int r1, int r2);

        void requestFallbackFromFillDialog();

        void requestHideFillUi(AutofillId r1);

        void requestHideFillUiWhenDestroyed(AutofillId r1);

        void requestShowFillUi(AutofillId r1, int r2, int r3, IAutofillWindowPresenter r4);

        void requestShowSoftInput(AutofillId r1);

        void save();

        void startIntentSender(IntentSender r1, Intent r2);

        void startIntentSenderAndFinishSession(IntentSender r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$DVAnQZTMeWDayJpb9OM9Nuon-_Y, reason: not valid java name */
    public static /* synthetic */ void m2408$r8$lambda$DVAnQZTMeWDayJpb9OM9Nuon_Y(AutoFillUI r0, AutoFillUiCallback r1) {
        r0.lambda$hideFillUi$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$JsBrB-u2m2bIJrdO-pznjC55kxE, reason: not valid java name */
    public static /* synthetic */ void m2409$r8$lambda$JsBrBu2m2bIJrdOpznjC55kxE(AutoFillUI r0, AutoFillUiCallback r1, CharSequence r2, String r3, Context r4, PendingUi r5, ComponentName r6, SaveInfo r7, ValueFinder r8, SaveEventLogger r9, boolean r10, boolean r11, boolean r12, LogMaker r13, Drawable r14) {
        r0.lambda$showSaveUi$7(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void $r8$lambda$L8yxqxM9aXd5dPL761kjNiCnc9I(AutoFillUI r0, int r1, IBinder r2) {
        r0.lambda$onPendingSaveUi$9(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$NN-BJAvetBGQ8IjHhLol_a-wjVc, reason: not valid java name */
    public static /* synthetic */ void m2410$r8$lambda$NNBJAvetBGQ8IjHhLol_awjVc(AutoFillUI r0, PendingUi r1, AutoFillUiCallback r2, boolean r3) {
        r0.lambda$destroyAll$11(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qlr74mck9Vib43sd3il-W-wsKdU, reason: not valid java name */
    public static /* synthetic */ void m2411$r8$lambda$Qlr74mck9Vib43sd3ilWwsKdU(AutoFillUI r0, AutoFillUiCallback r1) {
        r0.lambda$setCallback$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XLG0cjVLh-AgsG0eg9Wg6cPrkXI, reason: not valid java name */
    public static /* synthetic */ void m2412$r8$lambda$XLG0cjVLhAgsG0eg9Wg6cPrkXI(AutoFillUI r0, AutoFillUiCallback r1, String r2) {
        r0.lambda$filterFillUi$5(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Zwg-B6p2IPL96nB-W21noo_ok2Y, reason: not valid java name */
    public static /* synthetic */ void m2413$r8$lambda$ZwgB6p2IPL96nBW21noo_ok2Y(AutoFillUI r0, AutoFillUiCallback r1, Context r2, FillResponse r3, AutofillId r4, String r5, CharSequence r6, Drawable r7, int r8, LogMaker r9) {
        r0.lambda$showFillUi$6(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: $r8$lambda$bDJB-ApAhg8Mvf8G42Sh21ysZIw, reason: not valid java name */
    public static /* synthetic */ void m2414$r8$lambda$bDJBApAhg8Mvf8G42Sh21ysZIw(AutoFillUI r0, AutoFillUiCallback r1) {
        r0.lambda$hideAll$10(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$cYitYywY-bgKefHspzKo5ryTWlU, reason: not valid java name */
    public static /* synthetic */ void m2415$r8$lambda$cYitYywYbgKefHspzKo5ryTWlU(AutoFillUI r0, AutoFillUiCallback r1) {
        r0.lambda$clearCallback$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$em6tpwp028YC9vpwp02B3b7yOxo(AutoFillUI r0, AutoFillUiCallback r1) {
        r0.lambda$hideFillDialog$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$xesWzbK0RZ0FdonBMrMBCUace4U(AutoFillUI r0, AutoFillUiCallback r1, FillResponse r2, AutofillId r3, String r4, Drawable r5, String r6, ComponentName r7, Object r8, PresentationStatsEventLogger r9, LogMaker r10) {
        r0.lambda$showFillDialog$8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void $r8$lambda$xtXgiLwSDgnTHbXQIKqw4lrlxto(AutoFillUI r0, AutoFillUiCallback r1, CharSequence r2) {
        r0.lambda$showError$2(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutoFillUiCallback m2416$$Nest$fgetmCallback(AutoFillUI r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2417$$Nest$fgetmContext(AutoFillUI r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMetricsLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ MetricsLogger m2418$$Nest$fgetmMetricsLogger(AutoFillUI r0) {
        return r0.mMetricsLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$mhideFillDialogUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2419$$Nest$mhideFillDialogUiThread(AutoFillUI r0, AutoFillUiCallback r1) {
        r0.hideFillDialogUiThread(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhideFillUiUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2420$$Nest$mhideFillUiUiThread(AutoFillUI r0, AutoFillUiCallback r1, boolean r2) {
        r0.hideFillUiUiThread(r1, r2);
    }

    public AutoFillUI(Context context) {
        this.mHandler = UiThread.getHandler();
        this.mMetricsLogger = new MetricsLogger();
        this.mContext = context;
        this.mOverlayControl = new OverlayControl(context);
        this.mUiModeMgr = (UiModeManagerInternal) LocalServices.getService(UiModeManagerInternal.class);
        this.mExt = (IExtAutoFillUI) ExtImplFactory.getImpl(IExtAutoFillUI.class, new Object[]{this, this.mContext});
    }

    public void setCallback(final AutoFillUiCallback callback) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda5(this, callback));
    }

    private /* synthetic */ void lambda$setCallback$0(AutoFillUiCallback callback) {
        if (this.mCallback != callback) goto L5;
        return;
    L5:
        if (this.mCallback != null) goto L7;
    L10:
        this.mCallback = callback;
        return;
    L7:
        if (isSaveUiShowing() == false) goto L9;
        hideFillUiUiThread(callback, true);
        goto L10
    L9:
        hideAllUiThread(this.mCallback);
        goto L10
    }

    public void clearCallback(final AutoFillUiCallback callback) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda3(this, callback));
    }

    private /* synthetic */ void lambda$clearCallback$1(AutoFillUiCallback callback) {
        if (this.mCallback != callback) goto L6;
        hideAllUiThread(callback);
        this.mCallback = null;
        return;
    }

    public void showError(int resId, AutoFillUiCallback callback) {
        showError(this.mContext.getString(resId), callback);
    }

    public void showError(final CharSequence message, final AutoFillUiCallback callback) {
        Slog.w(TAG, "showError(): " + message);
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda7(this, callback, message));
    }

    private /* synthetic */ void lambda$showError$2(AutoFillUiCallback callback, CharSequence message) {
        if (this.mCallback == callback) goto L5;
        return;
    L5:
        hideAllUiThread(callback);
        if (TextUtils.isEmpty(message) == true) goto L9;
        Toast.makeText(this.mContext, message, 1).show();
        return;
    }

    private /* synthetic */ void lambda$hideFillUi$3(AutoFillUiCallback callback) {
        hideFillUiUiThread(callback, true);
    }

    public void hideFillUi(final AutoFillUiCallback callback) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda1(this, callback));
    }

    private /* synthetic */ void lambda$hideFillDialog$4(AutoFillUiCallback callback) {
        hideFillDialogUiThread(callback);
    }

    public void hideFillDialog(final AutoFillUiCallback callback) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda11(this, callback));
    }

    public void filterFillUi(final String filterText, final AutoFillUiCallback callback) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda4(this, callback, filterText));
    }

    private /* synthetic */ void lambda$filterFillUi$5(AutoFillUiCallback callback, String filterText) {
        if (callback == this.mCallback) goto L6;
        return;
    L6:
        if (this.mFillUi == null) goto L9;
        this.mFillUi.setFilterText(filterText);
        return;
    }

    public void showFillUi(AutofillId focusedId, final FillResponse response, final String filterText, String servicePackageName, ComponentName componentName, final CharSequence serviceLabel, final Drawable serviceIcon, final AutoFillUiCallback callback, final Context context, int sessionId, boolean compatMode, final int maxInputLengthForAutofill) {
        int r1 = 0;
        if (Helper.sDebug == false) goto L8;
        if (filterText != null) goto L6;
        int size = 0;
    L7:
        final AutofillId r5 = focusedId;
        Slogf.d(TAG, "showFillUi(): id=%s, filter=%d chars, displayId=%d", new Object[]{r5, Integer.valueOf(size), Integer.valueOf(context.getDisplayId())});
    L9:
        LogMaker r0 = Helper.newLogMaker(910, componentName, servicePackageName, sessionId, compatMode);
        if (filterText != null) goto L12;
        int r2 = 0;
    L13:
        LogMaker r3 = r0.addTaggedData(911, Integer.valueOf(r2));
        if (response.getDatasets() == null) goto L17;
        r1 = response.getDatasets().size();
    L17:
        final LogMaker log = r3.addTaggedData(909, Integer.valueOf(r1));
        Runnable createFillUiRunnable = new AutoFillUI$$ExternalSyntheticLambda6(this, callback, context, response, r5, filterText, serviceLabel, serviceIcon, maxInputLengthForAutofill, log);
        if (isSaveUiShowing() == true) goto L20;
        this.mHandler.post(createFillUiRunnable);
        return;
    L20:
        if (Helper.sDebug == false) goto L22;
        Slog.d(TAG, "postpone fill UI request..");
    L22:
        this.mCreateFillUiRunnable = createFillUiRunnable;
        return;
    L12:
        r2 = filterText.length();
        goto L13
    L6:
        size = filterText.length();
        goto L7
    L8:
        r5 = focusedId;
        goto L9
    }

    private /* synthetic */ void lambda$showFillUi$6(final AutoFillUiCallback callback, Context context, final FillResponse response, final AutofillId focusedId, String filterText, CharSequence serviceLabel, Drawable serviceIcon, int maxInputLengthForAutofill, final LogMaker log) {
        if (callback == this.mCallback) goto L5;
        return;
    L5:
        hideAllUiThread(callback);
        this.mFillUi = new FillUi(context, response, focusedId, filterText, this.mOverlayControl, serviceLabel, serviceIcon, this.mUiModeMgr.isNightMode(), maxInputLengthForAutofill, new AnonymousClass1(this, log, callback, response, focusedId));
    }

    public void showSaveUi(final CharSequence serviceLabel, final Drawable serviceIcon, final String servicePackageName, SaveInfo info, final ValueFinder valueFinder, final ComponentName componentName, final AutoFillUiCallback callback, final Context context, final PendingUi pendingSaveUi, final boolean isUpdate, final boolean compatMode, final boolean showServiceIcon, final SaveEventLogger mSaveEventLogger) {
        if (Helper.sVerbose == false) goto L5;
        final SaveInfo r11 = info;
        Slogf.v(TAG, "showSaveUi(update=%b) for %s and display %d: %s", new Object[]{Boolean.valueOf(isUpdate), componentName.toShortString(), Integer.valueOf(context.getDisplayId()), r11});
    L6:
        int r2 = 0;
        if (r11.getRequiredIds() != null) goto L9;
        int r1 = 0;
    L10:
        int numIds = 0 + r1;
        if (r11.getOptionalIds() == null) goto L14;
        r2 = r11.getOptionalIds().length;
    L14:
        final LogMaker log = Helper.newLogMaker(916, componentName, servicePackageName, pendingSaveUi.sessionId, compatMode).addTaggedData(FrameworkStatsLog.FIRST_OVERLAY_STATE_CHANGED, Integer.valueOf(numIds + r2));
        if (isUpdate == false) goto L17;
        log.addTaggedData(1555, 1);
    L17:
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda10(this, callback, serviceLabel, servicePackageName, context, pendingSaveUi, componentName, r11, valueFinder, mSaveEventLogger, isUpdate, compatMode, showServiceIcon, log, serviceIcon));
        return;
    L9:
        r1 = r11.getRequiredIds().length;
        goto L10
    L5:
        r11 = info;
        goto L6
    }

    private /* synthetic */ void lambda$showSaveUi$7(final AutoFillUiCallback callback, CharSequence serviceLabel, String servicePackageName, Context context, final PendingUi pendingSaveUi, ComponentName componentName, SaveInfo info, ValueFinder valueFinder, final SaveEventLogger mSaveEventLogger, boolean isUpdate, boolean compatMode, boolean showServiceIcon, final LogMaker log, Drawable serviceIcon) {
        if (callback == this.mCallback) goto L5;
        return;
    L5:
        hideAllUiThread(callback);
        this.mSaveUiCallback = callback;
        if ("updatePasswd".equals(serviceLabel) == false) goto L11;
        if (getExt().isInTestProcess(servicePackageName) == true) goto L11;
        this.mSaveUi = getExt().newUpdatePasswdUi(context, pendingSaveUi, serviceLabel, servicePackageName, componentName, info, valueFinder, this.mOverlayControl, callback, mSaveEventLogger, this.mUiModeMgr, isUpdate, compatMode, showServiceIcon, log);
    L16:
        mSaveEventLogger.maybeSetLatencySaveUiDisplayMillis();
        return;
    L11:
        if ("savePasswd".equals(serviceLabel) == true) goto L13;
    L15:
        this.mSaveUi = new SaveUi(context, pendingSaveUi, serviceLabel, serviceIcon, servicePackageName, componentName, info, valueFinder, this.mOverlayControl, new AnonymousClass2(this, log, mSaveEventLogger, callback, pendingSaveUi), this.mUiModeMgr.isNightMode(), isUpdate, compatMode, showServiceIcon);
        goto L16
    L13:
        if (getExt().isInTestProcess(servicePackageName) == true) goto L15;
        this.mSaveUi = getExt().newSavePasswdUi(context, pendingSaveUi, serviceLabel, servicePackageName, componentName, info, valueFinder, this.mOverlayControl, callback, mSaveEventLogger, this.mUiModeMgr, isUpdate, compatMode, showServiceIcon, log);
        goto L16
    }

    public void showFillDialog(final AutofillId focusedId, FillResponse response, final String filterText, final String servicePackageName, final ComponentName componentName, final Drawable serviceIcon, final AutoFillUiCallback callback, int sessionId, boolean compatMode, final PresentationStatsEventLogger presentationStatsEventLogger, final Object sessionLock) {
        if (Helper.sVerbose == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("showFillDialog for ");
        r0.append(componentName.toShortString());
        r0.append(": ");
        final FillResponse r5 = response;
        r0.append(r5);
        Slog.v(TAG, r0.toString());
    L6:
        LogMaker r1 = Helper.newLogMaker(910, componentName, servicePackageName, sessionId, compatMode);
        int r2 = 0;
        if (filterText != null) goto L9;
        int r3 = 0;
    L10:
        LogMaker r4 = r1.addTaggedData(911, Integer.valueOf(r3));
        if (r5.getDatasets() == null) goto L14;
        r2 = r5.getDatasets().size();
    L14:
        final LogMaker log = r4.addTaggedData(909, Integer.valueOf(r2));
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda0(this, callback, r5, focusedId, filterText, serviceIcon, servicePackageName, componentName, sessionLock, presentationStatsEventLogger, log));
        return;
    L9:
        r3 = filterText.length();
        goto L10
    L5:
        r5 = response;
        goto L6
    }

    private /* synthetic */ void lambda$showFillDialog$8(final AutoFillUiCallback callback, final FillResponse response, final AutofillId focusedId, String filterText, Drawable serviceIcon, String servicePackageName, final ComponentName componentName, final Object sessionLock, final PresentationStatsEventLogger presentationStatsEventLogger, final LogMaker log) {
        if (callback == this.mCallback) goto L5;
        return;
    L5:
        hideAllUiThread(callback);
        this.mFillDialog = new DialogFillUi(this.mContext, response, focusedId, filterText, serviceIcon, servicePackageName, componentName, this.mOverlayControl, this.mUiModeMgr.isNightMode(), new AnonymousClass3(this, callback, sessionLock, presentationStatsEventLogger, response, componentName, focusedId, log));
    }

    public void onPendingSaveUi(final int operation, final IBinder token) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda2(this, operation, token));
    }

    private /* synthetic */ void lambda$onPendingSaveUi$9(int operation, IBinder token) {
        if (this.mSaveUi == null) goto L5;
        this.mSaveUi.onPendingUi(operation, token);
        return;
    L5:
        Slog.w(TAG, "onPendingSaveUi(" + operation + "): no save ui");
    }

    private /* synthetic */ void lambda$hideAll$10(AutoFillUiCallback callback) {
        hideAllUiThread(callback);
    }

    public void hideAll(final AutoFillUiCallback callback) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda8(this, callback));
    }

    private /* synthetic */ void lambda$destroyAll$11(PendingUi pendingSaveUi, AutoFillUiCallback callback, boolean notifyClient) {
        destroyAllUiThread(pendingSaveUi, callback, notifyClient);
    }

    public void destroyAll(final PendingUi pendingSaveUi, final AutoFillUiCallback callback, final boolean notifyClient) {
        this.mHandler.post(new AutoFillUI$$ExternalSyntheticLambda9(this, pendingSaveUi, callback, notifyClient));
    }

    public boolean isSaveUiShowing() {
        if (this.mSaveUi != null) goto L6;
        return false;
    L6:
        return this.mSaveUi.isShowing();
    }

    public boolean isFillDialogShowing() {
        if (this.mFillDialog != null) goto L6;
        return false;
    L6:
        return this.mFillDialog.isShowing();
    }

    public void dump(PrintWriter pw) {
        pw.println("Autofill UI");
        pw.print("  ");
        pw.print("Night mode: ");
        pw.println(this.mUiModeMgr.isNightMode());
        if (this.mFillUi == null) goto L5;
        pw.print("  ");
        pw.println("showsFillUi: true");
        this.mFillUi.dump(pw, "    ");
    L7:
        if (this.mSaveUi == null) goto L9;
        pw.print("  ");
        pw.println("showsSaveUi: true");
        this.mSaveUi.dump(pw, "    ");
    L11:
        if (this.mFillDialog == null) goto L13;
        pw.print("  ");
        pw.println("showsFillDialog: true");
        this.mFillDialog.dump(pw, "    ");
        return;
    L13:
        pw.print("  ");
        pw.println("showsFillDialog: false");
        return;
    L9:
        pw.print("  ");
        pw.println("showsSaveUi: false");
        goto L11
    L5:
        pw.print("  ");
        pw.println("showsFillUi: false");
        goto L7
    }

    private void hideFillUiUiThread(AutoFillUiCallback callback, boolean notifyClient) {
        if (this.mFillUi == null) goto L9;
        if (callback != null) goto L6;
    L7:
        this.mFillUi.destroy(notifyClient);
        this.mFillUi = null;
        return;
    L6:
        if (callback == this.mCallback) goto L7;
        return;
    }

    protected PendingUi hideSaveUiUiThread(AutoFillUiCallback callback) {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "hideSaveUiUiThread(): mSaveUi=" + this.mSaveUi + ", callback=" + callback + ", mCallback=" + this.mCallback);
    L6:
        if (this.mSaveUi != null) goto L8;
        return null;
    L8:
        if (this.mSaveUiCallback == callback) goto L10;
        return null;
    L10:
        return this.mSaveUi.hide();
    }

    private void hideFillDialogUiThread(AutoFillUiCallback callback) {
        if (this.mFillDialog == null) goto L9;
        if (callback != null) goto L6;
    L7:
        this.mFillDialog.destroy();
        this.mFillDialog = null;
        return;
    L6:
        if (callback == this.mCallback) goto L7;
        return;
    }

    protected void destroySaveUiUiThread(PendingUi pendingSaveUi, boolean notifyClient) {
        if (this.mSaveUi != null) goto L9;
        if (Helper.sDebug == false) goto L31;
        Slog.d(TAG, "destroySaveUiUiThread(): already destroyed");
        return;
    L31:
        return;
    L9:
        if (Helper.sDebug == false) goto L11;
        Slog.d(TAG, "destroySaveUiUiThread(): " + pendingSaveUi);
    L11:
        this.mSaveUi.destroy();
        this.mSaveUi = null;
        this.mSaveUiCallback = null;
        if (pendingSaveUi == null) goto L23;
        if (notifyClient == false) goto L23;
    L17:
        e = move-exception;
        Slog.e(TAG, "Error notifying client to set save UI state to hidden: " + e);
        goto L23
    L15:
        if (Helper.sDebug == false) goto L19;
        Slog.d(TAG, "destroySaveUiUiThread(): notifying client");     // Catch: RemoteException -> L17
    L19:
        pendingSaveUi.client.setSaveUiState(pendingSaveUi.sessionId, false);     // Catch: RemoteException -> L17
    L23:
        if (this.mCreateFillUiRunnable != null) goto L25;
        return;
    L25:
        if (Helper.sDebug == false) goto L27;
        Slog.d(TAG, "start the pending fill UI request..");
    L27:
        this.mHandler.post(this.mCreateFillUiRunnable);
        this.mCreateFillUiRunnable = null;
    }

    private void destroyAllUiThread(PendingUi pendingSaveUi, AutoFillUiCallback callback, boolean notifyClient) {
        hideFillUiUiThread(callback, notifyClient);
        hideFillDialogUiThread(callback);
        destroySaveUiUiThread(pendingSaveUi, notifyClient);
    }

    private void hideAllUiThread(AutoFillUiCallback callback) {
        hideFillUiUiThread(callback, true);
        hideFillDialogUiThread(callback);
        PendingUi pendingSaveUi = hideSaveUiUiThread(callback);
        if (pendingSaveUi != null) goto L5;
        return;
    L5:
        if (pendingSaveUi.getState() == 4) goto L7;
        return;
    L7:
        if (Helper.sDebug == false) goto L9;
        Slog.d(TAG, "hideAllUiThread(): destroying Save UI because pending restoration is finished");
    L9:
        destroySaveUiUiThread(pendingSaveUi, true);
    }

    public IExtAutoFillUI getExt() {
        return this.mExt;
    }
}
