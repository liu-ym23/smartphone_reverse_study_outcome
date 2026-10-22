package com.android.server.locksettings;

import android.hardware.weaver.IWeaver;
import android.hardware.weaver.WeaverConfig;
import android.hardware.weaver.WeaverReadResponse;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class WeaverHidlAdapter implements IWeaver {
    private static final String TAG = "WeaverHidlAdapter";
    private final android.hardware.weaver.V1_0.IWeaver mImpl;

    public static /* synthetic */ void $r8$lambda$Mxbp5Ip8sxw8W46Lbi2XgJ7WqLU(WeaverConfig[] r0, int r1, android.hardware.weaver.V1_0.WeaverConfig r2) {
        lambda$getConfig$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$fAOwIGeTE7-05IsKKHwJnItYmqM, reason: not valid java name */
    public static /* synthetic */ void m5489$r8$lambda$fAOwIGeTE705IsKKHwJnItYmqM(WeaverReadResponse[] r0, int r1, android.hardware.weaver.V1_0.WeaverReadResponse r2) {
        lambda$read$1(r0, r1, r2);
    }

    WeaverHidlAdapter(android.hardware.weaver.V1_0.IWeaver impl) {
        this.mImpl = impl;
    }

    @Override // android.hardware.weaver.IWeaver
    public WeaverConfig getConfig() throws RemoteException {
        final WeaverConfig[] res = new WeaverConfig[1];
        this.mImpl.getConfig(new WeaverHidlAdapter$$ExternalSyntheticLambda0(res));
        return res[0];
    }

    private static /* synthetic */ void lambda$getConfig$0(WeaverConfig[] res, int status, android.hardware.weaver.V1_0.WeaverConfig config) {
        if (status != 0) goto L4;
        WeaverConfig aidlRes = new WeaverConfig();
        aidlRes.slots = config.slots;
        aidlRes.keySize = config.keySize;
        aidlRes.valueSize = config.valueSize;
        res[0] = aidlRes;
        return;
    L4:
        Slog.e(TAG, "Failed to get HIDL weaver config. status: " + status + ", slots: " + config.slots);
    }

    @Override // android.hardware.weaver.IWeaver
    public WeaverReadResponse read(int slotId, byte[] key) throws RemoteException {
        final WeaverReadResponse[] res = new WeaverReadResponse[1];
        this.mImpl.read(slotId, toByteArrayList(key), new WeaverHidlAdapter$$ExternalSyntheticLambda1(res));
        return res[0];
    }

    private static /* synthetic */ void lambda$read$1(WeaverReadResponse[] res, int inStatus, android.hardware.weaver.V1_0.WeaverReadResponse readResponse) {
        WeaverReadResponse aidlRes = new WeaverReadResponse();
        switch(inStatus) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Unexpected status in read: " + inStatus);
        aidlRes.status = 1;
    L9:
        aidlRes.timeout = readResponse.timeout;
        aidlRes.value = fromByteArrayList(readResponse.value);
        res[0] = aidlRes;
        return;
    L5:
        aidlRes.status = 3;
        goto L9
    L6:
        aidlRes.status = 2;
        goto L9
    L7:
        aidlRes.status = 1;
        goto L9
    L8:
        aidlRes.status = 0;
        goto L9
    }

    @Override // android.hardware.weaver.IWeaver
    public void write(int slotId, byte[] key, byte[] value) throws RemoteException {
        int writeStatus = this.mImpl.write(slotId, toByteArrayList(key), toByteArrayList(value));
        if (writeStatus != 0) goto L6;
        return;
    L6:
        throw new ServiceSpecificException(1, "Failed IWeaver.write call, status: " + writeStatus);
    }

    @Override // android.hardware.weaver.IWeaver
    public String getInterfaceHash() {
        throw new UnsupportedOperationException("WeaverHidlAdapter does not support getInterfaceHash");
    }

    @Override // android.hardware.weaver.IWeaver
    public int getInterfaceVersion() {
        return 2;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        throw new UnsupportedOperationException("WeaverHidlAdapter does not support asBinder");
    }

    private static ArrayList<Byte> toByteArrayList(byte[] data) {
        ArrayList<Byte> result = new ArrayList(data.length);
        int i = 0;
    L4:
        if (i >= data.length) goto L7;
        result.add(Byte.valueOf(data[i]));
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    private static byte[] fromByteArrayList(ArrayList<Byte> data) {
        byte[] result = new byte[data.size()];
        int i = 0;
    L4:
        if (i >= data.size()) goto L7;
        result[i] = data.get(i).byteValue();
        i = i + 1;
        goto L4
    L7:
        return result;
    }
}
