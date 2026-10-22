package ms.bd.c;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    public static String a() {
        JSONObject r1 = new JSONObject();
        HashMap r2 = b();     // Catch: Throwable -> L9
        Iterator r3 = r2.keySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        r1.put(r4, r2.get(r4));     // Catch: Throwable -> L9
        goto L5
    L7:
        return r1.toString();
    L10:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "afa3b6", new byte[]{107, 121}), String.class, "com.obric.aiagent.plugin");
    }

    private static HashMap b() {
        HashMap r0 = new HashMap();
        r0.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "58d34f", new byte[]{117}), String.class, "com.obric.aiagent.plugin"), Build.MODEL);
        r0.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ffb49f", new byte[]{37}), String.class, "com.obric.aiagent.plugin"), Build.BRAND);
        r0.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9e0f09", new byte[]{123}), String.class, "com.obric.aiagent.plugin"), Build.BOARD);
        r0.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c9536d", new byte[]{38}), String.class, "com.obric.aiagent.plugin"), Build.VERSION.RELEASE);
        r0.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1eb42e", new byte[]{117}), String.class, "com.obric.aiagent.plugin"), Build.DISPLAY);
        r0.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "71b0a9", new byte[]{112}), String.class, "com.obric.aiagent.plugin"), Build.HARDWARE);
        r0.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "03cf51", new byte[]{118}), String.class, "com.obric.aiagent.plugin"), Build.FINGERPRINT);
        return r0;
    }
}
