package com.stepos.base.lease;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NativeCancelBridge {
    static {
        new NativeCancelBridge();
    }

    public static final native boolean nativeAreSignalsInstalled0();

    public static final native boolean nativeIsCancelled0(long j10);

    public static final native void nativeRegister0(long j10);

    public static final native void nativeRequestCancel0(long j10);

    public static final native void nativeUnregister0(long j10);
}
