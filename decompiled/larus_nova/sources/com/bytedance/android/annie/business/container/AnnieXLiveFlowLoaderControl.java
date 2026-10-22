package com.bytedance.android.annie.business.container;

import android.os.Bundle;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.data.DataProviderService;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXLiveFlowLoaderControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 f38916a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f38918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, Object> f38919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, ? extends Object> f38920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IAnnieBusinessLatchService.b f38921e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final DataProviderService f38922f;

        public final Map<String, Object> a(String r100, String r101) {
            Map<String, ? extends Object> r102 = this.f38920d;
            if (r102 == null) goto L6;
            Intrinsics.checkNotNull(r102);
            return r102;
        L6:
            boolean r103 = false;
            if (r100 != null) goto L9;
        L12:
            boolean r104 = true;
        L13:
            if (r104 == false) goto L15;
            Map<String, ? extends Object> r105 = MapsKt.emptyMap();
        L73:
            this.f38920d = r105;
            Intrinsics.checkNotNull(r105);
            return r105;
        L15:
            Boolean r106 = HybridSecureUtil.b(r100);
            if (r106 == null) goto L18;
            boolean r107 = r106.booleanValue();
        L19:
            if (r107 == true) goto L77;
            r105 = MapsKt.emptyMap();
            goto L73
        L77:
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L67
            if (r101 != null) goto L25;
        L28:
            boolean r109 = true;
        L30:
            if ((!r109) == true) goto L34;
            r101 = null;
        L34:
            if (r101 == null) goto L54;
            String r110 = UriProtector.getQueryParameter(UriProtector.parse(r101), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L67
            if (r110 == null) goto L54;
            Object r111 = Result.m9449constructorimpl(new JSONArray(r110));     // Catch: Throwable -> L39
        L42:
            if (Result.m9455isFailureimpl(r111) == false) goto L44;
            r111 = null;
        L44:
            JSONArray r112 = (JSONArray) r111;     // Catch: Throwable -> L67
            if (r112 == null) goto L54;
            if (r112.length() <= 0) goto L49;
            r103 = true;
        L49:
            if (r103 == true) goto L52;
            r112 = null;
        L52:
            if (r112 == null) goto L54;
        L65:
            Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L67
        L70:
            if (Result.m9455isFailureimpl(r113) == false) goto L72;
            r113 = null;
        L72:
            this.f38922f.c(r100, (JSONArray) r113, null, AnnieXLiveFlowLoaderControl$LiveFlowLoadContext$observeWith$1.INSTANCE);
            r105 = this.f38922f.b();
        L39:
            th = move-exception;
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L67
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        L54:
            String r115 = UriProtector.getQueryParameter(UriProtector.parse(r100), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L67
            if (r115 != null) goto L79;
            r112 = null;
            goto L65
        L79:
            Object r116 = Result.m9449constructorimpl(new JSONArray(r115));     // Catch: Throwable -> L58
        L61:
            if (Result.m9455isFailureimpl(r116) == false) goto L63;
            r116 = null;
        L63:
            r112 = (JSONArray) r116;     // Catch: Throwable -> L67
        L58:
            th = move-exception;
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L67
            r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
            goto L61
        L25:
            if (StringsKt.isBlank(r101) == true) goto L28;
            r109 = false;
        L67:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L70
        L18:
            r107 = o7.l.g(r100);
            goto L19
        L9:
            if (r100.length() == 0) goto L12;
            r104 = false;
            goto L13
        }

        public a(String r100, String r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "originSchema");
            this.f38917a = r100;
            this.f38918b = r101;
            String r103 = r102.getString("biz_key");     // Catch: Throwable -> L8
            if (r103 == null) goto L5;
        L6:
            this.f38922f = new DataProviderService(r103);
            return;
        L5:
            r103 = "host";
            goto L6
        }
    }

    static {
        f38916a = new AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1(3);
    }

    public static IAnnieBusinessLatchService.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        a r101 = (a) f38916a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f38921e;
    }
}
