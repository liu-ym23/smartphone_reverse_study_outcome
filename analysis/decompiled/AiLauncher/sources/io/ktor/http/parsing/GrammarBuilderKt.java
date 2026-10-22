package io.ktor.http.parsing;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/http/parsing/GrammarBuilder;", "LY8/t;", "block", "Lio/ktor/http/parsing/Grammar;", "grammar", "(Lp9/l;)Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GrammarBuilderKt {
    public static final Grammar grammar(InterfaceC5074l<? super GrammarBuilder, t> block) {
        p.i(block, "block");
        GrammarBuilder grammarBuilder = new GrammarBuilder();
        block.invoke(grammarBuilder);
        return grammarBuilder.build();
    }
}
