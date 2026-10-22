package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintConfig;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintResult;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.android.ttcjpaysdk.thirdparty.voiceprint.interfaces.VoicePrintCallback;
import com.larus.nova.R;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0014J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0006\u0010\u0017\u001a\u00020\u0011J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\"\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintWidget;", "Landroid/widget/RelativeLayout;", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintUiDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonScaleAnimator", "Landroid/animation/Animator;", "controller", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintController;", "recordButton", "Landroid/widget/TextView;", "dispatchResult", "", "result", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult;", "initView", "onDetachedFromWindow", "playRecordButtonFailHighlight", "release", "setRecordButtonEnabled", "enabled", "", "setRecordButtonVisible", "visible", LynxTemplateRender.RENDER_PHASE_SETUP, "config", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintConfig;", "callback", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/interfaces/VoicePrintCallback;", "extraUiDelegate", "updateTips", "state", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintState;", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintWidget extends RelativeLayout implements VoicePrintUiDelegate {
    private static final Companion Companion = null;
    private static final String View_ALPHA = "alpha";
    private static final String View_SCALE_X = "scaleX";
    private static final String View_SCALE_Y = "scaleY";
    private static final String View_TRANSLATION_Y = "translationY";
    private Animator buttonScaleAnimator;
    private VoicePrintController controller;
    private TextView recordButton;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintWidget$Companion;", "", "()V", "View_ALPHA", "", "View_SCALE_X", "View_SCALE_Y", "View_TRANSLATION_Y", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[VoicePrintState.values().length];
            r100[VoicePrintState.FAIL_CONTINUE_VERIFY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VoicePrintState.DURATION_TOO_SHORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VoicePrintState.DURATION_TOO_LONG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VoicePrintWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public VoicePrintWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void initView() {
        TextView r100 = new TextView(getContext());
        r100.setId(RelativeLayout.generateViewId());
        r100.setBackground(ContextCompat.getDrawable(r100.getContext(), R.drawable.bg_record_btn));
        r100.setText(r100.getContext().getString(R.string.voice_print_press_to_speak));
        r100.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.voice_print_color_FFFFFF));
        r100.setTextSize(2, 15.0f);
        r100.setTypeface(Typeface.DEFAULT_BOLD);
        r100.setGravity(17);
        this.recordButton = r100;
        RelativeLayout.LayoutParams r101 = new RelativeLayout.LayoutParams(-1, (int) CommonKt.dp2px(this, 44.0f));
        r101.addRule(12);
        r101.bottomMargin = (int) CommonKt.dp2px(this, 16.0f);
        r101.setMarginStart((int) CommonKt.dp2px(this, 20.0f));
        r101.setMarginEnd((int) CommonKt.dp2px(this, 20.0f));
        addView(this.recordButton, r101);
        TextView r102 = this.recordButton;
        if (r102 == null) goto L6;
        r102.setOnTouchListener(new AnonymousClass2(this));
        return;
    }

    private final void playRecordButtonFailHighlight() {
        TextView r100 = this.recordButton;
        if (r100 != null) goto L5;
        return;
    L5:
        Animator r101 = this.buttonScaleAnimator;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        float[] r102 = {130.0f, 80.0f, 80.0f, 80.0f, 80.0f, 80.0f, 80.0f, 80.0f};
        int r103 = 9;
        float[] r104 = new float[9];
        r104[0] = 0.0f;
        float r110 = 690;
        int r111 = 0;
        float r112 = 0.0f;
    L9:
        if (r111 >= 8) goto L11;
        r112 = r112 + r102[r111];
        r111 = r111 + 1;
        r104[r111] = r112 / r110;
        goto L9
    L11:
        float[] r105 = {0.8f, 1.05f, 0.98f, 1.01f, 0.99f, 1.0f, 1.01f, 1.02f, 1.0f};
        Interpolator[] r106 = {PathInterpolatorCompat.create(0.35f, 0.0f, 0.68f, 1.0f), PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f), PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f), PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f), PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f), PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f), PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f), PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f)};
        Keyframe[] r113 = new Keyframe[9];
        int r114 = 0;
    L12:
        if (r114 >= 9) goto L17;
        if (r114 != 0) goto L15;
        Keyframe r115 = Keyframe.ofFloat(0.0f, r105[0]);
    L16:
        r113[r114] = r115;
        r114 = r114 + 1;
        goto L12
    L15:
        r115 = Keyframe.ofFloat(r104[r114], r105[r114]);
        r115.setInterpolator(r106[r114 - 1]);
        Unit r116 = Unit.INSTANCE;
        goto L16
    L17:
        PropertyValuesHolder r117 = PropertyValuesHolder.ofKeyframe("scaleX", r113);
        Keyframe[] r118 = new Keyframe[9];
        int r119 = 0;
    L18:
        if (r119 >= r103) goto L23;
        if (r119 != 0) goto L21;
        Keyframe r120 = Keyframe.ofFloat(0.0f, r105[0]);
    L22:
        r118[r119] = r120;
        r119 = r119 + 1;
        r103 = 9;
        goto L18
    L21:
        r120 = Keyframe.ofFloat(r104[r119], r105[r119]);
        r120.setInterpolator(r106[r119 - 1]);
        Unit r107 = Unit.INSTANCE;
        goto L22
    L23:
        ObjectAnimator r108 = ObjectAnimator.ofPropertyValuesHolder(r100, new PropertyValuesHolder[]{r117, PropertyValuesHolder.ofKeyframe("scaleY", r118)});
        r108.setDuration(690);
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r100, View.ALPHA, new float[]{0.0f, 1.0f});
        r109.setDuration(30);
        r109.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        AnimatorSet r121 = new AnimatorSet();
        r121.playTogether(new Animator[]{r108, r109});
        r121.start();
        this.buttonScaleAnimator = r121;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Animator r100 = this.buttonScaleAnimator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.buttonScaleAnimator = null;
        release();
        super.onDetachedFromWindow();
    }

    public final void release() {
        VoicePrintController r100 = this.controller;
        if (r100 == null) goto L5;
        r100.detach();
    L5:
        this.controller = null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public Integer getCurrentVerifyStep() {
        return VoicePrintUiDelegate.DefaultImpls.getCurrentVerifyStep(this);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public String getCurrentVerifyType() {
        return VoicePrintUiDelegate.DefaultImpls.getCurrentVerifyType(this);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public String getRecordingTips() {
        return VoicePrintUiDelegate.DefaultImpls.getRecordingTips(this);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void closeActivity() {
        VoicePrintUiDelegate.DefaultImpls.closeActivity(this);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void showPermissionDialog() {
        VoicePrintUiDelegate.DefaultImpls.showPermissionDialog(this);
    }

    public static final /* synthetic */ VoicePrintController access$getController$p(VoicePrintWidget r100) {
        return r100.controller;
    }

    public final void dispatchResult(VoicePrintResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        VoicePrintController r101 = this.controller;
        if (r101 == null) goto L6;
        r101.dispatchResult$bdpay_voiceprint_release(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void incrementIndicator(VoicePrintState r100) {
        VoicePrintUiDelegate.DefaultImpls.incrementIndicator(this, r100);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void setRecordButtonEnabled(boolean r100) {
        TextView r101 = this.recordButton;
        if (r101 == null) goto L6;
        r101.setEnabled(r100);
    L6:
        TextView r102 = this.recordButton;
        if (r102 == null) goto L11;
        r102.setClickable(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void setRecordButtonVisible(boolean r100) {
        TextView r101 = this.recordButton;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        float r102 = 1.0f;
    L8:
        r101.setAlpha(r102);
        return;
    L7:
        r102 = 0.0f;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void showRecognizeLoading(boolean r100) {
        VoicePrintUiDelegate.DefaultImpls.showRecognizeLoading(this, r100);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void updateTips(VoicePrintState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 != 1) goto L5;
    L9:
        playRecordButtonFailHighlight();
        return;
    L5:
        if (r101 == 2) goto L9;
        if (r101 == 3) goto L9;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void updateVoiceText(VoicePrintState r100) {
        VoicePrintUiDelegate.DefaultImpls.updateVoiceText(this, r100);
    }

    public VoicePrintWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setClickable(false);
        setFocusable(false);
        initView();
    }

    public final void setup(VoicePrintConfig r100, VoicePrintCallback r101, VoicePrintUiDelegate r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ArrayList r103 = new ArrayList(2);
        r103.add(this);
        if (r102 == null) goto L5;
        r103.add(r102);
    L5:
        CompositeVoicePrintUiDelegate r104 = new CompositeVoicePrintUiDelegate(r103);
        VoicePrintController r105 = this.controller;
        if (r105 != null) goto L8;
        r105 = new VoicePrintController();
        this.controller = r105;
    L8:
        r105.attach(r104);
        r105.setup(getContext(), r100, r101);
    }

    public /* synthetic */ VoicePrintWidget(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void setup$default(VoicePrintWidget r100, VoicePrintConfig r101, VoicePrintCallback r102, VoicePrintUiDelegate r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.setup(r101, r102, r103);
    }
}
