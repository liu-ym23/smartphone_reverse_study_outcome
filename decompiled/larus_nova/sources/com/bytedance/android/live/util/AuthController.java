package com.bytedance.android.live.util;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.platform.IHostAuthFunction;
import com.bytedance.android.livehostapi.platform.LiveOneKeyAuthRoutineImpl;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes7.dex */
public final class AuthController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IHostAuthFunction f102524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthController f102525b = null;

    public AuthController() {
    }

    static {
        f102525b = new AuthController();
    }

    public final Object e(Continuation<? super Boolean> r100) {
        if ((r100 instanceof AuthController$checkHasAuthConfirmDialog$1) == false) goto L7;
        AuthController$checkHasAuthConfirmDialog$1 r101 = (AuthController$checkHasAuthConfirmDialog$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L30:
        if (((Boolean) r103).booleanValue() == false) goto L34;
    L32:
        r106 = false;
    L34:
        return Boxing.boxBoolean(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        c r107 = (c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L25:
        if (((Boolean) r103).booleanValue() == false) goto L32;
        r101.L$0 = null;
        r101.label = 2;
        r103 = r107.e(r101);
        if (r103 != r104) goto L30;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        IHostAuthFunction r108 = f102524a;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("authFunction");
    L19:
        r107 = new c(r108);
        if (r107.f102531a.isHostLogin() == false) goto L32;
        r101.L$0 = r107;
        r101.label = 1;
        r103 = r107.c(r101);
        if (r103 != r104) goto L25;
        return r104;
    L7:
        r101 = new AuthController$checkHasAuthConfirmDialog$1(this, r100);
        goto L8
    }

    public final Object h(Continuation<? super String> r100) {
        if ((r100 instanceof AuthController$getCurrentAccountPhoneNumber$1) == false) goto L7;
        AuthController$getCurrentAccountPhoneNumber$1 r101 = (AuthController$getCurrentAccountPhoneNumber$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L26
    L24:
        return (String) r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        IHostAuthFunction r106 = f102524a;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("authFunction");
    L18:
        Intrinsics.checkNotNullParameter(r106, "authFunction");
        r101.label = 1;     // Catch: Throwable -> L26
        SafeContinuation r107 = new SafeContinuation(IntrinsicsKt.intercepted(r101));     // Catch: Throwable -> L26
        r106.getCurrentAccountPhoneNumber(new b(r107));     // Catch: Throwable -> L26
        r103 = r107.getOrThrow();     // Catch: Throwable -> L26
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r101);     // Catch: Throwable -> L26
    L22:
        if (r103 != r104) goto L24;
        return r104;
    L26:
        return "";
    L7:
        r101 = new AuthController$getCurrentAccountPhoneNumber$1(this, r100);
        goto L8
    }

    public final Object i(Continuation<? super Boolean> r100) {
        if ((r100 instanceof AuthController$isPhoneNumberUsedInDouyin$1) == false) goto L7;
        AuthController$isPhoneNumberUsedInDouyin$1 r101 = (AuthController$isPhoneNumberUsedInDouyin$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L26
    L24:
        boolean r106 = ((Boolean) r103).booleanValue();     // Catch: Throwable -> L26
    L28:
        return Boxing.boxBoolean(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        IHostAuthFunction r107 = f102524a;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("authFunction");
    L18:
        Intrinsics.checkNotNullParameter(r107, "authFunction");
        r101.label = 1;     // Catch: Throwable -> L26
        SafeContinuation r108 = new SafeContinuation(IntrinsicsKt.intercepted(r101));     // Catch: Throwable -> L26
        r107.isPhoneNumberUsedInDouyin(new b(r108));     // Catch: Throwable -> L26
        r103 = r108.getOrThrow();     // Catch: Throwable -> L26
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r101);     // Catch: Throwable -> L26
    L22:
        if (r103 != r104) goto L24;
        return r104;
    L26:
        r106 = false;
    L7:
        r101 = new AuthController$isPhoneNumberUsedInDouyin$1(this, r100);
        goto L8
    }

    public static void j(LiveOneKeyAuthRoutineImpl.C99951 r110, Activity r111, Map r112) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        IHostAuthFunction r100 = f102524a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("authFunction");
    L5:
        c r101 = new c(r100);
        StringBuilder r102 = new StringBuilder("routine, activity is null: ");
        if (r111 != null) goto L8;
        boolean r103 = true;
    L9:
        r102.append(r103);
        ALogger.i("AuthController", r102.toString());
        String r104 = null;
        if (r111 != null) goto L12;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AuthController$routine$1(r110, r101, r111, null), 3, null);
        return;
    L12:
        if (r112 == null) goto L14;
        r104 = (String) r112.get("userAgreeAuth");
    L14:
        boolean r105 = Intrinsics.areEqual(r104, "1");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AuthController$routine$2(r101, r105, r111, r110, null), 3, null);
        return;
    L8:
        r103 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.android.livehostapi.platform.LiveOneKeyAuthRoutineImpl$doDouyinAuth$1$1, com.bytedance.android.livehostapi.platform.TokenRefreshCallback, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.bytedance.android.livehostapi.platform.TokenRefreshCallback] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public final Object f(Context r100, LiveOneKeyAuthRoutineImpl.C99921.C15621 r101, Continuation r102) {
        if ((r102 instanceof AuthController$doDouyinAuth$1) == false) goto L7;
        AuthController$doDouyinAuth$1 r103 = (AuthController$doDouyinAuth$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        TokenRefreshCallback r108 = (TokenRefreshCallback) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L23
        r101 = r108;
    L27:
    L26:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        IHostAuthFunction r109 = f102524a;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("authFunction");
    L19:
        c r110 = new c(r109);
        r103.L$0 = r101;     // Catch: Throwable -> L23
        r103.label = 1;     // Catch: Throwable -> L23
        Object r111 = g(r100, r110, r101, r103);     // Catch: Throwable -> L23
        r101 = r101;
        if (r111 != r106) goto L27;
        return r106;
    L23:
        th = move-exception;
        r101.onFailed(th);
    L7:
        r103 = new AuthController$doDouyinAuth$1(this, r102);
        goto L8
    }

    public static final Object b(Context r100, c r101, TokenRefreshCallback r102, Continuation r103) {
        Object r104 = BuildersKt.withContext(Dispatchers.getIO(), new AuthController$bindDouyinAccountByPhoneNumberFinal$2(r101, r102, r100, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object c(Context r100, c r101, TokenRefreshCallback r102, Continuation r103) {
        Object r104 = BuildersKt.withContext(Dispatchers.getIO(), new AuthController$createDouyinAccountFinal$2(r101, r102, r100, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    public static Object g(Context r100, c r101, TokenRefreshCallback r102, Continuation r103) {
        Object r104 = BuildersKt.withContext(Dispatchers.getMain(), new AuthController$doDouyinAuthFinal$2(r101, r100, r102, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object a(Context r100, c r101, TokenRefreshCallback r110, boolean r111, Continuation r112) {
        Object r102 = BuildersKt.withContext(Dispatchers.getMain(), new AuthController$alreadyHostLoginRoutine$2(r101, r110, r111, r100, null), r112);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object d(Throwable r100, Activity r101, c r110, TokenRefreshCallback r111, Continuation r112) {
        Object r102 = BuildersKt.withContext(Dispatchers.getMain(), new AuthController$handleException$2(r100, r110, r101, r111, null), r112);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
