package androidx.core.animation;

import android.animation.Animator;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aT\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a-\u0010\u0013\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a-\u0010\u0015\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", WidgetCostModule.TYPE_ON_START, "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimatorKt {
    public static final Animator.AnimatorListener doOnCancel(Animator r100, final Function1<? super Animator, Unit> r101) {
        Animator.AnimatorListener r102 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator r100, final Function1<? super Animator, Unit> r101) {
        Animator.AnimatorListener r102 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator r100, Function1<? super Animator, Unit> r101) {
        return addPauseListener$default(r100, null, r101, 1, null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator r100, final Function1<? super Animator, Unit> r101) {
        Animator.AnimatorListener r102 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator r100, Function1<? super Animator, Unit> r101) {
        return addPauseListener$default(r100, r101, null, 2, null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator r100, final Function1<? super Animator, Unit> r101) {
        Animator.AnimatorListener r102 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator r100, final Function1<? super Animator, Unit> r101, final Function1<? super Animator, Unit> r102) {
        Animator.AnimatorPauseListener r103 = new AnimatorKt$addPauseListener$listener$1(r102, r101);
        r100.addPauseListener(r103);
        return r103;
    }

    public static final Animator.AnimatorListener addListener(Animator r100, Function1<? super Animator, Unit> r101, Function1<? super Animator, Unit> r102, Function1<? super Animator, Unit> r103, Function1<? super Animator, Unit> r104) {
        AnimatorKt$addListener$listener$1 r105 = new AnimatorKt$addListener$listener$1(r104, r101, r103, r102);
        r100.addListener(r105);
        return r105;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator r100, Function1 r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = C87741.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = C87752.INSTANCE;
    L9:
        return addPauseListener(r100, r101, r102);
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator r100, Function1 r101, Function1 r102, Function1 r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = AnonymousClass1.INSTANCE;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = AnonymousClass2.INSTANCE;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = AnonymousClass3.INSTANCE;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = AnonymousClass4.INSTANCE;
    L14:
        AnimatorKt$addListener$listener$1 r107 = new AnimatorKt$addListener$listener$1(r104, r101, r103, r102);
        r100.addListener(r107);
        return r107;
    }
}
