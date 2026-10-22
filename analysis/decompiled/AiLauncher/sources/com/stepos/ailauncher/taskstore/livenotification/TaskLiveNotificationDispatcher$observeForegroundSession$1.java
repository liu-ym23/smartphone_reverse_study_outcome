package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeForegroundSession$1", f = "TaskLiveNotificationDispatcher.kt", l = {470}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$observeForegroundSession$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    int label;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "<unused var>", "", "LY8/t;", "<anonymous>", "(Ljava/util/Set;ZZLjava/util/Set;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeForegroundSession$1$1", f = "TaskLiveNotificationDispatcher.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeForegroundSession$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.s<Set<? extends String>, Boolean, Boolean, Set<? extends String>, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(5, interfaceC4014c);
        }

        public final Object f(Set<String> set, boolean z10, boolean z11, Set<String> set2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // p9.s
        public /* bridge */ /* synthetic */ Object invoke(Set<? extends String> set, Boolean bool, Boolean bool2, Set<? extends String> set2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return f(set, bool.booleanValue(), bool2.booleanValue(), set2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ Context $appContext;

        public a(Context context) {
            this.$appContext = context;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            TaskLiveNotificationDispatcher.INSTANCE.W0(this.$appContext);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$observeForegroundSession$1(Context context, InterfaceC4014c<? super TaskLiveNotificationDispatcher$observeForegroundSession$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$observeForegroundSession$1(this.$appContext, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$observeForegroundSession$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
            Xa.b bVarL = Xa.d.l(vVar.g(), vVar.d(), vVar.e(), vVar.h(), new AnonymousClass1(null));
            a aVar = new a(this.$appContext);
            this.label = 1;
            if (bVarL.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
