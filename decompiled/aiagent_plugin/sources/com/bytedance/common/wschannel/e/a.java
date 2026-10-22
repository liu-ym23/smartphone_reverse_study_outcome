package com.bytedance.common.wschannel.e;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: DiskStorageUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f6941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f6942b;

    static {
    }

    public a() {
    }

    private static File b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        File r0 = f6942b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        File r1 = new File(r3.getFilesDir(), "wschannel");
        f6942b = r1;
        if (r1.exists() == true) goto L9;
        f6942b.mkdirs();
    L9:
        return f6942b;
    }

    public static synchronized File a(Context r5) {
        monitor-enter(a.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        File r1 = f6941a;     // Catch: Throwable -> L20
        if (r1 == null) goto L23;
        monitor-exit(a.class);
        return r1;
    L23:
        File r2 = new File(b(r6), c.b(r6).replace(".", "_").replace(":", "-") + "_frontier.bin");     // Catch: Exception -> L15 Throwable -> L20
        if (r2.exists() == true) goto L11;
        r2.createNewFile();     // Catch: Exception -> L15 Throwable -> L20
    L11:
        f6941a = r2;     // Catch: Exception -> L15 Throwable -> L20
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "prepare PersistentFile success. fileName=" + f6941a);     // Catch: Exception -> L15 Throwable -> L20
    L17:
        File r7 = f6941a;     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return r7;
    L15:
        e = move-exception;
        Logger.e(TAG, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
