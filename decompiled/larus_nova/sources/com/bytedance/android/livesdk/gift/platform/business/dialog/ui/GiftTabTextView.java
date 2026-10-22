package com.bytedance.android.livesdk.gift.platform.business.dialog.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.livesdk.gift.configmodel.l;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import nz1.a;

/* JADX INFO: loaded from: classes9.dex */
public class GiftTabTextView extends RelativeLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f126605h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f126606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewSwitcher f126607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f126608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f126609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f126610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObjectAnimator f126611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f126612g;

    public final void a() {
        Disposable r100 = this.f126612g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.f126612g.dispose();
    L7:
        this.f126612g = null;
    }

    public String getText() {
        TextView r100 = this.f126606a;
        if (r100 != null) goto L5;
        ViewSwitcher r101 = this.f126607b;
        if (r101 != null) goto L9;
        return "";
    L9:
        if (r101.getChildCount() > 0) goto L11;
        return "";
    L11:
        if ((this.f126607b.getChildAt(0) instanceof TextView) == true) goto L13;
        return "";
    L13:
        return ((TextView) this.f126607b.getChildAt(0)).getText().toString();
    L5:
        return r100.getText().toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public GiftTabTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.RelativeLayout
    public void setGravity(int r100) {
        TextView r101 = this.f126606a;
        if (r101 == null) goto L5;
        r101.setGravity(r100);
        return;
    L5:
        ViewSwitcher r102 = this.f126607b;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.f126607b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.f126607b.getChildAt(0)).setGravity(r100);
        return;
    }

    public void setIsNeedSort(Boolean r100) {
        if (r100.booleanValue() == false) goto L5;
        this.f126609d.setVisibility(0);
        return;
    L5:
        this.f126609d.setVisibility(8);
    }

    public void setIsNeedTopicLabel(Boolean r100) {
        if (this.f126610e != null) goto L5;
        return;
    L5:
        if (r100.booleanValue() == false) goto L7;
        this.f126610e.setVisibility(0);
        return;
    L7:
        this.f126610e.setVisibility(8);
    }

    public void setOrderView(int r100) {
        this.f126609d.setBackgroundResource(r100);
    }

    public void setStatus(int r100) {
        if (r100 != 0) goto L5;
        this.f126609d.setBackgroundResource(R.drawable.ttlive_gift_default_sort_order);
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f126609d.setBackgroundResource(R.drawable.ttlive_gift_ascending_order);
        return;
    L7:
        this.f126609d.setBackgroundResource(R.drawable.ttlive_gift_descending_order);
    }

    public void setText(String r100) {
        TextView r101 = this.f126606a;
        if (r101 == null) goto L5;
        r101.setText(r100);
        return;
    L5:
        ViewSwitcher r102 = this.f126607b;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.f126607b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.f126607b.getChildAt(0)).setText(r100);
        return;
    }

    public void setTextColor(boolean r100) {
        if (getText().equals("嘉年华") == true) goto L5;
        Pair r101 = (Pair) b.a().c(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, new Pair(Integer.valueOf(R.color.ttlive_gift_bottom_tab_selected_color), Integer.valueOf(R.color.ttlive_gift_bottom_tab_normal_color)));
        Resources r102 = getContext().getResources();
        if (r100 == false) goto L13;
        Object r103 = r101.getFirst();
    L14:
        setTextColor(r102.getColor(((Integer) r103).intValue()));
        return;
    L13:
        r103 = r101.getSecond();
        goto L14
    L5:
        if (r100 == false) goto L7;
        int r104 = ColorProtector.parseColor(((l) a.V.getValue(null, a.f521324a[46])).a());
    L8:
        setTextColor(r104);
        return;
    L7:
        r104 = ColorProtector.parseColor(((l) a.V.getValue(null, a.f521324a[46])).b());
        goto L8
    }

    public void setTextSize(float r100) {
        TextView r101 = this.f126606a;
        if (r101 == null) goto L5;
        r101.setTextSize(1, r100);
        return;
    L5:
        ViewSwitcher r102 = this.f126607b;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.f126607b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.f126607b.getChildAt(0)).setTextSize(1, r100);
        return;
    }

    public void setTopicLabelBackground(int r100) {
        View r101 = this.f126610e;
        if (r101 == null) goto L6;
        r101.setBackgroundResource(r100);
        return;
    }

    public void setTopicViewRotation(float r100) {
        View r101 = this.f126610e;
        if (r101 == null) goto L6;
        r101.setRotation(r100);
        return;
    }

    public void setTextColor(int r100) {
        TextView r101 = this.f126606a;
        if (r101 == null) goto L5;
        r101.setTextColor(r100);
        return;
    L5:
        ViewSwitcher r102 = this.f126607b;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.f126607b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.f126607b.getChildAt(0)).setTextColor(r100);
        return;
    }

    public GiftTabTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void b(Float r100, Float r101) {
        ObjectAnimator r102 = this.f126611f;
        if (r102 != null) goto L5;
    L7:
        View r103 = this.f126610e;
        if (r103 != null) goto L10;
        return;
    L10:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r103, "rotation", new float[]{r100.floatValue(), r101.floatValue()});
        this.f126611f = r104;
        r104.setDuration(250);
        this.f126611f.start();
        return;
    L5:
        if (r102.isRunning() == false) goto L7;
        this.f126611f.cancel();
        goto L7
    }

    public GiftTabTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater r103 = LayoutInflater.from(r100);
        if (v.d() == false) goto L5;
        int r104 = R.layout.ttlive_gift_panel_tab_item_layout_with_scroll;
    L6:
        View r105 = r103.inflate(r104, this);
        this.f126606a = (TextView) r105.findViewById(R.id.prop_tv);
        this.f126607b = (ViewSwitcher) r105.findViewById(R.id.tab_name_switcher);
        this.f126608c = r105.findViewById(R.id.prop_panel_red_point);
        this.f126609d = r105.findViewById(R.id.sort_order_view);
        this.f126610e = r105.findViewById(R.id.topic_label_view);
        ViewSwitcher r106 = this.f126607b;
        if (r106 == null) goto L9;
        r106.setAnimateFirstView(false);
    L9:
        View r107 = this.f126609d;
        if (r107 != null) goto L12;
        return;
    L12:
        if ((r107.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L16;
        RelativeLayout.LayoutParams r108 = (RelativeLayout.LayoutParams) this.f126609d.getLayoutParams();
        r108.addRule(13, -1);
        this.f126609d.setLayoutParams(r108);
        return;
    L16:
        return;
    L5:
        r104 = R.layout.ttlive_prop_tv_layout;
        goto L6
    }
}
