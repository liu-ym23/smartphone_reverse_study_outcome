package com.zyql.ai.selector.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.BlendModeCompat;
import com.stepos.ailauncher.speech.tts.l;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.camera.listener.CaptureListener;
import com.zyql.ai.selector.camera.listener.ClickListener;
import com.zyql.ai.selector.camera.listener.TypeListener;
import com.zyql.ai.selector.tools.ScreenUtils;
import t0.C5499a;

/* loaded from: classes4.dex */
public class CaptureLayout extends FrameLayout {
    private TypeButton btn_cancel;
    private CaptureButton btn_capture;
    private TypeButton btn_confirm;
    private ReturnButton btn_return;
    private final int button_size;
    private CaptureListener captureListener;
    private int iconLeft;
    private int iconRight;
    private ImageView iv_custom_left;
    private ImageView iv_custom_right;
    private final int layout_height;
    private final int layout_width;
    private ClickListener leftClickListener;
    private ProgressBar progress_bar;
    private ClickListener rightClickListener;
    private TextView txt_tip;
    private TypeListener typeListener;

    public CaptureLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCaptureTip() {
        int buttonFeatures = this.btn_capture.getButtonFeatures();
        return buttonFeatures != 257 ? buttonFeatures != 258 ? getContext().getString(R.string.picture_photo_camera) : getContext().getString(R.string.picture_photo_recording) : getContext().getString(R.string.picture_photo_pictures);
    }

    private void initView() {
        setWillNotDraw(false);
        this.progress_bar = new ProgressBar(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.progress_bar.setLayoutParams(layoutParams);
        this.progress_bar.setVisibility(8);
        this.btn_capture = new CaptureButton(getContext(), this.button_size);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.btn_capture.setLayoutParams(layoutParams2);
        this.btn_capture.setCaptureListener(new CaptureListener() { // from class: com.zyql.ai.selector.camera.view.CaptureLayout.2
            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void recordEnd(long j10) {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordEnd(j10);
                }
                CaptureLayout.this.startTypeBtnAnimator();
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void recordError() {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordError();
                }
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void recordShort(long j10) {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordShort(j10);
                }
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void recordStart() {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordStart();
                }
                CaptureLayout.this.startAlphaAnimation();
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void recordZoom(float f10) {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordZoom(f10);
                }
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void takePictures() {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.takePictures();
                }
                CaptureLayout.this.startAlphaAnimation();
            }
        });
        this.btn_cancel = new TypeButton(getContext(), 1, this.button_size);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins((this.layout_width / 4) - (this.button_size / 2), 0, 0, 0);
        this.btn_cancel.setLayoutParams(layoutParams3);
        this.btn_cancel.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.camera.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31977a.lambda$initView$0(view);
            }
        });
        this.btn_confirm = new TypeButton(getContext(), 2, this.button_size);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams4.gravity = 21;
        layoutParams4.setMargins(0, 0, (this.layout_width / 4) - (this.button_size / 2), 0);
        this.btn_confirm.setLayoutParams(layoutParams4);
        this.btn_confirm.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.camera.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31978a.lambda$initView$1(view);
            }
        });
        this.btn_return = new ReturnButton(getContext(), (int) (this.button_size / 2.5f));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.setMargins(this.layout_width / 6, 0, 0, 0);
        this.btn_return.setLayoutParams(layoutParams5);
        this.btn_return.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.camera.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31979a.lambda$initView$2(view);
            }
        });
        this.iv_custom_left = new ImageView(getContext());
        int i10 = this.button_size;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams((int) (i10 / 2.5f), (int) (i10 / 2.5f));
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(this.layout_width / 6, 0, 0, 0);
        this.iv_custom_left.setLayoutParams(layoutParams6);
        this.iv_custom_left.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.camera.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31980a.lambda$initView$3(view);
            }
        });
        this.iv_custom_right = new ImageView(getContext());
        int i11 = this.button_size;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (i11 / 2.5f), (int) (i11 / 2.5f));
        layoutParams7.gravity = 21;
        layoutParams7.setMargins(0, 0, this.layout_width / 6, 0);
        this.iv_custom_right.setLayoutParams(layoutParams7);
        this.iv_custom_right.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.camera.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31981a.lambda$initView$4(view);
            }
        });
        this.txt_tip = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams8.gravity = 1;
        layoutParams8.setMargins(0, 0, 0, 0);
        this.txt_tip.setText(getCaptureTip());
        this.txt_tip.setTextColor(-1);
        this.txt_tip.setGravity(17);
        this.txt_tip.setLayoutParams(layoutParams8);
        addView(this.btn_capture);
        addView(this.progress_bar);
        addView(this.btn_cancel);
        addView(this.btn_confirm);
        addView(this.btn_return);
        addView(this.iv_custom_left);
        addView(this.iv_custom_right);
        addView(this.txt_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        TypeListener typeListener = this.typeListener;
        if (typeListener != null) {
            typeListener.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(View view) {
        TypeListener typeListener = this.typeListener;
        if (typeListener != null) {
            typeListener.confirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(View view) {
        ClickListener clickListener = this.leftClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(View view) {
        ClickListener clickListener = this.leftClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(View view) {
        ClickListener clickListener = this.rightClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
    }

    public void initEvent() {
        this.iv_custom_right.setVisibility(8);
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(this.layout_width, this.layout_height);
    }

    public void resetCaptureLayout() {
        this.btn_capture.resetState();
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
        this.btn_capture.setVisibility(0);
        this.txt_tip.setText(getCaptureTip());
        this.txt_tip.setVisibility(0);
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(0);
        } else {
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(0);
        }
    }

    public void setButtonCaptureEnabled(boolean z10) {
        this.progress_bar.setVisibility(z10 ? 8 : 0);
        this.btn_capture.setButtonCaptureEnabled(z10);
    }

    public void setButtonFeatures(int i10) {
        this.btn_capture.setButtonFeatures(i10);
        this.txt_tip.setText(getCaptureTip());
    }

    public void setCaptureListener(CaptureListener captureListener) {
        this.captureListener = captureListener;
    }

    public void setCaptureLoadingColor(int i10) {
        this.progress_bar.getIndeterminateDrawable().setColorFilter(C5499a.a(i10, BlendModeCompat.SRC_IN));
    }

    public void setDuration(int i10) {
        this.btn_capture.setDuration(i10);
    }

    public void setIconSrc(int i10, int i11) {
        this.iconLeft = i10;
        this.iconRight = i11;
        if (i10 != 0) {
            this.iv_custom_left.setImageResource(i10);
            this.iv_custom_left.setVisibility(0);
            this.btn_return.setVisibility(8);
        } else {
            this.iv_custom_left.setVisibility(8);
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight == 0) {
            this.iv_custom_right.setVisibility(8);
        } else {
            this.iv_custom_right.setImageResource(i11);
            this.iv_custom_right.setVisibility(0);
        }
    }

    public void setLeftClickListener(ClickListener clickListener) {
        this.leftClickListener = clickListener;
    }

    public void setMinDuration(int i10) {
        this.btn_capture.setMinDuration(i10);
    }

    public void setRightClickListener(ClickListener clickListener) {
        this.rightClickListener = clickListener;
    }

    public void setTextWithAnimation(String str) {
        this.txt_tip.setText(str);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.txt_tip, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 0.0f, 1.0f, 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.zyql.ai.selector.camera.view.CaptureLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CaptureLayout.this.txt_tip.setText(CaptureLayout.this.getCaptureTip());
                CaptureLayout.this.txt_tip.setAlpha(1.0f);
            }
        });
        objectAnimatorOfFloat.setDuration(l.SAFE_CLOSE_LEAD_MS);
        objectAnimatorOfFloat.start();
    }

    public void setTip(String str) {
        this.txt_tip.setText(str);
    }

    public void setTypeListener(TypeListener typeListener) {
        this.typeListener = typeListener;
    }

    public void showTip() {
        this.txt_tip.setVisibility(0);
    }

    public void startAlphaAnimation() {
        this.txt_tip.setVisibility(4);
    }

    public void startTypeBtnAnimator() {
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(8);
        } else {
            this.btn_return.setVisibility(8);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(8);
        }
        this.btn_capture.setVisibility(8);
        this.btn_cancel.setVisibility(0);
        this.btn_confirm.setVisibility(0);
        this.btn_cancel.setClickable(false);
        this.btn_confirm.setClickable(false);
        this.iv_custom_left.setVisibility(8);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.btn_cancel, "translationX", this.layout_width / 4, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.btn_confirm, "translationX", (-this.layout_width) / 4, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.zyql.ai.selector.camera.view.CaptureLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CaptureLayout.this.btn_cancel.setClickable(true);
                CaptureLayout.this.btn_confirm.setClickable(true);
            }
        });
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    public CaptureLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.iconLeft = 0;
        this.iconRight = 0;
        int screenWidth = ScreenUtils.getScreenWidth(getContext());
        if (getResources().getConfiguration().orientation == 1) {
            this.layout_width = screenWidth;
        } else {
            this.layout_width = screenWidth / 2;
        }
        int i11 = (int) (this.layout_width / 4.5f);
        this.button_size = i11;
        this.layout_height = i11 + ((i11 / 5) * 2) + 100;
        initView();
        initEvent();
    }
}
