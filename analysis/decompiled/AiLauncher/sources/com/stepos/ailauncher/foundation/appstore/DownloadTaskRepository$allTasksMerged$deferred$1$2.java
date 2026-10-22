package com.stepos.ailauncher.foundation.appstore;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Set;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$allTasksMerged$deferred$1$2", f = "DownloadTaskRepository.kt", l = {99}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class DownloadTaskRepository$allTasksMerged$deferred$1$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Set<? extends String>>, Object> {
    int label;

    public DownloadTaskRepository$allTasksMerged$deferred$1$2(InterfaceC4014c<? super DownloadTaskRepository$allTasksMerged$deferred$1$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DownloadTaskRepository$allTasksMerged$deferred$1$2(interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        return ((DownloadTaskRepository$allTasksMerged$deferred$1$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        DownloadTaskRepository downloadTaskRepository = DownloadTaskRepository.INSTANCE;
        this.label = 1;
        Object objH = downloadTaskRepository.h(this);
        return objH == objG ? objG : objH;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Set<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Set<String>>) interfaceC4014c);
    }
}
