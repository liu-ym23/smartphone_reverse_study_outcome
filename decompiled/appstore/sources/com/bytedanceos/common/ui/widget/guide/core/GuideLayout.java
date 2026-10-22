package com.bytedanceos.common.ui.widget.guide.core;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.ui.widget.guide.NewbieGuide;
import com.bytedanceos.common.ui.widget.guide.listener.OnHighlightDrewListener;
import com.bytedanceos.common.ui.widget.guide.listener.OnLayoutInflatedListener;
import com.bytedanceos.common.ui.widget.guide.model.GuidePage;
import com.bytedanceos.common.ui.widget.guide.model.HighLight;
import com.bytedanceos.common.ui.widget.guide.model.HighlightOptions;
import com.bytedanceos.common.ui.widget.guide.model.RelativeGuide;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GuideLayout extends FrameLayout {
    public static final int DEFAULT_BACKGROUND_COLOR = -1308622848;
    private Paint bitmapPaint;
    private Controller controller;
    private float downX;
    private float downY;
    public GuidePage guidePage;
    private Paint lightPaint;
    private OnGuideLayoutDismissListener listener;
    private Paint paint;
    private Canvas tempCanvas;
    private int touchSlop;
    private PorterDuffXfermode xfermode;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.widget.guide.core.GuideLayout$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedanceos$common$ui$widget$guide$model$HighLight$Shape = null;

        static {
            int[] r10 = new int[HighLight.Shape.values().length];
            $SwitchMap$com$bytedanceos$common$ui$widget$guide$model$HighLight$Shape = r10;
            r10[HighLight.Shape.CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedanceos$common$ui$widget$guide$model$HighLight$Shape[HighLight.Shape.OVAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedanceos$common$ui$widget$guide$model$HighLight$Shape[HighLight.Shape.ROUND_RECTANGLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedanceos$common$ui$widget$guide$model$HighLight$Shape[HighLight.Shape.RECTANGLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface OnGuideLayoutDismissListener {
        void onGuideLayoutDismiss(GuideLayout r10);
    }

    public GuideLayout(Context r10, GuidePage r11, Controller r12) {
        super(r10);
        init();
        setGuidePage(r11);
        this.controller = r12;
    }

    public static /* synthetic */ void access$000(GuideLayout r10) {
        r10.dismiss();
    }

    private void addCustomToLayout(GuidePage r10) {
        removeAllViews();
        int r11 = r10.getLayoutResId();
        if (r11 == 0) goto L19;
        int r12 = 0;
        View r13 = LayoutInflater.from(getContext()).inflate(r11, this, false);
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(-1, -1);
        int[] r15 = r10.getClickToDismissIds();
        if (r15 != null) goto L7;
    L15:
        OnLayoutInflatedListener r16 = r10.getOnLayoutInflatedListener();
        if (r16 == null) goto L18;
        r16.onLayoutInflated(r13, this.controller);
    L18:
        addView(r13, r14);
        goto L19
    L7:
        if (r15.length <= 0) goto L15;
        int r17 = r15.length;
    L9:
        if (r12 >= r17) goto L15;
        int r18 = r15[r12];
        View r19 = r13.findViewById(r18);
        if (r19 == null) goto L13;
        r19.setOnClickListener(new AnonymousClass2(this));
    L14:
        r12 = r12 + 1;
        goto L9
    L13:
        i.k(NewbieGuide.TAG, "can't find the view by id : " + r18 + " which used to remove guide page");
    L19:
        List<RelativeGuide> r20 = r10.getRelativeGuides();
        if (r20.size() <= 0) goto L25;
        Iterator<RelativeGuide> r21 = r20.iterator();
    L23:
        if (r21.hasNext() == false) goto L30;
        addView(r21.next().getGuideLayout((ViewGroup) getParent(), this.controller));
        goto L23
    L30:
        return;
    }

    private void dismiss() {
        if (getParent() == null) goto L8;
        ((ViewGroup) getParent()).removeView(this);
        OnGuideLayoutDismissListener r10 = this.listener;
        if (r10 == null) goto L9;
        r10.onGuideLayoutDismiss(this);
        return;
    L9:
        return;
    }

    private void init() {
        this.paint = new Paint(1);
        this.lightPaint = new Paint(1);
        this.bitmapPaint = new Paint(1);
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        setLayerType(1, null);
        setWillNotDraw(false);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.tempCanvas = new Canvas();
    }

    private void notifyClickListener(HighLight r10) {
        HighlightOptions r11 = r10.getOptions();
        if (r11 == null) goto L8;
        View.OnClickListener r12 = r11.onClickListener;
        if (r12 == null) goto L9;
        r12.onClick(this);
        return;
    L9:
        return;
    }

    private void notifyDrewListener(Canvas r10, HighLight r11, RectF r12) {
        HighlightOptions r13 = r11.getOptions();
        if (r13 == null) goto L8;
        OnHighlightDrewListener r14 = r13.onHighlightDrewListener;
        if (r14 == null) goto L9;
        r14.onHighlightDrew(r10, r12);
        return;
    L9:
        return;
    }

    private void setGuidePage(GuidePage r10) {
        this.guidePage = r10;
        setOnClickListener(new AnonymousClass1(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addCustomToLayout(this.guidePage);
        Animation r10 = this.guidePage.getEnterAnimation();
        if (r10 == null) goto L6;
        startAnimation(r10);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        Bitmap r11 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        this.tempCanvas.setBitmap(r11);
        Paint r12 = this.paint;
        if (this.guidePage.getBackgroundColor() != 0) goto L5;
        int r13 = DEFAULT_BACKGROUND_COLOR;
    L6:
        r12.setColor(r13);
        Canvas r14 = this.tempCanvas;
        r14.drawRect(0.0f, 0.0f, r14.getWidth(), this.tempCanvas.getHeight(), this.paint);
        this.lightPaint.setColor(getResources().getColor(R.color.transparent));
        this.lightPaint.setXfermode(this.xfermode);
        if (this.guidePage.getMaskFilter() == null) goto L9;
        this.lightPaint.setMaskFilter(this.guidePage.getMaskFilter());
    L9:
        List<HighLight> r15 = this.guidePage.getHighLights();
        if (r15 == null) goto L28;
        Iterator<HighLight> r16 = r15.iterator();
    L13:
        if (r16.hasNext() == false) goto L35;
        HighLight r17 = r16.next();
        RectF r18 = r17.getRectF((ViewGroup) getParent());
        int r19 = AnonymousClass4.$SwitchMap$com$bytedanceos$common$ui$widget$guide$model$HighLight$Shape[r17.getShape().ordinal()];
        if (r19 != 1) goto L17;
        this.tempCanvas.drawCircle(r18.centerX(), r18.centerY(), r17.getRadius(), this.lightPaint);
    L27:
        r10.drawBitmap(r11, 0.0f, 0.0f, this.bitmapPaint);
        notifyDrewListener(r10, r17, r18);
        r11.recycle();
        goto L13
    L17:
        if (r19 != 2) goto L19;
        this.tempCanvas.drawOval(r18, this.lightPaint);
        goto L27
    L19:
        if (r19 != 3) goto L21;
        this.tempCanvas.drawRoundRect(r18, r17.getRound(), r17.getRound(), this.lightPaint);
        goto L27
    L21:
        if (r19 == 4) goto L23;
        this.tempCanvas.drawRect(r18, this.lightPaint);
        goto L27
    L23:
        this.tempCanvas.drawRect(r18, this.lightPaint);
        goto L27
    L35:
        return;
    L28:
        return;
    L5:
        r13 = this.guidePage.getBackgroundColor();
        goto L6
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        this.downX = r10.getX();
        this.downY = r10.getY();
    L23:
        return super.onTouchEvent(r10);
    L5:
        if (r11 != 1) goto L7;
    L9:
        float r12 = r10.getX();
        float r13 = r10.getY();
        if (Math.abs(r12 - this.downX) >= this.touchSlop) goto L23;
        if (Math.abs(r13 - this.downY) >= this.touchSlop) goto L23;
        Iterator<HighLight> r14 = this.guidePage.getHighLights().iterator();
    L15:
        if (r14.hasNext() == false) goto L20;
        HighLight r15 = r14.next();
        if (r15.getRectF((ViewGroup) getParent()).contains(r12, r13) == false) goto L15;
        notifyClickListener(r15);
        return true;
    L20:
        performClick();
        goto L23
    L7:
        if (r11 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void remove() {
        Animation r10 = this.guidePage.getExitAnimation();
        if (r10 == null) goto L5;
        r10.setAnimationListener(new AnonymousClass3(this));
        startAnimation(r10);
        return;
    L5:
        dismiss();
    }

    public void setOnGuideLayoutDismissListener(OnGuideLayoutDismissListener r10) {
        this.listener = r10;
    }

    private GuideLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    private GuideLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
