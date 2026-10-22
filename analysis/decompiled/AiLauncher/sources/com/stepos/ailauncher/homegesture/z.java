package com.stepos.ailauncher.homegesture;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.sheet.b0;
import com.stepos.ailauncher.sheet.s0;
import h8.C4148a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\b*\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/homegesture/z;", "", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "rootToken", "", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "participants", "Lkotlin/Function0;", "LY8/t;", "onFinished", "onCancelled", "<init>", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Ljava/util/List;Lp9/a;Lp9/a;)V", "", Const.INTENT_KEY_UMID, "()Z", "c", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;)V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "Lp9/a;", "Ljava/util/List;", "Lcom/stepos/ailauncher/sheet/s0;", "stack", "Lcom/stepos/ailauncher/sheet/s0;", "Lcom/stepos/ailauncher/sheet/b0;", "springAnimation", "Lcom/stepos/ailauncher/sheet/b0;", "completed", "Z", "preparedParticipants", "Companion", Const.INTENT_KEY_APIKEY, "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    private static final String TAG = "HomeGroupExit";
    private boolean completed;
    private final InterfaceC5063a<Y8.t> onCancelled;
    private final InterfaceC5063a<Y8.t> onFinished;
    private final List<HomeGroupExitParticipant> participants;
    private List<? extends HomeGroupExitParticipant> preparedParticipants;
    private final HomeRootToken rootToken;
    private b0 springAnimation;
    private final s0 stack;

    public z(HomeRootToken rootToken, List<? extends HomeGroupExitParticipant> participants, InterfaceC5063a<Y8.t> onFinished, InterfaceC5063a<Y8.t> onCancelled) {
        kotlin.jvm.internal.p.i(rootToken, "rootToken");
        kotlin.jvm.internal.p.i(participants, "participants");
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        kotlin.jvm.internal.p.i(onCancelled, "onCancelled");
        this.rootToken = rootToken;
        this.onFinished = onFinished;
        this.onCancelled = onCancelled;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : participants) {
            if (hashSet.add(((HomeGroupExitParticipant) obj).getParticipantId())) {
                arrayList.add(obj);
            }
        }
        this.participants = arrayList;
        this.stack = s0.INSTANCE.b(this.rootToken.getWire());
        this.preparedParticipants = C1173v.m();
    }

    public static final Y8.t e(z zVar, float f10) {
        Object objB;
        if (zVar.completed) {
            return Y8.t.f7040a;
        }
        float fM = C5685n.m(f10 / 871.0f, 0.0f, 1.0f);
        for (HomeGroupExitParticipant homeGroupExitParticipant : zVar.preparedParticipants) {
            try {
                Result.Companion companion = Result.INSTANCE;
                homeGroupExitParticipant.applyHomeGroupExit(f10, fM);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "apply failed id=" + homeGroupExitParticipant.getParticipantId() + ": " + thE.getMessage(), false, 4, null);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t f(z zVar, boolean z10, float f10) {
        Object objB;
        if (zVar.completed) {
            return Y8.t.f7040a;
        }
        zVar.completed = true;
        if (z10) {
            Iterator it = Z8.B.U(zVar.preparedParticipants).iterator();
            while (it.hasNext()) {
                zVar.c((HomeGroupExitParticipant) it.next());
            }
            zVar.stack.u();
            zVar.onCancelled.invoke();
            return Y8.t.f7040a;
        }
        for (HomeGroupExitParticipant homeGroupExitParticipant : zVar.preparedParticipants) {
            try {
                Result.Companion companion = Result.INSTANCE;
                homeGroupExitParticipant.applyHomeGroupExit(871.0f, 1.0f);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        for (HomeGroupExitParticipant homeGroupExitParticipant2 : zVar.preparedParticipants) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                homeGroupExitParticipant2.finishHomeGroupExit();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th2));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "finish failed id=" + homeGroupExitParticipant2.getParticipantId() + ": " + thE.getMessage(), false, 4, null);
            }
        }
        zVar.stack.u();
        zVar.onFinished.invoke();
        return Y8.t.f7040a;
    }

    public final void c(HomeGroupExitParticipant homeGroupExitParticipant) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            homeGroupExitParticipant.cancelHomeGroupExit();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "cancel failed id=" + homeGroupExitParticipant.getParticipantId() + ": " + thE.getMessage(), false, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.homegesture.z.d():boolean");
    }
}
