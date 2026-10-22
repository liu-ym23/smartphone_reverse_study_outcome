package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.UninstallAppsViewModel$deleteMyApps$1", f = "UninstallAppsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nUninstallAppsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UninstallAppsViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/UninstallAppsViewModel$deleteMyApps$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1549#2:61\n1620#2,3:62\n*S KotlinDebug\n*F\n+ 1 UninstallAppsViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/UninstallAppsViewModel$deleteMyApps$1\n*L\n49#1:61\n49#1:62,3\n*E\n"})
public final class UninstallAppsViewModel$deleteMyApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CommonAppEntity> $appList;
    int label;

    public UninstallAppsViewModel$deleteMyApps$1(List<CommonAppEntity> r10, Continuation<? super UninstallAppsViewModel$deleteMyApps$1> r11) {
        this.$appList = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UninstallAppsViewModel$deleteMyApps$1(this.$appList, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L13;
        kotlin.c.b(r10);
        CacheMyAppsRepository.f8997f.a().m(this.$appList);
        List<CommonAppEntity> r11 = this.$appList;
        if (r11 == null) goto L11;
        ArrayList r12 = new ArrayList(u.r(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        CommonAppEntity r14 = (CommonAppEntity) r13.next();
        AppInfo r15 = BaseApplication.c().b().u(r14.getPkg());
        BaseApplication.c().b().p0(r15);
        r12.add(Unit.f21064a);
    L11:
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UninstallAppsViewModel$deleteMyApps$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
