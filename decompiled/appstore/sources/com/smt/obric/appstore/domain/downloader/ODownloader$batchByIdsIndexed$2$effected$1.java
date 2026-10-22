package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.TaskOperateResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$batchByIdsIndexed$2$effected$1", f = "ODownloader.kt", i = {}, l = {512}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nODownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$batchByIdsIndexed$2$effected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,528:1\n1559#2:529\n1590#2,4:530\n1789#2,3:534\n*S KotlinDebug\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$batchByIdsIndexed$2$effected$1\n*L\n511#1:529\n511#1:530,4\n513#1:534,3\n*E\n"})
public final class ODownloader$batchByIdsIndexed$2$effected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Function3<Integer, Long, Continuation<? super TaskOperateResult>, Object> $action;
    final /* synthetic */ List<Long> $ids;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ODownloader$batchByIdsIndexed$2$effected$1(List<Long> r10, Function3<? super Integer, ? super Long, ? super Continuation<? super TaskOperateResult>, ? extends Object> r11, Continuation<? super ODownloader$batchByIdsIndexed$2$effected$1> r12) {
        this.$ids = r10;
        this.$action = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ODownloader$batchByIdsIndexed$2$effected$1 r12 = new ODownloader$batchByIdsIndexed$2$effected$1(this.$ids, this.$action, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Integer> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r15) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        kotlin.c.b(r15);
    L18:
        Integer r14 = tf.a.c(0);
        Iterator r16 = ((Iterable) r15).iterator();
    L20:
        if (r16.hasNext() == false) goto L25;
        TaskOperateResult r12 = (TaskOperateResult) r16.next();
        int r17 = r14.intValue();
        if (d.a(r12) == false) goto L24;
        r17 = r17 + 1;
    L24:
        r14 = tf.a.c(r17);
        goto L20
    L25:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r15);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        List<Long> r13 = this.$ids;
        Function3<Integer, Long, Continuation<? super TaskOperateResult>, Object> r19 = this.$action;
        ArrayList r110 = new ArrayList(u.r(r13, 10));
        Iterator<T> r20 = r13.iterator();
        int r21 = 0;
    L10:
        if (r20.hasNext() == false) goto L15;
        Object r22 = r20.next();
        int r111 = r21 + 1;
        if (r21 >= 0) goto L14;
        t.q();
    L14:
        r110.add(h.b(r18, null, null, new ODownloader$batchByIdsIndexed$2$effected$1$1$1(r19, r21, ((Number) r22).longValue(), null), 3, null));
        r21 = r111;
        goto L10
    L15:
        this.label = 1;
        r15 = AwaitKt.a(r110, this);
        if (r15 != r10) goto L18;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Integer> r11) {
        return ((ODownloader$batchByIdsIndexed$2$effected$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
