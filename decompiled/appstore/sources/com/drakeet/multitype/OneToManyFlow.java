package com.drakeet.multitype;

import androidx.annotation.CheckResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J=\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062&\u0010\u0005\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00040\u0003\"\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0004H'¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062&\u0010\u0005\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\t0\u0003\"\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\tH'¢\u0006\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/drakeet/multitype/OneToManyFlow;", "T", "", "", "Lcom/drakeet/multitype/c;", "delegates", "Lcom/drakeet/multitype/OneToManyEndpoint;", "to", "([Lcom/drakeet/multitype/c;)Lcom/drakeet/multitype/OneToManyEndpoint;", "Lcom/drakeet/multitype/b;", "([Lcom/drakeet/multitype/b;)Lcom/drakeet/multitype/OneToManyEndpoint;", "multitype"}, k = 1, mv = {1, 4, 0})
public interface OneToManyFlow<T> {
    @CheckResult
    @NotNull
    OneToManyEndpoint<T> to(@NotNull b... r10);

    @CheckResult
    @NotNull
    OneToManyEndpoint<T> to(@NotNull c... r10);
}
