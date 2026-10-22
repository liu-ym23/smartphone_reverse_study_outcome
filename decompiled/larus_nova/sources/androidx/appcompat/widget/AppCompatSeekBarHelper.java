package androidx.appcompat.widget;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private PorterDuff.Mode mTickMarkTintMode;
    private final SeekBar mView;

    private void applyTickMarkTint() {
        Drawable r100 = this.mTickMark;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mHasTickMarkTint == false) goto L7;
    L8:
        Drawable r101 = DrawableCompat.wrap(r100.mutate());
        this.mTickMark = r101;
        if (this.mHasTickMarkTint == false) goto L12;
        DrawableCompat.setTintList(r101, this.mTickMarkTintList);
    L12:
        if (this.mHasTickMarkTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
    L15:
        if (this.mTickMark.isStateful() == false) goto L20;
        this.mTickMark.setState(this.mView.getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTickMarkTintMode == true) goto L8;
    }

    public void drawableStateChanged() {
        Drawable r100 = this.mTickMark;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == true) goto L7;
        return;
    L7:
        if (r100.setState(this.mView.getDrawableState()) == false) goto L12;
        this.mView.invalidateDrawable(r100);
        return;
    }

    public void jumpDrawablesToCurrentState() {
        Drawable r100 = this.mTickMark;
        if (r100 == null) goto L6;
        r100.jumpToCurrentState();
        return;
    }

    public Drawable getTickMark() {
        return this.mTickMark;
    }

    public ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    public PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    public AppCompatSeekBarHelper(SeekBar r100) {
        super(r100);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = r100;
    }

    public void drawTickMarks(Canvas r100) {
        if (this.mTickMark == null) goto L18;
        int r101 = this.mView.getMax();
        int r102 = 1;
        if (r101 <= 1) goto L19;
        int r103 = this.mTickMark.getIntrinsicWidth();
        int r104 = this.mTickMark.getIntrinsicHeight();
        if (r103 < 0) goto L9;
        int r105 = r103 / 2;
    L10:
        if (r104 < 0) goto L12;
        r102 = r104 / 2;
    L12:
        this.mTickMark.setBounds(-r105, -r102, r105, r102);
        float r106 = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / r101;
        int r107 = r100.save();
        r100.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
        int r108 = 0;
    L13:
        if (r108 > r101) goto L15;
        this.mTickMark.draw(r100);
        r100.translate(r106, 0.0f);
        r108 = r108 + 1;
        goto L13
    L15:
        r100.restoreToCount(r107);
        return;
    L9:
        r105 = 1;
        goto L10
    L19:
        return;
    }

    public void setTickMark(Drawable r100) {
        Drawable r101 = this.mTickMark;
        if (r101 == null) goto L5;
        r101.setCallback(null);
    L5:
        this.mTickMark = r100;
        if (r100 == null) goto L11;
        r100.setCallback(this.mView);
        DrawableCompat.setLayoutDirection(r100, ViewCompat.getLayoutDirection(this.mView));
        if (r100.isStateful() == false) goto L10;
        r100.setState(this.mView.getDrawableState());
    L10:
        applyTickMarkTint();
    L11:
        this.mView.invalidate();
    }

    public void setTickMarkTintList(ColorStateList r100) {
        this.mTickMarkTintList = r100;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    public void setTickMarkTintMode(PorterDuff.Mode r100) {
        this.mTickMarkTintMode = r100;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void loadFromAttributes(AttributeSet r110, int r111) {
        super.loadFromAttributes(r110, r111);
        TintTypedArray r100 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r110, new int[]{R.attr.thumb, com.larus.nova.R.attr.tickMark, com.larus.nova.R.attr.tickMarkTint, com.larus.nova.R.attr.tickMarkTintMode}, r111, 0);
        SeekBar r101 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r101, r101.getContext(), new int[]{R.attr.thumb, com.larus.nova.R.attr.tickMark, com.larus.nova.R.attr.tickMarkTint, com.larus.nova.R.attr.tickMarkTintMode}, r110, r100.getWrappedTypeArray(), r111, 0);
        Drawable r112 = r100.getDrawableIfKnown(0);
        if (r112 == null) goto L5;
        this.mView.setThumb(r112);
    L5:
        setTickMark(r100.getDrawable(1));
        if (r100.hasValue(3) == false) goto L9;
        this.mTickMarkTintMode = DrawableUtils.parseTintMode(r100.getInt(3, -1), this.mTickMarkTintMode);
        this.mHasTickMarkTintMode = true;
    L9:
        if (r100.hasValue(2) == false) goto L11;
        this.mTickMarkTintList = r100.getColorStateList(2);
        this.mHasTickMarkTint = true;
    L11:
        r100.recycle();
        applyTickMarkTint();
    }
}
