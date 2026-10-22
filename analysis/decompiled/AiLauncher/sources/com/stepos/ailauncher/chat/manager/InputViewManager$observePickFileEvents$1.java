package com.stepos.ailauncher.chat.manager;

import Z8.C1165m;
import android.os.Bundle;
import android.util.Log;
import com.stepos.ailauncher.chat.view.BaseInputView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.InputViewManager$observePickFileEvents$1", f = "InputViewManager.kt", l = {291}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InputViewManager$observePickFileEvents$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        public static final a<T> INSTANCE = new a<>();

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Pair<String, Bundle> pair, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            BaseInputView baseInputView = null;
            if (InputViewManager.pickResultDispatchSuspended && InputViewManager.INSTANCE.M0(pair.e())) {
                C1165m c1165m = InputViewManager.pendingPickEvents;
                String strE = pair.e();
                Bundle bundleF = pair.f();
                c1165m.addLast(Y8.j.a(strE, bundleF != null ? new Bundle(bundleF) : null));
                String strE2 = pair.e();
                Log.i("InputViewManager", "observePickFileEvents: defer " + ((Object) strE2) + ", pending=" + InputViewManager.pendingPickEvents.size());
                return Y8.t.f7040a;
            }
            WeakReference weakReference = InputViewManager.pickInitiator;
            BaseInputView baseInputView2 = weakReference != null ? (BaseInputView) weakReference.get() : null;
            if (baseInputView2 == null) {
                Iterator<T> it = Z8.B.V(InputViewManager.inputViewList).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BaseInputView baseInputView3 = (BaseInputView) ((WeakReference) it.next()).get();
                    if (baseInputView3 != null) {
                        baseInputView = baseInputView3;
                        break;
                    }
                }
            } else {
                baseInputView = baseInputView2;
            }
            if (baseInputView == null) {
                Log.w("InputViewManager", "observePickFileEvents: no target InputView, drop " + ((Object) pair.e()));
                return Y8.t.f7040a;
            }
            if (baseInputView2 == null) {
                Log.w("InputViewManager", "observePickFileEvents: initiator lost, fallback to latest for " + ((Object) pair.e()));
            }
            InputViewManager.INSTANCE.j0(baseInputView, pair);
            return Y8.t.f7040a;
        }
    }

    public InputViewManager$observePickFileEvents$1(InterfaceC4014c<? super InputViewManager$observePickFileEvents$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new InputViewManager$observePickFileEvents$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((InputViewManager$observePickFileEvents$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<Pair<String, Bundle>> oVarB = com.stepos.ailauncher.chat.e.INSTANCE.b();
            Xa.c<? super Pair<String, Bundle>> cVar = a.INSTANCE;
            this.label = 1;
            if (oVarB.collect(cVar, this) == objG) {
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
