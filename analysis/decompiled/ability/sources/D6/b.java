package D6;

import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.compose.material.ripple.RippleHostView;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.room.RoomTrackingLiveData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.ability.R;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.ability.voicewakeup.training.TrainingActivity;
import com.stepos.common.picker.WheelPicker;
import com.stepos.deepbinder.core.handler.BaseInvocationHandler;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import com.stepos.taskrobot.llmapi.stepfun.MainDisplayWatcher;
import com.stepos.taskrobot.llmapi.stepfun.view.InfoDebugWindow;
import com.stepos.widget.glass.StepOSGlassImageButton;
import com.stepos.widget.toolbar.StepOSTitleBar;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import reactor.core.Disposable;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f379a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f379a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws NumberFormatException {
        R5.d dVar;
        int i = this.f379a;
        int i6 = 1;
        char c = 1;
        int i10 = 0;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((f) obj).getClass();
                break;
            case 1:
                h hVar = (h) obj;
                hVar.e = false;
                hVar.d = SystemClock.uptimeMillis();
                hVar.b.invoke();
                break;
            case 2:
                StepOSGlassImageButton stepOSGlassImageButton = (StepOSGlassImageButton) obj;
                stepOSGlassImageButton.d = false;
                if (stepOSGlassImageButton.isAttachedToWindow()) {
                    f fVar = stepOSGlassImageButton.b;
                    if (stepOSGlassImageButton.isGlassEnabled && stepOSGlassImageButton.getWidth() > 0 && stepOSGlassImageButton.getHeight() > 0 && stepOSGlassImageButton.getVisibility() != 8) {
                        float fMin = stepOSGlassImageButton.glassCornerRadius;
                        if (fMin <= 0.0f) {
                            fMin = Math.min(stepOSGlassImageButton.getWidth(), stepOSGlassImageButton.getHeight()) / 2.0f;
                        }
                        float f = fMin;
                        a aVar = stepOSGlassImageButton.e;
                        k kVar = new k(stepOSGlassImageButton.getWidth(), stepOSGlassImageButton.getHeight(), f, stepOSGlassImageButton.isGlassCrossWindow, stepOSGlassImageButton.getGlassEffect(), aVar);
                        if (!kotlin.jvm.internal.k.b(stepOSGlassImageButton.c, kVar)) {
                            boolean z10 = stepOSGlassImageButton.isGlassCrossWindow;
                            if (aVar != null) {
                                fVar.c(z10 ? 1 : 0, f, new j(aVar, i10));
                            } else {
                                fVar.a(f, z10 ? 1 : 0, stepOSGlassImageButton.getGlassEffect());
                            }
                            stepOSGlassImageButton.c = kVar;
                            stepOSGlassImageButton.invalidate();
                            break;
                        }
                    } else {
                        stepOSGlassImageButton.a();
                        break;
                    }
                }
                break;
            case 3:
                VoiceWakeSettingActivity voiceWakeSettingActivity = (VoiceWakeSettingActivity) obj;
                int i11 = VoiceWakeSettingActivity.f3343j;
                if (!voiceWakeSettingActivity.isFinishing() && !voiceWakeSettingActivity.isDestroyed()) {
                    voiceWakeSettingActivity.v(false);
                    Settings.Global.putInt(voiceWakeSettingActivity.getContentResolver(), "voice_wakeup_enabled", 0);
                    com.stepos.ability.voicewakeup.service.l lVar = com.stepos.ability.voicewakeup.service.l.f3333a;
                    com.stepos.ability.voicewakeup.service.l.u();
                    Toast.makeText(voiceWakeSettingActivity, R.string.voice_wake_train_unsupported, 0).show();
                    break;
                }
                break;
            case 4:
                TrainingActivity trainingActivity = (TrainingActivity) obj;
                if (!trainingActivity.f3362F && !trainingActivity.f3363G && !trainingActivity.f3374z && !trainingActivity.isFinishing() && !trainingActivity.isDestroyed() && trainingActivity.f3359B == null && trainingActivity.w()) {
                    trainingActivity.B();
                    break;
                }
                break;
            case 5:
                ((I4.h) obj).c();
                break;
            case 6:
                I9.d.a(new O5.b((O5.d) obj, c == true ? 1 : 0, i10));
                break;
            case 7:
                A5.c cVar = (A5.c) obj;
                cVar.getClass();
                if (TextUtils.isEmpty(null)) {
                    W5.c.a("SessionController", "set source: null");
                    String str = (String) cVar.b;
                    if (str != null && (dVar = O5.c.f1037a.d) != null) {
                        com.stepos.statsapp.v3.lib.plugin.emitter.remote.d dVar2 = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.d) dVar.c;
                        dVar2.e.execute(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.b(i6, dVar2, str));
                        break;
                    }
                }
                break;
            case 8:
                ((CarouselLayoutManager) obj).requestLayout();
                break;
            case 9:
                RippleHostView.setRippleState$lambda$2((RippleHostView) obj);
                break;
            case 10:
                AndroidContentCaptureManager.contentCaptureChangeChecker$lambda$2((AndroidContentCaptureManager) obj);
                break;
            case 11:
                TextInputServiceAndroid.sendInputCommand$lambda$1((TextInputServiceAndroid) obj);
                break;
            case 12:
                ((Carousel) obj).lambda$updateItems$0();
                break;
            case 13:
                DefaultSpecialEffectsController.startTransitions$lambda$11((ArrayList) obj);
                break;
            case 14:
                ((Fragment) obj).lambda$performCreateView$0();
                break;
            case 15:
                RoomTrackingLiveData.access$invalidated((RoomTrackingLiveData) obj);
                break;
            case 16:
                MaterialButton.a((MaterialButton) obj);
                break;
            case 17:
                com.google.android.material.bottomsheet.f fVar2 = (com.google.android.material.bottomsheet.f) obj;
                fVar2.c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) fVar2.e;
                ViewDragHelper viewDragHelper = sideSheetBehavior.i;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    fVar2.a(fVar2.b);
                    break;
                } else if (sideSheetBehavior.h == 2) {
                    sideSheetBehavior.c(fVar2.b);
                    break;
                }
                break;
            case 18:
                Slider slider = (Slider) obj;
                slider.setActiveThumbIndex(-1);
                slider.invalidate();
                break;
            case 19:
                ((com.google.android.material.textfield.c) obj).t(true);
                break;
            case 20:
                com.google.android.material.textfield.j jVar = (com.google.android.material.textfield.j) obj;
                boolean zIsPopupShowing = jVar.h.isPopupShowing();
                jVar.t(zIsPopupShowing);
                jVar.m = zIsPopupShowing;
                break;
            case 21:
                ((TextInputLayout) obj).e.requestLayout();
                break;
            case 22:
                AgentServiceClient.scheduleBindTimeout$lambda$0((AtomicBoolean) obj);
                break;
            case 23:
                int i12 = WheelPicker.f3576z;
                ((WheelPicker) obj).c();
                break;
            case 24:
                ((BaseInvocationHandler) obj).recycleOriginObjects();
                break;
            case 25:
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0((PolicySDKLoadDataView) obj);
                break;
            case 26:
                MainDisplayWatcher.armSettleTimeoutLocked$lambda$0((MainDisplayWatcher) obj);
                break;
            case 27:
                InfoDebugWindow.dismiss$lambda$0((InfoDebugWindow) obj);
                break;
            case 28:
                StepOSTitleBar.a((StepOSTitleBar) obj);
                break;
            default:
                ((Disposable.Composite) obj).dispose();
                break;
        }
    }
}
