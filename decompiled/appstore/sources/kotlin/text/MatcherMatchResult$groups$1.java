package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection implements MatchNamedGroupCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f21248a;

    public MatcherMatchResult$groups$1(MatcherMatchResult r10) {
        this.f21248a = r10;
    }

    public /* bridge */ boolean a(e r10) {
        return super.contains(r10);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if (r10 != null) goto L4;
        boolean r11 = true;
    L5:
        if (r11 == true) goto L9;
        return false;
    L9:
        return a((e) r10);
    L4:
        r11 = r10 instanceof e;
        goto L5
    }

    @Override // kotlin.text.MatchGroupCollection
    public e get(int r10) {
        bg.c r11 = f.d(MatcherMatchResult.a(this.f21248a), r10);
        if (r11.i().intValue() < 0) goto L5;
        String r12 = MatcherMatchResult.a(this.f21248a).group(r10);
        kotlin.jvm.internal.q.f(r12, "group(...)");
        return new e(r12, r11);
    L5:
        return null;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return MatcherMatchResult.a(this.f21248a).groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return SequencesKt___SequencesKt.s(b0.Q(t.j(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    public e get(String r10) {
        kotlin.jvm.internal.q.g(r10, "name");
        return uf.b.f24937a.c(MatcherMatchResult.a(this.f21248a), r10);
    }
}
