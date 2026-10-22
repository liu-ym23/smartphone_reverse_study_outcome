package androidx.work.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/work/impl/model/o;", "spec", "", "invoke", "(Landroidx/work/impl/model/o;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class WorkerUpdater$updateWorkImpl$type$1 extends Lambda implements Function1<androidx.work.impl.model.o, String> {
    public static final WorkerUpdater$updateWorkImpl$type$1 INSTANCE = null;

    static {
        INSTANCE = new WorkerUpdater$updateWorkImpl$type$1();
    }

    public WorkerUpdater$updateWorkImpl$type$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(androidx.work.impl.model.o r10) {
        return invoke2(r10);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(@NotNull androidx.work.impl.model.o r10) {
        kotlin.jvm.internal.q.g(r10, "spec");
        if (r10.h() == false) goto L5;
        return "Periodic";
    L5:
        return "OneTime";
    }
}
