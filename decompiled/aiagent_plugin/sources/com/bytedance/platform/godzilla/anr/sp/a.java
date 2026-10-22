package com.bytedance.platform.godzilla.anr.sp;

import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: QueuedWorkProxyAboveOrEqualsAndroid0.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "QueuedWkPyAOrEAndroid0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f9063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static LinkedList<Runnable> f9064b;

    static /* synthetic */ void a() {
        b();
    }

    private static void b() {
        if (f9063a == null) goto L13;
        LinkedList<Runnable> r0 = f9064b;
        if (r0 == null) goto L16;
        LinkedList r1 = (LinkedList) ZeusTransformUtils.preCheckCast(r0.clone(), LinkedList.class, "com.obric.aiagent.plugin");
        f9064b.clear();
        f9063a.removeMessages(1);
        if (r1.size() <= 0) goto L15;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        ((Runnable) ZeusTransformUtils.preCheckCast(r2.next(), Runnable.class, "com.obric.aiagent.plugin")).run();
        goto L11
    L17:
        return;
    L15:
        return;
    L16:
        return;
    }
}
