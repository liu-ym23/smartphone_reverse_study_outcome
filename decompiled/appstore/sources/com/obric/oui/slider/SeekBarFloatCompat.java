package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000eJ\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0014J\u0013\u0010\u0017\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\n*\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/obric/oui/slider/SeekBarFloatCompat;", "Lcom/obric/oui/slider/SeekBarCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "minValue", "", "setMinValue", "(F)V", "maxValue", "setMaxValue", "progress", "setProgress", "getMinValue", "()F", "getMaxValue", "getFloatProgress", "X", "(F)I", "M", "(I)F", "decimals", "I", "(FI)F", "h0", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SeekBarFloatCompat extends SeekBarCompat {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final a f16959h0 = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f16959h0 = new a(null);
    }

    @JvmOverloads
    public SeekBarFloatCompat(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ float W(SeekBarFloatCompat r10, float r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r12 = 2;
    L6:
        return r10.I(r11, r12);
    }

    public final float I(float r10, int r11) {
        String r12 = String.format(Locale.CHINA, "%." + r11 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r10)}, 1));
        q.f(r12, "format(locale, this, *args)");
        return Float.parseFloat(r12);
    }

    public final float M(int r10) {
        return W(this, r10 / 100, 0, 1, null);
    }

    public final int X(float r10) {
        return (int) (r10 * 100);
    }

    public final float getFloatProgress() {
        return M(super.getProgress());
    }

    public final float getMaxValue() {
        return M(getMaxRealValue());
    }

    public final float getMinValue() {
        return M(getMinRealValue());
    }

    public final void setMaxValue(float r10) {
        super.setMaxValue(X(r10));
    }

    public final void setMinValue(float r10) {
        super.setMinValue(X(r10));
    }

    public final void setProgress(float r10) {
        super.setProgress(X(r10));
    }

    @JvmOverloads
    public SeekBarFloatCompat(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ SeekBarFloatCompat(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public SeekBarFloatCompat(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
