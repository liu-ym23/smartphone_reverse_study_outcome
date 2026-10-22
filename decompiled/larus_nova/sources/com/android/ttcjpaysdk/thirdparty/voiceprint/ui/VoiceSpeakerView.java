package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.android.ttcjpaysdk.thirdparty.voiceprint.record.VoiceVibrateUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ;2\u00020\u0001:\u0001;B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020!J\b\u0010%\u001a\u00020!H\u0014J\b\u0010&\u001a\u00020!H\u0014J\u0010\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0012H\u0016J\u0018\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020!2\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0006\u0010.\u001a\u00020!J\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0007J\u0016\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0018J\u000e\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020!J\u0006\u00107\u001a\u00020!J\u0016\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceSpeakerView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "blueBg", "blurCircle", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceBlurCircleAmplitudeView;", "currentState", "highlightBlue", "highlightRadius", "", "highlightRed", "isAggregatedVisible", "", "isViewAttached", "isWindowVisible", "redBg", "redWave", "textCancel", "", "textColorRecording", "textRecording", "tipsView", "Landroid/widget/TextView;", "visualizer", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceVisualizerOptView;", "whiteWave", "clearTouchPosition", "", "evaluateAnimRunningState", "isAnimating", "notifyFinishRecording", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityAggregated", "isVisible", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "onWindowVisibilityChanged", "setBackgroundTransparent", "setState", "state", "setText", "recordingText", "cancelText", "setVolume", "db", "startWaveAnim", "stopWaveAnim", "updateTouchPosition", "rawX", "rawY", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoiceSpeakerView extends FrameLayout {
    public static final Companion Companion = null;
    private static final float MAX_VOLUME_DB = 80.0f;
    private static final float MIN_VOLUME_DB = 55.0f;
    public static final int STATE_CANCEL = 2;
    private static final int STATE_IDLE = 0;
    public static final int STATE_RECORDING = 1;
    private final int blueBg;
    private final VoiceBlurCircleAmplitudeView blurCircle;
    private int currentState;
    private final int highlightBlue;
    private final float highlightRadius;
    private final int highlightRed;
    private boolean isAggregatedVisible;
    private boolean isViewAttached;
    private boolean isWindowVisible;
    private final int redBg;
    private final int redWave;
    private CharSequence textCancel;
    private final int textColorRecording;
    private CharSequence textRecording;
    private final TextView tipsView;
    private final VoiceVisualizerOptView visualizer;
    private final int whiteWave;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceSpeakerView$Companion;", "", "()V", "MAX_VOLUME_DB", "", "MIN_VOLUME_DB", "STATE_CANCEL", "", "STATE_IDLE", "STATE_RECORDING", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public VoiceSpeakerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public VoiceSpeakerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final void setBackgroundTransparent() {
        setBackgroundColor(0);
    }

    private final void evaluateAnimRunningState() {
        if (this.isViewAttached == true) goto L5;
    L9:
        boolean r100 = false;
    L10:
        if (r100 == true) goto L12;
        this.blurCircle.stopWaveAnim();
        this.visualizer.stopWaveAnim();
        return;
    L12:
        if (this.blurCircle.isAnimating() == true) goto L15;
        this.blurCircle.startWaveAnim();
    L15:
        if (this.visualizer.isAnimating() == true) goto L19;
        this.visualizer.startWaveAnim();
        return;
    L19:
        return;
    L5:
        if (this.isWindowVisible == false) goto L9;
        if (this.isAggregatedVisible == false) goto L9;
        r100 = true;
        goto L10
    }

    public final void clearTouchPosition() {
        this.blurCircle.dismissHighlight();
    }

    public final boolean isAnimating() {
        if (this.blurCircle.isAnimating() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.visualizer.isAnimating() == true) goto L8;
        return false;
    }

    public final void notifyFinishRecording() {
        VoiceVibrateUtil.vibrate$default(VoiceVibrateUtil.INSTANCE, getContext(), 0, 2, null);
    }

    public final void startWaveAnim() {
        this.blurCircle.startWaveAnim();
        this.visualizer.startWaveAnim();
    }

    public final void stopWaveAnim() {
        this.blurCircle.stopWaveAnim();
        this.visualizer.stopWaveAnim();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r100 = true;
        this.isViewAttached = true;
        if (getWindowVisibility() == 0) goto L6;
        r100 = false;
    L6:
        this.isWindowVisible = r100;
        this.isAggregatedVisible = isShown();
        evaluateAnimRunningState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isViewAttached = false;
        evaluateAnimRunningState();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        this.isAggregatedVisible = r100;
        evaluateAnimRunningState();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 != 0) goto L5;
        boolean r101 = true;
    L6:
        this.isWindowVisible = r101;
        evaluateAnimRunningState();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setState(int r100) {
        if (this.currentState != r100) goto L5;
        return;
    L5:
        this.currentState = r100;
        if (r100 != 1) goto L8;
        VoiceVibrateUtil.vibrate$default(VoiceVibrateUtil.INSTANCE, getContext(), 0, 2, null);
        this.blurCircle.setCircleColor(this.blueBg);
        this.blurCircle.setHighlightStyle(this.highlightBlue, this.highlightRadius);
        this.visualizer.setPaintColor(this.whiteWave);
        this.tipsView.setTextColor(this.textColorRecording);
        this.tipsView.setText(this.textRecording);
    L12:
        invalidate();
        return;
    L8:
        if (r100 != 2) goto L12;
        VoiceVibrateUtil.vibrate$default(VoiceVibrateUtil.INSTANCE, getContext(), 0, 2, null);
        this.blurCircle.setCircleColor(this.redBg);
        this.blurCircle.setHighlightStyle(this.highlightRed, this.highlightRadius);
        this.visualizer.setPaintColor(this.redWave);
        this.tipsView.setTextColor(this.redWave);
        this.tipsView.setText(this.textCancel);
        goto L12
    }

    public final void setVolume(float r100) {
        this.blurCircle.updateByDb(r100, MIN_VOLUME_DB, MAX_VOLUME_DB);
        this.visualizer.setVolumeDb(r100, MIN_VOLUME_DB, MAX_VOLUME_DB);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        this.isAggregatedVisible = isShown();
        evaluateAnimRunningState();
    }

    public final void setText(CharSequence r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingText");
        Intrinsics.checkNotNullParameter(r101, "cancelText");
        this.textRecording = r100;
        this.textCancel = r101;
        TextView r102 = this.tipsView;
        if (this.currentState == 1) goto L6;
        r100 = r101;
    L6:
        r102.setText(r100);
    }

    public final void updateTouchPosition(float r100, float r101) {
        int[] r102 = new int[2];
        this.blurCircle.getLocationOnScreen(r102);
        this.blurCircle.showHighlight(r100 - r102[0], r101 - r102[1]);
    }

    public VoiceSpeakerView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.textRecording = r110.getString(R.string.voice_print_recording_release_to_complete);
        this.textCancel = r110.getString(R.string.voice_print_recording_release_to_cancel);
        int r113 = ContextCompat.getColor(r110, R.color.voice_print_color_33B4FF);
        this.blueBg = r113;
        this.redBg = ContextCompat.getColor(r110, R.color.voice_print_color_33FF3B30);
        int r114 = ContextCompat.getColor(r110, R.color.voice_print_color_FFFFFF);
        this.whiteWave = r114;
        this.redWave = ContextCompat.getColor(r110, R.color.voice_print_color_FE3824);
        int r100 = ContextCompat.getColor(r110, R.color.voice_print_color_E5FFFFFF);
        this.textColorRecording = r100;
        int r101 = ContextCompat.getColor(r110, R.color.voice_print_color_0061F2);
        this.highlightBlue = r101;
        this.highlightRed = ContextCompat.getColor(r110, R.color.voice_print_color_FF3B30);
        float r102 = CommonKt.dp2px(this, 72.0f);
        this.highlightRadius = r102;
        VoiceBlurCircleAmplitudeView r103 = new VoiceBlurCircleAmplitudeView(r110, null, 0, 6, null);
        r103.setCircleColor(r113);
        r103.setHighlightStyle(r101, r102);
        this.blurCircle = r103;
        VoiceVisualizerOptView r115 = new VoiceVisualizerOptView(r110);
        r115.setPaintColor(r114);
        r115.setSideMargin(CommonKt.dp2px(r115, 64.0f));
        r115.setGradient(5, 5);
        this.visualizer = r115;
        TextView r116 = new TextView(r110);
        r116.setTextColor(r100);
        r116.setTextSize(13.0f);
        r116.setGravity(17);
        r116.setText(this.textRecording);
        this.tipsView = r116;
        setClipChildren(false);
        setClipToPadding(false);
        addView(r103, new FrameLayout.LayoutParams(-1, -1, 17));
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-2, -2, 81);
        r117.bottomMargin = (int) CommonKt.dp2px(this, 110.0f);
        Unit r104 = Unit.INSTANCE;
        addView(r116, r117);
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(-1, (int) CommonKt.dp2px(this, 60.0f), 81);
        r118.bottomMargin = (int) CommonKt.dp2px(this, 30.0f);
        addView(r115, r118);
    }

    public /* synthetic */ VoiceSpeakerView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
