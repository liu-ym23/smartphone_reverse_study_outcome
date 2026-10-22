package ad2;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f2961a;

    public g(h r100) {
        this.f2961a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.f2961a.f2962a.indexOf(((Pair) r100).getFirst())), Integer.valueOf(this.f2961a.f2962a.indexOf(((Pair) r101).getFirst())));
    }
}
