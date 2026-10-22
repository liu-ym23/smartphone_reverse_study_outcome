package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.apm.battery.dao.DBHelper;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SeekBarFloatCompat.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u0007H\u0002J\f\u0010\u0019\u001a\u00020\n*\u00020\u0007H\u0002J\f\u0010\u001a\u001a\u00020\u0007*\u00020\nH\u0002¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/slider/SeekBarFloatCompat;", "Lcom/obric/oui/slider/SeekBarCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getFloatProgress", "", "getMaxValue", "getMinValue", "setMaxValue", "", "maxValue", "setMinValue", "minValue", "setProgress", "progress", DBHelper.BATTERY_COL_PROCESS_NAME, "animate", "", "round", "decimals", "toRealValue", "toWrapValue", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SeekBarFloatCompat extends SeekBarCompat {
    public static final Companion Companion = null;
    private static final int MULTIPLE = 100;

    /* JADX INFO: compiled from: SeekBarFloatCompat.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/slider/SeekBarFloatCompat$Companion;", "", "()V", "MULTIPLE", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SeekBarFloatCompat(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public SeekBarFloatCompat(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    private final int toWrapValue(float r1) {
        return (int) (r1 * 100);
    }

    public /* synthetic */ SeekBarFloatCompat(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public SeekBarFloatCompat(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
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
        Intrinsics.checkNotNullExpressionValue(r3, "format(locale, this, *args)");
        return Float.parseFloat(r3);
    }

    static /* synthetic */ float round$default(SeekBarFloatCompat r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 2;
    L6:
        return r0.round(r1, r2);
    }
}
