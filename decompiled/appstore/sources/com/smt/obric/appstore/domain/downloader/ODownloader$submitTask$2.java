package com.smt.obric.appstore.domain.downloader;

import com.bytedanceos.common.toolbox.j;
import com.obric.download.base.DownloadTask;
import com.obric.download.base.TaskOperateResult;
import java.util.List;
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
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$submitTask$2", f = "ODownloader.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
public final class ODownloader$submitTask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TaskOperateResult>, Object> {
    final /* synthetic */ DownloadTask $task;
    int label;

    public ODownloader$submitTask$2(DownloadTask r10, Continuation<? super ODownloader$submitTask$2> r11) {
        this.$task = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$submitTask$2(this.$task, r11);
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
        StringBuilder r13 = new StringBuilder();
        r13.append("[AppStatus][ODownloader][Action] E: enqueueDownload pkg=");
        r13.append(this.$task.getApkPackageName());
        r13.append(", name=");
        r13.append(this.$task.getName());
        r13.append(", useMobile=");
        r13.append(!this.$task.getOnlyWifi());
        r13.append(", url=");
        r13.append(this.$task.getUrl());
        r13.append(", backupurl_size=");
        List<String> r14 = this.$task.getBackupUrls();
        if (r14 == null) goto L14;
        Integer r15 = tf.a.c(r14.size());
    L15:
        r13.append(r15);
        j.n(r13.toString());
        TaskOperateResult r16 = yb.c.f26207r.a().K(this.$task);
        StringBuilder r17 = new StringBuilder();
        r17.append("[AppStatus][ODownloader][Action] X: enqueueDownload pkg=");
        r17.append(this.$task.getApkPackageName());
        r17.append(", name=");
        r17.append(this.$task.getName());
        r17.append(", useMobile=");
        r17.append(!this.$task.getOnlyWifi());
        r17.append(", url=");
        r17.append(this.$task.getUrl());
        r17.append(". result=");
        r17.append(c.b(r16));
        String r18 = r17.toString();
        if (d.a(r16) == false) goto L18;
        j.n(r18);
    L19:
        return r16;
    L18:
        j.s(r18);
        goto L19
    L14:
        r15 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ODownloader r19 = ODownloader.f18038a;
        this.label = 1;
        if (ODownloader.a(r19, this) != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super TaskOperateResult> r11) {
        return ((ODownloader$submitTask$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
