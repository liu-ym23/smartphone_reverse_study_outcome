package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
public class Placeholder extends View {
    private View mContent;
    private int mContentId;
    private int mEmptyVisibility;

    public View getContent() {
        return this.mContent;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    public Placeholder(Context r100) {
        super(r100);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(null);
    }

    private void init(AttributeSet r100) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if (r100 == null) goto L19;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.content, R.attr.placeholder_emptyVisibility});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        int r104 = r101.getIndex(r103);
        if (r104 != 0) goto L10;
        this.mContentId = r101.getResourceId(r104, this.mContentId);
    L12:
        r103 = r103 + 1;
        goto L5
    L10:
        if (r104 != 1) goto L12;
        this.mEmptyVisibility = r101.getInt(r104, this.mEmptyVisibility);
        goto L12
    L13:
        r101.recycle();
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        if (isInEditMode() == false) goto L6;
        r100.drawRGB(223, 223, 223);
        Paint r101 = new Paint();
        r101.setARGB(255, 210, 210, 210);
        r101.setTextAlign(Paint.Align.CENTER);
        r101.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r102 = new Rect();
        r100.getClipBounds(r102);
        r101.setTextSize(r102.height());
        int r103 = r102.height();
        int r104 = r102.width();
        r101.setTextAlign(Paint.Align.LEFT);
        r101.getTextBounds("?", 0, 1, r102);
        r100.drawText("?", ((r104 / 2.0f) - (r102.width() / 2.0f)) - r102.left, ((r103 / 2.0f) + (r102.height() / 2.0f)) - r102.bottom, r101);
        return;
    }

    public void setContentId(int r100) {
        if (this.mContentId != r100) goto L5;
        return;
    L5:
        View r101 = this.mContent;
        if (r101 == null) goto L8;
        r101.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.mContent.getLayoutParams()).isInPlaceholder = false;
        this.mContent = null;
    L8:
        this.mContentId = r100;
        if (r100 == (-1)) goto L14;
        View r102 = ((View) getParent()).findViewById(r100);
        if (r102 == null) goto L15;
        r102.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r100) {
        this.mEmptyVisibility = r100;
    }

    public void updatePostMeasure(ConstraintLayout r100) {
        if (this.mContent != null) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) this.mContent.getLayoutParams();
        r102.widget.setVisibility(0);
        ConstraintWidget.DimensionBehaviour r103 = r101.widget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r104 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r103 == r104) goto L9;
        r101.widget.setWidth(r102.widget.getWidth());
    L9:
        if (r101.widget.getVerticalDimensionBehaviour() == r104) goto L11;
        r101.widget.setHeight(r102.widget.getHeight());
    L11:
        r102.widget.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout r100) {
        if (this.mContentId == (-1)) goto L5;
    L7:
        View r101 = r100.findViewById(this.mContentId);
        this.mContent = r101;
        if (r101 == null) goto L11;
        ((ConstraintLayout.LayoutParams) r101.getLayoutParams()).isInPlaceholder = true;
        this.mContent.setVisibility(0);
        setVisibility(0);
        return;
    L11:
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        setVisibility(this.mEmptyVisibility);
        goto L7
    }

    public Placeholder(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r101);
    }

    public Placeholder(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r101);
    }

    public Placeholder(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r101);
    }
}
