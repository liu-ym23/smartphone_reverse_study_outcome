package com.obric.oui.window.listener;

import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: WindowConfigChangeListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WindowConfigChangeListener$Companion$addListener$2 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f36891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f36892b;

    @x(a = i.a.ON_DESTROY)
    public final void onDestroy() {
        ConcurrentLinkedQueue r0 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(b.c().get(Integer.valueOf(this.f36891a)), ConcurrentLinkedQueue.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        p r4 = this.f36892b;
        Iterator r1 = r0.iterator();
        d.h.b.o.c(r1, "it.iterator()");
    L7:
        if (r1.hasNext() == false) goto L17;
        if (d.h.b.o.a(((WeakReference) ZeusTransformUtils.preCheckCast(r1.next(), WeakReference.class, "com.obric.aiagent.plugin")).get(), r4) == false) goto L7;
        r1.remove();
        goto L7
    L17:
        return;
    }
}
