package ms.bd.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f39619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f39620b;

    static {
        f39620b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "11d03d", new byte[]{97, 54, 26, 84, 24, 106, 115}), String.class, "com.obric.aiagent.plugin");
    }

    public static String a() {
        String r0 = f39619a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        SensorManager r1 = (SensorManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4eb291", new byte[]{54, 98, 31, 85, 9, 52}), String.class, "com.obric.aiagent.plugin")), SensorManager.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L18;
        StringBuilder r2 = new StringBuilder();
        Sensor r4 = r1.getDefaultSensor(1);
        if (r4 == null) goto L10;
        r2.append(1).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4d74c1", new byte[]{26}), String.class, "com.obric.aiagent.plugin")).append(r4.getName()).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7dba3c", new byte[]{25}), String.class, "com.obric.aiagent.plugin")).append(r4.getVendor()).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1774c0", new byte[]{60}), String.class, "com.obric.aiagent.plugin"));
    L10:
        Sensor r6 = r1.getDefaultSensor(5);
        if (r6 == null) goto L13;
        r2.append(5).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "dea9c4", new byte[]{74}), String.class, "com.obric.aiagent.plugin")).append(r6.getName()).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a49b7d", new byte[]{79}), String.class, "com.obric.aiagent.plugin")).append(r6.getVendor()).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "85057c", new byte[]{53}), String.class, "com.obric.aiagent.plugin"));
    L13:
        Sensor r3 = r1.getDefaultSensor(9);
        if (r3 == null) goto L16;
        r2.append(9).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "deb795", new byte[]{74}), String.class, "com.obric.aiagent.plugin")).append(r3.getName()).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "cac2f8", new byte[]{77}), String.class, "com.obric.aiagent.plugin")).append(r3.getVendor());
    L16:
        f39619a = r2.toString();
    L18:
        if (f39619a != null) goto L21;
        f39619a = f39620b;
    L21:
        return f39619a;
    }
}
