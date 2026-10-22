package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityTime;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/CountDownLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountDownLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f170142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TextView> f170143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TextView> f170144c;

    public CountDownLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CountDownLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f170142a != null) goto L5;
        this.f170142a = new LinkedHashMap();
    L5:
        View r101 = this.f170142a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f170142a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(ActivityTime r110) {
        if (r110 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        int r100 = c2.f45564h;
        c2 r101 = c2.a.a(getContext(), TimeUnit.SECONDS.toMillis(r110.getEndTime() - (System.currentTimeMillis() / 1000)), false);
        TextElementView r102 = (TextElementView) a(R.id.activity_time_prefix);
        if (r102 == null) goto L9;
        r102.setVisibility(8);
    L9:
        TextElement r103 = r110.getActivityDesc();
        if (r103 == null) goto L18;
        TextElementView r104 = (TextElementView) a(R.id.activity_time_prefix);
        if (r104 == null) goto L14;
        r104.x(r103);
    L14:
        TextElementView r105 = (TextElementView) a(R.id.activity_time_prefix);
        if (r105 == null) goto L18;
        r105.setVisibility(0);
    L18:
        if (r101.f45565a <= 0) goto L40;
        TextView r106 = (TextView) a(R.id.activity_countdown_day);
        if (r106 == null) goto L22;
        r106.setText(r101.f45566b);
    L22:
        String r107 = r101.f45566b;
        if (r107 == null) goto L25;
        int r108 = r107.length();
    L27:
        if (r108 < 3) goto L31;
        TextView r109 = (TextView) a(R.id.activity_countdown_day);
        if (r109 == null) goto L34;
        r109.setPadding(com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(0));
    L34:
        TextView r111 = (TextView) a(R.id.activity_countdown_day);
        if (r111 == null) goto L37;
        r111.setVisibility(0);
    L37:
        TextView r112 = (TextView) a(R.id.activity_countdown_day_label);
        if (r112 == null) goto L46;
        r112.setVisibility(0);
    L46:
        TextView r113 = (TextView) a(R.id.activity_countdown_hours);
        if (r113 == null) goto L49;
        r113.setText(r101.f45567c);
    L49:
        TextView r114 = (TextView) a(R.id.activity_countdown_hours);
        if (r114 == null) goto L52;
        r114.setVisibility(0);
    L52:
        TextView r115 = (TextView) a(R.id.activity_countdown_category_between_hours_and_min);
        if (r115 == null) goto L55;
        r115.setVisibility(0);
    L55:
        TextView r116 = (TextView) a(R.id.activity_countdown_min);
        if (r116 == null) goto L58;
        r116.setText(r101.f45568d);
    L58:
        TextView r117 = (TextView) a(R.id.activity_countdown_min);
        if (r117 == null) goto L61;
        r117.setVisibility(0);
    L61:
        TextView r118 = (TextView) a(R.id.activity_countdown_category_between_min_and_sec);
        if (r118 == null) goto L64;
        r118.setVisibility(0);
    L64:
        TextView r119 = (TextView) a(R.id.activity_countdown_sec);
        if (r119 == null) goto L67;
        r119.setText(r101.f45569e);
    L67:
        TextView r120 = (TextView) a(R.id.activity_countdown_sec);
        if (r120 == null) goto L70;
        r120.setVisibility(0);
    L70:
        FontStyle r121 = r110.getCountDownTextStyle();
        if (r121 == null) goto L85;
        Iterator<T> r122 = this.f170143b.iterator();
    L74:
        if (r122.hasNext() == false) goto L85;
        TextView r123 = (TextView) r122.next();
        if (r123 == null) goto L74;
        r123.setTextSize(r121.getFontSize());
        if (r121.getLine() < 1) goto L81;
        int r124 = r121.getLine();
    L82:
        r123.setMaxLines(r124);
        r123.setEllipsize(TextUtils.TruncateAt.END);
        r123.setTextColor(com.bytedance.android.shopping.extensions.a.a(r121.getTextColor(), 0));
        if (r121.getFontWeight() < 500) goto L74;
        r123.setTypeface(r123.getTypeface(), 1);
        goto L74
    L81:
        r124 = Integer.MAX_VALUE;
    L85:
        final String r125 = r110.getCountDownTextBgColor();
        if (r125 == null) goto L94;
        Iterator<T> r126 = this.f170144c.iterator();
    L89:
        if (r126.hasNext() == false) goto L107;
        TextView r127 = (TextView) r126.next();
        if (r127 == null) goto L89;
        r127.setBackgroundDrawable(com.bytedance.commerce.base.drawable.a.a(new CountDownLayout$bindNumViewBgColor$bgDrawable$1(r125)));
        goto L89
    L107:
        return;
    L94:
        return;
    L31:
        TextView r128 = (TextView) a(R.id.activity_countdown_day);
        if (r128 == null) goto L34;
        r128.setPadding(com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(0));
        goto L34
    L25:
        r108 = 0;
        goto L27
    L40:
        TextView r129 = (TextView) a(R.id.activity_countdown_day);
        if (r129 == null) goto L43;
        r129.setVisibility(8);
    L43:
        TextView r130 = (TextView) a(R.id.activity_countdown_day_label);
        if (r130 == null) goto L46;
        r130.setVisibility(8);
        goto L46
    }

    public CountDownLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f170142a = new LinkedHashMap();
        FrameLayout.inflate(r110, R.layout.shopping_anchor_v4_countdown_layout, this);
        this.f170143b = CollectionsKt.listOf(new TextView[]{(TextView) a(R.id.activity_countdown_day), (TextView) a(R.id.activity_countdown_day_label), (TextView) a(R.id.activity_countdown_hours), (TextView) a(R.id.activity_countdown_category_between_hours_and_min), (TextView) a(R.id.activity_countdown_min), (TextView) a(R.id.activity_countdown_category_between_min_and_sec), (TextView) a(R.id.activity_countdown_sec)});
        this.f170144c = CollectionsKt.listOf(new TextView[]{(TextView) a(R.id.activity_countdown_day), (TextView) a(R.id.activity_countdown_hours), (TextView) a(R.id.activity_countdown_min), (TextView) a(R.id.activity_countdown_sec)});
    }

    public /* synthetic */ CountDownLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
