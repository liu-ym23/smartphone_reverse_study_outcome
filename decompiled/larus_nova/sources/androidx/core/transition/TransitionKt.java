package androidx.core.transition;

import android.transition.Transition;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", WidgetCostModule.TYPE_ON_START, "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionKt {
    public static final Transition.TransitionListener doOnCancel(Transition r100, final Function1<? super Transition, Unit> r101) {
        Transition.TransitionListener r102 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Transition.TransitionListener doOnEnd(Transition r100, final Function1<? super Transition, Unit> r101) {
        Transition.TransitionListener r102 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Transition.TransitionListener doOnPause(Transition r100, final Function1<? super Transition, Unit> r101) {
        Transition.TransitionListener r102 = new TransitionKt$doOnPause$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Transition.TransitionListener doOnResume(Transition r100, final Function1<? super Transition, Unit> r101) {
        Transition.TransitionListener r102 = new TransitionKt$doOnResume$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Transition.TransitionListener doOnStart(Transition r100, final Function1<? super Transition, Unit> r101) {
        Transition.TransitionListener r102 = new TransitionKt$doOnStart$$inlined$addListener$default$1(r101);
        r100.addListener(r102);
        return r102;
    }

    public static final Transition.TransitionListener addListener(Transition r100, Function1<? super Transition, Unit> r101, Function1<? super Transition, Unit> r102, Function1<? super Transition, Unit> r110, Function1<? super Transition, Unit> r111, Function1<? super Transition, Unit> r112) {
        TransitionKt$addListener$listener$1 r103 = new TransitionKt$addListener$listener$1(r101, r111, r112, r110, r102);
        r100.addListener(r103);
        return r103;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition r100, Function1 r101, Function1 r102, Function1 r103, Function1 r104, Function1 r105, int r106, Object r107) {
        if ((r106 & 1) == 0) goto L6;
        r101 = AnonymousClass1.INSTANCE;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = AnonymousClass2.INSTANCE;
    L8:
        Function1 r108 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = AnonymousClass3.INSTANCE;
    L11:
        Function1 r109 = r103;
        if ((r106 & 8) == 0) goto L15;
        r104 = AnonymousClass4.INSTANCE;
    L15:
        if ((r106 & 16) == 0) goto L17;
        r105 = AnonymousClass5.INSTANCE;
    L17:
        TransitionKt$addListener$listener$1 r110 = new TransitionKt$addListener$listener$1(r101, r104, r105, r109, r108);
        r100.addListener(r110);
        return r110;
    }
}
