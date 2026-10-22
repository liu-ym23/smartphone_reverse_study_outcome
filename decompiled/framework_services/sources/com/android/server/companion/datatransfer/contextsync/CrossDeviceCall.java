package com.android.server.companion.datatransfer.contextsync;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.telecom.Call;
import android.telecom.CallAudioState;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import android.util.Slog;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CrossDeviceCall {
    private static final String SEPARATOR = "::";
    private static final String TAG = "CrossDeviceCall";
    private final Call mCall;
    private String mCallerDisplayName;
    private int mCallerDisplayNamePresentation;
    private byte[] mCallingAppIcon;
    private String mCallingAppName;
    private final String mCallingAppPackageName;
    private String mContactDisplayName;
    private final Set<Integer> mControls;
    private int mDirection;
    private Uri mHandle;
    private int mHandlePresentation;
    private final String mId;
    private final boolean mIsCallPlacedByContextSync;
    boolean mIsEnterprise;
    private boolean mIsMuted;
    private final String mSerializedPhoneAccountHandle;
    private int mStatus;
    private final int mUserId;

    public CrossDeviceCall(Context context, Call call, CallAudioState callAudioState) {
        this(context, call, call.getDetails(), callAudioState);
    }

    CrossDeviceCall(Context context, Call.Details callDetails, CallAudioState callAudioState) {
        this(context, null, callDetails, callAudioState);
    }

    private CrossDeviceCall(Context context, Call call, Call.Details callDetails, CallAudioState callAudioState) {
        boolean r0 = false;
        this.mStatus = 0;
        this.mControls = new HashSet();
        this.mCall = call;
        if (callDetails.getIntentExtras() == null) goto L5;
        String predefinedId = callDetails.getIntentExtras().getString(CrossDeviceSyncController.EXTRA_CALL_ID);
    L6:
        String generatedId = UUID.randomUUID().toString();
        if (predefinedId == null) goto L9;
        String r5 = generatedId + SEPARATOR + predefinedId;
    L10:
        this.mId = r5;
        if (call == null) goto L13;
        call.putExtra(CrossDeviceSyncController.EXTRA_CALL_ID, this.mId);
    L13:
        PhoneAccountHandle handle = callDetails.getAccountHandle();
        if (handle == null) goto L16;
        int r6 = handle.getUserHandle().getIdentifier();
    L17:
        this.mUserId = r6;
        if (handle != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        this.mIsCallPlacedByContextSync = r7;
        String r8 = "";
        if (handle == null) goto L26;
        String r9 = callDetails.getAccountHandle().getComponentName().getPackageName();
    L27:
        this.mCallingAppPackageName = r9;
        if (handle == null) goto L31;
        r8 = handle.getId() + SEPARATOR + handle.getComponentName().flattenToString();
    L31:
        this.mSerializedPhoneAccountHandle = r8;
        if ((callDetails.getCallProperties() & 32) != 32) goto L34;
        boolean r4 = true;
    L35:
        this.mIsEnterprise = r4;
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = packageManager.getApplicationInfoAsUser(this.mCallingAppPackageName, PackageManager.ApplicationInfoFlags.of(0), this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L38
        this.mCallingAppName = packageManager.getApplicationLabel(applicationInfo).toString();     // Catch: PackageManager.NameNotFoundException -> L38
        this.mCallingAppIcon = BitmapUtils.renderDrawableToByteArray(packageManager.getApplicationIcon(applicationInfo));     // Catch: PackageManager.NameNotFoundException -> L38
    L40:
        if (callAudioState != null) goto L42;
    L44:
        this.mIsMuted = r0;
        updateCallDetails(callDetails);
        return;
    L42:
        if (callAudioState.isMuted() == false) goto L44;
        r0 = true;
    L38:
        e = move-exception;
        Slog.e(TAG, "Could not get application info for package " + this.mCallingAppPackageName, e);
        goto L40
    L34:
        r4 = false;
        goto L35
    L26:
        r9 = "";
        goto L27
    L20:
        if (new ComponentName(context, CallMetadataSyncConnectionService.class).equals(handle.getComponentName()) == false) goto L22;
        r7 = true;
        goto L23
    L16:
        r6 = -1;
        goto L17
    L9:
        r5 = generatedId;
        goto L10
    L5:
        predefinedId = null;
        goto L6
    }

    public void updateMuted(boolean isMuted) {
        this.mIsMuted = isMuted;
        updateCallDetails(this.mCall.getDetails());
    }

    public void updateSilencedIfRinging() {
        if (this.mStatus != 1) goto L5;
        this.mStatus = 4;
    L5:
        this.mControls.remove(3);
    }

    void updateCallDetails(Call.Details callDetails) {
        this.mCallerDisplayName = callDetails.getCallerDisplayName();
        this.mCallerDisplayNamePresentation = callDetails.getCallerDisplayNamePresentation();
        this.mContactDisplayName = callDetails.getContactDisplayName();
        this.mHandle = callDetails.getHandle();
        this.mHandlePresentation = callDetails.getHandlePresentation();
        int direction = callDetails.getCallDirection();
        if (direction != 0) goto L5;
        this.mDirection = 1;
    L8:
        this.mStatus = convertStateToStatus(callDetails.getState());
        this.mControls.clear();
        int r5 = 8;
        if (this.mStatus != 8) goto L11;
        this.mControls.add(6);
    L11:
        int r6 = 4;
        if (this.mStatus != 1) goto L14;
    L15:
        this.mControls.add(1);
        this.mControls.add(2);
        if (this.mStatus != 1) goto L19;
        this.mControls.add(3);
    L19:
        if (this.mStatus != 2) goto L21;
    L22:
        this.mControls.add(6);
        if (callDetails.can(1) == false) goto L30;
        Set<Integer> r2 = this.mControls;
        if (this.mStatus == 3) goto L28;
        r5 = 7;
    L28:
        r2.add(Integer.valueOf(r5));
    L30:
        if (this.mStatus == 2) goto L32;
        return;
    L32:
        if (callDetails.can(64) == false) goto L40;
        Set<Integer> r1 = this.mControls;
        if (this.mIsMuted == false) goto L37;
        r6 = 5;
    L37:
        r1.add(Integer.valueOf(r6));
        return;
    L40:
        return;
    L21:
        if (this.mStatus != 3) goto L30;
    L14:
        if (this.mStatus != 4) goto L19;
    L5:
        if (direction != 1) goto L7;
        this.mDirection = 2;
        goto L8
    L7:
        this.mDirection = 0;
        goto L8
    }

    public static int convertStateToStatus(int callState) {
        switch(callState) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L3;
            case 6: goto L3;
            case 7: goto L9;
            case 8: goto L3;
            case 9: goto L3;
            case 10: goto L3;
            case 11: goto L3;
            case 12: goto L7;
            case 13: goto L5;
            default: goto L3;
        };
    L3:
        Slog.e(TAG, "Couldn't resolve state to status: " + callState);
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 7;
    L11:
        return 2;
    L13:
        return 3;
    L15:
        return 1;
    L17:
        return 8;
    }

    public static int convertStatusToState(int status) {
        switch(status) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L17;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 1;
    L7:
        return 7;
    L9:
        return 13;
    L11:
        return 12;
    L13:
        return 3;
    L15:
        return 4;
    L17:
        return 2;
    }

    public String getId() {
        return this.mId;
    }

    public Call getCall() {
        return this.mCall;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public String getCallingAppName() {
        return this.mCallingAppName;
    }

    public byte[] getCallingAppIcon() {
        return this.mCallingAppIcon;
    }

    public String getCallingAppPackageName() {
        return this.mCallingAppPackageName;
    }

    public String getSerializedPhoneAccountHandle() {
        return this.mSerializedPhoneAccountHandle;
    }

    public String getReadableCallerId(boolean isAdminBlocked) {
        if (this.mIsEnterprise == false) goto L8;
        if (isAdminBlocked == false) goto L8;
        return getNonContactString();
    L8:
        if (TextUtils.isEmpty(this.mContactDisplayName) == false) goto L11;
        return getNonContactString();
    L11:
        return this.mContactDisplayName;
    }

    private String getNonContactString() {
        if (TextUtils.isEmpty(this.mCallerDisplayName) == true) goto L9;
        if (this.mCallerDisplayNamePresentation != 1) goto L9;
        return this.mCallerDisplayName;
    L9:
        if (this.mHandle != null) goto L11;
        return null;
    L11:
        if (this.mHandle.getSchemeSpecificPart() != null) goto L13;
        return null;
    L13:
        if (this.mHandlePresentation == 1) goto L15;
        return null;
    L15:
        return this.mHandle.getSchemeSpecificPart();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public Set<Integer> getControls() {
        return this.mControls;
    }

    public boolean isCallPlacedByContextSync() {
        return this.mIsCallPlacedByContextSync;
    }

    void doAccept() {
        this.mCall.answer(0);
    }

    void doReject() {
        if (this.mStatus != 1) goto L6;
        this.mCall.reject(1);
        return;
    }

    void doEnd() {
        this.mCall.disconnect();
    }

    void doPutOnHold() {
        this.mCall.hold();
    }

    void doTakeOffHold() {
        this.mCall.unhold();
    }
}
