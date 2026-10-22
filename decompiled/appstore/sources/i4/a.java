package i4;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.e;
import df.c;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(Context r10, String r11, Bundle r12) {
        if (e.b(r11) == false) goto L5;
        return;
    L5:
        JSONObject r13 = new JSONObject();
        r13.put("_event_v3", 1);     // Catch: Throwable -> L13
        if (r12 == null) goto L15;
        Iterator<String> r14 = r12.keySet().iterator();     // Catch: Throwable -> L13
    L10:
        if (r14.hasNext() == false) goto L15;
        String r15 = r14.next();     // Catch: Throwable -> L13
        r13.put(r15, r12.get(r15));     // Catch: Throwable -> L13
    L15:
        c.a(r10, "event_v3", r11, null, 0, 0, r13);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }
}
