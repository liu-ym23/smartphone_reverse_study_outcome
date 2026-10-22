package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;", "getFinishListener", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;", "setFinishListener", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;)V", "finishListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioRecordViewV3 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f136056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f136057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioWaveViewV3 f136058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f136059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f136060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieAnimationView f136061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f136062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f136063h;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioRecordViewV3 f136064a;

        public a(AudioRecordViewV3 r100) {
            this.f136064a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            c r101 = this.f136064a.getFinishListener();
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    public static final class b {
    }

    public interface c {
        void a();
    }

    static {
    }

    public final void b() {
        this.f136062g = 0;
        this.f136058c.c();
        this.f136061f.pauseAnimation();
    }

    public final c getFinishListener() {
        return this.f136056a;
    }

    public AudioRecordViewV3(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setFinishListener(c r100) {
        this.f136056a = r100;
    }

    public AudioRecordViewV3(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static void a(ConstraintLayout r100, ConstraintLayout r101) {
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{1.0f, 0.0f});
        r102.setDuration(150);
        r102.start();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r103.setDuration(150);
        r103.setStartDelay(100);
        r103.start();
    }

    public final void c(int r100, boolean r101) {
        int r102 = this.f136062g;
        if (r100 != r102) goto L6;
        return;
    L6:
        if (r100 == 1) goto L30;
        if (r100 == 2) goto L17;
        if (r100 != 3) goto L34;
        if (r102 != 1) goto L14;
        if (r101 == false) goto L14;
        a(this.f136059d, this.f136057b);
    L14:
        if (r102 != 2) goto L34;
        if (r101 == false) goto L34;
        a(this.f136059d, this.f136060e);
    L34:
        if (r101 == false) goto L37;
        this.f136062g = r100;
        return;
    L37:
        return;
    L17:
        if (r102 == 1) goto L19;
        if (r102 != 3) goto L34;
        if (this.f136063h == true) goto L27;
        this.f136063h = true;
        this.f136061f.playAnimation();
    L27:
        if (r101 == false) goto L34;
        a(this.f136060e, this.f136059d);
        goto L34
    L19:
        if (this.f136063h == true) goto L21;
        this.f136063h = true;
        this.f136061f.playAnimation();
    L21:
        if (r101 == false) goto L34;
        a(this.f136060e, this.f136057b);
        goto L34
    L30:
        if (this.f136063h == true) goto L34;
        if (r102 != 3) goto L34;
        if (r101 == false) goto L34;
        a(this.f136057b, this.f136059d);
        goto L34
    }

    public AudioRecordViewV3(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_comment_recording_v3, this);
        setBackgroundResource(R.drawable.ttlive_audio_black_bg);
        ConstraintLayout r103 = (ConstraintLayout) findViewById(R.id.audio_wave);
        this.f136057b = r103;
        this.f136058c = (AudioWaveViewV3) r103.findViewById(R.id.audio_wave_view);
        this.f136059d = (ConstraintLayout) findViewById(R.id.audio_cancel);
        this.f136060e = (ConstraintLayout) findViewById(R.id.audio_count_down);
        LottieAnimationView r104 = (LottieAnimationView) findViewById(R.id.audio_count_down_view);
        this.f136061f = r104;
        r104.addAnimatorListener(new a(this));
    }
}
