package com.android.server.devicepolicy;

import android.content.Context;
import android.content.pm.VerifierDeviceIdentity;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.security.identity.Util;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.util.Preconditions;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
class EnterpriseSpecificIdCalculator {
    private static final int ESID_LENGTH = 16;
    private static final int PADDED_ENTERPRISE_ID_LENGTH = 64;
    private static final int PADDED_HW_ID_LENGTH = 16;
    private static final int PADDED_PROFILE_OWNER_LENGTH = 64;
    private final String mImei;
    private final String mMacAddress;
    private final String mMeid;
    private final String mSerialNumber;

    EnterpriseSpecificIdCalculator(String imei, String meid, String serialNumber, String macAddress) {
        this.mImei = imei;
        this.mMeid = meid;
        this.mSerialNumber = serialNumber;
        this.mMacAddress = macAddress;
    }

    EnterpriseSpecificIdCalculator(Context context) {
        TelephonyManager telephonyService = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        if (telephonyService == null) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "Unable to access telephony service");
        this.mImei = telephonyService.getImei(0);
        String meid = telephonyService.getMeid(0);     // Catch: UnsupportedOperationException -> L9
    L11:
        this.mMeid = meid;
        this.mSerialNumber = Build.getSerial();
        WifiManager wifiManager = (WifiManager) context.getSystemService(WifiManager.class);
        String macAddress = "";
        if (context.getPackageManager().hasSystemFeature("android.hardware.wifi") == false) goto L18;
        String[] macAddresses = wifiManager.getFactoryMacAddresses();
        if (macAddresses == null) goto L18;
        if (macAddresses.length <= 0) goto L18;
        macAddress = macAddresses[0];
    L18:
        this.mMacAddress = macAddress;
        return;
    L10:
        meid = null;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private static String getPaddedTruncatedString(String input, int maxLength) {
        String paddedValue = String.format("%" + maxLength + "s", new Object[]{input});
        return paddedValue.substring(0, maxLength);
    }

    private static String getPaddedHardwareIdentifier(String hardwareIdentifier) {
        if (hardwareIdentifier != null) goto L5;
        hardwareIdentifier = "";
    L5:
        return getPaddedTruncatedString(hardwareIdentifier, 16);
    }

    String getPaddedImei() {
        return getPaddedHardwareIdentifier(this.mImei);
    }

    String getPaddedMeid() {
        return getPaddedHardwareIdentifier(this.mMeid);
    }

    String getPaddedSerialNumber() {
        return getPaddedHardwareIdentifier(this.mSerialNumber);
    }

    String getPaddedProfileOwnerName(String profileOwnerPackage) {
        return getPaddedTruncatedString(profileOwnerPackage, 64);
    }

    String getPaddedEnterpriseId(String enterpriseId) {
        return getPaddedTruncatedString(enterpriseId, 64);
    }

    public String calculateEnterpriseId(String profileOwnerPackage, String enterpriseIdString) {
        boolean r2 = true;
        Preconditions.checkArgument(!TextUtils.isEmpty(profileOwnerPackage), "owner package must be specified.");
        if (enterpriseIdString != null) goto L5;
    L8:
        Preconditions.checkArgument(r2, "enterprise ID must either be null or non-empty.");
        if (enterpriseIdString != null) goto L11;
        String enterpriseIdString2 = "";
    L12:
        byte[] serialNumber = getPaddedSerialNumber().getBytes();
        byte[] imei = getPaddedImei().getBytes();
        byte[] meid = getPaddedMeid().getBytes();
        byte[] macAddress = this.mMacAddress.getBytes();
        int totalIdentifiersLength = ((serialNumber.length + imei.length) + meid.length) + macAddress.length;
        ByteBuffer fixedIdentifiers = ByteBuffer.allocate(totalIdentifiersLength);
        fixedIdentifiers.put(serialNumber);
        fixedIdentifiers.put(imei);
        fixedIdentifiers.put(meid);
        fixedIdentifiers.put(macAddress);
        byte[] dpcPackage = getPaddedProfileOwnerName(profileOwnerPackage).getBytes();
        byte[] enterpriseId = getPaddedEnterpriseId(enterpriseIdString2).getBytes();
        ByteBuffer info = ByteBuffer.allocate(dpcPackage.length + enterpriseId.length);
        info.put(dpcPackage);
        info.put(enterpriseId);
        byte[] esidBytes = Util.computeHkdf("HMACSHA256", fixedIdentifiers.array(), null, info.array(), 16);
        ByteBuffer esidByteBuffer = ByteBuffer.wrap(esidBytes);
        VerifierDeviceIdentity firstId = new VerifierDeviceIdentity(esidByteBuffer.getLong());
        VerifierDeviceIdentity secondId = new VerifierDeviceIdentity(esidByteBuffer.getLong());
        return firstId.toString() + secondId.toString();
    L11:
        enterpriseIdString2 = enterpriseIdString;
        goto L12
    L5:
        if (enterpriseIdString.isEmpty() == false) goto L8;
        r2 = false;
        goto L8
    }
}
