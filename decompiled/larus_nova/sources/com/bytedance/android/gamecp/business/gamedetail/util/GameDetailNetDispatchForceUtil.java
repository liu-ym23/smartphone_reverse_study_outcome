package com.bytedance.android.gamecp.business.gamedetail.util;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes44.dex */
public final class GameDetailNetDispatchForceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f55619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final GameDetailNetDispatchForceUtil f55620b = null;

    public GameDetailNetDispatchForceUtil() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        LocalTestManager.a(new Class[]{uv.a.class});     // Catch: Throwable -> L11
        Iterator<T> r100 = f55619a.iterator();     // Catch: Throwable -> L11
    L6:
        if (r100.hasNext() == false) goto L8;
        int r101 = ((Number) r100.next()).intValue();     // Catch: Throwable -> L11
        Lazy r102 = MessageQueueUtil.f55621a;     // Catch: Throwable -> L11
        MessageQueueUtil.c(r101);     // Catch: Throwable -> L11
        goto L6
    L8:
        f55619a.clear();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        LocalTestManager.a(new Class[]{uv.a.class});     // Catch: Throwable -> L9
        MessageQueueUtil r100 = MessageQueueUtil.f55624d;     // Catch: Throwable -> L9
        int r101 = MessageQueueUtil.b();     // Catch: Throwable -> L9
        if (r101 == (-1)) goto L7;
        f55619a.add(Integer.valueOf(r101));     // Catch: Throwable -> L9
        r100.a(GameDetailNetDispatchForceUtil$startDispatch$2.INSTANCE);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        f55620b = new GameDetailNetDispatchForceUtil();
        f55619a = new LinkedHashSet();
    }
}
