package com.bytedance.android.shopping.store.tabkit;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.model.a0;
import com.bytedance.android.shopping.store.tabkit.model.b0;
import com.bytedance.android.shopping.store.tabkit.model.n;
import com.bytedance.android.shopping.store.tabkit.model.p;
import com.bytedance.android.shopping.store.tabkit.model.q;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.x;
import com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.MixTabLayout;
import com.bytedance.android.shopping.store.tabkit.view.RightItemView;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f186738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ti.l f186739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.store.tabkit.model.k f186740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TabKitBridge f186741d;

        public a(Function1 r100, ti.l r101, com.bytedance.android.shopping.store.tabkit.model.k r102, TabKitBridge r103) {
            this.f186738a = r100;
            this.f186739b = r101;
            this.f186740c = r102;
            this.f186741d = r103;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            pd.f r100 = this.f186741d.f186580c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.d((IECBridgeMethod) this.f186738a.invoke(this.f186740c));
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f186742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ti.l f186743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.store.tabkit.model.k f186744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TabKitBridge f186745d;

        public b(Function1 r100, ti.l r101, com.bytedance.android.shopping.store.tabkit.model.k r102, TabKitBridge r103) {
            this.f186742a = r100;
            this.f186743b = r101;
            this.f186744c = r102;
            this.f186745d = r103;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            pd.f r100 = this.f186745d.f186580c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.d((IECBridgeMethod) this.f186742a.invoke(this.f186744c));
        }
    }

    public static final boolean a(View r100) {
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L19;
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == true) goto L10;
        r102 = null;
    L10:
        View r103 = (View) r102;
        if (r103 != null) goto L13;
        return false;
    L13:
        if (r103.getVisibility() != 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 != true) goto L21;
        return true;
    L21:
        return false;
    L15:
        r104 = false;
        goto L16
    L19:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public static final List<BaseTabItemView> i(ECTabLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$baseTabItemViews");
        List<ECTabLayout.Tab> r101 = k(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        View r104 = ((ECTabLayout.Tab) r103.next()).getCustomView();
        if (r104 == null) goto L9;
        r102.add((BaseTabItemView) r104);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView");
    L10:
        return r102;
    }

    public static final String j(com.bytedance.android.shopping.store.tabkit.model.k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$localRedDotKey");
        StringBuilder r101 = new StringBuilder("ec_hybrid_tab_red_dot_show_");
        r101.append(String.valueOf(r100.n()));
        r101.append("_");
        x r102 = r100.o();
        if (r102 == null) goto L7;
        com.bytedance.android.shopping.store.tabkit.model.l r103 = r102.a();
        if (r103 == null) goto L7;
        String r104 = r103.getIdentifier();
    L8:
        r101.append(String.valueOf(r104));
        return r101.toString();
    L7:
        r104 = null;
        goto L8
    }

    public static final List<ECTabLayout.Tab> k(ECTabLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$tabs");
        ArrayList r101 = new ArrayList();
        int r102 = r100.getTabCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ECTabLayout.Tab r104 = r100.getTabAt(r103);
        if (r104 == null) goto L7;
        r101.add(r104);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r101;
    }

    public static final boolean l(com.bytedance.android.shopping.store.tabkit.model.k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLynxTab");
        s r101 = r100.f();
        if (r101 == null) goto L5;
        Integer r102 = r101.c();
    L6:
        if (r102 != null) goto L9;
    L11:
        return false;
    L9:
        if (r102.intValue() != 2) goto L11;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean m(com.bytedance.android.shopping.store.tabkit.model.k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isWebTab");
        s r101 = r100.f();
        if (r101 == null) goto L5;
        Integer r102 = r101.c();
    L6:
        if (r102 != null) goto L9;
    L11:
        return false;
    L9:
        if (r102.intValue() != 3) goto L11;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static final void d(com.bytedance.android.shopping.store.tabkit.model.g r100, ECDraweeView r101) {
        Intrinsics.checkNotNullParameter(r101, "iconView");
        int r102 = 0;
        if (r100 == null) goto L7;
        Integer r103 = r100.e();
        if (r103 == null) goto L7;
        int r104 = com.bytedance.android.shopping.extensions.b.b(r103);
    L8:
        if (r100 == null) goto L12;
        Integer r105 = r100.d();
        if (r105 == null) goto L12;
        r102 = com.bytedance.android.shopping.extensions.b.b(r105);
    L12:
        c(r102, r104, r101);
        return;
    L7:
        r104 = 0;
        goto L8
    }

    public static final b0 e(b0 r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendParam");
        Intrinsics.checkNotNullParameter(r101, "map");
        b0 r102 = new b0();
        r102.c(r100.a());
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r101);
        Map<String, String> r104 = r100.b();
        if (r104 == null) goto L5;
        r103.putAll(r104);
    L5:
        Unit r105 = Unit.INSTANCE;
        r102.d(MapsKt.toMap(r103));
        return r102;
    }

    public static final void f(ECDraweeView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        PipelineDraweeControllerBuilder r102 = Fresco.newDraweeControllerBuilder().setUri("res://" + r100.getContext().getPackageName() + HTTP.URL_DEFAULT + r101).setOldController(r100.getController());
        if (r102 == null) goto L5;
        AbstractDraweeController r103 = r102.build();
    L6:
        r100.setController(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void g(GenericDraweeView r100, ECUrlModel r110) {
        Intrinsics.checkNotNullParameter(h0.f44678a, "$this$bindImage");
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        h0.d(r100, r110, new r("redundancy", "redundancy", "redundancy"), null, null, null, null, 120);
    }

    public static final void h(GenericDraweeView r100, ECUrlModel r101) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        AbstractDraweeController r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getUri();
    L6:
        String r104 = a2.d(r103);
        if (r104 != null) goto L14;
        if (r101 == null) goto L12;
        List<String> r105 = r101.getUrlList();
        if (r105 == null) goto L12;
        String r106 = (String) CollectionsKt.first(r105);
    L13:
        r104 = a2.d(r106);
    L12:
        r106 = null;
    L14:
        if (r104 != null) goto L16;
        return;
    L16:
        PipelineDraweeControllerBuilder r107 = Fresco.newDraweeControllerBuilder().setUri(r104).setOldController(r100.getController());
        if (r107 == null) goto L19;
        r102 = r107.build();
    L19:
        r100.setController(r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final p o(q r100, TabKitViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectTabBarStyle");
        if (r101 == null) goto L7;
        MutableLiveData<Integer> r102 = r101.getScreenState();
        if (r102 == null) goto L7;
        Integer r103 = r102.getValue();
    L8:
        if (r103 == null) goto L14;
        if (r103.intValue() != 0) goto L14;
        return r100.d();
    L14:
        return r100.i();
    L7:
        r103 = null;
        goto L8
    }

    public static final void p(MixTabLayout r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityByDisplayMode");
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        ExtensionsKt.visible(r100);
        return;
    L11:
        if (r101.intValue() != 1) goto L13;
        ExtensionsKt.visible(r100);
        return;
    L6:
        if (r101.intValue() != 2) goto L8;
        ExtensionsKt.gone(r100);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.ec.core.event.a, com.bytedance.android.shopping.store.tabkit.ExtensionsKt$toBaseMetricEvent2$3] */
    public static final ExtensionsKt$toBaseMetricEvent2$3 r(b0 r100, com.bytedance.android.shopping.store.tabkit.model.k r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$toBaseMetricEvent2");
        final String r102 = r100.a();
        if (r102 != null) goto L6;
        return null;
    L6:
        ?? r103 = new ExtensionsKt$toBaseMetricEvent2$3(r102, r102);
        Map<String, String> r104 = r100.b();
        if (r104 == null) goto L9;
        r103.appendParam(r104);
    L9:
        com.bytedance.android.shopping.store.tabkit.model.c r105 = r101.a();
        if (r105 == null) goto L16;
        a0 r106 = r105.a();
        if (r106 == null) goto L16;
        Map<String, String> r107 = r106.b();
        if (r107 == null) goto L16;
        r103.appendParam(r107);
    L16:
        Map<String, String> r108 = r101.h();
        if (r108 == null) goto L19;
        r103.appendParam(r108);
    L19:
        return r103;
    }

    public static final void s(com.bytedance.android.shopping.store.tabkit.model.g r100, ECDraweeView r101) {
        if (r100 == null) goto L13;
        String r102 = r100.c();
        if (r102 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r102) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L15;
        if (r101 == null) goto L16;
        r101.setColorFilter(com.bytedance.android.ec.core.utils.s.a(r102, (int) BodyPartID.bodyIdMax));
        return;
    L16:
        return;
    L15:
        return;
    }

    public static final void t(ECTabLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateTabBarItems");
        Iterator r102 = ((ArrayList) i(r100)).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((BaseTabItemView) r102.next()).setFullScreenState(r101);
        goto L4
    }

    public static final void c(int r100, int r101, ECDraweeView r102) {
        Intrinsics.checkNotNullParameter(r102, "iconView");
        if (r101 != 0) goto L6;
        if (r100 != 0) goto L6;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.height = com.bytedance.android.shopping.extensions.b.b(24);
        r103.width = com.bytedance.android.shopping.extensions.b.b(24);
        r102.setAdjustMode(0);
        return;
    L6:
        if (r101 <= 0) goto L10;
        if (r100 <= 0) goto L10;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        r104.height = r100;
        r104.width = r101;
        r102.setAdjustMode(0);
        return;
    L10:
        if (r100 != 0) goto L13;
        if (r101 <= 0) goto L13;
        r102.getLayoutParams().width = r101;
        r102.getLayoutParams().height = -2;
        r102.setAdjustMode(2);
        return;
    L13:
        if (r101 != 0) goto L20;
        if (r100 <= 0) goto L21;
        r102.getLayoutParams().height = r100;
        r102.getLayoutParams().width = -2;
        r102.setAdjustMode(1);
        return;
    L21:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.ec.core.event.a, com.bytedance.android.shopping.store.tabkit.ExtensionsKt$toBaseMetricEvent2$1] */
    public static final ExtensionsKt$toBaseMetricEvent2$1 q(b0 r100, com.bytedance.android.shopping.store.tabkit.model.k r101, a0 r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$toBaseMetricEvent2");
        final String r103 = r100.a();
        if (r103 != null) goto L6;
        return null;
    L6:
        ?? r104 = new ExtensionsKt$toBaseMetricEvent2$1(r103, r103);
        Map<String, String> r105 = r100.b();
        if (r105 == null) goto L9;
        r104.appendParam(r105);
    L9:
        if (r102 == null) goto L13;
        Map<String, String> r106 = r102.b();
        if (r106 == null) goto L13;
        r104.appendParam(r106);
    L13:
        if (r101 == null) goto L17;
        Map<String, String> r107 = r101.h();
        if (r107 == null) goto L17;
        r104.appendParam(r107);
    L17:
        return r104;
    }

    public static final void b(View r100, Integer r101, View r102, RightItemView r110) {
        ViewGroup.LayoutParams r103 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
    L7:
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L10;
        r103 = r104;
    L10:
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r103;
        if (r105 != null) goto L13;
        return;
    L13:
        Ref.IntRef r106 = new Ref.IntRef();
        r106.element = 0;
        Ref.IntRef r107 = new Ref.IntRef();
        r107.element = 0;
        if (r101 != null) goto L17;
    L19:
        if (r101 != null) goto L22;
    L24:
        if (r101 != null) goto L27;
    L29:
        if (r101 != null) goto L32;
        return;
    L32:
        if (r101.intValue() != 2) goto L37;
        r100.post(new c(r102, r106, r105, r107, r100));
        return;
    L37:
        return;
    L27:
        if (r101.intValue() != 3) goto L29;
        r100.post(new com.bytedance.android.shopping.store.tabkit.b(r105, r110, r107, r106, r100));
        return;
    L22:
        if (r101.intValue() != 0) goto L24;
    L23:
        r105.gravity = 1;
        r105.setMargins(r106.element, r105.topMargin, r107.element, r105.bottomMargin);
        r100.requestLayout();
        return;
    L17:
        if (r101.intValue() != 1) goto L19;
    L5:
        r104 = null;
        goto L7
    }

    public static final void n(ti.l r100, TabKitBridge r101, com.bytedance.android.shopping.store.tabkit.model.k r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$registerTabKitBridge");
        Intrinsics.checkNotNullParameter(r101, "bridge");
        Intrinsics.checkNotNullParameter(r102, "tab");
        if (r103 == false) goto L9;
        Iterator r104 = ((ArrayList) r101.f186579b.getValue()).iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Function1 r105 = (Function1) r104.next();
        r100.registerMethod(((TabKitBridge.TabKitBaseBridgeMethod) r105.invoke(r102)).getName(), new a(r105, r100, r102, r101));
        goto L6
    L8:
        return;
    L9:
        Iterator<Function1<com.bytedance.android.shopping.store.tabkit.model.k, TabKitBridge.TabKitBaseBridgeMethod>> r106 = r101.f186578a.iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        Function1<com.bytedance.android.shopping.store.tabkit.model.k, TabKitBridge.TabKitBaseBridgeMethod> r107 = r106.next();
        r100.registerMethod(r107.invoke(r102).getName(), new b(r107, r100, r102, r101));
        goto L11
    }

    public static final void u(ECTabLayout r100, p r101, boolean r110, MixTabLayout r111, View r112, RightItemView r113) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateTabBarLayoutStyle");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Integer r103 = null;
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r102;
        if (r101 == null) goto L12;
        Integer r105 = r101.d();
        if (r105 == null) goto L12;
        int r106 = r105.intValue();
        if (r104 == null) goto L12;
        r104.height = r106;
    L12:
        if (r101 == null) goto L14;
        String r107 = r101.b();
    L15:
        if (r107 != null) goto L138;
        if (r110 == true) goto L27;
        if (r111 == null) goto L27;
        r111.setBackgroundColor(-1);
    L27:
        Drawable r114 = r100.getTabSelectedIndicator();
        if ((r114 instanceof LayerDrawable) == true) goto L30;
        r114 = null;
    L30:
        LayerDrawable r115 = (LayerDrawable) r114;
        if (r115 == null) goto L33;
        Drawable r108 = r115.getDrawable(0);
    L35:
        if ((r108 instanceof GradientDrawable) == true) goto L37;
        r108 = null;
    L37:
        GradientDrawable r109 = (GradientDrawable) r108;
        if (r110 == false) goto L67;
        if (r101 == null) goto L67;
        n r116 = r101.e();
        if (r116 == null) goto L67;
        List<String> r117 = r116.a();
        if (r117 == null) goto L67;
        if (r117.size() <= 1) goto L142;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L56
        if (r109 == null) goto L53;
        List<String> r119 = r117;     // Catch: Throwable -> L56
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));     // Catch: Throwable -> L56
        Iterator<T> r121 = r119.iterator();     // Catch: Throwable -> L56
    L50:
        if (r121.hasNext() == false) goto L52;
        r120.add(Integer.valueOf(Color.parseColor((String) r121.next())));     // Catch: Throwable -> L56
        goto L50
    L52:
        qc3.a.f(r109, CollectionsKt.toIntArray(r120));     // Catch: Throwable -> L56
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L56
    L54:
        Object r123 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L56
    L66:
        Result.m9448boximpl(r123);
        goto L67
    L53:
        r122 = null;
    L56:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    L142:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L64
        if (r109 == null) goto L61;
        qc3.a.f(r109, new int[]{Color.parseColor((String) ListProtector.get(r117, 0)), Color.parseColor((String) ListProtector.get(r117, 0))});     // Catch: Throwable -> L64
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L64
    L62:
        r123 = Result.m9449constructorimpl(r126);     // Catch: Throwable -> L64
        goto L66
    L61:
        r126 = null;
    L64:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L67:
        if (r101 == null) goto L73;
        n r128 = r101.e();
        if (r128 == null) goto L73;
        Integer r129 = r128.d();
        if (r129 == null) goto L73;
        int r130 = com.bytedance.android.shopping.extensions.b.b(r129);
    L75:
        Integer r131 = Integer.valueOf(r130);
    L77:
        if (r131 == null) goto L79;
        int r132 = r131.intValue();
    L80:
        if (r101 == null) goto L86;
        n r133 = r101.e();
        if (r133 == null) goto L86;
        Integer r134 = r133.c();
        if (r134 == null) goto L86;
        int r135 = com.bytedance.android.shopping.extensions.b.b(r134);
    L88:
        Integer r136 = Integer.valueOf(r135);
    L90:
        if (r136 == null) goto L92;
        int r137 = r136.intValue();
    L94:
        if (Build.VERSION.SDK_INT < 23) goto L97;
        if (r115 == null) goto L97;
        r115.setLayerSize(0, r132, r137);
    L97:
        if (r101 == null) goto L99;
        Integer r138 = r101.a();
    L100:
        b(r100, r138, r112, r113);
        if (r101 == null) goto L105;
        n r139 = r101.e();
        if (r139 == null) goto L105;
        r103 = r139.b();
    L105:
        if (r103 != null) goto L108;
    L112:
        if (r103 != null) goto L115;
    L119:
        Iterator r140 = ((ArrayList) i(r100)).iterator();
    L121:
        if (r140.hasNext() == false) goto L137;
        BaseTabItemView r141 = (BaseTabItemView) r140.next();
        r141.setTabBarStyleConfig(r101);
        if (r110 == false) goto L121;
        if (r101 == null) goto L129;
        int r142 = r101.f();
        if (r142 == null) goto L129;
    L130:
        int r143 = com.bytedance.android.shopping.extensions.b.b(r142);
        if (r101 == null) goto L135;
        Integer r144 = r101.h();
        if (r144 == null) goto L135;
        int r145 = com.bytedance.android.shopping.extensions.b.b(r144);
    L136:
        r141.setPadding(r143, 0, r145, 0);
    L135:
        r145 = com.bytedance.android.shopping.extensions.b.b(14);
    L129:
        r142 = 14;
        goto L130
    L137:
        return;
    L115:
        if (r103.intValue() != 1) goto L119;
        Drawable r146 = r100.getTabSelectedIndicator();
        if (r146 == null) goto L119;
        r146.setAlpha(255);
        goto L119
    L108:
        if (r103.intValue() != 2) goto L112;
        Drawable r147 = r100.getTabSelectedIndicator();
        if (r147 == null) goto L119;
        r147.setAlpha(0);
        goto L119
    L99:
        r138 = null;
        goto L100
    L92:
        r137 = com.bytedance.android.shopping.extensions.b.b(3);
    L86:
        if (r109 == null) goto L89;
        r135 = r109.getIntrinsicHeight();
        goto L88
    L89:
        r136 = null;
        goto L90
    L79:
        r132 = com.bytedance.android.shopping.extensions.b.b(30);
    L73:
        if (r109 == null) goto L76;
        r130 = r109.getIntrinsicWidth();
        goto L75
    L76:
        r131 = null;
        goto L77
    L33:
        r108 = null;
        goto L35
    L138:
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L22
        if (r111 == null) goto L19;
        r111.setBackgroundColor(Color.parseColor(r101.b()));     // Catch: Throwable -> L22
        Unit r149 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Result.m9449constructorimpl(r149);     // Catch: Throwable -> L22
        goto L27
    L19:
        r149 = null;
    L22:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L14:
        r107 = null;
        goto L15
    }
}
