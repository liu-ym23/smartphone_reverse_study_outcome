package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.TaskOperateResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/download/base/TaskOperateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$updateExtraInfoBlocking$1", f = "ODownloader.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
final class ODownloader$updateExtraInfoBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TaskOperateResult>, Object> {
    final /* synthetic */ String $extraInfo;
    final /* synthetic */ long $id;
    int label;

    public ODownloader$updateExtraInfoBlocking$1(long r10, String r11, Continuation<? super ODownloader$updateExtraInfoBlocking$1> r12) {
        this.$id = r10;
        this.$extraInfo = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$updateExtraInfoBlocking$1(this.$id, this.$extraInfo, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super TaskOperateResult> r11) {
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
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ODownloader r13 = ODownloader.f18038a;
        long r14 = this.$id;
        String r15 = this.$extraInfo;
        this.label = 1;
        r10 = r13.B(r14, r15, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super TaskOperateResult> r11) {
        return ((ODownloader$updateExtraInfoBlocking$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
