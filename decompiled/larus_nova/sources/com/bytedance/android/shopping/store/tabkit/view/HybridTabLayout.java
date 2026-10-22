package com.bytedance.android.shopping.store.tabkit.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.api.d;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.container.TabKitFoldFragment;
import com.bytedance.android.shopping.store.utils.g;
import com.bytedance.lynx.service.model.b;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "getLynxCard", "()Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "lynxCard", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getListener", "()Ljava/util/ArrayList;", "listener", "Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "tabKitView", "Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "getTabKitView", "()Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "setTabKitView", "(Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridTabLayout extends FrameLayout implements IECLynxCardLifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECLynxCard f186866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<IECLynxCardLifeCycle> f186867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Object> f186868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f186869d;

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void createViewDuration(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadStart() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onPreCreateView(boolean r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRealSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onReceivedError(b r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRuntimeReady() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetup(Map<String, ? extends Object> r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetupPref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingUpdatePref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTransDataTime(long r100, long r101) {
    }

    public final void setTabKitView(ECTabKitView r100) {
    }

    public final ECTabKitView getTabKitView() {
        View r100 = this.f186866a.b();
        LynxBaseUI r101 = null;
        if ((r100 instanceof LynxView) == true) goto L5;
        r100 = null;
    L5:
        LynxView r102 = (LynxView) r100;
        if (r102 == null) goto L8;
        LynxBaseUI r103 = r102.findUIByIdSelector("tabbar");
    L10:
        if ((r103 instanceof ECTabKitView) == false) goto L14;
        r101 = r103;
    L14:
        return (ECTabKitView) r101;
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onFirstScreen() {
        Iterator<T> r100 = this.f186867b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r100.next()).onFirstScreen();
        goto L4
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
        Iterator<T> r100 = this.f186867b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r100.next()).onLoadSuccess();
        goto L4
    L6:
        getLayoutParams().height = -2;
        requestLayout();
    }

    public final ArrayList<IECLynxCardLifeCycle> getListener() {
        return this.f186867b;
    }

    public final ECLynxCard getLynxCard() {
        return this.f186866a;
    }

    public HybridTabLayout(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r100, "cache");
    }

    public HybridTabLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f186866a = new ECLynxCard();
        this.f186867b = new ArrayList();
        HashMap<String, Object> r102 = new HashMap();
        this.f186868c = r102;
        HashMap<String, Object> r103 = new HashMap();
        r103.put("meta_info", r102);
        Unit r104 = Unit.INSTANCE;
        this.f186869d = r103;
    }

    public final void a(TabKitViewModel r100, Pair<Integer, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "tabKitViewModel");
        if (r100.isFoldPage() == true) goto L5;
        return;
    L5:
        if (r101 != null) goto L13;
        Context r102 = getContext();
        if ((r102 instanceof Activity) == true) goto L9;
        r102 = null;
    L9:
        Activity r103 = (Activity) r102;
        if (r103 == null) goto L12;
        int r104 = TabKitFoldFragment.f186710f;
        TabKitFoldFragment.a.a(r103);
    L12:
        r101 = null;
    L13:
        if (r101 == null) goto L22;
        LinkedHashMap r105 = new LinkedHashMap();
        g.a(r105, "ec_split_screen_width", com.bytedance.android.shopping.extensions.b.f(r101.getFirst()));
        String r106 = r100.getFoldType();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        g.a(r105, "split_screen_type", r106);
        g.a(r105, "is_split", Boolean.TRUE);
        this.f186866a.s(r105);
        this.f186866a.c(r101.getFirst().intValue(), r101.getSecond().intValue());
        ViewGroup.LayoutParams r107 = getLayoutParams();
        if (r107 == null) goto L20;
        r107.width = r101.getFirst().intValue();
    L20:
        requestLayout();
        return;
    }

    public final void b(com.bytedance.android.shopping.store.tabkit.model.k r100, com.bytedance.android.shopping.store.tabkit.model.k r101) {
        Intrinsics.checkNotNullParameter(r100, "targetHomeTab");
        Intrinsics.checkNotNullParameter(r101, "targetTab");
        HashMap<String, Object> r102 = this.f186868c;
        r102.put("bottom_tab_data", GsonProtectorUtils.toJson(new Gson(), r100));
        r102.put("tab_data", GsonProtectorUtils.toJson(new Gson(), r101));
        ECLynxCard r103 = this.f186866a;
        int r104 = d.f46381e;
        r103.e(d.a.a(this.f186869d), false);
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
        Iterator<T> r103 = this.f186867b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r103.next()).onLoadFailed(r100, r101, r102);
        goto L4
    }
}
