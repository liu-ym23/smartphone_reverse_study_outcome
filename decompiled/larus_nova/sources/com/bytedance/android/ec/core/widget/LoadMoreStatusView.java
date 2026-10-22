package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ui.ec.widget.loading.ECLoadMoreView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0003¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R*\u0010\u001f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u0012\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001d\u0010\u0019R0\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00060"}, d2 = {"Lcom/bytedance/android/ec/core/widget/LoadMoreStatusView;", "Landroid/widget/FrameLayout;", "Loj/b;", "", "status", "", "setECStatus", "", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getLottieFileName", "()Ljava/lang/String;", "getLottieFileName$annotations", "()V", "lottieFileName", "Landroid/widget/FrameLayout$LayoutParams;", "b", "Landroid/widget/FrameLayout$LayoutParams;", "getLoadLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "loadLayoutParams", "d", "I", "getRepeatMode", "()I", "getRepeatMode$annotations", "repeatMode", "e", "getRepeatCount", "getRepeatCount$annotations", "repeatCount", "", "Landroid/view/View;", "f", "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "setStatusViews", "(Ljava/util/Map;)V", "statusViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreStatusView extends FrameLayout implements oj.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f46001h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f46002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout.LayoutParams f46003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout.LayoutParams f46004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f46005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f46006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Integer, View> f46007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46008g;

    public static final class a {
        public a() {
        }

        public static LoadMoreStatusView a(Context r100, String r101, FrameLayout.LayoutParams r102) {
            int r103 = LoadMoreStatusView.f46001h;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "lottieFileName");
            Intrinsics.checkNotNullParameter(r102, "loadLayoutParams");
            AttributeSet r104 = null;
            LoadMoreStatusView r105 = new LoadMoreStatusView(r100, r104, 6, 0);
            r105.f46002a = r101;
            r105.f46003b = r102;
            r105.f46005d = 1;
            r105.f46006e = -1;
            return r105;
        }
    }

    static {
        new a();
    }

    public LoadMoreStatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LoadMoreStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Deprecated(message = "如无必要，不要传这个lottie文件名，默认会有加载更多的动画ECLoadMoreView")
    public static /* synthetic */ void getLottieFileName$annotations() {
    }

    @Deprecated(message = "如无必要，请使用默认的ECLoadMoreView")
    public static /* synthetic */ void getRepeatCount$annotations() {
    }

    @Deprecated(message = "如无必要，请使用默认的ECLoadMoreView")
    public static /* synthetic */ void getRepeatMode$annotations() {
    }

    @Override // oj.b
    public final void a() {
        setVisibility(0);
        setECStatus(0);
    }

    @Override // oj.b
    public final void d() {
        setVisibility(0);
        setECStatus(1);
    }

    @Override // oj.b
    public final void e() {
        setVisibility(0);
        setECStatus(2);
    }

    @Override // oj.b
    public final void b() {
        if (this.f46008g != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        View r100 = this.f46007f.get(Integer.valueOf(this.f46008g));
        if (r100 == null) goto L8;
        r100.setVisibility(4);
    L8:
        this.f46008g = -1;
    }

    public final FrameLayout.LayoutParams getLoadLayoutParams() {
        return this.f46003b;
    }

    public final String getLottieFileName() {
        return this.f46002a;
    }

    public final int getRepeatCount() {
        return this.f46006e;
    }

    public final int getRepeatMode() {
        return this.f46005d;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.f46007f;
    }

    @Override // oj.b
    public void setECStatus(int r100) {
        int r101 = this.f46008g;
        if (r101 < 0) goto L7;
        View r102 = this.f46007f.get(Integer.valueOf(r101));
        if (r102 == null) goto L7;
        r102.setVisibility(4);
    L7:
        View r103 = this.f46007f.get(Integer.valueOf(r100));
        if (r103 == null) goto L20;
        r103.setVisibility(0);
        this.f46008g = r100;
        if (r100 == 0) goto L12;
        return;
    L12:
        if (this.f46002a.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L22;
        ECLottieAnimationView r105 = (ECLottieAnimationView) r103.findViewById(R.id.shopping_load_more_lottie);
        if (r105 == null) goto L23;
        r105.setLayoutParams(this.f46003b);
        r105.setVisibility(0);
        r105.setAnimation(this.f46002a);
        r105.setRepeatMode(this.f46005d);
        r105.setRepeatCount(this.f46006e);
        r105.playAnimation();
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r104 = false;
        goto L15
    }

    public final void setStatusViews(Map<Integer, View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f46007f = r100;
    }

    public LoadMoreStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f46002a = "";
        this.f46003b = new FrameLayout.LayoutParams(-2, -2);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        Unit r104 = Unit.INSTANCE;
        this.f46004c = r103;
        this.f46005d = 1;
        this.f46006e = -1;
        this.f46007f = new LinkedHashMap();
        this.f46008g = -1;
        f(null, null, null);
    }

    @Override // oj.b
    public final void c(Context r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f(null, r101, r102);
    }

    public final void f(View r110, View r111, View r112) {
        this.f46007f.clear();
        Map<Integer, View> r100 = this.f46007f;
        Object r113 = r110;
        if (r110 == null) goto L5;
    L11:
        r100.put(0, (View) r113);
        this.f46007f.put(1, r111);
        this.f46007f.put(2, r112);
        removeAllViews();
        Iterator<Integer> r114 = this.f46007f.keySet().iterator();
    L13:
        if (r114.hasNext() == false) goto L18;
        int r115 = r114.next().intValue();
        View r116 = this.f46007f.get(Integer.valueOf(r115));
        if (r116 == null) goto L13;
        r116.setVisibility(4);
        addView(r116);
        goto L13
    L18:
        return;
    L5:
        if (this.f46002a.length() != 0) goto L7;
        boolean r117 = true;
    L8:
        if (r117 == false) goto L10;
        ECLoadMoreView r118 = new ECLoadMoreView(getContext(), null, 0, 6, null);
        r118.setLayoutParams(this.f46004c);
        r118.setVisibility(0);
        r113 = r118;
        goto L11
    L10:
        ShoppingAsyncInflater.a r119 = ShoppingAsyncInflater.f45268e;
        Context r101 = getContext();
        r119.getClass();
        View r120 = ShoppingAsyncInflater.a.a(r101).aU(R.layout.shopping_layout_load_more_status_view, this, false);
        ECLottieAnimationView r102 = (ECLottieAnimationView) r120.findViewById(R.id.shopping_load_more_lottie);
        r102.setLayoutParams(this.f46003b);
        r102.setVisibility(0);
        r102.setAnimation(this.f46002a);
        r102.setRepeatMode(this.f46005d);
        r102.setRepeatCount(this.f46006e);
        r102.playAnimation();
        r113 = r120;
        goto L11
    L7:
        r117 = false;
        goto L8
    }

    public /* synthetic */ LoadMoreStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
