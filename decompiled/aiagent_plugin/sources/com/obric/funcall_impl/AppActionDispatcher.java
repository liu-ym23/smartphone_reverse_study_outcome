package com.obric.funcall_impl;

import com.obric.funcall_api.OnAppActionListener;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AppActionDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppActionDispatcher {
    public static final AppActionDispatcher INSTANCE = null;
    private static final CopyOnWriteArrayList<OnAppActionListener> listeners = null;

    /* JADX INFO: compiled from: AppActionDispatcher.kt */
    @f(b = "AppActionDispatcher.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionDispatcher$notifyAppActionReceived$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f33246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f33247b;

        a(IntentAppAction r3, d<? super a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f33247b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f33247b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            b.a();
            if (this.f33246a != 0) goto L11;
            o.a(r4);
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(AppActionDispatcher.access$getListeners$p(), Iterable.class, "com.obric.aiagent.plugin");
            IntentAppAction r3 = this.f33247b;
            Iterator r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L9;
            ((OnAppActionListener) ZeusTransformUtils.preCheckCast(r6.next(), OnAppActionListener.class, "com.obric.aiagent.plugin")).onReceived(r3);
            goto L6
        L9:
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private AppActionDispatcher() {
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getListeners$p() {
        return listeners;
    }

    static {
        INSTANCE = new AppActionDispatcher();
        listeners = new CopyOnWriteArrayList();
    }

    public final void notifyAppActionReceived(IntentAppAction r2) {
        d.h.b.o.e(r2, "action");
        com.obric.funcall_impl.a.b.a((m) ZeusTransformUtils.preCheckCast(new a(r2, null), m.class, "com.obric.aiagent.plugin"));
    }

    public final void registerAppActionListener(OnAppActionListener r2) {
        OnAppActionListener r1 = (OnAppActionListener) ZeusTransformUtils.wrapperContextForParams(r2, OnAppActionListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "listener");
        CopyOnWriteArrayList<OnAppActionListener> r3 = listeners;
        if (r3.contains(r1) == true) goto L6;
        r3.add(r1);
        return;
    }

    public final void unRegisterAppActionListener(OnAppActionListener r2) {
        OnAppActionListener r1 = (OnAppActionListener) ZeusTransformUtils.wrapperContextForParams(r2, OnAppActionListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "listener");
        CopyOnWriteArrayList<OnAppActionListener> r3 = listeners;
        if (r3.contains(r1) == false) goto L6;
        r3.remove(r1);
        return;
    }
}
