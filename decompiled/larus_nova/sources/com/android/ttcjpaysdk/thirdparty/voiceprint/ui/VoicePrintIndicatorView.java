package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintIndicatorView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barHeight", "", "barWidth", "colorProgressFill", "colorProgressTrack", "cornerRadius", "indicatorCount", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "states", "", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintIndicatorView$State;", "computeProgress", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetStates", "setCount", "count", "setState", "index", "state", "State", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintIndicatorView extends View {
    private final float barHeight;
    private final float barWidth;
    private final int colorProgressFill;
    private final int colorProgressTrack;
    private final float cornerRadius;
    private int indicatorCount;
    private final Paint paint;
    private final RectF rectF;
    private final List<State> states;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintIndicatorView$State;", "", "(Ljava/lang/String;I)V", "UNVERIFIED", "VERIFYING", "VERIFIED", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State UNVERIFIED = null;
        public static final State VERIFIED = null;
        public static final State VERIFYING = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{UNVERIFIED, VERIFYING, VERIFIED};
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            UNVERIFIED = new State("UNVERIFIED", 0);
            VERIFYING = new State("VERIFYING", 1);
            VERIFIED = new State("VERIFIED", 2);
            $VALUES = $values();
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VoicePrintIndicatorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public VoicePrintIndicatorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final float computeProgress() {
        if (this.indicatorCount > 0) goto L5;
        return 0.0f;
    L5:
        Iterator<State> r100 = this.states.iterator();
        int r101 = 0;
    L7:
        if (r100.hasNext() == false) goto L12;
        if (r100.next() != State.VERIFIED) goto L7;
        r101 = r101 + 1;
        goto L7
    L12:
        return RangesKt.coerceIn(RangesKt.coerceAtMost(r101 + 1, this.indicatorCount) / this.indicatorCount, 0.0f, 1.0f);
    }

    private final void resetStates() {
        this.states.clear();
        int r100 = this.indicatorCount;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.states.add(State.UNVERIFIED);
        r101 = r101 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.indicatorCount > 0) goto L5;
        return;
    L5:
        float r101 = getHeight() / 2.0f;
        float r102 = this.barHeight;
        float r103 = r101 - (r102 / 2.0f);
        float r104 = r101 + (r102 / 2.0f);
        float r105 = getWidth();
        float r106 = this.barWidth;
        float r107 = (r105 - r106) / 2.0f;
        this.paint.setColor(this.colorProgressTrack);
        this.rectF.set(r107, r103, r106 + r107, r104);
        RectF r108 = this.rectF;
        float r109 = this.cornerRadius;
        r100.drawRoundRect(r108, r109, r109, this.paint);
        float r110 = computeProgress();
        if (r110 > 0.0f) goto L8;
        return;
    L8:
        float r111 = this.barWidth;
        float r112 = RangesKt.coerceAtMost(r110 * r111, r111);
        this.paint.setColor(this.colorProgressFill);
        this.rectF.set(r107, r103, r112 + r107, r104);
        RectF r113 = this.rectF;
        float r114 = this.cornerRadius;
        r100.drawRoundRect(r113, r114, r114, this.paint);
    }

    public final void setCount(int r100) {
        if (r100 == this.indicatorCount) goto L6;
        this.indicatorCount = r100;
        resetStates();
        requestLayout();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        int r106 = (int) this.barWidth;
        int r107 = (int) this.barHeight;
        if (r102 == 1073741824) goto L6;
        r103 = r106;
    L6:
        if (r104 == 1073741824) goto L9;
        r105 = r107;
    L9:
        setMeasuredDimension(r103, r105);
    }

    public final void setState(int r100, State r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == false) goto L10;
        ListProtector.set(this.states, r100, r101);
        invalidate();
        return;
    L10:
        return;
    L5:
        if (r100 >= this.indicatorCount) goto L7;
        r102 = true;
        goto L7
    }

    public VoicePrintIndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.indicatorCount = 5;
        this.barWidth = CommonKt.dp2px(this, 80.0f);
        float r103 = CommonKt.dp2px(this, 4.0f);
        this.barHeight = r103;
        this.cornerRadius = r103 / 2.0f;
        this.states = new ArrayList();
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.FILL);
        this.paint = r104;
        this.rectF = new RectF();
        this.colorProgressTrack = ContextCompat.getColor(r100, R.color.voice_print_color_0D161823);
        this.colorProgressFill = ContextCompat.getColor(r100, R.color.voice_print_color_BF161823);
        resetStates();
    }

    public /* synthetic */ VoicePrintIndicatorView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
