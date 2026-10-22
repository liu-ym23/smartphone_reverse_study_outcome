package com.smt.obric.appstore.domain.downloader;

import com.bytedanceos.common.toolbox.j;
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
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$pauseTask$2", f = "ODownloader.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
public final class ODownloader$pauseTask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TaskOperateResult>, Object> {
    final /* synthetic */ long $id;
    int label;

    public ODownloader$pauseTask$2(long r10, Continuation<? super ODownloader$pauseTask$2> r11) {
        this.$id = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$pauseTask$2(this.$id, r11);
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
        j.n("[AppStatus][ODownloader][Action] E: pauseTask id=" + this.$id);
        TaskOperateResult r13 = yb.c.f26207r.a().C((int) this.$id);
        StringBuilder r14 = new StringBuilder();
        r14.append("[AppStatus][ODownloader][Action] X: pauseTask id=");
        r14.append(this.$id);
        r14.append(". result=");
        if (r13 == null) goto L14;
        String r15 = c.b(r13);
    L15:
        r14.append(r15);
        String r16 = r14.toString();
        if (d.a(r13) == false) goto L18;
        j.n(r16);
    L19:
        return r13;
    L18:
        j.s(r16);
        goto L19
    L14:
        r15 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ODownloader r17 = ODownloader.f18038a;
        this.label = 1;
        if (ODownloader.a(r17, this) != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super TaskOperateResult> r11) {
        return ((ODownloader$pauseTask$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
