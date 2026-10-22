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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/download/base/TaskOperateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$setWiFiOnly$2", f = "ODownloader.kt", i = {}, l = {492}, m = "invokeSuspend", n = {}, s = {})
public final class ODownloader$setWiFiOnly$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TaskOperateResult>, Object> {
    final /* synthetic */ long $id;
    final /* synthetic */ boolean $wifiOnly;
    int label;

    public ODownloader$setWiFiOnly$2(long r10, boolean r11, Continuation<? super ODownloader$setWiFiOnly$2> r12) {
        this.$id = r10;
        this.$wifiOnly = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$setWiFiOnly$2(this.$id, this.$wifiOnly, r11);
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
        j.n("[AppStatus][ODownloader][Action] E: setWiFiOnly id=" + this.$id + ", wifiOnly=" + this.$wifiOnly);
        yb.c.f26207r.a().J((int) this.$id, this.$wifiOnly);
        j.n("[AppStatus][ODownloader][Action] X: setWiFiOnly id=" + this.$id + ". result=omit_by_sdk");
        return new TaskOperateResult((int) this.$id, 0, "");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ODownloader r13 = ODownloader.f18038a;
        this.label = 1;
        if (ODownloader.a(r13, this) != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super TaskOperateResult> r11) {
        return ((ODownloader$setWiFiOnly$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
