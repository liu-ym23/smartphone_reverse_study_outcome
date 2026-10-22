package com.stepos.ailauncher.homegesture;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant;
import com.stepos.ailauncher.sheet.b0;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001Bu\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012*\u0010\u000f\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010 R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 R8\u0010\u000f\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0004\u0012\u00020\u000e0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/homegesture/MinusOneGroupExitTransaction;", "", "", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", "participants", Parameters.ROOT, "Lkotlin/Function0;", "", "beginStack", "LY8/t;", "endStack", "Lkotlin/Function2;", "Lkotlin/Function1;", "", "Lcom/stepos/ailauncher/sheet/b0;", "animate", "onFinished", "<init>", "(Ljava/util/List;Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;Lp9/a;Lp9/a;Lp9/p;Lp9/a;)V", "p", "()Z", "k", "()V", "s", "progress", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(F)V", "action", "Lkotlin/Result;", "o", "(Lp9/a;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", "Lp9/a;", "Lp9/p;", "Ljava/util/List;", "", "prepared", "distancePx", "F", RobotInfo.STATUS_STARTED, "Z", "completed", "animationStarted", "animation", "Lcom/stepos/ailauncher/sheet/b0;", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MinusOneGroupExitTransaction {
    private final p9.p<InterfaceC5074l<? super Float, Y8.t>, InterfaceC5063a<Y8.t>, b0> animate;
    private b0 animation;
    private boolean animationStarted;
    private final InterfaceC5063a<Boolean> beginStack;
    private boolean completed;
    private float distancePx;
    private final InterfaceC5063a<Y8.t> endStack;
    private final InterfaceC5063a<Y8.t> onFinished;
    private final List<HomeSharedOffsetExitParticipant> participants;
    private final List<HomeSharedOffsetExitParticipant> prepared;
    private final HomeSharedOffsetExitParticipant root;
    private boolean started;

    /* JADX WARN: Multi-variable type inference failed */
    public MinusOneGroupExitTransaction(List<? extends HomeSharedOffsetExitParticipant> participants, HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant, InterfaceC5063a<Boolean> beginStack, InterfaceC5063a<Y8.t> endStack, p9.p<? super InterfaceC5074l<? super Float, Y8.t>, ? super InterfaceC5063a<Y8.t>, ? extends b0> animate, InterfaceC5063a<Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(participants, "participants");
        kotlin.jvm.internal.p.i(beginStack, "beginStack");
        kotlin.jvm.internal.p.i(endStack, "endStack");
        kotlin.jvm.internal.p.i(animate, "animate");
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        this.root = homeSharedOffsetExitParticipant;
        this.beginStack = beginStack;
        this.endStack = endStack;
        this.animate = animate;
        this.onFinished = onFinished;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : participants) {
            if (hashSet.add(((HomeSharedOffsetExitParticipant) obj).getParticipantId())) {
                arrayList.add(obj);
            }
        }
        this.participants = arrayList;
        this.prepared = new ArrayList();
    }

    public static final Y8.t l(MinusOneGroupExitTransaction minusOneGroupExitTransaction) {
        b0 b0Var = minusOneGroupExitTransaction.animation;
        if (b0Var != null) {
            b0Var.cancel();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t m(HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant, MinusOneGroupExitTransaction minusOneGroupExitTransaction) {
        homeSharedOffsetExitParticipant.applySharedOffsetExit(minusOneGroupExitTransaction.distancePx, 1.0f);
        return Y8.t.f7040a;
    }

    public static final Y8.t n(HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant) {
        homeSharedOffsetExitParticipant.finishHomeGroupExit();
        return Y8.t.f7040a;
    }

    public static final Y8.t q(HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant) {
        homeSharedOffsetExitParticipant.cancelHomeGroupExit();
        return Y8.t.f7040a;
    }

    public static final Y8.t r(MinusOneGroupExitTransaction minusOneGroupExitTransaction) {
        HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant = minusOneGroupExitTransaction.root;
        if (homeSharedOffsetExitParticipant == null) {
            minusOneGroupExitTransaction.s();
        } else {
            homeSharedOffsetExitParticipant.startSharedOffsetExit(new MinusOneGroupExitTransaction$start$3$1(minusOneGroupExitTransaction), new MinusOneGroupExitTransaction$start$3$2(minusOneGroupExitTransaction));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t t(final MinusOneGroupExitTransaction minusOneGroupExitTransaction) {
        b0 b0VarInvoke = minusOneGroupExitTransaction.animate.invoke(new InterfaceC5074l() { // from class: com.stepos.ailauncher.homegesture.Q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MinusOneGroupExitTransaction.u(this.f27438a, ((Float) obj).floatValue());
            }
        }, new MinusOneGroupExitTransaction$startAnimation$1$handle$2(minusOneGroupExitTransaction));
        if (minusOneGroupExitTransaction.completed) {
            b0VarInvoke.cancel();
        } else {
            minusOneGroupExitTransaction.animation = b0VarInvoke;
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t u(final MinusOneGroupExitTransaction minusOneGroupExitTransaction, final float f10) {
        if (!minusOneGroupExitTransaction.completed && Result.e(minusOneGroupExitTransaction.o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.S
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MinusOneGroupExitTransaction.v(this.f27439a, f10);
            }
        })) != null) {
            minusOneGroupExitTransaction.k();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t v(MinusOneGroupExitTransaction minusOneGroupExitTransaction, float f10) {
        minusOneGroupExitTransaction.j(C5685n.m(f10, 0.0f, 1.0f));
        return Y8.t.f7040a;
    }

    public final void j(float progress) {
        Iterator<T> it = this.prepared.iterator();
        while (it.hasNext()) {
            ((HomeSharedOffsetExitParticipant) it.next()).applySharedOffsetExit(this.distancePx * progress, progress);
        }
    }

    public final void k() {
        if (!this.started || this.completed) {
            return;
        }
        this.completed = true;
        o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.N
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MinusOneGroupExitTransaction.l(this.f27434a);
            }
        });
        this.animation = null;
        for (final HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant : this.prepared) {
            o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.O
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return MinusOneGroupExitTransaction.m(homeSharedOffsetExitParticipant, this);
                }
            });
        }
        try {
            for (final HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant2 : this.prepared) {
                o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.P
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return MinusOneGroupExitTransaction.n(homeSharedOffsetExitParticipant2);
                    }
                });
            }
            try {
                this.endStack.invoke();
            } finally {
            }
        } catch (Throwable th) {
            try {
                this.endStack.invoke();
                throw th;
            } finally {
            }
        }
    }

    public final Object o(InterfaceC5063a<Y8.t> action) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(action.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("MinusOneGroupExit", "group exit: " + thE.getMessage(), false, 4, null);
        }
        return objB;
    }

    public final boolean p() {
        Object objB;
        if (this.started) {
            return !this.completed;
        }
        if (this.participants.size() >= 2) {
            List<HomeSharedOffsetExitParticipant> list = this.participants;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!((HomeSharedOffsetExitParticipant) it.next()).isShowing()) {
                    }
                }
            }
            if (!this.beginStack.invoke().booleanValue()) {
                return false;
            }
            this.started = true;
            for (HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant : this.participants) {
                this.prepared.add(homeSharedOffsetExitParticipant);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(homeSharedOffsetExitParticipant.prepareSharedOffsetExit());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                Float f10 = (Float) objB;
                if (f10 == null || Math.abs(f10.floatValue()) > Float.MAX_VALUE || f10.floatValue() <= 0.0f) {
                    for (final HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant2 : Z8.B.V(this.prepared)) {
                        o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.K
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return MinusOneGroupExitTransaction.q(homeSharedOffsetExitParticipant2);
                            }
                        });
                    }
                    this.completed = true;
                    this.endStack.invoke();
                    return false;
                }
                this.distancePx = Math.max(this.distancePx, f10.floatValue());
            }
            if (Result.e(o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.L
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return MinusOneGroupExitTransaction.r(this.f27432a);
                }
            })) != null) {
                k();
            }
            return true;
        }
        return false;
    }

    public final void s() {
        if (this.completed || this.animationStarted) {
            return;
        }
        this.animationStarted = true;
        if (Result.e(o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.M
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MinusOneGroupExitTransaction.t(this.f27433a);
            }
        })) != null) {
            k();
        }
    }
}
