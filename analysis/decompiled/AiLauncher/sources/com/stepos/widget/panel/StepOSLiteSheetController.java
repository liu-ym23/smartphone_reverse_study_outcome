package com.stepos.widget.panel;

import Y8.t;
import android.animation.ValueAnimator;
import androidx.dynamicanimation.animation.e;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0003J%\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0003J\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0003J\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0003R0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R0\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R*\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u0010\u000bR$\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R$\u0010\f\u001a\u00020\t2\u0006\u00109\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u00105\u001a\u0004\b>\u00107R$\u0010?\u001a\u00020\t2\u0006\u00109\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u00107R$\u0010A\u001a\u00020\t2\u0006\u00109\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bA\u00105\u001a\u0004\bB\u00107R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00105R\u0014\u00109\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0011\u0010J\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bI\u0010=R\u0011\u0010L\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bK\u0010=R\u0011\u0010N\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bM\u0010=¨\u0006O"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetController;", "", "<init>", "()V", "", "next", "LY8/t;", "publish", "(F)V", "", "setMotion", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "restore", "", "animate", "settle", "(IZ)V", "beginDrag", "deltaY", "Lcom/stepos/widget/panel/StepOSLiteSheetGeometry;", "geometry", "canDismiss", ChatTracker.TRIGGER_DRAG, "(FLcom/stepos/widget/panel/StepOSLiteSheetGeometry;Z)F", "velocityY", "minFling", "release", "(FFZ)V", "cancelGesture", "enter", "dispose", "Lkotlin/Function1;", "onPosition", "Lp9/l;", "getOnPosition", "()Lp9/l;", "setOnPosition", "(Lp9/l;)V", "onSettled", "getOnSettled", "setOnSettled", "onMotion", "getOnMotion", "setOnMotion", "Lkotlin/Function0;", "onDismissRequested", "Lp9/a;", "getOnDismissRequested", "()Lp9/a;", "setOnDismissRequested", "(Lp9/a;)V", "mode", "I", "getMode", "()I", "setMode", UxipConstants.f30680s, "position", "F", "getPosition", "()F", "getState", "target", "getTarget", "motion", "getMotion", "origin", "Landroidx/dynamicanimation/animation/g;", "Landroidx/dynamicanimation/animation/g;", "Landroidx/dynamicanimation/animation/i;", "spring", "Landroidx/dynamicanimation/animation/i;", "getMinPosition", "minPosition", "getVisualPosition", "visualPosition", "getDismissProgress", "dismissProgress", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetController {
    private int mode;
    private int motion;
    private InterfaceC5063a<t> onDismissRequested;
    private InterfaceC5074l<? super Integer, t> onMotion;
    private InterfaceC5074l<? super Float, t> onPosition;
    private InterfaceC5074l<? super Integer, t> onSettled;
    private final androidx.dynamicanimation.animation.i spring;
    private final androidx.dynamicanimation.animation.g value;
    private float position = 1.0f;
    private int state = 1;
    private int target = 1;
    private int origin = 1;

    public StepOSLiteSheetController() {
        androidx.dynamicanimation.animation.g gVar = new androidx.dynamicanimation.animation.g(1.0f);
        this.value = gVar;
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(gVar);
        iVar.B(new androidx.dynamicanimation.animation.j().f(1.0f).h(1500.0f));
        iVar.o(0.001f);
        iVar.c(new e.r() { // from class: com.stepos.widget.panel.m
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                StepOSLiteSheetController.spring$lambda$2$lambda$0(this.f31294a, eVar, f10, f11);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.widget.panel.n
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                StepOSLiteSheetController.spring$lambda$2$lambda$1(this.f31295a, eVar, z10, f10, f11);
            }
        });
        this.spring = iVar;
    }

    private final void publish(float next) {
        this.position = next;
        this.value.b(next);
        InterfaceC5074l<? super Float, t> interfaceC5074l = this.onPosition;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(next));
        }
    }

    private final void setMotion(int next) {
        if (this.motion == next) {
            return;
        }
        this.motion = next;
        InterfaceC5074l<? super Integer, t> interfaceC5074l = this.onMotion;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Integer.valueOf(next));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void spring$lambda$2$lambda$0(StepOSLiteSheetController stepOSLiteSheetController, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        stepOSLiteSheetController.publish(C5685n.m(f10, 0.0f, 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void spring$lambda$2$lambda$1(StepOSLiteSheetController stepOSLiteSheetController, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10) {
            return;
        }
        stepOSLiteSheetController.publish(stepOSLiteSheetController.target);
        stepOSLiteSheetController.state = stepOSLiteSheetController.target;
        stepOSLiteSheetController.setMotion(0);
        InterfaceC5074l<? super Integer, t> interfaceC5074l = stepOSLiteSheetController.onSettled;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Integer.valueOf(stepOSLiteSheetController.state));
        }
    }

    public final void beginDrag() {
        if (this.motion == 1) {
            return;
        }
        this.spring.d();
        int i10 = this.mode;
        this.origin = i10 != 0 ? StepOSLiteSheetStatePolicy.INSTANCE.defaultState(i10) : this.position < 0.5f ? 0 : 1;
        setMotion(1);
    }

    public final void cancelGesture() {
        settle(this.state, true);
    }

    public final void dispose() {
        this.spring.d();
        this.onPosition = null;
        this.onSettled = null;
        this.onMotion = null;
        this.onDismissRequested = null;
    }

    public final float drag(float deltaY, StepOSLiteSheetGeometry geometry, boolean canDismiss) {
        kotlin.jvm.internal.p.i(geometry, "geometry");
        beginDrag();
        float pVar = geometry.top(this.position);
        publish(C5685n.m(geometry.position(deltaY + pVar), getMinPosition(), StepOSLiteSheetStatePolicy.INSTANCE.dragLimit(this.origin, canDismiss, this.mode)));
        return geometry.top(this.position) - pVar;
    }

    public final void enter() {
        int i10 = this.target;
        publish(2.0f);
        settle(i10, true);
    }

    public final float getDismissProgress() {
        return this.mode == 2 ? C5685n.m(this.position / 2.0f, 0.0f, 1.0f) : C5685n.m(this.position - 1.0f, 0.0f, 1.0f);
    }

    public final float getMinPosition() {
        return StepOSLiteSheetStatePolicy.INSTANCE.minPosition(this.mode);
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getMotion() {
        return this.motion;
    }

    public final InterfaceC5063a<t> getOnDismissRequested() {
        return this.onDismissRequested;
    }

    public final InterfaceC5074l<Integer, t> getOnMotion() {
        return this.onMotion;
    }

    public final InterfaceC5074l<Float, t> getOnPosition() {
        return this.onPosition;
    }

    public final InterfaceC5074l<Integer, t> getOnSettled() {
        return this.onSettled;
    }

    public final float getPosition() {
        return this.position;
    }

    public final int getState() {
        return this.state;
    }

    public final int getTarget() {
        return this.target;
    }

    public final float getVisualPosition() {
        if (this.mode == 2) {
            return 0.0f;
        }
        return this.position;
    }

    public final void release(float velocityY, float minFling, boolean canDismiss) {
        InterfaceC5063a<t> interfaceC5063a;
        if (this.motion != 1) {
            return;
        }
        int iReleasedState = StepOSLiteSheetStatePolicy.INSTANCE.releasedState(this.origin, this.position, velocityY, minFling, canDismiss, this.mode);
        if (iReleasedState != 2 || (interfaceC5063a = this.onDismissRequested) == null) {
            settle(iReleasedState, true);
        } else if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void restore(int state) {
        this.spring.d();
        this.state = state;
        this.target = state;
        publish(state);
        setMotion(0);
    }

    public final void setMode(int i10) {
        this.mode = i10;
    }

    public final void setOnDismissRequested(InterfaceC5063a<t> interfaceC5063a) {
        this.onDismissRequested = interfaceC5063a;
    }

    public final void setOnMotion(InterfaceC5074l<? super Integer, t> interfaceC5074l) {
        this.onMotion = interfaceC5074l;
    }

    public final void setOnPosition(InterfaceC5074l<? super Float, t> interfaceC5074l) {
        this.onPosition = interfaceC5074l;
    }

    public final void setOnSettled(InterfaceC5074l<? super Integer, t> interfaceC5074l) {
        this.onSettled = interfaceC5074l;
    }

    public final void settle(int state, boolean animate) {
        this.spring.d();
        this.target = state;
        if (animate && ValueAnimator.areAnimatorsEnabled()) {
            float f10 = state;
            if (Math.abs(this.position - f10) >= 0.001f) {
                this.value.b(this.position);
                setMotion(2);
                this.spring.w(f10);
                return;
            }
        }
        restore(state);
        InterfaceC5074l<? super Integer, t> interfaceC5074l = this.onSettled;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Integer.valueOf(state));
        }
    }
}
