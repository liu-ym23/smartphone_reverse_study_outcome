package com.android.server.inputmethod;

import android.R;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.EventLog;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.inputmethod.InlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.InlineSuggestionsRequestInfo;
import com.android.internal.inputmethod.InputBindResult;
import com.android.server.EventLogTags;
import com.android.server.wm.WindowManagerInternal;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodBindingController {
    static final boolean DEBUG = false;
    static final int IME_CONNECTION_BIND_FLAGS = 0;
    static final int IME_VISIBLE_BIND_FLAGS = 738201601;
    private static final String TAG = null;
    static final long TIME_TO_RECONNECT = 3000;
    private final AutofillSuggestionsController mAutofillController;
    private int mBackDisposition;
    private final Context mContext;
    private String mCurId;
    private Intent mCurIntent;
    private IInputMethodInvoker mCurMethod;
    private int mCurMethodUid;
    private int mCurSeq;
    private IBinder mCurToken;
    private int mCurTokenDisplayId;
    private InputMethodSubtype mCurrentSubtype;
    private int mDeviceIdToShowIme;
    private int mDisplayIdToShowIme;
    private boolean mHasMainConnection;
    private final int mImeConnectionBindFlags;
    private int mImeWindowVis;
    private long mLastBindTime;
    private CountDownLatch mLatchForTesting;
    private final ServiceConnection mMainConnection;
    private final PackageManagerInternal mPackageManagerInternal;
    private String mSelectedMethodId;
    private final InputMethodManagerService mService;
    private boolean mSupportsConnectionlessStylusHw;
    private boolean mSupportsStylusHw;
    private final int mUserId;
    private boolean mVisibleBound;
    private final ServiceConnection mVisibleConnection;
    private final WindowManagerInternal mWindowManagerInternal;

    /* JADX INFO: renamed from: -$$Nest$fgetmAutofillController, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutofillSuggestionsController m4674$$Nest$fgetmAutofillController(InputMethodBindingController r0) {
        return r0.mAutofillController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4675$$Nest$fgetmCurId(InputMethodBindingController r0) {
        return r0.mCurId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m4676$$Nest$fgetmCurIntent(InputMethodBindingController r0) {
        return r0.mCurIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurMethod, reason: not valid java name */
    static /* bridge */ /* synthetic */ IInputMethodInvoker m4677$$Nest$fgetmCurMethod(InputMethodBindingController r0) {
        return r0.mCurMethod;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurMethodUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4678$$Nest$fgetmCurMethodUid(InputMethodBindingController r0) {
        return r0.mCurMethodUid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m4679$$Nest$fgetmCurToken(InputMethodBindingController r0) {
        return r0.mCurToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLatchForTesting, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountDownLatch m4680$$Nest$fgetmLatchForTesting(InputMethodBindingController r0) {
        return r0.mLatchForTesting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m4681$$Nest$fgetmPackageManagerInternal(InputMethodBindingController r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputMethodManagerService m4682$$Nest$fgetmService(InputMethodBindingController r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportsConnectionlessStylusHw, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4683$$Nest$fgetmSupportsConnectionlessStylusHw(InputMethodBindingController r0) {
        return r0.mSupportsConnectionlessStylusHw;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportsStylusHw, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4684$$Nest$fgetmSupportsStylusHw(InputMethodBindingController r0) {
        return r0.mSupportsStylusHw;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4685$$Nest$fgetmUserId(InputMethodBindingController r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurMethod, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4686$$Nest$fputmCurMethod(InputMethodBindingController r0, IInputMethodInvoker r1) {
        r0.mCurMethod = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurMethodUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4687$$Nest$fputmCurMethodUid(InputMethodBindingController r0, int r1) {
        r0.mCurMethodUid = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastBindTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4688$$Nest$fputmLastBindTime(InputMethodBindingController r0, long r1) {
        r0.mLastBindTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSupportsConnectionlessStylusHw, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4689$$Nest$fputmSupportsConnectionlessStylusHw(InputMethodBindingController r0, boolean r1) {
        r0.mSupportsConnectionlessStylusHw = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSupportsStylusHw, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4690$$Nest$fputmSupportsStylusHw(InputMethodBindingController r0, boolean r1) {
        r0.mSupportsStylusHw = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearCurMethodAndSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4691$$Nest$mclearCurMethodAndSessions(InputMethodBindingController r0) {
        r0.clearCurMethodAndSessions();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4692$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = InputMethodBindingController.class.getSimpleName();
        IME_CONNECTION_BIND_FLAGS = 1082654725;
    }

    InputMethodBindingController(int userId, InputMethodManagerService service) {
        this(userId, service, IME_CONNECTION_BIND_FLAGS, null);
    }

    InputMethodBindingController(int userId, InputMethodManagerService service, int imeConnectionBindFlags, CountDownLatch latchForTesting) {
        this.mCurMethodUid = -1;
        this.mCurTokenDisplayId = -1;
        this.mDisplayIdToShowIme = -1;
        this.mDeviceIdToShowIme = 0;
        this.mBackDisposition = 0;
        this.mVisibleConnection = new AnonymousClass1(this);
        this.mMainConnection = new AnonymousClass2(this);
        this.mUserId = userId;
        this.mService = service;
        this.mContext = this.mService.mContext;
        this.mAutofillController = new AutofillSuggestionsController(this);
        this.mPackageManagerInternal = this.mService.mPackageManagerInternal;
        this.mWindowManagerInternal = this.mService.mWindowManagerInternal;
        this.mImeConnectionBindFlags = imeConnectionBindFlags;
        this.mLatchForTesting = latchForTesting;
    }

    long getLastBindTime() {
        return this.mLastBindTime;
    }

    boolean hasMainConnection() {
        return this.mHasMainConnection;
    }

    String getCurId() {
        return this.mCurId;
    }

    String getSelectedMethodId() {
        return this.mSelectedMethodId;
    }

    void setSelectedMethodId(String selectedMethodId) {
        this.mSelectedMethodId = selectedMethodId;
    }

    InputMethodInfo getSelectedMethod() {
        return InputMethodSettingsRepository.get(this.mUserId).getMethodMap().get(this.mSelectedMethodId);
    }

    IBinder getCurToken() {
        return this.mCurToken;
    }

    InputMethodSubtype getCurrentSubtype() {
        return this.mCurrentSubtype;
    }

    void setCurrentSubtype(InputMethodSubtype currentSubtype) {
        this.mCurrentSubtype = currentSubtype;
    }

    int getCurTokenDisplayId() {
        return this.mCurTokenDisplayId;
    }

    Intent getCurIntent() {
        return this.mCurIntent;
    }

    int getSequenceNumber() {
        return this.mCurSeq;
    }

    void advanceSequenceNumber() {
        this.mCurSeq++;
        if (this.mCurSeq > 0) goto L6;
        this.mCurSeq = 1;
        return;
    }

    IInputMethodInvoker getCurMethod() {
        return this.mCurMethod;
    }

    int getCurMethodUid() {
        return this.mCurMethodUid;
    }

    boolean isVisibleBound() {
        return this.mVisibleBound;
    }

    boolean supportsStylusHandwriting() {
        return this.mSupportsStylusHw;
    }

    boolean supportsConnectionlessStylusHandwriting() {
        return this.mSupportsConnectionlessStylusHw;
    }

    void invalidateAutofillSession() {
        this.mAutofillController.invalidateAutofillSession();
    }

    void onCreateInlineSuggestionsRequest(InlineSuggestionsRequestInfo requestInfo, InlineSuggestionsRequestCallback callback, boolean touchExplorationEnabled) {
        this.mAutofillController.onCreateInlineSuggestionsRequest(requestInfo, callback, touchExplorationEnabled);
    }

    IBinder getCurHostInputToken() {
        return this.mAutofillController.getCurHostInputToken();
    }

    void unbindCurrentMethod() {
        if (isVisibleBound() == false) goto L6;
        unbindVisibleConnection();
    L6:
        if (hasMainConnection() == false) goto L9;
        unbindMainConnection();
    L9:
        if (getCurToken() == null) goto L11;
        this.mService.resetSystemUiLocked(this);
        removeCurrentToken();
        this.mAutofillController.onResetSystemUi();
    L11:
        this.mCurId = null;
        clearCurMethodAndSessions();
    }

    private void clearCurMethodAndSessions() {
        this.mService.clearClientSessionsLocked(this);
        this.mCurMethod = null;
        this.mCurMethodUid = -1;
    }

    private void removeCurrentToken() {
        this.mWindowManagerInternal.removeWindowToken(this.mCurToken, true, false, this.mCurTokenDisplayId);
        this.mCurToken = null;
        this.mCurTokenDisplayId = -1;
    }

    InputBindResult bindCurrentMethod() {
        if (this.mSelectedMethodId != null) goto L6;
        Slog.e(TAG, "mSelectedMethodId is null!");
        return InputBindResult.NO_IME;
    L6:
        InputMethodInfo info = InputMethodSettingsRepository.get(this.mUserId).getMethodMap().get(this.mSelectedMethodId);
        if (info == null) goto L15;
        this.mCurIntent = createImeBindingIntent(info.getComponent());
        if (bindCurrentInputMethodServiceMainConnection() == false) goto L12;
        this.mCurId = info.getId();
        this.mLastBindTime = SystemClock.uptimeMillis();
        this.mCurToken = new Binder();
        this.mCurTokenDisplayId = this.mDisplayIdToShowIme;
        this.mWindowManagerInternal.addWindowToken(this.mCurToken, 2011, this.mDisplayIdToShowIme, null);
        return new InputBindResult(2, null, null, null, this.mCurId, this.mCurSeq, false);
    L12:
        Slog.w("InputMethodManagerService", "Failure connecting to input method service: " + this.mCurIntent);
        this.mCurIntent = null;
        return InputBindResult.IME_NOT_CONNECTED;
    L15:
        throw new IllegalArgumentException("Unknown id: " + this.mSelectedMethodId);
    }

    private Intent createImeBindingIntent(ComponentName component) {
        Intent intent = new Intent("android.view.InputMethod");
        intent.setComponent(component);
        intent.putExtra("android.intent.extra.client_label", R.string.lock_to_app_unlock_pattern);
        ActivityOptions options = ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(2);
        intent.putExtra("android.intent.extra.client_intent", PendingIntent.getActivity(this.mContext, 0, new Intent("android.settings.INPUT_METHOD_SETTINGS"), 67108864, options.toBundle()));
        return intent;
    }

    private void unbindMainConnection() {
        this.mContext.unbindService(this.mMainConnection);
        this.mHasMainConnection = false;
    }

    void unbindVisibleConnection() {
        this.mContext.unbindService(this.mVisibleConnection);
        this.mVisibleBound = false;
    }

    private boolean bindCurrentInputMethodService(ServiceConnection conn, int flags) {
        if (this.mCurIntent == null) goto L8;
        if (conn == null) goto L8;
        return this.mContext.bindServiceAsUser(this.mCurIntent, conn, flags, new UserHandle(this.mUserId));
    L8:
        Slog.e(TAG, "--- bind failed: service = " + this.mCurIntent + ", conn = " + conn);
        return false;
    }

    private boolean bindCurrentInputMethodServiceMainConnection() {
        this.mHasMainConnection = bindCurrentInputMethodService(this.mMainConnection, this.mImeConnectionBindFlags);
        return this.mHasMainConnection;
    }

    void setCurrentMethodVisible() {
        if (this.mCurMethod == null) goto L11;
        if (hasMainConnection() == true) goto L7;
        return;
    L7:
        if (isVisibleBound() == true) goto L19;
        this.mVisibleBound = bindCurrentInputMethodService(this.mVisibleConnection, IME_VISIBLE_BIND_FLAGS);
        return;
    L19:
        return;
    L11:
        if (hasMainConnection() == true) goto L14;
        bindCurrentMethod();
        return;
    L14:
        long bindingDuration = SystemClock.uptimeMillis() - this.mLastBindTime;
        if (bindingDuration < 3000) goto L20;
        EventLog.writeEvent(EventLogTags.IMF_FORCE_RECONNECT_IME, new Object[]{getSelectedMethodId(), Long.valueOf(bindingDuration), 1});
        Slog.w(TAG, "Force disconnect/connect to the IME in setCurrentMethodVisible()");
        unbindMainConnection();
        bindCurrentInputMethodServiceMainConnection();
        return;
    }

    void setCurrentMethodNotVisible() {
        if (isVisibleBound() == false) goto L6;
        unbindVisibleConnection();
        return;
    }

    InputMethodSubtype getCurrentInputMethodSubtype() {
        String selectedMethodId = getSelectedMethodId();
        if (selectedMethodId != null) goto L5;
        return null;
    L5:
        InputMethodSettings settings = InputMethodSettingsRepository.get(this.mUserId);
        InputMethodInfo imi = settings.getMethodMap().get(selectedMethodId);
        if (imi != null) goto L8;
    L12:
        return null;
    L8:
        if (imi.getSubtypeCount() == 0) goto L12;
        InputMethodSubtype subtype = SubtypeUtils.getCurrentInputMethodSubtype(imi, settings, this.mCurrentSubtype);
        this.mCurrentSubtype = subtype;
        return subtype;
    }

    void setDisplayIdToShowIme(int displayId) {
        this.mDisplayIdToShowIme = displayId;
    }

    int getDisplayIdToShowIme() {
        return this.mDisplayIdToShowIme;
    }

    void setDeviceIdToShowIme(int deviceId) {
        this.mDeviceIdToShowIme = deviceId;
    }

    int getDeviceIdToShowIme() {
        return this.mDeviceIdToShowIme;
    }

    int getUserId() {
        return this.mUserId;
    }

    void setImeWindowVis(int imeWindowVis) {
        this.mImeWindowVis = imeWindowVis;
    }

    int getImeWindowVis() {
        return this.mImeWindowVis;
    }

    int getBackDisposition() {
        return this.mBackDisposition;
    }

    void setBackDisposition(int backDisposition) {
        this.mBackDisposition = backDisposition;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "mSelectedMethodId=" + this.mSelectedMethodId);
        pw.println(prefix + "mCurrentSubtype=" + this.mCurrentSubtype);
        pw.println(prefix + "mCurSeq=" + this.mCurSeq);
        pw.println(prefix + "mCurId=" + this.mCurId);
        pw.println(prefix + "mHasMainConnection=" + this.mHasMainConnection);
        pw.println(prefix + "mVisibleBound=" + this.mVisibleBound);
        pw.println(prefix + "mCurToken=" + this.mCurToken);
        pw.println(prefix + "mCurTokenDisplayId=" + this.mCurTokenDisplayId);
        pw.println(prefix + "mCurHostInputToken=" + getCurHostInputToken());
        pw.println(prefix + "mCurIntent=" + this.mCurIntent);
        pw.println(prefix + "mCurMethod=" + this.mCurMethod);
        pw.println(prefix + "mImeWindowVis=" + this.mImeWindowVis);
        pw.println(prefix + "mBackDisposition=" + this.mBackDisposition);
        pw.println(prefix + "mDisplayIdToShowIme=" + this.mDisplayIdToShowIme);
        pw.println(prefix + "mDeviceIdToShowIme=" + this.mDeviceIdToShowIme);
        pw.println(prefix + "mSupportsStylusHw=" + this.mSupportsStylusHw);
        pw.println(prefix + "mSupportsConnectionlessStylusHw=" + this.mSupportsConnectionlessStylusHw);
    }

    InputBindResult bindMethod(String imeId) {
        if (imeId != null) goto L5;
        Slog.e(TAG, "mSelectedMethodId is null!");
        return InputBindResult.NO_IME;
    L5:
        InputMethodInfo info = InputMethodSettingsRepository.get(this.mUserId).getMethodMap().get(imeId);
        if (info == null) goto L14;
        this.mCurIntent = createImeBindingIntent(info.getComponent());
        if (bindCurrentInputMethodServiceMainConnection() == false) goto L11;
        this.mCurId = info.getId();
        this.mLastBindTime = SystemClock.uptimeMillis();
        this.mCurToken = new Binder();
        this.mCurTokenDisplayId = this.mDisplayIdToShowIme;
        this.mWindowManagerInternal.addWindowToken(this.mCurToken, 2011, this.mDisplayIdToShowIme, null);
        return new InputBindResult(2, null, null, null, this.mCurId, this.mCurSeq, false);
    L11:
        Slog.w("InputMethodManagerService", "Failure connecting to input method service: " + this.mCurIntent);
        this.mCurIntent = null;
        return InputBindResult.IME_NOT_CONNECTED;
    L14:
        throw new IllegalArgumentException("Unknown id: " + imeId);
    }
}
