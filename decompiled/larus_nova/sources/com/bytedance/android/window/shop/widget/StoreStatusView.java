package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/widget/StoreStatusView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/j;", "", "status", "", "setECStatus", "", "Landroid/view/View;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "statusViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StoreStatusView extends FrameLayout implements com.bytedance.android.ec.core.widget.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, View> f189878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Function0<View>> f189879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f189880c;

    public static final class a {
    }

    static {
    }

    public StoreStatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StoreStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ec.core.widget.j
    public final void showLoading() {
        setVisibility(0);
        setECStatus(0);
    }

    @Override // com.bytedance.android.ec.core.widget.j
    public final void reset() {
        if (this.f189880c != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        Map<Integer, View> r100 = this.f189878a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        View r102 = (View) r101.get(Integer.valueOf(this.f189880c));
        if (r102 == null) goto L8;
        r102.setVisibility(4);
    L8:
        this.f189880c = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.f189878a;
    }

    public void setECStatus(int r100) {
        if (this.f189878a.containsKey(Integer.valueOf(r100)) == true) goto L10;
        Map<Integer, Function0<View>> r101 = this.f189879b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Function0 r103 = (Function0) r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L7;
        View r104 = (View) r103.invoke();
    L8:
        if (r104 == null) goto L10;
        addView(r104);
        this.f189878a.put(Integer.valueOf(r100), r104);
        goto L10
    L7:
        r104 = null;
    L10:
        int r105 = this.f189880c;
        if (r105 < 0) goto L15;
        Map<Integer, View> r106 = this.f189878a;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        View r108 = (View) r107.get(Integer.valueOf(r105));
        if (r108 == null) goto L15;
        r108.setVisibility(4);
    L15:
        Map<Integer, View> r109 = this.f189878a;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        View r111 = (View) r110.get(Integer.valueOf(r100));
        if (r111 == null) goto L19;
        r111.setVisibility(0);
        this.f189880c = r100;
        return;
    }

    public StoreStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f189878a = new LinkedHashMap();
        this.f189879b = new LinkedHashMap();
        this.f189880c = -1;
    }

    public /* synthetic */ StoreStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
