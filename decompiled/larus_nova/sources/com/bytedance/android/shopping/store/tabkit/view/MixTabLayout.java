package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/MixTabLayout;", "Landroid/widget/FrameLayout;", "", "isTopBar", "", "setDefaultStyle", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "getNativeTabLayout", "()Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "nativeTabLayout", "Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "b", "Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "getHybridTabLayout", "()Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "hybridTabLayout", "Landroid/util/AttributeSet;", "c", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MixTabLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECTabLayout f186870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HybridTabLayout f186871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AttributeSet f186872c;

    public MixTabLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MixTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.f186872c;
    }

    public final HybridTabLayout getHybridTabLayout() {
        return this.f186871b;
    }

    public final ECTabLayout getNativeTabLayout() {
        return this.f186870a;
    }

    public ECTabLayout a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ECTabLayout(r100);
    }

    public HybridTabLayout b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        HybridTabLayout r101 = new HybridTabLayout(r100, null);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r101.setClipChildren(false);
        return r101;
    }

    public final void setDefaultStyle(boolean r100) {
        Drawable r101 = null;
        if (r100 == false) goto L8;
        ECTabLayout r102 = this.f186870a;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, b.b(44));
        r103.leftMargin = b.b(16);
        r103.rightMargin = b.b(16);
        r103.gravity = 17;
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
        ECTabLayout r105 = this.f186870a;
        int r106 = g1.f45599a;
        Drawable r107 = g1.a.b(getContext(), R.drawable.ec_tabkit_top_tab_indicator);
        if (r107 == null) goto L7;
        r101 = r107.mutate();
    L7:
        r105.setSelectedTabIndicator(r101);
        this.f186870a.setTabMode(0);
        return;
    L8:
        this.f186870a.setTabMaxWidth(Integer.MAX_VALUE);
        this.f186870a.setTabGravity(0);
        this.f186870a.setLayoutParams(new FrameLayout.LayoutParams(-1, b.b(48)));
        this.f186870a.setSelectedTabIndicatorColor(0);
        this.f186870a.setSelectedTabIndicator(null);
    }

    public MixTabLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f186872c = r101;
        setClipChildren(false);
        ECTabLayout r103 = a(r100);
        HybridTabLayout r104 = null;
        r103.setAnimation(null);
        r103.setNeedHideIndicatorWhenSingleTab(true);
        r103.setSelectedTabIndicatorHeight(b.b(4));
        r103.setSelectedTabIndicatorColor(0);
        r103.setTabPaddingStart(0);
        r103.setTabPaddingEnd(0);
        r103.setClipChildren(false);
        addView(r103);
        Unit r105 = Unit.INSTANCE;
        this.f186870a = r103;
        HybridTabLayout r106 = b(r100);
        if (r106 == null) goto L5;
        addView(r106);
        r104 = r106;
    L5:
        this.f186871b = r104;
        ExtensionsKt.gone(this);
        r100.obtainStyledAttributes(r101, new int[]{R.attr.scene}).getString(0);
    }

    public /* synthetic */ MixTabLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
