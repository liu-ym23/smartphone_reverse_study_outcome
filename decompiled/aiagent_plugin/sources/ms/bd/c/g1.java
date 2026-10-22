package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 {

    public interface a {
    }

    public interface b {
    }

    public static void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 21) goto L8;
    L5:
        new i1(new x1(), new d()).a(r5, r4);
        return;
    L8:
        Os.setenv("28d7fdd567361198183fa7b8e", "a7", true);     // Catch: Exception -> L7
        goto L5
    }
}
