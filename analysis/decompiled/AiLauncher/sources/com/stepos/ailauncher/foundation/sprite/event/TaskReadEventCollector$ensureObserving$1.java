package com.stepos.ailauncher.foundation.sprite.event;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.common.utils.v;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.r;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.sprite.event.TaskReadEventCollector$ensureObserving$1", f = "TaskReadEventCollector.kt", l = {95}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskReadEventCollector$ensureObserving$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    int label;

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0003\u0010\u0000\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "", "", "pageFg", Parameters.SESSION_ID, "keys"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "com.stepos.ailauncher.foundation.sprite.event.TaskReadEventCollector$ensureObserving$1$1", f = "TaskReadEventCollector.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.foundation.sprite.event.TaskReadEventCollector$ensureObserving$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements r<Boolean, String, Set<? extends String>, InterfaceC4014c<? super Triple<? extends Boolean, ? extends String, ? extends Set<? extends String>>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(4, interfaceC4014c);
        }

        public final Object f(boolean z10, String str, Set<String> set, InterfaceC4014c<? super Triple<Boolean, String, ? extends Set<String>>> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.Z$0 = z10;
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = set;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        @Override // p9.r
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, String str, Set<? extends String> set, InterfaceC4014c<? super Triple<? extends Boolean, ? extends String, ? extends Set<? extends String>>> interfaceC4014c) {
            return f(bool.booleanValue(), str, set, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z10 = this.Z$0;
            String str = (String) this.L$0;
            Set set = (Set) this.L$1;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return new Triple(C4109a.a(z10), str, set);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        public static final a<T> INSTANCE = new a<>();

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Triple<Boolean, String, ? extends Set<String>> triple, InterfaceC4014c<? super t> interfaceC4014c) {
            boolean zBooleanValue = triple.a().booleanValue();
            String strB = triple.b();
            Set<String> setC = triple.c();
            if (!zBooleanValue) {
                return t.f7040a;
            }
            TaskReadEventCollector.INSTANCE.e(strB, setC);
            return t.f7040a;
        }
    }

    public TaskReadEventCollector$ensureObserving$1(InterfaceC4014c<? super TaskReadEventCollector$ensureObserving$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskReadEventCollector$ensureObserving$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TaskReadEventCollector$ensureObserving$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            v vVar = v.INSTANCE;
            Xa.b bVarQ = Xa.d.q(Xa.d.m(vVar.d(), vVar.i(), vVar.g(), new AnonymousClass1(null)));
            Xa.c cVar = a.INSTANCE;
            this.label = 1;
            if (bVarQ.collect(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
