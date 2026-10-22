package com.obric.autogui.agents.scripted.impl;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.google.gson.GsonBuilder;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOScriptJSModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOScriptJSModule extends JSModule {
    public static final a Companion = null;
    private static final String JSB_LOG_PREFIX = "script_jsb_";
    public static final String NAME = "AOScriptJSModule";
    private static final String TAG = "AOScriptJSModule";
    private final d.f coroutineScope$delegate;

    /* JADX INFO: compiled from: AOScriptJSModule.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AOScriptJSModule.kt */
    @d.c.b.a.f(b = "AOScriptJSModule.kt", c = {213, 215}, d = "invokeSuspend", e = "com.obric.autogui.agents.scripted.impl.AOScriptJSModule$fetchRequest$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f26931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReadableMap f26932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Callback f26933d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f26934e;
        final /* synthetic */ AOScriptJSModule f;

        b(ReadableMap r3, Callback r4, String r5, AOScriptJSModule r6, d.c.d<? super b> r7) {
            ReadableMap r8 = (ReadableMap) ZeusTransformUtils.wrapperContextForParams(r3, ReadableMap.class, "com.obric.aiagent.plugin");
            Callback r9 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26932c = r8;
            this.f26933d = r9;
            this.f26934e = r5;
            this.f = r6;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f26932c, this.f26933d, this.f26934e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v34 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            JSONObject r2 = d.c.a.b.a();
            int r3 = this.f26931b;
            if (r3 != 0) goto L134;
            d.o.a(r25);
            JSONObject r4 = new JSONObject();
            HashMap<String, Object> r12 = this.f26932c.toHashMap();     // Catch: Exception -> L126
            Object r5 = r12.get("method");     // Catch: Exception -> L126
            if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L21;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
        L23:
            if (r6 == null) goto L26;
            String r7 = r6.toUpperCase(Locale.ROOT);     // Catch: Exception -> L126
            d.h.b.o.c(r7, "toUpperCase(...)");     // Catch: Exception -> L126
            if (r7 == null) goto L26;
        L27:
            Object r13 = r12.get("headers");     // Catch: Exception -> L126
            if (ZeusTransformUtils.instanceOf(r13, Map.class) == false) goto L30;
            Map r14 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
        L31:
            Object r15 = r12.get("body");     // Catch: Exception -> L126
            if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L34;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
        L35:
            Object r16 = r12.get("timeoutMs");     // Catch: Exception -> L126
            if (ZeusTransformUtils.instanceOf(r16, Number.class) == false) goto L38;
            Number r17 = (Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
        L39:
            if (r17 == null) goto L41;
            int r18 = r17.intValue();     // Catch: Exception -> L126
        L42:
            if (r14 == null) goto L60;
            int r22 = r18;
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            Iterator r110 = r14.entrySet().iterator();     // Catch: Exception -> L126
        L45:
            if (r110.hasNext() == false) goto L55;
            Iterator r26 = r110;
            Map.Entry r111 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            Object r112 = r111.getKey();     // Catch: Exception -> L126
            Object r113 = r111.getValue();     // Catch: Exception -> L126
            String r114 = r7;
            if (ZeusTransformUtils.instanceOf(r112, String.class) == true) goto L49;
        L51:
            d.m r9 = null;
        L52:
            if (r9 == null) goto L54;
            r19.add(r9);     // Catch: Exception -> L126
        L54:
            r110 = r26;
            r7 = r114;
            goto L45
        L49:
            if (ZeusTransformUtils.instanceOf(r113, String.class) == false) goto L51;
            r9 = d.s.a(r112, r113);     // Catch: Exception -> L126
            goto L52
        L55:
            String r115 = r7;
            Map r10 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L126
            if (r10 == null) goto L61;
            Map<String, String> r11 = ao.e(r10);     // Catch: Exception -> L126
            if (r11 == null) goto L61;
        L63:
            if (r11.containsKey(DownloadHelper.CONTENT_TYPE) == true) goto L83;
            CharSequence r116 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            if (r116 != null) goto L67;
        L70:
            boolean r117 = true;
        L71:
            if (r117 == true) goto L83;
            String r118 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Exception -> L126
            com.obric.autogui.tools.api.net.d r20 = null;
            if (d.o.o.b(r118, "{", false, 2, null) == false) goto L75;
        L78:
            boolean r21 = true;
        L79:
            if (r21 == false) goto L81;
            String r23 = "application/json";
        L82:
            r11.put(DownloadHelper.CONTENT_TYPE, r23);     // Catch: Exception -> L126
        L84:
            String r24 = AODeviceInfo.INSTANCE.getDeviceInfo().getDeviceId();     // Catch: Exception -> L126
            if (r24 != null) goto L89;
            r24 = (String) ZeusTransformUtils.preCheckCast(r11.get("deviceId"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            if (r24 != null) goto L89;
            r24 = "";
        L89:
            r11.put("device_id", r24);     // Catch: Exception -> L126
            com.obric.autogui.tools.api.net.a r0 = com.obric.autogui.tools.a.a.f31480a.a();     // Catch: Exception -> L126
            if (r0 != null) goto L94;
            r4.put("ok", false);     // Catch: Exception -> L126
            r4.put("status", -1);     // Catch: Exception -> L126
            r4.put("body", "");     // Catch: Exception -> L126
            r4.put("headers", new JSONObject());     // Catch: Exception -> L126
            r4.put(WsConstants.KEY_CONNECTION_ERROR, "HttpClientUnavailable");     // Catch: Exception -> L126
            this.f26933d.invoke(new Object[]{r4.toString()});     // Catch: Exception -> L126
            return x.f38692a;
        L94:
            if (d.h.b.o.a(r115, "GET") == false) goto L99;
            String r27 = this.f26934e;     // Catch: Exception -> L126
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r119 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            this.f26930a = r4;     // Catch: Exception -> L126
            this.f26931b = 1;     // Catch: Exception -> L126
            Object r1 = r0.a(r27, r11, r22, r119);     // Catch: Exception -> L126
            JSONObject r28 = r4;
            if (r1 != r2) goto L98;
            return r2;
        L98:
            com.obric.autogui.tools.api.net.a.InterfaceC0861a r29 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            JSONObject r30 = r28;
        L108:
            if (com.obric.autogui.agents.scripted.c.b.f26918a.r() == false) goto L119;
            if (ZeusTransformUtils.instanceOf(r29, com.obric.autogui.tools.api.net.d.class) == false) goto L112;
            com.obric.autogui.tools.api.net.d r120 = (com.obric.autogui.tools.api.net.d) ZeusTransformUtils.preCheckCast(r29, com.obric.autogui.tools.api.net.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
        L113:
            if (r120 == null) goto L116;
            Object r31 = r120.b();     // Catch: Exception -> L126
            if (r31 == null) goto L116;
        L117:
            r30.put("log_id", r31);     // Catch: Exception -> L126
        L116:
            r31 = "";
            goto L117
        L112:
            r120 = r20;
        L119:
            if (r29.a() == false) goto L124;
            r30.put("ok", true);     // Catch: Exception -> L126
            r30.put("status", 200);     // Catch: Exception -> L126
            Object r32 = (String) ZeusTransformUtils.preCheckCast(r29.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            if (r32 != null) goto L123;
            r32 = "";
        L123:
            r30.put("body", r32);     // Catch: Exception -> L126
            r30.put("headers", new JSONObject());     // Catch: Exception -> L126
            JSONObject r33 = r30;
        L132:
            this.f26933d.invoke(new Object[]{r33.toString()});
            return x.f38692a;
        L124:
            Context r34 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOScriptJSModule.m719access$getMContext$p$s1110670674(this.f), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            d.h.b.o.c(r34, "access$getMContext$p$s-1110670674(...)");     // Catch: Exception -> L126
            com.obric.autogui.tools.api.net.b r35 = r29.a(r34);     // Catch: Exception -> L126
            r30.put("ok", false);     // Catch: Exception -> L126
            r30.put("status", -1);     // Catch: Exception -> L126
            r30.put("body", "");     // Catch: Exception -> L126
            r30.put("headers", new JSONObject());     // Catch: Exception -> L126
            r30.put(WsConstants.KEY_CONNECTION_ERROR, r35.getType() + ':' + r35.a());     // Catch: Exception -> L126
            r33 = r30;
            goto L132
        L99:
            int r121 = r22;
            String r122 = this.f26934e;     // Catch: Exception -> L126
            if (r8 != 0) goto L102;
            String r210 = "";
        L103:
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r211 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            this.f26930a = r4;     // Catch: Exception -> L126
            this.f26931b = 2;     // Catch: Exception -> L126
            Object r36 = r0.a(r122, r11, r210, r121, r211);     // Catch: Exception -> L126
            JSONObject r37 = r4;
            if (r36 != r2) goto L106;
            return r2;
        L106:
            r29 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r36, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            r30 = r37;
            goto L108
        L102:
            r210 = r8;
            goto L103
        L81:
            r23 = "text/plain; charset=utf-8";
            goto L82
        L75:
            if (d.o.o.b(r118, "[", false, 2, null) == true) goto L78;
            r21 = false;
            goto L79
        L67:
            if (r116.length() == 0) goto L70;
            r117 = false;
        L83:
            r20 = null;
        L61:
            r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L126
            goto L63
        L60:
            r115 = r7;
            r22 = r18;
            goto L61
        L41:
            r18 = 15000;
            goto L42
        L38:
            r17 = null;
            goto L39
        L34:
            r8 = null;
            goto L35
        L30:
            r14 = null;
        L26:
            r7 = "GET";
            goto L27
        L21:
            r6 = null;
        L126:
            e = e;
            r2 = r4;
        L128:
            com.obric.autogui.agents.scripted.c.c.a("AOScriptJSModule", "fetchRequest failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r2.put("ok", false);
            r2.put("status", -1);
            r2.put("body", "");
            r2.put("headers", new JSONObject());
            String r38 = e.getMessage();
            if (r38 != null) goto L131;
            r38 = e.getClass().getName();
        L131:
            r2.put(WsConstants.KEY_CONNECTION_ERROR, r38);
            r33 = r2;
            goto L132
        L134:
            if (r3 == 1) goto L11;
            if (r3 != 2) goto L10;
            JSONObject r39 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f26930a, JSONObject.class, "com.obric.aiagent.plugin");
            d.o.a(r25);     // Catch: Exception -> L14
            r36 = r25;
            r37 = r39;
            r20 = null;
            goto L106
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            JSONObject r40 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f26930a, JSONObject.class, "com.obric.aiagent.plugin");
            d.o.a(r25);     // Catch: Exception -> L14
            r1 = r25;
            r28 = r40;
            r20 = null;
        L14:
            e = e;
            goto L128
        }
    }

    /* JADX INFO: compiled from: AOScriptJSModule.kt */
    @d.c.b.a.f(b = "AOScriptJSModule.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.scripted.impl.AOScriptJSModule$getDeviceInfoAsync$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AOScriptJSModule f26936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Callback f26937c;

        c(AOScriptJSModule r3, Callback r4, d.c.d<? super c> r5) {
            Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26936b = r3;
            this.f26937c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f26936b, this.f26937c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f26935a != 0) goto L7;
            d.o.a(r6);
            com.obric.autogui.util.d.a r7 = com.obric.autogui.util.d.f31513a;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOScriptJSModule.m719access$getMContext$p$s1110670674(this.f26936b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r0, "access$getMContext$p$s-1110670674(...)");
            Map r8 = ao.e(r7.a(r0).e());
            com.obric.autogui.util.d.a r1 = com.obric.autogui.util.d.f31513a;
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOScriptJSModule.m719access$getMContext$p$s1110670674(this.f26936b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r2, "access$getMContext$p$s-1110670674(...)");
            d.m<Integer, Integer> r3 = r1.a(r2).c();
            r8.put("device_width", r3.a());
            r8.put("device_height", r3.b());
            this.f26937c.invoke(new Object[]{new JSONObject(r8).toString()});
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AOScriptJSModule.kt */
    @d.c.b.a.f(b = "AOScriptJSModule.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.scripted.impl.AOScriptJSModule$getFullDeviceInfo$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f26939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AOScriptJSModule f26940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Callback f26941d;

        d(String r3, AOScriptJSModule r4, Callback r5, d.c.d<? super d> r6) {
            Callback r7 = (Callback) ZeusTransformUtils.wrapperContextForParams(r5, Callback.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26939b = r3;
            this.f26940c = r4;
            this.f26941d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f26939b, this.f26940c, this.f26941d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f26938a != 0) goto L15;
            d.o.a(r9);
            List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
            JSONArray r3 = new JSONArray(this.f26939b);     // Catch: Exception -> L10
            int r4 = r3.length();     // Catch: Exception -> L10
            int r5 = 0;
        L6:
            if (r5 >= r4) goto L8;
            String r6 = r3.getString(r5);     // Catch: Exception -> L10
            d.h.b.o.c(r6, "getString(...)");     // Catch: Exception -> L10
            r2.add(r6);     // Catch: Exception -> L10
            r5 = r5 + 1;     // Catch: Exception -> L10
            goto L6
        L8:
            com.obric.autogui.util.d.a r7 = com.obric.autogui.util.d.f31513a;     // Catch: Exception -> L10
            Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOScriptJSModule.m719access$getMContext$p$s1110670674(this.f26940c), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
            d.h.b.o.c(r8, "access$getMContext$p$s-1110670674(...)");     // Catch: Exception -> L10
            this.f26941d.invoke(new Object[]{new JSONObject(r7.a(r8).a(r2)).toString()});     // Catch: Exception -> L10
        L13:
            return x.f38692a;
        L10:
            e = move-exception;
            com.obric.autogui.agents.scripted.c.c.a("AOScriptJSModule", "getFullDeviceInfo error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            this.f26941d.invoke(new Object[]{"{}"});
            goto L13
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AOScriptJSModule.kt */
    @d.c.b.a.f(b = "AOScriptJSModule.kt", c = {136, 137}, d = "invokeSuspend", e = "com.obric.autogui.agents.scripted.impl.AOScriptJSModule$getScreenshot$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f26943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AOScriptJSModule f26944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f26945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f26946e;
        final /* synthetic */ Callback f;

        e(AOScriptJSModule r3, float r4, String r5, Callback r6, d.c.d<? super e> r7) {
            Callback r8 = (Callback) ZeusTransformUtils.wrapperContextForParams(r6, Callback.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26944c = r3;
            this.f26945d = r4;
            this.f26946e = r5;
            this.f = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f26944c, this.f26945d, this.f26946e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26943b;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            com.obric.autogui.agents.vlm.models.a.g r2 = (com.obric.autogui.agents.vlm.models.a.g) ZeusTransformUtils.preCheckCast(this.f26942a, com.obric.autogui.agents.vlm.models.a.g.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
        L23:
            IScreenshot r16 = ((ScreenshotResult) ZeusTransformUtils.preCheckCast(r15, ScreenshotResult.class, "com.obric.aiagent.plugin")).getPic();
        L24:
            if (r16 != null) goto L26;
            this.f.invoke(new Object[0]);
        L28:
            return x.f38692a;
        L26:
            String r3 = AOScriptJSModule.access$bitmapToBase64Map(this.f26944c, r16.getBitmap(), r16.getScale());
            r2.a(r16);
            this.f.invoke(new Object[]{r3});
            goto L28
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r2 = (com.obric.autogui.agents.vlm.models.a.g) ZeusTransformUtils.preCheckCast(this.f26942a, com.obric.autogui.agents.vlm.models.a.g.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
        L16:
            r16 = ((ScreenshotResult) ZeusTransformUtils.preCheckCast(r15, ScreenshotResult.class, "com.obric.aiagent.plugin")).getPic();
            goto L24
        L10:
            d.o.a(r15);
            Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOScriptJSModule.m719access$getMContext$p$s1110670674(this.f26944c), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r4, "access$getMContext$p$s-1110670674(...)");
            com.obric.autogui.agents.vlm.models.a.g r17 = new com.obric.autogui.agents.vlm.models.a.g(r4, this.f26945d);
            String r7 = "script_screenshot_" + System.currentTimeMillis();
            String r5 = this.f26946e;
            if (d.h.b.o.a(r5, "virtual") == false) goto L18;
            com.obric.autogui.agents.vlm.models.a.a r6 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26942a = r17;
            this.f26943b = 1;
            Object r8 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r6, r7, null, false, false, r11, 14, null);
            if (r8 != r0) goto L15;
            return r0;
        L15:
            r2 = r17;
            r15 = r8;
            goto L16
        L18:
            if (d.h.b.o.a(r5, InitTaskProcess.MAIN) == false) goto L29;
            com.obric.autogui.agents.vlm.models.a.a r9 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26942a = r17;
            this.f26943b = 2;
            Object r12 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r9, r7, null, false, r10, 6, null);
            if (r12 != r0) goto L22;
            return r0;
        L22:
            r2 = r17;
            r15 = r12;
            goto L23
        L29:
            this.f.invoke(new Object[]{null});
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AOScriptJSModule.kt */
    @d.c.b.a.f(b = "AOScriptJSModule.kt", c = {85}, d = "invokeSuspend", e = "com.obric.autogui.agents.scripted.impl.AOScriptJSModule$getViewTree$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AOScriptJSModule f26948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Callback f26949c;

        f(AOScriptJSModule r3, Callback r4, d.c.d<? super f> r5) {
            Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26948b = r3;
            this.f26949c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f26948b, this.f26949c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r26) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f26947a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r26);
            Object r3 = r26;
        L11:
            List r1 = (List) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin");
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L14;
            Loog.INSTANCE.d("AOScriptJSModule", "get view tree: dumpList: " + r1);
        L14:
            List r4 = null;
            if (r1 == null) goto L33;
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r7 = r5.iterator();
        L18:
            if (r7.hasNext() == false) goto L25;
            VHNode r8 = ((ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r7.next(), ViewHierarchyDump.class, "com.obric.aiagent.plugin")).getRootNode();
            if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class) == false) goto L22;
            com.obric.autogui.platforms.tools.internal.viewhierarchy.a r9 = (com.obric.autogui.platforms.tools.internal.viewhierarchy.a) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class, "com.obric.aiagent.plugin");
        L23:
            if (r9 == null) goto L18;
            r6.add(r9);
            goto L18
        L22:
            r9 = null;
            goto L23
        L25:
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r12 = r10.iterator();
        L27:
            if (r12.hasNext() == false) goto L32;
            com.obric.autogui.agents.scripted.impl.d r13 = com.obric.autogui.agents.scripted.impl.d.f26978a.a((com.obric.autogui.platforms.tools.internal.viewhierarchy.a) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class, "com.obric.aiagent.plugin"));
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L31;
            Loog.INSTANCE.d("AOScriptJSModule", "jsViewTreeNode: " + r13);
        L31:
            r11.add(r13);
            goto L27
        L32:
            r4 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        L33:
            com.obric.autogui.util.d.a r14 = com.obric.autogui.util.d.f31513a;
            Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOScriptJSModule.m719access$getMContext$p$s1110670674(this.f26948b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r15, "access$getMContext$p$s-1110670674(...)");
            d.m<Integer, Integer> r16 = r14.a(r15).c();
            com.obric.autogui.agents.scripted.impl.b r23 = new com.obric.autogui.agents.scripted.impl.b(d.c.b.a.b.a(0), d.c.b.a.b.a(0), d.c.b.a.b.a(0), d.c.b.a.b.a(0), (Integer) ZeusTransformUtils.preCheckCast(r16.a(), Integer.class, "com.obric.aiagent.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r16.b(), Integer.class, "com.obric.aiagent.plugin"));
            if (r4 != null) goto L46;
            r4 = d.a.p.b();
        L46:
            String r17 = new GsonBuilder().create().toJson(new com.obric.autogui.agents.scripted.impl.d(null, null, null, "page", "page", null, null, null, r23, r4, ao.b(), 231, null));     // Catch: Exception -> L39
        L42:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L44;
            Loog.INSTANCE.d("AOScriptJSModule", "jsNodeJsonList: " + r17);
        L44:
            this.f26949c.invoke(new Object[]{r17});
            return x.f38692a;
        L39:
            e = move-exception;
            com.obric.autogui.agents.scripted.c.c.a("AOScriptJSModule", "parse view tree failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r17 = "{}";
            goto L42
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r26);
            AOSystemTools r18 = AOSystemTools.INSTANCE;
            int r19 = AutoActionVirtualDisplay.INSTANCE.getOperatingDisplayId();
            d.c.d r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26947a = 1;
            r3 = AOSystemTools.dumpViewHierarchy$default(r18, r19, false, r20, 2, null);
            if (r3 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ am lambda$_VlZyKIco5qRzI6fe8ABJT0CXdI() {
        return coroutineScope_delegate$lambda$0();
    }

    public static final /* synthetic */ String access$bitmapToBase64Map(AOScriptJSModule r0, Bitmap r1, double r2) {
        return r0.bitmapToBase64Map(r1, r2);
    }

    /* JADX INFO: renamed from: access$getMContext$p$s-1110670674, reason: not valid java name */
    public static final /* synthetic */ Context m719access$getMContext$p$s1110670674(AOScriptJSModule r0) {
        return r0.mContext;
    }

    public AOScriptJSModule(Context r3, Object r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        super(r5, r4);
        this.coroutineScope$delegate = d.g.a($$Lambda$AOScriptJSModule$_VlZyKIco5qRzI6fe8ABJT0CXdI.INSTANCE);
    }

    private final am getCoroutineScope() {
        return (am) ZeusTransformUtils.preCheckCast(this.coroutineScope$delegate.b(), am.class, "com.obric.aiagent.plugin");
    }

    private static final am coroutineScope_delegate$lambda$0() {
        return an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final String getCurrentAppInfo() {
        if (com.obric.autogui.agents.scripted.c.b.f26918a.j() == true) goto L6;
        return "{}";
    L6:
        com.obric.autogui.util.d.a r0 = com.obric.autogui.util.d.f31513a;
        Context r2 = this.mContext;
        d.h.b.o.c(r2, "mContext");
        String r3 = new JSONObject(r0.a(r2).d()).toString();
        d.h.b.o.c(r3, "toString(...)");
        return r3;
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final String getVDTopActivityInfo() {
        if (com.obric.autogui.agents.scripted.c.b.f26918a.k() == true) goto L5;
        return "{}";
    L5:
        DisplayedAppInfo r5 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r5 != null) goto L8;
        return "{}";
    L8:
        d.m[] r0 = new d.m[2];
        ComponentName r2 = r5.getTopActivity();
        String r3 = null;
        if (r2 == null) goto L11;
        String r4 = r2.flattenToString();
    L12:
        r0[0] = d.s.a("top_activity", r4);
        ComponentName r6 = r5.getTopActivity();
        if (r6 == null) goto L18;
        String r7 = r6.getPackageName();
        if (r7 == null) goto L18;
        r3 = r7;
    L21:
        r0[1] = d.s.a("top_app_package", r3);
        String r8 = new JSONObject(ao.a(r0)).toString();
        d.h.b.o.c(r8, "toString(...)");
        return r8;
    L18:
        ComponentName r9 = r5.getRealActivity();
        if (r9 == null) goto L21;
        r3 = r9.getPackageName();
        goto L21
    L11:
        r4 = null;
        goto L12
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void getViewTree(Callback r7) {
        Callback r8 = (Callback) ZeusTransformUtils.wrapperContextForParams(r7, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.l() == true) goto L6;
        r8.invoke(new Object[0]);
        return;
    L6:
        kotlinx.coroutines.i.a(getCoroutineScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void getScreenshot(String r11, float r12, Callback r13) {
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r13, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "type");
        d.h.b.o.e(r6, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.m() == true) goto L6;
        r6.invoke(new Object[0]);
        return;
    L6:
        kotlinx.coroutines.i.a(getCoroutineScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r12, r11, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void fetchRequest(String r12, ReadableMap r13, Callback r14) {
        ReadableMap r3 = (ReadableMap) ZeusTransformUtils.wrapperContextForParams(r13, ReadableMap.class, "com.obric.aiagent.plugin");
        Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r14, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "url");
        d.h.b.o.e(r3, "options");
        d.h.b.o.e(r4, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.q() == true) goto L7;
        r4.invoke(new Object[0]);
        return;
    L7:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L9;
        Loog.INSTANCE.d("AOScriptJSModule", "fetchRequest called: " + r12 + "  " + r3);
    L9:
        kotlinx.coroutines.i.a(getCoroutineScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r3, r4, r12, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final String getDeviceInfo() {
        if (com.obric.autogui.agents.scripted.c.b.f26918a.n() == true) goto L6;
        return "{}";
    L6:
        com.obric.autogui.util.d.a r0 = com.obric.autogui.util.d.f31513a;
        Context r1 = this.mContext;
        d.h.b.o.c(r1, "mContext");
        Map r2 = ao.e(r0.a(r1).e());
        com.obric.autogui.util.d.a r3 = com.obric.autogui.util.d.f31513a;
        Context r4 = this.mContext;
        d.h.b.o.c(r4, "mContext");
        d.m<Integer, Integer> r5 = r3.a(r4).c();
        r2.put("device_width", r5.a());
        r2.put("device_height", r5.b());
        String r6 = new JSONObject(r2).toString();
        d.h.b.o.c(r6, "toString(...)");
        return r6;
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void getDeviceInfoAsync(Callback r9) {
        Callback r10 = (Callback) ZeusTransformUtils.wrapperContextForParams(r9, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.n() == true) goto L6;
        r10.invoke(new Object[]{"{}"});
        return;
    L6:
        kotlinx.coroutines.i.a(getCoroutineScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void getFullDeviceInfo(String r9, Callback r10) {
        Callback r11 = (Callback) ZeusTransformUtils.wrapperContextForParams(r10, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "targetInfoListStr");
        d.h.b.o.e(r11, "callback");
        kotlinx.coroutines.i.a(getCoroutineScope(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r9, this, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void eventSender(String r10, ReadableMap r11) {
        ReadableMap r9 = (ReadableMap) ZeusTransformUtils.wrapperContextForParams(r11, ReadableMap.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "tag");
        d.h.b.o.e(r9, AutoTestConstant.PARAM);
        if (com.obric.autogui.agents.scripted.c.b.f26918a.o() == true) goto L6;
        return;
    L6:
        if (r9.hasKey("session_id") == false) goto L8;
        String r12 = r9.getString("session_id");
    L10:
        if (com.obric.autogui.agents.scripted.c.a.f26915a.a(r10, r12) == true) goto L12;
        return;
    L12:
        HashMap<String, Object> r13 = r9.toHashMap();
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L15;
        Loog r14 = Loog.INSTANCE;
        String r1 = r13.toString();
        d.h.b.o.c(r1, "toString(...)");
        r14.d(r10, r1);
    L15:
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), r10, new JSONObject((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin")), false, false, null, 28, null);
        return;
    L8:
        r12 = null;
        goto L10
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void log(String r3, String r4, String r5) {
        d.h.b.o.e(r3, "tag");
        d.h.b.o.e(r4, DBDefinition.SEGMENT_INFO);
        d.h.b.o.e(r5, "level");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.p() == true) goto L6;
        return;
    L6:
        switch(r5.hashCode()) {
            case 3237038: goto L31;
            case 3641990: goto L25;
            case 95458899: goto L19;
            case 96784904: goto L15;
            case 351107458: goto L9;
            default: goto L45;
        };
    L45:
        return;
    L9:
        if (r5.equals("verbose") == false) goto L46;
        String r2 = JSB_LOG_PREFIX + r3;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L37;
        Loog.INSTANCE.v(r2, r4);
        return;
    L37:
        return;
    L46:
        return;
    L15:
        if (r5.equals(WsConstants.KEY_CONNECTION_ERROR) == false) goto L47;
        com.obric.autogui.agents.scripted.c.c.a(JSB_LOG_PREFIX + r3, r4);
        return;
    L47:
        return;
    L19:
        if (r5.equals("debug") == false) goto L48;
        String r6 = JSB_LOG_PREFIX + r3;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L40;
        Loog.INSTANCE.d(r6, r4);
        return;
    L40:
        return;
    L48:
        return;
    L25:
        if (r5.equals("warn") == false) goto L49;
        String r7 = JSB_LOG_PREFIX + r3;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L42;
        Loog.INSTANCE.w(r7, r4);
        return;
    L42:
        return;
    L49:
        return;
    L31:
        if (r5.equals(DBDefinition.SEGMENT_INFO) == false) goto L50;
        String r8 = JSB_LOG_PREFIX + r3;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L44;
        Loog.INSTANCE.i(r8, r4);
        return;
    L44:
        return;
    }

    private final JavaOnlyMap toJavaOnlyMap(Map<String, ? extends Object> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        putValue(r0, (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue());
        goto L4
    L6:
        return r0;
    }

    private final void putValue(JavaOnlyMap r6, String r7, Object r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L8;
        r6.putBoolean(r7, ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L11;
        r6.putString(r7, (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r8, CharSequence.class) == false) goto L14;
        r6.putString(r7, r8.toString());
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L17;
        r6.putInt(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L20;
        r6.putLong(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r8, Short.class) == false) goto L23;
        r6.putInt(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).shortValue());
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r8, Byte.class) == false) goto L26;
        r6.putInt(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).byteValue());
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L29;
        r6.putDouble(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).doubleValue());
        return;
    L29:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == false) goto L32;
        r6.putDouble(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L32:
        if ((r8 instanceof byte[]) == false) goto L35;
        r6.putByteArray(r7, (byte[]) ZeusTransformUtils.preCheckCast(r8, byte[].class, "com.obric.aiagent.plugin"));
        return;
    L35:
        if (ZeusTransformUtils.instanceOf(r8, JavaOnlyMap.class) == false) goto L38;
        r6.putMap(r7, (WritableMap) ZeusTransformUtils.preCheckCast(r8, WritableMap.class, "com.obric.aiagent.plugin"));
        return;
    L38:
        if (ZeusTransformUtils.instanceOf(r8, JavaOnlyArray.class) == false) goto L41;
        r6.putArray(r7, (WritableArray) ZeusTransformUtils.preCheckCast(r8, WritableArray.class, "com.obric.aiagent.plugin"));
        return;
    L41:
        if (ZeusTransformUtils.instanceOf(r8, Map.class) == false) goto L56;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin")).keySet(), Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L45;
    L47:
        Iterator r1 = r0.iterator();
    L49:
        if (r1.hasNext() == false) goto L53;
        if (ZeusTransformUtils.instanceOf(r1.next(), String.class) == true) goto L49;
        r3 = false;
    L53:
        if (r3 == false) goto L77;
        r6.putMap(r7, (WritableMap) ZeusTransformUtils.preCheckCast(toJavaOnlyMap((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin")), WritableMap.class, "com.obric.aiagent.plugin"));
        return;
    L77:
        return;
    L45:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L47;
    L56:
        if (ZeusTransformUtils.instanceOf(r8, List.class) == false) goto L59;
        r6.putArray(r7, (WritableArray) ZeusTransformUtils.preCheckCast(toJavaOnlyArray((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin")), WritableArray.class, "com.obric.aiagent.plugin"));
        return;
    L59:
        if ((r8 instanceof Object[]) == false) goto L80;
        r6.putArray(r7, (WritableArray) ZeusTransformUtils.preCheckCast(toJavaOnlyArray(d.a.i.a((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin"))), WritableArray.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final JavaOnlyArray toJavaOnlyArray(List<?> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        JavaOnlyArray r0 = new JavaOnlyArray();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L64;
        Object r2 = r10.next();
        if (r2 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r2, CharSequence.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, Short.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r2, Byte.class) == true) goto L27;
        if (ZeusTransformUtils.instanceOf(r2, Double.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == true) goto L33;
        if ((r2 instanceof byte[]) == true) goto L36;
        if (ZeusTransformUtils.instanceOf(r2, JavaOnlyMap.class) == true) goto L39;
        if (ZeusTransformUtils.instanceOf(r2, JavaOnlyArray.class) == true) goto L42;
        if (ZeusTransformUtils.instanceOf(r2, Map.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r2, List.class) == true) goto L60;
        if ((r2 instanceof Object[]) == false) goto L4;
        r0.pushArray((WritableArray) ZeusTransformUtils.preCheckCast(toJavaOnlyArray(d.a.i.a((Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.aiagent.plugin"))), WritableArray.class, "com.obric.aiagent.plugin"));
        goto L4
    L60:
        r0.pushArray((WritableArray) ZeusTransformUtils.preCheckCast(toJavaOnlyArray((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")), WritableArray.class, "com.obric.aiagent.plugin"));
        goto L4
    L45:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).keySet(), Iterable.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L48;
    L50:
        Iterator r4 = r3.iterator();
    L52:
        if (r4.hasNext() == false) goto L56;
        if (ZeusTransformUtils.instanceOf(r4.next(), String.class) == true) goto L52;
        r5 = false;
    L56:
        if (r5 == false) goto L4;
        r0.pushMap((WritableMap) ZeusTransformUtils.preCheckCast(toJavaOnlyMap((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")), WritableMap.class, "com.obric.aiagent.plugin"));
        goto L4
    L48:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L50;
    L42:
        r0.pushArray((WritableArray) ZeusTransformUtils.preCheckCast(r2, WritableArray.class, "com.obric.aiagent.plugin"));
        goto L4
    L39:
        r0.pushMap((WritableMap) ZeusTransformUtils.preCheckCast(r2, WritableMap.class, "com.obric.aiagent.plugin"));
        goto L4
    L36:
        r0.pushByteArray((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.aiagent.plugin"));
        goto L4
    L33:
        r0.pushDouble(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).floatValue());
        goto L4
    L30:
        r0.pushDouble(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).doubleValue());
        goto L4
    L27:
        r0.pushInt(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).byteValue());
        goto L4
    L24:
        r0.pushInt(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).shortValue());
        goto L4
    L21:
        r0.pushLong(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue());
        goto L4
    L18:
        r0.pushInt(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L4
    L15:
        r0.pushString(r2.toString());
        goto L4
    L12:
        r0.pushString((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));
        goto L4
    L9:
        r0.pushBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        goto L4
    L64:
        return r0;
    }

    private final String bitmapToBase64Map(Bitmap r5, double r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Exception -> L5
        r5.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
        String r1 = Base64.encodeToString(r0.toByteArray(), 2);     // Catch: Exception -> L5
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
        r2.put("width", r5.getWidth());     // Catch: Exception -> L5
        r2.put("height", r5.getHeight());     // Catch: Exception -> L5
        r2.put("mime", "image/png");     // Catch: Exception -> L5
        r2.put("base64", r1);     // Catch: Exception -> L5
        r2.put("scale", r6);     // Catch: Exception -> L5
        String r7 = r2.toString();     // Catch: Exception -> L5
        d.h.b.o.c(r7, "toString(...)");     // Catch: Exception -> L5
        return r7;
    L5:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a("AOScriptJSModule", "bitmapToBase64Map failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return "{}";
    }
}
