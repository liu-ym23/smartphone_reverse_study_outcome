package com.obric.event.task.base.conditiontask.holiday;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "FileUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32693a = null;

    static {
        f32693a = new a();
    }

    private a() {
    }

    public final void a(Closeable r3) {
        Closeable r2 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r2.close();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "close error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    }
}
