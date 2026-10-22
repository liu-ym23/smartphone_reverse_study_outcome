package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class NetworkRequestMethod extends BaseOpenMethod<v0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f60309i = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u10.b f60310h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.NetworkRequestMethod$call$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ String $domain;
        final /* synthetic */ String $host;
        final /* synthetic */ v0 $params;
        final /* synthetic */ String $relativePath;
        final /* synthetic */ String $schema;
        final /* synthetic */ NetworkRequestMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.NetworkRequestMethod$call$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
        public static final class C09901 extends Lambda implements Function0<Unit> {
            final /* synthetic */ AnonymousClass1 this$0;

            public C09901(AnonymousClass1 r100) {
                this.this$0 = r100;
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 r100 = this.this$0;
                NetworkRequestMethod r101 = r100.this$0;
                String r102 = r100.$domain;
                String r103 = r100.$schema;
                String r104 = r100.$host;
                Function0<Unit> r105 = new C09911(this);
                int r106 = NetworkRequestMethod.f60309i;
                r101.getClass();
                boolean r107 = true;
                if (InteractGameContext.Companion.c() == false) goto L13;
                String r108 = r101.f60306d.f60809m.f61088n;
                Intrinsics.checkNotNullParameter(r108, "$this$isOfficialVersion");
                LruCache<String, LiveSchemaInfo> r109 = LiveSchemaInfo.f201489r;
                LiveSchemaInfo r110 = LiveSchemaInfo.c.a(r108);
                if (r110 == null) goto L7;
                String r111 = (String) r110.f201493d.getValue();
            L9:
                if ((!Intrinsics.areEqual(r111, "current")) == false) goto L13;
                if (f0.a(r104) == false) goto L13;
                r105.invoke();
                return;
            L7:
                r111 = null;
            L13:
                BootInfoService r112 = (BootInfoService) r101.f60306d.o(BootInfoService.class);
                Intrinsics.checkNotNullParameter(r102, "domain");
                Intrinsics.checkNotNullParameter(r103, "schema");
                com.bytedance.android.live.broadcastgame.opengame.runtime.g r113 = r112.c();
                if (r113 == null) goto L29;
                com.bytedance.android.live.broadcastgame.opengame.runtime.j r114 = r113.f60835b;
                if (r114 == null) goto L29;
                List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r115 = r114.f60840b;
                if (r115 == null) goto L29;
                Iterator<T> r116 = r115.iterator();
            L21:
                if (r116.hasNext() == false) goto L29;
                com.bytedance.android.live.broadcastgame.opengame.network.a.c r117 = (com.bytedance.android.live.broadcastgame.opengame.network.a.c) r116.next();
                if (Intrinsics.areEqual(r117.b(), r102) == false) goto L21;
                if (Intrinsics.areEqual(r103, "https") == false) goto L21;
                if (r117.a() != 1) goto L21;
            L30:
                if (r107 == false) goto L32;
                r105.invoke();
                return;
            L32:
                r101.n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_HOST_ILLEGAL, null);
                return;
            L29:
                r107 = false;
                goto L30
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(NetworkRequestMethod r100, String r101, String r102, String r103, v0 r104, String r105) {
            this.this$0 = r100;
            this.$schema = r101;
            this.$host = r102;
            this.$domain = r103;
            this.$params = r104;
            this.$relativePath = r105;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            NetworkRequestMethod r100 = this.this$0;
            String r101 = this.$schema;
            String r102 = this.$host;
            C09901 r103 = new C09901(this);
            int r104 = NetworkRequestMethod.f60309i;
            r100.getClass();
            if (InteractGameContext.Companion.c() == false) goto L14;
            String r105 = r100.f60306d.f60809m.f61088n;
            Intrinsics.checkNotNullParameter(r105, "$this$isOfficialVersion");
            LruCache<String, LiveSchemaInfo> r106 = LiveSchemaInfo.f201489r;
            LiveSchemaInfo r107 = LiveSchemaInfo.c.a(r105);
            if (r107 == null) goto L7;
            String r108 = (String) r107.f201493d.getValue();
        L9:
            if ((!Intrinsics.areEqual(r108, "current")) == false) goto L14;
            if (f0.a(r102) == false) goto L14;
            r103.invoke();
            return;
        L7:
            r108 = null;
        L14:
            if (Intrinsics.areEqual("https", r101) == false) goto L16;
            r103.invoke();
            return;
        L16:
            r100.n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_NOT_HTTPS, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "request";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(v0 r110, CallContext r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Uri r112 = UriProtector.parse(r110.e());
        String r100 = r112.getScheme();
        String r101 = r112.getHost();
        int r113 = r112.getPort();
        if (r100 == null) goto L72;
        if (r101 == null) goto L72;
        if (r113 <= 0) goto L9;
        String r114 = r100 + "://" + r101 + ':' + r113;
    L10:
        String r102 = r114;
        String r115 = r110.e();
        if (r115.length() <= r102.length()) goto L13;
        String r116 = r115.substring(r102.length());
    L14:
        AnonymousClass1 r117 = new AnonymousClass1(this, r100, r101, r102, r110, r116);
        if (InteractGameContext.Companion.c() == false) goto L70;
        String r118 = this.f60306d.f60809m.f61088n;
        Intrinsics.checkNotNullParameter(r118, "$this$isOfficialVersion");
        LruCache<String, LiveSchemaInfo> r103 = LiveSchemaInfo.f201489r;
        LiveSchemaInfo r119 = LiveSchemaInfo.c.a(r118);
        if (r119 == null) goto L19;
        String r120 = (String) r119.f201493d.getValue();
    L20:
        boolean r104 = true;
        if ((!Intrinsics.areEqual(r120, "current")) == false) goto L70;
        if (f0.a(r101) == false) goto L70;
        Intrinsics.checkNotNullParameter(r101, "$this$isLanIp");
        List r121 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);
        if (r121.size() == 4) goto L74;
    L66:
        r104 = false;
    L67:
        if (r104 == false) goto L69;
        r117.invoke();
        return;
    L69:
        n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_NON_LAN_IP, null);
        return;
    L74:
        int r105 = CastIntegerProtector.parseInt((String) ListProtector.get(r121, 0));     // Catch: NumberFormatException -> L65
        int r106 = CastIntegerProtector.parseInt((String) ListProtector.get(r121, 1));     // Catch: NumberFormatException -> L65
        int r107 = CastIntegerProtector.parseInt((String) ListProtector.get(r121, 2));     // Catch: NumberFormatException -> L65
        int r122 = CastIntegerProtector.parseInt((String) ListProtector.get(r121, 3));     // Catch: NumberFormatException -> L65
        if (r105 != 10) goto L41;
        if (r106 < 0) goto L66;
        if (255 < r106) goto L66;
        if (r107 < 0) goto L66;
        if (255 < r107) goto L66;
        if (r122 < 0) goto L66;
        if (255 < r122) goto L66;
    L41:
        if (r105 != 172) goto L55;
        if (16 > r106) goto L66;
        if (31 < r106) goto L66;
        if (r107 < 0) goto L66;
        if (255 < r107) goto L66;
        if (r122 < 0) goto L66;
        if (255 < r122) goto L66;
    L55:
        if (r105 != 192) goto L66;
        if (r106 != 168) goto L66;
        if (r107 < 0) goto L66;
        if (255 < r107) goto L66;
        if (r122 < 0) goto L66;
        if (255 < r122) goto L66;
    L19:
        r120 = null;
    L70:
        r117.invoke();
        return;
    L13:
        r116 = "";
        goto L14
    L9:
        r114 = r100 + "://" + r101;
    L72:
        n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_URL_ILLEGAL, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(v0 r100, CallContext r101) {
        call2(r100, r101);
    }

    public NetworkRequestMethod(PluginContext r100, u10.b r101, LaunchMode r102, Queue<Long> r103) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "openNetworkExecutor");
        Intrinsics.checkNotNullParameter(r102, "launchMode");
        super(r100, r103);
        this.f60310h = r101;
    }
}
