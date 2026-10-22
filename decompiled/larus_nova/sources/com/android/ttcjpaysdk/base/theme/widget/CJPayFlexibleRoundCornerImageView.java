package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayFlexibleRoundCornerImageView extends AppCompatImageView {
    public static final int ALL = 15;
    public static final int BOTTOM_LEFT = 4;
    public static final int BOTTOM_RIGHT = 8;
    public static final int NONE = 0;
    public static final int TOP_LEFT = 1;
    public static final int TOP_RIGHT = 2;
    private int mBorderRadius;
    private int mCorners;
    private Path path;
    private float[] radii;
    private RectF rectF;

    public CJPayFlexibleRoundCornerImageView(Context r100) {
        super(r100);
        this.mBorderRadius = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
        this.mCorners = 0;
        initView(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        this.path.reset();
        this.rectF.set(0.0f, 0.0f, getWidth(), getHeight());
        int r101 = this.mCorners ^ 15;
        if ((r101 & 1) == 0) goto L6;
        float[] r102 = this.radii;
        r102[1] = 0.0f;
        r102[0] = 0.0f;
    L6:
        if ((r101 & 2) == 0) goto L9;
        float[] r103 = this.radii;
        r103[3] = 0.0f;
        r103[2] = 0.0f;
    L9:
        if ((r101 & 4) == 0) goto L12;
        float[] r104 = this.radii;
        r104[5] = 0.0f;
        r104[4] = 0.0f;
    L12:
        if ((r101 & 8) == 0) goto L14;
        float[] r105 = this.radii;
        r105[7] = 0.0f;
        r105[6] = 0.0f;
    L14:
        this.path.addRoundRect(this.rectF, this.radii, Path.Direction.CW);
        r100.clipPath(this.path);
        super.onDraw(r100);
    }

    public CJPayFlexibleRoundCornerImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mBorderRadius = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
        this.mCorners = 0;
        initView(r100, r101);
    }

    private void initView(Context r100, AttributeSet r101) {
        if (r101 == null) goto L8;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayCorners, R.attr.CJPayCornersRadius});
        if (r102 == null) goto L6;
        this.mBorderRadius = (int) r102.getDimension(1, CJPayBasicUtils.dipToPX(getContext(), 4.0f));
        this.mCorners = r102.getInteger(0, CJPayBasicUtils.dipToPX(getContext(), 15.0f));
        r102.recycle();
    L6:
        this.path = new Path();
        this.rectF = new RectF();
        int r103 = this.mBorderRadius;
        this.radii = new float[]{r103, r103, r103, r103, r103, r103, r103, r103};
        return;
    }

    public CJPayFlexibleRoundCornerImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mBorderRadius = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
        this.mCorners = 0;
        initView(r100, r101);
    }
}
