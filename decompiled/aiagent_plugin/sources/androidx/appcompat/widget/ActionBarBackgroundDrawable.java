package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    private static class a {
        public static void a(Drawable r0, Outline r1) {
            r0.getOutline(r1);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer r1) {
        this.mContainer = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (this.mContainer.mIsSplit == false) goto L8;
        if (this.mContainer.mSplitBackground == null) goto L16;
        this.mContainer.mSplitBackground.draw(r2);
        return;
    L16:
        return;
    L8:
        if (this.mContainer.mBackground == null) goto L11;
        this.mContainer.mBackground.draw(r2);
    L11:
        if (this.mContainer.mStackedBackground != null) goto L13;
        return;
    L13:
        if (this.mContainer.mIsStacked == false) goto L19;
        this.mContainer.mStackedBackground.draw(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r2) {
        if (this.mContainer.mIsSplit == false) goto L8;
        if (this.mContainer.mSplitBackground == null) goto L11;
        a.a(this.mContainer.mBackground, r2);
        return;
    L11:
        return;
    L8:
        if (this.mContainer.mBackground == null) goto L13;
        a.a(this.mContainer.mBackground, r2);
        return;
    }
}
