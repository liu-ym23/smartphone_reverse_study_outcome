package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "e", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ExceptionsConstructorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Function1<Throwable, Throwable> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionsConstructorKt$safeCtor$1(Function1<? super Throwable, ? extends Throwable> r10) {
        this.$block = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Throwable invoke(Throwable r10) {
        return invoke2(r10);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Throwable invoke2(@NotNull Throwable r10) {
        Function1<Throwable, Throwable> r11 = this.$block;
        Object r12 = null;
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L8
        Throwable r14 = r11.invoke(r10);     // Catch: Throwable -> L8
        if (kotlin.jvm.internal.q.b(r10.getMessage(), r14.getMessage()) == false) goto L6;
    L10:
        Object r15 = Result.m35constructorimpl(r14);     // Catch: Throwable -> L8
    L14:
        if (Result.m41isFailureimpl(r15) == true) goto L18;
        r12 = r15;
    L18:
        return (Throwable) r12;
    L6:
        if (kotlin.jvm.internal.q.b(r14.getMessage(), r10.toString()) == true) goto L10;
        r14 = null;
    L8:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r15 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L14
    }
}
