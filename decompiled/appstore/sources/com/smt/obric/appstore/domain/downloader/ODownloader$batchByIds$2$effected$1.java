package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.TaskOperateResult;
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
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$batchByIds$2$effected$1", f = "ODownloader.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nODownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$batchByIds$2$effected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,528:1\n1549#2:529\n1620#2,3:530\n1789#2,3:533\n*S KotlinDebug\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$batchByIds$2$effected$1\n*L\n474#1:529\n474#1:530,3\n476#1:533,3\n*E\n"})
public final class ODownloader$batchByIds$2$effected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Function2<Long, Continuation<? super TaskOperateResult>, Object> $action;
    final /* synthetic */ List<Long> $ids;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ODownloader$batchByIds$2$effected$1(List<Long> r10, Function2<? super Long, ? super Continuation<? super TaskOperateResult>, ? extends Object> r11, Continuation<? super ODownloader$batchByIds$2$effected$1> r12) {
        this.$ids = r10;
        this.$action = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ODownloader$batchByIds$2$effected$1 r12 = new ODownloader$batchByIds$2$effected$1(this.$ids, this.$action, r11);
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
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        kotlin.c.b(r12);
    L15:
        Integer r13 = tf.a.c(0);
        Iterator r14 = ((Iterable) r12).iterator();
    L17:
        if (r14.hasNext() == false) goto L22;
        TaskOperateResult r15 = (TaskOperateResult) r14.next();
        int r16 = r13.intValue();
        if (d.a(r15) == false) goto L21;
        r16 = r16 + 1;
    L21:
        r13 = tf.a.c(r16);
        goto L17
    L22:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r12);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        List<Long> r18 = this.$ids;
        Function2<Long, Continuation<? super TaskOperateResult>, Object> r19 = this.$action;
        ArrayList r110 = new ArrayList(u.r(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L10:
        if (r20.hasNext() == false) goto L12;
        r110.add(h.b(r17, null, null, new ODownloader$batchByIds$2$effected$1$1$1(r19, ((Number) r20.next()).longValue(), null), 3, null));
        goto L10
    L12:
        this.label = 1;
        r12 = AwaitKt.a(r110, this);
        if (r12 != r10) goto L15;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Integer> r11) {
        return ((ODownloader$batchByIds$2$effected$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
