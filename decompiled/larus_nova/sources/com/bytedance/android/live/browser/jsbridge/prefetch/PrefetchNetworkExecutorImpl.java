package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufMessageDefinitions;
import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs;
import com.bytedance.android.livesdk.config.b4;
import com.bytedance.android.livesdk.config.c4;
import com.bytedance.android.livesdk.config.fj0;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.ies.tools.prefetch.ProcessManager;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class PrefetchNetworkExecutorImpl implements com.bytedance.ies.tools.prefetch.i {

    public static abstract class MultiFormatResponse extends com.bytedance.ies.tools.prefetch.i.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Lazy f63777g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final JSONObject f63778h;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/prefetch/PrefetchNetworkExecutorImpl$MultiFormatResponse$Format;", "", "JSON", "Protobuf", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Format extends Enum<Format> {
            public static final Format JSON = null;
            public static final Format Protobuf = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Format[] f63779a = null;

            static {
                Format r100 = new Format("JSON", 0);
                JSON = r100;
                Format r101 = new Format("Protobuf", 1);
                Protobuf = r101;
                f63779a = new Format[]{r100, r101};
            }

            public static Format valueOf(String r100) {
                return (Format) r27.a.a(Format.class, r100);
            }

            public static Format[] values() {
                return (Format[]) f63779a.clone();
            }

            public Format(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class a extends MultiFormatResponse {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final Format f63780i;

            @Override // com.bytedance.android.live.browser.jsbridge.prefetch.PrefetchNetworkExecutorImpl.MultiFormatResponse
            public final Format c() {
                return this.f63780i;
            }

            public a(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
                super(r100);
                this.f63780i = Format.JSON;
            }
        }

        public static final class b extends MultiFormatResponse {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final Format f63781i;

            @Override // com.bytedance.android.live.browser.jsbridge.prefetch.PrefetchNetworkExecutorImpl.MultiFormatResponse
            public final Format c() {
                return this.f63781i;
            }

            public b(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
                super(r100);
                this.f63781i = Format.Protobuf;
            }
        }

        public abstract Format c();

        public final String toString() {
            return "PrefetchResponse: { format: " + c() + ", status_code: " + this.f248823d + ", data: " + this.f63778h + ", cached: " + this.f248825f + " }";
        }

        public MultiFormatResponse(JSONObject r100) {
            this.f63778h = r100;
            this.f63777g = LazyKt.lazy(new PrefetchNetworkExecutorImpl$MultiFormatResponse$decoded$2(this));
        }
    }

    public PrefetchNetworkExecutorImpl() {
    }

    public static final LinkedList d(PrefetchNetworkExecutorImpl r100, Map r101) {
        r100.getClass();
        LinkedList r102 = new LinkedList();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.add(new NameValuePair((String) r104.getKey(), (String) r104.getValue()));
        goto L4
    L6:
        return r102;
    }

    public static final Map c(PrefetchNetworkExecutorImpl r100, Map r101, Map r102, boolean r103) {
        r100.getClass();
        if (r103 == false) goto L5;
        return r101;
    L5:
        if (r102 == null) goto L7;
        String r104 = (String) r102.get("response-format");
    L9:
        if (Intrinsics.areEqual(r104, "protobuf") == true) goto L11;
        return r101;
    L11:
        if (b4.f119841a.getValue().booleanValue() == true) goto L13;
        return r101;
    L13:
        return MapsKt.plus(r101, TuplesKt.to("response-format", "protobuf"));
    L7:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.ies.tools.prefetch.i
    public final void a(String r100, Map r101, Map r102, ProcessManager.b r110) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        Map r103 = r102;
        int r104 = com.bytedance.android.live.browser.jsbridge.protobuf.a.f63850c;
        String r105 = (String) r103.get("channel");
        ExternalProtobufMessageDefinitions.Companion r106 = ExternalProtobufMessageDefinitions.f63828b;
        com.bytedance.android.live.browser.jsbridge.protobuf.a r107 = null;
        if (r105 == null) goto L8;
        Object r108 = r106.f63824a.get(r105);
    L9:
        ExternalProtobufShrinkConfigs.Companion r109 = ExternalProtobufShrinkConfigs.f63838b;
        if (r105 == null) goto L12;
        Object r111 = r109.f63824a.get(r105);
    L13:
        if (r108 == null) goto L16;
        if (r111 == null) goto L16;
        r107 = new com.bytedance.android.live.browser.jsbridge.protobuf.a((ExternalProtobufMessageDefinitions) r108, (ExternalProtobufShrinkConfigs) r111);
    L16:
        Observable r112 = Observable.fromCallable(new k(this, r100, r101, r103, r107)).subscribeOn(Schedulers.io());
        if (fj0.f120208a.getValue().booleanValue() == true) goto L20;
        r112 = r112.observeOn(AndroidSchedulers.mainThread());
    L20:
        r112.subscribe(new l(r110), new m(r110));
        return;
    L12:
        r109.getClass();
        r111 = null;
        goto L13
    L8:
        r106.getClass();
        r108 = null;
        goto L9
    }

    public static final MultiFormatResponse e(PrefetchNetworkExecutorImpl r110, HttpResponse r111, String r112, Map r113, com.bytedance.android.live.browser.jsbridge.protobuf.a r210) {
        r110.getClass();
        List<NameValuePair> r100 = r111.getHeaders();
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L26;
        NameValuePair r102 = (NameValuePair) r101.next();
        String r103 = r102.getName();
        Locale r104 = Locale.getDefault();
        if (r103 == null) goto L25;
        if (Intrinsics.areEqual(r103.toLowerCase(r104), com.alipay.sdk.m.p.e.f25658f) == false) goto L21;
        String r105 = r102.getValue();
        Locale r106 = Locale.getDefault();
        if (r105 == null) goto L20;
        if (Intrinsics.areEqual(r105.toLowerCase(r106), "application/x-protobuf") == false) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L9;
        boolean r108 = true;
    L27:
        if (r108 == false) goto L99;
        Object r109 = r113.get("data_message_name");
        if (r109 == null) goto L98;
        String r114 = (String) r109;
        String r115 = (String) r113.get("extra_message_name");
        c4 r116 = c4.f119920a;
        if (r116.getValue().booleanValue() == false) goto L33;
        String r117 = (String) r113.get("data_shrink_config");
    L35:
        if (r116.getValue().booleanValue() == false) goto L37;
        String r118 = (String) r113.get("extra_shrink_config");
    L38:
        if (r210 == null) goto L96;
        byte[] r119 = r111.getBody();
        Intrinsics.checkNotNullParameter(r119, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r114, "dataMessageName");
        JSONObject r120 = new JSONObject();
        am3.g r121 = new am3.g();
        r121.k(new am3.b(r119));
        ho0.b r122 = ho0.b.a(r121);
        r120.put("status_code", r122.header.f486203a);
        if (r122.header.f486203a != 0) goto L77;
        ExternalProtobufMessageDefinitions.Message r123 = r210.f63851a.a(r114);
        if (r123 == null) goto L76;
        JSONObject r124 = new JSONObject();
        r124.put(TriggerTiming.NOW, r122.header.f486207e);
        r120.put("extra", r124);
        byte[] r125 = r122.body;
        if (r125 == null) goto L94;
        r121.k(new am3.b(r125));
        long r126 = r121.c();
    L46:
        int r127 = r121.f();
        if (r127 == (-1)) goto L48;
        if (r127 != 1) goto L52;
        ExternalProtobufShrinkConfigs r128 = r210.f63852b;
        if (r117 == null) goto L70;
        ExternalProtobufShrinkConfigs.Config r129 = (ExternalProtobufShrinkConfigs.Config) ((LinkedHashMap) r128.f63839a).get(r117);
    L71:
        r120.put("data", r210.b(r123, r121, r129));
    L72:
        boolean r130 = true;
    L73:
        if (r130 == true) goto L46;
        am3.h.e(r121);
        goto L46
    L70:
        r128.getClass();
        r129 = null;
        goto L71
    L52:
        if (r127 != 2) goto L66;
        if (r115 == null) goto L56;
        ExternalProtobufMessageDefinitions.Message r131 = r210.f63851a.a(r115);
    L57:
        if (r131 == null) goto L66;
        ExternalProtobufShrinkConfigs r132 = r210.f63852b;
        if (r118 == null) goto L61;
        ExternalProtobufShrinkConfigs.Config r133 = (ExternalProtobufShrinkConfigs.Config) ((LinkedHashMap) r132.f63839a).get(r118);
    L62:
        JSONObject r134 = r210.b(r131, r121, r133);
        Iterator<String> r135 = r134.keys();
    L64:
        if (r135.hasNext() == false) goto L72;
        String r136 = r135.next();
        r124.put(r136, r134.get(r136));
        goto L64
    L61:
        r132.getClass();
        r133 = null;
        goto L62
    L56:
        r131 = null;
    L66:
        r130 = false;
        goto L73
    L48:
        r121.d(r126);
    L94:
        MultiFormatResponse r137 = new MultiFormatResponse.b(r120);
    L100:
        r137.f248820a = r111.getBody();
        r137.f248823d = r111.getStatusCode();
        return r137;
    L76:
        throw new IllegalArgumentException(("data message [" + r114 + "] definition not found").toString());
    L77:
        JSONObject r138 = new JSONObject();
        r138.put("message", r122.header.f486204b);
        r138.put("prompts", r122.header.f486205c);
        r138.put("alert", r122.header.f486206d);
        Unit r139 = Unit.INSTANCE;
        r120.put("data", r138);
        JSONObject r140 = new JSONObject();
        r140.put(TriggerTiming.NOW, r122.header.f486207e);
        r120.put("extra", r140);
        if (r115 == null) goto L80;
        ExternalProtobufMessageDefinitions.Message r141 = r210.f63851a.a(r115);
    L81:
        String r142 = r122.header.f486208f;
        if (r141 == null) goto L94;
        if (r142 != null) goto L85;
    L88:
        boolean r143 = true;
    L89:
        if (r143 == true) goto L94;
        JSONObject r144 = new JSONObject(r142);
        Iterator<String> r145 = r144.keys();
    L92:
        if (r145.hasNext() == false) goto L94;
        String r146 = r145.next();
        r140.put(r146, r144.get(r146));
        goto L92
    L85:
        if (r142.length() == 0) goto L88;
        r143 = false;
        goto L89
    L80:
        r141 = null;
        goto L81
    L96:
        throw new IllegalArgumentException("Decoder shouldn't be null".toString());
    L37:
        r118 = null;
        goto L38
    L33:
        r117 = null;
        goto L35
    L98:
        throw new IllegalArgumentException(("[data_message_name] is required for pb prefetch. please complete prefetch config. url: " + r112).toString());
    L99:
        r137 = new MultiFormatResponse.a(new JSONObject(new String(r111.getBody(), Charsets.UTF_8)));
        goto L100
    L20:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        r107 = false;
        goto L22
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L26:
        r108 = false;
        goto L27
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.bytedance.ies.tools.prefetch.i
    public final void b(String r100, Map r101, String r110, JSONObject r111, Map r112, ProcessManager.b r113) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r110, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r111, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r113, "callback");
        if (r112 != null) goto L5;
        r112 = MapsKt.emptyMap();
    L5:
        Map r102 = r112;
        int r114 = com.bytedance.android.live.browser.jsbridge.protobuf.a.f63850c;
        String r115 = (String) r102.get("channel");
        ExternalProtobufMessageDefinitions.Companion r116 = ExternalProtobufMessageDefinitions.f63828b;
        com.bytedance.android.live.browser.jsbridge.protobuf.a r103 = null;
        if (r115 == null) goto L8;
        Object r117 = r116.f63824a.get(r115);
    L9:
        ExternalProtobufShrinkConfigs.Companion r104 = ExternalProtobufShrinkConfigs.f63838b;
        if (r115 == null) goto L12;
        Object r118 = r104.f63824a.get(r115);
    L13:
        if (r117 == null) goto L16;
        if (r118 == null) goto L16;
        r103 = new com.bytedance.android.live.browser.jsbridge.protobuf.a((ExternalProtobufMessageDefinitions) r117, (ExternalProtobufShrinkConfigs) r118);
    L16:
        Observable r105 = Observable.fromCallable(new n(this, r100, r101, r102, r103, r111)).subscribeOn(Schedulers.io());
        if (fj0.f120208a.getValue().booleanValue() == true) goto L20;
        r105 = r105.observeOn(AndroidSchedulers.mainThread());
    L20:
        r105.subscribe(new o(r113), new p(r113));
        return;
    L12:
        r104.getClass();
        r118 = null;
        goto L13
    L8:
        r116.getClass();
        r117 = null;
        goto L9
    }
}
