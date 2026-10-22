package com.bytedance.ai.bridge.method.net;

import android.text.TextUtils;
import android.util.Base64;
import b4.k;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0012\u0015\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002J#\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AppletRequestMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestResultModel;", "getContentType", "", "headers", "", "createStreamResponseCallback", "com/bytedance/ai/bridge/method/net/AppletRequestMethod$createStreamResponseCallback$1", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lcom/bytedance/ai/bridge/core/CompletionBlock;)Lcom/bytedance/ai/bridge/method/net/AppletRequestMethod$createStreamResponseCallback$1;", "createResponseCallback", "com/bytedance/ai/bridge/method/net/AppletRequestMethod$createResponseCallback$1", "(Lcom/bytedance/ai/bridge/core/CompletionBlock;)Lcom/bytedance/ai/bridge/method/net/AppletRequestMethod$createResponseCallback$1;", "sendStreamEvent", "streamResponseData", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletRequestMethod extends AbsAppletRequestMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, k> f35625b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f35626c = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1", f = "AppletRequestMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $body;
        final /* synthetic */ String $bodyType;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsAppletRequestMethodIDL.b> $callback;
        final /* synthetic */ Map<String, Object> $header;
        final /* synthetic */ Map<String, Object> $methodParams;
        final /* synthetic */ AbsAppletRequestMethodIDL.a $params;
        final /* synthetic */ AbsAppletRequestMethodIDL.RequestMethodType $requestMethodType;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ AppletRequestMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f35627a = null;

            static {
                int[] r100 = new int[AbsAppletRequestMethodIDL.RequestMethodType.values().length];
                r100[AbsAppletRequestMethodIDL.RequestMethodType.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[AbsAppletRequestMethodIDL.RequestMethodType.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[AbsAppletRequestMethodIDL.RequestMethodType.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[AbsAppletRequestMethodIDL.RequestMethodType.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f35627a = r100;
            }
        }

        public AnonymousClass1(Map<String, ? extends Object> r100, AppletRequestMethod r101, String r102, Map<String, ? extends Object> r103, AbsAppletRequestMethodIDL.RequestMethodType r104, AbsAppletRequestMethodIDL.a r105, e3.d r106, f3.h<AbsAppletRequestMethodIDL.b> r107, Object r108, String r110, Continuation<? super AnonymousClass1> r111) {
            this.$header = r100;
            this.this$0 = r101;
            this.$url = r102;
            this.$methodParams = r103;
            this.$requestMethodType = r104;
            this.$params = r105;
            this.$bridgeContext = r106;
            this.$callback = r107;
            this.$body = r108;
            this.$bodyType = r110;
            super(2, r111);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            return new AnonymousClass1(this.$header, this.this$0, this.$url, this.$methodParams, this.$requestMethodType, this.$params, this.$bridgeContext, this.$callback, this.$body, this.$bodyType, r111);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L104;
            ResultKt.throwOnFailure(r110);
            b4.e r100 = b4.e.f17441a;
            Map<String, Object> r101 = this.$header;
            r100.getClass();
            Map<String, String> r102 = b4.e.c(r101);
            AppletRequestMethod r103 = this.this$0;
            ConcurrentHashMap<String, k> r104 = AppletRequestMethod.f35625b;
            r103.getClass();
            if (r102.containsKey(com.alipay.sdk.m.p.e.f25658f) == false) goto L8;
            String r105 = (String) ((LinkedHashMap) r102).get(com.alipay.sdk.m.p.e.f25658f);
        L11:
            String r106 = this.$url;
            Map<String, Object> r107 = this.$methodParams;
            Intrinsics.checkNotNullParameter(r106, "url");
            b4.g r108 = new b4.g(r106);
            if (r107 == null) goto L17;
            Iterator<Map.Entry<String, Object>> r109 = r107.entrySet().iterator();
        L15:
            if (r109.hasNext() == false) goto L17;
            Map.Entry<String, Object> r111 = r109.next();
            String r112 = r111.getKey();
            Object r113 = r111.getValue();
            b4.e.f17441a.getClass();
            String r114 = b4.e.h(r113);
            Intrinsics.checkNotNullParameter(r112, "name");
            Intrinsics.checkNotNullParameter(r114, "value");
            r108.f17455b.put(r112, r114);
        L17:
            String r115 = r108.a();
            IHostNetworkDepend r116 = r4.a.f535976c;
            if (r116 != null) goto L20;
            r116 = new b4.a();
        L20:
            AbsAppletRequestMethodIDL.RequestMethodType r117 = this.$requestMethodType;
            int r118 = a.f35627a[r117.ordinal()];
            if (r118 != 1) goto L23;
            boolean r119 = false;
            if (Intrinsics.areEqual(this.$params.getStreamType(), "sse") == false) goto L96;
            b4.e r120 = b4.e.f17441a;
            AppletRequestMethod r121 = this.this$0;
            e3.d r122 = this.$bridgeContext;
            f3.h<AbsAppletRequestMethodIDL.b> r123 = this.$callback;
            r121.getClass();
            b r124 = new b(r123, r121, r122);
            boolean r125 = this.$params.getAddCommonParams();
            Boolean r126 = this.$params.isCustomizedCookie();
            if (r126 == null) goto L95;
            r119 = r126.booleanValue();
        L95:
            r120.getClass();
            Intrinsics.checkNotNullParameter(r115, "targetUrl");
            Intrinsics.checkNotNullParameter(r102, "headers");
            Intrinsics.checkNotNullParameter(r124, "callback");
            Intrinsics.checkNotNullParameter(r116, "hostNetworkDepend");
            b4.f r127 = new b4.f(r115);
            Intrinsics.checkNotNullParameter(r102, "headers");
            r127.f17444b = r102;
            r127.f17445c = r125;
            r127.f17452j = r119;
            r127.f17449g = 15000;
            r127.f17451i = 15000;
            r127.f17450h = 15000;
            Intrinsics.checkNotNullParameter(r116, "hostNetworkDepend");
            b4.b r128 = b4.b.f17426a;
            com.bytedance.ai.bridge.method.net.core.RequestMethod r129 = com.bytedance.ai.bridge.method.net.core.RequestMethod.GET;
            r128.getClass();
            r124.a(b4.b.e(r129, r127, r116));
        L102:
            return Unit.INSTANCE;
        L96:
            b4.e r130 = b4.e.f17441a;
            AppletRequestMethod r131 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r132 = this.$callback;
            r131.getClass();
            com.bytedance.ai.bridge.method.net.a r133 = new com.bytedance.ai.bridge.method.net.a(r132);
            boolean r134 = this.$params.getAddCommonParams();
            Boolean r135 = this.$params.isCustomizedCookie();
            if (r135 == null) goto L99;
            boolean r136 = r135.booleanValue();
        L100:
            b4.e.d(r130, r115, r102, r133, null, r116, r134, r136);
            goto L102
        L99:
            r136 = false;
            goto L100
        L23:
            if (r118 != 2) goto L25;
            if (r105 != null) goto L51;
            String r137 = "application/x-www-form-urlencoded";
        L52:
            r102.put("Content-Type", r137);
            if (Intrinsics.areEqual(this.$params.getStreamType(), "sse") == false) goto L77;
            b4.e r138 = b4.e.f17441a;
            Object r139 = this.$body;
            AppletRequestMethod r140 = this.this$0;
            e3.d r141 = this.$bridgeContext;
            f3.h<AbsAppletRequestMethodIDL.b> r142 = this.$callback;
            r140.getClass();
            b r143 = new b(r142, r140, r141);
            boolean r144 = this.$params.getAddCommonParams();
            Boolean r145 = this.$params.isCustomizedCookie();
            if (r145 == null) goto L57;
            boolean r146 = r145.booleanValue();
        L58:
            r138.getClass();
            Intrinsics.checkNotNullParameter(r115, "targetUrl");
            Intrinsics.checkNotNullParameter(r102, "headers");
            Intrinsics.checkNotNullParameter(r137, "contentType");
            Intrinsics.checkNotNullParameter(r143, "callback");
            Intrinsics.checkNotNullParameter(r116, "hostNetworkDepend");
        L74:
            th = move-exception;
            com.bytedance.ai.utils.g.f37637a.e(b4.e.f17442b, "get failed", th);
            goto L102
        L60:
            if ((r139 instanceof byte[]) == false) goto L63;
            b4.f r147 = new b4.f(r115);     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r102, "headers");     // Catch: Throwable -> L74
            r147.f17444b = r102;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r137, "contentType");     // Catch: Throwable -> L74
            r147.f17448f = r137;     // Catch: Throwable -> L74
            r147.f17445c = r144;     // Catch: Throwable -> L74
            r147.f17452j = r146;     // Catch: Throwable -> L74
            r147.f17447e = (byte[]) r139;     // Catch: Throwable -> L74
            r147.f17449g = 15000;     // Catch: Throwable -> L74
            r147.f17451i = 15000;     // Catch: Throwable -> L74
            r147.f17450h = 15000;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r116, "hostNetworkDepend");     // Catch: Throwable -> L74
            b4.b r148 = b4.b.f17426a;     // Catch: Throwable -> L74
            com.bytedance.ai.bridge.method.net.core.RequestMethod r149 = com.bytedance.ai.bridge.method.net.core.RequestMethod.POST;     // Catch: Throwable -> L74
            r148.getClass();     // Catch: Throwable -> L74
            r143.a(b4.b.e(r149, r147, r116));     // Catch: Throwable -> L74
            goto L102
        L63:
            if ((r139 instanceof String) == false) goto L66;
            byte[] r150 = ((String) r139).getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
        L72:
            b4.f r151 = new b4.f(r115);     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r102, "headers");     // Catch: Throwable -> L74
            r151.f17444b = r102;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r137, "contentType");     // Catch: Throwable -> L74
            r151.f17448f = r137;     // Catch: Throwable -> L74
            r151.f17445c = r144;     // Catch: Throwable -> L74
            r151.f17452j = r146;     // Catch: Throwable -> L74
            r151.f17447e = r150;     // Catch: Throwable -> L74
            r151.f17449g = 15000;     // Catch: Throwable -> L74
            r151.f17451i = 15000;     // Catch: Throwable -> L74
            r151.f17450h = 15000;     // Catch: Throwable -> L74
            r151.f17453k = -1;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r116, "hostNetworkDepend");     // Catch: Throwable -> L74
            b4.b r152 = b4.b.f17426a;     // Catch: Throwable -> L74
            com.bytedance.ai.bridge.method.net.core.RequestMethod r153 = com.bytedance.ai.bridge.method.net.core.RequestMethod.POST;     // Catch: Throwable -> L74
            r152.getClass();     // Catch: Throwable -> L74
            r143.a(b4.b.e(r153, r151, r116));     // Catch: Throwable -> L74
            goto L102
        L66:
            if ((r139 instanceof List) == false) goto L69;
            r150 = new JSONArray((Collection) r139).toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
            goto L72
        L69:
            if ((r139 instanceof Map) == false) goto L71;
            r150 = new JSONObject((Map) r139).toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
            goto L72
        L71:
            r150 = new JSONObject().toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
            goto L72
        L57:
            r146 = false;
            goto L58
        L77:
            if ((this.$body instanceof String) == true) goto L79;
        L85:
            b4.e r154 = b4.e.f17441a;
            Object r155 = this.$body;
            AppletRequestMethod r156 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r157 = this.$callback;
            r156.getClass();
            com.bytedance.ai.bridge.method.net.a r158 = new com.bytedance.ai.bridge.method.net.a(r157);
            boolean r159 = this.$params.getAddCommonParams();
            Boolean r160 = this.$params.isCustomizedCookie();
            if (r160 == null) goto L88;
            boolean r161 = r160.booleanValue();
        L89:
            b4.e.f(r154, r115, r102, r137, r155, r158, null, r116, r159, r161);
            goto L102
        L88:
            r161 = false;
            goto L89
        L79:
            if (Intrinsics.areEqual(this.$bodyType, TTVideoEngineInterface.PLAY_API_KEY_BASE64) == false) goto L85;
            b4.e r162 = b4.e.f17441a;
            byte[] r163 = Base64.decode((String) this.$body, 0);
            AppletRequestMethod r164 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r165 = this.$callback;
            r164.getClass();
            com.bytedance.ai.bridge.method.net.a r166 = new com.bytedance.ai.bridge.method.net.a(r165);
            boolean r167 = this.$params.getAddCommonParams();
            Boolean r168 = this.$params.isCustomizedCookie();
            if (r168 == null) goto L83;
            boolean r169 = r168.booleanValue();
        L84:
            b4.e.f(r162, r115, r102, r137, r163, r166, null, r116, r167, r169);
            goto L102
        L83:
            r169 = false;
            goto L84
        L51:
            r137 = r105;
            goto L52
        L25:
            if (r118 != 3) goto L27;
            Object r170 = this.$body;
            if (r170 != null) goto L37;
        L39:
            JSONObject r171 = new JSONObject();
        L40:
            JSONObject r172 = r171;
            b4.e r173 = b4.e.f17441a;
            if (r105 != null) goto L43;
            String r174 = "application/x-www-form-urlencoded";
        L44:
            AppletRequestMethod r175 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r176 = this.$callback;
            r175.getClass();
            com.bytedance.ai.bridge.method.net.a r177 = new com.bytedance.ai.bridge.method.net.a(r176);
            boolean r178 = this.$params.getAddCommonParams();
            Boolean r179 = this.$params.isCustomizedCookie();
            if (r179 == null) goto L47;
            boolean r180 = r179.booleanValue();
        L48:
            b4.e.g(r173, r115, r102, r174, r172, r177, null, r116, r178, r180);
            goto L102
        L47:
            r180 = false;
            goto L48
        L43:
            r174 = r105;
            goto L44
        L37:
            if ((r170 instanceof Map) == false) goto L39;
            r171 = new JSONObject((Map) this.$body);
            goto L40
        L27:
            if (r118 != 4) goto L102;
            b4.e r181 = b4.e.f17441a;
            AppletRequestMethod r182 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r183 = this.$callback;
            r182.getClass();
            com.bytedance.ai.bridge.method.net.a r184 = new com.bytedance.ai.bridge.method.net.a(r183);
            boolean r185 = this.$params.getAddCommonParams();
            Boolean r186 = this.$params.isCustomizedCookie();
            if (r186 == null) goto L32;
            boolean r187 = r186.booleanValue();
        L33:
            b4.e.b(r181, r115, r102, r184, null, r116, r185, r187);
            goto L102
        L32:
            r187 = false;
            goto L33
        L8:
            if (r102.containsKey("Content-Type") == false) goto L10;
            r105 = (String) ((LinkedHashMap) r102).get("Content-Type");
            goto L11
        L10:
            r105 = null;
            goto L11
        L104:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f35625b = new ConcurrentHashMap();
        f35626c = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(TTExecutors.getNormalExecutor()));
    }

    public AppletRequestMethod() {
    }

    public static final void b(AppletRequestMethod r100, e3.d r101, AbsAppletRequestMethodIDL.StreamResponseData r102) {
        r100.getClass();
        r101.a("applet.streamResponse", com.bytedance.ai.applet.base.gson.e.d(r102));
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, f3.h r210) {
        AbsAppletRequestMethodIDL.a r100 = (AbsAppletRequestMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        AbsAppletRequestMethodIDL.RequestMethodType.a r101 = AbsAppletRequestMethodIDL.RequestMethodType.Companion;
        String r102 = r100.getMethod();
        r101.getClass();
        if (r102 != null) goto L16;
        AbsAppletRequestMethodIDL.RequestMethodType r103 = AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED;
    L8:
        AbsAppletRequestMethodIDL.RequestMethodType r104 = r103;
        if (r104 != AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED) goto L11;
        f3.h.a.a(r210, "Illegal method " + r100.getMethod(), null, null, 14);
        return;
    L11:
        Map<String, Object> r105 = r100.getHeader();
        Object r106 = r100.getBody();
        String r112 = r100.getBodyType();
        Map<String, Object> r107 = r100.getParams();
        String r113 = r100.getUrl();
        if (TextUtils.isEmpty(r113) == false) goto L14;
        f3.h.a.a(r210, "url is empty", null, null, 14);
        return;
    L14:
        BuildersKt.launch$default(f35626c, null, null, new AnonymousClass1(r105, this, r113, r107, r104, r100, r110, r210, r106, r112, null), 3, null);
        return;
    L16:
        r103 = AbsAppletRequestMethodIDL.RequestMethodType.valueOf(r102.toUpperCase());     // Catch: Exception -> L6
    L6:
        r103 = AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED;
        goto L8
    }
}
