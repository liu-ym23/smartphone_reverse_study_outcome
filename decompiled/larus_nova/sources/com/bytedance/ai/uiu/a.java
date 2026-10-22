package com.bytedance.ai.uiu;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import com.bytedance.ai.widget.WidgetManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f37603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f37604b = null;

    /* JADX INFO: renamed from: com.bytedance.ai.uiu.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0713a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37605a = null;

        static {
            int[] r100 = new int[ConversionScene.values().length];
            r100[ConversionScene.SCENE_FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ConversionScene.SCENE_WIDGETS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ConversionScene.SCENE_POPUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f37605a = r100;
        }
    }

    public a() {
    }

    static {
        a r100 = new a();
        f37603a = r100;
        f37604b = r100.getClass().getName();
    }

    public static final WebView c(k2.i r100) {
        if ((r100 instanceof WidgetContainer) == false) goto L8;
        View r101 = ((WidgetContainer) r100).engineView();
        if ((r101 instanceof WebView) == true) goto L14;
        return null;
    L14:
        return (WebView) r101;
    L8:
        if ((r100 instanceof k2.j) == false) goto L15;
        View r102 = r100.engineView();
        if ((r102 instanceof WebView) == true) goto L12;
        return null;
    L12:
        return (WebView) r102;
    L15:
        return null;
    }

    public static final Set b(ConversionScene r110, PageSetting r111) {
        if (r111 != PageSetting.LAST_PAGE) goto L5;
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.model.widgets.c r100 = AppletRuntimeManager.c();
    L7:
        if (r111 != PageSetting.ALL_PAGE) goto L9;
        boolean r101 = true;
    L10:
        int r112 = C0713a.f37605a[r110.ordinal()];
        if (r112 == 1) goto L18;
        if (r112 != 2) goto L14;
        Set r113 = SetsKt.setOf(new PageType[]{PageType.WIDGET_PAGE, PageType.FLOATING_VIEW});
    L19:
        AppletRuntimeManager.INSTANCE.getClass();
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r102 = AppletRuntimeManager.f36747b;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, com.bytedance.ai.model.widgets.c>> r104 = r102.entrySet().iterator();
    L21:
        if (r104.hasNext() == false) goto L37;
        Map.Entry<String, com.bytedance.ai.model.widgets.c> r105 = r104.next();
        com.bytedance.ai.model.widgets.c r106 = r105.getValue();
        if (r113.contains(r106.getPageInfo().getPageType()) == false) goto L34;
        if (r101 == true) goto L33;
        String r107 = r106.getPageInfo().getPageId();
        if (r100 == null) goto L30;
        PageInfo r108 = r100.getPageInfo();
        if (r108 == null) goto L30;
        String r109 = r108.getPageId();
    L32:
        if (Intrinsics.areEqual(r107, r109) == false) goto L34;
    L30:
        r109 = null;
    L33:
        boolean r114 = true;
    L35:
        if (r114 == false) goto L21;
        r103.put(r105.getKey(), r105.getValue());
    L34:
        r114 = false;
        goto L35
    L37:
        WidgetManager r115 = WidgetManager.f37917h.b();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.bytedance.ai.widget.WidgetManager");
        HashMap<com.bytedance.ai.widget.contianer.h, WidgetManager.b> r116 = r115.f37920a;
        if (r111 != PageSetting.LAST_PAGE) goto L40;
        com.bytedance.ai.widget.contianer.h r117 = (com.bytedance.ai.widget.contianer.h) CollectionsKt.firstOrNull(r116.keySet());
    L41:
        LinkedHashMap r118 = new LinkedHashMap();
        Iterator<Map.Entry<com.bytedance.ai.widget.contianer.h, WidgetManager.b>> r119 = r116.entrySet().iterator();
    L43:
        if (r119.hasNext() == false) goto L58;
        Map.Entry<com.bytedance.ai.widget.contianer.h, WidgetManager.b> r120 = r119.next();
        com.bytedance.ai.widget.contianer.h r121 = r120.getKey();
        if (r113.contains(PageType.WIDGET_PAGE) == false) goto L54;
        if (r101 == true) goto L53;
        String r122 = r121.j();
        if (r117 == null) goto L50;
        String r123 = r117.j();
    L52:
        if (Intrinsics.areEqual(r122, r123) == false) goto L54;
    L50:
        r123 = null;
    L53:
        boolean r124 = true;
    L55:
        if (r124 == false) goto L43;
        r118.put(r120.getKey(), r120.getValue());
    L54:
        r124 = false;
        goto L55
    L58:
        return CollectionsKt.union(r103.values(), r118.keySet());
    L40:
        r117 = null;
        goto L41
    L14:
        if (r112 == 3) goto L16;
        com.bytedance.ai.utils.g.f37637a.d(f37604b, "Get none pages for current conversation scene");
        return SetsKt.emptySet();
    L16:
        r113 = SetsKt.setOf(new PageType[]{PageType.POPUP_PAGE, PageType.FLOATING_VIEW});
        goto L19
    L18:
        r113 = SetsKt.setOf(new PageType[]{PageType.FULL_PAGE, PageType.FLOATING_VIEW});
        goto L19
    L9:
        r101 = false;
        goto L10
    L5:
        r100 = null;
        goto L7
    }

    public static void f(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "cardId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UIUContextManager$getTargetPagesUiContext$2(r101, r100, null), 3, null);
    }

    public static final Object a(a r100, k2.i r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof UIUContextManager$getPageUIContext$1) == false) goto L7;
        UIUContextManager$getPageUIContext$1 r103 = (UIUContextManager$getPageUIContext$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        String r108 = (String) r105;
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        UIUContextManager$getPageUIContext$2 r109 = new UIUContextManager$getPageUIContext$2(r101, null);
        r103.label = 1;
        r105 = TimeoutKt.c(1000, r109, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new UIUContextManager$getPageUIContext$1(r100, r102);
        goto L8
    }

    public static void e(ConversionScene r100, PageSetting r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "csvScene");
        Intrinsics.checkNotNullParameter(r101, "pageSetting");
        Intrinsics.checkNotNullParameter(r102, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UIUContextManager$getTargetPagesUiContext$1(r100, r101, r102, null), 3, null);
    }

    public static void g(String r100, List r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "cardId");
        Intrinsics.checkNotNullParameter(r101, "uiOperations");
        Intrinsics.checkNotNullParameter(r102, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UIUContextManager$performUIOperations$2(r102, r100, r101, null), 3, null);
    }

    public static final Object d(a r100, WebView r101, List r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof UIUContextManager$performUIOperations$3) == false) goto L7;
        UIUContextManager$performUIOperations$3 r104 = (UIUContextManager$performUIOperations$3) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L17:
        Boolean r109 = (Boolean) r106;
        if (r109 == null) goto L20;
        boolean r110 = r109.booleanValue();
    L22:
        return Boxing.boxBoolean(r110);
    L20:
        r110 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        UIUContextManager$performUIOperations$4 r111 = new UIUContextManager$performUIOperations$4(r101, r102, null);
        r104.label = 1;
        r106 = TimeoutKt.c(1000, r111, r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new UIUContextManager$performUIOperations$3(r100, r103);
        goto L8
    }
}
