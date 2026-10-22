package com.obric.oui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.widget.TextClock;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class OTextClock extends TextClock {
    private volatile TextView.BufferType mOriginalBufferType;
    private volatile CharSequence mOriginalText;
    private volatile float mRatio;
    private final Set<Character> mTargetCharacters;

    /* JADX INFO: renamed from: com.obric.oui.text.OTextClock$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36326a = null;

        static {
            int[] r0 = new int[Layout.Alignment.values().length];
            f36326a = r0;
            r0[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f36326a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f36326a[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class CustomCharacterSpan extends ReplacementSpan {
        private float originalWidth;
        private final float widthScale;

        public CustomCharacterSpan(float r2) {
            this.originalWidth = -1.0f;
            this.widthScale = r2;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (this.originalWidth >= 0.0f) goto L6;
            this.originalWidth = r2.measureText(r7, r4, r5);
        L6:
            return (int) (this.originalWidth * this.widthScale);
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
            if (this.originalWidth >= 0.0f) goto L6;
            this.originalWidth = r18.measureText(r3, r12, r13);
        L6:
            float r2 = this.originalWidth;
            r10.drawText(r3, r12, r13, calculateOffsetX(r14, r2, this.widthScale * r2), r16, r18);
        }

        private float calculateOffsetX(float r2, float r3, float r4) {
            Layout.Alignment r1 = getTextAlignment();
            int r5 = AnonymousClass1.f36326a[r1.ordinal()];
            if (r5 != 1) goto L5;
            float r6 = (r3 - r4) / 2.0f;
        L9:
            return r2 - r6;
        L5:
            if (r5 == 2) goto L7;
            return r2;
        L7:
            r6 = r3 - r4;
            goto L9
        }

        private Layout.Alignment getTextAlignment() {
            return Layout.Alignment.ALIGN_CENTER;
        }
    }

    public OTextClock(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mTargetCharacters = ConcurrentHashMap.newKeySet();
        this.mRatio = 1.0f;
        this.mOriginalText = "";
        this.mOriginalBufferType = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mTargetCharacters = ConcurrentHashMap.newKeySet();
        this.mRatio = 1.0f;
        this.mOriginalText = "";
        this.mOriginalBufferType = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        this.mTargetCharacters = ConcurrentHashMap.newKeySet();
        this.mRatio = 1.0f;
        this.mOriginalText = "";
        this.mOriginalBufferType = TextView.BufferType.NORMAL;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r3, TextView.BufferType r4) {
        this.mOriginalText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mOriginalBufferType = r4;
        applyTextWithFormatting();
    }

    private void applyTextWithFormatting() {
        if (this.mOriginalText != null) goto L5;
        return;
    L5:
        if (this.mOriginalText.length() > 0) goto L7;
        return;
    L7:
        if (isFormattingEnabled() == false) goto L9;
        super.setText(applyCustomCharacterSpacing(this.mOriginalText), this.mOriginalBufferType);
    L10:
        invalidate();
        return;
    L9:
        super.setText(this.mOriginalText, this.mOriginalBufferType);
        goto L10
    }

    private CharSequence applyCustomCharacterSpacing(CharSequence r9) {
        String r10 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        SpannableString r0 = new SpannableString(r10);
        HashSet r2 = new HashSet(this.mTargetCharacters);
        float r8 = this.mRatio;
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        char r4 = ((Character) ZeusTransformUtils.preCheckCast(r3.next(), Character.class, "com.obric.aiagent.plugin")).charValue();
        int r5 = r10.indexOf(r4);
    L6:
        if (r5 < 0) goto L4;
        int r6 = r5 + 1;
        r0.setSpan(new CustomCharacterSpan(r8), r5, r6, 33);
        r5 = r10.indexOf(r4, r6);
        goto L6
    L8:
        return r0;
    }

    public void setRatio(float r1) {
        this.mRatio = r1;
        applyTextWithFormatting();
    }

    public void setTargetCharacters(char[] r5) {
        this.mTargetCharacters.clear();
        if (r5 == null) goto L7;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        char r2 = r5[r1];
        this.mTargetCharacters.add(Character.valueOf(r2));
        r1 = r1 + 1;
    L7:
        applyTextWithFormatting();
    }

    private boolean isFormattingEnabled() {
        return !this.mTargetCharacters.isEmpty();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r1) {
        super.setTextSize(r1);
        applyTextWithFormatting();
    }

    @Override // android.widget.TextView
    public void setTextSize(int r1, float r2) {
        super.setTextSize(r1, r2);
        applyTextWithFormatting();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r1) {
        super.setTypeface(r1);
        applyTextWithFormatting();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r1, int r2) {
        super.setTypeface(r1, r2);
        applyTextWithFormatting();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float r1, float r2) {
        super.setLineSpacing(r1, r2);
        applyTextWithFormatting();
    }
}
