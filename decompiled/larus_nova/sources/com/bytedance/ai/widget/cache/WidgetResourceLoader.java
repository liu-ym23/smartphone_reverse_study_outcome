package com.bytedance.ai.widget.cache;

import android.content.Context;
import android.net.Uri;
import android.os.Trace;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
public class WidgetResourceLoader implements b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompletableDeferred<Widget>> f37940e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompletableDeferred<TemplateBundle>> f37941f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f37942g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConversationWidgetData f37943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f37944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Widget f37945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile TemplateBundle f37946d;

    public static final class a {
    }

    public /* synthetic */ WidgetResourceLoader() {
        throw null;
    }

    @Override // com.bytedance.ai.widget.cache.b
    public Object a(Continuation<? super Widget> r100) {
        return n(this, r100);
    }

    @Override // com.bytedance.ai.widget.cache.b
    public final Object c(Continuation<? super TemplateBundle> r100) {
        return k(this, r100);
    }

    @Override // com.bytedance.ai.widget.cache.b
    public TemplateData e() {
        return null;
    }

    @Override // com.bytedance.ai.widget.cache.b
    public Uri f() {
        return null;
    }

    @Override // com.bytedance.ai.widget.cache.b
    public Object g(Context r100, m r101, Continuation<? super Unit> r102) {
        return i(this, r101, r102);
    }

    public Object l(Continuation<? super TemplateBundle> r100) {
        return m(this, r100);
    }

    static {
        f37940e = new ConcurrentHashMap();
        f37941f = new ConcurrentHashMap();
        f37942g = new AtomicInteger(0);
    }

    public WidgetResourceLoader(ConversationWidgetData r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetData");
        this.f37943a = r100;
        this.f37944b = f37942g.incrementAndGet();
    }

    @Override // com.bytedance.ai.widget.cache.b
    public void b(ConversationWidgetData r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetData");
    }

    public static final Object h(WidgetResourceLoader r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof WidgetResourceLoader$loadWidgetFromPackage$1) == false) goto L7;
        WidgetResourceLoader$loadWidgetFromPackage$1 r100 = (WidgetResourceLoader$loadWidgetFromPackage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r104 = (String) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L21:
        Widget r113 = (Widget) r112;
        Trace.endSection();
        com.bytedance.ai.applet.base.log.b r106 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadWidgetFromPackage: end loading, packageName = " + r105 + ", widgetId = " + r104);
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        String r114 = r110.f37943a.getPackageName();
        String r107 = r110.f37943a.getWidgetId();
        com.bytedance.ai.applet.base.log.b r108 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadWidgetFromPackage: start loading, packageName = " + r114 + ", widgetId = " + r107);
        StringBuilder r109 = new StringBuilder("loadWidget_");
        r109.append(r107);
        Trace.beginSection(r109.toString());
        AIManager r115 = AIManager.f37211a;
        Map<String, Object> r116 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r110.f37943a.getMessageId()), TuplesKt.to("botId", r110.f37943a.getBotId())});
        String r117 = r110.f37943a.getVersionTag();
        if (r117 == null) goto L17;
        r116.put("version_tag", r117);
    L17:
        Unit r118 = Unit.INSTANCE;
        r100.L$0 = r114;
        r100.L$1 = r107;
        r100.label = 1;
        Object r119 = r115.E(r114, r107, r116, r100);
        if (r119 == r102) goto L23;
        r104 = r107;
        r105 = r114;
        r112 = r119;
        goto L21
    L23:
        return r102;
    L7:
        r100 = new WidgetResourceLoader$loadWidgetFromPackage$1(r110, r111);
        goto L8
    }

    public static Object k(WidgetResourceLoader r210, Continuation<? super TemplateBundle> r211) {
        WidgetResourceLoader r100 = r210;
        if ((r211 instanceof WidgetResourceLoader$loadTemplateBundle$1) == false) goto L7;
        WidgetResourceLoader$loadTemplateBundle$1 r101 = (WidgetResourceLoader$loadTemplateBundle$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        CompletableDeferred<TemplateBundle> r106 = (CompletableDeferred) r101.L$2;
        String r107 = (String) r101.L$1;
        WidgetResourceLoader r108 = (WidgetResourceLoader) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L61:
        f37941f.remove(r107, r106);
        JobKt.ensureActive(r101.getContext());
        r108.getClass();
        return r108.f37946d;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        CompletableDeferred<TemplateBundle> r109 = (CompletableDeferred) r101.L$5;
        String r110 = (String) r101.L$4;
        String r111 = (String) r101.L$3;
        String r112 = (String) r101.L$2;
        String r113 = (String) r101.L$1;
        WidgetResourceLoader r114 = (WidgetResourceLoader) r101.L$0;
        ResultKt.throwOnFailure(r103);
        CompletableDeferred<TemplateBundle> r115 = r109;
        r100 = r114;
    L50:
        TemplateBundle r116 = (TemplateBundle) r103;
        if (r116 == null) goto L54;
        com.bytedance.ai.applet.base.log.b r117 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r100.f37944b + ") loadTemplateJs: hit awaitResult");
        r100.f37946d = r116;
        return r116;
    L54:
        com.bytedance.ai.applet.base.log.b r118 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + r100.f37944b + ") loadTemplateJs: awaitResult is NULL", null);
        String r119 = r111;
    L57:
        WidgetResourceLoader$loadTemplateBundle$3 r120 = new WidgetResourceLoader$loadTemplateBundle$3(r100, r113, r112, r119, null);
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r115;
        r101.L$3 = null;
        r101.L$4 = null;
        r101.L$5 = null;
        r101.label = 2;
        if (r100.o(r115, r120, r101) != r104) goto L60;
        return r104;
    L60:
        r107 = r110;
        r108 = r100;
        r106 = r115;
        goto L61
    L16:
        ResultKt.throwOnFailure(r103);
        r210.getClass();
        if (r100.f37946d == null) goto L20;
        com.bytedance.ai.applet.base.log.b r121 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d("WidgetResourceLoader", "Loader(" + r100.f37944b + ") loadTemplateJs: templateBundle is loaded", null);
        return r100.f37946d;
    L20:
        r113 = r100.f37943a.getPackageName();
        r112 = r100.f37943a.getWidgetId();
        String r122 = r100.f37943a.getVersionTag();
        ConcurrentHashMap<String, Widget> r123 = com.bytedance.ai.widget.cache.a.f37947a;
        Intrinsics.checkNotNullParameter(r113, "packageName");
        Intrinsics.checkNotNullParameter(r112, "widgetId");
        if (com.bytedance.ai.widget.cache.a.f37949c == false) goto L23;
        TemplateBundle r124 = null;
    L24:
        r100.f37946d = r124;
        if (r100.f37946d == null) goto L29;
        com.bytedance.ai.applet.base.log.b r125 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r100.f37944b + ") loadTemplateBundle: hit cache, packageName = " + r113 + ", widgetId = " + r112 + ", versionTag = " + r122);
        return r100.f37946d;
    L29:
        if (r100.f37945c != null) goto L32;
        com.bytedance.ai.applet.base.log.b r126 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + r100.f37944b + ") loadTemplateJs: widget is NULL", null);
        return null;
    L32:
        Widget r127 = r100.f37945c;
        if (r127 == null) goto L35;
        String r128 = r127.f36908o;
    L37:
        if (Intrinsics.areEqual(r128, "lynx") == true) goto L44;
        com.bytedance.ai.applet.base.log.b r129 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r130 = new StringBuilder("Loader(");
        r130.append(r100.f37944b);
        r130.append(") loadTemplateBundle: renderType is NOT lynx, it is ");
        Widget r131 = r100.f37945c;
        if (r131 == null) goto L41;
        String r132 = r131.f36908o;
    L42:
        r130.append(r132);
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", r130.toString(), null);
        return null;
    L41:
        r132 = null;
        goto L42
    L44:
        r110 = j(r113, r112, r122);
        r115 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CompletableDeferred<TemplateBundle> r133 = f37941f.putIfAbsent(r110, r115);
        if (r133 == null) goto L56;
        com.bytedance.ai.applet.base.log.b r134 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r100.f37944b + ") loadTemplateJs: other loader is loading");
        WidgetResourceLoader$loadTemplateBundle$2$awaitResult$1 r135 = new WidgetResourceLoader$loadTemplateBundle$2$awaitResult$1(r133, null);
        r101.L$0 = r100;
        r101.L$1 = r113;
        r101.L$2 = r112;
        r101.L$3 = r122;
        r101.L$4 = r110;
        r101.L$5 = r115;
        r101.label = 1;
        Object r136 = TimeoutKt.c(5000, r135, r101);
        if (r136 != r104) goto L49;
        return r104;
    L49:
        r111 = r122;
        r103 = r136;
        goto L50
    L56:
        r119 = r122;
        goto L57
    L35:
        r128 = null;
        goto L37
    L23:
        r124 = com.bytedance.ai.widget.cache.a.f37948b.get(com.bytedance.ai.widget.cache.a.b(r113, r112, r122));
    L7:
        r101 = new WidgetResourceLoader$loadTemplateBundle$1(r100, r211);
        goto L8
    }

    public static Object m(WidgetResourceLoader r110, Continuation<? super TemplateBundle> r111) {
        if ((r111 instanceof WidgetResourceLoader$loadTemplateBundleFromPackage$1) == false) goto L7;
        WidgetResourceLoader$loadTemplateBundleFromPackage$1 r100 = (WidgetResourceLoader$loadTemplateBundleFromPackage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        WidgetResourceLoader$loadTemplateBundleFromPackage$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r113 = (String) r102.L$2;
        String r105 = (String) r102.L$1;
        WidgetResourceLoader r106 = (WidgetResourceLoader) r102.L$0;
        ResultKt.throwOnFailure(r112);
        String r114 = r113;
        r110 = r106;
    L31:
        TemplateBundle r107 = (TemplateBundle) r112;
        String r115 = r105;
    L32:
        Trace.endSection();
        com.bytedance.ai.applet.base.log.b r108 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadTemplateBundleFromPackage: end loading, packageName = " + r115 + ", widgetId = " + r114);
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r115 = r110.f37943a.getPackageName();
        r114 = r110.f37943a.getWidgetId();
        com.bytedance.ai.applet.base.log.b r109 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadTemplateBundleFromPackage: start loading, packageName = " + r115 + ", widgetId = " + r114);
        StringBuilder r116 = new StringBuilder("loadTemplateBundle_");
        Widget r117 = r110.f37945c;
        r107 = null;
        if (r117 == null) goto L17;
        String r118 = r117.K;
    L18:
        r116.append(r118);
        Trace.beginSection(r116.toString());
        Widget r119 = r110.f37945c;
        if (r119 == null) goto L32;
        int r120 = AppletLynxViewApi.f36629a;
        String r121 = r119.f36917x;
        if (r121 != null) goto L23;
        r121 = "";
    L23:
        String r122 = AppletResourceTool.m(AppletResourceTool.f37276a, r119, r119.L);
        if (r119.E != 1) goto L26;
        boolean r123 = true;
    L27:
        String r124 = r119.f36895b;
        String r125 = r119.K;
        r102.L$0 = r110;
        r102.L$1 = r115;
        r102.L$2 = r114;
        r102.label = 1;
        Object r126 = AppletLynxViewApi.b(r121, r122, r123, r124, r125, r102);
        if (r126 != r103) goto L30;
        return r103;
    L30:
        r105 = r115;
        r112 = r126;
        goto L31
    L26:
        r123 = false;
        goto L27
    L17:
        r118 = null;
    L7:
        r100 = new WidgetResourceLoader$loadTemplateBundleFromPackage$1(r110, r111);
        goto L8
    }

    public static Object n(WidgetResourceLoader r110, Continuation<? super Widget> r111) {
        if ((r111 instanceof WidgetResourceLoader$loadWidget$1) == false) goto L7;
        WidgetResourceLoader$loadWidget$1 r100 = (WidgetResourceLoader$loadWidget$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        CompletableDeferred<Widget> r113 = (CompletableDeferred) r100.L$2;
        String r104 = (String) r100.L$1;
        WidgetResourceLoader r105 = (WidgetResourceLoader) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L42:
        f37940e.remove(r104, r113);
        JobKt.ensureActive(r100.getContext());
        r105.getClass();
        return r105.f37945c;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        CompletableDeferred<Widget> r114 = (CompletableDeferred) r100.L$3;
        String r106 = (String) r100.L$2;
        String r107 = (String) r100.L$1;
        WidgetResourceLoader r108 = (WidgetResourceLoader) r100.L$0;
        ResultKt.throwOnFailure(r112);
        CompletableDeferred<Widget> r115 = r114;
        r110 = r108;
        String r109 = r107;
        Object r116 = r112;
    L33:
        Widget r117 = (Widget) r116;
        if (r117 == null) goto L37;
        com.bytedance.ai.applet.base.log.b r118 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadWidget: hit awaitResult");
        r110.f37945c = r117;
        return r117;
    L37:
        com.bytedance.ai.applet.base.log.b r119 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadWidget: awaitResult is NULL", null);
    L38:
        WidgetResourceLoader$loadWidget$3 r120 = new WidgetResourceLoader$loadWidget$3(r110, r109, null);
        r100.L$0 = r110;
        r100.L$1 = r106;
        r100.L$2 = r115;
        r100.L$3 = null;
        r100.label = 2;
        if (r110.o(r115, r120, r100) != r102) goto L41;
        return r102;
    L41:
        r104 = r106;
        r105 = r110;
        r113 = r115;
        goto L42
    L16:
        ResultKt.throwOnFailure(r112);
        r110.getClass();
        if (r110.f37945c == null) goto L20;
        com.bytedance.ai.applet.base.log.b r121 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadWidget: widget is loaded", null);
        return r110.f37945c;
    L20:
        String r122 = r110.f37943a.getPackageName();
        String r123 = r110.f37943a.getWidgetId();
        r109 = r110.f37943a.getVersionTag();
        ConcurrentHashMap<String, Widget> r124 = com.bytedance.ai.widget.cache.a.f37947a;
        Intrinsics.checkNotNullParameter(r122, "packageName");
        Intrinsics.checkNotNullParameter(r123, "widgetId");
        if (com.bytedance.ai.widget.cache.a.f37949c == false) goto L23;
        Widget r125 = null;
    L24:
        r110.f37945c = r125;
        if (r110.f37945c == null) goto L28;
        com.bytedance.ai.applet.base.log.b r126 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadWidget: hit cache, packageName = " + r122 + ", widgetId = " + r123 + ", versionTag = " + r109);
        return r110.f37945c;
    L28:
        r106 = j(r122, r123, r109);
        r115 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CompletableDeferred<Widget> r127 = f37940e.putIfAbsent(r106, r115);
        if (r127 == null) goto L38;
        com.bytedance.ai.applet.base.log.b r128 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r110.f37944b + ") loadWidget: other loader is loading");
        WidgetResourceLoader$loadWidget$2$awaitResult$1 r129 = new WidgetResourceLoader$loadWidget$2$awaitResult$1(r127, null);
        r100.L$0 = r110;
        r100.L$1 = r109;
        r100.L$2 = r106;
        r100.L$3 = r115;
        r100.label = 1;
        r116 = TimeoutKt.c(5000, r129, r100);
        if (r116 != r102) goto L33;
        return r102;
    L23:
        r125 = com.bytedance.ai.widget.cache.a.f37947a.get(com.bytedance.ai.widget.cache.a.b(r122, r123, r109));
    L7:
        r100 = new WidgetResourceLoader$loadWidget$1(r110, r111);
        goto L8
    }

    public static Object i(WidgetResourceLoader r110, m r111, Continuation r112) {
        m r100 = r111;
        if ((r112 instanceof WidgetResourceLoader$awaitRunApplet$1) == false) goto L7;
        WidgetResourceLoader$awaitRunApplet$1 r101 = (WidgetResourceLoader$awaitRunApplet$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        WidgetResourceLoader$awaitRunApplet$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        String r113 = "";
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (m) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        AppletRuntime r107 = (AppletRuntime) r104;
    L24:
        if (r107 != null) goto L26;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "createWidgetContainer runApplet failed", null);
    L26:
        i1 r108 = y0.f512051a;
        String r109 = r100.a();
        Pair[] r114 = new Pair[2];
        if (r107 == null) goto L32;
        Applet r115 = r107.f36719h;
        if (r115 == null) goto L32;
        String r116 = r115.B;
        if (r116 == null) goto L32;
    L33:
        r114[0] = TuplesKt.to("applet_res_from", r116);
        if (r107 == null) goto L39;
        String r117 = r107.f36731t;
        if (r117 == null) goto L39;
        r113 = r117;
    L39:
        r114[1] = TuplesKt.to("main_js_res_from", r113);
        y0.l(r109, "applet_widget_timeline_full", MapsKt.mapOf(r114));
        return Unit.INSTANCE;
    L32:
        r116 = "";
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        i1 r118 = y0.f512051a;
        y0.m(r111.a(), "applet_widget_timeline_full");
        AppletRuntimeManager r119 = AppletRuntimeManager.INSTANCE;
        String r120 = r100.f38025k;
        String r121 = r100.f38018d;
        String r122 = r100.f38015a;
        r119.getClass();
        r107 = AppletRuntimeManager.i(r120, r121, r122);
        if (r107 != null) goto L24;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "createWidgetContainer runApplet");
        String r123 = r100.f38015a;
        String r124 = r100.f38025k;
        if (r124 != null) goto L19;
        String r125 = "";
    L20:
        String r126 = r100.f38018d;
        String r127 = r111.a();
        Map r128 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(BindCardPayConfirmConstants.Key.TRACE_ID, r111.a()), TuplesKt.to("eventName", "applet_widget_timeline_full")});
        r103.L$0 = r100;
        r103.label = 1;
        r104 = AppletRuntimeManager.a(r119, r123, r125, r126, r127, r128, r103);
        if (r104 != r105) goto L23;
        return r105;
    L19:
        r125 = r124;
    L7:
        r101 = new WidgetResourceLoader$awaitRunApplet$1(r110, r112);
        goto L8
    }

    public static String j(String r100, String r110, String r111) {
        String[] r101 = new String[3];
        r101[0] = r100;
        r101[1] = r110;
        if (r111 != null) goto L5;
    L7:
        r111 = null;
    L8:
        r101[2] = r111;
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r101), ":", null, null, 0, null, null, 62, null);
    L5:
        if ((true ^ StringsKt.isBlank(r111)) == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, kotlinx.coroutines.CompletableDeferred<T>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r5v7, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final <T> Object o(CompletableDeferred<T> r100, Function1<? super Continuation<? super T>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof WidgetResourceLoader$safeRun$1) == false) goto L7;
        WidgetResourceLoader$safeRun$1 r103 = (WidgetResourceLoader$safeRun$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        boolean r108 = (CompletableDeferred<T>) ((CompletableDeferred) r103.L$0);
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L22
        r100 = r108;
    L20:
        ((CompletableDeferred) r100).complete(r105);     // Catch: Exception -> L22
    L25:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;     // Catch: Exception -> L22
        r103.label = 1;     // Catch: Exception -> L22
        r105 = r101.invoke(r103);     // Catch: Exception -> L22
        r100 = r100;
        if (r105 != r106) goto L20;
        return r106;
    L22:
        e = move-exception;
        com.bytedance.ai.applet.base.log.b r109 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + this.f37944b + ") safeRun: " + e.getMessage(), e);
        r100.complete(null);
    L7:
        r103 = new WidgetResourceLoader$safeRun$1(this, r102);
        goto L8
    }

    @Override // com.bytedance.ai.widget.cache.b
    public void d(final String r100, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r110, "conversationID");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.MSGID);
        h2.a r101 = f2.b.f475099c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f483562a == null) goto L9;
        AppletRuntimeManager r102 = AppletRuntimeManager.INSTANCE;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put(BindCardPayConfirmConstants.Key.TRACE_ID, r112);
        r103.put("eventName", "applet_widget_timeline_full");
        Unit r104 = Unit.INSTANCE;
        Function1 r105 = new e(r100);
        r102.getClass();
        AppletRuntimeManager.n(r100, r110, r111, r112, r113, r103, r105);
        return;
    }
}
