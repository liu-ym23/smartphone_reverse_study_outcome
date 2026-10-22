package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.internal.view.SupportMenu;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.motion.widget.a;
import com.obric.oui.constraintlayout.motion.widget.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class MotionLabel extends View implements c {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    static final String TAG = "MotionLabel";
    private boolean mAutoSize;
    private int mAutoSizeTextType;
    float mBackgroundPanX;
    float mBackgroundPanY;
    private float mBaseTextSize;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity;
    private Layout mLayout;
    boolean mNotBuilt;
    Matrix mOutlinePositionMatrix;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    TextPaint mPaint;
    Paint mPaintCache;
    float mPaintTextSize;
    Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    private int mStyleIndex;
    Paint mTempPaint;
    Rect mTempRect;
    private String mText;
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds;
    private int mTextFillColor;
    private int mTextOutlineColor;
    private float mTextOutlineThickness;
    private float mTextPanX;
    private float mTextPanY;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize;
    private int mTextureEffect;
    private float mTextureHeight;
    private float mTextureWidth;
    private int mTypefaceIndex;
    private boolean mUseOutline;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.v(r0, r1);
    }

    static /* synthetic */ float access$000(MotionLabel r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(MotionLabel r0) {
        return r0.mRound;
    }

    public MotionLabel(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        super(r7);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = SupportMenu.USER_MASK;
        this.mTextOutlineColor = SupportMenu.USER_MASK;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = 8388659;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.mPaintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r7, null);
    }

    public MotionLabel(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r8, r9);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = SupportMenu.USER_MASK;
        this.mTextOutlineColor = SupportMenu.USER_MASK;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = 8388659;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.mPaintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r8, r9);
    }

    public MotionLabel(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r8, r9, r7);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = SupportMenu.USER_MASK;
        this.mTextOutlineColor = SupportMenu.USER_MASK;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = 8388659;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.mPaintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r8, r9);
    }

    private void init(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        setUpTheme(r10);
        if (r11 == null) goto L77;
        TypedArray r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r11, R.styleable.MotionLabel);
        int r13 = r12.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r13) goto L76;
        int r2 = r12.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_text, "styleable", "MotionLabel_android_text")) goto L10;
        setText(r12.getText(r2));
    L75:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_fontFamily, "styleable", "MotionLabel_android_fontFamily")) goto L13;
        this.mFontFamily = r12.getString(r2);
        goto L75
    L13:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_scaleFromTextSize, "styleable", "MotionLabel_scaleFromTextSize")) goto L16;
        this.mBaseTextSize = r12.getDimensionPixelSize(r2, (int) this.mBaseTextSize);
        goto L75
    L16:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_textSize, "styleable", "MotionLabel_android_textSize")) goto L19;
        this.mTextSize = r12.getDimensionPixelSize(r2, (int) this.mTextSize);
        goto L75
    L19:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_textStyle, "styleable", "MotionLabel_android_textStyle")) goto L22;
        this.mStyleIndex = r12.getInt(r2, this.mStyleIndex);
        goto L75
    L22:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_typeface, "styleable", "MotionLabel_android_typeface")) goto L25;
        this.mTypefaceIndex = r12.getInt(r2, this.mTypefaceIndex);
        goto L75
    L25:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_textColor, "styleable", "MotionLabel_android_textColor")) goto L28;
        this.mTextFillColor = r12.getColor(r2, this.mTextFillColor);
        goto L75
    L28:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_borderRound, "styleable", "MotionLabel_borderRound")) goto L31;
        float r3 = r12.getDimension(r2, this.mRound);
        this.mRound = r3;
        setRound(r3);
        goto L75
    L31:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_borderRoundPercent, "styleable", "MotionLabel_borderRoundPercent")) goto L34;
        float r4 = r12.getFloat(r2, this.mRoundPercent);
        this.mRoundPercent = r4;
        setRoundPercent(r4);
        goto L75
    L34:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_gravity, "styleable", "MotionLabel_android_gravity")) goto L37;
        setGravity(r12.getInt(r2, -1));
        goto L75
    L37:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_android_autoSizeTextType, "styleable", "MotionLabel_android_autoSizeTextType")) goto L40;
        this.mAutoSizeTextType = r12.getInt(r2, 0);
        goto L75
    L40:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textOutlineColor, "styleable", "MotionLabel_textOutlineColor")) goto L43;
        this.mTextOutlineColor = r12.getInt(r2, this.mTextOutlineColor);
        this.mUseOutline = true;
        goto L75
    L43:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textOutlineThickness, "styleable", "MotionLabel_textOutlineThickness")) goto L46;
        this.mTextOutlineThickness = r12.getDimension(r2, this.mTextOutlineThickness);
        this.mUseOutline = true;
        goto L75
    L46:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackground, "styleable", "MotionLabel_textBackground")) goto L49;
        this.mTextBackground = r12.getDrawable(r2);
        this.mUseOutline = true;
        goto L75
    L49:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundPanX, "styleable", "MotionLabel_textBackgroundPanX")) goto L52;
        this.mBackgroundPanX = r12.getFloat(r2, this.mBackgroundPanX);
        goto L75
    L52:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundPanY, "styleable", "MotionLabel_textBackgroundPanY")) goto L55;
        this.mBackgroundPanY = r12.getFloat(r2, this.mBackgroundPanY);
        goto L75
    L55:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textPanX, "styleable", "MotionLabel_textPanX")) goto L58;
        this.mTextPanX = r12.getFloat(r2, this.mTextPanX);
        goto L75
    L58:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textPanY, "styleable", "MotionLabel_textPanY")) goto L61;
        this.mTextPanY = r12.getFloat(r2, this.mTextPanY);
        goto L75
    L61:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundRotate, "styleable", "MotionLabel_textBackgroundRotate")) goto L64;
        this.mRotate = r12.getFloat(r2, this.mRotate);
        goto L75
    L64:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textBackgroundZoom, "styleable", "MotionLabel_textBackgroundZoom")) goto L67;
        this.mZoom = r12.getFloat(r2, this.mZoom);
        goto L75
    L67:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textureHeight, "styleable", "MotionLabel_textureHeight")) goto L70;
        this.mTextureHeight = r12.getDimension(r2, this.mTextureHeight);
        goto L75
    L70:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textureWidth, "styleable", "MotionLabel_textureWidth")) goto L73;
        this.mTextureWidth = r12.getDimension(r2, this.mTextureWidth);
        goto L75
    L73:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionLabel_textureEffect, "styleable", "MotionLabel_textureEffect")) goto L75;
        this.mTextureEffect = r12.getInt(r2, this.mTextureEffect);
        goto L75
    L76:
        r12.recycle();
    L77:
        setupTexture();
        setupPath();
    }

    Bitmap blur(Bitmap r5, int r6) {
        int r4 = r5.getWidth();
        int r7 = r4 / 2;
        int r0 = r5.getHeight() / 2;
        Bitmap r8 = Bitmap.createScaledBitmap(r5, r7, r0, true);
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L9;
        if (r7 < 32) goto L9;
        if (r0 < 32) goto L9;
        r7 = r7 / 2;
        r0 = r0 / 2;
        r8 = Bitmap.createScaledBitmap(r8, r7, r0, true);
        r2 = r2 + 1;
    L9:
        return r8;
    }

    private void setupTexture() {
        if (this.mTextBackground == null) goto L28;
        this.mTextShaderMatrix = new Matrix();
        int r0 = this.mTextBackground.getIntrinsicWidth();
        int r1 = this.mTextBackground.getIntrinsicHeight();
        int r2 = 128;
        if (r0 > 0) goto L12;
        r0 = getWidth();
        if (r0 != 0) goto L12;
        if (Float.isNaN(this.mTextureWidth) == false) goto L11;
        r0 = 128;
        goto L12
    L11:
        r0 = (int) this.mTextureWidth;
    L12:
        if (r1 > 0) goto L21;
        r1 = getHeight();
        if (r1 != 0) goto L21;
        if (Float.isNaN(this.mTextureHeight) == true) goto L19;
        r2 = (int) this.mTextureHeight;
    L19:
        r1 = r2;
    L21:
        if (this.mTextureEffect == 0) goto L23;
        r0 = r0 / 2;
        r1 = r1 / 2;
    L23:
        this.mTextBackgroundBitmap = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(this.mTextBackgroundBitmap);
        this.mTextBackground.setBounds(0, 0, r3.getWidth(), r3.getHeight());
        this.mTextBackground.setFilterBitmap(true);
        this.mTextBackground.draw(r3);
        if (this.mTextureEffect == 0) goto L26;
        this.mTextBackgroundBitmap = blur(this.mTextBackgroundBitmap, 4);
    L26:
        this.mTextShader = new BitmapShader(this.mTextBackgroundBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        return;
    }

    private void adjustTexture(float r2, float r3, float r4, float r5) {
        if (this.mTextShaderMatrix != null) goto L5;
        return;
    L5:
        this.mFloatWidth = r4 - r2;
        this.mFloatHeight = r5 - r3;
        updateShaderMatrix();
    }

    public void setGravity(int r8) {
        if ((r8 & 8388615) != 0) goto L6;
        r8 = r8 | 8388611;
    L6:
        if ((r8 & 112) != 0) goto L8;
        r8 = r8 | 48;
    L8:
        int r1 = r8 & 8388615;
        int r3 = this.mGravity;
        int r4 = r3 & 8388615;
        if (r8 == r3) goto L11;
        invalidate();
    L11:
        this.mGravity = r8;
        int r2 = r8 & 112;
        if (r2 != 48) goto L14;
        this.mTextPanY = -1.0f;
    L18:
        int r9 = r8 & 8388615;
        if (r9 != 3) goto L21;
    L27:
        this.mTextPanX = -1.0f;
        return;
    L21:
        if (r9 == 5) goto L26;
        if (r9 == 8388611) goto L27;
        if (r9 == 8388613) goto L26;
        this.mTextPanX = 0.0f;
        return;
    L26:
        this.mTextPanX = 1.0f;
        return;
    L14:
        if (r2 == 80) goto L16;
        this.mTextPanY = 0.0f;
        goto L18
    L16:
        this.mTextPanY = 1.0f;
        goto L18
    }

    private float getHorizontalOffset() {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r0 = 1.0f;
    L6:
        TextPaint r2 = this.mPaint;
        String r3 = this.mText;
        float r1 = r0 * r2.measureText(r3, 0, r3.length());
        if (Float.isNaN(this.mFloatWidth) == false) goto L9;
        float r4 = getMeasuredWidth();
    L11:
        return ((((r4 - getPaddingLeft()) - getPaddingRight()) - r1) * (this.mTextPanX + 1.0f)) / 2.0f;
    L9:
        r4 = this.mFloatWidth;
        goto L11
    L5:
        r0 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    private float getVerticalOffset() {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r0 = 1.0f;
    L6:
        Paint.FontMetrics r2 = this.mPaint.getFontMetrics();
        if (Float.isNaN(this.mFloatHeight) == false) goto L9;
        float r3 = getMeasuredHeight();
    L11:
        return (((((r3 - getPaddingTop()) - getPaddingBottom()) - ((r2.descent - r2.ascent) * r0)) * (1.0f - this.mTextPanY)) / 2.0f) - (r0 * r2.ascent);
    L9:
        r3 = this.mFloatHeight;
        goto L11
    L5:
        r0 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    private void setUpTheme(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        TypedValue r0 = new TypedValue();
        r6.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"), r0, true);
        TextPaint r7 = this.mPaint;
        int r1 = r0.data;
        this.mTextFillColor = r1;
        r7.setColor(r1);
    }

    public void setText(CharSequence r3) {
        this.mText = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        invalidate();
    }

    void setupPath() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }

    void buildShape(float r11) {
        if (this.mUseOutline == false) goto L5;
    L7:
        this.mPath.reset();
        String r3 = this.mText;
        int r5 = r3.length();
        this.mPaint.getTextBounds(r3, 0, r5, this.mTextBounds);
        this.mPaint.getTextPath(r3, 0, r5, 0.0f, 0.0f, this.mPath);
        if (r11 == 1.0f) goto L10;
        INVOKESTATIC_com_obric_oui_constraintlayout_utils_widget_MotionLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, a.b() + " scale " + r11);
        Matrix r0 = new Matrix();
        r0.postScale(r11, r11);
        this.mPath.transform(r0);
    L10:
        this.mTextBounds.right--;
        this.mTextBounds.left++;
        this.mTextBounds.bottom++;
        this.mTextBounds.top--;
        RectF r12 = new RectF();
        r12.bottom = getHeight();
        r12.right = getWidth();
        this.mNotBuilt = false;
        return;
    L5:
        if (r11 != 1.0f) goto L7;
    }

    @Override // android.view.View
    public void layout(int r9, int r10, int r11, int r12) {
        super.layout(r9, r10, r11, r12);
        boolean r0 = Float.isNaN(this.mBaseTextSize);
        if (r0 == false) goto L5;
        float r1 = 1.0f;
    L6:
        this.mFloatWidth = r11 - r9;
        this.mFloatHeight = r12 - r10;
        if (this.mAutoSize == false) goto L22;
        if (this.mTempRect != null) goto L11;
        this.mTempPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTempPaint.set(this.mPaint);
        this.mPaintTextSize = this.mTempPaint.getTextSize();
    L11:
        Paint r2 = this.mTempPaint;
        String r3 = this.mText;
        r2.getTextBounds(r3, 0, r3.length(), this.mTempRect);
        int r4 = this.mTempRect.width();
        int r5 = (int) (this.mTempRect.height() * 1.3f);
        float r6 = (this.mFloatWidth - this.mPaddingRight) - this.mPaddingLeft;
        float r7 = (this.mFloatHeight - this.mPaddingBottom) - this.mPaddingTop;
        if (r0 == false) goto L17;
        float r8 = r4;
        float r13 = r5;
        if ((r8 * r7) <= (r13 * r6)) goto L16;
        this.mPaint.setTextSize((this.mPaintTextSize * r6) / r8);
        goto L22
    L16:
        this.mPaint.setTextSize((this.mPaintTextSize * r7) / r13);
        goto L22
    L17:
        float r14 = r4;
        float r15 = r5;
        if ((r14 * r7) <= (r15 * r6)) goto L20;
        r1 = r6 / r14;
        goto L22
    L20:
        r1 = r7 / r15;
    L22:
        if (this.mUseOutline == true) goto L24;
        if (r0 == false) goto L24;
        return;
    L24:
        adjustTexture(r9, r10, r11, r12);
        buildShape(r1);
        return;
    L5:
        r1 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void layout(float r9, float r10, float r11, float r12) {
        int r1 = (int) (r9 + 0.5f);
        this.mDeltaLeft = r9 - r1;
        int r2 = (int) (r11 + 0.5f);
        int r3 = r2 - r1;
        int r4 = (int) (r12 + 0.5f);
        int r0 = (int) (0.5f + r10);
        int r5 = r4 - r0;
        float r6 = r11 - r9;
        this.mFloatWidth = r6;
        float r7 = r12 - r10;
        this.mFloatHeight = r7;
        adjustTexture(r9, r10, r11, r12);
        if (getMeasuredHeight() == r5) goto L5;
    L8:
        measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(r5, 1073741824));
        super.layout(r1, r0, r2, r4);
    L10:
        if (this.mAutoSize == true) goto L12;
        return;
    L12:
        if (this.mTempRect != null) goto L14;
        this.mTempPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTempPaint.set(this.mPaint);
        this.mPaintTextSize = this.mTempPaint.getTextSize();
    L14:
        this.mFloatWidth = r6;
        this.mFloatHeight = r7;
        Paint r13 = this.mTempPaint;
        String r14 = this.mText;
        r13.getTextBounds(r14, 0, r14.length(), this.mTempRect);
        int r15 = this.mTempRect.width();
        float r16 = this.mTempRect.height() * 1.3f;
        float r8 = (r6 - this.mPaddingRight) - this.mPaddingLeft;
        float r17 = (r7 - this.mPaddingBottom) - this.mPaddingTop;
        float r18 = r15;
        if ((r18 * r17) <= (r16 * r8)) goto L17;
        this.mPaint.setTextSize((this.mPaintTextSize * r8) / r18);
    L19:
        if (this.mUseOutline == true) goto L23;
        if (Float.isNaN(this.mBaseTextSize) == false) goto L23;
        return;
    L23:
        if (Float.isNaN(this.mBaseTextSize) == false) goto L25;
        float r19 = 1.0f;
    L26:
        buildShape(r19);
        return;
    L25:
        r19 = this.mTextSize / this.mBaseTextSize;
        goto L26
    L17:
        this.mPaint.setTextSize((this.mPaintTextSize * r17) / r16);
        goto L19
    L5:
        if (getMeasuredWidth() != r3) goto L8;
        super.layout(r1, r0, r2, r4);
        goto L10
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r0 = 1.0f;
    L6:
        super.onDraw(r5);
        if (this.mUseOutline == true) goto L13;
        if (r0 != 1.0f) goto L13;
        float r1 = this.mPaddingLeft + getHorizontalOffset();
        r5.drawText(this.mText, this.mDeltaLeft + r1, this.mPaddingTop + getVerticalOffset(), this.mPaint);
        return;
    L13:
        if (this.mNotBuilt == false) goto L16;
        buildShape(r0);
    L16:
        if (this.mOutlinePositionMatrix != null) goto L19;
        this.mOutlinePositionMatrix = new Matrix();
    L19:
        if (this.mUseOutline == false) goto L28;
        this.mPaintCache.set(this.mPaint);
        this.mOutlinePositionMatrix.reset();
        float r2 = this.mPaddingLeft + getHorizontalOffset();
        float r3 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.postTranslate(r2, r3);
        this.mOutlinePositionMatrix.preScale(r0, r0);
        this.mPath.transform(this.mOutlinePositionMatrix);
        if (this.mTextShader == null) goto L23;
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setShader(this.mTextShader);
    L24:
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r5.drawPath(this.mPath, this.mPaint);
        if (this.mTextShader == null) goto L27;
        this.mPaint.setShader(null);
    L27:
        this.mPaint.setColor(this.mTextOutlineColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r5.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.postTranslate(-r2, -r3);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.set(this.mPaintCache);
        return;
    L23:
        this.mPaint.setColor(this.mTextFillColor);
        goto L24
    L28:
        float r4 = this.mPaddingLeft + getHorizontalOffset();
        float r6 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(r4, r6);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r5.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(-r4, -r6);
        this.mPath.transform(this.mOutlinePositionMatrix);
        return;
    L5:
        r0 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    public void setTextOutlineThickness(float r2) {
        this.mTextOutlineThickness = r2;
        this.mUseOutline = true;
        if (Float.isNaN(r2) == false) goto L5;
        this.mTextOutlineThickness = 1.0f;
        this.mUseOutline = false;
    L5:
        invalidate();
    }

    public void setTextFillColor(int r1) {
        this.mTextFillColor = r1;
        invalidate();
    }

    public void setTextOutlineColor(int r1) {
        this.mTextOutlineColor = r1;
        this.mUseOutline = true;
        invalidate();
    }

    private void setTypefaceFromAttrs(String r5, int r6, int r7) {
        if (r5 == null) goto L7;
        Typeface r8 = Typeface.create(r5, r7);
        if (r8 == null) goto L8;
        setTypeface(r8);
        return;
    L8:
        boolean r1 = true;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L12;
        r8 = Typeface.SERIF;
    L17:
        float r9 = 0.0f;
        if (r7 <= 0) goto L34;
        if (r8 != null) goto L21;
        Typeface r10 = Typeface.defaultFromStyle(r7);
    L22:
        setTypeface(r10);
        if (r10 == null) goto L25;
        int r11 = r10.getStyle();
    L26:
        int r12 = (~r11) & r7;
        TextPaint r13 = this.mPaint;
        if ((r12 & 1) != 0) goto L30;
        r1 = false;
    L30:
        r13.setFakeBoldText(r1);
        TextPaint r4 = this.mPaint;
        if ((r12 & 2) == 0) goto L33;
        r9 = -0.25f;
    L33:
        r4.setTextSkewX(r9);
        return;
    L25:
        r11 = 0;
        goto L26
    L21:
        r10 = Typeface.create(r8, r7);
        goto L22
    L34:
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(r8);
        return;
    L12:
        if (r6 != 3) goto L17;
        r8 = Typeface.MONOSPACE;
        goto L17
    L16:
        r8 = Typeface.SANS_SERIF;
        goto L17
    L7:
        r8 = null;
        goto L8
    }

    public void setTypeface(Typeface r2) {
        if (Objects.equals(this.mPaint.getTypeface(), r2) == true) goto L8;
        this.mPaint.setTypeface(r2);
        if (this.mLayout == null) goto L9;
        this.mLayout = null;
        requestLayout();
        invalidate();
        return;
    L9:
        return;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    @Override // android.view.View
    public void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getMode(r9);
        int r1 = View.MeasureSpec.getMode(r10);
        int r11 = View.MeasureSpec.getSize(r9);
        int r12 = View.MeasureSpec.getSize(r10);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (r0 != 1073741824) goto L9;
        if (r1 != 1073741824) goto L9;
        if (this.mAutoSizeTextType == 0) goto L18;
        this.mAutoSize = true;
    L18:
        setMeasuredDimension(r11, r12);
        return;
    L9:
        TextPaint r4 = this.mPaint;
        String r5 = this.mText;
        r4.getTextBounds(r5, 0, r5.length(), this.mTextBounds);
        if (r0 == 1073741824) goto L12;
        r11 = (int) (this.mTextBounds.width() + 0.99999f);
    L12:
        r11 = r11 + (this.mPaddingLeft + this.mPaddingRight);
        if (r1 == 1073741824) goto L18;
        int r2 = (int) (this.mPaint.getFontMetricsInt(null) + 0.99999f);
        if (r1 != Integer.MIN_VALUE) goto L17;
        r2 = Math.min(r12, r2);
    L17:
        r12 = (this.mPaddingTop + this.mPaddingBottom) + r2;
        goto L18
    }

    public void setRoundPercent(float r6) {
        if (this.mRoundPercent == r6) goto L5;
        boolean r0 = true;
    L6:
        this.mRoundPercent = r6;
        if (r6 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r0 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (this.mViewOutlineProvider != null) goto L17;
        ViewOutlineProvider r7 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r7;
        setOutlineProvider(r7);
    L17:
        setClipToOutline(true);
        int r8 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r8, r1) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r8, r1);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r2, r2, Path.Direction.CW);
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.mRound = r5;
        float r6 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r6);
        return;
    L7:
        if (this.mRound == r5) goto L9;
        boolean r0 = true;
    L10:
        this.mRound = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r0 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (this.mViewOutlineProvider != null) goto L21;
        ViewOutlineProvider r7 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r7;
        setOutlineProvider(r7);
    L21:
        setClipToOutline(true);
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r8 = this.mPath;
        RectF r1 = this.mRect;
        float r2 = this.mRound;
        r8.addRoundRect(r1, r2, r2, Path.Direction.CW);
        goto L23
    L9:
        r0 = false;
        goto L10
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getRound() {
        return this.mRound;
    }

    public void setTextSize(float r3) {
        this.mTextSize = r3;
        TextPaint r0 = this.mPaint;
        if (Float.isNaN(this.mBaseTextSize) == true) goto L6;
        r3 = this.mBaseTextSize;
    L6:
        r0.setTextSize(r3);
        if (Float.isNaN(this.mBaseTextSize) == false) goto L9;
        float r4 = 1.0f;
    L10:
        buildShape(r4);
        requestLayout();
        invalidate();
        return;
    L9:
        r4 = this.mTextSize / this.mBaseTextSize;
        goto L10
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public void setTextBackgroundPanX(float r1) {
        this.mBackgroundPanX = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float r1) {
        this.mBackgroundPanY = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float r1) {
        this.mZoom = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float r1) {
        this.mRotate = r1;
        updateShaderMatrix();
        invalidate();
    }

    private void updateShaderMatrix() {
        float r1 = 0.0f;
        if (Float.isNaN(this.mBackgroundPanX) == false) goto L5;
        float r0 = 0.0f;
    L7:
        if (Float.isNaN(this.mBackgroundPanY) == false) goto L9;
        float r2 = 0.0f;
    L11:
        if (Float.isNaN(this.mZoom) == false) goto L13;
        float r3 = 1.0f;
    L15:
        if (Float.isNaN(this.mRotate) == true) goto L18;
        r1 = this.mRotate;
    L18:
        this.mTextShaderMatrix.reset();
        float r4 = this.mTextBackgroundBitmap.getWidth();
        float r5 = this.mTextBackgroundBitmap.getHeight();
        if (Float.isNaN(this.mTextureWidth) == false) goto L21;
        float r6 = this.mFloatWidth;
    L23:
        if (Float.isNaN(this.mTextureHeight) == false) goto L25;
        float r7 = this.mFloatHeight;
    L27:
        if ((r4 * r7) >= (r5 * r6)) goto L29;
        float r8 = r6 / r4;
    L30:
        float r9 = r3 * r8;
        this.mTextShaderMatrix.postScale(r9, r9);
        float r10 = r4 * r9;
        float r11 = r6 - r10;
        float r12 = r9 * r5;
        float r13 = r7 - r12;
        if (Float.isNaN(this.mTextureHeight) == true) goto L34;
        r13 = this.mTextureHeight / 2.0f;
    L34:
        if (Float.isNaN(this.mTextureWidth) == true) goto L36;
        r11 = this.mTextureWidth / 2.0f;
    L36:
        float r14 = (((r2 * r13) + r7) - r12) * 0.5f;
        this.mTextShaderMatrix.postTranslate((((r0 * r11) + r6) - r10) * 0.5f, r14);
        this.mTextShaderMatrix.postRotate(r1, r6 / 2.0f, r7 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
        return;
    L29:
        r8 = r7 / r5;
        goto L30
    L25:
        r7 = this.mTextureHeight;
        goto L27
    L21:
        r6 = this.mTextureWidth;
        goto L23
    L13:
        r3 = this.mZoom;
        goto L15
    L9:
        r2 = this.mBackgroundPanY;
        goto L11
    L5:
        r0 = this.mBackgroundPanX;
        goto L7
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public void setTextPanX(float r1) {
        this.mTextPanX = r1;
        invalidate();
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public void setTextPanY(float r1) {
        this.mTextPanY = r1;
        invalidate();
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public void setTextureHeight(float r1) {
        this.mTextureHeight = r1;
        updateShaderMatrix();
        invalidate();
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public void setTextureWidth(float r1) {
        this.mTextureWidth = r1;
        updateShaderMatrix();
        invalidate();
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public void setScaleFromTextSize(float r1) {
        this.mBaseTextSize = r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_constraintlayout_utils_widget_MotionLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
