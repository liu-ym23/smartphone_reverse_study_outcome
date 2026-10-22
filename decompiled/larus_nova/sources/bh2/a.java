package bh2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.dtf.face.log.RecordConst;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public a() {
    }

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RecordConst.LOG_ERR_TYPE);
        JSONObject r102 = new JSONObject();
        r102.put("type", "decode_err");
        r102.put("err_type", r100);
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        r102.put("content_type", r103);
        int r104 = ECSdk.f48106a;
        pi.b r105 = (pi.b) ECSdk.a(pi.b.class);
        if (r105 == null) goto L9;
        r105.monitorEvent("ec_live_message_usability", r102, null, null);
    L9:
        ECExceptionMonitor.e(new AssertionError("MonitorMessageError: contentType=" + r101 + ", errType=" + r100));
        return;
    L5:
        r103 = r101;
        goto L6
    }
}
