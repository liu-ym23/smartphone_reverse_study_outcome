package com.obric.autogui.operator.a.b.a;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOImageUtil;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessResult;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessState;
import com.obric.autogui.common.api.platform.computercontrol.CCDataResult;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.cc.CCSpace;
import com.obric.autogui.common.api.space.errtrack.AppErrorTracker;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: OpOpenApp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.operator.a.b {
    private static final String TAG = "Op-OpenApp";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0751a f29344b = null;
    private static final Uri g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f29345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autogui.operator.e f29346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29347e;
    private final List<f> f;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpOpenApp.kt */
    public static final class C0751a {
        public /* synthetic */ C0751a(d.h.b.h r1) {
            this();
        }

        private C0751a() {
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    public static final class b implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f29351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f29352e;
        private final boolean f;
        private final h g;

        public b() {
            this(null, null, null, null, null, false, null, 127, null);
        }

        public static /* synthetic */ b a(b r5, String r6, String r7, String r8, String r9, String r10, boolean r11, h r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.f29348a;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.f29349b;
        L8:
            String r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.f29350c;
        L11:
            String r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.f29351d;
        L14:
            String r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.f29352e;
        L17:
            String r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.f;
        L20:
            boolean r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.g;
        L23:
            String r16 = r6;
            return r5.a(r16, r15, r0, r1, r2, r3, r12);
        }

        public final b a(String r9, String r10, String r11, String r12, String r13, boolean r14, h r15) {
            return new b(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29348a, r6.f29348a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29349b, r6.f29349b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29350c, r6.f29350c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f29351d, r6.f29351d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f29352e, r6.f29352e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            String r0 = this.f29348a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f29349b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f29350c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.f29351d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.f29352e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (((r12 + r14) * 31) + Boolean.hashCode(this.f)) * 31;
            h r16 = this.g;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Input(deepLink=" + this.f29348a + ", packageName=" + this.f29349b + ", appName=" + this.f29350c + ", activityName=" + this.f29351d + ", activityAction=" + this.f29352e + ", returnToLauncherIfFailed=" + this.f + ", restartInfo=" + this.g + ')';
        }

        public b(String r1, String r2, String r3, String r4, String r5, boolean r6, h r7) {
            this.f29348a = r1;
            this.f29349b = r2;
            this.f29350c = r3;
            this.f29351d = r4;
            this.f29352e = r5;
            this.f = r6;
            this.g = r7;
        }

        public /* synthetic */ b(String r2, String r3, String r4, String r5, String r6, boolean r7, h r8, int r9, d.h.b.h r10) {
            if ((r9 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r9 & 8) == 0) goto L15;
            r5 = null;
        L15:
            if ((r9 & 16) == 0) goto L18;
            r6 = null;
        L18:
            if ((r9 & 32) == 0) goto L21;
            r7 = false;
        L21:
            if ((r9 & 64) == 0) goto L23;
            r8 = null;
        L23:
            this(r2, r3, r4, r5, r6, r7, r8);
        }

        public final String a() {
            return this.f29348a;
        }

        public final String b() {
            return this.f29349b;
        }

        public final String c() {
            return this.f29350c;
        }

        public final String d() {
            return this.f29351d;
        }

        public final String e() {
            return this.f29352e;
        }

        public final boolean f() {
            return this.f;
        }

        public final h g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    public static final class c implements com.obric.autogui.operator.c, com.obric.autogui.operator.k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.operator.a.b.a.c f29353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f29354c;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpOpenApp.kt */
        public /* synthetic */ class C0752a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f29355a = null;

            static {
                int[] r0 = new int[com.obric.autogui.operator.a.b.a.b.values().length];
                r0[com.obric.autogui.operator.a.b.a.b.f29448d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f29355a = r0;
            }
        }

        public c(com.obric.autogui.operator.a.b.a.c r2, b r3) {
            o.e(r2, "openAppStatus");
            o.e(r3, "input");
            this.f29353b = r2;
            this.f29354c = r3;
        }

        public final com.obric.autogui.operator.a.b.a.c f() {
            return this.f29353b;
        }

        public final String g() {
            return this.f29353b.d();
        }

        @Override // com.obric.autogui.operator.c
        public boolean a() {
            return !this.f29353b.a().c();
        }

        @Override // com.obric.autogui.operator.c
        public int b() {
            return this.f29353b.a().a();
        }

        @Override // com.obric.autogui.operator.k
        public String a(Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            o.e(r7, "context");
            if (this.f29353b.a() != com.obric.autogui.operator.a.b.a.b.f29449e) goto L7;
            return "";
        L7:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f29353b.b(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
            return this.f29353b.b();
        L11:
            if (this.f29353b.a().c() == false) goto L24;
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f29354c.c(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L15;
        L18:
            boolean r1 = true;
        L19:
            if (r1 == false) goto L21;
            String r5 = r7.getString(ZeusTransformUtils.mapRes(R.string.agent_action_openapp_succeeded_wo_appname, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_openapp_succeeded_wo_appname"));
        L22:
            o.a(r5);
            return r5;
        L21:
            r5 = r7.getString(ZeusTransformUtils.mapRes(R.string.agent_action_openapp_succeeded, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_openapp_succeeded"), new Object[]{this.f29354c.c()});
            goto L22
        L15:
            if (d.o.o.d(r0) == true) goto L18;
            r1 = false;
            goto L19
        L24:
            String r8 = r7.getString(ZeusTransformUtils.mapRes(R.string.espe_execute_op_openapp_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_execute_op_openapp_failed"));
            o.c(r8, "getString(...)");
            return r8;
        }

        @Override // com.obric.autogui.operator.c
        public com.obric.autogui.operator.c.EnumC0779c c() {
            com.obric.autogui.operator.a.b.a.b r1 = this.f29353b.a();
            if (C0752a.f29355a[r1.ordinal()] != 1) goto L6;
            return com.obric.autogui.operator.c.EnumC0779c.f29879c;
        L6:
            return com.obric.autogui.operator.c.EnumC0779c.f29878b;
        }

        @Override // com.obric.autogui.operator.c
        public String d() {
            return this.f29353b.a().b();
        }

        @Override // com.obric.autogui.operator.c
        public String e() {
            return this.f29353b.c();
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    private final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f29356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.operator.a.b.a.a.b f29357b;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpOpenApp.kt */
        @d.c.b.a.f(b = "OpOpenApp.kt", c = {DownloadErrorCode.ERROR_DB_READONLY}, d = "run", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp$OpenAppByAppNameStrategy")
        static final class C0753a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f29358a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f29359b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f29360c;

            C0753a(d r3, d.c.d<? super C0753a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29359b = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29358a = r3;
                this.f29360c |= Integer.MIN_VALUE;
                return this.f29359b.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpOpenApp.kt */
        @d.c.b.a.f(b = "OpOpenApp.kt", c = {1024}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp$OpenAppByAppNameStrategy$run$result$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.operator.a.b.a.b.a, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f29361a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f29362b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f29363c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f29364d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f29365e;

            b(a r3, b r4, Context r5, d.c.d<? super b> r6) {
                Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29363c = r3;
                this.f29364d = r4;
                this.f29365e = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
                super(2, r8);
            }

            public final Object a(com.obric.autogui.operator.a.b.a.b.a r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                b r0 = new b(this.f29363c, this.f29364d, this.f29365e, r7);
                r0.f29362b = r5;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(com.obric.autogui.operator.a.b.a.b.a r3, d.c.d<? super x> r4) {
                return a((com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f29361a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r8);
            L38:
                d.m r9 = (d.m) ZeusTransformUtils.preCheckCast(r8, d.m.class, "com.obric.aiagent.plugin");
                if (r9 == null) goto L42;
                a.a(this.f29363c, ((Boolean) ZeusTransformUtils.preCheckCast(r9.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (String) ZeusTransformUtils.preCheckCast(r9.d(), String.class, "com.obric.aiagent.plugin"));
            L42:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r8);
                com.obric.autogui.operator.a.b.a.b.a r10 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(this.f29362b, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r10, com.obric.autogui.operator.a.b.a.b.f.class) == false) goto L26;
                Loog r2 = Loog.INSTANCE;
                StringBuilder r4 = new StringBuilder().append("[ShortcutBLTrace] shortcut candidate selected: target=").append(((com.obric.autogui.operator.a.b.a.b.f) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.operator.a.b.a.b.f.class, "com.obric.aiagent.plugin")).d()).append(", host=").append(((com.obric.autogui.operator.a.b.a.b.f) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.operator.a.b.a.b.f.class, "com.obric.aiagent.plugin")).c()).append(", stepId=");
                com.obric.autogui.operator.e r5 = a.a(this.f29363c);
                Integer r6 = null;
                if (r5 == null) goto L13;
                String r7 = r5.W();
            L14:
                StringBuilder r11 = r4.append(r7).append(", executionLoop=").append(a.b(this.f29363c)).append(", currentStepId=");
                com.obric.autogui.session.a r12 = com.obric.autogui.session.c.f30777a.b();
                if (r12 == null) goto L19;
                com.obric.autogui.operator.e r13 = r12.r();
                if (r13 == null) goto L19;
                String r14 = r13.W();
            L20:
                StringBuilder r15 = r11.append(r14).append(", resumedCount=");
                com.obric.autogui.session.a r16 = com.obric.autogui.session.c.f30777a.b();
                if (r16 == null) goto L25;
                AtomicInteger r17 = r16.N();
                if (r17 == null) goto L25;
                r6 = d.c.b.a.b.a(r17.get());
            L25:
                r2.i(a.TAG, r15.append(r6).toString());
            L19:
                r14 = null;
                goto L20
            L13:
                r7 = null;
            L26:
                h r3 = this.f29364d.g();
                boolean r18 = false;
                if (r3 != null) goto L29;
            L31:
                if (r18 == false) goto L42;
                if (com.obric.autogui.common.a.d.f28974a.S() == false) goto L42;
                if (r10 == null) goto L42;
                Context r19 = this.f29365e;
                d.c.d<? super d.m<Boolean, String>> r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29361a = 1;
                r8 = r10.b(r19, r20);
                if (r8 != r0) goto L38;
                return r0;
            L29:
                if (r3.a() != true) goto L31;
                r18 = true;
                goto L31
            }
        }

        /* JADX INFO: compiled from: OpOpenApp.kt */
        @d.c.b.a.f(b = "OpOpenApp.kt", c = {DownloadErrorCode.ERROR_MD5_INVALID}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp$OpenAppByAppNameStrategy$run$result$2")
        static final class c extends d.c.b.a.l implements d.h.a.m<com.obric.autogui.operator.a.b.a.b.a, d.c.d<? super com.obric.autogui.operator.a.b.a.c>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f29366a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f29367b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f29368c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f29369d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ AOOperatingSpace f29370e;
            final /* synthetic */ b f;

            c(a r3, Context r4, AOOperatingSpace r5, b r6, d.c.d<? super c> r7) {
                Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
                AOOperatingSpace r9 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r5, AOOperatingSpace.class, "com.obric.aiagent.plugin");
                d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29368c = r3;
                this.f29369d = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
                this.f29370e = r9;
                this.f = r6;
                super(2, r10);
            }

            public final Object a(com.obric.autogui.operator.a.b.a.b.a r3, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r4) {
                return ((c) ZeusTransformUtils.preCheckCast(create((com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                c r11 = new c(this.f29368c, this.f29369d, this.f29370e, this.f, r7);
                r11.f29367b = r9;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(com.obric.autogui.operator.a.b.a.b.a r3, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r4) {
                return a((com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r13) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f29366a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r13);
            L17:
                return r13;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r13);
                com.obric.autogui.operator.a.b.a.b.a r14 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(this.f29367b, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
                String r4 = null;
                if (ZeusTransformUtils.instanceOf(r14, com.obric.autogui.operator.a.b.a.b.c.class) == false) goto L11;
                com.obric.autogui.operator.a.b.a.b.c r15 = (com.obric.autogui.operator.a.b.a.b.c) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.operator.a.b.a.b.c.class, "com.obric.aiagent.plugin");
            L12:
                if (r15 == null) goto L14;
                r4 = r15.b();
            L14:
                a r5 = this.f29368c;
                Context r6 = this.f29369d;
                AOOperatingSpace r7 = this.f29370e;
                b r8 = this.f;
                d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29366a = 1;
                r13 = a.a(r5, r6, r7, r8, r4, "appName", r11);
                if (r13 != r0) goto L17;
                return r0;
            L11:
                r15 = null;
                goto L12
            }
        }

        public d(a r1) {
            this.f29356a = r1;
            this.f29357b = new com.obric.autogui.operator.a.b.a.a.b();
        }

        @Override // com.obric.autogui.operator.a.b.a.a.f
        public Object a(Context r23, AOOperatingSpace r24, b r25, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r26) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
            AOOperatingSpace r6 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r24, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, C0753a.class) == false) goto L7;
            C0753a r4 = (C0753a) ZeusTransformUtils.preCheckCast(r3, C0753a.class, "com.obric.aiagent.plugin");
            if ((r4.f29360c & Integer.MIN_VALUE) == 0) goto L7;
            r4.f29360c -= Integer.MIN_VALUE;
        L8:
            C0753a r9 = r4;
            Object r5 = r9.f29358a;
            Object r10 = d.c.a.b.a();
            int r7 = r9.f29360c;
            if (r7 == 0) goto L14;
            if (r7 != 1) goto L13;
            d.o.a(r5);
        L28:
            return (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r5);
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r25.c(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L17;
        L20:
            boolean r11 = true;
        L21:
            if (r11 == false) goto L24;
            com.obric.autogui.operator.a.b.a.b r13 = com.obric.autogui.operator.a.b.a.b.f29447c;
            String r14 = r1.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_no_app_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_no_app_name"));
            o.c(r14, "getString(...)");
            return new com.obric.autogui.operator.a.b.a.c(r13, r14, "no app-name provided", null, null, false, null, 120, null);
        L24:
            com.obric.autogui.operator.a.b.a.a.b r12 = this.f29357b;
            String r15 = r25.c();
            d.h.a.m<? super com.obric.autogui.operator.a.b.a.b.a, ? super d.c.d<? super x>, ? extends Object> r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f29356a, r25, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.h.a.m<? super com.obric.autogui.operator.a.b.a.b.a, ? super d.c.d<? super com.obric.autogui.operator.a.b.a.c>, ? extends Object> r17 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this.f29356a, r1, r6, r25, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            r9.f29360c = 1;
            r5 = r12.a(r1, r15, r16, r17, r9);
            if (r5 != r10) goto L28;
            return r10;
        L17:
            if (d.o.o.d(r8) == true) goto L20;
            r11 = false;
        L7:
            r4 = new C0753a(this, r3);
            goto L8
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    private final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f29371a;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpOpenApp.kt */
        @d.c.b.a.f(b = "OpOpenApp.kt", c = {976, 988, 991}, d = "run", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp$OpenAppByPackageStrategy")
        static final class C0754a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29372a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f29373b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f29374c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f29375d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f29376e;
            final /* synthetic */ e f;
            int g;

            C0754a(e r3, d.c.d<? super C0754a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29376e = r3;
                this.g |= Integer.MIN_VALUE;
                return this.f.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public e(a r1) {
            this.f29371a = r1;
        }

        @Override // com.obric.autogui.operator.a.b.a.a.f
        public Object a(Context r28, AOOperatingSpace r29, b r30, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r31) {
            e r0 = this;
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r28, Context.class, "com.obric.aiagent.plugin");
            AOOperatingSpace r6 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r29, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, C0754a.class) == false) goto L7;
            C0754a r5 = (C0754a) ZeusTransformUtils.preCheckCast(r4, C0754a.class, "com.obric.aiagent.plugin");
            if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
            r5.g -= Integer.MIN_VALUE;
        L8:
            C0754a r11 = r5;
            Object r7 = r11.f29376e;
            Object r12 = d.c.a.b.a();
            int r8 = r11.g;
            Object r10 = null;
            boolean r9 = true;
            if (r8 == 0) goto L18;
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L16;
            if (r8 != 3) goto L15;
            d.o.a(r7);
        L79:
            return r7;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            Object r1 = r11.f29374c;
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(r11.f29373b, Context.class, "com.obric.aiagent.plugin");
            e r13 = (e) ZeusTransformUtils.preCheckCast(r11.f29372a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
            r10 = null;
        L75:
            d.m r14 = (d.m) ZeusTransformUtils.preCheckCast(r7, d.m.class, "com.obric.aiagent.plugin");
            a.a(r13.f29371a, ((Boolean) ZeusTransformUtils.preCheckCast(r14.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (String) ZeusTransformUtils.preCheckCast(r14.d(), String.class, "com.obric.aiagent.plugin"));
            Object r15 = r1;
            Context r16 = r3;
        L76:
            com.obric.autogui.operator.a.b.a.b.a r17 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
            r11.f29372a = r10;
            r11.f29373b = r10;
            r11.f29374c = r10;
            r11.f29375d = r10;
            r11.g = 3;
            r7 = r17.a(r16, r11);
            if (r7 != r12) goto L79;
            return r12;
        L17:
            Object r18 = r11.f29375d;
            b r19 = (b) ZeusTransformUtils.preCheckCast(r11.f29374c, b.class, "com.obric.aiagent.plugin");
            r16 = (Context) ZeusTransformUtils.preCheckCast(r11.f29373b, Context.class, "com.obric.aiagent.plugin");
            e r20 = (e) ZeusTransformUtils.preCheckCast(r11.f29372a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
            r15 = r18;
            r0 = r20;
        L59:
            com.obric.autogui.operator.a.b.a.c r21 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
            if (r21 == null) goto L62;
            return r21;
        L62:
            h r22 = r19.g();
            if (r22 != null) goto L65;
        L67:
            r9 = false;
        L68:
            if (r9 == false) goto L76;
            if (com.obric.autogui.common.a.d.f28974a.S() == false) goto L76;
            com.obric.autogui.operator.a.b.a.b.a r23 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
            r11.f29372a = r0;
            r11.f29373b = r16;
            r11.f29374c = r15;
            r11.f29375d = r10;
            r11.g = 2;
            r7 = r23.b(r16, r11);
            if (r7 != r12) goto L74;
            return r12;
        L74:
            r3 = r16;
            Object r26 = r15;
            r13 = r0;
            r1 = r26;
            goto L75
        L65:
            if (r22.a() != r9) goto L67;
        L18:
            d.o.a(r7);
            CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r30.b(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r24 != null) goto L21;
        L24:
            boolean r25 = true;
        L25:
            if (r25 == false) goto L28;
            com.obric.autogui.operator.a.b.a.b r110 = com.obric.autogui.operator.a.b.a.b.f29447c;
            String r27 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_no_app_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_no_app_name"));
            o.c(r27, "getString(...)");
            return new com.obric.autogui.operator.a.b.a.c(r110, r27, "no package-name provided", null, null, false, null, 120, null);
        L28:
            CharSequence r32 = (CharSequence) ZeusTransformUtils.preCheckCast(r30.d(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r32 != null) goto L31;
        L34:
            boolean r33 = true;
        L35:
            if (r33 == false) goto L44;
            CharSequence r34 = (CharSequence) ZeusTransformUtils.preCheckCast(r30.e(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r34 != null) goto L39;
        L42:
            boolean r35 = true;
        L43:
            if (r35 == false) goto L44;
        L47:
            Intent r36 = null;
        L48:
            if (r36 != null) goto L50;
            r15 = new com.obric.autogui.operator.a.b.a.b.e(r2, r30.b());
        L52:
            if (ZeusTransformUtils.instanceOf(r15, com.obric.autogui.operator.a.b.a.b.c.class) == false) goto L54;
            String r37 = ((com.obric.autogui.operator.a.b.a.b.c) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.operator.a.b.a.b.c.class, "com.obric.aiagent.plugin")).b();
        L55:
            String r38 = r37;
            a r39 = r0.f29371a;
            r11.f29372a = r0;
            r11.f29373b = r2;
            r11.f29374c = r30;
            r11.f29375d = r15;
            r11.g = 1;
            r7 = a.a(r39, r2, r6, r30, r38, "pkg", r11);
            if (r7 != r12) goto L58;
            return r12;
        L58:
            r16 = r2;
            r19 = r30;
            goto L59
        L54:
            r37 = r30.b();
            goto L55
        L50:
            r15 = new com.obric.autogui.operator.a.b.a.b.d(r36, r30.c());
            goto L52
        L39:
            if (d.o.o.d(r34) == true) goto L42;
            r35 = false;
        L44:
            com.obric.autogui.common.d r40 = a.a(r0.f29371a, r30.b(), r30.d(), r30.e());
            if (r40.g() == false) goto L47;
            r36 = (Intent) ZeusTransformUtils.preCheckCast(r40.a(), Intent.class, "com.obric.aiagent.plugin");
            goto L48
        L31:
            if (d.o.o.d(r32) == true) goto L34;
            r33 = false;
            goto L35
        L21:
            if (d.o.o.d(r24) == true) goto L24;
            r25 = false;
        L7:
            r5 = new C0754a(r0, r4);
            goto L8
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    private interface f {
        Object a(Context r1, AOOperatingSpace r2, b r3, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r4);
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    private final class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f29377a;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpOpenApp.kt */
        @d.c.b.a.f(b = "OpOpenApp.kt", c = {DownloadErrorCode.ERROR_APP_INTERCEPT, 1096, 1099}, d = "run", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp$OpenDeepLinkPageStrategy")
        static final class C0755a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29378a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f29379b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f29380c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f29381d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f29382e;
            final /* synthetic */ g f;
            int g;

            C0755a(g r3, d.c.d<? super C0755a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29382e = r3;
                this.g |= Integer.MIN_VALUE;
                return this.f.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpOpenApp.kt */
        @d.c.b.a.f(b = "OpOpenApp.kt", c = {DownloadErrorCode.ERROR_PROBE_FIRST_BUFFER}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp$OpenDeepLinkPageStrategy$run$opener$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super com.obric.autogui.operator.a.b.a.c>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f29383a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f29384b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f29385c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f29386d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ AOOperatingSpace f29387e;
            final /* synthetic */ b f;

            b(a r3, Context r4, AOOperatingSpace r5, b r6, d.c.d<? super b> r7) {
                Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
                AOOperatingSpace r9 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r5, AOOperatingSpace.class, "com.obric.aiagent.plugin");
                d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29385c = r3;
                this.f29386d = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
                this.f29387e = r9;
                this.f = r6;
                super(2, r10);
            }

            public final Object a(String r3, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                b r11 = new b(this.f29385c, this.f29386d, this.f29387e, this.f, r7);
                r11.f29384b = r9;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(String r3, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r4) {
                return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f29383a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r12);
            L11:
                return r12;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r12);
                String r8 = (String) ZeusTransformUtils.preCheckCast(this.f29384b, String.class, "com.obric.aiagent.plugin");
                a r4 = this.f29385c;
                Context r5 = this.f29386d;
                AOOperatingSpace r6 = this.f29387e;
                b r7 = this.f;
                d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29383a = 1;
                r12 = a.a(r4, r5, r6, r7, r8, "deeplinkFallback", r10);
                if (r12 != r0) goto L11;
                return r0;
            }
        }

        public g(a r1) {
            this.f29377a = r1;
        }

        @Override // com.obric.autogui.operator.a.b.a.a.f
        public Object a(Context r27, AOOperatingSpace r28, b r29, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r30) {
            g r0 = this;
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r27, Context.class, "com.obric.aiagent.plugin");
            AOOperatingSpace r10 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r28, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, C0755a.class) == false) goto L7;
            C0755a r5 = (C0755a) ZeusTransformUtils.preCheckCast(r4, C0755a.class, "com.obric.aiagent.plugin");
            if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
            r5.g -= Integer.MIN_VALUE;
        L8:
            C0755a r11 = r5;
            Object r6 = r11.f29382e;
            Object r12 = d.c.a.b.a();
            int r7 = r11.g;
            if (r7 == 0) goto L18;
            if (r7 == 1) goto L17;
            if (r7 == 2) goto L16;
            if (r7 != 3) goto L15;
            d.o.a(r6);
        L55:
            return r6;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            com.obric.autogui.operator.a.b.a.b.a.a r1 = (com.obric.autogui.operator.a.b.a.b.a.a) ZeusTransformUtils.preCheckCast(r11.f29380c, com.obric.autogui.operator.a.b.a.b.a.a.class, "com.obric.aiagent.plugin");
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(r11.f29379b, Context.class, "com.obric.aiagent.plugin");
            g r8 = (g) ZeusTransformUtils.preCheckCast(r11.f29378a, g.class, "com.obric.aiagent.plugin");
            d.o.a(r6);
            Object r9 = r6;
            Object r13 = r12;
            Context r14 = r3;
            g r15 = r8;
            Object r16 = null;
        L50:
            d.m r17 = (d.m) ZeusTransformUtils.preCheckCast(r9, d.m.class, "com.obric.aiagent.plugin");
            a.a(r15.f29377a, ((Boolean) ZeusTransformUtils.preCheckCast(r17.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (String) ZeusTransformUtils.preCheckCast(r17.d(), String.class, "com.obric.aiagent.plugin"));
            com.obric.autogui.operator.a.b.a.b.a.a r18 = r1;
            r2 = r14;
        L52:
            r11.f29378a = r16;
            r11.f29379b = r16;
            r11.f29380c = r16;
            r11.f29381d = r16;
            r11.g = 3;
            r6 = r18.a(r2, r11);
            if (r6 != r13) goto L55;
            return r13;
        L17:
            com.obric.autogui.operator.a.b.a.b.a.a r19 = (com.obric.autogui.operator.a.b.a.b.a.a) ZeusTransformUtils.preCheckCast(r11.f29381d, com.obric.autogui.operator.a.b.a.b.a.a.class, "com.obric.aiagent.plugin");
            b r20 = (b) ZeusTransformUtils.preCheckCast(r11.f29380c, b.class, "com.obric.aiagent.plugin");
            Context r21 = (Context) ZeusTransformUtils.preCheckCast(r11.f29379b, Context.class, "com.obric.aiagent.plugin");
            g r22 = (g) ZeusTransformUtils.preCheckCast(r11.f29378a, g.class, "com.obric.aiagent.plugin");
            d.o.a(r6);
            r18 = r19;
            r0 = r22;
            b r23 = r20;
            r2 = r21;
            r13 = r12;
            boolean r110 = true;
        L34:
            com.obric.autogui.operator.a.b.a.c r24 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
            if (r24 == null) goto L37;
            return r24;
        L37:
            h r25 = r23.g();
            if (r25 != null) goto L40;
        L42:
            r110 = false;
        L43:
            if (r110 == true) goto L45;
        L51:
            r16 = null;
            goto L52
        L45:
            if (com.obric.autogui.common.a.d.f28974a.S() == false) goto L51;
            r11.f29378a = r0;
            r11.f29379b = r2;
            r11.f29380c = r18;
            r16 = null;
            r11.f29381d = null;
            r11.g = 2;
            Object r26 = r18.b(r2, r11);
            if (r26 != r13) goto L49;
            return r13;
        L49:
            r9 = r26;
            r14 = r2;
            r15 = r0;
            r1 = r18;
            goto L50
        L40:
            if (r25.a() != r110) goto L42;
        L18:
            d.o.a(r6);
            String r31 = r29.a();
            CharSequence r32 = (CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.aiagent.plugin");
            if (r32 != null) goto L21;
        L24:
            boolean r33 = true;
        L25:
            if (r33 == false) goto L28;
            com.obric.autogui.operator.a.b.a.b r111 = com.obric.autogui.operator.a.b.a.b.f29447c;
            String r34 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_no_app_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_no_app_name"));
            o.c(r34, "getString(...)");
            return new com.obric.autogui.operator.a.b.a.c(r111, r34, "no deep-link URL provided", null, null, false, null, 120, null);
        L28:
            Uri r35 = Uri.parse(r31);
            o.c(r35, "parse(...)");
            r110 = true;
            r18 = new com.obric.autogui.operator.a.b.a.b.a.a(r35, r29.b(), r29.c(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r0.f29377a, r2, r10, r29, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
            String r36 = r18.b();
            if (r36 != null) goto L31;
            r36 = r29.b();
        L31:
            String r37 = r36;
            a r38 = r0.f29377a;
            r11.f29378a = r0;
            r11.f29379b = r2;
            r23 = r29;
            r11.f29380c = r23;
            r11.f29381d = r18;
            r11.g = 1;
            r6 = a.a(r38, r2, r10, r29, r37, MemorySourceLinkType.DEEPLINK, r11);
            r13 = r12;
            if (r6 != r13) goto L34;
            return r13;
        L21:
            if (d.o.o.d(r32) == true) goto L24;
            r33 = false;
        L7:
            r5 = new C0755a(r0, r4);
            goto L8
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f29388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f29390c;

        public h() {
            this(false, false, false, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (this.f29388a == r6.f29388a) goto L12;
            return false;
        L12:
            if (this.f29389b == r6.f29389b) goto L15;
            return false;
        L15:
            if (this.f29390c == r6.f29390c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f29388a) * 31) + Boolean.hashCode(this.f29389b)) * 31) + Boolean.hashCode(this.f29390c);
        }

        public String toString() {
            return "RestartInfo(restart=" + this.f29388a + ", isClientCalled=" + this.f29389b + ", whiteScreenCheck=" + this.f29390c + ')';
        }

        public h(boolean r1, boolean r2, boolean r3) {
            this.f29388a = r1;
            this.f29389b = r2;
            this.f29390c = r3;
        }

        public /* synthetic */ h(boolean r2, boolean r3, boolean r4, int r5, d.h.b.h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = false;
        L11:
            this(r2, r3, r4);
        }

        public final boolean a() {
            return this.f29388a;
        }

        public final boolean b() {
            return this.f29389b;
        }

        public final boolean c() {
            return this.f29390c;
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f29394d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
            return false;
        L8:
            i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29391a, r6.f29391a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29392b, r6.f29392b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29393c, r6.f29393c) == true) goto L18;
            return false;
        L18:
            if (this.f29394d == r6.f29394d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f29391a.hashCode() * 31) + this.f29392b.hashCode()) * 31) + this.f29393c.hashCode()) * 31) + Integer.hashCode(this.f29394d);
        }

        public String toString() {
            return "ShortcutOpenContext(stepId=" + this.f29391a + ", targetAppName=" + this.f29392b + ", hostPackageName=" + this.f29393c + ", loopNumber=" + this.f29394d + ')';
        }

        public i(String r2, String r3, String r4, int r5) {
            o.e(r2, "stepId");
            o.e(r3, "targetAppName");
            o.e(r4, "hostPackageName");
            this.f29391a = r2;
            this.f29392b = r3;
            this.f29393c = r4;
            this.f29394d = r5;
        }

        public final String a() {
            return this.f29391a;
        }

        public final String b() {
            return this.f29392b;
        }

        public final String c() {
            return this.f29393c;
        }

        public final int d() {
            return this.f29394d;
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    @d.c.b.a.f(b = "OpOpenApp.kt", c = {608, 613}, d = "interceptUserDefinedAccess", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f29399e;
        int f;

        j(a r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29399e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f29398d = r7;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f29399e, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    @d.c.b.a.f(b = "OpOpenApp.kt", c = {817}, d = "isInWhiteScreen", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f29403d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29404e;

        k(a r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29403d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29402c = r3;
            this.f29404e |= Integer.MIN_VALUE;
            return a.a(this.f29403d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    @d.c.b.a.f(b = "OpOpenApp.kt", c = {BizStatus.StatusChangedReason.PAUSED__STARTED_MANUAL_OPERATING}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp$maybePauseDueToUserInterrupt$1")
    static final class l extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f29406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f29407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f29408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f29409e;

        l(String r3, com.obric.autogui.session.a r4, String r5, String r6, d.c.d<? super l> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29406b = r3;
            this.f29407c = r4;
            this.f29408d = r5;
            this.f29409e = r6;
            super(1, r8);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((l) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r9) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f29406b, this.f29407c, this.f29408d, this.f29409e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29405a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L41:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            int r4 = 0;
            DisplayedAppInfo r5 = null;
            Object r6 = null;
            Collection r11 = IAutoActionVDApi.DefaultImpls.fetchMdTopAppInfo$default((IAutoActionVDApi) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE, IAutoActionVDApi.class, "com.obric.aiagent.plugin"), 2, false, 2, null);
            if (r11 == null) goto L32;
            Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
            String r2 = this.f29406b;
            Iterator r13 = r12.iterator();
        L12:
            if (r13.hasNext() == false) goto L30;
            Object r7 = r13.next();
            DisplayedAppInfo r8 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r7, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
            ComponentName r9 = r8.getTopActivity();
            if (r9 == null) goto L16;
            String r14 = r9.getPackageName();
        L18:
            if (o.a(r14, r2) == true) goto L27;
            ComponentName r15 = r8.getRealActivity();
            if (r15 == null) goto L22;
            String r16 = r15.getPackageName();
        L24:
            if (o.a(r16, r2) == true) goto L27;
            Object[] r17 = false;
        L28:
            if (r17 == false) goto L12;
            r6 = r7;
            goto L30
        L22:
            r16 = null;
        L27:
            r17 = true;
            goto L28
        L16:
            r14 = null;
        L30:
            r5 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r6, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        L32:
            if (r5 == null) goto L34;
            r4 = r5.getTaskId();
        L34:
            VDTrackingApp r18 = new VDTrackingApp(r4, this.f29406b);
            Loog.INSTANCE.w(a.TAG, " - [OpenApp] launching USER_INTERRUPTED due to a delayed opening for package: " + r18);
            this.f29407c.F().put("op_openapp_pending_open", r18);
            com.obric.autogui.session.state.a.m r19 = (com.obric.autogui.session.state.a.m) ZeusTransformUtils.preCheckCast(this.f29407c.m().a(BizStatus.USER_INTERRUPTED), com.obric.autogui.session.state.a.m.class, "com.obric.aiagent.plugin");
            if (r19 == null) goto L37;
            String r3 = this.f29408d;
            String r20 = this.f29409e;
            r19.a(r3);
            r19.b(r20);
        L37:
            com.obric.autogui.session.state.b r110 = this.f29407c.m();
            BizStatus r21 = BizStatus.USER_INTERRUPTED;
            BizStatus.StatusChangedReasonStruct r22 = BizStatus.StatusChangedReasonStruct.Companion.getDEFAULT();
            d.c.d<? super com.obric.autogui.common.e> r23 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29405a = 1;
            if (r110.a(r21, r22, r23) != r0) goto L41;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    @d.c.b.a.f(b = "OpOpenApp.kt", c = {312}, d = "openAppInternal", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29413d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29414e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        m(a r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return a.a(this.h, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpOpenApp.kt */
    @d.c.b.a.f(b = "OpOpenApp.kt", c = {236, 266}, d = "operateSingleton", e = "com.obric.autogui.operator.impl.op.openapp.OpOpenApp")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f29419e;
        int f;

        n(a r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29419e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29418d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f29419e.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private static final String a(String r0) {
        return r0;
    }

    private static final String c() {
        return "OpenApp failed.";
    }

    private static final String d() {
        return "[isInWhiteScreen] no wait step";
    }

    private static final String e() {
        return "[isInWhiteScreen] activityNames is empty or not distinct";
    }

    private static final String f() {
        return "[isInWhiteScreen] first wait step is not StandardModelBaseStep";
    }

    private static final String g() {
        return "[isInWhiteScreen] failed to get current screenshot";
    }

    private static final String h() {
        return "[isInWhiteScreen] failed to get first step screenshot";
    }

    private static final String i() {
        return "[isInWhiteScreen] screenshots are not similar, not white screen";
    }

    private static final String j() {
        return "[isInWhiteScreen] screenshots are not white screen by analysis, not white screen";
    }

    public static /* synthetic */ String lambda$0R8R2h2h5F3J6cCjEEKIqqH2sHY() {
        return c();
    }

    public static /* synthetic */ String lambda$1p5a64nsykK1cPSlap61f5NsOUs() {
        return e();
    }

    public static /* synthetic */ x lambda$FTRybs4UwC6Dkh4YO6hLDRKF34Y(int r0, Bundle r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$KQTnMlgXYMBhZhCSShs6kpugB2I() {
        return i();
    }

    public static /* synthetic */ String lambda$_XhxRS6YxsWY5bzGliCqs1tJAQE() {
        return j();
    }

    public static /* synthetic */ String lambda$aTtkLliltwacIQMoAQcSJfeaqPI() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$bcK5Oi4YKJ1g8hscMX_mdTb-5LA, reason: not valid java name */
    public static /* synthetic */ String m826lambda$bcK5Oi4YKJ1g8hscMX_mdTb5LA() {
        return f();
    }

    public static /* synthetic */ String lambda$c6ExSxdIaQvTURAx51y1cqL19rs(String r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$gNi1Ub1_QrKM02EnlGg0_65yfTg() {
        return d();
    }

    /* JADX INFO: renamed from: lambda$iENychHXJKUPT1kIWEi6-byX-ew, reason: not valid java name */
    public static /* synthetic */ String m827lambda$iENychHXJKUPT1kIWEi6byXew(ComponentName r0, List r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ymlEXyr3054w-EFKZhthiyVObnE, reason: not valid java name */
    public static /* synthetic */ String m828lambda$ymlEXyr3054wEFKZhthiyVObnE() {
        return h();
    }

    public a() {
        this.f29347e = -1;
        this.f = p.b(new f[]{new g(this), new e(this), new d(this)});
    }

    public static final /* synthetic */ com.obric.autogui.common.d a(a r0, String r1, String r2, String r3) {
        return r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ com.obric.autogui.operator.e a(a r0) {
        return r0.f29346d;
    }

    public static final /* synthetic */ Object a(a r9, Context r10, AOOperatingSpace r11, b r12, String r13, String r14, d.c.d r15) {
        return r9.a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r11, AOOperatingSpace.class, "com.obric.aiagent.plugin"), r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, Context r3, b r4, d.c.d r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r8, Context r9, b r10, String r11, String r12, d.c.d r13) {
        return r8.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), r10, r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, Context r3, d.c.d r4) {
        return r2.d((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, boolean r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ int b(a r0) {
        return r0.f29347e;
    }

    static {
        f29344b = new C0751a(null);
        Uri r0 = Uri.parse("content://com.obric.browser.webcapability");
        o.c(r0, "parse(...)");
        g = r0;
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L6;
        return false;
    L6:
        this.f29345c = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        return true;
    }

    @Override // com.obric.autogui.operator.b
    public void a(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        super.a(r2);
        this.f29346d = r2;
    }

    @Override // com.obric.autogui.operator.b
    public void b(com.obric.autogui.operator.e r5) {
        o.e(r5, "step");
        super.b(r5);
        Loog r0 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("[ShortcutBLTrace] unbind OpenApp: boundStepId=");
        com.obric.autogui.operator.e r2 = this.f29346d;
        if (r2 == null) goto L5;
        String r3 = r2.W();
    L6:
        StringBuilder r6 = r1.append(r3).append(", requestedStepId=").append(r5.W()).append(", executionLoop=").append(this.f29347e).append(", resumedCount=");
        com.obric.autogui.session.a r4 = com.obric.autogui.session.c.f30777a.b();
        if (r4 == null) goto L11;
        AtomicInteger r7 = r4.N();
        if (r7 == null) goto L11;
        Integer r8 = Integer.valueOf(r7.get());
    L12:
        r0.i(TAG, r6.append(r8).toString());
        this.f29346d = null;
        this.f29347e = -1;
        return;
    L11:
        r8 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.obric.autogui.operator.a.b
    public Object b(Context r20, d.c.d<? super com.obric.autogui.operator.c> r21) {
        a r0 = this;
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, n.class) == false) goto L7;
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f29418d;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r4.f29415a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L70:
        com.obric.autogui.operator.a.b.a.c r8 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        h r9 = r2.g();
        if (r9 != null) goto L73;
    L75:
        boolean r10 = false;
    L76:
        if (r10 == false) goto L85;
        if (r2.g().b() == false) goto L85;
        if (r8.a().c() == false) goto L85;
        if (com.obric.autogui.common.a.d.f28974a.S() == false) goto L85;
        AppErrorTracker.INSTANCE.recordAppRestart(r2.c(), r2.b(), r2.a());
    L85:
        return new c(r8, r2);
    L73:
        if (r9.a() != true) goto L75;
        r10 = true;
        goto L76
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b r11 = (b) ZeusTransformUtils.preCheckCast(r4.f29417c, b.class, "com.obric.aiagent.plugin");
        r1 = (Context) ZeusTransformUtils.preCheckCast(r4.f29416b, Context.class, "com.obric.aiagent.plugin");
        a r12 = (a) ZeusTransformUtils.preCheckCast(r4.f29415a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        b r13 = r11;
        r0 = r12;
        Object r14 = r5;
    L57:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L61;
        Loog.INSTANCE.i(TAG, "not white screen");
        return new c(new com.obric.autogui.operator.a.b.a.c(null, null, "WhiteScreenCheckFailed", null, null, false, null, 123, null), r13);
    L61:
        if (r13.g().b() == true) goto L63;
    L66:
        r4.f29415a = r13;
        r4.f29416b = null;
        r4.f29417c = null;
        r4.f = 2;
        Object r15 = r0.a(r1, r13, r4);
        if (r15 != r6) goto L69;
        return r6;
    L69:
        b r18 = r13;
        r5 = r15;
        r2 = r18;
        goto L70
    L63:
        if (AppErrorTracker.INSTANCE.getAppRestartTimes(r13.c(), r13.b(), r13.a()) < com.obric.autogui.common.a.d.f28974a.Q()) goto L66;
        Loog.INSTANCE.i(TAG, "app restart times exceeded");
        com.obric.autogui.operator.a.b.a.b r16 = com.obric.autogui.operator.a.b.a.b.i;
        String r17 = r1.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_app_restart_times_exceeded, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_app_restart_times_exceeded"));
        o.c(r17, "getString(...)");
        return new c(new com.obric.autogui.operator.a.b.a.c(r16, r17, "AppRestartTimesExceeded", null, null, false, null, 120, null), r13);
    L16:
        d.o.a(r5);
        AppErrorTracker.INSTANCE.clearCurrentError();
        r13 = r0.f29345c;
        if (r13 == null) goto L19;
        com.obric.autogui.session.a r19 = com.obric.autogui.session.c.f30777a.b();
        if (r19 == null) goto L25;
        AtomicInteger r110 = r19.N();
        if (r110 == null) goto L25;
        int r111 = r110.get();
    L26:
        r0.f29347e = r111;
        if (r19 == null) goto L31;
        Map<String, Object> r112 = r19.F();
        if (r112 == null) goto L31;
        Object r113 = r112.remove("op_openapp_shortcut_open_context");
    L32:
        Loog r114 = Loog.INSTANCE;
        StringBuilder r22 = new StringBuilder().append("[ShortcutBLTrace] operate OpenApp: stepId=");
        com.obric.autogui.operator.e r115 = r0.f29346d;
        if (r115 == null) goto L35;
        String r116 = r115.W();
    L36:
        StringBuilder r23 = r22.append(r116).append(", executionLoop=").append(r0.f29347e).append(", currentStepId=");
        if (r19 == null) goto L41;
        com.obric.autogui.operator.e r24 = r19.r();
        if (r24 == null) goto L41;
        String r25 = r24.W();
    L42:
        r114.i(TAG, r23.append(r25).append(", appName=").append(r13.c()).append(", packageName=").append(r13.b()).append(", clearedContext=").append(r113).toString());
        h r26 = r13.g();
        if (r26 != null) goto L45;
    L47:
        boolean r27 = false;
    L48:
        if (r27 == false) goto L66;
        boolean r28 = com.obric.autogui.common.a.d.f28974a.S();
        Loog.INSTANCE.i(TAG, " - [Restart] settings_enable:" + r28 + ", isClientCalled:" + r13.g().b());
        if (r28 == false) goto L66;
        if (r13.g().c() == false) goto L61;
        r4.f29415a = r0;
        r4.f29416b = r1;
        r4.f29417c = r13;
        r4.f = 1;
        r14 = r0.d(r1, r4);
        if (r14 != r6) goto L57;
        return r6;
    L45:
        if (r26.a() != true) goto L47;
        r27 = true;
    L41:
        r25 = null;
        goto L42
    L35:
        r116 = null;
    L31:
        r113 = null;
    L25:
        r111 = -1;
        goto L26
    L19:
        return new com.obric.autogui.operator.h(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), "openApp input invalid", "open_app_input_invalid");
    L7:
        r4 = new n(r0, r3);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00f6 -> B:25:0x00fc). Please report as a decompilation issue!!! */
    private final Object a(Context r25, b r26, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r27) {
        a r0 = this;
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, m.class) == false) goto L7;
        m r4 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");
        if ((r4.i & Integer.MIN_VALUE) == 0) goto L7;
        r4.i -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.g;
        Object r6 = d.c.a.b.a();
        int r7 = r4.i;
        com.obric.autogui.operator.a.b.a.b r8 = null;
        ComponentName r9 = null;
        boolean r10 = true;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        Iterator<f> r2 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f, Iterator.class, "com.obric.aiagent.plugin");
        DisplayedAppInfo r11 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r4.f29414e, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r12 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r4.f29413d, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        b r13 = (b) ZeusTransformUtils.preCheckCast(r4.f29412c, b.class, "com.obric.aiagent.plugin");
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(r4.f29411b, Context.class, "com.obric.aiagent.plugin");
        a r15 = (a) ZeusTransformUtils.preCheckCast(r4.f29410a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        Iterator<f> r16 = r2;
        r0 = r15;
        AOOperatingSpace r17 = r12;
        DisplayedAppInfo r18 = r11;
        b r19 = r13;
    L25:
        com.obric.autogui.operator.a.b.a.c r20 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r20.a().c() == false) goto L29;
    L30:
        com.obric.autogui.operator.a.b.a.c r110 = r20;
        Context r21 = r14;
    L33:
        if (r110 == null) goto L39;
        com.obric.autogui.operator.a.b.a.b r22 = r110.a();
        if (r22 == null) goto L39;
        if (r22.c() != true) goto L39;
        Object[] r23 = true;
    L40:
        if (r23 == false) goto L56;
        r0.a(r21, r110);
        String r24 = r110.d();
        CharSequence r28 = (CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin");
        if (r28 != null) goto L44;
    L47:
        if (r10 == false) goto L49;
    L54:
        return r110;
    L49:
        if (r110.a() == com.obric.autogui.operator.a.b.a.b.k) goto L54;
        AppErrorTracker r29 = AppErrorTracker.INSTANCE;
        if (r18 == null) goto L53;
        r9 = r18.getTopActivity();
    L53:
        r29.checkOpenSuccess(r21, r9, r24);
        goto L54
    L44:
        if (d.o.o.d(r28) == true) goto L47;
        r10 = false;
        goto L47
    L56:
        if (r19.f() == true) goto L58;
        if (r110 == null) goto L62;
        r8 = r110.a();
    L62:
        if (r8 != com.obric.autogui.operator.a.b.a.b.f29448d) goto L67;
        String r30 = r110.d();
        if (r30 == null) goto L67;
        Loog.INSTANCE.w(TAG, "Paused due to user-interrupt: pkg=" + r30);
        r0.a(r21, r30, r110.b());
        return r110;
    L67:
        final String r31 = "OpenApp failed; reason=" + r110;
        Loog.INSTANCE.ep(TAG, new $$Lambda$a$c6ExSxdIaQvTURAx51y1cqL19rs(r31), $$Lambda$a$0R8R2h2h5F3J6cCjEEKIqqH2sHY.INSTANCE);
        if (r110 == null) goto L70;
        return r110;
    L70:
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29446b, null, "openApp noOpener", null, null, false, null, 122, null);
    L58:
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29445a, null, "openApp returnToLauncher", null, null, false, null, 122, null);
    L39:
        r23 = false;
        goto L40
    L29:
        if (r20.e() == false) goto L30;
        AOOperatingSpace r210 = r17;
        r110 = r20;
        r21 = r14;
        AOOperatingSpace r111 = r210;
    L20:
        if (r16.hasNext() == false) goto L33;
        f r112 = (f) ZeusTransformUtils.preCheckCast(r16.next(), f.class, "com.obric.aiagent.plugin");
        r4.f29410a = r0;
        r4.f29411b = r21;
        r4.f29412c = r19;
        r4.f29413d = r111;
        r4.f29414e = r18;
        r4.f = r16;
        r4.i = 1;
        Object r113 = r112.a(r21, r111, r19, r4);
        if (r113 != r6) goto L24;
        return r6;
    L24:
        AOOperatingSpace r211 = r111;
        r14 = r21;
        r5 = r113;
        r17 = r211;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        AOOperatingSpace r32 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r32 != null) goto L18;
        Loog.INSTANCE.e(TAG, "[OpenApp] --> No active space to run OpenApp.");
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.l, null, "NoActiveSpace", null, null, false, null, 122, null);
    L18:
        r18 = r32.fetchTopDisplayed();
        r16 = r0.f.iterator();
        r111 = r32;
        r110 = null;
        r21 = r1;
        r19 = r26;
    L7:
        r4 = new m(r0, r3);
        goto L8
    }

    private final Object a(Context r9, AOOperatingSpace r10, b r11, String r12, String r13, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r4 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r10, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.operator.a.b.a.c> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == false) goto L13;
        return null;
    L13:
        if (r4.getType() != AOOperatingSpace.SpaceType.ComputerControl) goto L17;
        return a(r3, r4, r11, r12, r13);
    L17:
        return a(r3, r11, r12, r13, r7);
    L5:
        if (d.o.o.d(r15) == true) goto L8;
        r16 = false;
        goto L9
    }

    private final com.obric.autogui.operator.a.b.a.c a(Context r27, AOOperatingSpace r28, b r29, String r30, String r31) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r27, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r1 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r28, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, CCSpace.class) == false) goto L5;
        CCSpace r2 = (CCSpace) ZeusTransformUtils.preCheckCast(r1, CCSpace.class, "com.obric.aiagent.plugin");
    L7:
        if (r2 != null) goto L10;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_access_request", "InvalidCCSpace", com.obric.autogui.session.c.f30777a.b(), null, null, "PULL", null, r30, null, null, null, 1880, null);
        Loog.INSTANCE.e("CCAppAccess", "event=access_request_failed origin=PULL packageName=" + r30 + " reason=InvalidCCSpace");
        return a(r30, r31, "InvalidCCSpace");
    L10:
        Loog.INSTANCE.i("CCAppAccess", "event=access_request_start origin=PULL packageName=" + r30 + " reasonTag=" + r31);
        CCDataResult<CCApplicationAccessResult> r9 = AOPlatformTools.INSTANCE.computerControl().requestApplicationAccess(r2.getSessionAccessor(), r30);
        if (ZeusTransformUtils.instanceOf(r9, CCDataResult.Success.class) == false) goto L24;
        CCApplicationAccessResult r17 = (CCApplicationAccessResult) ZeusTransformUtils.preCheckCast(((CCDataResult.Success) ZeusTransformUtils.preCheckCast(r9, CCDataResult.Success.class, "com.obric.aiagent.plugin")).getData(), CCApplicationAccessResult.class, "com.obric.aiagent.plugin");
        if (r17.getState() != CCApplicationAccessState.Unknown) goto L15;
        String r21 = "CCAppAccess";
        Context r0 = r12;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_access_callback", "UnknownAccessState", com.obric.autogui.session.c.f30777a.b(), r2.getSessionAccessor(), null, "PULL", null, r30, r17.getState(), Integer.valueOf(r17.getRawValue()), null, 1104, null);
    L16:
        a(r17.getState(), r30, a(r0, r29, r30));
        String r13 = r21;
        Loog.INSTANCE.i(r13, "event=access_sync_result origin=PULL packageName=" + r30 + " state=" + r17.getState() + " rawValue=" + r17.getRawValue());
        if (r17.getState() != CCApplicationAccessState.DeniedBlacklist) goto L20;
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(new ComponentName(r30, "ComputerControlSystemBlacklist"), AppBlackListState.SoftBlackList, 0, 0, false, 28, null));
        Loog.INSTANCE.i(r13, "event=system_blacklist_clarify_scheduled origin=PULL packageName=" + r30);
    L20:
        if (r17.getState() != CCApplicationAccessState.Granted) goto L29;
        return null;
    L29:
        return a(r30, r31, r17.getState().name());
    L15:
        r21 = "CCAppAccess";
        r0 = r12;
        goto L16
    L24:
        if (ZeusTransformUtils.instanceOf(r9, CCDataResult.Failed.class) == false) goto L28;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_access_request", ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r9, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getReason().name(), com.obric.autogui.session.c.f30777a.b(), r2.getSessionAccessor(), null, "PULL", null, r30, null, null, ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r9, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable(), 848, null);
        Loog.INSTANCE.w("CCAppAccess", "event=access_request_failed origin=PULL packageName=" + r30 + " reason=" + ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r9, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getReason(), ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r9, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable());
        return a(r30, r31, ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r9, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getReason().name());
    L28:
        throw new d.k();
    L5:
        r2 = null;
        goto L7
    }

    private final void a(CCApplicationAccessState r3, String r4, String r5) {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3 != CCApplicationAccessState.Pending) goto L9;
        r0.E().a("computer_control_apply_app_permission", r5);
        Loog.INSTANCE.i("CCAppAccess", "event=client_risky_operation_changed origin=PULL packageName=" + r4 + " active=true value=computer_control_apply_app_permission computer_control_apply_app_name=" + r5);
        return;
    L9:
        a(r4, "SYNC_" + r3.name());
    }

    private final String a(Context r5, b r6, String r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        String r8 = r6.c();
        boolean r9 = true;
        if (r8 == null) goto L12;
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r10 == null) goto L12;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L13:
        if (r10 == null) goto L15;
        return r10;
    L15:
        AppInfoEntry r11 = AOPackagesTools.INSTANCE.getAppInfo(r4, r7);
        if (r11 == null) goto L30;
        CharSequence r12 = r11.getAppLabel();
        if (r12 == null) goto L31;
        String r13 = r12.toString();
        if (r13 == null) goto L32;
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r14 != null) goto L24;
        return null;
    L24:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L27;
        r9 = false;
    L27:
        if (r9 == true) goto L29;
        return null;
    L29:
        return r14;
    L32:
        return null;
    L31:
        return null;
    L30:
        return null;
    L9:
        r3 = false;
    L12:
        r10 = null;
        goto L13
    }

    private final void a(String r3, String r4) {
        com.obric.autogui.session.a r2 = com.obric.autogui.session.c.f30777a.b();
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.E().a("computer_control_apply_app_permission") == true) goto L8;
        return;
    L8:
        Loog.INSTANCE.i("CCAppAccess", "event=client_risky_operation_changed origin=PULL packageName=" + r3 + " active=false source=" + r4);
    }

    private final com.obric.autogui.operator.a.b.a.c a(String r11, String r12, String r13) {
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29449e, null, "CCAccess/" + r13 + '/' + r12, null, r11, false, null, 74, null);
    }

    private final Object a(Context r23, b r24, String r25, String r26, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r27) {
        String r0 = r25;
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, j.class) == false) goto L7;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f29398d;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f;
        boolean r10 = true;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.f29396b, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.f29395a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        String r15 = r8;
    L32:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L34;
        return null;
    L34:
        Loog.INSTANCE.e(TAG, "Record-set add blocked OpenApp; pkg=" + r15 + ", source=" + r2);
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29446b, null, "RecordSetAddFailed/" + r2, null, r15, false, null, 74, null);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.f29397c, String.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r4.f29396b, String.class, "com.obric.aiagent.plugin");
        b r12 = (b) ZeusTransformUtils.preCheckCast(r4.f29395a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        b r13 = r12;
        String r14 = r9;
        r0 = r11;
    L20:
        com.obric.autogui.agents.vlm.models.impl.applist.black.j.d r16 = (com.obric.autogui.agents.vlm.models.impl.applist.black.j.d) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.impl.applist.black.j.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.applist.black.j.e r17 = com.obric.autogui.agents.vlm.models.impl.applist.black.j.e.f27428a;
        if (r16.a() == true) goto L23;
    L25:
        r10 = false;
    L26:
        if (r10 == false) goto L36;
        com.obric.autogui.agents.vlm.models.impl.applist.black.p r18 = com.obric.autogui.agents.vlm.models.impl.applist.black.p.f27502a;
        r4.f29395a = r0;
        r4.f29396b = r14;
        r4.f29397c = null;
        r4.f = 2;
        r5 = r18.a(r0, r4);
        if (r5 != r6) goto L30;
        return r6;
    L30:
        r15 = r0;
        r2 = r14;
        goto L32
    L36:
        com.obric.autogui.session.a r19 = com.obric.autogui.session.c.f30777a.b();
        if (r19 != null) goto L40;
        Loog.INSTANCE.w(TAG, "Auth blocked but session is null");
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29449e, null, "NotAuthorized/" + r14, null, r0, false, null, 74, null);
    L40:
        r19.F().put("op_openapp_pending_auth", b.a(r13, null, r0, null, null, null, false, null, 125, null));
        com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.a(r0);
        Loog.INSTANCE.i(TAG, "Auth blocked; pkg=" + r0);
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29449e, null, "NotAuthorized/" + r14, null, r0, false, null, 74, null);
    L23:
        if (r16.b() != r17) goto L25;
    L16:
        d.o.a(r5);
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r20 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.a(r1);
        r4.f29395a = r24;
        r4.f29396b = r0;
        r14 = r26;
        r4.f29397c = r14;
        r4.f = 1;
        Object r21 = r20.a(r0, r4);
        if (r21 != r6) goto L19;
        return r6;
    L19:
        r13 = r24;
        r5 = r21;
    L7:
        r4 = new j(this, r3);
        goto L8
    }

    private final void a(Context r17, com.obric.autogui.operator.a.b.a.c r18) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        Loog r3 = Loog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("[ShortcutBLTrace] OpenApp performed: reason=").append(r18.a()).append(", opener=");
        com.obric.autogui.operator.a.b.a.b.a r5 = r18.f();
        CharSequence r6 = null;
        if (r5 == null) goto L7;
        Class<?> r7 = r5.getClass();
        if (r7 == null) goto L7;
        String r8 = r7.getSimpleName();
    L8:
        StringBuilder r9 = r4.append(r8).append(", stepId=");
        com.obric.autogui.operator.e r10 = this.f29346d;
        if (r10 == null) goto L11;
        String r11 = r10.W();
    L12:
        StringBuilder r12 = r9.append(r11).append(", executionLoop=").append(this.f29347e).append(", currentStepId=");
        com.obric.autogui.session.a r13 = com.obric.autogui.session.c.f30777a.b();
        if (r13 == null) goto L17;
        com.obric.autogui.operator.e r14 = r13.r();
        if (r14 == null) goto L17;
        String r15 = r14.W();
    L18:
        StringBuilder r16 = r12.append(r15).append(", resumedCount=");
        com.obric.autogui.session.a r19 = com.obric.autogui.session.c.f30777a.b();
        if (r19 == null) goto L23;
        AtomicInteger r20 = r19.N();
        if (r20 == null) goto L23;
        Integer r21 = Integer.valueOf(r20.get());
    L24:
        r3.i(TAG, r16.append(r21).toString());
        com.obric.autogui.operator.a.b.a.b.a r22 = r18.f();
        if (ZeusTransformUtils.instanceOf(r22, com.obric.autogui.operator.a.b.a.b.f.class) == false) goto L27;
        com.obric.autogui.operator.a.b.a.b.f r23 = (com.obric.autogui.operator.a.b.a.b.f) ZeusTransformUtils.preCheckCast(r22, com.obric.autogui.operator.a.b.a.b.f.class, "com.obric.aiagent.plugin");
    L28:
        boolean r24 = true;
        if (r23 == null) goto L43;
        String r25 = r23.d();
        if (r25 == null) goto L43;
        String r26 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r26 == null) goto L43;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L37;
        boolean r27 = true;
    L38:
        if (r27 == true) goto L41;
        r26 = null;
    L41:
        if (r26 == null) goto L43;
        b(r26, r23.c());
        goto L43
    L37:
        r27 = false;
    L43:
        ComponentName r28 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        if (r28 == null) goto L46;
        String r29 = r28.getPackageName();
    L47:
        a(r1, r29);
        String r30 = r18.d();
        if (r30 == null) goto L50;
        AOPackagesTools.INSTANCE.prefetchAppSignAndMd5(r1, r30);
    L50:
        com.obric.autogui.session.a r31 = com.obric.autogui.session.c.f30777a.b();
        if (r31 == null) goto L53;
        final int r32 = r31.D().getInt("openapp_times", 0) + 1;
        Loog.INSTANCE.i(TAG, " - [OPEN-APP] count=" + r32);
        r31.D().putInt("openapp_times", r32);
        r31.J().a(new $$Lambda$a$FTRybs4UwC6Dkh4YO6hLDRKF34Y(r32));
    L53:
        if (r31 == null) goto L80;
        IAutoActionTrackingApi r33 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r110 = new JSONObject();
        b r34 = this.f29345c;
        if (r34 == null) goto L57;
        String r35 = r34.c();
    L58:
        r110.put(IBdInstall.PARAM_APP_NAME, r35);
        r110.put("app_package", r18.d());
        String r36 = r18.c();
        if (r36 != null) goto L61;
    L63:
        r24 = false;
    L64:
        if (r24 == false) goto L66;
        String r37 = r18.c();
    L67:
        r110.put(MemorySourceLinkType.DEEPLINK, r37);
        com.obric.autogui.session.c.b.a(r110, r31);
        x r38 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r33, "opened_app", r110, false, false, null, 28, null);
        b r0 = this.f29345c;
        if (r0 == null) goto L70;
        String r2 = r0.c();
    L72:
        if (r18.d() == null) goto L77;
        AppInfoEntry r39 = AOPackagesTools.INSTANCE.getAppInfo(r1, r18.d());
        if (r39 == null) goto L76;
        r6 = r39.getAppLabel();
    L76:
        String r40 = String.valueOf(r6);
    L78:
        IAutoActionTrackingApi r41 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r42 = new JSONObject();
        r42.put("operate_type_lv1", r18.a().b());
        r42.put("operate_type_lv2", "");
        r42.put("package_name", r18.d());
        r42.put("target_app_name", r2);
        r42.put("actual_app_name", r40);
        r42.put("extra", r18.c());
        r42.put(DBHelper.COL_TIME, System.currentTimeMillis());
        com.obric.autogui.session.c.b.a(r42, r31);
        x r43 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r41, "oauto_operate_app", r42, false, false, null, 28, null);
        return;
    L77:
        r40 = SensitiveType.UNKNOWN;
        goto L78
    L70:
        r2 = null;
        goto L72
    L66:
        r37 = null;
        goto L67
    L61:
        if (d.o.o.b(r36, "dlOpened", false, 2, null) != true) goto L63;
    L57:
        r35 = null;
        goto L58
    L80:
        return;
    L46:
        r29 = null;
        goto L47
    L27:
        r23 = null;
    L23:
        r21 = null;
    L17:
        r15 = null;
        goto L18
    L11:
        r11 = null;
    L7:
        r8 = null;
        goto L8
    }

    private static final x a(int r1, Bundle r2) {
        o.e(r2, "$this$withTaskEndReports");
        r2.putInt("openapp_times", r1);
        return x.f38692a;
    }

    private final void b(String r5, String r6) {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.autogui.operator.e r2 = this.f29346d;
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.W();
    L9:
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        i r1 = new i(r4, r5, r6, this.f29347e);
        r0.F().put("op_openapp_shortcut_open_context", r1);
        Loog r7 = Loog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("[ShortcutBLTrace] record shortcut context: context=").append(r1).append(", currentStepId=");
        com.obric.autogui.operator.e r9 = r0.r();
        if (r9 == null) goto L14;
        r3 = r9.W();
    L14:
        r7.i(TAG, r8.append(r3).append(", resumedCount=").append(r0.N().get()).toString());
        return;
    L8:
        r4 = null;
        goto L9
    }

    private final Object d(Context r19, d.c.d<? super Boolean> r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, k.class) == false) goto L7;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin");
        if ((r4.f29404e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f29404e -= Integer.MIN_VALUE;
    L8:
        k r10 = r4;
        Object r5 = r10.f29402c;
        Object r6 = d.c.a.b.a();
        int r7 = r10.f29404e;
        Bitmap r13 = null;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        com.obric.autogui.operator.e r0 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r10.f29401b, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(r10.f29400a, List.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L113:
        IScreenshot r8 = ((ScreenshotResult) ZeusTransformUtils.preCheckCast(r5, ScreenshotResult.class, "com.obric.aiagent.plugin")).getPic();
        if (r8 != null) goto L117;
        Loog.INSTANCE.dp(TAG, $$Lambda$a$aTtkLliltwacIQMoAQcSJfeaqPI.INSTANCE);
        return d.c.b.a.b.a(false);
    L117:
        com.obric.autogui.agents.vlm.models.a.a.b r9 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).n();
        if (r9 == null) goto L122;
        IScreenshot r11 = r9.a();
        if (r11 == null) goto L122;
        r13 = r11.getBitmap();
    L122:
        if (r13 != null) goto L126;
        Loog.INSTANCE.dp(TAG, $$Lambda$a$ymlEXyr3054wEFKZhthiyVObnE.INSTANCE);
        r8.release();
        return d.c.b.a.b.a(r12);
    L126:
        if (AOImageUtil.INSTANCE.isSimilarByDHash(r13, r8.getBitmap(), com.obric.autogui.common.a.d.f28974a.N()) == true) goto L129;
        Loog.INSTANCE.dp(TAG, $$Lambda$a$KQTnMlgXYMBhZhCSShs6kpugB2I.INSTANCE);
        r8.release();
        return d.c.b.a.b.a(r12);
    L129:
        boolean r12 = com.obric.autogui.util.i.f31571a.a(r8.getBitmap());
        r8.release();
        if (r12 == true) goto L133;
        Loog.INSTANCE.dp(TAG, $$Lambda$a$_XhxRS6YxsWY5bzGliCqs1tJAQE.INSTANCE);
        return d.c.b.a.b.a(r12);
    L133:
        Loog.INSTANCE.i(TAG, "[isInWhiteScreen] detected white screen by image similarity, activity: " + ((String) ZeusTransformUtils.preCheckCast(p.k(r2), String.class, "com.obric.aiagent.plugin")));
        return d.c.b.a.b.a(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        b r14 = this.f29345c;
        if (r14 == null) goto L17;
        h r15 = r14.g();
        if (r15 != null) goto L21;
    L23:
        boolean r16 = false;
    L24:
        if (r16 == false) goto L26;
        com.obric.autogui.session.a r17 = com.obric.autogui.session.c.f30777a.b();
        if (r17 == null) goto L138;
        List<com.obric.autogui.operator.e> r18 = r17.p();
        if (r18 == null) goto L138;
        ArrayList r21 = new ArrayList();
        Iterator r22 = p.l((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L34:
        if (r22.hasNext() == false) goto L70;
        com.obric.autogui.operator.e r23 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r22.next(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23.Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r24, Collection.class) == true) goto L38;
    L40:
        Iterator r25 = r24.iterator();
    L42:
        if (r25.hasNext() == false) goto L39;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r25.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L46;
        boolean r26 = true;
    L47:
        if (r26 == false) goto L42;
        boolean r27 = true;
    L49:
        if (r27 == true) goto L70;
        if ((!r23.Q().isEmpty()) == false) goto L70;
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(r23.Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r28, Collection.class) == true) goto L56;
    L58:
        Iterator r29 = r28.iterator();
    L60:
        if (r29.hasNext() == false) goto L57;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r29.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29872d) goto L64;
        boolean r30 = true;
    L65:
        if (r30 == true) goto L60;
        boolean r31 = false;
    L67:
        if (r31 == false) goto L70;
        r21.add(0, r23);
        goto L34
    L64:
        r30 = false;
    L57:
        r31 = true;
        goto L67
    L56:
        if (((Collection) ZeusTransformUtils.preCheckCast(r28, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L58;
    L46:
        r26 = false;
    L39:
        r27 = false;
        goto L49
    L38:
        if (((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L40;
    L70:
        if (r21.isEmpty() == false) goto L73;
        Loog.INSTANCE.dp(TAG, $$Lambda$a$gNi1Ub1_QrKM02EnlGg0_65yfTg.INSTANCE);
        return d.c.b.a.b.a(false);
    L73:
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.aiagent.plugin");
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r34 = r32.iterator();
    L75:
        if (r34.hasNext() == false) goto L86;
        com.obric.autogui.operator.e r35 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r34.next(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r35, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L83;
        com.obric.autogui.agents.vlm.models.a.a.b r36 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r35, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).n();
        if (r36 == null) goto L83;
        ComponentName r37 = r36.b();
        if (r37 == null) goto L83;
        String r38 = r37.getClassName();
    L84:
        if (r38 == null) goto L75;
        r33.add(r38);
    L83:
        r38 = null;
        goto L84
    L86:
        final List r39 = (List) ZeusTransformUtils.preCheckCast(r33, List.class, "com.obric.aiagent.plugin");
        if (r39.isEmpty() == false) goto L89;
    L135:
        Loog.INSTANCE.dp(TAG, $$Lambda$a$1p5a64nsykK1cPSlap61f5NsOUs.INSTANCE);
        return d.c.b.a.b.a(false);
    L89:
        if (p.s((Iterable) ZeusTransformUtils.preCheckCast(r39, Iterable.class, "com.obric.aiagent.plugin")).size() != 1) goto L135;
        final ComponentName r40 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        if (r40 == null) goto L94;
        String r41 = r40.getClassName();
    L96:
        if (o.a(r41, p.k(r39)) == true) goto L99;
        Loog.INSTANCE.dp(TAG, new $$Lambda$a$iENychHXJKUPT1kIWEi6byXew(r40, r39));
        return d.c.b.a.b.a(false);
    L99:
        com.obric.autogui.operator.e r42 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(p.l((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin")), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r42, com.obric.autogui.agents.vlm.models.impl.g.class) == true) goto L103;
        Loog.INSTANCE.dp(TAG, $$Lambda$a$bcK5Oi4YKJ1g8hscMX_mdTb5LA.INSTANCE);
        return d.c.b.a.b.a(false);
    L103:
        com.obric.autogui.agents.vlm.models.a.a.b r43 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r42, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).n();
        if (r43 == null) goto L108;
        IScreenshot r44 = r43.a();
        if (r44 == null) goto L108;
        float r45 = r44.getScale();
    L109:
        com.obric.autogui.agents.vlm.models.a.a r46 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.a.g(r1, r45), com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        r10.f29400a = r39;
        r10.f29401b = r42;
        r10.f29404e = 1;
        Object r47 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r46, "WhiteScreen-Check", null, false, false, r10, 14, null);
        if (r47 != r6) goto L112;
        return r6;
    L112:
        r2 = r39;
        r0 = r42;
        r5 = r47;
    L108:
        r45 = 1.0f;
        goto L109
    L94:
        r41 = null;
    L138:
        return d.c.b.a.b.a(false);
    L26:
        return d.c.b.a.b.a(false);
    L21:
        if (r15.c() != true) goto L23;
        r16 = true;
        goto L24
    L17:
        return d.c.b.a.b.a(false);
    L7:
        r4 = new k(this, r3);
        goto L8
    }

    private static final String a(ComponentName r3, List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder().append("[isInWhiteScreen] currentTopActivity(");
        if (r3 == null) goto L5;
        String r6 = r3.getClassName();
    L7:
        return r0.append(r6).append(") is not (").append((String) ZeusTransformUtils.preCheckCast(p.k(r5), String.class, "com.obric.aiagent.plugin")).append(')').toString();
    L5:
        r6 = null;
        goto L7
    }

    private final void a(Context r13, String r14) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("operator.openapp.browser_switch_tablet.enable", true) == true) goto L7;
        Loog.INSTANCE.d(TAG, "openApp maybeSwitchBrowserToTablet: disabled by config");
        return;
    L7:
        if (o.a(r14, "com.obric.browser") == true) goto L22;
        return;
    L22:
        int r15 = AutoActionConfigs.INSTANCE.getIntCfg("operator.openapp.browser_switch_tablet.base_width", -1);     // Catch: Throwable -> L19
        Bundle r6 = new Bundle();     // Catch: Throwable -> L19
        if (r15 <= 0) goto L12;
        r6.putInt("baseWidth", r15);     // Catch: Throwable -> L19
    L12:
        ContentResolver r2 = r12.getContentResolver();     // Catch: Throwable -> L19
        Uri r16 = g;     // Catch: Throwable -> L19
        Bundle r3 = ZeusProviderTransform.call(r2, r16, "switch_tablet", null, r6, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r3 == null) goto L16;
        Boolean r4 = Boolean.valueOf(r3.getBoolean("success"));     // Catch: Throwable -> L19
    L17:
        Loog.INSTANCE.d(TAG, "openApp maybeSwitchBrowserToTablet: invoked " + r16 + ", success=" + r4);     // Catch: Throwable -> L19
        IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L19
        r7.put("package_name", r14);     // Catch: Throwable -> L19
        r7.put("success", r4);     // Catch: Throwable -> L19
        r7.put("base_width", r15);     // Catch: Throwable -> L19
        x r17 = x.f38692a;     // Catch: Throwable -> L19
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "open_browser_switch_tablet", r7, false, false, null, 28, null);     // Catch: Throwable -> L19
        return;
    L16:
        r4 = null;
    L19:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "openApp maybeSwitchBrowserToTablet failed: " + th);
    }

    private final com.obric.autogui.common.d<Intent> b(String r5, String r6, String r7) {
        Intent r4 = new Intent();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        r4.setClassName(r5, r6);
    L11:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == true) goto L19;
        r4.setAction(r7);
    L19:
        return com.obric.autogui.common.d.f29012a.a(r4);
    L14:
        if (d.o.o.d(r8) == false) goto L16;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void a(boolean r17, String r18) {
        com.obric.autogui.session.a r1 = com.obric.autogui.session.c.f30777a.b();
        if (r1 == null) goto L6;
        List<com.obric.autogui.operator.e> r2 = r1.p();
        if (r2 == null) goto L6;
    L7:
        Iterator r3 = p.l((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        boolean r5 = true;
        String r7 = null;
        if (r3.hasNext() == false) goto L26;
        com.obric.autogui.operator.e r4 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4.Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L13;
    L15:
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L14;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L17;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L8;
    L27:
        IAutoActionTrackingApi r12 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r13 = new JSONObject();
        if (r1 == null) goto L30;
        String r6 = r1.b();
    L31:
        r13.put("session_id", r6);
        if (r1 == null) goto L34;
        String r14 = r1.a();
    L35:
        r13.put("session_key", r14);
        if (r1 == null) goto L40;
        AutoOperateTask r15 = r1.l();
        if (r15 == null) goto L40;
        Integer r16 = Integer.valueOf(r15.getLaunchOrigin());
    L41:
        r13.put("session_origin", r16);
        com.obric.autogui.operator.e r19 = this.f29346d;
        if (r19 == null) goto L44;
        String r20 = r19.W();
    L45:
        r13.put("step_id", r20);
        if (r1 == null) goto L48;
        Integer r21 = Integer.valueOf(r1.s());
    L49:
        r13.put("step_index", r21);
        b r22 = this.f29345c;
        if (r22 == null) goto L52;
        String r23 = r22.c();
    L53:
        r13.put(IBdInstall.PARAM_APP_NAME, r23);
        r13.put("package_name", r18);
        b r24 = this.f29345c;
        if (r24 == null) goto L58;
        h r25 = r24.g();
        if (r25 == null) goto L58;
        Boolean r26 = Boolean.valueOf(r25.b());
    L60:
        if (o.a(r26, true) == false) goto L63;
        String r27 = "client_white_screen";
    L66:
        r13.put("reason", r27);
        r13.put("kill_success", r17);
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L69;
        com.obric.autogui.agents.vlm.models.impl.g r28 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L70:
        if (r28 == null) goto L76;
        IAutoActionAgentEventListener.AgentStepInfo r29 = r28.T();
        if (r29 == null) goto L76;
        long r30 = r29.getFinishTimeMills();
        if (r30 <= 0) goto L76;
        r13.put("interval", AOSystemTools.INSTANCE.nowTimeMillis() - r30);
    L76:
        b r31 = this.f29345c;
        if (r31 == null) goto L83;
        h r32 = r31.g();
        if (r32 == null) goto L83;
        if (r32.b() != true) goto L83;
    L84:
        if (r5 == false) goto L97;
        AppErrorTracker r33 = AppErrorTracker.INSTANCE;
        b r34 = this.f29345c;
        if (r34 == null) goto L88;
        String r35 = r34.c();
    L89:
        b r36 = this.f29345c;
        if (r36 == null) goto L92;
        String r37 = r36.b();
    L93:
        b r0 = this.f29345c;
        if (r0 == null) goto L96;
        r7 = r0.a();
    L96:
        r13.put("client_restart_times", r33.getAppRestartTimes(r35, r37, r7));
        goto L97
    L92:
        r37 = null;
        goto L93
    L88:
        r35 = null;
    L97:
        x r38 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r12, "operate_restart_app", r13, false, false, null, 28, null);
        return;
    L83:
        r5 = false;
        goto L84
    L69:
        r28 = null;
        goto L70
    L63:
        if (o.a(r26, false) == false) goto L65;
        r27 = "cloud_model";
        goto L66
    L65:
        r27 = SensitiveType.UNKNOWN;
    L58:
        r26 = null;
        goto L60
    L52:
        r23 = null;
        goto L53
    L48:
        r21 = null;
        goto L49
    L44:
        r20 = null;
    L40:
        r16 = null;
        goto L41
    L34:
        r14 = null;
        goto L35
    L30:
        r6 = null;
        goto L31
    L21:
        r10 = false;
    L14:
        r11 = false;
        goto L24
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L15;
    L26:
        r4 = null;
    L6:
        r2 = p.b();
        goto L7
    }

    private final com.obric.autogui.operator.a.b.a.c a(Context r11, String r12, String r13) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r3 = com.obric.autogui.session.c.f30777a.b();
        if (r3 != null) goto L6;
        Loog.INSTANCE.w(TAG, " - [OpenApp] no ongoing session.");
        return null;
    L6:
        String r4 = r10.getString(ZeusTransformUtils.mapRes(R.string.agent_task_user_interrupt_open_app_paused, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_interrupt_open_app_paused"));
        o.c(r4, "getString(...)");
        r3.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new l(r12, r3, r4, r13, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29448d, null, null, null, null, false, null, 126, null);
    }
}
