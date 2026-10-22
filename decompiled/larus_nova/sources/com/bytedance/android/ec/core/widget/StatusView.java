package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingConfig;
import com.bytedance.android.ui.ec.widget.loading.ECSloganLoadingAnimationView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/core/widget/StatusView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/j;", "", "status", "", "setECStatus", "Landroid/view/View;", "loadingView", "setupLoadingAnim", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "setStatusViews", "(Ljava/util/Map;)V", "statusViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StatusView extends FrameLayout implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f46051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f46053c;

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

    @Override // com.bytedance.android.ec.core.widget.j
    public final void showLoading() {
        setVisibility(0);
        setECStatus(0);
    }

    public final View a() {
        ECLoadingConfig r100 = ECLoadingConfig.INSTANCE;
        if (r100.isDecided() == true) goto L5;
        r100.decideUsePersistentCache(ECSettingKeys.E());
    L5:
        ShoppingAsyncInflater.a r101 = ShoppingAsyncInflater.f45268e;
        Context r102 = getContext();
        r101.getClass();
        View r103 = ShoppingAsyncInflater.a.a(r102).aU(R.layout.shopping_layout_status_view_loading, this, false);
        Lazy r104 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L9;
    L11:
        this.f46053c = r103;
        return r103;
    L9:
        if (we.a.f559330a == false) goto L11;
        ((LinearLayout) r103.findViewById(R.id.tt_loading)).setVisibility(0);
        goto L11
    }

    @Override // com.bytedance.android.ec.core.widget.j
    public final void reset() {
        if (this.f46052b != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        View r100 = this.f46051a.get(Integer.valueOf(this.f46052b));
        if (r100 == null) goto L8;
        r100.setVisibility(4);
    L8:
        this.f46052b = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.f46051a;
    }

    public void setECStatus(int r100) {
        int r101 = this.f46052b;
        if (r101 < 0) goto L7;
        View r102 = this.f46051a.get(Integer.valueOf(r101));
        if (r102 == null) goto L7;
        r102.setVisibility(4);
    L7:
        View r103 = this.f46051a.get(Integer.valueOf(r100));
        if (r103 == null) goto L15;
        r103.setVisibility(0);
        this.f46052b = r100;
        if (r100 != 0) goto L16;
        Lazy r104 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L17;
        setupLoadingAnim(r103);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void setStatusViews(Map<Integer, View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f46051a = r100;
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
        this.f46051a = new LinkedHashMap();
        this.f46052b = -1;
        b(null, null, false);
    }

    public final void b(View r100, View r101, boolean r102) {
        this.f46051a.clear();
        Map<Integer, View> r103 = this.f46051a;
        if (r100 != null) goto L15;
        if (r102 == false) goto L14;
        r100 = this.f46053c;
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
        this.f46053c = r100;
        Intrinsics.checkNotNull(r100);
        goto L15
    L14:
        r100 = a();
    L15:
        r103.put(0, r100);
        this.f46051a.put(1, null);
        this.f46051a.put(2, r101);
        removeAllViews();
        Iterator<Integer> r106 = this.f46051a.keySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L22;
        View r107 = this.f46051a.get(Integer.valueOf(r106.next().intValue()));
        if (r107 == null) goto L17;
        r107.setVisibility(4);
        addView(r107);
        goto L17
    }

    public /* synthetic */ StatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
