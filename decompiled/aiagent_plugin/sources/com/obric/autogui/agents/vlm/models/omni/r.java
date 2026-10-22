package com.obric.autogui.agents.vlm.models.omni;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.IFlowFrontierIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.ad;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.TaskState;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: OmniSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    private static final String TAG = "OmniActionsHolder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile String f28466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f28467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.a.d<com.obric.autogui.agents.vlm.models.omni.l> f28468e;
    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper f;
    private final com.obric.autogui.agents.vlm.models.omni.c.j g;
    private volatile com.obric.autogui.agents.vlm.models.omni.l h;
    private volatile com.obric.autogui.agents.vlm.models.omni.l i;
    private volatile String j;
    private volatile boolean k;
    private final ConcurrentHashMap<String, au<Boolean>> l;

    /* JADX INFO: compiled from: OmniSession.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private final String a(int r1) {
            switch(r1) {
                case 106001: goto L7;
                case 106002: goto L6;
                case 106003: goto L6;
                case 106004: goto L5;
                case 106005: goto L5;
                case 106006: goto L4;
                case 106007: goto L4;
                default: goto L3;
            };
        L3:
            return null;
        L4:
            return "app_in_blacklist_virus";
        L5:
            return "app_in_blacklist_user_defined";
        L6:
            return "app_in_blacklist_soft";
        L7:
            return "app_in_blacklist_hard";
        }

        private a() {
        }

        public static final /* synthetic */ String a(a r0, int r1) {
            return r0.a(r1);
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {993}, d = "cacheHeifScreenshot", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f28471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f28472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28473e;

        b(r r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28472d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28471c = r3;
            this.f28473e |= Integer.MIN_VALUE;
            return r.a(this.f28472d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {BDImageUploader.KeyIsImageCountThreshold, 450}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$dispatchResult$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f28475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ r f28476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ScreenshotResult f28477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f28478e;
        final /* synthetic */ boolean f;
        final /* synthetic */ JsonObject g;
        final /* synthetic */ String h;
        final /* synthetic */ Boolean i;
        private /* synthetic */ Object j;

        c(int r3, r r4, ScreenshotResult r5, boolean r6, boolean r7, JsonObject r8, String r9, Boolean r10, d.c.d<? super c> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28475b = r3;
            this.f28476c = r4;
            this.f28477d = r5;
            this.f28478e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            super(2, r12);
        }

        public static /* synthetic */ String lambda$BRTyCLMxzT7yQkm7D4AIriNzcws(int r0, boolean r1, boolean r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ String lambda$aShn3hJTlJfpoNVUzuvMbFfbMh8(int r0, boolean r1, boolean r2, am r3, JsonObject r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r13, d.c.d<?> r14) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            c r15 = new c(this.f28475b, this.f28476c, this.f28477d, this.f28478e, this.f, this.g, this.h, this.i, r11);
            r15.j = r13;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r15, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f28474a;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r25);
        L46:
            return d.x.f38692a;
        L10:
            d.o.a(r25);
            final am r11 = (am) ZeusTransformUtils.preCheckCast(this.j, am.class, "com.obric.aiagent.plugin");
            Loog r3 = Loog.INSTANCE;
            StringBuilder r5 = new StringBuilder().append("dispatchResult enter: code=").append(this.f28475b).append(" hasLastOmniAction=");
            boolean r13 = false;
            if (this.f28476c.e() == null) goto L13;
            boolean r7 = true;
        L14:
            StringBuilder r6 = r5.append(r7).append(" screenStatus=");
            ScreenshotResult r8 = this.f28477d;
            com.obric.autogui.agents.vlm.models.omni.intent.g r14 = null;
            if (r8 == null) goto L17;
            ScreenshotResult.Status r9 = r8.getStatus();
        L18:
            r3.i(r.TAG, r6.append(r9).append(" isRecovering=").append(this.f28478e).append(" hasInitiallyRequested=").append(this.f).append(" thread=").append(Thread.currentThread().getName()).toString());
            com.obric.autogui.agents.vlm.models.omni.l r4 = this.f28476c.e();
            if (r4 != null) goto L22;
            Loog.INSTANCE.i("OmniGUIIntent", "DispatchContext is null, cannot send result.");
            return d.x.f38692a;
        L22:
            Loog r10 = Loog.INSTANCE;
            final int r12 = this.f28475b;
            final boolean r15 = this.f28478e;
            final boolean r16 = this.f;
            final JsonObject r17 = this.g;
            d.h.a.a<String> r18 = new $$Lambda$r$c$aShn3hJTlJfpoNVUzuvMbFfbMh8(r12, r15, r16, r11, r17);
            final int r19 = this.f28475b;
            final boolean r20 = this.f28478e;
            final boolean r21 = this.f;
            r10.ip(r.TAG, r18, new $$Lambda$r$c$BRTyCLMxzT7yQkm7D4AIriNzcws(r19, r20, r21));
            if (this.f28478e == false) goto L37;
            r4.a(true);
            Object r22 = r.a(this.f28476c).r_();
            Loog r23 = Loog.INSTANCE;
            StringBuilder r24 = new StringBuilder().append("dispatchResult: session recovering notify hasLastOmniAction=");
            if (this.f28476c.e() == null) goto L27;
            boolean r26 = true;
        L28:
            StringBuilder r27 = r24.append(r26).append(" dropAction=");
            com.obric.autogui.agents.vlm.models.omni.l r28 = (com.obric.autogui.agents.vlm.models.omni.l) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.h.d(r22), com.obric.autogui.agents.vlm.models.omni.l.class, "com.obric.aiagent.plugin");
            if (r28 == null) goto L31;
            r14 = r28.a();
        L31:
            if (r14 == null) goto L33;
            r13 = true;
        L33:
            r23.i(r.TAG, r27.append(r13).append(' ').toString());
            r r29 = this.f28476c;
            int r30 = this.f28475b;
            JsonObject r31 = this.g;
            ScreenshotResult r32 = this.f28477d;
            String r33 = this.h;
            Boolean r110 = this.i;
            d.c.d r210 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28474a = 1;
            if (r.a(r29, r4, r30, r31, r32, r33, r110, r210) != r1) goto L46;
            return r1;
        L27:
            r26 = false;
            goto L28
        L37:
            if (r4.c() == false) goto L39;
        L42:
            r r34 = this.f28476c;
            int r35 = this.f28475b;
            JsonObject r36 = this.g;
            ScreenshotResult r37 = this.f28477d;
            String r38 = this.h;
            Boolean r111 = this.i;
            d.c.d r211 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28474a = 2;
            if (r.a(r34, r4, r35, r36, r37, r38, r111, r211) != r1) goto L46;
            return r1;
        L39:
            if (this.f == true) goto L42;
            Loog.INSTANCE.i(r.TAG, "skip notify because first loop");
            goto L46
        L17:
            r9 = null;
            goto L18
        L13:
            r7 = false;
            goto L14
        }

        private static final String a(int r2, boolean r3, boolean r4, am r5, JsonObject r6) {
            am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.aiagent.plugin");
            StringBuilder r8 = new StringBuilder().append("dispatchResult: ").append(r2).append(' ').append(r3).append(' ').append(r4).append(' ');
            d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L9
            JsonElement r10 = r6.get("hyper_params");     // Catch: Throwable -> L9
            if (r10.isJsonObject() == false) goto L6;
            JsonObject r11 = r10.getAsJsonObject();     // Catch: Throwable -> L9
        L7:
            Object r12 = d.n.f(r11.get("user_response").getAsString());     // Catch: Throwable -> L9
        L12:
            if (d.n.b(r12) == false) goto L15;
            r12 = null;
        L15:
            return r8.append((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin")).toString();
        L6:
            r11 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r10.getAsString(), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            d.n.a r13 = d.n.f38560a;
            r12 = d.n.f(d.o.a(th));
            goto L12
        }

        private static final String a(int r2, boolean r3, boolean r4) {
            return "dispatchResult: " + r2 + ' ' + r3 + ' ' + r4;
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {761}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$endTask$1")
    static final class d extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f28480b;

        d(r r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28480b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f28480b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28479a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            this.f28480b.m();
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            AtomicCapabilitySdk r2 = AtomicCapabilitySdk.INSTANCE;
            String r11 = this.f28480b.a();
            TaskStateInfo r3 = new TaskStateInfo(TaskState.Stop, null, null, ao.a(d.s.a("o_reference_msg_id", this.f28480b.g())));
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28479a = 1;
            if (AtomicCapabilitySdk.requestStateChanged$default(r2, r11, r3, null, null, r6, 12, null) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {974}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$getOrStartHeifCacheJob$job$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f28482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HeifScreenshotAttachment f28484d;

        e(r r3, String r4, HeifScreenshotAttachment r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28482b = r3;
            this.f28483c = r4;
            this.f28484d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f28482b, this.f28483c, this.f28484d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28481a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            r r8 = this.f28482b;
            String r2 = this.f28483c;
            HeifScreenshotAttachment r3 = this.f28484d;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28481a = 1;
            r7 = r.a(r8, r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {794, 853}, d = "notify", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28489e;
        Object f;
        Object g;
        Object h;
        Object i;
        int j;
        /* synthetic */ Object k;
        final /* synthetic */ r l;
        int m;

        f(r r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.k = r9;
            this.m |= Integer.MIN_VALUE;
            return r.a(this.l, null, 0, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {719}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$notifyMockCallUser$1")
    static final class h extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f28492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f28494d;

        h(r r3, String r4, List<String> r5, d.c.d<? super h> r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28492b = r3;
            this.f28493c = r4;
            this.f28494d = r7;
            super(1, r8);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((h) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f28492b, this.f28493c, this.f28494d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28491a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r13);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r13);
            Loog.INSTANCE.i(r.TAG, "notifyMockCallUser");
            AtomicCapabilitySdk r4 = AtomicCapabilitySdk.INSTANCE;
            String r5 = this.f28492b.a();
            TaskStateInfo r6 = new TaskStateInfo(TaskState.CallUser, null, null, ao.a(new d.m[]{d.s.a("island_content", this.f28493c), d.s.a("island_buttons", com.obric.capabilitykit.common.a.a().toJson(this.f28494d))}));
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28491a = 1;
            if (AtomicCapabilitySdk.requestStateChanged$default(r4, r5, r6, null, null, r9, 12, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {EntityType.COUNTDOWN}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$notifyMockClarify$1")
    static final class i extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f28496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f28498d;

        i(r r3, String r4, List<String> r5, d.c.d<? super i> r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28496b = r3;
            this.f28497c = r4;
            this.f28498d = r7;
            super(1, r8);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((i) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f28496b, this.f28497c, this.f28498d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28495a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r13);
        L19:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r13);
            Loog.INSTANCE.i(r.TAG, "notifyMockClarify");
            AtomicCapabilitySdk r4 = AtomicCapabilitySdk.INSTANCE;
            String r5 = this.f28496b.a();
            TaskState r14 = TaskState.Clarify;
            d.m[] r2 = new d.m[3];
            r2[0] = d.s.a("island_content", this.f28497c);
            r2[1] = d.s.a("island_buttons", com.obric.capabilitykit.common.a.a().toJson(this.f28498d));
            com.obric.autogui.agents.vlm.models.omni.l r7 = this.f28496b.e();
            if (r7 == null) goto L14;
            com.obric.autogui.agents.vlm.models.omni.intent.g r8 = r7.a();
            if (r8 == null) goto L14;
            String r9 = r8.g();
            if (r9 == null) goto L14;
        L15:
            r2[2] = d.s.a("tool_id", r9);
            TaskStateInfo r6 = new TaskStateInfo(r14, null, null, ao.a(r2));
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28495a = 1;
            if (AtomicCapabilitySdk.requestStateChanged$default(r4, r5, r6, null, null, r10, 12, null) != r0) goto L19;
            return r0;
        L14:
            r9 = "";
            goto L15
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {752}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$requestTakeOverState$1")
    static final class j extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f28500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f28501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f28502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f28503e;
        final /* synthetic */ TaskState f;

        j(String r3, Map<String, String> r4, r r5, String r6, TaskState r7, d.c.d<? super j> r8) {
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28500b = r3;
            this.f28501c = r9;
            this.f28502d = r5;
            this.f28503e = r6;
            this.f = r7;
            super(1, r10);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((j) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r10) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f28500b, this.f28501c, this.f28502d, this.f28503e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28499a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r15);
        L41:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r15);
            String r16 = this.f28500b;
            if (r16 == null) goto L12;
            Map<String, String> r17 = ao.a(this.f28501c, d.s.a("take_over_scene", r16));
            if (r17 == null) goto L12;
        L14:
            if (d.h.b.o.a(this.f28500b, "occupy_begin") == false) goto L25;
            com.obric.autogui.agents.vlm.models.omni.l r2 = this.f28502d.e();
            if (r2 == null) goto L20;
            com.obric.autogui.agents.vlm.models.omni.intent.g r3 = r2.a();
            if (r3 == null) goto L20;
            String r4 = r3.g();
        L21:
            if (r4 != null) goto L25;
            Loog.INSTANCE.w(r.TAG, "requestTakeOverState OCCUPY_BEGIN with null toolId, skip");
            return d.x.f38692a;
        L20:
            r4 = null;
        L25:
            if (d.h.b.o.a(this.f28500b, "occupy_begin") == false) goto L27;
        L30:
            String r5 = "OccupyTakeOverTrace ";
        L31:
            Loog r6 = Loog.INSTANCE;
            StringBuilder r7 = new StringBuilder().append(r5).append(this.f28503e).append(" with toolId=");
            com.obric.autogui.agents.vlm.models.omni.l r8 = this.f28502d.e();
            if (r8 == null) goto L36;
            com.obric.autogui.agents.vlm.models.omni.intent.g r9 = r8.a();
            if (r9 == null) goto L36;
            String r10 = r9.g();
        L37:
            r6.i(r.TAG, r7.append(r10).append(", ext=").append(r17).toString());
            AtomicCapabilitySdk r11 = AtomicCapabilitySdk.INSTANCE;
            String r12 = this.f28502d.a();
            TaskStateInfo r13 = new TaskStateInfo(this.f, null, null, r17);
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28499a = 1;
            if (AtomicCapabilitySdk.requestStateChanged$default(r11, r12, r13, null, null, r14, 12, null) != r0) goto L41;
            return r0;
        L36:
            r10 = null;
            goto L37
        L27:
            if (d.h.b.o.a(this.f28500b, "occupy_end") == true) goto L30;
            r5 = "";
        L12:
            r17 = this.f28501c;
            goto L14
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {946}, d = "startHeifScreenshotCacheIfNeeded", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f28506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f28507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ r f28508e;
        int f;

        k(r r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28508e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28507d = r3;
            this.f |= Integer.MIN_VALUE;
            return r.a(this.f28508e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {947}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$startHeifScreenshotCacheIfNeeded$ready$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f28510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HeifScreenshotAttachment f28512d;

        l(r r3, String r4, HeifScreenshotAttachment r5, d.c.d<? super l> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28510b = r3;
            this.f28511c = r4;
            this.f28512d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f28510b, this.f28511c, this.f28512d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28509a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            au r6 = r.a(this.f28510b, this.f28511c, this.f28512d);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28509a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {561, 564}, d = "takeAction", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f28515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f28516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28517e;

        m(r r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28516d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28515c = r3;
            this.f28517e |= Integer.MIN_VALUE;
            return this.f28516d.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniSession.kt */
    @d.c.b.a.f(b = "OmniSession.kt", c = {600}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniSession$terminateSession$1")
    static final class n extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f28519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ r f28520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f28521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f28522e;
        final /* synthetic */ HashSet<String> f;
        final /* synthetic */ Map<String, Object> g;
        final /* synthetic */ u h;

        n(r r3, int r4, String r5, HashSet<String> r6, Map<String, ? extends Object> r7, u r8, d.c.d<? super n> r9) {
            Map<String, Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28520c = r3;
            this.f28521d = r4;
            this.f28522e = r5;
            this.f = r6;
            this.g = r10;
            this.h = r8;
            super(1, r11);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((n) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r11) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f28520c, this.f28521d, this.f28522e, this.f, this.g, this.h, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f28519b;
            if (r2 == 0) goto L10;
            if (r2 != 1) goto L9;
            Object r1 = this.f28518a;
            d.o.a(r17);     // Catch: Throwable -> L35
        L15:
            Loog r3 = Loog.INSTANCE;     // Catch: Throwable -> L35
            StringBuilder r5 = new StringBuilder().append("terminateSession, clear exist actions ");     // Catch: Throwable -> L35
            com.obric.autogui.agents.vlm.models.omni.l r4 = (com.obric.autogui.agents.vlm.models.omni.l) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.h.d(r1), com.obric.autogui.agents.vlm.models.omni.l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            if (r4 == null) goto L20;
            com.obric.autogui.agents.vlm.models.omni.intent.g r6 = r4.a();     // Catch: Throwable -> L35
            if (r6 == null) goto L20;
            String r7 = r6.g();     // Catch: Throwable -> L35
        L21:
            r3.i(r.TAG, r5.append(r7).toString());     // Catch: Throwable -> L35
        L30:
            th = move-exception;
            if (this.h.b() == false) goto L34;
            this.f28520c.m();
        L34:
            throw th;
        L23:
            if (this.h.a() == false) goto L26;
            r.a(this.f28520c, this.f28521d);     // Catch: Throwable -> L30
        L26:
            if (this.h.b() == false) goto L29;
            this.f28520c.m();
        L29:
            return d.x.f38692a;
        L20:
            r7 = null;
            goto L21
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r17);
            Object r8 = r.a(this.f28520c).r_();     // Catch: Throwable -> L35
            r r9 = this.f28520c;     // Catch: Throwable -> L35
            int r10 = this.f28521d;     // Catch: Throwable -> L35
            JsonObject r11 = r.a(r9, this.f28522e, this.f, this.g);     // Catch: Throwable -> L35
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            this.f28518a = r8;     // Catch: Throwable -> L35
            this.f28519b = 1;     // Catch: Throwable -> L35
            if (r.a(r9, r10, r11, null, false, true, null, null, r13, 96, null) != r0) goto L14;
            return r0;
        L14:
            r1 = r8;
        L35:
            th = move-exception;
        L43:
            th = move-exception;
            if (this.h.b() == false) goto L47;
            this.f28520c.m();
        L47:
            throw th;
        L37:
            if (this.h.a() == false) goto L40;
            r.a(this.f28520c, this.f28521d);     // Catch: Throwable -> L43
        L40:
            if (this.h.b() == false) goto L42;
            this.f28520c.m();
        L42:
            throw th;
        }
    }

    static {
        f28464a = new a(null);
    }

    public static /* synthetic */ com.obric.autogui.agents.vlm.models.omni.c.h lambda$64y3jM6WEQPZdTPHSiceQXCKkfA(r r0, com.obric.autogui.agents.vlm.models.omni.c.k r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$Fslfw5Yke5hcli4ZA3IYseRluo4(com.obric.autogui.agents.vlm.models.omni.l r0, String r1, int r2, d.h.b.z.a r3, com.obric.autogui.agents.vlm.models.omni.m.a r4, com.obric.autogui.agents.vlm.models.omni.e r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$MIkA9WdiueSrA-0Hlh48SziLgYM, reason: not valid java name */
    public static /* synthetic */ String m780lambda$MIkA9WdiueSrA0Hlh48SziLgYM(com.obric.autogui.agents.vlm.models.omni.e r0) {
        return a(r0);
    }

    public r(String r4, String r5) {
        d.h.b.o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        this.f28465b = r4;
        this.f28466c = r5;
        this.f28467d = new Object();
        this.f28468e = kotlinx.coroutines.a.g.a(1, null, null, 6, null);
        this.f = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "omniActionsHolder_" + r4, false, 2, null);
        this.g = new com.obric.autogui.agents.vlm.models.omni.c.j(this, new $$Lambda$r$64y3jM6WEQPZdTPHSiceQXCKkfA(this));
        this.j = "";
        this.l = new ConcurrentHashMap();
    }

    public static final /* synthetic */ JsonObject a(r r2, String r3, HashSet r4, Map r5) {
        return r2.a(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r8, com.obric.autogui.agents.vlm.models.omni.l r9, int r10, JsonObject r11, ScreenshotResult r12, String r13, Boolean r14, d.c.d r15) {
        return r8.a(r9, r10, r11, r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r2, com.obric.autogui.agents.vlm.models.omni.l r3, ScreenshotResult r4, ConcurrentHashMap r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r2, String r3, HeifScreenshotAttachment r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.a.d a(r r0) {
        return r0.f28468e;
    }

    public static final /* synthetic */ au a(r r0, String r1, HeifScreenshotAttachment r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(r r0, int r1) {
        r0.a(r1);
    }

    public final String a() {
        return this.f28465b;
    }

    public final String b() {
        return this.f28466c;
    }

    public final AOThreadingTools.SingleThreadCoroutineScopeWrapper c() {
        return this.f;
    }

    public final com.obric.autogui.agents.vlm.models.omni.c.j d() {
        return this.g;
    }

    private static final com.obric.autogui.agents.vlm.models.omni.c.h a(r r1, com.obric.autogui.agents.vlm.models.omni.c.k r2) {
        d.h.b.o.e(r2, "telemetry");
        return (com.obric.autogui.agents.vlm.models.omni.c.h) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.omni.c.l.f28290a.a(r1, r2), com.obric.autogui.agents.vlm.models.omni.c.h.class, "com.obric.aiagent.plugin");
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.l r1) {
        this.h = r1;
    }

    public final com.obric.autogui.agents.vlm.models.omni.l e() {
        return this.h;
    }

    public final void b(com.obric.autogui.agents.vlm.models.omni.l r1) {
        this.i = r1;
    }

    public final com.obric.autogui.agents.vlm.models.omni.l f() {
        return this.i;
    }

    public final String g() {
        return this.j;
    }

    public final boolean h() {
        return this.k;
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "logId");
        this.f28466c = r2;
    }

    public static /* synthetic */ Object a(r r10, int r11, JsonObject r12, ScreenshotResult r13, boolean r14, boolean r15, String r16, Boolean r17, d.c.d r18, int r19, Object r20) {
        d.c.d<? super d.x> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r19 & 32) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r19 & 64) == 0) goto L9;
        Boolean r8 = null;
    L11:
        return r10.a(r11, r12, r13, r14, r15, r7, r8, r9);
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public final Object a(int r15, JsonObject r16, ScreenshotResult r17, boolean r18, boolean r19, String r20, Boolean r21, d.c.d<? super d.x> r22) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        Object r1 = kotlinx.coroutines.i.a(this.f.getCoroutineScope().a(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r15, this, r17, r18, r19, r16, r20, r21, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
        if (r1 != d.c.a.b.a()) goto L6;
        return r1;
    L6:
        return d.x.f38692a;
    }

    public final boolean c(com.obric.autogui.agents.vlm.models.omni.l r7) {
        d.h.b.o.e(r7, "action");
        Object r0 = this.f28467d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.k == false) goto L7;
        boolean r1 = false;
    L12:
        monitor-exit(r0);
        Loog.INSTANCE.i(TAG, "assignInitAction sessionId=" + this.f28465b + " toolId=" + r7.a().g() + " questionId=" + r7.b().getQuestionId() + " assigned=" + r1 + " hasRefMsgId=" + (!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.aiagent.plugin"))));
        return r1;
    L7:
        String r2 = v.a(r7.b().getQuestionId());     // Catch: Throwable -> L15
        if (r2 == null) goto L10;
        this.j = r2;     // Catch: Throwable -> L15
    L10:
        this.h = r7;     // Catch: Throwable -> L15
        r1 = true;
        goto L12
    }

    public final boolean a(Long r3) {
        Object r0 = this.f28467d;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.k == false) goto L7;
        boolean r2 = false;
    L11:
        monitor-exit(r0);
        return r2;
    L7:
        String r4 = v.a(r3);     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        this.j = r4;     // Catch: Throwable -> L13
    L10:
        r2 = true;
        goto L11
    }

    public final void i() {
        Object r0 = this.f28467d;
        monitor-enter(r0);
        this.k = true;     // Catch: Throwable -> L9
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L9
        monitor-exit(r0);
        this.g.b();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void j() {
        Object r0 = this.f28467d;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.k == false) goto L7;
        boolean r1 = false;
    L21:
        monitor-exit(r0);
        if (r1 == true) goto L30;
        Loog.INSTANCE.i(TAG, "clearLastOmniAction skipped for closed sessionId=" + this.f28465b);
        return;
    L30:
        return;
    L7:
        Loog r2 = Loog.INSTANCE;     // Catch: Throwable -> L25
        StringBuilder r3 = new StringBuilder().append("clearLastOmniAction sessionId=").append(this.f28465b).append(" lastToolId=");     // Catch: Throwable -> L25
        com.obric.autogui.agents.vlm.models.omni.l r4 = this.h;     // Catch: Throwable -> L25
        if (r4 == null) goto L12;
        com.obric.autogui.agents.vlm.models.omni.intent.g r5 = r4.a();     // Catch: Throwable -> L25
        if (r5 == null) goto L12;
        String r6 = r5.g();     // Catch: Throwable -> L25
    L13:
        StringBuilder r7 = r3.append(r6).append(" savedToolId=");     // Catch: Throwable -> L25
        com.obric.autogui.agents.vlm.models.omni.l r8 = this.i;     // Catch: Throwable -> L25
        if (r8 == null) goto L18;
        com.obric.autogui.agents.vlm.models.omni.intent.g r9 = r8.a();     // Catch: Throwable -> L25
        if (r9 == null) goto L18;
        String r10 = r9.g();     // Catch: Throwable -> L25
    L19:
        r2.i(TAG, r7.append(r10).toString());     // Catch: Throwable -> L25
        k();     // Catch: Throwable -> L25
        this.h = null;     // Catch: Throwable -> L25
        this.i = null;     // Catch: Throwable -> L25
        r1 = true;
    L18:
        r10 = null;
    L12:
        r6 = null;
        goto L13
    }

    public final void k() {
        com.obric.autogui.agents.vlm.models.omni.l r0 = this.h;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        com.obric.autogui.agents.vlm.models.omni.l r2 = this.h;
        if (r2 == null) goto L11;
        com.obric.autogui.agents.vlm.models.omni.b.b r3 = r2.d();
        if (r3 == null) goto L12;
        r3.a();
        return;
    L12:
        return;
    }

    public final boolean d(com.obric.autogui.agents.vlm.models.omni.l r6) {
        d.h.b.o.e(r6, "omniAction");
        Loog r0 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("pushAction begin sessionId=").append(this.f28465b).append(" toolId=").append(r6.a().g()).append(" action=");
        com.obric.autogui.agents.vlm.models.omni.intent.j r2 = r6.a().c();
        if (r2 == null) goto L5;
        String r3 = r2.a();
    L6:
        StringBuilder r4 = r1.append(r3).append(" questionId=").append(r6.b().getQuestionId()).append(" hasLastOmniAction=");
        if (this.h == null) goto L9;
        boolean r5 = true;
    L10:
        r0.i(TAG, r4.append(r5).append(" isSessionClosed=").append(this.k).toString());
        Object r7 = this.f28468e.a_(r6);
        Loog.INSTANCE.i(TAG, "pushAction end sessionId=" + this.f28465b + " success=" + kotlinx.coroutines.a.h.a(r7) + " isClosed=" + kotlinx.coroutines.a.h.c(r7) + " isFailure=" + kotlinx.coroutines.a.h.b(r7) + " toold_id=" + r6.a().g());
        return kotlinx.coroutines.a.h.a(r7);
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void a(ScreenshotResult r5) {
        if (r5 == null) goto L25;
        HeifScreenshotAttachment r6 = r5.getHeifAttachment();
        if (r6 == null) goto L26;
        com.obric.autogui.agents.vlm.models.omni.l r0 = this.h;
        if (r0 == null) goto L11;
        DispatchContext r1 = r0.b();
        if (r1 == null) goto L11;
        Long r2 = r1.getQuestionId();
    L12:
        String r3 = a(r2);
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
    L18:
        boolean r7 = true;
    L20:
        if (r7 == false) goto L23;
        Loog.INSTANCE.w(TAG, "preCacheHeifScreenshot skipped, fdKey is empty");
        return;
    L23:
        Loog.INSTANCE.i(TAG, "preCacheHeifScreenshot scheduled fdKey=" + r3 + " isActive=" + a(r3, r6).b());
        return;
    L15:
        if (d.o.o.d(r4) == true) goto L18;
        r7 = false;
    L11:
        r2 = null;
        goto L12
    L26:
        return;
    }

    public final Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.omni.l> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, m.class) == false) goto L7;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r11, m.class, "com.obric.aiagent.plugin");
        if ((r1.f28517e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f28517e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.f28515c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f28517e;
        String r5 = null;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        com.obric.autogui.agents.vlm.models.omni.l r9 = (com.obric.autogui.agents.vlm.models.omni.l) ZeusTransformUtils.preCheckCast(r1.f28514b, com.obric.autogui.agents.vlm.models.omni.l.class, "com.obric.aiagent.plugin");
        r r0 = (r) ZeusTransformUtils.preCheckCast(r1.f28513a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L36:
        Loog r13 = Loog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("next action received sessionId=").append(r0.f28465b).append(" toolId=").append(r9.a().g()).append(" action=");
        com.obric.autogui.agents.vlm.models.omni.intent.j r6 = r9.a().c();
        if (r6 == null) goto L39;
        r5 = r6.a();
    L39:
        r13.i(TAG, r2.append(r5).append(" questionId=").append(r9.b().getQuestionId()).toString());
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r this = (r) ZeusTransformUtils.preCheckCast(r1.f28513a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L29:
        com.obric.autogui.agents.vlm.models.omni.l r14 = (com.obric.autogui.agents.vlm.models.omni.l) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.omni.l.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.b.b r7 = r14.d();
        if (r7 == null) goto L32;
        r7.a(com.obric.autogui.agents.vlm.models.omni.b.f.f28227b);
    L32:
        com.obric.autogui.agents.vlm.models.omni.c.j r8 = this.g;
        r1.f28513a = this;
        r1.f28514b = r14;
        r1.f28517e = 2;
        if (r8.a(r1) != r3) goto L35;
        return r3;
    L35:
        r0 = this;
        r9 = r14;
        goto L36
    L16:
        d.o.a(r12);
        Loog r15 = Loog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("await NextAction sessionId=").append(this.f28465b).append(" hasLastOmniAction=");
        if (this.h == null) goto L19;
        boolean r17 = true;
    L20:
        StringBuilder r18 = r16.append(r17).append(" lastToolId=");
        com.obric.autogui.agents.vlm.models.omni.l r19 = this.h;
        if (r19 == null) goto L25;
        com.obric.autogui.agents.vlm.models.omni.intent.g r20 = r19.a();
        if (r20 == null) goto L25;
        String r21 = r20.g();
    L26:
        r15.i(TAG, r18.append(r21).toString());
        kotlinx.coroutines.a.d<com.obric.autogui.agents.vlm.models.omni.l> r110 = this.f28468e;
        r1.f28513a = this;
        r1.f28517e = 1;
        r12 = r110.a(r1);
        if (r12 != r3) goto L29;
        return r3;
    L25:
        r21 = null;
        goto L26
    L19:
        r17 = false;
    L7:
        r1 = new m(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(r r1, int r2, String r3, HashSet r4, Map r5, int r6, Object r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = ao.b();
    L8:
        r1.a(r2, r3, r4, r8);
    }

    public final void a(int r11, String r12, HashSet<String> r13, Map<String, ? extends Object> r14) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "msg");
        d.h.b.o.e(r7, "resultExtras");
        u r8 = v.a(r11);
        Loog.INSTANCE.i(TAG, "terminateSession, reason=" + r11 + ", stopRemote=" + r8.a() + ", closeLocal=" + r8.b() + ", msg=" + r12 + '~');
        k();
        if (r8.b() == false) goto L5;
        i();
    L5:
        this.f.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new n(this, r11, r12, r13, r7, r8, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void a(int r9) {
        Long r2 = v.a(this.j);
        if (r2 != null) goto L6;
        Loog.INSTANCE.w(TAG, "terminateSession: invalid refMsgId=" + this.j + ", skip notifyStopComplexTaskByHttp");
        return;
    L6:
        String r8 = a.a(f28464a, r9);
        IFlowNetworkIDL r4 = com.obric.aiagent.assistant.idl.am.a(d.h.b.aa.b(IFlowNetworkIDL.class));     // Catch: Exception -> L13 CancellationException -> L16
        if (r4 != null) goto L11;
        Loog.INSTANCE.e(TAG, "terminateSession: network IPC unavailable, cannot stop task msgId=" + r2 + " reason=" + r9 + " scene=" + r8);     // Catch: Exception -> L13 CancellationException -> L16
        return;
    L11:
        r4.notifyStopComplexTaskByHttpWithScene(r2.longValue(), r8);     // Catch: Exception -> L13 CancellationException -> L16
        Loog.INSTANCE.i(TAG, "terminateSession: notify stop task dispatched msgId=" + r2 + " reason=" + r9 + " scene=" + r8);     // Catch: Exception -> L13 CancellationException -> L16
        return;
    L16:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "terminateSession: notify stop task failed msgId=" + r2 + " reason=" + r9 + " scene=" + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final JsonObject a(String r4, HashSet<String> r5, Map<String, ? extends Object> r6) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        JsonObject r7 = new JsonObject();
        JsonArray r1 = new JsonArray();
        r1.add(r4);
        r1.add("当前操作中的应用已退出，后续需要操作应用，先使用`open_app`打开应用");
        if (r5 == null) goto L8;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        r1.add((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"));
    L8:
        d.x r9 = d.x.f38692a;
        r7.add("system_hint", (JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin"));
        JsonObject r10 = new JsonObject();
        r10.addProperty("user_response", r7.toString());
        JsonObject r11 = new JsonObject();
        r11.addProperty("hyper_params", r10.toString());
        Iterator r12 = r3.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r15 = r13.getValue();
        r11.add(r14, com.obric.capabilitykit.common.a.a().toJsonTree(r15));
        goto L10
    L12:
        return r11;
    }

    public final AOThreadingTools.LaunchedJob a(String r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "content");
        d.h.b.o.e(r7, "options");
        return this.f.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new i(this, r5, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final AOThreadingTools.LaunchedJob b(String r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "content");
        d.h.b.o.e(r7, "options");
        return this.f.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new h(this, r5, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ AOThreadingTools.LaunchedJob a(r r1, String r2, Map r3, int r4, Object r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = ao.b();
    L9:
        return r1.a(r2, r6);
    }

    public final AOThreadingTools.LaunchedJob a(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "ext");
        return a(TaskState.UserOperationBegin, "startTakeOver", r3, r5);
    }

    public static /* synthetic */ AOThreadingTools.LaunchedJob b(r r1, String r2, Map r3, int r4, Object r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = ao.b();
    L9:
        return r1.b(r2, r6);
    }

    public final AOThreadingTools.LaunchedJob b(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "ext");
        return a(TaskState.UserOperationEnd, "endTakeOver", r3, r5);
    }

    private final AOThreadingTools.LaunchedJob a(TaskState r10, String r11, String r12, Map<String, String> r13) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        return this.f.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new j(r12, r4, this, r11, r10, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final AOThreadingTools.LaunchedJob l() {
        return this.f.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    private final Object a(com.obric.autogui.agents.vlm.models.omni.l r35, int r36, JsonObject r37, ScreenshotResult r38, String r39, Boolean r40, d.c.d<? super d.x> r41) {
        com.obric.autogui.agents.vlm.models.omni.l r2 = r35;
        String r3 = r39;
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r41, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L7;
        f r7 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if ((r7.m & Integer.MIN_VALUE) == 0) goto L7;
        r7.m -= Integer.MIN_VALUE;
    L8:
        Object r6 = r7.k;
        Object r8 = d.c.a.b.a();
        int r9 = r7.m;
        if (r9 == 0) goto L27;
        if (r9 != 1) goto L12;
        int r1 = r7.j;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r7.f, String.class, "com.obric.aiagent.plugin");
        r3 = (String) ZeusTransformUtils.preCheckCast(r7.f28489e, String.class, "com.obric.aiagent.plugin");
        ScreenshotResult r10 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r7.f28488d, ScreenshotResult.class, "com.obric.aiagent.plugin");
        JsonObject r12 = (JsonObject) ZeusTransformUtils.preCheckCast(r7.f28487c, JsonObject.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.l r14 = (com.obric.autogui.agents.vlm.models.omni.l) ZeusTransformUtils.preCheckCast(r7.f28486b, com.obric.autogui.agents.vlm.models.omni.l.class, "com.obric.aiagent.plugin");
        r r11 = (r) ZeusTransformUtils.preCheckCast(r7.f28485a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Exception -> L23 CancellationException -> L25
        Object r0 = r6;
        String r13 = " screenStatus=";
        r36 = r1;
        ScreenshotResult r15 = r10;
    L311:
        Boolean r16 = (Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L25 Exception -> L55
        com.obric.autogui.agents.vlm.models.omni.l r33 = r14;
        ScreenshotResult r17 = r15;
        int r18 = r36;
        com.obric.autogui.agents.vlm.models.omni.l r19 = r33;
    L72:
        Loog r110 = Loog.INSTANCE;
        f r111 = r7;
        StringBuilder r20 = new StringBuilder().append("[OAutoActionEffect] white screen result resolved screenshot_step_id=");
        if (r3 != null) goto L75;
        r3 = "";
    L75:
        StringBuilder r21 = r20.append(r3).append(", tool_id=").append(r4).append(", has_result=");
        if (r16 == null) goto L78;
        boolean r22 = true;
    L79:
        StringBuilder r23 = r21.append(r22).append(", is_white_screen=");
        if (r16 == null) goto L82;
        String r24 = r16.toString();
    L83:
        if (r24 != null) goto L85;
        r24 = "";
    L85:
        r110.i(TAG, r23.append(r24).toString());
        String r25 = r11.f28466c;
        if (r25 != null) goto L88;
    L90:
        r25 = null;
    L91:
        com.obric.autogui.agents.vlm.models.omni.f r26 = r19.h().a(s.a(r18, r19.o()));
        ab r27 = r19.i().a();
        com.obric.autogui.agents.vlm.models.omni.m.a r112 = com.obric.autogui.agents.vlm.models.omni.m.f28435a.a(r12, r26, r27, r19.j(), r16);
        com.obric.autogui.agents.vlm.models.omni.b r28 = r26.o();
        com.obric.autogui.agents.vlm.models.omni.g r113 = r26.l();
        Loog r114 = Loog.INSTANCE;
        String r115 = "com.obric.aiagent.plugin";
        StringBuilder r29 = new StringBuilder();
        r r34 = r11;
        String r42 = r13;
        StringBuilder r30 = r29.append("[OAutoActionEffect] notify evaluation prepared tool_id=").append(r4).append(", log_id=");
        ScreenshotResult r310 = r17;
        if (r25 != null) goto L94;
        String r116 = "";
    L95:
        int r311 = r18;
        r30.append(r116).append(", is_multi_action=").append(r26.e()).append(", action_count=").append(r26.a()).append(", evaluated_action_count=").append(r26.g()).append(", completed_action_count=").append(r26.h()).append(", ineffective_action_count=").append(r26.i()).append(", missing_action_count=").append(r26.k()).append(", aggregate_completed=").append(r28.b()).append(", first_evaluations=").append(r113.a()).append(", end_evaluations=").append(r113.b()).append(", action_result_code=");
        StringBuilder r31 = r29.append(r26.m()).append(", action_result_reason=");
        String r117 = r26.n();
        if (r117 != null) goto L98;
        r117 = "";
    L98:
        StringBuilder r32 = r31.append(r117).append(", overall_end_status=").append(r28.a()).append(", payload_default_used=").append(r112.e()).append(", activity_changed=");
        Boolean r118 = r27.a();
        if (r118 == null) goto L101;
        String r119 = r118.toString();
    L102:
        if (r119 != null) goto L104;
        r119 = "";
    L104:
        StringBuilder r43 = r32.append(r119).append(", viewtree_changed=");
        Boolean r120 = r27.b();
        if (r120 == null) goto L107;
        String r121 = r120.toString();
    L108:
        if (r121 != null) goto L110;
        r121 = "";
    L110:
        StringBuilder r44 = r43.append(r121).append(", image_changed=");
        Boolean r45 = r27.c();
        if (r45 == null) goto L113;
        String r46 = r45.toString();
    L114:
        if (r46 != null) goto L116;
        r46 = "";
    L116:
        StringBuilder r47 = r44.append(r46).append(", top_activity_in_system_animation=");
        Boolean r48 = r19.j();
        if (r48 == null) goto L119;
        String r49 = r48.toString();
    L120:
        if (r49 != null) goto L122;
        r49 = "";
    L122:
        r47.append(r49);
        r114.i(TAG, r29.toString());
        if (r112.b() == false) goto L129;
        Loog r50 = Loog.INSTANCE;
        StringBuilder r51 = new StringBuilder().append("[OAutoActionEffect] notify payload attached tool_id=").append(r4).append(", log_id=");
        if (r25 != null) goto L127;
        String r52 = "";
    L128:
        r50.i(TAG, r51.append(r52).append(", is_multi_action=").append(r26.e()).append(", action_count=").append(r26.a()).append(", aggregate_completed=").append(r28.b()).append(", payload_default_used=").append(r112.e()).append(", first_evaluations=").append(r112.c()).append(", end_evaluations=").append(r112.d()).toString());
    L137:
        d.h.b.z.a r53 = new d.h.b.z.a();
        Loog r54 = Loog.INSTANCE;     // Catch: Exception -> L253
        int r55 = r311;
        StringBuilder r56 = new StringBuilder().append("notify begin tool_id=").append(r4).append(" code=").append(r55).append(" hasScreen=");     // Catch: Exception -> L251
        if (r310 == null) goto L143;
        boolean r57 = true;
    L144:
        StringBuilder r58 = r56.append(r57);     // Catch: Exception -> L251
        String r59 = r42;
        StringBuilder r60 = r58.append(r59);     // Catch: Exception -> L251
        if (r310 != null) goto L307;
        ScreenshotResult.Status r61 = null;
    L151:
        r54.i(TAG, r60.append(r61).toString());     // Catch: Exception -> L251
        ConcurrentHashMap<String, String> r62 = new ConcurrentHashMap();     // Catch: Exception -> L251
        r62.put("result", r112.a().toString());     // Catch: Exception -> L251
        AOAgentRobotsTools.TargetAppGrant r63 = r19.n();     // Catch: Exception -> L251
        if (r63 == null) goto L156;
        String r64 = AOAgentRobotsTools.INSTANCE.encodeTargetAppGrant(r63);     // Catch: Exception -> L148
        if (r64 == null) goto L156;
        r62.put(AOAgentRobotsTools.TARGET_APP_GRANT_EXT_KEY, r64);     // Catch: Exception -> L148
        d.x r65 = d.x.f38692a;     // Catch: Exception -> L148
    L148:
        e = e;
        r r66 = r34;
    L256:
        d.h.b.z.a r67 = r53;
        String r68 = r25;
        int r69 = r55;
        com.obric.autogui.agents.vlm.models.omni.m.a r70 = r112;
    L257:
        Loog.INSTANCE.e(TAG, "notify result failed tool_id=" + r4 + " error_type=" + e.getClass().getSimpleName());
        com.obric.autogui.agents.vlm.models.omni.b.b r71 = r19.d();
        if (r71 == null) goto L260;
        r71.a();
        d.x r72 = d.x.f38692a;
    L260:
        com.obric.autogui.agents.vlm.models.omni.d.a.f28330a.a(r19, r68, r26, r69, r67.f38499a, r70.b(), r70.c(), r70.d());
        if (r26.a() != 1) goto L269;
        if (r26.d() != null) goto L269;
        Set<String> r73 = d.n.m.i(d.n.m.d(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r26.b(), Iterable.class, r115)), (d.h.a.b) ZeusTransformUtils.preCheckCast(g.f28490a, d.h.a.b.class, r115)), $$Lambda$r$MIkA9WdiueSrA0Hlh48SziLgYM.INSTANCE));
        final com.obric.autogui.agents.vlm.models.omni.l r312 = r19;
        final String r313 = r68;
        final int r314 = r69;
        final d.h.b.z.a r315 = r67;
        final com.obric.autogui.agents.vlm.models.omni.m.a r316 = r70;
        d.h.a.b<? super com.obric.autogui.agents.vlm.models.omni.e, d.x> r74 = new $$Lambda$r$Fslfw5Yke5hcli4ZA3IYseRluo4(r312, r313, r314, r315, r316);
        Iterator r75 = ((Iterable) ZeusTransformUtils.preCheckCast(r19.h().a(r73, r74), Iterable.class, r115)).iterator();
    L266:
        if (r75.hasNext() == false) goto L269;
        r74.invoke(r75.next());
    L269:
        if (r66.h != r19) goto L271;
        r66.h = null;
    L272:
        Loog.INSTANCE.i(TAG, "notify context cleared tool_id=" + r4);
        return d.x.f38692a;
    L271:
        Loog.INSTANCE.w(TAG, "notify context changed before clear. tool_id=" + r4);
    L156:
        r66 = r34;
        r111.f28485a = r66;     // Catch: Exception -> L249
        r111.f28486b = r19;     // Catch: Exception -> L249
        r111.f28487c = r310;     // Catch: Exception -> L249
        r111.f28488d = r4;     // Catch: Exception -> L249
        r111.f28489e = r25;     // Catch: Exception -> L249
        r111.f = r26;     // Catch: Exception -> L249
        r111.g = r112;     // Catch: Exception -> L249
        r111.h = r53;     // Catch: Exception -> L249
        r111.i = r62;     // Catch: Exception -> L249
        r111.j = r55;     // Catch: Exception -> L249
        r111.m = 2;     // Catch: Exception -> L249
        Object r76 = r66.a(r19, r310, r62, r111);     // Catch: Exception -> L249
        if (r76 != r8) goto L161;
        return r8;
    L161:
        r4 = r4;
        r19 = r19;
        ScreenshotResult r122 = r310;
        r67 = r53;
        r68 = r25;
        r69 = r55;
        r6 = r76;
        r70 = r112;
    L163:
        r115 = r115;
        boolean r77 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, r115)).booleanValue();     // Catch: Exception -> L245
        if (r77 == true) goto L309;
    L171:
        if (r122 != null) goto L275;
    L168:
        r70 = r70;
    L182:
        Bitmap r123 = null;
    L291:
        r66 = r66;
        ((Map) ZeusTransformUtils.preCheckCast(r62, Map.class, r115)).put("was_interrupted", String.valueOf(r19.o()));     // Catch: Exception -> L240
        Map r78 = com.obric.autogui.agents.vlm.models.omni.d.b.a(r26, r19.f(), null, 4, null);     // Catch: Exception -> L240
        com.obric.autogui.agents.vlm.models.omni.b.b r79 = r19.d();     // Catch: Exception -> L240
        if (r79 == null) goto L206;
        LinkedHashMap r80 = new LinkedHashMap();     // Catch: Exception -> L240
        Iterator r81 = r78.entrySet().iterator();     // Catch: Exception -> L240
    L188:
        if (r81.hasNext() == false) goto L205;
        com.obric.autogui.agents.vlm.models.omni.f r124 = r26;
        Iterator r317 = r81;
        Map.Entry r82 = (Map.Entry) ZeusTransformUtils.preCheckCast(r81.next(), Map.Entry.class, r115);     // Catch: Exception -> L203
        String r318 = r68;
        String r83 = (String) ZeusTransformUtils.preCheckCast(r82.getKey(), String.class, r115);     // Catch: Exception -> L237
        if (d.h.b.o.a(r83, "effect_detector_execution_count") == false) goto L196;
    L199:
        boolean r84 = true;
    L200:
        if (r84 == false) goto L202;
        r80.put(r82.getKey(), r82.getValue());     // Catch: Exception -> L237
    L202:
        r81 = r317;
        r68 = r318;
        r26 = r124;
        goto L188
    L196:
        if (d.h.b.o.a(r83, "effect_core_blocking_total_elapsed_ms") == true) goto L199;
        r84 = false;
    L237:
        e = e;
        r68 = r318;
    L239:
        r26 = r124;
    L203:
        e = e;
        goto L239
    L205:
        r124 = r26;
        r318 = r68;
        r79.a((Map) ZeusTransformUtils.preCheckCast(r80, Map.class, r115));     // Catch: Exception -> L237
        d.x r85 = d.x.f38692a;     // Catch: Exception -> L237
    L207:
        com.obric.autogui.agents.vlm.models.omni.b.b r86 = r19.d();     // Catch: Exception -> L237
        if (r86 == null) goto L210;
        r86.b();     // Catch: Exception -> L237
        d.x r87 = d.x.f38692a;     // Catch: Exception -> L237
    L210:
        AtomicCapabilitySdk r88 = AtomicCapabilitySdk.INSTANCE;     // Catch: Exception -> L237
        IntentResult<?> r89 = new IntentResult(r69, r123, null, "step exec finished", false, false, 0, null, null, r62, 500, null);     // Catch: Exception -> L237
        r89.setFinal(true);     // Catch: Exception -> L237
        r88.updateIntentResult(r89, r19.b(), true);     // Catch: Exception -> L237
        r67.f38499a = true;     // Catch: Exception -> L237
        Loog r90 = Loog.INSTANCE;     // Catch: Exception -> L237
        StringBuilder r91 = new StringBuilder().append("notify result successfully tool_id=").append(r4).append(" hasBitmap=");     // Catch: Exception -> L237
        if (r123 == null) goto L213;
        boolean r92 = true;
    L214:
        StringBuilder r93 = r91.append(r92).append(" heifCacheReady=");     // Catch: Exception -> L237
        if (r77 == false) goto L217;
        boolean r94 = true;
    L218:
        StringBuilder r95 = r93.append(r94).append(" wasInterrupted=").append(r19.o()).append(" bitmapIsRecycled=");     // Catch: Exception -> L237
        if (r123 != null) goto L221;
    L223:
        boolean r125 = false;
    L224:
        StringBuilder r96 = r95.append(r125).append(r59);     // Catch: Exception -> L237
        if (r122 == null) goto L227;
        ScreenshotResult.Status r126 = r122.getStatus();     // Catch: Exception -> L237
    L228:
        StringBuilder r97 = r96.append(r126).append(" heifAttachment=");     // Catch: Exception -> L237
        if (r122 == null) goto L231;
        HeifScreenshotAttachment r127 = r122.getHeifAttachment();     // Catch: Exception -> L237
    L232:
        if (r127 == null) goto L234;
        boolean r98 = true;
    L235:
        r90.i(TAG, r97.append(r98).toString());     // Catch: Exception -> L237
        r70 = r70;
        r66 = r66;
        r68 = r318;
        r26 = r124;
        goto L260
    L234:
        r98 = false;
        goto L235
    L231:
        r127 = null;
        goto L232
    L227:
        r126 = null;
        goto L228
    L221:
        if (r123.isRecycled() != true) goto L223;
        r125 = true;
        goto L224
    L217:
        r94 = false;
        goto L218
    L213:
        r92 = false;
        goto L214
    L206:
        r124 = r26;
        r318 = r68;
    L240:
        e = e;
        r70 = r70;
        r66 = r66;
    L242:
        e = e;
    L244:
        r70 = r70;
        goto L257
    L275:
        r70 = r70;
        Bitmap r99 = com.obric.autogui.agents.vlm.models.omni.intent.h.f28416a.a(r122, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.b().getContext(), r115), Context.class, r115));     // Catch: Exception -> L178
        if (r99 == null) goto L182;
        r123 = r99.asShared();     // Catch: Exception -> L178
    L178:
        e = e;
    L180:
        e = e;
        goto L257
    L309:
        if (r19.a().l() == true) goto L171;
    L169:
        e = e;
    L245:
        e = e;
    L249:
        e = e;
        goto L256
    L307:
        r61 = r310.getStatus();     // Catch: Exception -> L148
        goto L151
    L143:
        r57 = false;
    L251:
        e = e;
        r66 = r34;
    L253:
        e = e;
        r66 = r34;
        r55 = r311;
        goto L256
    L127:
        r52 = r25;
        goto L128
    L129:
        Loog r100 = Loog.INSTANCE;
        StringBuilder r101 = new StringBuilder().append("[OAutoActionEffect] notify payload attach failed tool_id=").append(r4).append(", log_id=");
        if (r25 != null) goto L132;
        String r102 = "";
    L133:
        StringBuilder r103 = r101.append(r102).append(", is_multi_action=").append(r26.e()).append(", action_count=").append(r26.a()).append(", aggregate_completed=").append(r28.b()).append(", payload_default_used=").append(r112.e()).append(", error_type=");
        String r104 = r112.f();
        if (r104 != null) goto L136;
        r104 = "";
    L136:
        r100.w(TAG, r103.append(r104).toString());
        goto L137
    L132:
        r102 = r25;
        goto L133
    L119:
        r49 = null;
        goto L120
    L113:
        r46 = null;
        goto L114
    L107:
        r121 = null;
        goto L108
    L101:
        r119 = null;
        goto L102
    L94:
        r116 = r25;
        goto L95
    L88:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L90;
    L82:
        r24 = null;
        goto L83
    L78:
        r22 = false;
        goto L79
    L55:
        e = move-exception;
        Boolean r128 = null;
        ScreenshotResult r319 = r15;
        Exception r105 = e;
        String r106 = r4;
        r2 = r14;
        r17 = r319;
    L67:
        r2.b(r128);
        Loog r129 = Loog.INSTANCE;
        com.obric.autogui.agents.vlm.models.omni.l r130 = r2;
        r r320 = r11;
        StringBuilder r107 = new StringBuilder().append("[OAutoActionEffect] white screen result resolve failed screenshot_step_id=");
        if (r3 != null) goto L70;
        String r108 = "";
    L71:
        r129.w(TAG, r107.append(r108).append(", tool_id=").append(r106).append(", error_type=").append(r105.getClass().getSimpleName()).toString());
        r11 = r320;
        r4 = r106;
        r18 = r36;
        r19 = r130;
        r16 = null;
        goto L72
    L70:
        r108 = r3;
    L23:
        e = move-exception;
        r13 = " screenStatus=";
        r128 = null;
        r105 = e;
        r106 = r4;
        r2 = r14;
        r17 = r10;
        r36 = r1;
        goto L67
    L12:
        if (r9 != 2) goto L19;
        r69 = r7.j;
        r62 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r7.i, ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        r67 = (d.h.b.z.a) ZeusTransformUtils.preCheckCast(r7.h, d.h.b.z.a.class, "com.obric.aiagent.plugin");
        r70 = (com.obric.autogui.agents.vlm.models.omni.m.a) ZeusTransformUtils.preCheckCast(r7.g, com.obric.autogui.agents.vlm.models.omni.m.a.class, "com.obric.aiagent.plugin");
        r26 = (com.obric.autogui.agents.vlm.models.omni.f) ZeusTransformUtils.preCheckCast(r7.f, com.obric.autogui.agents.vlm.models.omni.f.class, "com.obric.aiagent.plugin");
        r68 = (String) ZeusTransformUtils.preCheckCast(r7.f28489e, String.class, "com.obric.aiagent.plugin");
        r4 = (String) ZeusTransformUtils.preCheckCast(r7.f28488d, String.class, "com.obric.aiagent.plugin");
        r122 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r7.f28487c, ScreenshotResult.class, "com.obric.aiagent.plugin");
        r19 = (com.obric.autogui.agents.vlm.models.omni.l) ZeusTransformUtils.preCheckCast(r7.f28486b, com.obric.autogui.agents.vlm.models.omni.l.class, "com.obric.aiagent.plugin");
        r66 = (r) ZeusTransformUtils.preCheckCast(r7.f28485a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Exception -> L16
        r115 = "com.obric.aiagent.plugin";
        r59 = " screenStatus=";
    L16:
        e = e;
        r115 = "com.obric.aiagent.plugin";
        goto L257
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L27:
        d.o.a(r6);
        com.obric.autogui.agents.vlm.models.omni.c.k r109 = this.g.a();
        if (r109 == null) goto L30;
        r109.a(r35.a());
        d.x r131 = d.x.f38692a;
    L30:
        if (r3 == null) goto L42;
        r2.a(r40);
        Loog r132 = Loog.INSTANCE;
        StringBuilder r133 = new StringBuilder().append("[OAutoActionEffect] model screenshot system animation bound to completed action screenshot_step_id=").append(r3).append(", tool_id=").append(r35.a().g()).append(", state=");
        if (r40 == null) goto L34;
        String r134 = r40.toString();
    L35:
        if (r134 != null) goto L37;
        r134 = "";
    L37:
        StringBuilder r135 = r133.append(r134).append(", available=");
        if (r40 == null) goto L40;
        boolean r136 = true;
    L41:
        r132.i(TAG, r135.append(r136).toString());
        goto L42
    L40:
        r136 = false;
        goto L41
    L34:
        r134 = null;
    L42:
        String r137 = r35.a().g();
        r13 = " screenStatus=";
        r7.f28485a = this;     // Catch: CancellationException -> L25 Exception -> L63
        r7.f28486b = r2;     // Catch: CancellationException -> L25 Exception -> L63
        r12 = r37;
        r7.f28487c = r12;     // Catch: CancellationException -> L25 Exception -> L61
        r17 = r38;
        r7.f28488d = r17;     // Catch: CancellationException -> L25 Exception -> L59
        r7.f28489e = r3;     // Catch: CancellationException -> L25 Exception -> L59
        r7.f = r137;     // Catch: CancellationException -> L25 Exception -> L59
        r36 = r36;
        r7.j = r36;     // Catch: CancellationException -> L25 Exception -> L57
        r7.m = 1;     // Catch: CancellationException -> L25 Exception -> L57
        r0 = r2.a(r3, 1000, r7);     // Catch: CancellationException -> L25 Exception -> L57
        if (r0 != r8) goto L52;
        return r8;
    L52:
        r15 = r17;
        r14 = r2;
        r4 = r137;
        r11 = this;
    L57:
        e = e;
    L66:
        r105 = e;
        r106 = r137;
        r128 = null;
        r11 = this;
    L59:
        e = e;
        r36 = r36;
    L61:
        e = e;
    L65:
        r17 = r38;
    L63:
        e = e;
        r12 = r37;
    L25:
        e = move-exception;
        throw e;
    L7:
        r7 = new f(this, r5);
        goto L8
    }

    private static final String a(com.obric.autogui.agents.vlm.models.omni.e r1) {
        d.h.b.o.e(r1, "it");
        return r1.e().a();
    }

    private static final d.x a(com.obric.autogui.agents.vlm.models.omni.l r10, String r11, int r12, d.h.b.z.a r13, com.obric.autogui.agents.vlm.models.omni.m.a r14, com.obric.autogui.agents.vlm.models.omni.e r15) {
        d.h.b.o.e(r15, "entry");
        com.obric.autogui.agents.vlm.models.omni.d.a.f28330a.a(r10, r11, com.obric.autogui.agents.vlm.models.omni.c.a(r10.h(), null, 1, null), r15, r12, r13.f38499a, r14.c(), r14.d());
        return d.x.f38692a;
    }

    private final Object a(com.obric.autogui.agents.vlm.models.omni.l r12, ScreenshotResult r13, ConcurrentHashMap<String, String> r14, d.c.d<? super Boolean> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r16, k.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f28507d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        boolean r6 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r11 = r0.f28506c;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f28505b, String.class, "com.obric.aiagent.plugin");
        r14 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r0.f28504a, ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L33:
        Boolean r19 = (Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r19, d.c.b.a.b.a(true)) == true) goto L41;
        Loog r110 = Loog.INSTANCE;
        StringBuilder r111 = new StringBuilder().append("cacheHeifScreenshot not ready fdKey=").append(r18).append(" reusedPreCache=").append(r11).append(" timedOut=");
        if (r19 == null) goto L39;
        r6 = false;
    L39:
        r110.w(TAG, r111.append(r6).toString());
        return d.c.b.a.b.a(false);
    L41:
        ((Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin")).put("has_screenshot", "1");
        Loog.INSTANCE.i(TAG, "cacheHeifScreenshot ready fdKey=" + r18 + " reusedPreCache=" + r11);
        return d.c.b.a.b.a(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        if (r13 == null) goto L44;
        HeifScreenshotAttachment r112 = r13.getHeifAttachment();
        if (r112 == null) goto L44;
        r18 = a(r12.b().getQuestionId());
        CharSequence r113 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
        if (r113 != null) goto L22;
    L25:
        boolean r114 = true;
    L26:
        if (r114 == false) goto L29;
        Loog.INSTANCE.w(TAG, "cacheHeifScreenshot skipped, fdKey is empty");
        return d.c.b.a.b.a(false);
    L29:
        boolean r115 = this.l.containsKey(r112.getFile().getAbsolutePath());
        d.h.a.m r116 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, r18, r112, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f28504a = r14;
        r0.f28505b = r18;
        r0.f28506c = r115;
        r0.f = 1;
        Object r117 = dg.b(2000, r116, r0);
        if (r117 != r2) goto L32;
        return r2;
    L32:
        r17 = r117;
        r11 = r115;
        goto L33
    L22:
        if (d.o.o.d(r113) == true) goto L25;
        r114 = false;
    L44:
        return d.c.b.a.b.a(false);
    L7:
        r0 = new k(this, r16);
        goto L8
    }

    private final au<Boolean> a(String r11, HeifScreenshotAttachment r12) {
        String r0 = r12.getFile().getAbsolutePath();
        au<Boolean> r1 = (au) ZeusTransformUtils.preCheckCast(this.l.get(r0), au.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        au<Boolean> r13 = kotlinx.coroutines.i.b(this.f.getCoroutineScope(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        au<Boolean> r10 = (au) ZeusTransformUtils.preCheckCast(this.l.putIfAbsent(r0, r13), au.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L9;
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(r13, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
        return r10;
    L9:
        return r13;
    }

    private final Object a(String r8, HeifScreenshotAttachment r9, d.c.d<? super Boolean> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r0.f28473e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28473e -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f28471c;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f28473e;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r9 = (HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(r0.f28470b, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin");
        r8 = (String) ZeusTransformUtils.preCheckCast(r0.f28469a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r7);     // Catch: Throwable -> L38
    L21:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L24;
        Loog.INSTANCE.w(TAG, "cacheHeifScreenshot skipped, heif encoding not complete fdKey=" + r8);     // Catch: Throwable -> L38
        return d.c.b.a.b.a(false);
    L24:
        IFlowFrontierIDL r13 = ad.a(d.h.b.aa.b(IFlowFrontierIDL.class));     // Catch: Throwable -> L38
        if (r13 != null) goto L28;
        Loog.INSTANCE.w(TAG, "cacheHeifScreenshot skipped, frontier ipc is null fdKey=" + r8);     // Catch: Throwable -> L38
        return d.c.b.a.b.a(false);
    L28:
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r9.openReadOnlyFd(), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        r13.cacheScreenshotFd(33555568, r8, (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r14, ParcelFileDescriptor.class, "com.obric.aiagent.plugin"), ao.b());     // Catch: Throwable -> L33
        d.x r15 = d.x.f38692a;     // Catch: Throwable -> L33
        d.f.c.a(r14, null);     // Catch: Throwable -> L38
        Loog.INSTANCE.i(TAG, "cacheHeifScreenshot success fdKey=" + r8);     // Catch: Throwable -> L38
        return d.c.b.a.b.a(true);
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        d.f.c.a(r14, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r7);
        Loog.INSTANCE.i(TAG, "cacheHeifScreenshot begin fdKey=" + r8);     // Catch: Throwable -> L38
        r0.f28469a = r8;     // Catch: Throwable -> L38
        r0.f28470b = r9;     // Catch: Throwable -> L38
        r0.f28473e = 1;     // Catch: Throwable -> L38
        r7 = r9.awaitEncodingComplete(r0);     // Catch: Throwable -> L38
        if (r7 != r12) goto L21;
        return r12;
    L38:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "cacheHeifScreenshot failed fdKey=" + r8, th);
        return d.c.b.a.b.a(false);
    L7:
        r0 = new b(this, r11);
        goto L8
    }

    private final String a(Object r3) {
        if (r3 == null) goto L17;
        String r4 = r3.toString();
        if (r4 == null) goto L18;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
    L13:
        r1 = false;
    L14:
        if (r1 == true) goto L16;
        return null;
    L16:
        return r4;
    L9:
        if (d.h.b.o.a(r4, "null") == true) goto L13;
        if (d.h.b.o.a(r4, "-1") == true) goto L13;
    L18:
        return null;
    L17:
        return null;
    }

    public final void m() {
        this.g.b();
        Object r1 = this.f28467d;
        monitor-enter(r1);
        k();     // Catch: Throwable -> L21
        this.k = true;     // Catch: Throwable -> L21
        this.h = null;     // Catch: Throwable -> L21
        d.x r4 = d.x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(r1);
        Collection<au<Boolean>> r2 = this.l.values();
        d.h.b.o.c(r2, "<get-values>(...)");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ca.a.a((ca) ZeusTransformUtils.preCheckCast((au) ZeusTransformUtils.preCheckCast(r3.next(), au.class, "com.obric.aiagent.plugin"), ca.class, "com.obric.aiagent.plugin"), null, 1, null);
        goto L8
    L10:
        this.l.clear();
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L13
        d.n.f(Boolean.valueOf(kotlinx.coroutines.a.t.a.a((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(((r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.aiagent.plugin")).f28468e, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin"), null, 1, null)));     // Catch: Throwable -> L13
    L26:
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L17
        ((r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.aiagent.plugin")).f.shutdown();     // Catch: Throwable -> L17
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L17
    L19:
        Loog.INSTANCE.i("OmniSession", '[' + this.f28465b + "] Destroyed");
        return;
    L17:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L13:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L21:
        th = move-exception;
        throw th;
    }
}
