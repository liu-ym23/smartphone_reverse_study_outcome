package com.stepos.ailauncher.chat.lowpower;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.container.m0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.lowpower.TempPowerLowMonitor$start$3", f = "TempPowerLowMonitor.kt", l = {98}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TempPowerLowMonitor$start$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        public static final a<T> INSTANCE = new a<>();

        public final Object b(boolean z10, InterfaceC4014c<? super t> interfaceC4014c) {
            if (z10) {
                TempPowerLowChecker tempPowerLowChecker = TempPowerLowChecker.INSTANCE;
                if (tempPowerLowChecker.f()) {
                    C4148a.k("TempPowerLowMonitor", "overlay opened while restricted -> show dialog", false, 4, null);
                    d.INSTANCE.f(tempPowerLowChecker.c());
                }
            }
            return t.f7040a;
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return b(((Boolean) obj).booleanValue(), interfaceC4014c);
        }
    }

    public TempPowerLowMonitor$start$3(InterfaceC4014c<? super TempPowerLowMonitor$start$3> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TempPowerLowMonitor$start$3(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TempPowerLowMonitor$start$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Boolean> tVarI = m0.INSTANCE.i();
            Xa.c<? super Boolean> cVar = a.INSTANCE;
            this.label = 1;
            if (tVarI.collect(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
