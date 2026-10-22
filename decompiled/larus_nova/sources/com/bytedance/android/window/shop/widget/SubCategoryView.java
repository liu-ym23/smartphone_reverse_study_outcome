package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.SharedPrefExtKt;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/widget/SubCategoryView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubCategoryView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f189882c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECWindowTabLayout f189883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0 f189884b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubCategoryView f189885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f189886b;

        public a(SubCategoryView r100, i0 r101) {
            this.f189885a = r100;
            this.f189886b = r101;
        }

        public final void a() {
            SubCategoryView r100 = this.f189885a;
            i0 r101 = this.f189886b;
            int r102 = SubCategoryView.f189882c;
            r100.getClass();
            if (Intrinsics.areEqual(r101.f189579l, SubCategoryTypes.SUB_LIVE_APPOINT.getType()) == false) goto L31;
            Iterator<WindowProductCategoryVODeprecated.a> r103 = r101.f189578k.f189508j.iterator();
            int r104 = 0;
        L7:
            if (r103.hasNext() == false) goto L12;
            if (Intrinsics.areEqual(r103.next().f189512a, SubCategoryTypes.SUB_LIVE_HOT.getType()) == true) goto L13;
            r104 = r104 + 1;
        L13:
            if (r104 == (-1)) goto L32;
            String r105 = com.bytedance.android.ec.sdk.helper.r.f48132a.getCurrentUserId();
            ECWindowTabLayout r106 = r100.f189883a;
            if (r106 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
        L18:
            ECTabLayout.Tab r107 = r106.getTabAt(r104);
            if (r107 == null) goto L30;
            View r108 = r107.getCustomView();
            if (r108 != null) goto L24;
            return;
        L24:
            if (SharedPrefExtKt.getSharePref(r100.getContext(), "ec_window_live_point").getBoolean(r105, false) == true) goto L34;
            List r109 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.h());
            new com.bytedance.android.ec.window.base.common.bubble.r(r108, "更多直播热卖商品", new com.bytedance.android.ec.window.base.common.bubble.q(13.0f, BodyPartID.bodyIdMax), r109, new m(r100, r105), 312).b();
            return;
        L34:
            return;
        L30:
            return;
        L32:
            return;
        L12:
            r104 = -1;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public SubCategoryView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SubCategoryView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189883a = (ECWindowTabLayout) findViewById(R.id.ec_window_sub_category_tab);
    }

    public final void a(i0 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (Intrinsics.areEqual(this.f189884b, r100) == false) goto L5;
        return;
    L5:
        this.f189884b = r100;
        ECWindowTabLayout r101 = this.f189883a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L8:
        r101.removeAllTabs();
        ((ArrayList) r101.f189847a).clear();
        ((LinkedHashMap) r101.f189848b).clear();
        r101.clearOnTabSelectedListeners();
        r101.post(new e(r101));
        r101.setSelectedTabIndicator(R.drawable.shopping_shopwindow_tab_indicator);
        r101.setTabRippleColor(null);
        r101.addOnTabSelectedListener(new d());
        ECWindowTabLayout r102 = this.f189883a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L11:
        r102.c(r100);
        ECWindowTabLayout r103 = this.f189883a;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L14:
        r103.post(new a(this, r100));
    }

    public final void b(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ECWindowTabLayout r101 = this.f189883a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L7:
        int r102 = r101.getTabCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L25;
        ECWindowTabLayout r104 = this.f189883a;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L12:
        ECTabLayout.Tab r105 = r104.getTabAt(r103);
        if (r105 == null) goto L15;
        Object r106 = r105.getTag();
    L17:
        if (Intrinsics.areEqual(r106, r100) == false) goto L24;
        ECWindowTabLayout r107 = this.f189883a;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L21:
        ECTabLayout.Tab r108 = r107.getTabAt(r103);
        if (r108 == null) goto L24;
        r108.select();
    L24:
        r103 = r103 + 1;
        goto L8
    L15:
        r106 = null;
        goto L17
    }

    public SubCategoryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SubCategoryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
