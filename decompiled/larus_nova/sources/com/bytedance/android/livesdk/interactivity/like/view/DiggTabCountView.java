package com.bytedance.android.livesdk.interactivity.like.view;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.qn;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/DiggTabCountView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggTabCountView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f137850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f137851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f137852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f137853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PointF f137854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f137855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f137856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet<Integer> f137857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f137858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q4.b f137859j;

    public static final class a {
    }

    static {
    }

    public DiggTabCountView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DiggTabCountView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public DiggTabCountView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_tap_count_text, null);
        this.f137850a = r103;
        TextView r104 = (TextView) r103.findViewById(R.id.tv_digg_count);
        this.f137851b = r104;
        TextView r105 = (TextView) r103.findViewById(R.id.tv_digg_count_prefix);
        this.f137852c = r105;
        View r106 = r103.findViewById(R.id.ll_double_digg_suffix);
        this.f137853d = r106;
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r103.setAlpha(0.0f);
        addView(r103, r107);
        if (qn.f121069a.getValue().booleanValue() == true) goto L9;
        ALogger.i("DiggTabCountView", "set typeface in init");
        Typeface r108 = Typeface.createFromAsset(r100.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L7
        r104.setTypeface(r108);     // Catch: Exception -> L7
        r105.setTypeface(r108);     // Catch: Exception -> L7
        ((TextView) r106.findViewById(R.id.tv_double_digg_suffix_x)).setTypeface(r108);     // Catch: Exception -> L7
        ((TextView) r106.findViewById(R.id.tv_double_digg_suffix_count)).setTypeface(r108);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ALogger.e("DiggTabCountView", "load font asset exception: " + e.getMessage());
    L9:
        this.f137855f = UtilityKotlinExtentionsKt.h(16);
        this.f137856g = UtilityKotlinExtentionsKt.h(42);
        this.f137857h = new HashSet();
        this.f137859j = u4.b(false, new DiggTabCountView$countAnimController$1(this));
    }

    public /* synthetic */ DiggTabCountView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
