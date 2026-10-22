package com.obric.aiagent.privacy;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: PrivacyServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyServiceImpl implements IPrivacyService {
    private static final a Companion = null;
    private static final String TAG = "PrivacyServiceImpl";
    private final CopyOnWriteArraySet<d.h.a.a<x>> agreeListeners;
    private final CopyOnWriteArraySet<d.h.a.a<x>> clearAgreeListeners;

    /* JADX INFO: compiled from: PrivacyServiceImpl.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public PrivacyServiceImpl() {
        this.agreeListeners = new CopyOnWriteArraySet();
        this.clearAgreeListeners = new CopyOnWriteArraySet();
    }

    @Override // com.obric.aiagent.privacy.IPrivacyService
    public void markAgree() {
        if (isAgreed() == true) goto L8;
        ILogDepend.Companion.i(TAG, "markAgree");
        com.obric.aiagent.privacy.a.f18762a.a();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.agreeListeners, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r3.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        goto L6
    L10:
        return;
    }

    @Override // com.obric.aiagent.privacy.IPrivacyService
    public void clearAgree() {
        if (isAgreed() == false) goto L8;
        ILogDepend.Companion.i(TAG, "clearAgree");
        com.obric.aiagent.privacy.a.f18762a.b();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.clearAgreeListeners, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r3.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        goto L6
    L10:
        return;
    }

    @Override // com.obric.aiagent.privacy.IPrivacyService
    public boolean isAgreed() {
        boolean r0 = com.obric.aiagent.privacy.a.f18762a.c();     // Catch: Exception -> L5
        ILogDepend.Companion.d(TAG, "isAgreed: " + r0);     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "isAgreed error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return true;
    }

    @Override // com.obric.aiagent.privacy.IPrivacyService
    public void registerAgreeListener(d.h.a.a<x> r3) {
        d.h.a.a<x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "invoker");
        this.agreeListeners.add(r4);
    }

    @Override // com.obric.aiagent.privacy.IPrivacyService
    public void unregisterAgreeListener(d.h.a.a<x> r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "invoker");
        this.agreeListeners.remove(r4);
    }
}
