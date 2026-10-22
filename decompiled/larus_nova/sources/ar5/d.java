package ar5;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f16022a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f16022a, ((d) r100).f16022a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f16022a.hashCode();
    }

    public final String toString() {
        return "WikiResolvedVisiblePath(orderedWikiTokens=" + this.f16022a + ')';
    }

    public d(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "orderedWikiTokens");
        this.f16022a = r100;
    }
}
