package com.smt.obric.appstore.domain.downloader;

import com.bytedanceos.common.toolbox.j;
import com.obric.download.base.TaskOperateResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$batchByIdsIndexed$2", f = "ODownloader.kt", i = {}, l = {510}, m = "invokeSuspend", n = {}, s = {})
public final class ODownloader$batchByIdsIndexed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Function3<Integer, Long, Continuation<? super TaskOperateResult>, Object> $action;
    final /* synthetic */ List<Long> $ids;
    final /* synthetic */ String $name;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ODownloader$batchByIdsIndexed$2(String r10, List<Long> r11, Function3<? super Integer, ? super Long, ? super Continuation<? super TaskOperateResult>, ? extends Object> r12, Continuation<? super ODownloader$batchByIdsIndexed$2> r13) {
        this.$name = r10;
        this.$ids = r11;
        this.$action = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$batchByIdsIndexed$2(this.$name, this.$ids, this.$action, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Integer> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r14) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        boolean r12 = true;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        kotlin.c.b(r14);
    L11:
        int r15 = ((Number) r14).intValue();
        if (r15 == this.$ids.size()) goto L15;
        r12 = false;
    L15:
        String r13 = "[AppStatus][ODownloader][Action] batchByIdsIndexed invoke opName=" + this.$name + " result=" + r15 + '/' + this.$ids.size() + ", allSucc=" + r12;
        if (r12 == false) goto L18;
        j.n(r13);
    L20:
        return tf.a.c(r15);
    L18:
        j.s(r13);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r14);
        j.n("[AppStatus][ODownloader][Action] batchByIdsIndexed invoke opName=" + this.$name + " ids=" + b0.h0(this.$ids, ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null));
        ODownloader$batchByIdsIndexed$2$effected$1 r16 = new ODownloader$batchByIdsIndexed$2$effected$1(this.$ids, this.$action, null);
        this.label = 1;
        r14 = d0.e(r16, this);
        if (r14 != r10) goto L11;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Integer> r11) {
        return ((ODownloader$batchByIdsIndexed$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
