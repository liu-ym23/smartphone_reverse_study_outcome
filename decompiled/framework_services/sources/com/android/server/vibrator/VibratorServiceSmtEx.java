package com.android.server.vibrator;

import android.os.CombinedVibration;
import android.os.IBinder;
import android.os.IVibratorServiceSmtEx;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import com.android.server.pm.PackageManagerService;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class VibratorServiceSmtEx extends IVibratorServiceSmtEx.Stub {
    private static final String SYSTEM_UI_PACKAGE = "com.android.systemui";
    private static final String TAG = "VibratorService";
    private static HashSet<String> sPrivilegedVibratePackages;
    private static HashSet<String> sPrivilegedVibratePackagesAlways;
    protected boolean mBytedanceGlobalVibrationEnabled;
    private IBinder.DeathRecipient mDeathRecipient;
    private IBinder mDisableVibrateClient;
    private VibratorManagerService mService;

    /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder.DeathRecipient m9355$$Nest$fgetmDeathRecipient(VibratorServiceSmtEx r0) {
        return r0.mDeathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisableVibrateClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m9356$$Nest$fgetmDisableVibrateClient(VibratorServiceSmtEx r0) {
        return r0.mDisableVibrateClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisableVibrateClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9357$$Nest$fputmDisableVibrateClient(VibratorServiceSmtEx r0, IBinder r1) {
        r0.mDisableVibrateClient = r1;
    }

    static {
        sPrivilegedVibratePackages = new HashSet();
        sPrivilegedVibratePackages.add("com.android.systemui");
        sPrivilegedVibratePackages.add("com.bytedanceos.sara");
        sPrivilegedVibratePackages.add(PackageManagerService.PLATFORM_PACKAGE_NAME);
        sPrivilegedVibratePackages.add("com.bytedanceos.drivingmode");
        sPrivilegedVibratePackages.add("com.android.settings");
        sPrivilegedVibratePackagesAlways = new HashSet();
        sPrivilegedVibratePackagesAlways.add("com.android.systemui");
        sPrivilegedVibratePackagesAlways.add(PackageManagerService.PLATFORM_PACKAGE_NAME);
    }

    public VibratorServiceSmtEx(VibratorManagerService service) {
        this.mBytedanceGlobalVibrationEnabled = true;
        this.mDeathRecipient = new AnonymousClass1(this);
        this.mService = service;
    }

    public void vibratePatternWithPrivilege(int type, int uid, String packageName, long[] pattern, int repeat, IBinder token) {
        if (priviligeCheck(type, packageName) == true) goto L6;
        return;
    L6:
        if (type != 1) goto L8;
        int privateFlags = 0 | 512;
        int privateFlags2 = privateFlags;
    L11:
        VibrationAttributes attributes = new VibrationAttributes.Builder().build();
        attributes.setPrivateFlag(privateFlags2);
        this.mService.vibrate(uid, 0, packageName, CombinedVibration.createParallel(VibrationEffect.createWaveform(pattern, repeat)), attributes, "private", token);
        return;
    L8:
        if (type != 0) goto L10;
        int privateFlags3 = 0 | 256;
        privateFlags2 = privateFlags3;
        goto L11
    L10:
        privateFlags2 = 0;
        goto L11
    }

    public void vibrateEffectWithPrivilege(int type, int uid, String packageName, VibrationEffect effect, IBinder token) {
        if (priviligeCheck(type, packageName) == true) goto L5;
        return;
    L5:
        int privateFlags = 0;
        if (type != 1) goto L8;
        privateFlags = 0 | 512;
    L10:
        VibrationAttributes attributes = new VibrationAttributes.Builder().build();
        attributes.setPrivateFlag(privateFlags);
        this.mService.vibrate(uid, 0, packageName, CombinedVibration.createParallel(effect), attributes, "private", token);
        return;
    L8:
        if (type != 0) goto L10;
        privateFlags = 0 | 256;
        goto L10
    }

    private boolean priviligeCheck(int type, String packageName) {
        switch(type) {
            case 0: goto L9;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if (sPrivilegedVibratePackagesAlways.contains(packageName) == true) goto L11;
        return false;
    L11:
        return true;
    L9:
        if (sPrivilegedVibratePackages.contains(packageName) == true) goto L13;
        return false;
    L13:
        return true;
    }
}
