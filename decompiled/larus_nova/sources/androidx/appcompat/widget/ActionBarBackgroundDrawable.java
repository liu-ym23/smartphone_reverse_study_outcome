package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer r100) {
        this.mContainer = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        ActionBarContainer r101 = this.mContainer;
        if (r101.mIsSplit == false) goto L7;
        Drawable r102 = r101.mSplitBackground;
        if (r102 == null) goto L16;
        r102.draw(r100);
        return;
    L16:
        return;
    L7:
        Drawable r103 = r101.mBackground;
        if (r103 == null) goto L10;
        r103.draw(r100);
    L10:
        ActionBarContainer r104 = this.mContainer;
        Drawable r105 = r104.mStackedBackground;
        if (r105 != null) goto L13;
        return;
    L13:
        if (r104.mIsStacked == false) goto L19;
        r105.draw(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r100) {
        ActionBarContainer r101 = this.mContainer;
        if (r101.mIsSplit == false) goto L7;
        Drawable r102 = r101.mSplitBackground;
        if (r102 == null) goto L11;
        r102.getOutline(r100);
        return;
    L11:
        return;
    L7:
        Drawable r103 = r101.mBackground;
        if (r103 == null) goto L13;
        r103.getOutline(r100);
        return;
    }
}
