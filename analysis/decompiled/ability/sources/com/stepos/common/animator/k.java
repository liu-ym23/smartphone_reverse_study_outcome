package com.stepos.common.animator;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class k implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3568a;
    public final /* synthetic */ float b;
    public final /* synthetic */ int c;
    public final /* synthetic */ m d;

    public k(m mVar, View view, float f, int i) {
        this.d = mVar;
        this.f3568a = view;
        this.b = f;
        this.c = i;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f7) {
        float f9 = f / 100.0f;
        View view = this.f3568a;
        if (view.getTag(R.id.press_anim_tag) == null) {
            view.setScaleY(f9);
            view.setScaleX(f9);
            return;
        }
        int iIntValue = ((Integer) view.getTag(R.id.press_anim_tag)).intValue();
        if ((iIntValue & 1) != 0) {
            view.setScaleY(f9);
            view.setScaleX(f9);
        }
        if ((iIntValue & 2) != 0) {
            int i = (int) (((float) (((1.0f - f9) / 0.05d) * this.b)) * 255.0f);
            this.d.getClass();
            int i6 = this.c;
            int iArgb = Color.argb(i, Color.red(i6), Color.green(i6), Color.blue(i6));
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
            view.setAlpha(1.0f - ((float) (((1.0f - f9) / 0.05d) * 0.4000000059604645d)));
        }
    }
}
