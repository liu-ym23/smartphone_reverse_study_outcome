package com.bytedance.android.ec.hybrid.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/ECMarqueeUIWidget;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMarqueeUIWidget extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f47666e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f47667f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f47668g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HoleOverlayView f47669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ApertureView f47670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CusShadowView f47671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47672d;

    public static final class a {
    }

    static {
        f47666e = UIToolsKt.a(7);
        f47667f = UIToolsKt.a(2);
        f47668g = UIToolsKt.a(25);
    }

    public ECMarqueeUIWidget(Context r100) {
        this(r100, null);
    }

    public ECMarqueeUIWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f47669a = new HoleOverlayView(r100, null);
        this.f47670b = new ApertureView(r100, null);
        this.f47671c = new CusShadowView(r100, null);
    }

    public static final void a(ECMarqueeUIWidget r100, View r101, long r102) {
        r100.getClass();
        if (r101 == null) goto L14;
        ViewPropertyAnimator r103 = r101.animate();
        if (r103 == null) goto L15;
        ViewPropertyAnimator r104 = r103.alpha(0.0f);
        if (r104 == null) goto L16;
        ViewPropertyAnimator r105 = r104.setDuration(r102);
        if (r105 == null) goto L17;
        ViewPropertyAnimator r106 = r105.setListener(new e(r100));
        if (r106 == null) goto L18;
        r106.start();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
