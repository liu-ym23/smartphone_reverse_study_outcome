package com.stepos.ability.commoninternal;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/ability/commoninternal/HashUtils;", "", AppAgent.CONSTRUCT, "()V", "sha256", "", "input", "", "bytesToHex", SingleFileBundle.KEY_BYTES, "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HashUtils {
    public static final HashUtils INSTANCE = new HashUtils();

    private HashUtils() {
    }

    public final String bytesToHex(byte[] bytes) {
        k.f(bytes, "bytes");
        char[] charArray = "0123456789ABCDEF".toCharArray();
        k.e(charArray, "toCharArray(...)");
        char[] cArr = new char[bytes.length * 2];
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            byte b = bytes[i];
            int i6 = i * 2;
            cArr[i6] = charArray[(b & 255) >>> 4];
            cArr[i6 + 1] = charArray[b & 15];
        }
        return new String(cArr);
    }

    public final String sha256(byte[] input) {
        k.f(input, "input");
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(input);
        k.c(bArrDigest);
        return bytesToHex(bArrDigest);
    }
}
