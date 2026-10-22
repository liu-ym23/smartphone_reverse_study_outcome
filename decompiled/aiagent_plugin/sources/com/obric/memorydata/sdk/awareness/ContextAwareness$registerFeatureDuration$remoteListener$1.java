package com.obric.memorydata.sdk.awareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.o;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ContextAwareness.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContextAwareness$registerFeatureDuration$remoteListener$1 extends IFeatureDurationListener.Stub {
    final /* synthetic */ a.b $key;

    ContextAwareness$registerFeatureDuration$remoteListener$1(a.b r1) {
        this.$key = r1;
    }

    @Override // com.obric.memorydata.sdk.awareness.IFeatureDurationListener
    public void onTriggered(String r5, String r6, long r7) {
        o.e(r5, "featureName");
        o.e(r6, "targetFeatureValue");
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(a.f().get(this.$key), Set.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = ax.b();
    L5:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L10;
        ((d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.aiagent.plugin")).a(r5, r6, r7);
        goto L7
    L10:
        if (this.$key.d() == false) goto L14;
        a.f().remove(this.$key);
        a.g().remove(this.$key);
        return;
    }
}
