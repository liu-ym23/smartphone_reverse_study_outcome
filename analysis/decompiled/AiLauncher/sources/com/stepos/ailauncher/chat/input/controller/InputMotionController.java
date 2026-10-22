package com.stepos.ailauncher.chat.input.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.view.InputMotionLayout;
import com.stepos.ailauncher.chat.view.input.InputBarMotionSpec;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import h9.InterfaceC4149a;
import io.ktor.sse.ServerSentEventKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import q5.C5155a;
import v9.C5685n;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 =2\u00020\u0001:\u0002>?B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0012J\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0012J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020$2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020$2\u0006\u0010+\u001a\u00020'H\u0002¢\u0006\u0004\b,\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0011\u0010:\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u00109¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/InputMotionController;", "", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "motionLayout", "<init>", "(Landroidx/constraintlayout/motion/widget/MotionLayout;)V", "Lkotlin/Function0;", "LY8/t;", "action", "s", "(Lp9/a;)V", "Lcom/stepos/ailauncher/chat/input/controller/InputMotionController$State;", "target", "", "animated", "u", "(Lcom/stepos/ailauncher/chat/input/controller/InputMotionController$State;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "", "fraction", "hasText", "t", "(FZ)V", "r", "(Lcom/stepos/ailauncher/chat/input/controller/InputMotionController$State;)V", "snapped", "y", "(Z)V", "p", "k", "f", "(F)V", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "q", "(Ljava/lang/String;)V", "", "id", "x", "(I)Ljava/lang/String;", "depth", "v", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroid/animation/TimeInterpolator;", "formInterpolator", "Landroid/animation/TimeInterpolator;", "Landroid/animation/ValueAnimator;", "manualProgressAnimator", "Landroid/animation/ValueAnimator;", "currentState", "Lcom/stepos/ailauncher/chat/input/controller/InputMotionController$State;", "n", "()Lcom/stepos/ailauncher/chat/input/controller/InputMotionController$State;", "m", "()F", "currentProgress", "o", "drivenProgress", "Companion", Const.INTENT_KEY_APIKEY, "State", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InputMotionController {
    private static final String TAG = "InputMotion";
    private State currentState;
    private final TimeInterpolator formInterpolator;
    private ValueAnimator manualProgressAnimator;
    private final MotionLayout motionLayout;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/InputMotionController$State;", "", "id", "", "progress", "", "<init>", "(Ljava/lang/String;IIF)V", "getId$chat_release", "()I", "getProgress$chat_release", "()F", "COMPACT_SINGLE_ROW", "EXPANDED_MULTI_ROW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State COMPACT_SINGLE_ROW = new State("COMPACT_SINGLE_ROW", 0, R$id.state_compact_single_row, 0.0f);
        public static final State EXPANDED_MULTI_ROW = new State("EXPANDED_MULTI_ROW", 1, R$id.state_expanded_multi_row, 1.0f);
        private final int id;
        private final float progress;

        private static final /* synthetic */ State[] $values() {
            return new State[]{COMPACT_SINGLE_ROW, EXPANDED_MULTI_ROW};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10, int i11, float f10) {
            this.id = i11;
            this.progress = f10;
        }

        public static InterfaceC4149a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        /* renamed from: getId$chat_release, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: getProgress$chat_release, reason: from getter */
        public final float getProgress() {
            return this.progress;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputBarMotionSpec.FormTransitionDriver.values().length];
            try {
                iArr[InputBarMotionSpec.FormTransitionDriver.MANUAL_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputBarMotionSpec.FormTransitionDriver.SNAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputBarMotionSpec.FormTransitionDriver.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/input/controller/InputMotionController$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (InputMotionController.this.manualProgressAnimator == animation) {
                InputMotionController.this.manualProgressAnimator = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (InputMotionController.this.manualProgressAnimator == animation) {
                InputMotionController.this.manualProgressAnimator = null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/input/controller/InputMotionController$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationCancel", "(Landroid/animation/Animator;)V", "onAnimationEnd", "", "canceled", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ InterfaceC5063a<Y8.t> $action;
        private boolean canceled;

        public d(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$action = interfaceC5063a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            this.canceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (this.canceled) {
                return;
            }
            this.$action.invoke();
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"com/stepos/ailauncher/chat/input/controller/InputMotionController$e", "Landroidx/constraintlayout/motion/widget/MotionLayout$j;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "l", "", "startId", "endId", "LY8/t;", "c", "(Landroidx/constraintlayout/motion/widget/MotionLayout;II)V", "", "p", Const.INTENT_KEY_APIKEY, "(Landroidx/constraintlayout/motion/widget/MotionLayout;IIF)V", "triggerId", "", "positive", "progress", Const.INTENT_KEY_UMID, "(Landroidx/constraintlayout/motion/widget/MotionLayout;IZF)V", "currentId", Const.INTENT_KEY_PKGNAME, "(Landroidx/constraintlayout/motion/widget/MotionLayout;I)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements MotionLayout.j {
        final /* synthetic */ InterfaceC5063a<Y8.t> $action;

        public e(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$action = interfaceC5063a;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
        public void a(MotionLayout l10, int startId, int endId, float p10) {
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
        public void b(MotionLayout l10, int currentId) {
            if (l10 != null) {
                l10.setTransitionListener(null);
            }
            this.$action.invoke();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
        public void c(MotionLayout l10, int startId, int endId) {
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
        public void d(MotionLayout l10, int triggerId, boolean positive, float progress) {
        }
    }

    public InputMotionController(MotionLayout motionLayout) {
        kotlin.jvm.internal.p.i(motionLayout, "motionLayout");
        this.motionLayout = motionLayout;
        this.formInterpolator = new TimeInterpolator() { // from class: com.stepos.ailauncher.chat.input.controller.C
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f10) {
                return InputMotionController.l(f10);
            }
        };
        this.currentState = State.COMPACT_SINGLE_ROW;
    }

    public static final void g(InputMotionController inputMotionController, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        inputMotionController.j(((Float) animatedValue).floatValue());
    }

    public static final float l(float f10) {
        return InputBarMotionSpec.INSTANCE.b(f10);
    }

    public static final CharSequence w(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName == null) {
            fileName = "?";
        }
        return fileName + ServerSentEventKt.COLON + stackTraceElement.getLineNumber() + Const.STR_MART_WELL + stackTraceElement.getMethodName();
    }

    public final void f(float target) {
        h();
        float fO = o();
        j(fO);
        if (fO == target) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fO, target);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(this.formInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.input.controller.E
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                InputMotionController.g(this.f25378a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new c());
        this.manualProgressAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
    }

    public final void h() {
        ValueAnimator valueAnimator = this.manualProgressAnimator;
        if (valueAnimator == null) {
            return;
        }
        this.manualProgressAnimator = null;
        valueAnimator.cancel();
    }

    public final void i() {
        h();
    }

    public final void j(float value) {
        k();
        MotionLayout motionLayout = this.motionLayout;
        InputMotionLayout inputMotionLayout = motionLayout instanceof InputMotionLayout ? (InputMotionLayout) motionLayout : null;
        if (inputMotionLayout != null) {
            inputMotionLayout.setDrivenProgress(value);
        }
        this.motionLayout.setProgress(value);
        this.motionLayout.requestLayout();
    }

    public final void k() {
        int id = State.COMPACT_SINGLE_ROW.getId();
        int id2 = State.EXPANDED_MULTI_ROW.getId();
        if (this.motionLayout.getStartState() == id && this.motionLayout.getEndState() == id2) {
            return;
        }
        this.motionLayout.Y(id, id2);
        this.motionLayout.setProgress(o());
        this.motionLayout.requestLayout();
    }

    public final float m() {
        return o();
    }

    /* renamed from: n, reason: from getter */
    public final State getCurrentState() {
        return this.currentState;
    }

    public final float o() {
        MotionLayout motionLayout = this.motionLayout;
        InputMotionLayout inputMotionLayout = motionLayout instanceof InputMotionLayout ? (InputMotionLayout) motionLayout : null;
        return inputMotionLayout != null ? inputMotionLayout.getDrivenProgress() : motionLayout.getProgress();
    }

    public final void p(State target) {
        j(target.getProgress());
    }

    public final void q(String action) {
        C5155a c5155a = C5155a.INSTANCE;
        if (C5155a.enabled) {
            C4148a.k(C5155a.TAG, "[SET_STATE_DONE] action=" + action + " attached=" + this.motionLayout.isAttachedToWindow() + " mlCur=" + x(this.motionLayout.getCurrentState()) + " progress=" + this.motionLayout.getProgress(), false, 4, null);
        }
    }

    public final void r(State target) {
        kotlin.jvm.internal.p.i(target, "target");
        State state = this.currentState;
        if (C5155a.enabled) {
            C4148a.k(TAG, "prepareForImeDrive → target=" + target + " logical=" + state + " ml.cur=" + this.motionLayout.getCurrentState() + " ml.progress=" + this.motionLayout.getProgress() + " caller=" + v(6), false, 4, null);
            C5155a c5155a = C5155a.INSTANCE;
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[PREPARE_IME_DRIVE] target=" + target + " prevLogical=" + state + " prevProgress=" + this.motionLayout.getProgress() + " caller=" + v(4), false, 4, null);
            }
        }
        this.currentState = target;
        h();
        j(o());
    }

    public final void s(InterfaceC5063a<Y8.t> action) {
        kotlin.jvm.internal.p.i(action, "action");
        ValueAnimator valueAnimator = this.manualProgressAnimator;
        if (valueAnimator != null) {
            valueAnimator.addListener(new d(action));
            return;
        }
        if (InputBarMotionSpec.INSTANCE.f(this.currentState == State.EXPANDED_MULTI_ROW, o())) {
            action.invoke();
        } else {
            this.motionLayout.setTransitionListener(new e(action));
        }
    }

    public final void t(float fraction, boolean hasText) {
        h();
        float fM = C5685n.m(fraction, 0.0f, 1.0f);
        C5155a c5155a = C5155a.INSTANCE;
        if (C5155a.enabled) {
            C4148a.k(C5155a.TAG, "[SET_PROGRESS] fraction=" + fraction + " clamped=" + fM + " prev=" + this.motionLayout.getProgress() + " logicalBefore=" + this.currentState + " caller=" + v(4), false, 4, null);
        }
        j(fM);
        y(fM <= 0.0f);
        if (fM <= 0.0f) {
            this.currentState = !hasText ? State.COMPACT_SINGLE_ROW : State.EXPANDED_MULTI_ROW;
        } else if (fM >= 1.0f) {
            this.currentState = State.EXPANDED_MULTI_ROW;
        }
    }

    public final void u(State target, boolean animated) {
        kotlin.jvm.internal.p.i(target, "target");
        k();
        boolean z10 = this.currentState == target;
        InputBarMotionSpec.FormTransitionDriver formTransitionDriverG = InputBarMotionSpec.INSTANCE.g(z10, animated);
        String str = (!z10 || animated) ? (z10 && animated) ? "same-noop" : formTransitionDriverG == InputBarMotionSpec.FormTransitionDriver.MANUAL_PROGRESS ? "manual-progress" : "jump" : "same-jump";
        if (C5155a.enabled) {
            C4148a.k(TAG, "setState → target=" + target + " animated=" + animated + " action=" + str + " logical=" + this.currentState + " ml.cur=" + this.motionLayout.getCurrentState() + " ml.progress=" + this.motionLayout.getProgress() + " caller=" + v(6), false, 4, null);
            C5155a c5155a = C5155a.INSTANCE;
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[SET_STATE] target=" + target + " animated=" + animated + " action=" + str + " prevProgress=" + this.motionLayout.getProgress() + " attached=" + this.motionLayout.isAttachedToWindow() + " mlCur=" + x(this.motionLayout.getCurrentState()) + " caller=" + v(4), false, 4, null);
            }
        }
        if (z10) {
            if (formTransitionDriverG == InputBarMotionSpec.FormTransitionDriver.SNAP) {
                h();
                y(target == State.COMPACT_SINGLE_ROW);
                p(target);
            }
            q(str);
            return;
        }
        this.currentState = target;
        int i10 = b.$EnumSwitchMapping$0[formTransitionDriverG.ordinal()];
        if (i10 == 1) {
            y(false);
            f(target.getProgress());
        } else if (i10 == 2) {
            h();
            y(target == State.COMPACT_SINGLE_ROW);
            p(target);
        } else if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        q(str);
    }

    public final String v(int depth) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        kotlin.jvm.internal.p.f(stackTrace);
        return SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.Z(SequencesKt___SequencesKt.E(Z8.r.M(stackTrace), 2), depth), " ← ", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.input.controller.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InputMotionController.w((StackTraceElement) obj);
            }
        }, 30, null);
    }

    public final String x(int id) {
        Object objB;
        if (id == -1) {
            return "UNSET";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.motionLayout.getResources().getResourceEntryName(id));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = "id=" + id;
        if (Result.g(objB)) {
            objB = str;
        }
        return (String) objB;
    }

    public final void y(boolean snapped) {
        MotionLayout motionLayout = this.motionLayout;
        InputMotionLayout inputMotionLayout = motionLayout instanceof InputMotionLayout ? (InputMotionLayout) motionLayout : null;
        if (inputMotionLayout != null) {
            inputMotionLayout.setSnappedToUnfocused(snapped);
        }
    }
}
