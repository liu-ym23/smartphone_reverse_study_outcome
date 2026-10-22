package com.obric.aiagent.ipc.utils;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.n;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IPCDSL.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final <S extends IInterface> void a(RemoteCallbackList<S> r6, d.h.a.b<? super S, x> r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "<this>");
        o.e(r8, "action");
        monitor-enter(r6);
        int r0 = r6.beginBroadcast();     // Catch: Throwable -> L23
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L20;
        IInterface r3 = r6.getBroadcastItem(r2);     // Catch: Throwable -> L23
        boolean r4 = true;
        if (r3 == null) goto L13;
        IBinder r5 = r3.asBinder();     // Catch: Throwable -> L23
        if (r5 == null) goto L13;
        if (r5.isBinderAlive() != true) goto L13;
    L14:
        if (r4 == false) goto L19;
        n.a r9 = n.f38560a;     // Catch: Throwable -> L17
        n.f(r8.invoke(r3));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        n.a r10 = n.f38560a;     // Catch: Throwable -> L23
        n.f(d.o.a(th));     // Catch: Throwable -> L23
    L19:
        r2 = r2 + 1;     // Catch: Throwable -> L23
    L13:
        r4 = false;
        goto L14
    L20:
        r6.finishBroadcast();     // Catch: Throwable -> L23
        x r11 = x.f38692a;     // Catch: Throwable -> L23
        monitor-exit(r6);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static final Map<String, String> a(Map<Object, ? extends Object> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r5.size()), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r3 = r2.getKey();
        Object r7 = r2.getValue();
        r0.add(s.a(String.valueOf(r3), String.valueOf(r7)));
        goto L4
    L7:
        return ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }
}
