package com.obric.autogui.session.functions.impl.vd;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.am;
import org.json.JSONObject;

/* JADX INFO: compiled from: VDEventsListenerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDEventsListenerImpl implements IAutoActionVDListener {
    public static final a Companion = null;
    private static final String KEY_EXTRA_TRACKING_APP = "vdex_tracking_app";
    public static final String KEY_EXTRA_TRACKING_APP_INFO = "vdex_tracking_app_info";
    private static final String TAG = "Agent-VDEvents";

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final VDTrackingApp a(com.obric.autogui.session.a r2) {
            d.h.b.o.e(r2, "<this>");
            Object r1 = r2.F().get(VDEventsListenerImpl.KEY_EXTRA_TRACKING_APP);
            if (ZeusTransformUtils.instanceOf(r1, VDTrackingApp.class) == true) goto L7;
            return null;
        L7:
            return (VDTrackingApp) ZeusTransformUtils.preCheckCast(r1, VDTrackingApp.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {663}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$appMovedToMdBackground$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f31096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f31097d;

        b(VDEventsListenerImpl r3, String r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31095b = r3;
            this.f31096c = r4;
            super(2, r6);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f31095b, this.f31096c, r6);
            r0.f31097d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31094a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            com.obric.autogui.session.a r5 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31097d, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            VDEventsListenerImpl r4 = this.f31095b;
            String r6 = this.f31096c;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31094a = 1;
            if (VDEventsListenerImpl.resumePendingOpenApp$default(r4, r5, r6, 0, r8, 2, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$handleOperatingAppChanged$3")
    static final class c extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ VDTrackingApp f31100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f31101d;

        c(VDEventsListenerImpl r3, VDTrackingApp r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31099b = r3;
            this.f31100c = r4;
            super(2, r6);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f31099b, this.f31100c, r6);
            r0.f31101d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            d.c.a.b.a();
            if (this.f31098a != 0) goto L60;
            d.o.a(r12);
            com.obric.autogui.session.a r13 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31101d, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            VDTrackingApp r0 = VDEventsListenerImpl.access$getTrackingApp(this.f31099b, r13);
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, "[VD] App changed [" + r0 + "] --> [" + this.f31100c + ']');
            if (r13.L() == true) goto L9;
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - ignored: ongoing session state=" + r13.m().e() + " - not in agent-active state");
            return x.f38692a;
        L9:
            if (VDEventsListenerImpl.access$setTrackingApp(this.f31099b, r13, this.f31100c) == false) goto L11;
            VDEventsListenerImpl r2 = this.f31099b;
            VDTrackingApp r3 = this.f31100c;
            String r5 = null;
            if (r3 == null) goto L15;
            String r4 = r3.getPackageName();
        L16:
            VDEventsListenerImpl.access$reportAssistantOperateApps(r2, r4);
            z.f r6 = new z.f();
            VDTrackingApp r7 = this.f31100c;
            VDEventsListenerImpl r8 = this.f31099b;
            long r9 = System.currentTimeMillis();
            if (r7 == null) goto L19;
            T r10 = VDEventsListenerImpl.access$fetchAppInfo(r8, r7);
        L20:
            r6.f38504a = r10;
            long r11 = System.currentTimeMillis() - r9;
            if (r0 == null) goto L23;
            String r14 = r0.getPackageName();
        L24:
            VDTrackingApp r15 = this.f31100c;
            if (r15 == null) goto L27;
            String r16 = r15.getPackageName();
        L29:
            if (d.h.b.o.a(r14, r16) == false) goto L40;
            if (r0 == null) goto L32;
            Integer r17 = d.c.b.a.b.a(r0.getTaskId());
        L33:
            VDTrackingApp r18 = this.f31100c;
            if (r18 == null) goto L36;
            Integer r19 = d.c.b.a.b.a(r18.getTaskId());
        L38:
            if (d.h.b.o.a(r17, r19) == true) goto L40;
            boolean r20 = true;
        L41:
            IAutoActionAgentEventListener.OperatingAppInfo r21 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r6.f38504a, IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
            if (r21 == null) goto L45;
            r21.setTaskIdChanged(r20);
        L45:
            if (r6.f38504a != 0) goto L47;
            r13.F().remove(VDEventsListenerImpl.KEY_EXTRA_TRACKING_APP_INFO);
        L57:
            long r22 = System.currentTimeMillis();
            com.obric.autogui.b.a.f28928a.onOperatingAppChanged(r13.d(), (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r6.f38504a, IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin"));
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD] tracking-app changed to " + this.f31100c + "; l(AppFetch)=" + r11 + "ms; l(Trigger)=" + (System.currentTimeMillis() - r22) + "ms");
            return x.f38692a;
        L47:
            r13.F().put(VDEventsListenerImpl.KEY_EXTRA_TRACKING_APP_INFO, r6.f38504a);
            if (r0 == null) goto L50;
            String r1 = r0.getPackageName();
        L51:
            VDTrackingApp r23 = this.f31100c;
            if (r23 == null) goto L55;
            r5 = r23.getPackageName();
        L55:
            if (d.h.b.o.a(r1, r5) == true) goto L57;
            r13.a((IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r6.f38504a, IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin"));
            goto L57
        L50:
            r1 = null;
            goto L51
        L36:
            r19 = null;
            goto L38
        L32:
            r17 = null;
        L40:
            r20 = false;
            goto L41
        L27:
            r16 = null;
            goto L29
        L23:
            r14 = null;
            goto L24
        L19:
            r10 = 0;
            goto L20
        L15:
            r4 = null;
            goto L16
        L11:
            return x.f38692a;
        L60:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {784, 786}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$launchBlackListActions$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ComponentName f31104c;

        d(VDEventsListenerImpl r3, ComponentName r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31103b = r3;
            this.f31104c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f31103b, this.f31104c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31102a;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 != 2) goto L11;
            d.o.a(r6);     // Catch: Throwable -> L8
        L19:
            AppBlackListEventHolder.INSTANCE.unlock();
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r6);
        L16:
            VDEventsListenerImpl r7 = this.f31103b;     // Catch: Throwable -> L8
            ComponentName r2 = this.f31104c;     // Catch: Throwable -> L8
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            this.f31102a = 2;     // Catch: Throwable -> L8
            if (VDEventsListenerImpl.access$takeBlackListActionsLocked(r7, r2, r3) != r0) goto L19;
            return r0;
        L13:
            d.o.a(r6);
            AppBlackListEventHolder r8 = AppBlackListEventHolder.INSTANCE;
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31102a = 1;
            if (r8.lock(r4) != r0) goto L16;
            return r0;
        L8:
            th = move-exception;
            AppBlackListEventHolder.INSTANCE.unlock();
            throw th;
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$reportAssistantOperateApps$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31106b;

        e(String r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31106b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f31106b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f31105a != 0) goto L12;
            d.o.a(r5);
            int r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationInfo(this.f31106b, 0).uid;     // Catch: Throwable -> L7
            com.obric.aiagent.os.libs.a.a().a(new int[]{r6});     // Catch: Throwable -> L7
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD] reportAssistantOperateApps pkg=" + this.f31106b + ", uid=" + r6);     // Catch: Throwable -> L7
        L10:
            return x.f38692a;
        L7:
            th = move-exception;
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - [VD] reportAssistantOperateApps failed for pkg=" + this.f31106b + ": " + th);
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {630}, d = "resumeForTaskModification", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f31108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31111e;

        f(VDEventsListenerImpl r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31110d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31109c = r3;
            this.f31111e |= Integer.MIN_VALUE;
            return VDEventsListenerImpl.access$resumeForTaskModification(this.f31110d, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {861}, d = "takeBlackListActionsLocked", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f31114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f31115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31116e;
        int f;

        g(VDEventsListenerImpl r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31116e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31115d = r3;
            this.f |= Integer.MIN_VALUE;
            return VDEventsListenerImpl.access$takeBlackListActionsLocked(this.f31116e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {929}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$takeBlackListActionsLocked$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f31118b;

        h(d.c.d<? super h> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            h r4 = new h((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f31118b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31117a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.autogui.session.a r8 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31118b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD-BlackList] triggered; relaunching");
            com.obric.autogui.session.c.f30777a.b(r8);
            com.obric.autogui.session.functions.c r9 = r8.n();
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31117a = 1;
            if (r9.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {497}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$taskClosed$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f31120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f31121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31122d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f31123e;

        i(boolean r3, int r4, VDEventsListenerImpl r5, d.c.d<? super i> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31120b = r3;
            this.f31121c = r4;
            this.f31122d = r5;
            super(2, r7);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f31120b, this.f31121c, this.f31122d, r7);
            r0.f31123e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31119a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.autogui.session.a r9 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31123e, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            if (this.f31120b == true) goto L14;
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - [MD] Task closed [" + this.f31121c + "] (not-tracking); re-trying OpenApp.");
            VDEventsListenerImpl r2 = this.f31122d;
            int r5 = this.f31121c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31119a = 1;
            if (VDEventsListenerImpl.access$resumePendingOpenApp(r2, r9, null, r5, r3) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {599}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$trackingAppMovedToMd$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ VDTrackingApp f31125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f31127d;

        j(VDTrackingApp r3, VDEventsListenerImpl r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31125b = r3;
            this.f31126c = r4;
            super(2, r6);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            j r0 = new j(this.f31125b, this.f31126c, r6);
            r0.f31127d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31124a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L22:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            com.obric.autogui.session.a r13 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31127d, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, "App moved: [VD] --> [MAIN] (" + this.f31125b + ')');
            VDTrackingApp r2 = VDEventsListenerImpl.access$getTrackingApp(this.f31126c, r13);
            if (this.f31125b.isSameAs(r2) == true) goto L12;
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - " + this.f31125b + " != " + r2 + "; ignored");
            return x.f38692a;
        L12:
            com.obric.autogui.session.state.b.c r3 = r13.m().d();
            boolean r4 = r13.J().e();
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD] --> [MAIN] (" + this.f31125b + "); " + r3.e() + ", terminationActive=" + r4 + ", session=" + r13.a());
            if (r3.d() == true) goto L23;
            if (r4 == true) goto L23;
            if (r3.a(BizStatus.OPERATING) == false) goto L22;
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, "OccupyTakeOverTrace - [VD][OccupyApp] entering user-interrupted from trackingApp=" + this.f31125b + ", trackingAppInfo=" + r13.F().get(VDEventsListenerImpl.KEY_EXTRA_TRACKING_APP_INFO));
            com.obric.autogui.session.state.b r14 = r13.m();
            BizStatus r5 = BizStatus.USER_INTERRUPTED;
            BizStatus.StatusChangedReasonStruct r6 = BizStatus.StatusChangedReasonStruct.Companion.getDEFAULT();
            d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31124a = 1;
            if (r14.a(r5, r6, r7) != r0) goto L22;
            return r0;
        L23:
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, "OccupyTakeOverTrace - [VD][OccupyApp] skip user-interrupted because termination is active, trackingApp=" + this.f31125b + ", " + r3.e() + ", terminationActive=" + r4 + ", session=" + r13.a());
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {614}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$trackingAppMovedToVd$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ VDTrackingApp f31129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f31131d;

        k(VDTrackingApp r3, VDEventsListenerImpl r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31129b = r3;
            this.f31130c = r4;
            super(2, r6);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f31129b, this.f31130c, r6);
            r0.f31131d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31128a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.autogui.session.a r8 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31131d, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, "App moved: [MAIN] --> [VD] (" + this.f31129b + ')');
            VDTrackingApp r2 = VDEventsListenerImpl.access$getTrackingApp(this.f31130c, r8);
            if (this.f31129b.isSameTaskAs(r2) == true) goto L12;
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - " + this.f31129b + " != " + r2 + "; ignored (unmatched task)");
            return x.f38692a;
        L12:
            VDEventsListenerImpl r3 = this.f31130c;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31128a = 1;
            if (VDEventsListenerImpl.access$resumeForTaskModification(r3, r8, true, r4) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {528}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$trackingAppTerminated$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ VDEventsListenerImpl f31133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ VDTrackingApp f31134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f31135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f31136e;

        l(VDEventsListenerImpl r3, VDTrackingApp r4, boolean r5, d.c.d<? super l> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31133b = r3;
            this.f31134c = r4;
            this.f31135d = r5;
            super(2, r7);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            l r0 = new l(this.f31133b, this.f31134c, this.f31135d, r7);
            r0.f31136e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31132a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L24:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            com.obric.autogui.session.a r11 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31136e, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            VDTrackingApp r2 = VDEventsListenerImpl.access$getTrackingApp(this.f31133b, r11);
            if (this.f31134c.isSameAs(r2) == true) goto L12;
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - " + this.f31134c + " != " + r2 + "; ignored");
            return x.f38692a;
        L12:
            CharSequence r4 = null;
            if (r2 == null) goto L17;
            String r3 = r2.getPackageName();
            if (r3 == null) goto L17;
            AppInfoEntry r5 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3);
        L19:
            if (this.f31135d == true) goto L25;
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD] App terminated [" + this.f31134c + "] proceeding to Operating (configured)");
            VDEventsListenerImpl.access$addAppRemovedPrompt(this.f31133b, r11, r5);
            VDEventsListenerImpl r6 = this.f31133b;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31132a = 1;
            if (VDEventsListenerImpl.access$resumeForTaskModification(r6, r11, false, r7) != r0) goto L24;
            return r0;
        L25:
            Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - app term: proceeding to finish state");
            com.obric.autogui.session.state.d r9 = com.obric.autogui.session.state.d.f31396a;
            com.obric.autogui.common.e.a r8 = com.obric.autogui.common.e.f29014b;
            if (r5 == null) goto L28;
            CharSequence r12 = r5.getAppLabel();
        L29:
            if (r12 != null) goto L31;
        L34:
            boolean r13 = true;
        L36:
            if (r13 == false) goto L38;
            String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_user_manual_operation_wo_app_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_user_manual_operation_wo_app_name"));
        L42:
            d.h.b.o.a(r14);
            r9.a(r11, r8.c(r14), 112001);
            return x.f38692a;
        L38:
            Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            int r16 = ZeusTransformUtils.mapRes(R.string.agent_task_early_term_user_manual_operation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_user_manual_operation");
            Object[] r17 = new Object[1];
            if (r5 == null) goto L41;
            r4 = r5.getAppLabel();
        L41:
            r17[0] = r4;
            r14 = r15.getString(r16, r17);
            goto L42
        L31:
            if (d.o.o.d(r12) == true) goto L34;
            r13 = false;
            goto L36
        L28:
            r12 = null;
        L17:
            r5 = null;
            goto L19
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$vdBlacklistAppOpen$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f31139c;

        /* JADX INFO: renamed from: com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$m$1, reason: invalid class name */
        /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
        @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {210, 281}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$vdBlacklistAppOpen$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f31140a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f31141b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.session.a f31142c;

            AnonymousClass1(String r3, com.obric.autogui.session.a r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31141b = r3;
                this.f31142c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f31141b, this.f31142c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r17) {
                Object r1 = d.c.a.b.a();
                int r2 = this.f31140a;
                boolean r4 = true;
                if (r2 == 0) goto L10;
                if (r2 == 1) goto L9;
                if (r2 != 2) goto L8;
                d.o.a(r17);
            L57:
                return x.f38692a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                d.o.a(r17);
                Object r3 = r17;
            L13:
                AppBlackListState r8 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r3, AppBlackListState.class, "com.obric.aiagent.plugin");
                Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD][BlackListOpen] intercepted: pkg=" + this.f31141b + ", state=" + r8);
                if (r8 != AppBlackListState.HardBlackList) goto L24;
                AppInfoEntry r5 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f31141b);
                if (r5 == null) goto L20;
                CharSequence r6 = r5.getAppLabel();
                if (r6 == null) goto L20;
            L21:
                IAutoActionAgentApi r7 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
                String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_agent_cannot_continue_operating_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_agent_cannot_continue_operating_app"), new Object[]{r6});
                d.h.b.o.c(r9, "getString(...)");
                IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default(r7, null, r9, 106001, null, null, 24, null);
                return x.f38692a;
            L20:
                r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f31141b, CharSequence.class, "com.obric.aiagent.plugin");
                goto L21
            L24:
                if (r8 != AppBlackListState.UserDefinedBlackList) goto L26;
            L33:
                com.obric.autogui.session.functions.c r10 = this.f31142c.n();
                if (r10.a(com.obric.autogui.session.functions.impl.a.a.class) != null) goto L40;
                if (r10.a(com.obric.autogui.session.functions.impl.b.class) != null) goto L40;
                r4 = false;
            L40:
                if (r4 == true) goto L42;
            L45:
                this.f31142c.F().remove("op_openapp_pending_auth");
                com.obric.autogui.session.a r11 = com.obric.autogui.session.c.f30777a.b();
                if (r11 != null) goto L49;
                Loog.INSTANCE.e(VDEventsListenerImpl.TAG, " - [VD] no session; blacklist app open ignored");
                return x.f38692a;
            L49:
                int r12 = r11.N().get();
                Loog r13 = Loog.INSTANCE;
                StringBuilder r14 = new StringBuilder().append("[ShortcutBLTrace] create blacklist event: source=vdBlacklistAppOpen, eventPackage=").append(this.f31141b).append(", eventLoop=").append(r12).append(", currentStepId=");
                com.obric.autogui.operator.e r15 = r11.r();
                if (r15 == null) goto L52;
                String r16 = r15.W();
            L53:
                r13.i(VDEventsListenerImpl.TAG, r14.append(r16).append(", shortcutContext=").append(r11.F().get("op_openapp_shortcut_open_context")).toString());
                AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(new ComponentName(this.f31141b, "BlackListOpen"), r8, r12, 0, false, 24, null));
                Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD][BlackListOpen] BL event triggered; relaunch");
                com.obric.autogui.session.c.f30777a.b(r11);
                com.obric.autogui.session.functions.c r18 = r11.n();
                d.c.d<? super x> r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31140a = 2;
                if (r18.a(r19) != r1) goto L57;
                return r1;
            L52:
                r16 = null;
                goto L53
            L42:
                if (r8 != AppBlackListState.UserDefinedBlackList) goto L45;
                AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(new ComponentName(this.f31141b, "BlackListOpen"), r8, 0, 0, false, 28, null));
                Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD][BlackListOpen] manual stage; defer auth");
                return x.f38692a;
            L26:
                if (r8 == AppBlackListState.SoftBlackList) goto L33;
                if (r8 == AppBlackListState.SAEPBlackList) goto L33;
                if (r8 == AppBlackListState.Virus) goto L33;
                return x.f38692a;
            L10:
                d.o.a(r17);
                com.obric.autogui.agents.vlm.models.impl.applist.black.g r20 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
                Context r21 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
                String r22 = this.f31141b;
                d.c.d<? super AppBlackListState> r23 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31140a = 1;
                r3 = r20.a(r21, r22, r23);
                if (r3 != r1) goto L13;
                return r1;
            }
        }

        m(String r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31138b = r3;
            super(2, r5);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            m r0 = new m(this.f31138b, r5);
            r0.f31139c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f31137a != 0) goto L17;
            d.o.a(r5);
            com.obric.autogui.session.a r6 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31139c, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            String r4 = this.f31138b;
            if (r4 == null) goto L7;
            String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L8:
            if (r7 != null) goto L11;
            r7 = "";
        L11:
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - [VD] blacklist app open but pkg empty");
            return x.f38692a;
        L14:
            AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L7:
            r7 = null;
            goto L8
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$vdStartActivityIntercepted$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentName f31144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f31145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f31146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f31147e;

        /* JADX INFO: renamed from: com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$n$1, reason: invalid class name */
        /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
        @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {137, 194}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$vdStartActivityIntercepted$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f31148a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ComponentName f31149b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f31150c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f31151d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.session.a f31152e;

            AnonymousClass1(ComponentName r3, int r4, int r5, com.obric.autogui.session.a r6, d.c.d<? super AnonymousClass1> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31149b = r3;
                this.f31150c = r4;
                this.f31151d = r5;
                this.f31152e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f31149b, this.f31150c, this.f31151d, this.f31152e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r15) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f31148a;
                boolean r3 = true;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                d.o.a(r15);
            L46:
                return x.f38692a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                d.o.a(r15);
            L13:
                AppBlackListState r7 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r15, AppBlackListState.class, "com.obric.aiagent.plugin");
                Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD][StartActivity] intercepted: taskId=" + this.f31150c + ", err=" + this.f31151d + ", state=" + r7 + ", act=" + this.f31149b);
                if (r7 != AppBlackListState.UserDefinedBlackList) goto L16;
            L23:
                com.obric.autogui.session.functions.c r16 = this.f31152e.n();
                if (r16.a(com.obric.autogui.session.functions.impl.a.a.class) == null) goto L26;
            L29:
                if (r3 == true) goto L31;
            L34:
                this.f31152e.F().remove("op_openapp_pending_auth");
                com.obric.autogui.session.a r17 = com.obric.autogui.session.c.f30777a.b();
                if (r17 != null) goto L38;
                Loog.INSTANCE.e(VDEventsListenerImpl.TAG, " - [VD] no session; startActivity intercept ignored");
                return x.f38692a;
            L38:
                int r8 = r17.N().get();
                Loog r2 = Loog.INSTANCE;
                StringBuilder r4 = new StringBuilder().append("[ShortcutBLTrace] create blacklist event: source=vdStartActivityIntercepted, eventPackage=").append(this.f31149b.getPackageName()).append(", eventLoop=").append(r8).append(", currentStepId=");
                com.obric.autogui.operator.e r5 = r17.r();
                if (r5 == null) goto L41;
                String r6 = r5.W();
            L42:
                r2.i(VDEventsListenerImpl.TAG, r4.append(r6).append(", shortcutContext=").append(r17.F().get("op_openapp_shortcut_open_context")).toString());
                AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(this.f31149b, r7, r8, 0, false, 24, null));
                Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD][StartActivity] BL event triggered; relaunch");
                com.obric.autogui.session.c.f30777a.b(r17);
                com.obric.autogui.session.functions.c r18 = r17.n();
                d.c.d<? super x> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31148a = 2;
                if (r18.a(r9) != r0) goto L46;
                return r0;
            L41:
                r6 = null;
                goto L42
            L31:
                if (r7 != AppBlackListState.UserDefinedBlackList) goto L34;
                AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(this.f31149b, r7, 0, 0, false, 28, null));
                Loog.INSTANCE.i(VDEventsListenerImpl.TAG, " - [VD][StartActivity] manual stage; defer auth");
                return x.f38692a;
            L26:
                if (r16.a(com.obric.autogui.session.functions.impl.b.class) != null) goto L29;
                r3 = false;
                goto L29
            L16:
                if (r7 == AppBlackListState.SoftBlackList) goto L23;
                if (r7 == AppBlackListState.SAEPBlackList) goto L23;
                if (r7 == AppBlackListState.Virus) goto L23;
                return x.f38692a;
            L10:
                d.o.a(r15);
                String r19 = this.f31149b.getPackageName();
                d.h.b.o.c(r19, "getPackageName(...)");
                com.obric.autogui.agents.vlm.models.impl.applist.black.g r10 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
                Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
                d.c.d<? super AppBlackListState> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31148a = 1;
                r15 = r10.a(r11, r19, r12);
                if (r15 != r0) goto L13;
                return r0;
            }
        }

        n(ComponentName r3, int r4, int r5, d.c.d<? super n> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31144b = r3;
            this.f31145c = r4;
            this.f31146d = r5;
            super(2, r7);
        }

        public final Object a(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            n r0 = new n(this.f31144b, this.f31145c, this.f31146d, r7);
            r0.f31147e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f31143a != 0) goto L14;
            d.o.a(r9);
            com.obric.autogui.session.a r6 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f31147e, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            ComponentName r3 = this.f31144b;
            if (r3 == null) goto L11;
            String r10 = r3.getPackageName();
            d.h.b.o.c(r10, "getPackageName(...)");
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L11;
            AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, this.f31145c, this.f31146d, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L11:
            Loog.INSTANCE.w(VDEventsListenerImpl.TAG, " - [VD] startActivity intercepted but no activity; taskId=" + this.f31145c + ", err=" + this.f31146d);
            return x.f38692a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VDEventsListenerImpl.kt */
    @d.c.b.a.f(b = "VDEventsListenerImpl.kt", c = {952}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl$withOngoingSession$1")
    static final class o extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> f31154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f31155c;

        o(d.h.a.m<? super com.obric.autogui.session.a, ? super d.c.d<? super x>, ? extends Object> r3, com.obric.autogui.session.a r4, d.c.d<? super o> r5) {
            d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31154b = r6;
            this.f31155c = r4;
            super(1, r7);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((o) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f31154b, this.f31155c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31153a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r4);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r4);
            d.h.a.m<com.obric.autogui.session.a, d.c.d<? super x>, Object> r5 = this.f31154b;
            com.obric.autogui.session.a r2 = this.f31155c;
            this.f31153a = 1;
            if (r5.invoke(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public VDEventsListenerImpl() {
    }

    public static final /* synthetic */ void access$addAppRemovedPrompt(VDEventsListenerImpl r0, com.obric.autogui.session.a r1, AppInfoEntry r2) {
        r0.addAppRemovedPrompt(r1, r2);
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.OperatingAppInfo access$fetchAppInfo(VDEventsListenerImpl r0, VDTrackingApp r1) {
        return r0.fetchAppInfo(r1);
    }

    public static final /* synthetic */ VDTrackingApp access$getTrackingApp(VDEventsListenerImpl r0, com.obric.autogui.session.a r1) {
        return r0.getTrackingApp(r1);
    }

    public static final /* synthetic */ void access$reportAssistantOperateApps(VDEventsListenerImpl r0, String r1) {
        r0.reportAssistantOperateApps(r1);
    }

    public static final /* synthetic */ Object access$resumeForTaskModification(VDEventsListenerImpl r2, com.obric.autogui.session.a r3, boolean r4, d.c.d r5) {
        return r2.resumeForTaskModification(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$resumePendingOpenApp(VDEventsListenerImpl r2, com.obric.autogui.session.a r3, String r4, int r5, d.c.d r6) {
        return r2.resumePendingOpenApp(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$setTrackingApp(VDEventsListenerImpl r0, com.obric.autogui.session.a r1, VDTrackingApp r2) {
        return r0.setTrackingApp(r1, r2);
    }

    public static final /* synthetic */ Object access$takeBlackListActionsLocked(VDEventsListenerImpl r2, ComponentName r3, d.c.d r4) {
        return r2.takeBlackListActionsLocked(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final boolean shallTrack(VDTrackingApp r3) {
        String r4 = r3.getPackageName();
        if (r4 == null) goto L8;
        if (shallTrackPackage(r4) != true) goto L8;
        return true;
    L8:
        return false;
    }

    private final boolean shallTrackPackage(String r7) {
        String r6 = AOHostAppTools.INSTANCE.getHostAppPackage();
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.ProdOperateHostApp) == true) goto L13;
        if (r7 != null) goto L6;
    L8:
        boolean r8 = false;
    L9:
        if (r8 == false) goto L13;
        Loog.INSTANCE.d(TAG, " - [VD] [" + r7 + "] ignored (current-app)");
        return false;
    L6:
        if (r7.contentEquals((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) != true) goto L8;
        r8 = true;
    L13:
        if (IAutoActionVDApi.Companion.isWaivedTrackingPackage(r7) == false) goto L16;
        Loog.INSTANCE.d(TAG, " - [VD] [" + r7 + "] ignored (not-tracking)");
        return false;
    L16:
        return true;
    }

    private final VDTrackingApp getTrackingApp(com.obric.autogui.session.a r3) {
        Object r2 = r3.F().get(KEY_EXTRA_TRACKING_APP);
        if (ZeusTransformUtils.instanceOf(r2, VDTrackingApp.class) == false) goto L5;
        VDTrackingApp r4 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(r2, VDTrackingApp.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public String getTrackingAppPkgName() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(TAG, " - [VD] no ongoing session; VD events are ignored.");
        return "";
    L6:
        VDTrackingApp r3 = getTrackingApp(r0);
        if (r3 == null) goto L9;
        String r4 = r3.getPackageName();
    L10:
        if (r4 != null) goto L13;
        return "";
    L13:
        return r4;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public String captureOperationOwnerToken() {
        com.obric.autogui.session.a r3 = com.obric.autogui.session.c.f30777a.b();
        if (r3 != null) goto L5;
        return null;
    L5:
        AOOperatingSpace r1 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        String r2 = r3.a();
        if (r3.b(r1) == true) goto L8;
        return null;
    L8:
        return r2;
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public boolean canMoveTrackingAppToVdOnScreenOff() {
        com.obric.autogui.session.a r3 = com.obric.autogui.session.c.f30777a.b();
        if (r3 != null) goto L5;
        return false;
    L5:
        com.obric.autogui.session.state.b.c r1 = r3.m().d();
        if (r1.d() == false) goto L8;
        return false;
    L8:
        if (r3.J().e() == false) goto L10;
        return false;
    L10:
        if (r1.a(BizStatus.OPERATING) == false) goto L12;
    L13:
        return true;
    L12:
        if (r1.a(BizStatus.USER_INTERRUPTED) == true) goto L13;
        return false;
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void vdStartActivityIntercepted(int r3, int r4, ComponentName r5) {
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r5, r3, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void vdBlacklistAppOpen(String r3) {
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final boolean setTrackingApp(com.obric.autogui.session.a r4, VDTrackingApp r5) {
        VDTrackingApp r0 = null;
        if (r5 != null) goto L5;
    L7:
        Object r3 = r4.F().get(KEY_EXTRA_TRACKING_APP);
        if (ZeusTransformUtils.instanceOf(r3, VDTrackingApp.class) == false) goto L11;
        r0 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(r3, VDTrackingApp.class, "com.obric.aiagent.plugin");
    L11:
        if (r5 != null) goto L14;
        if (r0 != null) goto L14;
        return false;
    L14:
        if (r5 == null) goto L20;
        if (r0 == null) goto L20;
        if (r5.isSameAs(r0) == false) goto L20;
        return false;
    L20:
        if (r5 != null) goto L23;
        r4.F().remove(KEY_EXTRA_TRACKING_APP);
        r4.F().remove(KEY_EXTRA_TRACKING_APP_INFO);
        return true;
    L23:
        r4.F().put(KEY_EXTRA_TRACKING_APP, r5);
        return true;
    L5:
        if (shallTrack(r5) == true) goto L7;
        r5 = null;
        goto L7
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void vdOperatingAppChanged(VDTrackingApp r2) {
        handleOperatingAppChanged(r2, null);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void vdOperatingAppChanged(VDTrackingApp r1, String r2) {
        handleOperatingAppChanged(r1, r2);
    }

    private final void handleOperatingAppChanged(VDTrackingApp r7, String r8) {
        if (r8 != null) goto L22;
    L20:
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
        VDEventsListenerImpl r3 = (VDEventsListenerImpl) ZeusTransformUtils.preCheckCast(this, VDEventsListenerImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        com.obric.autogui.b.a r4 = com.obric.autogui.b.a.f28928a;     // Catch: Throwable -> L15
        if (r7 != null) goto L7;
    L12:
        String r5 = null;
    L13:
        r4.a(r8, r5);     // Catch: Throwable -> L15
        Object r6 = d.n.f(x.f38692a);     // Catch: Throwable -> L15
    L17:
        Throwable r9 = d.n.c(r6);
        if (r9 == null) goto L20;
        Loog.INSTANCE.e(TAG, " - [VD] operation notification failed, owner=" + r8, r9);
        goto L20
    L7:
        if (r3.shallTrack(r7) == false) goto L9;
        VDTrackingApp r10 = r7;
    L10:
        if (r10 == null) goto L12;
        r5 = r10.getPackageName();     // Catch: Throwable -> L15
        goto L13
    L9:
        r10 = null;
    L15:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L17
    }

    private final IAutoActionAgentEventListener.OperatingAppInfo fetchAppInfo(VDTrackingApp r10) {
        String r1 = r10.getPackageName();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        Loog.INSTANCE.w(TAG, "App changed --> empty pkgName = " + r1);
        return null;
    L13:
        AppInfoEntry r4 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1);
        if (r4 != null) goto L17;
        Loog.INSTANCE.w(TAG, "App changed --> not-found pkgName = " + r1);
        return null;
    L17:
        CharSequence r5 = r4.getAppLabel();
        if (r5 != null) goto L21;
        Loog.INSTANCE.w(TAG, "App changed --> not-found appLabel = " + r1);
        r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
    L21:
        if (d.h.b.o.a(r1, "com.obric.appletapp") == false) goto L30;
        String r9 = fetchTaskLabelFromRecents(r10.getTaskId());
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L25;
    L26:
        r3 = true;
    L27:
        if (r3 == true) goto L29;
        Loog.INSTANCE.i(TAG, " - [VD][AppLabel] override for appletapp: taskId=" + r10.getTaskId() + ", from=" + r5 + ", to=" + r9);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
    L32:
        return new IAutoActionAgentEventListener.OperatingAppInfo(r1, null, r7, r10.getTaskId(), false, 16, null);
    L29:
        Loog.INSTANCE.i(TAG, " - [VD][AppLabel] appletapp override skipped: taskId=" + r10.getTaskId() + ", pkg=" + r1 + " (no taskLabel)");
        goto L30
    L25:
        if (d.o.o.d(r6) == false) goto L27;
    L30:
        r7 = r5;
        goto L32
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    private final String fetchTaskLabelFromRecents(int r9) {
        if (r9 > 0) goto L6;
        Loog.INSTANCE.d(TAG, " - [VD][TaskLabel] ignored invalid taskId=" + r9);
        return null;
    L6:
        Loog.INSTANCE.d(TAG, " - [VD][TaskLabel] resolving from recents: taskId=" + r9);
        DisplayedAppInfo r1 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        boolean r2 = true;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L28;
        CharSequence r3 = r1.getTaskLabel();
        if (r3 == null) goto L17;
        String r5 = r3.toString();
    L18:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L28;
        Loog.INSTANCE.d(TAG, " - [VD][TaskLabel] hit vdTop: taskId=" + r9 + ", label=" + r5);
        return r5;
    L21:
        if (d.o.o.d(r6) == true) goto L24;
        r7 = false;
        goto L25
    L17:
        r5 = null;
    L28:
        Collection r8 = IAutoActionVDApi.DefaultImpls.fetchMdTopAppInfo$default((IAutoActionVDApi) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE, IAutoActionVDApi.class, "com.obric.aiagent.plugin"), 10, false, 2, null);
        if (r8 != null) goto L31;
    L34:
        boolean r10 = true;
    L35:
        if (r10 == false) goto L38;
        Loog.INSTANCE.d(TAG, " - [VD][TaskLabel] md recents empty: taskId=" + r9);
        return null;
    L38:
        if (r8 == null) goto L50;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L41:
        if (r11.hasNext() == false) goto L48;
        Object r12 = r11.next();
        if (((DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r12, DisplayedAppInfo.class, "com.obric.aiagent.plugin")).getTaskId() != r9) goto L45;
        boolean r13 = true;
    L46:
        if (r13 == false) goto L41;
    L49:
        DisplayedAppInfo r14 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r12, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
    L51:
        if (r14 == null) goto L55;
        CharSequence r15 = r14.getTaskLabel();
        if (r15 == null) goto L55;
        String r16 = r15.toString();
    L56:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L59;
    L62:
        if (r2 == true) goto L65;
        Loog.INSTANCE.d(TAG, " - [VD][TaskLabel] hit mdRecents: taskId=" + r9 + ", label=" + r16);
        return r16;
    L65:
        Loog.INSTANCE.d(TAG, " - [VD][TaskLabel] not found: taskId=" + r9);
        return null;
    L59:
        if (d.o.o.d(r17) == true) goto L62;
        r2 = false;
    L55:
        r16 = null;
        goto L56
    L45:
        r13 = false;
        goto L46
    L48:
        r12 = null;
        goto L49
    L50:
        r14 = null;
        goto L51
    L31:
        if (r8.isEmpty() == true) goto L34;
        r10 = false;
        goto L35
    L9:
        if (r1.getTaskId() != r9) goto L11;
        r4 = true;
        goto L13
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void taskClosed(int r3, boolean r4) {
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r4, r3, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void trackingAppTerminated(VDTrackingApp r4) {
        d.h.b.o.e(r4, "trackingApp");
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, r4, AutoActionConfigs.INSTANCE.getBooleanCfg("vd.task_remove_term", false), null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final void addAppRemovedPrompt(com.obric.autogui.session.a r5, AppInfoEntry r6) {
        Object r4 = r5.a(com.obric.autogui.agents.b.f26789a.a());
        CharSequence r1 = null;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L5;
        com.obric.autogui.agents.vlm.b.C0677b r7 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
    L6:
        if (r7 == null) goto L18;
        com.obric.autogui.agents.vlm.b.C0677b.a r8 = r7.o();
        if (r8 == null) goto L19;
        com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b r0 = com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27123c;
        if (r6 == null) goto L13;
        r1 = r6.getAppLabel();
    L13:
        if (r1 != null) goto L15;
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.espe_resumed_as_app_removed_wo_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_resumed_as_app_removed_wo_app"));
    L16:
        d.h.b.o.a(r9);
        r8.a(r0, r9);
        return;
    L15:
        r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.espe_resumed_as_app_removed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_resumed_as_app_removed"), new Object[]{r6.getAppLabel()});
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void trackingAppMovedToMd(VDTrackingApp r3) {
        d.h.b.o.e(r3, "trackingApp");
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r3, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void trackingAppMovedToVd(VDTrackingApp r3) {
        d.h.b.o.e(r3, "app");
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r3, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final Object resumeForTaskModification(com.obric.autogui.session.a r16, boolean r17, d.c.d<? super x> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L7;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin");
        if ((r2.f31111e & Integer.MIN_VALUE) == 0) goto L7;
        r2.f31111e -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f31109c;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f31111e;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        boolean r5 = r2.f31108b;
        com.obric.autogui.session.a r6 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r2.f31107a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
    L20:
        Object r7 = r6.F().get(KEY_EXTRA_TRACKING_APP_INFO);
        if (ZeusTransformUtils.instanceOf(r7, IAutoActionAgentEventListener.OperatingAppInfo.class) == false) goto L23;
        IAutoActionAgentEventListener.OperatingAppInfo r8 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r7, IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
    L24:
        if (r8 == null) goto L29;
        if (r5 == false) goto L27;
        com.obric.autogui.b.a.f28928a.onOperatingAppChanged(r6.d(), r8);
        goto L29
    L27:
        Loog.INSTANCE.i(TAG, " --> [OpState] Resuming because of the App being nullified.");
        r6.F().remove(KEY_EXTRA_TRACKING_APP_INFO);
    L29:
        return x.f38692a;
    L23:
        r8 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        com.obric.autogui.session.state.b.c r9 = r16.m().d();
        Loog.INSTANCE.i(TAG, " --> [OpState] " + r9.e());
        if (r9.a(BizStatus.USER_INTERRUPTED) == false) goto L29;
        com.obric.autogui.session.state.b r10 = r16.m();
        BizStatus r11 = BizStatus.OPERATING;
        BizStatus.StatusChangedReasonStruct r14 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f.a(), null, null, null, 14, null);
        r2.f31107a = r16;
        r2.f31108b = r17;
        r2.f31111e = 1;
        if (r10.a(r11, r14, r2) != r3) goto L19;
        return r3;
    L19:
        r6 = r16;
        r5 = r17;
    L7:
        r2 = new f(this, r0);
        goto L8
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void appMovedToMdBackground(String r5) {
        d.h.b.o.e(r5, "appPackage");
        Loog.INSTANCE.i(TAG, "App moved: [MAIN] --> [MAIN BG] (" + r5 + ')');
        if (shallTrackPackage(r5) == true) goto L6;
        Loog.INSTANCE.d(TAG, " - ignored app moved: [MAIN] --> [MAIN BG] (" + r5 + ')');
        return;
    L6:
        withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Object resumePendingOpenApp$default(VDEventsListenerImpl r1, com.obric.autogui.session.a r2, String r3, int r4, d.c.d r5, int r6, Object r7) {
        d.c.d<? super x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r4 = 0;
    L6:
        return r1.resumePendingOpenApp(r2, r3, r4, r8);
    }

    private final Object resumePendingOpenApp(com.obric.autogui.session.a r8, String r9, int r10, d.c.d<? super x> r11) {
        d.c.d<? super com.obric.autogui.common.e> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        Object r0 = r8.F().get("op_openapp_pending_open");
        if (ZeusTransformUtils.instanceOf(r0, VDTrackingApp.class) == false) goto L5;
        VDTrackingApp r1 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(r0, VDTrackingApp.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        boolean r2 = false;
        if (r10 != 0) goto L12;
    L14:
        boolean r13 = false;
    L15:
        if (r9 != null) goto L17;
    L19:
        if (r13 == false) goto L21;
        r8.F().remove("op_openapp_pending_open");
        VDTrackingApp r7 = getTrackingApp(r8);
        if (r7 == null) goto L30;
        if (r7.getTaskId() != r1.getTaskId()) goto L27;
    L28:
        r2 = true;
        goto L30
    L27:
        if (d.h.b.o.a(r7.getPackageName(), r1.getPackageName()) == true) goto L28;
    L30:
        if (r2 == false) goto L32;
    L34:
        com.obric.autogui.session.state.b.c r14 = r8.m().d();
        Loog.INSTANCE.i(TAG, "OccupyTakeOverTrace - [PendingOpenApp] resume pending OpenApp, target=" + r1 + ", " + r14.e());
        if (r14.a(BizStatus.USER_INTERRUPTED) == false) goto L42;
        Object r15 = r8.m().a(BizStatus.OPERATING, new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f.a(), null, null, null, 14, null), r12);
        if (r15 != d.c.a.b.a()) goto L40;
        return r15;
    L40:
        return x.f38692a;
    L42:
        return x.f38692a;
    L32:
        if (r1.getTaskId() <= 0) goto L34;
        Loog.INSTANCE.i(TAG, " - [PendingOpenApp] bringing MD app to VD before resuming: " + r1 + ", currentTracking=" + r7);
        Loog.INSTANCE.i(TAG, " - [PendingOpenApp] bringMdAppToVd result: " + AutoActionVirtualDisplay.INSTANCE.bringMdAppToVd(r1.getTaskId()));
        goto L34
    L21:
        return x.f38692a;
    L17:
        if (d.h.b.o.a(r9, r1.getPackageName()) == false) goto L19;
        r13 = true;
        goto L19
    L12:
        if (r1.getTaskId() != r10) goto L14;
        r13 = true;
        goto L15
    L8:
        return x.f38692a;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener
    public void vdTaskIdChanged(int r2) {
        DisplayedAppInfo r3 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r3 != null) goto L6;
        Loog.INSTANCE.i(TAG, " - [VD] no top app in vd; vdTaskIdChanged is ignored.");
        return;
    L6:
        launchBlackListActions(r3);
        ComponentName r4 = r3.getTopActivity();
        if (r4 == null) goto L10;
        String r5 = r4.getPackageName();
        if (r5 == null) goto L10;
    L11:
        maybeSwitchBrowserToTablet(r5);
        return;
    L10:
        r5 = "";
        goto L11
    }

    private final void launchBlackListActions(DisplayedAppInfo r6) {
        DisplayedAppInfo r7 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r6, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [VD-BlackList] taskIdChanged & topApp=" + r7);
        AppBlackListEvent r0 = AppBlackListEventHolder.INSTANCE.getBlackListEvent();
        if (r0 != null) goto L5;
    L8:
        ComponentName r1 = r7.getTopActivity();
        if (r1 != null) goto L11;
        r1 = r7.getRealActivity();
    L11:
        if (r1 != null) goto L14;
        Loog.INSTANCE.e(TAG, " - [VD-BlackList] candidateComponentToCheck is null.");
        AppBlackListEventHolder.INSTANCE.clearBlackListEvent();
        return;
    L14:
        AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r0.isAcknowledged() == true) goto L8;
        Loog.INSTANCE.d(TAG, " - [VD-BlackList] taskIdChanged & topApp=" + r7 + "event still valid (" + r0.getBlackListState() + ')');
        AppBlackListEventHolder.INSTANCE.clearBlackListEvent();
    }

    private final void maybeSwitchBrowserToTablet(String r13) {
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("operator.openapp.browser_switch_tablet.enable", true) == true) goto L7;
        Loog.INSTANCE.d(TAG, "openApp maybeSwitchBrowserToTablet: disabled by config");
        return;
    L7:
        if (d.h.b.o.a(r13, "com.obric.browser") == true) goto L22;
        return;
    L22:
        int r1 = AutoActionConfigs.INSTANCE.getIntCfg("operator.openapp.browser_switch_tablet.base_width", -1);     // Catch: Throwable -> L19
        Bundle r7 = new Bundle();     // Catch: Throwable -> L19
        if (r1 <= 0) goto L12;
        r7.putInt("baseWidth", r1);     // Catch: Throwable -> L19
    L12:
        Bundle r14 = ZeusProviderTransform.call(r12.getContentResolver(), Uri.parse("content://com.obric.browser.webcapability"), "switch_tablet", null, r7, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r14 == null) goto L16;
        Boolean r15 = Boolean.valueOf(r14.getBoolean("success"));     // Catch: Throwable -> L19
    L17:
        Loog.INSTANCE.d(TAG, "vdTaskIdChanged maybeSwitchBrowserToTablet, success=" + r15);     // Catch: Throwable -> L19
        IAutoActionTrackingApi r4 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L19
        r6.put("package_name", r13);     // Catch: Throwable -> L19
        r6.put("success", r15);     // Catch: Throwable -> L19
        r6.put("base_width", r1);     // Catch: Throwable -> L19
        x r16 = x.f38692a;     // Catch: Throwable -> L19
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r4, "open_browser_switch_tablet", r6, false, false, null, 28, null);     // Catch: Throwable -> L19
        return;
    L16:
        r15 = null;
    L19:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "openApp maybeSwitchBrowserToTablet failed: " + th);
    }

    private final Object takeBlackListActionsLocked(ComponentName r17, d.c.d<? super x> r18) {
        VDEventsListenerImpl r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L7;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f31115d;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f;
        boolean r6 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r7 = r3.f31114c;
        ComponentName r8 = (ComponentName) ZeusTransformUtils.preCheckCast(r3.f31113b, ComponentName.class, "com.obric.aiagent.plugin");
        VDEventsListenerImpl r9 = (VDEventsListenerImpl) ZeusTransformUtils.preCheckCast(r3.f31112a, VDEventsListenerImpl.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        ComponentName r10 = r8;
        r0 = r9;
    L24:
        AppBlackListState r11 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r2, AppBlackListState.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [VD-BlackList] Examined (" + (AOSystemTools.INSTANCE.nowTimeMillis() - r7) + "ms); state=" + r11 + "; comp=" + r10);
        if (r11 != AppBlackListState.SoftBlackList) goto L27;
    L34:
        com.obric.autogui.session.a r12 = com.obric.autogui.session.c.f30777a.b();
        if (r12 != null) goto L37;
    L47:
        com.obric.autogui.session.a r13 = com.obric.autogui.session.c.f30777a.b();
        if (r13 != null) goto L51;
        Loog.INSTANCE.e(TAG, " - [VD] no session; VD-BlackList ignored");
        return x.f38692a;
    L51:
        int r14 = r13.N().get();
        Loog r15 = Loog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("[ShortcutBLTrace] create blacklist event: source=takeBlackListActionsLocked, eventPackage=").append(r10.getPackageName()).append(", eventLoop=").append(r14).append(", currentStepId=");
        com.obric.autogui.operator.e r19 = r13.r();
        if (r19 == null) goto L54;
        String r20 = r19.W();
    L55:
        r15.i(TAG, r16.append(r20).append(", shortcutContext=").append(r13.F().get("op_openapp_shortcut_open_context")).toString());
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(r10, r11, r14, 0, false, 24, null));
        r0.withOngoingSession((d.h.a.m) ZeusTransformUtils.preCheckCast(new h(null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    L57:
        return x.f38692a;
    L54:
        r20 = null;
        goto L55
    L37:
        if (r11 != AppBlackListState.UserDefinedBlackList) goto L47;
        com.obric.autogui.session.functions.c r21 = r12.n();
        if (r21.a(com.obric.autogui.session.functions.impl.a.a.class) == null) goto L41;
    L44:
        if (r6 == false) goto L47;
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(r10, r11, 0, 0, false, 28, null));
        Loog.INSTANCE.i(TAG, " - [VD-BlackList] manual stage; defer auth");
        return x.f38692a;
    L41:
        if (r21.a(com.obric.autogui.session.functions.impl.b.class) != null) goto L44;
        r6 = false;
        goto L44
    L27:
        if (r11 == AppBlackListState.SAEPBlackList) goto L34;
        if (r11 == AppBlackListState.UserDefinedBlackList) goto L34;
        if (r11 == AppBlackListState.Virus) goto L34;
        Loog.INSTANCE.w(TAG, "VD-BlackList handled: " + r11 + "; no actions");
        goto L57
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        AppBlackListEvent r22 = AppBlackListEventHolder.INSTANCE.getBlackListEvent();
        if (r22 != null) goto L17;
    L20:
        long r23 = AOSystemTools.INSTANCE.nowTimeMillis();
        com.obric.autogui.agents.vlm.models.impl.applist.black.g r24 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
        Context r25 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r110 = r17.getPackageName();
        d.h.b.o.c(r110, "getPackageName(...)");
        r3.f31112a = r0;
        r3.f31113b = r17;
        r3.f31114c = r23;
        r3.f = 1;
        r2 = r24.a(r25, r110, r3);
        if (r2 != r4) goto L23;
        return r4;
    L23:
        r7 = r23;
        r10 = r17;
        goto L24
    L17:
        if (r22.isAcknowledged() == true) goto L20;
        Loog.INSTANCE.w(TAG, " - [VD-BlackList] Double-checked BlackListEvent! --> " + r22);
        return x.f38692a;
    L7:
        r3 = new g(r0, r1);
        goto L8
    }

    private final void withOngoingSession(d.h.a.m<? super com.obric.autogui.session.a, ? super d.c.d<? super x>, ? extends Object> r5) {
        d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r6 = com.obric.autogui.session.c.f30777a.b();
        if (r6 != null) goto L6;
        Loog.INSTANCE.e(TAG, " - [VD] no session; VD events ignored");
        return;
    L6:
        r6.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new o(r4, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void reportAssistantOperateApps(String r4) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        return;
    L11:
        AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (d.o.o.d(r3) == true) goto L8;
        r5 = false;
        goto L9
    }
}
