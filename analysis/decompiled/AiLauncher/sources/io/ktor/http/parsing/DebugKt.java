package io.ktor.http.parsing;

import La.D;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/parsing/Grammar;", "", "offset", "LY8/t;", "printDebug", "(Lio/ktor/http/parsing/Grammar;I)V", "", "node", "printlnWithOffset", "(ILjava/lang/Object;)V", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DebugKt {
    public static final void printDebug(Grammar grammar, int i10) {
        p.i(grammar, "<this>");
        if (grammar instanceof StringGrammar) {
            printlnWithOffset(i10, "STRING[" + Regex.INSTANCE.c(((StringGrammar) grammar).getValue()) + ']');
            return;
        }
        if (grammar instanceof RawGrammar) {
            printlnWithOffset(i10, "STRING[" + ((RawGrammar) grammar).getValue() + ']');
            return;
        }
        if (grammar instanceof NamedGrammar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NAMED[");
            NamedGrammar namedGrammar = (NamedGrammar) grammar;
            sb2.append(namedGrammar.getName());
            sb2.append(']');
            printlnWithOffset(i10, sb2.toString());
            printDebug(namedGrammar.getGrammar(), i10 + 2);
            return;
        }
        if (grammar instanceof SequenceGrammar) {
            printlnWithOffset(i10, "SEQUENCE");
            Iterator<T> it = ((SequenceGrammar) grammar).getGrammars().iterator();
            while (it.hasNext()) {
                printDebug((Grammar) it.next(), i10 + 2);
            }
            return;
        }
        if (grammar instanceof OrGrammar) {
            printlnWithOffset(i10, "OR");
            Iterator<T> it2 = ((OrGrammar) grammar).getGrammars().iterator();
            while (it2.hasNext()) {
                printDebug((Grammar) it2.next(), i10 + 2);
            }
            return;
        }
        if (grammar instanceof MaybeGrammar) {
            printlnWithOffset(i10, "MAYBE");
            printDebug(((MaybeGrammar) grammar).getGrammar(), i10 + 2);
            return;
        }
        if (grammar instanceof ManyGrammar) {
            printlnWithOffset(i10, "MANY");
            printDebug(((ManyGrammar) grammar).getGrammar(), i10 + 2);
            return;
        }
        if (grammar instanceof AtLeastOne) {
            printlnWithOffset(i10, "MANY_NOT_EMPTY");
            printDebug(((AtLeastOne) grammar).getGrammar(), i10 + 2);
            return;
        }
        if (grammar instanceof AnyOfGrammar) {
            printlnWithOffset(i10, "ANY_OF[" + Regex.INSTANCE.c(((AnyOfGrammar) grammar).getValue()) + ']');
            return;
        }
        if (!(grammar instanceof RangeGrammar)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("RANGE[");
        RangeGrammar rangeGrammar = (RangeGrammar) grammar;
        sb3.append(rangeGrammar.getFrom());
        sb3.append('-');
        sb3.append(rangeGrammar.getTo());
        sb3.append(']');
        printlnWithOffset(i10, sb3.toString());
    }

    public static /* synthetic */ void printDebug$default(Grammar grammar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        printDebug(grammar, i10);
    }

    private static final void printlnWithOffset(int i10, Object obj) {
        System.out.println((Object) (D.P(" ", i10) + (i10 / 2) + ": " + obj));
    }
}
