package com.android.ttcjpaysdk.kmp.base.util;

import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.kmp.common.context.DevicePlatform;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u001c¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/util/DeviceUtils;", "", "<init>", "()V", "getDevicePlatform", "", "getDeviceId", "getInstallId", "getOsApi", "getCDid", "getNetworkAccessType", "getDeviceModel", "getDeviceBrand", "getOsVersion", "getWifiSignal", "", "callback", "Lcom/bytedance/kmp/common/context/CallbackInt1;", "getBatterySOC", "", "getAppDir", "getFilesDir", "getCacheDir", "getTempDir", "getDataBaseDir", "getLanguage", "getRegion", "getStartupTime", "", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceUtils {
    public static final int $stable = 0;
    public static final DeviceUtils INSTANCE = null;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[DevicePlatform.values().length];
            r100[DevicePlatform.ANDROID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DevicePlatform.IOS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DevicePlatform.HARMONY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        INSTANCE = new DeviceUtils();
    }

    private DeviceUtils() {
    }

    public final String getDevicePlatform() {
        int r100 = n96.a.f518414a;
        DevicePlatform r101 = DevicePlatform.ANDROID;
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L5;
        return "android";
    L5:
        if (r102 != 2) goto L7;
        return BackupSeiMessage.SOURCE_IOS;
    L7:
        if (r102 != 3) goto L10;
        return "openHarmony";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final String getAppDir() {
        return n96.a.b().p0();
    }

    public final int getBatterySOC() {
        return n96.a.b().J2();
    }

    public final String getCDid() {
        return n96.a.b().N2();
    }

    public final String getCacheDir() {
        return n96.a.b().getCacheDir();
    }

    public final String getDataBaseDir() {
        return n96.a.b().N1();
    }

    public final String getDeviceBrand() {
        return n96.a.b().getDeviceBrand();
    }

    public final String getDeviceId() {
        return n96.a.b().getDeviceId();
    }

    public final String getDeviceModel() {
        return n96.a.b().getDeviceModel();
    }

    public final String getFilesDir() {
        return n96.a.b().v();
    }

    public final String getInstallId() {
        return n96.a.b().getInstallId();
    }

    public final String getLanguage() {
        return n96.a.b().getLanguage();
    }

    public final String getNetworkAccessType() {
        return n96.a.b().getNetworkAccessType();
    }

    public final String getOsApi() {
        return n96.a.b().c3();
    }

    public final String getOsVersion() {
        return n96.a.b().getOsVersion();
    }

    public final String getRegion() {
        return n96.a.b().getRegion();
    }

    public final long getStartupTime() {
        return n96.a.b().W();
    }

    public final String getTempDir() {
        return n96.a.b().T1();
    }

    public final void getWifiSignal(o96.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        n96.a.b().H1();
    }
}
