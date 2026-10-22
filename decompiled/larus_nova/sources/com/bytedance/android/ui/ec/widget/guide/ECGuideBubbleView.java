package com.bytedance.android.ui.ec.widget.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public class ECGuideBubbleView extends FrameLayout implements ECFunctionGuideView.FunctionLayer {
    private int mArrowHeight;
    private Paint mArrowPaint;
    private final Path mArrowPath;
    private int mArrowToRightEdgeDistance;
    private int mArrowWidth;
    private FrameLayout.LayoutParams mLayerParams;
    private int mNoticeTextHeight;
    private TextView mNoticeTextView;
    private int mQuadLength;
    private int mTopDistanceToTarget;

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public FrameLayout.LayoutParams getLayerParams() {
        return this.mLayerParams;
    }

    public ECGuideBubbleView(Context r100) {
        super(r100);
        this.mArrowPath = new Path();
        this.mArrowPaint = new Paint();
        this.mLayerParams = new FrameLayout.LayoutParams(-2, -2);
        init(r100, false);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        float r101 = getMeasuredWidth() - this.mArrowToRightEdgeDistance;
        this.mArrowPath.moveTo(r101, this.mArrowHeight);
        this.mArrowPath.lineTo(r101 - this.mArrowWidth, this.mArrowHeight);
        Path r102 = this.mArrowPath;
        float r103 = r101 - (this.mArrowWidth / 2.0f);
        int r104 = this.mQuadLength;
        r102.lineTo(r103 - r104, r104);
        Path r105 = this.mArrowPath;
        int r106 = this.mArrowWidth;
        float r107 = r101 - (r106 / 2.0f);
        float r108 = r101 - (r106 / 2.0f);
        int r109 = this.mQuadLength;
        r105.quadTo(r107, 0.0f, r108 + r109, r109);
        this.mArrowPath.close();
        r100.drawPath(this.mArrowPath, this.mArrowPaint);
    }

    public ECGuideBubbleView(Context r100, boolean r101) {
        super(r100);
        this.mArrowPath = new Path();
        this.mArrowPaint = new Paint();
        this.mLayerParams = new FrameLayout.LayoutParams(-2, -2);
        init(r100, r101);
    }

    private void init(Context r100, boolean r101) {
        setWillNotDraw(false);
        this.mQuadLength = UnitExtensionKt.dp2px(1);
        this.mArrowHeight = UnitExtensionKt.dp2px(5);
        this.mArrowWidth = UnitExtensionKt.dp2px(10);
        this.mArrowToRightEdgeDistance = UnitExtensionKt.dp2px(11);
        this.mNoticeTextHeight = UnitExtensionKt.dp2px(44);
        this.mArrowPaint.setStyle(Paint.Style.FILL);
        this.mArrowPaint.setAntiAlias(true);
        this.mNoticeTextView = new TextView(r100);
        if (r101 == false) goto L5;
        this.mArrowPaint.setColor(-1);
        this.mNoticeTextView.setBackgroundResource(R.drawable.ec_bg_white_bubble_notice);
        this.mNoticeTextView.setTextColor(-1090519040);
        this.mTopDistanceToTarget = UnitExtensionKt.dp2px(10);
    L6:
        this.mNoticeTextView.setGravity(17);
        this.mNoticeTextView.setTextSize(1, 14.0f);
        int r102 = UnitExtensionKt.dp2px(12);
        this.mNoticeTextView.setPadding(r102, r102, r102, r102);
        return;
    L5:
        this.mArrowPaint.setColor(-654311424);
        this.mNoticeTextView.setBackgroundResource(R.drawable.ec_bg_black_bubble_notice);
        this.mNoticeTextView.setTextColor(-1);
        this.mTopDistanceToTarget = UnitExtensionKt.dp2px(6);
        goto L6
    }

    public void setSingleData(int r100, int r101, String r102, String r103) {
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, this.mNoticeTextHeight);
        r104.topMargin = this.mArrowHeight;
        addView(this.mNoticeTextView, r104);
        this.mNoticeTextView.setText(r102);
        this.mNoticeTextView.setIncludeFontPadding(false);
        this.mNoticeTextView.measure(0, 0);
        int r105 = (this.mNoticeTextView.getMeasuredWidth() - (this.mArrowWidth / 2)) - this.mArrowToRightEdgeDistance;
        FrameLayout.LayoutParams r106 = this.mLayerParams;
        r106.leftMargin = r100 - r105;
        r106.topMargin = r101 + this.mTopDistanceToTarget;
    }

    public void setMulData(Context r100, int r101, int r102, int r103, Function1<TextView, Unit> r104) {
        if (r100 == null) goto L4;
        int r105 = UnitExtensionKt.dp2px(16);
        int r106 = UnitExtensionKt.dp2px(12);
        this.mNoticeTextView.setPadding(r105, r106, r105, r106);
        this.mNoticeTextView.setGravity(3);
        this.mNoticeTextView.setLineSpacing(UnitExtensionKt.dp2px(5), 1.0f);
    L4:
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(r103, -2);
        r107.topMargin = this.mArrowHeight;
        addView(this.mNoticeTextView, r107);
        if (r104 == null) goto L7;
        r104.invoke(this.mNoticeTextView);
    L7:
        int r108 = (r103 - (this.mArrowWidth / 2)) - this.mArrowToRightEdgeDistance;
        FrameLayout.LayoutParams r109 = this.mLayerParams;
        r109.leftMargin = r101 - r108;
        r109.topMargin = r102 + this.mTopDistanceToTarget;
    }
}
