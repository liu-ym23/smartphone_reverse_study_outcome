package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 F2\u00020\u0001:\u0001FB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0014J(\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0014J\u000e\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020\u0007J\u0016\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020+J\u000e\u0010B\u001a\u0002052\u0006\u0010C\u001a\u00020\u0013J\u0018\u0010D\u001a\u0002052\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H\u0002J\b\u0010E\u001a\u000205H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/RecordingOverlayView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundPaint", "Landroid/graphics/Paint;", "blueBgColor", "blurMaskFilter", "Landroid/graphics/BlurMaskFilter;", "cachedShader", "Landroid/graphics/Shader;", "currentBarHeights", "", "currentDisplayVolumeDb", "", "currentState", "dp126", "dp3", "dp47", "dp8", "lastHeight", "lastUpdateTime", "", "lastWidth", "ovalHeight", "getOvalHeight", "()F", "ovalWidth", "getOvalWidth", "path", "Landroid/graphics/Path;", "randomFactors", "redBgColor", "redWaveColor", "secureRandom", "Ljava/security/SecureRandom;", "targetVolumeDb", "textCancel", "", "textColor", "textPaint", "textRecording", "waveformPaint", "whiteWaveColor", "getOrUpdateShader", "width", "height", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "setState", "state", "setText", "recordingText", "cancelText", "setVolume", "db", "updatePath", "updateRandomFactors", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecordingOverlayView extends View {
    public static final Companion Companion = null;
    private static final float MAX_VOLUME_DB = 90.0f;
    private static final float MIN_VOLUME_THRESHOLD = 60.0f;
    public static final int STATE_CANCEL = 2;
    public static final int STATE_RECORDING = 1;
    private final Paint backgroundPaint;
    private final int blueBgColor;
    private final BlurMaskFilter blurMaskFilter;
    private Shader cachedShader;
    private final float[] currentBarHeights;
    private float currentDisplayVolumeDb;
    private int currentState;
    private final float dp126;

    /* JADX INFO: renamed from: dp3, reason: collision with root package name */
    private final float f29878dp3;
    private final float dp47;

    /* JADX INFO: renamed from: dp8, reason: collision with root package name */
    private final float f29879dp8;
    private float lastHeight;
    private long lastUpdateTime;
    private float lastWidth;
    private final float ovalHeight;
    private final float ovalWidth;
    private final Path path;
    private final float[] randomFactors;
    private final int redBgColor;
    private final int redWaveColor;
    private final SecureRandom secureRandom;
    private float targetVolumeDb;
    private String textCancel;
    private final int textColor;
    private final Paint textPaint;
    private String textRecording;
    private final Paint waveformPaint;
    private final int whiteWaveColor;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/RecordingOverlayView$Companion;", "", "()V", "MAX_VOLUME_DB", "", "MIN_VOLUME_THRESHOLD", "STATE_CANCEL", "", "STATE_RECORDING", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public RecordingOverlayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public RecordingOverlayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void updateRandomFactors() {
        int r100 = this.randomFactors.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        if (this.secureRandom.nextFloat() <= 0.8f) goto L7;
        this.randomFactors[r101] = (this.secureRandom.nextFloat() * 0.3f) + 0.7f;
    L8:
        r101 = r101 + 1;
        goto L3
    L7:
        this.randomFactors[r101] = (this.secureRandom.nextFloat() * 0.3f) + 0.2f;
        goto L8
    }

    public final float getOvalHeight() {
        return this.ovalHeight;
    }

    public final float getOvalWidth() {
        return this.ovalWidth;
    }

    @Override // android.view.View
    public void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        float r100 = this.currentDisplayVolumeDb;
        float r101 = this.targetVolumeDb;
        float r102 = r100 + ((r101 - r100) * 0.05f);
        this.currentDisplayVolumeDb = r102;
        if (Math.abs(r101 - r102) <= 0.1f) goto L5;
        invalidate();
    L5:
        long r103 = System.currentTimeMillis();
        if ((r103 - this.lastUpdateTime) <= 150) goto L8;
        updateRandomFactors();
        this.lastUpdateTime = r103;
    L8:
        float r104 = getWidth();
        float r105 = getHeight();
        if (this.path.isEmpty() == false) goto L11;
        updatePath(r104, r105);
    L11:
        boolean r106 = true;
        if (this.currentState != 1) goto L14;
        String r107 = this.textRecording;
    L15:
        float r108 = Math.min(1.4f, (Math.max(0.0f, (this.currentDisplayVolumeDb - 60.0f) / 30.0f) * 0.4f) + 1.0f);
        r210.save();
        float r110 = 2;
        float r109 = r104 / r110;
        r210.scale(r108, r108, r109, r105 - 100.0f);
        this.backgroundPaint.setMaskFilter(this.blurMaskFilter);
        this.backgroundPaint.setShader(getOrUpdateShader(r104, r105));
        r210.drawPath(this.path, this.backgroundPaint);
        this.backgroundPaint.setMaskFilter(null);
        r210.restore();
        float r111 = r105 - this.dp126;
        Paint r112 = this.textPaint;
        if (this.currentState != 1) goto L18;
        int r113 = this.textColor;
    L19:
        r112.setColor(r113);
        r210.drawText(r107, r109, r111, this.textPaint);
        float r114 = r111 + this.dp47;
        float r115 = this.f29878dp3;
        float r116 = r115 + r115;
        float r117 = (r104 - (50 * r116)) / r110;
        if (this.currentState != 1) goto L22;
        int r118 = this.whiteWaveColor;
    L23:
        this.waveformPaint.setColor(r118);
        int r119 = 0;
    L24:
        int r120 = 255;
        if (r119 >= 50) goto L38;
        float r121 = this.currentDisplayVolumeDb;
        if (r121 >= 60.0f) goto L29;
        float r122 = this.f29879dp8;
    L30:
        float[] r123 = this.currentBarHeights;
        float r124 = r123[r119];
        float r125 = r124 + ((r122 - r124) * 0.2f);
        r123[r119] = r125;
        float r126 = r117 + (r119 * r116);
        if (r119 >= 5) goto L35;
        int r127 = r119 + 1;
    L33:
        r120 = (int) ((r127 * 0.2f) * 255);
    L37:
        this.waveformPaint.setAlpha(r120);
        float r128 = r125 / r110;
        r210.drawLine(r126, r114 - r128, r126, r114 + r128, this.waveformPaint);
        r119 = r119 + 1;
        goto L24
    L35:
        if (r119 < 45) goto L37;
        r127 = 50 - r119;
        goto L33
    L29:
        r122 = Math.max(this.f29879dp8, r121 * this.randomFactors[r119]);
        goto L30
    L38:
        this.waveformPaint.setAlpha(255);
        if (Math.abs(this.targetVolumeDb - this.currentDisplayVolumeDb) <= 0.1f) goto L42;
    L47:
        if (r106 == false) goto L53;
        invalidate();
        return;
    L53:
        return;
    L42:
        if (Math.abs(this.currentBarHeights[0] - 10.0f) > 0.5f) goto L44;
    L46:
        r106 = false;
        goto L47
    L44:
        if (this.targetVolumeDb >= 60.0f) goto L46;
    L22:
        r118 = this.redWaveColor;
        goto L23
    L18:
        r113 = this.redWaveColor;
        goto L19
    L14:
        r107 = this.textCancel;
        goto L15
    }

    public final void setState(int r100) {
        if (this.currentState == r100) goto L6;
        this.currentState = r100;
        this.cachedShader = null;
        invalidate();
        return;
    }

    public final void setVolume(float r100) {
        this.targetVolumeDb = r100;
        invalidate();
    }

    private final Shader getOrUpdateShader(float r110, float r111) {
        if (this.cachedShader != null) goto L5;
    L14:
        float r100 = 2;
        float r112 = r110 / r100;
        float r113 = r111 - 100.0f;
        float r114 = Math.max(this.ovalWidth, this.ovalHeight) / r100;
        if (this.currentState != 1) goto L17;
        int r101 = this.blueBgColor;
    L18:
        RadialGradient r115 = new RadialGradient(r112, r113, r114, new int[]{r101, r101, 16777215 & r101}, new float[]{0.0f, 0.1f, 1.0f}, Shader.TileMode.CLAMP);
        Matrix r102 = new Matrix();
        float r103 = r100 * r114;
        r102.setScale(this.ovalWidth / r103, this.ovalHeight / r103, r112, r113);
        r115.setLocalMatrix(r102);
        this.cachedShader = r115;
        this.lastHeight = r111;
        this.lastWidth = r110;
    L19:
        Shader r104 = this.cachedShader;
        Intrinsics.checkNotNull(r104);
        return r104;
    L17:
        r101 = this.redBgColor;
        goto L18
    L5:
        if (this.lastHeight != r111) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L14;
        if (this.lastWidth != r110) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == true) goto L19;
    L12:
        r106 = false;
        goto L13
    L7:
        r105 = false;
        goto L8
    }

    private final void updatePath(float r110, float r111) {
        float r100 = 2;
        float r112 = r110 / r100;
        float r113 = r111 - 100.0f;
        float r101 = this.ovalWidth;
        float r102 = this.ovalHeight;
        this.path.reset();
        Path r103 = this.path;
        r103.addOval(r112 - (r101 / r100), r113 - (r102 / r100), r112 + (r101 / r100), r113 + (r102 / r100), Path.Direction.CW);
    }

    public final void setText(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingText");
        Intrinsics.checkNotNullParameter(r101, "cancelText");
        this.textRecording = r100;
        this.textCancel = r101;
        invalidate();
    }

    public RecordingOverlayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.currentState = 1;
        this.textRecording = r100.getString(R.string.voice_print_recording_release_to_complete);
        this.textCancel = r100.getString(R.string.voice_print_recording_release_to_cancel);
        this.f29878dp3 = CommonKt.dp2px(this, 3.0f);
        this.f29879dp8 = CommonKt.dp2px(this, 8.0f);
        this.dp126 = CommonKt.dp2px(this, 126.0f);
        this.dp47 = CommonKt.dp2px(this, 47.0f);
        this.ovalWidth = CommonKt.dp2px(this, 536.0f);
        this.ovalHeight = CommonKt.dp2px(this, 409.0f);
        float[] r103 = new float[50];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= 50) goto L5;
        r103[r105] = 1.0f;
        r105 = r105 + 1;
        goto L3
    L5:
        this.randomFactors = r103;
        float[] r106 = new float[50];
    L6:
        if (r104 >= 50) goto L8;
        r106[r104] = 10.0f;
        r104 = r104 + 1;
        goto L6
    L8:
        this.currentBarHeights = r106;
        this.secureRandom = new SecureRandom();
        this.backgroundPaint = new Paint(1);
        Paint r107 = new Paint(1);
        r107.setTextSize(CommonKt.dp2px(this, 13.0f));
        r107.setTextAlign(Paint.Align.CENTER);
        this.textPaint = r107;
        Paint r108 = new Paint(1);
        r108.setStrokeWidth(this.f29878dp3);
        r108.setStrokeCap(Paint.Cap.ROUND);
        this.waveformPaint = r108;
        this.blurMaskFilter = new BlurMaskFilter(160.0f, BlurMaskFilter.Blur.NORMAL);
        this.blueBgColor = ContextCompat.getColor(r100, R.color.voice_print_color_467BFB);
        this.redBgColor = ContextCompat.getColor(r100, R.color.voice_print_color_59FE3824);
        this.whiteWaveColor = ContextCompat.getColor(r100, R.color.voice_print_color_FFFFFF);
        int r109 = ContextCompat.getColor(r100, R.color.voice_print_color_E5FFFFFF);
        this.textColor = r109;
        this.redWaveColor = ContextCompat.getColor(r100, R.color.voice_print_color_FE3824);
        this.path = new Path();
        r107.setColor(r109);
        updateRandomFactors();
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        updatePath(r100, r101);
        this.cachedShader = null;
    }

    public /* synthetic */ RecordingOverlayView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
