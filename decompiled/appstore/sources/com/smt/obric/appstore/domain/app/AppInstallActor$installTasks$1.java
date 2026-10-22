package com.smt.obric.appstore.domain.app;

import com.bytedanceos.common.toolbox.ServerElements;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/smt/obric/appstore/domain/app/entity/a;", ServerElements.LIST, "", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$installTasks$1", f = "AppInstallActor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAppInstallActor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$installTasks$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1261:1\n1864#2,3:1262\n*S KotlinDebug\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$installTasks$1\n*L\n206#1:1262,3\n*E\n"})
public final class AppInstallActor$installTasks$1 extends SuspendLambda implements Function2<List<? extends com.smt.obric.appstore.domain.app.entity.a>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public AppInstallActor$installTasks$1(Continuation<? super AppInstallActor$installTasks$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$installTasks$1 r12 = new AppInstallActor$installTasks$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(List<? extends com.smt.obric.appstore.domain.app.entity.a> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L16;
        kotlin.c.b(r10);
        List r11 = (List) this.L$0;
        if (j.a() == false) goto L14;
        long r12 = System.nanoTime();
        int r13 = r11.size();
        Iterator r14 = r11.iterator();
        int r15 = 0;
    L8:
        if (r14.hasNext() == false) goto L14;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L12;
        t.q();
    L12:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] installTasks SSOT(" + r12 + ")@" + r15 + '/' + r13 + ": " + ((com.smt.obric.appstore.domain.app.entity.a) r16).P());
        r15 = r17;
    L14:
        return Unit.f21064a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull List<com.smt.obric.appstore.domain.app.entity.a> r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$installTasks$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
