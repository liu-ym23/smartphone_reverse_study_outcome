package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {
    static final int DEFAULT_HYPHENATION_FREQUENCY = 0;
    static final float DEFAULT_LINE_SPACING_ADD = 0.0f;
    static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";

    @Nullable
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;

    @Nullable
    private static Object textDirection;
    private Layout.Alignment alignment;

    @Nullable
    private TextUtils.TruncateAt ellipsize;
    private int end;
    private int hyphenationFrequency;
    private boolean includePad;
    private boolean isRtl;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private final TextPaint paint;
    private CharSequence source;
    private int start;
    private final int width;

    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable r10) {
            super("Error thrown initializing StaticLayout " + r10.getMessage(), r10);
        }
    }

    static {
        DEFAULT_HYPHENATION_FREQUENCY = 1;
    }

    private StaticLayoutBuilderCompat(CharSequence r10, TextPaint r11, int r12) {
        this.source = r10;
        this.paint = r11;
        this.width = r12;
        this.start = 0;
        this.end = r10.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = Channel.UNLIMITED;
        this.lineSpacingAdd = DEFAULT_LINE_SPACING_ADD;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
        this.includePad = true;
        this.ellipsize = null;
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        if (initialized == false) goto L15;
        return;
    L15:
    L8:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L6:
        if (this.isRtl == false) goto L10;
        TextDirectionHeuristic r14 = TextDirectionHeuristics.RTL;     // Catch: Exception -> L8
    L11:
        textDirection = r14;     // Catch: Exception -> L8
        Class r13 = Integer.TYPE;     // Catch: Exception -> L8
        Class r10 = Float.TYPE;     // Catch: Exception -> L8
        Constructor<StaticLayout> r15 = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, r13, r13, TextPaint.class, r13, Layout.Alignment.class, TextDirectionHeuristic.class, r10, r10, Boolean.TYPE, TextUtils.TruncateAt.class, r13, r13});     // Catch: Exception -> L8
        constructor = r15;     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        initialized = true;     // Catch: Exception -> L8
        return;
    L10:
        r14 = TextDirectionHeuristics.LTR;     // Catch: Exception -> L8
        goto L11
    }

    @NonNull
    public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence r10, @NonNull TextPaint r11, @IntRange(from = 0) int r12) {
        return new StaticLayoutBuilderCompat(r10, r11, r12);
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if (this.source != null) goto L5;
        this.source = "";
    L5:
        int r10 = Math.max(0, this.width);
        CharSequence r11 = this.source;
        if (this.maxLines != 1) goto L8;
        r11 = TextUtils.ellipsize(r11, this.paint, r10, this.ellipsize);
    L8:
        int r12 = Math.min(r11.length(), this.end);
        this.end = r12;
        if (this.isRtl == true) goto L11;
    L13:
        StaticLayout.Builder r13 = StaticLayout.Builder.obtain(r11, this.start, r12, this.paint, r10);
        r13.setAlignment(this.alignment);
        r13.setIncludePad(this.includePad);
        if (this.isRtl == false) goto L16;
        TextDirectionHeuristic r14 = TextDirectionHeuristics.RTL;
    L17:
        r13.setTextDirection(r14);
        TextUtils.TruncateAt r15 = this.ellipsize;
        if (r15 == null) goto L20;
        r13.setEllipsize(r15);
    L20:
        r13.setMaxLines(this.maxLines);
        float r16 = this.lineSpacingAdd;
        if (r16 == DEFAULT_LINE_SPACING_ADD) goto L23;
    L24:
        r13.setLineSpacing(r16, this.lineSpacingMultiplier);
    L26:
        if (this.maxLines <= 1) goto L29;
        r13.setHyphenationFrequency(this.hyphenationFrequency);
    L29:
        return r13.build();
    L23:
        if (this.lineSpacingMultiplier == 1.0f) goto L26;
    L16:
        r14 = TextDirectionHeuristics.LTR;
        goto L17
    L11:
        if (this.maxLines != 1) goto L13;
        this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
        goto L13
    }

    @NonNull
    public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment r10) {
        this.alignment = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt r10) {
        this.ellipsize = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEnd(@IntRange(from = 0) int r10) {
        this.end = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setHyphenationFrequency(int r10) {
        this.hyphenationFrequency = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setIncludePad(boolean r10) {
        this.includePad = r10;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean r10) {
        this.isRtl = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setLineSpacing(float r10, float r11) {
        this.lineSpacingAdd = r10;
        this.lineSpacingMultiplier = r11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setMaxLines(@IntRange(from = 0) int r10) {
        this.maxLines = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStart(@IntRange(from = 0) int r10) {
        this.start = r10;
        return this;
    }
}
