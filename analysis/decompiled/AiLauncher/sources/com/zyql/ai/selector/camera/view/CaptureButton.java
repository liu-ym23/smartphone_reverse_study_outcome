package com.zyql.ai.selector.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import com.zyql.ai.selector.camera.CheckPermission;
import com.zyql.ai.selector.camera.CustomCameraView;
import com.zyql.ai.selector.camera.listener.CaptureListener;
import com.zyql.ai.selector.tools.DoubleUtils;

/* loaded from: classes4.dex */
public class CaptureButton extends View {
    public static final int STATE_BAN = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDERING = 4;
    private float button_inside_radius;
    private float button_outside_radius;
    private float button_radius;
    private int button_size;
    private int button_state;
    private CaptureListener captureLisenter;
    private float center_X;
    private float center_Y;
    private int duration;
    private float event_Y;
    private int inside_color;
    private int inside_reduce_size;
    private boolean isTakeCamera;
    private LongPressRunnable longPressRunnable;
    private Paint mPaint;
    private int min_duration;
    private int outside_add_size;
    private int outside_color;
    private float progress;
    private int progress_color;
    private int recorded_time;
    private RectF rectF;
    private int state;
    private float strokeWidth;
    private RecordCountDownTimer timer;

    public class LongPressRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            CaptureButton.this.state = 3;
            if (CheckPermission.getRecordState() != 1) {
                CaptureButton.this.state = 1;
                if (CaptureButton.this.captureLisenter != null) {
                    CaptureButton.this.captureLisenter.recordError();
                    return;
                }
            }
            CaptureButton captureButton = CaptureButton.this;
            captureButton.startRecordAnimation(captureButton.button_outside_radius, CaptureButton.this.button_outside_radius + CaptureButton.this.outside_add_size, CaptureButton.this.button_inside_radius, CaptureButton.this.button_inside_radius - CaptureButton.this.inside_reduce_size);
        }

        private LongPressRunnable() {
        }
    }

    public class RecordCountDownTimer extends CountDownTimer {
        public RecordCountDownTimer(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CaptureButton.this.recordEnd();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            CaptureButton.this.updateProgress(j10);
        }
    }

    public CaptureButton(Context context) {
        super(context);
        this.progress_color = -300503530;
        this.outside_color = -287515428;
        this.inside_color = -1;
        this.isTakeCamera = true;
    }

    private void handlerPressByState() {
        int i10;
        removeCallbacks(this.longPressRunnable);
        int i11 = this.state;
        if (i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                this.timer.cancel();
                recordEnd();
            }
        } else if (this.captureLisenter == null || !((i10 = this.button_state) == 257 || i10 == 259)) {
            this.state = 1;
        } else {
            startCaptureAnimation(this.button_inside_radius);
        }
        this.state = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCaptureAnimation$0(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordAnimation$1(ValueAnimator valueAnimator) {
        this.button_outside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordAnimation$2(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void resetRecordAnim() {
        this.state = 5;
        this.progress = 0.0f;
        invalidate();
        float f10 = this.button_outside_radius;
        float f11 = this.button_radius;
        startRecordAnimation(f10, f11, this.button_inside_radius, 0.75f * f11);
    }

    private void startCaptureAnimation(float f10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, 0.75f * f10, f10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zyql.ai.selector.camera.view.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f31974a.lambda$startCaptureAnimation$0(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.zyql.ai.selector.camera.view.CaptureButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (CaptureButton.this.captureLisenter != null) {
                    CaptureButton.this.captureLisenter.takePictures();
                }
                CaptureButton.this.state = 5;
            }
        });
        valueAnimatorOfFloat.setDuration(50L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecordAnimation(float f10, float f11, float f12, float f13) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f12, f13);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zyql.ai.selector.camera.view.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f31975a.lambda$startRecordAnimation$1(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zyql.ai.selector.camera.view.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f31976a.lambda$startRecordAnimation$2(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.zyql.ai.selector.camera.view.CaptureButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (DoubleUtils.isFastDoubleClick()) {
                    return;
                }
                if (CaptureButton.this.state != 3) {
                    CaptureButton.this.state = 1;
                    return;
                }
                if (CaptureButton.this.captureLisenter != null) {
                    CaptureButton.this.captureLisenter.recordStart();
                }
                CaptureButton.this.state = 4;
                CaptureButton.this.timer.start();
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j10) {
        int i10 = this.duration;
        this.recorded_time = (int) (i10 - j10);
        this.progress = 360.0f - ((j10 / i10) * 360.0f);
        invalidate();
    }

    public int getButtonFeatures() {
        return this.button_state;
    }

    public boolean isIdle() {
        return this.state == 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.outside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_outside_radius, this.mPaint);
        this.mPaint.setColor(this.inside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_inside_radius, this.mPaint);
        if (this.state == 4) {
            this.mPaint.setColor(this.progress_color);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            canvas.drawArc(this.rectF, -90.0f, this.progress, false, this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int i12 = this.button_size;
        int i13 = this.outside_add_size;
        setMeasuredDimension((i13 * 2) + i12, i12 + (i13 * 2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CaptureListener captureListener;
        int i10;
        if (this.isTakeCamera) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    handlerPressByState();
                } else if (action == 2 && (captureListener = this.captureLisenter) != null && this.state == 4 && ((i10 = this.button_state) == 258 || i10 == 259)) {
                    captureListener.recordZoom(this.event_Y - motionEvent.getY());
                }
            } else if (motionEvent.getPointerCount() <= 1 && this.state == 1) {
                this.event_Y = motionEvent.getY();
                this.state = 2;
                int i11 = this.button_state;
                if (i11 == 258 || i11 == 259) {
                    postDelayed(this.longPressRunnable, 500L);
                }
            }
        }
        return true;
    }

    public void recordEnd() {
        CaptureListener captureListener = this.captureLisenter;
        if (captureListener != null) {
            int i10 = this.recorded_time;
            if (i10 < this.min_duration) {
                captureListener.recordShort(i10);
            } else {
                captureListener.recordEnd(i10);
            }
        }
        resetRecordAnim();
    }

    public void resetState() {
        this.state = 1;
    }

    public void setButtonCaptureEnabled(boolean z10) {
        this.isTakeCamera = z10;
    }

    public void setButtonFeatures(int i10) {
        this.button_state = i10;
    }

    public void setCaptureListener(CaptureListener captureListener) {
        this.captureLisenter = captureListener;
    }

    public void setDuration(int i10) {
        this.duration = i10;
        this.timer = new RecordCountDownTimer(i10, i10 / 360);
    }

    public void setMinDuration(int i10) {
        this.min_duration = i10;
    }

    public CaptureButton(Context context, int i10) {
        super(context);
        this.progress_color = -300503530;
        this.outside_color = -287515428;
        this.inside_color = -1;
        this.isTakeCamera = true;
        this.button_size = i10;
        float f10 = i10 / 2.0f;
        this.button_radius = f10;
        this.button_outside_radius = f10;
        this.button_inside_radius = f10 * 0.75f;
        this.strokeWidth = i10 / 15;
        int i11 = i10 / 8;
        this.outside_add_size = i11;
        this.inside_reduce_size = i11;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.progress = 0.0f;
        this.longPressRunnable = new LongPressRunnable();
        this.state = 1;
        this.button_state = CustomCameraView.BUTTON_STATE_BOTH;
        this.duration = 10000;
        this.min_duration = 1500;
        int i12 = this.button_size;
        int i13 = this.outside_add_size;
        this.center_X = ((i13 * 2) + i12) / 2;
        this.center_Y = (i12 + (i13 * 2)) / 2;
        float f11 = this.center_X;
        float f12 = this.button_radius;
        int i14 = this.outside_add_size;
        float f13 = this.strokeWidth;
        float f14 = this.center_Y;
        this.rectF = new RectF(f11 - ((i14 + f12) - (f13 / 2.0f)), f14 - ((i14 + f12) - (f13 / 2.0f)), f11 + ((i14 + f12) - (f13 / 2.0f)), f14 + ((f12 + i14) - (f13 / 2.0f)));
        this.timer = new RecordCountDownTimer(this.duration, r14 / 360);
    }
}
