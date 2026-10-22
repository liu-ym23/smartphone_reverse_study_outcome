package A3;

import E3.j;
import java.util.function.IntPredicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements IntPredicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f94a;

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f94a) {
            case 0:
                return (i >= 97 && i <= 122) || (i >= 65 && i <= 90);
            case 1:
                return i >= 48 && i <= 57;
            case 2:
                return i >= 128 && i <= 1114111;
            case 3:
                return 95 == i;
            case 4:
                return j.f470a.get(i);
            case 5:
                return j.b.get(i);
            case 6:
                return i < 127;
            default:
                return i < 127;
        }
    }
}
