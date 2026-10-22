package android.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.StepOSViewCaptureManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.animation.PathInterpolator;
import com.stepos.feature.StepOSFeature;
import com.stepos.internal.picker.ContentCapture;
import com.stepos.internal.picker.FindContentUtil;
import com.stepos.internal.picker.OneMindUtil;
import com.stepos.internal.picker.data.DragAndDropBinder;
import com.stepos.internal.picker.dragshadowbuilder.BaseScaleDragShadowBuilder;
import com.stepos.settings.config.StepOSSettingsKeys;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class StepOSViewExtImpl implements IStepOSViewExt {
    private static final String KEY_START_WINDOWMODE = "start_windowmode";
    private static final String MIME_IGNORE_STEPOS_LAUNCHER = "com.android.launcher3";
    private static final String PKG_STEPOS_VOICE_ASSISTANT = "com.stepos.voiceassistant";
    private static final String STEPOS_AI_ACTION_START_DRAG_AND_DROP = "com.stepos.ai.picker.action.service.START_DRAG_AND_DROP";
    private static final String TAG = "StepOSViewExtImpl";
    private static final String TAG_CONTENT_CAPTURE = "ContentCapture";
    private DragAndDropBinder mDragAndDropBinder;
    private WeakReference<View> mDragTargetView;
    private View mHost;
    private BaseScaleDragShadowBuilder mScaleDragShadowBuilder;
    private ValueAnimator mScaleValueAnimator;
    private boolean mHasPlayAnimation = false;
    private boolean mNeedCallback = false;

    public void onAttach(View host) {
        this.mHost = host;
    }

    public void onDraw(Canvas canvas) {
    }

    public void onDetach() {
        if (this.mScaleValueAnimator != null) {
            this.mScaleValueAnimator.cancel();
            this.mScaleValueAnimator = null;
        }
        this.mDragTargetView = null;
        this.mScaleDragShadowBuilder = null;
        this.mDragAndDropBinder = null;
        this.mHasPlayAnimation = false;
        this.mHost = null;
    }

    public void onDispatchDragEvent(DragEvent event) {
        if (!StepOSFeature.STEPOS_FEATURE_GLOBAL_DRAG) {
            return;
        }
        ContentCapture.getInstance().dispatchDragEventHandler(event);
    }

    public boolean tryStartActivityForResult(String who, Intent intent, int requestCode) {
        Context context;
        if (this.mHost == null || intent == null || (context = this.mHost.getContext()) == null) {
            return false;
        }
        int windowModeOpen = Settings.System.getInt(context.getContentResolver(), StepOSSettingsKeys.SYSTEM_WINDOW_MODE_TEXT_SEARCH, 0);
        if (windowModeOpen != 1) {
            return false;
        }
        intent.setFlags(402653184);
        Bundle bundle = ActivityOptions.makeBasic().toBundle();
        bundle.putBoolean(KEY_START_WINDOWMODE, true);
        context.startActivityForResult(who, intent, requestCode, bundle);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0271  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStartDragAndDrop(android.content.ClipData r24, android.view.View.DragShadowBuilder r25, java.lang.Object r26, int r27) {
        /*
            Method dump skipped, instructions count: 715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.StepOSViewExtImpl.onStartDragAndDrop(android.content.ClipData, android.view.View$DragShadowBuilder, java.lang.Object, int):void");
    }

    private boolean checkLongClickAndCaptureByView(Context context) {
        int pickerConfigValue;
        if (context == null) {
            Log.d(TAG, "checkLongClickAndCapture, context is null");
            return false;
        }
        String packageName = context.getPackageName();
        Log.d(TAG, "checkLongClickAndCaptureByView, packageName:" + packageName);
        if (PKG_STEPOS_VOICE_ASSISTANT.equals(packageName)) {
            Log.d(TAG, "checkLongClickAndCapture, ignore: " + packageName);
            return true;
        }
        if (TextUtils.equals("com.stepos.media.gallery", packageName)) {
            Log.d(TAG, "checkLongClickAndCaptureByView, disabled pkg: " + packageName);
            return false;
        }
        if (TextUtils.equals("com.stepos.setup", packageName)) {
            Log.d(TAG, "checkLongClickAndCaptureByView, disabled pkg: " + packageName);
            return false;
        }
        if (TextUtils.equals("com.android.settings", packageName)) {
            Log.d(TAG, "checkLongClickAndCaptureByView, disabled pkg: " + packageName);
            return false;
        }
        if (!OneMindUtil.hasEnableAlphaMe(context)) {
            Log.d(TAG, "checkLongClickAndCaptureByView, hasEnableAlphaMe false: " + packageName);
            return false;
        }
        if (OneMindUtil.hasAppFlag(context, packageName, 29)) {
            Log.d(TAG, "checkLongClickAndCaptureByView, pkg not allowed : " + packageName);
            return false;
        }
        if (OneMindUtil.isGameScene(context)) {
            Log.d(TAG, "checkLongClickAndCaptureByView, game scene : " + packageName);
            return false;
        }
        Activity activity = FindContentUtil.getActivity(context);
        if (activity == null) {
            pickerConfigValue = OneMindUtil.detectActivityScene(3);
        } else {
            pickerConfigValue = OneMindUtil.detectActivitySceneByActivity(3, activity.getClass().getName());
        }
        if (pickerConfigValue != 0) {
            return true;
        }
        Log.d(TAG, "checkLongClickAndCaptureByView, activity not allowed");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPlayEnterOrExitAnimation(final boolean isEnter) {
        Log.v(TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation isEnter: " + isEnter);
        if (this.mDragTargetView == null || this.mDragTargetView.get() == null) {
            Log.v(TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation view is null!");
            return;
        }
        if (this.mScaleValueAnimator != null) {
            this.mHost.post(new Runnable() { // from class: android.view.StepOSViewExtImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.v(StepOSViewExtImpl.TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation mScaleValueAnimator.cancel().");
                    StepOSViewExtImpl.this.mScaleValueAnimator.cancel();
                    StepOSViewExtImpl.this.mScaleValueAnimator = null;
                    Log.v(StepOSViewExtImpl.TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation mScaleValueAnimator.cancel() done.");
                }
            });
        }
        if (this.mScaleDragShadowBuilder == null) {
            Log.v(TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation mScaleDragShadowBuilder is null.");
            return;
        }
        if (this.mDragTargetView != null && this.mDragTargetView.get() != null) {
            this.mHost.post(new Runnable() { // from class: android.view.StepOSViewExtImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ValueAnimator valueAnimatorOfFloat;
                    StepOSViewExtImpl stepOSViewExtImpl = StepOSViewExtImpl.this;
                    if (isEnter) {
                        valueAnimatorOfFloat = ObjectAnimator.ofFloat(StepOSViewExtImpl.this.mScaleDragShadowBuilder.getFirstScaleValue(), StepOSViewExtImpl.this.mScaleDragShadowBuilder.getSecondScaleValue());
                    } else {
                        valueAnimatorOfFloat = ObjectAnimator.ofFloat(StepOSViewExtImpl.this.mScaleDragShadowBuilder.getSecondScaleValue(), StepOSViewExtImpl.this.mScaleDragShadowBuilder.getFirstScaleValue());
                    }
                    stepOSViewExtImpl.mScaleValueAnimator = valueAnimatorOfFloat;
                    StepOSViewExtImpl.this.mScaleValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.view.StepOSViewExtImpl.3.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (StepOSViewExtImpl.this.mScaleDragShadowBuilder != null && valueAnimator != null) {
                                StepOSViewExtImpl.this.mScaleDragShadowBuilder.setScaleValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                if (StepOSViewExtImpl.this.mDragTargetView != null && StepOSViewExtImpl.this.mDragTargetView.get() != null) {
                                    ((View) StepOSViewExtImpl.this.mDragTargetView.get()).updateDragShadow(StepOSViewExtImpl.this.mScaleDragShadowBuilder);
                                }
                            }
                        }
                    });
                    StepOSViewExtImpl.this.mScaleValueAnimator.setDuration(500L);
                    StepOSViewExtImpl.this.mScaleValueAnimator.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
                    Log.v(StepOSViewExtImpl.TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation valueAnimator.start().");
                    StepOSViewExtImpl.this.mScaleValueAnimator.start();
                    Log.v(StepOSViewExtImpl.TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation valueAnimator.start() done.");
                }
            });
            Log.v(TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation mDragTargetView.get().post: " + this.mHost.getClass().getName());
        } else {
            Log.v(TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation mDragTargetView is null.");
        }
        Log.v(TAG_CONTENT_CAPTURE, "doPlayEnterOrExitAnimation done.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPlayAnimation(ValueAnimator valueAnimator) {
        Log.v(TAG_CONTENT_CAPTURE, "doPlayAnimation hasPlayAnimation: " + this.mHasPlayAnimation);
        if (this.mHasPlayAnimation) {
            return;
        }
        this.mHasPlayAnimation = true;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private void initDragAndDropBinder() {
        if (this.mDragAndDropBinder != null) {
            return;
        }
        this.mDragAndDropBinder = new DragAndDropBinder();
        this.mDragAndDropBinder.setOnDragAndDropListener(new DragAndDropBinder.OnDragAndDropListener() { // from class: android.view.StepOSViewExtImpl.4
            public void onDragStatus(int status, Parcel data) {
                Log.d(StepOSViewExtImpl.TAG_CONTENT_CAPTURE, "ScanScreen onDragStatus status: " + status);
                if (1 == status) {
                    if (StepOSViewExtImpl.this.mScaleValueAnimator != null) {
                        StepOSViewExtImpl.this.doPlayAnimation(StepOSViewExtImpl.this.mScaleValueAnimator);
                    }
                } else {
                    if (2 == status) {
                        StepOSViewExtImpl.this.doPlayEnterOrExitAnimation(true);
                        if (StepOSViewExtImpl.this.mScaleDragShadowBuilder != null) {
                            StepOSViewExtImpl.this.mScaleDragShadowBuilder.setEnableDragTipIcon(true);
                            return;
                        }
                        return;
                    }
                    if (5 == status) {
                        StepOSViewExtImpl.this.doPlayEnterOrExitAnimation(false);
                        if (StepOSViewExtImpl.this.mScaleDragShadowBuilder != null) {
                            StepOSViewExtImpl.this.mScaleDragShadowBuilder.setEnableDragTipIcon(false);
                        }
                    }
                }
            }
        });
    }

    public void setNeedCallback(boolean need) {
        this.mNeedCallback = need;
    }

    public boolean needCallback() {
        return this.mNeedCallback;
    }

    public void dispatchViewClick() {
        if (this.mHost == null) {
            return;
        }
        StepOSViewCaptureManager.getInstance().dispatchViewClick(this.mHost);
    }
}
