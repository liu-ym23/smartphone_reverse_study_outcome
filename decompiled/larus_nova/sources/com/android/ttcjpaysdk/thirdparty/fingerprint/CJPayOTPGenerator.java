package com.android.ttcjpaysdk.thirdparty.fingerprint;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayOTPGenerator {
    private static final int MILLISECOND = 1000;
    public static long totpProofreadValue;
    private int codeDigits;
    private byte[] key;
    private int timestep;

    public String generateOTP() {
        byte[] r100 = hmac_sha1(this.key, longToByte8(timecode().longValue()));
        int r101 = r100[r100.length - 1] & 15;
        StringBuilder r102 = new StringBuilder(Integer.toString(((r100[r101 + 3] & UByte.MAX_VALUE) | ((((r100[r101] & ByteCompanionObject.MAX_VALUE) << 24) | ((r100[r101 + 1] & UByte.MAX_VALUE) << 16)) | ((r100[r101 + 2] & UByte.MAX_VALUE) << 8))) % ((int) Math.pow(10.0d, this.codeDigits))));
    L4:
        if (r102.length() >= this.codeDigits) goto L7;
        r102.insert(0, "0");
        goto L4
    L7:
        return r102.toString();
    }

    private Long timecode() {
        long r100 = System.currentTimeMillis();
        long r101 = totpProofreadValue;
        if (r101 == 0) goto L8;
        r100 = r100 - r101;
        JSONObject r102 = new JSONObject();
        r102.put("timespan_ms", totpProofreadValue);     // Catch: Exception -> L9
        r102.put("timestep", this.timestep);     // Catch: Exception -> L9
        r102.put("curTime", r100);     // Catch: Exception -> L9
    L6:
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_fingerprint_totp_adjustment", new JSONObject[]{r102});
    L8:
        return Long.valueOf((r100 / 1000) / ((long) this.timestep));
    }

    private static byte[] longToByte8(long r100) {
        byte[] r101 = new byte[8];
        int r102 = 0;
    L3:
        if (r102 >= 8) goto L5;
        r101[r102] = (byte) ((r100 >>> ((7 - r102) * 8)) & 255);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    private static byte[] hmac_sha1(byte[] r100, byte[] r101) {
        SecretKeySpec r102 = new SecretKeySpec(r100, "HmacSHA1");
        Mac r103 = Mac.getInstance("HmacSHA1");     // Catch: InvalidKeyException -> L5 NoSuchAlgorithmException -> L7
        r103.init(r102);     // Catch: InvalidKeyException -> L5 NoSuchAlgorithmException -> L7
        return r103.doFinal(r101);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public CJPayOTPGenerator(byte[] r100, int r101, int r102) {
        this.key = r100;
        this.codeDigits = r101;
        this.timestep = r102;
    }
}
