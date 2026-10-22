package com.obric.oui.forms;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.GetChars;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ReplacementSpan;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class OPasswordTransformationMethod extends PasswordTransformationMethod {
    private static final int CACHE_RETAIN_EXTRA_SIZE = 16;
    private static final int CACHE_SHRINK_THRESHOLD = 32;
    private static final char DEFAULT_MASK_CHAR = 8226;
    private final float mDotSizeRatio;
    private final float mDotSpacingRatio;
    private final int mErrorBackgroundColor;
    private PasswordMaskSpanned mPasswordMaskSpanned;
    private boolean mShowErrorBackground;

    private static class IndexedPasswordMaskSpan extends ReplacementSpan {
        private final float mDotSizeRatio;
        private final float mDotSpacingRatio;
        private final int mErrorBackgroundColor;
        private boolean mIsShowErrorBackground;
        private final int start;

        static /* synthetic */ int access$000(IndexedPasswordMaskSpan r0) {
            return r0.start;
        }

        IndexedPasswordMaskSpan(int r2, float r3, float r4, int r5) {
            this.mIsShowErrorBackground = false;
            this.start = r2;
            this.mDotSizeRatio = r3;
            this.mDotSpacingRatio = r4;
            this.mErrorBackgroundColor = r5;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            copyFontMetrics(r3, r7);
            if (isMaskChar(r8, r5) == false) goto L5;
            float r9 = r3.getTextSize();
            float r10 = (this.mDotSizeRatio * r9) + (r9 * this.mDotSpacingRatio);
        L7:
            return (int) Math.ceil(r10);
        L5:
            r10 = r3.measureText(r8, r5, r6);
            goto L7
        }

        public void setShowErrorBackground(boolean r1) {
            this.mIsShowErrorBackground = r1;
        }

        public boolean isShowErrorBackground() {
            return this.mIsShowErrorBackground;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r12, CharSequence r13, int r14, int r15, float r16, int r17, int r18, int r19, Paint r20) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
            if (isMaskChar(r3, r14) == true) goto L6;
            r12.drawText(r3, r14, r15, r16, r18, r20);
            return;
        L6:
            float r4 = r20.getTextSize();
            float r5 = this.mDotSizeRatio * r4;
            float r6 = (r4 * this.mDotSpacingRatio) + r5;
            float r7 = r5 / 2.0f;
            float r8 = r16 + r7;
            float r9 = (r17 + r19) / 2.0f;
            Paint.Style r10 = r20.getStyle();
            r20.setStyle(Paint.Style.FILL);
            if (this.mIsShowErrorBackground == false) goto L9;
            int r11 = r20.getColor();
            r20.setColor(this.mErrorBackgroundColor);
            r12.drawRect(Math.round(r16), r17, Math.round((r16 + r6) + 0.5f), r19, r20);
            r20.setColor(r11);
        L9:
            r12.drawCircle(r8, r9, r7, r20);
            r20.setStyle(r10);
        }

        private boolean isMaskChar(CharSequence r2, int r3) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            if (r3 >= 0) goto L5;
        L9:
            return false;
        L5:
            if (r3 >= r1.length()) goto L9;
            if (r1.charAt(r3) != 8226) goto L9;
            return true;
        }

        private void copyFontMetrics(Paint r1, Paint.FontMetricsInt r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            Paint.FontMetricsInt r0 = r1.getFontMetricsInt();
            r2.ascent = r0.ascent;
            r2.descent = r0.descent;
            r2.top = r0.top;
            r2.bottom = r0.bottom;
        }
    }

    private static class PasswordMaskSpanned implements GetChars, Spanned {
        private final ArrayList<IndexedPasswordMaskSpan> cachedMaskSpans;
        private CharSequence delegate;
        private final float mDotSizeRatio;
        private final float mDotSpacingRatio;
        private final int mErrorBackgroundColor;
        private boolean mIsShowErrorBackground;

        PasswordMaskSpanned(CharSequence r3, float r4, float r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.mIsShowErrorBackground = false;
            this.cachedMaskSpans = new ArrayList();
            this.delegate = r7;
            this.mDotSizeRatio = r4;
            this.mDotSpacingRatio = r5;
            this.mErrorBackgroundColor = r6;
        }

        void updateDelegate(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (this.delegate != r4) goto L5;
            return;
        L5:
            this.delegate = r4;
        }

        private CharSequence requireDelegate() {
            CharSequence r0 = this.delegate;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return requireDelegate().length();
        }

        @Override // java.lang.CharSequence
        public char charAt(int r1) {
            return requireDelegate().charAt(r1);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r1, int r2) {
            return requireDelegate().subSequence(r1, r2);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return requireDelegate().toString();
        }

        @Override // android.text.GetChars
        public void getChars(int r3, int r4, char[] r5, int r6) {
            CharSequence r2 = requireDelegate();
            if (ZeusTransformUtils.instanceOf(r2, GetChars.class) == false) goto L5;
            ((GetChars) ZeusTransformUtils.preCheckCast(r2, GetChars.class, "com.obric.aiagent.plugin")).getChars(r3, r4, r5, r6);
            return;
        L5:
            TextUtils.getChars(r2, r3, r4, r5, r6);
        }

        @Override // android.text.Spanned
        public <T> T[] getSpans(int r9, int r10, Class<T> r11) {
            CharSequence r0 = requireDelegate();
            ArrayList r1 = new ArrayList();
            if (ZeusTransformUtils.instanceOf(r0, Spanned.class) == false) goto L8;
            Object[] r2 = ((Spanned) ZeusTransformUtils.preCheckCast(r0, Spanned.class, "com.obric.aiagent.plugin")).getSpans(r9, r10, r11);
            int r5 = r2.length;
            int r6 = 0;
        L5:
            if (r6 >= r5) goto L8;
            r1.add(r2[r6]);
            r6 = r6 + 1;
        L8:
            if (r11.isAssignableFrom(IndexedPasswordMaskSpan.class) == false) goto L10;
        L13:
            ensureMaskSpanCache(length());
            int r12 = Math.max(r9, 0);
            int r13 = Math.min(r10, length());
        L14:
            if (r12 >= r13) goto L20;
            if (r0.charAt(r12) != 8226) goto L18;
            r1.add(r11.cast((IndexedPasswordMaskSpan) ZeusTransformUtils.preCheckCast(this.cachedMaskSpans.get(r12), IndexedPasswordMaskSpan.class, "com.obric.aiagent.plugin")));
        L18:
            r12 = r12 + 1;
        L20:
            return (T[]) toTypedArray(r1, r11);
        L10:
            if (r11.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r11.isAssignableFrom(Object.class) == false) goto L20;
            goto L13
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, IndexedPasswordMaskSpan.class) == true) goto L5;
            CharSequence r2 = requireDelegate();
            if (ZeusTransformUtils.instanceOf(r2, Spanned.class) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.aiagent.plugin")).getSpanStart(r3);
        L5:
            return IndexedPasswordMaskSpan.access$000((IndexedPasswordMaskSpan) ZeusTransformUtils.preCheckCast(r3, IndexedPasswordMaskSpan.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, IndexedPasswordMaskSpan.class) == true) goto L5;
            CharSequence r2 = requireDelegate();
            if (ZeusTransformUtils.instanceOf(r2, Spanned.class) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.aiagent.plugin")).getSpanEnd(r3);
        L5:
            return IndexedPasswordMaskSpan.access$000((IndexedPasswordMaskSpan) ZeusTransformUtils.preCheckCast(r3, IndexedPasswordMaskSpan.class, "com.obric.aiagent.plugin")) + 1;
        }

        @Override // android.text.Spanned
        public int getSpanFlags(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, IndexedPasswordMaskSpan.class) == false) goto L6;
            return 33;
        L6:
            CharSequence r2 = requireDelegate();
            if (ZeusTransformUtils.instanceOf(r2, Spanned.class) == true) goto L9;
            return 0;
        L9:
            return ((Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.aiagent.plugin")).getSpanFlags(r3);
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int r4, int r5, Class r6) {
            CharSequence r0 = requireDelegate();
            if (ZeusTransformUtils.instanceOf(r0, Spanned.class) == false) goto L5;
            int r1 = ((Spanned) ZeusTransformUtils.preCheckCast(r0, Spanned.class, "com.obric.aiagent.plugin")).nextSpanTransition(r4, r5, r6);
        L6:
            if (r6 != null) goto L8;
        L13:
            ensureMaskSpanCache(length());
            int r7 = Math.max(r4, 0);
            int r3 = Math.min(r5, length());
        L14:
            if (r7 >= r3) goto L21;
            if (r0.charAt(r7) != 8226) goto L20;
            if (r7 <= r4) goto L19;
            r1 = Math.min(r1, r7);
        L19:
            r1 = Math.min(r1, r7 + 1);
        L20:
            r7 = r7 + 1;
        L21:
            return r1;
        L8:
            if (r6.isAssignableFrom(IndexedPasswordMaskSpan.class) == true) goto L13;
            if (r6.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r6.isAssignableFrom(Object.class) == false) goto L21;
        L5:
            r1 = r5;
            goto L6
        }

        public void setShowErrorBackground(boolean r5) {
            this.mIsShowErrorBackground = r5;
            int r0 = 0;
        L4:
            if (r0 >= this.cachedMaskSpans.size()) goto L6;
            ((IndexedPasswordMaskSpan) ZeusTransformUtils.preCheckCast(this.cachedMaskSpans.get(r0), IndexedPasswordMaskSpan.class, "com.obric.aiagent.plugin")).setShowErrorBackground(r5);
            r0 = r0 + 1;
            goto L4
        }

        public boolean isShowErrorBackground() {
            return this.mIsShowErrorBackground;
        }

        private void ensureMaskSpanCache(int r6) {
        L3:
            if (this.cachedMaskSpans.size() >= r6) goto L5;
            IndexedPasswordMaskSpan r1 = new IndexedPasswordMaskSpan(this.cachedMaskSpans.size(), this.mDotSizeRatio, this.mDotSpacingRatio, this.mErrorBackgroundColor);
            r1.setShowErrorBackground(this.mIsShowErrorBackground);
            this.cachedMaskSpans.add(r1);
            goto L3
        L5:
            shrinkMaskSpanCacheIfNeeded(r6);
        }

        private void shrinkMaskSpanCacheIfNeeded(int r3) {
            int r4 = r3 + 16;
            if (this.cachedMaskSpans.size() > (r4 + 32)) goto L5;
            return;
        L5:
            ArrayList<IndexedPasswordMaskSpan> r2 = this.cachedMaskSpans;
            r2.subList(r4, r2.size()).clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <T> T[] toTypedArray(List<T> r2, Class<T> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            T[] r5 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r3, r4.size()), Object[].class, "com.obric.aiagent.plugin"));
            int r0 = 0;
        L4:
            if (r0 >= r4.size()) goto L6;
            r5[r0] = r4.get(r0);
            r0 = r0 + 1;
            goto L4
        L6:
            return r5;
        }
    }

    public OPasswordTransformationMethod(float r2, float r3, int r4) {
        this.mShowErrorBackground = false;
        this.mDotSizeRatio = r2;
        this.mDotSpacingRatio = r3;
        this.mErrorBackgroundColor = r4;
    }

    public float getDotSizeRatio() {
        return this.mDotSizeRatio;
    }

    public float getDotSpacingRatio() {
        return this.mDotSpacingRatio;
    }

    public int getErrorBackgroundColor() {
        return this.mErrorBackgroundColor;
    }

    public void setShowErrorBackground(boolean r2) {
        if (this.mShowErrorBackground == r2) goto L8;
        this.mShowErrorBackground = r2;
        PasswordMaskSpanned r1 = this.mPasswordMaskSpanned;
        if (r1 == null) goto L9;
        r1.setShowErrorBackground(r2);
        return;
    L9:
        return;
    }

    public boolean isShowErrorBackground() {
        return this.mShowErrorBackground;
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r4, View r5) {
        CharSequence r6 = super.getTransformation((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"), r5);
        PasswordMaskSpanned r7 = this.mPasswordMaskSpanned;
        if (r7 != null) goto L5;
        this.mPasswordMaskSpanned = new PasswordMaskSpanned(r6, this.mDotSizeRatio, this.mDotSpacingRatio, this.mErrorBackgroundColor);
    L6:
        this.mPasswordMaskSpanned.setShowErrorBackground(this.mShowErrorBackground);
        return this.mPasswordMaskSpanned;
    L5:
        r7.updateDelegate(r6);
        goto L6
    }
}
