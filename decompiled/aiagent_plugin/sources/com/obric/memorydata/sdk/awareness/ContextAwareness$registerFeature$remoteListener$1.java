package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ContextAwareness.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContextAwareness$registerFeature$remoteListener$1 extends IFeatureChangeListener.Stub {
    ContextAwareness$registerFeature$remoteListener$1() {
    }

    @Override // com.obric.memorydata.sdk.awareness.IFeatureChangeListener
    public void onFeatureChanged(Bundle r14) {
        o.e(r14, "featureInfo");
        r14.setClassLoader(getClass().getClassLoader());
        String r13 = r14.getString("feature_name");
        Object r0 = r14.get("old_value");
        Object r1 = r14.get("new_value");
        Bundle r15 = r14.getBundle("extras");
        if (r15 == null) goto L5;
        r15.setClassLoader(r15.getClass().getClassLoader());
        r15.keySet();
    L6:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L32;
        if (r1 == null) goto L32;
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(a.f33811a.a().get(r13), Set.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L31;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r6.hasNext() == false) goto L40;
        c r7 = (c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L25;
        r7 = null;
    L25:
        if (r7 == null) goto L26;
        if (r0 != null) goto L29;
        Object r8 = null;
    L30:
        r7.a(r13, r8, r1, r15);
        goto L20
    L29:
        r8 = r0;
        goto L30
    L26:
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "listener is not match FeatureChangeListener<T> type", null, 4, null);
        goto L20
    L40:
        return;
    L31:
        return;
    L32:
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "invalid featureName: " + r13 + " or newValue: " + r1, null, 4, null);
        return;
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r15 = null;
        goto L6
    }
}
