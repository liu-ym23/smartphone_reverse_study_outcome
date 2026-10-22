package com.stepos.core.common.log;

import b6.e;
import com.stepos.core.common.debug.DebugInjectionGate;
import gc.r;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Result;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Sanitizer {
    private static final int DEFAULT_MAX_LEN = 256;
    private static final int HASH8_BYTES = 4;
    public static final Sanitizer INSTANCE = new Sanitizer();

    private Sanitizer() {
    }

    public static final String hash8(String s8) {
        g.f(s8, "s");
        return hashHex(s8, 4);
    }

    public static final String hashHex(String s8, int i10) {
        Object objA;
        g.f(s8, "s");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = s8.getBytes(gc.a.f9106b);
            g.e(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            g.e(bArrDigest, "digest(...)");
            objA = kotlin.collections.a.z0(l.l0(bArrDigest, i10), "", null, null, new e(29), 30);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = "";
        }
        return (String) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence hashHex$lambda$2$lambda$1(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    public static final boolean isUserBuild() {
        Object objA;
        try {
            objA = Boolean.valueOf(!DebugInjectionGate.INSTANCE.isDeviceInjectionAllowed());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.TRUE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public static final String len(int i10) {
        return ai.onnxruntime.providers.a.a(i10, "len=");
    }

    public static final String text(String str, int i10) {
        return (str == null || str.length() == 0) ? "" : isUserBuild() ? a0.a.g("len=", str.length(), ",hash=", hash8(str)) : r.R0(i10, str);
    }

    public static /* synthetic */ String text$default(String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 256;
        }
        return text(str, i10);
    }

    public static /* synthetic */ void isUserBuild$annotations() {
    }
}
