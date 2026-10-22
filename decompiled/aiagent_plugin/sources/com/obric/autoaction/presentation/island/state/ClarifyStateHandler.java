package com.obric.autoaction.presentation.island.state;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.island.template.OAutoDialogueIslandTemplate;
import com.obric.autoaction.presentation.island.template.OAutoExpandCardTemplate;
import com.obric.autoaction.presentation.island.template.TextButton;
import com.obric.autoaction.presentation.island.template.TitleWithIcon;
import com.obric.autoaction.presentation.island.template.UpdateBtnEventData;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.autogui.common.e;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: ClarifyStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClarifyStateHandler extends com.obric.autoaction.presentation.island.state.a {
    private ca delayUpdateTextJob;
    private ca islandStyleUpdateJob;

    /* JADX INFO: compiled from: ClarifyStateHandler.kt */
    @f(b = "ClarifyStateHandler.kt", c = {177}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.island.state.ClarifyStateHandler$delayUpdateText$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25087a;

        a(d.c.d<? super a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25087a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L11:
            IslandSession r8 = com.obric.autoaction.presentation.island.a.a().c();
            if (r8 == null) goto L14;
            IslandWidget r10 = r8.getExpandWidget();
        L15:
            if (r10 == null) goto L20;
            IslandSession r2 = com.obric.autoaction.presentation.island.a.a().c();
            if (r2 == null) goto L20;
            String r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_reply"));
            d.h.b.o.c(r3, "getString(...)");
            r2.sendAnyEvent(r10, "update_button", new UpdateBtnEventData("clarify_btn", false, new UpdateBtnEventData.Text(r3, null, "var:ai-gradient-a3")));
        L20:
            return x.f38692a;
        L14:
            r10 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25087a = 1;
            if (ax.a(5000, r11) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ClarifyStateHandler.kt */
    @f(b = "ClarifyStateHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.island.state.ClarifyStateHandler$listenInputStateChange$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClarifyStateHandler f25089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f25090c;

        b(ClarifyStateHandler r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25089b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f25089b, r5);
            r0.f25090c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f25088a != 0) goto L7;
            o.a(r3);
            am r4 = (am) ZeusTransformUtils.preCheckCast(this.f25090c, am.class, "com.obric.aiagent.plugin");
            ClarifyStateHandler.access$updateBtnStyleIfAssistShow(this.f25089b, r4);
            ClarifyStateHandler.access$delayUpdateText(this.f25089b, r4);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ClarifyStateHandler.kt */
    @f(b = "ClarifyStateHandler.kt", c = {132}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.island.state.ClarifyStateHandler$onClarify$clarifyExpandWidget$1$3$1$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAutoAgentWidgetStateListener.ClarifyOptions f25092b;

        c(IAutoAgentWidgetStateListener.ClarifyOptions r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25092b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f25092b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25091a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            IAutoActionPresentationApi r7 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L11;
            r7.exitClarifyStateInSurfaceActivity(this.f25092b.getOption());
        L11:
            AutoActionAgent r8 = AutoActionAgent.INSTANCE;
            String r2 = this.f25092b.getOption();
            d.c.d<? super e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25091a = 1;
            if (r8.exitUserClarify(r2, "gui_island_btn", r3) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ClarifyStateHandler.kt */
    @f(b = "ClarifyStateHandler.kt", c = {199}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.island.state.ClarifyStateHandler$updateBtnStyleIfAssistShow$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClarifyStateHandler f25094b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements h<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f25096a;

            /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.state.ClarifyStateHandler$d$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f25097a;

                /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.state.ClarifyStateHandler$d$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(b = "ClarifyStateHandler.kt", c = {219}, d = "emit", e = "com.obric.autoaction.presentation.island.state.ClarifyStateHandler$updateBtnStyleIfAssistShow$1$invokeSuspend$$inlined$map$1$2")
                public static final class C06011 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25098a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25099b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25100c;

                    public C06011(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25100c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25098a = r3;
                        this.f25099b |= Integer.MIN_VALUE;
                        return this.f25100c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f25097a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06011.class) == false) goto L7;
                    C06011 r0 = (C06011) ZeusTransformUtils.preCheckCast(r8, C06011.class, "com.obric.aiagent.plugin");
                    if ((r0.f25099b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25099b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25098a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25099b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r9);
                    i r5 = this.f25097a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    Boolean r11 = d.c.b.a.b.a(((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getAssistState().getVisible());
                    r0.f25099b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06011(this, r8);
                    goto L8
                }
            }

            public a(h r3) {
                this.f25096a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super Boolean> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25096a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        d(ClarifyStateHandler r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25094b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f25094b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25093a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            h r7 = j.b((h) ZeusTransformUtils.preCheckCast(new a((h) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState(), h.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin"));
            final ClarifyStateHandler r4 = this.f25094b;
            i r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25093a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$4DRaK5spVgcRS-aRCbRMlTi7uBk, reason: not valid java name */
    public static /* synthetic */ x m628lambda$4DRaK5spVgcRSaRCbRMlTi7uBk() {
        return onClarify$lambda$7$lambda$3();
    }

    public static /* synthetic */ x lambda$Cxj8gXT2Co_3bJoFqYNdPOkXg98(ClarifyStateHandler r0) {
        return onClarify$lambda$7$lambda$6(r0);
    }

    public static /* synthetic */ x lambda$Tv9dOGNrGzi8ZYUfTOjhV7cUrxE() {
        return onClarify$lambda$7$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$cxdTydYPD-H4JBvUSt6PvnxxVDA, reason: not valid java name */
    public static /* synthetic */ x m629lambda$cxdTydYPDH4JBvUSt6PvnxxVDA(IAutoAgentWidgetStateListener.ClarifyOptions r0) {
        return onClarify$lambda$7$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ x lambda$jUS3ai6gimciOfBBhHnWBTg0VaA(IslandSession r0, int r1) {
        return onClarify$lambda$7$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ x lambda$rTAcxcknNPMjiHDyOv0NGJgmb6U(ClarifyStateHandler r0) {
        return onClarify$lambda$9$lambda$8(r0);
    }

    public static final /* synthetic */ void access$delayUpdateText(ClarifyStateHandler r2, am r3) {
        r2.delayUpdateText((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$updateBtnStyleIfAssistShow(ClarifyStateHandler r2, am r3) {
        r2.updateBtnStyleIfAssistShow((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"));
    }

    public ClarifyStateHandler() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onClarify(WidgetState.Clarify r36) {
        d.h.b.o.e(r36, "state");
        List<IAutoAgentWidgetStateListener.ClarifyOptions> r2 = r36.getGuiClarifyOptions();
        Icon r3 = new Icon(20, 20, "svg:island_stop", null, null, null, null, 120, null);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r7 = R.string.obric_widget_expect_reply;
        String r10 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        String r8 = r6.getString(ZeusTransformUtils.mapRes(r7, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_expect_reply"));
        String r11 = "getString(...)";
        d.h.b.o.c(r8, "getString(...)");
        TitleWithIcon r4 = new TitleWithIcon(r3, new Text(r8, 14, com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_2, "color", "oui_on_accent_text_2"), false, 2, null)));
        String r5 = r36.getSessionInfo().getTask().getUserTask();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        Text r9 = new Text(r5, 12, com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_3, "color", "oui_on_accent_text_3"), false, 2, null));
        String r12 = "var:ai-gradient-a3";
        Text r13 = new Text(r36.getStepInfo().getAction(), 16, "var:ai-gradient-a3");
        if (r2 != null) goto L8;
        Icon r14 = new Icon(18, 18, "svg:reply_pink", null, null, null, null, 120, null);
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_hold_ai_or_voice_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_hold_ai_or_voice_reply"));
        d.h.b.o.c(r0, "getString(...)");
        TextButton r15 = new TextButton("clarify_btn", r14, new Text(r0, 14, "var:ai-gradient-a3"), null, null, 24, null);
    L10:
        if (r2 == null) goto L27;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
        int r19 = 0;
    L13:
        if (r18.hasNext() == false) goto L26;
        Object r110 = r18.next();
        int r111 = r19 + 1;
        if (r19 >= 0) goto L17;
        p.c();
    L17:
        Iterator r112 = r18;
        IAutoAgentWidgetStateListener.ClarifyOptions r20 = (IAutoAgentWidgetStateListener.ClarifyOptions) ZeusTransformUtils.preCheckCast(r110, IAutoAgentWidgetStateListener.ClarifyOptions.class, "com.obric.aiagent.plugin");
        boolean r113 = r20.getHighLight();
        String r114 = r12;
        if (r113 == true) goto L20;
        Object r115 = null;
        boolean r116 = false;
        int r117 = 2;
        String r1 = com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.island_btn_bg_dark, "color", "island_btn_bg_dark"), false, 2, null);
    L21:
        String r31 = r1;
        if (r113 == true) goto L24;
        String r21 = com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.white, "color", "white"), r116, r117, r115);
    L25:
        r17.add(new TextButton("gui_clarify_btn_" + r19, null, new Text(r20.getOption(), 14, r21), r31, null, 16, null));
        r18 = r112;
        r12 = r114;
        r19 = r111;
        r11 = r11;
        r10 = r10;
        goto L13
    L24:
        r21 = r114;
        goto L25
    L20:
        r115 = null;
        r116 = false;
        r117 = 2;
        r1 = "var:ai-gradient-a3-lighter";
        goto L21
    L26:
        String r22 = r10;
        String r23 = r11;
        List r24 = p.o((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L28:
        OAutoExpandCardTemplate r25 = new OAutoExpandCardTemplate(r4, r9, r13, r15, r24);
        com.obric.autoaction.presentation.island.template.a r118 = com.obric.autoaction.presentation.island.template.a.f25101a;
        String r26 = r22;
        String r119 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_please_reply, r26, "obric_widget_please_reply"));
        d.h.b.o.c(r119, r23);
        IslandWidget r120 = new OAutoDialogueIslandTemplate(r25, com.obric.autoaction.presentation.island.template.a.a(r118, "svg:island_stop_expand", "svg:reply", r119, r36.getStepInfo().getAction(), null, 16, null)).create(Boolean.valueOf(com.obric.autoaction.presentation.island.state.b.a((WidgetState) ZeusTransformUtils.preCheckCast(r36, WidgetState.class, "com.obric.aiagent.plugin"))));
        r120.addOnViewClickCallback("clarify_btn", $$Lambda$ClarifyStateHandler$Tv9dOGNrGzi8ZYUfTOjhV7cUrxE.INSTANCE);
        r120.addOnViewClickCallback("btn_default", $$Lambda$ClarifyStateHandler$4DRaK5spVgcRSaRCbRMlTi7uBk.INSTANCE);
        List<IAutoAgentWidgetStateListener.ClarifyOptions> r27 = r36.getGuiClarifyOptions();
        if (r27 == null) goto L37;
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r121 = 0;
    L32:
        if (r28.hasNext() == false) goto L37;
        Object r29 = r28.next();
        int r30 = r121 + 1;
        if (r121 >= 0) goto L36;
        p.c();
    L36:
        final IAutoAgentWidgetStateListener.ClarifyOptions r32 = (IAutoAgentWidgetStateListener.ClarifyOptions) ZeusTransformUtils.preCheckCast(r29, IAutoAgentWidgetStateListener.ClarifyOptions.class, "com.obric.aiagent.plugin");
        r120.addOnViewClickCallback("gui_clarify_btn_" + r121, new $$Lambda$ClarifyStateHandler$cxdTydYPDH4JBvUSt6PvnxxVDA(r32));
        r121 = r30;
    L37:
        r120.setOnCardClickCallback(new $$Lambda$ClarifyStateHandler$Cxj8gXT2Co_3bJoFqYNdPOkXg98(this));
        IslandWidget r122 = CommonCollapseTemplate.create$default(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:island_stop", null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_please_reply, r26, "obric_widget_please_reply")), null, 10, null), null, 1, null);
        r122.setOnCardClickCallback(new $$Lambda$ClarifyStateHandler$rTAcxcknNPMjiHDyOv0NGJgmb6U(this));
        if (com.obric.autoaction.presentation.island.state.b.a((WidgetState) ZeusTransformUtils.preCheckCast(r36, WidgetState.class, "com.obric.aiagent.plugin")) == false) goto L40;
        com.obric.autoaction.presentation.island.a.a().a(8, false);
    L40:
        com.obric.autoaction.presentation.island.b.a(com.obric.autoaction.presentation.island.a.a(), r122, r120, false, 4, null);
        return;
    L27:
        r22 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r23 = "getString(...)";
        r24 = null;
        goto L28
    L8:
        r15 = null;
        goto L10
    }

    private static final x onClarify$lambda$7$lambda$1() {
        com.obric.autoaction.presentation.input.b.a(com.obric.autoaction.presentation.input.b.f24958a, false, false, null, null, 15, null);
        return x.f38692a;
    }

    private static final x onClarify$lambda$7$lambda$3() {
        com.obric.autoaction.presentation.island.a.a().a($$Lambda$ClarifyStateHandler$jUS3ai6gimciOfBBhHnWBTg0VaA.INSTANCE);
        return x.f38692a;
    }

    private static final x onClarify$lambda$7$lambda$3$lambda$2(IslandSession r7, int r8) {
        d.h.b.o.e(r7, SensitiveType.SESSION);
        if (r8 != (-1)) goto L6;
        com.obric.autoaction.presentation.input.b.a(com.obric.autoaction.presentation.input.b.f24958a, false, false, null, null, 15, null);
    L6:
        return x.f38692a;
    }

    private static final x onClarify$lambda$7$lambda$5$lambda$4(IAutoAgentWidgetStateListener.ClarifyOptions r9) {
        kotlinx.coroutines.i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return x.f38692a;
    }

    private static final x onClarify$lambda$7$lambda$6(ClarifyStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private static final x onClarify$lambda$9$lambda$8(ClarifyStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    public final ca getIslandStyleUpdateJob() {
        return this.islandStyleUpdateJob;
    }

    public final void setIslandStyleUpdateJob(ca r3) {
        this.islandStyleUpdateJob = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    }

    public final ca getDelayUpdateTextJob() {
        return this.delayUpdateTextJob;
    }

    public final void setDelayUpdateTextJob(ca r3) {
        this.delayUpdateTextJob = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    }

    private final void listenInputStateChange() {
        ca r0 = this.islandStyleUpdateJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        ca r1 = this.delayUpdateTextJob;
        if (r1 == null) goto L8;
        ca.a.a(r1, null, 1, null);
    L8:
        this.islandStyleUpdateJob = kotlinx.coroutines.i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void delayUpdateText(am r9) {
        this.delayUpdateTextJob = kotlinx.coroutines.i.a((am) ZeusTransformUtils.wrapperContextForParams(r9, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void updateBtnStyleIfAssistShow(am r9) {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.wrapperContextForParams(r9, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateChange(WidgetState r2, WidgetState r3) {
        d.h.b.o.e(r3, "state");
        super.onStateChange(r2, r3);
        if (ZeusTransformUtils.instanceOf(r3, WidgetState.Clarify.class) == false) goto L5;
        listenInputStateChange();
        return;
    L5:
        ca r4 = this.delayUpdateTextJob;
        if (r4 == null) goto L8;
        ca.a.a(r4, null, 1, null);
    L8:
        ca r5 = this.islandStyleUpdateJob;
        if (r5 == null) goto L11;
        ca.a.a(r5, null, 1, null);
    L11:
        this.delayUpdateTextJob = null;
        this.islandStyleUpdateJob = null;
    }

    private final void openPlayer() {
        IAutoActionPresentationApi r2 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        IAutoActionPresentationApi.DefaultImpls.openPlayer$default(r2, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "click_dynamic_island", null, 4, null);
        return;
    }
}
