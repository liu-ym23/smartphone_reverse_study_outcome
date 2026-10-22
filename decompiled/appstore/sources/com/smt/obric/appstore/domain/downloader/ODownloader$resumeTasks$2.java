package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.TaskOperateResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class ODownloader$resumeTasks$2 extends FunctionReferenceImpl implements Function2<Long, Continuation<? super TaskOperateResult>, Object>, SuspendFunction {
    public ODownloader$resumeTasks$2(Object r10) {
        super(2, r10, ODownloader.class, "resumeTask", "resumeTask(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(long r10, @NotNull Continuation<? super TaskOperateResult> r11) {
        return ((ODownloader) this.receiver).x(r10, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Long r10, Continuation<? super TaskOperateResult> r11) {
        return invoke(r10.longValue(), r11);
    }
}
