package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes17.dex */
public class MockView extends View {
    private int mDiagonalsColor;
    private boolean mDrawDiagonals;
    private boolean mDrawLabel;
    private int mMargin;
    private Paint mPaintDiagonals;
    private Paint mPaintText;
    private Paint mPaintTextBackground;
    protected String mText;
    private int mTextBackgroundColor;
    private Rect mTextBounds;
    private int mTextColor;

    public MockView(Context r100) {
        super(r100);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_constraintlayout_utils_widget_MockView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getWidth();
        int r101 = getHeight();
        if (this.mDrawDiagonals == false) goto L5;
        r100 = r100 - 1;
        r101 = r101 - 1;
        float r111 = r100;
        float r112 = r101;
        r110.drawLine(0.0f, 0.0f, r111, r112, this.mPaintDiagonals);
        r110.drawLine(0.0f, r112, r111, 0.0f, this.mPaintDiagonals);
        r110.drawLine(0.0f, 0.0f, r111, 0.0f, this.mPaintDiagonals);
        r110.drawLine(r111, 0.0f, r111, r112, this.mPaintDiagonals);
        r110.drawLine(r111, r112, 0.0f, r112, this.mPaintDiagonals);
        r110.drawLine(0.0f, r112, 0.0f, 0.0f, this.mPaintDiagonals);
    L5:
        String r102 = this.mText;
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.mDrawLabel == false) goto L12;
        this.mPaintText.getTextBounds(r102, 0, r102.length(), this.mTextBounds);
        float r103 = (r100 - this.mTextBounds.width()) / 2.0f;
        float r104 = ((r101 - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
        this.mTextBounds.offset((int) r103, (int) r104);
        Rect r105 = this.mTextBounds;
        int r106 = r105.left;
        int r107 = this.mMargin;
        r105.set(r106 - r107, r105.top - r107, r105.right + r107, r105.bottom + r107);
        r110.drawRect(this.mTextBounds, this.mPaintTextBackground);
        r110.drawText(this.mText, r103, r104, this.mPaintText);
        return;
    }

    public MockView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r100, r101);
    }

    private void init(Context r100, AttributeSet r101) {
        if (r101 == null) goto L26;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.mock_diagonalsColor, R.attr.mock_label, R.attr.mock_labelBackgroundColor, R.attr.mock_labelColor, R.attr.mock_showDiagonals, R.attr.mock_showLabel});
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L24;
        int r105 = r102.getIndex(r104);
        if (r105 != 1) goto L10;
        this.mText = r102.getString(r105);
    L23:
        r104 = r104 + 1;
        goto L5
    L10:
        if (r105 != 4) goto L12;
        this.mDrawDiagonals = r102.getBoolean(r105, this.mDrawDiagonals);
        goto L23
    L12:
        if (r105 != 0) goto L15;
        this.mDiagonalsColor = r102.getColor(r105, this.mDiagonalsColor);
        goto L23
    L15:
        if (r105 != 2) goto L18;
        this.mTextBackgroundColor = r102.getColor(r105, this.mTextBackgroundColor);
        goto L23
    L18:
        if (r105 != 3) goto L21;
        this.mTextColor = r102.getColor(r105, this.mTextColor);
        goto L23
    L21:
        if (r105 != 5) goto L23;
        this.mDrawLabel = r102.getBoolean(r105, this.mDrawLabel);
        goto L23
    L24:
        r102.recycle();
    L26:
        if (this.mText == null) goto L31;
    L28:
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round(this.mMargin * (INVOKEVIRTUAL_androidx_constraintlayout_utils_widget_MockView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).xdpi / 160.0f));
        return;
    L31:
        this.mText = r100.getResources().getResourceEntryName(getId());     // Catch: Exception -> L30
        goto L28
    }

    public MockView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r100, r101);
    }
}
