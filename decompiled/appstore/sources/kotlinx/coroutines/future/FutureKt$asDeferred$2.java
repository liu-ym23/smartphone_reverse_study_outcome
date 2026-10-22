package kotlinx.coroutines.future;

import com.bytedance.apm.constant.CommonKey;
import java.util.concurrent.CompletionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.a0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00032\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u00032\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "T", CommonKey.KEY_VALUE, "exception", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FutureKt$asDeferred$2 extends Lambda implements Function2<Object, Throwable, Object> {
    final /* synthetic */ CompletableDeferred<Object> $result;

    public FutureKt$asDeferred$2(CompletableDeferred<Object> r10) {
        this.$result = r10;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Throwable r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r10, Throwable r11) {
        if (r11 != null) goto L6;
        boolean r12 = this.$result.complete(r10);     // Catch: Throwable -> L4
    L16:
        return Boolean.valueOf(r12);
    L6:
        CompletableDeferred<Object> r13 = this.$result;     // Catch: Throwable -> L4
        if ((r11 instanceof CompletionException) == false) goto L9;
        CompletionException r14 = (CompletionException) r11;     // Catch: Throwable -> L4
    L10:
        if (r14 == null) goto L15;
        Throwable r15 = r14.getCause();     // Catch: Throwable -> L4
        if (r15 == null) goto L15;
        r11 = r15;
    L15:
        r12 = r13.completeExceptionally(r11);     // Catch: Throwable -> L4
        goto L16
    L9:
        r14 = null;
    L4:
        th = move-exception;
        a0.a(EmptyCoroutineContext.INSTANCE, th);
        return Unit.f21064a;
    }
}
