package com.stepos.ailauncher.foundation.appstore;

import Ua.M;
import Y8.t;
import Z8.F;
import Z8.Y;
import android.os.SystemClock;
import android.util.Pair;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Set;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$queryAllTasks$2", f = "DownloadTaskRepository.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class DownloadTaskRepository$queryAllTasks$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Set<? extends String>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DownloadTaskRepository$queryAllTasks$2(InterfaceC4014c<? super DownloadTaskRepository$queryAllTasks$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        DownloadTaskRepository$queryAllTasks$2 downloadTaskRepository$queryAllTasks$2 = new DownloadTaskRepository$queryAllTasks$2(interfaceC4014c);
        downloadTaskRepository$queryAllTasks$2.L$0 = obj;
        return downloadTaskRepository$queryAllTasks$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        return ((DownloadTaskRepository$queryAllTasks$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Set setR1;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Result.Companion companion = Result.INSTANCE;
            List<Pair<String, Integer>> allDownloadTasks = AppCenterSdk.getInstance().getAllDownloadTasks();
            if (allDownloadTasks != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = allDownloadTasks.iterator();
                while (it.hasNext()) {
                    String str = (String) ((Pair) it.next()).first;
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
                setR1 = F.r1(arrayList);
            } else {
                setR1 = null;
            }
            objB = Result.b(setR1);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("appstore.download.tasks.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Set setE = (Set) (Result.g(objB) ? null : objB);
        if (setE == null) {
            setE = Y.e();
        }
        DownloadTaskRepository.cached = setE;
        DownloadTaskRepository.cachedAt = SystemClock.elapsedRealtime();
        R5.b.INSTANCE.c("appstore.download.tasks.query", Y8.j.a("pkgs", C4109a.f(setE.size())), Y8.j.a("elapsedMs", C4109a.g(DownloadTaskRepository.cachedAt - jElapsedRealtime)));
        return setE;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Set<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Set<String>>) interfaceC4014c);
    }
}
