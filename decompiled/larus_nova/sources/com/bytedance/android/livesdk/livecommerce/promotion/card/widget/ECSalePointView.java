package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECSalePointView;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "getLine", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSalePointView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f150423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f150424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f150425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f150426d;

    private final View getLine() {
        View r100 = new View(getContext());
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), UtilityKotlinExtentionsKt.d(8));
        r101.leftMargin = UtilityKotlinExtentionsKt.d(3);
        r101.rightMargin = UtilityKotlinExtentionsKt.d(Double.valueOf(3.5d));
        r101.gravity = 16;
        r100.setLayoutParams(r101);
        r100.setBackgroundColor(th.a.a(getContext(), R.color.shopping_color_sale_point_line));
        r100.setVisibility(8);
        return r100;
    }

    public ECSalePointView(Context r100) {
        super(r100);
        setOrientation(0);
        TextView r101 = b(getContext());
        this.f150423a = r101;
        View r102 = getLine();
        this.f150424b = r102;
        TextView r103 = b(getContext());
        this.f150425c = r103;
        addView(r101);
        addView(r102);
        addView(r103);
    }

    public static TextView b(Context r100) {
        TextView r101 = new TextView(r100);
        r101.setTextSize(1, 12.0f);
        r101.setTextColor(th.a.a(r100, R.color.shopping_color_FF3344));
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setMaxLines(1);
        return r101;
    }

    public final void a(ECCarouselData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f150426d == false) goto L5;
        this.f150423a.setTextColor(th.a.a(getContext(), R.color.shopping_std_text_black_3));
        this.f150425c.setTextColor(th.a.a(getContext(), R.color.shopping_std_text_black_3));
        this.f150424b.setBackgroundColor(th.a.a(getContext(), R.color.shopping_std_line_black_1));
    L6:
        String r101 = r100.getBefore();
        String r102 = null;
        if (cg4.a.a(r101) == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
        this.f150423a.setVisibility(0);
        this.f150423a.setText(r101);
    L15:
        if (cg4.a.a(r100.getBefore()) == true) goto L17;
    L19:
        this.f150424b.setVisibility(8);
    L20:
        String r103 = r100.getContent();
        if (cg4.a.a(r103) == false) goto L23;
        r102 = r103;
    L23:
        if (r102 == null) goto L27;
        this.f150425c.setVisibility(0);
        this.f150425c.setText(r102);
        int r104 = s.f45717a;
        Integer r105 = s.b(r100.getColor());
        if (r105 == null) goto L29;
        this.f150425c.setTextColor(r105.intValue());
        return;
    L29:
        return;
    L27:
        this.f150425c.setVisibility(8);
        Unit r106 = Unit.INSTANCE;
        return;
    L17:
        if (cg4.a.a(r100.getContent()) == false) goto L19;
        this.f150424b.setVisibility(0);
        goto L20
    L13:
        this.f150423a.setVisibility(8);
        Unit r107 = Unit.INSTANCE;
        goto L15
    L5:
        this.f150423a.setTextColor(th.a.a(getContext(), R.color.shopping_color_FF3344));
        this.f150425c.setTextColor(th.a.a(getContext(), R.color.shopping_color_FF3344));
        this.f150424b.setBackgroundColor(th.a.a(getContext(), R.color.shopping_color_sale_point_line));
        goto L6
    }

    public ECSalePointView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setOrientation(0);
        TextView r102 = b(getContext());
        this.f150423a = r102;
        View r103 = getLine();
        this.f150424b = r103;
        TextView r104 = b(getContext());
        this.f150425c = r104;
        addView(r102);
        addView(r103);
        addView(r104);
    }

    public ECSalePointView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setOrientation(0);
        TextView r103 = b(getContext());
        this.f150423a = r103;
        View r104 = getLine();
        this.f150424b = r104;
        TextView r105 = b(getContext());
        this.f150425c = r105;
        addView(r103);
        addView(r104);
        addView(r105);
    }
}
