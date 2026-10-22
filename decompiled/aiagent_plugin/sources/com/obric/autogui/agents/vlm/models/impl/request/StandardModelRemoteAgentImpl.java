package com.obric.autogui.agents.vlm.models.impl.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardModelRemoteAgentImpl implements IAutoActionRemoteAgentApi, com.obric.autogui.tools.api.net.push.a {
    public static final a Companion = null;
    private static final long POLLING_INTERVAL = 5000;
    private static final String TAG = "StandardModelRemoteAgentImpl";
    private final Handler mHandler;
    private Runnable mTaskQueryRunnable;
    private IAutoActionRemoteAgentApi.QueueStateUpdateListener updateListener;

    /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27987a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f27988b = null;

        static {
            int[] r0 = new int[IAutoActionRemoteAgentApi.ErrorType.values().length];
            r0[IAutoActionRemoteAgentApi.ErrorType.QueueTimedOut.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L4:
            f27987a = r0;
            int[] r1 = new int[com.obric.autogui.common.b.c.values().length];
            r1[com.obric.autogui.common.b.c.p.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L12:
            r1[com.obric.autogui.common.b.c.f29008e.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L7:
            f27988b = r1;
        }
    }

    /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
    @d.c.b.a.f(b = "StandardModelRemoteAgentImpl.kt", c = {215}, d = "createOrQueryTask", e = "com.obric.autogui.agents.vlm.models.impl.request.StandardModelRemoteAgentImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StandardModelRemoteAgentImpl f27991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27992d;

        c(StandardModelRemoteAgentImpl r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27991c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27990b = r3;
            this.f27992d |= Integer.MIN_VALUE;
            return StandardModelRemoteAgentImpl.access$createOrQueryTask(this.f27991c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
    @d.c.b.a.f(b = "StandardModelRemoteAgentImpl.kt", c = {ChannelsEnvironment.BAND_6_GHZ_LAST_CH_NUM}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.request.StandardModelRemoteAgentImpl$createOrQueryTask$2")
    static final class d extends l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.autogui.common.e> f27994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StandardModelRemoteAgentImpl f27995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f27996d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.autogui.a.a.d> f27997e;

        d(z.f<com.obric.autogui.common.e> r3, StandardModelRemoteAgentImpl r4, com.obric.autogui.session.a r5, z.f<com.obric.autogui.a.a.d> r6, d.c.d<? super d> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27994b = r3;
            this.f27995c = r4;
            this.f27996d = r5;
            this.f27997e = r6;
            super(1, r8);
        }

        private static final String a() {
            return "checkQueueTime failed:";
        }

        public static /* synthetic */ String lambda$B7F3iP_WjGeCcOUZ3Yx7XyzW_5o(z.f r0) {
            return a(r0);
        }

        public static /* synthetic */ String lambda$LFR8eeDhVN3Ti5oqUrQS6YVLUQ0() {
            return a();
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r9) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f27994b, this.f27995c, this.f27996d, this.f27997e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r10v14, types: [T, com.obric.autogui.a.a.d] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, com.obric.autogui.common.e] */
        /* JADX WARN: Type inference failed for: r8v0, types: [T, com.obric.autogui.a.a.d] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27993a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L15:
            ?? r11 = (com.obric.autogui.a.a.d) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.a.a.d.class, "com.obric.aiagent.plugin");
            this.f27997e.f38504a = r11;
            return d.c.b.a.b.a(r11.a().getRetryable());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            z.f<com.obric.autogui.common.e> r12 = this.f27994b;
            StandardModelRemoteAgentImpl r2 = this.f27995c;
            com.obric.autogui.session.a r4 = this.f27996d;
            d.h.b.o.a(r4);
            r12.f38504a = StandardModelRemoteAgentImpl.access$checkQueueTime(r2, r4);
            if (((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(this.f27994b.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g() == true) goto L12;
            Loog r13 = Loog.INSTANCE;
            final z.f<com.obric.autogui.common.e> r3 = this.f27994b;
            r13.dp(StandardModelRemoteAgentImpl.TAG, new $$Lambda$StandardModelRemoteAgentImpl$d$B7F3iP_WjGeCcOUZ3Yx7XyzW_5o(r3), $$Lambda$StandardModelRemoteAgentImpl$d$LFR8eeDhVN3Ti5oqUrQS6YVLUQ0.INSTANCE);
            Loog.INSTANCE.w(StandardModelRemoteAgentImpl.TAG, "checkQueueTime failed");
            z.f<com.obric.autogui.a.a.d> r14 = this.f27997e;
            r14.f38504a = new com.obric.autogui.a.a.d(IAutoActionRemoteAgentApi.ErrorType.QueueTimedOut, com.obric.autogui.a.a.b.f.a(), this.f27996d.b(), 0, null, 16, null);
            return d.c.b.a.b.a(false);
        L12:
            StandardModelRemoteAgentImpl r15 = this.f27995c;
            com.obric.autogui.session.a r5 = this.f27996d;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27993a = 1;
            r10 = StandardModelRemoteAgentImpl.access$doCreateOrQueryTask(r15, r5, r6);
            if (r10 != r0) goto L15;
            return r0;
        }

        private static final String a(z.f r3) {
            return "checkQueueTime failed: " + ((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).h();
        }
    }

    /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
    @d.c.b.a.f(b = "StandardModelRemoteAgentImpl.kt", c = {308, 312, 340}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.request.StandardModelRemoteAgentImpl$doCreateOrQueryTask$4")
    static final class e extends l implements m<am, d.c.d<? super com.obric.autogui.a.a.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28002e;
        Object f;
        Object g;
        long h;
        int i;
        final /* synthetic */ com.obric.autogui.session.a j;
        final /* synthetic */ StandardModelRemoteAgentImpl k;

        /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f28003a = null;

            static {
                int[] r0 = new int[com.obric.autogui.tools.api.net.c.values().length];
                r0[com.obric.autogui.tools.api.net.c.i.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[com.obric.autogui.tools.api.net.c.j.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f28003a = r0;
            }
        }

        e(com.obric.autogui.session.a r3, StandardModelRemoteAgentImpl r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            this.k = r4;
            super(2, r6);
        }

        private static final String a() {
            return "doCreateOrQueryTask response";
        }

        private static final String b() {
            return "doCreateOrQueryTask error";
        }

        /* JADX INFO: renamed from: lambda$-tvGl-MH4akoUrSSqLE6W_yMON0, reason: not valid java name */
        public static /* synthetic */ String m769lambda$tvGlMH4akoUrSSqLE6W_yMON0(Throwable r0) {
            return a(r0);
        }

        public static /* synthetic */ String lambda$Ce0Z2Eou2gb6nweQRQd_Ar2W7uI() {
            return b();
        }

        public static /* synthetic */ x lambda$EWb_6IL8E4n35h09SenkaKJcRFo(long r0, long r2, Bundle r4) {
            return a(r0, r2, r4);
        }

        public static /* synthetic */ String lambda$XpGdv2iki5WqLDjcthPtkYwaUaQ() {
            return a();
        }

        /* JADX INFO: renamed from: lambda$lozTLnLo433HNr-wfZKGdj1OyXk, reason: not valid java name */
        public static /* synthetic */ String m770lambda$lozTLnLo433HNrwfZKGdj1OyXk(String r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.a.a.d> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.j, this.k, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.a.a.d> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r26) {
            Object r1 = d.c.a.b.a();
            int r2 = this.i;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L14;
            if (r2 != 3) goto L13;
            long r3 = this.h;
            o.a(r26);     // Catch: Throwable -> L10
            final long r9 = r3;
            Object r4 = r26;
        L60:
            com.obric.autogui.tools.api.net.a.InterfaceC0861a r5 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            final long r6 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L10
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.j.b(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L64;
            this.j.J().a(new $$Lambda$StandardModelRemoteAgentImpl$e$EWb_6IL8E4n35h09SenkaKJcRFo(r6, r9));     // Catch: Throwable -> L10
        L64:
            if (r5.a() == true) goto L74;
            com.obric.autogui.tools.api.net.b r7 = r5.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.j.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
            r7.b();     // Catch: Throwable -> L10
            Loog.INSTANCE.e(StandardModelRemoteAgentImpl.TAG, "doCreateOrQueryTask failed: " + r7.getType());     // Catch: Throwable -> L10
            int r8 = a.f28003a[r7.getType().ordinal()];     // Catch: Throwable -> L10
            if (r8 == 1) goto L71;
            if (r8 == 2) goto L70;
            IAutoActionRemoteAgentApi.ErrorType r10 = IAutoActionRemoteAgentApi.ErrorType.NetworkError;     // Catch: Throwable -> L10
        L73:
            return new com.obric.autogui.a.a.d(r10, com.obric.autogui.a.a.b.f.a(), this.j.b(), 0, null, 16, null);
        L70:
            r10 = IAutoActionRemoteAgentApi.ErrorType.ServiceError;     // Catch: Throwable -> L10
            goto L73
        L71:
            r10 = IAutoActionRemoteAgentApi.ErrorType.ApiError;     // Catch: Throwable -> L10
            goto L73
        L74:
            final String r11 = (String) ZeusTransformUtils.preCheckCast(r5.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            Loog.INSTANCE.dp(StandardModelRemoteAgentImpl.TAG, new $$Lambda$StandardModelRemoteAgentImpl$e$lozTLnLo433HNrwfZKGdj1OyXk(r11), $$Lambda$StandardModelRemoteAgentImpl$e$XpGdv2iki5WqLDjcthPtkYwaUaQ.INSTANCE);     // Catch: Throwable -> L10
            JsonObject r12 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r11, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            int r13 = r12.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L10
            String r14 = r12.get("msg").getAsString();     // Catch: Throwable -> L10
            String r15 = r12.get("log_id").getAsString();     // Catch: Throwable -> L10
            if (r13 == 0) goto L78;
            Loog.INSTANCE.e(StandardModelRemoteAgentImpl.TAG, "doCreateOrQueryTask failed, code: " + r13 + ", message: " + r14 + ", logId: " + r15);     // Catch: Throwable -> L10
            StandardModelRemoteAgentImpl r0 = this.k;     // Catch: Throwable -> L10
            d.h.b.o.a(r14);     // Catch: Throwable -> L10
            d.h.b.o.a(r15);     // Catch: Throwable -> L10
            return StandardModelRemoteAgentImpl.access$parseServiceError(r0, r13, r14, r15);
        L78:
            JsonObject r16 = r12.getAsJsonObject("data");     // Catch: Throwable -> L10
            StandardModelRemoteAgentImpl r17 = this.k;     // Catch: Throwable -> L10
            d.h.b.o.a(r16);     // Catch: Throwable -> L10
            return StandardModelRemoteAgentImpl.access$parseTaskQueryResponseUnsafe(r17, r16, this.j, StandardModelRemoteAgentImpl.access$getUpdateListener$p(this.k));
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            JSONObject r18 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f28001d, JSONObject.class, "com.obric.aiagent.plugin");
            JSONObject r19 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f28000c, JSONObject.class, "com.obric.aiagent.plugin");
            com.obric.autogui.session.a r110 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f27999b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            JSONObject r111 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f27998a, JSONObject.class, "com.obric.aiagent.plugin");
            o.a(r26);
            JSONObject r112 = r111;
            JSONObject r113 = r18;
            Object r20 = r26;
        L43:
            List r21 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin");
            if (r21 != null) goto L47;
            com.obric.autogui.session.a r114 = r110;
            JSONObject r115 = r19;
        L46:
            r21 = p.b();
            r19 = r115;
            r110 = r114;
        L47:
            Loog.INSTANCE.d(StandardModelRemoteAgentImpl.TAG, "supported script ability list: " + r21);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L50;
            r113.put("ability_desc_list", com.obric.autogui.util.b.f31495a.a().toJson(r21));
        L50:
            r19.put("hyper_params", r113.toString());
            long r22 = r110.R().b();
            if (r22 <= 0) goto L53;
            r19.put("doubao_message_id", r22);
        L53:
            String r23 = com.obric.autogui.a.a.f26086a.a();
            com.obric.autogui.tools.api.net.a r24 = com.obric.autogui.tools.a.a.f31480a.a();
            if (r24 == null) goto L56;
            r9 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L10
            String r116 = r112.toString();     // Catch: Throwable -> L10
            d.h.b.o.c(r116, "toString(...)");     // Catch: Throwable -> L10
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r117 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            this.f27998a = null;     // Catch: Throwable -> L10
            this.f27999b = null;     // Catch: Throwable -> L10
            this.f28000c = null;     // Catch: Throwable -> L10
            this.f28001d = null;     // Catch: Throwable -> L10
            this.f28002e = null;     // Catch: Throwable -> L10
            this.f = null;     // Catch: Throwable -> L10
            this.g = null;     // Catch: Throwable -> L10
            this.h = r9;     // Catch: Throwable -> L10
            this.i = 3;     // Catch: Throwable -> L10
            r4 = r24.a(r23, r116, 60000, r117);     // Catch: Throwable -> L10
            if (r4 != r1) goto L60;
            return r1;
        L56:
            return new com.obric.autogui.a.a.d(IAutoActionRemoteAgentApi.ErrorType.ClientError, com.obric.autogui.a.a.b.f.a(), "", 0, null, 16, null);
        L15:
            JSONObject r25 = (JSONObject) ZeusTransformUtils.preCheckCast(this.g, JSONObject.class, "com.obric.aiagent.plugin");
            String r27 = (String) ZeusTransformUtils.preCheckCast(this.f, String.class, "com.obric.aiagent.plugin");
            Gson r118 = (Gson) ZeusTransformUtils.preCheckCast(this.f28002e, Gson.class, "com.obric.aiagent.plugin");
            r113 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f28001d, JSONObject.class, "com.obric.aiagent.plugin");
            JSONObject r119 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f28000c, JSONObject.class, "com.obric.aiagent.plugin");
            com.obric.autogui.session.a r120 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(this.f27999b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
            JSONObject r121 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f27998a, JSONObject.class, "com.obric.aiagent.plugin");
            o.a(r26);
            r112 = r121;
            r114 = r120;
            Object r122 = r26;
            Gson r123 = r118;
            r115 = r119;
        L37:
            r25.put(r27, r123.toJson(((com.obric.autogui.agents.vlm.models.impl.applist.b) ZeusTransformUtils.preCheckCast(r122, com.obric.autogui.agents.vlm.models.impl.applist.b.class, "com.obric.aiagent.plugin")).b()));
            IJSScriptService r28 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");
            if (r28 == null) goto L46;
            Context r29 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r114.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            Set<String> r30 = r114.S();
            String r124 = r114.b();
            this.f27998a = r112;
            this.f27999b = r114;
            this.f28000c = r115;
            this.f28001d = r113;
            this.f28002e = null;
            this.f = null;
            this.g = null;
            this.i = 2;
            r20 = r28.getSupportedAbilityList(r29, r30, r124, this);
            if (r20 != r1) goto L42;
            return r1;
        L42:
            r19 = r115;
            r110 = r114;
            goto L43
        L16:
            o.a(r26);
            com.obric.autogui.agents.vlm.models.b r31 = com.obric.autogui.agents.vlm.models.b.f27277a.a(((Number) ZeusTransformUtils.preCheckCast(com.obric.autogui.common.a.m.f28999a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.j.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).e().d(), Number.class, "com.obric.aiagent.plugin")).intValue());
            Loog.INSTANCE.d(StandardModelRemoteAgentImpl.TAG, "current modelName: " + r31.a());
            boolean r125 = false;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.j.b(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L19;
            boolean r32 = true;
        L20:
            if (r32 == false) goto L22;
            com.obric.autogui.a.a.c r33 = com.obric.autogui.a.a.c.f26108b;
        L33:
            r115 = new JSONObject();
            com.obric.autogui.session.a r126 = this.j;
            r115.put("session_id", r126.b());
            r115.put("session_origin", r126.l().getLaunchOrigin());
            r115.put("request_type", r33.a());
            r115.put("model_name", r31.a());
            r115.put("device_id", r126.R().a());
            r115.put(WsConstants.KEY_APP_VERSION, AOHostAppTools.INSTANCE.getAppVersionCode());
            r25 = new JSONObject();
            r25.put("os_ota_version", com.bytedance.common.utility.c.a("ro.os.ota.version"));
            r27 = "app_list";
            r123 = com.obric.autogui.util.b.f31495a.b();
            com.obric.autogui.agents.vlm.models.impl.applist.b r127 = new com.obric.autogui.agents.vlm.models.impl.applist.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r126.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            this.f27998a = r115;
            this.f27999b = r126;
            this.f28000c = r115;
            this.f28001d = r25;
            this.f28002e = r123;
            this.f = "app_list";
            this.g = r25;
            this.i = 1;
            r122 = r127.a(this);
            if (r122 != r1) goto L36;
            return r1;
        L36:
            r112 = r115;
            r114 = r126;
            r113 = r25;
            goto L37
        L22:
            Object r34 = this.j.a(com.obric.autogui.agents.b.f26789a.a());
            if (ZeusTransformUtils.instanceOf(r34, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L25;
            com.obric.autogui.agents.vlm.b.C0677b r35 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r34, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        L26:
            if (r35 != null) goto L28;
        L30:
            if (r125 == false) goto L32;
            r33 = com.obric.autogui.a.a.c.f26109c;
            goto L33
        L32:
            r33 = com.obric.autogui.a.a.c.f26111e;
            goto L33
        L28:
            if (r35.j() != true) goto L30;
            r125 = true;
            goto L30
        L25:
            r35 = null;
            goto L26
        L19:
            r32 = false;
        L10:
            th = move-exception;
            Loog.INSTANCE.ep(StandardModelRemoteAgentImpl.TAG, new $$Lambda$StandardModelRemoteAgentImpl$e$tvGlMH4akoUrSSqLE6W_yMON0(th), $$Lambda$StandardModelRemoteAgentImpl$e$Ce0Z2Eou2gb6nweQRQd_Ar2W7uI.INSTANCE);
            return new com.obric.autogui.a.a.d(IAutoActionRemoteAgentApi.ErrorType.RespondedError, com.obric.autogui.a.a.b.f.a(), "", 0, null, 16, null);
        }

        private static final x a(long r0, long r2, Bundle r4) {
            r4.putLong("create_task_latency", r0 - r2);
            return x.f38692a;
        }

        private static final String a(String r2) {
            return "doCreateOrQueryTask response: " + r2;
        }

        private static final String a(Throwable r2) {
            return "doCreateOrQueryTask error: " + r2.getMessage();
        }
    }

    /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
    @d.c.b.a.f(b = "StandardModelRemoteAgentImpl.kt", c = {AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT}, d = "enterQueueState", e = "com.obric.autogui.agents.vlm.models.impl.request.StandardModelRemoteAgentImpl")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f28006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ StandardModelRemoteAgentImpl f28007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28008e;

        f(StandardModelRemoteAgentImpl r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28007d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28006c = r3;
            this.f28008e |= Integer.MIN_VALUE;
            return this.f28007d.enterQueueState(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModelRemoteAgentImpl.kt */
    @d.c.b.a.f(b = "StandardModelRemoteAgentImpl.kt", c = {538}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.request.StandardModelRemoteAgentImpl$mockQueue$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f28010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StandardModelRemoteAgentImpl f28011c;

        g(int r3, StandardModelRemoteAgentImpl r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28010b = r3;
            this.f28011c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f28010b, this.f28011c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28009a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            Loog.INSTANCE.d(StandardModelRemoteAgentImpl.TAG, " - debug: mock queueing [DONE] for " + this.f28010b + "ms");
            IAutoActionRemoteAgentApi.QueueStateUpdateListener r5 = StandardModelRemoteAgentImpl.access$getUpdateListener$p(this.f28011c);
            if (r5 == null) goto L15;
            r5.onQueueStateUpdated(new IAutoActionRemoteAgentApi.QueueStateUpdation(true, 0));
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            long r3 = this.f28010b;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28009a = 1;
            if (ax.a(r3, r7) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    private static final String dealWithQueueingError$lambda$1() {
        return "createOrQueryTask failed";
    }

    private static final String doCreateOrQueryTask$lambda$3() {
        return "doCreateOrQueryTask";
    }

    public static /* synthetic */ String lambda$6I1qGxnGwFmHiyv3WvnVaj2DNPM() {
        return onReceiveMsg$lambda$10();
    }

    /* JADX INFO: renamed from: lambda$8A1dPtsEj8j_nkIC-kX_ofXIiCQ, reason: not valid java name */
    public static /* synthetic */ String m766lambda$8A1dPtsEj8j_nkICkX_ofXIiCQ(com.obric.autogui.a.a.d r0) {
        return dealWithQueueingError$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$Czxxei1jahKD-BpBLi1Rvx8q6KM, reason: not valid java name */
    public static /* synthetic */ String m767lambda$Czxxei1jahKDBpBLi1Rvx8q6KM(com.obric.autogui.a.a.d r0) {
        return parseTaskQueryResponseUnsafe$lambda$7(r0);
    }

    public static /* synthetic */ String lambda$F1Y0DbfcJvrOY9dk9OCyCyp0a40() {
        return doCreateOrQueryTask$lambda$3();
    }

    public static /* synthetic */ String lambda$I9jaAmVHoaxSXL8hS2MVb_wk5As(String r0) {
        return onReceiveMsg$lambda$9(r0);
    }

    public static /* synthetic */ String lambda$PtyxBxs6mCT8TxO81Smtsijxqsc() {
        return dealWithQueueingError$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$VZPJiZ-livwa0eDbCv5RLV9gquI, reason: not valid java name */
    public static /* synthetic */ String m768lambda$VZPJiZlivwa0eDbCv5RLV9gquI(com.obric.autogui.session.a r0) {
        return doCreateOrQueryTask$lambda$2(r0);
    }

    public static /* synthetic */ String lambda$b9nrLr4FYvmytTFoQYs8Nxb8gPY() {
        return parseTaskQueryResponseUnsafe$lambda$8();
    }

    private static final String onReceiveMsg$lambda$10() {
        return "onReceiveMsg";
    }

    private static final String parseTaskQueryResponseUnsafe$lambda$8() {
        return "parseTaskQueryResponse";
    }

    public StandardModelRemoteAgentImpl() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTaskQueryRunnable = (Runnable) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Runnable.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autogui.common.e access$checkQueueTime(StandardModelRemoteAgentImpl r0, com.obric.autogui.session.a r1) {
        return r0.checkQueueTime(r1);
    }

    public static final /* synthetic */ Object access$createOrQueryTask(StandardModelRemoteAgentImpl r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.createOrQueryTask(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$dealWithQueueingError(StandardModelRemoteAgentImpl r0, com.obric.autogui.session.a r1, com.obric.autogui.a.a.d r2) {
        r0.dealWithQueueingError(r1, r2);
    }

    public static final /* synthetic */ Object access$doCreateOrQueryTask(StandardModelRemoteAgentImpl r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.doCreateOrQueryTask(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Handler access$getMHandler$p(StandardModelRemoteAgentImpl r0) {
        return r0.mHandler;
    }

    public static final /* synthetic */ Runnable access$getMTaskQueryRunnable$p(StandardModelRemoteAgentImpl r0) {
        return r0.mTaskQueryRunnable;
    }

    public static final /* synthetic */ IAutoActionRemoteAgentApi.QueueStateUpdateListener access$getUpdateListener$p(StandardModelRemoteAgentImpl r0) {
        return r0.updateListener;
    }

    public static final /* synthetic */ com.obric.autogui.a.a.d access$parseServiceError(StandardModelRemoteAgentImpl r0, int r1, String r2, String r3) {
        return r0.parseServiceError(r1, r2, r3);
    }

    public static final /* synthetic */ com.obric.autogui.a.a.d access$parseTaskQueryResponseUnsafe(StandardModelRemoteAgentImpl r2, JsonObject r3, com.obric.autogui.session.a r4, IAutoActionRemoteAgentApi.QueueStateUpdateListener r5) {
        return r2.parseTaskQueryResponseUnsafe(r3, r4, (IAutoActionRemoteAgentApi.QueueStateUpdateListener) ZeusTransformUtils.wrapperContextForParams(r5, IAutoActionRemoteAgentApi.QueueStateUpdateListener.class, "com.obric.aiagent.plugin"));
    }

    private final void dealWithQueueingError(com.obric.autogui.session.a r10, final com.obric.autogui.a.a.d r11) {
        Loog.INSTANCE.ep(TAG, new $$Lambda$StandardModelRemoteAgentImpl$8A1dPtsEj8j_nkICkX_ofXIiCQ(r11), $$Lambda$StandardModelRemoteAgentImpl$PtyxBxs6mCT8TxO81Smtsijxqsc.INSTANCE);
        IAutoActionRemoteAgentApi.ErrorType r9 = r11.a();
        if (b.f27987a[r9.ordinal()] != 1) goto L5;
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_queue_exceed_max_time, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_queue_exceed_max_time"));
        d.h.b.o.c(r12, "getString(...)");
        com.obric.autogui.session.state.termination.a.a(r10.J(), com.obric.autogui.common.e.f29014b.c(r12), 103003, null, null, 12, null);
    L6:
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_queue_terminated, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_queue_terminated"));
        d.h.b.o.c(r12, "getString(...)");
        com.obric.autogui.session.state.termination.a.a(r10.J(), com.obric.autogui.common.e.f29014b.c(r12), 103002, null, null, 12, null);
        goto L6
    }

    private static final String dealWithQueueingError$lambda$0(com.obric.autogui.a.a.d r2) {
        return "createOrQueryTask failed: " + r2;
    }

    @Override // com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi
    public Object enterQueueState(IAutoActionRemoteAgentApi.QueueStateUpdateListener r11, d.c.d<? super IAutoActionRemoteAgentApi.QueueStateEnteringResult> r12) {
        IAutoActionRemoteAgentApi.QueueStateUpdateListener r13 = (IAutoActionRemoteAgentApi.QueueStateUpdateListener) ZeusTransformUtils.wrapperContextForParams(r11, IAutoActionRemoteAgentApi.QueueStateUpdateListener.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r14, f.class, "com.obric.aiagent.plugin");
        if ((r0.f28008e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28008e -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f28006c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28008e;
        String r4 = "";
        boolean r6 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.autogui.session.a r10 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f28005b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        StandardModelRemoteAgentImpl r16 = (StandardModelRemoteAgentImpl) ZeusTransformUtils.preCheckCast(r0.f28004a, StandardModelRemoteAgentImpl.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L30:
        com.obric.autogui.a.a.d r17 = (com.obric.autogui.a.a.d) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.a.a.d.class, "com.obric.aiagent.plugin");
        if (r17.a() == IAutoActionRemoteAgentApi.ErrorType.Succeeded) goto L35;
        Loog.INSTANCE.e(TAG, "enterQueueState - createOrQueryTask failed: " + r17.a());
        return new IAutoActionRemoteAgentApi.QueueStateEnteringResult(r17.a(), "", false, 0);
    L35:
        if (r17.b() != com.obric.autogui.a.a.b.f26104c.a()) goto L37;
        r6 = true;
    L37:
        if (r6 == false) goto L49;
        if (r10 == null) goto L40;
        r10.b(AOSystemTools.INSTANCE.bootTimeMillis());
    L40:
        Loog r1 = Loog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append(" - debug: startQueueTime: ");
        Runnable r7 = null;
        if (r10 == null) goto L43;
        Long r18 = d.c.b.a.b.a(r10.g());
    L44:
        r1.d(TAG, r5.append(r18).toString());
        com.obric.autogui.tools.a.b.f31481a.a((com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin"));
        Handler r19 = r16.mHandler;
        Runnable r8 = r16.mTaskQueryRunnable;
        if (r8 != null) goto L47;
        d.h.b.o.c("mTaskQueryRunnable");
    L48:
        r19.postDelayed(r7, 5000);
        goto L49
    L47:
        r7 = r8;
        goto L48
    L43:
        r18 = null;
    L49:
        Loog.INSTANCE.d(TAG, "isQueueNeeded: " + r6);
        if (r6 == true) goto L59;
        if (com.obric.autogui.agents.vlm.models.impl.request.a.b.f28023a.c() == false) goto L59;
        int r110 = com.obric.autogui.agents.vlm.models.impl.request.a.b.f28023a.d();
        if (r110 < 2000) goto L56;
        r16.mockQueue(r110);
    L56:
        Loog.INSTANCE.d(TAG, "mockQueueing: millis = " + r110);
        return new IAutoActionRemoteAgentApi.QueueStateEnteringResult(IAutoActionRemoteAgentApi.ErrorType.Succeeded, r17.c(), true, 10);
    L59:
        return new IAutoActionRemoteAgentApi.QueueStateEnteringResult(IAutoActionRemoteAgentApi.ErrorType.Succeeded, r17.c(), r6, r17.d());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r15);
        this.updateListener = r13;
        com.obric.autogui.session.a r111 = com.obric.autogui.session.c.f30777a.b();
        if (r111 != null) goto L17;
    L26:
        r0.f28004a = this;
        r0.f28005b = r111;
        r0.f28008e = 1;
        r15 = createOrQueryTask(r111, r0);
        if (r15 != r2) goto L29;
        return r2;
    L29:
        r16 = this;
        r10 = r111;
        goto L30
    L17:
        if (r111.c() == false) goto L26;
        Bundle r112 = r111.l().getTaskExtras();
        if (r112 == null) goto L24;
        String r113 = r112.getString("session_id");
        if (r113 == null) goto L24;
        r4 = r113;
    L24:
        r111.a(r4);
        return new IAutoActionRemoteAgentApi.QueueStateEnteringResult(IAutoActionRemoteAgentApi.ErrorType.Succeeded, r111.b(), false, 0);
    L7:
        r0 = new f(this, r14);
        goto L8
    }

    @Override // com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi
    public Object checkNetworkLinkage(d.c.d<? super com.obric.autogui.common.e> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.session.state.c.f31395a.a();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.obric.autogui.common.e] */
    private final Object createOrQueryTask(com.obric.autogui.session.a r17, d.c.d<? super com.obric.autogui.a.a.d> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if ((r2.f27992d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f27992d -= Integer.MIN_VALUE;
    L8:
        c r9 = r2;
        Object r1 = r9.f27990b;
        Object r3 = d.c.a.b.a();
        int r4 = r9.f27992d;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        z.f r5 = (z.f) ZeusTransformUtils.preCheckCast(r9.f27989a, z.f.class, "com.obric.aiagent.plugin");
        o.a(r1);
    L18:
        T r6 = r5.f38504a;
        d.h.b.o.a(r6);
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        z.f r7 = new z.f();
        z.f r8 = new z.f();
        r8.f38504a = com.obric.autogui.common.e.f29014b.a();
        com.obric.autogui.util.a r11 = com.obric.autogui.util.a.f31488a;
        d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r10 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r8, this, r17, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r9.f27989a = r7;
        r9.f27992d = 1;
        if (r11.a("createOrQueryTask", 3, 100, r10, r9) != r3) goto L17;
        return r3;
    L17:
        r5 = r7;
    L7:
        r2 = new c(this, r0);
        goto L8
    }

    private final com.obric.autogui.common.e checkQueueTime(com.obric.autogui.session.a r8) {
        if (r8.g() <= 0) goto L9;
        k r7 = com.obric.autogui.common.a.m.f28999a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        long r3 = AOSystemTools.INSTANCE.bootTimeMillis() - r8.g();
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r7.g().d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        Loog.INSTANCE.d(TAG, " - debug: queueTime: " + r3 + ", max: " + r9);
        if (r3 <= r9) goto L8;
        Loog.INSTANCE.i(TAG, "doCreateOrQueryTask, exceed max queue time, time: " + r3 + ", max:" + r9);
        return com.obric.autogui.common.e.f29014b.b("exceed max queue time, time: " + r3 + ", max:" + r9);
    L8:
        return com.obric.autogui.common.e.f29014b.a();
    L9:
        Loog.INSTANCE.w(TAG, "doCreateOrQueryTask, startQueueTime is zero: " + r8.g());
        return com.obric.autogui.common.e.f29014b.a();
    }

    private final Object doCreateOrQueryTask(final com.obric.autogui.session.a r10, d.c.d<? super com.obric.autogui.a.a.d> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        Loog.INSTANCE.e(TAG, "doCreateOrQueryTask, session is null");
        return new com.obric.autogui.a.a.d(IAutoActionRemoteAgentApi.ErrorType.ClientError, com.obric.autogui.a.a.b.f.a(), "", 0, null, 16, null);
    L6:
        Loog.INSTANCE.dp(TAG, new $$Lambda$StandardModelRemoteAgentImpl$VZPJiZlivwa0eDbCv5RLV9gquI(r10), $$Lambda$StandardModelRemoteAgentImpl$F1Y0DbfcJvrOY9dk9OCyCyp0a40.INSTANCE);
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new e(r10, this, null), m.class, "com.obric.aiagent.plugin"), r12);
    }

    private static final String doCreateOrQueryTask$lambda$2(com.obric.autogui.session.a r2) {
        return "doCreateOrQueryTask, sessionId: " + r2.b();
    }

    private final com.obric.autogui.a.a.d parseServiceError(int r19, String r20, String r21) {
        com.obric.autogui.common.b.c r1 = com.obric.autogui.common.b.c.f29004a.a(r19);
        int r2 = b.f27988b[r1.ordinal()];
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L9;
        Loog.INSTANCE.e(TAG, "parseServiceError, unknown error type: " + r1);
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("exception_type", "queue_bad_state");
        r4.put("event_id", r21);
        r4.put("debug_info", "er=" + r19);
        x r0 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "technical_bad_case", r4, false, false, null, 28, null);
        return new com.obric.autogui.a.a.d(IAutoActionRemoteAgentApi.ErrorType.ApiError, com.obric.autogui.a.a.b.f.a(), "", 0, null, 16, null);
    L9:
        return new com.obric.autogui.a.a.d(IAutoActionRemoteAgentApi.ErrorType.ServiceError, com.obric.autogui.a.a.b.f.a(), "", 0, null, 16, null);
    L11:
        return new com.obric.autogui.a.a.d(IAutoActionRemoteAgentApi.ErrorType.QueueFull, com.obric.autogui.a.a.b.f26104c.a(), "", 0, null, 16, null);
    }

    private final com.obric.autogui.a.a.d parseTaskQueryResponseUnsafe(JsonObject r12, com.obric.autogui.session.a r13, IAutoActionRemoteAgentApi.QueueStateUpdateListener r14) {
        IAutoActionRemoteAgentApi.QueueStateUpdateListener r15 = (IAutoActionRemoteAgentApi.QueueStateUpdateListener) ZeusTransformUtils.wrapperContextForParams(r14, IAutoActionRemoteAgentApi.QueueStateUpdateListener.class, "com.obric.aiagent.plugin");
        int r0 = r12.get("task_status").getAsInt();
        String r8 = r12.get("session_id").getAsString();
        int r9 = r12.get("queue_num").getAsInt();
        String r7 = r12.get("model_name").getAsString();
        com.obric.autogui.agents.vlm.models.impl.applist.black.a[] r2 = (com.obric.autogui.agents.vlm.models.impl.applist.black.a[]) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r12.get("hard_blacklist").getAsJsonArray(), JsonElement.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.vlm.models.impl.applist.black.a[].class), com.obric.autogui.agents.vlm.models.impl.applist.black.a[].class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.applist.black.a[] r16 = (com.obric.autogui.agents.vlm.models.impl.applist.black.a[]) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r12.get("soft_blacklist").getAsJsonArray(), JsonElement.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.vlm.models.impl.applist.black.a[].class), com.obric.autogui.agents.vlm.models.impl.applist.black.a[].class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.c();
        com.obric.autogui.agents.vlm.models.impl.applist.black.g r3 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
        d.h.b.o.a(r2);
        r3.a(d.a.i.j(r2), com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27353a);
        com.obric.autogui.agents.vlm.models.impl.applist.black.g r4 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
        d.h.b.o.a(r16);
        r4.a(d.a.i.j(r16), com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27354b);
        List r17 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r5 = r2.length;
        boolean r10 = false;
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        r17.add(r2[r6].d());
        r6 = r6 + 1;
        goto L3
    L5:
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r2.length), Collection.class, "com.obric.aiagent.plugin");
        int r11 = r2.length;
        int r19 = 0;
    L6:
        if (r19 >= r11) goto L8;
        r18.add(r2[r19].d());
        r19 = r19 + 1;
        goto L6
    L8:
        OperatingSpaceManager.INSTANCE.setGlobalDisabledApps((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        IAutoActionRemoteAgentApi.ErrorType r20 = IAutoActionRemoteAgentApi.ErrorType.Succeeded;
        d.h.b.o.a(r8);
        d.h.b.o.a(r7);
        final com.obric.autogui.a.a.d r110 = new com.obric.autogui.a.a.d(r20, r0, r8, r9, r7);
        Loog.INSTANCE.dp(TAG, new $$Lambda$StandardModelRemoteAgentImpl$Czxxei1jahKDBpBLi1Rvx8q6KM(r110), $$Lambda$StandardModelRemoteAgentImpl$b9nrLr4FYvmytTFoQYs8Nxb8gPY.INSTANCE);
        if (r13 == null) goto L12;
        r13.a(r8);
    L12:
        if (r0 != com.obric.autogui.a.a.b.f26105d.a()) goto L14;
        r10 = true;
    L14:
        if (r10 == false) goto L19;
        Handler r111 = this.mHandler;
        Runnable r1 = this.mTaskQueryRunnable;
        if (r1 != null) goto L18;
        d.h.b.o.c("mTaskQueryRunnable");
        r1 = null;
    L18:
        r111.removeCallbacks(r1);
        com.obric.autogui.tools.a.b.f31481a.b((com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin"));
    L19:
        IAutoActionRemoteAgentApi.QueueStateUpdation r112 = new IAutoActionRemoteAgentApi.QueueStateUpdation(r10, r9);
        if (com.obric.autogui.agents.vlm.models.impl.request.a.b.f28023a.c() == false) goto L23;
        if (r10 == false) goto L23;
        return r110;
    L23:
        if (r15 == null) goto L25;
        r15.onQueueStateUpdated(r112);
    L25:
        return r110;
    }

    private static final String parseTaskQueryResponseUnsafe$lambda$7(com.obric.autogui.a.a.d r2) {
        return "parseTaskQueryResponse, response: " + r2;
    }

    @Override // com.obric.autogui.tools.api.net.push.a
    public void onReceiveMsg(final String r7) {
        d.h.b.o.e(r7, "message");
        Handler r0 = this.mHandler;
        Runnable r1 = this.mTaskQueryRunnable;
        if (r1 != null) goto L5;
        d.h.b.o.c("mTaskQueryRunnable");
        r1 = null;
    L5:
        r0.removeCallbacks(r1);
        Handler r2 = this.mHandler;
        Runnable r3 = this.mTaskQueryRunnable;
        if (r3 != null) goto L8;
        d.h.b.o.c("mTaskQueryRunnable");
        r3 = null;
    L8:
        r2.postDelayed(r3, 5000);
        Loog.INSTANCE.dp(TAG, new $$Lambda$StandardModelRemoteAgentImpl$I9jaAmVHoaxSXL8hS2MVb_wk5As(r7), $$Lambda$StandardModelRemoteAgentImpl$6I1qGxnGwFmHiyv3WvnVaj2DNPM.INSTANCE);
        JsonObject r8 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r7, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r8);
        parseTaskQueryResponseUnsafe(r8, null, this.updateListener);
    }

    private static final String onReceiveMsg$lambda$9(String r2) {
        return "onReceiveMsg, raw message: " + r2;
    }

    private final void mockQueue(int r10) {
        Loog.INSTANCE.d(TAG, " - debug: mock queueing for " + r10 + "ms");
        i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new g(r10, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
