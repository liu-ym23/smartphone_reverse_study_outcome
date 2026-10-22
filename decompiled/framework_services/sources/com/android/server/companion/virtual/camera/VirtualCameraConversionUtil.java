package com.android.server.companion.virtual.camera;

import android.companion.virtual.camera.VirtualCameraConfig;
import android.companion.virtual.camera.VirtualCameraStreamConfig;
import android.companion.virtualcamera.IVirtualCameraCallback;
import android.companion.virtualcamera.SupportedStreamConfiguration;
import android.companion.virtualcamera.VirtualCameraConfiguration;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class VirtualCameraConversionUtil {
    public static /* synthetic */ SupportedStreamConfiguration $r8$lambda$GbsuBtfWboD1INdCSSvZK_JsSko(VirtualCameraStreamConfig r0) {
        return convertSupportedStreamConfiguration(r0);
    }

    public static /* synthetic */ SupportedStreamConfiguration[] $r8$lambda$LzWQiZNxN_C1LzNLgPdGNS9yANs(int r0) {
        return lambda$getServiceCameraConfiguration$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smconvertToJavaFormat, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3036$$Nest$smconvertToJavaFormat(int r0) {
        return convertToJavaFormat(r0);
    }

    public static VirtualCameraConfiguration getServiceCameraConfiguration(VirtualCameraConfig cameraConfig) throws RemoteException {
        VirtualCameraConfiguration serviceConfiguration = new VirtualCameraConfiguration();
        serviceConfiguration.supportedStreamConfigs = (SupportedStreamConfiguration[]) cameraConfig.getStreamConfigs().stream().map(new VirtualCameraConversionUtil$$ExternalSyntheticLambda0()).toArray(new VirtualCameraConversionUtil$$ExternalSyntheticLambda1());
        serviceConfiguration.sensorOrientation = cameraConfig.getSensorOrientation();
        serviceConfiguration.lensFacing = cameraConfig.getLensFacing();
        serviceConfiguration.virtualCameraCallback = convertCallback(cameraConfig.getCallback());
        return serviceConfiguration;
    }

    private static /* synthetic */ SupportedStreamConfiguration[] lambda$getServiceCameraConfiguration$0(int x$0) {
        return new SupportedStreamConfiguration[x$0];
    }

    private static IVirtualCameraCallback convertCallback(final android.companion.virtual.camera.IVirtualCameraCallback camera) {
        return new AnonymousClass1(camera);
    }

    private static SupportedStreamConfiguration convertSupportedStreamConfiguration(VirtualCameraStreamConfig stream) {
        SupportedStreamConfiguration supportedConfig = new SupportedStreamConfiguration();
        supportedConfig.height = stream.getHeight();
        supportedConfig.width = stream.getWidth();
        supportedConfig.pixelFormat = convertToHalFormat(stream.getFormat());
        supportedConfig.maxFps = stream.getMaximumFramesPerSecond();
        return supportedConfig;
    }

    private static int convertToHalFormat(int javaFormat) {
        switch(javaFormat) {
            case 1: goto L5;
            case 35: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 35;
    L5:
        return 1;
    }

    private static int convertToJavaFormat(int halFormat) {
        switch(halFormat) {
            case 1: goto L5;
            case 35: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 35;
    L5:
        return 1;
    }

    private VirtualCameraConversionUtil() {
    }
}
