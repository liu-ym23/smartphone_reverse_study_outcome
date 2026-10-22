package com.bytedance.android.gamecp.business.floatwindow.installguide.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class DotsView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ImageView> f53197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53200d;

    public final void a(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f53198b) goto L9;
        if (r101 != r100) goto L7;
        int r102 = this.f53199c;
    L8:
        Drawable r103 = y0.e(r102);
        ((ImageView) ListProtector.get(this.f53197a, r101)).setImageDrawable(r103);
        r101 = r101 + 1;
        goto L4
    L7:
        r102 = this.f53200d;
        goto L8
    }

    public void setNumberOfPage(int r100) {
        this.f53198b = r100;
        this.f53197a = new ArrayList();
        int r101 = 0;
    L4:
        if (r101 >= this.f53198b) goto L6;
        ImageView r102 = new ImageView(getContext());
        r102.setImageDrawable(y0.e(this.f53200d));
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.leftMargin = y0.b(6.0f);
        addView(r102, r103);
        this.f53197a.add(r102);
        r101 = r101 + 1;
        goto L4
    L6:
        a(0);
    }

    public DotsView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f53198b = 0;
    }
}
