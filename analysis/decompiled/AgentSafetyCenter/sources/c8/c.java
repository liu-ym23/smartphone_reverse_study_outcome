package c8;

import g8.i;
import java.util.function.IntPredicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements IntPredicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2229a;

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f2229a) {
            case 0:
                return (i >= 97 && i <= 122) || (i >= 65 && i <= 90);
            case 1:
                return i >= 48 && i <= 57;
            case 2:
                return i >= 128 && i <= 1114111;
            case 3:
                return 95 == i;
            case 4:
                return i.f4386a.get(i);
            case 5:
                return i.f4387b.get(i);
            case 6:
                return i < 127;
            default:
                return i < 127;
        }
    }
}
