package io.ktor.http.parsing;

import Y8.t;
import Z8.A;
import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.parsing.ParserDslKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a)\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000¢\u0006\u0004\b\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0080\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0080\u0004¢\u0006\u0004\b\r\u0010\u000f\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0080\u0004¢\u0006\u0004\b\r\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u000f\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u000e\u001a\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0003\u001a\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0003\u001a\u001b\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0010\u001a\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0006\u001a\u001c\u0010\u0019\u001a\u00020\u0000*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001a\u001a,\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000\u001d\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00000\u001dH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/http/parsing/Grammar;", "grammar", "maybe", "(Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Grammar;", "", UxipConstants.f30680s, "(Ljava/lang/String;)Lio/ktor/http/parsing/Grammar;", "Lkotlin/Function1;", "Lio/ktor/http/parsing/GrammarBuilder;", "LY8/t;", "block", "Lkotlin/Function0;", "(Lp9/l;)Lp9/a;", "then", "(Ljava/lang/String;Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Grammar;", "(Lio/ktor/http/parsing/Grammar;Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Grammar;", "(Lio/ktor/http/parsing/Grammar;Ljava/lang/String;)Lio/ktor/http/parsing/Grammar;", "or", "many", "atLeastOne", "name", "named", "anyOf", "", "other", "to", "(CC)Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/ComplexGrammar;", ExifInterface.GPS_DIRECTION_TRUE, "", "flatten", "(Ljava/util/List;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ParserDslKt {
    public static final Grammar anyOf(String value) {
        p.i(value, "value");
        return new AnyOfGrammar(value);
    }

    public static final Grammar atLeastOne(Grammar grammar) {
        p.i(grammar, "grammar");
        return new AtLeastOne(grammar);
    }

    public static final /* synthetic */ <T extends ComplexGrammar> List<Grammar> flatten(List<? extends Grammar> list) {
        p.i(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            p.o(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj instanceof ComplexGrammar) {
                A.E(arrayList, ((ComplexGrammar) obj).getGrammars());
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Grammar many(Grammar grammar) {
        p.i(grammar, "grammar");
        return new ManyGrammar(grammar);
    }

    public static final Grammar maybe(Grammar grammar) {
        p.i(grammar, "grammar");
        return new MaybeGrammar(grammar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Grammar maybe$lambda$0(InterfaceC5074l interfaceC5074l) {
        GrammarBuilder grammarBuilder = new GrammarBuilder();
        interfaceC5074l.invoke(grammarBuilder);
        return maybe(grammarBuilder.build());
    }

    public static final Grammar named(Grammar grammar, String name) {
        p.i(grammar, "<this>");
        p.i(name, "name");
        return new NamedGrammar(name, grammar);
    }

    public static final Grammar or(Grammar grammar, Grammar grammar2) {
        p.i(grammar, "<this>");
        p.i(grammar2, "grammar");
        return new OrGrammar(C1173v.p(grammar, grammar2));
    }

    public static final Grammar then(String str, Grammar grammar) {
        p.i(str, "<this>");
        p.i(grammar, "grammar");
        return then(new StringGrammar(str), grammar);
    }

    public static final Grammar to(char c10, char c11) {
        return new RangeGrammar(c10, c11);
    }

    public static final Grammar maybe(String value) {
        p.i(value, "value");
        return new MaybeGrammar(new StringGrammar(value));
    }

    public static final Grammar or(Grammar grammar, String value) {
        p.i(grammar, "<this>");
        p.i(value, "value");
        return or(grammar, new StringGrammar(value));
    }

    public static final Grammar then(Grammar grammar, Grammar grammar2) {
        p.i(grammar, "<this>");
        p.i(grammar2, "grammar");
        return new SequenceGrammar(C1173v.p(grammar, grammar2));
    }

    public static final InterfaceC5063a<Grammar> maybe(final InterfaceC5074l<? super GrammarBuilder, t> block) {
        p.i(block, "block");
        return new InterfaceC5063a() { // from class: o8.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ParserDslKt.maybe$lambda$0(block);
            }
        };
    }

    public static final Grammar or(String str, Grammar grammar) {
        p.i(str, "<this>");
        p.i(grammar, "grammar");
        return or(new StringGrammar(str), grammar);
    }

    public static final Grammar then(Grammar grammar, String value) {
        p.i(grammar, "<this>");
        p.i(value, "value");
        return then(grammar, new StringGrammar(value));
    }
}
