package androidx.window.embedding;

import android.util.Pair;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2010a;
    public final /* synthetic */ EmbeddingAdapter b;
    public final /* synthetic */ Set c;

    public /* synthetic */ c(EmbeddingAdapter embeddingAdapter, Set set, int i) {
        this.f2010a = i;
        this.b = embeddingAdapter;
        this.c = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f2010a) {
            case 0:
                return EmbeddingAdapter.m7306translateActivityPairPredicates$lambda1(this.b, this.c, (Pair) obj);
            default:
                return EmbeddingAdapter.m7305translateActivityIntentPredicates$lambda3(this.b, this.c, (Pair) obj);
        }
    }
}
