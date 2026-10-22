package com.android.internal.chooser.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class DarkImageDrawable extends Drawable {
    public static final ColorFilter sDarkFilter = new LightingColorFilter(15790320, 0);
    private ImageView mImageView;

    public DarkImageDrawable(ImageView imageView) {
        this.mImageView = imageView;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] state) {
        boolean pressed = false;
        int length = state.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int s = state[i];
            if (s != 16842919) {
                i++;
            } else {
                pressed = true;
                break;
            }
        }
        if (pressed) {
            this.mImageView.setColorFilter(sDarkFilter);
        } else {
            this.mImageView.setColorFilter((ColorFilter) null);
        }
        return super.onStateChange(state);
    }
}
