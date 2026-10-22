package com.smt.obric.appstore.domain.sysapp;

import com.bytedanceos.common.model.AppInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadObricPreloadSysAppUseCase$invoke$2$1$1", f = "LoadObricPreloadSysAppUseCase.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLoadObricPreloadSysAppUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadObricPreloadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadObricPreloadSysAppUseCase$invoke$2$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n1549#2:134\n1620#2,3:135\n1549#2:138\n1620#2,3:139\n*S KotlinDebug\n*F\n+ 1 LoadObricPreloadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadObricPreloadSysAppUseCase$invoke$2$1$1\n*L\n47#1:134\n47#1:135,3\n53#1:138\n53#1:139,3\n*E\n"})
public final class LoadObricPreloadSysAppUseCase$invoke$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppInfo>>, Object> {
    final /* synthetic */ List<File> $files;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LoadObricPreloadSysAppUseCase this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public LoadObricPreloadSysAppUseCase$invoke$2$1$1(List<? extends File> r10, LoadObricPreloadSysAppUseCase r11, Continuation<? super LoadObricPreloadSysAppUseCase$invoke$2$1$1> r12) {
        this.$files = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        LoadObricPreloadSysAppUseCase$invoke$2$1$1 r12 = new LoadObricPreloadSysAppUseCase$invoke$2$1$1(this.$files, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super List<? extends AppInfo>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r13) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        kotlin.c.b(r13);
    L15:
        List r14 = b0.V((Iterable) r13);
        LoadObricPreloadSysAppUseCase r12 = this.this$0;
        ArrayList r15 = new ArrayList(u.r(r14, 10));
        Iterator r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        r15.add(LoadObricPreloadSysAppUseCase.b(r12, (LoadObricPreloadSysAppUseCase.a) r16.next()));
        goto L17
    L19:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r13);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        List<File> r18 = this.$files;
        LoadObricPreloadSysAppUseCase r19 = this.this$0;
        ArrayList r110 = new ArrayList(u.r(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L10:
        if (r20.hasNext() == false) goto L12;
        r110.add(h.b(r17, null, null, new LoadObricPreloadSysAppUseCase$invoke$2$1$1$1$1(r19, (File) r20.next(), null), 3, null));
        goto L10
    L12:
        this.label = 1;
        r13 = AwaitKt.a(r110, this);
        if (r13 != r10) goto L15;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<? extends AppInfo>> r11) {
        return ((LoadObricPreloadSysAppUseCase$invoke$2$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
