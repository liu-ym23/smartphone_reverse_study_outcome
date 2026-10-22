package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.common.api.platform.system.CoarseLocationInfo;
import com.obric.autogui.common.api.platform.system.IAutoActionLocationApi;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.x;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConditionLocationRepo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionLocationRepo implements androidx.lifecycle.o, k {
    private static final String TAG = "ConditionLocationRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23073a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f23074c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f23075b;

    /* JADX INFO: compiled from: ConditionLocationRepo.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final String a() {
            return ConditionLocationRepo.a();
        }
    }

    /* JADX INFO: compiled from: ConditionLocationRepo.kt */
    @d.c.b.a.f(b = "ConditionLocationRepo.kt", c = {ChannelsEnvironment.BAND_6_GHZ_LAST_CH_NUM}, d = "getCurrentLocation", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationRepo")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f23078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ConditionLocationRepo f23079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23080e;

        b(ConditionLocationRepo r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23079d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23078c = r3;
            this.f23080e |= Integer.MIN_VALUE;
            return ConditionLocationRepo.a(this.f23079d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionLocationRepo.kt */
    @d.c.b.a.f(b = "ConditionLocationRepo.kt", c = {97}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationRepo$getLocationListForNet$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.autogui.common.d<n>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f23082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionLocationRepo f23083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23084d;

        c(Context r3, ConditionLocationRepo r4, String r5, d.c.d<? super c> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23082b = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f23083c = r4;
            this.f23084d = r5;
            super(2, r8);
        }

        private static final String a() {
            return "getLocationList, request failed:";
        }

        public static /* synthetic */ String lambda$dH0Y4MhbSBwm41SVY61ra5kKb8c() {
            return a();
        }

        public static /* synthetic */ String lambda$gX9zqqBpt3p72kI95oimNBDWFlU(com.obric.autogui.tools.api.net.a.InterfaceC0861a r0, Context r1) {
            return a(r0, r1);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.common.d<n>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23082b, this.f23083c, this.f23084d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.d<n>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23081a;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            d.o.a(r11);     // Catch: Throwable -> L7
        L19:
            final com.obric.autogui.tools.api.net.a.InterfaceC0861a r12 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            if (r12.a() == true) goto L23;
            Loog r0 = Loog.INSTANCE;     // Catch: Throwable -> L7
            final Context r3 = this.f23082b;     // Catch: Throwable -> L7
            r0.ep(ConditionLocationRepo.TAG, new $$Lambda$ConditionLocationRepo$c$gX9zqqBpt3p72kI95oimNBDWFlU(r12, r3), $$Lambda$ConditionLocationRepo$c$dH0Y4MhbSBwm41SVY61ra5kKb8c.INSTANCE);     // Catch: Throwable -> L7
            return com.obric.autogui.common.d.f29012a.a("getLocationList, request failed: " + r12.a(this.f23082b));
        L23:
            JsonObject r13 = (JsonObject) ZeusTransformUtils.preCheckCast(ConditionLocationRepo.a(this.f23083c).fromJson((String) ZeusTransformUtils.preCheckCast(r12.c(), String.class, "com.obric.aiagent.plugin"), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            int r4 = r13.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L7
            String r5 = r13.get("msg").getAsString();     // Catch: Throwable -> L7
            String r6 = r13.get("log_id").getAsString();     // Catch: Throwable -> L7
            if (r4 == 0) goto L32;
            Loog.INSTANCE.e(ConditionLocationRepo.TAG, "doCreateOrQueryTask failed, code: " + r4);     // Catch: Throwable -> L7
            return com.obric.autogui.common.d.f29012a.a("doCreateOrQueryTask failed, code: " + r4 + ", message: " + r5 + ", logId: " + r6);
        L32:
            return com.obric.autogui.common.d.f29012a.a((n) ZeusTransformUtils.preCheckCast(ConditionLocationRepo.a(this.f23083c).fromJson(r13.get("data"), n.class), n.class, "com.obric.aiagent.plugin"));
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r11);
            com.obric.autogui.tools.api.net.a r14 = com.obric.autogui.tools.a.a.f31480a.a();
            if (r14 == null) goto L14;
            JSONObject r7 = new JSONObject();
            r7.put("Keyword", this.f23084d);
            JSONObject r8 = new JSONObject();
            r8.put("AppId", "728048");
            r8.put("Did", AODeviceInfo.INSTANCE.getRpDid());
            x r9 = x.f38692a;
            r7.put("BizInfo", r8);
            JSONObject r10 = new JSONObject();
            x r15 = x.f38692a;
            r7.put("Adms", r10);
            r7.put("Page", 1);
            r7.put("Offset", 20);
            String r16 = ConditionLocationRepo.f23073a.a() + "/auto_action/api/address/input_tips";     // Catch: Throwable -> L7
            String r17 = r7.toString();     // Catch: Throwable -> L7
            d.h.b.o.c(r17, "toString(...)");     // Catch: Throwable -> L7
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f23081a = 1;     // Catch: Throwable -> L7
            r11 = r14.a(r16, r17, 60000, r18);     // Catch: Throwable -> L7
            if (r11 != r1) goto L19;
            return r1;
        L14:
            return com.obric.autogui.common.d.f29012a.a("network client is null");
        L7:
            th = move-exception;
            Loog.INSTANCE.e(ConditionLocationRepo.TAG, "getLocationList, request failed: " + Log.getStackTraceString(th));
            return com.obric.autogui.common.d.f29012a.a("getLocationList, request failed: " + th);
        }

        private static final String a(com.obric.autogui.tools.api.net.a.InterfaceC0861a r2, Context r3) {
            return "getLocationList, request failed: " + ((com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin")).a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionLocationRepo.kt */
    @d.c.b.a.f(b = "ConditionLocationRepo.kt", c = {137, 138, 139}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationRepo$getUserLocation$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ConditionLocationItemData>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f23087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f23088d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f23089e;
        final /* synthetic */ boolean f;
        final /* synthetic */ ConditionLocationRepo g;
        private /* synthetic */ Object h;

        /* JADX INFO: compiled from: ConditionLocationRepo.kt */
        @d.c.b.a.f(b = "ConditionLocationRepo.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationRepo$getUserLocation$2$companyDeferred$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super MemoryResponse<Location>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23090a;

            a(d.c.d<? super a> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f23090a != 0) goto L7;
                d.o.a(r1);
                return com.obric.memorydata.sdk.awareness.a.f33811a.a(com.obric.memorydata.sdk.awareness.e.f33825b);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: ConditionLocationRepo.kt */
        @d.c.b.a.f(b = "ConditionLocationRepo.kt", c = {ApWakeEvent.ACCELERATING_END}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationRepo$getUserLocation$2$curLocationDeferred$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionLocationItemData>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23091a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ConditionLocationRepo f23092b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Context f23093c;

            b(ConditionLocationRepo r3, Context r4, d.c.d<? super b> r5) {
                Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23092b = r3;
                this.f23093c = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super ConditionLocationItemData> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23092b, this.f23093c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionLocationItemData> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f23091a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                ConditionLocationRepo r7 = this.f23092b;
                Context r2 = this.f23093c;
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23091a = 1;
                r6 = ConditionLocationRepo.a(r7, r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: ConditionLocationRepo.kt */
        @d.c.b.a.f(b = "ConditionLocationRepo.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationRepo$getUserLocation$2$homeDeferred$1")
        static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super MemoryResponse<Location>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23094a;

            c(d.c.d<? super c> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f23094a != 0) goto L7;
                d.o.a(r1);
                return com.obric.memorydata.sdk.awareness.a.f33811a.a(com.obric.memorydata.sdk.awareness.e.f33824a);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d(boolean r3, boolean r4, Context r5, boolean r6, ConditionLocationRepo r7, d.c.d<? super d> r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23087c = r3;
            this.f23088d = r4;
            this.f23089e = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
            this.f = r6;
            this.g = r7;
            super(2, r10);
        }

        private static final String a() {
            return "address:";
        }

        private static final String b() {
            return "get location failed:";
        }

        private static final String c() {
            return "address:";
        }

        private static final String d() {
            return "get location failed:";
        }

        /* JADX INFO: renamed from: lambda$2Ty-KoCW6owwSq_EmMl8gQikHO8, reason: not valid java name */
        public static /* synthetic */ String m456lambda$2TyKoCW6owwSq_EmMl8gQikHO8() {
            return b();
        }

        public static /* synthetic */ String lambda$8yYwBZrw6m0wfX2Fq5AU1GrF8Es() {
            return c();
        }

        public static /* synthetic */ String lambda$KXwG53GNr3wDxBIqei5cWgKBDhE() {
            return d();
        }

        public static /* synthetic */ String lambda$Kiq_sa0YfcaacF0FscOr2bZA9tU() {
            return a();
        }

        public static /* synthetic */ String lambda$MpdA2Mn3lwVKibbyIBP3BxmKiqo(String r0, Location r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ String lambda$fs2_zEzGoAWoIgb4jGfm3BtPEGg(String r0, Location r1) {
            return b(r0, r1);
        }

        public static /* synthetic */ String lambda$jMT_WOCcdp2ubeWHKaDbHvg6mXA(MemoryResponse r0) {
            return b(r0);
        }

        /* JADX INFO: renamed from: lambda$v5zgIIeASa5Ka-QYvG41l5QStKs, reason: not valid java name */
        public static /* synthetic */ String m457lambda$v5zgIIeASa5KaQYvG41l5QStKs(MemoryResponse r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionLocationItemData>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            d r12 = new d(this.f23087c, this.f23088d, this.f23089e, this.f, this.g, r8);
            r12.h = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionLocationItemData>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r30) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23086b;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            MemoryResponse r3 = (MemoryResponse) ZeusTransformUtils.preCheckCast(this.f23085a, MemoryResponse.class, "com.obric.aiagent.plugin");
            final MemoryResponse r4 = (MemoryResponse) ZeusTransformUtils.preCheckCast(this.h, MemoryResponse.class, "com.obric.aiagent.plugin");
            d.o.a(r30);
            Object r5 = r30;
        L28:
            ConditionLocationItemData r6 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r5, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
            final MemoryResponse r7 = r3;
        L30:
            List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L33;
            d.c.b.a.b.a(r8.add(r6));
        L33:
            final String r9 = "";
            String r10 = "name";
            if (r4.isSuccess() == false) goto L55;
            final Location r11 = (Location) ZeusTransformUtils.preCheckCast(r4.getData(), Location.class, "com.obric.aiagent.plugin");
            if (this.f23088d == false) goto L38;
            String r12 = "name";
        L39:
            if (r11 == null) goto L43;
            Bundle r13 = r11.getExtras();
            if (r13 == null) goto L43;
            final String r14 = r13.getString(r12);
        L44:
            if (r14 != null) goto L46;
            r14 = "";
        L46:
            String r15 = this.f23089e.getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_home, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_home"));
            d.h.b.o.c(r15, "getString(...)");
            if (r11 == null) goto L49;
            double r21 = r11.getLongitude();
        L50:
            if (r11 == null) goto L52;
            double r23 = r11.getLatitude();
        L53:
            r8.add(new ConditionLocationItemData(0, r15, r14, r21, r23, false, null, 96, null));
            Loog.INSTANCE.dp(ConditionLocationRepo.TAG, new $$Lambda$ConditionLocationRepo$d$MpdA2Mn3lwVKibbyIBP3BxmKiqo(r14, r11), $$Lambda$ConditionLocationRepo$d$Kiq_sa0YfcaacF0FscOr2bZA9tU.INSTANCE);
        L58:
            if (r7.isSuccess() == false) goto L80;
            final Location r16 = (Location) ZeusTransformUtils.preCheckCast(r7.getData(), Location.class, "com.obric.aiagent.plugin");
            if (this.f23088d == true) goto L63;
            r10 = SensitiveType.ADDRESS;
        L63:
            if (r16 == null) goto L67;
            Bundle r17 = r16.getExtras();
            if (r17 == null) goto L67;
            String r18 = r17.getString(r10);
        L68:
            if (r18 == null) goto L71;
            r9 = r18;
        L71:
            String r0 = this.f23089e.getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_company, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_company"));
            d.h.b.o.c(r0, "getString(...)");
            if (r16 == null) goto L74;
            double r20 = r16.getLongitude();
        L75:
            if (r16 == null) goto L77;
            double r22 = r16.getLatitude();
        L78:
            r8.add(new ConditionLocationItemData(1, r0, r9, r20, r22, false, null, 96, null));
            Loog.INSTANCE.dp(ConditionLocationRepo.TAG, new $$Lambda$ConditionLocationRepo$d$fs2_zEzGoAWoIgb4jGfm3BtPEGg(r9, r16), $$Lambda$ConditionLocationRepo$d$8yYwBZrw6m0wfX2Fq5AU1GrF8Es.INSTANCE);
        L83:
            return p.o((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin"));
        L77:
            r22 = 0.0d;
            goto L78
        L74:
            r20 = 0.0d;
        L67:
            r18 = null;
            goto L68
        L80:
            if (this.f == false) goto L83;
            String r19 = this.f23089e.getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_company, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_company"));
            d.h.b.o.c(r19, "getString(...)");
            r8.add(new ConditionLocationItemData(1, r19, "", 0.0d, 0.0d, false, null, 64, null));
            Loog.INSTANCE.wp(ConditionLocationRepo.TAG, new $$Lambda$ConditionLocationRepo$d$jMT_WOCcdp2ubeWHKaDbHvg6mXA(r7), $$Lambda$ConditionLocationRepo$d$KXwG53GNr3wDxBIqei5cWgKBDhE.INSTANCE);
            goto L83
        L52:
            r23 = 0.0d;
            goto L53
        L49:
            r21 = 0.0d;
        L43:
            r14 = null;
            goto L44
        L38:
            r12 = SensitiveType.ADDRESS;
            goto L39
        L55:
            if (this.f == false) goto L58;
            String r24 = this.f23089e.getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_home, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_home"));
            d.h.b.o.c(r24, "getString(...)");
            r8.add(new ConditionLocationItemData(0, r24, "", 0.0d, 0.0d, false, null, 64, null));
            Loog.INSTANCE.wp(ConditionLocationRepo.TAG, new $$Lambda$ConditionLocationRepo$d$v5zgIIeASa5KaQYvG41l5QStKs(r4), $$Lambda$ConditionLocationRepo$d$2TyKoCW6owwSq_EmMl8gQikHO8.INSTANCE);
            goto L58
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r4 = (MemoryResponse) ZeusTransformUtils.preCheckCast(this.f23085a, MemoryResponse.class, "com.obric.aiagent.plugin");
            au r25 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
            d.o.a(r30);
            au r110 = r25;
            Object r26 = r30;
        L22:
            r7 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r26, MemoryResponse.class, "com.obric.aiagent.plugin");
            if (r110 == null) goto L29;
            d.c.d r27 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r4;
            this.f23085a = r7;
            this.f23086b = 3;
            r5 = r110.a(r27);
            if (r5 != r1) goto L27;
            return r1;
        L27:
            r3 = r7;
            goto L28
        L29:
            r6 = null;
            goto L30
        L11:
            au r28 = (au) ZeusTransformUtils.preCheckCast(this.f23085a, au.class, "com.obric.aiagent.plugin");
            au r29 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
            d.o.a(r30);
            au r31 = r28;
            r110 = r29;
            Object r32 = r30;
        L19:
            r4 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r32, MemoryResponse.class, "com.obric.aiagent.plugin");
            d.c.d r33 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r110;
            this.f23085a = r4;
            this.f23086b = 2;
            r26 = r31.a(r33);
            if (r26 != r1) goto L22;
            return r1;
        L12:
            d.o.a(r30);
            am r34 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.d(ConditionLocationRepo.TAG, "getLocation");
            if (this.f23087c == false) goto L15;
            r110 = kotlinx.coroutines.i.b(r34, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.g, this.f23089e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        L16:
            au r111 = kotlinx.coroutines.i.b(r34, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            r31 = kotlinx.coroutines.i.b(r34, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r110;
            this.f23085a = r31;
            this.f23086b = 1;
            r32 = r111.a(r112);
            if (r32 != r1) goto L19;
            return r1;
        L15:
            r110 = null;
            goto L16
        }

        private static final String a(String r3, Location r4) {
            StringBuilder r5 = new StringBuilder().append("address ").append(r3).append(", longitude ");
            Double r0 = null;
            if (r4 == null) goto L5;
            Double r1 = Double.valueOf(r4.getLongitude());
        L6:
            StringBuilder r6 = r5.append(r1).append(", latitude ");
            if (r4 == null) goto L10;
            r0 = Double.valueOf(r4.getLatitude());
        L10:
            return r6.append(r0).toString();
        L5:
            r1 = null;
            goto L6
        }

        private static final String a(MemoryResponse r2) {
            return "get location failed, errorCode: " + r2.getCode() + ", errorMessage: " + r2.getMessage();
        }

        private static final String b(String r3, Location r4) {
            StringBuilder r5 = new StringBuilder().append("address ").append(r3).append(", longitude ");
            Double r0 = null;
            if (r4 == null) goto L5;
            Double r1 = Double.valueOf(r4.getLongitude());
        L6:
            StringBuilder r6 = r5.append(r1).append(", latitude ");
            if (r4 == null) goto L10;
            r0 = Double.valueOf(r4.getLatitude());
        L10:
            return r6.append(r0).toString();
        L5:
            r1 = null;
            goto L6
        }

        private static final String b(MemoryResponse r2) {
            return "get location failed, errorCode: " + r2.getCode() + ", errorMessage: " + r2.getMessage();
        }
    }

    public ConditionLocationRepo() {
        this.f23075b = new GsonBuilder().create();
    }

    public static final /* synthetic */ Gson a(ConditionLocationRepo r0) {
        return r0.f23075b;
    }

    public static final /* synthetic */ Object a(ConditionLocationRepo r2, Context r3, d.c.d r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a() {
        return f23074c;
    }

    static {
        f23073a = new a(null);
        f23074c = d.o.o.b(com.obric.aiagent.product.a.a.f18769a.c(), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.location.k
    public Object a(Context r5, String r6, d.c.d<? super com.obric.autogui.common.d<n>> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r8, this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r9);
    }

    @Override // com.obric.autoaction.app.launcherpage.condition.location.k
    public Object a(Context r10, boolean r11, boolean r12, boolean r13, d.c.d<? super List<ConditionLocationItemData>> r14) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r12, r13, r5, r11, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r15);
    }

    private final Object a(Context r13, d.c.d<? super ConditionLocationItemData> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r16, b.class, "com.obric.aiagent.plugin");
        if ((r0.f23080e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23080e -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f23078c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f23080e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r15 = (Context) ZeusTransformUtils.preCheckCast(r0.f23077b, Context.class, "com.obric.aiagent.plugin");
        ConditionLocationRepo this = (ConditionLocationRepo) ZeusTransformUtils.preCheckCast(r0.f23076a, ConditionLocationRepo.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L21:
        com.obric.autogui.common.d r18 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        if (r18.g() == true) goto L25;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [UserLoc] failed to get coarse location: " + r18.h());
        return null;
    L25:
        CoarseLocationInfo r12 = (CoarseLocationInfo) ZeusTransformUtils.preCheckCast(r18.a(), CoarseLocationInfo.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L40;
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r12.getName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r19) == false) goto L30;
        r19 = r12.getRepresentation();
    L30:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.aiagent.plugin");
        String r9 = r15.getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_current, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_current"));
        String r5 = r12.getRepresentation();
        Double r110 = r12.getLongitude();
        if (r110 == null) goto L33;
        double r6 = r110.doubleValue();
    L34:
        Double r111 = r12.getLatitude();
        if (r111 == null) goto L37;
        double r7 = r111.doubleValue();
    L39:
        return new ConditionLocationItemData(2, r4, r5, r6, r7, false, r9, 32, null);
    L37:
        r7 = 0.0d;
        goto L39
    L33:
        r6 = 0.0d;
        goto L34
    L40:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        IAutoActionLocationApi r112 = AOPlatformTools.INSTANCE.location();
        if (r112 != null) goto L18;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [UserLoc] location-service not supported on this platform.");
        return null;
    L18:
        r0.f23076a = this;
        r0.f23077b = r15;
        r0.f23080e = 1;
        r17 = r112.acquireCoarseLocation(r15, true, true, r0);
        if (r17 != r2) goto L21;
        return r2;
    L7:
        r0 = new b(this, r16);
        goto L8
    }
}
