package com.stepos.ailauncher.chat.fragment;

import android.view.View;
import com.stepos.ailauncher.chat.manager.AmooStoreBadgeState;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooStoreFragment$bindUnreadDots$1", f = "AmooStoreFragment.kt", l = {423}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooStoreFragment$bindUnreadDots$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ View $dotInstalled;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ View $dotInstalled;

        public a(View view) {
            this.$dotInstalled = view;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(AmooStoreBadgeState.State state, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            this.$dotInstalled.setVisibility(state.getUnreadInstalledEntry() ? 0 : 8);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmooStoreFragment$bindUnreadDots$1(View view, InterfaceC4014c<? super AmooStoreFragment$bindUnreadDots$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$dotInstalled = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AmooStoreFragment$bindUnreadDots$1(this.$dotInstalled, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AmooStoreFragment$bindUnreadDots$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<AmooStoreBadgeState.State> tVarE = AmooStoreBadgeState.INSTANCE.e();
            a aVar = new a(this.$dotInstalled);
            this.label = 1;
            if (tVarE.collect(aVar, this) == objG) {
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
