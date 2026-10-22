package com.stepos.ailauncher.chat.wake;

import Ua.C1056g;
import android.content.Context;
import android.content.Intent;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.WakeService$Companion$wakeWithCardText$1", f = "WakeService.kt", l = {1707}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class WakeService$Companion$wakeWithCardText$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appCtx;
    final /* synthetic */ String $source;
    final /* synthetic */ String $text;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WakeService$Companion$wakeWithCardText$1(String str, String str2, Context context, InterfaceC4014c<? super WakeService$Companion$wakeWithCardText$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$source = str;
        this.$text = str2;
        this.$appCtx = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new WakeService$Companion$wakeWithCardText$1(this.$source, this.$text, this.$appCtx, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((WakeService$Companion$wakeWithCardText$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.A0 immediate = Ua.Y.c().getImmediate();
            WakeService$Companion$wakeWithCardText$1$allowed$1 wakeService$Companion$wakeWithCardText$1$allowed$1 = new WakeService$Companion$wakeWithCardText$1$allowed$1(this.$appCtx, this.$source, null);
            this.label = 1;
            obj = C1056g.j(immediate, wakeService$Companion$wakeWithCardText$1$allowed$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (!((Boolean) obj).booleanValue()) {
            R5.b.INSTANCE.h("wake.cardText.denied", Y8.j.a("source", this.$source));
            return Y8.t.f7040a;
        }
        WakeService.INSTANCE.n1(this.$text);
        R5.b.INSTANCE.c("wake.cardText.pending", Y8.j.a("len", C4109a.f(this.$text.length())), Y8.j.a("source", this.$source));
        Intent intent = new Intent(this.$appCtx, (Class<?>) WakeService.class);
        intent.setAction("com.stepos.ailauncher.action.WAKE");
        this.$appCtx.startService(intent);
        return Y8.t.f7040a;
    }
}
