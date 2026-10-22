package androidx.core.content;

import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1916a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f1916a = i;
        this.b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        int i = this.f1916a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return ((ComponentName) obj2).equals((ComponentName) obj);
            case 1:
                return UriMatcherCompat.lambda$asPredicate$0((UriMatcher) obj2, (Uri) obj);
            case 2:
                return obj2.equals(obj);
            default:
                return ((Predicate) obj2).lambda$negate$1(obj);
        }
    }
}
