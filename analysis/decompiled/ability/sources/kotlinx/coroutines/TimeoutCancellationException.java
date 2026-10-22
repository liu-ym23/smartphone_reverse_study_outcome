package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import m9.c0;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TimeoutCancellationException extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient c0 f5181a;

    public TimeoutCancellationException(String str, c0 c0Var) {
        super(str);
        this.f5181a = c0Var;
    }
}
