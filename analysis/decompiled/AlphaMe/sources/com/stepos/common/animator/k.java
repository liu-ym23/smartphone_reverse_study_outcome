package com.stepos.common.animator;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class k implements W.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f11301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f11302b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11303c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f11304d;

    public k(m mVar, View view, float f4, int i4) {
        this.f11304d = mVar;
        this.f11301a = view;
        this.f11302b = f4;
        this.f11303c = i4;
    }

    @Override // W.j
    public final void a(float f4) {
        float f5 = f4 / 100.0f;
        View view = this.f11301a;
        if (view.getTag(R.id.press_anim_tag) == null) {
            view.setScaleY(f5);
            view.setScaleX(f5);
            return;
        }
        int iIntValue = ((Integer) view.getTag(R.id.press_anim_tag)).intValue();
        if ((iIntValue & 1) != 0) {
            view.setScaleY(f5);
            view.setScaleX(f5);
        }
        if ((iIntValue & 2) != 0) {
            int i4 = (int) (((float) (((1.0f - f5) / 0.05d) * this.f11302b)) * 255.0f);
            this.f11304d.getClass();
            int i5 = this.f11303c;
            int iArgb = Color.argb(i4, Color.red(i5), Color.green(i5), Color.blue(i5));
            if (view instanceof ImageView) {
                ((ImageView) view).setColorFilter(iArgb, PorterDuff.Mode.SRC_ATOP);
            } else {
                Drawable background = view.getBackground();
                if (background != null) {
                    background.setColorFilter(iArgb, PorterDuff.Mode.SRC_ATOP);
                }
            }
        }
        if ((iIntValue & 4) != 0) {
            view.setAlpha(1.0f - ((float) (((1.0f - f5) / 0.05d) * 0.4000000059604645d)));
        }
    }
}
