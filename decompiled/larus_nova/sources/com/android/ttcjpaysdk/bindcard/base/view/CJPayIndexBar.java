package com.android.ttcjpaysdk.bindcard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayCanvasExtensionKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u000256B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0014J(\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017H\u0014J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0017J\u001e\u00100\u001a\u00020#2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u0010\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u00010\u0014J\u0010\u00104\u001a\u00020#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/view/CJPayIndexBar;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "blackPaint", "Landroid/graphics/Paint;", "circlePaint", "indexArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mCellHeight", "", "mHeight", "mMarginTop", "mOnIndexChangedListener", "Lcom/android/ttcjpaysdk/bindcard/base/view/CJPayIndexBar$OnIndexChangedListener;", "mWidth", "selectedIndex", "", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "textView", "Landroid/widget/TextView;", "whitePaint", "getTextHeight", "text", "getTextWidth", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setIndex", "index", "setOnIndexChangedListener", "onIndexChangedListener", "setSelectedIndexTextView", "Companion", "OnIndexChangedListener", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayIndexBar extends View {
    private static final String BLACK_COLOR = "#161823";
    public static final Companion Companion = null;
    private static final String WHITE_COLOR = "#FFFFFF";
    private Paint blackPaint;
    private Paint circlePaint;
    private ArrayList<String> indexArray;
    private float mCellHeight;
    private float mHeight;
    private float mMarginTop;
    private OnIndexChangedListener mOnIndexChangedListener;
    private float mWidth;
    private int selectedIndex;
    private TextView textView;
    private Paint whitePaint;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/view/CJPayIndexBar$Companion;", "", "()V", "BLACK_COLOR", "", "WHITE_COLOR", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/view/CJPayIndexBar$OnIndexChangedListener;", "", "onIndexChanged", "", "index", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnIndexChangedListener {
        void onIndexChanged(String r100);
    }

    static {
        Companion = new Companion(null);
    }

    private final void init() {
        Paint r100 = new Paint();
        this.blackPaint = r100;
        Context r101 = getContext();
        if (r101 == null) goto L7;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L7;
        int r103 = r102.getColor(R.color.cj_pay_color_black_161823);
    L8:
        r100.setColor(r103);
        Paint r104 = this.blackPaint;
        if (r104 == null) goto L12;
        r104.setTextSize(CJPayBasicExtensionKt.dip2pxF(12.0f, getContext()));
    L12:
        Paint r105 = this.blackPaint;
        if (r105 == null) goto L16;
        r105.setAntiAlias(true);
    L16:
        Paint r106 = this.blackPaint;
        if (r106 == null) goto L19;
        CJPayCanvasExtensionKt.setMyFakeBoldText(r106, true);
    L19:
        Paint r107 = new Paint(this.blackPaint);
        this.whitePaint = r107;
        Context r108 = getContext();
        if (r108 == null) goto L24;
        Resources r109 = r108.getResources();
        if (r109 == null) goto L24;
        int r110 = r109.getColor(R.color.cj_pay_color_white);
    L25:
        r107.setColor(r110);
        Paint r111 = new Paint();
        Context r112 = getContext();
        if (r112 == null) goto L30;
        Resources r113 = r112.getResources();
        if (r113 == null) goto L30;
        int r114 = r113.getColor(R.color.cj_pay_color_black_161823);
    L31:
        r111.setColor(r114);
        this.circlePaint = r111;
        return;
    L30:
        r114 = ColorProtector.parseColor(BLACK_COLOR);
    L24:
        r110 = ColorProtector.parseColor("#FFFFFF");
    L7:
        r103 = ColorProtector.parseColor(BLACK_COLOR);
        goto L8
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public CJPayIndexBar(Context r100) {
        super(r100);
        this.indexArray = new ArrayList();
        this.selectedIndex = -1;
        init();
    }

    public static final /* synthetic */ TextView access$getTextView$p(CJPayIndexBar r100) {
        return r100.textView;
    }

    private final float getTextHeight(String r100) {
        Rect r101 = new Rect();
        Paint r102 = this.blackPaint;
        if (r102 == null) goto L6;
        r102.getTextBounds(r100, 0, r100.length(), r101);
    L6:
        return r101.height();
    }

    private final float getTextWidth(String r100) {
        Rect r101 = new Rect();
        Paint r102 = this.blackPaint;
        if (r102 == null) goto L6;
        r102.getTextBounds(r100, 0, r100.length(), r101);
    L6:
        return r101.width();
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.indexArray.isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = this.indexArray.size();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L12;
        String r102 = (String) ListProtector.get(this.indexArray, r101);
        float r103 = (this.mWidth / 2.0f) - (getTextWidth(r102) / 2.0f);
        float r104 = (((this.mCellHeight / 2.0f) + (getTextHeight(r102) / 2.0f)) + (this.mCellHeight * r101)) + this.mMarginTop;
        if (r101 != this.selectedIndex) goto L10;
        float r105 = this.mWidth / 2.0f;
        float r106 = r104 - (getTextHeight(r102) / 2.0f);
        float r107 = CJPayBasicExtensionKt.dip2pxF(8.0f, getContext());
        Paint r108 = this.circlePaint;
        Intrinsics.checkNotNull(r108);
        r110.drawCircle(r105, r106, r107, r108);
        Paint r109 = this.whitePaint;
        Intrinsics.checkNotNull(r109);
        r110.drawText(r102, r103, r104, r109);
    L11:
        r101 = r101 + 1;
        goto L6
    L10:
        Paint r111 = this.blackPaint;
        Intrinsics.checkNotNull(r111);
        r110.drawText(r102, r103, r104, r111);
        goto L11
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L21;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L11;
    L49:
        return true;
    L11:
        if (this.textView == null) goto L49;
        invalidate();
        TextView r102 = this.textView;
        if (r102 == null) goto L49;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L49;
        ViewPropertyAnimator r104 = r103.alpha(0.0f);
        if (r104 == null) goto L49;
        ViewPropertyAnimator r105 = r104.setDuration(500);
        if (r105 == null) goto L49;
        r105.setListener(new AnonymousClass3(this));
    L21:
        int r106 = (int) ((r100.getY() - this.mMarginTop) / this.mCellHeight);
        if (r106 < 0) goto L49;
        if (r106 >= this.indexArray.size()) goto L49;
        TextView r107 = this.textView;
        if (r107 == null) goto L30;
        ViewPropertyAnimator r108 = r107.animate();
        if (r108 == null) goto L30;
        r108.cancel();
    L30:
        TextView r109 = this.textView;
        if (r109 != null) goto L33;
    L41:
        TextView r110 = this.textView;
        if (r110 == null) goto L45;
        r110.setText((CharSequence) ListProtector.get(this.indexArray, r106));
    L45:
        OnIndexChangedListener r111 = this.mOnIndexChangedListener;
        if (r111 == null) goto L48;
        r111.onIndexChanged((String) ListProtector.get(this.indexArray, r106));
    L48:
        this.selectedIndex = r106;
        invalidate();
        goto L49
    L33:
        if (r109.getVisibility() != 8) goto L35;
        boolean r112 = true;
    L36:
        if (r112 == true) goto L39;
        r109 = null;
    L39:
        if (r109 == null) goto L41;
        r109.setAlpha(1.0f);
        r109.setVisibility(0);
        goto L41
    L35:
        r112 = false;
        goto L36
    }

    public final void setIndex(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "index");
        this.indexArray = r100;
        this.mMarginTop = (this.mHeight - (this.mCellHeight * r100.size())) / 2;
        invalidate();
    }

    public final void setOnIndexChangedListener(OnIndexChangedListener r100) {
        this.mOnIndexChangedListener = r100;
    }

    public final void setSelectedIndex(int r100) {
        this.selectedIndex = r100;
    }

    public final void setSelectedIndexTextView(TextView r100) {
        this.textView = r100;
    }

    public CJPayIndexBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.indexArray = new ArrayList();
        this.selectedIndex = -1;
        init();
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.mWidth = getMeasuredWidth();
        float r104 = getMeasuredHeight();
        this.mHeight = r104;
        float r105 = (1.0f * r104) / 27;
        this.mCellHeight = r105;
        this.mMarginTop = (r104 - (r105 * this.indexArray.size())) / 2;
    }
}
