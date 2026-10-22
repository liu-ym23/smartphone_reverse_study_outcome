package com.obric.autoaction.presentation.island;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.IslandState;
import com.obric.autogui.util.ui.e;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bs;

/* JADX INFO: compiled from: GlobalTaskStateIslandManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.obric.autoaction.presentation.island.b f25040a = null;

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlobalTaskStateIslandManager.kt */
    @f(b = "GlobalTaskStateIslandManager.kt", c = {41}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.island.GlobalTaskStateIslandManagerKt$initTaskStateIslandManager$1")
    static final class C0596a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25041a;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class C0597a implements h<IAutoActionPresentationApi.PlayerVisibility> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f25043a;

            /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.a$a$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f25044a;

                /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.a$a$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(b = "GlobalTaskStateIslandManager.kt", c = {219}, d = "emit", e = "com.obric.autoaction.presentation.island.GlobalTaskStateIslandManagerKt$initTaskStateIslandManager$1$invokeSuspend$$inlined$map$1$2")
                public static final class C05981 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25045a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25046b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25047c;

                    public C05981(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25047c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25045a = r3;
                        this.f25046b |= Integer.MIN_VALUE;
                        return this.f25047c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f25044a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C05981.class) == false) goto L7;
                    C05981 r0 = (C05981) ZeusTransformUtils.preCheckCast(r8, C05981.class, "com.obric.aiagent.plugin");
                    if ((r0.f25046b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25046b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25045a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25046b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r9);
                    i r5 = this.f25044a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    IAutoActionPresentationApi.PlayerVisibility r11 = ((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getPlayer().getVisible();
                    r0.f25046b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C05981(this, r8);
                    goto L8
                }
            }

            public C0597a(h r3) {
                this.f25043a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super IAutoActionPresentationApi.PlayerVisibility> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25043a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        C0596a(d.c.d<? super C0596a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0596a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0596a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0596a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25041a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            h r7 = j.b((h) ZeusTransformUtils.preCheckCast(new C0597a((h) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState(), h.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin"));
            i r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25042a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25041a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: GlobalTaskStateIslandManager.kt */
    public static final class b extends PluginBroadcastReceiver {
        b() {
        }

        public void onReceive(Context r7, Intent r8) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L5;
            String r9 = r8.getAction();
        L6:
            if (r9 != null) goto L8;
            return;
        L8:
            if (r9.hashCode() == (-2128145023)) goto L11;
            return;
        L11:
            if (r9.equals("android.intent.action.SCREEN_OFF") == false) goto L15;
            com.obric.autoaction.presentation.island.b.a(a.a(), 8, false, 2, null);
            a.a().e();
            return;
        L15:
            return;
        L5:
            r9 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: GlobalTaskStateIslandManager.kt */
    public static final class c implements IslandCardCallback {
        c() {
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionCreate(IslandSession r10) {
            d.h.b.o.e(r10, SensitiveType.SESSION);
            kotlinx.coroutines.b.x<GlobalUIContext> r9 = AutoActionUIContext.INSTANCE.getState();
        L3:
            GlobalUIContext r11 = r9.c();
            GlobalUIContext r1 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r11, GlobalUIContext.class, "com.obric.aiagent.plugin");
            if (r9.a(r11, GlobalUIContext.copy$default(r1, null, IslandState.copy$default(r1.getIsland(), false, false, false, 3, null), null, null, 13, null)) == false) goto L3;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionActive(IslandSession r10) {
            d.h.b.o.e(r10, SensitiveType.SESSION);
            kotlinx.coroutines.b.x<GlobalUIContext> r9 = AutoActionUIContext.INSTANCE.getState();
        L3:
            GlobalUIContext r11 = r9.c();
            GlobalUIContext r1 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r11, GlobalUIContext.class, "com.obric.aiagent.plugin");
            if (r9.a(r11, GlobalUIContext.copy$default(r1, null, IslandState.copy$default(r1.getIsland(), true, false, false, 6, null), null, null, 13, null)) == false) goto L3;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionInactive(IslandSession r10) {
            d.h.b.o.e(r10, SensitiveType.SESSION);
            IslandSession r9 = a.a().c();
            boolean r0 = false;
            if (r9 != null) goto L5;
        L7:
            if (r0 == false) goto L11;
            kotlinx.coroutines.b.x<GlobalUIContext> r11 = AutoActionUIContext.INSTANCE.getState();
        L9:
            GlobalUIContext r12 = r11.c();
            GlobalUIContext r1 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r12, GlobalUIContext.class, "com.obric.aiagent.plugin");
            if (r11.a(r12, GlobalUIContext.copy$default(r1, null, IslandState.copy$default(r1.getIsland(), false, false, false, 6, null), null, null, 13, null)) == false) goto L9;
            return;
        L11:
            return;
        L5:
            if (r9.getTaskId() != r10.getTaskId()) goto L7;
            r0 = true;
            goto L7
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionDestroy(IslandSession r8, Integer r9) {
            d.h.b.o.e(r8, SensitiveType.SESSION);
            if (a.a().c() != null) goto L7;
            kotlinx.coroutines.b.x<GlobalUIContext> r7 = AutoActionUIContext.INSTANCE.getState();
        L5:
            GlobalUIContext r10 = r7.c();
            GlobalUIContext r0 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r10, GlobalUIContext.class, "com.obric.aiagent.plugin");
            if (r7.a(r10, GlobalUIContext.copy$default(r0, null, r0.getIsland().copy(false, false, false), null, null, 13, null)) == false) goto L5;
            return;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionStatusChanged(IslandSession r10, int r11) {
            d.h.b.o.e(r10, SensitiveType.SESSION);
            IslandSession r9 = a.a().c();
            boolean r0 = false;
            if (r9 != null) goto L5;
        L7:
            if (r0 == true) goto L10;
            return;
        L10:
            if (r11 != (-2)) goto L12;
            kotlinx.coroutines.b.x<GlobalUIContext> r12 = AutoActionUIContext.INSTANCE.getState();
        L19:
            GlobalUIContext r13 = r12.c();
            GlobalUIContext r1 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r13, GlobalUIContext.class, "com.obric.aiagent.plugin");
            if (r12.a(r13, GlobalUIContext.copy$default(r1, null, IslandState.copy$default(r1.getIsland(), false, false, false, 3, null), null, null, 13, null)) == false) goto L19;
            com.obric.autoaction.presentation.input.b.f24958a.d();
            return;
        L12:
            if (r11 != (-1)) goto L27;
            e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 10);
            kotlinx.coroutines.b.x<GlobalUIContext> r14 = AutoActionUIContext.INSTANCE.getState();
        L15:
            GlobalUIContext r15 = r14.c();
            GlobalUIContext r2 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r15, GlobalUIContext.class, "com.obric.aiagent.plugin");
            if (r14.a(r15, GlobalUIContext.copy$default(r2, null, IslandState.copy$default(r2.getIsland(), false, false, true, 3, null), null, null, 13, null)) == false) goto L15;
            return;
        L27:
            return;
        L5:
            if (r10.getTaskId() != r9.getTaskId()) goto L7;
            r0 = true;
            goto L7
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public Bundle onWidgetShow(IslandWidget r12) {
            d.h.b.o.e(r12, "widget");
            kotlinx.coroutines.b.x<GlobalUIContext> r11 = AutoActionUIContext.INSTANCE.getState();
        L3:
            GlobalUIContext r0 = r11.c();
            GlobalUIContext r2 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r0, GlobalUIContext.class, "com.obric.aiagent.plugin");
            IslandState r4 = r2.getIsland();
            IslandSession r1 = a.a().c();
            if (r1 == null) goto L6;
            IslandWidget r3 = r1.getExpandWidget();
        L8:
            if (r11.a(r0, GlobalUIContext.copy$default(r2, null, IslandState.copy$default(r4, true, d.h.b.o.a(r12, r3), false, 4, null), null, null, 13, null)) == false) goto L3;
            return null;
        L6:
            r3 = null;
            goto L8
        }
    }

    static {
        f25040a = new com.obric.autoaction.presentation.island.b(true, 0, null, "task_state", 6, null);
    }

    public static final com.obric.autoaction.presentation.island.b a() {
        return f25040a;
    }

    public static final void b() {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new C0596a(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        PluginBroadcastReceiver r1 = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(new b(), PluginBroadcastReceiver.class, "com.obric.aiagent.plugin");
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.SCREEN_OFF");
        x r4 = x.f38692a;
        ZeusTransformUtils.registerReceiver(r0, r1, r3, "com.obric.aiagent.plugin");
        f25040a.a((IslandCardCallback) ZeusTransformUtils.preCheckCast(new c(), IslandCardCallback.class, "com.obric.aiagent.plugin"));
    }
}
