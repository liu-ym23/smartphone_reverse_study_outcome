package com.stepos.ailauncher.chat.manager;

import android.util.Log;
import com.stepos.ailauncher.chat.api.ActionViewApi;
import com.stepos.ailauncher.chat.model.ActionBarConfig;
import com.stepos.ailauncher.network.ApiResponse;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.InputViewManager$fetchActionBarConfig$1", f = "InputViewManager.kt", l = {268}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InputViewManager$fetchActionBarConfig$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public InputViewManager$fetchActionBarConfig$1(InterfaceC4014c<? super InputViewManager$fetchActionBarConfig$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        InputViewManager$fetchActionBarConfig$1 inputViewManager$fetchActionBarConfig$1 = new InputViewManager$fetchActionBarConfig$1(interfaceC4014c);
        inputViewManager$fetchActionBarConfig$1.L$0 = obj;
        return inputViewManager$fetchActionBarConfig$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((InputViewManager$fetchActionBarConfig$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Result.Companion companion = Result.INSTANCE;
                ActionViewApi actionViewApiV0 = InputViewManager.INSTANCE.v0();
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = actionViewApiV0.getActionBarConfig(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((ApiResponse) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            ApiResponse apiResponse = (ApiResponse) objB;
            if (apiResponse.isSuccess()) {
                InputViewManager inputViewManager = InputViewManager.INSTANCE;
                InputViewManager.actionBarConfig = (ActionBarConfig) apiResponse.getData();
                InputViewManager.INSTANCE.N();
            } else {
                C4109a.f(Log.w("InputViewManager", "fetchActionBarConfig: failed code=" + apiResponse.getCode() + ", msg=" + apiResponse.getMessage()));
            }
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e("InputViewManager", "fetchActionBarConfig: error", thE);
        }
        return Y8.t.f7040a;
    }
}
