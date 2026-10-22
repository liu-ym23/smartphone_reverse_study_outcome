package com.smt.obric.appstore.domain.sysapp;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase$loadOnce$2$1$installed$1", f = "LoadSysAppUseCase.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLoadSysAppUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase$loadOnce$2$1$installed$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 LoadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase\n*L\n1#1,226:1\n766#2:227\n857#2:228\n858#2:233\n216#3,4:229\n*S KotlinDebug\n*F\n+ 1 LoadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase$loadOnce$2$1$installed$1\n*L\n121#1:227\n121#1:228\n121#1:233\n124#1:229,4\n*E\n"})
public final class LoadSysAppUseCase$loadOnce$2$1$installed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppInfo>>, Object> {
    final /* synthetic */ CoroutineScope $$this$coroutineScope;
    final /* synthetic */ Deferred<List<AppInfo>> $installedAsync;
    final /* synthetic */ Set<String> $obricPreloads;
    final /* synthetic */ LoadSysAppUseCase $this_runCatching;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public LoadSysAppUseCase$loadOnce$2$1$installed$1(Deferred<? extends List<? extends AppInfo>> r10, LoadSysAppUseCase r11, Set<String> r12, CoroutineScope r13, Continuation<? super LoadSysAppUseCase$loadOnce$2$1$installed$1> r14) {
        this.$installedAsync = r10;
        this.$this_runCatching = r11;
        this.$obricPreloads = r12;
        this.$$this$coroutineScope = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new LoadSysAppUseCase$loadOnce$2$1$installed$1(this.$installedAsync, this.$this_runCatching, this.$obricPreloads, this.$$this$coroutineScope, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super List<? extends AppInfo>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L11:
        List r13 = (List) r10;
        LoadSysAppUseCase.h(this.$this_runCatching, "installed_raw", r13);
        LoadSysAppUseCase r14 = this.$this_runCatching;
        Set<String> r15 = this.$obricPreloads;
        CoroutineScope r16 = this.$$this$coroutineScope;
        ArrayList r17 = new ArrayList();
        Iterator r18 = r13.iterator();
    L13:
        if (r18.hasNext() == false) goto L24;
        Object r19 = r18.next();
        AppInfo r20 = (AppInfo) r19;
        if (LoadSysAppUseCase.a(r14) != LoadSysAppUseCase.Filter.SysAppRecovery) goto L23;
        String r21 = r20.appPackageName;
        if (r21 != null) goto L19;
        r21 = "";
    L19:
        boolean r22 = LoadSysAppUseCase$loadOnce$2$1.access$invokeSuspend$isRemovable(r15, r16, r21);
        if (LoadSysAppUseCase.k(r14, r20) == false) goto L22;
        j.n("[SysAppNameDebug][LoadSysAppUseCase] installed filter pkg=" + r20.appPackageName + " name=" + r20.appName + " version=" + r20.appVersionCode + '/' + r20.appVersionName + " removable=" + r22);
    L22:
        if (r22 == false) goto L13;
    L23:
        r17.add(r19);
        goto L13
    L24:
        return r17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        Deferred<List<AppInfo>> r23 = this.$installedAsync;
        this.label = 1;
        r10 = r23.await(this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<? extends AppInfo>> r11) {
        return ((LoadSysAppUseCase$loadOnce$2$1$installed$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
