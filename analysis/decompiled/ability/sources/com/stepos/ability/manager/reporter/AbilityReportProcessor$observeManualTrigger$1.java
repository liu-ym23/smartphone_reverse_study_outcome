package com.stepos.ability.manager.reporter;

import C7.r;
import J7.c;
import S7.n;
import android.util.Log;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.h;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.reporter.AbilityReportProcessor$observeManualTrigger$1", f = "AbilityReportProcessor.kt", l = {136}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilityReportProcessor$observeManualTrigger$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3145a;
    public final /* synthetic */ a b;

    @c(c = "com.stepos.ability.manager.reporter.AbilityReportProcessor$observeManualTrigger$1$1", f = "AbilityReportProcessor.kt", l = {139}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LC7/r;", "it", "<anonymous>", "(V)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.manager.reporter.AbilityReportProcessor$observeManualTrigger$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3146a;
        public final /* synthetic */ a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a aVar, H7.c cVar) {
            super(2, cVar);
            this.b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((r) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3146a;
            try {
                if (i == 0) {
                    b.b(obj);
                    Log.i("AbilityReportProcessor", "Collect manual trigger.");
                    a aVar = this.b;
                    this.f3146a = 1;
                    if (a.a(aVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
            } catch (Exception e) {
                Log.e("AbilityReportProcessor", "Upload failed.", e);
            }
            return r.f317a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityReportProcessor$observeManualTrigger$1(a aVar, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilityReportProcessor$observeManualTrigger$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilityReportProcessor$observeManualTrigger$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3145a;
        if (i == 0) {
            b.b(obj);
            a aVar = this.b;
            h hVar = aVar.f;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(aVar, null);
            this.f3145a = 1;
            if (d.d(hVar, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return r.f317a;
    }
}
