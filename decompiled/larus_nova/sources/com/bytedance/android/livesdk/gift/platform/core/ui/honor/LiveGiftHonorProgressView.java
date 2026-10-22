package com.bytedance.android.livesdk.gift.platform.core.ui.honor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class LiveGiftHonorProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GradientDrawable f132010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GradientDrawable f132011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GradientDrawable f132012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ClipDrawable f132013d;

    public interface a {
    }

    public void setHonorProgressCallBack(a r100) {
    }

    public final void a() {
        GradientDrawable r100 = new GradientDrawable();
        this.f132010a = r100;
        r100.setShape(0);
        if (getContext() != null) goto L5;
    L11:
        this.f132010a.setColor(s1.h(R.color.ttlive_level_honor_progress_background));
    L12:
        GradientDrawable r101 = new GradientDrawable();
        this.f132012c = r101;
        r101.setShape(0);
        this.f132012c.setColor(ColorProtector.parseColor("#55ffffff"));
        Drawable r102 = s1.m(R.drawable.ttlive_bg_honor_progress_add);
        if ((r102 instanceof ClipDrawable) == false) goto L15;
        this.f132013d = (ClipDrawable) r102;
    L15:
        Drawable r103 = s1.m(R.drawable.ttlive_bg_honor_progress_highlight);
        if ((r103 instanceof GradientDrawable) == false) goto L18;
        this.f132011b = (GradientDrawable) r103;
        return;
    L18:
        GradientDrawable r104 = new GradientDrawable();
        this.f132011b = r104;
        r104.setColor(ColorProtector.parseColor("#face15"));
        this.f132011b.setShape(0);
        return;
    L5:
        if (getContext().getResources() == null) goto L11;
        if (getContext().getResources().getConfiguration() == null) goto L11;
        if (getContext().getResources().getConfiguration().orientation != 2) goto L11;
        this.f132010a.setColor(ColorProtector.parseColor("#161823"));
        goto L12
    }

    private int getHighlightHeight() {
        return s1.j(R.dimen.ttlive_gift_honor_level_progress_highlight_height);
    }

    private int getHighlightMargin() {
        return s1.j(R.dimen.ttlive_gift_honor_level_progress_highlight_margin);
    }

    private int getHighlightWidth() {
        return getWidth() - (s1.j(R.dimen.ttlive_gift_honor_level_progress_highlight_margin) * 2);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public LiveGiftHonorProgressView(Context r100) {
        super(r100);
        new ArrayList();
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        this.f132010a.setCornerRadius(getHeight() / 2);
        this.f132010a.setBounds(0, 0, getWidth(), getHeight());
        this.f132011b.setBounds(getHighlightMargin(), getHighlightMargin(), ((int) (getHighlightWidth() * 0.0f)) + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
        this.f132011b.setCornerRadius(getHighlightHeight() / 2);
        this.f132012c.setBounds(0, 0, (int) (getWidth() * 0.0f), getHeight());
        this.f132012c.setCornerRadius(getHeight() / 2);
        ClipDrawable r101 = this.f132013d;
        if (r101 == null) goto L5;
        r101.setBounds(getHighlightMargin(), getHighlightMargin(), getHighlightWidth() + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
        this.f132013d.setLevel((int) 0.0f);
    L5:
        this.f132010a.draw(r100);
        this.f132011b.draw(r100);
    }

    public LiveGiftHonorProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        new ArrayList();
        a();
    }

    public LiveGiftHonorProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new ArrayList();
        a();
    }
}
