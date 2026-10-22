package com.bytedance.applet.debugger;

import com.larus.im.FlowRuntime;
import com.larus.platform.api.AppletDebuggerEntryState;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.x1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes14.dex */
public final class AppletDebuggerEntryStateController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletDebuggerRegistrationRepository f191694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f191695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f191696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f191697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f191698e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Deferred<Unit> f191700b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f191699a, r101.f191699a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f191700b, r101.f191700b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f191699a.hashCode() * 31) + this.f191700b.hashCode();
        }

        public final String toString() {
            return "InFlightRefresh(userId=" + this.f191699a + ", deferred=" + this.f191700b + ')';
        }

        public a(String r100, Deferred<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "deferred");
            this.f191699a = r100;
            this.f191700b = r101;
        }
    }

    public AppletDebuggerEntryStateController() {
        this(0);
    }

    public AppletDebuggerEntryStateController(int r100) {
        AppletDebuggerRegistrationRepository r101 = new AppletDebuggerRegistrationRepository();
        Intrinsics.checkNotNullParameter(r101, "registrationRepository");
        this.f191694a = r101;
        this.f191695b = kotlinx.coroutines.sync.b.a();
        this.f191696c = j1.a(AppletDebuggerEntryState.HIDDEN);
        this.f191697d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        com.larus.platform.api.b r102 = new AppletDebuggerEntryStateController$accountStatusCallback$1(this);
        AccountService.f365697a.E(r102);
    }

    public final Object b(Continuation<? super Unit> r100) {
        FlowRuntime.a().isOversea();
        this.f191696c.setValue(AppletDebuggerEntryState.HIDDEN);
        gd9.l r101 = FlowRuntime.a();
        r101.isOversea();
        r101.isPlugin();
        if (x1.f365857a.a() == true) goto L10;
        AccountService r102 = AccountService.f365697a;
        if (r102.isLogin().booleanValue() == false) goto L10;
        String r103 = r102.getUserId();
        if ((!StringsKt.isBlank(r103)) == false) goto L10;
    L11:
        if (r103 == null) goto L13;
        Object r104 = CoroutineScopeKt.coroutineScope(new AppletDebuggerEntryStateController$refreshEntryState$2(this, r103, null), r100);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r104;
    L18:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    L10:
        r103 = null;
        goto L11
    }

    public static final Object a(AppletDebuggerEntryStateController r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof AppletDebuggerEntryStateController$refreshEntryState$3) == false) goto L7;
        AppletDebuggerEntryStateController$refreshEntryState$3 r103 = (AppletDebuggerEntryStateController$refreshEntryState$3) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        boolean r108 = ((Boolean) r105).booleanValue();
        StateFlowImpl r109 = r100.f191696c;
        AccountService r110 = AccountService.f365697a;
        if (r110.isLogin().booleanValue() == true) goto L20;
    L23:
        AppletDebuggerEntryState r111 = AppletDebuggerEntryState.HIDDEN;
    L24:
        r109.setValue(r111);
        return Unit.INSTANCE;
    L20:
        if (Intrinsics.areEqual(r110.getUserId(), r101) == false) goto L23;
        if (r108 == false) goto L23;
        r111 = AppletDebuggerEntryState.VISIBLE;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r100.f191696c.setValue(AppletDebuggerEntryState.LOADING);
        AppletDebuggerRegistrationRepository r112 = r100.f191694a;
        r103.L$0 = r101;
        r103.label = 1;
        r105 = r112.a(r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new AppletDebuggerEntryStateController$refreshEntryState$3(r100, r102);
        goto L8
    }
}
