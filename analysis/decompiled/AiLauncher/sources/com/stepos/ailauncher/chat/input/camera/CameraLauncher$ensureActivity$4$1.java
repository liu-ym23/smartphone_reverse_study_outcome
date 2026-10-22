package com.stepos.ailauncher.chat.input.camera;

import Ua.M;
import Wa.g;
import Y8.t;
import android.app.Activity;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$4$1", f = "CameraLauncher.kt", l = {316}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CameraLauncher$ensureActivity$4$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ g<Activity> $channel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraLauncher$ensureActivity$4$1(g<Activity> gVar, Activity activity, InterfaceC4014c<? super CameraLauncher$ensureActivity$4$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$channel = gVar;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        CameraLauncher$ensureActivity$4$1 cameraLauncher$ensureActivity$4$1 = new CameraLauncher$ensureActivity$4$1(this.$channel, this.$activity, interfaceC4014c);
        cameraLauncher$ensureActivity$4$1.L$0 = obj;
        return cameraLauncher$ensureActivity$4$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CameraLauncher$ensureActivity$4$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (i10 == 0) {
            C4849c.b(obj);
            if (this.$channel.isClosedForSend()) {
                C4109a.f(Log.w("CameraLauncher", "openCamera: send to closed channel"));
                return t.f7040a;
            }
            g<Activity> gVar = this.$channel;
            Activity activity = this.$activity;
            Result.Companion companion2 = Result.INSTANCE;
            this.L$0 = h.a(m10);
            this.L$1 = h.a(m10);
            this.I$0 = 0;
            this.label = 1;
            if (gVar.send(activity, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        objB = Result.b(t.f7040a);
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e("CameraLauncher", "openCamera: send 失败", thE);
        }
        Result.a(objB);
        return t.f7040a;
    }
}
