package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2008a;
    public final /* synthetic */ Set b;

    public /* synthetic */ a(Set set, int i) {
        this.f2008a = i;
        this.b = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f2008a;
        Set set = this.b;
        switch (i) {
            case 0:
                return EmbeddingAdapter.m7308translateIntentPredicates$lambda8(set, (Intent) obj);
            default:
                return EmbeddingAdapter.m7307translateActivityPredicates$lambda6(set, (Activity) obj);
        }
    }
}
