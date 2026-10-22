package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
interface CardViewDelegate {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable drawable);

    void setMinWidthHeightInternal(int i, int i6);

    void setShadowPadding(int i, int i6, int i10, int i11);
}
