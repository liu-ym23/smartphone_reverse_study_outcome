package com.obric.autogui.agents.vlm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink;
import com.obric.autogui.common.api.cocreation.OmniLabelingStepRecord;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitorKt;
import com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.session.state.AutoActionAgentImpl;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.h.b.ae;
import d.h.b.z;
import d.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.dm;
import kotlinx.coroutines.w;
import org.json.JSONObject;

/* JADX INFO: compiled from: VlmAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autogui.agents.a {
    private static final String TAG = "VLM-Agent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27108a = null;
    private static final Set<String> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autogui.agents.vlm.models.a.a f27109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.agents.a.f f27110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autogui.agents.c[] f27111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.autogui.agents.b.g f27112e;
    private int f;

    /* JADX INFO: compiled from: VlmAgent.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VlmAgent.kt */
    public static final class C0677b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.session.a f27113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.obric.autogui.common.a.k f27114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.obric.autogui.agents.vlm.models.c f27115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f27116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f27117e;
        private d.h.a.r<? super com.obric.autogui.agents.a.d, ? super String, ? super com.obric.autogui.agents.a.e, ? super d.c.d<? super com.obric.autogui.agents.a.d>, ? extends Object> f;
        private boolean g;
        private boolean h;
        private IAutoActionSpecialApi.ScreenShotTickToken i;
        private volatile ActionSystemAnimationMonitor j;
        private String k;
        private final a l;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.b$b$a */
        /* JADX INFO: compiled from: VlmAgent.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<C0678a> f27118a;

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.b$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: VlmAgent.kt */
            public static final class C0678a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final String f27119a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final EnumC0679b f27120b;

                public boolean equals(Object r5) {
                    if (this != r5) goto L6;
                    return true;
                L6:
                    if (ZeusTransformUtils.instanceOf(r5, C0678a.class) == true) goto L8;
                    return false;
                L8:
                    C0678a r6 = (C0678a) ZeusTransformUtils.preCheckCast(r5, C0678a.class, "com.obric.aiagent.plugin");
                    if (d.h.b.o.a(this.f27119a, r6.f27119a) == true) goto L12;
                    return false;
                L12:
                    if (this.f27120b == r6.f27120b) goto L14;
                    return false;
                L14:
                    return true;
                }

                public int hashCode() {
                    return (this.f27119a.hashCode() * 31) + this.f27120b.hashCode();
                }

                public String toString() {
                    return "Entry(value=" + this.f27119a + ", type=" + this.f27120b + ')';
                }

                public C0678a(String r2, EnumC0679b r3) {
                    d.h.b.o.e(r2, "value");
                    d.h.b.o.e(r3, "type");
                    this.f27119a = r2;
                    this.f27120b = r3;
                }

                public final String a() {
                    return this.f27119a;
                }

                public final EnumC0679b getType() {
                    return this.f27120b;
                }
            }

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.b$b$a$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: VlmAgent.kt */
            public static final enum EnumC0679b extends Enum<EnumC0679b> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final EnumC0679b f27121a = null;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public static final EnumC0679b f27122b = null;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public static final EnumC0679b f27123c = null;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private static final /* synthetic */ EnumC0679b[] f27124d = null;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private static final /* synthetic */ d.d.a f27125e = null;

                private static final /* synthetic */ EnumC0679b[] a() {
                    return new EnumC0679b[]{f27121a, f27122b, f27123c};
                }

                private EnumC0679b(String r1, int r2) {
                    super(r1, r2);
                }

                static {
                    f27121a = new EnumC0679b("UserAddition", 0);
                    f27122b = new EnumC0679b("UserClarify", 1);
                    f27123c = new EnumC0679b("SystemHint", 2);
                    EnumC0679b[] r0 = a();
                    f27124d = r0;
                    f27125e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
                }

                public static EnumC0679b valueOf(String r2) {
                    return (EnumC0679b) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0679b.class, r2), EnumC0679b.class, "com.obric.aiagent.plugin");
                }

                public static EnumC0679b[] values() {
                    return (EnumC0679b[]) ZeusTransformUtils.preCheckCast(f27124d.clone(), EnumC0679b[].class, "com.obric.aiagent.plugin");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f27118a, r6.f27118a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f27118a.hashCode();
            }

            public String toString() {
                return "VlmModelRequestContext(entries=" + this.f27118a + ')';
            }

            public a(List<C0678a> r3) {
                List<C0678a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "entries");
                this.f27118a = r4;
            }

            public /* synthetic */ a(List r2, int r3, d.h.b.h r4) {
                List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
                if ((r3 & 1) == 0) goto L5;
                r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            L5:
                this(r5);
            }

            public final List<C0678a> a() {
                return this.f27118a;
            }

            public final void b() {
                monitor-enter(this);
            L9:
                th = move-exception;
                throw th;
            L4:
                if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f27118a, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L6;
                Loog.INSTANCE.i(b.TAG, "cleared InferenceRequestContext entries (s=" + this.f27118a.size() + ").");     // Catch: Throwable -> L9
                this.f27118a.clear();     // Catch: Throwable -> L9
            L6:
                x r0 = x.f38692a;     // Catch: Throwable -> L9
                monitor-exit(this);
            }

            public final void a(EnumC0679b r7, String r8) {
                d.h.b.o.e(r7, "type");
                d.h.b.o.e(r8, "value");
                monitor-enter(this);
                Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f27118a, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
                boolean r2 = true;
                if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L7;
            L9:
                Iterator r1 = r0.iterator();     // Catch: Throwable -> L28
            L11:
                if (r1.hasNext() == false) goto L20;
                C0678a r3 = (C0678a) ZeusTransformUtils.preCheckCast(r1.next(), C0678a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
                if (r3.getType() == r7) goto L15;
            L17:
                boolean r4 = false;
            L18:
                if (r4 == false) goto L11;
            L21:
                if (r2 == false) goto L25;
                Loog.INSTANCE.w(b.TAG, "duplicated entry for type=" + r7 + ". ignored.");     // Catch: Throwable -> L28
                monitor-exit(this);
                return;
            L25:
                this.f27118a.add(new C0678a(r8, r7));     // Catch: Throwable -> L28
                monitor-exit(this);
                return;
            L15:
                if (d.h.b.o.a(r3.a(), r8) == false) goto L17;
                r4 = true;
            L20:
                r2 = false;
                goto L21
            L7:
                if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
            L28:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VlmAgent.kt */
        public /* synthetic */ class C0680b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f27126a = null;

            static {
                int[] r0 = new int[com.obric.autogui.agents.vlm.models.b.values().length];
                r0[com.obric.autogui.agents.vlm.models.b.f27279c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[com.obric.autogui.agents.vlm.models.b.f27278b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f27126a = r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.b$b$c */
        /* JADX INFO: compiled from: VlmAgent.kt */
        @d.c.b.a.f(b = "VlmAgent.kt", c = {237}, d = "init", e = "com.obric.autogui.agents.vlm.VlmAgent$MyVlmSessionExt")
        static final class c extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f27127a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f27128b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f27129c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f27130d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ C0677b f27131e;
            int f;

            c(C0677b r3, d.c.d<? super c> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27131e = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f27130d = r3;
                this.f |= Integer.MIN_VALUE;
                return this.f27131e.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0677b(com.obric.autogui.session.a r3) {
            d.h.b.o.e(r3, "base");
            this.f27113a = r3;
            this.l = new a(null, 1, 0 == true ? 1 : 0);
        }

        public final com.obric.autogui.session.a a() {
            return this.f27113a;
        }

        public final String b() {
            return this.f27113a.b();
        }

        public final Context getContext() {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f27113a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }

        public final com.obric.autogui.common.a.k c() {
            return this.f27114b;
        }

        public final void a(com.obric.autogui.agents.vlm.models.c r3) {
            this.f27115c = (com.obric.autogui.agents.vlm.models.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.vlm.models.c.class, "com.obric.aiagent.plugin");
        }

        public final com.obric.autogui.agents.vlm.models.c d() {
            return this.f27115c;
        }

        public final boolean e() {
            if (this.f27113a.t() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final void a(boolean r1) {
            this.f27116d = r1;
        }

        public final boolean f() {
            return this.f27116d;
        }

        public final void b(boolean r1) {
            this.f27117e = r1;
        }

        public final boolean g() {
            return this.f27117e;
        }

        public final void a(d.h.a.r<? super com.obric.autogui.agents.a.d, ? super String, ? super com.obric.autogui.agents.a.e, ? super d.c.d<? super com.obric.autogui.agents.a.d>, ? extends Object> r3) {
            this.f = (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.r.class, "com.obric.aiagent.plugin");
        }

        public final d.h.a.r<com.obric.autogui.agents.a.d, String, com.obric.autogui.agents.a.e, d.c.d<? super com.obric.autogui.agents.a.d>, Object> h() {
            return this.f;
        }

        public final void c(boolean r1) {
            this.g = r1;
        }

        public final boolean i() {
            return this.g;
        }

        public final void d(boolean r1) {
            this.h = r1;
        }

        public final boolean j() {
            return this.h;
        }

        public final long k() {
            return this.f27113a.f();
        }

        public final void a(IAutoActionSpecialApi.ScreenShotTickToken r1) {
            this.i = r1;
        }

        public final IAutoActionSpecialApi.ScreenShotTickToken l() {
            return this.i;
        }

        public final void a(ActionSystemAnimationMonitor r3) {
            this.j = (ActionSystemAnimationMonitor) ZeusTransformUtils.wrapperContextForParams(r3, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
        }

        public final ActionSystemAnimationMonitor m() {
            return this.j;
        }

        public final Set<String> n() {
            return this.f27113a.S();
        }

        public final Object a(d.c.d<? super C0677b> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L7;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");
            if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
            r1.f -= Integer.MIN_VALUE;
        L8:
            Object r9 = r1.f27130d;
            Object r3 = d.c.a.b.a();
            int r4 = r1.f;
            if (r4 == 0) goto L14;
            if (r4 != 1) goto L13;
            C0677b this = (C0677b) ZeusTransformUtils.preCheckCast(r1.f27129c, C0677b.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.c r5 = (com.obric.autogui.agents.vlm.models.c) ZeusTransformUtils.preCheckCast(r1.f27128b, com.obric.autogui.agents.vlm.models.c.class, "com.obric.aiagent.plugin");
            C0677b r0 = (C0677b) ZeusTransformUtils.preCheckCast(r1.f27127a, C0677b.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
        L31:
            this.f27115c = r5;
            return r0;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r9);
            com.obric.autogui.common.a.k r10 = com.obric.autogui.common.a.m.f28999a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f27113a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            this.f27114b = r10;
            boolean r2 = false;
            if (r10 == null) goto L21;
            com.obric.autogui.common.a.g r11 = r10.h();
            if (r11 == null) goto L21;
            if (((Number) ZeusTransformUtils.preCheckCast(r11.d(), Number.class, "com.obric.aiagent.plugin")).intValue() != 2) goto L21;
            r2 = true;
        L21:
            if (r2 == false) goto L23;
            com.obric.autogui.common.b.b.f29001a.a(1);
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[Evaluation-Mode] the vlm-agent is in evaluation mode (loggable=" + com.obric.autogui.common.b.b.f29001a.a() + ").");
        L24:
            com.obric.autogui.agents.vlm.models.c r12 = q();
            if (r12 == null) goto L30;
            r1.f27127a = this;
            r1.f27128b = r12;
            r1.f27129c = this;
            r1.f = 1;
            if (r12.a(this, r1) != r3) goto L29;
            return r3;
        L29:
            r0 = this;
            r5 = r12;
            goto L31
        L30:
            r5 = null;
            r0 = this;
            goto L31
        L23:
            com.obric.autogui.common.b.b.f29001a.b(1);
        L7:
            r1 = new c(this, r8);
            goto L8
        }

        private final com.obric.autogui.agents.vlm.models.c q() {
            com.obric.autogui.common.a.k r0 = this.f27114b;
            if (r0 != null) goto L5;
            return null;
        L5:
            Loog.INSTANCE.d(b.TAG, "selectModel config cVlmModelType: " + new GsonBuilder().create().toJson(r0.e().d()));
            com.obric.autogui.agents.vlm.models.b r2 = (com.obric.autogui.agents.vlm.models.b) ZeusTransformUtils.preCheckCast(d.a.i.b(com.obric.autogui.agents.vlm.models.b.values(), ((Number) ZeusTransformUtils.preCheckCast(r0.e().d(), Number.class, "com.obric.aiagent.plugin")).intValue()), com.obric.autogui.agents.vlm.models.b.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L9;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "configured unknown model type: " + r0.e());
            return null;
        L9:
            int r4 = C0680b.f27126a[r2.ordinal()];
            if (r4 == 1) goto L18;
            if (r4 == 2) goto L16;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "configured unknown model type: " + r0.e());
            return null;
        L16:
            return (com.obric.autogui.agents.vlm.models.c) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.a(), com.obric.autogui.agents.vlm.models.c.class, "com.obric.aiagent.plugin");
        L18:
            return (com.obric.autogui.agents.vlm.models.c) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.d(r2), com.obric.autogui.agents.vlm.models.c.class, "com.obric.aiagent.plugin");
        }

        public final void a(String r1) {
            this.k = r1;
        }

        public final a o() {
            return this.l;
        }

        public final String p() {
            String r0 = this.k;
            if (r0 != null) goto L5;
            r0 = this.f27113a.l().getUserTask();
        L5:
            if (r0 == null) goto L7;
            this.f27113a.l().getInternalExtras().put(AutoOperateTask.KEY_EXTRA_EVALUATED_TASK, r0);
        L7:
            return r0;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27132a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f27133b = null;

        static {
            int[] r0 = new int[com.obric.autogui.agents.a.e.values().length];
            r0[com.obric.autogui.agents.a.e.f26137c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L14:
            r0[com.obric.autogui.agents.a.e.f26136b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L18:
            r0[com.obric.autogui.agents.a.e.f26138d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L6:
            f27132a = r0;
            int[] r1 = new int[com.obric.autogui.operator.b.EnumC0777b.values().length];
            r1[com.obric.autogui.operator.b.EnumC0777b.f29869a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L8:
            f27133b = r1;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, DownloadErrorCode.ERROR_DOWNLOAD_RUNNABLE_UNKNOWN, DownloadErrorCode.ERROR_TTNET_CONNECT}, d = "executeStep", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27138e;
        Object f;
        Object g;
        Object h;
        Object i;
        int j;
        long k;
        /* synthetic */ Object l;
        final /* synthetic */ b m;
        int n;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.m = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.l = r3;
            this.n |= Integer.MIN_VALUE;
            return this.m.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {DownloadErrorCode.ERROR_SEGMENT_APPLY}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.VlmAgent$executeStep$4")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<com.obric.autogui.agents.vlm.models.a.a.b> f27140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f27141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.operator.e f27142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f27143e;

        e(w<com.obric.autogui.agents.vlm.models.a.a.b> r3, b r4, com.obric.autogui.operator.e r5, d.c.d<? super e> r6) {
            w<com.obric.autogui.agents.vlm.models.a.a.b> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27140b = r7;
            this.f27141c = r4;
            this.f27142d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f27140b, this.f27141c, this.f27142d, r7);
            r0.f27143e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27139a;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            w r7 = (w) ZeusTransformUtils.preCheckCast(this.f27143e, w.class, "com.obric.aiagent.plugin");
            d.o.a(r8);     // Catch: Throwable -> L8
        L17:
            Object r9 = d.n.f((com.obric.autogui.agents.vlm.models.a.a.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.agents.vlm.models.a.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        L23:
            if (d.n.b(r9) == false) goto L25;
            r9 = null;
        L25:
            r7.a(r9);
            return x.f38692a;
        L8:
            Throwable th = th;
        L21:
            d.n.a r2 = d.n.f38560a;
            r9 = d.n.f(d.o.a(th));
            goto L23
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r8);
            am r10 = (am) ZeusTransformUtils.preCheckCast(this.f27143e, am.class, "com.obric.aiagent.plugin");
            w<com.obric.autogui.agents.vlm.models.a.a.b> r11 = this.f27140b;
            b r3 = this.f27141c;
            com.obric.autogui.operator.e r4 = this.f27142d;
            d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L19
            this.f27143e = r11;     // Catch: Throwable -> L19
            this.f27139a = 1;     // Catch: Throwable -> L19
            Object r12 = b.a(r3, r4, this);     // Catch: Throwable -> L19
            if (r12 != r0) goto L16;
            return r0;
        L16:
            r8 = r12;
            r7 = r11;
        L19:
            th = move-exception;
            th = th;
            r7 = r11;
            goto L21
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.b<com.obric.autogui.agents.a.f.g, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.l f27144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.a f27145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.operator.e f27146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27147d;

        f(com.obric.autogui.agents.vlm.models.omni.l r7, com.obric.autogui.agents.vlm.a r8, com.obric.autogui.operator.e r9, String r10) {
            this.f27144a = r7;
            this.f27145b = r8;
            this.f27146c = r9;
            this.f27147d = r10;
            super(1, d.h.b.o.a.class, "bindExecutionResultEvaluation", "executeStep$bindExecutionResultEvaluation(Lcom/obric/autogui/agents/vlm/models/omni/OmniAction;Lcom/obric/autogui/agents/vlm/ActionEffectActionPosition;Lcom/obric/autogui/operator/AOStep;Ljava/lang/String;Lcom/obric/autogui/agents/actioneffect/model/ActionEffectEvaluationResult;)V", 0);
        }

        public final void a(com.obric.autogui.agents.a.f.g r4) {
            d.h.b.o.e(r4, "p0");
            b.a(this.f27144a, this.f27145b, this.f27146c, this.f27147d, r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.autogui.agents.a.f.g r3) {
            a((com.obric.autogui.agents.a.f.g) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.f.g.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    /* synthetic */ class g extends d.h.b.l implements d.h.a.b<com.obric.autogui.agents.a.f.g, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.l f27148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.a f27149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.operator.e f27150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27151d;

        g(com.obric.autogui.agents.vlm.models.omni.l r7, com.obric.autogui.agents.vlm.a r8, com.obric.autogui.operator.e r9, String r10) {
            this.f27148a = r7;
            this.f27149b = r8;
            this.f27150c = r9;
            this.f27151d = r10;
            super(1, d.h.b.o.a.class, "bindExecutionResultEvaluation", "executeStep$bindExecutionResultEvaluation(Lcom/obric/autogui/agents/vlm/models/omni/OmniAction;Lcom/obric/autogui/agents/vlm/ActionEffectActionPosition;Lcom/obric/autogui/operator/AOStep;Ljava/lang/String;Lcom/obric/autogui/agents/actioneffect/model/ActionEffectEvaluationResult;)V", 0);
        }

        public final void a(com.obric.autogui.agents.a.f.g r4) {
            d.h.b.o.e(r4, "p0");
            b.a(this.f27148a, this.f27149b, this.f27150c, this.f27151d, r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.autogui.agents.a.f.g r3) {
            a((com.obric.autogui.agents.a.f.g) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.f.g.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {381}, d = "init", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f27155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27156e;

        h(b r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27155d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27154c = r3;
            this.f27156e |= Integer.MIN_VALUE;
            return this.f27155d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {391}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.VlmAgent$init$2")
    static final class i extends d.c.b.a.l implements d.h.a.r<com.obric.autogui.agents.a.d, String, com.obric.autogui.agents.a.e, d.c.d<? super com.obric.autogui.agents.a.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27160d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.a.f f27161e;
        final /* synthetic */ com.obric.autogui.session.a f;

        i(com.obric.autogui.agents.a.f r3, com.obric.autogui.session.a r4, d.c.d<? super i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27161e = r3;
            this.f = r4;
            super(4, r6);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public final Object a2(com.obric.autogui.agents.a.d r3, String r4, com.obric.autogui.agents.a.e r5, d.c.d<? super com.obric.autogui.agents.a.d> r6) {
            com.obric.autogui.agents.a.e r7 = (com.obric.autogui.agents.a.e) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.agents.a.e.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f27161e, this.f, r8);
            r0.f27158b = r3;
            r0.f27159c = r4;
            r0.f27160d = r7;
            return r0.invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.r
        public /* synthetic */ Object a(com.obric.autogui.agents.a.d r3, String r4, com.obric.autogui.agents.a.e r5, d.c.d<? super com.obric.autogui.agents.a.d> r6) {
            return a2((com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (com.obric.autogui.agents.a.e) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.a.e.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27157a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.autogui.agents.a.d r6 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(this.f27158b, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(this.f27159c, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.e r8 = (com.obric.autogui.agents.a.e) ZeusTransformUtils.preCheckCast(this.f27160d, com.obric.autogui.agents.a.e.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.f r4 = this.f27161e;
            String r5 = this.f.b();
            d.c.d<? super com.obric.autogui.agents.a.d> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27158b = null;
            this.f27159c = null;
            this.f27157a = 1;
            r11 = r4.a(r5, r6, r7, r8, r9);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {1464}, d = "judgePredCondition", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27165d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27166e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ b h;
        int i;

        j(b r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {1465, 1469, 1471}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.VlmAgent$judgePredCondition$predJudgesResult$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.autogui.agents.a.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.b.g f27168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f27169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.common.a.k f27170d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.a.d f27171e;
        final /* synthetic */ b f;
        final /* synthetic */ com.obric.autogui.agents.c[] g;

        k(com.obric.autogui.agents.b.g r3, com.obric.autogui.session.a r4, com.obric.autogui.common.a.k r5, com.obric.autogui.agents.a.d r6, b r7, com.obric.autogui.agents.c[] r8, d.c.d<? super k> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27168b = r3;
            this.f27169c = r4;
            this.f27170d = r5;
            this.f27171e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.agents.a.b> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f27168b, this.f27169c, this.f27170d, this.f27171e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.agents.a.b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27167a;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            d.o.a(r13);
        L28:
            return (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.agents.a.b.class, "com.obric.aiagent.plugin");
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r13);
        L29:
            return (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.agents.a.b.class, "com.obric.aiagent.plugin");
        L11:
            d.o.a(r13);
        L15:
            com.obric.autogui.agents.a.b r14 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.agents.a.b.class, "com.obric.aiagent.plugin");
            if (r14.a() == com.obric.autogui.agents.a.e.f26135a) goto L19;
            return r14;
        L19:
            if (com.obric.autogui.common.a.d.f28974a.m() == false) goto L24;
            b r6 = this.f;
            com.obric.autogui.session.a r7 = this.f27169c;
            com.obric.autogui.common.a.k r8 = this.f27170d;
            com.obric.autogui.agents.a.d r9 = this.f27171e;
            com.obric.autogui.agents.c[] r10 = this.g;
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27167a = 2;
            r13 = b.a(r6, r7, r8, r9, r10, r11);
            if (r13 != r0) goto L29;
            return r0;
        L24:
            b r12 = this.f;
            com.obric.autogui.session.a r15 = this.f27169c;
            com.obric.autogui.common.a.k r16 = this.f27170d;
            com.obric.autogui.agents.a.d r17 = this.f27171e;
            com.obric.autogui.agents.c[] r18 = this.g;
            d.c.d r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27167a = 3;
            r13 = b.b(r12, r15, r16, r17, r18, r19);
            if (r13 != r0) goto L28;
            return r0;
        L12:
            d.o.a(r13);
            com.obric.autogui.agents.b.g r110 = this.f27168b;
            com.obric.autogui.session.a r2 = this.f27169c;
            com.obric.autogui.common.a.k r20 = this.f27170d;
            com.obric.autogui.agents.a.d r21 = this.f27171e;
            d.c.d<? super com.obric.autogui.agents.a.b> r22 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27167a = 1;
            r13 = r110.a(r2, r20, r21, r22);
            if (r13 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {1595}, d = "logStep", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27176e;
        Object f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ b i;
        int j;

        l(b r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return b.a(this.i, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {1268, 1322}, d = "maybeOpenAppInPlace", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f27180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27181e;

        m(b r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27180d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27179c = r3;
            this.f27181e |= Integer.MIN_VALUE;
            return b.a(this.f27180d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {1271}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.VlmAgent$maybeOpenAppInPlace$moved$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f27184c;

        n(com.obric.autogui.session.a r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27184c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super Boolean> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            n r0 = new n(this.f27184c, r5);
            r0.f27183b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Boolean> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27182a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f27183b, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.impl.applist.black.p r2 = com.obric.autogui.agents.vlm.models.impl.applist.black.p.f27502a;
            String r4 = this.f27184c.a();
            d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27182a = 1;
            r7 = r2.b(r8, r4, r3);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {1553}, d = "onStepExecuted", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class o extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f27187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27188d;

        o(b r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27187c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27186b = r3;
            this.f27188d |= Integer.MIN_VALUE;
            return this.f27187c.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {698, 706}, d = "onStepStartedExecution", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class p extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27192d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f27193e;
        final /* synthetic */ b f;
        int g;

        p(b r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27193e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {675}, d = "predictNextStep", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class q extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f27195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f27197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27198e;

        q(b r3, d.c.d<? super q> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27197d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27196c = r3;
            this.f27198e |= Integer.MIN_VALUE;
            return this.f27197d.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_CALL_USER, 1409}, d = "predictStepInternal", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class r extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f27203e;
        int f;

        r(b r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27203e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27202d = r3;
            this.f |= Integer.MIN_VALUE;
            return b.a(this.f27203e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {563, 574}, d = "runPredJudgesV1Sequential", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class s extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27207d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27208e;
        Object f;
        int g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ b j;
        int k;

        s(b r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.i = r7;
            this.k |= Integer.MIN_VALUE;
            return b.b(this.j, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {498, 535}, d = "runPredJudgesV2Parallel", e = "com.obric.autogui.agents.vlm.VlmAgent")
    static final class t extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27212d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27213e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ b i;
        int j;

        t(b r3, d.c.d<? super t> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.h = r7;
            this.j |= Integer.MIN_VALUE;
            return b.a(this.i, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.c f27214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.a.b f27215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f27216c;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, u.class) == true) goto L8;
            return false;
        L8:
            u r8 = (u) ZeusTransformUtils.preCheckCast(r7, u.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27214a, r8.f27214a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27215b, r8.f27215b) == true) goto L15;
            return false;
        L15:
            if (this.f27216c == r8.f27216c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f27214a.hashCode() * 31) + this.f27215b.hashCode()) * 31) + Long.hashCode(this.f27216c);
        }

        public String toString() {
            return "JudgeRunResult(judge=" + this.f27214a + ", result=" + this.f27215b + ", costMillis=" + this.f27216c + ')';
        }

        public u(com.obric.autogui.agents.c r3, com.obric.autogui.agents.a.b r4, long r5) {
            com.obric.autogui.agents.c r6 = (com.obric.autogui.agents.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.c.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "judge");
            d.h.b.o.e(r4, "result");
            this.f27214a = r6;
            this.f27215b = r4;
            this.f27216c = r5;
        }

        public final com.obric.autogui.agents.c a() {
            return this.f27214a;
        }

        public final com.obric.autogui.agents.a.b b() {
            return this.f27215b;
        }
    }

    /* JADX INFO: compiled from: VlmAgent.kt */
    @d.c.b.a.f(b = "VlmAgent.kt", c = {507}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.VlmAgent$runPredJudgesV2Parallel$results$1")
    static final class v extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends u>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.f<List<com.obric.autogui.agents.c>> f27218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bp f27219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f27220d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.common.a.k f27221e;
        final /* synthetic */ com.obric.autogui.agents.a.d f;
        private /* synthetic */ Object g;

        /* JADX INFO: compiled from: VlmAgent.kt */
        @d.c.b.a.f(b = "VlmAgent.kt", c = {EntityType.AUDITORY_RECORDING}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.VlmAgent$runPredJudgesV2Parallel$results$1$1$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super u>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            long f27222a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f27223b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.c f27224c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.session.a f27225d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.common.a.k f27226e;
            final /* synthetic */ com.obric.autogui.agents.a.d f;
            private /* synthetic */ Object g;

            a(com.obric.autogui.agents.c r3, com.obric.autogui.session.a r4, com.obric.autogui.common.a.k r5, com.obric.autogui.agents.a.d r6, d.c.d<? super a> r7) {
                com.obric.autogui.agents.c r8 = (com.obric.autogui.agents.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.c.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27224c = r8;
                this.f27225d = r4;
                this.f27226e = r5;
                this.f = r6;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super u> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                a r11 = new a(this.f27224c, this.f27225d, this.f27226e, this.f, r7);
                r11.g = r9;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super u> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r11) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27223b;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                long r2 = this.f27222a;
                am r3 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
                d.o.a(r11);
            L12:
                com.obric.autogui.agents.a.b r12 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.a.b.class, "com.obric.aiagent.plugin");
                long r4 = System.currentTimeMillis() - r2;
                Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r3), "JudgeV2 judgePredCondition(v2)=" + this.f27224c.getClass().getSimpleName() + " cost=" + r4);
                return new u(this.f27224c, r12, r4);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r11);
                am r13 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
                long r5 = System.currentTimeMillis();
                com.obric.autogui.agents.c r6 = this.f27224c;
                com.obric.autogui.session.a r7 = this.f27225d;
                com.obric.autogui.common.a.k r8 = this.f27226e;
                com.obric.autogui.agents.a.d r9 = this.f;
                d.c.d<? super com.obric.autogui.agents.a.b> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r13;
                this.f27222a = r5;
                this.f27223b = 1;
                Object r14 = r6.a(r7, r8, r9, r10);
                if (r14 != r0) goto L11;
                return r0;
            L11:
                r3 = r13;
                r11 = r14;
                r2 = r5;
                goto L12
            }
        }

        v(z.f<List<com.obric.autogui.agents.c>> r3, bp r4, com.obric.autogui.session.a r5, com.obric.autogui.common.a.k r6, com.obric.autogui.agents.a.d r7, d.c.d<? super v> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27218b = r3;
            this.f27219c = r4;
            this.f27220d = r5;
            this.f27221e = r6;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super List<u>> r4) {
            return ((v) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            v r12 = new v(this.f27218b, this.f27219c, this.f27220d, this.f27221e, this.f, r8);
            r12.g = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends u>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f27217a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r20);
            return r20;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r20);
            am r3 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f27218b.f38504a, Iterable.class, "com.obric.aiagent.plugin");
            bp r12 = this.f27219c;
            com.obric.autogui.session.a r13 = this.f27220d;
            com.obric.autogui.common.a.k r14 = this.f27221e;
            com.obric.autogui.agents.a.d r15 = this.f;
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r5 = r4.iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            com.obric.autogui.agents.c r7 = (com.obric.autogui.agents.c) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.autogui.agents.c.class, "com.obric.aiagent.plugin");
            Iterator r21 = r5;
            Collection r6 = r11;
            r6.add(kotlinx.coroutines.i.b(r3, (d.c.g) ZeusTransformUtils.preCheckCast(r12, d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r7, r13, r14, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null));
            r11 = r6;
            r5 = r21;
            goto L10
        L12:
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27217a = 1;
            Object r0 = kotlinx.coroutines.f.a(r8, r9);
            if (r0 != r1) goto L17;
            return r1;
        L17:
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$4Rw1-cYSqfwJTxeOBm7MNckPtRU, reason: not valid java name */
    public static /* synthetic */ x m742lambda$4Rw1cYSqfwJTxeOBm7MNckPtRU(z.f r0, com.obric.autogui.agents.vlm.models.omni.l r1, com.obric.autogui.agents.vlm.a r2, com.obric.autogui.operator.e r3, String r4, com.obric.autogui.agents.a.f.g r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$FT7zodjDjRKlCBVmH8XhNw0hc5g(com.obric.autogui.agents.vlm.models.omni.l r0, String r1, com.obric.autogui.agents.vlm.models.impl.g r2, com.obric.autogui.agents.vlm.a r3, com.obric.autogui.agents.a.a.j r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Thread lambda$QIudb9QbVYrqLK41taQqeidv_JU(AtomicInteger r0, Runnable r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$WZppSGcLFl7ytyq1_E-5AiVn4ZA, reason: not valid java name */
    public static /* synthetic */ x m743lambda$WZppSGcLFl7ytyq1_E5AiVn4ZA(boolean r0, b r1, DisplayedAppInfo r2, String r3, com.obric.autogui.operator.e r4, com.obric.autogui.session.a r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$fMuY54Gh91vqhqbhTIcKLUr0imA(com.obric.autogui.agents.vlm.models.omni.l r0, com.obric.autogui.agents.vlm.a r1, com.obric.autogui.operator.e r2, z.f r3, String r4, String r5, com.obric.autogui.agents.a.f.f r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public b() {
        super(com.obric.autogui.agents.a.EnumC0655a.f26120b);
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autogui.operator.e r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autogui.session.a r3, com.obric.autogui.agents.a.d r4, d.c.d r5) {
        return r2.c(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r6, com.obric.autogui.session.a r7, com.obric.autogui.common.a.k r8, com.obric.autogui.agents.a.d r9, com.obric.autogui.agents.c[] r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, com.obric.autogui.operator.g r5, d.c.d r6) {
        return r2.b(r3, r4, (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, d.c.d r5) {
        return r2.c(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(com.obric.autogui.agents.vlm.models.omni.l r0, com.obric.autogui.agents.vlm.a r1, com.obric.autogui.operator.e r2, String r3, com.obric.autogui.agents.a.f.g r4) {
        b(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object b(b r6, com.obric.autogui.session.a r7, com.obric.autogui.common.a.k r8, com.obric.autogui.agents.a.d r9, com.obric.autogui.agents.c[] r10, d.c.d r11) {
        return r6.b(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f27108a = new a(null);
        List<?> r0 = AutoActionConfigs.INSTANCE.getListCfg("vd.start.bring_app_actions");
        if (r0 == null) goto L16;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r5 == null) goto L6;
        r2.add(r5);
        goto L6
    L10:
        r5 = null;
        goto L11
    L13:
        Set<String> r6 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        if (r6 == null) goto L16;
    L17:
        g = r6;
        return;
    L16:
        r6 = ax.a(new String[]{"clarify", "stop", "open_app", "set_time_task"});
        goto L17
    }

    private final C0677b c(com.obric.autogui.session.a r3) {
        Object r2 = r3.a((com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin"));
        d.h.b.o.a(r2, "null cannot be cast to non-null type com.obric.autogui.agents.vlm.VlmAgent.MyVlmSessionExt");
        return (C0677b) ZeusTransformUtils.preCheckCast(r2, C0677b.class, "com.obric.aiagent.plugin");
    }

    private final boolean a(AutoOperateTask r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getUserTask(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        return !r3;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r3 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.autogui.agents.a
    public Object a(com.obric.autogui.session.a r7, d.c.d<? super com.obric.autogui.common.e> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin");
        if ((r0.f27156e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27156e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f27154c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27156e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f27153b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b this = (b) ZeusTransformUtils.preCheckCast(r0.f27152a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
    L21:
        C0677b r11 = (C0677b) ZeusTransformUtils.preCheckCast(r10, C0677b.class, "com.obric.aiagent.plugin");
        this.f27109b = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.a.g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0.3f), com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.r<? super com.obric.autogui.agents.a.d, ? super String, ? super com.obric.autogui.agents.a.e, ? super d.c.d<? super com.obric.autogui.agents.a.d>, ? extends Object> r4 = null;
        com.obric.autogui.agents.a.f r1 = new com.obric.autogui.agents.a.f((com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.a.g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0.3f), com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin"), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        this.f27110c = r1;
        if (r7.c() == false) goto L24;
        r4 = (d.h.a.r) ZeusTransformUtils.preCheckCast(new i(r1, r7, null), d.h.a.r.class, "com.obric.aiagent.plugin");
    L24:
        r11.a(r4);
        this.f = 0;
        this.a(r7, r11);
        this.a(r11);
        r7.a((com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin"), r11);
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "vlm-agent initialized with session");
        if (a(r7.l()) == false) goto L17;
        C0677b r12 = new C0677b(r7);
        r0.f27152a = this;
        r0.f27153b = r7;
        r0.f27156e = 1;
        r10 = r12.a(r0);
        if (r10 != r2) goto L21;
        return r2;
    L17:
        return com.obric.autogui.common.e.f29014b.b("task is not operated by VLM.");
    L7:
        r0 = new h(this, r9);
        goto L8
    }

    private final void a(C0677b r4) {
        this.f27111d = new com.obric.autogui.agents.c[]{new com.obric.autogui.agents.b.a(), new com.obric.autogui.agents.b.f(), new com.obric.autogui.agents.b.d(), new com.obric.autogui.agents.b.i(r4), new com.obric.autogui.agents.b.h(r4.a()), new com.obric.autogui.agents.b.c(r4.a())};
        this.f27112e = new com.obric.autogui.agents.b.g();
    }

    private final long a(com.obric.autogui.common.a.k r5, com.obric.autogui.session.a r6) {
        String r4 = r6.C();
        if (com.obric.autogui.common.a.d.f28974a.x() == true) goto L6;
        long r0 = r5.o();
    L12:
        if (com.obric.autogui.common.a.d.f28974a.o() == false) goto L21;
        Object r7 = d.a.p.n(r6.p());
        ActionSystemAnimationMonitor r2 = null;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L16;
        com.obric.autogui.agents.vlm.models.impl.g r8 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L17:
        if (r8 == null) goto L19;
        r2 = r8.q();
    L19:
        if (r2 == null) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L24;
        long r10 = com.obric.autogui.common.a.d.f28974a.c(r4);
    L26:
        return r0 + r10;
    L24:
        r10 = 0;
        goto L26
    L16:
        r8 = null;
    L21:
        r9 = false;
        goto L22
    L6:
        if (com.obric.autogui.common.a.d.f28974a.n() == true) goto L8;
    L10:
        r0 = com.obric.autogui.common.a.d.f28974a.w();
        goto L12
    L8:
        if (d.h.b.o.a(r4, "open_app") == false) goto L10;
        r0 = com.obric.autogui.common.a.d.f28974a.a(r4, com.obric.autogui.agents.b.c.f26803a.a() + ((long) 500));
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v2, types: [kotlinx.coroutines.bp] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r1v22, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.bp] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, kotlinx.coroutines.bp] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21, types: [kotlinx.coroutines.bp] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0308 -> B:81:0x0310). Please report as a decompilation issue!!! */
    private final Object a(com.obric.autogui.session.a r19, com.obric.autogui.common.a.k r20, com.obric.autogui.agents.a.d r21, com.obric.autogui.agents.c[] r22, d.c.d<? super com.obric.autogui.agents.a.b> r23) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, t.class) == false) goto L7;
        t r3 = (t) ZeusTransformUtils.preCheckCast(r1, t.class, "com.obric.aiagent.plugin");
        if ((r3.j & Integer.MIN_VALUE) == 0) goto L7;
        r3.j -= Integer.MIN_VALUE;
        b r4 = this;
    L8:
        Object r2 = r3.h;
        Object r5 = d.c.a.b.a();
        ?? r6 = r3.j;
        boolean r9 = true;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L17;
        if (r6 != 2) goto L16;
        z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(r3.g, z.f.class, "com.obric.aiagent.plugin");
        bp r8 = (bp) ZeusTransformUtils.preCheckCast(r3.f, bp.class, "com.obric.aiagent.plugin");
        ExecutorService r10 = (ExecutorService) ZeusTransformUtils.preCheckCast(r3.f27213e, ExecutorService.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r11 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.f27212d, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.a.k r12 = (com.obric.autogui.common.a.k) ZeusTransformUtils.preCheckCast(r3.f27211c, com.obric.autogui.common.a.k.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r13 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f27210b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.f27209a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L92
        Object r15 = r5;
        ?? r14 = r8;
        char r16 = 2;
        t r17 = r3;
        z.f r18 = r7;
        com.obric.autogui.agents.a.d r24 = r11;
        r4 = r0;
        com.obric.autogui.session.a r25 = r13;
        ExecutorService r110 = r10;
    L81:
        com.obric.autogui.common.a.k r26 = r12;
        r9 = true;
        ?? r111 = r14;
    L98:
    L89:
        th = th;
        ExecutorService r27 = r110;
        ?? r28 = r111;
    L91:
        ExecutorService r112 = r27;
        r6 = r28;
    L93:
        r6.close();
        r112.shutdownNow();
        throw th;
    L24:
        if ((((Collection) ZeusTransformUtils.preCheckCast(r18.f38504a, Collection.class, "com.obric.aiagent.plugin")).isEmpty() ^ r9) == false) goto L84;
        r27 = r110;
        r28 = r111;
        Object r113 = r15;
        d.h.a.m r29 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new v(r18, r111, r25, r26, r24, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L87
        r17.f27209a = r4;     // Catch: Throwable -> L87
        r17.f27210b = r25;     // Catch: Throwable -> L87
        r17.f27211c = r26;     // Catch: Throwable -> L87
        r17.f27212d = r24;     // Catch: Throwable -> L87
        r17.f27213e = r27;     // Catch: Throwable -> L87
        r17.f = r28;     // Catch: Throwable -> L87
        r17.g = r18;     // Catch: Throwable -> L87
        r17.j = 1;     // Catch: Throwable -> L87
        Object r30 = an.a(r29, r17);     // Catch: Throwable -> L87
        if (r30 != r113) goto L31;
        return r113;
    L31:
        com.obric.autogui.session.a r114 = r25;
        r12 = r26;
        b r31 = r4;
        z.f r32 = r18;
        r2 = r30;
        r5 = r113;
        com.obric.autogui.agents.a.d r115 = r24;
        r3 = r17;
        r6 = r28;
    L95:
        List r33 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        Iterator r34 = ((Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L82
    L33:
        Object r116 = null;
        if (r34.hasNext() == false) goto L42;
        Object r35 = r34.next();     // Catch: Throwable -> L82
        if (((u) ZeusTransformUtils.preCheckCast(r35, u.class, "com.obric.aiagent.plugin")).b().a() != com.obric.autogui.agents.a.e.f26136b) goto L38;
        boolean r117 = true;
    L39:
        if (r117 == false) goto L33;
    L43:
        u r36 = (u) ZeusTransformUtils.preCheckCast(r35, u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        if (r36 == null) goto L49;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r31), " - [JudgeV2][VLM-PredJudge] aborting by " + r36.a());     // Catch: Throwable -> L82
        com.obric.autogui.agents.a.b r37 = r36.b();     // Catch: Throwable -> L82
    L46:
        r6.close();
    L47:
        r27.shutdownNow();
        return r37;
    L49:
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L82
    L51:
        if (r38.hasNext() == false) goto L58;
        Object r39 = r38.next();     // Catch: Throwable -> L82
        if (((u) ZeusTransformUtils.preCheckCast(r39, u.class, "com.obric.aiagent.plugin")).b().a() != com.obric.autogui.agents.a.e.f26138d) goto L55;
        boolean r118 = true;
    L56:
        if (r118 == false) goto L51;
        r116 = r39;
        goto L58
    L55:
        r118 = false;
    L58:
        u r40 = (u) ZeusTransformUtils.preCheckCast(r116, u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        if (r40 == null) goto L61;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r31), " - [JudgeV2][VLM-PredJudge] intercepting by " + r40.a() + " (" + r40.b().b() + ')');     // Catch: Throwable -> L82
        r37 = r40.b();     // Catch: Throwable -> L82
        goto L46
    L61:
        Iterable r41 = (Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        Collection r42 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        Iterator r43 = r41.iterator();     // Catch: Throwable -> L82
    L63:
        if (r43.hasNext() == false) goto L70;
        Object r44 = r43.next();     // Catch: Throwable -> L82
        if (((u) ZeusTransformUtils.preCheckCast(r44, u.class, "com.obric.aiagent.plugin")).b().a() != com.obric.autogui.agents.a.e.f26137c) goto L67;
        boolean r119 = true;
    L68:
        if (r119 == false) goto L63;
        r42.add(r44);     // Catch: Throwable -> L82
        goto L63
    L67:
        r119 = false;
        goto L68
    L70:
        Iterable r45 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r42, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        Collection r46 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r45, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        Iterator r47 = r45.iterator();     // Catch: Throwable -> L82
    L72:
        if (r47.hasNext() == false) goto L74;
        r46.add(((u) ZeusTransformUtils.preCheckCast(r47.next(), u.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L82
        goto L72
    L74:
        ?? r48 = (List) ZeusTransformUtils.preCheckCast(r46, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        if (r48.isEmpty() == false) goto L77;
        r37 = com.obric.autogui.agents.a.b.f26124a.a();     // Catch: Throwable -> L82
        goto L46
    L77:
        r32.f38504a = r48;     // Catch: Throwable -> L82
        r3.f27209a = r31;     // Catch: Throwable -> L82
        r3.f27210b = r114;     // Catch: Throwable -> L82
        r3.f27211c = r12;     // Catch: Throwable -> L82
        r3.f27212d = r115;     // Catch: Throwable -> L82
        r3.f27213e = r27;     // Catch: Throwable -> L82
        r3.f = r6;     // Catch: Throwable -> L82
        r3.g = r32;     // Catch: Throwable -> L82
        r16 = 2;
        r3.j = 2;     // Catch: Throwable -> L82
        if (dm.a(r3) != r5) goto L80;
        return r5;
    L80:
        r15 = r5;
        r14 = r6;
        r17 = r3;
        r18 = r32;
        r24 = r115;
        r4 = r31;
        r25 = r114;
        r110 = r27;
        goto L81
    L38:
        r117 = false;
        goto L39
    L42:
        r35 = null;
    L82:
        th = th;
        r112 = r27;
    L87:
        th = th;
        goto L91
    L84:
        r27 = r110;
        r28 = r111;
        r37 = com.obric.autogui.agents.a.b.f26124a.a();     // Catch: Throwable -> L87
        r28.close();
        goto L47
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r32 = (z.f) ZeusTransformUtils.preCheckCast(r3.g, z.f.class, "com.obric.aiagent.plugin");
        bp r49 = (bp) ZeusTransformUtils.preCheckCast(r3.f, bp.class, "com.obric.aiagent.plugin");
        ExecutorService r120 = (ExecutorService) ZeusTransformUtils.preCheckCast(r3.f27213e, ExecutorService.class, "com.obric.aiagent.plugin");
        r115 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.f27212d, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        r12 = (com.obric.autogui.common.a.k) ZeusTransformUtils.preCheckCast(r3.f27211c, com.obric.autogui.common.a.k.class, "com.obric.aiagent.plugin");
        r114 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f27210b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r31 = (b) ZeusTransformUtils.preCheckCast(r3.f27209a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L92
        r27 = r120;
        r6 = r49;
        goto L95
    L20:
        d.o.a(r2);
        final AtomicInteger r50 = new AtomicInteger(0);
        ExecutorService r121 = Executors.newFixedThreadPool(r22.length, new $$Lambda$b$QIudb9QbVYrqLK41taQqeidv_JU(r50));
        d.h.b.o.c(r121, "newFixedThreadPool(...)");
        bp r51 = br.a(r121);
        z.f r52 = new z.f();     // Catch: Throwable -> L92
        r52.f38504a = d.a.i.g(r22);     // Catch: Throwable -> L92
        r25 = r19;
        r15 = r5;
        r111 = r51;
        r110 = r121;
        r18 = r52;
        r17 = r3;
        r26 = r20;
        r24 = r21;
    L92:
        th = th;
    L7:
        r4 = this;
        r3 = new t(r4, r1);
        goto L8
    }

    private static final Thread a(AtomicInteger r3, Runnable r4) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"), "PredJudgeV2-" + r3.incrementAndGet());
        r0.setDaemon(true);
        return r0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x01a2 -> B:17:0x00f0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x023d -> B:42:0x023f). Please report as a decompilation issue!!! */
    private final Object b(com.obric.autogui.session.a r22, com.obric.autogui.common.a.k r23, com.obric.autogui.agents.a.d r24, com.obric.autogui.agents.c[] r25, d.c.d<? super com.obric.autogui.agents.a.b> r26) {
        String r2 = "com.obric.aiagent.plugin";
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, s.class) == false) goto L7;
        s r3 = (s) ZeusTransformUtils.preCheckCast(r1, s.class, "com.obric.aiagent.plugin");
        if ((r3.k & Integer.MIN_VALUE) == 0) goto L7;
        r3.k -= Integer.MIN_VALUE;
        b r4 = this;
    L8:
        Object r5 = r3.i;
        Object r6 = d.c.a.b.a();
        int r7 = r3.k;
        int r8 = 1;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        int r9 = r3.g;
        com.obric.autogui.agents.c[] r10 = (com.obric.autogui.agents.c[]) ZeusTransformUtils.preCheckCast(r3.f27208e, com.obric.autogui.agents.c[].class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r11 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.f27207d, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.a.k r12 = (com.obric.autogui.common.a.k) ZeusTransformUtils.preCheckCast(r3.f27206c, com.obric.autogui.common.a.k.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r13 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f27205b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.f27204a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        String r16 = "com.obric.aiagent.plugin";
        Object r14 = r6;
        com.obric.autogui.agents.c[] r15 = r10;
        char r17 = 2;
        int r18 = r9;
        r4 = r0;
        com.obric.autogui.session.a r19 = r13;
        s r20 = r3;
        com.obric.autogui.agents.a.d r21 = r11;
    L42:
        com.obric.autogui.common.a.k r27 = r12;
        Object r110 = r14;
        r2 = r16;
    L18:
        if (r18 >= r15.length) goto L44;
        com.obric.autogui.agents.c r111 = (com.obric.autogui.agents.c) ZeusTransformUtils.preCheckCast(d.a.i.b(r15, r18), com.obric.autogui.agents.c.class, r2);
        if (r111 != null) goto L23;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r4), " - [VLM-PredJudge] null judge found at index=" + r18);
        return com.obric.autogui.agents.a.b.f26124a.a();
    L23:
        long r112 = System.currentTimeMillis();
        r20.f27204a = r4;
        r20.f27205b = r19;
        r20.f27206c = r27;
        r20.f27207d = r21;
        r20.f27208e = r15;
        r20.f = r111;
        r20.g = r18;
        r20.h = r112;
        r20.k = r8;
        Object r113 = r111.a(r19, r27, r21, r20);
        if (r113 != r110) goto L26;
        return r110;
    L26:
        com.obric.autogui.common.a.k r114 = r27;
        s r115 = r20;
        r5 = r113;
        r14 = r110;
        long r28 = r112;
    L27:
        com.obric.autogui.agents.a.b r29 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.a.b.class, r2);
        r16 = r2;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r4), "judgePredCondition=" + r111.getClass().getSimpleName() + " cost=" + (System.currentTimeMillis() - r28));
        int r30 = c.f27132a[r29.a().ordinal()];
        r8 = 1;
        if (r30 != 1) goto L30;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r4), " - [VLM-PredJudge] retrying `" + r111 + '`');
        r115.f27204a = r4;
        r115.f27205b = r19;
        r115.f27206c = r114;
        r115.f27207d = r21;
        r115.f27208e = r15;
        r115.f = null;
        r115.g = r18;
        r17 = 2;
        r115.k = 2;
        if (dm.a(r115) != r14) goto L41;
        return r14;
    L41:
        r20 = r115;
        r12 = r114;
        goto L42
    L30:
        if (r30 != 2) goto L32;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r4), " - [VLM-PredJudge] aborting by the request of `" + r111 + '`');
        return r29;
    L32:
        if (r30 == 3) goto L34;
        r18 = r18 + 1;
        r20 = r115;
        r27 = r114;
        r110 = r14;
        r2 = r16;
        goto L18
    L34:
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r4), " - [VLM-PredJudge] intercepting by the request of `" + r111 + "` (" + r29.b() + ')');
        return r29;
    L44:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r28 = r3.h;
        int r31 = r3.g;
        com.obric.autogui.agents.c r32 = (com.obric.autogui.agents.c) ZeusTransformUtils.preCheckCast(r3.f, com.obric.autogui.agents.c.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.c[] r116 = (com.obric.autogui.agents.c[]) ZeusTransformUtils.preCheckCast(r3.f27208e, com.obric.autogui.agents.c[].class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r117 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.f27207d, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        r114 = (com.obric.autogui.common.a.k) ZeusTransformUtils.preCheckCast(r3.f27206c, com.obric.autogui.common.a.k.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r118 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f27205b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r33 = (b) ZeusTransformUtils.preCheckCast(r3.f27204a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        r4 = r33;
        r19 = r118;
        r14 = r6;
        r15 = r116;
        r111 = r32;
        r18 = r31;
        r115 = r3;
        r21 = r117;
        goto L27
    L16:
        d.o.a(r5);
        r27 = r23;
        r18 = 0;
        r20 = r3;
        r110 = r6;
        r19 = r22;
        r21 = r24;
        r15 = r25;
    L7:
        r4 = this;
        r3 = new s(r4, r1);
        goto L8
    }

    private final void a(com.obric.autogui.session.a r11, C0677b r12) {
        AutoOperateTask r0 = r11.l();
        Object r1 = r0.getInternalExtras().get(AutoActionAgentImpl.KEY_EXTRA_FOLLOWING_SESSION_INFO);
        List<String> r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, IAutoActionAgentEventListener.SessionInfo.class) == false) goto L5;
        IAutoActionAgentEventListener.SessionInfo r2 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r1, IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        Object r4 = r0.getInternalExtras().get(AutoActionAgentImpl.KEY_EXTRA_FOLLOWING_QUESTION);
        if (ae.e(r4) == false) goto L11;
        r3 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L11:
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.isEmpty() == false) goto L17;
        Loog.INSTANCE.w(TAG, " - [USER-FOLLOW]: following with an empty question. ignored.");
        return;
    L17:
        String r5 = r2.getSessionId();
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L27;
        Loog.INSTANCE.w(TAG, " - [USER-FOLLOW]: following a null sessionId. ignored.");
        return;
    L27:
        Loog.INSTANCE.i(TAG, " - [USER-FOLLOW]: " + r2);
        r11.a(r5);
        r11.b(r2.getStepIndex());
        r12.d(true);
        C0677b.a r8 = r12.o();
        C0677b.a.EnumC0679b r9 = C0677b.a.EnumC0679b.f27121a;
        String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_following_query_prompt_to_inform_the_model_that_its_a_following_query, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_following_query_prompt_to_inform_the_model_that_its_a_following_query"));
        d.h.b.o.c(r10, "getString(...)");
        r8.a(r9, r10);
        r12.a(a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, r3));
        IAutoActionTrackingApi r13 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r14 = new JSONObject();
        com.obric.autogui.session.c.b.a(r14, r11);
        x r15 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r13, "posted_query_follow", r14, false, false, null, 28, null);
        return;
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
        goto L24
    L5:
        r2 = null;
        goto L6
    }

    private final String a(Context r11, AutoOperateTask r12, List<String> r13) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        String r15 = r10.getString(ZeusTransformUtils.mapRes(R.string.agent_following_query_prompt_delimiter, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_following_query_prompt_delimiter"));
        d.h.b.o.c(r15, "getString(...)");
        return r12.getUserTask() + r15 + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    @Override // com.obric.autogui.agents.a
    public Object b(com.obric.autogui.session.a r8, com.obric.autogui.agents.a.d r9, d.c.d<? super com.obric.autogui.common.d<com.obric.autogui.operator.e>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, q.class) == false) goto L7;
        q r0 = (q) ZeusTransformUtils.preCheckCast(r11, q.class, "com.obric.aiagent.plugin");
        if ((r0.f27198e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27198e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f27196c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27198e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r7 = r0.f27195b;
        b r13 = (b) ZeusTransformUtils.preCheckCast(r0.f27194a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
        long r5 = r7;
        b this = r13;
    L24:
        com.obric.autogui.common.d r14 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "vlm-agent prediction latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r5) + "ms");
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        com.obric.autogui.operator.e r15 = r9.e();
        if (r15 == null) goto L19;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[Vlm-Intercept] step(" + r9.b() + ") intercepted by " + r15);
        return com.obric.autogui.common.d.f29012a.a(r15);
    L19:
        if (c(r8).e() == true) goto L21;
        r8.I();
    L21:
        r5 = AOSystemTools.INSTANCE.nowTimeMillis();
        r0.f27194a = this;
        r0.f27195b = r5;
        r0.f27198e = 1;
        r12 = c(r8, r9, r0);
        if (r12 != r2) goto L24;
        return r2;
    L7:
        r0 = new q(this, r11);
        goto L8
    }

    @Override // com.obric.autogui.agents.a
    public void b(com.obric.autogui.session.a r5) {
        d.h.b.o.e(r5, SensitiveType.SESSION);
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "vlm-agent - stop predicting session/" + r5.a() + " AT ONCE.");
        C0677b r0 = c(r5);
        if (r5.M() == false) goto L5;
        b(r5, r0);
    L5:
        com.obric.autogui.agents.vlm.models.c r4 = r0.d();
        if (r4 == null) goto L9;
        r4.a(r0);
        return;
    }

    @Override // com.obric.autogui.agents.a
    public Object a(com.obric.autogui.session.a r24, com.obric.autogui.operator.e r25, d.c.d<? super x> r26) {
        b r0 = this;
        com.obric.autogui.session.a r1 = r24;
        com.obric.autogui.operator.e r2 = r25;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, p.class) == false) goto L7;
        p r6 = (p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.aiagent.plugin");
        if ((r6.g & Integer.MIN_VALUE) == 0) goto L7;
        r6.g -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f27193e;
        Object r7 = d.c.a.b.a();
        int r8 = r6.g;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        boolean r3 = r6.f27192d;
        com.obric.autogui.operator.e r9 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r6.f27191c, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r10 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r6.f27190b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r11 = (b) ZeusTransformUtils.preCheckCast(r6.f27189a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L70;
        com.obric.autogui.util.h.f31557a.a(r10, r11.a(r9));
        if (r3 == false) goto L28;
    L30:
        if (r3 == false) goto L32;
    L34:
        if (r3 == true) goto L37;
        Loog.INSTANCE.d(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "open_app detect disabled, skip ScreenShotTick register. [opti-openapp]");
    L37:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.agents.vlm.models.a.f.class) == true) goto L69;
        C0677b r12 = r11.c(r10);
        if (r12.i() == true) goto L69;
        r12.c(true);
        Bundle r13 = r10.l().getTaskExtras();
        long r14 = -1;
        if (r13 == null) goto L43;
        long r15 = r13.getLong("triggered_boot_time", -1);
    L45:
        if (r15 <= 0) goto L47;
        long r16 = AOSystemTools.INSTANCE.bootTimeMillis() - r15;
    L48:
        Loog.INSTANCE.i(TAG, "[VeryFirstStep] first-step(" + r9 + ") duration=" + r16 + "/ms");
        if (r16 <= 0) goto L69;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.agents.vlm.models.a.e.class) == false) goto L54;
        String r17 = "unsolicited-" + r9.getClass().getSimpleName();
    L60:
        IAutoActionTrackingApi r18 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r19 = new JSONObject();
        r19.put("action_type", r17);
        r19.put("step_id", r9.W());
        r19.put("request_time", r16);
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L63;
        long r20 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).y().a();
    L64:
        r19.put("server_time", r20);
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L67;
        r14 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).y().b();
    L67:
        r19.put("inference_time", r14);
        com.obric.autogui.session.c.b.a(r19, r10);
        x r21 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r18, "oauto_first_step_stat", r19, false, false, null, 28, null);
        goto L69
    L63:
        r20 = -1;
        goto L64
    L54:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L59;
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin")).f(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r22) == false) goto L58;
        r22 = "unsolicited-" + r9.getClass().getSimpleName();
    L58:
        r17 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.aiagent.plugin");
        goto L60
    L59:
        r17 = "unknown-" + r9.getClass().getSimpleName();
        goto L60
    L47:
        r16 = -1;
        goto L48
    L43:
        r15 = -1;
    L69:
        return x.f38692a;
    L32:
        if (com.obric.autogui.common.a.d.f28974a.n() == false) goto L34;
        r11.b(r10, r9);
        goto L37
    L28:
        if (r10.M() == false) goto L30;
        Loog.INSTANCE.i(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] session_paused, skip fallback registration, stepId=" + r9.W());
        goto L37
    L70:
        Loog.INSTANCE.e(TAG, "[OpenAppInPlace] start-in-place record-set add failed; terminating session=" + r10.a() + '.');
        r9.S();
        com.obric.autogui.session.state.termination.a.a(r10.J(), com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), "start-in-place record-set add failed"), 100001, null, null, 12, null);
        throw new CancellationException("start-in-place record-set add failed");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.operator.e r23 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r6.f27191c, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        r1 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r6.f27190b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r27 = (b) ZeusTransformUtils.preCheckCast(r6.f27189a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        r2 = r23;
        r0 = r27;
    L19:
        boolean r28 = r0.a(r1, r2);
        r6.f27189a = r0;
        r6.f27190b = r1;
        r6.f27191c = r2;
        r6.f27192d = r28;
        r6.g = 2;
        r5 = r0.c(r1, r2, r6);
        if (r5 != r7) goto L22;
        return r7;
    L22:
        r11 = r0;
        r3 = r28;
        com.obric.autogui.operator.e r29 = r2;
        r10 = r1;
        r9 = r29;
        goto L24
    L16:
        d.o.a(r5);
        r6.f27189a = r0;
        r6.f27190b = r1;
        r6.f27191c = r2;
        r6.g = 1;
        if (super.a(r1, r2, r6) != r7) goto L19;
        return r7;
    L7:
        r6 = new p(r0, r4);
        goto L8
    }

    private final boolean a(com.obric.autogui.session.a r10, com.obric.autogui.operator.e r11) {
        C0677b r0 = c(r10);
        if (ZeusTransformUtils.instanceOf(r11, com.obric.autogui.agents.vlm.models.impl.e.class) == false) goto L5;
        com.obric.autogui.agents.vlm.models.impl.e r1 = (com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin");
    L7:
        if (r1 == null) goto L9;
        r1.b(false);
    L9:
        ActionSystemAnimationMonitor r4 = r0.m();
        if (r4 != null) goto L12;
    L20:
        if (r1 == null) goto L22;
        ActionSystemAnimationMonitor r6 = r1.q();
    L23:
        if (r6 == r4) goto L32;
        if (r1 == null) goto L26;
        ActionSystemAnimationMonitor r5 = r1.q();
    L27:
        if (r5 == null) goto L32;
        if (r5.unregister() == true) goto L32;
        r0.a(r5);
        r1.a(null);
        Loog.INSTANCE.w(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] step monitor is still registered, skip new monitor, stepId=" + r11.W());
        return false;
    L26:
        r5 = null;
    L32:
        r0.a(null);
        if (r1 == null) goto L36;
        r1.a(null);
    L36:
        if (com.obric.autogui.common.a.d.f28974a.o() == true) goto L38;
        return false;
    L38:
        if (r1 != null) goto L40;
        return false;
    L40:
        String r2 = r1.f();
        if (com.obric.autogui.agents.b.g.f26833a.a(r2) == true) goto L45;
        Loog.INSTANCE.i(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] skip monitor, stepId=" + r11.W() + ", actionType=" + r2);
        return false;
    L45:
        if (r10.M() == false) goto L48;
        Loog.INSTANCE.i(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] session_paused before register, stepId=" + r11.W());
        return false;
    L48:
        ActionSystemAnimationMonitor r7 = r1.q();
        if (r7 == null) goto L51;
        r7.unregister();
    L51:
        ActionSystemAnimationMonitor r8 = AOPlatformTools.INSTANCE.special().registerActionSystemAnimationMonitor(r11.W());
        r1.a(r8);
        r0.a(r8);
        if (r8 == null) goto L54;
        boolean r9 = true;
    L55:
        r1.b(r9);
        if (r10.M() == false) goto L59;
        b(r10, r0);
        return false;
    L59:
        Loog r12 = Loog.INSTANCE;
        StringBuilder r13 = new StringBuilder().append("[RuleStability] register before action, stepId=").append(r11.W()).append(", actionType=").append(r2).append(", registered=");
        if (r8 == null) goto L62;
        boolean r14 = true;
    L63:
        r12.i(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, r13.append(r14).toString());
        if (r8 != null) goto L66;
        return false;
    L66:
        return true;
    L62:
        r14 = false;
        goto L63
    L54:
        r9 = false;
        goto L55
    L22:
        r6 = null;
        goto L23
    L12:
        if (r4.unregister() == true) goto L20;
        if (r1 == null) goto L15;
        ActionSystemAnimationMonitor r15 = r1.q();
    L16:
        if (r15 != r4) goto L18;
        r1.a(null);
    L18:
        Loog.INSTANCE.w(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] previous monitor is still registered, skip new monitor, stepId=" + r11.W());
        return false;
    L15:
        r15 = null;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    private final void b(com.obric.autogui.session.a r9, C0677b r10) {
        ActionSystemAnimationMonitor r8 = r10.m();
        if (r8 != null) goto L5;
        return;
    L5:
        boolean r0 = r8.unregister();
        com.obric.autogui.agents.vlm.models.impl.g[] r1 = new com.obric.autogui.agents.vlm.models.impl.g[2];
        com.obric.autogui.operator.e r2 = r9.r();
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L8;
        com.obric.autogui.agents.vlm.models.impl.g r3 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L9:
        r1[0] = r3;
        Object r11 = d.a.p.n(r9.p());
        if (ZeusTransformUtils.instanceOf(r11, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L12;
        com.obric.autogui.agents.vlm.models.impl.g r12 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L13:
        r1[1] = r12;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(r1), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L22;
        Object r6 = r14.next();
        if (((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).q() != r8) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L15;
        r4.add(r6);
        goto L15
    L19:
        r7 = false;
        goto L20
    L22:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r15.hasNext() == false) goto L26;
        ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).a(null);
        goto L24
    L26:
        if (r0 == true) goto L28;
    L30:
        Loog.INSTANCE.i(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] session_paused, unregister=" + r0 + ", stepId=" + r8.getStepId());
        return;
    L28:
        if (r10.m() != r8) goto L30;
        r10.a(null);
        goto L30
    L12:
        r12 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }

    private final String a(com.obric.autogui.operator.e r5) {
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L5;
        com.obric.autogui.agents.vlm.models.a.b r4 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L7:
        if (r4 == null) goto L18;
        String r6 = r4.f();
        if (r6 == null) goto L18;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r7 == null) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
    L19:
        if (r7 == null) goto L21;
        return r7;
    L21:
        com.obric.autogui.operator.e.C0780e r8 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(r5.Q(), Iterable.class, "com.obric.aiagent.plugin")), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L24;
        com.obric.autogui.operator.b.EnumC0777b r9 = r8.a();
    L25:
        if (r9 != null) goto L27;
        int r10 = -1;
    L28:
        if (r10 != 1) goto L31;
        return "open_app";
    L31:
        return null;
    L27:
        r10 = c.f27133b[r9.ordinal()];
        goto L28
    L24:
        r9 = null;
        goto L25
    L15:
        r3 = false;
    L18:
        r7 = null;
        goto L19
    L5:
        r4 = null;
        goto L7
    }

    private final void b(com.obric.autogui.session.a r18, com.obric.autogui.operator.e r19) {
        if (ZeusTransformUtils.instanceOf(r19, com.obric.autogui.agents.vlm.models.impl.e.class) == true) goto L5;
        return;
    L5:
        com.obric.autogui.operator.a.b.a.a.b r2 = null;
        if (ZeusTransformUtils.instanceOf(r19, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L8;
        com.obric.autogui.agents.vlm.models.a.b r1 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r19, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 == null) goto L11;
        String r3 = r1.f();
    L13:
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == true) goto L20;
        return;
    L20:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r19.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r5.hasNext() == false) goto L29;
        Object r6 = r5.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == false) goto L22;
    L30:
        com.obric.autogui.operator.e.C0780e r8 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L33;
        return;
    L33:
        com.obric.autogui.operator.b.a r9 = r8.b();
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.operator.a.b.a.a.b.class) == false) goto L36;
        r2 = (com.obric.autogui.operator.a.b.a.a.b) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.operator.a.b.a.a.b.class, "com.obric.aiagent.plugin");
    L36:
        if (r2 != null) goto L38;
        return;
    L38:
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        String r11 = r2.b();
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L41;
    L44:
        boolean r13 = true;
    L46:
        if (r13 == false) goto L75;
        String r14 = r2.c();
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L51;
    L54:
        boolean r16 = true;
    L55:
        if (r16 == true) goto L73;
        Collection r17 = IAutoActionPackagesApi.DefaultImpls.getPackageNamesForLabel$default((IAutoActionPackagesApi) ZeusTransformUtils.preCheckCast(AOPackagesTools.INSTANCE, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r14, false, 4, null);
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r112 = r110.iterator();
    L58:
        if (r112.hasNext() == false) goto L69;
        Object r113 = r112.next();
        com.obric.autogui.operator.a.b.a.d.a r20 = com.obric.autogui.operator.a.b.a.d.f29526a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r113, String.class, "com.obric.aiagent.plugin"), r14);
        if (r20 == null) goto L64;
        boolean r21 = true;
        if (r20.b() != true) goto L65;
        boolean r22 = true;
    L66:
        if (r22 == false) goto L58;
        r111.add(r113);
    L65:
        r22 = false;
        goto L66
    L64:
        r21 = true;
        goto L65
    L69:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.aiagent.plugin");
        String r24 = (String) ZeusTransformUtils.preCheckCast(d.a.p.p(r23), String.class, "com.obric.aiagent.plugin");
        if (r24 != null) goto L72;
        r24 = "";
    L72:
        Loog.INSTANCE.w(TAG, "[ScreenShotTick] multiple packages for appName=" + r14 + ", pickedExact=" + r24 + ", exact=" + r23 + ", all=" + r17 + " [opti-openapp]");
        r11 = r24;
        goto L75
    L73:
        r11 = "";
        goto L75
    L51:
        if (d.o.o.d(r15) == true) goto L54;
        r16 = false;
    L75:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L78;
        Loog.INSTANCE.w(TAG, "[ScreenShotTick] skipped register (pkg empty), stepId=" + r19.W() + ", opInput=" + r2 + " [opti-openapp]");
        return;
    L78:
        C0677b r25 = c(r18);
        IAutoActionSpecialApi.ScreenShotTickToken r26 = AOPlatformTools.INSTANCE.special().registerScreenShotTick(r11, 0, r2.d());
        r25.a(r26);
        Loog.INSTANCE.i(TAG, "[ScreenShotTick] registered before OpenApp, token=" + r26 + ", stepId=" + r19.W() + " [opti-openapp]");
        return;
    L41:
        if (d.o.o.d(r12) == true) goto L44;
        r13 = false;
        goto L46
    L26:
        r7 = false;
        goto L27
    L29:
        r6 = null;
        goto L30
    L15:
        if (d.o.o.a(r3, "open_app", true) != true) goto L17;
        r4 = true;
        goto L18
    L11:
        r3 = null;
        goto L13
    L8:
        r1 = null;
        goto L9
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 28791. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.obric.autogui.agents.a
    public java.lang.Object b(com.obric.autogui.session.a r42, com.obric.autogui.operator.e r43, d.c.d<? super com.obric.autogui.operator.g> r44) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = (r41v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: com.obric.autogui.agents.vlm.b.b(com.obric.autogui.session.a, com.obric.autogui.operator.e, d.c.d<? super com.obric.autogui.operator.g>):java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.agents.vlm.b.b(com.obric.autogui.session.a, com.obric.autogui.operator.e, d.c.d):java.lang.Object");
    }

    private static final void a(com.obric.autogui.agents.vlm.models.omni.l r1, String r2, com.obric.autogui.agents.vlm.models.omni.e r3) {
        com.obric.autogui.agents.vlm.models.omni.d.a r0 = com.obric.autogui.agents.vlm.models.omni.d.a.f28330a;
        if (r1 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2, r3);
    }

    private static final void b(com.obric.autogui.agents.vlm.models.omni.l r9, com.obric.autogui.agents.vlm.a r10, com.obric.autogui.operator.e r11, String r12, com.obric.autogui.agents.a.f.g r13) {
        if (r9 == null) goto L40;
        com.obric.autogui.agents.vlm.models.omni.e r0 = r9.h().a(r10.a(), r11.W(), r13);
        boolean r1 = true;
        if (r0 == null) goto L6;
        boolean r3 = true;
    L7:
        com.obric.autogui.agents.a.m.v r4 = r13.j();
        Loog r5 = Loog.INSTANCE;
        StringBuilder r6 = new StringBuilder();
        r6.append("[OAutoActionEffect] execution result evaluation bound action=").append(r13.b()).append(", attempt_id=").append(r13.a()).append(", step_id=").append(r11.W()).append(", tool_id=").append(r9.a().g()).append(", action_index=").append(r10.a()).append(", action_count=").append(r10.b()).append(", is_multi_action=").append(r10.c()).append(", bound=").append(r3).append(", mode=").append(r13.e()).append(", start_status=").append(r13.c()).append(", end_status=").append(r13.d()).append(", timing_available=");
        if (r4 != null) goto L10;
    L12:
        r1 = false;
    L13:
        StringBuilder r14 = r6.append(r1).append(", evaluation_total_elapsed_ms=");
        String r15 = null;
        if (r4 == null) goto L18;
        com.obric.autogui.agents.a.m.g r16 = r4.j();
        if (r16 == null) goto L18;
        String r17 = Long.valueOf(r16.a()).toString();
    L19:
        String r2 = "";
        if (r17 != null) goto L22;
        r17 = "";
    L22:
        StringBuilder r18 = r14.append(r17).append(", lifecycle_wall_elapsed_ms=");
        if (r4 == null) goto L25;
        String r19 = Long.valueOf(r4.c()).toString();
    L26:
        if (r19 != null) goto L28;
        r19 = "";
    L28:
        StringBuilder r110 = r18.append(r19).append(", core_blocking_total_elapsed_ms=");
        if (r4 == null) goto L33;
        com.obric.autogui.agents.a.m.c r111 = r4.h();
        if (r111 == null) goto L33;
        r15 = Long.valueOf(r111.h()).toString();
    L33:
        if (r15 == null) goto L36;
        r2 = r15;
    L36:
        r110.append(r2).append(", detector_execution_count=0, snapshot_call_count=0");
        r5.i(TAG, r6.toString());
        if (r0 == null) goto L41;
        a(r9, r12, r0);
        return;
    L41:
        return;
    L25:
        r19 = null;
    L18:
        r17 = null;
        goto L19
    L10:
        if (r4.b() != true) goto L12;
    L6:
        r3 = false;
        goto L7
    }

    private static final void a(com.obric.autogui.agents.vlm.models.omni.l r7, String r8, com.obric.autogui.agents.vlm.models.impl.g r9, com.obric.autogui.agents.vlm.a r10, com.obric.autogui.agents.a.a.j r11) {
        d.h.b.o.e(r11, "observation");
        com.obric.autogui.agents.vlm.models.omni.d.c.f28333a.a(r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final x a(com.obric.autogui.agents.vlm.models.omni.l r8, com.obric.autogui.agents.vlm.a r9, com.obric.autogui.operator.e r10, z.f r11, String r12, String r13, com.obric.autogui.agents.a.f.f r14) {
        d.h.b.o.e(r12, "attemptId");
        d.h.b.o.e(r13, "actionType");
        d.h.b.o.e(r14, "mode");
        if (r8 == null) goto L9;
        if (r8.h().a(r9.a(), r10.W(), r12, r13, r14) == false) goto L7;
        r11.f38504a = r12;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] omni evaluation registered action=" + r13 + ", attempt_id=" + r12 + ", step_id=" + r10.W() + ", tool_id=" + r8.a().g() + ", action_index=" + r9.a() + ", action_count=" + r9.b() + ", is_multi_action=" + r9.c());
        goto L9
    L7:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] omni evaluation register skipped action=" + r13 + ", attempt_id=" + r12 + ", step_id=" + r10.W() + ", tool_id=" + r8.a().g() + ", action_index=" + r9.a() + ", action_count=" + r9.b() + ", is_multi_action=" + r9.c());
    L9:
        return x.f38692a;
    }

    private static final x a(z.f r16, com.obric.autogui.agents.vlm.models.omni.l r17, com.obric.autogui.agents.vlm.a r18, com.obric.autogui.operator.e r19, String r20, com.obric.autogui.agents.a.f.g r21) {
        String r1 = (String) ZeusTransformUtils.preCheckCast(r16.f38504a, String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L97;
        if (r17 == null) goto L97;
        if (r21 == null) goto L95;
        com.obric.autogui.agents.vlm.models.omni.e r2 = r17.h().b(r18.a(), r1, r21);
        boolean r8 = true;
        int r9 = 0;
        if (r2 == null) goto L10;
        boolean r10 = true;
    L11:
        com.obric.autogui.agents.a.m.v r11 = r21.j();
        Loog r12 = Loog.INSTANCE;
        StringBuilder r13 = new StringBuilder();
        r13.append("[OAutoActionEffect] omni evaluation bound action=").append(r21.b()).append(", attempt_id=").append(r21.a()).append(", step_id=").append(r19.W()).append(", tool_id=").append(r17.a().g()).append(", action_index=").append(r18.a()).append(", action_count=").append(r18.b()).append(", is_multi_action=").append(r18.c()).append(", bound=").append(r10).append(", mode=").append(r21.e()).append(", start_status=").append(r21.c()).append(", end_status=").append(r21.d()).append(", finish_reason=");
        com.obric.autogui.agents.a.m.s r3 = r21.l();
        String r4 = null;
        if (r3 == null) goto L14;
        String r5 = r3.name();
    L15:
        String r6 = "";
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        StringBuilder r7 = r13.append(r5).append(", timing_available=");
        if (r11 != null) goto L21;
    L23:
        boolean r14 = false;
    L24:
        StringBuilder r15 = r7.append(r14).append(", framework_callback_available=");
        if (r11 == null) goto L27;
        Long r22 = r11.f();
    L28:
        if (r22 != null) goto L31;
        r8 = false;
    L31:
        StringBuilder r23 = r15.append(r8).append(", registration_to_callback_elapsed_ms=");
        if (r11 == null) goto L36;
        Long r24 = r11.f();
        if (r24 == null) goto L36;
        String r25 = r24.toString();
    L37:
        if (r25 != null) goto L39;
        r25 = "";
    L39:
        StringBuilder r26 = r23.append(r25).append(", framework_callback_processing_elapsed_ms=");
        if (r11 == null) goto L44;
        Long r27 = r11.g();
        if (r27 == null) goto L44;
        String r28 = r27.toString();
    L45:
        if (r28 != null) goto L47;
        r28 = "";
    L47:
        StringBuilder r29 = r26.append(r28).append(", evaluation_total_elapsed_ms=");
        if (r11 == null) goto L52;
        com.obric.autogui.agents.a.m.g r30 = r11.j();
        if (r30 == null) goto L52;
        String r31 = Long.valueOf(r30.a()).toString();
    L53:
        if (r31 != null) goto L55;
        r31 = "";
    L55:
        StringBuilder r32 = r29.append(r31).append(", lifecycle_wall_elapsed_ms=");
        if (r11 == null) goto L58;
        String r33 = Long.valueOf(r11.c()).toString();
    L59:
        if (r33 != null) goto L61;
        r33 = "";
    L61:
        StringBuilder r34 = r32.append(r33).append(", core_blocking_total_elapsed_ms=");
        if (r11 == null) goto L66;
        com.obric.autogui.agents.a.m.c r35 = r11.h();
        if (r35 == null) goto L66;
        String r36 = Long.valueOf(r35.h()).toString();
    L67:
        if (r36 != null) goto L69;
        r36 = "";
    L69:
        StringBuilder r37 = r34.append(r36).append(", preparation_elapsed_ms=");
        if (r11 == null) goto L74;
        com.obric.autogui.agents.a.m.c r38 = r11.h();
        if (r38 == null) goto L74;
        String r39 = Long.valueOf(r38.a()).toString();
    L75:
        if (r39 != null) goto L77;
        r39 = "";
    L77:
        StringBuilder r40 = r37.append(r39).append(", completion_elapsed_ms=");
        if (r11 == null) goto L82;
        com.obric.autogui.agents.a.m.c r41 = r11.h();
        if (r41 == null) goto L82;
        r4 = Long.valueOf(r41.f()).toString();
    L82:
        if (r4 == null) goto L85;
        r6 = r4;
    L85:
        StringBuilder r42 = r40.append(r6).append(", detector_execution_count=");
        if (r11 == null) goto L92;
        com.obric.autogui.agents.a.m.g r43 = r11.j();
        if (r43 == null) goto L92;
        List<com.obric.autogui.agents.a.m.e> r44 = r43.f();
        if (r44 == null) goto L92;
        r9 = r44.size();
    L92:
        r42.append(r9);
        r12.i(TAG, r13.toString());
        if (r2 == null) goto L97;
        a(r17, r20, r2);
    L74:
        r39 = null;
    L66:
        r36 = null;
        goto L67
    L58:
        r33 = null;
    L52:
        r31 = null;
    L44:
        r28 = null;
    L36:
        r25 = null;
        goto L37
    L27:
        r22 = null;
        goto L28
    L21:
        if (r11.b() != true) goto L23;
        r14 = true;
        goto L24
    L14:
        r5 = null;
        goto L15
    L10:
        r10 = false;
        goto L11
    L95:
        r17.h().a(r18.a(), r1);
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] omni evaluation registration removed attempt_id=" + r1 + ", step_id=" + r19.W() + ", tool_id=" + r17.a().g() + ", action_index=" + r18.a() + ", action_count=" + r18.b() + ", reason=route_skipped");
    L97:
        return x.f38692a;
    }

    private final Object a(com.obric.autogui.operator.e r19, d.c.d<? super com.obric.autogui.agents.vlm.models.a.a.b> r20) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r19, com.obric.autogui.agents.vlm.models.impl.g.class) == true) goto L5;
    L9:
        Loog.INSTANCE.i(TAG, "[AfterExecScreenState] skipped stepId=" + r19.W() + ", stepType=" + r19.getClass().getSimpleName());
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r19, com.obric.autogui.operator.j.class) == true) goto L9;
        long r4 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.i(TAG, "[AfterExecScreenState] begin stepId=" + r19.W());
        long r6 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.i(TAG, "[AfterExecScreenState] fetch top component begin stepId=" + r19.W());
        com.obric.autogui.common.d<ComponentName> r2 = AutoActionVirtualDisplay.INSTANCE.getVdTopComponent();
        Loog.INSTANCE.i(TAG, "[AfterExecScreenState] fetch top component holder end stepId=" + r19.W() + ", latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r6) + "ms");
        long r8 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.i(TAG, "[AfterExecScreenState] read top component payload begin stepId=" + r19.W());
        ComponentName r13 = (ComponentName) ZeusTransformUtils.preCheckCast(r2.a(), ComponentName.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "[AfterExecScreenState] read top component payload end stepId=" + r19.W() + ", payload=" + r13 + ", latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r8) + "ms");
        Loog.INSTANCE.i(TAG, "[AfterExecScreenState] end stepId=" + r19.W() + ", totalLatency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r4) + "ms");
        Loog.INSTANCE.d(TAG, "Fetched after-exec ScreenState for step=" + r19.W());
        return new com.obric.autogui.agents.vlm.models.a.a.b(null, r13, null, null, 13, null);
    }

    private final Object c(final com.obric.autogui.session.a r38, final com.obric.autogui.operator.e r39, d.c.d<? super Boolean> r40) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r40, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, m.class) == false) goto L7;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin");
        if ((r1.f27181e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f27181e -= Integer.MIN_VALUE;
    L8:
        m r9 = r1;
        Object r2 = r9.f27179c;
        Object r10 = d.c.a.b.a();
        int r3 = r9.f27181e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r2);
    L95:
        return d.c.b.a.b.a(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.f27178b, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r5 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r9.f27177a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L88:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L91;
        Loog.INSTANCE.e(TAG, "[OpenAppInPlace] record-set add failed; package=" + r4 + " owner=" + r5.a() + ". not bringing task to vd.");
        return d.c.b.a.b.a(false);
    L91:
        r9.f27177a = null;
        r9.f27178b = null;
        r9.f27181e = 2;
        if (kotlinx.coroutines.ax.a(300, r9) != r10) goto L95;
        return r10;
    L16:
        d.o.a(r2);
        if (ZeusTransformUtils.instanceOf(r39, com.obric.autogui.agents.vlm.models.a.e.class) == true) goto L99;
        if (c(r38).f() == true) goto L99;
        if (ZeusTransformUtils.instanceOf(r39, com.obric.autogui.agents.vlm.models.impl.e.class) == true) goto L26;
        return d.c.b.a.b.a(true);
    L26:
        if (g.contains(((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r39, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin")).f()) == true) goto L97;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r39.Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L30;
    L32:
        Iterator r7 = r6.iterator();
    L34:
        if (r7.hasNext() == false) goto L31;
        com.obric.autogui.operator.e.C0780e r8 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r8.a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L38;
    L41:
        boolean r11 = true;
    L42:
        if (r11 == false) goto L34;
        boolean r12 = true;
    L44:
        if (r12 == true) goto L97;
        com.obric.autogui.session.state.a r13 = r38.m().e();
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.session.state.a.h.class) == false) goto L49;
        com.obric.autogui.session.state.a.h r14 = (com.obric.autogui.session.state.a.h) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.session.state.a.h.class, "com.obric.aiagent.plugin");
    L50:
        if (r14 != null) goto L53;
        Loog.INSTANCE.d(TAG, "[OpenAppInPlace] not in operating state. not bringing task to vd.");
        return d.c.b.a.b.a(true);
    L53:
        final DisplayedAppInfo r15 = r14.a();
        if (r15 != null) goto L57;
        Loog.INSTANCE.w(TAG, "[OpenAppInPlace] no task-to-bring candidate. not bringing task to vd.");
        return d.c.b.a.b.a(true);
    L57:
        ComponentName r16 = r15.getRealActivity();
        if (r16 == null) goto L63;
        String r17 = r16.getPackageName();
        if (r17 == null) goto L63;
    L62:
        String r18 = r17;
    L67:
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L70;
    L73:
        boolean r20 = true;
    L74:
        if (r20 == false) goto L77;
        Loog.INSTANCE.e(TAG, "[OpenAppInPlace] record-set gate blocked; reason=empty_package. not bringing task to vd.");
        com.obric.autogui.agents.vlm.models.impl.applist.black.m.f27494a.a(new com.obric.autogui.agents.vlm.models.impl.applist.black.s("package_gate", "blocked", "empty_package", "start_in_place", null, null, null, null, null, null, null, null, null, null, null, d.c.b.a.b.a(true), d.c.b.a.b.a(false), null, 163824, null), r38);
        return d.c.b.a.b.a(false);
    L77:
        final boolean r21 = a(com.obric.autogui.session.e.f30963a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r38.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r15, false);
        Loog.INSTANCE.i(TAG, "isSameApp=" + r21);
        if (r21 == false) goto L80;
    L83:
        d.h.a.m r110 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r38, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        final String r22 = r18;
        String r111 = r18;
        d.h.a.a r23 = new $$Lambda$b$WZppSGcLFl7ytyq1_E5AiVn4ZA(r21, this, r15, r22, r39, r38);
        r9.f27177a = r38;
        r9.f27178b = r111;
        r9.f27181e = 1;
        r2 = com.obric.autogui.agents.vlm.c.a(r111, r110, r23, r9);
        if (r2 != r10) goto L86;
        return r10;
    L86:
        r5 = r38;
        r4 = r111;
        goto L88
    L80:
        if (a(AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo(), r15, true) == false) goto L83;
        Loog.INSTANCE.e(TAG, "vd top app is the target app. not bringing task to vd.");
        return d.c.b.a.b.a(true);
    L70:
        if (d.o.o.d(r19) == true) goto L73;
        r20 = false;
    L63:
        ComponentName r24 = r15.getTopActivity();
        if (r24 == null) goto L66;
        r17 = r24.getPackageName();
        goto L62
    L66:
        r18 = null;
        goto L67
    L49:
        r14 = null;
        goto L50
    L38:
        if (r8.a() == com.obric.autogui.operator.b.EnumC0777b.i) goto L41;
        r11 = false;
    L31:
        r12 = false;
        goto L44
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L32;
    L97:
        return d.c.b.a.b.a(true);
    L99:
        return d.c.b.a.b.a(true);
    L7:
        r1 = new m(this, r0);
        goto L8
    }

    private static final x a(boolean r17, b r18, DisplayedAppInfo r19, String r20, com.obric.autogui.operator.e r21, com.obric.autogui.session.a r22) {
        DisplayedAppInfo r4 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r19, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        if (r17 == true) goto L6;
        r18.a(r4, r20);
        r18.a(r4, r21, r22);
        return x.f38692a;
    L6:
        Loog.INSTANCE.i(TAG, "[OpenAppInPlace] bringing task=" + r4 + " to VD.");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IAutoActionPresentationApi r7 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        String r8 = null;
        if (r7 == null) goto L11;
        Intent r9 = r7.getOpenPlayerIntent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "start_in_place");
        if (r9 == null) goto L11;
        r9.addFlags(65536);
    L12:
        ZeusTransformUtils.startActivity(r6, r9, "com.obric.aiagent.plugin");
        r18.a(r4, r20);
        IAutoActionTrackingApi r10 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r11 = new JSONObject();
        r11.put("scenario", "OperationInPlace");
        if (ZeusTransformUtils.instanceOf(r21, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L15;
        com.obric.autogui.agents.vlm.models.a.b r5 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L16:
        if (r5 == null) goto L18;
        r8 = r5.f();
    L18:
        r11.put("operation", r8);
        r11.put("package_name", r20);
        com.obric.autogui.session.c.b.a(r11, r22);
        x r1 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r10, "start_in_place", r11, false, false, null, 28, null);
        r18.a(r4, r21, r22);
        return x.f38692a;
    L15:
        r5 = null;
    L11:
        r9 = null;
        goto L12
    }

    private final boolean a(DisplayedAppInfo r4, DisplayedAppInfo r5, boolean r6) {
        DisplayedAppInfo r3 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        DisplayedAppInfo r7 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r5, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        ComponentName r1 = null;
        if (r6 == false) goto L19;
        if (r3 == null) goto L6;
        ComponentName r8 = r3.getTopActivity();
    L8:
        if (d.h.b.o.a(r8, r7.getTopActivity()) == false) goto L30;
        if (r3 == null) goto L11;
        ComponentName r9 = r3.getRealActivity();
    L13:
        if (d.h.b.o.a(r9, r7.getRealActivity()) == false) goto L30;
        if (r3 == null) goto L17;
        r1 = r3.getBaseActivity();
    L17:
        if (d.h.b.o.a(r1, r7.getBaseActivity()) == false) goto L30;
        return true;
    L11:
        r9 = null;
    L30:
        return false;
    L6:
        r8 = null;
        goto L8
    L19:
        if (r3 == null) goto L21;
        ComponentName r10 = r3.getRealActivity();
    L23:
        if (d.h.b.o.a(r10, r7.getRealActivity()) == false) goto L30;
        if (r3 == null) goto L27;
        r1 = r3.getBaseActivity();
    L27:
        if (d.h.b.o.a(r1, r7.getBaseActivity()) == false) goto L30;
        return true;
    L21:
        r10 = null;
        goto L23
    }

    private final void a(DisplayedAppInfo r8, String r9) {
        DisplayedAppInfo r7 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r8, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        Collection<DisplayedAppInfo> r10 = AutoActionVirtualDisplay.INSTANCE.fetchMdTopAppInfo(20, false);
        String r3 = null;
        if (r10 == null) goto L15;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r11.hasNext() == false) goto L13;
        Object r4 = r11.next();
        if (((DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin")).getTaskId() != r7.getTaskId()) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L6;
    L14:
        DisplayedAppInfo r12 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
    L17:
        if (r12 == null) goto L19;
        AutoActionVirtualDisplay.INSTANCE.bringMdAppToVd(r7.getTaskId());
        Loog.INSTANCE.i(TAG, "existing app=" + r12 + ". just bringing task to vd.");
        return;
    L19:
        if (r9 == null) goto L21;
        r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L21:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L24;
    L25:
        r2 = true;
    L26:
        if (r2 == true) goto L28;
        AutoActionVirtualDisplay.INSTANCE.openAppInVd(r3);
    L28:
        Loog.INSTANCE.i(TAG, "there is no existing app. open new task to vd.");
        return;
    L24:
        if (d.o.o.d(r13) == false) goto L26;
    L10:
        r5 = false;
        goto L11
    L13:
        r4 = null;
        goto L14
    L15:
        r12 = null;
        goto L17
    }

    private final void a(DisplayedAppInfo r12, com.obric.autogui.operator.e r13, com.obric.autogui.session.a r14) {
        ComponentName r11 = ((DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r12, DisplayedAppInfo.class, "com.obric.aiagent.plugin")).getRealActivity();
        if (r11 == null) goto L20;
        AOPackagesTools r15 = AOPackagesTools.INSTANCE;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r2 = r11.getPackageName();
        d.h.b.o.c(r2, "getPackageName(...)");
        AppInfoEntry r16 = r15.getAppInfo(r1, r2);
        CharSequence r3 = null;
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L7;
        com.obric.autogui.agents.vlm.models.a.b r17 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L8:
        if (r17 == null) goto L10;
        String r18 = r17.f();
    L11:
        IAutoActionTrackingApi r4 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("operate_type_lv1", "open_app_in_place");
        r5.put("operate_type_lv2", "action-" + r18);
        r5.put("package_name", r11.getPackageName());
        if (r16 == null) goto L14;
        CharSequence r19 = r16.getAppLabel();
    L15:
        r5.put("target_app_name", r19);
        if (r16 == null) goto L18;
        r3 = r16.getAppLabel();
    L18:
        r5.put("actual_app_name", r3);
        r5.put("extra", "p=" + r11);
        r5.put(DBHelper.COL_TIME, System.currentTimeMillis());
        com.obric.autogui.session.c.b.a(r5, r14);
        x r110 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r4, "oauto_operate_app", r5, false, false, null, 28, null);
        return;
    L14:
        r19 = null;
        goto L15
    L10:
        r18 = null;
        goto L11
    L7:
        r17 = null;
        goto L8
    }

    private final Object c(com.obric.autogui.session.a r9, com.obric.autogui.agents.a.d r10, d.c.d<? super com.obric.autogui.common.d<com.obric.autogui.operator.e>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, r.class) == false) goto L7;
        r r1 = (r) ZeusTransformUtils.preCheckCast(r12, r.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.f27202d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r1.f27199a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L32:
        com.obric.autogui.common.d r14 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e r15 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r14.a(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (r14.g() == true) goto L35;
        return r14;
    L35:
        if (r15 != null) goto L38;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r8), "make the step failed: " + r14.h() + "; step=" + r15);
        return com.obric.autogui.common.d.f29012a.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L38:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.agents.vlm.models.c r16 = (com.obric.autogui.agents.vlm.models.c) ZeusTransformUtils.preCheckCast(r1.f27201c, com.obric.autogui.agents.vlm.models.c.class, "com.obric.aiagent.plugin");
        C0677b r17 = (C0677b) ZeusTransformUtils.preCheckCast(r1.f27200b, C0677b.class, "com.obric.aiagent.plugin");
        b r18 = (b) ZeusTransformUtils.preCheckCast(r1.f27199a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L24:
        com.obric.autogui.common.d r19 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        if (r19.g() == false) goto L27;
        Object r110 = r19.a();
        d.h.b.o.a(r110);
        com.obric.autogui.agents.vlm.models.c.b r111 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r110, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        r1.f27199a = r18;
        r1.f27200b = null;
        r1.f27201c = null;
        r1.f = 2;
        r13 = r16.a(r17, r111, r1);
        if (r13 != r3) goto L31;
        return r3;
    L31:
        r8 = r18;
        goto L32
    L27:
        return com.obric.autogui.common.d.f29012a.a("prepare for the step failed: " + r19.h());
    L16:
        d.o.a(r13);
        r17 = c(r9);
        com.obric.autogui.agents.vlm.models.c r112 = r17.d();
        if (r112 == null) goto L19;
        r1.f27199a = this;
        r1.f27200b = r17;
        r1.f27201c = r112;
        r1.f = 1;
        Object r113 = r112.a(r17, r10, r1);
        if (r113 != r3) goto L23;
        return r3;
    L23:
        r18 = this;
        r16 = r112;
        r13 = r113;
        goto L24
    L19:
        return com.obric.autogui.common.d.f29012a.a("model is not initialized.");
    L7:
        r1 = new r(this, r12);
        goto L8
    }

    @Override // com.obric.autogui.agents.a
    public Object a(com.obric.autogui.session.a r26, com.obric.autogui.agents.a.d r27, d.c.d<? super com.obric.autogui.agents.a.b> r28) {
        b r9 = this;
        com.obric.autogui.session.a r10 = r26;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, j.class) == false) goto L7;
        j r1 = (j) ZeusTransformUtils.preCheckCast(r0, j.class, "com.obric.aiagent.plugin");
        if ((r1.i & Integer.MIN_VALUE) == 0) goto L7;
        r1.i -= Integer.MIN_VALUE;
    L8:
        j r2 = r1;
        Object r3 = r2.g;
        Object r12 = d.c.a.b.a();
        int r4 = r2.i;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r5 = r2.f;
        ActionSystemAnimationMonitor r6 = (ActionSystemAnimationMonitor) ZeusTransformUtils.preCheckCast(r2.f27166e, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
        C0677b r7 = (C0677b) ZeusTransformUtils.preCheckCast(r2.f27165d, C0677b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r8 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r2.f27164c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r11 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r2.f27163b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r13 = (b) ZeusTransformUtils.preCheckCast(r2.f27162a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L14
        ActionSystemAnimationMonitor r15 = r6;
        long r14 = r5;
        com.obric.autogui.agents.a.d r16 = r8;
    L76:
        com.obric.autogui.agents.a.b r17 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        r13.a(r11, r7, r15);
        long r18 = AOSystemTools.INSTANCE.nowTimeMillis() - r14;
        if (r17 != null) goto L62;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(r13), " - [VLM-PredJudge] l=" + r18 + " - reaches time limit.");
        com.obric.autogui.agents.b.c r19 = r13.c();
        if (r19 == null) goto L57;
        r19.b(r11);
    L57:
        if (com.obric.autogui.agents.b.b.a(r11) == false) goto L61;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r13), "event=access_ui_wait_outer_timeout sessionKey=" + r11.a() + " stepId=" + r16.b() + " elapsedMs=" + r18);
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error")), 0, 4, null);
    L61:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L62:
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r13), " - [VLM-PredJudge] l=" + r18 + " - proceed as usual.");
        return r17;
    L64:
        th = th;
        r10 = r11;
        r9 = r13;
    L66:
        r6 = r15;
    L72:
        r9.a(r10, r7, r6);
        throw th;
    L14:
        th = th;
        r10 = r11;
        r9 = r13;
        goto L72
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r3);
        C0677b r20 = c(r26);
        ActionSystemAnimationMonitor r21 = r20.m();
        if (r21 != null) goto L27;
        Object r22 = d.a.p.n(r26.p());
        if (ZeusTransformUtils.instanceOf(r22, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L23;
        com.obric.autogui.agents.vlm.models.impl.g r23 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r22, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L24:
        if (r23 == null) goto L26;
        r21 = r23.q();
        goto L27
    L26:
        ActionSystemAnimationMonitor r24 = null;
    L28:
        com.obric.autogui.common.a.k r25 = r20.c();
        if (r25 != null) goto L33;
        r9.a(r10, r20, r24);
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r9), "cannot obtain config during step-making (judgePredCondition).");
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error")), 0, 4, null);
    L33:
        if (r20.e() == true) goto L35;
    L38:
        com.obric.autogui.agents.c[] r29 = r9.f27111d;
        com.obric.autogui.agents.b.g r30 = r9.f27112e;
        if (r29 == null) goto L74;
        if (r30 == null) goto L74;
        long r110 = AOSystemTools.INSTANCE.nowTimeMillis();
        long r111 = r9.a(r25, r10);
        r15 = r24;
        C0677b r112 = r20;
        d.h.a.m r31 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r30, r26, r25, r27, this, r29, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L67
        r2.f27162a = r9;     // Catch: Throwable -> L67
        r2.f27163b = r10;     // Catch: Throwable -> L67
        r16 = r27;
        r2.f27164c = r16;     // Catch: Throwable -> L67
        r2.f27165d = r112;     // Catch: Throwable -> L67
        r2.f27166e = r15;     // Catch: Throwable -> L67
        r14 = r110;
        r2.f = r14;     // Catch: Throwable -> L67
        r2.i = 1;     // Catch: Throwable -> L67
        r3 = dg.b(r111, r31, r2);     // Catch: Throwable -> L67
        if (r3 != r12) goto L49;
        return r12;
    L49:
        r13 = r9;
        r11 = r10;
        r7 = r112;
    L67:
        th = th;
    L71:
        r7 = r112;
    L69:
        th = th;
        r15 = r24;
        r112 = r20;
    L74:
        r9.a(r10, r20, r24);
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(r9), " - [VLM-PredJudge] no predCondition judges are initialized.");
        return com.obric.autogui.agents.a.b.f26124a.a();
    L35:
        if (r26.N().get() > 1) goto L38;
        return com.obric.autogui.agents.a.b.f26124a.a();
    L23:
        r23 = null;
    L27:
        r24 = r21;
    L7:
        r1 = new j(r9, r0);
        goto L8
    }

    private final void d(com.obric.autogui.session.a r3) {
        Object r2 = d.a.p.n(r3.p());
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L5;
        com.obric.autogui.agents.vlm.models.impl.g r4 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.agents.vlm.models.a.e.class) == false) goto L11;
        return;
    L11:
        com.obric.autogui.agents.vlm.models.omni.r r5 = com.obric.autogui.agents.vlm.models.omni.t.f28523a.a(r3.b());
        if (r5 == null) goto L18;
        com.obric.autogui.agents.vlm.models.omni.l r6 = r5.e();
        if (r6 == null) goto L19;
        r6.a(r4.r());
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void a(com.obric.autogui.session.a r7, C0677b r8, ActionSystemAnimationMonitor r9) {
        ActionSystemAnimationMonitor r10 = (ActionSystemAnimationMonitor) ZeusTransformUtils.wrapperContextForParams(r9, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
        return;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.p(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L7;
        r2.add(r3);
        goto L7
    L11:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L20;
        Object r11 = r6.next();
        if (((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).q() != r10) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L13;
        r5.add(r11);
        goto L13
    L17:
        r12 = false;
        goto L18
    L20:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        boolean r14 = r10.unregister();
        if (r10.hasPageSwitchStarted() == false) goto L26;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r15.hasNext() == false) goto L26;
        ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).s();
    L26:
        d(r7);
        if (r14 == true) goto L31;
        Loog.INSTANCE.w(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] retain monitor for unregister retry, stepId=" + r10.getStepId());
        return;
    L31:
        if (r8.m() != r10) goto L33;
        r8.a(null);
    L33:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L35:
        if (r16.hasNext() == false) goto L37;
        ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).a(null);
        goto L35
    }

    @Override // com.obric.autogui.agents.a
    public Object a(com.obric.autogui.session.a r6, com.obric.autogui.operator.e r7, com.obric.autogui.operator.g r8, d.c.d<? super com.obric.autogui.operator.g> r9) {
        com.obric.autogui.operator.g r10 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, o.class) == false) goto L7;
        o r0 = (o) ZeusTransformUtils.preCheckCast(r11, o.class, "com.obric.aiagent.plugin");
        if ((r0.f27188d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27188d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f27186b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27188d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.autogui.operator.g r13 = (com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r0.f27185a, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autogui.agents.vlm.models.a.e.class) == true) goto L17;
        c(r6).o().b();
        c(r6).a(true);
    L17:
        r0.f27185a = r10;
        r0.f27188d = 1;
        if (b(r6, r7, r10, r0) != r2) goto L21;
        return r2;
    L21:
        return r10;
    L7:
        r0 = new o(this, r11);
        goto L8
    }

    private final Object b(com.obric.autogui.session.a r20, com.obric.autogui.operator.e r21, com.obric.autogui.operator.g r22, d.c.d<? super x> r23) {
        b r0 = this;
        com.obric.autogui.session.a r1 = r20;
        com.obric.autogui.operator.g r3 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, l.class) == false) goto L7;
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if ((r6.j & Integer.MIN_VALUE) == 0) goto L7;
        r6.j -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.h;
        Object r8 = d.c.a.b.a();
        int r9 = r6.j;
        Bitmap r10 = null;
        if (r9 == 0) goto L17;
        if (r9 != 1) goto L16;
        int r2 = r6.g;
        IAutoActionAgentEventListener.AgentStepInfo r4 = (IAutoActionAgentEventListener.AgentStepInfo) ZeusTransformUtils.preCheckCast(r6.f, IAutoActionAgentEventListener.AgentStepInfo.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.f27176e, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a.d r12 = (com.obric.autogui.session.a.d) ZeusTransformUtils.preCheckCast(r6.f27175d, com.obric.autogui.session.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.g r13 = (com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r6.f27174c, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r14 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r6.f27173b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        b r15 = (b) ZeusTransformUtils.preCheckCast(r6.f27172a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r7);     // Catch: CancellationException -> L14
        String r16 = r11;
        IAutoActionAgentEventListener.AgentStepInfo r17 = r4;
        r1 = r14;
        com.obric.autogui.session.a.d r18 = r12;
        r3 = r13;
        int r19 = r2;
        r0 = r15;
        Object r24 = r7;
    L34:
        r10 = (Bitmap) ZeusTransformUtils.preCheckCast(r24, Bitmap.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L36
    L38:
        Bitmap r110 = r10;
        com.obric.autogui.b.a r25 = com.obric.autogui.b.a.f28928a;
        IAutoActionAgentEventListener.SessionInfo r26 = r1.d();
        String r111 = r18.b() + '/' + r16;
        com.obric.autogui.session.a.d r27 = r1.z();
        if (r27 == null) goto L45;
        File r28 = r27.b();
        if (r28 == null) goto L45;
        String r29 = r28.getAbsolutePath();
        if (r29 == null) goto L45;
    L46:
        r25.afterAgentStep(r26, r17, new IAutoActionAgentEventListener.AgentStepExecInfo(r110, r111, r29, !r3.a(), r3.f()));
    L47:
        com.obric.autogui.session.d.h r30 = r1.k().a();
        if (r30 == null) goto L50;
        r30.c();
    L50:
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r0), "[Step #" + r19 + "] - step logged.");
        return x.f38692a;
    L45:
        r29 = "";
    L36:
        r13 = r3;
        r12 = r18;
    L37:
        Loog.INSTANCE.e(TAG, " - [StepLog] failed to acquire after-exec screenshot for step=" + r17.getAction() + " (cancelled)");
        r18 = r12;
        r3 = r13;
    L14:
        r19 = r2;
        r16 = r11;
        r0 = r15;
        r17 = r4;
        r1 = r14;
        goto L37
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r7);
        r19 = r20.s();
        r18 = r20.y();
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r0), "[Step #" + r19 + "] - started to log for step #" + r19);
        if (ZeusTransformUtils.instanceOf(r21, com.obric.autogui.agents.vlm.models.a.c.class) == false) goto L24;
        JsonObject r112 = ((com.obric.autogui.agents.vlm.models.a.c) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.agents.vlm.models.a.c.class, "com.obric.aiagent.plugin")).v();
        if (r112 == null) goto L24;
        r18.a("step_" + r19 + "_rep", (JsonElement) ZeusTransformUtils.preCheckCast(r112, JsonElement.class, "com.obric.aiagent.plugin"));
        r18.a(r112);
        IAutoActionAgentEventListener.AgentStepInfo r113 = r21.T();
        if (r113 == null) goto L24;
        r0.a(r1, r19, r113);
    L24:
        String r114 = String.format("%03d", Arrays.copyOf(new Object[]{d.c.b.a.b.a(r19)}, 1));
        d.h.b.o.c(r114, "format(...)");
        r16 = r114 + "_01_action.jpg";
        r17 = r21.T();
        if (r17 == null) goto L47;
        if (r20.L() == true) goto L54;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(r0), " - waived `afterAgentStep` callback for (`" + r17.getAction() + "`) due to session not running.");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(r0), " - current state = " + r20.m().e());
        goto L47
    L54:
        if (r17.isLastStep() == false) goto L38;
        com.obric.autogui.session.state.termination.a r115 = r20.J();     // Catch: CancellationException -> L36
        r6.f27172a = r0;     // Catch: CancellationException -> L36
        r6.f27173b = r1;     // Catch: CancellationException -> L36
        r6.f27174c = r3;     // Catch: CancellationException -> L36
        r6.f27175d = r18;     // Catch: CancellationException -> L36
        r6.f27176e = r16;     // Catch: CancellationException -> L36
        r6.f = r17;     // Catch: CancellationException -> L36
        r6.g = r19;     // Catch: CancellationException -> L36
        r6.j = 1;     // Catch: CancellationException -> L36
        r24 = r115.a(r6);     // Catch: CancellationException -> L36
        if (r24 != r8) goto L34;
        return r8;
    L7:
        r6 = new l(r0, r5);
        goto L8
    }

    private final void a(com.obric.autogui.session.a r19, int r20, IAutoActionAgentEventListener.AgentStepInfo r21) {
        if (r19.c() == true) goto L5;
        return;
    L5:
        String r0 = r19.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        r0 = r19.a();
    L11:
        String r1 = r0;
        String r9 = r19.l().getRepresentativeTaskString();
        String r2 = com.obric.autogui.agents.vlm.cocreation.c.f27232a.a(r19);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
    L44:
        Loog.INSTANCE.w(TAG, "[OmniLabeling] skip invalid recordId=" + r1 + ", userQueryLength=" + r9.length());
        return;
    L14:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L44;
        if (r21.isLastStep() == false) goto L22;
        Bundle r6 = r21.getExtras();
        if (r6 == null) goto L21;
        boolean r7 = r6.getBoolean("model_success", r21.isSuccess());
    L23:
        boolean r14 = r7;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L37
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        Loog r11 = Loog.INSTANCE;     // Catch: Throwable -> L37
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L37
        r12.append("[OmniLabeling] dispatch step recordId=").append(r1).append(", sessionId=").append(r19.b()).append(", sessionKey=").append(r19.a()).append(", stepIndex=").append(r20).append(", createdAt=").append(r19.e().getTime()).append(", finishAt=").append(r21.getFinishTimeMills()).append(", last=").append(r21.isLastStep()).append(", rawSuccess=").append(r21.isSuccess()).append(", finalSuccess=").append(r14).append(", taskTriggerType=").append(r2).append(", query=").append(a(r10, r9, 0, 1, null)).append(", action=");     // Catch: Throwable -> L37
        r12.append(a(r10, r21.getAction(), 0, 1, null)).append(", thought=").append(a(r10, r21.getThought(), 0, 1, null));     // Catch: Throwable -> L37
        r11.i(TAG, r12.toString());     // Catch: Throwable -> L37
        IOmniLabelingDataSink r3 = (IOmniLabelingDataSink) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniLabelingDataSink.class), IOmniLabelingDataSink.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r3 != null) goto L27;
        Loog.INSTANCE.w(TAG, "[OmniLabeling] data sink missing, recordId=" + r1);     // Catch: Throwable -> L37
        String r4 = TAG;
    L33:
        Object r5 = d.n.f(x.f38692a);     // Catch: Throwable -> L35
    L40:
        Throwable r13 = d.n.c(r5);
        if (r13 == null) goto L49;
        Loog.INSTANCE.w(r4, "[OmniLabeling] failed to dispatch step, recordId=" + r1 + ", error=" + r13.getMessage());
        return;
    L49:
        return;
    L35:
        th = th;
    L39:
        d.n.a r15 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L40
    L27:
        long r16 = r19.e().getTime();     // Catch: Throwable -> L37
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r21.getAction(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (d.o.o.d(r17) == false) goto L30;
        r17 = r21.getThought();     // Catch: Throwable -> L37
    L30:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        String r110 = r21.getThought();     // Catch: Throwable -> L37
        boolean r111 = r21.isLastStep();     // Catch: Throwable -> L37
        long r112 = r21.getFinishTimeMills();     // Catch: Throwable -> L37
        r4 = TAG;
        r3.onStepLogged(new OmniLabelingStepRecord(r1, r16, r9, r20, r18, r110, r111, r14, r112, r2));     // Catch: Throwable -> L35
    L37:
        th = th;
        r4 = TAG;
        goto L39
    L21:
        r7 = r21.isSuccess();
        goto L23
    L22:
        r7 = r21.isSuccess();
        goto L23
    }

    static /* synthetic */ String a(b r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 96;
    L6:
        return r0.a(r1, r2);
    }

    private final String a(String r7, int r8) {
        String r6 = d.o.o.a(r7, "\n", "\\n", false, 4, null);
        if (r6.length() > r8) goto L6;
        return r6;
    L6:
        return d.o.o.e(r6, r8) + "...";
    }

    public final Map<String, String> b() {
        com.obric.autogui.agents.b.c r0 = c();
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return ao.b();
    }

    private final com.obric.autogui.agents.b.c c() {
        com.obric.autogui.agents.c[] r6 = this.f27111d;
        if (r6 == null) goto L11;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r3 = r6.length;
    L5:
        if (r1 >= r3) goto L16;
        com.obric.autogui.agents.c r4 = r6[r1];
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.agents.b.c.class) == false) goto L9;
        r0.add(r4);
    L9:
        r1 = r1 + 1;
        goto L5
    L16:
        return (com.obric.autogui.agents.b.c) ZeusTransformUtils.preCheckCast(d.a.p.l((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin")), com.obric.autogui.agents.b.c.class, "com.obric.aiagent.plugin");
    L11:
        return null;
    }

    @Override // com.obric.autogui.agents.a
    public void a(com.obric.autogui.session.a r6) {
        d.h.b.o.e(r6, SensitiveType.SESSION);
        super.a(r6);
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - cleansing vlm-agent for session=" + r6.b());
        c(r6).a(null);
        com.obric.autogui.agents.a.f r0 = this.f27110c;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.f27110c = null;
        com.obric.autogui.agents.vlm.models.a.a r1 = this.f27109b;
        if (r1 != null) goto L8;
        d.h.b.o.c("mScreenshotProvider");
        r1 = null;
    L8:
        r1.e();
        com.obric.autogui.agents.c[] r2 = this.f27111d;
        if (r2 == null) goto L13;
        int r3 = 0;
        int r4 = r2.length;
    L11:
        if (r3 >= r4) goto L13;
        r2[r3].a(r6);
        r3 = r3 + 1;
    L13:
        com.obric.autogui.agents.b.g r5 = this.f27112e;
        if (r5 == null) goto L16;
        r5.a(r6);
    L16:
        C0677b r7 = c(r6);
        ActionSystemAnimationMonitor r8 = r7.m();
        if (r8 != null) goto L19;
    L22:
        r7.a(null);
    L23:
        com.obric.autogui.agents.vlm.models.c r9 = r7.d();
        if (r9 == null) goto L26;
        r9.a();
    L26:
        r7.a(null);
        com.obric.autogui.operator.a.b.f29284a.b();
        return;
    L19:
        if (r8.unregister() == true) goto L22;
        Loog.INSTANCE.w(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] retain monitor after cleanse unregister failure, stepId=" + r8.getStepId());
        goto L23
    }
}
