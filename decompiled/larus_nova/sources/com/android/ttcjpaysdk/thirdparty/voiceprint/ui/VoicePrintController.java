package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintManager;
import com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintConfig;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintOperation;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintResult;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.VoicePrintTracker;
import com.android.ttcjpaysdk.thirdparty.voiceprint.interfaces.VoicePrintCallback;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\u0006\u0010$\u001a\u00020\u0015J\u0015\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b(J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0002J\n\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u00101\u001a\u000202H\u0002J\u001e\u00104\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u00108\u001a\u00020\u0015H\u0002J\u0016\u00109\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00101\u001a\u000202R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintController;", "", "()V", "cancelThresholdPx", "", "config", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintConfig;", "confirmTipView", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintConfirmTipView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isRecording", "", "overlayView", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceSpeakerView;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/VoicePrintSession;", "startY", "uiDelegate", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintUiDelegate;", LynxViewpagerItem.BIND_ON_ATTACH, "", "attachConfirmTipView", "rootView", "Landroid/view/ViewGroup;", AppConstants.BUNDLE_TIP, "attachOverlayView", "overlay", "bringViewToTopZ", "view", "Landroid/view/View;", "parent", "cancelRecording", "cancelReason", "", "clearSession", "detach", "dispatchResult", "result", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult;", "dispatchResult$bdpay_voiceprint_release", "dispatchState", "state", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintState;", "findActivity", "Landroid/app/Activity;", "handleActionCancel", "handleActionDown", "handleActionMove", "event", "Landroid/view/MotionEvent;", "handleActionUp", LynxTemplateRender.RENDER_PHASE_SETUP, "callback", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/interfaces/VoicePrintCallback;", "startRecordingInternal", "stopRecordAndRecognize", "touchToStart", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintController {
    private float cancelThresholdPx;
    private VoicePrintConfig config;
    private VoicePrintConfirmTipView confirmTipView;
    private Context context;
    private boolean isRecording;
    private VoiceSpeakerView overlayView;
    private VoicePrintSession session;
    private float startY;
    private VoicePrintUiDelegate uiDelegate;

    private final void clearSession() {
        VoicePrintSession r100 = this.session;
        if (r100 == null) goto L5;
        VoicePrintManager.INSTANCE.release(r100);
    L5:
        this.session = null;
        VoiceSpeakerView r101 = this.overlayView;
        if (r101 == null) goto L13;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L10;
        ViewGroup r103 = (ViewGroup) r102;
    L11:
        if (r103 == null) goto L13;
        r103.removeView(r101);
        goto L13
    L10:
        r103 = null;
    L13:
        this.overlayView = null;
        VoicePrintConfirmTipView r104 = this.confirmTipView;
        if (r104 == null) goto L21;
        ViewParent r105 = r104.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L18;
        ViewGroup r106 = (ViewGroup) r105;
    L19:
        if (r106 == null) goto L21;
        r106.removeView(r104);
        goto L21
    L18:
        r106 = null;
    L21:
        this.confirmTipView = null;
        this.isRecording = false;
        this.startY = 0.0f;
    }

    private final Activity findActivity() {
        Context r100 = this.context;
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        if ((r100 instanceof Activity) == true) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L8:
        return (Activity) r100;
    L11:
        if ((r100 instanceof Activity) == true) goto L17;
        return null;
    L17:
        return (Activity) r100;
    }

    private final void handleActionCancel() {
        if (this.isRecording == true) goto L5;
        return;
    L5:
        this.isRecording = false;
        cancelRecording(CameraParam.TYPE_SYSTEM_CAMERA);
    }

    private final void stopRecordAndRecognize() {
        if (this.isRecording == true) goto L5;
        return;
    L5:
        this.isRecording = false;
        VoiceSpeakerView r100 = this.overlayView;
        if (r100 == null) goto L8;
        r100.setState(1);
    L8:
        VoicePrintConfirmTipView r101 = this.confirmTipView;
        if (r101 == null) goto L11;
        r101.setGlowState(1);
    L11:
        VoiceSpeakerView r102 = this.overlayView;
        if (r102 == null) goto L14;
        r102.notifyFinishRecording();
    L14:
        final VoicePrintSession r103 = this.session;
        if (r103 == null) goto L18;
        VoicePrintManager.INSTANCE.stopRecordingAsync(r103, new VoicePrintController$stopRecordAndRecognize$1$1(r103));
        return;
    }

    public VoicePrintController() {
        this.cancelThresholdPx = 120.0f;
    }

    public final void detach() {
        clearSession();
        this.uiDelegate = null;
        this.context = null;
    }

    public static final /* synthetic */ VoicePrintConfig access$getConfig$p(VoicePrintController r100) {
        return r100.config;
    }

    public static final /* synthetic */ VoicePrintConfirmTipView access$getConfirmTipView$p(VoicePrintController r100) {
        return r100.confirmTipView;
    }

    public static final /* synthetic */ VoiceSpeakerView access$getOverlayView$p(VoicePrintController r100) {
        return r100.overlayView;
    }

    public static final /* synthetic */ VoicePrintSession access$getSession$p(VoicePrintController r100) {
        return r100.session;
    }

    public static final /* synthetic */ VoicePrintUiDelegate access$getUiDelegate$p(VoicePrintController r100) {
        return r100.uiDelegate;
    }

    public static final /* synthetic */ boolean access$isRecording$p(VoicePrintController r100) {
        return r100.isRecording;
    }

    private final void cancelRecording(String r100) {
        VoicePrintSession r101 = this.session;
        if (r101 == null) goto L6;
        VoicePrintManager.INSTANCE.cancelRecording(r101, false, r100);
        return;
    }

    private final void dispatchState(VoicePrintState r100) {
        VoicePrintSession r101 = this.session;
        if (r101 == null) goto L6;
        VoicePrintManager.INSTANCE.dispatchState$bdpay_voiceprint_release(r101, r100);
        return;
    }

    private final void handleActionDown(final ViewGroup r100) {
        VoicePrintUiDelegate r101 = this.uiDelegate;
        if (r101 == null) goto L8;
        Integer r102 = r101.getCurrentVerifyStep();
        if (r102 == null) goto L8;
        String r103 = r102.toString();
        if (r103 == null) goto L8;
    L9:
        VoicePrintUiDelegate r104 = this.uiDelegate;
        if (r104 == null) goto L12;
        String r105 = r104.getCurrentVerifyType();
    L13:
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        VoicePrintTracker.INSTANCE.reportSubmitInput(this.config, r103, r105);
        Activity r106 = findActivity();
        if (r106 != null) goto L19;
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.UNKNOWN_ERROR, "No activity found to request permission", null, 4, null));
        return;
    L19:
        VoicePrintManager.INSTANCE.requestRecordAudioPermission(r106, new AnonymousClass1(this), new AnonymousClass2(this, r100), new AnonymousClass3(this));
        return;
    L12:
        r105 = null;
    L8:
        r103 = "1";
        goto L9
    }

    private final void handleActionMove(MotionEvent r100) {
        if (this.isRecording == true) goto L6;
        return;
    L6:
        if ((this.startY - r100.getRawY()) < this.cancelThresholdPx) goto L13;
        VoiceSpeakerView r101 = this.overlayView;
        if (r101 == null) goto L10;
        r101.setState(2);
    L10:
        VoicePrintConfirmTipView r102 = this.confirmTipView;
        if (r102 == null) goto L20;
        r102.setGlowState(2);
        return;
    L20:
        return;
    L13:
        VoiceSpeakerView r103 = this.overlayView;
        if (r103 == null) goto L16;
        r103.setState(1);
    L16:
        VoicePrintConfirmTipView r104 = this.confirmTipView;
        if (r104 == null) goto L22;
        r104.setGlowState(1);
        return;
    }

    private final void handleActionUp(MotionEvent r100) {
        if (this.isRecording == true) goto L6;
        return;
    L6:
        if ((this.startY - r100.getRawY()) < this.cancelThresholdPx) goto L8;
        this.isRecording = false;
        cancelRecording("user");
        return;
    L8:
        stopRecordAndRecognize();
    }

    private final void startRecordingInternal(ViewGroup r110) {
        if (this.isRecording == false) goto L5;
        return;
    L5:
        this.isRecording = true;
        VoiceSpeakerView r100 = this.overlayView;
        if (r100 != null) goto L8;
    L10:
        VoicePrintConfirmTipView r101 = this.confirmTipView;
        if (r101 != null) goto L13;
    L15:
        Context r111 = this.context;
        Unit r102 = null;
        if (r111 == null) goto L18;
        Context r112 = r111.getApplicationContext();
    L19:
        VoicePrintSession r103 = this.session;
        if (r103 == null) goto L25;
        if (r112 == null) goto L23;
        VoicePrintManager.INSTANCE.startRecording(r103, r112);
    L24:
        r102 = Unit.INSTANCE;
        goto L25
    L23:
        this.isRecording = false;
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.UNKNOWN_ERROR, "context is null", null, 4, null));
    L25:
        if (r102 != null) goto L28;
        this.isRecording = false;
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.UNKNOWN_ERROR, "session not initialized", null, 4, null));
        return;
    L28:
        return;
    L18:
        r112 = null;
        goto L19
    L13:
        if (r101.getParent() != null) goto L15;
        attachConfirmTipView(r110, r101);
        goto L15
    L8:
        if (r100.getParent() != null) goto L10;
        attachOverlayView(r110, r100);
        goto L10
    }

    public final void attach(VoicePrintUiDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "uiDelegate");
        this.uiDelegate = r100;
    }

    public final void dispatchResult$bdpay_voiceprint_release(VoicePrintResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        VoicePrintSession r101 = this.session;
        if (r101 == null) goto L6;
        VoicePrintManager.INSTANCE.dispatchResult$bdpay_voiceprint_release(r101, r100);
        return;
    }

    public static final /* synthetic */ void access$dispatchState(VoicePrintController r100, VoicePrintState r101) {
        r100.dispatchState(r101);
    }

    public static final /* synthetic */ void access$startRecordingInternal(VoicePrintController r100, ViewGroup r101) {
        r100.startRecordingInternal(r101);
    }

    private final void attachConfirmTipView(ViewGroup r100, VoicePrintConfirmTipView r101) {
        if ((r100 instanceof LinearLayout) == false) goto L10;
        Activity r102 = findActivity();
        if (r102 == null) goto L7;
        r100 = (ViewGroup) r102.findViewById(R.id.content);
    L8:
        if (r100 != null) goto L10;
        return;
    L7:
        r100 = null;
    L10:
        int r103 = (int) CommonKt.dp2px(r101, 147.0f);
        if ((r100 instanceof FrameLayout) == false) goto L14;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 81;
        r104.bottomMargin = r103;
        ViewGroup.LayoutParams r105 = r104;
    L19:
        r100.addView(r101, r105);
        return;
    L14:
        if ((r100 instanceof RelativeLayout) == false) goto L17;
        RelativeLayout.LayoutParams r106 = new RelativeLayout.LayoutParams(-2, -2);
        r106.addRule(12);
        r106.addRule(14);
        r106.bottomMargin = r103;
        r105 = r106;
        goto L19
    L17:
        if ((r100 instanceof ConstraintLayout) == false) goto L21;
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(-2, -2);
        r107.startToStart = 0;
        r107.endToEnd = 0;
        r107.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r107).bottomMargin = r103;
        r105 = r107;
        goto L19
    }

    private final void attachOverlayView(ViewGroup r100, VoiceSpeakerView r101) {
        if ((r100 instanceof LinearLayout) == false) goto L10;
        Activity r102 = findActivity();
        if (r102 == null) goto L7;
        r100 = (ViewGroup) r102.findViewById(R.id.content);
    L8:
        if (r100 != null) goto L10;
        return;
    L7:
        r100 = null;
    L10:
        int r103 = (int) CommonKt.dp2px(r101, 400.0f);
        if ((r100 instanceof FrameLayout) == false) goto L14;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, r103);
        r104.gravity = 81;
        ViewGroup.LayoutParams r105 = r104;
    L19:
        r100.addView(r101, r105);
        return;
    L14:
        if ((r100 instanceof RelativeLayout) == false) goto L17;
        RelativeLayout.LayoutParams r106 = new RelativeLayout.LayoutParams(-1, r103);
        r106.addRule(12);
        r106.addRule(14);
        r105 = r106;
        goto L19
    L17:
        if ((r100 instanceof ConstraintLayout) == false) goto L21;
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(0, r103);
        r107.startToStart = 0;
        r107.endToEnd = 0;
        r107.bottomToBottom = 0;
        r105 = r107;
        goto L19
    }

    private final void bringViewToTopZ(View r100, ViewGroup r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        int r103 = r101.getChildCount();     // Catch: Throwable -> L12
        float r104 = 0.0f;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L10;
        View r106 = r101.getChildAt(r105);     // Catch: Throwable -> L12
        if (r106 == r100) goto L9;
        if (r106.getElevation() <= r104) goto L9;
        r104 = r106.getElevation();     // Catch: Throwable -> L12
    L9:
        r105 = r105 + 1;     // Catch: Throwable -> L12
        goto L3
    L10:
        r100.setElevation(r104 + 1.0f);     // Catch: Throwable -> L12
        r101.bringChildToFront(r100);     // Catch: Throwable -> L12
        r101.invalidate();     // Catch: Throwable -> L12
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void touchToStart(ViewGroup r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = r101.getActionMasked();
        if (r102 != 0) goto L5;
        this.startY = r101.getRawY();
        VoiceSpeakerView r103 = this.overlayView;
        if (r103 == null) goto L26;
        r103.updateTouchPosition(r101.getRawX(), r101.getRawY());
    L26:
        handleActionDown(r100);
        return;
    L5:
        if (r102 != 1) goto L7;
        VoiceSpeakerView r104 = this.overlayView;
        if (r104 == null) goto L22;
        r104.clearTouchPosition();
    L22:
        handleActionUp(r101);
        return;
    L7:
        if (r102 != 2) goto L9;
        VoiceSpeakerView r105 = this.overlayView;
        if (r105 == null) goto L18;
        r105.updateTouchPosition(r101.getRawX(), r101.getRawY());
    L18:
        handleActionMove(r101);
        return;
    L9:
        if (r102 != 3) goto L31;
        VoiceSpeakerView r106 = this.overlayView;
        if (r106 == null) goto L14;
        r106.clearTouchPosition();
    L14:
        handleActionCancel();
        return;
    }

    public final void setup(Context r110, final VoicePrintConfig r111, final VoicePrintCallback r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "config");
        Intrinsics.checkNotNullParameter(r112, "callback");
        clearSession();
        this.context = r110;
        this.config = r111;
        this.cancelThresholdPx = CommonKt.dp2px(r110, 40.0f);
        VoicePrintCallback r100 = new VoicePrintController$setup$callbackWrapper$1(this, r112, r111);
        VoicePrintManager r113 = VoicePrintManager.INSTANCE;
        VoicePrintSession r101 = VoicePrintManager.createSession$default(r113, r111, r100, null, 4, null);
        r113.setOnVolumeChangeListener(r101, new VoicePrintController$setup$1$1(this));
        this.session = r101;
        VoiceSpeakerView r114 = new VoiceSpeakerView(r110, null, 0, 6, null);
        r114.setVisibility(8);
        r114.setElevation(CommonKt.dp2px(r114, 10.0f));
        VoicePrintUiDelegate r102 = this.uiDelegate;
        VoicePrintConfirmTipView r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getRecordingTips();
    L7:
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        r104 = r110.getString(com.larus.nova.R.string.voice_print_recording_tips);
    L15:
        r114.setText(r104, r110.getString(com.larus.nova.R.string.voice_print_recording_release_to_cancel));
        this.overlayView = r114;
        if (Intrinsics.areEqual(r111.getVerifyType(), VoicePrintOperation.VERIFY.getValue()) == false) goto L18;
        r103 = new VoicePrintConfirmTipView(r110, null, 0, 6, null);
        r103.setVisibility(8);
        r103.setElevation(CommonKt.dp2px(r103, 10.0f));
        r103.setText(r110.getString(com.larus.nova.R.string.voice_print_confirm_tip, new Object[]{r111.getVoiceText()}));
        r103.setGlowState(1);
    L18:
        this.confirmTipView = r103;
        return;
    L9:
        if (StringsKt.isBlank(r104) == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r104 = null;
        goto L7
    }
}
