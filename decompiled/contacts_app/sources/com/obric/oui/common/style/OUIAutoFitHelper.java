package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.obric.common.oui.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class OUIAutoFitHelper {
    private static final float DEFAULT_FONT_SCALE = 0.8f;
    private static final int MAX_LINES_SINGLE = 1;
    private static final String TAG = "OUIAutoFitHelper";
    private float mFontScale;
    private boolean mIsHeadFlag;
    private boolean mIsMarquee;
    private boolean mIsSingleLine;
    private WeakReference<OUIAutoFitListener> mListener;
    private int mMaxLine;
    private float mOriginSize;
    private float mScaleFontSize;
    private WeakReference<TextView> mView;

    public interface OUIAutoFitListener {
        void resetTextSize(float r1);
    }

    public OUIAutoFitHelper(TextView r2, OUIAutoFitListener r3) {
        this.mFontScale = 0.8f;
        this.mView = new WeakReference(r2);
        this.mListener = new WeakReference(r3);
    }

    public void loadFromAttributes(AttributeSet r6, int r7) {
        TextView r0 = this.mView.get();
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "loadFromAttributes mView is null");
        return;
    L6:
        Context r1 = r0.getContext();
        this.mOriginSize = r0.getTextSize();
        int r2 = r0.getMaxLines();
        this.mMaxLine = r2;
        boolean r3 = true;
        if (r2 != 1) goto L9;
        boolean r4 = true;
    L10:
        this.mIsSingleLine = r4;
        if (r6 != null) goto L13;
        if (r7 != 0) goto L13;
    L20:
        this.mScaleFontSize = this.mOriginSize * this.mFontScale;
        if (r0.getEllipsize() == TextUtils.TruncateAt.MARQUEE) goto L24;
        r3 = false;
    L24:
        this.mIsMarquee = r3;
        return;
    L13:
        TypedArray r8 = r1.getTheme().obtainStyledAttributes(r6, R.styleable.OUIAutoFit, 0, 0);
        this.mFontScale = r8.getFloat(R.styleable.OUIAutoFit_OUI_font_scale, 0.8f);     // Catch: Throwable -> L16 Exception -> L26
    L16:
        th = move-exception;
        r8.recycle();
        throw th;
    L19:
        r8.recycle();
        goto L20
    L9:
        r4 = false;
        goto L10
    }

    public void setFontScale(float r2) {
        if (r2 >= 1.0f) goto L6;
        this.mFontScale = r2;
        this.mScaleFontSize = this.mOriginSize * r2;
        return;
    }

    public void setHeadFlag(boolean r1) {
        this.mIsHeadFlag = r1;
    }

    public boolean needMarquee() {
        if (this.mIsSingleLine == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsMarquee == false) goto L7;
        return true;
    }

    public float getScaleFontSize() {
        return this.mScaleFontSize;
    }

    public float getOriginSize() {
        return this.mOriginSize;
    }

    public float getFontScale() {
        return this.mFontScale;
    }

    public boolean isSingleLine() {
        return this.mIsSingleLine;
    }

    public boolean needReset() {
        if (this.mOriginSize <= this.mScaleFontSize) goto L5;
        return true;
    L5:
        return false;
    }

    public void setTextSize(TextView r2) {
        if (r2 == null) goto L5;
        float r3 = r2.getTextSize();
        this.mOriginSize = r3;
        this.mScaleFontSize = r3 * this.mFontScale;
        return;
    }

    public void setOriginSize() {
        WeakReference<TextView> r0 = this.mView;
        if (r0 != null) goto L5;
        return;
    L5:
        TextView r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        float r2 = this.mOriginSize;
        if (r2 <= 0.0f) goto L11;
        r1.setTextSize(0, r2);
    L11:
        r1.setFontVariationSettings(null);
    }

    public boolean needReMeasure() {
        WeakReference<TextView> r0 = this.mView;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        TextView r2 = r0.get();
        if (r2 != null) goto L8;
        return false;
    L8:
        Layout r3 = r2.getLayout();
        if (r3 != null) goto L11;
    L41:
        return false;
    L11:
        if (this.mOriginSize <= 0.0f) goto L41;
        int r4 = r3.getLineCount();
        if (this.mIsSingleLine == true) goto L15;
        boolean r5 = needReset();
        if (this.mIsHeadFlag == false) goto L29;
        if (r5 == false) goto L34;
        if (r4 <= 1) goto L34;
    L28:
        r1 = true;
    L34:
        if (r1 == false) goto L40;
        WeakReference<OUIAutoFitListener> r6 = this.mListener;
        if (r6 == null) goto L40;
        if (r6.get() == null) goto L40;
        this.mListener.get().resetTextSize(this.mScaleFontSize);
    L40:
        return true;
    L29:
        int r7 = r3.getEllipsisCount(r4 - 1);
        if (r5 == false) goto L34;
        if (r7 <= 0) goto L34;
        if (r4 <= 0) goto L34;
    L15:
        if (r3.getEllipsisCount(r4 - 1) <= 0) goto L41;
        if (needReset() == false) goto L41;
        WeakReference<OUIAutoFitListener> r8 = this.mListener;
        if (r8 != null) goto L21;
    L23:
        return true;
    L21:
        if (r8.get() == null) goto L23;
        this.mListener.get().resetTextSize(this.mScaleFontSize);
        goto L23
    }

    public void resetFontVariationSettings() {
        if (this.mIsSingleLine == false) goto L5;
        return;
    L5:
        WeakReference<TextView> r2 = this.mView;
        if (r2 != null) goto L8;
        return;
    L8:
        TextView r3 = r2.get();
        if (r3 != null) goto L11;
        return;
    L11:
        Layout r0 = r3.getLayout();
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.getEllipsisCount(r0.getLineCount() - 1) <= 0) goto L18;
        r3.setFontVariationSettings("'wdth' 70");
        return;
    }
}
