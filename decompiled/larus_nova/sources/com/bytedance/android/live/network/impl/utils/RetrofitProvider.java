package com.bytedance.android.live.network.impl.utils;

import am2.v;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.network.MonitorTimeCostCallAdapterFactory;
import com.bytedance.android.live.network.MonitorTimeCostCallAdapterFactoryV2;
import com.bytedance.android.live.network.MonitorTimeCostRequestConverterFactory;
import com.bytedance.android.live.network.NetworkSettingKeys;
import com.bytedance.android.live.network.PbAnnotationCallAdapterFactory;
import com.bytedance.android.live.network.PbAnnotationCallAdapterFactoryV2;
import com.bytedance.android.live.network.PbRequestCallAdapter;
import com.bytedance.android.live.network.PbRequestCallAdapterV2;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.impl.factory.MultiTypeRequestConverterFactory;
import com.bytedance.android.live.network.impl.interceptor.FuseRequestAdaptorInterceptor;
import com.bytedance.android.live.network.impl.interceptor.p;
import com.bytedance.android.live.network.impl.interceptor.r;
import com.bytedance.android.live.network.impl.interceptor.w;
import com.bytedance.android.live.network.impl.interceptor.y;
import com.bytedance.android.live.network.impl.interceptor.z;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.a21;
import com.bytedance.android.livesdk.config.ge;
import com.bytedance.android.livesdk.config.mc0;
import com.bytedance.android.livesdk.config.n71;
import com.bytedance.android.livesdk.config.pc0;
import com.bytedance.android.livesdk.config.z11;
import com.bytedance.android.livesdk.config.z7;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.android.livesdkapi.network.ILiveRetrofitWrapper;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.rxjava2.adapter.RxJava2CallAdapterFactory;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class RetrofitProvider implements com.bytedance.android.live.a {
    private static final String TAG = "RetrofitProvider";

    public class a extends com.bytedance.android.live.network.impl.utils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LiveCall f83917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Request f83918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IHostNetwork f83919c;

        /* JADX INFO: renamed from: com.bytedance.android.live.network.impl.utils.RetrofitProvider$a$a, reason: collision with other inner class name */
        public class C1273a implements TypedInput {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HttpResponse f83920a;

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public final InputStream in() throws IOException {
                InputStream r100 = this.f83920a.getStream();
                if (r100 == null) goto L5;
                return r100;
            L5:
                byte[] r101 = this.f83920a.getBody();
                if (r101 != null) goto L10;
                return null;
            L10:
                return new ByteArrayInputStream(r101);
            }

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public final long length() throws IOException {
                InputStream r100 = this.f83920a.getStream();
                if (r100 != null) goto L5;
                byte[] r101 = this.f83920a.getBody();
                if (r101 != null) goto L10;
                return 0;
            L10:
                return r101.length;
            L5:
                return r100.available();
            }

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public final String mimeType() {
                return this.f83920a.getMimeType();
            }

            public C1273a(HttpResponse r100) {
                this.f83920a = r100;
            }
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final void cancel() {
            LiveCall r100 = this.f83917a;
            if (r100 == null) goto L11;
            r100.cancel();     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final Response execute() throws IOException {
            long r100 = System.currentTimeMillis();
            String r101 = this.f83918b.getMethod();
            a21 r102 = null;
            boolean r103 = true;
            if ("GET".equals(r101) == false) goto L5;
        L8:
            Request r104 = this.f83918b;
            MonitorTimeCostCallAdapterFactory.f83773c.getClass();
            Intrinsics.checkNotNullParameter(r104, "request");
            String r105 = (String) ((ConcurrentHashMap) MonitorTimeCostCallAdapterFactory.f83772b).remove(MonitorTimeCostCallAdapterFactory.b.a(r104));
            if (r105 != null) goto L11;
        L13:
            boolean r106 = false;
        L14:
            ArrayList r110 = new ArrayList();
            List<Header> r111 = this.f83918b.getHeaders();
            if (r111 == null) goto L26;
            Iterator<Header> r112 = r111.iterator();
        L18:
            if (r112.hasNext() == false) goto L26;
            Header r113 = r112.next();
            if (NetworkSettingKeys.ENABLE_PB_REQUESTS.getValue().booleanValue() == false) goto L23;
            if (r106 == true) goto L23;
        L25:
            r110.add(new NameValuePair(r113.getName(), r113.getValue()));
        L23:
            if (TextUtils.equals(r113.getName(), "response-format") == false) goto L25;
        L26:
            r110.add(new NameValuePair("W-Ab-Cut-Group", String.valueOf(NetworkSettingKeys.LIVE_NETWORK_AB_CUT_GROUP.getValue())));
            HashMap r107 = new HashMap();
            if (bo0.a.a() == false) goto L70;
            String r114 = this.f83918b.getPath();
            if (r114.endsWith(HTTP.URL_DEFAULT) == false) goto L31;
            r114 = r114.substring(0, r114.length() - 1);
        L31:
            Intrinsics.checkNotNullParameter(r114, "path");
            z11 r115 = bo0.a.f19789b;
            Map<String, a21> r116 = r115.a();
            if (r116 != null) goto L34;
        L37:
            if (r103 == true) goto L43;
            Map<String, a21> r108 = r115.a();
            if (r108 == null) goto L43;
            r102 = r108.get(r114);
        L43:
            if (TextUtils.equals("GET", r101) == false) goto L54;
            if (r102 == null) goto L53;
            r107.put("path", this.f83918b.getPath());
            if (r102.b() == false) goto L52;
            r107.put("meet_uplink", "1");
            com.ss.ugc.live.sdk.platform.a.f458524f.getClass();
            if (r102.a() == true) goto L51;
            r107.put("actual_channel", "1");
            goto L53
        L51:
            throw new IOException("byte link only!");
        L52:
            r107.put("meet_uplink", "0");
        L53:
            this.f83917a = this.f83919c.get(this.f83918b.getUrl(), r110);
            Object r109 = "1";
            Object r117 = "0";
        L80:
            long r118 = System.currentTimeMillis();
            bo0.a.a();
            HttpResponse r119 = (HttpResponse) this.f83917a.execute();
            if (bo0.a.a() == true) goto L83;
        L89:
            if (r105 == null) goto L91;
            long r120 = System.currentTimeMillis() - r118;
            HashMap r121 = new HashMap(4);
            r121.put("scene", r105);
            r121.put("duration", String.valueOf(r120));
            u.l().sendLog("network_request_receiving_time_cost", r121, new Object[0]);
        L91:
            ArrayList r122 = new ArrayList();
            if (r119.getHeaders() == null) goto L103;
            Iterator<NameValuePair> r123 = r119.getHeaders().iterator();
            long r124 = 0;
            long r125 = 0;
        L95:
            if (r123.hasNext() == false) goto L105;
            NameValuePair r126 = r123.next();
            r122.add(new Header(r126.getName(), r126.getValue()));
            if ("Webcast-Ntp-T2".equalsIgnoreCase(r126.getName()) == false) goto L100;
            r125 = d.a(r126.getValue());
            goto L95
        L100:
            if ("Webcast-Ntp-T3".equalsIgnoreCase(r126.getName()) == false) goto L95;
            r124 = d.a(r126.getValue());
        L105:
            if (r125 <= 0) goto L110;
            if (r124 <= 0) goto L110;
            int r127 = com.bytedance.android.livesdk.utils.ntp.a.f159088b;
            long r128 = r125 - r118;
            long r129 = 2;
            com.bytedance.android.livesdk.utils.ntp.a.f159087a = (r128 - (System.currentTimeMillis() - r124)) / r129;
            long r130 = System.currentTimeMillis();
            int r131 = com.ss.ugc.live.sdk.msg.utils.f.f458476b;
            com.ss.ugc.live.sdk.msg.utils.f.f458475a = (r128 - (r130 - r124)) / r129;
        L110:
            if (this.f83918b.isResponseStreaming() == false) goto L112;
            TypedInput r132 = new C1273a(r119);
        L113:
            Response r133 = new Response(r119.getUrl(), r119.getStatusCode(), r119.getReason(), r122, r132);
            r133.setExtraInfo(r119.getExtraInfo());
            return r133;
        L112:
            r132 = new TypedByteArray(r119.getMimeType(), r119.getBody(), new String[0]);
            goto L113
        L103:
            r124 = 0;
            r125 = 0;
            goto L105
        L83:
            if (r107.isEmpty() == true) goto L89;
            if (r119.getStatusCode() != 200) goto L87;
            Object r134 = r109;
        L88:
            r107.put("success", r134);
            r107.put("duration", String.valueOf(System.currentTimeMillis() - r100));
            u.l().sendLog("livesdk_api_uplink_agent_quality", r107, new Object[0]);
            goto L89
        L87:
            r134 = r117;
            goto L88
        L54:
            if (r102 == null) goto L63;
            r107.put("path", this.f83918b.getPath());
            if (r102.b() == false) goto L62;
            r107.put("meet_uplink", "1");
            com.ss.ugc.live.sdk.platform.a.f458524f.getClass();
            if (r102.a() == true) goto L61;
            r107.put("actual_channel", "1");
            goto L63
        L61:
            throw new IOException("byte link only!");
        L62:
            r107.put("meet_uplink", "0");
        L63:
            ByteArrayOutputStream r135 = new ByteArrayOutputStream();
            if (this.f83918b.getBody() == null) goto L67;
            this.f83918b.getBody().writeTo(r135);
        L67:
            if ((this.f83918b.getBody() instanceof MultipartTypedOutput) == false) goto L69;
            r109 = "1";
            r117 = "0";
            this.f83917a = this.f83919c.uploadFile(this.f83918b.getMaxLength(), this.f83918b.getUrl(), r110, this.f83918b.getBody().mimeType(), r135.toByteArray(), this.f83918b.getBody().length(), this.f83918b.getBody().md5Stub());
            goto L80
        L69:
            r109 = "1";
            r117 = "0";
            this.f83917a = this.f83919c.post(this.f83918b.getUrl(), r110, this.f83918b.getBody().mimeType(), r135.toByteArray());
            goto L80
        L34:
            if (r116.isEmpty() == true) goto L37;
            r103 = false;
            goto L37
        L70:
            r109 = "1";
            r117 = "0";
            if (TextUtils.equals("GET", r101) == false) goto L73;
            this.f83917a = this.f83919c.get(this.f83918b.getUrl(), r110);
            goto L80
        L73:
            ByteArrayOutputStream r136 = new ByteArrayOutputStream();
            if (this.f83918b.getBody() == null) goto L77;
            this.f83918b.getBody().writeTo(r136);
        L77:
            if ((this.f83918b.getBody() instanceof MultipartTypedOutput) == false) goto L79;
            this.f83917a = this.f83919c.uploadFile(this.f83918b.getMaxLength(), this.f83918b.getUrl(), r110, this.f83918b.getBody().mimeType(), r136.toByteArray(), this.f83918b.getBody().length(), this.f83918b.getBody().md5Stub());
            goto L80
        L79:
            this.f83917a = this.f83919c.post(this.f83918b.getUrl(), r110, this.f83918b.getBody().mimeType(), r136.toByteArray());
            goto L80
        L11:
            if (pc0.f120968a.getValue().booleanValue() == false) goto L13;
            r106 = true;
            goto L14
        L5:
            if ("POST".equals(r101) == true) goto L8;
            LocalTestManager.a(new Class[]{wy.a.class});
            ALogger.e(RetrofitProvider.TAG, "REQUEST NOT GET OR POST");
            return null;
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final Request getRequest() {
            return this.f83918b;
        }

        public a(Request r100, IHostNetwork r101) {
            this.f83918b = r100;
            this.f83919c = r101;
        }
    }

    public RetrofitProvider() {
    }

    public static /* synthetic */ Client a(Client r100) {
        return lambda$getRetrofitInstance$1(r100);
    }

    public static /* synthetic */ SsCall b(RetrofitProvider r100, IHostNetwork r101, Request r102) {
        return r100.lambda$getRetrofitInstance$0(r101, r102);
    }

    private static /* synthetic */ Client lambda$getRetrofitInstance$1(Client r100) {
        return r100;
    }

    public List<Interceptor> getCustomInterceptors() {
        return null;
    }

    public static List<CallAdapter.Factory> getLiveCallAdapters() {
        ArrayList r100 = new ArrayList();
        r100.add(new MonitorTimeCostCallAdapterFactoryV2(new PbAnnotationCallAdapterFactoryV2(RxJava2CallAdapterFactory.createAsync())));
        return r100;
    }

    public static List<Converter.Factory> getLiveConverters() {
        ArrayList r100 = new ArrayList();
        r100.add(new MonitorTimeCostRequestConverterFactory(new MultiTypeRequestConverterFactory(new rx5.a(NetworkGson.a()))));
        r100.add(new com.bytedance.android.live.network.f());
        return r100;
    }

    public static List<Interceptor> getLiveInterceptors() {
        ArrayList r100 = new ArrayList();
        if (com.bytedance.android.live.network.impl.interceptor.a.f83857b == null) goto L5;
    L14:
        r100.add(com.bytedance.android.live.network.impl.interceptor.a.f83857b);
        r100.add(y.a());
        v r101 = LiveInitSettingKeys.get_LIVE_LOGSDK_CONFIG();
        if (r101.c() == false) goto L18;
        r100.add(new w(r101.d()));
    L18:
        if (mc0.f120744a.getValue().a() == false) goto L21;
        r100.add(z.a.f83914a);
    L21:
        if (z7.f121741a.getValue().getEnable() == false) goto L24;
        r100.add(new r());
    L24:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L28;
        ILiveSdkProjectModeService r102 = (ILiveSdkProjectModeService) jc1.k.f(ILiveSdkProjectModeService.class);
        if (r102 == null) goto L28;
        r100.addAll(r102.getInterceptors());
    L28:
        String r103 = at2.c.f16218a;
        r100.add(at2.a.f16216a);
        List<Interceptor> r104 = new RetrofitProvider().getCustomInterceptors();
        if (r104 == null) goto L36;
        Iterator r105 = new ArrayList(r104).iterator();
    L32:
        if (r105.hasNext() == false) goto L36;
        Interceptor r106 = (Interceptor) r105.next();
        if (r106 == null) goto L32;
        r100.add(r106);
    L36:
        r100.add(new p());
        return r100;
    L5:
        monitor-enter(com.bytedance.android.live.network.impl.interceptor.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.android.live.network.impl.interceptor.a.f83857b != null) goto L9;
        com.bytedance.android.live.network.impl.interceptor.a.f83857b = new com.bytedance.android.live.network.impl.interceptor.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.android.live.network.impl.interceptor.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.bytedance.android.live.a
    public Retrofit getRetrofitInstance() {
        return getRetrofitInstance("https://" + ((INetworkService) jc1.k.f(INetworkService.class)).getHostDomain());
    }

    @Override // com.bytedance.android.live.a
    public ILiveRetrofitWrapper getRetrofitInstanceV2() {
        PbRequestCallAdapterV2.a r100 = PbRequestCallAdapterV2.f83795f;
        com.bytedance.android.live.network.d r101 = new com.bytedance.android.live.network.d(NetworkSettingKeys.PB_REQUEST_SWITCHES.getValue(), 2, NetworkSettingKeys.PB_REQUEST_STRATEGY.getValue().booleanValue());
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        PbRequestCallAdapterV2.f83792c = r101;
        return ((IHostNetwork) jc1.k.f(IHostNetwork.class)).getRetrofitInstanceV2();
    }

    private void appendRealtimeSignalInterceptor(Retrofit.Builder r100) {
        SettingKey<n71> r101 = LiveConfigSettingKeys.LIVE_REAL_TIME_SIGNAL_CONFIG_SETTING_KEY;
        if (r101.getValue().f() == false) goto L10;
        IUserRealtimeSignalFeature r102 = (IUserRealtimeSignalFeature) jc1.k.f(IUserRealtimeSignalFeature.class);
        if (r102 == null) goto L11;
        r100.addInterceptor(r102.getFeedApiInterceptor());
        if (r101.getValue().e() == false) goto L12;
        r100.addInterceptor(r102.getDislikeInterceptor());
        return;
    L12:
        return;
    L11:
        return;
    }

    public Retrofit getRetrofitInstance(String r100) {
        return getRetrofitInstance(r100, true);
    }

    private /* synthetic */ SsCall lambda$getRetrofitInstance$0(IHostNetwork r100, Request r101) throws IOException {
        return new a(r101, r100);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.live.network.impl.utils.j] */
    public Retrofit getRetrofitInstance(String r100, boolean r101) {
        final IHostNetwork r102 = (IHostNetwork) jc1.k.f(INetworkService.class);
        final ?? r103 = new j(this, r102);
        PbRequestCallAdapter.a r104 = PbRequestCallAdapter.f83789f;
        com.bytedance.android.live.network.d r105 = new com.bytedance.android.live.network.d(NetworkSettingKeys.PB_REQUEST_SWITCHES.getValue(), 2, NetworkSettingKeys.PB_REQUEST_STRATEGY.getValue().booleanValue());
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        PbRequestCallAdapter.f83786c = r105;
        Retrofit.Builder r106 = new Retrofit.Builder().setEndpoint(r100).client(new k(r103)).addCallAdapterFactory(new MonitorTimeCostCallAdapterFactory(new PbAnnotationCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()))).addConverterFactory(new com.bytedance.android.live.network.f()).addConverterFactory(new MonitorTimeCostRequestConverterFactory(new zn0.c(new MultiTypeRequestConverterFactory(new rx5.a(NetworkGson.a())))));
        if (r101 == true) goto L5;
    L17:
        r106.addInterceptor(y.a()).httpExecutor(new SsHttpExecutor());
        r106.addInterceptor(FuseRequestAdaptorInterceptor.f83854j);
        v r107 = LiveInitSettingKeys.get_LIVE_LOGSDK_CONFIG();
        if (r107.c() == false) goto L21;
        r106.addInterceptor(new w(r107.d()));
    L21:
        if (mc0.f120744a.getValue().a() == false) goto L23;
        r106.addInterceptor(z.a.f83914a);
    L23:
        int r108 = c.f83926a;
        if (ge.f120273a.getValue().a() == false) goto L26;
        r106.addInterceptor(com.bytedance.android.live.network.impl.interceptor.d.f83865a);
    L26:
        r106.addInterceptor(new zn0.d());
        if (z7.f121741a.getValue().getEnable() == false) goto L30;
        r106.addInterceptor(new r());
    L30:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L34;
        ILiveSdkProjectModeService r109 = (ILiveSdkProjectModeService) jc1.k.f(ILiveSdkProjectModeService.class);
        if (r109 == null) goto L34;
        r109.addLocalTestInterceptor(r106);
    L34:
        IHostContext r110 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r110 != null) goto L37;
    L41:
        appendRealtimeSignalInterceptor(r106);
        List<Interceptor> r111 = getCustomInterceptors();
        if (r111 == null) goto L50;
        Iterator r112 = new ArrayList(r111).iterator();
    L45:
        if (r112.hasNext() == false) goto L50;
        Interceptor r113 = (Interceptor) r112.next();
        if (r113 == null) goto L45;
        r106.addInterceptor(r113);
    L50:
        return r106.build();
    L37:
        if (r110.hasSandboxRecord() == false) goto L41;
        Interceptor r114 = r110.getSandboxInterceptor();
        if (r114 == null) goto L41;
        r106.addInterceptor(r114);
        goto L41
    L5:
        if (com.bytedance.android.live.network.impl.interceptor.a.f83857b == null) goto L7;
    L16:
        r106.addInterceptor(com.bytedance.android.live.network.impl.interceptor.a.f83857b);
        goto L17
    L7:
        monitor-enter(com.bytedance.android.live.network.impl.interceptor.a.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (com.bytedance.android.live.network.impl.interceptor.a.f83857b != null) goto L11;
        com.bytedance.android.live.network.impl.interceptor.a.f83857b = new com.bytedance.android.live.network.impl.interceptor.a();     // Catch: Throwable -> L13
    L11:
        monitor-exit(com.bytedance.android.live.network.impl.interceptor.a.class);     // Catch: Throwable -> L13
        goto L16
    }
}
