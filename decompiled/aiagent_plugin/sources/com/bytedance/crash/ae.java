package com.bytedance.crash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: NpthCustomHeaderApi.java */
/* JADX INFO: loaded from: classes.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CopyOnWriteArrayList<a> f7128a;

    /* JADX INFO: compiled from: NpthCustomHeaderApi.java */
    public interface a {
    }

    static {
        f7128a = new CopyOnWriteArrayList();
    }

    public static void a(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        f7128a.add(r3);
    }
}
