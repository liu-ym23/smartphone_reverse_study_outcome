package com.bytedance.ai.bridge.method.net;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ai.applet.domain.AppletDomainPolicyManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.network.AbsRequestMethodIDL;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.client.Request;
import com.lynx.tasm.LynxError;
import com.xiaomi.mipush.sdk.Constants;
import d3.a0;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001$\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014H\u0002J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010 \u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001b\u0010#\u001a\u00020$2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0002\u0010,¨\u0006."}, d2 = {"Lcom/bytedance/ai/bridge/method/net/RequestMethod;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestResultModel;", "appendGetDataToUrl", "", "url", "rawData", "", "toGetQueryString", "data", "", "Lorg/json/JSONObject;", "getQueryValueString", "value", "appendQueryString", "queryString", "normalizeRequestData", "contentType", "containsCustomizedCookie", "", "headers", "toJsonString", "toQueryString", "encodeURIComponent", "maskUrl", "createResponseCallback", "com/bytedance/ai/bridge/method/net/RequestMethod$createResponseCallback$1", "(Lcom/bytedance/ai/bridge/core/CompletionBlock;)Lcom/bytedance/ai/bridge/method/net/RequestMethod$createResponseCallback$1;", "mapRequestErrNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "errorCode", "", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/Integer;Ljava/lang/Throwable;)Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestMethod extends AbsRequestMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35629b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.RequestMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.RequestMethod$handle$1", f = "RequestMethod.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsRequestMethodIDL.b> $callback;
        final /* synthetic */ AbsAppletRequestMethodIDL.RequestMethodType $method;
        final /* synthetic */ AbsRequestMethodIDL.a $params;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ RequestMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.RequestMethod$handle$1$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f35630a = null;

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
                f35630a = r100;
            }
        }

        public AnonymousClass1(String r100, String r101, f3.h<AbsRequestMethodIDL.b> r102, AbsRequestMethodIDL.a r103, RequestMethod r104, AbsAppletRequestMethodIDL.RequestMethodType r105, Continuation<? super AnonymousClass1> r106) {
            this.$appletId = r100;
            this.$url = r101;
            this.$callback = r102;
            this.$params = r103;
            this.this$0 = r104;
            this.$method = r105;
            super(2, r106);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
            return new AnonymousClass1(this.$appletId, this.$url, this.$callback, this.$params, this.this$0, this.$method, r110);
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
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            boolean r102 = true;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r210);
            Object r103 = r210;
        L11:
            com.bytedance.ai.applet.domain.e r104 = (com.bytedance.ai.applet.domain.e) r103;
            if (r104.f34612a == true) goto L15;
            com.bytedance.ai.utils.g r105 = com.bytedance.ai.utils.g.f37637a;
            StringBuilder r106 = new StringBuilder("call failed, errNo=");
            f3.a r107 = f3.a.f475271l;
            r106.append(r107.f475285a);
            r106.append(", msg=");
            r106.append(r104.f34613b);
            r105.e("AISDK_JSB_RequestMethod", r106.toString());
            f3.h.a.a(this.$callback, r104.f34613b, r107, null, 10);
            return Unit.INSTANCE;
        L15:
            b4.e r108 = b4.e.f17441a;
            Map<String, Object> r109 = this.$params.getHeader();
            r108.getClass();
            Map r110 = b4.e.c(r109);
            r110.put(Request.KEY_BYPASS_TTNET_FEATURES, "1");
            if (r110.containsKey("Content-Type") == false) goto L18;
        L20:
            IHostNetworkDepend r111 = r4.a.f535976c;
            if (r111 != null) goto L23;
            r111 = new b4.a();
        L23:
            RequestMethod r112 = this.this$0;
            f3.h<AbsRequestMethodIDL.b> r113 = this.$callback;
            int r114 = RequestMethod.f35629b;
            r112.getClass();
            j r115 = new j(r113, r112);
            LinkedHashMap r116 = (LinkedHashMap) r110;
            String r117 = (String) r116.get("Content-Type");
            if (r117 != null) goto L28;
            r117 = (String) r116.get(com.alipay.sdk.m.p.e.f25658f);
            if (r117 != null) goto L28;
            r117 = "application/json";
        L28:
            final RequestMethod r118 = this.this$0;
            Object r119 = this.$params.getData();
            r118.getClass();
            if (r119 != null) goto L32;
            r119 = null;
        L79:
            this.this$0.getClass();
            if (r110.isEmpty() == true) goto L93;
            Iterator r120 = r116.entrySet().iterator();
        L84:
            if (r120.hasNext() == false) goto L93;
            Map.Entry r121 = (Map.Entry) r120.next();
            String r122 = (String) r121.getKey();
            String r123 = (String) r121.getValue();
            if (StringsKt.equals(r122, BaseHttpRequestInfo.KEY_COOKIE, true) == true) goto L88;
        L90:
            boolean r124 = false;
        L91:
            if (r124 == false) goto L84;
            boolean r125 = true;
        L94:
            int r126 = a.f35630a[this.$method.ordinal()];
            if (r126 == 1) goto L105;
            if (r126 != 2) goto L98;
            b4.e.f(b4.e.f17441a, this.$url, r110, r117, r119, r115, this.$params.getDataType(), r111, false, r125);
        L152:
            return Unit.INSTANCE;
        L98:
            if (r126 != 3) goto L100;
            b4.e.g(b4.e.f17441a, this.$url, r110, r117, r119, r115, this.$params.getDataType(), r111, false, r125);
            goto L152
        L100:
            if (r126 != 4) goto L152;
            b4.e r127 = b4.e.f17441a;
            String r128 = this.$url;
            RequestMethod r129 = this.this$0;
            f3.h<AbsRequestMethodIDL.b> r130 = this.$callback;
            r129.getClass();
            b4.e.b(r127, r128, r110, new j(r130, r129), this.$params.getDataType(), r111, false, r125);
            goto L152
        L105:
            final RequestMethod r131 = this.this$0;
            String r132 = this.$url;
            Object r133 = this.$params.getData();
            r131.getClass();
            if (r133 != null) goto L108;
        L149:
            String r134 = r132;
        L150:
            b4.e.d(b4.e.f17441a, r134, r110, r115, this.$params.getDataType(), r111, false, r125);
            goto L152
        L108:
            if ((r133 instanceof byte[]) == true) goto L149;
            if ((r133 instanceof Map) == false) goto L120;
            ArrayList r135 = new ArrayList();
            Iterator r136 = ((Map) r133).entrySet().iterator();
        L114:
            if (r136.hasNext() == false) goto L118;
            Map.Entry r137 = (Map.Entry) r136.next();
            Object r138 = r137.getKey();
            Object r139 = r137.getValue();
            if (r138 == null) goto L114;
            r135.add(TuplesKt.to(r138.toString(), RequestMethod.c(r139)));
            goto L114
        L118:
            String r140 = CollectionsKt.joinToString$default(r135, "&", null, null, 0, null, new h(r131), 30, null);
        L126:
            String r141 = StringsKt.trim(r140).toString();
        L127:
            String r142 = "?";
            if (StringsKt.startsWith$default(r141, "?", false, 2, null) == true) goto L148;
            if (StringsKt.startsWith$default(r141, "&", false, 2, null) == true) goto L148;
            if (r141.length() == 0) goto L136;
            r102 = false;
        L136:
            if (r102 == true) goto L149;
            if (StringsKt.endsWith$default(r132, "?", false, 2, null) == false) goto L141;
        L146:
            r142 = "";
        L147:
            r134 = r132 + r142 + r141;
            goto L150
        L141:
            if (StringsKt.endsWith$default(r132, "&", false, 2, null) == true) goto L146;
            if (StringsKt.contains$default(r132, "?", false, 2, null) == false) goto L147;
            r142 = "&";
        L148:
            r141 = StringsKt.drop(r141, 1);
            goto L127
        L120:
            if ((r133 instanceof JSONObject) == false) goto L149;
            JSONObject r143 = (JSONObject) r133;
            ArrayList r144 = new ArrayList();
            Iterator<String> r145 = r143.keys();
        L123:
            if (r145.hasNext() == false) goto L125;
            String r146 = r145.next();
            r144.add(TuplesKt.to(r146, RequestMethod.c(r143.opt(r146))));
            goto L123
        L125:
            r140 = CollectionsKt.joinToString$default(r144, "&", null, null, 0, null, new i(r131), 30, null);
            goto L126
        L88:
            if ((!StringsKt.isBlank(r123)) == false) goto L90;
            r124 = true;
        L93:
            r125 = false;
            goto L94
        L32:
            if ((r119 instanceof String) == true) goto L79;
            if ((r119 instanceof byte[]) == true) goto L79;
            String r147 = StringsKt.trim(StringsKt.substringBefore$default(r117, com.alipay.sdk.m.u.i.f25853b, null, 2, null)).toString().toLowerCase(Locale.ROOT);
            if (Intrinsics.areEqual(r147, "application/x-www-form-urlencoded") == false) goto L65;
            ArrayList r148 = new ArrayList();
            if ((r119 instanceof Map) == false) goto L52;
            Iterator r149 = ((Map) r119).entrySet().iterator();
        L42:
            if (r149.hasNext() == false) goto L62;
            Map.Entry r150 = (Map.Entry) r149.next();
            Object r151 = r150.getKey();
            Object r152 = r150.getValue();
            if (r151 == null) goto L42;
            String r153 = r151.toString();
            if (r152 == null) goto L49;
            String r154 = r152.toString();
            if (r154 == null) goto L49;
        L50:
            r148.add(TuplesKt.to(r153, r154));
        L49:
            r154 = "null";
        L62:
            String r155 = CollectionsKt.joinToString$default(r148, "&", null, null, 0, null, new g(r118), 30, null);
        L78:
            r119 = r155;
            goto L79
        L52:
            if ((r119 instanceof JSONObject) == false) goto L63;
            JSONObject r156 = (JSONObject) r119;
            Iterator<String> r157 = r156.keys();
        L55:
            if (r157.hasNext() == false) goto L62;
            String r158 = r157.next();
            Object r159 = r156.opt(r158);
            if (r159 == null) goto L60;
            String r160 = r159.toString();
            if (r160 == null) goto L60;
        L61:
            r148.add(TuplesKt.to(r158, r160));
        L60:
            r160 = "null";
            goto L61
        L63:
            r155 = r119.toString();
            goto L78
        L65:
            if (Intrinsics.areEqual(r147, "application/json") == false) goto L68;
            r155 = RequestMethod.d(r119);
            goto L78
        L68:
            if ((r119 instanceof Map) == false) goto L70;
        L77:
            r155 = RequestMethod.d(r119);
            goto L78
        L70:
            if ((r119 instanceof JSONObject) == true) goto L77;
            if ((r119 instanceof List) == true) goto L77;
            if ((r119 instanceof JSONArray) == true) goto L77;
            r155 = r119.toString();
            goto L78
        L18:
            if (r110.containsKey(com.alipay.sdk.m.p.e.f25658f) == true) goto L20;
            r110.put("Content-Type", "application/json");
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            AppletDomainPolicyManager r161 = AppletDomainPolicyManager.f34590a;
            String r162 = this.$appletId;
            String r163 = this.$url;
            this.label = 1;
            r103 = r161.d(r162, r163, this);
            if (r103 != r100) goto L11;
            return r100;
        }
    }

    static {
    }

    public RequestMethod() {
    }

    public static String b(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(URLEncoder.encode(r110, StandardCharsets.UTF_8.name()), Marker.ANY_NON_NULL_MARKER, "%20", false, 4, null), "%21", "!", false, 4, null), "%27", "'", false, 4, null), "%28", "(", false, 4, null), "%29", ")", false, 4, null), "%7E", Constants.WAVE_SEPARATOR, false, 4, null);
    }

    public static String c(Object r100) {
        if (r100 != null) goto L4;
        return "null";
    L4:
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L7;
        return "null";
    L7:
        if ((r100 instanceof String) == false) goto L10;
        return (String) r100;
    L10:
        if ((r100 instanceof Number) == true) goto L31;
        if ((r100 instanceof Boolean) == true) goto L31;
        if ((r100 instanceof JSONObject) == false) goto L18;
        return ((JSONObject) r100).toString();
    L18:
        if ((r100 instanceof JSONArray) == false) goto L21;
        return ((JSONArray) r100).toString();
    L21:
        if ((r100 instanceof Map) == false) goto L24;
        return new JSONObject((Map) r100).toString();
    L24:
        if ((r100 instanceof List) == false) goto L27;
        return new JSONArray((Collection) r100).toString();
    L27:
        if ((r100 instanceof Object[]) == false) goto L40;
        return new JSONArray(ArraysKt.toList((Object[]) r100)).toString();
    L40:
        return r100.toString();
    L31:
        return r100.toString();
    }

    public static String d(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L6;
        return ((JSONObject) r100).toString();
    L6:
        if ((r100 instanceof JSONArray) == false) goto L9;
        return ((JSONArray) r100).toString();
    L9:
        if ((r100 instanceof Map) == false) goto L12;
        return new JSONObject((Map) r100).toString();
    L12:
        if ((r100 instanceof List) == false) goto L15;
        return new JSONArray((Collection) r100).toString();
    L15:
        return r100.toString();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, f3.h r112) {
        AbsRequestMethodIDL.a r100 = (AbsRequestMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r101 = r100.getUrl();
        com.bytedance.ai.utils.g r102 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r103 = new StringBuilder("call start, url=");
        Object r104 = "invalid_url";
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
        Uri r106 = UriProtector.parse(r101);     // Catch: Throwable -> L15
        String r107 = r106.getScheme();     // Catch: Throwable -> L15
        if (r107 == null) goto L8;
        String r108 = r106.getHost();     // Catch: Throwable -> L15
        if (r108 == null) goto L8;
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L15
        r113.append(r107);     // Catch: Throwable -> L15
        r113.append("://");     // Catch: Throwable -> L15
        r113.append(r108);     // Catch: Throwable -> L15
        String r109 = r106.getPath();     // Catch: Throwable -> L15
        if (r109 != null) goto L12;
        r109 = "";
    L12:
        r113.append(r109);     // Catch: Throwable -> L15
        String r114 = r113.toString();     // Catch: Throwable -> L15
    L13:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r115) == true) goto L21;
        r104 = r115;
    L21:
        r103.append((String) r104);
        r103.append(", method=");
        String r116 = r100.getMethod();
        if (r116 != null) goto L24;
        r116 = "unknown";
    L24:
        r103.append(r116);
        r102.i("AISDK_JSB_RequestMethod", r103.toString());
        if (TextUtils.isEmpty(r101) == false) goto L27;
        com.bytedance.ai.utils.g r117 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r118 = new StringBuilder("call failed, errNo=");
        f3.a r119 = f3.a.f475267h;
        r118.append(r119.f475285a);
        r118.append(", msg=url is empty");
        r117.e("AISDK_JSB_RequestMethod", r118.toString());
        f3.h.a.a(r112, "url is empty", r119, null, 10);
        return;
    L27:
        AbsAppletRequestMethodIDL.RequestMethodType.a r120 = AbsAppletRequestMethodIDL.RequestMethodType.Companion;
        String r121 = r100.getMethod();
        if (r121 != null) goto L30;
        r121 = "GET";
    L30:
        r120.getClass();
        AbsAppletRequestMethodIDL.RequestMethodType r122 = AbsAppletRequestMethodIDL.RequestMethodType.valueOf(r121.toUpperCase());     // Catch: Exception -> L33
    L35:
        if (r122 != AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED) goto L37;
        String r123 = "Illegal method " + r100.getMethod();
        com.bytedance.ai.utils.g r124 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r125 = new StringBuilder("call failed, errNo=");
        f3.a r126 = f3.a.f475267h;
        r125.append(r126.f475285a);
        r125.append(", msg=");
        r125.append(r123);
        r124.e("AISDK_JSB_RequestMethod", r125.toString());
        f3.h.a.a(r112, r123, r126, null, 10);
        return;
    L37:
        a0 r127 = r110.getContainerContext();
        if (r127 == null) goto L40;
        String r128 = r127.getAppletId();
    L41:
        BuildersKt.launch$default(AppletRequestMethod.f35626c, null, null, new AnonymousClass1(r128, r101, r112, r100, this, r122, null), 3, null);
        return;
    L40:
        r128 = null;
    L33:
        r122 = AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED;
    L8:
        r114 = "invalid_url";
    L15:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
