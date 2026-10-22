package com.obric.autogui.session.state.a;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.w;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.TaskPreservingDisplayAccessor;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.cc.CCSpace;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: StateTerminate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends com.obric.autogui.session.state.a {
    private static final String TAG = "S-Term";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31322b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Uri f31323d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f31324c;

    /* JADX INFO: compiled from: StateTerminate.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StateTerminate.kt */
    @d.c.b.a.f(b = "StateTerminate.kt", c = {106, 108}, d = "beforeEnter", e = "com.obric.autogui.session.state.impl.StateTerminate")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f31327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31328d;

        b(l r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31327c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31326b = r3;
            this.f31328d |= Integer.MIN_VALUE;
            return this.f31327c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StateTerminate.kt */
    @d.c.b.a.f(b = "StateTerminate.kt", c = {216}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StateTerminate$onEnter$2")
    static final class c extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f31330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f31331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f31332d;

        c(CharSequence r3, l r4, boolean r5, d.c.d<? super c> r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31330b = r7;
            this.f31331c = r4;
            this.f31332d = r5;
            super(1, r8);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f31330b, this.f31331c, this.f31332d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31329a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L13:
            l.a(this.f31331c, this.f31332d);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            CharSequence r6 = this.f31330b;
            if (r6 == null) goto L13;
            l r2 = this.f31331c;
            int r3 = r2.a();
            this.f31329a = 1;
            if (l.a(r2, r6, r3, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StateTerminate.kt */
    @d.c.b.a.f(b = "StateTerminate.kt", c = {241, 244, 241, 244, 241, 244}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StateTerminate$onEnter$3")
    static final class d extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f31333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f31334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l f31337e;
        final /* synthetic */ long f;

        d(l r3, long r4, d.c.d<? super d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31337e = r3;
            this.f = r4;
            super(1, r7);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f31337e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r31) {
            Object r5 = d.c.a.b.a();
            switch(this.f31336d) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            long r2 = this.f31334b;
            long r4 = this.f31333a;
            th = (Throwable) ZeusTransformUtils.preCheckCast(this.f31335c, Throwable.class, "com.obric.aiagent.plugin");
            d.o.a(r31);
            String r17 = "terminate cleanup shutdown end, session=";
            String r18 = ", stateThread={";
            String r19 = ", msg=";
            String r20 = ", ok=";
            String r21 = "terminate cleanup idle result, session=";
            String r10 = "com.obric.aiagent.plugin";
            long r7 = r4;
            String r6 = ", costMs=";
            Object r8 = r31;
        L56:
            com.obric.autogui.common.e r9 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.common.e.class, r10);
            Loog.INSTANCE.w(l.TAG, r21 + this.f31337e.d().a() + r20 + r9.g() + r19 + r9.h() + r6 + (AOSystemTools.INSTANCE.bootTimeMillis() - r2) + r18 + this.f31337e.d().m().a().describeState() + '}');
            long r3 = AOSystemTools.INSTANCE.bootTimeMillis();
            this.f31337e.d().Q();
            Loog.INSTANCE.w(l.TAG, r17 + this.f31337e.d().a() + r6 + (AOSystemTools.INSTANCE.bootTimeMillis() - r3) + ", totalMs=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r7));
            throw th;
        L7:
            long r11 = this.f31334b;
            long r12 = this.f31333a;
            th = (Throwable) ZeusTransformUtils.preCheckCast(this.f31335c, Throwable.class, "com.obric.aiagent.plugin");
            d.o.a(r31);
            r19 = ", msg=";
            r20 = ", ok=";
            r21 = "terminate cleanup idle result, session=";
            String r26 = ", voided=";
            r10 = "com.obric.aiagent.plugin";
            String r22 = ", costMs=";
            long r13 = r11;
            r5 = r5;
            r17 = "terminate cleanup shutdown end, session=";
            r18 = ", stateThread={";
            r7 = r12;
            Object r14 = r31;
        L53:
            boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, r10)).booleanValue();
            r6 = r22;
            Loog.INSTANCE.w(l.TAG, new StringBuilder().append("terminate cleanup void result, session=").append(this.f31337e.d().a()).append(r26).append(r15).append(r6).append(AOSystemTools.INSTANCE.bootTimeMillis() - r13).toString());
            r2 = AOSystemTools.INSTANCE.bootTimeMillis();
            com.obric.autogui.session.state.b r16 = this.f31337e.e();
            BizStatus r110 = BizStatus.IDLE;
            BizStatus.StatusChangedReasonStruct r111 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.e.f31230a.a(), null, null, null, 14, null);
            d.c.d<? super com.obric.autogui.common.e> r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, r10);
            this.f31335c = th;
            this.f31333a = r7;
            this.f31334b = r2;
            this.f31336d = 6;
            r8 = r16.a(r110, r111, r112);
            if (r8 != r5) goto L56;
            return r5;
        L8:
            long r23 = this.f31334b;
            long r24 = this.f31333a;
            d.o.a(r31);
            Object r0 = r31;
            r17 = "terminate cleanup shutdown end, session=";
            r18 = ", stateThread={";
            r19 = ", msg=";
            String r25 = ", ok=";
            String r27 = "terminate cleanup idle result, session=";
            String r113 = ", costMs=";
        L41:
            com.obric.autogui.common.e r1 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.w(l.TAG, r27 + this.f31337e.d().a() + r25 + r1.g() + r19 + r1.h() + r113 + (AOSystemTools.INSTANCE.bootTimeMillis() - r23) + r18 + this.f31337e.d().m().a().describeState() + '}');
            long r28 = AOSystemTools.INSTANCE.bootTimeMillis();
            this.f31337e.d().Q();
            Loog r29 = Loog.INSTANCE;
            StringBuilder r30 = new StringBuilder().append(r17).append(this.f31337e.d().a()).append(r113);
        L24:
            r29.w(l.TAG, r30.append(AOSystemTools.INSTANCE.bootTimeMillis() - r28).append(", totalMs=").append(AOSystemTools.INSTANCE.bootTimeMillis() - r24).toString());
            return x.f38692a;
        L9:
            long r32 = this.f31334b;
            long r33 = this.f31333a;
            d.o.a(r31);
            Object r34 = r31;
            r19 = ", msg=";
            r25 = ", ok=";
            r27 = "terminate cleanup idle result, session=";
            String r210 = ", voided=";
            String r211 = ", costMs=";
            r5 = r5;
            r24 = r33;
            long r35 = r32;
            r17 = "terminate cleanup shutdown end, session=";
            r18 = ", stateThread={";
        L38:
            r113 = r211;
            Loog.INSTANCE.w(l.TAG, "terminate cleanup void result, session=" + this.f31337e.d().a() + r210 + ((Boolean) ZeusTransformUtils.preCheckCast(r34, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() + r113 + (AOSystemTools.INSTANCE.bootTimeMillis() - r35));
            r23 = AOSystemTools.INSTANCE.bootTimeMillis();
            com.obric.autogui.session.state.b r36 = this.f31337e.e();
            BizStatus r37 = BizStatus.IDLE;
            BizStatus.StatusChangedReasonStruct r38 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.e.f31230a.a(), null, null, null, 14, null);
            d.c.d<? super com.obric.autogui.common.e> r114 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31333a = r24;
            this.f31334b = r23;
            this.f31336d = 4;
            r0 = r36.a(r37, r38, r114);
            if (r0 != r5) goto L41;
            return r5;
        L10:
            long r39 = this.f31334b;
            r24 = this.f31333a;
            d.o.a(r31);
            Object r40 = r31;
            r17 = "terminate cleanup shutdown end, session=";
            r18 = ", stateThread={";
            r19 = ", msg=";
            r25 = ", ok=";
            String r212 = "terminate cleanup idle result, session=";
        L23:
            com.obric.autogui.common.e r41 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r40, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.w(l.TAG, r212 + this.f31337e.d().a() + r25 + r41.g() + r19 + r41.h() + ", costMs=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r39) + r18 + this.f31337e.d().m().a().describeState() + '}');
            r28 = AOSystemTools.INSTANCE.bootTimeMillis();
            this.f31337e.d().Q();
            r29 = Loog.INSTANCE;
            r30 = new StringBuilder().append(r17).append(this.f31337e.d().a()).append(", costMs=");
            goto L24
        L11:
            long r42 = this.f31334b;
            long r43 = this.f31333a;
            d.o.a(r31);
            Object r44 = r31;
            r19 = ", msg=";
            r25 = ", ok=";
            r212 = "terminate cleanup idle result, session=";
            String r213 = ", voided=";
            Object r45 = r5;
            r24 = r43;
            long r46 = r42;
            r17 = "terminate cleanup shutdown end, session=";
            r18 = ", stateThread={";
        L20:
            Loog.INSTANCE.w(l.TAG, "terminate cleanup void result, session=" + this.f31337e.d().a() + r213 + ((Boolean) ZeusTransformUtils.preCheckCast(r44, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() + ", costMs=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r46));
            r39 = AOSystemTools.INSTANCE.bootTimeMillis();
            com.obric.autogui.session.state.b r47 = this.f31337e.e();
            BizStatus r48 = BizStatus.IDLE;
            BizStatus.StatusChangedReasonStruct r49 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.e.f31230a.a(), null, null, null, 14, null);
            d.c.d<? super com.obric.autogui.common.e> r115 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31333a = r24;
            this.f31334b = r39;
            this.f31336d = 2;
            r40 = r47.a(r48, r49, r115);
            if (r40 != r45) goto L23;
            return r45;
        L12:
            d.o.a(r31);
            r17 = "terminate cleanup shutdown end, session=";
            r18 = ", stateThread={";
            r7 = AOSystemTools.INSTANCE.bootTimeMillis();
            r19 = ", msg=";
            r25 = ", ok=";
            r212 = "terminate cleanup idle result, session=";
            Loog.INSTANCE.w(l.TAG, "terminate cleanup start, session=" + this.f31337e.d().a() + ", waitMs=" + (r7 - this.f) + ", thread=" + Thread.currentThread().getName() + ", worker={" + this.f31337e.d().h().describeState() + '}');
            long r214 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L27
            Loog.INSTANCE.w(l.TAG, "terminate cleanup finalizer begin, session=" + this.f31337e.d().a() + ", step=" + this.f31337e.d().s() + ", trackingStepId=" + this.f31337e.d().v());     // Catch: Throwable -> L27
            com.obric.autogui.session.state.termination.b.a(com.obric.autogui.session.state.termination.b.f31431a.a(this.f31337e.d()), null, 1, null);     // Catch: Throwable -> L27
            r213 = ", voided=";
            Loog.INSTANCE.w(l.TAG, "terminate cleanup finalizer end, session=" + this.f31337e.d().a() + ", costMs=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r214));     // Catch: Throwable -> L25
            long r116 = AOSystemTools.INSTANCE.bootTimeMillis();
            r45 = r5;
            Loog.INSTANCE.w(l.TAG, new StringBuilder().append("terminate cleanup finally begin, session=").append(this.f31337e.d().a()).append(", elapsedMs=").append(r116 - r7).append(", worker={").append(this.f31337e.d().h().describeState()).append("}, stateThread={").append(this.f31337e.d().m().a().describeState()).append('}').toString());
            com.obric.autogui.session.c r50 = com.obric.autogui.session.c.f30777a;
            com.obric.autogui.session.a r51 = this.f31337e.d();
            d.c.d<? super Boolean> r52 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31333a = r7;
            this.f31334b = r116;
            this.f31336d = 1;
            r44 = r50.a(r51, r52);
            if (r44 != r45) goto L19;
            return r45;
        L19:
            r24 = r7;
            r46 = r116;
        L25:
            th = th;
            String r117 = r213;
        L58:
            r27 = r212;
            r211 = ", costMs=";
            Loog.INSTANCE.e(l.TAG, "failed to schedule session finalizer: " + this.f31337e.d().a(), th);     // Catch: Throwable -> L44
            r210 = r117;
            long r118 = AOSystemTools.INSTANCE.bootTimeMillis();
            Loog.INSTANCE.w(l.TAG, "terminate cleanup finally begin, session=" + this.f31337e.d().a() + ", elapsedMs=" + (r118 - r7) + ", worker={" + this.f31337e.d().h().describeState() + "}, stateThread={" + this.f31337e.d().m().a().describeState() + '}');
            com.obric.autogui.session.c r53 = com.obric.autogui.session.c.f30777a;
            com.obric.autogui.session.a r54 = this.f31337e.d();
            d.c.d<? super Boolean> r55 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31333a = r7;
            this.f31334b = r118;
            this.f31336d = 3;
            r34 = r53.a(r54, r55);
            if (r34 != r5) goto L37;
            return r5;
        L37:
            r24 = r7;
            r35 = r118;
        L44:
            th = th;
            String r119 = r27;
            String r120 = r211;
        L50:
            r26 = r117;
            r22 = r120;
            r13 = AOSystemTools.INSTANCE.bootTimeMillis();
            r20 = r25;
            r21 = r119;
            Loog.INSTANCE.w(l.TAG, "terminate cleanup finally begin, session=" + this.f31337e.d().a() + ", elapsedMs=" + (r13 - r7) + ", worker={" + this.f31337e.d().h().describeState() + "}, stateThread={" + this.f31337e.d().m().a().describeState() + '}');
            com.obric.autogui.session.c r56 = com.obric.autogui.session.c.f30777a;
            com.obric.autogui.session.a r57 = this.f31337e.d();
            r10 = "com.obric.aiagent.plugin";
            d.c.d<? super Boolean> r58 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, r10);
            this.f31335c = th;
            this.f31333a = r7;
            this.f31334b = r13;
            this.f31336d = 5;
            r14 = r56.a(r57, r58);
            if (r14 != r5) goto L53;
            return r5;
        L46:
            th = th;
            r120 = ", costMs=";
            r119 = r27;
        L48:
            th = th;
            r119 = r212;
            r120 = ", costMs=";
        L27:
            th = th;
            r117 = ", voided=";
            goto L58
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StateTerminate.kt */
    @d.c.b.a.f(b = "StateTerminate.kt", c = {336}, d = "sendEarlyTerminateStep", e = "com.obric.autogui.session.state.impl.StateTerminate")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f31341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l f31342e;
        int f;

        e(l r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31342e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31341d = r3;
            this.f |= Integer.MIN_VALUE;
            return l.a(this.f31342e, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ String lambda$iklHDNTBi3AHCOh3_XepipPKVOY(CharSequence r0, int r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$pxv801VlcXKCyEvE3BQ-Ko8NF_w, reason: not valid java name */
    public static /* synthetic */ x m900lambda$pxv801VlcXKCyEvE3BQKo8NF_w(l r0, r r1) {
        return a(r0, r1);
    }

    public static final /* synthetic */ Object a(l r2, CharSequence r3, int r4, d.c.d r5) {
        return r2.a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(l r0, boolean r1) {
        r0.a(r1);
    }

    public l(com.obric.autogui.session.state.b r9, com.obric.autogui.session.a r10) {
        d.h.b.o.e(r9, "machine");
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(BizStatus.TERMINATED, r10, r9, false, 8, null);
    }

    static {
        f31322b = new a(null);
        Uri r0 = Uri.parse("content://com.obric.browser.webcapability");
        d.h.b.o.c(r0, "parse(...)");
        f31323d = r0;
    }

    public final int a() {
        return f().getReason();
    }

    private final CharSequence j() {
        return (CharSequence) ZeusTransformUtils.preCheckCast(f().getMsg(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.session.state.a
    public Object a(com.obric.autogui.session.state.a r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L7;
        return com.obric.autogui.common.e.f29014b.a();
    L7:
        return com.obric.autogui.common.e.f29014b.b("not supported");
    }

    @Override // com.obric.autogui.session.state.a
    public int g() {
        int r2 = f().getReason();
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (r2 != 1) goto L7;
        Loog.INSTANCE.e(TAG, "unspecified termination reason.");
        return 1100;
    L7:
        if (r2 == 2) goto L10;
        return BizStatus.StatusChangedReason.TERMINATED__OTHER_REASON;
    L10:
        return 1101;
    }

    @Override // com.obric.autogui.session.state.a
    public Object b(com.obric.autogui.session.state.a r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.session.state.a.c.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, j.class) == true) goto L10;
        Loog.INSTANCE.e(TAG, "cannot terminate from `" + r2 + "`; we only allow terminate from [IAgentActiveState] or [StatePreparing]");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_terminate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_terminate"), null, 2, null);
    L10:
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public Object a(com.obric.autogui.util.c.b r8, d.c.d<? super x> r9) {
        com.obric.autogui.util.c.b r10 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r1.f31328d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f31328d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.f31326b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f31328d;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        l this = (l) ZeusTransformUtils.preCheckCast(r1.f31325a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L22:
        this.f31324c = (Bitmap) ZeusTransformUtils.preCheckCast(r12, Bitmap.class, "com.obric.aiagent.plugin");
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        this = (l) ZeusTransformUtils.preCheckCast(r1.f31325a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L19:
        com.obric.autogui.session.state.termination.a r13 = this.d().J();
        r1.f31325a = this;
        r1.f31328d = 2;
        r12 = r13.a(r1);
        if (r12 != r3) goto L22;
        return r3;
    L16:
        d.o.a(r12);
        r1.f31325a = this;
        r1.f31328d = 1;
        if (super.a(r10, r1) != r3) goto L19;
        return r3;
    L7:
        r1 = new b(this, r11);
        goto L8
    }

    private final void k() {
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (ZeusTransformUtils.instanceOf(r0, CCSpace.class) == false) goto L5;
        CCSpace r1 = (CCSpace) ZeusTransformUtils.preCheckCast(r0, CCSpace.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Loog.INSTANCE.i(TAG, "(ses/" + d().a() + ") [termination] hand over CC applications before close, reason=" + a());
        CCActionResult r2 = AOPlatformTools.INSTANCE.computerControl().handOverApplications(r1.getSessionAccessor());     // Catch: Exception -> L17
        if (d.h.b.o.a(r2, CCActionResult.Success.INSTANCE) == false) goto L13;
        Loog.INSTANCE.i(TAG, "(ses/" + d().a() + ") [termination] hand over CC applications succeeded");     // Catch: Exception -> L17
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r2, CCActionResult.Failed.class) == false) goto L16;
        Loog.INSTANCE.w(TAG, "(ses/" + d().a() + ") [termination] hand over CC applications failed: " + r2);     // Catch: Exception -> L17
        return;
    L16:
        throw new d.k();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "(ses/" + d().a() + ") [termination] hand over CC applications failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void l() {
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();     // Catch: Exception -> L18
        TaskPreservingDisplayAccessor r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, CCSpace.class) == false) goto L6;
        CCSpace r1 = (CCSpace) ZeusTransformUtils.preCheckCast(r0, CCSpace.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
    L7:
        if (r1 != null) goto L9;
        return;
    L9:
        VDTrackingApp r3 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdOperatingApp().a(), VDTrackingApp.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        if (r3 == null) goto L17;
        int r4 = r3.getTaskId();     // Catch: Exception -> L18
        DisplayAccessor r5 = r1.getDisplayAccessor();     // Catch: Exception -> L18
        if (ZeusTransformUtils.instanceOf(r5, TaskPreservingDisplayAccessor.class) == false) goto L14;
        r2 = (TaskPreservingDisplayAccessor) ZeusTransformUtils.preCheckCast(r5, TaskPreservingDisplayAccessor.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
    L14:
        if (r2 == null) goto L23;
        r2.scheduleTaskMoveToMainDisplayBeforeDestroy(r4);     // Catch: Exception -> L18
        return;
    L23:
        return;
    L17:
        return;
    L6:
        r1 = null;
    L18:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to preserve CC task before termination", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.session.state.a, com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r9) {
        com.obric.autogui.util.c.b r10 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "fromState");
        boolean r1 = true;
        if (m() == false) goto L8;
        if (n() == false) goto L8;
        boolean r4 = true;
    L10:
        if (a() != 2) goto L12;
    L15:
        boolean r5 = true;
    L16:
        Bundle r6 = d().l().getTaskExtras();
        if (r6 != null) goto L19;
    L21:
        r1 = false;
    L22:
        if (r5 == false) goto L25;
        k();
    L28:
        super.b(r10);
        d().c("terminate");
        CharSequence r11 = j();
        com.obric.autogui.agents.b.f26789a.a().b(d());     // Catch: Exception -> L31
    L42:
        d().a(new $$Lambda$l$pxv801VlcXKCyEvE3BQKo8NF_w(this));     // Catch: Exception -> L35
    L37:
        d().m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r11, this, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        long r3 = AOSystemTools.INSTANCE.bootTimeMillis();
        Loog.INSTANCE.w(TAG, "post terminate cleanup, session=" + d().a() + ", id=" + d().b() + ", reason=" + f().getReason() + ", worker={" + d().h().describeState() + "}, stateThread={" + d().m().a().describeState() + '}');
        d().h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, r3, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L35:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "enqueue Omni termination failed, session=" + d().a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L31:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "stop prediction during termination failed, session=" + d().a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L42
    L25:
        if (a() != 0) goto L28;
        if (r1 == true) goto L28;
        l();
        goto L28
    L19:
        if (r6.getBoolean("eos_exit_directly", false) != true) goto L21;
    L12:
        if (a(a()) == true) goto L15;
        r5 = false;
    L8:
        r4 = false;
        goto L10
    }

    private static final x a(l r8, r r9) {
        d.h.b.o.e(r9, "it");
        int r2 = r8.f().getReason();
        String r0 = r8.f().getMsg();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r3 = r0;
        if (w.f28887a.a(r8.f().getReason()) == false) goto L8;
        Map<String, Object> r10 = r8.f().getExtra();
    L9:
        r.a(r9, r2, r3, null, r10, 4, null);
        return x.f38692a;
    L8:
        r10 = ao.b();
        goto L9
    }

    private final boolean m() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.terminate.browser_switch_phone.enable", true);
    }

    @Override // com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void a(com.obric.autogui.util.c.b r3) {
        com.obric.autogui.util.c.b r4 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "toState");
        super.a(r4);
        com.obric.autogui.util.f.f31548a.b();
        com.obric.autogui.util.c.f31500a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    private final String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        int r2 = a();
        if (r2 != 0) goto L5;
        int r5 = ZeusTransformUtils.mapRes(R.string.agent_task_terminated_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminated_success");
    L15:
        String r6 = r4.getString(r5);
        d.h.b.o.c(r6, "getString(...)");
        return r6;
    L5:
        if (r2 != 2) goto L7;
        r5 = ZeusTransformUtils.mapRes(R.string.agent_task_early_terminated_by_user, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_terminated_by_user");
        goto L15
    L7:
        if (r2 != 104002) goto L9;
        r5 = ZeusTransformUtils.mapRes(R.string.agent_task_early_term_thermal_state_too_high_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_thermal_state_too_high_title");
        goto L15
    L9:
        if (r2 == 105001) goto L11;
        r5 = ZeusTransformUtils.mapRes(R.string.agent_task_early_terminated_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_terminated_error");
        goto L15
    L11:
        r5 = ZeusTransformUtils.mapRes(R.string.agent_task_early_cancelled_externally, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_cancelled_externally");
        goto L15
    }

    private final boolean a(int r6) {
        List<?> r5 = AutoActionConfigs.INSTANCE.getListCfg("vd.term.bring_app_reasons");
        List r0 = null;
        if (r5 == null) goto L17;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        Object r3 = r8.next();
        if (ZeusTransformUtils.instanceOf(r3, Number.class) == false) goto L10;
        Number r4 = (Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin");
    L11:
        if (r4 == null) goto L13;
        Integer r9 = Integer.valueOf(r4.intValue());
    L14:
        if (r9 == null) goto L6;
        r1.add(r9);
        goto L6
    L13:
        r9 = null;
        goto L14
    L10:
        r4 = null;
        goto L11
    L16:
        r0 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L17:
        Loog.INSTANCE.d(TAG, "[Term-BringApp] configured=" + r0 + ", earlyTermReason=" + r6);
        if (r0 != null) goto L28;
        if (r6 != 106004) goto L22;
    L25:
        return true;
    L22:
        if (r6 == 106002) goto L25;
        return false;
    L28:
        return r0.contains(Integer.valueOf(r6));
    }

    private final Object a(CharSequence r26, final int r27, d.c.d<? super x> r28) {
        l r0 = this;
        final CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r26, CharSequence.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f31341d;
        Object r7 = d.c.a.b.a();
        int r8 = r5.f;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        IAutoActionAgentEventListener.SessionInfo r1 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r5.f31340c, IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.AgentStepInfo r3 = (IAutoActionAgentEventListener.AgentStepInfo) ZeusTransformUtils.preCheckCast(r5.f31339b, IAutoActionAgentEventListener.AgentStepInfo.class, "com.obric.aiagent.plugin");
        l r9 = (l) ZeusTransformUtils.preCheckCast(r5.f31338a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        IAutoActionAgentEventListener.SessionInfo r10 = r1;
        r0 = r9;
    L20:
        Bitmap r11 = (Bitmap) ZeusTransformUtils.preCheckCast(r6, Bitmap.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.AgentStepInfo r12 = r3;
    L21:
        Bitmap r13 = r11;
        com.obric.autogui.b.a r14 = com.obric.autogui.b.a.f28928a;
        com.obric.autogui.session.a.d r15 = r0.d().z();
        if (r15 == null) goto L28;
        File r16 = r15.b();
        if (r16 == null) goto L28;
        String r17 = r16.getAbsolutePath();
        if (r17 == null) goto L28;
    L29:
        r14.afterAgentStep(r10, r12, new IAutoActionAgentEventListener.AgentStepExecInfo(r13, null, r17, true, null, 16, null));
        return x.f38692a;
    L28:
        r17 = "";
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r19 = r2.toString();
        Loog.INSTANCE.dp(LogUtil.INSTANCE.getCLAZZ_TAG(r0), new $$Lambda$l$iklHDNTBi3AHCOh3_XepipPKVOY(r2, r27));
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(r0), "early-terminate");
        String r110 = r0.a(r18);
        long r111 = AOSystemTools.INSTANCE.nowTimeMillis();
        long r21 = AOSystemTools.INSTANCE.nowTimeMillis();
        Bundle r20 = h();
        r20.putBoolean("open_app", r0.a(r27));
        x r22 = x.f38692a;
        r12 = new IAutoActionAgentEventListener.AgentStepInfo("", r110, r19, r19, false, true, "", 0, false, r111, r21, r20);
        r10 = d().d();
        com.obric.autogui.b.a.f28928a.onAgentStep(r10, r12);
        r11 = null;
        if (r0.b(r27) == false) goto L21;
        com.obric.autogui.session.state.termination.a r23 = d().J();
        r5.f31338a = r0;
        r5.f31339b = r12;
        r5.f31340c = r10;
        r5.f = 1;
        Object r24 = r23.a(r5);
        if (r24 != r7) goto L19;
        return r7;
    L19:
        r6 = r24;
        r3 = r12;
    L7:
        r5 = new e(r0, r4);
        goto L8
    }

    private static final String a(CharSequence r2, int r3) {
        return "early-terminate, reasonMsg=" + ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin")) + ", termReason=" + r3;
    }

    private final boolean b(int r2) {
        if (r2 != 112001) goto L6;
        return false;
    L6:
        if (AutoActionVirtualDisplay.INSTANCE.getVdOperatingApp().a() != null) goto L8;
        return false;
    L8:
        return true;
    }

    private final boolean n() {
        ComponentName r2 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        String r3 = r2.getPackageName();
    L7:
        return d.h.b.o.a(r3, "com.obric.browser");
    L5:
        r3 = null;
        goto L7
    }

    private final void a(boolean r13) {
        if (r13 == true) goto L22;
        return;
    L22:
        ContentResolver r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver();     // Catch: Throwable -> L19
        Uri r14 = f31323d;     // Catch: Throwable -> L19
        Bundle r2 = ZeusProviderTransform.call(r1, r14, "switch_phone", null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        String r3 = null;
        if (r2 == null) goto L10;
        Boolean r4 = Boolean.valueOf(r2.getBoolean("success"));     // Catch: Throwable -> L19
    L11:
        Loog.INSTANCE.d(TAG, "maybeSwitchBrowserToPhoneMode: invoked " + r14 + ", success=" + r4);     // Catch: Throwable -> L19
        ComponentName r15 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r15 == null) goto L14;
        r3 = r15.getPackageName();     // Catch: Throwable -> L19
    L14:
        IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L19
        if (r3 != null) goto L17;
        r3 = "com.obric.browser";
    L17:
        r6.put("package_name", r3);     // Catch: Throwable -> L19
        r6.put("success", r4);     // Catch: Throwable -> L19
        x r16 = x.f38692a;     // Catch: Throwable -> L19
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "close_browser_switch_phone", r6, false, false, null, 28, null);     // Catch: Throwable -> L19
        return;
    L10:
        r4 = null;
    L19:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "maybeSwitchBrowserToPhoneMode failed: " + th);
    }

    @Override // com.obric.autogui.session.state.a
    public Bundle h() {
        Bundle r0 = super.h();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        r0.putInt("term_reason_type", a());
        r0.putCharSequence("early_term_reason", j());
        r0.putBundle("task_end_reports", d().J().f());
        r0.putBoolean("open_app", a(a()));
        Object r1 = f().getExtra().get("early_term_msg");
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L9:
        r0.putString("early_term_msg", r2);
        Bitmap r3 = this.f31324c;
        if (r3 == null) goto L12;
        r0.putParcelable("termination_screenshot", (Parcelable) ZeusTransformUtils.preCheckCast(r3, Parcelable.class, "com.obric.aiagent.plugin"));
    L12:
        com.obric.autogui.operator.e r5 = d().r();
        if (r5 == null) goto L22;
        IAutoActionAgentEventListener.AgentStepInfo r6 = r5.T();
        if (r6 == null) goto L22;
        r0.putString("last_action_type", r6.getActionProtocolType());
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L19
        r0.putString("last_action_args", new JSONObject(r6.getRawAction()).optString("action_args"));     // Catch: Throwable -> L19
        d.n.f(x.f38692a);     // Catch: Throwable -> L19
    L21:
        r0.putLong("last_action_interval", AOSystemTools.INSTANCE.nowTimeMillis() - r6.getCreationTimeMillis());
    L19:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L22:
        return r0;
    L8:
        r2 = null;
        goto L9
    }
}
