package androidx.core.util;

import androidx.core.content.IntentSanitizer;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1931a;
    public final /* synthetic */ Predicate b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Predicate predicate, Predicate predicate2, int i) {
        this.f1931a = i;
        this.b = predicate;
        this.c = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1931a) {
            case 0:
                return this.b.lambda$or$2((Predicate) this.c, obj);
            case 1:
                return this.b.lambda$and$0((Predicate) this.c, obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.c, this.b, obj);
        }
    }

    public /* synthetic */ a(Class cls, Predicate predicate) {
        this.f1931a = 2;
        this.c = cls;
        this.b = predicate;
    }
}
