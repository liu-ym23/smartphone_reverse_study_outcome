package androidx.core.animation;

import android.animation.Animator;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¤\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001aV\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a5\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001a/\u0010\u0013\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a5\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001a/\u0010\u0015\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a5\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimatorKt {
    public static final Animator.AnimatorPauseListener doOnResume(Animator r2, Function1<? super Animator, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        return addPauseListener$default(r2, r3, null, 2, null);
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator r2, Function1<? super Animator, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        return addPauseListener$default(r2, null, r3, 1, null);
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator r0, AnonymousClass1 r1, AnonymousClass2 r2, AnonymousClass3 r3, AnonymousClass4 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = AnonymousClass1.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = AnonymousClass2.INSTANCE;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = AnonymousClass3.INSTANCE;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = AnonymousClass4.INSTANCE;
    L14:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "onEnd");
        Intrinsics.checkNotNullParameter(r2, "onStart");
        Intrinsics.checkNotNullParameter(r3, "onCancel");
        Intrinsics.checkNotNullParameter(r4, "onRepeat");
        AnimatorKt$addListener$listener$1 r7 = new AnimatorKt$addListener$listener$1(r4, r1, r3, r2);
        r0.addListener(r7);
        return r7;
    }

    public static final Animator.AnimatorListener addListener(Animator r1, Function1<? super Animator, Unit> r2, Function1<? super Animator, Unit> r3, Function1<? super Animator, Unit> r4, Function1<? super Animator, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "onEnd");
        Intrinsics.checkNotNullParameter(r3, "onStart");
        Intrinsics.checkNotNullParameter(r4, "onCancel");
        Intrinsics.checkNotNullParameter(r5, "onRepeat");
        AnimatorKt$addListener$listener$1 r0 = new AnimatorKt$addListener$listener$1(r5, r2, r4, r3);
        r1.addListener(r0);
        return r0;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator r0, C01111 r1, C01122 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = C01111.INSTANCE;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = C01122.INSTANCE;
    L9:
        return addPauseListener(r0, r1, r2);
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator r1, final Function1<? super Animator, Unit> r2, final Function1<? super Animator, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "onResume");
        Intrinsics.checkNotNullParameter(r3, "onPause");
        Animator.AnimatorPauseListener r0 = new AnimatorKt$addPauseListener$listener$1(r3, r2);
        Api19Impl.addPauseListener(r1, r0);
        return r0;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator r1, final Function1<? super Animator, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Animator.AnimatorListener r0 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Animator.AnimatorListener doOnStart(Animator r1, final Function1<? super Animator, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Animator.AnimatorListener r0 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator r1, final Function1<? super Animator, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Animator.AnimatorListener r0 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator r1, final Function1<? super Animator, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Animator.AnimatorListener r0 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(r2);
        r1.addListener(r0);
        return r0;
    }
}
