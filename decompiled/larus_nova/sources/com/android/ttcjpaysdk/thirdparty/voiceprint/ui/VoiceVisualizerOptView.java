package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 J2\u00020\u0001:\u0002IJB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\rH\u0002J\u0006\u0010+\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\u000fJ\b\u0010-\u001a\u00020#H\u0014J\u0010\u0010.\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0014J(\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0014J\u0010\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0002J\b\u00106\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020#2\u0006\u00100\u001a\u00020\tH\u0002J\u000e\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\tJ\u0016\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tJ\u0010\u0010=\u001a\u00020#2\b\b\u0001\u0010>\u001a\u00020\tJ\u000e\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\rJ\u000e\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\rJ\"\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\r2\b\b\u0002\u0010E\u001a\u00020\r2\b\b\u0002\u0010F\u001a\u00020\rJ\u0006\u0010G\u001a\u00020#J\u0006\u0010H\u001a\u00020#R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceVisualizerOptView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "amplitude", "Ljava/util/LinkedList;", "", "animating", "", "barCount", "barParams", "", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceVisualizerOptView$BarParam;", "barWidth", "customWaveGroupCount", "endAlphaSize", "gapWidth", "lastTime", "", "maxBarHeight", "minBarHeight", "paint", "Landroid/graphics/Paint;", "sideMargin", "startAlphaSize", "visualizerWidth", "waveGroupNumber", "drawBars", "", "stage", "canvas", "Landroid/graphics/Canvas;", "ensureCapacity", "capacity", "genBarData", "currAmp", "getVisualizerWidth", "isAnimating", "onDetachedFromWindow", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "paintAlpha", "index", "popMaxAmplitude", "recalcSize", "setCustomWaveGroupCount", "count", "setGradient", "startSize", "endSize", "setPaintColor", "color", "setSideMargin", "marginPx", "setVolume01", "value", "setVolumeDb", "db", "minDb", "maxDb", "startWaveAnim", "stopWaveAnim", "BarParam", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoiceVisualizerOptView extends View {
    private static final int AMPLITUDE_WINDOW = 10;
    private static final int BAR_TYPE_OTHER = 2;
    private static final int BAR_TYPE_SIDE = 1;
    private static final int BAR_TYPE_TOP = 0;
    public static final Companion Companion = null;
    private static final long FRAME_DURATION_MS = 400;
    private static final int GROUP_TYPE_OTHER = 2;
    private static final int GROUP_TYPE_SIDE = 1;
    private static final int GROUP_TYPE_TOP = 0;
    private final LinkedList<Float> amplitude;
    private boolean animating;
    private int barCount;
    private final Map<Integer, BarParam> barParams;
    private final float barWidth;
    private int customWaveGroupCount;
    private int endAlphaSize;
    private final float gapWidth;
    private long lastTime;
    private final float maxBarHeight;
    private final float minBarHeight;
    private final Paint paint;
    private float sideMargin;
    private int startAlphaSize;
    private float visualizerWidth;
    private int waveGroupNumber;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceVisualizerOptView$BarParam;", "", "barType", "", "groupType", "barHeight", "", "curBarHeight", "change", "(IIFFF)V", "getBarHeight", "()F", "setBarHeight", "(F)V", "getBarType", "()I", "setBarType", "(I)V", "getChange", "setChange", "getCurBarHeight", "setCurBarHeight", "getGroupType", "setGroupType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BarParam {
        private float barHeight;
        private int barType;
        private float change;
        private float curBarHeight;
        private int groupType;

        public BarParam() {
            this(0, 0, 0.0f, 0.0f, 0.0f, 31, null);
        }

        public static /* synthetic */ BarParam copy$default(BarParam r100, int r101, int r102, float r103, float r104, float r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.barType;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.groupType;
        L8:
            int r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.barHeight;
        L11:
            float r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.curBarHeight;
        L14:
            float r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.change;
        L17:
            int r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final int component1() {
            return this.barType;
        }

        public final int component2() {
            return this.groupType;
        }

        public final float component3() {
            return this.barHeight;
        }

        public final float component4() {
            return this.curBarHeight;
        }

        public final float component5() {
            return this.change;
        }

        public final BarParam copy(int r100, int r101, float r110, float r111, float r112) {
            return new BarParam(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BarParam) == true) goto L8;
            return false;
        L8:
            BarParam r101 = (BarParam) r100;
            if (this.barType == r101.barType) goto L12;
            return false;
        L12:
            if (this.groupType == r101.groupType) goto L15;
            return false;
        L15:
            if (Float.compare(this.barHeight, r101.barHeight) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.curBarHeight, r101.curBarHeight) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.change, r101.change) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.barType * 31) + this.groupType) * 31) + Float.floatToIntBits(this.barHeight)) * 31) + Float.floatToIntBits(this.curBarHeight)) * 31) + Float.floatToIntBits(this.change);
        }

        public String toString() {
            return "BarParam(barType=" + this.barType + ", groupType=" + this.groupType + ", barHeight=" + this.barHeight + ", curBarHeight=" + this.curBarHeight + ", change=" + this.change + ')';
        }

        public final float getBarHeight() {
            return this.barHeight;
        }

        public final int getBarType() {
            return this.barType;
        }

        public final float getChange() {
            return this.change;
        }

        public final float getCurBarHeight() {
            return this.curBarHeight;
        }

        public final int getGroupType() {
            return this.groupType;
        }

        public final void setBarHeight(float r100) {
            this.barHeight = r100;
        }

        public final void setBarType(int r100) {
            this.barType = r100;
        }

        public final void setChange(float r100) {
            this.change = r100;
        }

        public final void setCurBarHeight(float r100) {
            this.curBarHeight = r100;
        }

        public final void setGroupType(int r100) {
            this.groupType = r100;
        }

        public BarParam(int r100, int r101, float r102, float r103, float r104) {
            this.barType = r100;
            this.groupType = r101;
            this.barHeight = r102;
            this.curBarHeight = r103;
            this.change = r104;
        }

        public /* synthetic */ BarParam(int r100, int r101, float r102, float r103, float r104, int r105, DefaultConstructorMarker r110) {
            int r106 = 2;
            if ((r105 & 1) == 0) goto L5;
            int r111 = 2;
        L7:
            if ((r105 & 2) != 0) goto L11;
            r106 = r101;
        L11:
            if ((r105 & 4) == 0) goto L13;
            float r107 = 0.0f;
        L15:
            if ((r105 & 8) == 0) goto L17;
            float r108 = 0.0f;
        L19:
            if ((r105 & 16) == 0) goto L21;
            float r109 = 0.0f;
        L22:
            this(r111, r106, r107, r108, r109);
            return;
        L21:
            r109 = r104;
            goto L22
        L17:
            r108 = r103;
            goto L19
        L13:
            r107 = r102;
            goto L15
        L5:
            r111 = r100;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceVisualizerOptView$Companion;", "", "()V", "AMPLITUDE_WINDOW", "", "BAR_TYPE_OTHER", "BAR_TYPE_SIDE", "BAR_TYPE_TOP", "FRAME_DURATION_MS", "", "GROUP_TYPE_OTHER", "GROUP_TYPE_SIDE", "GROUP_TYPE_TOP", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void stopWaveAnim() {
        this.animating = false;
        this.amplitude.clear();
        Iterator<BarParam> r100 = this.barParams.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        BarParam r101 = r100.next();
        r101.setCurBarHeight(this.minBarHeight);
        r101.setBarHeight(this.minBarHeight);
        r101.setChange(0.0f);
        goto L4
    L6:
        invalidate();
    }

    private final float popMaxAmplitude() {
        Float r100 = CollectionsKt.m9877maxOrNull(this.amplitude);
        if (r100 == null) goto L5;
        float r101 = r100.floatValue();
    L6:
        this.amplitude.clear();
        return r101;
    L5:
        r101 = 0.0f;
        goto L6
    }

    public final void startWaveAnim() {
        if (this.animating == false) goto L5;
        return;
    L5:
        this.animating = true;
        invalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopWaveAnim();
    }

    public final float getVisualizerWidth() {
        return this.visualizerWidth;
    }

    public final boolean isAnimating() {
        return this.animating;
    }

    public VoiceVisualizerOptView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        float r101 = CommonKt.dp2px(this, 2.0f);
        this.barWidth = r101;
        this.gapWidth = CommonKt.dp2px(this, 2.0f);
        this.sideMargin = CommonKt.dp2px(this, 64.0f);
        this.minBarHeight = CommonKt.dp2px(this, 3.0f);
        this.maxBarHeight = CommonKt.dp2px(this, 60.0f);
        this.amplitude = new LinkedList();
        this.barParams = new LinkedHashMap();
        Paint r102 = new Paint();
        r102.setAntiAlias(true);
        r102.setFilterBitmap(true);
        r102.setStrokeCap(Paint.Cap.ROUND);
        r102.setStrokeWidth(r101);
        r102.setColor(ContextCompat.getColor(getContext(), R.color.voice_print_color_FFFFFF));
        this.paint = r102;
    }

    private final void ensureCapacity(int r110) {
        if (this.barParams.get(Integer.valueOf(r110)) == null) goto L5;
        return;
    L5:
        this.barParams.clear();
        int r100 = 1;
        if (1 > r110) goto L10;
    L7:
        Integer r101 = Integer.valueOf(r100);
        this.barParams.put(r101, new BarParam(0, 0, 0.0f, 0.0f, 0.0f, 31, null));
        if (r100 == r110) goto L12;
        r100 = r100 + 1;
        goto L7
    L12:
        return;
    }

    private final void genBarData(float r110) {
        int r100 = 2;
        int r101 = this.waveGroupNumber / 2;
        int r102 = r101 + 3;
        int r103 = Random.Default.nextInt(r101, r102);
        int r104 = this.waveGroupNumber;
        if (1 > r104) goto L47;
        int r105 = 1;
    L5:
        int r106 = 0;
        if (r105 != r103) goto L8;
        float r107 = 1.0f;
    L17:
        if (r105 != r103) goto L19;
        int r111 = 0;
    L26:
        int r112 = Random.Default.nextInt(r100, 5);
        float r113 = RangesKt.coerceAtLeast((this.maxBarHeight * r110) * r107, this.minBarHeight);
        float r114 = 0.85f * r113;
        float r108 = RangesKt.coerceAtLeast(r114 * r107, this.minBarHeight);
        float r109 = RangesKt.coerceAtLeast((r114 * 0.8f) * r107, this.minBarHeight);
        int r115 = 1;
    L28:
        if (r115 >= 6) goto L45;
        BarParam r116 = this.barParams.get(Integer.valueOf(((r105 - 1) * 5) + r115));
        if (r116 == null) goto L43;
        r116.setGroupType(r111);
        if (r115 != r112) goto L35;
        r116.setBarType(r106);
        r116.setBarHeight(r113);
        goto L43
    L35:
        int r117 = r112 - 1;
        if (r115 > (r112 + 1)) goto L39;
        if (r117 > r115) goto L39;
        boolean r118 = true;
    L40:
        if (r118 == false) goto L42;
        r116.setBarType(1);
        r116.setBarHeight(r108);
        goto L43
    L42:
        r116.setBarType(2);
        r116.setBarHeight(r109);
    L39:
        r118 = false;
    L43:
        r115 = r115 + 1;
        r106 = 0;
        goto L28
    L45:
        if (r105 == r104) goto L52;
        r105 = r105 + 1;
        r100 = 2;
        goto L5
    L52:
        return;
    L19:
        if (r101 > r105) goto L22;
        if (r105 > r102) goto L22;
        boolean r119 = true;
    L23:
        if (r119 == false) goto L25;
        r111 = 1;
        goto L26
    L25:
        r111 = 2;
    L22:
        r119 = false;
        goto L23
    L8:
        int r120 = r103 - 1;
        if (r105 > (r103 + 1)) goto L12;
        if (r120 > r105) goto L12;
        boolean r121 = true;
    L13:
        if (r121 == false) goto L15;
        float r122 = Random.Default.nextFloat() * 0.2f;
        float r123 = 0.75f;
    L16:
        r107 = r122 + r123;
        goto L17
    L15:
        r122 = Random.Default.nextFloat() * 0.15f;
        r123 = 0.55f;
    L12:
        r121 = false;
        goto L13
    }

    private final int paintAlpha(int r100) {
        int r101 = this.startAlphaSize;
        int r102 = this.endAlphaSize;
        int r103 = this.barCount;
        boolean r104 = true;
        if (r101 == 0) goto L10;
        if (1 > r100) goto L7;
        if (r100 > r101) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        float r106 = r100 / r101;
    L11:
        if (r102 == 0) goto L20;
        if (((r103 - r102) + 1) > r100) goto L16;
        if (r100 > r103) goto L16;
    L17:
        if (r104 == false) goto L20;
        r106 = (r103 - r100) / r102;
    L16:
        r104 = false;
    L20:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (r106 * 255), 0), 255);
    L7:
        r105 = false;
    L10:
        r106 = 1.0f;
        goto L11
    }

    private final void recalcSize(int r100) {
        int r101 = (int) ((r100 - (this.sideMargin * 2)) / ((this.barWidth + this.gapWidth) * 5));
        if ((r101 % 2) != 0) goto L5;
        r101 = r101 - 1;
    L5:
        int r102 = this.customWaveGroupCount;
        if (r102 <= 0) goto L8;
        r101 = r102;
    L8:
        int r103 = RangesKt.coerceAtLeast(r101, 3);
        this.waveGroupNumber = r103;
        int r104 = r103 * 5;
        this.barCount = r104;
        this.visualizerWidth = (r104 * this.barWidth) + ((r104 - 1) * this.gapWidth);
        ensureCapacity(r104);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.animating == true) goto L5;
        return;
    L5:
        if (this.barCount <= 0) goto L17;
        long r101 = SystemClock.elapsedRealtime();
        long r102 = r101 - this.lastTime;
        if (r102 < 400) goto L14;
        this.lastTime = r101;
        float r103 = popMaxAmplitude();
        if (r102 < 800) goto L12;
        r102 = 0;
        r103 = 0.0f;
    L13:
        genBarData(r103);
        goto L14
    L12:
        r102 = r102 - 400;
    L14:
        drawBars(r102, r100);
        postInvalidateDelayed(10);
        return;
    }

    public final void setCustomWaveGroupCount(int r100) {
        this.customWaveGroupCount = r100;
        recalcSize(getWidth());
    }

    public final void setPaintColor(int r100) {
        this.paint.setColor(r100);
    }

    public final void setSideMargin(float r100) {
        this.sideMargin = r100;
        recalcSize(getWidth());
    }

    public final void setVolume01(float r100) {
        if (this.animating == true) goto L5;
        return;
    L5:
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (this.amplitude.size() < 10) goto L8;
        this.amplitude.poll();
    L8:
        this.amplitude.offer(Float.valueOf(r101));
    }

    public VoiceVisualizerOptView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        float r102 = CommonKt.dp2px(this, 2.0f);
        this.barWidth = r102;
        this.gapWidth = CommonKt.dp2px(this, 2.0f);
        this.sideMargin = CommonKt.dp2px(this, 64.0f);
        this.minBarHeight = CommonKt.dp2px(this, 3.0f);
        this.maxBarHeight = CommonKt.dp2px(this, 60.0f);
        this.amplitude = new LinkedList();
        this.barParams = new LinkedHashMap();
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setFilterBitmap(true);
        r103.setStrokeCap(Paint.Cap.ROUND);
        r103.setStrokeWidth(r102);
        r103.setColor(ContextCompat.getColor(getContext(), R.color.voice_print_color_FFFFFF));
        this.paint = r103;
    }

    private final void drawBars(long r210, Canvas r211) {
        float r100 = ((getWidth() - this.visualizerWidth) / 2.0f) + (this.barWidth / 2.0f);
        int r101 = this.barCount;
        int r102 = 1;
        if (1 > r101) goto L133;
        int r103 = 1;
    L5:
        BarParam r104 = this.barParams.get(Integer.valueOf(r103));
        if (r104 == null) goto L131;
        boolean r105 = false;
        if (r104.getGroupType() == 0) goto L11;
    L13:
        boolean r106 = false;
    L15:
        if (r104.getGroupType() != 0) goto L19;
        if (r104.getBarType() != r102) goto L19;
    L22:
        boolean r107 = true;
    L25:
        if (r104.getGroupType() != 0) goto L29;
        if (r104.getBarType() != 2) goto L29;
    L32:
        boolean r108 = true;
    L35:
        if (r104.getGroupType() != r102) goto L39;
        if (r104.getBarType() != 2) goto L39;
    L40:
        boolean r110 = true;
    L43:
        if (0 <= r210) goto L45;
    L47:
        boolean r111 = false;
    L49:
        if (r111 == false) goto L57;
        if (r106 == true) goto L52;
    L130:
        float r109 = RangesKt.coerceAtLeast(r104.getCurBarHeight() + r104.getChange(), this.minBarHeight);
        r104.setCurBarHeight(r109);
        float r112 = (getHeight() - r109) / 2;
        float r113 = r100 + ((r103 - 1) * (this.barWidth + this.gapWidth));
        this.paint.setAlpha(paintAlpha(r103));
        r211.drawLine(r113, r112, r113, r112 + r109, this.paint);
        goto L131
    L52:
        if (r104.getCurBarHeight() <= 0.0f) goto L54;
        float r114 = r104.getCurBarHeight();
    L55:
        r104.setChange((r104.getBarHeight() - r114) / 20);
        goto L130
    L54:
        r114 = this.minBarHeight;
        goto L55
    L57:
        if (50 <= r210) goto L59;
    L61:
        boolean r115 = false;
    L62:
        if (r115 == false) goto L70;
        if (r107 == false) goto L130;
        if (r104.getCurBarHeight() <= 0.0f) goto L67;
        float r116 = r104.getCurBarHeight();
    L68:
        r104.setChange((r104.getBarHeight() - r116) / 20);
        goto L130
    L67:
        r116 = this.minBarHeight;
        goto L68
    L70:
        if (100 <= r210) goto L72;
    L74:
        boolean r117 = false;
    L75:
        if (r117 == false) goto L83;
        if (r108 == false) goto L130;
        if (r104.getCurBarHeight() <= 0.0f) goto L80;
        float r118 = r104.getCurBarHeight();
    L81:
        r104.setChange((r104.getBarHeight() - r118) / 20);
        goto L130
    L80:
        r118 = this.minBarHeight;
        goto L81
    L83:
        if (150 <= r210) goto L85;
    L87:
        boolean r119 = false;
    L88:
        if (r119 == false) goto L96;
        if (r110 == false) goto L130;
        if (r104.getCurBarHeight() <= 0.0f) goto L93;
        float r120 = r104.getCurBarHeight();
    L94:
        r104.setChange((r104.getBarHeight() - r120) / 20);
        goto L130
    L93:
        r120 = this.minBarHeight;
        goto L94
    L96:
        if (200 <= r210) goto L98;
    L100:
        boolean r121 = false;
    L101:
        if (r121 == false) goto L105;
        if (r106 == false) goto L130;
        r104.setChange((this.minBarHeight - r104.getBarHeight()) / 20);
        goto L130
    L105:
        if (250 <= r210) goto L107;
    L109:
        boolean r122 = false;
    L110:
        if (r122 == false) goto L114;
        if (r107 == false) goto L130;
        r104.setChange((this.minBarHeight - r104.getBarHeight()) / 20);
        goto L130
    L114:
        if (300 <= r210) goto L116;
    L118:
        boolean r123 = false;
    L119:
        if (r123 == false) goto L123;
        if (r108 == false) goto L130;
        r104.setChange((this.minBarHeight - r104.getBarHeight()) / 20);
        goto L130
    L123:
        if (350 <= r210) goto L125;
    L127:
        if (r105 == false) goto L130;
        if (r110 == false) goto L130;
        r104.setChange((this.minBarHeight - r104.getBarHeight()) / 20);
        goto L130
    L125:
        if (r210 >= 400) goto L127;
        r105 = true;
        goto L127
    L116:
        if (r210 >= 350) goto L118;
        r123 = true;
        goto L119
    L107:
        if (r210 >= 300) goto L109;
        r122 = true;
        goto L110
    L98:
        if (r210 >= 250) goto L100;
        r121 = true;
        goto L101
    L85:
        if (r210 >= 200) goto L87;
        r119 = true;
        goto L88
    L72:
        if (r210 >= 150) goto L74;
        r117 = true;
        goto L75
    L59:
        if (r210 >= 100) goto L61;
        r115 = true;
        goto L62
    L45:
        if (r210 >= 50) goto L47;
        r111 = true;
    L39:
        if (r104.getGroupType() == 2) goto L40;
        r110 = false;
    L29:
        if (r104.getGroupType() == r102) goto L31;
    L33:
        r108 = false;
        goto L35
    L31:
        if (r104.getBarType() != r102) goto L33;
    L19:
        if (r104.getGroupType() == r102) goto L21;
    L23:
        r107 = false;
        goto L25
    L21:
        if (r104.getBarType() != 0) goto L23;
    L11:
        if (r104.getBarType() != 0) goto L13;
        r106 = true;
    L131:
        if (r103 == r101) goto L133;
        r103 = r103 + 1;
        r102 = 1;
    L133:
        this.paint.setAlpha(255);
    }

    public final void setGradient(int r100, int r101) {
        this.startAlphaSize = RangesKt.coerceAtLeast(r100, 0);
        this.endAlphaSize = RangesKt.coerceAtLeast(r101, 0);
    }

    public VoiceVisualizerOptView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        float r103 = CommonKt.dp2px(this, 2.0f);
        this.barWidth = r103;
        this.gapWidth = CommonKt.dp2px(this, 2.0f);
        this.sideMargin = CommonKt.dp2px(this, 64.0f);
        this.minBarHeight = CommonKt.dp2px(this, 3.0f);
        this.maxBarHeight = CommonKt.dp2px(this, 60.0f);
        this.amplitude = new LinkedList();
        this.barParams = new LinkedHashMap();
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setFilterBitmap(true);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeWidth(r103);
        r104.setColor(ContextCompat.getColor(getContext(), R.color.voice_print_color_FFFFFF));
        this.paint = r104;
    }

    public final void setVolumeDb(float r100, float r101, float r102) {
        if (r102 > r101) goto L5;
        return;
    L5:
        setVolume01(RangesKt.coerceIn((r100 - r101) / (r102 - r101), 0.0f, 1.0f));
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        recalcSize(r100);
    }

    public static /* synthetic */ void setVolumeDb$default(VoiceVisualizerOptView r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 60.0f;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 90.0f;
    L8:
        r100.setVolumeDb(r101, r102, r103);
    }
}
