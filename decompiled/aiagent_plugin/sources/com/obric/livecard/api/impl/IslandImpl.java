package com.obric.livecard.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.EventsUtils;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonObject;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.livecard.api.IIslandCardCallback;
import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.IIslandStatusCallback;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.ITopSessionChangedCallback;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCard;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.exception.IslandUnsupportedException;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.obric.livecard.api.utils.LiveCardConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.b.p;
import d.m;
import d.n;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.f.a;
import kotlinx.coroutines.f.c;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: IslandImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IslandImpl implements OnLiveCardServiceDiedListener, IslandApi, IslandHideApi {
    public static final Companion Companion = null;
    public static final String LIVE_CARD_HOST = "com.android.systemui";
    public static final String LIVE_CARD_HOST_DEPRECATED = "com.obric.livecard";
    public static final String LIVE_CARD_SERVICE = "com.obric.livecard.port.LiveCardService";
    private final String TAG;
    private m<? extends IBinder, ? extends IBinder.DeathRecipient> currBinderDiedListener;
    private final w<IslandTask> islandTaskFlow;
    private final CopyOnWriteArrayList<TopSessionChangedCallbackImpl> liveCardServiceDiedListeners;
    private volatile IIslandService mService;
    private final ConcurrentHashMap<IslandSession, IIslandCardCallback> mSessionMap;
    private final a serviceLock;
    private final a sessionLock;

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {386}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$1")
    static final class AnonymousClass1 extends l implements d.h.a.m<am, d<? super x>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        AnonymousClass1(IslandImpl r3, d<? super AnonymousClass1> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            h r7 = (h) ZeusTransformUtils.preCheckCast(IslandImpl.access$getIslandTaskFlow$p(this.this$0), h.class, "com.obric.aiagent.plugin");
            i r2 = (i) ZeusTransformUtils.preCheckCast(new IslandImpl$1$invokeSuspend$$inlined$collect$1(this.this$0), i.class, "com.obric.aiagent.plugin");
            d<? super x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IslandImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(d.h.b.h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$addIslandStatusCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {215}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$addIslandStatusCallback$1")
    static final class C11731 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ IslandStatusCallback $callback;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11731(IslandImpl r3, IslandStatusCallback r4, d<? super C11731> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$callback = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11731(this.this$0, this.$callback, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11731) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11731.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.addIIslandStatusCallback((IIslandStatusCallback) ZeusTransformUtils.preCheckCast(this.$callback, IIslandStatusCallback.class, "com.obric.aiagent.plugin"));
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r7 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$addOnTopCardChangedListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {152}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$addOnTopCardChangedListener$1")
    static final class C11741 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ OnTopCardChangedListener $callback;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11741(OnTopCardChangedListener r3, IslandImpl r4, d<? super C11741> r5) {
            OnTopCardChangedListener r6 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnTopCardChangedListener.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$callback = r6;
            this.this$0 = r4;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11741(this.$callback, this.this$0, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11741) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11741.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            TopSessionChangedCallbackImpl r2 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(this.L$2, TopSessionChangedCallbackImpl.class, "com.obric.aiagent.plugin");
            IslandImpl r3 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$1, IslandImpl.class, "com.obric.aiagent.plugin");
            TopSessionChangedCallbackImpl r4 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(this.L$0, TopSessionChangedCallbackImpl.class, "com.obric.aiagent.plugin");
            o.a(r5);
        L12:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.addOnTopCardChangedListener((ITopSessionChangedCallback) ZeusTransformUtils.preCheckCast(r2, ITopSessionChangedCallback.class, "com.obric.aiagent.plugin"));
        L15:
            IslandImpl.access$getLiveCardServiceDiedListeners$p(r3).add(r2);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            TopSessionChangedCallbackImpl r7 = new TopSessionChangedCallbackImpl(this.$callback);
            r3 = this.this$0;
            this.L$0 = r7;
            this.L$1 = r3;
            this.L$2 = r7;
            this.label = 1;
            Object r8 = r3.getService(this);
            if (r8 != r0) goto L11;
            return r0;
        L11:
            r2 = r7;
            r5 = r8;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$collapseIsland$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {ApWakeEvent.ACCELERATING_END}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$collapseIsland$1")
    static final class C11751 extends l implements d.h.a.b<d<? super x>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11751(IslandImpl r3, d<? super C11751> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11751(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11751) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11751.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r4 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L15;
            r4.doCollapse();
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r6 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r6.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$createSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {78}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$createSession$1")
    static final class C11761 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ String $packageName;
        final /* synthetic */ IslandSession $session;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11761(IslandSession r3, IslandImpl r4, String r5, d<? super C11761> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$session = r3;
            this.this$0 = r4;
            this.$packageName = r5;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11761(this.$session, this.this$0, this.$packageName, r6), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11761) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11761.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            IIslandService r8 = (IIslandService) ZeusTransformUtils.preCheckCast(r7, IIslandService.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L15;
            r8.createSession(this.$session, this.$packageName, (IIslandCardCallback) ZeusTransformUtils.preCheckCast(this.this$0.getMSessionMap().get(this.$session), IIslandCardCallback.class, "com.obric.aiagent.plugin"));
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            this.$session.setTaskId(System.currentTimeMillis());
            ((Map) ZeusTransformUtils.preCheckCast(this.this$0.getMSessionMap(), Map.class, "com.obric.aiagent.plugin")).put(this.$session, new ClientCallback(this.$session));
            IslandImpl r9 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r7 = r9.getService(r2);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$destroySession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {EventsUtils.FEAT_TYPE_PROC_FREQUENT_RESTART}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$destroySession$1")
    static final class C11771 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ IslandSession $session;
        int label;
        final /* synthetic */ IslandImpl this$0;

        /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$destroySession$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IslandImpl.kt */
        static final class C09041 extends p implements d.h.a.b<IslandSession, Boolean> {
            final /* synthetic */ IslandSession $session;

            C09041(IslandSession r1) {
                this.$session = r1;
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(IslandSession r3) {
                d.h.b.o.e(r3, "it");
                if (r3.getTaskId() != this.$session.getTaskId()) goto L5;
                boolean r2 = true;
            L7:
                return Boolean.valueOf(r2);
            L5:
                r2 = false;
                goto L7
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(IslandSession r3) {
                return invoke2((IslandSession) ZeusTransformUtils.preCheckCast(r3, IslandSession.class, "com.obric.aiagent.plugin"));
            }
        }

        C11771(IslandImpl r3, IslandSession r4, d<? super C11771> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$session = r4;
            super(1, r6);
        }

        public static /* synthetic */ boolean lambda$FSGeQK3S2jk3nhnCtQ0FitE8B4E(d.h.a.b r0, Object r1) {
            return invokeSuspend$lambda$0(r0, r1);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11771(this.this$0, this.$session, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11771) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11771.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            IIslandService r7 = (IIslandService) ZeusTransformUtils.preCheckCast(r6, IIslandService.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
            r7.destroySession(this.$session);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            Set<IslandSession> r8 = this.this$0.getMSessionMap().keySet();
            final d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new C09041(this.$session), d.h.a.b.class, "com.obric.aiagent.plugin");
            r8.removeIf(new $$Lambda$IslandImpl$destroySession$1$FSGeQK3S2jk3nhnCtQ0FitE8B4E(r2));
            IslandImpl r9 = this.this$0;
            d<? super IIslandService> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r6 = r9.getService(r3);
            if (r6 != r0) goto L11;
            return r0;
        }

        private static final boolean invokeSuspend$lambda$0(d.h.a.b r2, Object r3) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$getPriority$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {193}, d = "getPriority", e = "com.obric.livecard.api.impl.IslandImpl")
    static final class C11781 extends d.c.b.a.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IslandImpl this$0;

        C11781(IslandImpl r3, d<? super C11781> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPriority(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$getService$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {391, 402, 295}, d = "getService", e = "com.obric.livecard.api.impl.IslandImpl")
    static final class C11791 extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IslandImpl this$0;

        C11791(IslandImpl r3, d<? super C11791> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getService((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onLauncherFocused$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {264}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$onLauncherFocused$1")
    static final class C11801 extends l implements d.h.a.b<d<? super x>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11801(IslandImpl r3, d<? super C11801> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11801(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11801) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11801.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            o.a(r4);     // Catch: Throwable -> L19
        L13:
            IIslandService r3 = (IIslandService) ZeusTransformUtils.preCheckCast(r4, IIslandService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            if (r3 == null) goto L16;
            r3.onLauncherFocused();     // Catch: Throwable -> L19
            x r5 = x.f38692a;     // Catch: Throwable -> L19
        L17:
            n.f(r5);     // Catch: Throwable -> L19
        L22:
            return x.f38692a;
        L16:
            r5 = null;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r4);
            IslandImpl r6 = this.this$0;
            n.a r2 = n.f38560a;     // Catch: Throwable -> L19
            this.label = 1;     // Catch: Throwable -> L19
            r4 = r6.getService(this);     // Catch: Throwable -> L19
            if (r4 != r0) goto L13;
            return r0;
        L19:
            th = move-exception;
            n.a r7 = n.f38560a;
            n.f(o.a(th));
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onNotificationVisible$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {199}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$onNotificationVisible$1")
    static final class C11811 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ boolean $visible;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11811(IslandImpl r3, boolean r4, d<? super C11811> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$visible = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11811(this.this$0, this.$visible, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11811) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11811.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.onNotificationVisible(this.$visible);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r7 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onServiceDied$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {391}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$onServiceDied$1")
    static final class C11821 extends l implements d.h.a.m<am, d<? super x>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11821(IslandImpl r3, d<? super C11821> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11821(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11821) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11821.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            IslandImpl r2 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$1, IslandImpl.class, "com.obric.aiagent.plugin");
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L28:
            Iterator r10 = ((Map) ZeusTransformUtils.preCheckCast(r2.getMSessionMap(), Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L25
        L14:
            if (r10.hasNext() == false) goto L18;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            IslandCardCallback r6 = ((IslandSession) ZeusTransformUtils.preCheckCast(r5.getKey(), IslandSession.class, "com.obric.aiagent.plugin")).getCallback();     // Catch: Throwable -> L25
            if (r6 == null) goto L14;
            r6.onSessionDestroy((IslandSession) ZeusTransformUtils.preCheckCast(r5.getKey(), IslandSession.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(1));     // Catch: Throwable -> L25
            goto L14
        L18:
            r2.getMSessionMap().clear();     // Catch: Throwable -> L25
            x r11 = x.f38692a;     // Catch: Throwable -> L25
            r3.b(null);
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L21:
            if (r12.hasNext() == false) goto L23;
            ((TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(r12.next(), TopSessionChangedCallbackImpl.class, "com.obric.aiagent.plugin")).onServiceDied();
            goto L21
        L23:
            IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0).clear();
            return x.f38692a;
        L25:
            th = move-exception;
            r3.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            r3 = IslandImpl.access$getSessionLock$p(this.this$0);
            IslandImpl r13 = this.this$0;
            d<? super x> r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.L$0 = r3;
            this.L$1 = r13;
            this.label = 1;
            if (r3.a(null, r7) != r0) goto L11;
            return r0;
        L11:
            r2 = r13;
            goto L28
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onSysUIFlagsChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {280}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$onSysUIFlagsChanged$1")
    static final class C11831 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ long $sysuiFlags;
        long J$0;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11831(IslandImpl r3, long r4, d<? super C11831> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$sysuiFlags = r4;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11831(this.this$0, this.$sysuiFlags, r7), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11831) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11831.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            long r2 = this.J$0;
            o.a(r6);     // Catch: Throwable -> L21
        L15:
            IIslandService r5 = (IIslandService) ZeusTransformUtils.preCheckCast(r6, IIslandService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            if (r5 == null) goto L18;
            r5.onSysUIFlagsChanged(r2);     // Catch: Throwable -> L21
            x r7 = x.f38692a;     // Catch: Throwable -> L21
        L19:
            n.f(r7);     // Catch: Throwable -> L21
        L24:
            return x.f38692a;
        L18:
            r7 = null;
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r6);
            IslandImpl r8 = this.this$0;
            long r3 = this.$sysuiFlags;
            n.a r4 = n.f38560a;     // Catch: Throwable -> L21
            this.J$0 = r3;     // Catch: Throwable -> L21
            this.label = 1;     // Catch: Throwable -> L21
            r6 = r8.getService(this);     // Catch: Throwable -> L21
            if (r6 != r0) goto L14;
            return r0;
        L14:
            r2 = r3;
        L21:
            th = move-exception;
            n.a r9 = n.f38560a;
            n.f(o.a(th));
            goto L24
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$onVolumeButtonClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {256}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$onVolumeButtonClick$1")
    static final class C11841 extends l implements d.h.a.b<d<? super x>, Object> {
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11841(IslandImpl r3, d<? super C11841> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11841(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11841) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11841.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            o.a(r4);     // Catch: Throwable -> L19
        L13:
            IIslandService r3 = (IIslandService) ZeusTransformUtils.preCheckCast(r4, IIslandService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            if (r3 == null) goto L16;
            r3.onVolumeButtonClick();     // Catch: Throwable -> L19
            x r5 = x.f38692a;     // Catch: Throwable -> L19
        L17:
            n.f(r5);     // Catch: Throwable -> L19
        L22:
            return x.f38692a;
        L16:
            r5 = null;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r4);
            IslandImpl r6 = this.this$0;
            n.a r2 = n.f38560a;     // Catch: Throwable -> L19
            this.label = 1;     // Catch: Throwable -> L19
            r4 = r6.getService(this);     // Catch: Throwable -> L19
            if (r4 != r0) goto L13;
            return r0;
        L19:
            th = move-exception;
            n.a r7 = n.f38560a;
            n.f(o.a(th));
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$removeIslandStatusCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {223}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$removeIslandStatusCallback$1")
    static final class C11851 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ IslandStatusCallback $callback;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11851(IslandImpl r3, IslandStatusCallback r4, d<? super C11851> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$callback = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11851(this.this$0, this.$callback, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11851) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11851.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.removeIIslandStatusCallback((IIslandStatusCallback) ZeusTransformUtils.preCheckCast(this.$callback, IIslandStatusCallback.class, "com.obric.aiagent.plugin"));
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r7 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$removeOnTopCardChangedListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {163}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$removeOnTopCardChangedListener$1")
    static final class C11861 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ OnTopCardChangedListener $callback;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11861(IslandImpl r3, OnTopCardChangedListener r4, d<? super C11861> r5) {
            OnTopCardChangedListener r6 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r4, OnTopCardChangedListener.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$callback = r6;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11861(this.this$0, this.$callback, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11861) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11861.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            TopSessionChangedCallbackImpl r2 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(this.L$1, TopSessionChangedCallbackImpl.class, "com.obric.aiagent.plugin");
            IslandImpl r6 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$0, IslandImpl.class, "com.obric.aiagent.plugin");
            o.a(r7);
        L21:
            IIslandService r8 = (IIslandService) ZeusTransformUtils.preCheckCast(r7, IIslandService.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L24;
            r8.removeOnTopCardChangedListener((ITopSessionChangedCallback) ZeusTransformUtils.preCheckCast(r2, ITopSessionChangedCallback.class, "com.obric.aiagent.plugin"));
        L24:
            IslandImpl.access$getLiveCardServiceDiedListeners$p(r6).remove(r2);
        L26:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0), Iterable.class, "com.obric.aiagent.plugin");
            OnTopCardChangedListener r3 = this.$callback;
            Iterator r10 = r9.iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            Object r4 = r10.next();
            if (d.h.b.o.a(((TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(r4, TopSessionChangedCallbackImpl.class, "com.obric.aiagent.plugin")).getDelegate(), r3) == false) goto L10;
        L15:
            TopSessionChangedCallbackImpl r11 = (TopSessionChangedCallbackImpl) ZeusTransformUtils.preCheckCast(r4, TopSessionChangedCallbackImpl.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L26;
            IslandImpl r5 = this.this$0;
            this.L$0 = r5;
            this.L$1 = r11;
            this.label = 1;
            Object r12 = r5.getService(this);
            if (r12 != r0) goto L20;
            return r0;
        L20:
            r2 = r11;
            r7 = r12;
            r6 = r5;
            goto L21
        L14:
            r4 = null;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$sendEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {96}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$sendEvent$1")
    static final class C11871 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ String $eventId;
        final /* synthetic */ String $jsonString;
        final /* synthetic */ IslandSession $targetSession;
        final /* synthetic */ IslandWidget $targetWidget;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11871(IslandImpl r3, IslandSession r4, IslandWidget r5, String r6, String r7, d<? super C11871> r8) {
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$targetSession = r4;
            this.$targetWidget = r5;
            this.$eventId = r6;
            this.$jsonString = r7;
            super(1, r9);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r10) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11871(this.this$0, this.$targetSession, this.$targetWidget, this.$eventId, this.$jsonString, r8), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11871) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11871.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.sendEvent(this.$targetSession, this.$targetWidget, this.$eventId, this.$jsonString);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r7 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$setKeyguardLocked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {272}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$setKeyguardLocked$1")
    static final class C11881 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ boolean $locked;
        boolean Z$0;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11881(IslandImpl r3, boolean r4, d<? super C11881> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$locked = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11881(this.this$0, this.$locked, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11881) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11881.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            boolean r4 = this.Z$0;
            o.a(r5);     // Catch: Throwable -> L24
        L15:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
            if (r6 == null) goto L21;
            if (r4 == true) goto L20;
            r2 = false;
        L20:
            r6.setKeyguardLocked(r2);     // Catch: Throwable -> L24
            x r7 = x.f38692a;     // Catch: Throwable -> L24
        L22:
            n.f(r7);     // Catch: Throwable -> L24
        L27:
            return x.f38692a;
        L21:
            r7 = null;
            goto L22
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r5);
            IslandImpl r8 = this.this$0;
            boolean r3 = this.$locked;
            n.a r9 = n.f38560a;     // Catch: Throwable -> L24
            this.Z$0 = r3;     // Catch: Throwable -> L24
            this.label = 1;     // Catch: Throwable -> L24
            r5 = r8.getService(this);     // Catch: Throwable -> L24
            if (r5 != r0) goto L14;
            return r0;
        L14:
            r4 = r3;
        L24:
            th = move-exception;
            n.a r10 = n.f38560a;
            n.f(o.a(th));
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$setVisible$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {207}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$setVisible$1")
    static final class C11891 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ boolean $visible;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11891(IslandImpl r3, boolean r4, d<? super C11891> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$visible = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11891(this.this$0, this.$visible, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11891) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11891.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.setVisible(this.$visible);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r7 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$tryExpand$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {123}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$tryExpand$1")
    static final class C11901 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ Boolean $canFrontShow;
        final /* synthetic */ IslandSession $targetSession;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11901(IslandImpl r3, IslandSession r4, Boolean r5, d<? super C11901> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$targetSession = r4;
            this.$canFrontShow = r5;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11901(this.this$0, this.$targetSession, this.$canFrontShow, r6), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11901) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11901.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L22;
            IslandSession r2 = this.$targetSession;
            Boolean r4 = this.$canFrontShow;
            if (r4 == null) goto L16;
        L15:
            boolean r7 = r4.booleanValue();
        L20:
            r6.tryExpand(r2, r7);
            goto L22
        L16:
            r4 = r2.getCanFrontShow();
            if (r4 != null) goto L15;
            r7 = false;
        L22:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r8 = this.this$0;
            d<? super IIslandService> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r8.getService(r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$updateSessionFlags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {143}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$updateSessionFlags$1")
    static final class C11911 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ IslandSession $session;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11911(IslandImpl r3, IslandSession r4, d<? super C11911> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$session = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11911(this.this$0, this.$session, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11911) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11911.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.updateSessionFlags(this.$session);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r7 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$updateWidget$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IslandImpl.kt */
    @f(b = "IslandImpl.kt", c = {104}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$updateWidget$1")
    static final class C11921 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ IslandSession $targetSession;
        final /* synthetic */ IslandWidget $targetWidget;
        int label;
        final /* synthetic */ IslandImpl this$0;

        C11921(IslandImpl r3, IslandSession r4, IslandWidget r5, d<? super C11921> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$targetSession = r4;
            this.$targetWidget = r5;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11921(this.this$0, this.$targetSession, this.$targetWidget, r6), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11921) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11921.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            r6.updateWidget(this.$targetSession, this.$targetWidget);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IslandImpl r7 = this.this$0;
            d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r7.getService(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ void lambda$1cucFQIpkWaG8gqsMASDmYqNMgE(IslandImpl r0) {
        registerIslandService$lambda$8$lambda$6(r0);
    }

    public IslandImpl() {
        this.mSessionMap = new ConcurrentHashMap();
        this.sessionLock = c.a(false, 1, null);
        this.serviceLock = c.a(false, 1, null);
        this.islandTaskFlow = ad.a(0, 64, null, 5, null);
        this.liveCardServiceDiedListeners = new CopyOnWriteArrayList();
        this.TAG = "IslandApi";
        kotlinx.coroutines.i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.a(), g.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static final /* synthetic */ w access$getIslandTaskFlow$p(IslandImpl r0) {
        return r0.islandTaskFlow;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getLiveCardServiceDiedListeners$p(IslandImpl r0) {
        return r0.liveCardServiceDiedListeners;
    }

    public static final /* synthetic */ a access$getSessionLock$p(IslandImpl r0) {
        return r0.sessionLock;
    }

    public static final /* synthetic */ String access$getTAG$p(IslandImpl r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$setLiveCardComponentName(IslandImpl r2, Context r3, Intent r4) {
        r2.setLiveCardComponentName((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public final ConcurrentHashMap<IslandSession, IIslandCardCallback> getMSessionMap() {
        return this.mSessionMap;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public boolean createSession(IslandSession r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, SensitiveType.SESSION);
        d.h.b.o.e(r8, "context");
        String r9 = ILiveCard.Companion.getInst().getPackageName();
        if (r9 != null) goto L6;
        return false;
    L6:
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11761(r6, this, r9, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
        return true;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void destroySession(IslandSession r5) {
        d.h.b.o.e(r5, SensitiveType.SESSION);
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11771(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void sendEvent(IslandSession r11, IslandWidget r12, String r13, String r14) {
        d.h.b.o.e(r11, "targetSession");
        d.h.b.o.e(r12, "targetWidget");
        d.h.b.o.e(r13, "eventId");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11871(this, r11, r12, r13, r14, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateWidget(IslandSession r5, IslandWidget r6) {
        d.h.b.o.e(r5, "targetSession");
        d.h.b.o.e(r6, "targetWidget");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11921(this, r5, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public Object updateAnimation(IslandSession r12, IslandWidget r13, d<? super x> r14) {
        d r15 = (d) ZeusTransformUtils.wrapperContextForParams(r14, d.class, "com.obric.aiagent.plugin");
        d.c.i r0 = new d.c.i(b.a(r15));
        d r7 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new IslandImpl$updateAnimation$2$1(this, r12, r13, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
        Object r11 = r0.a();
        if (r11 != b.a()) goto L6;
        d.c.b.a.h.c(r15);
    L6:
        if (r11 != b.a()) goto L9;
        return r11;
    L9:
        return x.f38692a;
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void tryExpand(IslandSession r5, Boolean r6) {
        d.h.b.o.e(r5, "targetSession");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11901(this, r5, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void collapseIsland() {
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11751(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public int getIslandVersion() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L11
        IIslandService r3 = this.mService;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        Bundle r4 = r3.getIslandVersion();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        int r5 = r4.getInt("version");     // Catch: Throwable -> L11
    L9:
        Object r6 = n.f(Integer.valueOf(r5));     // Catch: Throwable -> L11
    L14:
        if (n.b(r6) == false) goto L16;
        r6 = null;
    L16:
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L19;
        return 0;
    L19:
        return r7.intValue();
    L8:
        r5 = 0;
    L11:
        th = move-exception;
        n.a r2 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L14
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void updateSessionFlags(IslandSession r5) {
        d.h.b.o.e(r5, SensitiveType.SESSION);
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11911(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void addOnTopCardChangedListener(OnTopCardChangedListener r6) {
        OnTopCardChangedListener r7 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r6, OnTopCardChangedListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "callback");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11741(r7, this, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void removeOnTopCardChangedListener(OnTopCardChangedListener r6) {
        OnTopCardChangedListener r7 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r6, OnTopCardChangedListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "callback");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11861(this, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public void setPriority(IslandSession r4, long r5) {
        d.h.b.o.e(r4, SensitiveType.SESSION);
        if (r5 > System.currentTimeMillis()) goto L12;
        assertDialogueFeature();
        JsonObject r0 = r4.getExt();
        if (r0 != null) goto L7;
        r0 = new JsonObject();
    L7:
        r0.addProperty(LiveCardConstant.ISLAND_EXT_KEY_UPDATE_TIMESTAMP, (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r5), Number.class, "com.obric.aiagent.plugin"));
        r4.setExt(r0);
        if (((IIslandCardCallback) ZeusTransformUtils.preCheckCast(this.mSessionMap.get(r4), IIslandCardCallback.class, "com.obric.aiagent.plugin")) == null) goto L13;
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new IslandImpl$setPriority$2$1(this, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
        return;
    L13:
        return;
    L12:
        throw new IllegalArgumentException("priority > System.currentTimeMillis()");
    }

    @Override // com.obric.livecard.api.island.IslandApi
    public Object getPriority(IslandSession r6, d<? super Long> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C11781.class) == false) goto L7;
        C11781 r0 = (C11781) ZeusTransformUtils.preCheckCast(r8, C11781.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (IslandSession) ZeusTransformUtils.preCheckCast(r0.L$0, IslandSession.class, "com.obric.aiagent.plugin");
        o.a(r9);
    L17:
        IIslandService r5 = (IIslandService) ZeusTransformUtils.preCheckCast(r9, IIslandService.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L22;
        Bundle r10 = r5.getPriority(r6);
        if (r10 == null) goto L22;
        return d.c.b.a.b.a(r10.getLong("priority"));
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        assertDialogueFeature();
        r0.L$0 = r6;
        r0.label = 1;
        r9 = getService(r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new C11781(this, r8);
        goto L8
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onNotificationVisible(boolean r5) {
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11811(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void setVisible(boolean r5) {
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11891(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void addIslandStatusCallback(IslandStatusCallback r5) {
        d.h.b.o.e(r5, "callback");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11731(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void removeIslandStatusCallback(IslandStatusCallback r5) {
        d.h.b.o.e(r5, "callback");
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11851(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void registerIslandService(IIslandService r7) {
        IIslandService r8 = (IIslandService) ZeusTransformUtils.wrapperContextForParams(r7, IIslandService.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, WsConstants.KEY_SERVICE);
        a r0 = this.serviceLock;
        monitor-enter(r0);
        m<? extends IBinder, ? extends IBinder.DeathRecipient> r1 = this.currBinderDiedListener;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        ((IBinder) ZeusTransformUtils.preCheckCast(r1.a(), IBinder.class, "com.obric.aiagent.plugin")).unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r1.b(), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L10
    L7:
        IBinder r2 = r8.asBinder();     // Catch: Throwable -> L10
        IBinder.DeathRecipient r3 = new $$Lambda$IslandImpl$1cucFQIpkWaG8gqsMASDmYqNMgE(this);     // Catch: Throwable -> L10
        r8.asBinder().linkToDeath(r3, 0);     // Catch: Throwable -> L10
        x r4 = x.f38692a;     // Catch: Throwable -> L10
        this.currBinderDiedListener = new m(r2, r3);     // Catch: Throwable -> L10
        this.mService = r8;     // Catch: Throwable -> L10
        x r6 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static final void registerIslandService$lambda$8$lambda$6(IslandImpl r9) {
        d.h.b.o.e(r9, "this$0");
        a r0 = r9.serviceLock;
        monitor-enter(r0);
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);     // Catch: Throwable -> L8
        r9.mService = null;     // Catch: Throwable -> L8
        x r1 = x.f38692a;     // Catch: Throwable -> L8
        monitor-exit(r0);
        kotlinx.coroutines.i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.a(), g.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new IslandImpl$registerIslandService$1$2$2(r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onVolumeButtonClick() {
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11841(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onLauncherFocused() {
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11801(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void setKeyguardLocked(boolean r5) {
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11881(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    @Override // com.obric.livecard.api.island.IslandHideApi
    public void onSysUIFlagsChanged(long r5) {
        this.islandTaskFlow.a(new IslandTask(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11831(this, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null));
    }

    public final Object getService(d<? super IIslandService> r10) {
        d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C11791.class) == false) goto L7;
        C11791 r1 = (C11791) ZeusTransformUtils.preCheckCast(r11, C11791.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = b.a();
        int r4 = r1.label;
        boolean r7 = true;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L20;
        if (r4 != 3) goto L19;
        IslandImpl this = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$2, IslandImpl.class, "com.obric.aiagent.plugin");
        a r5 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.aiagent.plugin");
        IslandImpl r0 = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$0, IslandImpl.class, "com.obric.aiagent.plugin");
        o.a(r12);     // Catch: Throwable -> L16
    L47:
        this.mService = (IIslandService) ZeusTransformUtils.preCheckCast(r12, IIslandService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        this = r0;
    L49:
        x r13 = x.f38692a;     // Catch: Throwable -> L16
        r5.b(null);
    L56:
        return this.mService;
    L16:
        th = th;
    L53:
        r5.b(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        a r9 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.aiagent.plugin");
        IslandImpl r2 = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$0, IslandImpl.class, "com.obric.aiagent.plugin");
        o.a(r12);
        a r14 = r9;
        this = r2;
    L64:
    L51:
        th = th;
        r5 = r14;
        goto L53
    L42:
        if (this.mService != null) goto L48;
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new IslandImpl$getService$3$1(this, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        r1.L$0 = this;     // Catch: Throwable -> L51
        r1.L$1 = r14;     // Catch: Throwable -> L51
        r1.L$2 = this;     // Catch: Throwable -> L51
        r1.label = 3;     // Catch: Throwable -> L51
        Object r8 = dg.b(WsConstants.EXIT_DELAY_TIME, r6, r1);     // Catch: Throwable -> L51
        if (r8 != r3) goto L46;
        return r3;
    L46:
        r5 = r14;
        r12 = r8;
        r0 = this;
        goto L47
    L48:
        r5 = r14;
        goto L49
    L21:
        a r15 = (a) ZeusTransformUtils.preCheckCast(r1.L$1, a.class, "com.obric.aiagent.plugin");
        IslandImpl r16 = (IslandImpl) ZeusTransformUtils.preCheckCast(r1.L$0, IslandImpl.class, "com.obric.aiagent.plugin");
        o.a(r12);
        a r17 = r15;
        this = r16;
    L62:
        IIslandService r18 = this.mService;     // Catch: Throwable -> L57
        if (r18 == null) goto L32;
        IBinder r19 = r18.asBinder();     // Catch: Throwable -> L57
        if (r19 == null) goto L32;
        if (r19.isBinderAlive() == true) goto L32;
    L33:
        if (r7 == false) goto L35;
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);     // Catch: Throwable -> L57
        this.mService = null;     // Catch: Throwable -> L57
    L35:
        x r20 = x.f38692a;     // Catch: Throwable -> L57
        r17.b(null);
        if (this.mService != null) goto L56;
        r14 = this.serviceLock;
        r1.L$0 = this;
        r1.L$1 = r14;
        r1.label = 2;
        if (r14.a(null, r1) != r3) goto L64;
        return r3;
    L32:
        r7 = false;
    L57:
        th = move-exception;
        r17.b(null);
        throw th;
    L22:
        o.a(r12);
        r17 = this.serviceLock;
        r1.L$0 = this;
        r1.L$1 = r17;
        r1.label = 1;
        if (r17.a(null, r1) != r3) goto L62;
        return r3;
    L7:
        r1 = new C11791(this, r11);
        goto L8
    }

    private final void setLiveCardComponentName(Context r8, Intent r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L16
        IslandImpl r7 = (IslandImpl) ZeusTransformUtils.preCheckCast(this, IslandImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        ServiceInfo[] r11 = r10.getPackageManager().getPackageInfo(LIVE_CARD_HOST, 4).services;     // Catch: Throwable -> L16
        boolean r12 = false;
        if (r11 == null) goto L14;
        d.h.b.o.c(r11, "services");     // Catch: Throwable -> L16
        int r5 = r11.length;     // Catch: Throwable -> L16
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L11;
        if (d.h.b.o.a(r11[r6].name, LIVE_CARD_SERVICE) == true) goto L9;
        r6 = r6 + 1;     // Catch: Throwable -> L16
        goto L6
    L9:
        boolean r13 = true;
    L12:
        if (r13 != true) goto L14;
        r12 = true;
        goto L14
    L11:
        r13 = false;
    L14:
        Object r14 = n.f(Boolean.valueOf(r12));     // Catch: Throwable -> L16
    L19:
        if (n.b(r14) == false) goto L21;
        r14 = null;
    L21:
        Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L24;
        r2 = r15.booleanValue();
    L24:
        if (r2 == false) goto L26;
        r9.setClassName(LIVE_CARD_HOST, LIVE_CARD_SERVICE);
        return;
    L26:
        r9.setClassName(LIVE_CARD_HOST_DEPRECATED, "com.obric.livecard.port.IslandService");
        return;
    L16:
        th = move-exception;
        n.a r16 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L19
    }

    @Override // com.obric.livecard.api.impl.OnLiveCardServiceDiedListener
    public void onServiceDied() {
        INVOKESTATIC_com_obric_livecard_api_impl_IslandImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.TAG, "-------IslandImpl: onServiceDisconnected");
        LiveCard.INSTANCE.setIslandVersion$LiveCard_sdk_release(null);
        this.mService = null;
        kotlinx.coroutines.i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C11821(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void assertDialogueFeature() {
        ILiveCard r3 = ILiveCard.Companion.getInst();
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0);
        int r4 = r3.getVersion((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin"));
        if (r4 < 3) goto L6;
        return;
    L6:
        throw new IslandUnsupportedException("This method requires the LiveCard version to be IslandVersionCode.DIALOGUE_FEATURE, but the current version is " + r4);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_livecard_api_impl_IslandImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
