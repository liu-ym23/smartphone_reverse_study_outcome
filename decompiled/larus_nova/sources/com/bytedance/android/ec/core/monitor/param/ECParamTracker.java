package com.bytedance.android.ec.core.monitor.param;

import android.net.Uri;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.event.EventActionImpl;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ECParamTracker extends EventActionImpl implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, JSONObject> f45184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<b> f45185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f45186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f45187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ParamReportConfigSetting f45188g;

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void a(final Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        r100.buildUpon().toString();
        p(CheckPointType.ENTER_PAGE, new ECParamTracker$enterPage$1(this, r100));
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void b(Function0<? extends JSONObject> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataBuilder");
        p(CheckPointType.ENTER_PAGE, r100);
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void j(Function0 r100) {
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "page");
        Intrinsics.checkNotNullParameter(r100, "dataBuilder");
        p("outer_buyNow", r100);
    }

    public static final JSONObject o(ECParamTracker r100, Uri r101) {
        r100.getClass();
        JSONObject r102 = x0.c(r101);
        KtSafeMethodExtensionKt.safePut(r102, "schema_host", r101.getHost());
        List<String> r103 = r100.f45188g.getFilterKeys();
        if (r103 == null) goto L8;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r102.remove((String) r104.next());
    L8:
        return r102;
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void f(String r100, final Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "schema");
        p("outer_".concat(r100), new ECParamTracker$outer$2(this, r101));
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void g(String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "schema");
        p("outer_".concat(r100), new ECParamTracker$outer$1(this, r101));
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void l(String r100, Function0<? extends JSONObject> r110) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r110, "dataBuilder");
        if (StringsKt.startsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == false) goto L5;
        String r101 = StringsKt.replace$default(StringsKt.removePrefix(r100, HTTP.URL_DEFAULT), HTTP.URL_DEFAULT, "_", false, 4, null);
    L6:
        p("request_" + r101, r110);
        return;
    L5:
        r101 = StringsKt.replace$default(r100, HTTP.URL_DEFAULT, "_", false, 4, null);
        goto L6
    }

    public final void p(final String r100, final Function0<? extends JSONObject> r101) {
        b2.b(new ECParamTracker$putParams$1(this, r101, r100));
    }

    public ECParamTracker(String r100, String r101, ParamReportConfigSetting r102) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "sampleConfig");
        this.f45186e = r100;
        this.f45187f = r101;
        this.f45188g = r102;
        this.f45184c = new ConcurrentHashMap();
        this.f45185d = new ArrayList();
        initEventContext(new Pair[]{TuplesKt.to("page_name", r100), TuplesKt.to("session_id", r101), TuplesKt.to("init_time", String.valueOf(System.currentTimeMillis()))});
        kh.a r103 = new kh.a(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "listener");
        ((ArrayList) this.f45185d).add(r103);
    }
}
