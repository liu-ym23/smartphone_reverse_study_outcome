package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class RtlViewPagerShower extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ImageView> f112522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f112523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f112524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f112525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout.LayoutParams f112526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f112527f;

    public final void b(int r100) {
        ArrayList<ImageView> r101 = this.f112522a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L27;
        int r102 = this.f112523b;
        if (r102 >= 0) goto L10;
    L15:
        if (r100 >= 0) goto L17;
        return;
    L17:
        if (r100 < this.f112522a.size()) goto L19;
        return;
    L19:
        if (this.f112525d == null) goto L21;
        ((ImageView) ListProtector.get(this.f112522a, r100)).setImageDrawable(this.f112525d);
    L22:
        this.f112523b = r100;
        return;
    L21:
        ((ImageView) ListProtector.get(this.f112522a, r100)).setImageResource(R.drawable.ttlive_dot_colour);
        goto L22
    L10:
        if (r102 >= this.f112522a.size()) goto L15;
        if (this.f112524c == null) goto L14;
        ((ImageView) ListProtector.get(this.f112522a, this.f112523b)).setImageDrawable(this.f112524c);
        goto L15
    L14:
        ((ImageView) ListProtector.get(this.f112522a, this.f112523b)).setImageResource(R.drawable.ttlive_dot_gray);
        goto L15
    }

    public void setMargin(int r100) {
        this.f112527f = r100;
    }

    public RtlViewPagerShower(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f112522a = new ArrayList();
        this.f112523b = -1;
        this.f112526e = new LinearLayout.LayoutParams(-2, -2);
        this.f112527f = -1;
    }

    public final void a(int r100, int r101) {
        removeAllViews();
        this.f112522a.clear();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L16;
        ImageView r103 = new ImageView(getContext());
        Drawable r104 = this.f112524c;
        if (r104 == null) goto L7;
        r103.setImageDrawable(r104);
    L9:
        if (r102 >= (r100 - 1)) goto L14;
        int r105 = this.f112527f;
        if (r105 != (-1)) goto L13;
        r105 = (int) getContext().getResources().getDimension(R.dimen.ttlive_gift_pager_shower_margin);
    L13:
        this.f112526e.setMargins(0, 0, r105, 0);
        this.f112526e.setMarginStart(0);
        this.f112526e.setMarginEnd(r105);
        addView(r103, this.f112526e);
    L15:
        this.f112522a.add(r103);
        r102 = r102 + 1;
        goto L3
    L14:
        addView(r103);
        goto L15
    L7:
        r103.setImageResource(R.drawable.ttlive_dot_gray);
        goto L9
    L16:
        b(r101);
    }

    public RtlViewPagerShower(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f112522a = new ArrayList();
        this.f112523b = -1;
        this.f112526e = new LinearLayout.LayoutParams(-2, -2);
        this.f112527f = -1;
    }
}
