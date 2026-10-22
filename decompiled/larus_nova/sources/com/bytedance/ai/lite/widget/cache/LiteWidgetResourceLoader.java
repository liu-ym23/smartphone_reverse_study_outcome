package com.bytedance.ai.lite.widget.cache;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ai.lite.model.objects.LiteWidget;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.cache.WidgetResourceLoader;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
public final class LiteWidgetResourceLoader extends WidgetResourceLoader {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConversationWidgetData f36628h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final void d(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationID");
        Intrinsics.checkNotNullParameter(r102, "botId");
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.MSGID);
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final TemplateData e() {
        g.f37637a.d("LiteWidgetResourceLoader", "getCustomTemplateData " + this.f36628h.getWidgetData());
        String r100 = this.f36628h.getWidgetData();
        if (r100 != null) goto L5;
        return null;
    L5:
        return TemplateData.fromString(r100);
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final Uri f() {
        if (f.g(this.f36628h.getLiteTemplateUrl()) == true) goto L7;
        return null;
    L7:
        return UriProtector.parse(this.f36628h.getLiteTemplateUrl());
    }

    public LiteWidgetResourceLoader(ConversationWidgetData r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetData");
        super(r100);
        this.f36628h = r100;
        AppletResourceTool.s(AppletResourceTool.f37276a);
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final Object a(Continuation<? super Widget> r100) {
        this.f37945c = new LiteWidget(this.f36628h.getPackageName(), this.f36628h.getWidgetId());
        Widget r101 = this.f37945c;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ai.lite.model.objects.LiteWidget");
        LiteWidget r102 = (LiteWidget) r101;
        r102.getClass();
        Intrinsics.checkNotNullParameter("lynx", "<set-?>");
        r102.f36908o = "lynx";
        g.f37637a.i("LiteWidgetResourceLoader", "loadWidget " + this.f37945c);
        Widget r103 = this.f37945c;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ai.lite.model.objects.LiteWidget");
        return (LiteWidget) r103;
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final void b(ConversationWidgetData r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetData");
        this.f36628h = r100;
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader
    public final Object l(Continuation<? super TemplateBundle> r110) {
        if ((r110 instanceof LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1) == false) goto L7;
        LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1 r100 = (LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L37:
        TemplateBundle r105 = (TemplateBundle) r111;
    L38:
        g.f37637a.i("LiteWidgetResourceLoader", "Loader(" + this.f37944b + ") loadTemplateBundleFromPackage: end loading, liteTemplateUrl=" + this.f36628h.getLiteTemplateUrl());
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r105 = null;
        if (f.g(this.f36628h.getLiteTemplateUrl()) == false) goto L17;
        Uri r112 = UriProtector.parse(this.f36628h.getLiteTemplateUrl());
    L19:
        if (r112 == null) goto L27;
        String r113 = UriProtector.getQueryParameter(r112, "surl");
        if (r113 != null) goto L23;
        r113 = "";
    L23:
        Uri r114 = UriProtector.parse(r113);
        g r106 = g.f37637a;
        r106.d("LiteWidgetResourceLoader", "check uri " + this.f36628h.getLiteTemplateUrl() + " host=" + r114.getHost());
        int r107 = g5.a.f480013a;
        if (g5.a.a(r114.getHost()) == true) goto L27;
        r106.e("LiteWidgetResourceLoader", "domain " + r114.getHost() + " not in list");
        return null;
    L27:
        String r115 = this.f36628h.getLiteTemplateUrl();
        if (r115 == null) goto L38;
        int r108 = AppletLynxViewApi.f36629a;
        Widget r109 = this.f37945c;
        if (r109 == null) goto L33;
        String r116 = r109.f36917x;
        if (r116 == null) goto L33;
    L34:
        r102.label = 1;
        r111 = AppletLynxViewApi.b(r116, r115, false, null, null, r102);
        if (r111 != r103) goto L37;
        return r103;
    L33:
        r116 = "";
        goto L34
    L17:
        r112 = null;
    L7:
        r100 = new LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1(this, r110);
        goto L8
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final Object g(Context r100, m r101, Continuation<? super Unit> r102) {
        i1 r103 = y0.f512051a;
        y0.m(r101.a(), "applet_widget_timeline_full");
        y0.l(r101.a(), "applet_widget_timeline_full", MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_res_from", ""), TuplesKt.to("main_js_res_from", "")}));
        return Unit.INSTANCE;
    }
}
