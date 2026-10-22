package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: SeekBarFloatCompat.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SeekBarFloatCompat extends SeekBarCompat {
    public static final a Companion = null;
    private static final int MULTIPLE = 100;

    /* JADX INFO: compiled from: SeekBarFloatCompat.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public SeekBarFloatCompat(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public SeekBarFloatCompat(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    private final int toWrapValue(float r1) {
        return (int) (r1 * 100);
    }

    public /* synthetic */ SeekBarFloatCompat(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public SeekBarFloatCompat(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    public final void setMinValue(float r1) {
        super.setMinValue(toWrapValue(r1));
    }

    public final void setMaxValue(float r1) {
        super.setMaxValue(toWrapValue(r1));
    }

    public final void setProgress(float r1) {
        super.setProgress(toWrapValue(r1));
    }

    public final void setProgress(float r1, boolean r2) {
        super.setProgress(toWrapValue(r1), r2);
    }

    public final float getMinValue() {
        return toRealValue(getMinRealValue());
    }

    public final float getMaxValue() {
        return toRealValue(getMaxRealValue());
    }

    public final float getFloatProgress() {
        return toRealValue(super.getProgress());
    }

    private final float toRealValue(int r4) {
        return round$default(this, r4 / 100, 0, 1, null);
    }

    private final float round(float r4, int r5) {
        String r3 = String.format(Locale.CHINA, "%." + r5 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r4)}, 1));
        o.c(r3, "format(locale, this, *args)");
        return Float.parseFloat(r3);
    }

    static /* synthetic */ float round$default(SeekBarFloatCompat r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 2;
    L6:
        return r0.round(r1, r2);
    }
}
