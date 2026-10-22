package ms.bd.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static boolean a(String r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (a(r3, true) == false) goto L7;
        return true;
    L7:
        return a(r3, false);
    }

    private static boolean a(String r19, boolean r20) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L21;
        Date r2 = new Date();
        KeyGenParameterSpec.Builder r3 = new KeyGenParameterSpec.Builder(r19, 12).setAlgorithmParameterSpec(new ECGenParameterSpec((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "07d2eb", new byte[]{50, 48, 20, 86, 8, 32, 101, 4, 100}), String.class, "com.obric.aiagent.plugin"))).setDigests(new String[]{(String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5cc023", new byte[]{23, 73, 49, 9, 95, 113, 96}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "46b5d0", new byte[]{22, 28, 48, 12, 8, 127, 99}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b9799f", new byte[]{64, 19, 101, 0, 83, 32, 51}), String.class, "com.obric.aiagent.plugin")}).setKeyValidityStart(r2);
        if (r0 < 24) goto L7;
        r3.setAttestationChallenge(r2.toString().getBytes());
    L7:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L10;
        PackageManager r5 = null;
    L11:
        if (r20 == false) goto L23;
        if (r0 < 31) goto L23;
        if (r5 == null) goto L23;
        if (r5.hasSystemFeature((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4f4b20", new byte[]{36, 106, 67, 4, 2, 46, 51, 9, 118, 61, 35, 112, 80, 23, 31, 34, 121, 67, 96, 36, 44, 103, 66, 41, 4, 35, 8, 70, 113, 38, 32, 119, 83, 23, 25, 46, 56, 73}), String.class, "com.obric.aiagent.plugin")) == false) goto L23;
        r3.setDevicePropertiesAttestationIncluded(true);
    L23:
        KeyPairGenerator r1 = KeyPairGenerator.getInstance((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2d57d6", new byte[]{6, 69}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "962132", new byte[]{9, 58, 69, 87, 3, 44, 62, 60, 102, 120, 27, 32, 78, 87, 9}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L22
        r1.initialize(r3.build());     // Catch: Exception -> L22
        r1.generateKeyPair();     // Catch: Exception -> L22
        return true;
    L10:
        r5 = r4.getPackageManager();
    L21:
        return false;
    }
}
