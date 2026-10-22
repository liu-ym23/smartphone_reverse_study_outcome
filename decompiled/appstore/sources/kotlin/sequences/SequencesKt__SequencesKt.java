package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SequencesKt__SequencesKt extends i {

    public static final class a implements Sequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f21205a;

        public a(Iterator r10) {
            this.f21205a = r10;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator iterator() {
            return this.f21205a;
        }
    }

    public static Sequence c(Iterator r10) {
        q.g(r10, "<this>");
        return d(new a(r10));
    }

    public static final Sequence d(Sequence r10) {
        q.g(r10, "<this>");
        if ((r10 instanceof kotlin.sequences.a) == false) goto L6;
        return r10;
    L6:
        return new kotlin.sequences.a(r10);
    }

    public static Sequence e() {
        return b.f21208a;
    }

    public static Sequence f(final Object r10, Function1 r11) {
        q.g(r11, "nextFunction");
        if (r10 != null) goto L6;
        return b.f21208a;
    L6:
        return new e(new SequencesKt__SequencesKt$generateSequence$2(r10), r11);
    }

    public static Sequence g(Function0 r10, Function1 r11) {
        q.g(r10, "seedFunction");
        q.g(r11, "nextFunction");
        return new e(r10, r11);
    }
}
