package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ContextAwareness.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContextAwareness$registerEvent$remoteListener$1 extends IEventChangeListener.Stub {
    ContextAwareness$registerEvent$remoteListener$1() {
    }

    @Override // com.obric.memorydata.sdk.awareness.IEventChangeListener
    public void onEventChanged(String r4, Bundle r5) {
        o.e(r4, "event");
        if (r5 == null) goto L5;
        r5.setClassLoader(r5.getClass().getClassLoader());
        r5.keySet();
    L5:
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(a.f33811a.b().get(r4), Set.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        ((b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin")).a(r4, r5);
        goto L9
    L13:
        return;
    }
}
