package com.stepos.backend.qnn;

import com.stepos.core.ota.crypto.OtaAtRestDecryptor;
import java.nio.ByteBuffer;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnAtRestBridge {
    public static final QnnAtRestBridge INSTANCE = new QnnAtRestBridge();

    private QnnAtRestBridge() {
    }

    public static final boolean decryptInto(String srcPath, ByteBuffer out) {
        Object objA;
        kotlin.jvm.internal.g.f(srcPath, "srcPath");
        kotlin.jvm.internal.g.f(out, "out");
        OtaAtRestDecryptor otaAtRestDecryptor = a4.a.f37i;
        if (otaAtRestDecryptor == null) {
            return false;
        }
        try {
            objA = Boolean.valueOf(otaAtRestDecryptor.decryptWeightInto(srcPath, out));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }
}
