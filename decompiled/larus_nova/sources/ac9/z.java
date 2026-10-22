package ac9;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.home.api.feed.FlowFeedActionScene;
import com.larus.nova.R;
import com.skydoves.balloon.Balloon;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class z extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final eb9.o<?> f2812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowFeedActionScene f2813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<eb9.d, eb9.c, Unit> f2814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Function0<Unit>, Unit> f2815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Balloon f2817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f2818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2819h;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Balloon r100 = this.f2817f;
        if (r100 == null) goto L5;
        r100.h();
    L5:
        this.f2817f = null;
        this.f2818g = null;
        super.onDetachedFromWindow();
    }

    public final LinearLayout a(eb9.k r100) {
        LinearLayout r101 = new LinearLayout(getContext());
        r101.setLayoutParams(new LinearLayout.LayoutParams(this.f2816e, e(R.attr.larus_dp_48, R.dimen.larus_dp_48)));
        r101.setGravity(16);
        r101.setOrientation(0);
        r101.setPaddingRelative(e(R.attr.larus_dp_16, R.dimen.larus_dp_16), 0, e(R.attr.larus_dp_16, R.dimen.larus_dp_16), 0);
        r101.setClickable(true);
        r101.setFocusable(true);
        if (r100.a(this.f2812a) == false) goto L5;
        float r102 = 1.0f;
    L6:
        r101.setAlpha(r102);
        eb9.o<?> r103 = this.f2812a;
        Intrinsics.checkNotNullParameter(r103, BrowserDependency.UrlClickType.CARD);
        Integer r104 = r100.f471886c.invoke(r103);
        if (r104 == null) goto L9;
        r101.setBackgroundResource(r104.intValue());
    L9:
        return r101;
    L5:
        r102 = 0.5f;
        goto L6
    }

    public final TextView b(eb9.k r100) {
        TextView r101 = new TextView(getContext());
        eb9.o<?> r102 = this.f2812a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, BrowserDependency.UrlClickType.CARD);
        r101.setText(r100.f471884a.invoke(r102).a(r101.getContext()));
        eb9.o<?> r103 = this.f2812a;
        Intrinsics.checkNotNullParameter(r103, BrowserDependency.UrlClickType.CARD);
        Integer r104 = r100.f471887d.invoke(r103);
        if (r104 == null) goto L5;
        int r105 = Integer.valueOf(ContextCompat.getColor(r101.getContext(), r104.intValue())).intValue();
    L6:
        r101.setTextColor(r105);
        r101.setTextSize(0, e(R.attr.larus_dp_16, R.dimen.larus_dp_16));
        if (Build.VERSION.SDK_INT < 28) goto L9;
        Typeface r106 = Typeface.create(Typeface.create("sans-serif-medium", 0), 500, false);
    L10:
        r101.setTypeface(r106);
        r101.setGravity(16);
        r101.setMaxLines(1);
        return r101;
    L9:
        r106 = Typeface.create("sans-serif-medium", 0);
        goto L10
    L5:
        r105 = d(R.attr.larus_neutral_100, R.color.larus_neutral_100);
        goto L6
    }

    public final void f(boolean r100) {
        if (r100 == true) goto L7;
        View r101 = this.f2818g;
        if (r101 == null) goto L18;
        r101.setVisibility(8);
        return;
    L18:
        return;
    L7:
        ViewParent r102 = getParent();
        if ((r102 instanceof FrameLayout) == false) goto L10;
        FrameLayout r103 = (FrameLayout) r102;
    L11:
        if (r103 != null) goto L13;
        return;
    L13:
        View r104 = this.f2818g;
        if (r104 != null) goto L16;
        r104 = new View(getContext());
        r104.setBackgroundResource(v19.c.b(R.attr.larus_fg_common_menu_mask, r104.getContext(), R.drawable.larus_fg_common_menu_mask));
        r104.setAlpha(0.5f);
        r104.setOnClickListener(new y(this));
        this.f2818g = r104;
        r103.addView(r104);
    L16:
        r104.setLayoutParams(new FrameLayout.LayoutParams(getWidth(), getHeight()));
        r104.setX(getX());
        r104.setY(getY());
        r104.setVisibility(0);
        return;
    L10:
        r103 = null;
        goto L11
    }

    public final void c(final eb9.d r100, final eb9.c r101) {
        if (this.f2819h == false) goto L5;
        return;
    L5:
        this.f2819h = true;
        this.f2815d.invoke(new t(this, r100, r101));
    }

    public final int d(int r100, int r101) {
        return ContextCompat.getColor(getContext(), v19.c.b(r100, getContext(), r101));
    }

    public final int e(int r100, int r101) {
        return getResources().getDimensionPixelSize(v19.c.b(r100, getContext(), r101));
    }

    public z(Context r110, eb9.o r111, FlowFeedActionScene r112, List r210, Function2 r211, b0 r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r112, "scene");
        Intrinsics.checkNotNullParameter(r210, "actionItems");
        Intrinsics.checkNotNullParameter(r211, "onAction");
        Intrinsics.checkNotNullParameter(r212, "closeMenu");
        super(r110);
        this.f2812a = r111;
        this.f2813b = r112;
        this.f2814c = r211;
        this.f2815d = r212;
        int r100 = e(R.attr.larus_dp_224, R.dimen.larus_dp_224);
        this.f2816e = r100;
        int r101 = 1;
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(r100, -2));
        setMinimumWidth(r100);
        setBackgroundResource(v19.c.b(R.attr.larus_bg_sidebar_conversation_menu, r110, R.drawable.larus_bg_sidebar_conversation_menu));
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r210.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        String r105 = ((eb9.d) r104).a();
        Object r106 = r102.get(r105);
        if (r106 != null) goto L8;
        r106 = new ArrayList();
        r102.put(r105, r106);
    L8:
        ((List) r106).add(r104);
        goto L4
    L9:
        Iterator r107 = r102.values().iterator();
        int r108 = 0;
        int r109 = 0;
    L11:
        if (r107.hasNext() == false) goto L48;
        Object r113 = r107.next();
        int r114 = r109 + 1;
        if (r109 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        List r115 = (List) r113;
        int r116 = -1;
        int r117 = R.dimen.larus_dp_8;
        if (r109 <= 0) goto L18;
        View r118 = new View(getContext());
        r118.setLayoutParams(new LinearLayout.LayoutParams(-1, e(R.attr.larus_dp_8, R.dimen.larus_dp_8)));
        r118.setBackgroundColor(d(R.attr.larus_neutral_transparent_1, R.color.larus_neutral_transparent_1));
        addView(r118);
    L18:
        Iterator r119 = r115.iterator();
        int r120 = 0;
    L20:
        if (r119.hasNext() == false) goto L47;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        eb9.d r123 = (eb9.d) r121;
        if (r120 <= 0) goto L32;
        int r124 = v19.c.b(R.attr.larus_common_menu_divider, getContext(), R.drawable.larus_common_menu_divider);
        Drawable r125 = AppCompatResources.getDrawable(getContext(), r124);
        if (r125 == null) goto L29;
        int r126 = RangesKt.coerceAtLeast(r125.getIntrinsicHeight(), r101);
    L30:
        View r127 = new View(getContext());
        r127.setLayoutParams(new LinearLayout.LayoutParams(r116, r126));
        r127.setBackgroundResource(r124);
        addView(r127);
        goto L32
    L29:
        r126 = 1;
    L32:
        if ((r123 instanceof eb9.d.b) == false) goto L36;
        final eb9.d.b r128 = (eb9.d.b) r123;
        LinearLayout r129 = a(r128.f471864b);
        r129.addView(b(r128.f471864b), new LinearLayout.LayoutParams(r108, r116, 1.0f));
        TextView r130 = new TextView(r129.getContext());
        r130.setText(r128.f471865c.invoke(this.f2812a).a(r130.getContext()));
        r130.setTextColor(d(R.attr.larus_neutral_50, R.color.larus_neutral_50));
        r130.setTextSize(r108, e(R.attr.larus_dp_16, R.dimen.larus_dp_16));
        r130.setGravity(16);
        r130.setMaxLines(r101);
        r129.addView(r130);
        ImageView r131 = new ImageView(r129.getContext());
        r131.setImageResource(v19.c.b(R.attr.larus_icon_menu_expand, r131.getContext(), R.drawable.larus_icon_menu_expand));
        LinearLayout.LayoutParams r132 = new LinearLayout.LayoutParams(e(R.attr.larus_dp_14, R.dimen.larus_dp_14), e(R.attr.larus_dp_14, R.dimen.larus_dp_14));
        r132.setMarginStart(e(R.attr.larus_dp_8, r117));
        r131.setLayoutParams(r132);
        r129.addView(r131);
        r129.setOnClickListener(new s(r128, this));
        addView(r129);
    L44:
        r120 = r122;
        r108 = 0;
        r101 = 1;
        r116 = -1;
        r117 = R.dimen.larus_dp_8;
        goto L20
    L36:
        if ((r123 instanceof eb9.d.C5763d) == false) goto L39;
        final eb9.d.C5763d r133 = (eb9.d.C5763d) r123;
        LinearLayout r134 = a(r133.f471873b);
        r134.addView(b(r133.f471873b), new LinearLayout.LayoutParams(0, r116, 1.0f));
        e(R.attr.larus_dp_35, R.dimen.larus_dp_35);
        final CustomSwitchCompat r135 = new CustomSwitchCompat(r134.getContext(), null);
        r135.setShowText(false);
        r135.setSplitTrack(false);
        r135.setBackground(null);
        r135.setGravity(17);
        r135.setMinimumWidth(0);
        r135.setMinimumHeight(0);
        r135.setMinWidth(0);
        r135.setMinHeight(0);
        r135.setPadding(0, 0, 0, 0);
        r135.setTrackResource(v19.c.b(R.attr.larus_bg_switch_track_widget, r135.getContext(), R.drawable.larus_bg_switch_track_widget));
        r135.setThumbResource(R.drawable.larus_bg_switch_thumb_widget);
        r135.setChecked(r133.f471874c.invoke(this.f2812a).booleanValue());
        r135.setEnabled(r133.f471873b.a(this.f2812a));
        r135.setLayoutParams(new LinearLayout.LayoutParams(-2, e(R.attr.larus_dp_22, R.dimen.larus_dp_22)));
        r135.setOnCheckedChangeListener(new o(this, r133));
        r134.addView(r135);
        r134.setOnClickListener(new q(r133, this, r135));
        addView(r134);
        goto L44
    L39:
        if ((r123 instanceof eb9.d.a) == false) goto L46;
        final eb9.d.a r136 = (eb9.d.a) r123;
        LinearLayout r137 = a(r136.f471860b);
        r137.addView(b(r136.f471860b), new LinearLayout.LayoutParams(0, r116, 1.0f));
        eb9.k r138 = r136.f471860b;
        eb9.o<?> r139 = this.f2812a;
        r138.getClass();
        Intrinsics.checkNotNullParameter(r139, BrowserDependency.UrlClickType.CARD);
        Integer r140 = r138.f471885b.invoke(r139);
        if (r140 == null) goto L43;
        int r141 = r140.intValue();
        ImageView r142 = new ImageView(r137.getContext());
        r142.setImageResource(r141);
        r142.setLayoutParams(new LinearLayout.LayoutParams(e(R.attr.larus_dp_20, R.dimen.larus_dp_20), e(R.attr.larus_dp_20, R.dimen.larus_dp_20)));
        r137.addView(r142);
    L43:
        r137.setOnClickListener(new r(this, r136));
        addView(r137);
        goto L44
    L46:
        throw new NoWhenBranchMatchedException();
    L47:
        r109 = r114;
        goto L11
    }
}
