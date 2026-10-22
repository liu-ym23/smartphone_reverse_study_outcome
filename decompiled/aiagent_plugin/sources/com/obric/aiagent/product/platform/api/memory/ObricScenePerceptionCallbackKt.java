package com.obric.aiagent.product.platform.api.memory;

import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: ObricScenePerceptionCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricScenePerceptionCallbackKt {
    private static final String TAG = "ObricScenePerceptionCallback";

    public static final /* synthetic */ Object access$newScenePerceptionCallbackWrapperProxy(String r2, m r3) {
        return newScenePerceptionCallbackWrapperProxy(r2, (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ Object lambda$uSJwu_bPuy1vSwsyiZ9tVfg3f98(m r0, String r1, Object r2, Method r3, Object[] r4) {
        return newScenePerceptionCallbackWrapperProxy$lambda$1(r0, r1, r2, r3, r4);
    }

    private static final Object newScenePerceptionCallbackWrapperProxy(final String r4, m<? super Integer, ? super Bundle, x> r5) {
        final m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        Class r0 = ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L10
        if (r0.isInterface() == false) goto L9;
        Object r7 = Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{r0}, new $$Lambda$ObricScenePerceptionCallbackKt$uSJwu_bPuy1vSwsyiZ9tVfg3f98(r6, r4));
        o.c(r7, "newProxyInstance(...)");
        return r7;
    L9:
        throw new IllegalArgumentException(("Callback wrapper must be an interface for Proxy to work: " + r4).toString());
    L10:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Callback wrapper not found: " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw e;
    }

    private static final Object newScenePerceptionCallbackWrapperProxy$lambda$1(m r5, String r6, Object r7, Method r8, Object[] r9) {
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        String r11 = r8.getName();
        Object r0 = null;
        if (r11 == null) goto L56;
        boolean r3 = true;
        switch(r11.hashCode()) {
            case -1776922004: goto L52;
            case -1295482945: goto L43;
            case 147696667: goto L39;
            case 975459573: goto L8;
            default: goto L60;
        };
    L60:
        return null;
    L8:
        if (r11.equals("onAction") == false) goto L61;
        if (r9 == null) goto L12;
        Object r12 = i.b(r9, 0);
    L14:
        if (ZeusTransformUtils.instanceOf(r12, Number.class) == false) goto L16;
        Number r13 = (Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin");
    L17:
        if (r13 == null) goto L33;
        int r14 = r13.intValue();
        if (r9 == null) goto L21;
        Object r15 = i.b(r9, 1);
    L23:
        if (ZeusTransformUtils.instanceOf(r15, Bundle.class) == false) goto L25;
        Bundle r16 = (Bundle) ZeusTransformUtils.preCheckCast(r15, Bundle.class, "com.obric.aiagent.plugin");
    L26:
        if (r16 != null) goto L32;
        StringBuilder r17 = new StringBuilder().append("onAction[1] is not Bundle: ");
        if (r9 == null) goto L31;
        r0 = i.b(r9, 1);
    L31:
        throw new IllegalArgumentException(r17.append(r0).toString());
    L32:
        r10.invoke(Integer.valueOf(r14), r16);
        return null;
    L25:
        r16 = null;
        goto L26
    L21:
        r15 = null;
        goto L23
    L33:
        StringBuilder r18 = new StringBuilder().append("onAction[0] is not a number: ");
        if (r9 == null) goto L37;
        r0 = i.b(r9, 0);
    L37:
        throw new IllegalArgumentException(r18.append(r0).toString());
    L16:
        r13 = null;
        goto L17
    L12:
        r12 = null;
        goto L14
    L61:
        return null;
    L39:
        if (r11.equals("hashCode") == true) goto L58;
        return null;
    L58:
        return Integer.valueOf(System.identityHashCode(r7));
    L43:
        if (r11.equals("equals") == false) goto L63;
        if (r9 == null) goto L47;
        r0 = i.b(r9, 0);
    L47:
        if (r7 == r0) goto L59;
        r3 = false;
    L59:
        return Boolean.valueOf(r3);
    L63:
        return null;
    L52:
        if (r11.equals("toString") == true) goto L55;
        return null;
    L55:
        return "Proxy(" + r6 + ')';
    L56:
        return null;
    }
}
