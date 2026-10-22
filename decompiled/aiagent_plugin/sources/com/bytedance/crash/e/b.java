package com.bytedance.crash.e;

import android.text.TextUtils;
import com.bytedance.crash.o.i;
import com.bytedance.crash.o.l;
import com.bytedance.crash.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: GameScriptStack.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f7451a;

    public static void a(u r2) {
        f7451a = (u) ZeusTransformUtils.wrapperContextForParams(r2, u.class, "com.obric.aiagent.plugin");
    }

    public static void a(File r3) {
        u r0 = f7451a;
        if (r0 == null) goto L11;
        String r1 = r0.a();     // Catch: Throwable -> L8
        if (r1 == null) goto L12;
        i.c(new File(r3, "game_script_stack.txt"), r1);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void a(JSONObject r2, File r3) {
        File r0 = new File(r3, "game_script_stack.txt");
        if (r0.exists() == false) goto L8;
        String r4 = i.d(r0);
        if (TextUtils.isEmpty(r4) == true) goto L9;
        l.a(r2, "game_script_stack", r4);
        return;
    L9:
        return;
    }
}
