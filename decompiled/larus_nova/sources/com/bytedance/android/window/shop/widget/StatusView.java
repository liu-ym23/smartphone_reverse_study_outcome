package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.loading.ECSloganLoadingAnimationView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated(message = "不要用这个了，用ec-core中的")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/window/shop/widget/StatusView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "loadingView", "", "setLoading", "", "status", "setECStatus", "setupLoadingAnim", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "statusViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, View> f189875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f189876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f189877c;

    public static final class a {
    }

    static {
    }

    public StatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a() {
        ShoppingAsyncInflater.a r100 = ShoppingAsyncInflater.f45268e;
        Context r101 = getContext();
        r100.getClass();
        View r102 = ShoppingAsyncInflater.a.a(r101).aU(R.layout.ec_window_layout_status_view_loading, this, false);
        Lazy r103 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L6;
    L8:
        this.f189877c = r102;
        return r102;
    L6:
        if (we.a.f559330a == false) goto L8;
        ((LinearLayout) r102.findViewById(R.id.tt_loading)).setVisibility(0);
        goto L8
    }

    public final void b() {
        if (this.f189876b != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        Map<Integer, View> r100 = this.f189875a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        View r102 = (View) r101.get(Integer.valueOf(this.f189876b));
        if (r102 == null) goto L8;
        r102.setVisibility(4);
    L8:
        this.f189876b = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.f189875a;
    }

    public final void setECStatus(int r100) {
        int r101 = this.f189876b;
        if (r101 < 0) goto L7;
        Map<Integer, View> r102 = this.f189875a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        View r104 = (View) r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L7;
        r104.setVisibility(4);
    L7:
        Map<Integer, View> r105 = this.f189875a;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        View r107 = (View) r106.get(Integer.valueOf(r100));
        if (r107 == null) goto L15;
        r107.setVisibility(0);
        this.f189876b = r100;
        if (r100 != 0) goto L16;
        Lazy r108 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L17;
        setupLoadingAnim(r107);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void setLoading(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        this.f189875a.put(0, r100);
        removeAllViews();
        Iterator r101 = ((LinkedHashMap) this.f189875a).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        int r102 = ((Number) r101.next()).intValue();
        Map<Integer, View> r103 = this.f189875a;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        View r105 = (View) r104.get(Integer.valueOf(r102));
        if (r105 == null) goto L4;
        r105.setVisibility(4);
        addView(r105);
        goto L4
    }

    public void setupLoadingAnim(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        ECSloganLoadingAnimationView r101 = (ECSloganLoadingAnimationView) r100.findViewById(R.id.shopping_loading_lottie);
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }

    public StatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f189875a = new LinkedHashMap();
        this.f189876b = -1;
        c(null, null, false);
    }

    public final void c(View r100, View r101, boolean r102) {
        ((LinkedHashMap) this.f189875a).clear();
        Map<Integer, View> r103 = this.f189875a;
        if (r100 != null) goto L15;
        if (r102 == false) goto L14;
        r100 = this.f189877c;
        if (r100 == null) goto L13;
        ViewParent r104 = r100.getParent();
        if ((r104 instanceof ViewGroup) == true) goto L10;
        r104 = null;
    L10:
        ViewGroup r105 = (ViewGroup) r104;
        if (r105 == null) goto L15;
        r105.removeView(r100);
        goto L15
    L13:
        r100 = a();
        this.f189877c = r100;
        Intrinsics.checkNotNull(r100);
        goto L15
    L14:
        r100 = a();
    L15:
        r103.put(0, r100);
        this.f189875a.put(1, null);
        this.f189875a.put(2, r101);
        removeAllViews();
        Iterator r106 = ((LinkedHashMap) this.f189875a).keySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L22;
        int r107 = ((Number) r106.next()).intValue();
        View r108 = (View) ((LinkedHashMap) this.f189875a).get(Integer.valueOf(r107));
        if (r108 == null) goto L17;
        r108.setVisibility(4);
        addView(r108);
        goto L17
    }

    public /* synthetic */ StatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
