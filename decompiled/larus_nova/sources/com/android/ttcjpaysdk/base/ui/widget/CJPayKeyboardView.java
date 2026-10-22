package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.bean.InsuranceConfiguration;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayKeyboardView extends KeyboardView implements KeyboardView.OnKeyboardActionListener {
    private static final int KEY_EMPTY = -300;
    private static final int KEY_INSURANCE_TIPS = -500;
    private static final int KEY_X = -10;
    private static final String TAG = "PwdKeyboardView";
    private InsuranceConfiguration insuranceConfiguration;
    private Bitmap insuranceIcon;
    private Rect keyIconRect;
    private OnKeyListener listener;
    private OnDoneListener onDoneListener;
    private boolean showX;
    private Paint textPaint;

    public interface OnDoneListener {
        void onDone();
    }

    public interface OnKeyListener {
        void onDelete();

        void onInput(String r100);
    }

    public void hideX() {
        this.showX = false;
        invalidate();
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onPress(int r100) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onRelease(int r100) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onText(CharSequence r100) {
    }

    public void showX() {
        this.showX = true;
        invalidate();
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeUp() {
    }

    private void initTextPaint() {
        Paint r100 = new Paint(1);
        this.textPaint = r100;
        r100.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setTextSize(CJPayBasicUtils.dipToPX(getContext(), 24.0f));
        this.textPaint.setColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_black_34));
    }

    public void showDone() {
        setKeyboard(new Keyboard(getContext(), R.xml.cj_pay_key_board_number_contains_done));
        setInsuranceImage();
    }

    private void setInsuranceImage() {
        InsuranceConfiguration r100 = CJPaySettingsManager.getInstance().getInsuranceConfig();
        this.insuranceConfiguration = r100;
        if (r100.show == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.unified_keyboard_icon) == true) goto L9;
        ImageLoader.Companion.getInstance().loadImage(this.insuranceConfiguration.unified_keyboard_icon, new AnonymousClass1(this));
        return;
    }

    public void showInsurance() {
        InsuranceConfiguration r100 = CJPaySettingsManager.getInstance().getInsuranceConfig();
        this.insuranceConfiguration = r100;
        if (r100.show == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.unified_keyboard_icon) == true) goto L9;
        setKeyboard(new Keyboard(getContext(), R.xml.cj_pay_key_board_number_with_insurance));
        setInsuranceImage();
        return;
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        Iterator<Keyboard.Key> r101 = getKeyboard().getKeys().iterator();
    L4:
        if (r101.hasNext() == false) goto L24;
        Keyboard.Key r102 = r101.next();
        if (r102.codes[0] != (-10)) goto L11;
        drawKeyBackground(r102, r100);
        if (this.showX == false) goto L11;
        drawKeyLabel(r102, r100, CJPayBasicUtils.dipToPX(getContext(), 22.0f), 0);
    L11:
        if (r102.codes[0] != (-4)) goto L14;
        drawKeyBackground(r102, r100);
        drawKeyLabel(r102, r100, CJPayBasicUtils.dipToPX(getContext(), 16.0f), r102.width / 3);
    L14:
        if (r102.codes[0] != (-300)) goto L17;
        drawKeyBackground(r102, r100);
    L17:
        if (r102.codes[0] != (-5)) goto L20;
        drawKeyBackground(r102, r100);
        drawKeyIcon(r102, r100, getResources().getDrawable(R.drawable.cj_pay_icon_pwd_delete));
    L20:
        if (r102.codes[0] != (-500)) goto L4;
        drawKeyBackground(r102, r100);
        if (this.insuranceConfiguration.show == false) goto L4;
        drawInsuranceView(r100, this.insuranceIcon);
        goto L4
    }

    public void onKeyForShoots(int r100) {
        onKey(r100, new int[]{0});
    }

    public void setOnDoneListener(OnDoneListener r100) {
        this.onDoneListener = r100;
    }

    public void setOnKeyListener(OnKeyListener r100) {
        this.listener = r100;
    }

    public CJPayKeyboardView(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r100, r101);
    }

    public static /* synthetic */ Bitmap access$002(CJPayKeyboardView r100, Bitmap r101) {
        r100.insuranceIcon = r101;
        return r101;
    }

    private void drawInsuranceView(Canvas r100, Bitmap r101) {
        if (getContext() == null) goto L7;
        if (r101 == null) goto L8;
        int r102 = CJPayBasicUtils.dipToPX(getContext(), 200.0f);
        int r103 = CJPayBasicUtils.dipToPX(getContext(), 20.0f);
        int r104 = (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getContext()) - r102) / 2;
        int r105 = (CJPayBasicUtils.dipToPX(getContext(), 30.0f) - r103) / 2;
        BitmapDrawable r106 = new BitmapDrawable(getContext().getResources(), r101);
        r106.setBounds(r104, r105, r102 + r104, r103 + r105);
        r106.draw(r100);
        return;
    L8:
        return;
    }

    private void drawKeyBackground(Keyboard.Key r100, Canvas r101) {
        Drawable r102 = getResources().getDrawable(R.drawable.cj_pay_bg_pwd_delete_and_empty_key_board);
        int r103 = r100.x;
        int r104 = r100.y;
        r102.setBounds(r103, r104, r100.width + r103, r100.height + r104);
        r102.draw(r101);
    }

    private void init(Context r100, AttributeSet r101) {
        setKeyboard(new Keyboard(r100, R.xml.cj_pay_key_board_number));
        setEnabled(true);
        setFocusable(true);
        setPreviewEnabled(false);
        setOnKeyboardActionListener(this);
        initTextPaint();
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayShowX});
        this.showX = r102.getBoolean(0, false);
        r102.recycle();
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onKey(int r100, int[] r101) {
        if (r100 != (-500)) goto L6;
        return;
    L6:
        if (r100 == (-10)) goto L8;
        OnKeyListener r102 = this.listener;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r100 != (-5)) goto L17;
        r102.onDelete();
        return;
    L17:
        if (r100 != (-4)) goto L22;
        OnDoneListener r103 = this.onDoneListener;
        if (r103 == null) goto L28;
        r103.onDone();
        return;
    L28:
        return;
    L22:
        if (r100 == (-300)) goto L30;
        r102.onInput(String.valueOf((char) r100));
        return;
    L30:
        return;
    L8:
        if (this.showX == false) goto L25;
        this.listener.onInput("X");
        return;
    }

    public CJPayKeyboardView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100, r101);
    }

    private void drawKeyIcon(Keyboard.Key r100, Canvas r101, Drawable r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        Rect r103 = this.keyIconRect;
        if (r103 != null) goto L7;
    L8:
        int r104 = r102.getIntrinsicWidth();
        int r105 = r102.getIntrinsicHeight();
        int r106 = r100.width;
        if (r104 <= r106) goto L11;
        r105 = (int) (((r106 * 1.0f) / r104) * r105);
        r104 = r106;
    L14:
        int r107 = (r100.x + (r106 / 2)) - (r104 / 2);
        int r108 = (r100.y + (r100.height / 2)) - (r105 / 2);
        this.keyIconRect = new Rect(r107, r108, r104 + r107, r105 + r108);
    L15:
        Rect r109 = this.keyIconRect;
        if (r109 != null) goto L18;
        return;
    L18:
        if (r109.isEmpty() == true) goto L22;
        r102.setBounds(this.keyIconRect);
        r102.draw(r101);
        return;
    L22:
        return;
    L11:
        int r110 = r100.height;
        if (r105 <= r110) goto L14;
        r104 = (int) (((r110 * 1.0f) / r105) * r104);
        r105 = r110;
        goto L14
    L7:
        if (r103.isEmpty() == false) goto L15;
        goto L8
    }

    private void drawKeyLabel(Keyboard.Key r100, Canvas r101, int r102, int r110) {
        if (r100.label == null) goto L6;
        this.textPaint.setTextSize(r102);
        Paint.FontMetrics r103 = this.textPaint.getFontMetrics();
        double r104 = ((double) r100.y) + (((double) r100.height) / 2.0d);
        float r105 = r103.bottom;
        r101.drawText(r100.label.toString(), (r100.x + (r100.width / 2)) + r110, (float) ((r104 + ((double) ((r105 - r103.top) / 2.0f))) - ((double) r105)), this.textPaint);
        return;
    }
}
