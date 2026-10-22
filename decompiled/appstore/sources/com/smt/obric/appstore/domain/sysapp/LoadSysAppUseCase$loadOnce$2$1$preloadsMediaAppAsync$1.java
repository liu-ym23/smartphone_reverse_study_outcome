package com.smt.obric.appstore.domain.sysapp;

import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase$loadOnce$2$1$preloadsMediaAppAsync$1", f = "LoadSysAppUseCase.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class LoadSysAppUseCase$loadOnce$2$1$preloadsMediaAppAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppInfo>>, Object> {
    final /* synthetic */ LoadSysAppUseCase $this_runCatching;
    int label;

    public LoadSysAppUseCase$loadOnce$2$1$preloadsMediaAppAsync$1(LoadSysAppUseCase r10, Continuation<? super LoadSysAppUseCase$loadOnce$2$1$preloadsMediaAppAsync$1> r11) {
        this.$this_runCatching = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new LoadSysAppUseCase$loadOnce$2$1$preloadsMediaAppAsync$1(this.$this_runCatching, r11);
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
        Object r13 = ((Result) r10).m44unboximpl();
    L11:
        kotlin.c.b(r13);
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        LoadObricPreloadSysAppUseCase r14 = LoadSysAppUseCase.e(this.$this_runCatching);
        this.label = 1;
        r13 = r14.c("/system/media/app", this);
        if (r13 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<? extends AppInfo>> r11) {
        return ((LoadSysAppUseCase$loadOnce$2$1$preloadsMediaAppAsync$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
