package com.stepos.ailauncher.chat.voice.support.widget;

import Y8.t;
import Z8.C1173v;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l5.n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\rJ\u000f\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010\u001fJ\u000f\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0004\b%\u0010\u001fJ\u0013\u0010'\u001a\u00020&*\u00020\u0017H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00101R\u0014\u00104\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00101R\u0016\u00105\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0018\u00108\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010<R\u0014\u0010A\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010<¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/support/widget/c;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "tip", "setTextPlease", "(Ljava/lang/String;)V", "r", "volume", "q", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", UxipConstants.f30680s, "t", "Landroid/animation/Animator;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroid/animation/Animator;", "m", "l", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", "", "n", "(Landroid/content/res/Configuration;)Z", "useNightMode", "s", "(Z)V", "Ll5/n;", "viewBinding", "Ll5/n;", "Landroid/view/animation/PathInterpolator;", "btnMissPathInterpolator", "Landroid/view/animation/PathInterpolator;", "lineShowPathInterpolator", "lineMissPathInterceptor", "btnShowPathInterpolator", "isAnimating", "Z", "isIdle", "startRecordAnim", "Landroid/animation/Animator;", "endRecordAnim", "useWhichNightMode", "I", "Landroid/view/View$OnClickListener;", "clickListener", "Landroid/view/View$OnClickListener;", "darkTextColor", "lightTextColor", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c extends FrameLayout {
    private static final String TAG = "RecordLayout";
    private final PathInterpolator btnMissPathInterpolator;
    private final PathInterpolator btnShowPathInterpolator;
    private View.OnClickListener clickListener;
    private final int darkTextColor;
    private Animator endRecordAnim;
    private boolean isAnimating;
    private boolean isIdle;
    private final int lightTextColor;
    private final PathInterpolator lineMissPathInterceptor;
    private final PathInterpolator lineShowPathInterpolator;
    private Animator startRecordAnim;
    private int useWhichNightMode;
    private final n viewBinding;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/voice/support/widget/c$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "LY8/t;", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.this.viewBinding.button.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/voice/support/widget/c$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "LY8/t;", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.support.widget.c$c, reason: collision with other inner class name */
    public static final class C0302c implements Animator.AnimatorListener {
        public C0302c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.viewBinding.button.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/voice/support/widget/c$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "LY8/t;", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Animator.AnimatorListener {
        public d(c cVar) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d(c.TAG, "start recording anim ends");
            c.this.isAnimating = false;
            c.this.isIdle = false;
            View.OnClickListener onClickListener = c.this.clickListener;
            if (onClickListener != null) {
                onClickListener.onClick(c.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d(c.TAG, "start recording anim begins");
            c.this.isAnimating = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/voice/support/widget/c$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "LY8/t;", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements Animator.AnimatorListener {
        public e(c cVar) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d(c.TAG, "stop recording anim ends");
            c.this.isAnimating = false;
            c.this.isIdle = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d(c.TAG, "stop recording anim begins");
            c.this.isAnimating = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        n nVarB = n.b(LayoutInflater.from(context), this, true);
        p.h(nVarB, "inflate(...)");
        this.viewBinding = nVarB;
        this.btnMissPathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.83f, 0.83f);
        this.lineShowPathInterpolator = new PathInterpolator(0.17f, 0.17f, 0.14f, 1.0f);
        this.lineMissPathInterceptor = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        this.btnShowPathInterpolator = new PathInterpolator(0.21f, 1.2f, 0.3f, 1.0f);
        this.useWhichNightMode = -1;
        this.darkTextColor = Color.parseColor("#EEEEEE");
        this.lightTextColor = Color.parseColor("#000000");
    }

    public static final void o(c cVar, View view) {
        View.OnClickListener onClickListener;
        Log.d(TAG, "wave area click: isAnimating=" + cVar.isAnimating + ", isIdle=" + cVar.isIdle);
        if (cVar.isAnimating || cVar.isIdle || (onClickListener = cVar.clickListener) == null) {
            return;
        }
        onClickListener.onClick(cVar);
    }

    public static final void p(c cVar, View view) {
        if (!cVar.isAnimating && cVar.isIdle) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(C1173v.p(cVar.l(), cVar.g(), cVar.j(), cVar.viewBinding.wave.i(300)));
            animatorSet.addListener(cVar.new d(cVar));
            cVar.startRecordAnim = animatorSet;
            animatorSet.start();
        }
    }

    public final Animator g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.viewBinding.button, "ScaleX", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.setInterpolator(this.btnMissPathInterpolator);
        t tVar = t.f7040a;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.viewBinding.button, "ScaleY", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(150L);
        objectAnimatorOfFloat2.setInterpolator(this.btnMissPathInterpolator);
        List listP = C1173v.p(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(listP);
        animatorSet.addListener(new b());
        return animatorSet;
    }

    public final Animator h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.viewBinding.button, "ScaleX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setStartDelay(380L);
        objectAnimatorOfFloat.setInterpolator(this.btnShowPathInterpolator);
        t tVar = t.f7040a;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.viewBinding.button, "ScaleY", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(500L);
        objectAnimatorOfFloat2.setStartDelay(380L);
        objectAnimatorOfFloat2.setInterpolator(this.btnShowPathInterpolator);
        List listP = C1173v.p(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(listP);
        animatorSet.addListener(new C0302c());
        return animatorSet;
    }

    public final Animator i() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.viewBinding.wave, "ScaleX", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.setStartDelay(200L);
        objectAnimatorOfFloat.setInterpolator(this.lineMissPathInterceptor);
        p.h(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }

    public final Animator j() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.viewBinding.wave, "ScaleX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(267L);
        objectAnimatorOfFloat.setStartDelay(133L);
        objectAnimatorOfFloat.setInterpolator(this.lineShowPathInterpolator);
        p.h(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }

    public final Animator k() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.viewBinding.textPlease, "Alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.setStartDelay(200L);
        t tVar = t.f7040a;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.viewBinding.textAgain, "Alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        objectAnimatorOfFloat2.setStartDelay(350L);
        List listP = C1173v.p(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(listP);
        return animatorSet;
    }

    public final Animator l() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.viewBinding.textAgain, "Alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.setStartDelay(0L);
        t tVar = t.f7040a;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.viewBinding.textPlease, "Alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        objectAnimatorOfFloat2.setStartDelay(200L);
        List listP = C1173v.p(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(listP);
        return animatorSet;
    }

    public final void m() {
        ImageButton imageButton = this.viewBinding.button;
        imageButton.setScaleX(0.0f);
        imageButton.setScaleY(0.0f);
        imageButton.setVisibility(8);
    }

    public final boolean n(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.viewBinding.wave.m();
        m();
        this.viewBinding.waveClickArea.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.o(this.f26573a, view);
            }
        });
        this.viewBinding.button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.p(this.f26574a, view);
            }
        });
        t(this.useWhichNightMode);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.useWhichNightMode != -1) {
            return;
        }
        Log.d(TAG, "RecordLayout onConfigurationChanged");
        s(n(newConfig));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Animator animator;
        Animator animator2;
        super.onDetachedFromWindow();
        Animator animator3 = this.startRecordAnim;
        if (animator3 != null && animator3.isRunning() && (animator2 = this.startRecordAnim) != null) {
            animator2.cancel();
        }
        Animator animator4 = this.endRecordAnim;
        if (animator4 != null && animator4.isRunning() && (animator = this.endRecordAnim) != null) {
            animator.cancel();
        }
        this.viewBinding.wave.q();
    }

    public final void q(int volume) {
        this.viewBinding.wave.k(volume);
    }

    public final void r() {
        if (this.isIdle || this.isAnimating) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(C1173v.p(k(), this.viewBinding.wave.g(), i(), h()));
        animatorSet.addListener(new e(this));
        this.endRecordAnim = animatorSet;
        animatorSet.start();
    }

    public final void s(boolean useNightMode) {
        int i10 = useNightMode ? this.darkTextColor : this.lightTextColor;
        Log.d(TAG, "expectedColor is " + i10);
        this.viewBinding.textAgain.setTextColor(i10);
        this.viewBinding.textPlease.setTextColor(i10);
    }

    public final void setTextPlease(String tip) {
        p.i(tip, "tip");
        this.viewBinding.textPlease.setText(tip);
    }

    public final void t(int value) {
        this.useWhichNightMode = value;
        if (value == -1) {
            return;
        }
        s(value == 1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        this(context, null, 0);
        p.i(context, "context");
    }
}
