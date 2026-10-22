package com.bytedance.vmsdk.worker;

/* JADX INFO: loaded from: classes.dex */
public class VmSdkException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11783a;

    public VmSdkException(int r1, String r2) {
        super(r2);
        this.f11783a = r1;
    }

    public static void throwVmSdkException(int r1, String r2) {
        throw new VmSdkException(r1, r2);
    }
}
