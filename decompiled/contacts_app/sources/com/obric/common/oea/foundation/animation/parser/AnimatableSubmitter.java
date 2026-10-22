package com.obric.common.oea.foundation.animation.parser;

import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.AnimationLifecycleListener;
import com.obric.common.oea.foundation.animation.command.AnimationCommand;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatableSubmitter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u008c\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00112\"\b\u0002\u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0003J\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\u008c\u0001\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u00112\"\b\u0002\u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/common/oea/foundation/animation/parser/AnimatableSubmitter;", "", "()V", "TAG", "", "animate", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "targetFps", "", "view", "Landroid/view/View;", "mode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "speed", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "animationInfos", "", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "onUpdateCallback", "Lkotlin/Function3;", "", "onEndCallback", "Lkotlin/Function2;", "", "", "convertToAnimatedPropertyInfo", "command", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "parseAndExecute", "animationCommands", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimatableSubmitter {
    public static final AnimatableSubmitter INSTANCE = null;
    private static final String TAG = "AnimatableSubmitter";

    static {
        INSTANCE = new AnimatableSubmitter();
    }

    private AnimatableSubmitter() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimationManager parseAndExecute$default(AnimatableSubmitter r11, float r12, View r13, RunMode r14, float r15, RepeatMode r16, List r17, Function3 r18, Function2 r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        float r6 = 1.0f;
    L7:
        if ((r20 & 16) == 0) goto L9;
        RepeatMode r7 = RepeatMode.NORMAL;
    L11:
        if ((r20 & 64) == 0) goto L13;
        Function3 r1 = (Function3) null;
        Function3 r9 = null;
    L15:
        if ((r20 & 128) == 0) goto L17;
        Function2 r0 = (Function2) null;
        Function2 r10 = null;
    L19:
        return r11.parseAndExecute(r12, r13, r14, r6, r7, r17, r9, r10);
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public final AnimationManager parseAndExecute(float r12, View r13, RunMode r14, float r15, RepeatMode r16, List<? extends AnimationCommand<?>> r17, Function3<? super String, Object, ? super Float, Unit> r18, Function2<? super Boolean, ? super Throwable, Unit> r19) {
        Intrinsics.checkNotNullParameter(r14, "mode");
        Intrinsics.checkNotNullParameter(r16, "repeatMode");
        Intrinsics.checkNotNullParameter(r17, "animationCommands");
        ArrayList r8 = new ArrayList();
        Iterator<T> r0 = r17.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        AnimationCommand<?> r1 = (AnimationCommand) r0.next();
        r8.add(INSTANCE.convertToAnimatedPropertyInfo(r1));
        goto L4
    L7:
        return animate(r12, r13, r14, r15, r16, r8, r18, r19);
    }

    private final AnimationInfo<?> convertToAnimatedPropertyInfo(AnimationCommand<?> r1) {
        return r1.convertToAnimatedPropertyInfo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ AnimationManager animate$default(AnimatableSubmitter r11, float r12, View r13, RunMode r14, float r15, RepeatMode r16, List r17, Function3 r18, Function2 r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        float r6 = 1.0f;
    L7:
        if ((r20 & 16) == 0) goto L9;
        RepeatMode r7 = RepeatMode.NORMAL;
    L11:
        if ((r20 & 64) == 0) goto L13;
        Function3 r1 = (Function3) null;
        Function3 r9 = null;
    L15:
        if ((r20 & 128) == 0) goto L17;
        Function2 r0 = (Function2) null;
        Function2 r10 = null;
    L19:
        return r11.animate(r12, r13, r14, r6, r7, r17, r9, r10);
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    private final AnimationManager animate(float r11, View r12, RunMode r13, float r14, RepeatMode r15, List<? extends AnimationInfo<?>> r16, Function3<? super String, Object, ? super Float, Unit> r17, final Function2<? super Boolean, ? super Throwable, Unit> r18) {
        if (r12 == null) goto L16;
        AnimationInfo<?> r0 = AnimationLifecycleListener.INSTANCE.getAnimationInfo(r12);
        if (r0 == null) goto L7;
        float r1 = r0.getCurrentVelocity();
    L8:
        Iterator<T> r2 = r16.iterator();
    L10:
        if (r2.hasNext() == false) goto L16;
        AnimationInfo<?> r3 = (AnimationInfo) r2.next();
        if (r3.getInitialVelocity() != null) goto L14;
        OEALogger.INSTANCE.d(TAG, "没指定初始速度，重设velocity " + r1);
        r3.setInitialVelocity(Float.valueOf(r1));
    L15:
        AnimationLifecycleListener.INSTANCE.addAnimationInfo(r12, r3);
        goto L10
    L14:
        OEALogger.INSTANCE.d(TAG, "指定了初始速度，" + r3.getInitialVelocity());
        goto L15
    L7:
        r1 = 0.0f;
    L16:
        final AnimationManager r9 = new AnimationManager();
        AnimationLifecycleListener.INSTANCE.addAnimationManager(r9);
        r9.runAnimation(r11, r12, r13, r14, r15, r16, r17, new AnonymousClass2(r18, r9));
        return r9;
    }
}
